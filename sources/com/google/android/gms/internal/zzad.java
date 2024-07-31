package com.google.android.gms.internal;

import java.io.IOException;

/* loaded from: classes.dex */
public interface zzad {

    /* loaded from: classes.dex */
    public static final class zza extends zzare<zza> {
        public String zzck = null;
        public Long zzcl = null;
        public String stackTrace = null;
        public String zzcm = null;
        public String zzcn = null;
        public Long zzco = null;
        public Long zzcp = null;
        public String zzcq = null;
        public Long zzcr = null;
        public String zzcs = null;

        public zza() {
            this.bqE = -1;
        }

        @Override // com.google.android.gms.internal.zzark
        /* renamed from: zza */
        public zza zzb(zzarc zzarcVar) throws IOException {
            while (true) {
                int m9602cw = zzarcVar.m9602cw();
                switch (m9602cw) {
                    case 0:
                        return this;
                    case 10:
                        this.zzck = zzarcVar.readString();
                        break;
                    case 16:
                        this.zzcl = Long.valueOf(zzarcVar.m9599cz());
                        break;
                    case 26:
                        this.stackTrace = zzarcVar.readString();
                        break;
                    case 34:
                        this.zzcm = zzarcVar.readString();
                        break;
                    case 42:
                        this.zzcn = zzarcVar.readString();
                        break;
                    case 48:
                        this.zzco = Long.valueOf(zzarcVar.m9599cz());
                        break;
                    case 56:
                        this.zzcp = Long.valueOf(zzarcVar.m9599cz());
                        break;
                    case 66:
                        this.zzcq = zzarcVar.readString();
                        break;
                    case 72:
                        this.zzcr = Long.valueOf(zzarcVar.m9599cz());
                        break;
                    case 82:
                        this.zzcs = zzarcVar.readString();
                        break;
                    default:
                        if (super.zza(zzarcVar, m9602cw)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        @Override // com.google.android.gms.internal.zzare, com.google.android.gms.internal.zzark
        public void zza(zzard zzardVar) throws IOException {
            String str = this.zzck;
            if (str != null) {
                zzardVar.zzr(1, str);
            }
            Long l = this.zzcl;
            if (l != null) {
                zzardVar.zzb(2, l.longValue());
            }
            String str2 = this.stackTrace;
            if (str2 != null) {
                zzardVar.zzr(3, str2);
            }
            String str3 = this.zzcm;
            if (str3 != null) {
                zzardVar.zzr(4, str3);
            }
            String str4 = this.zzcn;
            if (str4 != null) {
                zzardVar.zzr(5, str4);
            }
            Long l2 = this.zzco;
            if (l2 != null) {
                zzardVar.zzb(6, l2.longValue());
            }
            Long l3 = this.zzcp;
            if (l3 != null) {
                zzardVar.zzb(7, l3.longValue());
            }
            String str5 = this.zzcq;
            if (str5 != null) {
                zzardVar.zzr(8, str5);
            }
            Long l4 = this.zzcr;
            if (l4 != null) {
                zzardVar.zzb(9, l4.longValue());
            }
            String str6 = this.zzcs;
            if (str6 != null) {
                zzardVar.zzr(10, str6);
            }
            super.zza(zzardVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzare, com.google.android.gms.internal.zzark
        public int zzx() {
            int zzx = super.zzx();
            String str = this.zzck;
            if (str != null) {
                zzx += zzard.zzs(1, str);
            }
            Long l = this.zzcl;
            if (l != null) {
                zzx += zzard.zzf(2, l.longValue());
            }
            String str2 = this.stackTrace;
            if (str2 != null) {
                zzx += zzard.zzs(3, str2);
            }
            String str3 = this.zzcm;
            if (str3 != null) {
                zzx += zzard.zzs(4, str3);
            }
            String str4 = this.zzcn;
            if (str4 != null) {
                zzx += zzard.zzs(5, str4);
            }
            Long l2 = this.zzco;
            if (l2 != null) {
                zzx += zzard.zzf(6, l2.longValue());
            }
            Long l3 = this.zzcp;
            if (l3 != null) {
                zzx += zzard.zzf(7, l3.longValue());
            }
            String str5 = this.zzcq;
            if (str5 != null) {
                zzx += zzard.zzs(8, str5);
            }
            Long l4 = this.zzcr;
            if (l4 != null) {
                zzx += zzard.zzf(9, l4.longValue());
            }
            String str6 = this.zzcs;
            return str6 != null ? zzx + zzard.zzs(10, str6) : zzx;
        }
    }
}
