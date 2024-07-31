package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public abstract class zzg {

    /* renamed from: BB */
    public static final zzg f2841BB = zza("\t\n\u000b\f\r \u0085\u1680\u2028\u2029\u205f\u3000 \u180e ").zza(zza(8192, 8202));

    /* renamed from: BC */
    public static final zzg f2842BC = zza("\t\n\u000b\f\r \u0085\u1680\u2028\u2029\u205f\u3000").zza(zza(8192, 8198)).zza(zza(8200, 8202));

    /* renamed from: BD */
    public static final zzg f2843BD = zza(0, 127);

    /* renamed from: BE */
    public static final zzg f2844BE;

    /* renamed from: BF */
    public static final zzg f2845BF;

    /* renamed from: BG */
    public static final zzg f2846BG;

    /* renamed from: BH */
    public static final zzg f2847BH;

    /* renamed from: BI */
    public static final zzg f2848BI;

    /* renamed from: BJ */
    public static final zzg f2849BJ;

    /* renamed from: BK */
    public static final zzg f2850BK;

    /* renamed from: BL */
    public static final zzg f2851BL;

    /* renamed from: BM */
    public static final zzg f2852BM;

    /* renamed from: BN */
    public static final zzg f2853BN;

    /* renamed from: BO */
    public static final zzg f2854BO;

    /* renamed from: BP */
    public static final zzg f2855BP;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class zza extends zzg {

        /* renamed from: BW */
        List<zzg> f2862BW;

        zza(List<zzg> list) {
            this.f2862BW = list;
        }

        @Override // com.google.android.gms.common.internal.zzg
        public zzg zza(zzg zzgVar) {
            ArrayList arrayList = new ArrayList(this.f2862BW);
            arrayList.add((zzg) zzac.zzy(zzgVar));
            return new zza(arrayList);
        }

        @Override // com.google.android.gms.common.internal.zzg
        public boolean zzd(char c) {
            for (zzg zzgVar : this.f2862BW) {
                if (zzgVar.zzd(c)) {
                    return true;
                }
            }
            return false;
        }
    }

    static {
        char[] charArray;
        zzg zza2 = zza('0', '9');
        zzg zzgVar = zza2;
        for (char c : "٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray()) {
            zzgVar = zzgVar.zza(zza(c, (char) (c + '\t')));
        }
        f2844BE = zzgVar;
        f2845BF = zza('\t', '\r').zza(zza((char) 28, ' ')).zza(zzc((char) 5760)).zza(zzc((char) 6158)).zza(zza((char) 8192, (char) 8198)).zza(zza((char) 8200, (char) 8203)).zza(zza((char) 8232, (char) 8233)).zza(zzc((char) 8287)).zza(zzc((char) 12288));
        f2846BG = new zzg() { // from class: com.google.android.gms.common.internal.zzg.1
            @Override // com.google.android.gms.common.internal.zzg
            public boolean zzd(char c2) {
                return Character.isDigit(c2);
            }
        };
        f2847BH = new zzg() { // from class: com.google.android.gms.common.internal.zzg.5
            @Override // com.google.android.gms.common.internal.zzg
            public boolean zzd(char c2) {
                return Character.isLetter(c2);
            }
        };
        f2848BI = new zzg() { // from class: com.google.android.gms.common.internal.zzg.6
            @Override // com.google.android.gms.common.internal.zzg
            public boolean zzd(char c2) {
                return Character.isLetterOrDigit(c2);
            }
        };
        f2849BJ = new zzg() { // from class: com.google.android.gms.common.internal.zzg.7
            @Override // com.google.android.gms.common.internal.zzg
            public boolean zzd(char c2) {
                return Character.isUpperCase(c2);
            }
        };
        f2850BK = new zzg() { // from class: com.google.android.gms.common.internal.zzg.8
            @Override // com.google.android.gms.common.internal.zzg
            public boolean zzd(char c2) {
                return Character.isLowerCase(c2);
            }
        };
        f2851BL = zza((char) 0, (char) 31).zza(zza((char) 127, (char) 159));
        f2852BM = zza((char) 0, ' ').zza(zza((char) 127, (char) 160)).zza(zzc((char) 173)).zza(zza((char) 1536, (char) 1539)).zza(zza("\u06dd\u070f\u1680឴឵\u180e")).zza(zza((char) 8192, (char) 8207)).zza(zza((char) 8232, (char) 8239)).zza(zza((char) 8287, (char) 8292)).zza(zza((char) 8298, (char) 8303)).zza(zzc((char) 12288)).zza(zza((char) 55296, (char) 63743)).zza(zza("\ufeff\ufff9\ufffa\ufffb"));
        f2853BN = zza((char) 0, (char) 1273).zza(zzc((char) 1470)).zza(zza((char) 1488, (char) 1514)).zza(zzc((char) 1523)).zza(zzc((char) 1524)).zza(zza((char) 1536, (char) 1791)).zza(zza((char) 1872, (char) 1919)).zza(zza((char) 3584, (char) 3711)).zza(zza((char) 7680, (char) 8367)).zza(zza((char) 8448, (char) 8506)).zza(zza((char) 64336, (char) 65023)).zza(zza((char) 65136, (char) 65279)).zza(zza((char) 65377, (char) 65500));
        f2854BO = new zzg() { // from class: com.google.android.gms.common.internal.zzg.9
            @Override // com.google.android.gms.common.internal.zzg
            public zzg zza(zzg zzgVar2) {
                zzac.zzy(zzgVar2);
                return this;
            }

            @Override // com.google.android.gms.common.internal.zzg
            public boolean zzb(CharSequence charSequence) {
                zzac.zzy(charSequence);
                return true;
            }

            @Override // com.google.android.gms.common.internal.zzg
            public boolean zzd(char c2) {
                return true;
            }
        };
        f2855BP = new zzg() { // from class: com.google.android.gms.common.internal.zzg.10
            @Override // com.google.android.gms.common.internal.zzg
            public zzg zza(zzg zzgVar2) {
                return (zzg) zzac.zzy(zzgVar2);
            }

            @Override // com.google.android.gms.common.internal.zzg
            public boolean zzb(CharSequence charSequence) {
                return charSequence.length() == 0;
            }

            @Override // com.google.android.gms.common.internal.zzg
            public boolean zzd(char c2) {
                return false;
            }
        };
    }

    public static zzg zza(final char c, final char c2) {
        zzac.zzbs(c2 >= c);
        return new zzg() { // from class: com.google.android.gms.common.internal.zzg.4
            @Override // com.google.android.gms.common.internal.zzg
            public boolean zzd(char c3) {
                return c <= c3 && c3 <= c2;
            }
        };
    }

    public static zzg zza(CharSequence charSequence) {
        switch (charSequence.length()) {
            case 0:
                return f2855BP;
            case 1:
                return zzc(charSequence.charAt(0));
            case 2:
                final char charAt = charSequence.charAt(0);
                final char charAt2 = charSequence.charAt(1);
                return new zzg() { // from class: com.google.android.gms.common.internal.zzg.2
                    @Override // com.google.android.gms.common.internal.zzg
                    public boolean zzd(char c) {
                        return c == charAt || c == charAt2;
                    }
                };
            default:
                final char[] charArray = charSequence.toString().toCharArray();
                Arrays.sort(charArray);
                return new zzg() { // from class: com.google.android.gms.common.internal.zzg.3
                    @Override // com.google.android.gms.common.internal.zzg
                    public boolean zzd(char c) {
                        return Arrays.binarySearch(charArray, c) >= 0;
                    }
                };
        }
    }

    public static zzg zzc(final char c) {
        return new zzg() { // from class: com.google.android.gms.common.internal.zzg.11
            @Override // com.google.android.gms.common.internal.zzg
            public zzg zza(zzg zzgVar) {
                return zzgVar.zzd(c) ? zzgVar : super.zza(zzgVar);
            }

            @Override // com.google.android.gms.common.internal.zzg
            public boolean zzd(char c2) {
                return c2 == c;
            }
        };
    }

    public zzg zza(zzg zzgVar) {
        return new zza(Arrays.asList(this, (zzg) zzac.zzy(zzgVar)));
    }

    public boolean zzb(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!zzd(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public abstract boolean zzd(char c);
}
