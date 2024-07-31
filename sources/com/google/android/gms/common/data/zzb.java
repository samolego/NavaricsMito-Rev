package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzac;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public class zzb<T> implements Iterator<T> {

    /* renamed from: zH */
    protected final DataBuffer<T> f2728zH;

    /* renamed from: zI */
    protected int f2729zI = -1;

    public zzb(DataBuffer<T> dataBuffer) {
        this.f2728zH = (DataBuffer) zzac.zzy(dataBuffer);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f2729zI < this.f2728zH.getCount() - 1;
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            DataBuffer<T> dataBuffer = this.f2728zH;
            int i = this.f2729zI + 1;
            this.f2729zI = i;
            return dataBuffer.get(i);
        }
        int i2 = this.f2729zI;
        StringBuilder sb = new StringBuilder(46);
        sb.append("Cannot advance the iterator beyond ");
        sb.append(i2);
        throw new NoSuchElementException(sb.toString());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
