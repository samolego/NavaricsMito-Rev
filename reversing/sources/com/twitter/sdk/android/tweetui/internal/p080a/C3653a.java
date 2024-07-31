package com.twitter.sdk.android.tweetui.internal.p080a;

import android.support.media.ExifInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.twitter.sdk.android.tweetui.internal.a.a */
/* loaded from: classes2.dex */
public class HtmlEntities {

    /* renamed from: d */
    final InterfaceC2752a f9058d = new C2753b();

    /* renamed from: b */
    static final String[][] f9055b = {new String[]{"nbsp", "160"}, new String[]{"iexcl", "161"}, new String[]{"cent", "162"}, new String[]{"pound", "163"}, new String[]{"curren", "164"}, new String[]{"yen", "165"}, new String[]{"brvbar", "166"}, new String[]{"sect", "167"}, new String[]{"uml", "168"}, new String[]{"copy", "169"}, new String[]{"ordf", "170"}, new String[]{"laquo", "171"}, new String[]{"not", "172"}, new String[]{"shy", "173"}, new String[]{"reg", "174"}, new String[]{"macr", "175"}, new String[]{"deg", "176"}, new String[]{"plusmn", "177"}, new String[]{"sup2", "178"}, new String[]{"sup3", "179"}, new String[]{"acute", "180"}, new String[]{"micro", "181"}, new String[]{"para", "182"}, new String[]{"middot", "183"}, new String[]{"cedil", "184"}, new String[]{"sup1", "185"}, new String[]{"ordm", "186"}, new String[]{"raquo", "187"}, new String[]{"frac14", "188"}, new String[]{"frac12", "189"}, new String[]{"frac34", "190"}, new String[]{"iquest", "191"}, new String[]{"Agrave", "192"}, new String[]{"Aacute", "193"}, new String[]{"Acirc", "194"}, new String[]{"Atilde", "195"}, new String[]{"Auml", "196"}, new String[]{"Aring", "197"}, new String[]{"AElig", "198"}, new String[]{"Ccedil", "199"}, new String[]{"Egrave", "200"}, new String[]{"Eacute", "201"}, new String[]{"Ecirc", "202"}, new String[]{"Euml", "203"}, new String[]{"Igrave", "204"}, new String[]{"Iacute", "205"}, new String[]{"Icirc", "206"}, new String[]{"Iuml", "207"}, new String[]{"ETH", "208"}, new String[]{"Ntilde", "209"}, new String[]{"Ograve", "210"}, new String[]{"Oacute", "211"}, new String[]{"Ocirc", "212"}, new String[]{"Otilde", "213"}, new String[]{"Ouml", "214"}, new String[]{"times", "215"}, new String[]{"Oslash", "216"}, new String[]{"Ugrave", "217"}, new String[]{"Uacute", "218"}, new String[]{"Ucirc", "219"}, new String[]{"Uuml", "220"}, new String[]{"Yacute", "221"}, new String[]{"THORN", "222"}, new String[]{"szlig", "223"}, new String[]{"agrave", "224"}, new String[]{"aacute", "225"}, new String[]{"acirc", "226"}, new String[]{"atilde", "227"}, new String[]{"auml", "228"}, new String[]{"aring", "229"}, new String[]{"aelig", "230"}, new String[]{"ccedil", "231"}, new String[]{"egrave", "232"}, new String[]{"eacute", "233"}, new String[]{"ecirc", "234"}, new String[]{"euml", "235"}, new String[]{"igrave", "236"}, new String[]{"iacute", "237"}, new String[]{"icirc", "238"}, new String[]{"iuml", "239"}, new String[]{"eth", "240"}, new String[]{"ntilde", "241"}, new String[]{"ograve", "242"}, new String[]{"oacute", "243"}, new String[]{"ocirc", "244"}, new String[]{"otilde", "245"}, new String[]{"ouml", "246"}, new String[]{"divide", "247"}, new String[]{"oslash", "248"}, new String[]{"ugrave", "249"}, new String[]{"uacute", "250"}, new String[]{"ucirc", "251"}, new String[]{"uuml", "252"}, new String[]{"yacute", "253"}, new String[]{"thorn", "254"}, new String[]{"yuml", "255"}};

