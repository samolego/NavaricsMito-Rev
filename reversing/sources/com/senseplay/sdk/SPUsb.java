package com.senseplay.sdk;

import android.content.Context;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Handler;
import android.util.Log;
import com.hwfit.abs.HwAbs;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.log.SPToast;
import com.senseplay.sdk.model.usb.UsbData;
import com.senseplay.sdk.tool.HandleOpe;

/* loaded from: classes2.dex */
public class SPUsb {
    public static final int TYPE_AOA = 1;
    public static final int TYPE_USB = 0;
    private static Context context = null;
    private static SPUsb spUsb = null;
    private static boolean usbIsReady = false;
    private static int usbType;
    private HwAbs mHwAbs;
    private UsbData usbData;

    /* JADX INFO: Access modifiers changed from: private */
    public void startCmdHandler(boolean z) {
    }

    public static SPUsb getInstance() {
        if (spUsb == null) {
            synchronized (SPUsb.class) {
                if (spUsb == null) {
                    spUsb = new SPUsb();
                }
            }
        }
        return spUsb;
    }

    private SPUsb() {
        context = SPManager.getContent();
        this.usbData = new UsbData();
    }

    public void setUsbType(int i) {
        usbType = i;
    }

    public static boolean isHost() {
        return usbType == 1;
    }

    public void registerUsbReceiver(Context context2, MCallBack<Boolean> mCallBack) {
        this.usbData.registerReceiver(context2, usbType, mCallBack);
    }

    public void unregisterUsbReceiver(Context context2) {
        this.usbData.unregisterReceiver(context2);
    }

    public void openUsb(final MCallBack<Boolean> mCallBack) {
        UsbManager usbManager = (UsbManager) context.getSystemService("usb");
        int i = usbType;
        if (i == 0) {
            UsbDevice initUsbDevice = this.usbData.initUsbDevice(usbManager);
            if (usbManager == null || initUsbDevice == null) {
                mCallBack.onResult(false);
            } else if (this.usbData.hasPermission(usbManager, initUsbDevice)) {
                openUsbDevice(usbType, mCallBack);
            } else {
                this.usbData.requestPermission(usbManager, initUsbDevice, new MCallBack<Boolean>() { // from class: com.senseplay.sdk.SPUsb.1
                    @Override // com.senseplay.mframe.client.MCallBack
                    public void onResult(Boolean bool) {
                        if (bool.booleanValue()) {
                            SPUsb.this.openUsbDevice(SPUsb.usbType, mCallBack);
                        } else {
                            mCallBack.onResult(false);
                        }
                    }
                }, context);
            }
        } else if (1 == i) {
            UsbAccessory initUsbHost = this.usbData.initUsbHost(usbManager);
            if (usbManager == null || initUsbHost == null) {
                Log.w("ffffff", "ffffffff");
                mCallBack.onResult(false);
            } else if (this.usbData.hasPermission(usbManager, initUsbHost)) {
                openUsbDevice(usbType, mCallBack);
            } else {
                this.usbData.requestPermission(usbManager, initUsbHost, new MCallBack<Boolean>() { // from class: com.senseplay.sdk.SPUsb.2
                    @Override // com.senseplay.mframe.client.MCallBack
                    public void onResult(Boolean bool) {
                        if (bool.booleanValue()) {
                            SPUsb.this.openUsbDevice(SPUsb.usbType, mCallBack);
                        } else {
                            mCallBack.onResult(false);
                        }
                    }
                }, context);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUsbDevice(final int i, final MCallBack<Boolean> mCallBack) {
        Log.w("openUsbDevice", "openUsbDevice");
        HandleOpe.postDelayed(new HandleOpe.OpeListener() { // from class: com.senseplay.sdk.SPUsb.3
            @Override // com.senseplay.sdk.tool.HandleOpe.OpeListener
            public void run() {
                try {
                    if (i == 0) {
                        if (SPUsb.this.mHwAbs != null) {
                            SPUsb.this.mHwAbs.Connect();
                        } else {
                            SPUsb.this.mHwAbs = new HwAbs(SPUsb.context, 10);
                            SPUsb.this.mHwAbs.Connect();
                        }
                    } else if (1 == i) {
                        if (SPUsb.this.mHwAbs != null) {
                            SPUsb.this.mHwAbs.Connect();
                        } else {
                            SPUsb.this.mHwAbs = new HwAbs(SPUsb.context, 13);
                            SPUsb.this.mHwAbs.Connect();
                        }
                    }
                    if (SPUsb.this.mHwAbs.HwConnectReady()) {
                        SPUsb.this.startCmdHandler(true);
                        Context context2 = SPUsb.context;
                        SPToast.shortShowDebug(context2, "open usb succ " + SPUsb.this.mHwAbs.SdkVersion());
                        SPUsb.this.useOpenSucc(mCallBack);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    mCallBack.onResult(false);
                }
            }
        }, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void useOpenSucc(final MCallBack<Boolean> mCallBack) {
        new Handler().postDelayed(new Runnable() { // from class: com.senseplay.sdk.SPUsb.4
            @Override // java.lang.Runnable
            public void run() {
                boolean unused = SPUsb.usbIsReady = true;
                mCallBack.onResult(true);
            }
        }, 600L);
    }

    public boolean checkUsb() {
        HwAbs hwAbs = this.mHwAbs;
        if (hwAbs == null) {
            return false;
        }
        return hwAbs.HwConnectReady();
    }

    public HwAbs getUsb() {
        return this.mHwAbs;
    }

    public static boolean isUsbIsReady() {
        return usbIsReady;
    }

    public void release() {
        usbIsReady = false;
        try {
            if (this.mHwAbs != null) {
                this.mHwAbs.Disconnect();
                this.mHwAbs = null;
            }
            if (this.usbData != null) {
                this.usbData.closeTimer();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
