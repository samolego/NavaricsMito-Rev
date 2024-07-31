package com.senseplay.sdk.task;

import com.adapt.SPM_Manager;

/* loaded from: classes2.dex */
public class SPCmdHandler extends Thread {
    private boolean flag;
    private boolean isWorking = false;
    private boolean usbInit;

    public void exit() {
        this.flag = false;
        this.isWorking = false;
    }

    public SPCmdHandler(boolean z) {
        this.flag = true;
        this.usbInit = false;
        this.flag = true;
        this.usbInit = z;
    }

    public boolean isWorking() {
        return this.isWorking;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        SPM_Manager.GetInstance();
        while (this.flag) {
            try {
                sleep(5L);
                if (this.usbInit) {
                    this.isWorking = true;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
    }
}
