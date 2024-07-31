package com.senseplay.sdk.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsoluteLayout;
import android.widget.ProgressBar;
import com.senseplay.sdk.C2189R;
import com.senseplay.sdk.listener.WebLoginListener;
import com.senseplay.sdk.log.SPDebug;
import com.senseplay.sdk.model.account.AccountData;
import com.senseplay.sdk.model.pciture.PictureData;

/* loaded from: classes2.dex */
public class SPWebView extends WebView {
    private WebLoginListener listener;
    private ValueCallback mUploadMessage;
    private PictureData pictureData;
    private ProgressBar progressBar;

    /* loaded from: classes2.dex */
    public interface UploadListener {
        void clear();
    }

    public SPWebView(Context context) {
        super(context);
    }

    public SPWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SPWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public SPWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void init() {
        this.progressBar = new ProgressBar(getContext(), null, 16842872);
        this.progressBar.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, 4, 0, 0));
        this.progressBar.setProgressDrawable(getContext().getResources().getDrawable(C2189R.C2190drawable.sp_progress_bar));
        addView(this.progressBar);
        setWebViewClient(new MyWebViewClient());
        setWebChromeClient(new MyWebChromeClient());
    }

    public void setPicture(PictureData pictureData) {
        this.pictureData = pictureData;
        pictureData.setUploadListener(new UploadListener() { // from class: com.senseplay.sdk.view.SPWebView.1
            @Override // com.senseplay.sdk.view.SPWebView.UploadListener
            public void clear() {
                SPWebView.this.uploadUri(null);
            }
        });
    }

    public void setWebSettings() {
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setCacheMode(1);
        settings.setAllowFileAccess(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && canGoBack()) {
            goBack();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* loaded from: classes2.dex */
    private class MyWebViewClient extends WebViewClient {
        private MyWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            SPDebug.m5813e("url", str);
            if (str == null) {
                return true;
            }
            if (str != null && str.contains(AccountData.LoginSuccess)) {
                if (SPWebView.this.listener != null) {
                    SPWebView.this.listener.setAccountInfo(str);
                }
            } else if (str.contains(AccountData.Back_Account) || str.contains(AccountData.Back_Reg) || str.contains(AccountData.Back)) {
                ((Activity) SPWebView.this.getContext()).finish();
            } else if (str.contains(AccountData.Back_Logout)) {
                ((Activity) SPWebView.this.getContext()).finish();
                if (SPWebView.this.listener != null) {
                    SPWebView.this.listener.logout();
                }
            } else {
                webView.loadUrl(str);
            }
            return true;
        }
    }

    /* loaded from: classes2.dex */
    private class MyWebChromeClient extends WebChromeClient {
        private MyWebChromeClient() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (i == 100) {
                SPWebView.this.progressBar.setVisibility(8);
            } else {
                if (SPWebView.this.progressBar.getVisibility() == 8) {
                    SPWebView.this.progressBar.setVisibility(0);
                }
                SPWebView.this.progressBar.setProgress(i);
            }
            super.onProgressChanged(webView, i);
        }

        @Override // android.webkit.WebChromeClient
        @TargetApi(21)
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            SPWebView.this.mUploadMessage = valueCallback;
            SPWebView.this.showDialog();
            return true;
        }

        protected void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            SPWebView.this.mUploadMessage = valueCallback;
            SPWebView.this.showDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        PictureData pictureData = this.pictureData;
        if (pictureData != null) {
            pictureData.showDialog();
        }
    }

    public void uploadUri(Uri uri) {
        if (this.mUploadMessage == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            if (uri != null) {
                this.mUploadMessage.onReceiveValue(new Uri[]{uri});
            } else {
                this.mUploadMessage.onReceiveValue(null);
            }
        } else if (uri != null) {
            this.mUploadMessage.onReceiveValue(uri);
        } else {
            this.mUploadMessage.onReceiveValue(null);
        }
        this.mUploadMessage = null;
    }

    public ValueCallback<Uri> getmUploadMessage() {
        return this.mUploadMessage;
    }

    public void setWebLoginListener(WebLoginListener webLoginListener) {
        this.listener = webLoginListener;
    }
}