    /* renamed from: c */
    static final String[][] f9056c = {new String[]{"fnof", "402"}, new String[]{"Alpha", "913"}, new String[]{"Beta", "914"}, new String[]{ExifInterface.TAG_GAMMA, "915"}, new String[]{"Delta", "916"}, new String[]{"Epsilon", "917"}, new String[]{"Zeta", "918"}, new String[]{"Eta", "919"}, new String[]{"Theta", "920"}, new String[]{"Iota", "921"}, new String[]{"Kappa", "922"}, new String[]{"Lambda", "923"}, new String[]{"Mu", "924"}, new String[]{"Nu", "925"}, new String[]{"Xi", "926"}, new String[]{"Omicron", "927"}, new String[]{"Pi", "928"}, new String[]{"Rho", "929"}, new String[]{"Sigma", "931"}, new String[]{"Tau", "932"}, new String[]{"Upsilon", "933"}, new String[]{"Phi", "934"}, new String[]{"Chi", "935"}, new String[]{"Psi", "936"}, new String[]{"Omega", "937"}, new String[]{"alpha", "945"}, new String[]{"beta", "946"}, new String[]{"gamma", "947"}, new String[]{"delta", "948"}, new String[]{"epsilon", "949"}, new String[]{"zeta", "950"}, new String[]{"eta", "951"}, new String[]{"theta", "952"}, new String[]{"iota", "953"}, new String[]{"kappa", "954"}, new String[]{"lambda", "955"}, new String[]{"mu", "956"}, new String[]{"nu", "957"}, new String[]{"xi", "958"}, new String[]{"omicron", "959"}, new String[]{"pi", "960"}, new String[]{"rho", "961"}, new String[]{"sigmaf", "962"}, new String[]{"sigma", "963"}, new String[]{"tau", "964"}, new String[]{"upsilon", "965"}, new String[]{"phi", "966"}, new String[]{"chi", "967"}, new String[]{"psi", "968"}, new String[]{"omega", "969"}, new String[]{"thetasym", "977"}, new String[]{"upsih", "978"}, new String[]{"piv", "982"}, new String[]{"bull", "8226"}, new String[]{"hellip", "8230"}, new String[]{"prime", "8242"}, new String[]{"Prime", "8243"}, new String[]{"oline", "8254"}, new String[]{"frasl", "8260"}, new String[]{"weierp", "8472"}, new String[]{"image", "8465"}, new String[]{"real", "8476"}, new String[]{"trade", "8482"}, new String[]{"alefsym", "8501"}, new String[]{"larr", "8592"}, new String[]{"uarr", "8593"}, new String[]{"rarr", "8594"}, new String[]{"darr", "8595"}, new String[]{"harr", "8596"}, new String[]{"crarr", "8629"}, new String[]{"lArr", "8656"}, new String[]{"uArr", "8657"}, new String[]{"rArr", "8658"}, new String[]{"dArr", "8659"}, new String[]{"hArr", "8660"}, new String[]{"forall", "8704"}, new String[]{"part", "8706"}, new String[]{"exist", "8707"}, new String[]{"empty", "8709"}, new String[]{"nabla", "8711"}, new String[]{"isin", "8712"}, new String[]{"notin", "8713"}, new String[]{"ni", "8715"}, new String[]{"prod", "8719"}, new String[]{"sum", "8721"}, new String[]{"minus", "8722"}, new String[]{"lowast", "8727"}, new String[]{"radic", "8730"}, new String[]{"prop", "8733"}, new String[]{"infin", "8734"}, new String[]{"ang", "8736"}, new String[]{"and", "8743"}, new String[]{"or", "8744"}, new String[]{"cap", "8745"}, new String[]{"cup", "8746"}, new String[]{"int", "8747"}, new String[]{"there4", "8756"}, new String[]{"sim", "8764"}, new String[]{"cong", "8773"}, new String[]{"asymp", "8776"}, new String[]{"ne", "8800"}, new String[]{"equiv", "8801"}, new String[]{"le", "8804"}, new String[]{"ge", "8805"}, new String[]{"sub", "8834"}, new String[]{"sup", "8835"}, new String[]{"sube", "8838"}, new String[]{"supe", "8839"}, new String[]{"oplus", "8853"}, new String[]{"otimes", "8855"}, new String[]{"perp", "8869"}, new String[]{"sdot", "8901"}, new String[]{"lceil", "8968"}, new String[]{"rceil", "8969"}, new String[]{"lfloor", "8970"}, new String[]{"rfloor", "8971"}, new String[]{"lang", "9001"}, new String[]{"rang", "9002"}, new String[]{"loz", "9674"}, new String[]{"spades", "9824"}, new String[]{"clubs", "9827"}, new String[]{"hearts", "9829"}, new String[]{"diams", "9830"}, new String[]{"OElig", "338"}, new String[]{"oelig", "339"}, new String[]{"Scaron", "352"}, new String[]{"scaron", "353"}, new String[]{"Yuml", "376"}, new String[]{"circ", "710"}, new String[]{"tilde", "732"}, new String[]{"ensp", "8194"}, new String[]{"emsp", "8195"}, new String[]{"thinsp", "8201"}, new String[]{"zwnj", "8204"}, new String[]{"zwj", "8205"}, new String[]{"lrm", "8206"}, new String[]{"rlm", "8207"}, new String[]{"ndash", "8211"}, new String[]{"mdash", "8212"}, new String[]{"lsquo", "8216"}, new String[]{"rsquo", "8217"}, new String[]{"sbquo", "8218"}, new String[]{"ldquo", "8220"}, new String[]{"rdquo", "8221"}, new String[]{"bdquo", "8222"}, new String[]{"dagger", "8224"}, new String[]{"Dagger", "8225"}, new String[]{"permil", "8240"}, new String[]{"lsaquo", "8249"}, new String[]{"rsaquo", "8250"}, new String[]{"euro", "8364"}};

