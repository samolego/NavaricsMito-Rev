package com.google.android.gms.internal;

import java.io.IOException;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes.dex */
public interface zzae {

    /* loaded from: classes.dex */
    public static final class zza extends zzare<zza> {
        public zzb zzdx;
        public C3250zza zzeo;
        public zzb zzeq;
        public zze zzex;
        public String zzct = null;
        public String zzcs = null;
        public Long zzcu = null;
        public Long zzcv = null;
        public Long zzcw = null;
        public Long zzcx = null;
        public Long zzcy = null;
        public Long zzcz = null;
        public Long zzda = null;
        public Long zzdb = null;
        public Long zzdc = null;
        public Long zzdd = null;
        public String zzde = null;
        public Long zzdf = null;
        public Long zzdg = null;
        public Long zzdh = null;
        public Long zzdi = null;
        public Long zzdj = null;
        public Long zzdk = null;
        public Long zzdl = null;
        public Long zzdm = null;
        public Long zzdn = null;
        public String zzdo = null;
        public String zzdp = null;
        public Long zzdq = null;
        public Long zzdr = null;
        public Long zzds = null;
        public String zzdt = null;
        public Long zzdu = null;
        public Long zzdv = null;
        public Long zzdw = null;
        public Long zzdy = null;
        public Long zzdz = null;
        public Long zzea = null;
        public Long zzeb = null;
        public Long zzec = null;
        public Long zzed = null;
        public String zzee = null;
        public String zzef = null;
        public Integer zzeg = null;
        public Integer zzeh = null;
        public Long zzei = null;
        public Long zzej = null;
        public Long zzek = null;
        public Long zzel = null;
        public Long zzem = null;
        public Integer zzen = null;
        public C3250zza[] zzep = C3250zza.zzy();
        public Long zzer = null;
        public String zzes = null;
        public Integer zzet = null;
        public Boolean zzeu = null;
        public String zzev = null;
        public Long zzew = null;

