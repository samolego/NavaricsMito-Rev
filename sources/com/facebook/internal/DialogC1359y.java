package com.facebook.internal;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.AccessToken;
import com.facebook.FacebookDialogException;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.common.R;
import com.facebook.share.internal.ShareInternalUtility;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* renamed from: com.facebook.internal.y */
/* loaded from: classes.dex */
public class WebDialog extends Dialog {

    /* renamed from: a */
    private static final int f2070a = R.style.com_facebook_activity_theme;

    /* renamed from: m */
    private static volatile int f2071m;

    /* renamed from: b */
    private String f2072b;

    /* renamed from: c */
    private String f2073c;

    /* renamed from: d */
    private InterfaceC0993c f2074d;

    /* renamed from: e */
    private WebView f2075e;

    /* renamed from: f */
    private ProgressDialog f2076f;

    /* renamed from: g */
    private ImageView f2077g;

    /* renamed from: h */
    private FrameLayout f2078h;

    /* renamed from: i */
    private AsyncTaskC0994d f2079i;

    /* renamed from: j */
    private boolean f2080j;

    /* renamed from: k */
    private boolean f2081k;

    /* renamed from: l */
    private boolean f2082l;

    /* renamed from: n */
    private WindowManager.LayoutParams f2083n;

    /* compiled from: WebDialog.java */
    /* renamed from: com.facebook.internal.y$c */
    /* loaded from: classes.dex */
    public interface InterfaceC0993c {
        /* renamed from: a */
        void mo10250a(Bundle bundle, FacebookException facebookException);
    }

