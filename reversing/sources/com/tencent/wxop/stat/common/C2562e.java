package com.tencent.wxop.stat.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.tencent.wxop.stat.common.e */
/* loaded from: classes2.dex */
public class C2562e {

    /* renamed from: a */
    ExecutorService f8045a;

    public C2562e() {
        this.f8045a = null;
        this.f8045a = Executors.newSingleThreadExecutor();
    }

    /* renamed from: a */
    public void m4865a(Runnable runnable) {
        this.f8045a.execute(runnable);
    }
}
