package com.twitter.sdk.android.core;

import android.util.Log;

/* compiled from: DefaultLogger.java */
/* renamed from: com.twitter.sdk.android.core.d */
/* loaded from: classes2.dex */
public class C2510d implements InterfaceC2514h {

    /* renamed from: a */
    private int f8479a;

    public C2510d(int i) {
        this.f8479a = i;
    }

    public C2510d() {
        this.f8479a = 4;
    }

    /* renamed from: a */
    public boolean m8286a(String str, int i) {
        return this.f8479a <= i;
    }

    @Override // com.twitter.sdk.android.core.InterfaceC2514h
    /* renamed from: a */
    public void mo8285a(String str, String str2, Throwable th) {
        if (m8286a(str, 3)) {
            Log.d(str, str2, th);
        }
    }

    @Override // com.twitter.sdk.android.core.InterfaceC2514h
    /* renamed from: b */
    public void mo8288b(String str, String str2, Throwable th) {
        if (m8286a(str, 5)) {
            Log.w(str, str2, th);
        }
    }

    @Override // com.twitter.sdk.android.core.InterfaceC2514h
    /* renamed from: c */
    public void mo8290c(String str, String str2, Throwable th) {
        if (m8286a(str, 6)) {
            Log.e(str, str2, th);
        }
    }

    @Override // com.twitter.sdk.android.core.InterfaceC2514h
    /* renamed from: a */
    public void mo8284a(String str, String str2) {
        mo8285a(str, str2, (Throwable) null);
    }

    @Override // com.twitter.sdk.android.core.InterfaceC2514h
    /* renamed from: b */
    public void mo8287b(String str, String str2) {
        mo8288b(str, str2, null);
    }

    @Override // com.twitter.sdk.android.core.InterfaceC2514h
    /* renamed from: c */
    public void mo8289c(String str, String str2) {
        mo8290c(str, str2, null);
    }

    @Override // com.twitter.sdk.android.core.InterfaceC2514h
    /* renamed from: a */
    public void mo8282a(int i, String str, String str2) {
        m8283a(i, str, str2, false);
    }

    /* renamed from: a */
    public void m8283a(int i, String str, String str2, boolean z) {
        if (z || m8286a(str, i)) {
            Log.println(i, str, str2);
        }
    }
}