    /* renamed from: a */
    private int m10456a(int i, float f, int i2, int i3) {
        int i4 = (int) (i / f);
        double d = 0.5d;
        if (i4 <= i2) {
            d = 1.0d;
        } else if (i4 < i3) {
            d = 0.5d + (((i3 - i4) / (i3 - i2)) * 0.5d);
        }
        return (int) (i * d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static void m10455a(Context context) {
        if (context == null) {
            return;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null || f2071m != 0) {
                return;
            }
            m10457a(applicationInfo.metaData.getInt("com.facebook.sdk.WebDialogTheme"));
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    /* renamed from: a */
    public static WebDialog m10454a(Context context, String str, Bundle bundle, int i, InterfaceC0993c interfaceC0993c) {
        m10455a(context);
        return new WebDialog(context, str, bundle, i, interfaceC0993c);
    }

    /* renamed from: a */
    public static int m10458a() {
        Validate.m10472a();
        return f2071m;
    }

    /* renamed from: a */
    public static void m10457a(int i) {
        if (i == 0) {
            i = f2070a;
        }
        f2071m = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WebDialog(Context context, String str) {
        this(context, str, m10458a());
    }

    private WebDialog(Context context, String str, int i) {
        super(context, i == 0 ? m10458a() : i);
        this.f2073c = "fbconnect://success";
        this.f2080j = false;
        this.f2081k = false;
        this.f2082l = false;
        this.f2072b = str;
    }

    private WebDialog(Context context, String str, Bundle bundle, int i, InterfaceC0993c interfaceC0993c) {
        super(context, i == 0 ? m10458a() : i);
        this.f2073c = "fbconnect://success";
        this.f2080j = false;
        this.f2081k = false;
        this.f2082l = false;
        bundle = bundle == null ? new Bundle() : bundle;
        this.f2073c = Utility.m10484f(context) ? "fbconnect://chrome_os_success" : "fbconnect://success";
        bundle.putString("redirect_uri", this.f2073c);
        bundle.putString("display", "touch");
        bundle.putString("client_id", FacebookSdk.m10865l());
        bundle.putString("sdk", String.format(Locale.ROOT, "android-%s", FacebookSdk.m10867j()));
        this.f2074d = interfaceC0993c;
        if (str.equals("share") && bundle.containsKey("media")) {
            this.f2079i = new AsyncTaskC0994d(str, bundle);
            return;
        }
        String m10556a = ServerProtocol.m10556a();
        this.f2072b = Utility.m10526a(m10556a, FacebookSdk.m10868i() + "/dialog/" + str, bundle).toString();
    }

    public void setOnCompleteListener(InterfaceC0993c interfaceC0993c) {
        this.f2074d = interfaceC0993c;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cancel();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        ProgressDialog progressDialog;
        WebView webView = this.f2075e;
        if (webView != null) {
            webView.stopLoading();
        }
        if (!this.f2081k && (progressDialog = this.f2076f) != null && progressDialog.isShowing()) {
            this.f2076f.dismiss();
        }
        super.dismiss();
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        AsyncTaskC0994d asyncTaskC0994d = this.f2079i;
        if (asyncTaskC0994d != null && asyncTaskC0994d.getStatus() == AsyncTask.Status.PENDING) {
            this.f2079i.execute(new Void[0]);
            this.f2076f.show();
            return;
        }
        m10438e();
    }

    @Override // android.app.Dialog
    protected void onStop() {
        AsyncTaskC0994d asyncTaskC0994d = this.f2079i;
        if (asyncTaskC0994d != null) {
            asyncTaskC0994d.cancel(true);
            this.f2076f.dismiss();
        }
        super.onStop();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f2081k = true;
        super.onDetachedFromWindow();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        WindowManager.LayoutParams layoutParams;
        this.f2081k = false;
        if (Utility.m10492d(getContext()) && (layoutParams = this.f2083n) != null && layoutParams.token == null) {
            this.f2083n.token = getOwnerActivity().getWindow().getAttributes().token;
            Utility.m10505b("FacebookSDK.WebDialog", "Set token on onAttachedToWindow(): " + this.f2083n.token);
        }
        super.onAttachedToWindow();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        if (layoutParams.token == null) {
            this.f2083n = layoutParams;
        }
        super.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2076f = new ProgressDialog(getContext());
        this.f2076f.requestWindowFeature(1);
        this.f2076f.setMessage(getContext().getString(R.string.com_facebook_loading));
        this.f2076f.setCanceledOnTouchOutside(false);
        this.f2076f.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.facebook.internal.y.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WebDialog.this.cancel();
            }
        });
        requestWindowFeature(1);
        this.f2078h = new FrameLayout(getContext());
        m10438e();
        getWindow().setGravity(17);
        getWindow().setSoftInputMode(16);
        m10436f();
        if (this.f2072b != null) {
            m10445b((this.f2077g.getDrawable().getIntrinsicWidth() / 2) + 1);
        }
        this.f2078h.addView(this.f2077g, new ViewGroup.LayoutParams(-2, -2));
        setContentView(this.f2078h);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void m10443b(String str) {
        this.f2073c = str;
    }

    /* renamed from: a */
    protected Bundle mo10448a(String str) {
        Uri parse = Uri.parse(str);
        Bundle m10490d = Utility.m10490d(parse.getQuery());
        m10490d.putAll(Utility.m10490d(parse.getFragment()));
        return m10490d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public boolean m10446b() {
        return this.f2080j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public boolean m10442c() {
        return this.f2082l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public WebView m10440d() {
        return this.f2075e;
    }

    /* renamed from: e */
    public void m10438e() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        getWindow().setLayout(Math.min(m10456a(displayMetrics.widthPixels < displayMetrics.heightPixels ? displayMetrics.widthPixels : displayMetrics.heightPixels, displayMetrics.density, 480, 800), displayMetrics.widthPixels), Math.min(m10456a(displayMetrics.widthPixels < displayMetrics.heightPixels ? displayMetrics.heightPixels : displayMetrics.widthPixels, displayMetrics.density, 800, 1280), displayMetrics.heightPixels));
    }

    /* renamed from: a */
    protected void m10453a(Bundle bundle) {
        InterfaceC0993c interfaceC0993c = this.f2074d;
        if (interfaceC0993c == null || this.f2080j) {
            return;
        }
        this.f2080j = true;
        interfaceC0993c.mo10250a(bundle, null);
        dismiss();
    }

    /* renamed from: a */
    protected void m10447a(Throwable th) {
        FacebookException facebookException;
        if (this.f2074d == null || this.f2080j) {
            return;
        }
        this.f2080j = true;
        if (th instanceof FacebookException) {
            facebookException = (FacebookException) th;
        } else {
            facebookException = new FacebookException(th);
        }
        this.f2074d.mo10250a(null, facebookException);
        dismiss();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        if (this.f2074d == null || this.f2080j) {
            return;
        }
        m10447a(new FacebookOperationCanceledException());
    }

    /* renamed from: f */
    private void m10436f() {
        this.f2077g = new ImageView(getContext());
        this.f2077g.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.internal.y.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WebDialog.this.cancel();
            }
        });
        this.f2077g.setImageDrawable(getContext().getResources().getDrawable(R.drawable.com_facebook_close));
        this.f2077g.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: b */
    public void m10445b(int i) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f2075e = new WebView(getContext()) { // from class: com.facebook.internal.y.3
            @Override // android.webkit.WebView, android.view.View
            public void onWindowFocusChanged(boolean z) {
                try {
                    super.onWindowFocusChanged(z);
                } catch (NullPointerException unused) {
                }
            }
        };
        this.f2075e.setVerticalScrollBarEnabled(false);
        this.f2075e.setHorizontalScrollBarEnabled(false);
        this.f2075e.setWebViewClient(new C0992b());
        this.f2075e.getSettings().setJavaScriptEnabled(true);
        this.f2075e.loadUrl(this.f2072b);
        this.f2075e.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f2075e.setVisibility(4);
        this.f2075e.getSettings().setSavePassword(false);
        this.f2075e.getSettings().setSaveFormData(false);
        this.f2075e.setFocusable(true);
        this.f2075e.setFocusableInTouchMode(true);
        this.f2075e.setOnTouchListener(new View.OnTouchListener() { // from class: com.facebook.internal.y.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.hasFocus()) {
                    return false;
                }
                view.requestFocus();
                return false;
            }
        });
        linearLayout.setPadding(i, i, i, i);
        linearLayout.addView(this.f2075e);
        linearLayout.setBackgroundColor(-872415232);
        this.f2078h.addView(linearLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WebDialog.java */
    /* renamed from: com.facebook.internal.y$b */
    /* loaded from: classes.dex */
    public class C0992b extends WebViewClient {
        private C0992b() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            int i;
            Utility.m10505b("FacebookSDK.WebDialog", "Redirect URL: " + str);
            if (str.startsWith(WebDialog.this.f2073c)) {
                Bundle mo10448a = WebDialog.this.mo10448a(str);
                String string = mo10448a.getString(IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR);
                if (string == null) {
                    string = mo10448a.getString("error_type");
                }
                String string2 = mo10448a.getString("error_msg");
                if (string2 == null) {
                    string2 = mo10448a.getString("error_message");
                }
                if (string2 == null) {
                    string2 = mo10448a.getString("error_description");
                }
                String string3 = mo10448a.getString("error_code");
                if (Utility.m10530a(string3)) {
                    i = -1;
                } else {
                    try {
                        i = Integer.parseInt(string3);
                    } catch (NumberFormatException unused) {
                        i = -1;
                    }
                }
                if (Utility.m10530a(string) && Utility.m10530a(string2) && i == -1) {
                    WebDialog.this.m10453a(mo10448a);
                } else if (string != null && (string.equals("access_denied") || string.equals("OAuthAccessDeniedException"))) {
                    WebDialog.this.cancel();
                } else if (i == 4201) {
                    WebDialog.this.cancel();
                } else {
                    WebDialog.this.m10447a(new FacebookServiceException(new FacebookRequestError(i, string, string2), string2));
                }
                return true;
            } else if (str.startsWith("fbconnect://cancel")) {
                WebDialog.this.cancel();
                return true;
            } else if (str.contains("touch")) {
                return false;
            } else {
                try {
                    WebDialog.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return true;
                } catch (ActivityNotFoundException unused2) {
                    return false;
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            WebDialog.this.m10447a(new FacebookDialogException(str, i, str2));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            sslErrorHandler.cancel();
            WebDialog.this.m10447a(new FacebookDialogException(null, -11, null));
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Utility.m10505b("FacebookSDK.WebDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
            if (WebDialog.this.f2081k) {
                return;
            }
            WebDialog.this.f2076f.show();
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (!WebDialog.this.f2081k) {
                WebDialog.this.f2076f.dismiss();
            }
            WebDialog.this.f2078h.setBackgroundColor(0);
            WebDialog.this.f2075e.setVisibility(0);
            WebDialog.this.f2077g.setVisibility(0);
            WebDialog.this.f2082l = true;
        }
    }

    /* compiled from: WebDialog.java */
    /* renamed from: com.facebook.internal.y$a */
    /* loaded from: classes.dex */
    public static class C0991a {

        /* renamed from: a */
        private Context f2088a;

        /* renamed from: b */
        private String f2089b;

        /* renamed from: c */
        private String f2090c;

        /* renamed from: d */
        private int f2091d;

        /* renamed from: e */
        private InterfaceC0993c f2092e;

        /* renamed from: f */
        private Bundle f2093f;

        /* renamed from: g */
        private AccessToken f2094g;

        public C0991a(Context context, String str, Bundle bundle) {
            this.f2094g = AccessToken.m11457a();
            if (!AccessToken.m11451b()) {
                String m10548a = Utility.m10548a(context);
                if (m10548a != null) {
                    this.f2089b = m10548a;
                } else {
                    throw new FacebookException("Attempted to create a builder without a valid access token or a valid default Application ID.");
                }
            }
            m10434a(context, str, bundle);
        }

        public C0991a(Context context, String str, String str2, Bundle bundle) {
            str = str == null ? Utility.m10548a(context) : str;
            Validate.m10468a(str, "applicationId");
            this.f2089b = str;
            m10434a(context, str2, bundle);
        }

        /* renamed from: a */
        public C0991a m10433a(InterfaceC0993c interfaceC0993c) {
            this.f2092e = interfaceC0993c;
            return this;
        }

        /* renamed from: a */
        public WebDialog mo10247a() {
            AccessToken accessToken = this.f2094g;
            if (accessToken != null) {
                this.f2093f.putString("app_id", accessToken.m11440l());
                this.f2093f.putString("access_token", this.f2094g.m11448d());
            } else {
                this.f2093f.putString("app_id", this.f2089b);
            }
            return WebDialog.m10454a(this.f2088a, this.f2090c, this.f2093f, this.f2091d, this.f2092e);
        }

        /* renamed from: b */
        public String m10432b() {
            return this.f2089b;
        }

        /* renamed from: c */
        public Context m10431c() {
            return this.f2088a;
        }

        /* renamed from: d */
        public int m10430d() {
            return this.f2091d;
        }

        /* renamed from: e */
        public Bundle m10429e() {
            return this.f2093f;
        }

        /* renamed from: f */
        public InterfaceC0993c m10428f() {
            return this.f2092e;
        }

        /* renamed from: a */
        private void m10434a(Context context, String str, Bundle bundle) {
            this.f2088a = context;
            this.f2090c = str;
            if (bundle != null) {
                this.f2093f = bundle;
            } else {
                this.f2093f = new Bundle();
            }
        }
    }

    /* compiled from: WebDialog.java */
    /* renamed from: com.facebook.internal.y$d */
    /* loaded from: classes.dex */
    private class AsyncTaskC0994d extends AsyncTask<Void, Void, String[]> {

        /* renamed from: b */
        private String f2097b;

        /* renamed from: c */
        private Bundle f2098c;

        /* renamed from: d */
        private Exception[] f2099d;

        AsyncTaskC0994d(String str, Bundle bundle) {
            this.f2097b = str;
            this.f2098c = bundle;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String[] doInBackground(Void... voidArr) {
            String[] stringArray = this.f2098c.getStringArray("media");
            final String[] strArr = new String[stringArray.length];
            this.f2099d = new Exception[stringArray.length];
            final CountDownLatch countDownLatch = new CountDownLatch(stringArray.length);
            ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
            AccessToken m11457a = AccessToken.m11457a();
            for (final int i = 0; i < stringArray.length; i++) {
                try {
                    if (isCancelled()) {
                        Iterator it = concurrentLinkedQueue.iterator();
                        while (it.hasNext()) {
                            ((AsyncTask) it.next()).cancel(true);
                        }
                        return null;
                    }
                    Uri parse = Uri.parse(stringArray[i]);
                    if (Utility.m10507b(parse)) {
                        strArr[i] = parse.toString();
                        countDownLatch.countDown();
                    } else {
                        concurrentLinkedQueue.add(ShareInternalUtility.m9954a(m11457a, parse, new GraphRequest.InterfaceC0829b() { // from class: com.facebook.internal.y.d.1
                            @Override // com.facebook.GraphRequest.InterfaceC0829b
                            /* renamed from: a */
                            public void mo10080a(GraphResponse graphResponse) {
                                FacebookRequestError m10831a;
                                try {
                                    m10831a = graphResponse.m10831a();
                                } catch (Exception e) {
                                    AsyncTaskC0994d.this.f2099d[i] = e;
                                }
                                if (m10831a != null) {
                                    String m11405e = m10831a.m11405e();
                                    if (m11405e == null) {
                                        m11405e = "Error staging photo.";
                                    }
                                    throw new FacebookGraphResponseException(graphResponse, m11405e);
                                }
                                JSONObject m10824b = graphResponse.m10824b();
                                if (m10824b == null) {
                                    throw new FacebookException("Error staging photo.");
                                }
                                String optString = m10824b.optString("uri");
                                if (optString == null) {
                                    throw new FacebookException("Error staging photo.");
                                }
                                strArr[i] = optString;
                                countDownLatch.countDown();
                            }
                        }).m11348j());
                    }
                } catch (Exception unused) {
                    Iterator it2 = concurrentLinkedQueue.iterator();
                    while (it2.hasNext()) {
                        ((AsyncTask) it2.next()).cancel(true);
                    }
                    return null;
                }
            }
            countDownLatch.await();
            return strArr;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String[] strArr) {
            Exception[] excArr;
            WebDialog.this.f2076f.dismiss();
            for (Exception exc : this.f2099d) {
                if (exc != null) {
                    WebDialog.this.m10447a(exc);
                    return;
                }
            }
            if (strArr == null) {
                WebDialog.this.m10447a(new FacebookException("Failed to stage photos for web dialog"));
                return;
            }
            List asList = Arrays.asList(strArr);
            if (asList.contains(null)) {
                WebDialog.this.m10447a(new FacebookException("Failed to stage photos for web dialog"));
                return;
            }
            Utility.m10544a(this.f2098c, "media", new JSONArray((Collection) asList));
            WebDialog.this.f2072b = Utility.m10526a(ServerProtocol.m10556a(), FacebookSdk.m10868i() + "/dialog/" + this.f2097b, this.f2098c).toString();
            WebDialog.this.m10445b((WebDialog.this.f2077g.getDrawable().getIntrinsicWidth() / 2) + 1);
        }
    }
}
