package com.tencent.wxop.stat;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.k */
/* loaded from: classes2.dex */
public class RunnableC2594k implements Runnable {

    /* renamed from: a */
    final /* synthetic */ List f8149a;

    /* renamed from: b */
    final /* synthetic */ InterfaceC2591h f8150b;

    /* renamed from: c */
    final /* synthetic */ C2592i f8151c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2594k(C2592i c2592i, List list, InterfaceC2591h interfaceC2591h) {
        this.f8151c = c2592i;
        this.f8149a = list;
        this.f8150b = interfaceC2591h;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f8151c.m4753a(this.f8149a, this.f8150b);
    }
}
