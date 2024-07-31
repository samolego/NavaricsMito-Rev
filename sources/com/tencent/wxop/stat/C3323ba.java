package com.tencent.wxop.stat;

import java.util.List;

/* renamed from: com.tencent.wxop.stat.ba */
/* loaded from: classes2.dex */
class C2553ba implements InterfaceC2591h {

    /* renamed from: a */
    final /* synthetic */ List f7999a;

    /* renamed from: b */
    final /* synthetic */ boolean f8000b;

    /* renamed from: c */
    final /* synthetic */ C2546au f8001c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2553ba(C2546au c2546au, List list, boolean z) {
        this.f8001c = c2546au;
        this.f7999a = list;
        this.f8000b = z;
    }

    @Override // com.tencent.wxop.stat.InterfaceC2591h
    /* renamed from: a */
    public void mo4749a() {
        StatServiceImpl.m4960c();
        this.f8001c.m4902a(this.f7999a, this.f8000b, true);
    }

    @Override // com.tencent.wxop.stat.InterfaceC2591h
    /* renamed from: b */
    public void mo4748b() {
        StatServiceImpl.m4957d();
        this.f8001c.m4904a(this.f7999a, 1, this.f8000b, true);
    }
}
