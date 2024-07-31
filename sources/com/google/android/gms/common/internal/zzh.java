package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzxa;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzh {

    /* renamed from: BX */
    private final Set<Scope> f2863BX;

    /* renamed from: BY */
    private final Map<Api<?>, zza> f2864BY;

    /* renamed from: BZ */
    private final zzxa f2865BZ;

    /* renamed from: Ca */
    private Integer f2866Ca;

    /* renamed from: ec */
    private final Account f2867ec;

    /* renamed from: fo */
    private final String f2868fo;

    /* renamed from: vF */
    private final Set<Scope> f2869vF;

    /* renamed from: vH */
    private final int f2870vH;

    /* renamed from: vI */
    private final View f2871vI;

    /* renamed from: vJ */
    private final String f2872vJ;

    /* loaded from: classes.dex */
    public static final class zza {

        /* renamed from: Cb */
        public final boolean f2873Cb;

        /* renamed from: hm */
        public final Set<Scope> f2874hm;

        public zza(Set<Scope> set, boolean z) {
            zzac.zzy(set);
            this.f2874hm = Collections.unmodifiableSet(set);
            this.f2873Cb = z;
        }
    }

    public zzh(Account account, Set<Scope> set, Map<Api<?>, zza> map, int i, View view, String str, String str2, zzxa zzxaVar) {
        this.f2867ec = account;
        this.f2869vF = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.f2864BY = map == null ? Collections.EMPTY_MAP : map;
        this.f2871vI = view;
        this.f2870vH = i;
        this.f2868fo = str;
        this.f2872vJ = str2;
        this.f2865BZ = zzxaVar;
        HashSet hashSet = new HashSet(this.f2869vF);
        for (zza zzaVar : this.f2864BY.values()) {
            hashSet.addAll(zzaVar.f2874hm);
        }
        this.f2863BX = Collections.unmodifiableSet(hashSet);
    }

    public static zzh zzcd(Context context) {
        return new GoogleApiClient.Builder(context).zzaqd();
    }

    public Account getAccount() {
        return this.f2867ec;
    }

    @Deprecated
    public String getAccountName() {
        Account account = this.f2867ec;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    public Account zzatv() {
        Account account = this.f2867ec;
        return account != null ? account : new Account("<<default account>>", "com.google");
    }

    public int zzauf() {
        return this.f2870vH;
    }

    public Set<Scope> zzaug() {
        return this.f2869vF;
    }

    public Set<Scope> zzauh() {
        return this.f2863BX;
    }

    public Map<Api<?>, zza> zzaui() {
        return this.f2864BY;
    }

    public String zzauj() {
        return this.f2868fo;
    }

    public String zzauk() {
        return this.f2872vJ;
    }

    public View zzaul() {
        return this.f2871vI;
    }

    public zzxa zzaum() {
        return this.f2865BZ;
    }

    public Integer zzaun() {
        return this.f2866Ca;
    }

    public Set<Scope> zzb(Api<?> api) {
        zza zzaVar = this.f2864BY.get(api);
        if (zzaVar == null || zzaVar.f2874hm.isEmpty()) {
            return this.f2869vF;
        }
        HashSet hashSet = new HashSet(this.f2869vF);
        hashSet.addAll(zzaVar.f2874hm);
        return hashSet;
    }

    public void zzc(Integer num) {
        this.f2866Ca = num;
    }
}
