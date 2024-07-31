package com.twitter.sdk.android.core.internal.p079b;

import android.annotation.SuppressLint;

/* renamed from: com.twitter.sdk.android.core.internal.b.d */
/* loaded from: classes2.dex */
public class PreferenceStoreStrategy<T> {

    /* renamed from: a */
    private final PreferenceStore f8497a;

    /* renamed from: b */
    private final SerializationStrategy<T> f8498b;

    /* renamed from: c */
    private final String f8499c;

    public PreferenceStoreStrategy(PreferenceStore preferenceStore, SerializationStrategy<T> serializationStrategy, String str) {
        this.f8497a = preferenceStore;
        this.f8498b = serializationStrategy;
        this.f8499c = str;
    }

    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: a */
    public void m4477a(T t) {
        PreferenceStore preferenceStore = this.f8497a;
        preferenceStore.mo4480a(preferenceStore.mo4479b().putString(this.f8499c, this.f8498b.mo4216a(t)));
    }

    /* renamed from: a */
    public T m4478a() {
        return this.f8498b.mo4214b(this.f8497a.mo4481a().getString(this.f8499c, null));
    }

    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: b */
    public void m4476b() {
        this.f8497a.mo4479b().remove(this.f8499c).commit();
    }
}
