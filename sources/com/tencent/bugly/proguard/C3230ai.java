package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ai */
/* loaded from: classes2.dex */
public final class C2459ai extends AbstractC2479k implements Cloneable {

    /* renamed from: c */
    private static ArrayList<String> f7523c;

    /* renamed from: a */
    private String f7524a = "";

    /* renamed from: b */
    private ArrayList<String> f7525b = null;

    @Override // com.tencent.bugly.proguard.AbstractC2479k
    /* renamed from: a */
    public final void mo5197a(StringBuilder sb, int i) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC2479k
    /* renamed from: a */
    public final void mo5198a(C2478j c2478j) {
        c2478j.m5207a(this.f7524a, 0);
        ArrayList<String> arrayList = this.f7525b;
        if (arrayList != null) {
            c2478j.m5206a((Collection) arrayList, 1);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC2479k
    /* renamed from: a */
    public final void mo5199a(C2476i c2476i) {
        this.f7524a = c2476i.m5224b(0, true);
        if (f7523c == null) {
            f7523c = new ArrayList<>();
            f7523c.add("");
        }
        this.f7525b = (ArrayList) c2476i.m5231a((C2476i) f7523c, 1, false);
    }
}
