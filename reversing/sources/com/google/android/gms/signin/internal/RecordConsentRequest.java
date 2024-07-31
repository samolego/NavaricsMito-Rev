package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public class RecordConsentRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RecordConsentRequest> CREATOR = new zzf();
    private final Scope[] aAj;

    /* renamed from: ec */
    private final Account f3405ec;

    /* renamed from: hk */
    private final String f3406hk;
    final int mVersionCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecordConsentRequest(int i, Account account, Scope[] scopeArr, String str) {
        this.mVersionCode = i;
        this.f3405ec = account;
        this.aAj = scopeArr;
        this.f3406hk = str;
    }

    public Account getAccount() {
        return this.f3405ec;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    public String zzahn() {
        return this.f3406hk;
    }

    public Scope[] zzcdi() {
        return this.aAj;
    }
}
