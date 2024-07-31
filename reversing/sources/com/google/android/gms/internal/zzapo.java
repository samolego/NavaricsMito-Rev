package com.google.android.gms.internal;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzapo extends zzapy {
    private static final Reader bmu = new Reader() { // from class: com.google.android.gms.internal.zzapo.1
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object bmv = new Object();
    private final List<Object> bmw;

    public zzapo(zzaoh zzaohVar) {
        super(bmu);
        this.bmw = new ArrayList();
        this.bmw.add(zzaohVar);
    }

    /* renamed from: bo */
    private Object m9643bo() {
        List<Object> list = this.bmw;
        return list.get(list.size() - 1);
    }

    /* renamed from: bp */
    private Object m9642bp() {
        List<Object> list = this.bmw;
        return list.remove(list.size() - 1);
    }

    private void zza(zzapz zzapzVar) throws IOException {
        if (mo9627bn() == zzapzVar) {
            return;
        }
        String valueOf = String.valueOf(zzapzVar);
        String valueOf2 = String.valueOf(mo9627bn());
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18 + String.valueOf(valueOf2).length());
        sb.append("Expected ");
        sb.append(valueOf);
        sb.append(" but was ");
        sb.append(valueOf2);
        throw new IllegalStateException(sb.toString());
    }

    @Override // com.google.android.gms.internal.zzapy
    public void beginArray() throws IOException {
        zza(zzapz.BEGIN_ARRAY);
        this.bmw.add(((zzaoe) m9643bo()).iterator());
    }

    @Override // com.google.android.gms.internal.zzapy
    public void beginObject() throws IOException {
        zza(zzapz.BEGIN_OBJECT);
        this.bmw.add(((zzaok) m9643bo()).entrySet().iterator());
    }

    @Override // com.google.android.gms.internal.zzapy
    /* renamed from: bn */
    public zzapz mo9627bn() throws IOException {
        if (this.bmw.isEmpty()) {
            return zzapz.END_DOCUMENT;
        }
        Object m9643bo = m9643bo();
        if (m9643bo instanceof Iterator) {
            List<Object> list = this.bmw;
            boolean z = list.get(list.size() - 2) instanceof zzaok;
            Iterator it = (Iterator) m9643bo;
            if (!it.hasNext()) {
                return z ? zzapz.END_OBJECT : zzapz.END_ARRAY;
            } else if (z) {
                return zzapz.NAME;
            } else {
                this.bmw.add(it.next());
                return mo9627bn();
            }
        } else if (m9643bo instanceof zzaok) {
            return zzapz.BEGIN_OBJECT;
        } else {
            if (m9643bo instanceof zzaoe) {
                return zzapz.BEGIN_ARRAY;
            }
            if (!(m9643bo instanceof zzaon)) {
                if (m9643bo instanceof zzaoj) {
                    return zzapz.NULL;
                }
                if (m9643bo == bmv) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
            zzaon zzaonVar = (zzaon) m9643bo;
            if (zzaonVar.m9656bc()) {
                return zzapz.STRING;
            }
            if (zzaonVar.m9658ba()) {
                return zzapz.BOOLEAN;
            }
            if (zzaonVar.m9657bb()) {
                return zzapz.NUMBER;
            }
            throw new AssertionError();
        }
    }

    /* renamed from: bq */
    public void m9641bq() throws IOException {
        zza(zzapz.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) m9643bo()).next();
        this.bmw.add(entry.getValue());
        this.bmw.add(new zzaon((String) entry.getKey()));
    }

    @Override // com.google.android.gms.internal.zzapy, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.bmw.clear();
        this.bmw.add(bmv);
    }

    @Override // com.google.android.gms.internal.zzapy
    public void endArray() throws IOException {
        zza(zzapz.END_ARRAY);
        m9642bp();
        m9642bp();
    }

    @Override // com.google.android.gms.internal.zzapy
    public void endObject() throws IOException {
        zza(zzapz.END_OBJECT);
        m9642bp();
        m9642bp();
    }

    @Override // com.google.android.gms.internal.zzapy
    public boolean hasNext() throws IOException {
        zzapz mo9627bn = mo9627bn();
        return (mo9627bn == zzapz.END_OBJECT || mo9627bn == zzapz.END_ARRAY) ? false : true;
    }

    @Override // com.google.android.gms.internal.zzapy
    public boolean nextBoolean() throws IOException {
        zza(zzapz.BOOLEAN);
        return ((zzaon) m9642bp()).getAsBoolean();
    }

    @Override // com.google.android.gms.internal.zzapy
    public double nextDouble() throws IOException {
        zzapz mo9627bn = mo9627bn();
        if (mo9627bn != zzapz.NUMBER && mo9627bn != zzapz.STRING) {
            String valueOf = String.valueOf(zzapz.NUMBER);
            String valueOf2 = String.valueOf(mo9627bn);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18 + String.valueOf(valueOf2).length());
            sb.append("Expected ");
            sb.append(valueOf);
            sb.append(" but was ");
            sb.append(valueOf2);
            throw new IllegalStateException(sb.toString());
        }
        double asDouble = ((zzaon) m9643bo()).getAsDouble();
        if (isLenient() || !(Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            m9642bp();
            return asDouble;
        }
        StringBuilder sb2 = new StringBuilder(57);
        sb2.append("JSON forbids NaN and infinities: ");
        sb2.append(asDouble);
        throw new NumberFormatException(sb2.toString());
    }

    @Override // com.google.android.gms.internal.zzapy
    public int nextInt() throws IOException {
        zzapz mo9627bn = mo9627bn();
        if (mo9627bn == zzapz.NUMBER || mo9627bn == zzapz.STRING) {
            int asInt = ((zzaon) m9643bo()).getAsInt();
            m9642bp();
            return asInt;
        }
        String valueOf = String.valueOf(zzapz.NUMBER);
        String valueOf2 = String.valueOf(mo9627bn);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18 + String.valueOf(valueOf2).length());
        sb.append("Expected ");
        sb.append(valueOf);
        sb.append(" but was ");
        sb.append(valueOf2);
        throw new IllegalStateException(sb.toString());
    }

    @Override // com.google.android.gms.internal.zzapy
    public long nextLong() throws IOException {
        zzapz mo9627bn = mo9627bn();
        if (mo9627bn == zzapz.NUMBER || mo9627bn == zzapz.STRING) {
            long asLong = ((zzaon) m9643bo()).getAsLong();
            m9642bp();
            return asLong;
        }
        String valueOf = String.valueOf(zzapz.NUMBER);
        String valueOf2 = String.valueOf(mo9627bn);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18 + String.valueOf(valueOf2).length());
        sb.append("Expected ");
        sb.append(valueOf);
        sb.append(" but was ");
        sb.append(valueOf2);
        throw new IllegalStateException(sb.toString());
    }

    @Override // com.google.android.gms.internal.zzapy
    public String nextName() throws IOException {
        zza(zzapz.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) m9643bo()).next();
        this.bmw.add(entry.getValue());
        return (String) entry.getKey();
    }

    @Override // com.google.android.gms.internal.zzapy
    public void nextNull() throws IOException {
        zza(zzapz.NULL);
        m9642bp();
    }

    @Override // com.google.android.gms.internal.zzapy
    public String nextString() throws IOException {
        zzapz mo9627bn = mo9627bn();
        if (mo9627bn == zzapz.STRING || mo9627bn == zzapz.NUMBER) {
            return ((zzaon) m9642bp()).mo9660aR();
        }
        String valueOf = String.valueOf(zzapz.STRING);
        String valueOf2 = String.valueOf(mo9627bn);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18 + String.valueOf(valueOf2).length());
        sb.append("Expected ");
        sb.append(valueOf);
        sb.append(" but was ");
        sb.append(valueOf2);
        throw new IllegalStateException(sb.toString());
    }

    @Override // com.google.android.gms.internal.zzapy
    public void skipValue() throws IOException {
        if (mo9627bn() == zzapz.NAME) {
            nextName();
        } else {
            m9642bp();
        }
    }

    @Override // com.google.android.gms.internal.zzapy
    public String toString() {
        return getClass().getSimpleName();
    }
}
