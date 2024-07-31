package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.C2930c;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSink;

/* renamed from: okhttp3.internal.http2.h */
/* loaded from: classes2.dex */
final class Http2Writer implements Closeable {

    /* renamed from: b */
    private static final Logger f10455b = Logger.getLogger(Http2.class.getName());

    /* renamed from: c */
    private final BufferedSink f10457c;

    /* renamed from: d */
    private final boolean f10458d;

    /* renamed from: g */
    private boolean f10461g;

    /* renamed from: e */
    private final Buffer f10459e = new Buffer();

    /* renamed from: a */
    final Hpack.C2949b f10456a = new Hpack.C2949b(this.f10459e);

    /* renamed from: f */
    private int f10460f = 16384;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Http2Writer(BufferedSink bufferedSink, boolean z) {
        this.f10457c = bufferedSink;
        this.f10458d = z;
    }

    /* renamed from: a */
    public synchronized void m2624a() throws IOException {
        if (this.f10461g) {
            throw new IOException("closed");
        }
        if (this.f10458d) {
            if (f10455b.isLoggable(Level.FINE)) {
                f10455b.fine(C2930c.m2886a(">> CONNECTION %s", Http2.f10333a.hex()));
            }
            this.f10457c.mo2255c(Http2.f10333a.toByteArray());
            this.f10457c.flush();
        }
    }

    /* renamed from: a */
    public synchronized void m2617a(C2972k c2972k) throws IOException {
        if (this.f10461g) {
            throw new IOException("closed");
        }
        this.f10460f = c2972k.m2588d(this.f10460f);
        if (c2972k.m2591c() != -1) {
            this.f10456a.m2730a(c2972k.m2591c());
        }
        m2622a(0, 0, (byte) 4, (byte) 1);
        this.f10457c.flush();
    }

    /* renamed from: a */
    public synchronized void m2621a(int i, int i2, List<Header> list) throws IOException {
        if (this.f10461g) {
            throw new IOException("closed");
        }
        this.f10456a.m2728a(list);
        long m2302b = this.f10459e.m2302b();
        int min = (int) Math.min(this.f10460f - 4, m2302b);
        long j = min;
        int i3 = (m2302b > j ? 1 : (m2302b == j ? 0 : -1));
        m2622a(i, min + 4, (byte) 5, i3 == 0 ? (byte) 4 : (byte) 0);
        this.f10457c.mo2253g(i2 & Integer.MAX_VALUE);
        this.f10457c.mo2215a_(this.f10459e, j);
        if (i3 > 0) {
            m2610b(i, m2302b - j);
        }
    }

    /* renamed from: b */
    public synchronized void m2611b() throws IOException {
        if (this.f10461g) {
            throw new IOException("closed");
        }
        this.f10457c.flush();
    }

    /* renamed from: a */
    public synchronized void m2614a(boolean z, int i, int i2, List<Header> list) throws IOException {
        if (this.f10461g) {
            throw new IOException("closed");
        }
        m2613a(z, i, list);
    }

    /* renamed from: a */
    public synchronized void m2619a(int i, ErrorCode errorCode) throws IOException {
        if (this.f10461g) {
            throw new IOException("closed");
        }
        if (errorCode.httpCode == -1) {
            throw new IllegalArgumentException();
        }
        m2622a(i, 4, (byte) 3, (byte) 0);
        this.f10457c.mo2253g(errorCode.httpCode);
        this.f10457c.flush();
    }

    /* renamed from: c */
    public int m2608c() {
        return this.f10460f;
    }

    /* renamed from: a */
    public synchronized void m2612a(boolean z, int i, Buffer buffer, int i2) throws IOException {
        if (this.f10461g) {
            throw new IOException("closed");
        }
        m2623a(i, z ? (byte) 1 : (byte) 0, buffer, i2);
    }

    /* renamed from: a */
    void m2623a(int i, byte b, Buffer buffer, int i2) throws IOException {
        m2622a(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.f10457c.mo2215a_(buffer, i2);
        }
    }

