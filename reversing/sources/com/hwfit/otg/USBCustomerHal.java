package com.hwfit.otg;

import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbInterface;
import android.util.Log;
import com.MThread.C0591MThread;
import com.MThread.MThreadI;
import com.jnilib.CppSDKConnectors;
import com.p035dg.ConfigManager;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* loaded from: classes.dex */
public class USBCustomerHal extends UsbAbs {
    private static USBCustomerHal mInstance;
    private C0591MThread mMsgProcThread;
    private C0591MThread mSendDataThread;
    private byte[] mSendDataBuff = new byte[20480];
    final BlockingQueue<byte[]> blockingQueue = new ArrayBlockingQueue(200);
    int procCnt = 0;
    private MThreadI mIMsgProc = new MThreadI() { // from class: com.hwfit.otg.USBCustomerHal.1
        @Override // com.MThread.MThreadI
        public void Exec() {
            try {
                byte[] take = USBCustomerHal.this.blockingQueue.take();
                while (take != null) {
                    CppSDKConnectors.RcWrite(take, take.length);
                    take = USBCustomerHal.this.blockingQueue.take();
                }
                Thread.sleep(25L);
            } catch (InterruptedException unused) {
            }
        }
    };
    private MThreadI mISendData = new MThreadI() { // from class: com.hwfit.otg.USBCustomerHal.2
        @Override // com.MThread.MThreadI
        public void Exec() {
            try {
                if (USBHal.GetInstance().USB_Ready()) {
                    int RcRead = CppSDKConnectors.RcRead(USBCustomerHal.this.mSendDataBuff);
                    while (RcRead > 0) {
                        int write = USBCustomerHal.this.write(USBCustomerHal.this.mSendDataBuff, RcRead);
                        if (write < 0) {
                            Log.e("USB_WR", "USB Write failed! Value: " + write);
                        }
                        OTGManager.mSendCnt++;
                        RcRead = CppSDKConnectors.RcRead(USBCustomerHal.this.mSendDataBuff);
                    }
                    Thread.sleep(3L);
                    return;
                }
                Thread.sleep(100L);
            } catch (Exception e) {
                Log.e("OTG_WRITE", e.toString());
            }
        }
    };

    private USBCustomerHal() {
    }

    public static USBCustomerHal getInstance() {
        synchronized (USBCustomerHal.class) {
            if (mInstance == null) {
                mInstance = new USBCustomerHal();
            }
        }
        return mInstance;
    }

    public void init(UsbDeviceConnection usbDeviceConnection, UsbInterface usbInterface) {
        if (!OTGManager.EN_USB_REQUEST_M) {
            this.mOtgBulkReadThreadEn = true;
            this.mOtgBulkReadBuffSize = 256;
            this.getmOtgBulkReadTimerout = IjkMediaCodecInfo.RANK_SECURE;
            this.mEnmOtgBulkReadPeriodWait = true;
            this.mOtgBulkReadPeriod = 2;
            this.mOtgBulkReadThreadName = "USB_CmdRead";
        }
        this.TAG = "Usb_Customer";
        this.mUsbInterface = usbInterface;
        this.mDeviceConnection = usbDeviceConnection;
        this.blockingQueue.clear();
        getUsbInfo();
    }

    @Override // com.hwfit.otg.UsbAbs
    public void sendMsg(byte[] bArr, int i) {
        try {
            OTGManager.mReadCnt++;
            if (OTGManager.CmdGetCnt < ConfigManager.GetInstance().getConfig().getCmdProcDelayCnt()) {
                OTGManager.CmdGetCnt++;
            }
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            this.blockingQueue.put(bArr2);
        } catch (Exception unused) {
        }
    }

    @Override // com.hwfit.otg.UsbAbs
    public void startLater() {
        if (this.mSendDataThread == null) {
            this.mSendDataThread = new C0591MThread(this.mISendData, "USB-Send");
        }
        if (!this.mSendDataThread.IsRunning()) {
            this.mSendDataThread.start();
        }
        if (this.mSendDataThread.isPause()) {
            this.mSendDataThread.resumeThread();
        }
        if (this.mMsgProcThread == null) {
            this.mMsgProcThread = new C0591MThread(this.mIMsgProc, "CMD_Proc");
        }
        if (!this.mMsgProcThread.IsRunning()) {
            this.mMsgProcThread.start();
        }
        if (this.mMsgProcThread.isPause()) {
            this.mMsgProcThread.resumeThread();
        }
        Log.v("USB_CM_LATER", "proc cnt-->" + this.procCnt);
    }

    @Override // com.hwfit.otg.UsbAbs
    public void disconnectEarly() {
        try {
            if (this.mSendDataThread != null) {
                this.mSendDataThread.pauseThread();
            }
            if (this.mMsgProcThread != null) {
                this.mMsgProcThread.pauseThread();
            }
            if (this.mSendDataThread != null) {
                this.mSendDataThread.exit();
                this.mSendDataThread = null;
            }
            if (this.mMsgProcThread != null) {
                this.mMsgProcThread.exit();
                this.mMsgProcThread = null;
            }
        } catch (Exception unused) {
        }
    }
}
