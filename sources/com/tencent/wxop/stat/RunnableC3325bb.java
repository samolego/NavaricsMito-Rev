package com.tencent.wxop.stat;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.bb */
/* loaded from: classes2.dex */
public class RunnableC2554bb implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f8002a;

    /* renamed from: b */
    final /* synthetic */ C2546au f8003b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2554bb(C2546au c2546au, int i) {
        this.f8003b = c2546au;
        this.f8002a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f8003b.m4899b(this.f8002a, true);
        this.f8003b.m4899b(this.f8002a, false);
    }
}
