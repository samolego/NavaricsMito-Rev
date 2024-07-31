package com.google.android.gms.internal;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public final class zzapu extends zzaot<Time> {
    public static final zzaou bmp = new zzaou() { // from class: com.google.android.gms.internal.zzapu.1
        @Override // com.google.android.gms.internal.zzaou
        public <T> zzaot<T> zza(zzaob zzaobVar, zzapx<T> zzapxVar) {
            if (zzapxVar.m9638by() == Time.class) {
                return new zzapu();
            }
            return null;
        }
    };
    private final DateFormat bmP = new SimpleDateFormat("hh:mm:ss a");

    @Override // com.google.android.gms.internal.zzaot
    public synchronized void zza(zzaqa zzaqaVar, Time time) throws IOException {
        zzaqaVar.zzut(time == null ? null : this.bmP.format((Date) time));
    }

    @Override // com.google.android.gms.internal.zzaot
    /* renamed from: zzn */
    public synchronized Time zzb(zzapy zzapyVar) throws IOException {
        if (zzapyVar.mo9627bn() == zzapz.NULL) {
            zzapyVar.nextNull();
            return null;
        }
        try {
            return new Time(this.bmP.parse(zzapyVar.nextString()).getTime());
        } catch (ParseException e) {
            throw new zzaoq(e);
        }
    }
}
