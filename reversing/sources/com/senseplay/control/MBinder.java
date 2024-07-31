package com.senseplay.control;

import android.os.RemoteException;
import com.senseplay.control.IControlAidl;
import com.senseplay.control.IKeyAid;
import com.senseplay.control.IRJoyStickAidl;
import com.senseplay.control.IRVechileAidl;
import com.senseplay.control.IReceiverAidl;

/* loaded from: classes2.dex */
public class MBinder extends IControlAidl.Stub {
    public static ISendAidl iSendAidl;
    private IReceiverAidl iReceiverAidl = new IReceiverAidl.Stub() { // from class: com.senseplay.control.MBinder.1
        @Override // com.senseplay.control.IReceiverAidl
        public IRJoyStickAidl getJoyStockAidl() throws RemoteException {
            return MBinder.this.joyStickAidl;
        }

        @Override // com.senseplay.control.IReceiverAidl
        public IRVechileAidl getVechileAidl() throws RemoteException {
            return MBinder.this.vechileAidl;
        }

        @Override // com.senseplay.control.IReceiverAidl
        public IKeyAid getKeyAidl() throws RemoteException {
            return MBinder.this.keyAid;
        }
    };
    private IRJoyStickAidl joyStickAidl = new IRJoyStickAidl.Stub() { // from class: com.senseplay.control.MBinder.2
        @Override // com.senseplay.control.IRJoyStickAidl
        public void joyStick1(int i) throws RemoteException {
            if (MBinder.this.joystickListener != null) {
                MBinder.this.joystickListener.joyStock1(i);
            }
        }

        @Override // com.senseplay.control.IRJoyStickAidl
        public void joyStick2(int i) throws RemoteException {
            if (MBinder.this.joystickListener != null) {
                MBinder.this.joystickListener.joyStock2(i);
            }
        }
    };
    private IRVechileAidl vechileAidl = new IRVechileAidl.Stub() { // from class: com.senseplay.control.MBinder.3
        @Override // com.senseplay.control.IRVechileAidl
        public void setGear(String str) throws RemoteException {
        }
    };
    private IKeyAid keyAid = new IKeyAid.Stub() { // from class: com.senseplay.control.MBinder.4
        @Override // com.senseplay.control.IKeyAid
        public void onKey(String str, String str2) throws RemoteException {
            if (MBinder.this.keyListener != null) {
                MBinder.this.keyListener.onKye(str, str2);
            }
        }
    };
    private JoystickListener joystickListener = SPControlServer.getInstance().getJoystickListener();
    private KeyListener keyListener = SPControlServer.getInstance().getKeyListener();

    @Override // com.senseplay.control.IControlAidl
    public IReceiverAidl getReceiverAidl() throws RemoteException {
        return this.iReceiverAidl;
    }

    @Override // com.senseplay.control.IControlAidl
    public void setSendAidl(ISendAidl iSendAidl2) throws RemoteException {
        iSendAidl = iSendAidl2;
    }
}
