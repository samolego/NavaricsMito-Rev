package com.hwfit.otg;

import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbRequest;
import android.util.Log;
import com.MThread.C0591MThread;
import com.MThread.MThreadI;
import com.p035dg.ConfigManager;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class UsbAbs {
    protected UsbDeviceConnection mDeviceConnection;
    protected UsbEndpoint mInEp;
    protected C0591MThread mOtgBulkReadThread;
    protected UsbEndpoint mOutEp;
    protected UsbInterface mUsbInterface;
    protected UsbRequest mUsbRequest;
    protected String TAG = "USB";
    protected boolean mIsLinked = false;
    protected ByteBuffer mRequestRdBuf = null;
    protected byte[] mReceiveytes = new byte[1024];
    protected String mOtgBulkReadThreadName = "USB-BulkRead";
    protected boolean mOtgBulkReadThreadEn = true;
    protected int mOtgBulkReadBuffSize = 1024;
    protected int getmOtgBulkReadTimerout = 1000;
    protected int mOtgBulkReadPeriod = 10;
    protected boolean mEnmOtgBulkReadPeriodWait = true;
    private MThreadI IOtgBulkRead = new MThreadI() { // from class: com.hwfit.otg.UsbAbs.1
        @Override // com.MThread.MThreadI
        public void Exec() {
            try {
                if (UsbAbs.this.mDeviceConnection != null && UsbAbs.this.mInEp != null) {
                    int bulkTransfer = UsbAbs.this.mDeviceConnection.bulkTransfer(UsbAbs.this.mInEp, UsbAbs.this.mReceiveytes, UsbAbs.this.mOtgBulkReadBuffSize, UsbAbs.this.getmOtgBulkReadTimerout);
                    if (bulkTransfer > 0) {
                        UsbAbs.this.sendMsg(UsbAbs.this.mReceiveytes, bulkTransfer);
                    } else {
                        Log.v(UsbAbs.this.TAG, "Read failed!");
                    }
                    if (UsbAbs.this.mEnmOtgBulkReadPeriodWait) {
                        Thread.sleep(UsbAbs.this.mOtgBulkReadPeriod);
                        return;
                    }
                    return;
                }
                Thread.sleep(100L);
            } catch (Exception unused) {
            }
        }
    };

    protected abstract void disconnectEarly();

    protected abstract void sendMsg(byte[] bArr, int i);

    protected abstract void startLater();

    public void getUsbInfo() {
        UsbInterface usbInterface = this.mUsbInterface;
        if (usbInterface == null || this.mDeviceConnection == null) {
            return;
        }
        int endpointCount = usbInterface.getEndpointCount();
        for (int i = 0; i < endpointCount; i++) {
            if (this.mUsbInterface.getEndpoint(i).getDirection() == 128) {
                this.mInEp = this.mUsbInterface.getEndpoint(i);
            } else if (this.mUsbInterface.getEndpoint(i).getDirection() == 0) {
                this.mOutEp = this.mUsbInterface.getEndpoint(i);
            } else {
                Log.e(this.TAG, "Usb Endpoint err!!!!");
            }
        }
        this.mIsLinked = this.mInEp != null;
    }

    public int start() {
        if (!OTGManager.EN_USB_REQUEST_M && this.mOtgBulkReadThreadEn && this.mOtgBulkReadThread == null) {
            this.mOtgBulkReadThread = new C0591MThread(this.IOtgBulkRead, this.mOtgBulkReadThreadName);
        }
        if (!OTGManager.EN_USB_REQUEST_M && this.mOtgBulkReadThreadEn && !this.mOtgBulkReadThread.IsRunning()) {
            this.mOtgBulkReadThread.start();
        }
        if (!OTGManager.EN_USB_REQUEST_M && this.mOtgBulkReadThreadEn && this.mOtgBulkReadThread.isPause()) {
            this.mOtgBulkReadThread.resumeThread();
        }
        if (!OTGManager.EN_USB_REQUEST_M && this.mOtgBulkReadThreadEn) {
            this.mReceiveytes = new byte[this.mOtgBulkReadBuffSize];
        }
        if (!OTGManager.EN_USB_REQUEST_M) {
            String str = this.TAG;
            Log.v(str, "BulkReadThreadEn: " + this.mOtgBulkReadThreadEn + ",BulkReadBuffSize:" + this.mOtgBulkReadBuffSize + ",BulkReadTimerout: " + this.getmOtgBulkReadTimerout + ",BulkReadPeriod:" + this.mOtgBulkReadPeriod + ",OtgBulkReadPeriodWait:" + this.mEnmOtgBulkReadPeriodWait);
        }
        if (OTGManager.EN_USB_REQUEST_M) {
            startRequest();
        }
        startLater();
        return 0;
    }

    public int exit() {
        disconnect();
        return 0;
    }

    public int getInterfaceID() {
        if (this.mIsLinked && this.mUsbInterface == null) {
            return -1;
        }
        return this.mUsbInterface.getId();
    }

    public void disconnect() {
        UsbRequest usbRequest;
        C0591MThread c0591MThread;
        C0591MThread c0591MThread2;
        if (!OTGManager.EN_USB_REQUEST_M && this.mOtgBulkReadThreadEn && (c0591MThread2 = this.mOtgBulkReadThread) != null) {
            c0591MThread2.pauseThread();
        }
        if (!OTGManager.EN_USB_REQUEST_M && this.mOtgBulkReadThreadEn && (c0591MThread = this.mOtgBulkReadThread) != null) {
            c0591MThread.exit();
            this.mOtgBulkReadThread = null;
        }
        disconnectEarly();
        if (OTGManager.EN_USB_REQUEST_M && (usbRequest = this.mUsbRequest) != null) {
            usbRequest.cancel();
            this.mUsbRequest.close();
        }
        this.mDeviceConnection.releaseInterface(this.mUsbInterface);
        this.mIsLinked = false;
    }

    public boolean isOpen() {
        return this.mInEp != null && this.mIsLinked;
    }

    private void startRequest() {
        this.mRequestRdBuf = ByteBuffer.allocate(this.mInEp.getMaxPacketSize());
        this.mUsbRequest = new UsbRequest();
        this.mUsbRequest.initialize(this.mDeviceConnection, this.mInEp);
        if (this.mUsbRequest.queue(this.mRequestRdBuf, this.mInEp.getMaxPacketSize())) {
            return;
        }
        Log.e(this.TAG, "Usb Request failed!");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int write(byte[] bArr, int i) {
        return this.mDeviceConnection.bulkTransfer(this.mOutEp, bArr, i, ConfigManager.GetInstance().getConfig().getOtgWriteAndReadTimerout());
    }

    public int requestStream(UsbRequest usbRequest) {
        if (usbRequest != null && this.mUsbRequest == usbRequest && OTGManager.EN_USB_REQUEST_M) {
            int position = this.mRequestRdBuf.position();
            this.mRequestRdBuf.clear();
            this.mRequestRdBuf.get(this.mReceiveytes, 0, position);
            this.mRequestRdBuf.clear();
            sendMsg(this.mReceiveytes, position);
            this.mUsbRequest.queue(this.mRequestRdBuf, this.mInEp.getMaxPacketSize());
            return position;
        }
        return -1;
    }

    public int otgBulkReadData(byte[] bArr, int i) {
        UsbEndpoint usbEndpoint;
        UsbDeviceConnection usbDeviceConnection = this.mDeviceConnection;
        if (usbDeviceConnection == null || (usbEndpoint = this.mInEp) == null) {
            return -1;
        }
        return usbDeviceConnection.bulkTransfer(usbEndpoint, bArr, i, 500);
    }
}
