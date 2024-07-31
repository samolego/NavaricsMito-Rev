package com.tencent.p070a.p071a.p072a.p073a;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

/* renamed from: com.tencent.a.a.a.a.d */
/* loaded from: classes2.dex */
final class C2397d extends AbstractC2399f {
    public C2397d(Context context) {
        super(context);
    }

    @Override // com.tencent.p070a.p071a.p072a.p073a.AbstractC2399f
    /* renamed from: a */
    protected final void mo5569a(String str) {
        synchronized (this) {
            Log.i("MID", "write mid to sharedPreferences");
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f7115a).edit();
            edit.putString(C2401h.m5555c("4kU71lN96TJUomD1vOU9lgj9Tw=="), str);
            edit.commit();
        }
    }

    @Override // com.tencent.p070a.p071a.p072a.p073a.AbstractC2399f
    /* renamed from: a */
    protected final boolean mo5571a() {
        return true;
    }

    @Override // com.tencent.p070a.p071a.p072a.p073a.AbstractC2399f
    /* renamed from: b */
    protected final String mo5568b() {
        String string;
        synchronized (this) {
            Log.i("MID", "read mid from sharedPreferences");
            string = PreferenceManager.getDefaultSharedPreferences(this.f7115a).getString(C2401h.m5555c("4kU71lN96TJUomD1vOU9lgj9Tw=="), null);
        }
        return string;
    }
}
