package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.zzac;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

/* loaded from: classes.dex */
public class zzk {

    /* renamed from: hI */
    private static final Lock f2634hI = new ReentrantLock();

    /* renamed from: hJ */
    private static zzk f2635hJ;

    /* renamed from: hK */
    private final Lock f2636hK = new ReentrantLock();

    /* renamed from: hL */
    private final SharedPreferences f2637hL;

    zzk(Context context) {
        this.f2637hL = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static zzk zzbd(Context context) {
        zzac.zzy(context);
        f2634hI.lock();
        try {
            if (f2635hJ == null) {
                f2635hJ = new zzk(context.getApplicationContext());
            }
            return f2635hJ;
        } finally {
            f2634hI.unlock();
        }
    }

    private String zzy(String str, String str2) {
        String valueOf = String.valueOf(":");
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 0 + String.valueOf(valueOf).length() + String.valueOf(str2).length());
        sb.append(str);
        sb.append(valueOf);
        sb.append(str2);
        return sb.toString();
    }

    void zza(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        zzac.zzy(googleSignInAccount);
        zzac.zzy(googleSignInOptions);
        String zzahf = googleSignInAccount.zzahf();
        zzx(zzy("googleSignInAccount", zzahf), googleSignInAccount.zzahh());
        zzx(zzy("googleSignInOptions", zzahf), googleSignInOptions.zzahg());
    }

    public GoogleSignInAccount zzaic() {
        return zzga(zzgc("defaultGoogleSignInAccount"));
    }

    public GoogleSignInOptions zzaid() {
        return zzgb(zzgc("defaultGoogleSignInAccount"));
    }

    public void zzaie() {
        String zzgc = zzgc("defaultGoogleSignInAccount");
        zzge("defaultGoogleSignInAccount");
        zzgd(zzgc);
    }

    public void zzb(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        zzac.zzy(googleSignInAccount);
        zzac.zzy(googleSignInOptions);
        zzx("defaultGoogleSignInAccount", googleSignInAccount.zzahf());
        zza(googleSignInAccount, googleSignInOptions);
    }

    GoogleSignInAccount zzga(String str) {
        String zzgc;
        if (TextUtils.isEmpty(str) || (zzgc = zzgc(zzy("googleSignInAccount", str))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.zzfw(zzgc);
        } catch (JSONException unused) {
            return null;
        }
    }

    GoogleSignInOptions zzgb(String str) {
        String zzgc;
        if (TextUtils.isEmpty(str) || (zzgc = zzgc(zzy("googleSignInOptions", str))) == null) {
            return null;
        }
        try {
            return GoogleSignInOptions.zzfy(zzgc);
        } catch (JSONException unused) {
            return null;
        }
    }

    protected String zzgc(String str) {
        this.f2636hK.lock();
        try {
            return this.f2637hL.getString(str, null);
        } finally {
            this.f2636hK.unlock();
        }
    }

    void zzgd(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        zzge(zzy("googleSignInAccount", str));
        zzge(zzy("googleSignInOptions", str));
    }

    protected void zzge(String str) {
        this.f2636hK.lock();
        try {
            this.f2637hL.edit().remove(str).apply();
        } finally {
            this.f2636hK.unlock();
        }
    }

    protected void zzx(String str, String str2) {
        this.f2636hK.lock();
        try {
            this.f2637hL.edit().putString(str, str2).apply();
        } finally {
            this.f2636hK.unlock();
        }
    }
}
