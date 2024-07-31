package com.navatics.miya;

import com.navatics.miya.p060b.C2012j;

/* renamed from: com.navatics.miya.e */
/* loaded from: classes.dex */
public class Registration {

    /* renamed from: a */
    private final Class f6046a;

    /* renamed from: b */
    private final boolean f6047b;

    /* renamed from: c */
    private final int f6048c;

    /* renamed from: d */
    private Serializer f6049d;

    public Registration(Class cls, Serializer serializer, int i) {
        if (cls == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        if (serializer == null) {
            throw new IllegalArgumentException("serializer cannot be null.");
        }
        this.f6046a = cls;
        this.f6049d = serializer;
        this.f6048c = i;
        this.f6047b = C2012j.m6660a(cls.getName());
    }

    /* renamed from: a */
    public Class m6654a() {
        return this.f6046a;
    }

    /* renamed from: b */
    public boolean m6652b() {
        return this.f6047b;
    }

    /* renamed from: c */
    public int m6651c() {
        return this.f6048c;
    }

    /* renamed from: d */
    public Serializer m6650d() {
        return this.f6049d;
    }

    /* renamed from: a */
    public void m6653a(Serializer serializer) {
        if (serializer == null) {
            throw new IllegalArgumentException("serializer cannot be null.");
        }
        this.f6049d = serializer;
    }

    public String toString() {
        return "[" + this.f6048c + ", " + C2012j.m6659b(this.f6046a) + "]";
    }
}
