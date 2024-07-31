package com.twitter.sdk.android.core;

import android.util.Log;

/* renamed from: com.twitter.sdk.android.core.d */
/* loaded from: classes2.dex */
public class DefaultLogger implements InterfaceC2645h {

    /* renamed from: a */
    private int f8439a;

    public DefaultLogger(int i) {
        this.f8439a = i;
    }

    public DefaultLogger() {
        this.f8439a = 4;
    }

    /* renamed from: a */
    public boolean m4572a(String str, int i) {
        return this.f8439a <= i;
    }

    @Override // com.twitter.sdk.android.core.InterfaceC2645h
    /* renamed from: a */
    public void mo4560a(String str, String str2, Throwable th) {
        if (m4572a(str, 3)) {
            Log.d(str, str2, th);
        }
    }

    @Override // com.twitter.sdk.android.core.InterfaceC2645h
    /* renamed from: b */
    public void mo4558b(String str, String str2, Throwable th) {
        if (m4572a(str, 5)) {
            Log.w(str, str2, th);
        }
    }

    @Override // com.twitter.sdk.android.core.InterfaceC2645h
    /* renamed from: c */
    public void mo4556c(String str, String str2, Throwable th) {
        if (m4572a(str, 6)) {
            Log.e(str, str2, th);
        }
    }

    @Override // com.twitter.sdk.android.core.InterfaceC2645h
    /* renamed from: a */
    public void mo4561a(String str, String str2) {
        mo4560a(str, str2, (Throwable) null);
    }

    @Override // com.twitter.sdk.android.core.InterfaceC2645h
    /* renamed from: b */
    public void mo4559b(String str, String str2) {
        mo4558b(str, str2, null);
    }

    @Override // com.twitter.sdk.android.core.InterfaceC2645h
    /* renamed from: c */
    public void mo4557c(String str, String str2) {
        mo4556c(str, str2, null);
    }

    @Override // com.twitter.sdk.android.core.InterfaceC2645h
    /* renamed from: a */
    public void mo4562a(int i, String str, String str2) {
        m4573a(i, str, str2, false);
    }

    /* renamed from: a */
    public void m4573a(int i, String str, String str2, boolean z) {
        if (z || m4572a(str, i)) {
            Log.println(i, str, str2);
        }
    }
}
