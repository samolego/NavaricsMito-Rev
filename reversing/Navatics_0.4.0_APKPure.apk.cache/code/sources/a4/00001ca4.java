package com.navatics.xlog;

import android.os.Looper;
import android.os.Process;

/* loaded from: classes2.dex */
public class AndroidSystem implements ISystemInterface {
    @Override // com.navatics.xlog.ISystemInterface
    public int myPid() {
        return Process.myPid();
    }

    @Override // com.navatics.xlog.ISystemInterface
    public int myTid() {
        return Process.myTid();
    }

    @Override // com.navatics.xlog.ISystemInterface
    public long mainTid() {
        return Looper.getMainLooper().getThread().getId();
    }
}