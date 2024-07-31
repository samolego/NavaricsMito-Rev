package com.google.android.gms.internal;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* loaded from: classes.dex */
public final class zzapt extends zzaot<Date> {
    public static final zzaou bmp = new zzaou() { // from class: com.google.android.gms.internal.zzapt.1
        @Override // com.google.android.gms.internal.zzaou
        public <T> zzaot<T> zza(zzaob zzaobVar, zzapx<T> zzapxVar) {
            if (zzapxVar.m9638by() == Date.class) {
                return new zzapt();
            }
            return null;
        }
    };
    private final DateFormat bmP = new SimpleDateFormat("MMM d, yyyy");

    @Override // com.google.android.gms.internal.zzaot
    public synchronized void zza(zzaqa zzaqaVar, Date date) throws IOException {
        zzaqaVar.zzut(date == null ? null : this.bmP.format((java.util.Date) date));
    }

    @Override // com.google.android.gms.internal.zzaot
    /* renamed from: zzm */
    public synchronized Date zzb(zzapy zzapyVar) throws IOException {
        if (zzapyVar.mo9627bn() == zzapz.NULL) {
            zzapyVar.nextNull();
            return null;
        }
        try {
            return new Date(this.bmP.parse(zzapyVar.nextString()).getTime());
        } catch (ParseException e) {
            throw new zzaoq(e);
        }
    }
}
