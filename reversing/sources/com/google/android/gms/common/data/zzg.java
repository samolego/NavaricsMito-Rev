package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public class zzg<T> extends zzb<T> {

    /* renamed from: Ad */
    private T f2737Ad;

    public zzg(DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    @Override // com.google.android.gms.common.data.zzb, java.util.Iterator
    public T next() {
        if (!hasNext()) {
            int i = this.f2729zI;
            StringBuilder sb = new StringBuilder(46);
            sb.append("Cannot advance the iterator beyond ");
            sb.append(i);
            throw new NoSuchElementException(sb.toString());
        }
        this.f2729zI++;
        if (this.f2729zI == 0) {
            this.f2737Ad = this.f2728zH.get(0);
            T t = this.f2737Ad;
            if (!(t instanceof zzc)) {
                String valueOf = String.valueOf(t.getClass());
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 44);
                sb2.append("DataBuffer reference of type ");
                sb2.append(valueOf);
                sb2.append(" is not movable");
                throw new IllegalStateException(sb2.toString());
            }
        } else {
            ((zzc) this.f2737Ad).zzfz(this.f2729zI);
        }
        return this.f2737Ad;
    }
}
