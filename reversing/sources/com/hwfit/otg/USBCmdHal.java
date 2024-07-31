package com.hwfit.otg;

import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbInterface;
import com.common.ARTOSYN_ACK_FRAME;
import com.hwfit.common.OTA_Proc;

/* loaded from: classes.dex */
public class USBCmdHal extends UsbAbs {
    private static USBCmdHal mInstance;
    private Object writeObj = new Object();

    @Override // com.hwfit.otg.UsbAbs
    public void disconnectEarly() {
    }

    @Override // com.hwfit.otg.UsbAbs
    public void startLater() {
    }

    private USBCmdHal() {
    }

    public static USBCmdHal getInstance() {
        synchronized (USBCmdHal.class) {
            if (mInstance == null) {
                mInstance = new USBCmdHal();
            }
        }
        return mInstance;
    }

    public void init(UsbDeviceConnection usbDeviceConnection, UsbInterface usbInterface) {
        this.mUsbInterface = usbInterface;
        this.mDeviceConnection = usbDeviceConnection;
        this.TAG = "Usb_CMD";
        if (!OTGManager.EN_USB_REQUEST_M) {
            this.mOtgBulkReadThreadEn = false;
        }
        getUsbInfo();
    }

    @Override // com.hwfit.otg.UsbAbs
    public void sendMsg(byte[] bArr, int i) {
        if (i <= 0) {
            return;
        }
        ARTOSYN_ACK_FRAME artosyn_ack_frame = new ARTOSYN_ACK_FRAME();
        artosyn_ack_frame.fill(bArr);
        switch (artosyn_ack_frame.getFrameType()) {
            case IS_ERR:
            default:
                return;
            case IS_OTA:
                OTA_Proc.GetInstance().pushAckFrame(artosyn_ack_frame);
                return;
        }
    }

    @Override // com.hwfit.otg.UsbAbs
    public int write(byte[] bArr, int i) {
        if (this.mDeviceConnection == null) {
            return -1;
        }
        synchronized (this.writeObj) {
            if (bArr == null || i <= 0) {
                return -1;
            }
            return this.mDeviceConnection.bulkTransfer(this.mOutEp, bArr, i, 1000);
        }
    }
}
