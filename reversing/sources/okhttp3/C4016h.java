package okhttp3;

import com.senseplay.sdk.config.CacheConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: okhttp3.h */
/* loaded from: classes2.dex */
public final class CipherSuite {

    /* renamed from: bk */
    final String f10100bk;

    /* renamed from: a */
    static final Comparator<String> f10011a = new Comparator<String>() { // from class: okhttp3.h.1
        @Override // java.util.Comparator
        /* renamed from: a */
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
    private static final Map<String, CipherSuite> f10075bl = new TreeMap(f10011a);

    /* renamed from: b */
    public static final CipherSuite f10064b = m2967a("SSL_RSA_WITH_NULL_MD5", 1);

    /* renamed from: c */
    public static final CipherSuite f10076c = m2967a("SSL_RSA_WITH_NULL_SHA", 2);

    /* renamed from: d */
    public static final CipherSuite f10077d = m2967a("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);

    /* renamed from: e */
    public static final CipherSuite f10078e = m2967a("SSL_RSA_WITH_RC4_128_MD5", 4);

    /* renamed from: f */
    public static final CipherSuite f10079f = m2967a("SSL_RSA_WITH_RC4_128_SHA", 5);

    /* renamed from: g */
    public static final CipherSuite f10080g = m2967a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);

    /* renamed from: h */
    public static final CipherSuite f10081h = m2967a("SSL_RSA_WITH_DES_CBC_SHA", 9);

    /* renamed from: i */
    public static final CipherSuite f10082i = m2967a("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);

    /* renamed from: j */
    public static final CipherSuite f10083j = m2967a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);

    /* renamed from: k */
    public static final CipherSuite f10084k = m2967a("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);

    /* renamed from: l */
    public static final CipherSuite f10085l = m2967a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);

    /* renamed from: m */
    public static final CipherSuite f10086m = m2967a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);

    /* renamed from: n */
    public static final CipherSuite f10087n = m2967a("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);

    /* renamed from: o */
    public static final CipherSuite f10088o = m2967a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);