        /* renamed from: com.google.android.gms.internal.zzae$zza$zza  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C3250zza extends zzare<C3250zza> {
            private static volatile C3250zza[] zzey;
            public Long zzdf = null;
            public Long zzdg = null;
            public Long zzez = null;
            public Long zzfa = null;
            public Long zzfb = null;
            public Long zzfc = null;
            public Integer zzfd = null;
            public Long zzfe = null;
            public Long zzff = null;
            public Long zzfg = null;
            public Integer zzfh = null;
            public Long zzfi = null;

            public C3250zza() {
                this.bqE = -1;
            }

            public static C3250zza[] zzy() {
                if (zzey == null) {
                    synchronized (zzari.bqD) {
                        if (zzey == null) {
                            zzey = new C3250zza[0];
                        }
                    }
                }
                return zzey;
            }

            @Override // com.google.android.gms.internal.zzare, com.google.android.gms.internal.zzark
            public void zza(zzard zzardVar) throws IOException {
                Long l = this.zzdf;
                if (l != null) {
                    zzardVar.zzb(1, l.longValue());
                }
                Long l2 = this.zzdg;
                if (l2 != null) {
                    zzardVar.zzb(2, l2.longValue());
                }
                Long l3 = this.zzez;
                if (l3 != null) {
                    zzardVar.zzb(3, l3.longValue());
                }
                Long l4 = this.zzfa;
                if (l4 != null) {
                    zzardVar.zzb(4, l4.longValue());
                }
                Long l5 = this.zzfb;
                if (l5 != null) {
                    zzardVar.zzb(5, l5.longValue());
                }
                Long l6 = this.zzfc;
                if (l6 != null) {
                    zzardVar.zzb(6, l6.longValue());
                }
                Integer num = this.zzfd;
                if (num != null) {
                    zzardVar.zzae(7, num.intValue());
                }
                Long l7 = this.zzfe;
                if (l7 != null) {
                    zzardVar.zzb(8, l7.longValue());
                }
                Long l8 = this.zzff;
                if (l8 != null) {
                    zzardVar.zzb(9, l8.longValue());
                }
                Long l9 = this.zzfg;
                if (l9 != null) {
                    zzardVar.zzb(10, l9.longValue());
                }
                Integer num2 = this.zzfh;
                if (num2 != null) {
                    zzardVar.zzae(11, num2.intValue());
                }
                Long l10 = this.zzfi;
                if (l10 != null) {
                    zzardVar.zzb(12, l10.longValue());
                }
                super.zza(zzardVar);
            }

            @Override // com.google.android.gms.internal.zzark
            /* renamed from: zzd */
            public C3250zza zzb(zzarc zzarcVar) throws IOException {
                while (true) {
                    int m9602cw = zzarcVar.m9602cw();
                    switch (m9602cw) {
                        case 0:
                            return this;
                        case 8:
                            this.zzdf = Long.valueOf(zzarcVar.m9599cz());
                            break;
                        case 16:
                            this.zzdg = Long.valueOf(zzarcVar.m9599cz());
                            break;
                        case 24:
                            this.zzez = Long.valueOf(zzarcVar.m9599cz());
                            break;
                        case 32:
                            this.zzfa = Long.valueOf(zzarcVar.m9599cz());
                            break;
                        case 40:
                            this.zzfb = Long.valueOf(zzarcVar.m9599cz());
                            break;
                        case 48:
                            this.zzfc = Long.valueOf(zzarcVar.m9599cz());
                            break;
                        case 56:
                            int m9615cA = zzarcVar.m9615cA();
                            if (m9615cA != 1000) {
                                switch (m9615cA) {
                                }
                            }
                            this.zzfd = Integer.valueOf(m9615cA);
                            break;
                        case 64:
                            this.zzfe = Long.valueOf(zzarcVar.m9599cz());
                            break;
                        case 72:
                            this.zzff = Long.valueOf(zzarcVar.m9599cz());
                            break;
                        case 80:
                            this.zzfg = Long.valueOf(zzarcVar.m9599cz());
                            break;
                        case 88:
                            int m9615cA2 = zzarcVar.m9615cA();
                            if (m9615cA2 != 1000) {
                                switch (m9615cA2) {
                                }
                            }
                            this.zzfh = Integer.valueOf(m9615cA2);
                            break;
                        case 96:
                            this.zzfi = Long.valueOf(zzarcVar.m9599cz());
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

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzare, com.google.android.gms.internal.zzark
            public int zzx() {
                int zzx = super.zzx();
                Long l = this.zzdf;
                if (l != null) {
                    zzx += zzard.zzf(1, l.longValue());
                }
                Long l2 = this.zzdg;
                if (l2 != null) {
                    zzx += zzard.zzf(2, l2.longValue());
                }
                Long l3 = this.zzez;
                if (l3 != null) {
                    zzx += zzard.zzf(3, l3.longValue());
                }
                Long l4 = this.zzfa;
                if (l4 != null) {
                    zzx += zzard.zzf(4, l4.longValue());
                }
                Long l5 = this.zzfb;
                if (l5 != null) {
                    zzx += zzard.zzf(5, l5.longValue());
                }
                Long l6 = this.zzfc;
                if (l6 != null) {
                    zzx += zzard.zzf(6, l6.longValue());
                }
                Integer num = this.zzfd;
                if (num != null) {
                    zzx += zzard.zzag(7, num.intValue());
                }
                Long l7 = this.zzfe;
                if (l7 != null) {
                    zzx += zzard.zzf(8, l7.longValue());
                }
                Long l8 = this.zzff;
                if (l8 != null) {
                    zzx += zzard.zzf(9, l8.longValue());
                }
                Long l9 = this.zzfg;
                if (l9 != null) {
                    zzx += zzard.zzf(10, l9.longValue());
                }
                Integer num2 = this.zzfh;
                if (num2 != null) {
                    zzx += zzard.zzag(11, num2.intValue());
                }
                Long l10 = this.zzfi;
                return l10 != null ? zzx + zzard.zzf(12, l10.longValue()) : zzx;
            }
        }

        /* loaded from: classes.dex */
        public static final class zzb extends zzare<zzb> {
            public Long zzel = null;
            public Long zzem = null;
            public Long zzfj = null;

            public zzb() {
                this.bqE = -1;
            }

            @Override // com.google.android.gms.internal.zzare, com.google.android.gms.internal.zzark
            public void zza(zzard zzardVar) throws IOException {
                Long l = this.zzel;
                if (l != null) {
                    zzardVar.zzb(1, l.longValue());
                }
                Long l2 = this.zzem;
                if (l2 != null) {
                    zzardVar.zzb(2, l2.longValue());
                }
                Long l3 = this.zzfj;
                if (l3 != null) {
                    zzardVar.zzb(3, l3.longValue());
                }
                super.zza(zzardVar);
            }

            @Override // com.google.android.gms.internal.zzark
            /* renamed from: zze */
            public zzb zzb(zzarc zzarcVar) throws IOException {
                while (true) {
                    int m9602cw = zzarcVar.m9602cw();
                    if (m9602cw == 0) {
                        return this;
                    }
                    if (m9602cw == 8) {
                        this.zzel = Long.valueOf(zzarcVar.m9599cz());
                    } else if (m9602cw == 16) {
                        this.zzem = Long.valueOf(zzarcVar.m9599cz());
                    } else if (m9602cw == 24) {
                        this.zzfj = Long.valueOf(zzarcVar.m9599cz());
                    } else if (!super.zza(zzarcVar, m9602cw)) {
                        return this;
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzare, com.google.android.gms.internal.zzark
            public int zzx() {
                int zzx = super.zzx();
                Long l = this.zzel;
                if (l != null) {
                    zzx += zzard.zzf(1, l.longValue());
                }
                Long l2 = this.zzem;
                if (l2 != null) {
                    zzx += zzard.zzf(2, l2.longValue());
                }
                Long l3 = this.zzfj;
                return l3 != null ? zzx + zzard.zzf(3, l3.longValue()) : zzx;
            }
        }

        public zza() {
            this.bqE = -1;
        }

        public static zza zzc(byte[] bArr) throws zzarj {
            return (zza) zzark.zza(new zza(), bArr);
        }

        @Override // com.google.android.gms.internal.zzare, com.google.android.gms.internal.zzark
        public void zza(zzard zzardVar) throws IOException {
            String str = this.zzct;
            if (str != null) {
                zzardVar.zzr(1, str);
            }
            String str2 = this.zzcs;
            if (str2 != null) {
                zzardVar.zzr(2, str2);
            }
            Long l = this.zzcu;
            if (l != null) {
                zzardVar.zzb(3, l.longValue());
            }
            Long l2 = this.zzcv;
            if (l2 != null) {
                zzardVar.zzb(4, l2.longValue());
            }
            Long l3 = this.zzcw;
            if (l3 != null) {
                zzardVar.zzb(5, l3.longValue());
            }
            Long l4 = this.zzcx;
            if (l4 != null) {
                zzardVar.zzb(6, l4.longValue());
            }
            Long l5 = this.zzcy;
            if (l5 != null) {
                zzardVar.zzb(7, l5.longValue());
            }
            Long l6 = this.zzcz;
            if (l6 != null) {
                zzardVar.zzb(8, l6.longValue());
            }
            Long l7 = this.zzda;
            if (l7 != null) {
                zzardVar.zzb(9, l7.longValue());
            }
            Long l8 = this.zzdb;
            if (l8 != null) {
                zzardVar.zzb(10, l8.longValue());
            }
            Long l9 = this.zzdc;
            if (l9 != null) {
                zzardVar.zzb(11, l9.longValue());
            }
            Long l10 = this.zzdd;
            if (l10 != null) {
                zzardVar.zzb(12, l10.longValue());
            }
            String str3 = this.zzde;
            if (str3 != null) {
                zzardVar.zzr(13, str3);
            }
            Long l11 = this.zzdf;
            if (l11 != null) {
                zzardVar.zzb(14, l11.longValue());
            }
            Long l12 = this.zzdg;
            if (l12 != null) {
                zzardVar.zzb(15, l12.longValue());
            }
            Long l13 = this.zzdh;
            if (l13 != null) {
                zzardVar.zzb(16, l13.longValue());
            }
            Long l14 = this.zzdi;
            if (l14 != null) {
                zzardVar.zzb(17, l14.longValue());
            }
            Long l15 = this.zzdj;
            if (l15 != null) {
                zzardVar.zzb(18, l15.longValue());
            }
            Long l16 = this.zzdk;
            if (l16 != null) {
                zzardVar.zzb(19, l16.longValue());
            }
            Long l17 = this.zzdl;
            if (l17 != null) {
                zzardVar.zzb(20, l17.longValue());
            }
            Long l18 = this.zzer;
            if (l18 != null) {
                zzardVar.zzb(21, l18.longValue());
            }
            Long l19 = this.zzdm;
            if (l19 != null) {
                zzardVar.zzb(22, l19.longValue());
            }
            Long l20 = this.zzdn;
            if (l20 != null) {
                zzardVar.zzb(23, l20.longValue());
            }
            String str4 = this.zzes;
            if (str4 != null) {
                zzardVar.zzr(24, str4);
            }
            Long l21 = this.zzew;
            if (l21 != null) {
                zzardVar.zzb(25, l21.longValue());
            }
            Integer num = this.zzet;
            if (num != null) {
                zzardVar.zzae(26, num.intValue());
            }
            String str5 = this.zzdo;
            if (str5 != null) {
                zzardVar.zzr(27, str5);
            }
            Boolean bool = this.zzeu;
            if (bool != null) {
                zzardVar.zzj(28, bool.booleanValue());
            }
            String str6 = this.zzdp;
            if (str6 != null) {
                zzardVar.zzr(29, str6);
            }
            String str7 = this.zzev;
            if (str7 != null) {
                zzardVar.zzr(30, str7);
            }
            Long l22 = this.zzdq;
            if (l22 != null) {
                zzardVar.zzb(31, l22.longValue());
            }
            Long l23 = this.zzdr;
            if (l23 != null) {
                zzardVar.zzb(32, l23.longValue());
            }
            Long l24 = this.zzds;
            if (l24 != null) {
                zzardVar.zzb(33, l24.longValue());
            }
            String str8 = this.zzdt;
            if (str8 != null) {
                zzardVar.zzr(34, str8);
            }
            Long l25 = this.zzdu;
            if (l25 != null) {
                zzardVar.zzb(35, l25.longValue());
            }
            Long l26 = this.zzdv;
            if (l26 != null) {
                zzardVar.zzb(36, l26.longValue());
            }
            Long l27 = this.zzdw;
            if (l27 != null) {
                zzardVar.zzb(37, l27.longValue());
            }
            zzb zzbVar = this.zzdx;
            if (zzbVar != null) {
                zzardVar.zza(38, zzbVar);
            }
            Long l28 = this.zzdy;
            if (l28 != null) {
                zzardVar.zzb(39, l28.longValue());
            }
            Long l29 = this.zzdz;
            if (l29 != null) {
                zzardVar.zzb(40, l29.longValue());
            }
            Long l30 = this.zzea;
            if (l30 != null) {
                zzardVar.zzb(41, l30.longValue());
            }
            Long l31 = this.zzeb;
            if (l31 != null) {
                zzardVar.zzb(42, l31.longValue());
            }
            C3250zza[] c3250zzaArr = this.zzep;
            if (c3250zzaArr != null && c3250zzaArr.length > 0) {
                int i = 0;
                while (true) {
                    C3250zza[] c3250zzaArr2 = this.zzep;
                    if (i >= c3250zzaArr2.length) {
                        break;
                    }
                    C3250zza c3250zza = c3250zzaArr2[i];
                    if (c3250zza != null) {
                        zzardVar.zza(43, c3250zza);
                    }
                    i++;
                }
            }
            Long l32 = this.zzec;
            if (l32 != null) {
                zzardVar.zzb(44, l32.longValue());
            }
            Long l33 = this.zzed;
            if (l33 != null) {
                zzardVar.zzb(45, l33.longValue());
            }
            String str9 = this.zzee;
            if (str9 != null) {
                zzardVar.zzr(46, str9);
            }
            String str10 = this.zzef;
            if (str10 != null) {
                zzardVar.zzr(47, str10);
            }
            Integer num2 = this.zzeg;
            if (num2 != null) {
                zzardVar.zzae(48, num2.intValue());
            }
            Integer num3 = this.zzeh;
            if (num3 != null) {
                zzardVar.zzae(49, num3.intValue());
            }
            C3250zza c3250zza2 = this.zzeo;
            if (c3250zza2 != null) {
                zzardVar.zza(50, c3250zza2);
            }
            Long l34 = this.zzei;
            if (l34 != null) {
                zzardVar.zzb(51, l34.longValue());
            }
            Long l35 = this.zzej;
            if (l35 != null) {
                zzardVar.zzb(52, l35.longValue());
            }
            Long l36 = this.zzek;
            if (l36 != null) {
                zzardVar.zzb(53, l36.longValue());
            }
            Long l37 = this.zzel;
            if (l37 != null) {
                zzardVar.zzb(54, l37.longValue());
            }
            Long l38 = this.zzem;
            if (l38 != null) {
                zzardVar.zzb(55, l38.longValue());
            }
            Integer num4 = this.zzen;
            if (num4 != null) {
                zzardVar.zzae(56, num4.intValue());
            }
            zzb zzbVar2 = this.zzeq;
            if (zzbVar2 != null) {
                zzardVar.zza(57, zzbVar2);
            }
            zze zzeVar = this.zzex;
            if (zzeVar != null) {
                zzardVar.zza(201, zzeVar);
            }
            super.zza(zzardVar);
        }

        @Override // com.google.android.gms.internal.zzark
        /* renamed from: zzc */
        public zza zzb(zzarc zzarcVar) throws IOException {
            zzark zzarkVar;
            while (true) {
                int m9602cw = zzarcVar.m9602cw();
                switch (m9602cw) {
                    case 0:
                        return this;
                    case 10:
                        this.zzct = zzarcVar.readString();
                        continue;
                    case 18:
                        this.zzcs = zzarcVar.readString();
                        continue;
                    case 24:
                        this.zzcu = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 32:
                        this.zzcv = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 40:
                        this.zzcw = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 48:
                        this.zzcx = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 56:
                        this.zzcy = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 64:
                        this.zzcz = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 72:
                        this.zzda = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 80:
                        this.zzdb = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 88:
                        this.zzdc = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 96:
                        this.zzdd = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 106:
                        this.zzde = zzarcVar.readString();
                        continue;
                    case 112:
                        this.zzdf = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 120:
                        this.zzdg = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 128:
                        this.zzdh = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 136:
                        this.zzdi = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case IjkMediaMeta.FF_PROFILE_H264_HIGH_444 /* 144 */:
                        this.zzdj = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 152:
                        this.zzdk = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 160:
                        this.zzdl = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 168:
                        this.zzer = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 176:
                        this.zzdm = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 184:
                        this.zzdn = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 194:
                        this.zzes = zzarcVar.readString();
                        continue;
                    case 200:
                        this.zzew = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 208:
                        int m9615cA = zzarcVar.m9615cA();
                        switch (m9615cA) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                this.zzet = Integer.valueOf(m9615cA);
                                continue;
                            default:
                                continue;
                        }
                    case 218:
                        this.zzdo = zzarcVar.readString();
                        continue;
                    case 224:
                        this.zzeu = Boolean.valueOf(zzarcVar.m9613cC());
                        continue;
                    case 234:
                        this.zzdp = zzarcVar.readString();
                        continue;
                    case 242:
                        this.zzev = zzarcVar.readString();
                        continue;
                    case 248:
                        this.zzdq = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 256:
                        this.zzdr = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 264:
                        this.zzds = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 274:
                        this.zzdt = zzarcVar.readString();
                        continue;
                    case 280:
                        this.zzdu = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 288:
                        this.zzdv = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 296:
                        this.zzdw = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 306:
                        if (this.zzdx == null) {
                            this.zzdx = new zzb();
                        }
                        zzarkVar = this.zzdx;
                        break;
                    case 312:
                        this.zzdy = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 320:
                        this.zzdz = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 328:
                        this.zzea = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 336:
                        this.zzeb = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 346:
                        int zzc = zzarn.zzc(zzarcVar, 346);
                        C3250zza[] c3250zzaArr = this.zzep;
                        int length = c3250zzaArr == null ? 0 : c3250zzaArr.length;
                        C3250zza[] c3250zzaArr2 = new C3250zza[zzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzep, 0, c3250zzaArr2, 0, length);
                        }
                        while (length < c3250zzaArr2.length - 1) {
                            c3250zzaArr2[length] = new C3250zza();
                            zzarcVar.zza(c3250zzaArr2[length]);
                            zzarcVar.m9602cw();
                            length++;
                        }
                        c3250zzaArr2[length] = new C3250zza();
                        zzarcVar.zza(c3250zzaArr2[length]);
                        this.zzep = c3250zzaArr2;
                        continue;
                    case 352:
                        this.zzec = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 360:
                        this.zzed = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 370:
                        this.zzee = zzarcVar.readString();
                        continue;
                    case 378:
                        this.zzef = zzarcVar.readString();
                        continue;
                    case 384:
                        int m9615cA2 = zzarcVar.m9615cA();
                        if (m9615cA2 != 1000) {
                            switch (m9615cA2) {
                                case 0:
                                case 1:
                                case 2:
                                    break;
                                default:
                                    continue;
                            }
                        }
                        this.zzeg = Integer.valueOf(m9615cA2);
                    case 392:
                        int m9615cA3 = zzarcVar.m9615cA();
                        if (m9615cA3 != 1000) {
                            switch (m9615cA3) {
                                case 0:
                                case 1:
                                case 2:
                                    break;
                                default:
                                    continue;
                            }
                        }
                        this.zzeh = Integer.valueOf(m9615cA3);
                    case 402:
                        if (this.zzeo == null) {
                            this.zzeo = new C3250zza();
                        }
                        zzarkVar = this.zzeo;
                        break;
                    case 408:
                        this.zzei = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 416:
                        this.zzej = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 424:
                        this.zzek = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 432:
                        this.zzel = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 440:
                        this.zzem = Long.valueOf(zzarcVar.m9599cz());
                        continue;
                    case 448:
                        int m9615cA4 = zzarcVar.m9615cA();
                        if (m9615cA4 != 1000) {
                            switch (m9615cA4) {
                                case 0:
                                case 1:
                                case 2:
                                    break;
                                default:
                                    continue;
                            }
                        }
                        this.zzen = Integer.valueOf(m9615cA4);
                    case 458:
                        if (this.zzeq == null) {
                            this.zzeq = new zzb();
                        }
                        zzarkVar = this.zzeq;
                        break;
                    case 1610:
                        if (this.zzex == null) {
                            this.zzex = new zze();
                        }
                        zzarkVar = this.zzex;
                        break;
                    default:
                        if (super.zza(zzarcVar, m9602cw)) {
                            continue;
                        } else {
                            return this;
                        }
                }
                zzarcVar.zza(zzarkVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzare, com.google.android.gms.internal.zzark
        public int zzx() {
            int zzx = super.zzx();
            String str = this.zzct;
            if (str != null) {
                zzx += zzard.zzs(1, str);
            }
            String str2 = this.zzcs;
            if (str2 != null) {
                zzx += zzard.zzs(2, str2);
            }
            Long l = this.zzcu;
            if (l != null) {
                zzx += zzard.zzf(3, l.longValue());
            }
            Long l2 = this.zzcv;
            if (l2 != null) {
                zzx += zzard.zzf(4, l2.longValue());
            }
            Long l3 = this.zzcw;
            if (l3 != null) {
                zzx += zzard.zzf(5, l3.longValue());
            }
            Long l4 = this.zzcx;
            if (l4 != null) {
                zzx += zzard.zzf(6, l4.longValue());
            }
            Long l5 = this.zzcy;
            if (l5 != null) {
                zzx += zzard.zzf(7, l5.longValue());
            }
            Long l6 = this.zzcz;
            if (l6 != null) {
                zzx += zzard.zzf(8, l6.longValue());
            }
            Long l7 = this.zzda;
            if (l7 != null) {
                zzx += zzard.zzf(9, l7.longValue());
            }
            Long l8 = this.zzdb;
            if (l8 != null) {
                zzx += zzard.zzf(10, l8.longValue());
            }
            Long l9 = this.zzdc;
            if (l9 != null) {
                zzx += zzard.zzf(11, l9.longValue());
            }
            Long l10 = this.zzdd;
            if (l10 != null) {
                zzx += zzard.zzf(12, l10.longValue());
            }
            String str3 = this.zzde;
            if (str3 != null) {
                zzx += zzard.zzs(13, str3);
            }
            Long l11 = this.zzdf;
            if (l11 != null) {
                zzx += zzard.zzf(14, l11.longValue());
            }
            Long l12 = this.zzdg;
            if (l12 != null) {
                zzx += zzard.zzf(15, l12.longValue());
            }
            Long l13 = this.zzdh;
            if (l13 != null) {
                zzx += zzard.zzf(16, l13.longValue());
            }
            Long l14 = this.zzdi;
            if (l14 != null) {
                zzx += zzard.zzf(17, l14.longValue());
            }
            Long l15 = this.zzdj;
            if (l15 != null) {
                zzx += zzard.zzf(18, l15.longValue());
            }
            Long l16 = this.zzdk;
            if (l16 != null) {
                zzx += zzard.zzf(19, l16.longValue());
            }
            Long l17 = this.zzdl;
            if (l17 != null) {
                zzx += zzard.zzf(20, l17.longValue());
            }
            Long l18 = this.zzer;
            if (l18 != null) {
                zzx += zzard.zzf(21, l18.longValue());
            }
            Long l19 = this.zzdm;
            if (l19 != null) {
                zzx += zzard.zzf(22, l19.longValue());
            }
            Long l20 = this.zzdn;
            if (l20 != null) {
                zzx += zzard.zzf(23, l20.longValue());
            }
            String str4 = this.zzes;
            if (str4 != null) {
                zzx += zzard.zzs(24, str4);
            }
            Long l21 = this.zzew;
            if (l21 != null) {
                zzx += zzard.zzf(25, l21.longValue());
            }
            Integer num = this.zzet;
            if (num != null) {
                zzx += zzard.zzag(26, num.intValue());
            }
            String str5 = this.zzdo;
            if (str5 != null) {
                zzx += zzard.zzs(27, str5);
            }
            Boolean bool = this.zzeu;
            if (bool != null) {
                zzx += zzard.zzk(28, bool.booleanValue());
            }
            String str6 = this.zzdp;
            if (str6 != null) {
                zzx += zzard.zzs(29, str6);
            }
            String str7 = this.zzev;
            if (str7 != null) {
                zzx += zzard.zzs(30, str7);
            }
            Long l22 = this.zzdq;
            if (l22 != null) {
                zzx += zzard.zzf(31, l22.longValue());
            }
            Long l23 = this.zzdr;
            if (l23 != null) {
                zzx += zzard.zzf(32, l23.longValue());
            }
            Long l24 = this.zzds;
            if (l24 != null) {
                zzx += zzard.zzf(33, l24.longValue());
            }
            String str8 = this.zzdt;
            if (str8 != null) {
                zzx += zzard.zzs(34, str8);
            }
            Long l25 = this.zzdu;
            if (l25 != null) {
                zzx += zzard.zzf(35, l25.longValue());
            }
            Long l26 = this.zzdv;
            if (l26 != null) {
                zzx += zzard.zzf(36, l26.longValue());
            }
            Long l27 = this.zzdw;
            if (l27 != null) {
                zzx += zzard.zzf(37, l27.longValue());
            }
            zzb zzbVar = this.zzdx;
            if (zzbVar != null) {
                zzx += zzard.zzc(38, zzbVar);
            }
            Long l28 = this.zzdy;
            if (l28 != null) {
                zzx += zzard.zzf(39, l28.longValue());
            }
            Long l29 = this.zzdz;
            if (l29 != null) {
                zzx += zzard.zzf(40, l29.longValue());
            }
            Long l30 = this.zzea;
            if (l30 != null) {
                zzx += zzard.zzf(41, l30.longValue());
            }
            Long l31 = this.zzeb;
            if (l31 != null) {
                zzx += zzard.zzf(42, l31.longValue());
            }
            C3250zza[] c3250zzaArr = this.zzep;
            if (c3250zzaArr != null && c3250zzaArr.length > 0) {
                int i = 0;
                while (true) {
                    C3250zza[] c3250zzaArr2 = this.zzep;
                    if (i >= c3250zzaArr2.length) {
                        break;
                    }
                    C3250zza c3250zza = c3250zzaArr2[i];
                    if (c3250zza != null) {
                        zzx += zzard.zzc(43, c3250zza);
                    }
                    i++;
                }
            }
            Long l32 = this.zzec;
            if (l32 != null) {
                zzx += zzard.zzf(44, l32.longValue());
            }
            Long l33 = this.zzed;
            if (l33 != null) {
                zzx += zzard.zzf(45, l33.longValue());
            }
            String str9 = this.zzee;
            if (str9 != null) {
                zzx += zzard.zzs(46, str9);
            }
            String str10 = this.zzef;
            if (str10 != null) {
                zzx += zzard.zzs(47, str10);
            }
            Integer num2 = this.zzeg;
            if (num2 != null) {
                zzx += zzard.zzag(48, num2.intValue());
            }
            Integer num3 = this.zzeh;
            if (num3 != null) {
                zzx += zzard.zzag(49, num3.intValue());
            }
            C3250zza c3250zza2 = this.zzeo;
            if (c3250zza2 != null) {
                zzx += zzard.zzc(50, c3250zza2);
            }
            Long l34 = this.zzei;
            if (l34 != null) {
                zzx += zzard.zzf(51, l34.longValue());
            }
            Long l35 = this.zzej;
            if (l35 != null) {
                zzx += zzard.zzf(52, l35.longValue());
            }
            Long l36 = this.zzek;
            if (l36 != null) {
                zzx += zzard.zzf(53, l36.longValue());
            }
            Long l37 = this.zzel;
            if (l37 != null) {
                zzx += zzard.zzf(54, l37.longValue());
            }
            Long l38 = this.zzem;
            if (l38 != null) {
                zzx += zzard.zzf(55, l38.longValue());
            }
            Integer num4 = this.zzen;
            if (num4 != null) {
                zzx += zzard.zzag(56, num4.intValue());
            }
            zzb zzbVar2 = this.zzeq;
            if (zzbVar2 != null) {
                zzx += zzard.zzc(57, zzbVar2);
            }
            zze zzeVar = this.zzex;
            return zzeVar != null ? zzx + zzard.zzc(201, zzeVar) : zzx;
        }
    }

    /* loaded from: classes.dex */
    public static final class zzb extends zzare<zzb> {
        public Long zzfk = null;
        public Integer zzfl = null;
        public Boolean zzfm = null;
        public int[] zzfn = zzarn.bqF;
        public Long zzfo = null;

        public zzb() {
            this.bqE = -1;
        }

        @Override // com.google.android.gms.internal.zzare, com.google.android.gms.internal.zzark
        public void zza(zzard zzardVar) throws IOException {
            Long l = this.zzfk;
            if (l != null) {
                zzardVar.zzb(1, l.longValue());
            }
            Integer num = this.zzfl;
            if (num != null) {
                zzardVar.zzae(2, num.intValue());
            }
            Boolean bool = this.zzfm;
            if (bool != null) {
                zzardVar.zzj(3, bool.booleanValue());
            }
            int[] iArr = this.zzfn;
            if (iArr != null && iArr.length > 0) {
                int i = 0;
                while (true) {
                    int[] iArr2 = this.zzfn;
                    if (i >= iArr2.length) {
                        break;
                    }
                    zzardVar.zzae(4, iArr2[i]);
                    i++;
                }
            }
            Long l2 = this.zzfo;
            if (l2 != null) {
                zzardVar.zza(5, l2.longValue());
            }
            super.zza(zzardVar);
        }

        @Override // com.google.android.gms.internal.zzark
        /* renamed from: zzf */
        public zzb zzb(zzarc zzarcVar) throws IOException {
            while (true) {
                int m9602cw = zzarcVar.m9602cw();
                if (m9602cw == 0) {
                    return this;
                }
                if (m9602cw == 8) {
                    this.zzfk = Long.valueOf(zzarcVar.m9599cz());
                } else if (m9602cw == 16) {
                    this.zzfl = Integer.valueOf(zzarcVar.m9615cA());
                } else if (m9602cw == 24) {
                    this.zzfm = Boolean.valueOf(zzarcVar.m9613cC());
                } else if (m9602cw == 32) {
                    int zzc = zzarn.zzc(zzarcVar, 32);
                    int[] iArr = this.zzfn;
                    int length = iArr == null ? 0 : iArr.length;
                    int[] iArr2 = new int[zzc + length];
                    if (length != 0) {
                        System.arraycopy(this.zzfn, 0, iArr2, 0, length);
                    }
                    while (length < iArr2.length - 1) {
                        iArr2[length] = zzarcVar.m9615cA();
                        zzarcVar.m9602cw();
                        length++;
                    }
                    iArr2[length] = zzarcVar.m9615cA();
                    this.zzfn = iArr2;
                } else if (m9602cw == 34) {
                    int zzahc = zzarcVar.zzahc(zzarcVar.m9610cF());
                    int position = zzarcVar.getPosition();
                    int i = 0;
                    while (zzarcVar.m9605cK() > 0) {
                        zzarcVar.m9615cA();
                        i++;
                    }
                    zzarcVar.zzahe(position);
                    int[] iArr3 = this.zzfn;
                    int length2 = iArr3 == null ? 0 : iArr3.length;
                    int[] iArr4 = new int[i + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.zzfn, 0, iArr4, 0, length2);
                    }
                    while (length2 < iArr4.length) {
                        iArr4[length2] = zzarcVar.m9615cA();
                        length2++;
                    }
                    this.zzfn = iArr4;
                    zzarcVar.zzahd(zzahc);
                } else if (m9602cw == 40) {
                    this.zzfo = Long.valueOf(zzarcVar.m9600cy());
                } else if (!super.zza(zzarcVar, m9602cw)) {
                    return this;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzare, com.google.android.gms.internal.zzark
        public int zzx() {
            int[] iArr;
            int zzx = super.zzx();
            Long l = this.zzfk;
            if (l != null) {
                zzx += zzard.zzf(1, l.longValue());
            }
            Integer num = this.zzfl;
            if (num != null) {
                zzx += zzard.zzag(2, num.intValue());
            }
            Boolean bool = this.zzfm;
            if (bool != null) {
                zzx += zzard.zzk(3, bool.booleanValue());
            }
            int[] iArr2 = this.zzfn;
            if (iArr2 != null && iArr2.length > 0) {
                int i = 0;
                int i2 = 0;
                while (true) {
                    iArr = this.zzfn;
                    if (i >= iArr.length) {
                        break;
                    }
                    i2 += zzard.zzahi(iArr[i]);
                    i++;
                }
                zzx = zzx + i2 + (iArr.length * 1);
            }
            Long l2 = this.zzfo;
            return l2 != null ? zzx + zzard.zze(5, l2.longValue()) : zzx;
        }
    }

    /* loaded from: classes.dex */
    public static final class zzc extends zzare<zzc> {
        public byte[] zzfp = null;
        public byte[] zzfq = null;

        public zzc() {
            this.bqE = -1;
        }

        @Override // com.google.android.gms.internal.zzare, com.google.android.gms.internal.zzark
        public void zza(zzard zzardVar) throws IOException {
            byte[] bArr = this.zzfp;
            if (bArr != null) {
                zzardVar.zza(1, bArr);
            }
            byte[] bArr2 = this.zzfq;
            if (bArr2 != null) {
                zzardVar.zza(2, bArr2);
            }
            super.zza(zzardVar);
        }

        @Override // com.google.android.gms.internal.zzark
        /* renamed from: zzg */
        public zzc zzb(zzarc zzarcVar) throws IOException {
            while (true) {
                int m9602cw = zzarcVar.m9602cw();
                if (m9602cw == 0) {
                    return this;
                }
                if (m9602cw == 10) {
                    this.zzfp = zzarcVar.readBytes();
                } else if (m9602cw == 18) {
                    this.zzfq = zzarcVar.readBytes();
                } else if (!super.zza(zzarcVar, m9602cw)) {
                    return this;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzare, com.google.android.gms.internal.zzark
        public int zzx() {
            int zzx = super.zzx();
            byte[] bArr = this.zzfp;
            if (bArr != null) {
                zzx += zzard.zzb(1, bArr);
            }
            byte[] bArr2 = this.zzfq;
            return bArr2 != null ? zzx + zzard.zzb(2, bArr2) : zzx;
        }
    }

    /* loaded from: classes.dex */
    public static final class zzd extends zzare<zzd> {
        public byte[] data = null;
        public byte[] zzfr = null;
        public byte[] zzfs = null;
        public byte[] zzft = null;

        public zzd() {
            this.bqE = -1;
        }

        public static zzd zzd(byte[] bArr) throws zzarj {
            return (zzd) zzark.zza(new zzd(), bArr);
        }

        @Override // com.google.android.gms.internal.zzare, com.google.android.gms.internal.zzark
        public void zza(zzard zzardVar) throws IOException {
            byte[] bArr = this.data;
            if (bArr != null) {
                zzardVar.zza(1, bArr);
            }
            byte[] bArr2 = this.zzfr;
            if (bArr2 != null) {
                zzardVar.zza(2, bArr2);
            }
            byte[] bArr3 = this.zzfs;
            if (bArr3 != null) {
                zzardVar.zza(3, bArr3);
            }
            byte[] bArr4 = this.zzft;
            if (bArr4 != null) {
                zzardVar.zza(4, bArr4);
            }
            super.zza(zzardVar);
        }

        @Override // com.google.android.gms.internal.zzark
        /* renamed from: zzh */
        public zzd zzb(zzarc zzarcVar) throws IOException {
            while (true) {
                int m9602cw = zzarcVar.m9602cw();
                if (m9602cw == 0) {
                    return this;
                }
                if (m9602cw == 10) {
                    this.data = zzarcVar.readBytes();
                } else if (m9602cw == 18) {
                    this.zzfr = zzarcVar.readBytes();
                } else if (m9602cw == 26) {
                    this.zzfs = zzarcVar.readBytes();
                } else if (m9602cw == 34) {
                    this.zzft = zzarcVar.readBytes();
                } else if (!super.zza(zzarcVar, m9602cw)) {
                    return this;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzare, com.google.android.gms.internal.zzark
        public int zzx() {
            int zzx = super.zzx();
            byte[] bArr = this.data;
            if (bArr != null) {
                zzx += zzard.zzb(1, bArr);
            }
            byte[] bArr2 = this.zzfr;
            if (bArr2 != null) {
                zzx += zzard.zzb(2, bArr2);
            }
            byte[] bArr3 = this.zzfs;
            if (bArr3 != null) {
                zzx += zzard.zzb(3, bArr3);
            }
            byte[] bArr4 = this.zzft;
            return bArr4 != null ? zzx + zzard.zzb(4, bArr4) : zzx;
        }
    }

    /* loaded from: classes.dex */
    public static final class zze extends zzare<zze> {
        public Long zzfk = null;
        public String zzfu = null;
        public byte[] zzfv = null;

        public zze() {
            this.bqE = -1;
        }

        @Override // com.google.android.gms.internal.zzare, com.google.android.gms.internal.zzark
        public void zza(zzard zzardVar) throws IOException {
            Long l = this.zzfk;
            if (l != null) {
                zzardVar.zzb(1, l.longValue());
            }
            String str = this.zzfu;
            if (str != null) {
                zzardVar.zzr(3, str);
            }
            byte[] bArr = this.zzfv;
            if (bArr != null) {
                zzardVar.zza(4, bArr);
            }
            super.zza(zzardVar);
        }

        @Override // com.google.android.gms.internal.zzark
        /* renamed from: zzi */
        public zze zzb(zzarc zzarcVar) throws IOException {
            while (true) {
                int m9602cw = zzarcVar.m9602cw();
                if (m9602cw == 0) {
                    return this;
                }
                if (m9602cw == 8) {
                    this.zzfk = Long.valueOf(zzarcVar.m9599cz());
                } else if (m9602cw == 26) {
                    this.zzfu = zzarcVar.readString();
                } else if (m9602cw == 34) {
                    this.zzfv = zzarcVar.readBytes();
                } else if (!super.zza(zzarcVar, m9602cw)) {
                    return this;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzare, com.google.android.gms.internal.zzark
        public int zzx() {
            int zzx = super.zzx();
            Long l = this.zzfk;
            if (l != null) {
                zzx += zzard.zzf(1, l.longValue());
            }
            String str = this.zzfu;
            if (str != null) {
                zzx += zzard.zzs(3, str);
            }
            byte[] bArr = this.zzfv;
            return bArr != null ? zzx + zzard.zzb(4, bArr) : zzx;
        }
    }

    /* loaded from: classes.dex */
    public static final class zzf extends zzare<zzf> {
        public byte[][] zzfw = zzarn.bqL;
        public byte[] zzfr = null;
        public Integer zzfx = null;
        public Integer zzfy = null;

        public zzf() {
            this.bqE = -1;
        }

        @Override // com.google.android.gms.internal.zzare, com.google.android.gms.internal.zzark
        public void zza(zzard zzardVar) throws IOException {
            byte[][] bArr = this.zzfw;
            if (bArr != null && bArr.length > 0) {
                int i = 0;
                while (true) {
                    byte[][] bArr2 = this.zzfw;
                    if (i >= bArr2.length) {
                        break;
                    }
                    byte[] bArr3 = bArr2[i];
                    if (bArr3 != null) {
                        zzardVar.zza(1, bArr3);
                    }
                    i++;
                }
            }
            byte[] bArr4 = this.zzfr;
            if (bArr4 != null) {
                zzardVar.zza(2, bArr4);
            }
            Integer num = this.zzfx;
            if (num != null) {
                zzardVar.zzae(3, num.intValue());
            }
            Integer num2 = this.zzfy;
            if (num2 != null) {
                zzardVar.zzae(4, num2.intValue());
            }
            super.zza(zzardVar);
        }

        @Override // com.google.android.gms.internal.zzark
        /* renamed from: zzj */
        public zzf zzb(zzarc zzarcVar) throws IOException {
            while (true) {
                int m9602cw = zzarcVar.m9602cw();
                if (m9602cw == 0) {
                    return this;
                }
                if (m9602cw == 10) {
                    int zzc = zzarn.zzc(zzarcVar, 10);
                    byte[][] bArr = this.zzfw;
                    int length = bArr == null ? 0 : bArr.length;
                    byte[][] bArr2 = new byte[zzc + length];
                    if (length != 0) {
                        System.arraycopy(this.zzfw, 0, bArr2, 0, length);
                    }
                    while (length < bArr2.length - 1) {
                        bArr2[length] = zzarcVar.readBytes();
                        zzarcVar.m9602cw();
                        length++;
                    }
                    bArr2[length] = zzarcVar.readBytes();
                    this.zzfw = bArr2;
                } else if (m9602cw == 18) {
                    this.zzfr = zzarcVar.readBytes();
                } else if (m9602cw == 24) {
                    int m9615cA = zzarcVar.m9615cA();
                    switch (m9615cA) {
                        case 0:
                        case 1:
                            this.zzfx = Integer.valueOf(m9615cA);
                            continue;
                    }
                } else if (m9602cw == 32) {
                    int m9615cA2 = zzarcVar.m9615cA();
                    switch (m9615cA2) {
                        case 0:
                        case 1:
                            this.zzfy = Integer.valueOf(m9615cA2);
                            continue;
                    }
                } else if (!super.zza(zzarcVar, m9602cw)) {
                    return this;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzare, com.google.android.gms.internal.zzark
        public int zzx() {
            int zzx = super.zzx();
            byte[][] bArr = this.zzfw;
            if (bArr != null && bArr.length > 0) {
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    byte[][] bArr2 = this.zzfw;
                    if (i >= bArr2.length) {
                        break;
                    }
                    byte[] bArr3 = bArr2[i];
                    if (bArr3 != null) {
                        i3++;
                        i2 += zzard.zzbg(bArr3);
                    }
                    i++;
                }
                zzx = zzx + i2 + (i3 * 1);
            }
            byte[] bArr4 = this.zzfr;
            if (bArr4 != null) {
                zzx += zzard.zzb(2, bArr4);
            }
            Integer num = this.zzfx;
            if (num != null) {
                zzx += zzard.zzag(3, num.intValue());
            }
            Integer num2 = this.zzfy;
            return num2 != null ? zzx + zzard.zzag(4, num2.intValue()) : zzx;
        }
    }
}
