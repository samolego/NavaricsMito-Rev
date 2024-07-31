package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzh;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new zza();

    /* renamed from: gT */
    public static zze f2602gT = zzh.zzaxj();

    /* renamed from: hc */
    private static Comparator<Scope> f2603hc = new Comparator<Scope>() { // from class: com.google.android.gms.auth.api.signin.GoogleSignInAccount.1
        @Override // java.util.Comparator
        /* renamed from: zza */
        public int compare(Scope scope, Scope scope2) {
            return scope.zzaqg().compareTo(scope2.zzaqg());
        }
    };

    /* renamed from: fK */
    List<Scope> f2604fK;

    /* renamed from: gU */
    private String f2605gU;

    /* renamed from: gV */
    private String f2606gV;

    /* renamed from: gW */
    private Uri f2607gW;

    /* renamed from: gX */
    private String f2608gX;

    /* renamed from: gY */
    private long f2609gY;

    /* renamed from: gZ */
    private String f2610gZ;

    /* renamed from: gs */
    private String f2611gs;

    /* renamed from: ha */
    private String f2612ha;

    /* renamed from: hb */
    private String f2613hb;
    final int versionCode;
    private String zzbks;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List<Scope> list, String str7, String str8) {
        this.versionCode = i;
        this.zzbks = str;
        this.f2611gs = str2;
        this.f2605gU = str3;
        this.f2606gV = str4;
        this.f2607gW = uri;
        this.f2608gX = str5;
        this.f2609gY = j;
        this.f2610gZ = str6;
        this.f2604fK = list;
        this.f2612ha = str7;
        this.f2613hb = str8;
    }

    public static GoogleSignInAccount zza(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Uri uri, @Nullable Long l, @NonNull String str7, @NonNull Set<Scope> set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, (l == null ? Long.valueOf(f2602gT.currentTimeMillis() / 1000) : l).longValue(), zzac.zzhz(str7), new ArrayList((Collection) zzac.zzy(set)), str5, str6);
    }

    private JSONObject zzahi() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (getId() != null) {
                jSONObject.put("id", getId());
            }
            if (getIdToken() != null) {
                jSONObject.put("tokenId", getIdToken());
            }
            if (getEmail() != null) {
                jSONObject.put("email", getEmail());
            }
            if (getDisplayName() != null) {
                jSONObject.put("displayName", getDisplayName());
            }
            if (getGivenName() != null) {
                jSONObject.put("givenName", getGivenName());
            }
            if (getFamilyName() != null) {
                jSONObject.put("familyName", getFamilyName());
            }
            if (getPhotoUrl() != null) {
                jSONObject.put("photoUrl", getPhotoUrl().toString());
            }
            if (getServerAuthCode() != null) {
                jSONObject.put("serverAuthCode", getServerAuthCode());
            }
            jSONObject.put("expirationTime", this.f2609gY);
            jSONObject.put("obfuscatedIdentifier", zzahf());
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f2604fK, f2603hc);
            for (Scope scope : this.f2604fK) {
                jSONArray.put(scope.zzaqg());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Nullable
    public static GoogleSignInAccount zzfw(@Nullable String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl", null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        return zza(jSONObject.optString("id"), jSONObject.optString("tokenId", null), jSONObject.optString("email", null), jSONObject.optString("displayName", null), jSONObject.optString("givenName", null), jSONObject.optString("familyName", null), parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet).zzfx(jSONObject.optString("serverAuthCode", null));
    }

    public boolean equals(Object obj) {
        if (obj instanceof GoogleSignInAccount) {
            return ((GoogleSignInAccount) obj).zzahg().equals(zzahg());
        }
        return false;
    }

    @Nullable
    public String getDisplayName() {
        return this.f2606gV;
    }

    @Nullable
    public String getEmail() {
        return this.f2605gU;
    }

    @Nullable
    public String getFamilyName() {
        return this.f2613hb;
    }

    @Nullable
    public String getGivenName() {
        return this.f2612ha;
    }

    @NonNull
    public Set<Scope> getGrantedScopes() {
        return new HashSet(this.f2604fK);
    }

    @Nullable
    public String getId() {
        return this.zzbks;
    }

    @Nullable
    public String getIdToken() {
        return this.f2611gs;
    }

    @Nullable
    public Uri getPhotoUrl() {
        return this.f2607gW;
    }

    @Nullable
    public String getServerAuthCode() {
        return this.f2608gX;
    }

    public int hashCode() {
        return zzahg().hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public boolean zza() {
        return f2602gT.currentTimeMillis() / 1000 >= this.f2609gY - 300;
    }

    public long zzahe() {
        return this.f2609gY;
    }

    @NonNull
    public String zzahf() {
        return this.f2610gZ;
    }

    public String zzahg() {
        return zzahi().toString();
    }

    public String zzahh() {
        JSONObject zzahi = zzahi();
        zzahi.remove("serverAuthCode");
        return zzahi.toString();
    }

    public GoogleSignInAccount zzfx(String str) {
        this.f2608gX = str;
        return this;
    }
}