    /* renamed from: e */
    private static final String[][] f9057e = {new String[]{"quot", "34"}, new String[]{"amp", "38"}, new String[]{"lt", "60"}, new String[]{"gt", "62"}};

    /* renamed from: a */
    public static final HtmlEntities f9054a = new HtmlEntities();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HtmlEntities.java */
    /* renamed from: com.twitter.sdk.android.tweetui.internal.a.a$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC2752a {
        /* renamed from: a */
        int mo3960a(String str);

        /* renamed from: a */
        void mo3959a(String str, int i);
    }

    static {
        m3965a(f9054a);
    }

    /* renamed from: a */
    static void m3965a(HtmlEntities htmlEntities) {
        htmlEntities.m3962a(f9057e);
        htmlEntities.m3962a(f9055b);
        htmlEntities.m3962a(f9056c);
    }

    /* compiled from: HtmlEntities.java */
    /* renamed from: com.twitter.sdk.android.tweetui.internal.a.a$c */
    /* loaded from: classes2.dex */
    static class C2754c implements InterfaceC2752a {

        /* renamed from: a */
        private final Map f9059a = new HashMap();

        /* renamed from: b */
        private final IntHashMap f9060b = new IntHashMap();

        C2754c() {
        }

        @Override // com.twitter.sdk.android.tweetui.internal.p080a.HtmlEntities.InterfaceC2752a
        /* renamed from: a */
        public void mo3959a(String str, int i) {
            this.f9059a.put(str, Integer.valueOf(i));
            this.f9060b.m3957a(i, str);
        }

        @Override // com.twitter.sdk.android.tweetui.internal.p080a.HtmlEntities.InterfaceC2752a
        /* renamed from: a */
        public int mo3960a(String str) {
            Object obj = this.f9059a.get(str);
            if (obj == null) {
                return -1;
            }
            return ((Integer) obj).intValue();
        }
    }

    /* compiled from: HtmlEntities.java */
    /* renamed from: com.twitter.sdk.android.tweetui.internal.a.a$b */
    /* loaded from: classes2.dex */
    static class C2753b extends C2754c {
        C2753b() {
        }
    }

    /* compiled from: HtmlEntities.java */
    /* renamed from: com.twitter.sdk.android.tweetui.internal.a.a$d */
    /* loaded from: classes2.dex */
    public static final class C2755d {

        /* renamed from: a */
        public final String f9061a;

        /* renamed from: b */
        public final ArrayList<int[]> f9062b;

        public C2755d(String str, ArrayList<int[]> arrayList) {
            this.f9061a = str;
            this.f9062b = arrayList;
        }
    }

    /* renamed from: a */
    public void m3962a(String[][] strArr) {
        for (String[] strArr2 : strArr) {
            m3963a(strArr2[0], Integer.parseInt(strArr2[1]));
        }
    }

    /* renamed from: a */
    public void m3963a(String str, int i) {
        this.f9058d.mo3959a(str, i);
    }

    /* renamed from: a */
    public int m3964a(String str) {
        return this.f9058d.mo3960a(str);
    }

    /* renamed from: b */
    public C2755d m3961b(String str) {
        int i;
        int intValue;
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        ArrayList arrayList = new ArrayList(5);
        int i2 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt == '&') {
                int i3 = i2 + 1;
                int indexOf = str.indexOf(59, i3);
                if (indexOf == -1) {
                    sb.append(charAt);
                } else {
                    String substring = str.substring(i3, indexOf);
                    int length2 = substring.length();
                    if (length2 <= 0) {
                        i = -1;
                    } else if (substring.charAt(0) == '#' && length2 > 1) {
                        char charAt2 = substring.charAt(1);
                        if (charAt2 == 'x' || charAt2 == 'X') {
                            intValue = length2 > 2 ? Integer.valueOf(substring.substring(2), 16).intValue() : -1;
                        } else {
                            try {
                                intValue = Integer.parseInt(substring.substring(1));
                            } catch (Exception unused) {
                                intValue = -1;
                            }
                        }
                        i = intValue;
                    } else {
                        i = m3964a(substring);
                    }
                    if (i == -1) {
                        sb.append('&');
                        if (substring.indexOf(38) == -1) {
                            sb.append(substring);
                            sb.append(';');
                            i2 = indexOf;
                        }
                    } else {
                        sb.append((char) i);
                        arrayList.add(new int[]{i2, indexOf});
                        i2 = indexOf;
                    }
                }
            } else {
                sb.append(charAt);
            }
            i2++;
        }
        return new C2755d(sb.toString(), arrayList);
    }
}
