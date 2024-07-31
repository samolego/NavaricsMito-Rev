package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: classes.dex */
public final class FacebookRequestError implements Parcelable {

    /* renamed from: b */
    private final Category f1459b;

    /* renamed from: c */
    private final int f1460c;

    /* renamed from: d */
    private final int f1461d;

    /* renamed from: e */
    private final int f1462e;

    /* renamed from: f */
    private final String f1463f;

    /* renamed from: g */
    private final String f1464g;

    /* renamed from: h */
    private final String f1465h;

    /* renamed from: i */
    private final String f1466i;

    /* renamed from: j */
    private final String f1467j;

    /* renamed from: k */
    private final JSONObject f1468k;

    /* renamed from: l */
    private final JSONObject f1469l;

    /* renamed from: m */
    private final Object f1470m;

    /* renamed from: n */
    private final HttpURLConnection f1471n;

    /* renamed from: o */
    private final FacebookException f1472o;

    /* renamed from: a */
    static final C0822a f1458a = new C0822a(200, 299);
    public static final Parcelable.Creator<FacebookRequestError> CREATOR = new Parcelable.Creator<FacebookRequestError>() { // from class: com.facebook.FacebookRequestError.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FacebookRequestError createFromParcel(Parcel parcel) {
            return new FacebookRequestError(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FacebookRequestError[] newArray(int i) {
            return new FacebookRequestError[i];
        }
    };

    /* loaded from: classes.dex */
    public enum Category {
        LOGIN_RECOVERABLE,
        OTHER,
        TRANSIENT
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: com.facebook.FacebookRequestError$a */
    /* loaded from: classes.dex */
    private static class C0822a {

        /* renamed from: a */
        private final int f1474a;

        /* renamed from: b */
        private final int f1475b;

        private C0822a(int i, int i2) {
            this.f1474a = i;
            this.f1475b = i2;
        }

        /* renamed from: a */
        boolean m11399a(int i) {
            return this.f1474a <= i && i <= this.f1475b;
        }
    }

    private FacebookRequestError(int i, int i2, int i3, String str, String str2, String str3, String str4, boolean z, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, FacebookException facebookException) {
        boolean z2;
        Category m10715a;
        this.f1460c = i;
        this.f1461d = i2;
        this.f1462e = i3;
        this.f1463f = str;
        this.f1464g = str2;
        this.f1469l = jSONObject;
        this.f1468k = jSONObject2;
        this.f1470m = obj;
        this.f1471n = httpURLConnection;
        this.f1465h = str3;
        this.f1466i = str4;
        if (facebookException != null) {
            this.f1472o = facebookException;
            z2 = true;
        } else {
            this.f1472o = new FacebookServiceException(this, str2);
            z2 = false;
        }
        FacebookRequestErrorClassification m11402h = m11402h();
        if (z2) {
            m10715a = Category.OTHER;
        } else {
            m10715a = m11402h.m10715a(i2, i3, z);
        }
        this.f1459b = m10715a;
        this.f1467j = m11402h.m10714a(this.f1459b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FacebookRequestError(HttpURLConnection httpURLConnection, Exception exc) {
        this(-1, -1, -1, null, null, null, null, false, null, null, null, httpURLConnection, exc instanceof FacebookException ? (FacebookException) exc : new FacebookException(exc));
    }

    public FacebookRequestError(int i, String str, String str2) {
        this(-1, i, -1, str, str2, null, null, false, null, null, null, null, null);
    }

    /* renamed from: a */
    public int m11410a() {
        return this.f1460c;
    }

    /* renamed from: b */
    public int m11408b() {
        return this.f1461d;
    }

    /* renamed from: c */
    public int m11407c() {
        return this.f1462e;
    }

    /* renamed from: d */
    public String m11406d() {
        return this.f1463f;
    }

    /* renamed from: e */
    public String m11405e() {
        String str = this.f1464g;
        return str != null ? str : this.f1472o.getLocalizedMessage();
    }

    /* renamed from: f */
    public JSONObject m11404f() {
        return this.f1468k;
    }

    /* renamed from: g */
    public FacebookException m11403g() {
        return this.f1472o;
    }

    public String toString() {
        return "{HttpStatus: " + this.f1460c + ", errorCode: " + this.f1461d + ", subErrorCode: " + this.f1462e + ", errorType: " + this.f1463f + ", errorMessage: " + m11405e() + "}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static FacebookRequestError m11409a(JSONObject jSONObject, Object obj, HttpURLConnection httpURLConnection) {
        int optInt;
        String str;
        String str2;
        boolean z;
        String str3;
        String str4;
        try {
            if (jSONObject.has("code")) {
                int i = jSONObject.getInt("code");
                Object m10512a = Utility.m10512a(jSONObject, "body", "FACEBOOK_NON_JSON_RESULT");
                if (m10512a != null && (m10512a instanceof JSONObject)) {
                    JSONObject jSONObject2 = (JSONObject) m10512a;
                    boolean z2 = true;
                    int i2 = -1;
                    if (jSONObject2.has(IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR)) {
                        JSONObject jSONObject3 = (JSONObject) Utility.m10512a(jSONObject2, IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR, (String) null);
                        str4 = jSONObject3.optString(IjkMediaMeta.IJKM_KEY_TYPE, null);
                        str3 = jSONObject3.optString("message", null);
                        int optInt2 = jSONObject3.optInt("code", -1);
                        int optInt3 = jSONObject3.optInt("error_subcode", -1);
                        String optString = jSONObject3.optString("error_user_msg", null);
                        str2 = jSONObject3.optString("error_user_title", null);
                        optInt = optInt3;
                        i2 = optInt2;
                        str = optString;
                        z = jSONObject3.optBoolean("is_transient", false);
                    } else {
                        if (!jSONObject2.has("error_code") && !jSONObject2.has("error_msg") && !jSONObject2.has("error_reason")) {
                            str4 = null;
                            str3 = null;
                            str = null;
                            str2 = null;
                            z2 = false;
                            optInt = -1;
                            z = false;
                        }
                        String optString2 = jSONObject2.optString("error_reason", null);
                        String optString3 = jSONObject2.optString("error_msg", null);
                        int optInt4 = jSONObject2.optInt("error_code", -1);
                        optInt = jSONObject2.optInt("error_subcode", -1);
                        i2 = optInt4;
                        str = null;
                        str2 = null;
                        z = false;
                        str3 = optString3;
                        str4 = optString2;
                    }
                    if (z2) {
                        return new FacebookRequestError(i, i2, optInt, str4, str3, str2, str, z, jSONObject2, jSONObject, obj, httpURLConnection, null);
                    }
                }
                if (!f1458a.m11399a(i)) {
                    return new FacebookRequestError(i, -1, -1, null, null, null, null, false, jSONObject.has("body") ? (JSONObject) Utility.m10512a(jSONObject, "body", "FACEBOOK_NON_JSON_RESULT") : null, jSONObject, obj, httpURLConnection, null);
                }
            }
        } catch (JSONException unused) {
        }
        return null;
    }

    /* renamed from: h */
    static synchronized FacebookRequestErrorClassification m11402h() {
        synchronized (FacebookRequestError.class) {
            FetchedAppSettings m10808a = FetchedAppSettingsManager.m10808a(FacebookSdk.m10865l());
            if (m10808a == null) {
                return FacebookRequestErrorClassification.m10716a();
            }
            return m10808a.m10686f();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1460c);
        parcel.writeInt(this.f1461d);
        parcel.writeInt(this.f1462e);
        parcel.writeString(this.f1463f);
        parcel.writeString(this.f1464g);
        parcel.writeString(this.f1465h);
        parcel.writeString(this.f1466i);
    }

    private FacebookRequestError(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), false, null, null, null, null, null);
    }
}
