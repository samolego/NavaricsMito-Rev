package com.tencent.wxop.stat.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.tencent.wxop.stat.common.e */
/* loaded from: classes2.dex */
public class C2434e {

    /* renamed from: a */
    ExecutorService f8083a;

    public C2434e() {
        this.f8083a = null;
        this.f8083a = Executors.newSingleThreadExecutor();
    }

    /* renamed from: a */
    public void m7990a(Runnable runnable) {
        this.f8083a.execute(runnable);
    }
}