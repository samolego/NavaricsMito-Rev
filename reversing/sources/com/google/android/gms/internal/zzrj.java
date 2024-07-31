package com.google.android.gms.internal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class zzrj {

    /* renamed from: ys */
    private static final ExecutorService f3296ys = new ThreadPoolExecutor(0, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzsf("GAC_Transform"));

    public static ExecutorService zzarz() {
        return f3296ys;
    }
}
