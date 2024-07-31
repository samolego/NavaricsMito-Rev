package com.facebook;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class AccessToken implements Parcelable {

    /* renamed from: e */
    private final Date f1420e;

    /* renamed from: f */
    private final Set<String> f1421f;

    /* renamed from: g */
    private final Set<String> f1422g;

    /* renamed from: h */
    private final Set<String> f1423h;

    /* renamed from: i */
    private final String f1424i;

    /* renamed from: j */
    private final AccessTokenSource f1425j;

    /* renamed from: k */
    private final Date f1426k;

    /* renamed from: l */
    private final String f1427l;

    /* renamed from: m */
    private final String f1428m;

    /* renamed from: n */
    private final Date f1429n;

    /* renamed from: a */
    private static final Date f1416a = new Date(Long.MAX_VALUE);

    /* renamed from: b */
    private static final Date f1417b = f1416a;

    /* renamed from: c */
    private static final Date f1418c = new Date();

    /* renamed from: d */
    private static final AccessTokenSource f1419d = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
    public static final Parcelable.Creator<AccessToken> CREATOR = new Parcelable.Creator() { // from class: com.facebook.AccessToken.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AccessToken createFromParcel(Parcel parcel) {
            return new AccessToken(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AccessToken[] newArray(int i) {
            return new AccessToken[i];
        }
    };

    /* renamed from: com.facebook.AccessToken$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0816a {
        /* renamed from: a */
        void m11433a(AccessToken accessToken);

        /* renamed from: a */
        void m11432a(FacebookException facebookException);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AccessToken(String str, String str2, String str3, @Nullable Collection<String> collection, @Nullable Collection<String> collection2, @Nullable Collection<String> collection3, @Nullable AccessTokenSource accessTokenSource, @Nullable Date date, @Nullable Date date2, @Nullable Date date3) {
        Validate.m10468a(str, "accessToken");
        Validate.m10468a(str2, "applicationId");
        Validate.m10468a(str3, "userId");
        this.f1420e = date == null ? f1417b : date;
        this.f1421f = Collections.unmodifiableSet(collection != null ? new HashSet(collection) : new HashSet());
        this.f1422g = Collections.unmodifiableSet(collection2 != null ? new HashSet(collection2) : new HashSet());
        this.f1423h = Collections.unmodifiableSet(collection3 != null ? new HashSet(collection3) : new HashSet());
        this.f1424i = str;
        this.f1425j = accessTokenSource == null ? f1419d : accessTokenSource;
        this.f1426k = date2 == null ? f1418c : date2;
        this.f1427l = str2;
        this.f1428m = str3;
        this.f1429n = (date3 == null || date3.getTime() == 0) ? f1417b : date3;
    }

    /* renamed from: a */
    public static AccessToken m11457a() {
        return AccessTokenManager.m10905a().m10897b();
    }

    /* renamed from: b */
    public static boolean m11451b() {
        AccessToken m10897b = AccessTokenManager.m10905a().m10897b();
        return (m10897b == null || m10897b.m11438n()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static void m11449c() {
        AccessToken m10897b = AccessTokenManager.m10905a().m10897b();
        if (m10897b != null) {
            m11454a(m11450b(m10897b));
        }
    }

    /* renamed from: a */
    public static void m11454a(AccessToken accessToken) {
        AccessTokenManager.m10905a().m10903a(accessToken);
    }

    /* renamed from: d */
    public String m11448d() {
        return this.f1424i;
    }

    /* renamed from: e */
    public Date m11447e() {
        return this.f1420e;
    }

    /* renamed from: f */
    public Date m11446f() {
        return this.f1429n;
    }

    /* renamed from: g */
    public Set<String> m11445g() {
        return this.f1421f;
    }

    /* renamed from: h */
    public Set<String> m11444h() {
        return this.f1422g;
    }

    /* renamed from: i */
    public Set<String> m11443i() {
        return this.f1423h;
    }

    /* renamed from: j */
    public AccessTokenSource m11442j() {
        return this.f1425j;
    }

    /* renamed from: k */
    public Date m11441k() {
        return this.f1426k;
    }

    /* renamed from: l */
    public String m11440l() {
        return this.f1427l;
    }

    /* renamed from: m */
    public String m11439m() {
        return this.f1428m;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{AccessToken");
        sb.append(" token:");
        sb.append(m11436p());
        m11453a(sb);
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        String str;
        if (this == obj) {
            return true;
        }
        if (obj instanceof AccessToken) {
            AccessToken accessToken = (AccessToken) obj;
            return this.f1420e.equals(accessToken.f1420e) && this.f1421f.equals(accessToken.f1421f) && this.f1422g.equals(accessToken.f1422g) && this.f1423h.equals(accessToken.f1423h) && this.f1424i.equals(accessToken.f1424i) && this.f1425j == accessToken.f1425j && this.f1426k.equals(accessToken.f1426k) && ((str = this.f1427l) != null ? str.equals(accessToken.f1427l) : accessToken.f1427l == null) && this.f1428m.equals(accessToken.f1428m) && this.f1429n.equals(accessToken.f1429n);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((((((((((((527 + this.f1420e.hashCode()) * 31) + this.f1421f.hashCode()) * 31) + this.f1422g.hashCode()) * 31) + this.f1423h.hashCode()) * 31) + this.f1424i.hashCode()) * 31) + this.f1425j.hashCode()) * 31) + this.f1426k.hashCode()) * 31;
        String str = this.f1427l;
        return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f1428m.hashCode()) * 31) + this.f1429n.hashCode();
    }

    /* renamed from: b */
    static AccessToken m11450b(AccessToken accessToken) {
        return new AccessToken(accessToken.f1424i, accessToken.f1427l, accessToken.m11439m(), accessToken.m11445g(), accessToken.m11444h(), accessToken.m11443i(), accessToken.f1425j, new Date(), new Date(), accessToken.f1429n);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static AccessToken m11456a(Bundle bundle) {
        List<String> m11455a = m11455a(bundle, "com.facebook.TokenCachingStrategy.Permissions");
        List<String> m11455a2 = m11455a(bundle, "com.facebook.TokenCachingStrategy.DeclinedPermissions");
        List<String> m11455a3 = m11455a(bundle, "com.facebook.TokenCachingStrategy.ExpiredPermissions");
        String m10407d = LegacyTokenHelper.m10407d(bundle);
        String m10865l = Utility.m10530a(m10407d) ? FacebookSdk.m10865l() : m10407d;
        String m10409b = LegacyTokenHelper.m10409b(bundle);
        try {
            return new AccessToken(m10409b, m10865l, Utility.m10483f(m10409b).getString("id"), m11455a, m11455a2, m11455a3, LegacyTokenHelper.m10408c(bundle), LegacyTokenHelper.m10412a(bundle, "com.facebook.TokenCachingStrategy.ExpirationDate"), LegacyTokenHelper.m10412a(bundle, "com.facebook.TokenCachingStrategy.LastRefreshDate"), null);
        } catch (JSONException unused) {
            return null;
        }
    }

    /* renamed from: a */
    static List<String> m11455a(Bundle bundle, String str) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList(str);
        if (stringArrayList == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(stringArrayList));
    }

    /* renamed from: n */
    public boolean m11438n() {
        return new Date().after(this.f1420e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public JSONObject m11437o() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", 1);
        jSONObject.put("token", this.f1424i);
        jSONObject.put("expires_at", this.f1420e.getTime());
        jSONObject.put("permissions", new JSONArray((Collection) this.f1421f));
        jSONObject.put("declined_permissions", new JSONArray((Collection) this.f1422g));
        jSONObject.put("expired_permissions", new JSONArray((Collection) this.f1423h));
        jSONObject.put("last_refresh", this.f1426k.getTime());
        jSONObject.put("source", this.f1425j.name());
        jSONObject.put("application_id", this.f1427l);
        jSONObject.put("user_id", this.f1428m);
        jSONObject.put("data_access_expiration_time", this.f1429n.getTime());
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static AccessToken m11452a(JSONObject jSONObject) throws JSONException {
        if (jSONObject.getInt("version") > 1) {
            throw new FacebookException("Unknown AccessToken serialization format.");
        }
        String string = jSONObject.getString("token");
        Date date = new Date(jSONObject.getLong("expires_at"));
        JSONArray jSONArray = jSONObject.getJSONArray("permissions");
        JSONArray jSONArray2 = jSONObject.getJSONArray("declined_permissions");
        JSONArray optJSONArray = jSONObject.optJSONArray("expired_permissions");
        Date date2 = new Date(jSONObject.getLong("last_refresh"));
        AccessTokenSource valueOf = AccessTokenSource.valueOf(jSONObject.getString("source"));
        return new AccessToken(string, jSONObject.getString("application_id"), jSONObject.getString("user_id"), Utility.m10504b(jSONArray), Utility.m10504b(jSONArray2), optJSONArray == null ? new ArrayList() : Utility.m10504b(optJSONArray), valueOf, date, date2, new Date(jSONObject.optLong("data_access_expiration_time", 0L)));
    }

    /* renamed from: p */
    private String m11436p() {
        return this.f1424i == null ? "null" : FacebookSdk.m10880a(LoggingBehavior.INCLUDE_ACCESS_TOKENS) ? this.f1424i : "ACCESS_TOKEN_REMOVED";
    }

    /* renamed from: a */
    private void m11453a(StringBuilder sb) {
        sb.append(" permissions:");
        if (this.f1421f == null) {
            sb.append("null");
            return;
        }
        sb.append("[");
        sb.append(TextUtils.join(", ", this.f1421f));
        sb.append("]");
    }

    AccessToken(Parcel parcel) {
        this.f1420e = new Date(parcel.readLong());
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        this.f1421f = Collections.unmodifiableSet(new HashSet(arrayList));
        arrayList.clear();
        parcel.readStringList(arrayList);
        this.f1422g = Collections.unmodifiableSet(new HashSet(arrayList));
        arrayList.clear();
        parcel.readStringList(arrayList);
        this.f1423h = Collections.unmodifiableSet(new HashSet(arrayList));
        this.f1424i = parcel.readString();
        this.f1425j = AccessTokenSource.valueOf(parcel.readString());
        this.f1426k = new Date(parcel.readLong());
        this.f1427l = parcel.readString();
        this.f1428m = parcel.readString();
        this.f1429n = new Date(parcel.readLong());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f1420e.getTime());
        parcel.writeStringList(new ArrayList(this.f1421f));
        parcel.writeStringList(new ArrayList(this.f1422g));
        parcel.writeStringList(new ArrayList(this.f1423h));
        parcel.writeString(this.f1424i);
        parcel.writeString(this.f1425j.name());
        parcel.writeLong(this.f1426k.getTime());
        parcel.writeString(this.f1427l);
        parcel.writeString(this.f1428m);
        parcel.writeLong(this.f1429n.getTime());
    }
}
