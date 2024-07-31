package com.google.android.gms.common.data;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class zzf<T> extends AbstractDataBuffer<T> {

    /* renamed from: Ab */
    private boolean f2735Ab;

    /* renamed from: Ac */
    private ArrayList<Integer> f2736Ac;

    protected zzf(DataHolder dataHolder) {
        super(dataHolder);
        this.f2735Ab = false;
    }

    private void zzati() {
        synchronized (this) {
            if (!this.f2735Ab) {
                int count = this.f2707xi.getCount();
                this.f2736Ac = new ArrayList<>();
                if (count > 0) {
                    this.f2736Ac.add(0);
                    String zzath = zzath();
                    String zzd = this.f2707xi.zzd(zzath, 0, this.f2707xi.zzgb(0));
                    for (int i = 1; i < count; i++) {
                        int zzgb = this.f2707xi.zzgb(i);
                        String zzd2 = this.f2707xi.zzd(zzath, i, zzgb);
                        if (zzd2 == null) {
                            StringBuilder sb = new StringBuilder(String.valueOf(zzath).length() + 78);
                            sb.append("Missing value for markerColumn: ");
                            sb.append(zzath);
                            sb.append(", at row: ");
                            sb.append(i);
                            sb.append(", for window: ");
                            sb.append(zzgb);
                            throw new NullPointerException(sb.toString());
                        }
                        if (!zzd2.equals(zzd)) {
                            this.f2736Ac.add(Integer.valueOf(i));
                            zzd = zzd2;
                        }
                    }
                }
                this.f2735Ab = true;
            }
        }
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public final T get(int i) {
        zzati();
        return zzl(zzgf(i), zzgg(i));
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public int getCount() {
        zzati();
        return this.f2736Ac.size();
    }

    protected abstract String zzath();

    protected String zzatj() {
        return null;
    }

    int zzgf(int i) {
        if (i < 0 || i >= this.f2736Ac.size()) {
            StringBuilder sb = new StringBuilder(53);
            sb.append("Position ");
            sb.append(i);
            sb.append(" is out of bounds for this buffer");
            throw new IllegalArgumentException(sb.toString());
        }
        return this.f2736Ac.get(i).intValue();
    }

    protected int zzgg(int i) {
        if (i < 0 || i == this.f2736Ac.size()) {
            return 0;
        }
        int count = (i == this.f2736Ac.size() - 1 ? this.f2707xi.getCount() : this.f2736Ac.get(i + 1).intValue()) - this.f2736Ac.get(i).intValue();
        if (count == 1) {
            int zzgf = zzgf(i);
            int zzgb = this.f2707xi.zzgb(zzgf);
            String zzatj = zzatj();
            if (zzatj != null && this.f2707xi.zzd(zzatj, zzgf, zzgb) == null) {
                return 0;
            }
        }
        return count;
    }

    protected abstract T zzl(int i, int i2);
}
