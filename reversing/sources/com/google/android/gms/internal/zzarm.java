package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes.dex */
final class zzarm {
    final byte[] avk;
    final int tag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzarm(int i, byte[] bArr) {
        this.tag = i;
        this.avk = bArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzarm) {
            zzarm zzarmVar = (zzarm) obj;
            return this.tag == zzarmVar.tag && Arrays.equals(this.avk, zzarmVar.avk);
        }
        return false;
    }

    public int hashCode() {
        return ((this.tag + 527) * 31) + Arrays.hashCode(this.avk);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zza(zzard zzardVar) throws IOException {
        zzardVar.zzahm(this.tag);
        zzardVar.zzbh(this.avk);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int zzx() {
        return zzard.zzahn(this.tag) + 0 + this.avk.length;
    }
}
