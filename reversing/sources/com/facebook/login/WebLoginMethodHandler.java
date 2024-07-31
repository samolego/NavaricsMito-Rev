package com.facebook.login;

import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class WebLoginMethodHandler extends LoginMethodHandler {

    /* renamed from: c */
    private String f2206c;

    /* renamed from: c */
    protected String mo10260c() {
        return null;
    }

    /* renamed from: c_ */
    abstract AccessTokenSource mo10252c_();

    /* renamed from: d */
    private static final String m10259d() {
        return "fb" + FacebookSdk.m10865l() + "://authorize";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public Bundle m10261b(LoginClient.Request request) {
        Bundle bundle = new Bundle();
        if (!Utility.m10520a(request.m10305a())) {
            String join = TextUtils.join(",", request.m10305a());
            bundle.putString("scope", join);
            m10274a("scope", join);
        }
        bundle.putString("default_audience", request.m10302c().getNativeProtocolAudience());
        bundle.putString("state", m10275a(request.m10300e()));
        AccessToken m11457a = AccessToken.m11457a();
        String m11448d = m11457a != null ? m11457a.m11448d() : null;
        if (m11448d != null && m11448d.equals(m10257f())) {
            bundle.putString("access_token", m11448d);
            m10274a("access_token", "1");
        } else {
            Utility.m10508b(this.f2205b.m10326b());
            m10274a("access_token", "0");
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public Bundle m10263a(Bundle bundle, LoginClient.Request request) {
        bundle.putString("redirect_uri", m10259d());
        bundle.putString("client_id", request.m10301d());
        LoginClient loginClient = this.f2205b;
        bundle.putString("e2e", LoginClient.m10310m());
        bundle.putString("response_type", "token,signed_request");
        bundle.putString("return_scopes", "true");
        bundle.putString("auth_type", request.m10296i());
        bundle.putString("sdk", String.format(Locale.ROOT, "android-%s", FacebookSdk.m10867j()));
        if (mo10260c() != null) {
            bundle.putString("sso", mo10260c());
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m10262a(LoginClient.Request request, Bundle bundle, FacebookException facebookException) {
        String str;
        LoginClient.Result m10289a;
        this.f2206c = null;
        if (bundle != null) {
            if (bundle.containsKey("e2e")) {
                this.f2206c = bundle.getString("e2e");
            }
            try {
                AccessToken a = m10273a(request.m10305a(), bundle, mo10252c_(), request.m10301d());
                m10289a = LoginClient.Result.m10292a(this.f2205b.m10323c(), a);
                CookieSyncManager.createInstance(this.f2205b.m10326b()).sync();
                m10258d(a.m11448d());
            } catch (FacebookException e) {
                m10289a = LoginClient.Result.m10290a(this.f2205b.m10323c(), null, e.getMessage());
            }
        } else if (facebookException instanceof FacebookOperationCanceledException) {
            m10289a = LoginClient.Result.m10291a(this.f2205b.m10323c(), "User canceled log in.");
        } else {
            this.f2206c = null;
            String message = facebookException.getMessage();
            if (facebookException instanceof FacebookServiceException) {
                FacebookRequestError requestError = ((FacebookServiceException) facebookException).getRequestError();
                str = String.format(Locale.ROOT, "%d", Integer.valueOf(requestError.m11408b()));
                message = requestError.toString();
            } else {
                str = null;
            }
            m10289a = LoginClient.Result.m10289a(this.f2205b.m10323c(), null, message, str);
        }
        if (!Utility.m10530a(this.f2206c)) {
            m10271b(this.f2206c);
        }
        this.f2205b.m10332a(m10289a);
    }

    /* renamed from: f */
    private String m10257f() {
        return this.f2205b.m10326b().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).getString("TOKEN", "");
    }

    /* renamed from: d */
    private void m10258d(String str) {
        this.f2205b.m10326b().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).edit().putString("TOKEN", str).apply();
    }
}
