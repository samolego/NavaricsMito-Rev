package com.bumptech.glide.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/* renamed from: com.bumptech.glide.util.g */
/* loaded from: classes.dex */
public class MultiClassKey {

    /* renamed from: a */
    private Class<?> f1303a;

    /* renamed from: b */
    private Class<?> f1304b;

    /* renamed from: c */
    private Class<?> f1305c;

    public MultiClassKey() {
    }

    public MultiClassKey(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        m11582a(cls, cls2);
    }

    public MultiClassKey(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        m11581a(cls, cls2, cls3);
    }

    /* renamed from: a */
    public void m11582a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        m11581a(cls, cls2, null);
    }

    /* renamed from: a */
    public void m11581a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.f1303a = cls;
        this.f1304b = cls2;
        this.f1305c = cls3;
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f1303a + ", second=" + this.f1304b + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MultiClassKey multiClassKey = (MultiClassKey) obj;
        return this.f1303a.equals(multiClassKey.f1303a) && this.f1304b.equals(multiClassKey.f1304b) && C0791i.m11566a(this.f1305c, multiClassKey.f1305c);
    }

    public int hashCode() {
        int hashCode = ((this.f1303a.hashCode() * 31) + this.f1304b.hashCode()) * 31;
        Class<?> cls = this.f1305c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }
}
