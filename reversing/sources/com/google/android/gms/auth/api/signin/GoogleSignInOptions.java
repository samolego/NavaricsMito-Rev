package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.zze;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzac;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class GoogleSignInOptions extends AbstractSafeParcelable implements Api.ApiOptions.Optional, ReflectedParcelable {

    /* renamed from: ec */
    private Account f2618ec;

    /* renamed from: hg */
    private final ArrayList<Scope> f2619hg;

    /* renamed from: hh */
    private boolean f2620hh;

    /* renamed from: hi */
    private final boolean f2621hi;

    /* renamed from: hj */
    private final boolean f2622hj;

    /* renamed from: hk */
    private String f2623hk;

    /* renamed from: hl */
    private String f2624hl;
    final int versionCode;

    /* renamed from: hd */
    public static final Scope f2615hd = new Scope(Scopes.PROFILE);

    /* renamed from: he */
    public static final Scope f2616he = new Scope("email");

    /* renamed from: hf */
    public static final Scope f2617hf = new Scope("openid");
    public static final GoogleSignInOptions DEFAULT_SIGN_IN = new Builder().requestId().requestProfile().build();
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new zzb();

    /* renamed from: hc */
    private static Comparator<Scope> f2614hc = new Comparator<Scope>() { // from class: com.google.android.gms.auth.api.signin.GoogleSignInOptions.1
        @Override // java.util.Comparator
        /* renamed from: zza */
        public int compare(Scope scope, Scope scope2) {
            return scope.zzaqg().compareTo(scope2.zzaqg());
        }
    };

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: ec */
        private Account f2625ec;

        /* renamed from: hh */
        private boolean f2626hh;

        /* renamed from: hi */
        private boolean f2627hi;

        /* renamed from: hj */
        private boolean f2628hj;

        /* renamed from: hk */
        private String f2629hk;

        /* renamed from: hl */
        private String f2630hl;

        /* renamed from: hm */
        private Set<Scope> f2631hm;

        public Builder() {
            this.f2631hm = new HashSet();
        }

        public Builder(@NonNull GoogleSignInOptions googleSignInOptions) {
            this.f2631hm = new HashSet();
            zzac.zzy(googleSignInOptions);
            this.f2631hm = new HashSet(googleSignInOptions.f2619hg);
            this.f2627hi = googleSignInOptions.f2621hi;
            this.f2628hj = googleSignInOptions.f2622hj;
            this.f2626hh = googleSignInOptions.f2620hh;
            this.f2629hk = googleSignInOptions.f2623hk;
            this.f2625ec = googleSignInOptions.f2618ec;
            this.f2630hl = googleSignInOptions.f2624hl;
        }

        private String zzfz(String str) {
            zzac.zzhz(str);
            String str2 = this.f2629hk;
            zzac.zzb(str2 == null || str2.equals(str), "two different server client ids provided");
            return str;
        }

        public GoogleSignInOptions build() {
            if (this.f2626hh && (this.f2625ec == null || !this.f2631hm.isEmpty())) {
                requestId();
            }
            return new GoogleSignInOptions(this.f2631hm, this.f2625ec, this.f2626hh, this.f2627hi, this.f2628hj, this.f2629hk, this.f2630hl);
        }

        public Builder requestEmail() {
            this.f2631hm.add(GoogleSignInOptions.f2616he);
            return this;
        }

        public Builder requestId() {
            this.f2631hm.add(GoogleSignInOptions.f2617hf);
            return this;
        }

        public Builder requestIdToken(String str) {
            this.f2626hh = true;
            this.f2629hk = zzfz(str);
            return this;
        }

        public Builder requestProfile() {
            this.f2631hm.add(GoogleSignInOptions.f2615hd);
            return this;
        }

        public Builder requestScopes(Scope scope, Scope... scopeArr) {
            this.f2631hm.add(scope);
            this.f2631hm.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public Builder requestServerAuthCode(String str) {
            return requestServerAuthCode(str, false);
        }

        public Builder requestServerAuthCode(String str, boolean z) {
            this.f2627hi = true;
            this.f2629hk = zzfz(str);
            this.f2628hj = z;
            return this;
        }

        public Builder setAccountName(String str) {
            this.f2625ec = new Account(zzac.zzhz(str), "com.google");
            return this;
        }

        public Builder setHostedDomain(String str) {
            this.f2630hl = zzac.zzhz(str);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2) {
        this.versionCode = i;
        this.f2619hg = arrayList;
        this.f2618ec = account;
        this.f2620hh = z;
        this.f2621hi = z2;
        this.f2622hj = z3;
        this.f2623hk = str;
        this.f2624hl = str2;
    }

    private GoogleSignInOptions(Set<Scope> set, Account account, boolean z, boolean z2, boolean z3, String str, String str2) {
        this(2, new ArrayList(set), account, z, z2, z3, str, str2);
    }

    private JSONObject zzahi() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f2619hg, f2614hc);
            Iterator<Scope> it = this.f2619hg.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().zzaqg());
            }
            jSONObject.put("scopes", jSONArray);
            if (this.f2618ec != null) {
                jSONObject.put("accountName", this.f2618ec.name);
            }
            jSONObject.put("idTokenRequested", this.f2620hh);
            jSONObject.put("forceCodeForRefreshToken", this.f2622hj);
            jSONObject.put("serverAuthRequested", this.f2621hi);
            if (!TextUtils.isEmpty(this.f2623hk)) {
                jSONObject.put("serverClientId", this.f2623hk);
            }
            if (!TextUtils.isEmpty(this.f2624hl)) {
                jSONObject.put("hostedDomain", this.f2624hl);
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Nullable
    public static GoogleSignInOptions zzfy(@Nullable String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String optString = jSONObject.optString("accountName", null);
        return new GoogleSignInOptions(hashSet, !TextUtils.isEmpty(optString) ? new Account(optString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", null), jSONObject.optString("hostedDomain", null));
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.f2619hg.size() == googleSignInOptions.zzahj().size() && this.f2619hg.containsAll(googleSignInOptions.zzahj())) {
                if (this.f2618ec == null) {
                    if (googleSignInOptions.getAccount() != null) {
                        return false;
                    }
                } else if (!this.f2618ec.equals(googleSignInOptions.getAccount())) {
                    return false;
                }
                if (TextUtils.isEmpty(this.f2623hk)) {
                    if (!TextUtils.isEmpty(googleSignInOptions.zzahn())) {
                        return false;
                    }
                } else if (!this.f2623hk.equals(googleSignInOptions.zzahn())) {
                    return false;
                }
                if (this.f2622hj == googleSignInOptions.zzahm() && this.f2620hh == googleSignInOptions.zzahk()) {
                    return this.f2621hi == googleSignInOptions.zzahl();
                }
                return false;
            }
            return false;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public Account getAccount() {
        return this.f2618ec;
    }

    public Scope[] getScopeArray() {
        ArrayList<Scope> arrayList = this.f2619hg;
        return (Scope[]) arrayList.toArray(new Scope[arrayList.size()]);
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        Iterator<Scope> it = this.f2619hg.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().zzaqg());
        }
        Collections.sort(arrayList);
        return new zze().zzq(arrayList).zzq(this.f2618ec).zzq(this.f2623hk).zzbd(this.f2622hj).zzbd(this.f2620hh).zzbd(this.f2621hi).zzahv();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public String zzahg() {
        return zzahi().toString();
    }

    public ArrayList<Scope> zzahj() {
        return new ArrayList<>(this.f2619hg);
    }

    public boolean zzahk() {
        return this.f2620hh;
    }

    public boolean zzahl() {
        return this.f2621hi;
    }

    public boolean zzahm() {
        return this.f2622hj;
    }

    public String zzahn() {
        return this.f2623hk;
    }

    public String zzaho() {
        return this.f2624hl;
    }
}
