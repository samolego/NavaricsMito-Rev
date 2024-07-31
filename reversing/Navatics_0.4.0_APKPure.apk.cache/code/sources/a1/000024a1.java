package okhttp3;

import com.senseplay.sdk.config.CacheConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: CipherSuite.java */
/* renamed from: okhttp3.h, reason: use source file name */
/* loaded from: classes2.dex */
public final class CipherSuite {

    /* renamed from: bk */
    final String f10141bk;

    /* renamed from: a */
    static final Comparator<String> f10052a = new Comparator<String>() { // from class: okhttp3.h.1
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            int min = Math.min(str.length(), str2.length());
            for (int i = 4; i < min; i++) {
                char charAt = str.charAt(i);
                char charAt2 = str2.charAt(i);
                if (charAt != charAt2) {
                    return charAt < charAt2 ? -1 : 1;
                }
            }
            int length = str.length();
            int length2 = str2.length();
            if (length != length2) {
                return length < length2 ? -1 : 1;
            }
            return 0;
        }
    };

    /* renamed from: bl */
    private static final Map<String, CipherSuite> f10116bl = new TreeMap(f10052a);

    /* renamed from: b */
    public static final CipherSuite f10105b = m9874a("SSL_RSA_WITH_NULL_MD5", 1);

    /* renamed from: c */
    public static final CipherSuite f10117c = m9874a("SSL_RSA_WITH_NULL_SHA", 2);

    /* renamed from: d */
    public static final CipherSuite f10118d = m9874a("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);

    /* renamed from: e */
    public static final CipherSuite f10119e = m9874a("SSL_RSA_WITH_RC4_128_MD5", 4);

    /* renamed from: f */
    public static final CipherSuite f10120f = m9874a("SSL_RSA_WITH_RC4_128_SHA", 5);

    /* renamed from: g */
    public static final CipherSuite f10121g = m9874a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);

    /* renamed from: h */
    public static final CipherSuite f10122h = m9874a("SSL_RSA_WITH_DES_CBC_SHA", 9);

    /* renamed from: i */
    public static final CipherSuite f10123i = m9874a("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);

    /* renamed from: j */
    public static final CipherSuite f10124j = m9874a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);

    /* renamed from: k */
    public static final CipherSuite f10125k = m9874a("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);

    /* renamed from: l */
    public static final CipherSuite f10126l = m9874a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);

    /* renamed from: m */
    public static final CipherSuite f10127m = m9874a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);

    /* renamed from: n */
    public static final CipherSuite f10128n = m9874a("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);

    /* renamed from: o */
    public static final CipherSuite f10129o = m9874a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);

    /* renamed from: p */
    public static final CipherSuite f10130p = m9874a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);

    /* renamed from: q */
    public static final CipherSuite f10131q = m9874a("SSL_DH_anon_WITH_RC4_128_MD5", 24);

    /* renamed from: r */
    public static final CipherSuite f10132r = m9874a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);

    /* renamed from: s */
    public static final CipherSuite f10133s = m9874a("SSL_DH_anon_WITH_DES_CBC_SHA", 26);

    /* renamed from: t */
    public static final CipherSuite f10134t = m9874a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);

    /* renamed from: u */
    public static final CipherSuite f10135u = m9874a("TLS_KRB5_WITH_DES_CBC_SHA", 30);

    /* renamed from: v */
    public static final CipherSuite f10136v = m9874a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);

    /* renamed from: w */
    public static final CipherSuite f10137w = m9874a("TLS_KRB5_WITH_RC4_128_SHA", 32);

    /* renamed from: x */
    public static final CipherSuite f10138x = m9874a("TLS_KRB5_WITH_DES_CBC_MD5", 34);

    /* renamed from: y */
    public static final CipherSuite f10139y = m9874a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);

    /* renamed from: z */
    public static final CipherSuite f10140z = m9874a("TLS_KRB5_WITH_RC4_128_MD5", 36);

    /* renamed from: A */
    public static final CipherSuite f10026A = m9874a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);

    /* renamed from: B */
    public static final CipherSuite f10027B = m9874a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);

    /* renamed from: C */
    public static final CipherSuite f10028C = m9874a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);

    /* renamed from: D */
    public static final CipherSuite f10029D = m9874a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);

    /* renamed from: E */
    public static final CipherSuite f10030E = m9874a("TLS_RSA_WITH_AES_128_CBC_SHA", 47);

    /* renamed from: F */
    public static final CipherSuite f10031F = m9874a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);

    /* renamed from: G */
    public static final CipherSuite f10032G = m9874a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);

    /* renamed from: H */
    public static final CipherSuite f10033H = m9874a("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);

    /* renamed from: I */
    public static final CipherSuite f10034I = m9874a("TLS_RSA_WITH_AES_256_CBC_SHA", 53);

    /* renamed from: J */
    public static final CipherSuite f10035J = m9874a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);

    /* renamed from: K */
    public static final CipherSuite f10036K = m9874a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);

    /* renamed from: L */
    public static final CipherSuite f10037L = m9874a("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);

    /* renamed from: M */
    public static final CipherSuite f10038M = m9874a("TLS_RSA_WITH_NULL_SHA256", 59);

    /* renamed from: N */
    public static final CipherSuite f10039N = m9874a("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);

    /* renamed from: O */
    public static final CipherSuite f10040O = m9874a("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);

    /* renamed from: P */
    public static final CipherSuite f10041P = m9874a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);

    /* renamed from: Q */
    public static final CipherSuite f10042Q = m9874a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);

    /* renamed from: R */
    public static final CipherSuite f10043R = m9874a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);

    /* renamed from: S */
    public static final CipherSuite f10044S = m9874a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);

    /* renamed from: T */
    public static final CipherSuite f10045T = m9874a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);

    /* renamed from: U */
    public static final CipherSuite f10046U = m9874a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);

    /* renamed from: V */
    public static final CipherSuite f10047V = m9874a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);

    /* renamed from: W */
    public static final CipherSuite f10048W = m9874a("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);

    /* renamed from: X */
    public static final CipherSuite f10049X = m9874a("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);

    /* renamed from: Y */
    public static final CipherSuite f10050Y = m9874a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);

    /* renamed from: Z */
    public static final CipherSuite f10051Z = m9874a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);

    /* renamed from: aa */
    public static final CipherSuite f10079aa = m9874a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);

    /* renamed from: ab */
    public static final CipherSuite f10080ab = m9874a("TLS_PSK_WITH_RC4_128_SHA", 138);

    /* renamed from: ac */
    public static final CipherSuite f10081ac = m9874a("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);

    /* renamed from: ad */
    public static final CipherSuite f10082ad = m9874a("TLS_PSK_WITH_AES_128_CBC_SHA", 140);

    /* renamed from: ae */
    public static final CipherSuite f10083ae = m9874a("TLS_PSK_WITH_AES_256_CBC_SHA", 141);

    /* renamed from: af */
    public static final CipherSuite f10084af = m9874a("TLS_RSA_WITH_SEED_CBC_SHA", CacheConfig.Post_Delayed);

    /* renamed from: ag */
    public static final CipherSuite f10085ag = m9874a("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);

    /* renamed from: ah */
    public static final CipherSuite f10086ah = m9874a("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);

    /* renamed from: ai */
    public static final CipherSuite f10087ai = m9874a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);

    /* renamed from: aj */
    public static final CipherSuite f10088aj = m9874a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);

    /* renamed from: ak */
    public static final CipherSuite f10089ak = m9874a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);

    /* renamed from: al */
    public static final CipherSuite f10090al = m9874a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);

    /* renamed from: am */
    public static final CipherSuite f10091am = m9874a("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);

    /* renamed from: an */
    public static final CipherSuite f10092an = m9874a("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);

    /* renamed from: ao */
    public static final CipherSuite f10093ao = m9874a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);

    /* renamed from: ap */
    public static final CipherSuite f10094ap = m9874a("TLS_FALLBACK_SCSV", 22016);

    /* renamed from: aq */
    public static final CipherSuite f10095aq = m9874a("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);

    /* renamed from: ar */
    public static final CipherSuite f10096ar = m9874a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);

    /* renamed from: as */
    public static final CipherSuite f10097as = m9874a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);

    /* renamed from: at */
    public static final CipherSuite f10098at = m9874a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);

    /* renamed from: au */
    public static final CipherSuite f10099au = m9874a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);

    /* renamed from: av */
    public static final CipherSuite f10100av = m9874a("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);

    /* renamed from: aw */
    public static final CipherSuite f10101aw = m9874a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);

    /* renamed from: ax */
    public static final CipherSuite f10102ax = m9874a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);

    /* renamed from: ay */
    public static final CipherSuite f10103ay = m9874a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);

    /* renamed from: az */
    public static final CipherSuite f10104az = m9874a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);

    /* renamed from: aA */
    public static final CipherSuite f10053aA = m9874a("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);

    /* renamed from: aB */
    public static final CipherSuite f10054aB = m9874a("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);

    /* renamed from: aC */
    public static final CipherSuite f10055aC = m9874a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);

    /* renamed from: aD */
    public static final CipherSuite f10056aD = m9874a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);

    /* renamed from: aE */
    public static final CipherSuite f10057aE = m9874a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);

    /* renamed from: aF */
    public static final CipherSuite f10058aF = m9874a("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);

    /* renamed from: aG */
    public static final CipherSuite f10059aG = m9874a("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);

    /* renamed from: aH */
    public static final CipherSuite f10060aH = m9874a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);

    /* renamed from: aI */
    public static final CipherSuite f10061aI = m9874a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);

    /* renamed from: aJ */
    public static final CipherSuite f10062aJ = m9874a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);

    /* renamed from: aK */
    public static final CipherSuite f10063aK = m9874a("TLS_ECDH_anon_WITH_NULL_SHA", 49173);

    /* renamed from: aL */
    public static final CipherSuite f10064aL = m9874a("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);

    /* renamed from: aM */
    public static final CipherSuite f10065aM = m9874a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);

    /* renamed from: aN */
    public static final CipherSuite f10066aN = m9874a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);

    /* renamed from: aO */
    public static final CipherSuite f10067aO = m9874a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);

    /* renamed from: aP */
    public static final CipherSuite f10068aP = m9874a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);

    /* renamed from: aQ */
    public static final CipherSuite f10069aQ = m9874a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);

    /* renamed from: aR */
    public static final CipherSuite f10070aR = m9874a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);

    /* renamed from: aS */
    public static final CipherSuite f10071aS = m9874a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);

    /* renamed from: aT */
    public static final CipherSuite f10072aT = m9874a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);

    /* renamed from: aU */
    public static final CipherSuite f10073aU = m9874a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);

    /* renamed from: aV */
    public static final CipherSuite f10074aV = m9874a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);

    /* renamed from: aW */
    public static final CipherSuite f10075aW = m9874a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);

    /* renamed from: aX */
    public static final CipherSuite f10076aX = m9874a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);

    /* renamed from: aY */
    public static final CipherSuite f10077aY = m9874a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);

    /* renamed from: aZ */
    public static final CipherSuite f10078aZ = m9874a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);

    /* renamed from: ba */
    public static final CipherSuite f10106ba = m9874a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);

    /* renamed from: bb */
    public static final CipherSuite f10107bb = m9874a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);

    /* renamed from: bc */
    public static final CipherSuite f10108bc = m9874a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);

    /* renamed from: bd */
    public static final CipherSuite f10109bd = m9874a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);

    /* renamed from: be */
    public static final CipherSuite f10110be = m9874a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);

    /* renamed from: bf */
    public static final CipherSuite f10111bf = m9874a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);

    /* renamed from: bg */
    public static final CipherSuite f10112bg = m9874a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);

    /* renamed from: bh */
    public static final CipherSuite f10113bh = m9874a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);

    /* renamed from: bi */
    public static final CipherSuite f10114bi = m9874a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);

    /* renamed from: bj */
    public static final CipherSuite f10115bj = m9874a("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);

    /* renamed from: a */
    public static synchronized CipherSuite m9873a(String str) {
        CipherSuite cipherSuite;
        synchronized (CipherSuite.class) {
            cipherSuite = f10116bl.get(str);
            if (cipherSuite == null) {
                cipherSuite = new CipherSuite(str);
                f10116bl.put(str, cipherSuite);
            }
        }
        return cipherSuite;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static List<CipherSuite> m9872a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(m9873a(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private CipherSuite(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f10141bk = str;
    }

    /* renamed from: a */
    private static CipherSuite m9874a(String str, int i) {
        return m9873a(str);
    }

    public String toString() {
        return this.f10141bk;
    }
}