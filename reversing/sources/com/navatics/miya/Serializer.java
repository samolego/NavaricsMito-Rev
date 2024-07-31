package com.navatics.miya;

import com.navatics.miya.p059a.Output;

/* renamed from: com.navatics.miya.f */
/* loaded from: classes.dex */
public abstract class Serializer<T> {

    /* renamed from: a */
    private boolean f6050a;

    /* renamed from: b */
    private boolean f6051b;

    /* renamed from: a */
    public abstract void mo6619a(Miya miya, Output output, T t);

    /* renamed from: a */
    public boolean m6649a() {
        return this.f6050a;
    }

    /* renamed from: a */
    public void m6648a(boolean z) {
        this.f6050a = z;
    }

    /* renamed from: b */
    public void m6647b(boolean z) {
        this.f6051b = z;
    }
}
