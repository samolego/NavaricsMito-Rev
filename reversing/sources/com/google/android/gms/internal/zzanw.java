package com.google.android.gms.internal;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes.dex */
final class zzanw implements zzaog<Date>, zzaop<Date> {
    private final DateFormat bkA;
    private final DateFormat bkB;
    private final DateFormat bkz;

    zzanw() {
        this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    public zzanw(int i, int i2) {
        this(DateFormat.getDateTimeInstance(i, i2, Locale.US), DateFormat.getDateTimeInstance(i, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzanw(String str) {
        this(new SimpleDateFormat(str, Locale.US), new SimpleDateFormat(str));
    }

    zzanw(DateFormat dateFormat, DateFormat dateFormat2) {
        this.bkz = dateFormat;
        this.bkA = dateFormat2;
        this.bkB = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        this.bkB.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    private Date zza(zzaoh zzaohVar) {
        Date parse;
        synchronized (this.bkA) {
            try {
                try {
                    try {
                        parse = this.bkA.parse(zzaohVar.mo9660aR());
                    } catch (ParseException unused) {
                        return this.bkB.parse(zzaohVar.mo9660aR());
                    }
                } catch (ParseException e) {
                    throw new zzaoq(zzaohVar.mo9660aR(), e);
                }
            } catch (ParseException unused2) {
                return this.bkz.parse(zzaohVar.mo9660aR());
            }
        }
        return parse;
    }

    public String toString() {
        return zzanw.class.getSimpleName() + '(' + this.bkA.getClass().getSimpleName() + ')';
    }

    @Override // com.google.android.gms.internal.zzaop
    public zzaoh zza(Date date, Type type, zzaoo zzaooVar) {
        zzaon zzaonVar;
        synchronized (this.bkA) {
            zzaonVar = new zzaon(this.bkz.format(date));
        }
        return zzaonVar;
    }

    @Override // com.google.android.gms.internal.zzaog
    /* renamed from: zza */
    public Date zzb(zzaoh zzaohVar, Type type, zzaof zzaofVar) throws zzaol {
        if (zzaohVar instanceof zzaon) {
            Date zza = zza(zzaohVar);
            if (type == Date.class) {
                return zza;
            }
            if (type == Timestamp.class) {
                return new Timestamp(zza.getTime());
            }
            if (type == java.sql.Date.class) {
                return new java.sql.Date(zza.getTime());
            }
            String valueOf = String.valueOf(getClass());
            String valueOf2 = String.valueOf(type);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23 + String.valueOf(valueOf2).length());
            sb.append(valueOf);
            sb.append(" cannot deserialize to ");
            sb.append(valueOf2);
            throw new IllegalArgumentException(sb.toString());
        }
        throw new zzaol("The date should be a string value");
    }
}
