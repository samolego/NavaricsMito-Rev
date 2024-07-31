package okhttp3.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;

/* compiled from: Util.java */
/* renamed from: okhttp3.internal.c */
/* loaded from: classes2.dex */
public final class C2930c {

    /* renamed from: r */
    private static final Method f10196r;

    /* renamed from: s */
    private static final Pattern f10197s;

    /* renamed from: a */
    public static final byte[] f10179a = new byte[0];

    /* renamed from: b */
    public static final String[] f10180b = new String[0];

    /* renamed from: c */
    public static final ResponseBody f10181c = ResponseBody.m3003a(null, f10179a);

    /* renamed from: d */
    public static final RequestBody f10182d = RequestBody.m3036a((MediaType) null, f10179a);

    /* renamed from: i */
    private static final ByteString f10187i = ByteString.decodeHex("efbbbf");

    /* renamed from: j */
    private static final ByteString f10188j = ByteString.decodeHex("feff");

    /* renamed from: k */
    private static final ByteString f10189k = ByteString.decodeHex("fffe");

    /* renamed from: l */
    private static final ByteString f10190l = ByteString.decodeHex("0000ffff");

    /* renamed from: m */
    private static final ByteString f10191m = ByteString.decodeHex("ffff0000");

    /* renamed from: e */
    public static final Charset f10183e = Charset.forName("UTF-8");

    /* renamed from: f */
    public static final Charset f10184f = Charset.forName("ISO-8859-1");

    /* renamed from: n */
    private static final Charset f10192n = Charset.forName("UTF-16BE");

    /* renamed from: o */
    private static final Charset f10193o = Charset.forName("UTF-16LE");

    /* renamed from: p */
    private static final Charset f10194p = Charset.forName("UTF-32BE");

    /* renamed from: q */
    private static final Charset f10195q = Charset.forName("UTF-32LE");

    /* renamed from: g */
    public static final TimeZone f10185g = TimeZone.getTimeZone("GMT");

    /* renamed from: h */
    public static final Comparator<String> f10186h = new Comparator<String>() { // from class: okhttp3.internal.c.1
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    };

    /* renamed from: a */
    public static int m2899a(char c) {
        if (c < '0' || c > '9') {
            if (c < 'a' || c > 'f') {
                if (c < 'A' || c > 'F') {
                    return -1;
                }
                return (c - 'A') + 10;
            }
            return (c - 'a') + 10;
        }
        return c - '0';
    }

