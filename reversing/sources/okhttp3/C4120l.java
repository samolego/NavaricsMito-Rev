package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.internal.C2930c;
import okhttp3.internal.p104b.HttpDate;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* renamed from: okhttp3.l */
/* loaded from: classes2.dex */
public final class Cookie {

    /* renamed from: a */
    private static final Pattern f10503a = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: b */
    private static final Pattern f10504b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: c */
    private static final Pattern f10505c = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: d */
    private static final Pattern f10506d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: e */
    private final String f10507e;

    /* renamed from: f */
    private final String f10508f;

    /* renamed from: g */
    private final long f10509g;

    /* renamed from: h */
    private final String f10510h;

    /* renamed from: i */
    private final String f10511i;

    /* renamed from: j */
    private final boolean f10512j;

    /* renamed from: k */
    private final boolean f10513k;

    /* renamed from: l */
    private final boolean f10514l;

    /* renamed from: m */
    private final boolean f10515m;

    private Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f10507e = str;
        this.f10508f = str2;
        this.f10509g = j;
        this.f10510h = str3;
        this.f10511i = str4;
        this.f10512j = z;
        this.f10513k = z2;
        this.f10515m = z3;
        this.f10514l = z4;
    }

    /* renamed from: a */
    public String m2562a() {
        return this.f10507e;
    }

    /* renamed from: b */
    public String m2553b() {
        return this.f10508f;
    }

    /* renamed from: a */
    private static boolean m2557a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !C2930c.m2869c(str);
    }

    @Nullable
    /* renamed from: a */
    public static Cookie m2556a(HttpUrl httpUrl, String str) {
        return m2561a(System.currentTimeMillis(), httpUrl, str);
    }

    @Nullable
    /* renamed from: a */
    static Cookie m2561a(long j, HttpUrl httpUrl, String str) {
        long j2;
        Cookie cookie;
        String str2;
        String str3;
        String substring;
        int length = str.length();
        char c = ';';
        int m2892a = C2930c.m2892a(str, 0, length, ';');
        char c2 = '=';
        int m2892a2 = C2930c.m2892a(str, 0, m2892a, '=');
        if (m2892a2 == m2892a) {
            return null;
        }
        String m2868c = C2930c.m2868c(str, 0, m2892a2);
        if (m2868c.isEmpty() || C2930c.m2873b(m2868c) != -1) {
            return null;
        }
        String m2868c2 = C2930c.m2868c(str, m2892a2 + 1, m2892a);
        if (C2930c.m2873b(m2868c2) != -1) {
            return null;
        }
        int i = m2892a + 1;
        String str4 = null;
        String str5 = null;
        long j3 = -1;
        long j4 = 253402300799999L;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = true;
        boolean z4 = false;
        while (i < length) {
            int m2892a3 = C2930c.m2892a(str, i, length, c);
            int m2892a4 = C2930c.m2892a(str, i, m2892a3, c2);
            String m2868c3 = C2930c.m2868c(str, i, m2892a4);
            String m2868c4 = m2892a4 < m2892a3 ? C2930c.m2868c(str, m2892a4 + 1, m2892a3) : "";
            if (m2868c3.equalsIgnoreCase("expires")) {
                try {
                    j4 = m2559a(m2868c4, 0, m2868c4.length());
                    z4 = true;
                } catch (NumberFormatException | IllegalArgumentException unused) {
                }
            } else if (m2868c3.equalsIgnoreCase("max-age")) {
                j3 = m2560a(m2868c4);
                z4 = true;
            } else if (m2868c3.equalsIgnoreCase("domain")) {
                str4 = m2552b(m2868c4);
                z3 = false;
            } else if (m2868c3.equalsIgnoreCase("path")) {
                str5 = m2868c4;
            } else if (m2868c3.equalsIgnoreCase("secure")) {
                z = true;
            } else if (m2868c3.equalsIgnoreCase("httponly")) {
                z2 = true;
            }
            i = m2892a3 + 1;
            c = ';';
            c2 = '=';
        }
        if (j3 == Long.MIN_VALUE) {
            j2 = Long.MIN_VALUE;
        } else if (j3 != -1) {
            long j5 = j + (j3 <= 9223372036854775L ? j3 * 1000 : Long.MAX_VALUE);
            j2 = (j5 < j || j5 > 253402300799999L) ? 253402300799999L : j5;
        } else {
            j2 = j4;
        }
        String m2464f = httpUrl.m2464f();
        if (str4 == null) {
            str2 = m2464f;
            cookie = null;
        } else if (!m2557a(m2464f, str4)) {
            return null;
        } else {
            cookie = null;
            str2 = str4;
        }
        if (m2464f.length() == str2.length()) {
            str3 = str5;
        } else if (PublicSuffixDatabase.m2587a().m2586a(str2) == null) {
            return cookie;
        } else {
            str3 = str5;
        }
        if (str3 == null || !str3.startsWith("/")) {
            String m2461h = httpUrl.m2461h();
            int lastIndexOf = m2461h.lastIndexOf(47);
            substring = lastIndexOf != 0 ? m2461h.substring(0, lastIndexOf) : "/";
        } else {
            substring = str3;
        }
        return new Cookie(m2868c, m2868c2, j2, str2, substring, z, z2, z3, z4);
    }

    /* renamed from: a */
    private static long m2559a(String str, int i, int i2) {
        int m2558a = m2558a(str, i, i2, false);
        Matcher matcher = f10506d.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        while (m2558a < i2) {
            int m2558a2 = m2558a(str, m2558a + 1, i2, true);
            matcher.region(m2558a, m2558a2);
            if (i4 == -1 && matcher.usePattern(f10506d).matches()) {
                int parseInt = Integer.parseInt(matcher.group(1));
                int parseInt2 = Integer.parseInt(matcher.group(2));
                i8 = Integer.parseInt(matcher.group(3));
                i7 = parseInt2;
                i4 = parseInt;
            } else if (i5 == -1 && matcher.usePattern(f10505c).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
            } else if (i6 == -1 && matcher.usePattern(f10504b).matches()) {
                i6 = f10504b.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
            } else if (i3 == -1 && matcher.usePattern(f10503a).matches()) {
                i3 = Integer.parseInt(matcher.group(1));
            }
            m2558a = m2558a(str, m2558a2 + 1, i2, false);
        }
        if (i3 >= 70 && i3 <= 99) {
            i3 += 1900;
        }
        if (i3 >= 0 && i3 <= 69) {
            i3 += 2000;
        }
        if (i3 >= 1601) {
            if (i6 != -1) {
                if (i5 < 1 || i5 > 31) {
                    throw new IllegalArgumentException();
                }
                if (i4 < 0 || i4 > 23) {
                    throw new IllegalArgumentException();
                }
                if (i7 < 0 || i7 > 59) {
                    throw new IllegalArgumentException();
                }
                if (i8 < 0 || i8 > 59) {
                    throw new IllegalArgumentException();
                }
                GregorianCalendar gregorianCalendar = new GregorianCalendar(C2930c.f10185g);
                gregorianCalendar.setLenient(false);
                gregorianCalendar.set(1, i3);
                gregorianCalendar.set(2, i6 - 1);
                gregorianCalendar.set(5, i5);
                gregorianCalendar.set(11, i4);
                gregorianCalendar.set(12, i7);
                gregorianCalendar.set(13, i8);
                gregorianCalendar.set(14, 0);
                return gregorianCalendar.getTimeInMillis();
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    private static int m2558a(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    private static long m2560a(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e) {
            if (str.matches("-?\\d+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e;
        }
    }

    /* renamed from: b */
    private static String m2552b(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String m2894a = C2930c.m2894a(str);
        if (m2894a != null) {
            return m2894a;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    public static List<Cookie> m2555a(HttpUrl httpUrl, C2984s c2984s) {
        List<String> m2495b = c2984s.m2495b("Set-Cookie");
        int size = m2495b.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            Cookie m2556a = m2556a(httpUrl, m2495b.get(i));
            if (m2556a != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(m2556a);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public String toString() {
        return m2554a(false);
    }

    /* renamed from: a */
    String m2554a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f10507e);
        sb.append('=');
        sb.append(this.f10508f);
        if (this.f10514l) {
            if (this.f10509g == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(HttpDate.m2933a(new Date(this.f10509g)));
            }
        }
        if (!this.f10515m) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.f10510h);
        }
        sb.append("; path=");
        sb.append(this.f10511i);
        if (this.f10512j) {
            sb.append("; secure");
        }
        if (this.f10513k) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Cookie) {
            Cookie cookie = (Cookie) obj;
            return cookie.f10507e.equals(this.f10507e) && cookie.f10508f.equals(this.f10508f) && cookie.f10510h.equals(this.f10510h) && cookie.f10511i.equals(this.f10511i) && cookie.f10509g == this.f10509g && cookie.f10512j == this.f10512j && cookie.f10513k == this.f10513k && cookie.f10514l == this.f10514l && cookie.f10515m == this.f10515m;
        }
        return false;
    }

    public int hashCode() {
        long j = this.f10509g;
        return ((((((((((((((((527 + this.f10507e.hashCode()) * 31) + this.f10508f.hashCode()) * 31) + this.f10510h.hashCode()) * 31) + this.f10511i.hashCode()) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + (!this.f10512j ? 1 : 0)) * 31) + (!this.f10513k ? 1 : 0)) * 31) + (!this.f10514l ? 1 : 0)) * 31) + (!this.f10515m ? 1 : 0);
    }
}
