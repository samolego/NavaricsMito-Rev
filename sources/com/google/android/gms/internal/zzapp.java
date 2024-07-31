package com.google.android.gms.internal;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zzapp extends zzaqa {
    private static final Writer bmx = new Writer() { // from class: com.google.android.gms.internal.zzapp.1
        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    };
    private static final zzaon bmy = new zzaon("closed");
    private zzaoh bmA;
    private final List<zzaoh> bmw;
    private String bmz;

    public zzapp() {
        super(bmx);
        this.bmw = new ArrayList();
        this.bmA = zzaoj.bld;
    }

    /* renamed from: bs */
    private zzaoh m9639bs() {
        List<zzaoh> list = this.bmw;
        return list.get(list.size() - 1);
    }

    private void zzd(zzaoh zzaohVar) {
        if (this.bmz != null) {
            if (!zzaohVar.m9665aV() || m9625bK()) {
                ((zzaok) m9639bs()).zza(this.bmz, zzaohVar);
            }
            this.bmz = null;
        } else if (this.bmw.isEmpty()) {
            this.bmA = zzaohVar;
        } else {
            zzaoh m9639bs = m9639bs();
            if (!(m9639bs instanceof zzaoe)) {
                throw new IllegalStateException();
            }
            ((zzaoe) m9639bs).zzc(zzaohVar);
        }
    }

    /* renamed from: br */
    public zzaoh m9640br() {
        if (this.bmw.isEmpty()) {
            return this.bmA;
        }
        String valueOf = String.valueOf(this.bmw);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 34);
        sb.append("Expected one JSON element but was ");
        sb.append(valueOf);
        throw new IllegalStateException(sb.toString());
    }

    @Override // com.google.android.gms.internal.zzaqa
    /* renamed from: bt */
    public zzaqa mo9620bt() throws IOException {
        zzaoe zzaoeVar = new zzaoe();
        zzd(zzaoeVar);
        this.bmw.add(zzaoeVar);
        return this;
    }

    @Override // com.google.android.gms.internal.zzaqa
    /* renamed from: bu */
    public zzaqa mo9619bu() throws IOException {
        if (this.bmw.isEmpty() || this.bmz != null) {
            throw new IllegalStateException();
        }
        if (m9639bs() instanceof zzaoe) {
            List<zzaoh> list = this.bmw;
            list.remove(list.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.gms.internal.zzaqa
    /* renamed from: bv */
    public zzaqa mo9618bv() throws IOException {
        zzaok zzaokVar = new zzaok();
        zzd(zzaokVar);
        this.bmw.add(zzaokVar);
        return this;
    }

    @Override // com.google.android.gms.internal.zzaqa
    /* renamed from: bw */
    public zzaqa mo9617bw() throws IOException {
        if (this.bmw.isEmpty() || this.bmz != null) {
            throw new IllegalStateException();
        }
        if (m9639bs() instanceof zzaok) {
            List<zzaoh> list = this.bmw;
            list.remove(list.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.gms.internal.zzaqa
    /* renamed from: bx */
    public zzaqa mo9616bx() throws IOException {
        zzd(zzaoj.bld);
        return this;
    }

    @Override // com.google.android.gms.internal.zzaqa, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.bmw.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.bmw.add(bmy);
    }

    @Override // com.google.android.gms.internal.zzaqa, java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // com.google.android.gms.internal.zzaqa
    public zzaqa zza(Number number) throws IOException {
        if (number == null) {
            return mo9616bx();
        }
        if (!isLenient()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                String valueOf = String.valueOf(number);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 33);
                sb.append("JSON forbids NaN and infinities: ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        zzd(new zzaon(number));
        return this;
    }

    @Override // com.google.android.gms.internal.zzaqa
    public zzaqa zzcu(long j) throws IOException {
        zzd(new zzaon((Number) Long.valueOf(j)));
        return this;
    }

    @Override // com.google.android.gms.internal.zzaqa
    public zzaqa zzdf(boolean z) throws IOException {
        zzd(new zzaon(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.android.gms.internal.zzaqa
    public zzaqa zzus(String str) throws IOException {
        if (this.bmw.isEmpty() || this.bmz != null) {
            throw new IllegalStateException();
        }
        if (m9639bs() instanceof zzaok) {
            this.bmz = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.gms.internal.zzaqa
    public zzaqa zzut(String str) throws IOException {
        if (str == null) {
            return mo9616bx();
        }
        zzd(new zzaon(str));
        return this;
    }
}