    static {
        Method method = null;
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
        }
        f10196r = method;
        f10197s = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    /* renamed from: a */
    public static void m2885a(Throwable th, Throwable th2) {
        Method method = f10196r;
        if (method != null) {
            try {
                method.invoke(th, th2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m2898a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /* renamed from: a */
    public static boolean m2895a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    public static void m2897a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m2884a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e) {
                if (!m2896a(e)) {
                    throw e;
                }
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static boolean m2877a(Source source, int i, TimeUnit timeUnit) {
        try {
            return m2870b(source, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m2870b(Source source, int i, TimeUnit timeUnit) throws IOException {
        long nanoTime = System.nanoTime();
        long mo2213d = source.mo2214a().mo2210i_() ? source.mo2214a().mo2213d() - nanoTime : Long.MAX_VALUE;
        source.mo2214a().mo2208a(Math.min(mo2213d, timeUnit.toNanos(i)) + nanoTime);
        try {
            Buffer buffer = new Buffer();
            while (source.mo130a(buffer, 8192L) != -1) {
                buffer.m2282t();
            }
            if (mo2213d == Long.MAX_VALUE) {
                source.mo2214a().mo2212f();
            } else {
                source.mo2214a().mo2208a(nanoTime + mo2213d);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (mo2213d == Long.MAX_VALUE) {
                source.mo2214a().mo2212f();
            } else {
                source.mo2214a().mo2208a(nanoTime + mo2213d);
            }
            return false;
        } catch (Throwable th) {
            if (mo2213d == Long.MAX_VALUE) {
                source.mo2214a().mo2212f();
            } else {
                source.mo2214a().mo2208a(nanoTime + mo2213d);
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static <T> List<T> m2881a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    /* renamed from: a */
    public static <K, V> Map<K, V> m2880a(Map<K, V> map) {
        if (map.isEmpty()) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    /* renamed from: a */
    public static <T> List<T> m2875a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    /* renamed from: a */
    public static ThreadFactory m2887a(final String str, final boolean z) {
        return new ThreadFactory() { // from class: okhttp3.internal.c.2
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    /* renamed from: a */
    public static String[] m2882a(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i++;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: b */
    public static boolean m2871b(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0) {
            return false;
        }
        for (String str : strArr) {
            for (String str2 : strArr2) {
                if (comparator.compare(str, str2) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static String m2879a(HttpUrl httpUrl, boolean z) {
        String m2464f;
        if (httpUrl.m2464f().contains(":")) {
            m2464f = "[" + httpUrl.m2464f() + "]";
        } else {
            m2464f = httpUrl.m2464f();
        }
        if (z || httpUrl.m2462g() != HttpUrl.m2485a(httpUrl.m2474b())) {
            return m2464f + ":" + httpUrl.m2462g();
        }
        return m2464f;
    }

    /* renamed from: a */
    public static boolean m2896a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    /* renamed from: a */
    public static int m2883a(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], str) == 0) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static String[] m2874a(String[] strArr, String str) {
        String[] strArr2 = new String[strArr.length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[strArr2.length - 1] = str;
        return strArr2;
    }

    /* renamed from: a */
    public static int m2893a(String str, int i, int i2) {
        while (i < i2) {
            switch (str.charAt(i)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                    i++;
                default:
                    return i;
            }
        }
        return i2;
    }

    /* renamed from: b */
    public static int m2872b(String str, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            switch (str.charAt(i3)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                default:
                    return i3 + 1;
            }
        }
        return i;
    }

    /* renamed from: c */
    public static String m2868c(String str, int i, int i2) {
        int m2893a = m2893a(str, i, i2);
        return str.substring(m2893a, m2872b(str, m2893a, i2));
    }

    /* renamed from: a */
    public static int m2891a(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    public static int m2892a(String str, int i, int i2, char c) {
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    public static String m2894a(String str) {
        InetAddress m2866d;
        if (str.contains(":")) {
            if (str.startsWith("[") && str.endsWith("]")) {
                m2866d = m2866d(str, 1, str.length() - 1);
            } else {
                m2866d = m2866d(str, 0, str.length());
            }
            if (m2866d == null) {
                return null;
            }
            byte[] address = m2866d.getAddress();
            if (address.length == 16) {
                return m2876a(address);
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + "'");
        }
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (lowerCase.isEmpty()) {
                return null;
            }
            if (m2867d(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* renamed from: d */
    private static boolean m2867d(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static int m2873b(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: c */
    public static boolean m2869c(String str) {
        return f10197s.matcher(str).matches();
    }

    /* renamed from: a */
    public static String m2886a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    /* renamed from: a */
    public static Charset m2878a(BufferedSource bufferedSource, Charset charset) throws IOException {
        if (bufferedSource.mo2244a(0L, f10187i)) {
            bufferedSource.mo2231i(f10187i.size());
            return f10183e;
        } else if (bufferedSource.mo2244a(0L, f10188j)) {
            bufferedSource.mo2231i(f10188j.size());
            return f10192n;
        } else if (bufferedSource.mo2244a(0L, f10189k)) {
            bufferedSource.mo2231i(f10189k.size());
            return f10193o;
        } else if (bufferedSource.mo2244a(0L, f10190l)) {
            bufferedSource.mo2231i(f10190l.size());
            return f10194p;
        } else if (bufferedSource.mo2244a(0L, f10191m)) {
            bufferedSource.mo2231i(f10191m.size());
            return f10195q;
        } else {
            return charset;
        }
    }

    /* renamed from: a */
    public static int m2889a(String str, long j, TimeUnit timeUnit) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException(str + " < 0");
        } else if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        } else {
            long millis = timeUnit.toMillis(j);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(str + " too large.");
            } else if (millis != 0 || i <= 0) {
                return (int) millis;
            } else {
                throw new IllegalArgumentException(str + " too small.");
            }
        }
    }

    /* renamed from: a */
    public static AssertionError m2888a(String str, Exception exc) {
        AssertionError assertionError = new AssertionError(str);
        try {
            assertionError.initCause(exc);
        } catch (IllegalStateException unused) {
        }
        return assertionError;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x007c, code lost:
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0052  */
    @javax.annotation.Nullable
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.net.InetAddress m2866d(java.lang.String r10, int r11, int r12) {
        /*
            r0 = 16
            byte[] r0 = new byte[r0]
            r1 = -1
            r2 = 0
            r3 = 0
            r4 = -1
            r5 = -1
        L9:
            r6 = 0
            if (r11 >= r12) goto L7d
            int r7 = r0.length
            if (r3 != r7) goto L10
            return r6
        L10:
            int r7 = r11 + 2
            if (r7 > r12) goto L29
            java.lang.String r8 = "::"
            r9 = 2
            boolean r8 = r10.regionMatches(r11, r8, r2, r9)
            if (r8 == 0) goto L29
            if (r4 == r1) goto L20
            return r6
        L20:
            int r3 = r3 + 2
            if (r7 != r12) goto L26
            r4 = r3
            goto L7d
        L26:
            r4 = r3
            r5 = r7
            goto L4e
        L29:
            if (r3 == 0) goto L4d
            java.lang.String r7 = ":"
            r8 = 1
            boolean r7 = r10.regionMatches(r11, r7, r2, r8)
            if (r7 == 0) goto L38
            int r11 = r11 + 1
            r5 = r11
            goto L4e
        L38:
            java.lang.String r7 = "."
            boolean r11 = r10.regionMatches(r11, r7, r2, r8)
            if (r11 == 0) goto L4c
            int r11 = r3 + (-2)
            boolean r10 = m2890a(r10, r5, r12, r0, r11)
            if (r10 != 0) goto L49
            return r6
        L49:
            int r3 = r3 + 2
            goto L7d
        L4c:
            return r6
        L4d:
            r5 = r11
        L4e:
            r11 = r5
            r7 = 0
        L50:
            if (r11 >= r12) goto L63
            char r8 = r10.charAt(r11)
            int r8 = m2899a(r8)
            if (r8 != r1) goto L5d
            goto L63
        L5d:
            int r7 = r7 << 4
            int r7 = r7 + r8
            int r11 = r11 + 1
            goto L50
        L63:
            int r8 = r11 - r5
            if (r8 == 0) goto L7c
            r9 = 4
            if (r8 <= r9) goto L6b
            goto L7c
        L6b:
            int r6 = r3 + 1
            int r8 = r7 >>> 8
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte r8 = (byte) r8
            r0[r3] = r8
            int r3 = r6 + 1
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r7 = (byte) r7
            r0[r6] = r7
            goto L9
        L7c:
            return r6
        L7d:
            int r10 = r0.length
            if (r3 == r10) goto L90
            if (r4 != r1) goto L83
            return r6
        L83:
            int r10 = r0.length
            int r11 = r3 - r4
            int r10 = r10 - r11
            java.lang.System.arraycopy(r0, r4, r0, r10, r11)
            int r10 = r0.length
            int r10 = r10 - r3
            int r10 = r10 + r4
            java.util.Arrays.fill(r0, r4, r10, r2)
        L90:
            java.net.InetAddress r10 = java.net.InetAddress.getByAddress(r0)     // Catch: java.net.UnknownHostException -> L95
            return r10
        L95:
            java.lang.AssertionError r10 = new java.lang.AssertionError
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.C2930c.m2866d(java.lang.String, int, int):java.net.InetAddress");
    }

    /* renamed from: a */
    private static boolean m2890a(String str, int i, int i2, byte[] bArr, int i3) {
        int i4 = i3;
        while (i < i2) {
            if (i4 == bArr.length) {
                return false;
            }
            if (i4 != i3) {
                if (str.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i5 = i;
            int i6 = 0;
            while (i5 < i2) {
                char charAt = str.charAt(i5);
                if (charAt < '0' || charAt > '9') {
                    break;
                } else if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + charAt) - 48) > 255) {
                    return false;
                } else {
                    i5++;
                }
            }
            if (i5 - i == 0) {
                return false;
            }
            bArr[i4] = (byte) i6;
            i4++;
            i = i5;
        }
        return i4 == i3 + 4;
    }

    /* renamed from: a */
    private static String m2876a(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        while (i2 < bArr.length) {
            int i5 = i2;
            while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i2;
            if (i6 > i4 && i6 >= 4) {
                i3 = i2;
                i4 = i6;
            }
            i2 = i5 + 2;
        }
        Buffer buffer = new Buffer();
        while (i < bArr.length) {
            if (i == i3) {
                buffer.mo2251i(58);
                i += i4;
                if (i == 16) {
                    buffer.mo2251i(58);
                }
            } else {
                if (i > 0) {
                    buffer.mo2251i(58);
                }
                buffer.mo2250l(((bArr[i] & 255) << 8) | (bArr[i + 1] & 255));
                i += 2;
            }
        }
        return buffer.m2285p();
    }

    /* renamed from: a */
    public static X509TrustManager m2900a() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
                throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
            }
            return (X509TrustManager) trustManagers[0];
        } catch (GeneralSecurityException e) {
            throw m2888a("No System TLS", (Exception) e);
        }
    }
}
