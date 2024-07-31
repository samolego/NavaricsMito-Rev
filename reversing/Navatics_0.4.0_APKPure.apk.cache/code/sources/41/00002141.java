package com.twitter.sdk.android.core.internal.p068b;

import android.annotation.SuppressLint;

/* compiled from: PreferenceStoreStrategy.java */
/* renamed from: com.twitter.sdk.android.core.internal.b.d, reason: use source file name */
/* loaded from: classes2.dex */
public class PreferenceStoreStrategy<T> {

    /* renamed from: a */
    private final InterfaceC2536b f8537a;

    /* renamed from: b */
    private final SerializationStrategy<T> f8538b;

    /* renamed from: c */
    private final String f8539c;

    public PreferenceStoreStrategy(InterfaceC2536b interfaceC2536b, SerializationStrategy<T> serializationStrategy, String str) {
        this.f8537a = interfaceC2536b;
        this.f8538b = serializationStrategy;
        this.f8539c = str;
    }

    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: a */
    public void m8386a(T t) {
        InterfaceC2536b interfaceC2536b = this.f8537a;
        interfaceC2536b.mo8383a(interfaceC2536b.mo8384b().putString(this.f8539c, this.f8538b.mo8292a(t)));
    }

    /* renamed from: a */
    public T m8385a() {
        return this.f8538b.mo8293b(this.f8537a.mo8382a().getString(this.f8539c, null));
    }

    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: b */
    public void m8387b() {
        this.f8537a.mo8384b().remove(this.f8539c).commit();
    }
}