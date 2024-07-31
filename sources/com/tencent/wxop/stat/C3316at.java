package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.event.AbstractC2582e;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.at */
/* loaded from: classes2.dex */
public class C2545at implements InterfaceC2591h {

    /* renamed from: a */
    final /* synthetic */ C2542aq f7966a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2545at(C2542aq c2542aq) {
        this.f7966a = c2542aq;
    }

    @Override // com.tencent.wxop.stat.InterfaceC2591h
    /* renamed from: a */
    public void mo4749a() {
        Context context;
        StatServiceImpl.m4960c();
        if (C2546au.m4900b().f7970a > 0) {
            context = this.f7966a.f7962d;
            StatServiceImpl.commitEvents(context, -1);
        }
    }

    @Override // com.tencent.wxop.stat.InterfaceC2591h
    /* renamed from: b */
    public void mo4748b() {
        AbstractC2582e abstractC2582e;
        boolean z;
        C2546au m4900b = C2546au.m4900b();
        abstractC2582e = this.f7966a.f7959a;
        z = this.f7966a.f7961c;
        m4900b.m4908a(abstractC2582e, (InterfaceC2591h) null, z, true);
        StatServiceImpl.m4957d();
    }
}