    /* renamed from: p */
    public static final CipherSuite f10089p = m2967a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);

    /* renamed from: q */
    public static final CipherSuite f10090q = m2967a("SSL_DH_anon_WITH_RC4_128_MD5", 24);

    /* renamed from: r */
    public static final CipherSuite f10091r = m2967a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);

    /* renamed from: s */
    public static final CipherSuite f10092s = m2967a("SSL_DH_anon_WITH_DES_CBC_SHA", 26);

    /* renamed from: t */
    public static final CipherSuite f10093t = m2967a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);

    /* renamed from: u */
    public static final CipherSuite f10094u = m2967a("TLS_KRB5_WITH_DES_CBC_SHA", 30);

    /* renamed from: v */
    public static final CipherSuite f10095v = m2967a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);

    /* renamed from: w */
    public static final CipherSuite f10096w = m2967a("TLS_KRB5_WITH_RC4_128_SHA", 32);

    /* renamed from: x */
    public static final CipherSuite f10097x = m2967a("TLS_KRB5_WITH_DES_CBC_MD5", 34);

    /* renamed from: y */
    public static final CipherSuite f10098y = m2967a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);

    /* renamed from: z */
    public static final CipherSuite f10099z = m2967a("TLS_KRB5_WITH_RC4_128_MD5", 36);

    /* renamed from: A */
    public static final CipherSuite f9985A = m2967a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);

    /* renamed from: B */
    public static final CipherSuite f9986B = m2967a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);

    /* renamed from: C */
    public static final CipherSuite f9987C = m2967a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);

    /* renamed from: D */
    public static final CipherSuite f9988D = m2967a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);

    /* renamed from: E */
    public static final CipherSuite f9989E = m2967a("TLS_RSA_WITH_AES_128_CBC_SHA", 47);

    /* renamed from: F */
    public static final CipherSuite f9990F = m2967a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);

    /* renamed from: G */
    public static final CipherSuite f9991G = m2967a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);

    /* renamed from: H */
    public static final CipherSuite f9992H = m2967a("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);

    /* renamed from: I */
    public static final CipherSuite f9993I = m2967a("TLS_RSA_WITH_AES_256_CBC_SHA", 53);

    /* renamed from: J */
    public static final CipherSuite f9994J = m2967a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);

    /* renamed from: K */
    public static final CipherSuite f9995K = m2967a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);

    /* renamed from: L */
    public static final CipherSuite f9996L = m2967a("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);

    /* renamed from: M */
    public static final CipherSuite f9997M = m2967a("TLS_RSA_WITH_NULL_SHA256", 59);

    /* renamed from: N */
    public static final CipherSuite f9998N = m2967a("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);

    /* renamed from: O */
    public static final CipherSuite f9999O = m2967a("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);

    /* renamed from: P */
    public static final CipherSuite f10000P = m2967a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);

    /* renamed from: Q */
    public static final CipherSuite f10001Q = m2967a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);

    /* renamed from: R */
    public static final CipherSuite f10002R = m2967a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);

    /* renamed from: S */
    public static final CipherSuite f10003S = m2967a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);

    /* renamed from: T */
    public static final CipherSuite f10004T = m2967a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);

    /* renamed from: U */
    public static final CipherSuite f10005U = m2967a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);

    /* renamed from: V */
    public static final CipherSuite f10006V = m2967a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);

    /* renamed from: W */
    public static final CipherSuite f10007W = m2967a("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);

    /* renamed from: X */
    public static final CipherSuite f10008X = m2967a("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);

    /* renamed from: Y */
    public static final CipherSuite f10009Y = m2967a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);

    /* renamed from: Z */
    public static final CipherSuite f10010Z = m2967a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);

    /* renamed from: aa */
    public static final CipherSuite f10038aa = m2967a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);

    /* renamed from: ab */
    public static final CipherSuite f10039ab = m2967a("TLS_PSK_WITH_RC4_128_SHA", 138);

    /* renamed from: ac */
    public static final CipherSuite f10040ac = m2967a("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);

    /* renamed from: ad */
    public static final CipherSuite f10041ad = m2967a("TLS_PSK_WITH_AES_128_CBC_SHA", 140);

    /* renamed from: ae */
    public static final CipherSuite f10042ae = m2967a("TLS_PSK_WITH_AES_256_CBC_SHA", 141);

    /* renamed from: af */
    public static final CipherSuite f10043af = m2967a("TLS_RSA_WITH_SEED_CBC_SHA", CacheConfig.Post_Delayed);

    /* renamed from: ag */
    public static final CipherSuite f10044ag = m2967a("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);

    /* renamed from: ah */
    public static final CipherSuite f10045ah = m2967a("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);

    /* renamed from: ai */
    public static final CipherSuite f10046ai = m2967a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);

    /* renamed from: aj */
    public static final CipherSuite f10047aj = m2967a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);

    /* renamed from: ak */
    public static final CipherSuite f10048ak = m2967a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);

    /* renamed from: al */
    public static final CipherSuite f10049al = m2967a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);

    /* renamed from: am */
    public static final CipherSuite f10050am = m2967a("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);

    /* renamed from: an */
    public static final CipherSuite f10051an = m2967a("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);

    /* renamed from: ao */
    public static final CipherSuite f10052ao = m2967a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);

    /* renamed from: ap */
    public static final CipherSuite f10053ap = m2967a("TLS_FALLBACK_SCSV", 22016);

    /* renamed from: aq */
    public static final CipherSuite f10054aq = m2967a("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);

    /* renamed from: ar */
    public static final CipherSuite f10055ar = m2967a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);

    /* renamed from: as */
    public static final CipherSuite f10056as = m2967a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);

    /* renamed from: at */
    public static final CipherSuite f10057at = m2967a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);

    /* renamed from: au */
    public static final CipherSuite f10058au = m2967a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);

    /* renamed from: av */
    public static final CipherSuite f10059av = m2967a("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);

    /* renamed from: aw */
    public static final CipherSuite f10060aw = m2967a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);

    /* renamed from: ax */
    public static final CipherSuite f10061ax = m2967a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);

    /* renamed from: ay */
    public static final CipherSuite f10062ay = m2967a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);

    /* renamed from: az */
    public static final CipherSuite f10063az = m2967a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);

    /* renamed from: aA */
    public static final CipherSuite f10012aA = m2967a("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);

    /* renamed from: aB */
    public static final CipherSuite f10013aB = m2967a("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);

    /* renamed from: aC */
    public static final CipherSuite f10014aC = m2967a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);

    /* renamed from: aD */
    public static final CipherSuite f10015aD = m2967a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);

    /* renamed from: aE */
    public static final CipherSuite f10016aE = m2967a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);

    /* renamed from: aF */
    public static final CipherSuite f10017aF = m2967a("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);

    /* renamed from: aG */
    public static final CipherSuite f10018aG = m2967a("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);

    /* renamed from: aH */
    public static final CipherSuite f10019aH = m2967a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);

    /* renamed from: aI */
    public static final CipherSuite f10020aI = m2967a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);

    /* renamed from: aJ */
    public static final CipherSuite f10021aJ = m2967a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);

    /* renamed from: aK */
    public static final CipherSuite f10022aK = m2967a("TLS_ECDH_anon_WITH_NULL_SHA", 49173);

    /* renamed from: aL */
    public static final CipherSuite f10023aL = m2967a("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);

    /* renamed from: aM */
    public static final CipherSuite f10024aM = m2967a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);

    /* renamed from: aN */
    public static final CipherSuite f10025aN = m2967a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);

    /* renamed from: aO */
    public static final CipherSuite f10026aO = m2967a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);

    /* renamed from: aP */
    public static final CipherSuite f10027aP = m2967a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);

    /* renamed from: aQ */
    public static final CipherSuite f10028aQ = m2967a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);

    /* renamed from: aR */
    public static final CipherSuite f10029aR = m2967a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);

    /* renamed from: aS */
    public static final CipherSuite f10030aS = m2967a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);

    /* renamed from: aT */
    public static final CipherSuite f10031aT = m2967a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);

    /* renamed from: aU */
    public static final CipherSuite f10032aU = m2967a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);

    /* renamed from: aV */
    public static final CipherSuite f10033aV = m2967a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);

    /* renamed from: aW */
    public static final CipherSuite f10034aW = m2967a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);

    /* renamed from: aX */
    public static final CipherSuite f10035aX = m2967a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);

    /* renamed from: aY */
    public static final CipherSuite f10036aY = m2967a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);

    /* renamed from: aZ */
    public static final CipherSuite f10037aZ = m2967a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);

    /* renamed from: ba */
    public static final CipherSuite f10065ba = m2967a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);

    /* renamed from: bb */
    public static final CipherSuite f10066bb = m2967a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);

    /* renamed from: bc */
    public static final CipherSuite f10067bc = m2967a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);

    /* renamed from: bd */
    public static final CipherSuite f10068bd = m2967a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);

    /* renamed from: be */
    public static final CipherSuite f10069be = m2967a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);

    /* renamed from: bf */
    public static final CipherSuite f10070bf = m2967a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);

    /* renamed from: bg */
    public static final CipherSuite f10071bg = m2967a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);

    /* renamed from: bh */
    public static final CipherSuite f10072bh = m2967a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);

    /* renamed from: bi */
    public static final CipherSuite f10073bi = m2967a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);

    /* renamed from: bj */
    public static final CipherSuite f10074bj = m2967a("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);

    /* renamed from: a */
    public static synchronized CipherSuite m2968a(String str) {
        CipherSuite cipherSuite;
        synchronized (CipherSuite.class) {
            cipherSuite = f10075bl.get(str);
            if (cipherSuite == null) {
                cipherSuite = new CipherSuite(str);
                f10075bl.put(str, cipherSuite);
            }
        }
        return cipherSuite;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static List<CipherSuite> m2966a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(m2968a(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private CipherSuite(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f10100bk = str;
    }

    /* renamed from: a */
    private static CipherSuite m2967a(String str, int i) {
        return m2968a(str);
    }

    public String toString() {
        return this.f10100bk;
    }
}
