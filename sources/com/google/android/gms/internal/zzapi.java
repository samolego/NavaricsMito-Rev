package com.google.android.gms.internal;

import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes.dex */
public final class zzapi {

    /* loaded from: classes.dex */
    private static final class zza extends Writer {
        private final Appendable bmi;
        private final C3251zza bmj;

        /* renamed from: com.google.android.gms.internal.zzapi$zza$zza  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static class C3251zza implements CharSequence {
            char[] bmk;

            C3251zza() {
            }

            @Override // java.lang.CharSequence
            public char charAt(int i) {
                return this.bmk[i];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.bmk.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i, int i2) {
                return new String(this.bmk, i, i2 - i);
            }
        }

        private zza(Appendable appendable) {
            this.bmj = new C3251zza();
            this.bmi = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(int i) throws IOException {
            this.bmi.append((char) i);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) throws IOException {
            C3251zza c3251zza = this.bmj;
            c3251zza.bmk = cArr;
            this.bmi.append(c3251zza, i, i2 + i);
        }
    }

    public static Writer zza(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new zza(appendable);
    }

    public static void zzb(zzaoh zzaohVar, zzaqa zzaqaVar) throws IOException {
        zzapw.bnH.zza(zzaqaVar, zzaohVar);
    }

    public static zzaoh zzh(zzapy zzapyVar) throws zzaol {
        boolean z;
        try {
            try {
                zzapyVar.mo9627bn();
                z = false;
                try {
                    return zzapw.bnH.zzb(zzapyVar);
                } catch (EOFException e) {
                    e = e;
                    if (z) {
                        return zzaoj.bld;
                    }
                    throw new zzaoq(e);
                }
            } catch (zzaqb e2) {
                throw new zzaoq(e2);
            } catch (IOException e3) {
                throw new zzaoi(e3);
            } catch (NumberFormatException e4) {
                throw new zzaoq(e4);
            }
        } catch (EOFException e5) {
            e = e5;
            z = true;
        }
    }
}
