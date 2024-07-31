package com.senseplay.sdk.model.dfm;

import com.jnilib.CppSDKConnectors;

/* loaded from: classes2.dex */
public class DfmDevThead extends Thread {
    private DfmDevListener dfmDevListener;
    private boolean working;
    private boolean hasKey = false;
    private final int TIME = 50;
    private long times = 0;

    /* loaded from: classes2.dex */
    public interface DfmDevListener {
        void setCommonEvent(CommonEvent commonEvent);

        void setKeyEvent(KeyEvent keyEvent);

        void setTouchEvent(TouchEvent touchEvent);
    }

    public DfmDevThead() {
        this.working = true;
        this.working = true;
    }

    public void setDeviceCacheListener(DfmDevListener dfmDevListener) {
        this.dfmDevListener = dfmDevListener;
    }

    public void hasKey(boolean z) {
        this.hasKey = z;
    }

    private void dfmSwitch(boolean z) {
        CppSDKConnectors.DfmSwitch(z);
    }

    private void getKeycode() {
        byte[] bArr = new byte[6];
        if (CppSDKConnectors.getKeycode(bArr) == 6) {
            KeyEvent keyEvent = new KeyEvent();
            byte b = bArr[0];
            if (KeyCodeData.type_key == b) {
                keyEvent.setKey(KeyCodeData.getKey(bArr[1]));
                KeyCodeData.getKeyEvent(bArr[1], bArr[2], keyEvent);
                if (this.dfmDevListener == null || keyEvent.getKey() == null || "".equals(keyEvent.getKey()) || "null".equals(keyEvent.getKey())) {
                    return;
                }
                this.dfmDevListener.setKeyEvent(keyEvent);
            } else if (KeyCodeData.type_touch == b) {
                TouchEvent touchEvent = new TouchEvent();
                touchEvent.setKey(KeyCodeData.getKey(bArr[1]));
                KeyCodeData.getTouchEvent(bArr, touchEvent);
                DfmDevListener dfmDevListener = this.dfmDevListener;
                if (dfmDevListener != null) {
                    dfmDevListener.setTouchEvent(touchEvent);
                }
            } else if (KeyCodeData.type_va == b) {
                CommonEvent commonEvent = new CommonEvent();
                commonEvent.setKey(KeyCodeData.getKey(bArr[1]));
                KeyCodeData.getCommonEvent(bArr, commonEvent);
                DfmDevListener dfmDevListener2 = this.dfmDevListener;
                if (dfmDevListener2 != null) {
                    dfmDevListener2.setCommonEvent(commonEvent);
                }
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        while (this.working) {
            try {
                if (this.times % 200 == 0) {
                    dfmSwitch(true);
                    if (this.times > 10000000) {
                        this.times = 50L;
                    }
                }
                if (this.hasKey) {
                    getKeycode();
                }
                this.times += 50;
                sleep(50L);
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
    }

    public void exit() {
        this.working = false;
        this.hasKey = false;
        dfmSwitch(false);
    }
}
