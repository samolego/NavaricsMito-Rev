package com.senseplay.sdk;

import android.os.Handler;
import android.os.Message;
import com.jnilib.CppSDKConnectors;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.model.dfm.CommonEvent;
import com.senseplay.sdk.model.dfm.DfmDevThead;
import com.senseplay.sdk.model.dfm.KeyEvent;
import com.senseplay.sdk.model.dfm.TouchEvent;

/* loaded from: classes2.dex */
public class SPDfmDev {
    private static SPDfmDev spdfm;
    private MCallBack<CommonEvent> VAEvent;
    private MCallBack<KeyEvent> keyCallBack;
    private MCallBack<TouchEvent> touchCallBack;
    private DfmDevThead dfmDevThead = new DfmDevThead();
    private final int type_key = 1;
    private final int type_touch = 2;
    private final int type_va = 3;
    private Handler handler = new Handler() { // from class: com.senseplay.sdk.SPDfmDev.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (SPDfmDev.this.keyCallBack != null && i == 1) {
                SPDfmDev.this.keyCallBack.onResult((KeyEvent) message.obj);
            }
            if (SPDfmDev.this.touchCallBack != null && i == 2) {
                SPDfmDev.this.touchCallBack.onResult((TouchEvent) message.obj);
            }
            if (SPDfmDev.this.VAEvent == null || i != 3) {
                return;
            }
            SPDfmDev.this.VAEvent.onResult((CommonEvent) message.obj);
        }
    };

    public static SPDfmDev getInstance() {
        if (spdfm == null) {
            synchronized (SPDfmDev.class) {
                if (spdfm == null) {
                    spdfm = new SPDfmDev();
                }
            }
        }
        return spdfm;
    }

    private SPDfmDev() {
        this.dfmDevThead.setDeviceCacheListener(new DfmDevThead.DfmDevListener() { // from class: com.senseplay.sdk.SPDfmDev.1
            @Override // com.senseplay.sdk.model.dfm.DfmDevThead.DfmDevListener
            public void setKeyEvent(KeyEvent keyEvent) {
                Message message = new Message();
                message.what = 1;
                message.obj = keyEvent;
                SPDfmDev.this.handler.sendMessage(message);
            }

            @Override // com.senseplay.sdk.model.dfm.DfmDevThead.DfmDevListener
            public void setTouchEvent(TouchEvent touchEvent) {
                Message message = new Message();
                message.what = 2;
                message.obj = touchEvent;
                SPDfmDev.this.handler.sendMessage(message);
            }

            @Override // com.senseplay.sdk.model.dfm.DfmDevThead.DfmDevListener
            public void setCommonEvent(CommonEvent commonEvent) {
                Message message = new Message();
                message.what = 3;
                message.obj = commonEvent;
                SPDfmDev.this.handler.sendMessage(message);
            }
        });
        this.dfmDevThead.start();
    }

    public void getKeyEvent(MCallBack<KeyEvent> mCallBack) {
        this.dfmDevThead.hasKey(true);
        this.keyCallBack = mCallBack;
    }

    public void getTouchEvent(MCallBack<TouchEvent> mCallBack) {
        this.dfmDevThead.hasKey(true);
        this.touchCallBack = mCallBack;
    }

    public void getVAEvent(MCallBack<CommonEvent> mCallBack) {
        this.dfmDevThead.hasKey(true);
        this.VAEvent = mCallBack;
    }

    public int setSpeed(float f) {
        return CppSDKConnectors.SetSpeed(f);
    }

    public void release() {
        DfmDevThead dfmDevThead = this.dfmDevThead;
        if (dfmDevThead != null) {
            dfmDevThead.exit();
            this.dfmDevThead = null;
        }
        spdfm = null;
    }
}
