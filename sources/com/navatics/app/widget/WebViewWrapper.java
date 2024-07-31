package com.navatics.app.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.navatics.app.R;
import com.navatics.robot.utils.RxTimer;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes.dex */
public class WebViewWrapper extends RelativeLayout implements RxTimer.InterfaceC2159a {

    /* renamed from: f */
    private static final int[] f5539f = {R.raw.privacy_policy_ssl};

    /* renamed from: a */
    private WebView f5540a;

    /* renamed from: b */
    private ProgressBar f5541b;

    /* renamed from: c */
    private FrameLayout f5542c;

    /* renamed from: d */
    private RxTimer f5543d;

    /* renamed from: e */
    private String f5544e;

    /* renamed from: g */
    private ArrayList<SslCertificate> f5545g;

    /* renamed from: a */
    private void m7069a() {
        int[] iArr;
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            for (int i : f5539f) {
                InputStream openRawResource = getResources().openRawResource(i);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(openRawResource);
                try {
                    Certificate generateCertificate = certificateFactory.generateCertificate(bufferedInputStream);
                    if (generateCertificate instanceof X509Certificate) {
                        this.f5545g.add(new SslCertificate((X509Certificate) generateCertificate));
                    } else {
                        Log.w("WebViewWrapper", "Wrong Certificate format: " + i);
                    }
                } catch (CertificateException unused) {
                    Log.w("WebViewWrapper", "Cannot read certificate: " + i);
                    try {
                        bufferedInputStream.close();
                        openRawResource.close();
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                    }
                }
                try {
                    bufferedInputStream.close();
                    openRawResource.close();
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                }
            }
        } catch (CertificateException e3) {
            e3.printStackTrace();
        }
    }

    public WebViewWrapper(Context context) {
        this(context, null);
    }

    public WebViewWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WebViewWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5545g = new ArrayList<>();
        m7068a(context);
        m7064b();
        m7062c();
    }

    /* renamed from: a */
    private void m7068a(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.layout_webview, this);
        this.f5540a = (WebView) inflate.findViewById(R.id.webView);
        this.f5541b = (ProgressBar) inflate.findViewById(R.id.progressBar);
        this.f5542c = (FrameLayout) inflate.findViewById(R.id.frameLayout);
    }

    /* renamed from: b */
    private void m7064b() {
        WebSettings settings = this.f5540a.getSettings();
        settings.setJavaScriptEnabled(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setDatabaseEnabled(true);
        settings.setSaveFormData(true);
        settings.setDomStorageEnabled(true);
        settings.setGeolocationEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        this.f5540a.setHorizontalScrollBarEnabled(false);
        this.f5540a.setScrollbarFadingEnabled(true);
        this.f5540a.setScrollBarStyle(33554432);
        this.f5540a.setOverScrollMode(2);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
    }

    /* renamed from: c */
    private void m7062c() {
        this.f5540a.setWebViewClient(new WebViewClient() { // from class: com.navatics.app.widget.WebViewWrapper.1
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                WebViewWrapper.this.f5541b.setVisibility(0);
                WebViewWrapper webViewWrapper = WebViewWrapper.this;
                webViewWrapper.f5543d = RxTimer.m5859a(webViewWrapper, 2000L, false);
                WebViewWrapper.this.f5543d.m5860a();
                Log.i("WebViewWrapper", "onPageStarted: ");
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                WebViewWrapper.this.f5541b.setVisibility(8);
                if (WebViewWrapper.this.f5543d != null) {
                    WebViewWrapper.this.f5543d.m5857b();
                }
                Log.i("WebViewWrapper", "onPageFinished: ");
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                if (i == -2 || i == -6 || i == -8) {
                    webView.loadUrl("about:blank");
                    WebViewWrapper.this.f5540a.loadUrl("file:///android_asset/privacy_policy.html");
                    return;
                }
                super.onReceivedError(webView, i, str, str2);
                WebViewWrapper.this.f5541b.setVisibility(8);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                int statusCode = webResourceResponse.getStatusCode();
                if (404 != statusCode && 500 != statusCode) {
                    WebViewWrapper.this.f5541b.setVisibility(8);
                    super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                    return;
                }
                webView.loadUrl("file:///android_asset/privacy_policy.html");
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                boolean z;
                Log.i("WebViewWrapper", "onReceivedSslError: " + sslError.getPrimaryError());
                int primaryError = sslError.getPrimaryError();
                if ((primaryError == 5 || primaryError == 3 || primaryError == 4 || primaryError == 1) && WebViewWrapper.this.getUrl().equals("https://www.navatics.com/privacy_policy.html")) {
                    Log.i("WebViewWrapper", "onReceivedSslError: join");
                    SslCertificate certificate = sslError.getCertificate();
                    Bundle saveState = SslCertificate.saveState(certificate);
                    Iterator it = WebViewWrapper.this.f5545g.iterator();
                    while (it.hasNext()) {
                        SslCertificate sslCertificate = (SslCertificate) it.next();
                        if (TextUtils.equals(certificate.toString(), sslCertificate.toString())) {
                            Bundle saveState2 = SslCertificate.saveState(sslCertificate);
                            Iterator<String> it2 = saveState2.keySet().iterator();
                            while (true) {
                                z = false;
                                if (!it2.hasNext()) {
                                    z = true;
                                    break;
                                }
                                String next = it2.next();
                                Object obj = saveState.get(next);
                                Object obj2 = saveState2.get(next);
                                if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
                                    if (!Arrays.equals((byte[]) obj, (byte[]) obj2)) {
                                        break;
                                    }
                                } else if (obj != null && !obj.equals(obj2)) {
                                    break;
                                }
                            }
                            if (z) {
                                Log.i("WebViewWrapper", "onReceivedSslError: matches");
                                sslErrorHandler.proceed();
                                return;
                            }
                        }
                    }
                    super.onReceivedSslError(webView, sslErrorHandler, sslError);
                    Log.w("WebViewWrapper", "SSL Error " + sslError.getPrimaryError());
                }
            }
        });
        this.f5540a.setWebChromeClient(new WebChromeClient() { // from class: com.navatics.app.widget.WebViewWrapper.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                if (i >= 100) {
                    WebViewWrapper.this.f5541b.setVisibility(8);
                } else {
                    if (WebViewWrapper.this.f5541b.getVisibility() == 8) {
                        WebViewWrapper.this.f5541b.setVisibility(0);
                    }
                    WebViewWrapper.this.f5541b.setProgress(i);
                }
                super.onProgressChanged(webView, i);
            }
        });
    }

    @Override // com.navatics.robot.utils.RxTimer.InterfaceC2159a
    /* renamed from: a */
    public void mo5856a(RxTimer rxTimer) {
        this.f5543d.m5857b();
        this.f5540a.loadUrl("file:///android_asset/privacy_policy.html");
    }

    /* renamed from: a */
    public void m7065a(String str) {
        m7069a();
        this.f5544e = str;
        this.f5540a.loadUrl(str);
    }

    public void setProgressDrawable(@DrawableRes int i) {
        ProgressBar progressBar = this.f5541b;
        progressBar.setProgressDrawable(progressBar.getContext().getResources().getDrawable(i));
    }

    public WebView getWebView() {
        return this.f5540a;
    }

    public FrameLayout getFragment() {
        return this.f5542c;
    }

    public String getUrl() {
        return this.f5544e;
    }
}
