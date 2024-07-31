package com.navatics.dsbridge;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Keep;
import android.support.p011v7.app.AlertDialog;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.FrameLayout;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes.dex */
public class DWebView extends WebView {

    /* renamed from: b */
    private static boolean f5908b = false;

    /* renamed from: a */
    Map<Integer, OnReturnValue> f5909a;

    /* renamed from: c */
    private Map<String, Object> f5910c;

    /* renamed from: d */
    private String f5911d;

    /* renamed from: e */
    private int f5912e;

    /* renamed from: f */
    private WebChromeClient f5913f;

    /* renamed from: g */
    private volatile boolean f5914g;

    /* renamed from: h */
    private InterfaceC2005c f5915h;

    /* renamed from: i */
    private ArrayList<C2003a> f5916i;

    /* renamed from: j */
    private InnerJavascriptInterface f5917j;

    /* renamed from: k */
    private Handler f5918k;

    /* renamed from: l */
    private WebChromeClient f5919l;

    @Deprecated
    /* renamed from: com.navatics.dsbridge.DWebView$b */
    /* loaded from: classes.dex */
    public interface InterfaceC2004b {
        @TargetApi(11)
        /* renamed from: a */
        void m6783a(ValueCallback valueCallback, String str);

        @TargetApi(16)
        /* renamed from: a */
        void m6782a(ValueCallback<Uri> valueCallback, String str, String str2);
    }

    /* renamed from: com.navatics.dsbridge.DWebView$c */
    /* loaded from: classes.dex */
    public interface InterfaceC2005c {
        /* renamed from: a */
        boolean m6781a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class InnerJavascriptInterface {
        private InnerJavascriptInterface() {
        }

        /* renamed from: a */
        private void m6784a(String str) {
            Log.d("dsBridge", str);
            if (DWebView.f5908b) {
                DWebView dWebView = DWebView.this;
                dWebView.m6798a(String.format("alert('%s')", "DEBUG ERR MSG:\\n" + str.replaceAll("\\'", "\\\\'")));
            }
        }

        @Keep
        @JavascriptInterface
        public String call(String str, String str2) {
            boolean z;
            String[] m6793b = DWebView.this.m6793b(str.trim());
            String str3 = m6793b[1];
            Object obj = DWebView.this.f5910c.get(m6793b[0]);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", -1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (obj == null) {
                m6784a("Js bridge  called, but can't find a corresponded JavascriptInterface object , please check your code!");
                return jSONObject.toString();
            }
            try {
                JSONObject jSONObject2 = new JSONObject(str2);
                Method method = null;
                final String string = jSONObject2.has("_dscbstub") ? jSONObject2.getString("_dscbstub") : null;
                Object obj2 = jSONObject2.has("data") ? jSONObject2.get("data") : null;
                Class<?> cls = obj.getClass();
                try {
                    try {
                        method = cls.getMethod(str3, Object.class, CompletionHandler.class);
                        z = true;
                    } catch (Exception unused) {
                        method = cls.getMethod(str3, Object.class);
                        z = false;
                    }
                } catch (Exception unused2) {
                    z = false;
                }
                if (method == null) {
                    m6784a("Not find method \"" + str3 + "\" implementation! please check if the  signature or namespace of the method is right ");
                    return jSONObject.toString();
                } else if (Build.VERSION.SDK_INT >= 17 && ((JavascriptInterface) method.getAnnotation(JavascriptInterface.class)) == null) {
                    m6784a("Method " + str3 + " is not invoked, since  it is not declared with JavascriptInterface annotation! ");
                    return jSONObject.toString();
                } else {
                    method.setAccessible(true);
                    try {
                        if (!z) {
                            Object invoke = method.invoke(obj, obj2);
                            jSONObject.put("code", 0);
                            jSONObject.put("data", invoke);
                            return jSONObject.toString();
                        }
                        method.invoke(obj, obj2, new CompletionHandler() { // from class: com.navatics.dsbridge.DWebView.InnerJavascriptInterface.1
                        });
                        return jSONObject.toString();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        m6784a(String.format("Call failed：The parameter of \"%s\" in Java is invalid.", str3));
                        return jSONObject.toString();
                    }
                }
            } catch (JSONException e3) {
                m6784a(String.format("The argument of \"%s\" must be a JSON object string!", str3));
                e3.printStackTrace();
                return jSONObject.toString();
            }
        }
    }

