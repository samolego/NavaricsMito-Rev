package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.al */
/* loaded from: classes2.dex */
public final class C2462al extends AbstractC2479k implements Cloneable {

    /* renamed from: b */
    private static ArrayList<C2461ak> f7559b;

    /* renamed from: a */
    public ArrayList<C2461ak> f7560a = null;

    @Override // com.tencent.bugly.proguard.AbstractC2479k
    /* renamed from: a */
    public final void mo5197a(StringBuilder sb, int i) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC2479k
    /* renamed from: a */
    public final void mo5198a(C2478j c2478j) {
        c2478j.m5206a((Collection) this.f7560a, 0);
    }

    @Override // com.tencent.bugly.proguard.AbstractC2479k
    /* renamed from: a */
    public final void mo5199a(C2476i c2476i) {
        if (f7559b == null) {
            f7559b = new ArrayList<>();
            f7559b.add(new C2461ak());
        }
        this.f7560a = (ArrayList) c2476i.m5231a((C2476i) f7559b, 0, true);
    }
}
