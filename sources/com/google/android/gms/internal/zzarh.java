package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
class zzarh implements Cloneable {
    private zzarf<?, ?> bqB;
    private List<zzarm> bqC = new ArrayList();
    private Object value;

    private byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzx()];
        zza(zzard.zzbe(bArr));
        return bArr;
    }

    /* renamed from: cS */
    public final zzarh clone() {
        Object clone;
        zzarh zzarhVar = new zzarh();
        try {
            zzarhVar.bqB = this.bqB;
            if (this.bqC == null) {
                zzarhVar.bqC = null;
            } else {
                zzarhVar.bqC.addAll(this.bqC);
            }
            if (this.value != null) {
                if (this.value instanceof zzark) {
                    clone = (zzark) ((zzark) this.value).clone();
                } else if (this.value instanceof byte[]) {
                    clone = ((byte[]) this.value).clone();
                } else {
                    int i = 0;
                    if (this.value instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.value;
                        byte[][] bArr2 = new byte[bArr.length];
                        zzarhVar.value = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.value instanceof boolean[]) {
                        clone = ((boolean[]) this.value).clone();
                    } else if (this.value instanceof int[]) {
                        clone = ((int[]) this.value).clone();
                    } else if (this.value instanceof long[]) {
                        clone = ((long[]) this.value).clone();
                    } else if (this.value instanceof float[]) {
                        clone = ((float[]) this.value).clone();
                    } else if (this.value instanceof double[]) {
                        clone = ((double[]) this.value).clone();
                    } else if (this.value instanceof zzark[]) {
                        zzark[] zzarkVarArr = (zzark[]) this.value;
                        zzark[] zzarkVarArr2 = new zzark[zzarkVarArr.length];
                        zzarhVar.value = zzarkVarArr2;
                        while (i < zzarkVarArr.length) {
                            zzarkVarArr2[i] = (zzark) zzarkVarArr[i].clone();
                            i++;
                        }
                    }
                }
                zzarhVar.value = clone;
            }
            return zzarhVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public boolean equals(Object obj) {
        List<zzarm> list;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzarh) {
            zzarh zzarhVar = (zzarh) obj;
            if (this.value == null || zzarhVar.value == null) {
                List<zzarm> list2 = this.bqC;
                if (list2 == null || (list = zzarhVar.bqC) == null) {
                    try {
                        return Arrays.equals(toByteArray(), zzarhVar.toByteArray());
                    } catch (IOException e) {
                        throw new IllegalStateException(e);
                    }
                }
                return list2.equals(list);
            }
            zzarf<?, ?> zzarfVar = this.bqB;
            if (zzarfVar != zzarhVar.bqB) {
                return false;
            }
            if (zzarfVar.bhd.isArray()) {
                Object obj2 = this.value;
                return obj2 instanceof byte[] ? Arrays.equals((byte[]) obj2, (byte[]) zzarhVar.value) : obj2 instanceof int[] ? Arrays.equals((int[]) obj2, (int[]) zzarhVar.value) : obj2 instanceof long[] ? Arrays.equals((long[]) obj2, (long[]) zzarhVar.value) : obj2 instanceof float[] ? Arrays.equals((float[]) obj2, (float[]) zzarhVar.value) : obj2 instanceof double[] ? Arrays.equals((double[]) obj2, (double[]) zzarhVar.value) : obj2 instanceof boolean[] ? Arrays.equals((boolean[]) obj2, (boolean[]) zzarhVar.value) : Arrays.deepEquals((Object[]) obj2, (Object[]) zzarhVar.value);
            }
            return this.value.equals(zzarhVar.value);
        }
        return false;
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zza(zzard zzardVar) throws IOException {
        Object obj = this.value;
        if (obj != null) {
            this.bqB.zza(obj, zzardVar);
            return;
        }
        for (zzarm zzarmVar : this.bqC) {
            zzarmVar.zza(zzardVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zza(zzarm zzarmVar) {
        this.bqC.add(zzarmVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> T zzb(zzarf<?, T> zzarfVar) {
        if (this.value == null) {
            this.bqB = zzarfVar;
            this.value = zzarfVar.zzay(this.bqC);
            this.bqC = null;
        } else if (!this.bqB.equals(zzarfVar)) {
            throw new IllegalStateException("Tried to getExtension with a different Extension.");
        }
        return (T) this.value;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int zzx() {
        Object obj = this.value;
        if (obj != null) {
            return this.bqB.zzcu(obj);
        }
        int i = 0;
        for (zzarm zzarmVar : this.bqC) {
            i += zzarmVar.zzx();
        }
        return i;
    }
}
