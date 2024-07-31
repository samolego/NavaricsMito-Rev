package okhttp3.internal.publicsuffix;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.C2930c;
import okhttp3.internal.p107e.Platform;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import org.slf4j.Marker;

/* loaded from: classes2.dex */
public final class PublicSuffixDatabase {

    /* renamed from: a */
    private static final byte[] f10472a = {42};

    /* renamed from: b */
    private static final String[] f10473b = new String[0];

    /* renamed from: c */
    private static final String[] f10474c = {Marker.ANY_MARKER};

    /* renamed from: d */
    private static final PublicSuffixDatabase f10475d = new PublicSuffixDatabase();

    /* renamed from: e */
    private final AtomicBoolean f10476e = new AtomicBoolean(false);

    /* renamed from: f */
    private final CountDownLatch f10477f = new CountDownLatch(1);

    /* renamed from: g */
    private byte[] f10478g;

    /* renamed from: h */
    private byte[] f10479h;

    /* renamed from: a */
    public static PublicSuffixDatabase m2587a() {
        return f10475d;
    }

    /* renamed from: a */
    public String m2586a(String str) {
        int length;
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] split = IDN.toUnicode(str).split("\\.");
        String[] m2584a = m2584a(split);
        if (split.length != m2584a.length || m2584a[0].charAt(0) == '!') {
            if (m2584a[0].charAt(0) == '!') {
                length = split.length - m2584a.length;
            } else {
                length = split.length - (m2584a.length + 1);
            }
            StringBuilder sb = new StringBuilder();
            String[] split2 = str.split("\\.");
            while (length < split2.length) {
                sb.append(split2[length]);
                sb.append('.');
                length++;
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
        return null;
    }

    /* renamed from: a */
    private String[] m2584a(String[] strArr) {
        String str;
        String str2;
        String str3;
        String[] strArr2;
        String[] strArr3;
        if (!this.f10476e.get() && this.f10476e.compareAndSet(false, true)) {
            m2583b();
        } else {
            try {
                this.f10477f.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        synchronized (this) {
            if (this.f10478g == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        byte[][] bArr = new byte[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            bArr[i] = strArr[i].getBytes(C2930c.f10183e);
        }
        int i2 = 0;
        while (true) {
            if (i2 >= bArr.length) {
                str = null;
                break;
            }
            str = m2585a(this.f10478g, bArr, i2);
            if (str != null) {
                break;
            }
            i2++;
        }
        if (bArr.length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i3 = 0; i3 < bArr2.length - 1; i3++) {
                bArr2[i3] = f10472a;
                str2 = m2585a(this.f10478g, bArr2, i3);
                if (str2 != null) {
                    break;
                }
            }
        }
        str2 = null;
        if (str2 != null) {
            for (int i4 = 0; i4 < bArr.length - 1; i4++) {
                str3 = m2585a(this.f10479h, bArr, i4);
                if (str3 != null) {
                    break;
                }
            }
        }
        str3 = null;
        if (str3 != null) {
            return ("!" + str3).split("\\.");
        } else if (str == null && str2 == null) {
            return f10474c;
        } else {
            if (str != null) {
                strArr2 = str.split("\\.");
            } else {
                strArr2 = f10473b;
            }
            if (str2 != null) {
                strArr3 = str2.split("\\.");
            } else {
                strArr3 = f10473b;
            }
            return strArr2.length > strArr3.length ? strArr2 : strArr3;
        }
    }

    /* renamed from: a */
    private static String m2585a(byte[] bArr, byte[][] bArr2, int i) {
        int i2;
        int i3;
        int i4;
        int length = bArr.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = (i5 + length) / 2;
            while (i6 > -1 && bArr[i6] != 10) {
                i6--;
            }
            int i7 = i6 + 1;
            int i8 = 1;
            while (true) {
                i2 = i7 + i8;
                if (bArr[i2] == 10) {
                    break;
                }
                i8++;
            }
            int i9 = i2 - i7;
            int i10 = i;
            boolean z = false;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (z) {
                    z = false;
                    i3 = 46;
                } else {
                    i3 = bArr2[i10][i11] & 255;
                }
                i4 = i3 - (bArr[i7 + i12] & 255);
                if (i4 == 0) {
                    i12++;
                    i11++;
                    if (i12 == i9) {
                        break;
                    } else if (bArr2[i10].length == i11) {
                        if (i10 == bArr2.length - 1) {
                            break;
                        }
                        i10++;
                        z = true;
                        i11 = -1;
                    }
                } else {
                    break;
                }
            }
            if (i4 < 0) {
                length = i7 - 1;
            } else if (i4 > 0) {
                i5 = i2 + 1;
            } else {
                int i13 = i9 - i12;
                int length2 = bArr2[i10].length - i11;
                while (true) {
                    i10++;
                    if (i10 >= bArr2.length) {
                        break;
                    }
                    length2 += bArr2[i10].length;
                }
                if (length2 < i13) {
                    length = i7 - 1;
                } else if (length2 <= i13) {
                    return new String(bArr, i7, i9, C2930c.f10183e);
                } else {
                    i5 = i2 + 1;
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    private void m2583b() {
        boolean z = false;
        while (true) {
            try {
                try {
                    m2582c();
                    break;
                } catch (InterruptedIOException unused) {
                    z = true;
                } catch (IOException e) {
                    Platform.m2762c().mo2776a(5, "Failed to read public suffix list", e);
                    if (z) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    /* renamed from: c */
    private void m2582c() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        BufferedSource m2263a = Okio.m2263a(new GzipSource(Okio.m2269a(resourceAsStream)));
        try {
            byte[] bArr = new byte[m2263a.mo2229k()];
            m2263a.mo2240a(bArr);
            byte[] bArr2 = new byte[m2263a.mo2229k()];
            m2263a.mo2240a(bArr2);
            synchronized (this) {
                this.f10478g = bArr;
                this.f10479h = bArr2;
            }
            this.f10477f.countDown();
        } finally {
            C2930c.m2897a(m2263a);
        }
    }
}
