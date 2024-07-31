package com.facebook.login;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.customtabs.CustomTabsService;
import android.support.p008v4.app.FragmentActivity;
import com.facebook.AccessTokenSource;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.login.LoginClient;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: classes.dex */
public class CustomTabLoginMethodHandler extends WebLoginMethodHandler {

    /* renamed from: d */
    private String f2128d;

    /* renamed from: e */
    private String f2129e;

    /* renamed from: c */
    private static final String[] f2127c = {"com.android.chrome", "com.chrome.beta", "com.chrome.dev"};
    public static final Parcelable.Creator<CustomTabLoginMethodHandler> CREATOR = new Parcelable.Creator() { // from class: com.facebook.login.CustomTabLoginMethodHandler.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CustomTabLoginMethodHandler createFromParcel(Parcel parcel) {
            return new CustomTabLoginMethodHandler(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CustomTabLoginMethodHandler[] newArray(int i) {
            return new CustomTabLoginMethodHandler[i];
        }
    };

    @Override // com.facebook.login.LoginMethodHandler
    /* renamed from: a */
    String mo10256a() {
        return "custom_tab";
    }

    @Override // com.facebook.login.WebLoginMethodHandler
    /* renamed from: c */
    protected String mo10260c() {
        return "chrome_custom_tab";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CustomTabLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        this.f2129e = Utility.m10549a(20);
    }

    @Override // com.facebook.login.WebLoginMethodHandler
    /* renamed from: c_ */
    AccessTokenSource mo10252c_() {
        return AccessTokenSource.CHROME_CUSTOM_TAB;
    }

    @Override // com.facebook.login.LoginMethodHandler
    /* renamed from: a */
    boolean mo10255a(LoginClient.Request request) {
        if (m10395d()) {
            Bundle a = m10263a(m10261b(request), request);
            Intent intent = new Intent(this.f2205b.m10326b(), CustomTabMainActivity.class);
            intent.putExtra(CustomTabMainActivity.f1435a, a);
            intent.putExtra(CustomTabMainActivity.f1436b, m10394f());
            this.f2205b.m10336a().startActivityForResult(intent, 1);
            return true;
        }
        return false;
    }

    /* renamed from: d */
    private boolean m10395d() {
        return m10394f() != null && Validate.m10461c(FacebookSdk.m10869h());
    }

    /* renamed from: f */
    private String m10394f() {
        String str = this.f2128d;
        if (str != null) {
            return str;
        }
        FragmentActivity m10326b = this.f2205b.m10326b();
        List<ResolveInfo> queryIntentServices = m10326b.getPackageManager().queryIntentServices(new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION), 0);
        if (queryIntentServices != null) {
            HashSet hashSet = new HashSet(Arrays.asList(f2127c));
            for (ResolveInfo resolveInfo : queryIntentServices) {
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                if (serviceInfo != null && hashSet.contains(serviceInfo.packageName)) {
                    this.f2128d = serviceInfo.packageName;
                    return this.f2128d;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.facebook.login.LoginMethodHandler
    /* renamed from: a */
    boolean mo10269a(int i, int i2, Intent intent) {
        if (i != 1) {
            return super.mo10269a(i, i2, intent);
        }
        LoginClient.Request m10323c = this.f2205b.m10323c();
        if (i2 == -1) {
            m10396a(intent.getStringExtra(CustomTabMainActivity.f1437c), m10323c);
            return true;
        }
        super.m10262a(m10323c, (Bundle) null, new FacebookOperationCanceledException());
        return false;
    }

    /* renamed from: a */
    private void m10396a(String str, LoginClient.Request request) {
        int i;
        if (str == null || !str.startsWith(CustomTabMainActivity.m11431a())) {
            return;
        }
        Uri parse = Uri.parse(str);
        Bundle m10490d = Utility.m10490d(parse.getQuery());
        m10490d.putAll(Utility.m10490d(parse.getFragment()));
        if (!m10397a(m10490d)) {
            super.m10262a(request, (Bundle) null, new FacebookException("Invalid state parameter"));
            return;
        }
        String string = m10490d.getString(IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR);
        if (string == null) {
            string = m10490d.getString("error_type");
        }
        String string2 = m10490d.getString("error_msg");
        if (string2 == null) {
            string2 = m10490d.getString("error_message");
        }
        if (string2 == null) {
            string2 = m10490d.getString("error_description");
        }
        String string3 = m10490d.getString("error_code");
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
            super.m10262a(request, m10490d, (FacebookException) null);
        } else if (string != null && (string.equals("access_denied") || string.equals("OAuthAccessDeniedException"))) {
            super.m10262a(request, (Bundle) null, new FacebookOperationCanceledException());
        } else if (i == 4201) {
            super.m10262a(request, (Bundle) null, new FacebookOperationCanceledException());
        } else {
            super.m10262a(request, (Bundle) null, new FacebookServiceException(new FacebookRequestError(i, string, string2), string2));
        }
    }

    @Override // com.facebook.login.LoginMethodHandler
    /* renamed from: a */
    protected void mo10272a(JSONObject jSONObject) throws JSONException {
        jSONObject.put("7_challenge", this.f2129e);
    }

    /* renamed from: a */
    private boolean m10397a(Bundle bundle) {
        try {
            String string = bundle.getString("state");
            if (string == null) {
                return false;
            }
            return new JSONObject(string).getString("7_challenge").equals(this.f2129e);
        } catch (JSONException unused) {
            return false;
        }
    }

    CustomTabLoginMethodHandler(Parcel parcel) {
        super(parcel);
        this.f2129e = parcel.readString();
    }

    @Override // com.facebook.login.LoginMethodHandler, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f2129e);
    }
}
