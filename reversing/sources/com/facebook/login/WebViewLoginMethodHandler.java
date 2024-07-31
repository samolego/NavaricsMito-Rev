package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p008v4.app.FragmentActivity;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.Utility;
import com.facebook.internal.WebDialog;
import com.facebook.login.LoginClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class WebViewLoginMethodHandler extends WebLoginMethodHandler {
    public static final Parcelable.Creator<WebViewLoginMethodHandler> CREATOR = new Parcelable.Creator<WebViewLoginMethodHandler>() { // from class: com.facebook.login.WebViewLoginMethodHandler.2
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public WebViewLoginMethodHandler createFromParcel(Parcel parcel) {
            return new WebViewLoginMethodHandler(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public WebViewLoginMethodHandler[] newArray(int i) {
            return new WebViewLoginMethodHandler[i];
        }
    };

    /* renamed from: c */
    private WebDialog f2207c;

    /* renamed from: d */
    private String f2208d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    /* renamed from: a */
    public String mo10256a() {
        return "web_view";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    /* renamed from: e */
    public boolean mo10251e() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebViewLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    @Override // com.facebook.login.WebLoginMethodHandler
    /* renamed from: c_ */
    AccessTokenSource mo10252c_() {
        return AccessTokenSource.WEB_VIEW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    /* renamed from: b */
    public void mo10254b() {
        WebDialog webDialog = this.f2207c;
        if (webDialog != null) {
            webDialog.cancel();
            this.f2207c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    /* renamed from: a */
    public boolean mo10255a(final LoginClient.Request request) {
        Bundle b = m10261b(request);
        WebDialog.InterfaceC0993c interfaceC0993c = new WebDialog.InterfaceC0993c() { // from class: com.facebook.login.WebViewLoginMethodHandler.1
            @Override // com.facebook.internal.WebDialog.InterfaceC0993c
            /* renamed from: a */
            public void mo10250a(Bundle bundle, FacebookException facebookException) {
                WebViewLoginMethodHandler.this.m10253b(request, bundle, facebookException);
            }
        };
        this.f2208d = LoginClient.m10310m();
        m10274a("e2e", this.f2208d);
        FragmentActivity m10326b = this.f2205b.m10326b();
        this.f2207c = new C1023a(m10326b, request.m10301d(), b).m10246a(this.f2208d).m10245a(Utility.m10484f(m10326b)).m10244b(request.m10296i()).m10433a(interfaceC0993c).mo10247a();
        FacebookDialogFragment facebookDialogFragment = new FacebookDialogFragment();
        facebookDialogFragment.setRetainInstance(true);
        facebookDialogFragment.m10818a(this.f2207c);
        facebookDialogFragment.show(m10326b.getSupportFragmentManager(), "FacebookDialogFragment");
        return true;
    }

    /* renamed from: b */
    void m10253b(LoginClient.Request request, Bundle bundle, FacebookException facebookException) {
        super.m10262a(request, bundle, facebookException);
    }

    /* renamed from: com.facebook.login.WebViewLoginMethodHandler$a */
    /* loaded from: classes.dex */
    static class C1023a extends WebDialog.C0991a {

        /* renamed from: a */
        private String f2211a;

        /* renamed from: b */
        private String f2212b;

        /* renamed from: c */
        private String f2213c;

        public C1023a(Context context, String str, Bundle bundle) {
            super(context, str, "oauth", bundle);
            this.f2213c = "fbconnect://success";
        }

        /* renamed from: a */
        public C1023a m10246a(String str) {
            this.f2211a = str;
            return this;
        }

        /* renamed from: a */
        public C1023a m10245a(boolean z) {
            this.f2213c = z ? "fbconnect://chrome_os_success" : "fbconnect://success";
            return this;
        }

        /* renamed from: b */
        public C1023a m10244b(String str) {
            this.f2212b = str;
            return this;
        }

        @Override // com.facebook.internal.WebDialog.C0991a
        /* renamed from: a */
        public WebDialog mo10247a() {
            Bundle e = m10429e();
            e.putString("redirect_uri", this.f2213c);
            e.putString("client_id", m10432b());
            e.putString("e2e", this.f2211a);
            e.putString("response_type", "token,signed_request");
            e.putString("return_scopes", "true");
            e.putString("auth_type", this.f2212b);
            return WebDialog.m10454a(m10431c(), "oauth", e, m10430d(), m10428f());
        }
    }

    WebViewLoginMethodHandler(Parcel parcel) {
        super(parcel);
        this.f2208d = parcel.readString();
    }

    @Override // com.facebook.login.LoginMethodHandler, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f2208d);
    }
}
