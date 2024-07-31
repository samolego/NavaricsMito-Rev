package com.google.android.gms.internal;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class zzsf implements ThreadFactory {

    /* renamed from: Ff */
    private final String f3356Ff;

    /* renamed from: Fg */
    private final AtomicInteger f3357Fg;

    /* renamed from: Fh */
    private final ThreadFactory f3358Fh;
    private final int mPriority;

    public zzsf(String str) {
        this(str, 0);
    }

    public zzsf(String str, int i) {
        this.f3357Fg = new AtomicInteger();
        this.f3358Fh = Executors.defaultThreadFactory();
        this.f3356Ff = (String) com.google.android.gms.common.internal.zzac.zzb(str, "Name must not be null");
        this.mPriority = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f3358Fh.newThread(new zzsg(runnable, this.mPriority));
        String str = this.f3356Ff;
        int andIncrement = this.f3357Fg.getAndIncrement();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13);
        sb.append(str);
        sb.append("[");
        sb.append(andIncrement);
        sb.append("]");
        newThread.setName(sb.toString());
        return newThread;
    }
}
