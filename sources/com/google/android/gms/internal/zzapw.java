package com.google.android.gms.internal;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import org.slf4j.Marker;

/* loaded from: classes.dex */
public final class zzapw {
    public static final zzaot<Class> bmS = new zzaot<Class>() { // from class: com.google.android.gms.internal.zzapw.1
        @Override // com.google.android.gms.internal.zzaot
        public void zza(zzaqa zzaqaVar, Class cls) throws IOException {
            if (cls == null) {
                zzaqaVar.mo9616bx();
                return;
            }
            String valueOf = String.valueOf(cls.getName());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 76);
            sb.append("Attempted to serialize java.lang.Class: ");
            sb.append(valueOf);
            sb.append(". Forgot to register a type adapter?");
            throw new UnsupportedOperationException(sb.toString());
        }

        @Override // com.google.android.gms.internal.zzaot
        /* renamed from: zzo */
        public Class zzb(zzapy zzapyVar) throws IOException {
            if (zzapyVar.mo9627bn() == zzapz.NULL) {
                zzapyVar.nextNull();
                return null;
            }
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    };
    public static final zzaou bmT = zza(Class.class, bmS);
    public static final zzaot<BitSet> bmU = new zzaot<BitSet>() { // from class: com.google.android.gms.internal.zzapw.12
        @Override // com.google.android.gms.internal.zzaot
        public void zza(zzaqa zzaqaVar, BitSet bitSet) throws IOException {
            if (bitSet == null) {
                zzaqaVar.mo9616bx();
                return;
            }
            zzaqaVar.mo9620bt();
            for (int i = 0; i < bitSet.length(); i++) {
                zzaqaVar.zzcu(bitSet.get(i) ? 1L : 0L);
            }
            zzaqaVar.mo9619bu();
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0058, code lost:
            if (java.lang.Integer.parseInt(r1) != 0) goto L16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
            r5 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0083, code lost:
            if (r7.nextInt() != 0) goto L16;
         */
        @Override // com.google.android.gms.internal.zzaot
        /* renamed from: zzx */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.util.BitSet zzb(com.google.android.gms.internal.zzapy r7) throws java.io.IOException {
            /*
                r6 = this;
                com.google.android.gms.internal.zzapz r0 = r7.mo9627bn()
                com.google.android.gms.internal.zzapz r1 = com.google.android.gms.internal.zzapz.NULL
                if (r0 != r1) goto Ld
                r7.nextNull()
                r7 = 0
                return r7
            Ld:
                java.util.BitSet r0 = new java.util.BitSet
                r0.<init>()
                r7.beginArray()
                com.google.android.gms.internal.zzapz r1 = r7.mo9627bn()
                r2 = 0
                r3 = 0
            L1b:
                com.google.android.gms.internal.zzapz r4 = com.google.android.gms.internal.zzapz.END_ARRAY
                if (r1 == r4) goto L91
                int[] r4 = com.google.android.gms.internal.zzapw.C129326.bmF
                int r5 = r1.ordinal()
                r4 = r4[r5]
                r5 = 1
                switch(r4) {
                    case 1: goto L7f;
                    case 2: goto L7a;
                    case 3: goto L50;
                    default: goto L2b;
                }
            L2b:
                com.google.android.gms.internal.zzaoq r7 = new com.google.android.gms.internal.zzaoq
                java.lang.String r0 = java.lang.String.valueOf(r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = java.lang.String.valueOf(r0)
                int r2 = r2.length()
                int r2 = r2 + 27
                r1.<init>(r2)
                java.lang.String r2 = "Invalid bitset value type: "
                r1.append(r2)
                r1.append(r0)
                java.lang.String r0 = r1.toString()
                r7.<init>(r0)
                throw r7
            L50:
                java.lang.String r1 = r7.nextString()
                int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L5d
                if (r1 == 0) goto L5b
                goto L85
            L5b:
                r5 = 0
                goto L85
            L5d:
                com.google.android.gms.internal.zzaoq r7 = new com.google.android.gms.internal.zzaoq
                java.lang.String r0 = "Error: Expecting: bitset number value (1, 0), Found: "
                java.lang.String r1 = java.lang.String.valueOf(r1)
                int r2 = r1.length()
                if (r2 == 0) goto L70
                java.lang.String r0 = r0.concat(r1)
                goto L76
            L70:
                java.lang.String r1 = new java.lang.String
                r1.<init>(r0)
                r0 = r1
            L76:
                r7.<init>(r0)
                throw r7
            L7a:
                boolean r5 = r7.nextBoolean()
                goto L85
            L7f:
                int r1 = r7.nextInt()
                if (r1 == 0) goto L5b
            L85:
                if (r5 == 0) goto L8a
                r0.set(r3)
            L8a:
                int r3 = r3 + 1
                com.google.android.gms.internal.zzapz r1 = r7.mo9627bn()
                goto L1b
            L91:
                r7.endArray()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzapw.C127712.zzb(com.google.android.gms.internal.zzapy):java.util.BitSet");
        }
    };
    public static final zzaou bmV = zza(BitSet.class, bmU);
    public static final zzaot<Boolean> bmW = new zzaot<Boolean>() { // from class: com.google.android.gms.internal.zzapw.23
        @Override // com.google.android.gms.internal.zzaot
        public void zza(zzaqa zzaqaVar, Boolean bool) throws IOException {
            if (bool == null) {
                zzaqaVar.mo9616bx();
            } else {
                zzaqaVar.zzdf(bool.booleanValue());
            }
        }

        @Override // com.google.android.gms.internal.zzaot
        /* renamed from: zzae */
        public Boolean zzb(zzapy zzapyVar) throws IOException {
            if (zzapyVar.mo9627bn() != zzapz.NULL) {
                return zzapyVar.mo9627bn() == zzapz.STRING ? Boolean.valueOf(Boolean.parseBoolean(zzapyVar.nextString())) : Boolean.valueOf(zzapyVar.nextBoolean());
            }
            zzapyVar.nextNull();
            return null;
        }
    };
    public static final zzaot<Boolean> bmX = new zzaot<Boolean>() { // from class: com.google.android.gms.internal.zzapw.27
        @Override // com.google.android.gms.internal.zzaot
        public void zza(zzaqa zzaqaVar, Boolean bool) throws IOException {
            zzaqaVar.zzut(bool == null ? "null" : bool.toString());
        }

        @Override // com.google.android.gms.internal.zzaot
        /* renamed from: zzae */
        public Boolean zzb(zzapy zzapyVar) throws IOException {
            if (zzapyVar.mo9627bn() == zzapz.NULL) {
                zzapyVar.nextNull();
                return null;
            }
            return Boolean.valueOf(zzapyVar.nextString());
        }
    };
    public static final zzaou bmY = zza(Boolean.TYPE, Boolean.class, bmW);
    public static final zzaot<Number> bmZ = new zzaot<Number>() { // from class: com.google.android.gms.internal.zzapw.28
        @Override // com.google.android.gms.internal.zzaot
        public void zza(zzaqa zzaqaVar, Number number) throws IOException {
            zzaqaVar.zza(number);
        }

        @Override // com.google.android.gms.internal.zzaot
        /* renamed from: zzg */
        public Number zzb(zzapy zzapyVar) throws IOException {
            if (zzapyVar.mo9627bn() == zzapz.NULL) {
                zzapyVar.nextNull();
                return null;
            }
            try {
                return Byte.valueOf((byte) zzapyVar.nextInt());
            } catch (NumberFormatException e) {
                throw new zzaoq(e);
            }
        }
    };
    public static final zzaou bna = zza(Byte.TYPE, Byte.class, bmZ);
    public static final zzaot<Number> bnb = new zzaot<Number>() { // from class: com.google.android.gms.internal.zzapw.29
        @Override // com.google.android.gms.internal.zzaot
        public void zza(zzaqa zzaqaVar, Number number) throws IOException {
            zzaqaVar.zza(number);
        }

        @Override // com.google.android.gms.internal.zzaot
        /* renamed from: zzg */
        public Number zzb(zzapy zzapyVar) throws IOException {
            if (zzapyVar.mo9627bn() == zzapz.NULL) {
                zzapyVar.nextNull();
                return null;
            }
            try {
                return Short.valueOf((short) zzapyVar.nextInt());
            } catch (NumberFormatException e) {
                throw new zzaoq(e);
            }
        }
    };
    public static final zzaou bnc = zza(Short.TYPE, Short.class, bnb);
    public static final zzaot<Number> bnd = new zzaot<Number>() { // from class: com.google.android.gms.internal.zzapw.30
        @Override // com.google.android.gms.internal.zzaot
        public void zza(zzaqa zzaqaVar, Number number) throws IOException {
            zzaqaVar.zza(number);
        }

        @Override // com.google.android.gms.internal.zzaot
        /* renamed from: zzg */
        public Number zzb(zzapy zzapyVar) throws IOException {
            if (zzapyVar.mo9627bn() == zzapz.NULL) {
                zzapyVar.nextNull();
                return null;
            }
            try {
                return Integer.valueOf(zzapyVar.nextInt());
            } catch (NumberFormatException e) {
                throw new zzaoq(e);
            }
        }
    };
    public static final zzaou bne = zza(Integer.TYPE, Integer.class, bnd);
    public static final zzaot<Number> bnf = new zzaot<Number>() { // from class: com.google.android.gms.internal.zzapw.31
        @Override // com.google.android.gms.internal.zzaot
        public void zza(zzaqa zzaqaVar, Number number) throws IOException {
            zzaqaVar.zza(number);
        }

        @Override // com.google.android.gms.internal.zzaot
        /* renamed from: zzg */
        public Number zzb(zzapy zzapyVar) throws IOException {
            if (zzapyVar.mo9627bn() == zzapz.NULL) {
                zzapyVar.nextNull();
                return null;
            }
            try {
                return Long.valueOf(zzapyVar.nextLong());
            } catch (NumberFormatException e) {
                throw new zzaoq(e);
            }
        }
    };
    public static final zzaot<Number> bng = new zzaot<Number>() { // from class: com.google.android.gms.internal.zzapw.32
        @Override // com.google.android.gms.internal.zzaot
        public void zza(zzaqa zzaqaVar, Number number) throws IOException {
            zzaqaVar.zza(number);
        }

        @Override // com.google.android.gms.internal.zzaot
        /* renamed from: zzg */
        public Number zzb(zzapy zzapyVar) throws IOException {
            if (zzapyVar.mo9627bn() == zzapz.NULL) {
                zzapyVar.nextNull();
                return null;
            }
            return Float.valueOf((float) zzapyVar.nextDouble());
        }
    };
    public static final zzaot<Number> bnh = new zzaot<Number>() { // from class: com.google.android.gms.internal.zzapw.2
        @Override // com.google.android.gms.internal.zzaot
        public void zza(zzaqa zzaqaVar, Number number) throws IOException {
            zzaqaVar.zza(number);
        }

        @Override // com.google.android.gms.internal.zzaot
        /* renamed from: zzg */
        public Number zzb(zzapy zzapyVar) throws IOException {
            if (zzapyVar.mo9627bn() == zzapz.NULL) {
                zzapyVar.nextNull();
                return null;
            }
            return Double.valueOf(zzapyVar.nextDouble());
        }
    };
    public static final zzaot<Number> bni = new zzaot<Number>() { // from class: com.google.android.gms.internal.zzapw.3
        @Override // com.google.android.gms.internal.zzaot
        public void zza(zzaqa zzaqaVar, Number number) throws IOException {
            zzaqaVar.zza(number);
        }

        @Override // com.google.android.gms.internal.zzaot
        /* renamed from: zzg */
        public Number zzb(zzapy zzapyVar) throws IOException {
            zzapz mo9627bn = zzapyVar.mo9627bn();
            int i = C129326.bmF[mo9627bn.ordinal()];
            if (i != 1) {
                if (i == 4) {
                    zzapyVar.nextNull();
                    return null;
                }
                String valueOf = String.valueOf(mo9627bn);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
                sb.append("Expecting number, got: ");
                sb.append(valueOf);
                throw new zzaoq(sb.toString());
            }
            return new zzape(zzapyVar.nextString());
        }
    };
    public static final zzaou bnj = zza(Number.class, bni);
    public static final zzaot<Character> bnk = new zzaot<Character>() { // from class: com.google.android.gms.internal.zzapw.4
        @Override // com.google.android.gms.internal.zzaot
        public void zza(zzaqa zzaqaVar, Character ch) throws IOException {
            zzaqaVar.zzut(ch == null ? null : String.valueOf(ch));
        }

        @Override // com.google.android.gms.internal.zzaot
        /* renamed from: zzp */
        public Character zzb(zzapy zzapyVar) throws IOException {
            if (zzapyVar.mo9627bn() == zzapz.NULL) {
                zzapyVar.nextNull();
                return null;
            }
            String nextString = zzapyVar.nextString();
            if (nextString.length() != 1) {
                String valueOf = String.valueOf(nextString);
                throw new zzaoq(valueOf.length() != 0 ? "Expecting character, got: ".concat(valueOf) : new String("Expecting character, got: "));
            }
            return Character.valueOf(nextString.charAt(0));
        }
    };
    public static final zzaou bnl = zza(Character.TYPE, Character.class, bnk);
    public static final zzaot<String> bnm = new zzaot<String>() { // from class: com.google.android.gms.internal.zzapw.5
        @Override // com.google.android.gms.internal.zzaot
        public void zza(zzaqa zzaqaVar, String str) throws IOException {
            zzaqaVar.zzut(str);
        }

        @Override // com.google.android.gms.internal.zzaot
        /* renamed from: zzq */
        public String zzb(zzapy zzapyVar) throws IOException {
            zzapz mo9627bn = zzapyVar.mo9627bn();
            if (mo9627bn != zzapz.NULL) {
                return mo9627bn == zzapz.BOOLEAN ? Boolean.toString(zzapyVar.nextBoolean()) : zzapyVar.nextString();
            }
            zzapyVar.nextNull();
            return null;
        }
    };
    public static final zzaot<BigDecimal> bnn = new zzaot<BigDecimal>() { // from class: com.google.android.gms.internal.zzapw.6
        @Override // com.google.android.gms.internal.zzaot
        public void zza(zzaqa zzaqaVar, BigDecimal bigDecimal) throws IOException {
            zzaqaVar.zza(bigDecimal);
        }

        @Override // com.google.android.gms.internal.zzaot
        /* renamed from: zzr */
        public BigDecimal zzb(zzapy zzapyVar) throws IOException {
            if (zzapyVar.mo9627bn() == zzapz.NULL) {
                zzapyVar.nextNull();
                return null;
            }
            try {
                return new BigDecimal(zzapyVar.nextString());
            } catch (NumberFormatException e) {
                throw new zzaoq(e);
            }
        }
    };
    public static final zzaot<BigInteger> bno = new zzaot<BigInteger>() { // from class: com.google.android.gms.internal.zzapw.7
        @Override // com.google.android.gms.internal.zzaot
        public void zza(zzaqa zzaqaVar, BigInteger bigInteger) throws IOException {
            zzaqaVar.zza(bigInteger);
        }

        @Override // com.google.android.gms.internal.zzaot
        /* renamed from: zzs */
        public BigInteger zzb(zzapy zzapyVar) throws IOException {
            if (zzapyVar.mo9627bn() == zzapz.NULL) {
                zzapyVar.nextNull();
                return null;
            }
            try {
                return new BigInteger(zzapyVar.nextString());
            } catch (NumberFormatException e) {
                throw new zzaoq(e);
            }
        }
    };
    public static final zzaou bnp = zza(String.class, bnm);
    public static final zzaot<StringBuilder> bnq = new zzaot<StringBuilder>() { // from class: com.google.android.gms.internal.zzapw.8
        @Override // com.google.android.gms.internal.zzaot
        public void zza(zzaqa zzaqaVar, StringBuilder sb) throws IOException {
            zzaqaVar.zzut(sb == null ? null : sb.toString());
        }

        @Override // com.google.android.gms.internal.zzaot
        /* renamed from: zzt */
        public StringBuilder zzb(zzapy zzapyVar) throws IOException {
            if (zzapyVar.mo9627bn() == zzapz.NULL) {
                zzapyVar.nextNull();
                return null;
            }
            return new StringBuilder(zzapyVar.nextString());
        }
    };
    public static final zzaou bnr = zza(StringBuilder.class, bnq);
    public static final zzaot<StringBuffer> bns = new zzaot<StringBuffer>() { // from class: com.google.android.gms.internal.zzapw.9
        @Override // com.google.android.gms.internal.zzaot
        public void zza(zzaqa zzaqaVar, StringBuffer stringBuffer) throws IOException {
            zzaqaVar.zzut(stringBuffer == null ? null : stringBuffer.toString());
        }

        @Override // com.google.android.gms.internal.zzaot
        /* renamed from: zzu */
        public StringBuffer zzb(zzapy zzapyVar) throws IOException {
            if (zzapyVar.mo9627bn() == zzapz.NULL) {
                zzapyVar.nextNull();
                return null;
            }
            return new StringBuffer(zzapyVar.nextString());
        }
    };
    public static final zzaou bnt = zza(StringBuffer.class, bns);
    public static final zzaot<URL> bnu = new zzaot<URL>() { // from class: com.google.android.gms.internal.zzapw.10
        @Override // com.google.android.gms.internal.zzaot
        public void zza(zzaqa zzaqaVar, URL url) throws IOException {
            zzaqaVar.zzut(url == null ? null : url.toExternalForm());
        }

        @Override // com.google.android.gms.internal.zzaot
        /* renamed from: zzv */
        public URL zzb(zzapy zzapyVar) throws IOException {
            if (zzapyVar.mo9627bn() == zzapz.NULL) {
                zzapyVar.nextNull();
                return null;
            }
            String nextString = zzapyVar.nextString();
            if ("null".equals(nextString)) {
                return null;
            }
            return new URL(nextString);
        }
    };
    public static final zzaou bnv = zza(URL.class, bnu);
    public static final zzaot<URI> bnw = new zzaot<URI>() { // from class: com.google.android.gms.internal.zzapw.11
        @Override // com.google.android.gms.internal.zzaot
        public void zza(zzaqa zzaqaVar, URI uri) throws IOException {
            zzaqaVar.zzut(uri == null ? null : uri.toASCIIString());
        }

        @Override // com.google.android.gms.internal.zzaot
        /* renamed from: zzw */
        public URI zzb(zzapy zzapyVar) throws IOException {
            if (zzapyVar.mo9627bn() == zzapz.NULL) {
                zzapyVar.nextNull();
                return null;
            }
            try {
                String nextString = zzapyVar.nextString();
                if ("null".equals(nextString)) {
                    return null;
                }
                return new URI(nextString);
            } catch (URISyntaxException e) {
                throw new zzaoi(e);
            }
        }
    };
    public static final zzaou bnx = zza(URI.class, bnw);
    public static final zzaot<InetAddress> bny = new zzaot<InetAddress>() { // from class: com.google.android.gms.internal.zzapw.13
        @Override // com.google.android.gms.internal.zzaot
        public void zza(zzaqa zzaqaVar, InetAddress inetAddress) throws IOException {
            zzaqaVar.zzut(inetAddress == null ? null : inetAddress.getHostAddress());
        }

        @Override // com.google.android.gms.internal.zzaot
        /* renamed from: zzy */
        public InetAddress zzb(zzapy zzapyVar) throws IOException {
            if (zzapyVar.mo9627bn() == zzapz.NULL) {
                zzapyVar.nextNull();
                return null;
            }
            return InetAddress.getByName(zzapyVar.nextString());
        }
    };
    public static final zzaou bnz = zzb(InetAddress.class, bny);
    public static final zzaot<UUID> bnA = new zzaot<UUID>() { // from class: com.google.android.gms.internal.zzapw.14
        @Override // com.google.android.gms.internal.zzaot
        public void zza(zzaqa zzaqaVar, UUID uuid) throws IOException {
            zzaqaVar.zzut(uuid == null ? null : uuid.toString());
        }

        @Override // com.google.android.gms.internal.zzaot
        /* renamed from: zzz */
        public UUID zzb(zzapy zzapyVar) throws IOException {
            if (zzapyVar.mo9627bn() == zzapz.NULL) {
                zzapyVar.nextNull();
                return null;
            }
            return UUID.fromString(zzapyVar.nextString());
        }
    };
    public static final zzaou bnB = zza(UUID.class, bnA);
    public static final zzaou bnC = new zzaou() { // from class: com.google.android.gms.internal.zzapw.15
        @Override // com.google.android.gms.internal.zzaou
        public <T> zzaot<T> zza(zzaob zzaobVar, zzapx<T> zzapxVar) {
            if (zzapxVar.m9638by() != Timestamp.class) {
                return null;
            }
            final zzaot<T> zzk = zzaobVar.zzk(Date.class);
            return (zzaot<T>) new zzaot<Timestamp>() { // from class: com.google.android.gms.internal.zzapw.15.1
                @Override // com.google.android.gms.internal.zzaot
                public void zza(zzaqa zzaqaVar, Timestamp timestamp) throws IOException {
                    zzk.zza(zzaqaVar, timestamp);
                }

                @Override // com.google.android.gms.internal.zzaot
                /* renamed from: zzaa */
                public Timestamp zzb(zzapy zzapyVar) throws IOException {
                    Date date = (Date) zzk.zzb(zzapyVar);
                    if (date != null) {
                        return new Timestamp(date.getTime());
                    }
                    return null;
                }
            };
        }
    };
    public static final zzaot<Calendar> bnD = new zzaot<Calendar>() { // from class: com.google.android.gms.internal.zzapw.16
        @Override // com.google.android.gms.internal.zzaot
        public void zza(zzaqa zzaqaVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                zzaqaVar.mo9616bx();
                return;
            }
            zzaqaVar.mo9618bv();
            zzaqaVar.zzus("year");
            zzaqaVar.zzcu(calendar.get(1));
            zzaqaVar.zzus("month");
            zzaqaVar.zzcu(calendar.get(2));
            zzaqaVar.zzus("dayOfMonth");
            zzaqaVar.zzcu(calendar.get(5));
            zzaqaVar.zzus("hourOfDay");
            zzaqaVar.zzcu(calendar.get(11));
            zzaqaVar.zzus("minute");
            zzaqaVar.zzcu(calendar.get(12));
            zzaqaVar.zzus("second");
            zzaqaVar.zzcu(calendar.get(13));
            zzaqaVar.mo9617bw();
        }

        @Override // com.google.android.gms.internal.zzaot
        /* renamed from: zzab */
        public Calendar zzb(zzapy zzapyVar) throws IOException {
            if (zzapyVar.mo9627bn() == zzapz.NULL) {
                zzapyVar.nextNull();
                return null;
            }
            zzapyVar.beginObject();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (zzapyVar.mo9627bn() != zzapz.END_OBJECT) {
                String nextName = zzapyVar.nextName();
                int nextInt = zzapyVar.nextInt();
                if ("year".equals(nextName)) {
                    i = nextInt;
                } else if ("month".equals(nextName)) {
                    i2 = nextInt;
                } else if ("dayOfMonth".equals(nextName)) {
                    i3 = nextInt;
                } else if ("hourOfDay".equals(nextName)) {
                    i4 = nextInt;
                } else if ("minute".equals(nextName)) {
                    i5 = nextInt;
                } else if ("second".equals(nextName)) {
                    i6 = nextInt;
                }
            }
            zzapyVar.endObject();
            return new GregorianCalendar(i, i2, i3, i4, i5, i6);
        }
    };
    public static final zzaou bnE = zzb(Calendar.class, GregorianCalendar.class, bnD);
    public static final zzaot<Locale> bnF = new zzaot<Locale>() { // from class: com.google.android.gms.internal.zzapw.17
        @Override // com.google.android.gms.internal.zzaot
        public void zza(zzaqa zzaqaVar, Locale locale) throws IOException {
            zzaqaVar.zzut(locale == null ? null : locale.toString());
        }

        @Override // com.google.android.gms.internal.zzaot
        /* renamed from: zzac */
        public Locale zzb(zzapy zzapyVar) throws IOException {
            if (zzapyVar.mo9627bn() == zzapz.NULL) {
                zzapyVar.nextNull();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(zzapyVar.nextString(), "_");
            String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            return (nextToken2 == null && nextToken3 == null) ? new Locale(nextToken) : nextToken3 == null ? new Locale(nextToken, nextToken2) : new Locale(nextToken, nextToken2, nextToken3);
        }
    };
    public static final zzaou bnG = zza(Locale.class, bnF);
    public static final zzaot<zzaoh> bnH = new zzaot<zzaoh>() { // from class: com.google.android.gms.internal.zzapw.18
        @Override // com.google.android.gms.internal.zzaot
        public void zza(zzaqa zzaqaVar, zzaoh zzaohVar) throws IOException {
            if (zzaohVar == null || zzaohVar.m9665aV()) {
                zzaqaVar.mo9616bx();
            } else if (zzaohVar.m9666aU()) {
                zzaon m9662aY = zzaohVar.m9662aY();
                if (m9662aY.m9657bb()) {
                    zzaqaVar.zza(m9662aY.mo9661aQ());
                } else if (m9662aY.m9658ba()) {
                    zzaqaVar.zzdf(m9662aY.getAsBoolean());
                } else {
                    zzaqaVar.zzut(m9662aY.mo9660aR());
                }
            } else if (zzaohVar.m9668aS()) {
                zzaqaVar.mo9620bt();
                Iterator<zzaoh> it = zzaohVar.m9663aX().iterator();
                while (it.hasNext()) {
                    zza(zzaqaVar, it.next());
                }
                zzaqaVar.mo9619bu();
            } else if (!zzaohVar.m9667aT()) {
                String valueOf = String.valueOf(zzaohVar.getClass());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 15);
                sb.append("Couldn't write ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            } else {
                zzaqaVar.mo9618bv();
                for (Map.Entry<String, zzaoh> entry : zzaohVar.m9664aW().entrySet()) {
                    zzaqaVar.zzus(entry.getKey());
                    zza(zzaqaVar, entry.getValue());
                }
                zzaqaVar.mo9617bw();
            }
        }

        @Override // com.google.android.gms.internal.zzaot
        /* renamed from: zzad */
        public zzaoh zzb(zzapy zzapyVar) throws IOException {
            switch (C129326.bmF[zzapyVar.mo9627bn().ordinal()]) {
                case 1:
                    return new zzaon((Number) new zzape(zzapyVar.nextString()));
                case 2:
                    return new zzaon(Boolean.valueOf(zzapyVar.nextBoolean()));
                case 3:
                    return new zzaon(zzapyVar.nextString());
                case 4:
                    zzapyVar.nextNull();
                    return zzaoj.bld;
                case 5:
                    zzaoe zzaoeVar = new zzaoe();
                    zzapyVar.beginArray();
                    while (zzapyVar.hasNext()) {
                        zzaoeVar.zzc((zzaoh) zzb(zzapyVar));
                    }
                    zzapyVar.endArray();
                    return zzaoeVar;
                case 6:
                    zzaok zzaokVar = new zzaok();
                    zzapyVar.beginObject();
                    while (zzapyVar.hasNext()) {
                        zzaokVar.zza(zzapyVar.nextName(), (zzaoh) zzb(zzapyVar));
                    }
                    zzapyVar.endObject();
                    return zzaokVar;
                default:
                    throw new IllegalArgumentException();
            }
        }
    };
    public static final zzaou bnI = zzb(zzaoh.class, bnH);
    public static final zzaou bnJ = new zzaou() { // from class: com.google.android.gms.internal.zzapw.19
        @Override // com.google.android.gms.internal.zzaou
        public <T> zzaot<T> zza(zzaob zzaobVar, zzapx<T> zzapxVar) {
            Class m9638by = zzapxVar.m9638by();
            if (!Enum.class.isAssignableFrom(m9638by) || m9638by == Enum.class) {
                return null;
            }
            if (!m9638by.isEnum()) {
                m9638by = (Class<? super Object>) m9638by.getSuperclass();
            }
            return new zza(m9638by);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.android.gms.internal.zzapw$26 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C129326 {
        static final /* synthetic */ int[] bmF = new int[zzapz.values().length];

        static {
            try {
                bmF[zzapz.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                bmF[zzapz.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                bmF[zzapz.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                bmF[zzapz.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                bmF[zzapz.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                bmF[zzapz.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                bmF[zzapz.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                bmF[zzapz.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                bmF[zzapz.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                bmF[zzapz.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class zza<T extends Enum<T>> extends zzaot<T> {
        private final Map<String, T> bnT = new HashMap();
        private final Map<T, String> bnU = new HashMap();

        public zza(Class<T> cls) {
            T[] enumConstants;
            try {
                for (T t : cls.getEnumConstants()) {
                    String name = t.name();
                    zzaow zzaowVar = (zzaow) cls.getField(name).getAnnotation(zzaow.class);
                    if (zzaowVar != null) {
                        name = zzaowVar.value();
                        for (String str : zzaowVar.m9654be()) {
                            this.bnT.put(str, t);
                        }
                    }
                    this.bnT.put(name, t);
                    this.bnU.put(t, name);
                }
            } catch (NoSuchFieldException unused) {
                throw new AssertionError();
            }
        }

        public void zza(zzaqa zzaqaVar, T t) throws IOException {
            zzaqaVar.zzut(t == null ? null : this.bnU.get(t));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.zzaot
        public /* bridge */ /* synthetic */ void zza(zzaqa zzaqaVar, Object obj) throws IOException {
            zza(zzaqaVar, (zzaqa) ((Enum) obj));
        }

        @Override // com.google.android.gms.internal.zzaot
        /* renamed from: zzaf */
        public T zzb(zzapy zzapyVar) throws IOException {
            if (zzapyVar.mo9627bn() == zzapz.NULL) {
                zzapyVar.nextNull();
                return null;
            }
            return this.bnT.get(zzapyVar.nextString());
        }
    }

    public static <TT> zzaou zza(final zzapx<TT> zzapxVar, final zzaot<TT> zzaotVar) {
        return new zzaou() { // from class: com.google.android.gms.internal.zzapw.20
            @Override // com.google.android.gms.internal.zzaou
            public <T> zzaot<T> zza(zzaob zzaobVar, zzapx<T> zzapxVar2) {
                if (zzapxVar2.equals(zzapx.this)) {
                    return zzaotVar;
                }
                return null;
            }
        };
    }

    public static <TT> zzaou zza(final Class<TT> cls, final zzaot<TT> zzaotVar) {
        return new zzaou() { // from class: com.google.android.gms.internal.zzapw.21
            public String toString() {
                String valueOf = String.valueOf(cls.getName());
                String valueOf2 = String.valueOf(zzaotVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23 + String.valueOf(valueOf2).length());
                sb.append("Factory[type=");
                sb.append(valueOf);
                sb.append(",adapter=");
                sb.append(valueOf2);
                sb.append("]");
                return sb.toString();
            }

            @Override // com.google.android.gms.internal.zzaou
            public <T> zzaot<T> zza(zzaob zzaobVar, zzapx<T> zzapxVar) {
                if (zzapxVar.m9638by() == cls) {
                    return zzaotVar;
                }
                return null;
            }
        };
    }

    public static <TT> zzaou zza(final Class<TT> cls, final Class<TT> cls2, final zzaot<? super TT> zzaotVar) {
        return new zzaou() { // from class: com.google.android.gms.internal.zzapw.22
            public String toString() {
                String valueOf = String.valueOf(cls2.getName());
                String valueOf2 = String.valueOf(cls.getName());
                String valueOf3 = String.valueOf(zzaotVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 24 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length());
                sb.append("Factory[type=");
                sb.append(valueOf);
                sb.append(Marker.ANY_NON_NULL_MARKER);
                sb.append(valueOf2);
                sb.append(",adapter=");
                sb.append(valueOf3);
                sb.append("]");
                return sb.toString();
            }

            @Override // com.google.android.gms.internal.zzaou
            public <T> zzaot<T> zza(zzaob zzaobVar, zzapx<T> zzapxVar) {
                Class<? super T> m9638by = zzapxVar.m9638by();
                if (m9638by == cls || m9638by == cls2) {
                    return zzaotVar;
                }
                return null;
            }
        };
    }

    public static <TT> zzaou zzb(final Class<TT> cls, final zzaot<TT> zzaotVar) {
        return new zzaou() { // from class: com.google.android.gms.internal.zzapw.25
            public String toString() {
                String valueOf = String.valueOf(cls.getName());
                String valueOf2 = String.valueOf(zzaotVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 32 + String.valueOf(valueOf2).length());
                sb.append("Factory[typeHierarchy=");
                sb.append(valueOf);
                sb.append(",adapter=");
                sb.append(valueOf2);
                sb.append("]");
                return sb.toString();
            }

            @Override // com.google.android.gms.internal.zzaou
            public <T> zzaot<T> zza(zzaob zzaobVar, zzapx<T> zzapxVar) {
                if (cls.isAssignableFrom(zzapxVar.m9638by())) {
                    return zzaotVar;
                }
                return null;
            }
        };
    }

    public static <TT> zzaou zzb(final Class<TT> cls, final Class<? extends TT> cls2, final zzaot<? super TT> zzaotVar) {
        return new zzaou() { // from class: com.google.android.gms.internal.zzapw.24
            public String toString() {
                String valueOf = String.valueOf(cls.getName());
                String valueOf2 = String.valueOf(cls2.getName());
                String valueOf3 = String.valueOf(zzaotVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 24 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length());
                sb.append("Factory[type=");
                sb.append(valueOf);
                sb.append(Marker.ANY_NON_NULL_MARKER);
                sb.append(valueOf2);
                sb.append(",adapter=");
                sb.append(valueOf3);
                sb.append("]");
                return sb.toString();
            }

            @Override // com.google.android.gms.internal.zzaou
            public <T> zzaot<T> zza(zzaob zzaobVar, zzapx<T> zzapxVar) {
                Class<? super T> m9638by = zzapxVar.m9638by();
                if (m9638by == cls || m9638by == cls2) {
                    return zzaotVar;
                }
                return null;
            }
        };
    }
}
