package com.navatics.app.activities;

import android.webkit.JavascriptInterface;
import com.navatics.dsbridge.DWebView;
import com.navatics.dsbridge.OnReturnValue;

/* renamed from: com.navatics.app.activities.a */
/* loaded from: classes.dex */
public class JsApi {

    /* renamed from: a */
    private DWebView f3969a;

    /* renamed from: b */
    private String f3970b = "115.636835";

    /* renamed from: c */
    private String f3971c = "-8.263694";

    public JsApi(DWebView dWebView) {
        this.f3969a = dWebView;
    }

    /* renamed from: a */
    public void m8974a(String str) {
        this.f3970b = str;
    }

    /* renamed from: b */
    public void m8973b(String str) {
        this.f3971c = str;
    }

    /* renamed from: a */
    public void m8975a() {
        this.f3969a.m6797a("refresh", (Object[]) null, (OnReturnValue) null);
    }

    @JavascriptInterface
    public String getLongitude(Object obj) {
        return this.f3970b;
    }

    @JavascriptInterface
    public String getLatitude(Object obj) {
        return this.f3971c;
    }
}
