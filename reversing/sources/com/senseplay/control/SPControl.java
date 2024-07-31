package com.senseplay.control;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.senseplay.control.IControlAidl;
import com.senseplay.control.ISendAidl;
import com.senseplay.control.model.LinKInfo;
import com.senseplay.control.model.VechileInfo;

/* loaded from: classes2.dex */
public class SPControl {
    private static Context mContext;
    private static SPControl spControl;
    private MCallBack<Boolean> conCallBack;
    private IControlAidl mService;
    private RVechileListener rVechileListener;
    private final String tag = "SPControl";
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.senseplay.control.SPControl.1
        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            SPControl.this.mService = null;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.w("SPControl", "onServiceConnected");
            SPControl.this.mService = IControlAidl.Stub.asInterface(iBinder);
            if (SPControl.this.mService != null) {
                SPControl.this.conCallBack.callBack(true);
            } else {
                SPControl.this.conCallBack.callBack(false);
            }
        }
    };
    private ISendAidl iSendAidl = new ISendAidl.Stub() { // from class: com.senseplay.control.SPControl.2
        @Override // com.senseplay.control.ISendAidl
        public void setLinKInfo(boolean z, int i, int i2) throws RemoteException {
            if (SPControl.this.rVechileListener == null) {
                Log.w("rVechileListener", "rVechileListener is null");
                return;
            }
            LinKInfo linKInfo = new LinKInfo();
            linKInfo.setLink(z);
            linKInfo.setSnr(i);
            linKInfo.setRssi(i2);
            SPControl.this.rVechileListener.setLinKInfo(linKInfo);
        }

        @Override // com.senseplay.control.ISendAidl
        public void setVechileInfo(String str, int i, int i2, float f, int i3, int i4, int i5) throws RemoteException {
            if (SPControl.this.rVechileListener == null) {
                Log.w("rVechileListener", "rVechileListener is null");
                return;
            }
            VechileInfo vechileInfo = new VechileInfo();
            vechileInfo.setMajorGear(str);
            vechileInfo.setMinorGear(i);
            vechileInfo.setCurSpeed(i2);
            vechileInfo.setSteerAngle(f);
            vechileInfo.setThrottle(i3);
            vechileInfo.setBrake(i4);
            vechileInfo.setMotorRotateSpeed(i5);
            SPControl.this.rVechileListener.setVechileInfo(vechileInfo);
        }
    };

    public static SPControl getInstance(Context context) {
        mContext = context;
        if (spControl == null) {
            synchronized (SPControl.class) {
                if (spControl == null) {
                    spControl = new SPControl(context);
                }
            }
        }
        return spControl;
    }

    private SPControl(Context context) {
    }

    public void connect(String str, MCallBack<Boolean> mCallBack) {
        this.conCallBack = mCallBack;
        if (mContext == null) {
            Log.w("connect", "mContext is null");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.senseplay.control.ControlService");
        intent.setPackage(str);
        mContext.bindService(intent, this.mServiceConnection, 1);
    }

    public void disconnect() {
        Context context = mContext;
        if (context != null) {
            context.unbindService(this.mServiceConnection);
        }
    }

    private IReceiverAidl getReceiver() {
        try {
            if (this.mService == null) {
                Log.w("SPControl", "mService is null");
                return null;
            } else if (this.mService.getReceiverAidl() == null) {
                Log.w("SPControl", "getReceiverAidl is null");
                return null;
            } else {
                return this.mService.getReceiverAidl();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void joyStick1(int i) {
        try {
            IReceiverAidl receiver = getReceiver();
            if (receiver == null) {
                return;
            }
            if (receiver.getJoyStockAidl() == null) {
                Log.w("SPControl", "getJoyStockAidl is null");
            } else {
                receiver.getJoyStockAidl().joyStick1(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void joyStick2(int i) {
        try {
            IReceiverAidl receiver = getReceiver();
            if (receiver == null) {
                return;
            }
            if (receiver.getJoyStockAidl() == null) {
                Log.w("SPControl", "getJoyStockAidl is null");
            } else {
                receiver.getJoyStockAidl().joyStick2(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void setKey(String str, String str2) {
        try {
            IReceiverAidl receiver = getReceiver();
            if (receiver == null) {
                return;
            }
            if (receiver.getKeyAidl() == null) {
                Log.w("SPControl", "getKeyAidl is null");
            } else {
                receiver.getKeyAidl().onKey(str, str2);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void setRVechileListener(RVechileListener rVechileListener) {
        try {
            this.rVechileListener = rVechileListener;
            if (this.mService != null) {
                this.mService.setSendAidl(this.iSendAidl);
            } else {
                Log.w("SPControl", "mService is null");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
