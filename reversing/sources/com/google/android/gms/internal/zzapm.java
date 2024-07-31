package com.google.android.gms.internal;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes.dex */
public final class zzapm extends zzaot<Date> {
    public static final zzaou bmp = new zzaou() { // from class: com.google.android.gms.internal.zzapm.1
        @Override // com.google.android.gms.internal.zzaou
        public <T> zzaot<T> zza(zzaob zzaobVar, zzapx<T> zzapxVar) {
            if (zzapxVar.m9638by() == Date.class) {
                return new zzapm();
            }
            return null;
        }
    };
    private final DateFormat bkz = DateFormat.getDateTimeInstance(2, 2, Locale.US);
    private final DateFormat bkA = DateFormat.getDateTimeInstance(2, 2);
    private final DateFormat bkB = m9644bm();

    /* renamed from: bm */
    private static DateFormat m9644bm() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    private synchronized Date zzur(String str) {
        try {
            try {
                try {
                } catch (ParseException unused) {
                    return this.bkz.parse(str);
                }
            } catch (ParseException e) {
                throw new zzaoq(str, e);
            }
        } catch (ParseException unused2) {
            return this.bkB.parse(str);
        }
        return this.bkA.parse(str);
    }

    @Override // com.google.android.gms.internal.zzaot
    public synchronized void zza(zzaqa zzaqaVar, Date date) throws IOException {
        if (date == null) {
            zzaqaVar.mo9616bx();
        } else {
            zzaqaVar.zzut(this.bkz.format(date));
        }
    }

    @Override // com.google.android.gms.internal.zzaot
    /* renamed from: zzk */
    public Date zzb(zzapy zzapyVar) throws IOException {
        if (zzapyVar.mo9627bn() == zzapz.NULL) {
            zzapyVar.nextNull();
            return null;
        }
        return zzur(zzapyVar.nextString());
    }
}
