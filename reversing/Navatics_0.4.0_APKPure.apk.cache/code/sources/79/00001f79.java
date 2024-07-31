package com.tencent.bugly.crashreport.crash;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.a */
/* loaded from: classes2.dex */
public final class C2320a implements Comparable<C2320a> {

    /* renamed from: a */
    public long f7414a = -1;

    /* renamed from: b */
    public long f7415b = -1;

    /* renamed from: c */
    public String f7416c = null;

    /* renamed from: d */
    public boolean f7417d = false;

    /* renamed from: e */
    public boolean f7418e = false;

    /* renamed from: f */
    public int f7419f = 0;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(C2320a c2320a) {
        C2320a c2320a2 = c2320a;
        if (c2320a2 == null) {
            return 1;
        }
        long j = this.f7415b - c2320a2.f7415b;
        if (j <= 0) {
            return j < 0 ? -1 : 0;
        }
        return 1;
    }
}