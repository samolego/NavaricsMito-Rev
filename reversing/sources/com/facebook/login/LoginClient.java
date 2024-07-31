package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p008v4.app.Fragment;
import android.support.p008v4.app.FragmentActivity;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.common.R;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class LoginClient implements Parcelable {
    public static final Parcelable.Creator<LoginClient> CREATOR = new Parcelable.Creator<LoginClient>() { // from class: com.facebook.login.LoginClient.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public LoginClient createFromParcel(Parcel parcel) {
            return new LoginClient(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public LoginClient[] newArray(int i) {
            return new LoginClient[i];
        }
    };

    /* renamed from: a */
    LoginMethodHandler[] f2171a;

    /* renamed from: b */
    int f2172b;

    /* renamed from: c */
    Fragment f2173c;

    /* renamed from: d */
    InterfaceC1018b f2174d;

    /* renamed from: e */
    InterfaceC1017a f2175e;

    /* renamed from: f */
    boolean f2176f;

    /* renamed from: g */
    Request f2177g;

    /* renamed from: h */
    Map<String, String> f2178h;

    /* renamed from: i */
    Map<String, String> f2179i;

    /* renamed from: j */
    private LoginLogger f2180j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.facebook.login.LoginClient$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1017a {
        /* renamed from: a */
        void mo10279a();

        /* renamed from: b */
        void mo10278b();
    }

    /* renamed from: com.facebook.login.LoginClient$b */
    /* loaded from: classes.dex */
    public interface InterfaceC1018b {
        /* renamed from: a */
        void mo10280a(Result result);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LoginClient(Fragment fragment) {
        this.f2172b = -1;
        this.f2173c = fragment;
    }

    /* renamed from: a */
    public Fragment m10336a() {
        return this.f2173c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m10334a(Fragment fragment) {
        if (this.f2173c != null) {
            throw new FacebookException("Can't set fragment once it is already set.");
        }
        this.f2173c = fragment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public FragmentActivity m10326b() {
        return this.f2173c.getActivity();
    }

    /* renamed from: c */
    public Request m10323c() {
        return this.f2177g;
    }

    /* renamed from: d */
    public static int m10320d() {
        return CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m10333a(Request request) {
        if (m10318e()) {
            return;
        }
        m10325b(request);
    }

    /* renamed from: b */
    void m10325b(Request request) {
        if (request == null) {
            return;
        }
        if (this.f2177g != null) {
            throw new FacebookException("Attempted to authorize while a request is pending.");
        }
        if (!AccessToken.m11451b() || m10315h()) {
            this.f2177g = request;
            this.f2171a = m10322c(request);
            m10314i();
        }
    }

    /* renamed from: e */
    boolean m10318e() {
        return this.f2177g != null && this.f2172b >= 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public void m10317f() {
        if (this.f2172b >= 0) {
            m10316g().mo10254b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public LoginMethodHandler m10316g() {
        int i = this.f2172b;
        if (i >= 0) {
            return this.f2171a[i];
        }
        return null;
    }

    /* renamed from: a */
    public boolean m10335a(int i, int i2, Intent intent) {
        if (this.f2177g != null) {
            return m10316g().mo10269a(i, i2, intent);
        }
        return false;
    }

    /* renamed from: c */
    protected LoginMethodHandler[] m10322c(Request request) {
        ArrayList arrayList = new ArrayList();
        LoginBehavior m10303b = request.m10303b();
        if (m10303b.allowsGetTokenAuth()) {
            arrayList.add(new GetTokenLoginMethodHandler(this));
        }
        if (m10303b.allowsKatanaAuth()) {
            arrayList.add(new KatanaProxyLoginMethodHandler(this));
        }
        if (m10303b.allowsFacebookLiteAuth()) {
            arrayList.add(new FacebookLiteLoginMethodHandler(this));
        }
        if (m10303b.allowsCustomTabAuth()) {
            arrayList.add(new CustomTabLoginMethodHandler(this));
        }
        if (m10303b.allowsWebViewAuth()) {
            arrayList.add(new WebViewLoginMethodHandler(this));
        }
        if (m10303b.allowsDeviceAuth()) {
            arrayList.add(new DeviceAuthMethodHandler(this));
        }
        LoginMethodHandler[] loginMethodHandlerArr = new LoginMethodHandler[arrayList.size()];
        arrayList.toArray(loginMethodHandlerArr);
        return loginMethodHandlerArr;
    }

    /* renamed from: h */
    boolean m10315h() {
        if (this.f2176f) {
            return true;
        }
        if (m10330a("android.permission.INTERNET") != 0) {
            FragmentActivity m10326b = m10326b();
            m10324b(Result.m10290a(this.f2177g, m10326b.getString(R.string.com_facebook_internet_permission_error_title), m10326b.getString(R.string.com_facebook_internet_permission_error_message)));
            return false;
        }
        this.f2176f = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public void m10314i() {
        int i;
        if (this.f2172b >= 0) {
            m10328a(m10316g().mo10256a(), "skipped", null, null, m10316g().f2204a);
        }
        do {
            LoginMethodHandler[] loginMethodHandlerArr = this.f2171a;
            if (loginMethodHandlerArr != null && (i = this.f2172b) < loginMethodHandlerArr.length - 1) {
                this.f2172b = i + 1;
            } else if (this.f2177g != null) {
                m10309n();
                return;
            } else {
                return;
            }
        } while (!m10313j());
    }

    /* renamed from: n */
    private void m10309n() {
        m10324b(Result.m10290a(this.f2177g, "Login attempt failed.", null));
    }

    /* renamed from: a */
    private void m10327a(String str, String str2, boolean z) {
        if (this.f2178h == null) {
            this.f2178h = new HashMap();
        }
        if (this.f2178h.containsKey(str) && z) {
            str2 = this.f2178h.get(str) + "," + str2;
        }
        this.f2178h.put(str, str2);
    }

    /* renamed from: j */
    boolean m10313j() {
        LoginMethodHandler m10316g = m10316g();
        if (m10316g.mo10251e() && !m10315h()) {
            m10327a("no_internet_permission", "1", false);
            return false;
        }
        boolean mo10255a = m10316g.mo10255a(this.f2177g);
        if (mo10255a) {
            m10308o().m10241a(this.f2177g.m10300e(), m10316g.mo10256a());
        } else {
            m10308o().m10238b(this.f2177g.m10300e(), m10316g.mo10256a());
            m10327a("not_tried", m10316g.mo10256a(), true);
        }
        return mo10255a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m10332a(Result result) {
        if (result.f2191b != null && AccessToken.m11451b()) {
            m10321c(result);
        } else {
            m10324b(result);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m10324b(Result result) {
        LoginMethodHandler m10316g = m10316g();
        if (m10316g != null) {
            m10329a(m10316g.mo10256a(), result, m10316g.f2204a);
        }
        Map<String, String> map = this.f2178h;
        if (map != null) {
            result.f2195f = map;
        }
        Map<String, String> map2 = this.f2179i;
        if (map2 != null) {
            result.f2196g = map2;
        }
        this.f2171a = null;
        this.f2172b = -1;
        this.f2177g = null;
        this.f2178h = null;
        m10319d(result);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnCompletedListener(InterfaceC1018b interfaceC1018b) {
        this.f2174d = interfaceC1018b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m10331a(InterfaceC1017a interfaceC1017a) {
        this.f2175e = interfaceC1017a;
    }

    /* renamed from: a */
    int m10330a(String str) {
        return m10326b().checkCallingOrSelfPermission(str);
    }

    /* renamed from: c */
    void m10321c(Result result) {
        Result m10290a;
        if (result.f2191b == null) {
            throw new FacebookException("Can't validate without a token");
        }
        AccessToken m11457a = AccessToken.m11457a();
        AccessToken accessToken = result.f2191b;
        if (m11457a != null && accessToken != null) {
            try {
                if (m11457a.m11439m().equals(accessToken.m11439m())) {
                    m10290a = Result.m10292a(this.f2177g, result.f2191b);
                    m10324b(m10290a);
                }
            } catch (Exception e) {
                m10324b(Result.m10290a(this.f2177g, "Caught exception", e.getMessage()));
                return;
            }
        }
        m10290a = Result.m10290a(this.f2177g, "User logged in as different Facebook user.", null);
        m10324b(m10290a);
    }

    /* renamed from: o */
    private LoginLogger m10308o() {
        LoginLogger loginLogger = this.f2180j;
        if (loginLogger == null || !loginLogger.m10243a().equals(this.f2177g.m10301d())) {
            this.f2180j = new LoginLogger(m10326b(), this.f2177g.m10301d());
        }
        return this.f2180j;
    }

    /* renamed from: d */
    private void m10319d(Result result) {
        InterfaceC1018b interfaceC1018b = this.f2174d;
        if (interfaceC1018b != null) {
            interfaceC1018b.mo10280a(result);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public void m10312k() {
        InterfaceC1017a interfaceC1017a = this.f2175e;
        if (interfaceC1017a != null) {
            interfaceC1017a.mo10279a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public void m10311l() {
        InterfaceC1017a interfaceC1017a = this.f2175e;
        if (interfaceC1017a != null) {
            interfaceC1017a.mo10278b();
        }
    }

    /* renamed from: a */
    private void m10329a(String str, Result result, Map<String, String> map) {
        m10328a(str, result.f2190a.getLoggingValue(), result.f2192c, result.f2193d, map);
    }

    /* renamed from: a */
    private void m10328a(String str, String str2, String str3, String str4, Map<String, String> map) {
        if (this.f2177g == null) {
            m10308o().m10240a("fb_mobile_login_method_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", str);
        } else {
            m10308o().m10239a(this.f2177g.m10300e(), str, str2, str3, str4, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public static String m10310m() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("init", System.currentTimeMillis());
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    /* loaded from: classes.dex */
    public static class Request implements Parcelable {
        public static final Parcelable.Creator<Request> CREATOR = new Parcelable.Creator<Request>() { // from class: com.facebook.login.LoginClient.Request.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public Request createFromParcel(Parcel parcel) {
                return new Request(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public Request[] newArray(int i) {
                return new Request[i];
            }
        };

        /* renamed from: a */
        private final LoginBehavior f2181a;

        /* renamed from: b */
        private Set<String> f2182b;

        /* renamed from: c */
        private final DefaultAudience f2183c;

        /* renamed from: d */
        private final String f2184d;

        /* renamed from: e */
        private final String f2185e;

        /* renamed from: f */
        private boolean f2186f;

        /* renamed from: g */
        private String f2187g;

        /* renamed from: h */
        private String f2188h;

        /* renamed from: i */
        private String f2189i;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public Set<String> m10305a() {
            return this.f2182b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public void m10304a(Set<String> set) {
            Validate.m10469a((Object) set, "permissions");
            this.f2182b = set;
        }

        /* renamed from: b */
        LoginBehavior m10303b() {
            return this.f2181a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: c */
        public DefaultAudience m10302c() {
            return this.f2183c;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: d */
        public String m10301d() {
            return this.f2184d;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: e */
        public String m10300e() {
            return this.f2185e;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: f */
        public boolean m10299f() {
            return this.f2186f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: g */
        public String m10298g() {
            return this.f2187g;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: h */
        public String m10297h() {
            return this.f2189i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: i */
        public String m10296i() {
            return this.f2188h;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: j */
        public boolean m10295j() {
            for (String str : this.f2182b) {
                if (LoginManager.m10236a(str)) {
                    return true;
                }
            }
            return false;
        }

        private Request(Parcel parcel) {
            this.f2186f = false;
            String readString = parcel.readString();
            this.f2181a = readString != null ? LoginBehavior.valueOf(readString) : null;
            ArrayList arrayList = new ArrayList();
            parcel.readStringList(arrayList);
            this.f2182b = new HashSet(arrayList);
            String readString2 = parcel.readString();
            this.f2183c = readString2 != null ? DefaultAudience.valueOf(readString2) : null;
            this.f2184d = parcel.readString();
            this.f2185e = parcel.readString();
            this.f2186f = parcel.readByte() != 0;
            this.f2187g = parcel.readString();
            this.f2188h = parcel.readString();
            this.f2189i = parcel.readString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            LoginBehavior loginBehavior = this.f2181a;
            parcel.writeString(loginBehavior != null ? loginBehavior.name() : null);
            parcel.writeStringList(new ArrayList(this.f2182b));
            DefaultAudience defaultAudience = this.f2183c;
            parcel.writeString(defaultAudience != null ? defaultAudience.name() : null);
            parcel.writeString(this.f2184d);
            parcel.writeString(this.f2185e);
            parcel.writeByte(this.f2186f ? (byte) 1 : (byte) 0);
            parcel.writeString(this.f2187g);
            parcel.writeString(this.f2188h);
            parcel.writeString(this.f2189i);
        }
    }

    /* loaded from: classes.dex */
    public static class Result implements Parcelable {
        public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator<Result>() { // from class: com.facebook.login.LoginClient.Result.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public Result createFromParcel(Parcel parcel) {
                return new Result(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public Result[] newArray(int i) {
                return new Result[i];
            }
        };

        /* renamed from: a */
        final Code f2190a;

        /* renamed from: b */
        final AccessToken f2191b;

        /* renamed from: c */
        final String f2192c;

        /* renamed from: d */
        final String f2193d;

        /* renamed from: e */
        final Request f2194e;

        /* renamed from: f */
        public Map<String, String> f2195f;

        /* renamed from: g */
        public Map<String, String> f2196g;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public enum Code {
            SUCCESS("success"),
            CANCEL("cancel"),
            ERROR(IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR);
            
            private final String loggingValue;

            Code(String str) {
                this.loggingValue = str;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public String getLoggingValue() {
                return this.loggingValue;
            }
        }

        Result(Request request, Code code, AccessToken accessToken, String str, String str2) {
            Validate.m10469a(code, "code");
            this.f2194e = request;
            this.f2191b = accessToken;
            this.f2192c = str;
            this.f2190a = code;
            this.f2193d = str2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public static Result m10292a(Request request, AccessToken accessToken) {
            return new Result(request, Code.SUCCESS, accessToken, null, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public static Result m10291a(Request request, String str) {
            return new Result(request, Code.CANCEL, null, str, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public static Result m10290a(Request request, String str, String str2) {
            return m10289a(request, str, str2, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public static Result m10289a(Request request, String str, String str2, String str3) {
            return new Result(request, Code.ERROR, null, TextUtils.join(": ", Utility.m10501b(str, str2)), str3);
        }

        private Result(Parcel parcel) {
            this.f2190a = Code.valueOf(parcel.readString());
            this.f2191b = (AccessToken) parcel.readParcelable(AccessToken.class.getClassLoader());
            this.f2192c = parcel.readString();
            this.f2193d = parcel.readString();
            this.f2194e = (Request) parcel.readParcelable(Request.class.getClassLoader());
            this.f2195f = Utility.m10541a(parcel);
            this.f2196g = Utility.m10541a(parcel);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f2190a.name());
            parcel.writeParcelable(this.f2191b, i);
            parcel.writeString(this.f2192c);
            parcel.writeString(this.f2193d);
            parcel.writeParcelable(this.f2194e, i);
            Utility.m10540a(parcel, this.f2195f);
            Utility.m10540a(parcel, this.f2196g);
        }
    }

    public LoginClient(Parcel parcel) {
        this.f2172b = -1;
        Parcelable[] readParcelableArray = parcel.readParcelableArray(LoginMethodHandler.class.getClassLoader());
        this.f2171a = new LoginMethodHandler[readParcelableArray.length];
        for (int i = 0; i < readParcelableArray.length; i++) {
            LoginMethodHandler[] loginMethodHandlerArr = this.f2171a;
            loginMethodHandlerArr[i] = (LoginMethodHandler) readParcelableArray[i];
            loginMethodHandlerArr[i].m10276a(this);
        }
        this.f2172b = parcel.readInt();
        this.f2177g = (Request) parcel.readParcelable(Request.class.getClassLoader());
        this.f2178h = Utility.m10541a(parcel);
        this.f2179i = Utility.m10541a(parcel);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelableArray(this.f2171a, i);
        parcel.writeInt(this.f2172b);
        parcel.writeParcelable(this.f2177g, i);
        Utility.m10540a(parcel, this.f2178h);
        Utility.m10540a(parcel, this.f2179i);
    }
}
