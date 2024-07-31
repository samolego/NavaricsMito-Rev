package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzac;

/* loaded from: classes.dex */
public class BooleanResult implements Result {

    /* renamed from: fp */
    private final Status f2660fp;

    /* renamed from: vu */
    private final boolean f2661vu;

    public BooleanResult(Status status, boolean z) {
        this.f2660fp = (Status) zzac.zzb(status, "Status must not be null");
        this.f2661vu = z;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BooleanResult) {
            BooleanResult booleanResult = (BooleanResult) obj;
            return this.f2660fp.equals(booleanResult.f2660fp) && this.f2661vu == booleanResult.f2661vu;
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.f2660fp;
    }

    public boolean getValue() {
        return this.f2661vu;
    }

    public final int hashCode() {
        return ((this.f2660fp.hashCode() + 527) * 31) + (this.f2661vu ? 1 : 0);
    }
}
