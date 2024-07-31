package com.hwfit.otg;

import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbInterface;

/* loaded from: classes.dex */
public class USBVideo1Hal extends UsbAbs {
    private static USBVideo1Hal mInstance;

    @Override // com.hwfit.otg.UsbAbs
    public void disconnectEarly() {
    }

    @Override // com.hwfit.otg.UsbAbs
    public void startLater() {
    }

    private USBVideo1Hal() {
    }

    public static USBVideo1Hal getInstance() {
        synchronized (USBVideo1Hal.class) {
            if (mInstance == null) {
                mInstance = new USBVideo1Hal();
            }
        }
        return mInstance;
    }

    public void init(UsbDeviceConnection usbDeviceConnection, UsbInterface usbInterface) {
        if (!OTGManager.EN_USB_REQUEST_M) {
            this.mOtgBulkReadThreadEn = true;
            this.mOtgBulkReadBuffSize = 2048;
            this.getmOtgBulkReadTimerout = 500;
            this.mOtgBulkReadPeriod = 5;
            this.mOtgBulkReadThreadName = "USB_Video1Read";
        }
        this.TAG = "Usb_V1";
        this.mUsbInterface = usbInterface;
        this.mDeviceConnection = usbDeviceConnection;
        getUsbInfo();
    }

    @Override // com.hwfit.otg.UsbAbs
    public void sendMsg(byte[] bArr, int i) {
        if (OTGManager.mVideoCb != null) {
            OTGManager.mVideoCb.video1Data(bArr, i);
        }
    }
}
