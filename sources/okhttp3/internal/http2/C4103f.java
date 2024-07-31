package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.C2930c;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: okhttp3.internal.http2.f */
/* loaded from: classes2.dex */
public final class Http2Reader implements Closeable {

    /* renamed from: a */
    static final Logger f10418a = Logger.getLogger(Http2.class.getName());

    /* renamed from: b */
    final Hpack.C2948a f10419b;

    /* renamed from: c */
    private final BufferedSource f10420c;

    /* renamed from: d */
    private final C2965a f10421d;

    /* renamed from: e */
    private final boolean f10422e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Reader.java */
    /* renamed from: okhttp3.internal.http2.f$b */
    /* loaded from: classes2.dex */
    public interface InterfaceC2966b {
        /* renamed from: a */
        void mo2658a();

        /* renamed from: a */
        void mo2657a(int i, int i2, int i3, boolean z);

        /* renamed from: a */
        void mo2656a(int i, int i2, List<Header> list) throws IOException;

        /* renamed from: a */
        void mo2655a(int i, long j);

        /* renamed from: a */
        void mo2654a(int i, ErrorCode errorCode);

        /* renamed from: a */
        void mo2653a(int i, ErrorCode errorCode, ByteString byteString);

        /* renamed from: a */
        void mo2652a(boolean z, int i, int i2);

        /* renamed from: a */
        void mo2651a(boolean z, int i, int i2, List<Header> list);

