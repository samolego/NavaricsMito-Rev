package com.tencent.wxop.stat;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.av */
/* loaded from: classes2.dex */
public class RunnableC2547av implements Runnable {

    /* renamed from: a */
    final /* synthetic */ List f7981a;

    /* renamed from: b */
    final /* synthetic */ int f7982b;

    /* renamed from: c */
    final /* synthetic */ boolean f7983c;

    /* renamed from: d */
    final /* synthetic */ boolean f7984d;

    /* renamed from: e */
    final /* synthetic */ C2546au f7985e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2547av(C2546au c2546au, List list, int i, boolean z, boolean z2) {
        this.f7985e = c2546au;
        this.f7981a = list;
        this.f7982b = i;
        this.f7983c = z;
        this.f7984d = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7985e.m4905a(this.f7981a, this.f7982b, this.f7983c);
        if (this.f7984d) {
            this.f7981a.clear();
        }
    }
}