    /* renamed from: b */
    public synchronized void m2609b(C2972k c2972k) throws IOException {
        if (this.f10461g) {
            throw new IOException("closed");
        }
        int i = 0;
        m2622a(0, c2972k.m2593b() * 6, (byte) 4, (byte) 0);
        while (i < 10) {
            if (c2972k.m2596a(i)) {
                this.f10457c.mo2252h(i == 4 ? 3 : i == 7 ? 4 : i);
                this.f10457c.mo2253g(c2972k.m2592b(i));
            }
            i++;
        }
        this.f10457c.flush();
    }

    /* renamed from: a */
    public synchronized void m2615a(boolean z, int i, int i2) throws IOException {
        if (this.f10461g) {
            throw new IOException("closed");
        }
        m2622a(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
        this.f10457c.mo2253g(i);
        this.f10457c.mo2253g(i2);
        this.f10457c.flush();
    }

    /* renamed from: a */
    public synchronized void m2618a(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
        if (this.f10461g) {
            throw new IOException("closed");
        }
        if (errorCode.httpCode == -1) {
            throw Http2.m2722a("errorCode.httpCode == -1", new Object[0]);
        }
        m2622a(0, bArr.length + 8, (byte) 7, (byte) 0);
        this.f10457c.mo2253g(i);
        this.f10457c.mo2253g(errorCode.httpCode);
        if (bArr.length > 0) {
            this.f10457c.mo2255c(bArr);
        }
        this.f10457c.flush();
    }

    /* renamed from: a */
    public synchronized void m2620a(int i, long j) throws IOException {
        if (this.f10461g) {
            throw new IOException("closed");
        }
        if (j == 0 || j > 2147483647L) {
            throw Http2.m2722a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        }
        m2622a(i, 4, (byte) 8, (byte) 0);
        this.f10457c.mo2253g((int) j);
        this.f10457c.flush();
    }

    /* renamed from: a */
    public void m2622a(int i, int i2, byte b, byte b2) throws IOException {
        if (f10455b.isLoggable(Level.FINE)) {
            f10455b.fine(Http2.m2721a(false, i, i2, b, b2));
        }
        int i3 = this.f10460f;
        if (i2 > i3) {
            throw Http2.m2722a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            throw Http2.m2722a("reserved bit set: %s", Integer.valueOf(i));
        }
        m2616a(this.f10457c, i2);
        this.f10457c.mo2251i(b & 255);
        this.f10457c.mo2251i(b2 & 255);
        this.f10457c.mo2253g(i & Integer.MAX_VALUE);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f10461g = true;
        this.f10457c.close();
    }

    /* renamed from: a */
    private static void m2616a(BufferedSink bufferedSink, int i) throws IOException {
        bufferedSink.mo2251i((i >>> 16) & 255);
        bufferedSink.mo2251i((i >>> 8) & 255);
        bufferedSink.mo2251i(i & 255);
    }

    /* renamed from: b */
    private void m2610b(int i, long j) throws IOException {
        while (j > 0) {
            int min = (int) Math.min(this.f10460f, j);
            long j2 = min;
            j -= j2;
            m2622a(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.f10457c.mo2215a_(this.f10459e, j2);
        }
    }

    /* renamed from: a */
    void m2613a(boolean z, int i, List<Header> list) throws IOException {
        if (this.f10461g) {
            throw new IOException("closed");
        }
        this.f10456a.m2728a(list);
        long m2302b = this.f10459e.m2302b();
        int min = (int) Math.min(this.f10460f, m2302b);
        long j = min;
        int i2 = (m2302b > j ? 1 : (m2302b == j ? 0 : -1));
        byte b = i2 == 0 ? (byte) 4 : (byte) 0;
        if (z) {
            b = (byte) (b | 1);
        }
        m2622a(i, min, (byte) 1, b);
        this.f10457c.mo2215a_(this.f10459e, j);
        if (i2 > 0) {
            m2610b(i, m2302b - j);
        }
    }
}