        /* renamed from: a */
        void mo2650a(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException;

        /* renamed from: a */
        void mo2649a(boolean z, C2972k c2972k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Http2Reader(BufferedSource bufferedSource, boolean z) {
        this.f10420c = bufferedSource;
        this.f10422e = z;
        this.f10421d = new C2965a(this.f10420c);
        this.f10419b = new Hpack.C2948a(4096, this.f10421d);
    }

    /* renamed from: a */
    public void m2672a(InterfaceC2966b interfaceC2966b) throws IOException {
        if (this.f10422e) {
            if (!m2668a(true, interfaceC2966b)) {
                throw Http2.m2720b("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        ByteString mo2237d = this.f10420c.mo2237d(Http2.f10333a.size());
        if (f10418a.isLoggable(Level.FINE)) {
            f10418a.fine(C2930c.m2886a("<< CONNECTION %s", mo2237d.hex()));
        }
        if (!Http2.f10333a.equals(mo2237d)) {
            throw Http2.m2720b("Expected a connection header but was %s", mo2237d.utf8());
        }
    }

    /* renamed from: a */
    public boolean m2668a(boolean z, InterfaceC2966b interfaceC2966b) throws IOException {
        try {
            this.f10420c.mo2245a(9L);
            int m2669a = m2669a(this.f10420c);
            if (m2669a < 0 || m2669a > 16384) {
                throw Http2.m2720b("FRAME_SIZE_ERROR: %s", Integer.valueOf(m2669a));
            }
            byte mo2232i = (byte) (this.f10420c.mo2232i() & 255);
            if (!z || mo2232i == 4) {
                byte mo2232i2 = (byte) (this.f10420c.mo2232i() & 255);
                int mo2229k = this.f10420c.mo2229k() & Integer.MAX_VALUE;
                if (f10418a.isLoggable(Level.FINE)) {
                    f10418a.fine(Http2.m2721a(true, mo2229k, m2669a, mo2232i, mo2232i2));
                }
                switch (mo2232i) {
                    case 0:
                        m2667b(interfaceC2966b, m2669a, mo2232i2, mo2229k);
                        break;
                    case 1:
                        m2670a(interfaceC2966b, m2669a, mo2232i2, mo2229k);
                        break;
                    case 2:
                        m2666c(interfaceC2966b, m2669a, mo2232i2, mo2229k);
                        break;
                    case 3:
                        m2665d(interfaceC2966b, m2669a, mo2232i2, mo2229k);
                        break;
                    case 4:
                        m2664e(interfaceC2966b, m2669a, mo2232i2, mo2229k);
                        break;
                    case 5:
                        m2663f(interfaceC2966b, m2669a, mo2232i2, mo2229k);
                        break;
                    case 6:
                        m2662g(interfaceC2966b, m2669a, mo2232i2, mo2229k);
                        break;
                    case 7:
                        m2661h(interfaceC2966b, m2669a, mo2232i2, mo2229k);
                        break;
                    case 8:
                        m2660i(interfaceC2966b, m2669a, mo2232i2, mo2229k);
                        break;
                    default:
                        this.f10420c.mo2231i(m2669a);
                        break;
                }
                return true;
            }
            throw Http2.m2720b("Expected a SETTINGS frame but was %s", Byte.valueOf(mo2232i));
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: a */
    private void m2670a(InterfaceC2966b interfaceC2966b, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw Http2.m2720b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        short mo2232i = (b & 8) != 0 ? (short) (this.f10420c.mo2232i() & 255) : (short) 0;
        if ((b & 32) != 0) {
            m2671a(interfaceC2966b, i2);
            i -= 5;
        }
        interfaceC2966b.mo2651a(z, i2, -1, m2673a(m2674a(i, b, mo2232i), mo2232i, b, i2));
    }

    /* renamed from: a */
    private List<Header> m2673a(int i, short s, byte b, int i2) throws IOException {
        C2965a c2965a = this.f10421d;
        c2965a.f10426d = i;
        c2965a.f10423a = i;
        c2965a.f10427e = s;
        c2965a.f10424b = b;
        c2965a.f10425c = i2;
        this.f10419b.m2748a();
        return this.f10419b.m2744b();
    }

    /* renamed from: b */
    private void m2667b(InterfaceC2966b interfaceC2966b, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw Http2.m2720b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        if ((b & 32) != 0) {
            throw Http2.m2720b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short mo2232i = (b & 8) != 0 ? (short) (this.f10420c.mo2232i() & 255) : (short) 0;
        interfaceC2966b.mo2650a(z, i2, this.f10420c, m2674a(i, b, mo2232i));
        this.f10420c.mo2231i(mo2232i);
    }

    /* renamed from: c */
    private void m2666c(InterfaceC2966b interfaceC2966b, int i, byte b, int i2) throws IOException {
        if (i != 5) {
            throw Http2.m2720b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw Http2.m2720b("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        m2671a(interfaceC2966b, i2);
    }

    /* renamed from: a */
    private void m2671a(InterfaceC2966b interfaceC2966b, int i) throws IOException {
        int mo2229k = this.f10420c.mo2229k();
        interfaceC2966b.mo2657a(i, mo2229k & Integer.MAX_VALUE, (this.f10420c.mo2232i() & 255) + 1, (Integer.MIN_VALUE & mo2229k) != 0);
    }

    /* renamed from: d */
    private void m2665d(InterfaceC2966b interfaceC2966b, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw Http2.m2720b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw Http2.m2720b("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int mo2229k = this.f10420c.mo2229k();
        ErrorCode fromHttp2 = ErrorCode.fromHttp2(mo2229k);
        if (fromHttp2 == null) {
            throw Http2.m2720b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(mo2229k));
        }
        interfaceC2966b.mo2654a(i2, fromHttp2);
    }

    /* renamed from: e */
    private void m2664e(InterfaceC2966b interfaceC2966b, int i, byte b, int i2) throws IOException {
        if (i2 != 0) {
            throw Http2.m2720b("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b & 1) != 0) {
            if (i != 0) {
                throw Http2.m2720b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            interfaceC2966b.mo2658a();
        } else if (i % 6 != 0) {
            throw Http2.m2720b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        } else {
            C2972k c2972k = new C2972k();
            for (int i3 = 0; i3 < i; i3 += 6) {
                int mo2230j = this.f10420c.mo2230j() & 65535;
                int mo2229k = this.f10420c.mo2229k();
                switch (mo2230j) {
                    case 2:
                        if (mo2229k != 0 && mo2229k != 1) {
                            throw Http2.m2720b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                        }
                        break;
                    case 3:
                        mo2230j = 4;
                        break;
                    case 4:
                        mo2230j = 7;
                        if (mo2229k < 0) {
                            throw Http2.m2720b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        }
                        break;
                    case 5:
                        if (mo2229k < 16384 || mo2229k > 16777215) {
                            throw Http2.m2720b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(mo2229k));
                        }
                        break;
                        break;
                }
                c2972k.m2595a(mo2230j, mo2229k);
            }
            interfaceC2966b.mo2649a(false, c2972k);
        }
    }

    /* renamed from: f */
    private void m2663f(InterfaceC2966b interfaceC2966b, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw Http2.m2720b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short mo2232i = (b & 8) != 0 ? (short) (this.f10420c.mo2232i() & 255) : (short) 0;
        interfaceC2966b.mo2656a(i2, this.f10420c.mo2229k() & Integer.MAX_VALUE, m2673a(m2674a(i - 4, b, mo2232i), mo2232i, b, i2));
    }

    /* renamed from: g */
    private void m2662g(InterfaceC2966b interfaceC2966b, int i, byte b, int i2) throws IOException {
        if (i != 8) {
            throw Http2.m2720b("TYPE_PING length != 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw Http2.m2720b("TYPE_PING streamId != 0", new Object[0]);
        }
        interfaceC2966b.mo2652a((b & 1) != 0, this.f10420c.mo2229k(), this.f10420c.mo2229k());
    }

    /* renamed from: h */
    private void m2661h(InterfaceC2966b interfaceC2966b, int i, byte b, int i2) throws IOException {
        if (i < 8) {
            throw Http2.m2720b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw Http2.m2720b("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int mo2229k = this.f10420c.mo2229k();
        int mo2229k2 = this.f10420c.mo2229k();
        int i3 = i - 8;
        ErrorCode fromHttp2 = ErrorCode.fromHttp2(mo2229k2);
        if (fromHttp2 == null) {
            throw Http2.m2720b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(mo2229k2));
        }
        ByteString byteString = ByteString.EMPTY;
        if (i3 > 0) {
            byteString = this.f10420c.mo2237d(i3);
        }
        interfaceC2966b.mo2653a(mo2229k, fromHttp2, byteString);
    }

    /* renamed from: i */
    private void m2660i(InterfaceC2966b interfaceC2966b, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw Http2.m2720b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
        long mo2229k = this.f10420c.mo2229k() & 2147483647L;
        if (mo2229k == 0) {
            throw Http2.m2720b("windowSizeIncrement was 0", Long.valueOf(mo2229k));
        }
        interfaceC2966b.mo2655a(i2, mo2229k);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f10420c.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Reader.java */
    /* renamed from: okhttp3.internal.http2.f$a */
    /* loaded from: classes2.dex */
    public static final class C2965a implements Source {

        /* renamed from: a */
        int f10423a;

        /* renamed from: b */
        byte f10424b;

        /* renamed from: c */
        int f10425c;

        /* renamed from: d */
        int f10426d;

        /* renamed from: e */
        short f10427e;

        /* renamed from: f */
        private final BufferedSource f10428f;

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        C2965a(BufferedSource bufferedSource) {
            this.f10428f = bufferedSource;
        }

        @Override // okio.Source
        /* renamed from: a */
        public long mo130a(Buffer buffer, long j) throws IOException {
            while (true) {
                int i = this.f10426d;
                if (i == 0) {
                    this.f10428f.mo2231i(this.f10427e);
                    this.f10427e = (short) 0;
                    if ((this.f10424b & 4) != 0) {
                        return -1L;
                    }
                    m2659b();
                } else {
                    long a = this.f10428f.mo130a(buffer, Math.min(j, i));
                    if (a == -1) {
                        return -1L;
                    }
                    this.f10426d = (int) (this.f10426d - a);
                    return a;
                }
            }
        }

        @Override // okio.Source
        /* renamed from: a */
        public Timeout mo2214a() {
            return this.f10428f.mo2214a();
        }

        /* renamed from: b */
        private void m2659b() throws IOException {
            int i = this.f10425c;
            int m2669a = Http2Reader.m2669a(this.f10428f);
            this.f10426d = m2669a;
            this.f10423a = m2669a;
            byte mo2232i = (byte) (this.f10428f.mo2232i() & 255);
            this.f10424b = (byte) (this.f10428f.mo2232i() & 255);
            if (Http2Reader.f10418a.isLoggable(Level.FINE)) {
                Http2Reader.f10418a.fine(Http2.m2721a(true, this.f10425c, this.f10423a, mo2232i, this.f10424b));
            }
            this.f10425c = this.f10428f.mo2229k() & Integer.MAX_VALUE;
            if (mo2232i != 9) {
                throw Http2.m2720b("%s != TYPE_CONTINUATION", Byte.valueOf(mo2232i));
            }
            if (this.f10425c != i) {
                throw Http2.m2720b("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    /* renamed from: a */
    static int m2669a(BufferedSource bufferedSource) throws IOException {
        return (bufferedSource.mo2232i() & 255) | ((bufferedSource.mo2232i() & 255) << 16) | ((bufferedSource.mo2232i() & 255) << 8);
    }

    /* renamed from: a */
    static int m2674a(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw Http2.m2720b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }
}
