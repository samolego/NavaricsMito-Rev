package com.MThread;

import android.util.Log;

/* loaded from: classes.dex */
public class MThread extends Thread {
    private MThreadI mMThreadI;
    private final Object lock = new Object();
    private boolean pause = false;
    private boolean mRuning = false;

    public MThread(MThreadI mThreadI, String str) {
        this.mMThreadI = mThreadI;
        super.setName(str);
    }

    public boolean isPause() {
        return this.pause;
    }

    public void Abort() {
        this.mRuning = false;
    }

    public void pauseThread() {
        try {
            this.pause = true;
            interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void resumeThread() {
        try {
            this.pause = false;
            Log.e("Thread", "Resume Thread " + getName());
            synchronized (this.lock) {
                this.lock.notifyAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean IsRunning() {
        return this.mRuning;
    }

    public void onPause() {
        synchronized (this.lock) {
            try {
                this.lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void exit() {
        try {
            Log.e("Thread", "Thread:  " + getName() + " exit!!!");
            this.mRuning = false;
            synchronized (this.lock) {
                interrupt();
                this.lock.notifyAll();
                interrupt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        this.mRuning = true;
        super.start();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        this.mRuning = true;
        while (this.mRuning && !isInterrupted()) {
            try {
                while (this.pause) {
                    onPause();
                }
                if (this.mMThreadI != null) {
                    this.mMThreadI.Exec();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }
}