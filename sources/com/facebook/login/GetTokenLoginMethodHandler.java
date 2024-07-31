package com.facebook.login;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class GetTokenLoginMethodHandler extends LoginMethodHandler {
    public static final Parcelable.Creator<GetTokenLoginMethodHandler> CREATOR = new Parcelable.Creator() { // from class: com.facebook.login.GetTokenLoginMethodHandler.3
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public GetTokenLoginMethodHandler createFromParcel(Parcel parcel) {
            return new GetTokenLoginMethodHandler(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public GetTokenLoginMethodHandler[] newArray(int i) {
            return new GetTokenLoginMethodHandler[i];
        }
    };

    /* renamed from: c */
    private GetTokenClient f2164c;

    @Override // com.facebook.login.LoginMethodHandler
    /* renamed from: a */
    String mo10256a() {
        return "get_token";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetTokenLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    @Override // com.facebook.login.LoginMethodHandler
    /* renamed from: b */
    void mo10254b() {
        GetTokenClient getTokenClient = this.f2164c;
        if (getTokenClient != null) {
            getTokenClient.m10561b();
            this.f2164c.m10562a((PlatformServiceClient.InterfaceC0981a) null);
            this.f2164c = null;
        }
    }

    @Override // com.facebook.login.LoginMethodHandler
    /* renamed from: a */
    boolean mo10255a(final LoginClient.Request request) {
        this.f2164c = new GetTokenClient(this.f2205b.m10326b(), request.m10301d());
        if (this.f2164c.m10564a()) {
            this.f2205b.m10312k();
            this.f2164c.m10562a(new PlatformServiceClient.InterfaceC0981a() { // from class: com.facebook.login.GetTokenLoginMethodHandler.1
                @Override // com.facebook.internal.PlatformServiceClient.InterfaceC0981a
                /* renamed from: a */
                public void mo10084a(Bundle bundle) {
                    GetTokenLoginMethodHandler.this.m10345a(request, bundle);
                }
            });
            return true;
        }
        return false;
    }

    /* renamed from: a */
    void m10345a(LoginClient.Request request, Bundle bundle) {
        GetTokenClient getTokenClient = this.f2164c;
        if (getTokenClient != null) {
            getTokenClient.m10562a((PlatformServiceClient.InterfaceC0981a) null);
        }
        this.f2164c = null;
        this.f2205b.m10311l();
        if (bundle != null) {
            ArrayList<String> stringArrayList = bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
            Set<String> m10305a = request.m10305a();
            if (stringArrayList != null && (m10305a == null || stringArrayList.containsAll(m10305a))) {
                m10343c(request, bundle);
                return;
            }
            HashSet hashSet = new HashSet();
            for (String str : m10305a) {
                if (!stringArrayList.contains(str)) {
                    hashSet.add(str);
                }
            }
            if (!hashSet.isEmpty()) {
                m10274a("new_permissions", TextUtils.join(",", hashSet));
            }
            request.m10304a(hashSet);
        }
        this.f2205b.m10314i();
    }

    /* renamed from: b */
    void m10344b(LoginClient.Request request, Bundle bundle) {
        this.f2205b.m10332a(LoginClient.Result.m10292a(this.f2205b.m10323c(), m10277a(bundle, AccessTokenSource.FACEBOOK_APPLICATION_SERVICE, request.m10301d())));
    }

    /* renamed from: c */
    void m10343c(final LoginClient.Request request, final Bundle bundle) {
        String string = bundle.getString("com.facebook.platform.extra.USER_ID");
        if (string == null || string.isEmpty()) {
            this.f2205b.m10312k();
            Utility.m10529a(bundle.getString("com.facebook.platform.extra.ACCESS_TOKEN"), new Utility.InterfaceC0984a() { // from class: com.facebook.login.GetTokenLoginMethodHandler.2
                @Override // com.facebook.internal.Utility.InterfaceC0984a
                /* renamed from: a */
                public void mo10341a(JSONObject jSONObject) {
                    try {
                        bundle.putString("com.facebook.platform.extra.USER_ID", jSONObject.getString("id"));
                        GetTokenLoginMethodHandler.this.m10344b(request, bundle);
                    } catch (JSONException e) {
                        GetTokenLoginMethodHandler.this.f2205b.m10324b(LoginClient.Result.m10290a(GetTokenLoginMethodHandler.this.f2205b.m10323c(), "Caught exception", e.getMessage()));
                    }
                }

                @Override // com.facebook.internal.Utility.InterfaceC0984a
                /* renamed from: a */
                public void mo10342a(FacebookException facebookException) {
                    GetTokenLoginMethodHandler.this.f2205b.m10324b(LoginClient.Result.m10290a(GetTokenLoginMethodHandler.this.f2205b.m10323c(), "Caught exception", facebookException.getMessage()));
                }
            });
            return;
        }
        m10344b(request, bundle);
    }

    GetTokenLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }

    @Override // com.facebook.login.LoginMethodHandler, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
