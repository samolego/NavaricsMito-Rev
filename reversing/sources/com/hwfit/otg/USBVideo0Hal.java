package com.hwfit.otg;

import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbInterface;
import android.util.Log;
import com.adapt.SPM_NvDecodec;
import com.hwfit.common.StatisticsInfo;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* loaded from: classes.dex */
public class USBVideo0Hal extends UsbAbs {
    public static boolean NATIVE_SEARCH_FRAME_EN = false;
    private static USBVideo0Hal mInstance;
    private long mFramePushT = 0;
    private long mPktCnt = 0;
    private long meriodPT = 0;
    private long startCpyTime;

    @Override // com.hwfit.otg.UsbAbs
    public void disconnectEarly() {
    }

    @Override // com.hwfit.otg.UsbAbs
    public void startLater() {
    }

    private USBVideo0Hal() {
    }

    public static USBVideo0Hal getInstance() {
        synchronized (USBVideo0Hal.class) {
            if (mInstance == null) {
                mInstance = new USBVideo0Hal();
            }
        }
        return mInstance;
    }

    public void init(UsbDeviceConnection usbDeviceConnection, UsbInterface usbInterface) {
        if (!OTGManager.EN_USB_REQUEST_M) {
            this.mOtgBulkReadThreadEn = true;
            this.mOtgBulkReadBuffSize = 2048;
            this.getmOtgBulkReadTimerout = IjkMediaCodecInfo.RANK_SECURE;
            this.mOtgBulkReadPeriod = 1;
            this.mOtgBulkReadThreadName = "USB_Video0Read";
            this.mEnmOtgBulkReadPeriodWait = false;
        }
        this.TAG = "Usb_V0";
        this.mUsbInterface = usbInterface;
        this.mDeviceConnection = usbDeviceConnection;
        getUsbInfo();
    }

    @Override // com.hwfit.otg.UsbAbs
    public void sendMsg(byte[] bArr, int i) {
        StatisticsInfo.V0_CodeRate += i;
        if (!NATIVE_SEARCH_FRAME_EN) {
            if (OTGManager.mVideoCb != null) {
                OTGManager.mVideoCb.video0Data(bArr, i);
                return;
            }
            return;
        }
        this.startCpyTime = System.nanoTime();
        SPM_NvDecodec.getInstance().pushStreamPkt(0, bArr, i);
        long nanoTime = System.nanoTime() - this.startCpyTime;
        Log.v("V0_PUSH", "Cpy," + (nanoTime / 1000) + ",us,size," + i);
    }
}
