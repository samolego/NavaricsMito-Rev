package com.twitter.sdk.android.core.identity;

import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.twitter.sdk.android.core.internal.p078a.UrlUtils;
import java.net.URI;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: com.twitter.sdk.android.core.identity.f */
/* loaded from: classes2.dex */
class OAuthWebViewClient extends WebViewClient {

    /* renamed from: a */
    private final String f8473a;

    /* renamed from: b */
    private final InterfaceC2651a f8474b;

    /* compiled from: OAuthWebViewClient.java */
    /* renamed from: com.twitter.sdk.android.core.identity.f$a */
    /* loaded from: classes2.dex */
    interface InterfaceC2651a {
        /* renamed from: a */
        void mo4527a(Bundle bundle);

        /* renamed from: a */
        void mo4526a(WebView webView, String str);

        /* renamed from: a */
        void mo4525a(WebViewException webViewException);
    }

    public OAuthWebViewClient(String str, InterfaceC2651a interfaceC2651a) {
        this.f8473a = str;
        this.f8474b = interfaceC2651a;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f8474b.mo4526a(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith(this.f8473a)) {
            TreeMap<String, String> m4486a = UrlUtils.m4486a(URI.create(str), false);
            Bundle bundle = new Bundle(m4486a.size());
            for (Map.Entry<String, String> entry : m4486a.entrySet()) {
                bundle.putString(entry.getKey(), entry.getValue());
            }
            this.f8474b.mo4527a(bundle);
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        this.f8474b.mo4525a(new WebViewException(i, str, str2));
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        this.f8474b.mo4525a(new WebViewException(sslError.getPrimaryError(), null, null));
    }
}
