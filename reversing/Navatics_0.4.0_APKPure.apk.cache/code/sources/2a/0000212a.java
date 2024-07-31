package com.twitter.sdk.android.core.identity;

import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.twitter.sdk.android.core.internal.p067a.UrlUtils;
import java.net.URI;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: OAuthWebViewClient.java */
/* renamed from: com.twitter.sdk.android.core.identity.f, reason: use source file name */
/* loaded from: classes2.dex */
class OAuthWebViewClient extends WebViewClient {

    /* renamed from: a */
    private final String f8513a;

    /* renamed from: b */
    private final a f8514b;

    /* compiled from: OAuthWebViewClient.java */
    /* renamed from: com.twitter.sdk.android.core.identity.f$a */
    /* loaded from: classes2.dex */
    interface a {
        /* renamed from: a */
        void mo8331a(Bundle bundle);

        /* renamed from: a */
        void mo8333a(WebView webView, String str);

        /* renamed from: a */
        void mo8334a(WebViewException webViewException);
    }

    public OAuthWebViewClient(String str, a aVar) {
        this.f8513a = str;
        this.f8514b = aVar;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f8514b.mo8333a(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith(this.f8513a)) {
            TreeMap<String, String> m8377a = UrlUtils.m8377a(URI.create(str), false);
            Bundle bundle = new Bundle(m8377a.size());
            for (Map.Entry<String, String> entry : m8377a.entrySet()) {
                bundle.putString(entry.getKey(), entry.getValue());
            }
            this.f8514b.mo8331a(bundle);
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        this.f8514b.mo8334a(new WebViewException(i, str, str2));
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        this.f8514b.mo8334a(new WebViewException(sslError.getPrimaryError(), null, null));
    }
}