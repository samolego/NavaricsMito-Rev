package com.senseplay.sdk.activity;

import android.app.Application;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.SPUsb;

/* loaded from: classes2.dex */
public class MyApplication extends Application {
    private boolean mCallingOpenUsb = false;
    SPUsb mUsb;

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        this.mUsb = SPUsb.getInstance();
        this.mUsb.registerUsbReceiver(this, new MCallBack<Boolean>() { // from class: com.senseplay.sdk.activity.MyApplication.1
            @Override // com.senseplay.mframe.client.MCallBack
            public void onResult(Boolean bool) {
                if (bool.booleanValue()) {
                    MyApplication.this.openUsb();
                }
            }
        });
        openUsb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUsb() {
        if (this.mCallingOpenUsb) {
            return;
        }
        this.mCallingOpenUsb = true;
        this.mUsb.openUsb(new MCallBack<Boolean>() { // from class: com.senseplay.sdk.activity.MyApplication.2
            @Override // com.senseplay.mframe.client.MCallBack
            public void onResult(Boolean bool) {
            }
        });
    }
}
