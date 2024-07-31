package com.senseplay.sdk.opengl;

import android.util.Log;

/* loaded from: classes2.dex */
public class GLUpdateThread extends Thread {
    private int[] texId;
    private final Object lock = new Object();
    private boolean pause = true;
    private boolean isResChanged = false;

    public GLUpdateThread(int[] iArr) {
        this.texId = iArr;
        setName("GLUpdateThread");
    }

    void pauseThread() {
        this.pause = true;
    }

    void resumeThread() {
        this.pause = false;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
    }

    void onPause() {
        synchronized (this.lock) {
            try {
                this.lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (true) {
            if (this.pause) {
                onPause();
            } else {
                GLTool Instance = GLTool.Instance();
                int i = Instance.width;
                int i2 = Instance.height;
                if (this.isResChanged) {
                    Instance.createAlpha8Tex(this.texId[0], null, i, i2, false);
                    Instance.createAlpha8Tex(this.texId[1], null, i / 2, i2 / 2, true);
                    Log.e("unity", "res changed,width: " + i + ",height:" + i2);
                    this.isResChanged = false;
                } else if (Instance.y_buf != null && Instance.uv_buf != null) {
                    if (Instance.y_buf.remaining() == 921600) {
                        Instance.createAlpha8Tex(this.texId[0], Instance.y_buf, i, i2, false);
                    }
                    if (Instance.uv_buf.remaining() == 460800) {
                        Instance.createAlpha8Tex(this.texId[1], Instance.uv_buf, i / 2, i2 / 2, true);
                    }
                }
            }
        }
    }
}
