package com.tencent.wxop.stat;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.aw */
/* loaded from: classes2.dex */
public class RunnableC2548aw implements Runnable {

    /* renamed from: a */
    final /* synthetic */ List f7986a;

    /* renamed from: b */
    final /* synthetic */ boolean f7987b;

    /* renamed from: c */
    final /* synthetic */ boolean f7988c;

    /* renamed from: d */
    final /* synthetic */ C2546au f7989d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2548aw(C2546au c2546au, List list, boolean z, boolean z2) {
        this.f7989d = c2546au;
        this.f7986a = list;
        this.f7987b = z;
        this.f7988c = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7989d.m4903a(this.f7986a, this.f7987b);
        if (this.f7988c) {
            this.f7986a.clear();
        }
    }
}
