package com.senseplay.sdk;

import android.content.Context;
import android.util.Log;
import com.common.IOTA_State;
import com.common.OTA_TARGET;
import com.hwfit.abs.HwAbs;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.cache.LinkFlag;
import com.senseplay.sdk.model.ota.OtaHttp;
import com.senseplay.sdk.model.ota.OtaListener;
import com.senseplay.sdk.model.ota.VersionInfo;

/* loaded from: classes2.dex */
public class SPOta {
    private static SPOta spOta;
    private OtaHttp otaHttp;
    private OtaListener otaListener;
    IOTA_State mIOTA_State = new IOTA_State() { // from class: com.senseplay.sdk.SPOta.3
        @Override // com.common.IOTA_State
        public void isSuccess() {
            LinkFlag.isOta = false;
            SPOta.this.spRc.setRcCommond(true);
            SPOta.this.postResult(true);
        }

        @Override // com.common.IOTA_State
        public void isFailed() {
            LinkFlag.isOta = false;
            SPOta.this.spRc.setRcCommond(true);
            SPOta.this.postResult(false);
        }

        @Override // com.common.IOTA_State
        public void isProcessing(float f) {
            Log.w("ota", "isProcessing: " + f);
            SPOta.this.postProcess((int) f);
        }

        @Override // com.common.IOTA_State
        public void isFlashWritting() {
            Log.w("ota", "isFlashWritting");
        }
    };
    private SPRc spRc = SPRc.getInstance();

    public static SPOta getInstance() {
        if (spOta == null) {
            synchronized (SPOta.class) {
                if (spOta == null) {
                    spOta = new SPOta(SPManager.getContent());
                }
            }
        }
        return spOta;
    }

    private SPOta(Context context) {
        this.otaHttp = new OtaHttp(context);
    }

    public void checkVersion(String str, String str2, String str3, String str4, String str5, MCallBack<VersionInfo> mCallBack) {
        this.otaHttp.checkVersion(str, str2, str3, str4, str5, mCallBack);
    }

    public void rcOTA(String str, OtaListener otaListener) {
        this.otaListener = otaListener;
        try {
            HwAbs usb = SPUsb.getInstance().getUsb();
            if (usb != null && usb.HwConnectReady()) {
                usb.StartOTA(str, OTA_TARGET.OTA_RC, this.mIOTA_State);
                return;
            }
            Log.w("startOTA", "no usb");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void devOTA(String str, OtaListener otaListener) {
        this.otaListener = otaListener;
        try {
            HwAbs usb = SPUsb.getInstance().getUsb();
            if (usb != null && usb.HwConnectReady()) {
                LinkFlag.isOta = true;
                this.spRc.setRcCommond(false);
                usb.StartOTA(str, OTA_TARGET.OTA_DEVICE, this.mIOTA_State);
                return;
            }
            Log.w("startOTA", "no usb");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postProcess(final int i) {
        if (SPManager.getInstance().getHandler() == null || this.otaListener == null) {
            Log.e("HandlerPost", "ota listener is null");
        } else {
            SPManager.getInstance().getHandler().post(new Runnable() { // from class: com.senseplay.sdk.SPOta.1
                @Override // java.lang.Runnable
                public void run() {
                    SPOta.this.otaListener.onProcessing(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postResult(final boolean z) {
        if (SPManager.getInstance().getHandler() == null || this.otaListener == null) {
            Log.e("HandlerPost", "ota listener is null");
        } else {
            SPManager.getInstance().getHandler().post(new Runnable() { // from class: com.senseplay.sdk.SPOta.2
                @Override // java.lang.Runnable
                public void run() {
                    SPOta.this.otaListener.onResult(z);
                }
            });
        }
    }
}