    public DWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5910c = new HashMap();
        this.f5912e = 0;
        this.f5914g = true;
        this.f5915h = null;
        this.f5917j = new InnerJavascriptInterface();
        this.f5918k = new Handler(Looper.getMainLooper());
        this.f5909a = new HashMap();
        this.f5919l = new WebChromeClient() { // from class: com.navatics.dsbridge.DWebView.6
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.onProgressChanged(webView, i);
                } else {
                    super.onProgressChanged(webView, i);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.onReceivedTitle(webView, str);
                } else {
                    super.onReceivedTitle(webView, str);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedIcon(WebView webView, Bitmap bitmap) {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.onReceivedIcon(webView, bitmap);
                } else {
                    super.onReceivedIcon(webView, bitmap);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.onReceivedTouchIconUrl(webView, str, z);
                } else {
                    super.onReceivedTouchIconUrl(webView, str, z);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.onShowCustomView(view, customViewCallback);
                } else {
                    super.onShowCustomView(view, customViewCallback);
                }
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(14)
            public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.onShowCustomView(view, i, customViewCallback);
                } else {
                    super.onShowCustomView(view, i, customViewCallback);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onHideCustomView() {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.onHideCustomView();
                } else {
                    super.onHideCustomView();
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
                if (DWebView.this.f5913f != null) {
                    return DWebView.this.f5913f.onCreateWindow(webView, z, z2, message);
                }
                return super.onCreateWindow(webView, z, z2, message);
            }

            @Override // android.webkit.WebChromeClient
            public void onRequestFocus(WebView webView) {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.onRequestFocus(webView);
                } else {
                    super.onRequestFocus(webView);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onCloseWindow(WebView webView) {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.onCloseWindow(webView);
                } else {
                    super.onCloseWindow(webView);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
                if (!DWebView.this.f5914g) {
                    jsResult.confirm();
                }
                if (DWebView.this.f5913f == null || !DWebView.this.f5913f.onJsAlert(webView, str, str2, jsResult)) {
                    new AlertDialog.Builder(DWebView.this.getContext()).setMessage(str2).setCancelable(false).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.navatics.dsbridge.DWebView.6.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            if (DWebView.this.f5914g) {
                                jsResult.confirm();
                            }
                        }
                    }).create().show();
                    return true;
                }
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsConfirm(WebView webView, String str, String str2, final JsResult jsResult) {
                if (!DWebView.this.f5914g) {
                    jsResult.confirm();
                }
                if (DWebView.this.f5913f == null || !DWebView.this.f5913f.onJsConfirm(webView, str, str2, jsResult)) {
                    DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.navatics.dsbridge.DWebView.6.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (DWebView.this.f5914g) {
                                if (i == -1) {
                                    jsResult.confirm();
                                } else {
                                    jsResult.cancel();
                                }
                            }
                        }
                    };
                    new AlertDialog.Builder(DWebView.this.getContext()).setMessage(str2).setCancelable(false).setPositiveButton(17039370, onClickListener).setNegativeButton(17039360, onClickListener).show();
                    return true;
                }
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView webView, String str, String str2, String str3, final JsPromptResult jsPromptResult) {
                if (Build.VERSION.SDK_INT > 16 || !str2.startsWith("_dsbridge=")) {
                    if (!DWebView.this.f5914g) {
                        jsPromptResult.confirm();
                    }
                    if (DWebView.this.f5913f == null || !DWebView.this.f5913f.onJsPrompt(webView, str, str2, str3, jsPromptResult)) {
                        final EditText editText = new EditText(DWebView.this.getContext());
                        editText.setText(str3);
                        if (str3 != null) {
                            editText.setSelection(str3.length());
                        }
                        float f = DWebView.this.getContext().getResources().getDisplayMetrics().density;
                        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.navatics.dsbridge.DWebView.6.3
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (DWebView.this.f5914g) {
                                    if (i == -1) {
                                        jsPromptResult.confirm(editText.getText().toString());
                                    } else {
                                        jsPromptResult.cancel();
                                    }
                                }
                            }
                        };
                        new AlertDialog.Builder(DWebView.this.getContext()).setTitle(str2).setView(editText).setCancelable(false).setPositiveButton(17039370, onClickListener).setNegativeButton(17039360, onClickListener).show();
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                        int i = (int) (16.0f * f);
                        layoutParams.setMargins(i, 0, i, 0);
                        layoutParams.gravity = 1;
                        editText.setLayoutParams(layoutParams);
                        int i2 = (int) (15.0f * f);
                        editText.setPadding(i2 - ((int) (f * 5.0f)), i2, i2, i2);
                        return true;
                    }
                    return true;
                }
                jsPromptResult.confirm(DWebView.this.f5917j.call(str2.substring(10), str3));
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
                if (DWebView.this.f5913f != null) {
                    return DWebView.this.f5913f.onJsBeforeUnload(webView, str, str2, jsResult);
                }
                return super.onJsBeforeUnload(webView, str, str2, jsResult);
            }

            @Override // android.webkit.WebChromeClient
            public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
                } else {
                    super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
                }
                super.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
            }

            @Override // android.webkit.WebChromeClient
            public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.onGeolocationPermissionsShowPrompt(str, callback);
                } else {
                    super.onGeolocationPermissionsShowPrompt(str, callback);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onGeolocationPermissionsHidePrompt() {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.onGeolocationPermissionsHidePrompt();
                } else {
                    super.onGeolocationPermissionsHidePrompt();
                }
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(21)
            public void onPermissionRequest(PermissionRequest permissionRequest) {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.onPermissionRequest(permissionRequest);
                } else {
                    super.onPermissionRequest(permissionRequest);
                }
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(21)
            public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.onPermissionRequestCanceled(permissionRequest);
                } else {
                    super.onPermissionRequestCanceled(permissionRequest);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsTimeout() {
                if (DWebView.this.f5913f != null) {
                    return DWebView.this.f5913f.onJsTimeout();
                }
                return super.onJsTimeout();
            }

            @Override // android.webkit.WebChromeClient
            public void onConsoleMessage(String str, int i, String str2) {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.onConsoleMessage(str, i, str2);
                } else {
                    super.onConsoleMessage(str, i, str2);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                if (DWebView.this.f5913f != null) {
                    return DWebView.this.f5913f.onConsoleMessage(consoleMessage);
                }
                return super.onConsoleMessage(consoleMessage);
            }

            @Override // android.webkit.WebChromeClient
            public Bitmap getDefaultVideoPoster() {
                if (DWebView.this.f5913f != null) {
                    return DWebView.this.f5913f.getDefaultVideoPoster();
                }
                return super.getDefaultVideoPoster();
            }

            @Override // android.webkit.WebChromeClient
            public View getVideoLoadingProgressView() {
                if (DWebView.this.f5913f != null) {
                    return DWebView.this.f5913f.getVideoLoadingProgressView();
                }
                return super.getVideoLoadingProgressView();
            }

            @Override // android.webkit.WebChromeClient
            public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.getVisitedHistory(valueCallback);
                } else {
                    super.getVisitedHistory(valueCallback);
                }
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(21)
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                if (DWebView.this.f5913f != null) {
                    return DWebView.this.f5913f.onShowFileChooser(webView, valueCallback, fileChooserParams);
                }
                return super.onShowFileChooser(webView, valueCallback, fileChooserParams);
            }

            @Keep
            @TargetApi(11)
            public void openFileChooser(ValueCallback valueCallback, String str) {
                if (DWebView.this.f5913f instanceof InterfaceC2004b) {
                    ((InterfaceC2004b) DWebView.this.f5913f).m6783a(valueCallback, str);
                }
            }

            @Keep
            @TargetApi(16)
            public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
                if (DWebView.this.f5913f instanceof InterfaceC2004b) {
                    ((InterfaceC2004b) DWebView.this.f5913f).m6782a(valueCallback, str, str2);
                }
            }
        };
        m6796b();
    }

    public DWebView(Context context) {
        super(context);
        this.f5910c = new HashMap();
        this.f5912e = 0;
        this.f5914g = true;
        this.f5915h = null;
        this.f5917j = new InnerJavascriptInterface();
        this.f5918k = new Handler(Looper.getMainLooper());
        this.f5909a = new HashMap();
        this.f5919l = new WebChromeClient() { // from class: com.navatics.dsbridge.DWebView.6
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.onProgressChanged(webView, i);
                } else {
                    super.onProgressChanged(webView, i);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.onReceivedTitle(webView, str);
                } else {
                    super.onReceivedTitle(webView, str);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedIcon(WebView webView, Bitmap bitmap) {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.onReceivedIcon(webView, bitmap);
                } else {
                    super.onReceivedIcon(webView, bitmap);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.onReceivedTouchIconUrl(webView, str, z);
                } else {
                    super.onReceivedTouchIconUrl(webView, str, z);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.onShowCustomView(view, customViewCallback);
                } else {
                    super.onShowCustomView(view, customViewCallback);
                }
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(14)
            public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.onShowCustomView(view, i, customViewCallback);
                } else {
                    super.onShowCustomView(view, i, customViewCallback);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onHideCustomView() {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.onHideCustomView();
                } else {
                    super.onHideCustomView();
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
                if (DWebView.this.f5913f != null) {
                    return DWebView.this.f5913f.onCreateWindow(webView, z, z2, message);
                }
                return super.onCreateWindow(webView, z, z2, message);
            }

            @Override // android.webkit.WebChromeClient
            public void onRequestFocus(WebView webView) {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.onRequestFocus(webView);
                } else {
                    super.onRequestFocus(webView);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onCloseWindow(WebView webView) {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.onCloseWindow(webView);
                } else {
                    super.onCloseWindow(webView);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
                if (!DWebView.this.f5914g) {
                    jsResult.confirm();
                }
                if (DWebView.this.f5913f == null || !DWebView.this.f5913f.onJsAlert(webView, str, str2, jsResult)) {
                    new AlertDialog.Builder(DWebView.this.getContext()).setMessage(str2).setCancelable(false).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.navatics.dsbridge.DWebView.6.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            if (DWebView.this.f5914g) {
                                jsResult.confirm();
                            }
                        }
                    }).create().show();
                    return true;
                }
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsConfirm(WebView webView, String str, String str2, final JsResult jsResult) {
                if (!DWebView.this.f5914g) {
                    jsResult.confirm();
                }
                if (DWebView.this.f5913f == null || !DWebView.this.f5913f.onJsConfirm(webView, str, str2, jsResult)) {
                    DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.navatics.dsbridge.DWebView.6.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (DWebView.this.f5914g) {
                                if (i == -1) {
                                    jsResult.confirm();
                                } else {
                                    jsResult.cancel();
                                }
                            }
                        }
                    };
                    new AlertDialog.Builder(DWebView.this.getContext()).setMessage(str2).setCancelable(false).setPositiveButton(17039370, onClickListener).setNegativeButton(17039360, onClickListener).show();
                    return true;
                }
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView webView, String str, String str2, String str3, final JsPromptResult jsPromptResult) {
                if (Build.VERSION.SDK_INT > 16 || !str2.startsWith("_dsbridge=")) {
                    if (!DWebView.this.f5914g) {
                        jsPromptResult.confirm();
                    }
                    if (DWebView.this.f5913f == null || !DWebView.this.f5913f.onJsPrompt(webView, str, str2, str3, jsPromptResult)) {
                        final EditText editText = new EditText(DWebView.this.getContext());
                        editText.setText(str3);
                        if (str3 != null) {
                            editText.setSelection(str3.length());
                        }
                        float f = DWebView.this.getContext().getResources().getDisplayMetrics().density;
                        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.navatics.dsbridge.DWebView.6.3
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (DWebView.this.f5914g) {
                                    if (i == -1) {
                                        jsPromptResult.confirm(editText.getText().toString());
                                    } else {
                                        jsPromptResult.cancel();
                                    }
                                }
                            }
                        };
                        new AlertDialog.Builder(DWebView.this.getContext()).setTitle(str2).setView(editText).setCancelable(false).setPositiveButton(17039370, onClickListener).setNegativeButton(17039360, onClickListener).show();
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                        int i = (int) (16.0f * f);
                        layoutParams.setMargins(i, 0, i, 0);
                        layoutParams.gravity = 1;
                        editText.setLayoutParams(layoutParams);
                        int i2 = (int) (15.0f * f);
                        editText.setPadding(i2 - ((int) (f * 5.0f)), i2, i2, i2);
                        return true;
                    }
                    return true;
                }
                jsPromptResult.confirm(DWebView.this.f5917j.call(str2.substring(10), str3));
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
                if (DWebView.this.f5913f != null) {
                    return DWebView.this.f5913f.onJsBeforeUnload(webView, str, str2, jsResult);
                }
                return super.onJsBeforeUnload(webView, str, str2, jsResult);
            }

            @Override // android.webkit.WebChromeClient
            public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
                } else {
                    super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
                }
                super.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
            }

            @Override // android.webkit.WebChromeClient
            public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.onGeolocationPermissionsShowPrompt(str, callback);
                } else {
                    super.onGeolocationPermissionsShowPrompt(str, callback);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onGeolocationPermissionsHidePrompt() {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.onGeolocationPermissionsHidePrompt();
                } else {
                    super.onGeolocationPermissionsHidePrompt();
                }
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(21)
            public void onPermissionRequest(PermissionRequest permissionRequest) {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.onPermissionRequest(permissionRequest);
                } else {
                    super.onPermissionRequest(permissionRequest);
                }
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(21)
            public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.onPermissionRequestCanceled(permissionRequest);
                } else {
                    super.onPermissionRequestCanceled(permissionRequest);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsTimeout() {
                if (DWebView.this.f5913f != null) {
                    return DWebView.this.f5913f.onJsTimeout();
                }
                return super.onJsTimeout();
            }

            @Override // android.webkit.WebChromeClient
            public void onConsoleMessage(String str, int i, String str2) {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.onConsoleMessage(str, i, str2);
                } else {
                    super.onConsoleMessage(str, i, str2);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                if (DWebView.this.f5913f != null) {
                    return DWebView.this.f5913f.onConsoleMessage(consoleMessage);
                }
                return super.onConsoleMessage(consoleMessage);
            }

            @Override // android.webkit.WebChromeClient
            public Bitmap getDefaultVideoPoster() {
                if (DWebView.this.f5913f != null) {
                    return DWebView.this.f5913f.getDefaultVideoPoster();
                }
                return super.getDefaultVideoPoster();
            }

            @Override // android.webkit.WebChromeClient
            public View getVideoLoadingProgressView() {
                if (DWebView.this.f5913f != null) {
                    return DWebView.this.f5913f.getVideoLoadingProgressView();
                }
                return super.getVideoLoadingProgressView();
            }

            @Override // android.webkit.WebChromeClient
            public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
                if (DWebView.this.f5913f != null) {
                    DWebView.this.f5913f.getVisitedHistory(valueCallback);
                } else {
                    super.getVisitedHistory(valueCallback);
                }
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(21)
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                if (DWebView.this.f5913f != null) {
                    return DWebView.this.f5913f.onShowFileChooser(webView, valueCallback, fileChooserParams);
                }
                return super.onShowFileChooser(webView, valueCallback, fileChooserParams);
            }

            @Keep
            @TargetApi(11)
            public void openFileChooser(ValueCallback valueCallback, String str) {
                if (DWebView.this.f5913f instanceof InterfaceC2004b) {
                    ((InterfaceC2004b) DWebView.this.f5913f).m6783a(valueCallback, str);
                }
            }

            @Keep
            @TargetApi(16)
            public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
                if (DWebView.this.f5913f instanceof InterfaceC2004b) {
                    ((InterfaceC2004b) DWebView.this.f5913f).m6782a(valueCallback, str, str2);
                }
            }
        };
        m6796b();
    }

    public static void setWebContentsDebuggingEnabled(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(z);
        }
        f5908b = z;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    /* renamed from: b */
    private void m6796b() {
        this.f5911d = getContext().getFilesDir().getAbsolutePath() + "/webcache";
        WebSettings settings = getSettings();
        settings.setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
            settings.setMixedContentMode(0);
        }
        settings.setAllowFileAccess(false);
        settings.setAppCacheEnabled(false);
        settings.setCacheMode(2);
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setAppCachePath(this.f5911d);
        settings.setUseWideViewPort(true);
        super.setWebChromeClient(this.f5919l);
        addInternalJavascriptObject();
        if (Build.VERSION.SDK_INT > 16) {
            super.addJavascriptInterface(this.f5917j, "_dsbridge");
            return;
        }
        settings.setUserAgentString(settings.getUserAgentString() + " _dsbridge");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public String[] m6793b(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        String str2 = "";
        if (lastIndexOf != -1) {
            str2 = str.substring(0, lastIndexOf);
            str = str.substring(lastIndexOf + 1);
        }
        return new String[]{str2, str};
    }

    @Keep
    private void addInternalJavascriptObject() {
        m6800a(new Object() { // from class: com.navatics.dsbridge.DWebView.1
            @Keep
            @JavascriptInterface
            public boolean hasNativeMethod(Object obj) throws JSONException {
                boolean z;
                JSONObject jSONObject = (JSONObject) obj;
                String trim = jSONObject.getString("name").trim();
                String trim2 = jSONObject.getString(IjkMediaMeta.IJKM_KEY_TYPE).trim();
                String[] m6793b = DWebView.this.m6793b(trim);
                Object obj2 = DWebView.this.f5910c.get(m6793b[0]);
                if (obj2 != null) {
                    Class<?> cls = obj2.getClass();
                    Method method = null;
                    try {
                        try {
                            method = cls.getMethod(m6793b[1], Object.class, CompletionHandler.class);
                            z = true;
                        } catch (Exception unused) {
                            z = false;
                        }
                    } catch (Exception unused2) {
                        method = cls.getMethod(m6793b[1], Object.class);
                        z = false;
                    }
                    if (method == null || (Build.VERSION.SDK_INT >= 17 && ((JavascriptInterface) method.getAnnotation(JavascriptInterface.class)) == null)) {
                        return false;
                    }
                    if ("all".equals(trim2) || ((z && "asyn".equals(trim2)) || (!z && "syn".equals(trim2)))) {
                        return true;
                    }
                }
                return false;
            }

            @Keep
            @JavascriptInterface
            public String closePage(Object obj) throws JSONException {
                DWebView.this.m6799a(new Runnable() { // from class: com.navatics.dsbridge.DWebView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (DWebView.this.f5915h == null || DWebView.this.f5915h.m6781a()) {
                            Context context = DWebView.this.getContext();
                            if (context instanceof Activity) {
                                ((Activity) context).onBackPressed();
                            }
                        }
                    }
                });
                return null;
            }

            @Keep
            @JavascriptInterface
            public void disableJavascriptDialogBlock(Object obj) throws JSONException {
                DWebView.this.f5914g = !((JSONObject) obj).getBoolean("disable");
            }

            @Keep
            @JavascriptInterface
            public void dsinit(Object obj) {
                DWebView.this.m6792c();
            }

            @Keep
            @JavascriptInterface
            public void returnValue(final Object obj) {
                DWebView.this.m6799a(new Runnable() { // from class: com.navatics.dsbridge.DWebView.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        JSONObject jSONObject = (JSONObject) obj;
                        try {
                            int i = jSONObject.getInt("id");
                            boolean z = jSONObject.getBoolean("complete");
                            OnReturnValue onReturnValue = DWebView.this.f5909a.get(Integer.valueOf(i));
                            Object obj2 = jSONObject.has("data") ? jSONObject.get("data") : null;
                            if (onReturnValue != null) {
                                onReturnValue.m6780a(obj2);
                                if (z) {
                                    DWebView.this.f5909a.remove(Integer.valueOf(i));
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }, "_dsb");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m6789c(String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            super.evaluateJavascript(str, null);
            return;
        }
        super.loadUrl("javascript:" + str);
    }

    /* renamed from: a */
    public void m6798a(final String str) {
        m6799a(new Runnable() { // from class: com.navatics.dsbridge.DWebView.2
            @Override // java.lang.Runnable
            public void run() {
                DWebView.this.m6789c(str);
            }
        });
    }

    @Override // android.webkit.WebView
    public void loadUrl(final String str) {
        m6799a(new Runnable() { // from class: com.navatics.dsbridge.DWebView.3
            @Override // java.lang.Runnable
            public void run() {
                DWebView.this.f5916i = new ArrayList();
                DWebView.super.loadUrl(str);
            }
        });
    }

    @Override // android.webkit.WebView
    public void loadUrl(final String str, final Map<String, String> map) {
        m6799a(new Runnable() { // from class: com.navatics.dsbridge.DWebView.4
            @Override // java.lang.Runnable
            public void run() {
                DWebView.this.f5916i = new ArrayList();
                DWebView.super.loadUrl(str, map);
            }
        });
    }

    @Override // android.webkit.WebView
    public void reload() {
        m6799a(new Runnable() { // from class: com.navatics.dsbridge.DWebView.5
            @Override // java.lang.Runnable
            public void run() {
                DWebView.this.f5916i = new ArrayList();
                DWebView.super.reload();
            }
        });
    }

    public void setJavascriptCloseWindowListener(InterfaceC2005c interfaceC2005c) {
        this.f5915h = interfaceC2005c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.navatics.dsbridge.DWebView$a */
    /* loaded from: classes.dex */
    public static class C2003a {

        /* renamed from: a */
        private String f5943a;

        /* renamed from: b */
        private int f5944b;

        /* renamed from: c */
        private String f5945c;

        C2003a(String str, int i, Object[] objArr) {
            this.f5943a = new JSONArray((Collection) Arrays.asList(objArr == null ? new Object[0] : objArr)).toString();
            this.f5944b = i;
            this.f5945c = str;
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", this.f5945c);
                jSONObject.put("callbackId", this.f5944b);
                jSONObject.put("data", this.f5943a);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public synchronized void m6792c() {
        if (this.f5916i != null) {
            Iterator<C2003a> it = this.f5916i.iterator();
            while (it.hasNext()) {
                m6809a(it.next());
            }
            this.f5916i = null;
        }
    }

    /* renamed from: a */
    private void m6809a(C2003a c2003a) {
        m6798a(String.format("window._handleMessageFromNative(%s)", c2003a.toString()));
    }

    /* renamed from: a */
    public synchronized <T> void m6797a(String str, Object[] objArr, OnReturnValue<T> onReturnValue) {
        C2003a c2003a = new C2003a(str, this.f5912e, objArr);
        if (onReturnValue != null) {
            Map<Integer, OnReturnValue> map = this.f5909a;
            int i = this.f5912e;
            this.f5912e = i + 1;
            map.put(Integer.valueOf(i), onReturnValue);
        }
        if (this.f5916i != null) {
            this.f5916i.add(c2003a);
        } else {
            m6809a(c2003a);
        }
    }

    /* renamed from: a */
    public void m6800a(Object obj, String str) {
        if (str == null) {
            str = "";
        }
        if (obj != null) {
            this.f5910c.put(str, obj);
        }
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.f5913f = webChromeClient;
    }

    @Override // android.webkit.WebView
    public void clearCache(boolean z) {
        super.clearCache(z);
        CookieManager.getInstance().removeAllCookie();
        Context context = getContext();
        try {
            context.deleteDatabase("webview.db");
            context.deleteDatabase("webviewCache.db");
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(this.f5911d);
        File file2 = new File(context.getCacheDir().getAbsolutePath() + "/webviewCache");
        if (file2.exists()) {
            m6801a(file2);
        }
        if (file.exists()) {
            m6801a(file);
        }
    }

    /* renamed from: a */
    public void m6801a(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    m6801a(file2);
                }
            }
            file.delete();
            return;
        }
        Log.e("Webview", "delete file no exists " + file.getAbsolutePath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6799a(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.f5918k.post(runnable);
        }
    }
}
