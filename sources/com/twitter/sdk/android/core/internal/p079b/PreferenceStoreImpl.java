package com.twitter.sdk.android.core.internal.p079b;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.twitter.sdk.android.core.internal.b.c */
/* loaded from: classes2.dex */
public class PreferenceStoreImpl implements PreferenceStore {

    /* renamed from: a */
    private final SharedPreferences f8496a;

    public PreferenceStoreImpl(Context context, String str) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null");
        }
        this.f8496a = context.getSharedPreferences(str, 0);
    }

    @Override // com.twitter.sdk.android.core.internal.p079b.PreferenceStore
    /* renamed from: a */
    public SharedPreferences mo4481a() {
        return this.f8496a;
    }

    @Override // com.twitter.sdk.android.core.internal.p079b.PreferenceStore
    /* renamed from: b */
    public SharedPreferences.Editor mo4479b() {
        return this.f8496a.edit();
    }

    @Override // com.twitter.sdk.android.core.internal.p079b.PreferenceStore
    /* renamed from: a */
    public boolean mo4480a(SharedPreferences.Editor editor) {
        editor.apply();
        return true;
    }
}
