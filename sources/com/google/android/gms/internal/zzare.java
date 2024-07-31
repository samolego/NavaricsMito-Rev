package com.google.android.gms.internal;

import com.google.android.gms.internal.zzare;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class zzare<M extends zzare<M>> extends zzark {
    protected zzarg bqv;

    @Override // com.google.android.gms.internal.zzark
    /* renamed from: cP */
    public M clone() throws CloneNotSupportedException {
        M m = (M) super.clone();
        zzari.zza(this, m);
        return m;
    }

    @Override // com.google.android.gms.internal.zzark
    /* renamed from: cQ */
    public /* synthetic */ zzark mo9586cQ() throws CloneNotSupportedException {
        return (zzare) clone();
    }

    public final <T> T zza(zzarf<M, T> zzarfVar) {
        zzarh zzahq;
        zzarg zzargVar = this.bqv;
        if (zzargVar == null || (zzahq = zzargVar.zzahq(zzarn.zzahu(zzarfVar.tag))) == null) {
            return null;
        }
        return (T) zzahq.zzb(zzarfVar);
    }

    @Override // com.google.android.gms.internal.zzark
    public void zza(zzard zzardVar) throws IOException {
        if (this.bqv == null) {
            return;
        }
        for (int i = 0; i < this.bqv.size(); i++) {
            this.bqv.zzahr(i).zza(zzardVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zza(zzarc zzarcVar, int i) throws IOException {
        int position = zzarcVar.getPosition();
        if (zzarcVar.zzaha(i)) {
            int zzahu = zzarn.zzahu(i);
            zzarm zzarmVar = new zzarm(i, zzarcVar.zzad(position, zzarcVar.getPosition() - position));
            zzarh zzarhVar = null;
            zzarg zzargVar = this.bqv;
            if (zzargVar == null) {
                this.bqv = new zzarg();
            } else {
                zzarhVar = zzargVar.zzahq(zzahu);
            }
            if (zzarhVar == null) {
                zzarhVar = new zzarh();
                this.bqv.zza(zzahu, zzarhVar);
            }
            zzarhVar.zza(zzarmVar);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzark
    public int zzx() {
        if (this.bqv != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.bqv.size(); i2++) {
                i += this.bqv.zzahr(i2).zzx();
            }
            return i;
        }
        return 0;
    }
}
