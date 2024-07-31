package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class zzaoe extends zzaoh implements Iterable<zzaoh> {
    private final List<zzaoh> aLw = new ArrayList();

    @Override // com.google.android.gms.internal.zzaoh
    /* renamed from: aQ */
    public Number mo9661aQ() {
        if (this.aLw.size() == 1) {
            return this.aLw.get(0).mo9661aQ();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.gms.internal.zzaoh
    /* renamed from: aR */
    public String mo9660aR() {
        if (this.aLw.size() == 1) {
            return this.aLw.get(0).mo9660aR();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof zzaoe) && ((zzaoe) obj).aLw.equals(this.aLw));
    }

    @Override // com.google.android.gms.internal.zzaoh
    public boolean getAsBoolean() {
        if (this.aLw.size() == 1) {
            return this.aLw.get(0).getAsBoolean();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.gms.internal.zzaoh
    public double getAsDouble() {
        if (this.aLw.size() == 1) {
            return this.aLw.get(0).getAsDouble();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.gms.internal.zzaoh
    public int getAsInt() {
        if (this.aLw.size() == 1) {
            return this.aLw.get(0).getAsInt();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.gms.internal.zzaoh
    public long getAsLong() {
        if (this.aLw.size() == 1) {
            return this.aLw.get(0).getAsLong();
        }
        throw new IllegalStateException();
    }

    public int hashCode() {
        return this.aLw.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<zzaoh> iterator() {
        return this.aLw.iterator();
    }

    public int size() {
        return this.aLw.size();
    }

    public zzaoh zzagv(int i) {
        return this.aLw.get(i);
    }

    public void zzc(zzaoh zzaohVar) {
        if (zzaohVar == null) {
            zzaohVar = zzaoj.bld;
        }
        this.aLw.add(zzaohVar);
    }
}
