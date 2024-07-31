package com.bumptech.glide.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/* compiled from: MultiClassKey.java */
/* renamed from: com.bumptech.glide.util.g, reason: use source file name */
/* loaded from: classes.dex */
public class MultiClassKey {

    /* renamed from: a */
    private Class<?> f1307a;

    /* renamed from: b */
    private Class<?> f1308b;

    /* renamed from: c */
    private Class<?> f1309c;

    public MultiClassKey() {
    }

    public MultiClassKey(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        m1360a(cls, cls2);
    }

    public MultiClassKey(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        m1361a(cls, cls2, cls3);
    }

    /* renamed from: a */
    public void m1360a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        m1361a(cls, cls2, null);
    }

    /* renamed from: a */
    public void m1361a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.f1307a = cls;
        this.f1308b = cls2;
        this.f1309c = cls3;
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f1307a + ", second=" + this.f1308b + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MultiClassKey multiClassKey = (MultiClassKey) obj;
        return this.f1307a.equals(multiClassKey.f1307a) && this.f1308b.equals(multiClassKey.f1308b) && C0781i.m1380a(this.f1309c, multiClassKey.f1309c);
    }

    public int hashCode() {
        int hashCode = ((this.f1307a.hashCode() * 31) + this.f1308b.hashCode()) * 31;
        Class<?> cls = this.f1309c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }
}