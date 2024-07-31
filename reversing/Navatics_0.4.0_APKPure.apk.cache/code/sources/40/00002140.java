package com.twitter.sdk.android.core.internal.p068b;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: PreferenceStoreImpl.java */
/* renamed from: com.twitter.sdk.android.core.internal.b.c, reason: use source file name */
/* loaded from: classes2.dex */
public class PreferenceStoreImpl implements InterfaceC2536b {

    /* renamed from: a */
    private final SharedPreferences f8536a;

    public PreferenceStoreImpl(Context context, String str) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null");
        }
        this.f8536a = context.getSharedPreferences(str, 0);
    }

    @Override // com.twitter.sdk.android.core.internal.p068b.InterfaceC2536b
    /* renamed from: a */
    public SharedPreferences mo8382a() {
        return this.f8536a;
    }

    @Override // com.twitter.sdk.android.core.internal.p068b.InterfaceC2536b
    /* renamed from: b */
    public SharedPreferences.Editor mo8384b() {
        return this.f8536a.edit();
    }

    @Override // com.twitter.sdk.android.core.internal.p068b.InterfaceC2536b
    /* renamed from: a */
    public boolean mo8383a(SharedPreferences.Editor editor) {
        editor.apply();
        return true;
    }
}