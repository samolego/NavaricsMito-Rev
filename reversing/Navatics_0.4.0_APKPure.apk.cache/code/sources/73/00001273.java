package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class zzu {
    protected static final Comparator<byte[]> zzbv = new Comparator<byte[]>() { // from class: com.google.android.gms.internal.zzu.1
        @Override // java.util.Comparator
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    };
    private List<byte[]> zzbr = new LinkedList();
    private List<byte[]> zzbs = new ArrayList(64);
    private int zzbt = 0;
    private final int zzbu;

    public zzu(int i) {
        this.zzbu = i;
    }

    private synchronized void zzw() {
        while (this.zzbt > this.zzbu) {
            byte[] remove = this.zzbr.remove(0);
            this.zzbs.remove(remove);
            this.zzbt -= remove.length;
        }
    }

    public synchronized void zza(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.zzbu) {
                this.zzbr.add(bArr);
                int binarySearch = Collections.binarySearch(this.zzbs, bArr, zzbv);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.zzbs.add(binarySearch, bArr);
                this.zzbt += bArr.length;
                zzw();
            }
        }
    }

    public synchronized byte[] zzb(int i) {
        for (int i2 = 0; i2 < this.zzbs.size(); i2++) {
            byte[] bArr = this.zzbs.get(i2);
            if (bArr.length >= i) {
                this.zzbt -= bArr.length;
                this.zzbs.remove(i2);
                this.zzbr.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }
}