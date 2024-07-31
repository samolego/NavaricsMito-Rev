package com.tencent.wxop.stat;

import com.tencent.wxop.stat.event.AbstractC2582e;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.ay */
/* loaded from: classes2.dex */
public class RunnableC2550ay implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AbstractC2582e f7991a;

    /* renamed from: b */
    final /* synthetic */ InterfaceC2591h f7992b;

    /* renamed from: c */
    final /* synthetic */ boolean f7993c;

    /* renamed from: d */
    final /* synthetic */ boolean f7994d;

    /* renamed from: e */
    final /* synthetic */ C2546au f7995e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2550ay(C2546au c2546au, AbstractC2582e abstractC2582e, InterfaceC2591h interfaceC2591h, boolean z, boolean z2) {
        this.f7995e = c2546au;
        this.f7991a = abstractC2582e;
        this.f7992b = interfaceC2591h;
        this.f7993c = z;
        this.f7994d = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7995e.m4897b(this.f7991a, this.f7992b, this.f7993c, this.f7994d);
    }
}
