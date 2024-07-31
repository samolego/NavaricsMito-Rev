package com.tencent.wxop.stat;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.ar */
/* loaded from: classes2.dex */
public class C2543ar implements InterfaceC2591h {

    /* renamed from: a */
    final /* synthetic */ C2542aq f7964a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2543ar(C2542aq c2542aq) {
        this.f7964a = c2542aq;
    }

    @Override // com.tencent.wxop.stat.InterfaceC2591h
    /* renamed from: a */
    public void mo4749a() {
        StatServiceImpl.m4960c();
        if (C2546au.m4900b().m4919a() >= StatConfig.getMaxBatchReportCount()) {
            C2546au.m4900b().m4918a(StatConfig.getMaxBatchReportCount());
        }
    }

    @Override // com.tencent.wxop.stat.InterfaceC2591h
    /* renamed from: b */
    public void mo4748b() {
        StatServiceImpl.m4957d();
    }
}
