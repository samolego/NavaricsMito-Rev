package com.google.android.gms.internal;

/* loaded from: classes.dex */
public final class zzarg implements Cloneable {
    private static final zzarh bqx = new zzarh();
    private zzarh[] bqA;
    private boolean bqy;
    private int[] bqz;
    private int mSize;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzarg() {
        this(10);
    }

    zzarg(int i) {
        this.bqy = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.bqz = new int[idealIntArraySize];
        this.bqA = new zzarh[idealIntArraySize];
        this.mSize = 0;
    }

    private int idealByteArraySize(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            int i3 = (1 << i2) - 12;
            if (i <= i3) {
                return i3;
            }
        }
        return i;
    }

    private int idealIntArraySize(int i) {
        return idealByteArraySize(i * 4) / 4;
    }

    private boolean zza(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean zza(zzarh[] zzarhVarArr, zzarh[] zzarhVarArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!zzarhVarArr[i2].equals(zzarhVarArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private int zzahs(int i) {
        int i2 = this.mSize - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.bqz[i4];
            if (i5 < i) {
                i3 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i2 = i4 - 1;
            }
        }
        return ~i3;
    }

    /* renamed from: cR */
    public final zzarg clone() {
        int size = size();
        zzarg zzargVar = new zzarg(size);
        System.arraycopy(this.bqz, 0, zzargVar.bqz, 0, size);
        for (int i = 0; i < size; i++) {
            zzarh[] zzarhVarArr = this.bqA;
            if (zzarhVarArr[i] != null) {
                zzargVar.bqA[i] = (zzarh) zzarhVarArr[i].clone();
            }
        }
        zzargVar.mSize = size;
        return zzargVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzarg) {
            zzarg zzargVar = (zzarg) obj;
            return size() == zzargVar.size() && zza(this.bqz, zzargVar.bqz, this.mSize) && zza(this.bqA, zzargVar.bqA, this.mSize);
        }
        return false;
    }

    public int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.bqz[i2]) * 31) + this.bqA[i2].hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int size() {
        return this.mSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zza(int i, zzarh zzarhVar) {
        int zzahs = zzahs(i);
        if (zzahs >= 0) {
            this.bqA[zzahs] = zzarhVar;
            return;
        }
        int i2 = ~zzahs;
        if (i2 < this.mSize) {
            zzarh[] zzarhVarArr = this.bqA;
            if (zzarhVarArr[i2] == bqx) {
                this.bqz[i2] = i;
                zzarhVarArr[i2] = zzarhVar;
                return;
            }
        }
        int i3 = this.mSize;
        if (i3 >= this.bqz.length) {
            int idealIntArraySize = idealIntArraySize(i3 + 1);
            int[] iArr = new int[idealIntArraySize];
            zzarh[] zzarhVarArr2 = new zzarh[idealIntArraySize];
            int[] iArr2 = this.bqz;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            zzarh[] zzarhVarArr3 = this.bqA;
            System.arraycopy(zzarhVarArr3, 0, zzarhVarArr2, 0, zzarhVarArr3.length);
            this.bqz = iArr;
            this.bqA = zzarhVarArr2;
        }
        int i4 = this.mSize;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.bqz;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            zzarh[] zzarhVarArr4 = this.bqA;
            System.arraycopy(zzarhVarArr4, i2, zzarhVarArr4, i5, this.mSize - i2);
        }
        this.bqz[i2] = i;
        this.bqA[i2] = zzarhVar;
        this.mSize++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzarh zzahq(int i) {
        int zzahs = zzahs(i);
        if (zzahs >= 0) {
            zzarh[] zzarhVarArr = this.bqA;
            if (zzarhVarArr[zzahs] == bqx) {
                return null;
            }
            return zzarhVarArr[zzahs];
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzarh zzahr(int i) {
        return this.bqA[i];
    }
}
