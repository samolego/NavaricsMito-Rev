package com.twitter.sdk.android.core.identity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.twitter.sdk.android.core.AbstractC2641c;
import com.twitter.sdk.android.core.InterfaceC2645h;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.identity.OAuthWebViewClient;
import com.twitter.sdk.android.core.internal.oauth.OAuth1aService;
import com.twitter.sdk.android.core.internal.oauth.OAuthResponse;

/* renamed from: com.twitter.sdk.android.core.identity.c */
/* loaded from: classes2.dex */
class OAuthController implements OAuthWebViewClient.InterfaceC2651a {

    /* renamed from: a */
    final InterfaceC2650a f8465a;

    /* renamed from: b */
    TwitterAuthToken f8466b;

    /* renamed from: c */
    private final ProgressBar f8467c;

    /* renamed from: d */
    private final WebView f8468d;

    /* renamed from: e */
    private final TwitterAuthConfig f8469e;

    /* renamed from: f */
    private final OAuth1aService f8470f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OAuthController.java */
    /* renamed from: com.twitter.sdk.android.core.identity.c$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC2650a {
        /* renamed from: a */
        void mo4529a(int i, Intent intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OAuthController(ProgressBar progressBar, WebView webView, TwitterAuthConfig twitterAuthConfig, OAuth1aService oAuth1aService, InterfaceC2650a interfaceC2650a) {
        this.f8467c = progressBar;
        this.f8468d = webView;
        this.f8469e = twitterAuthConfig;
        this.f8470f = oAuth1aService;
        this.f8465a = interfaceC2650a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m4541a() {
        Twitter.m4253h().mo4561a("Twitter", "Obtaining request token to start the sign in flow");
        this.f8470f.m4413a(m4537b());
    }

    /* renamed from: b */
    AbstractC2641c<OAuthResponse> m4537b() {
        return new AbstractC2641c<OAuthResponse>() { // from class: com.twitter.sdk.android.core.identity.c.1
            @Override // com.twitter.sdk.android.core.AbstractC2641c
            /* renamed from: a */
            public void mo3867a(Result<OAuthResponse> result) {
                OAuthController.this.f8466b = result.f8688a.f8552a;
                String m4414a = OAuthController.this.f8470f.m4414a(OAuthController.this.f8466b);
                Twitter.m4253h().mo4561a("Twitter", "Redirecting user to web view to complete authorization flow");
                OAuthController oAuthController = OAuthController.this;
                oAuthController.m4539a(oAuthController.f8468d, new OAuthWebViewClient(OAuthController.this.f8470f.m4415a(OAuthController.this.f8469e), OAuthController.this), m4414a, new OAuthWebChromeClient());
            }

            @Override // com.twitter.sdk.android.core.AbstractC2641c
            /* renamed from: a */
            public void mo3868a(TwitterException twitterException) {
                Twitter.m4253h().mo4556c("Twitter", "Failed to get request token", twitterException);
                OAuthController.this.m4540a(1, new TwitterAuthException("Failed to get request token"));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m4540a(int i, TwitterAuthException twitterAuthException) {
        Intent intent = new Intent();
        intent.putExtra("auth_error", twitterAuthException);
        this.f8465a.mo4529a(i, intent);
    }

    /* renamed from: a */
    void m4539a(WebView webView, WebViewClient webViewClient, String str, WebChromeClient webChromeClient) {
        WebSettings settings = webView.getSettings();
        settings.setAllowFileAccess(false);
        settings.setJavaScriptEnabled(false);
        settings.setSaveFormData(false);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setWebViewClient(webViewClient);
        webView.loadUrl(str);
        webView.setVisibility(4);
        webView.setWebChromeClient(webChromeClient);
    }

    /* renamed from: b */
    private void m4536b(Bundle bundle) {
        String string;
        Twitter.m4253h().mo4561a("Twitter", "OAuth web view completed successfully");
        if (bundle != null && (string = bundle.getString("oauth_verifier")) != null) {
            Twitter.m4253h().mo4561a("Twitter", "Converting the request token to an access token.");
            this.f8470f.m4412a(m4533c(), this.f8466b, string);
            return;
        }
        InterfaceC2645h m4253h = Twitter.m4253h();
        m4253h.mo4556c("Twitter", "Failed to get authorization, bundle incomplete " + bundle, null);
        m4540a(1, new TwitterAuthException("Failed to get authorization, bundle incomplete"));
    }

    /* renamed from: c */
    AbstractC2641c<OAuthResponse> m4533c() {
        return new AbstractC2641c<OAuthResponse>() { // from class: com.twitter.sdk.android.core.identity.c.2
            @Override // com.twitter.sdk.android.core.AbstractC2641c
            /* renamed from: a */
            public void mo3867a(Result<OAuthResponse> result) {
                Intent intent = new Intent();
                OAuthResponse oAuthResponse = result.f8688a;
                intent.putExtra("screen_name", oAuthResponse.f8553b);
                intent.putExtra("user_id", oAuthResponse.f8554c);
                intent.putExtra("tk", oAuthResponse.f8552a.f8434b);
                intent.putExtra("ts", oAuthResponse.f8552a.f8435c);
                OAuthController.this.f8465a.mo4529a(-1, intent);
            }

            @Override // com.twitter.sdk.android.core.AbstractC2641c
            /* renamed from: a */
            public void mo3868a(TwitterException twitterException) {
                Twitter.m4253h().mo4556c("Twitter", "Failed to get access token", twitterException);
                OAuthController.this.m4540a(1, new TwitterAuthException("Failed to get access token"));
            }
        };
    }

    /* renamed from: b */
    private void m4535b(WebViewException webViewException) {
        Twitter.m4253h().mo4556c("Twitter", "OAuth web view completed with an error", webViewException);
        m4540a(1, new TwitterAuthException("OAuth web view completed with an error"));
    }

    /* renamed from: d */
    private void m4531d() {
        this.f8468d.stopLoading();
        m4530e();
    }

    /* renamed from: e */
    private void m4530e() {
        this.f8467c.setVisibility(8);
    }

    @Override // com.twitter.sdk.android.core.identity.OAuthWebViewClient.InterfaceC2651a
    /* renamed from: a */
    public void mo4526a(WebView webView, String str) {
        m4530e();
        webView.setVisibility(0);
    }

    @Override // com.twitter.sdk.android.core.identity.OAuthWebViewClient.InterfaceC2651a
    /* renamed from: a */
    public void mo4527a(Bundle bundle) {
        m4536b(bundle);
        m4531d();
    }

    @Override // com.twitter.sdk.android.core.identity.OAuthWebViewClient.InterfaceC2651a
    /* renamed from: a */
    public void mo4525a(WebViewException webViewException) {
        m4535b(webViewException);
        m4531d();
    }
}
