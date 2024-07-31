package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okhttp3.internal.C2930c;
import okio.Buffer;
import okio.BufferedSource;

/* renamed from: okhttp3.ac */
/* loaded from: classes2.dex */
public abstract class ResponseBody implements Closeable {

    /* renamed from: a */
    private Reader f9940a;

    @Nullable
    /* renamed from: a */
    public abstract MediaType mo129a();

    /* renamed from: b */
    public abstract long mo128b();

    /* renamed from: d */
    public abstract BufferedSource mo127d();

    /* renamed from: c */
    public final InputStream m3002c() {
        return mo127d().mo2234g();
    }

    /* renamed from: e */
    public final Reader m3001e() {
        Reader reader = this.f9940a;
        if (reader != null) {
            return reader;
        }
        C2914a c2914a = new C2914a(mo127d(), m2999g());
        this.f9940a = c2914a;
        return c2914a;
    }

    /* renamed from: f */
    public final String m3000f() throws IOException {
        BufferedSource mo127d = mo127d();
        try {
            return mo127d.mo2242a(C2930c.m2878a(mo127d, m2999g()));
        } finally {
            C2930c.m2897a(mo127d);
        }
    }

    /* renamed from: g */
    private Charset m2999g() {
        MediaType mo129a = mo129a();
        return mo129a != null ? mo129a.m2420a(C2930c.f10183e) : C2930c.f10183e;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        C2930c.m2897a(mo127d());
    }

    /* renamed from: a */
    public static ResponseBody m3003a(@Nullable MediaType mediaType, byte[] bArr) {
        return m3004a(mediaType, bArr.length, new Buffer().mo2255c(bArr));
    }

    /* renamed from: a */
    public static ResponseBody m3004a(@Nullable final MediaType mediaType, final long j, final BufferedSource bufferedSource) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        }
        return new ResponseBody() { // from class: okhttp3.ac.1
            @Override // okhttp3.ResponseBody
            @Nullable
            /* renamed from: a */
            public MediaType mo129a() {
                return MediaType.this;
            }

            @Override // okhttp3.ResponseBody
            /* renamed from: b */
            public long mo128b() {
                return j;
            }

            @Override // okhttp3.ResponseBody
            /* renamed from: d */
            public BufferedSource mo127d() {
                return bufferedSource;
            }
        };
    }

    /* compiled from: ResponseBody.java */
    /* renamed from: okhttp3.ac$a */
    /* loaded from: classes2.dex */
    static final class C2914a extends Reader {

        /* renamed from: a */
        private final BufferedSource f9944a;

        /* renamed from: b */
        private final Charset f9945b;

        /* renamed from: c */
        private boolean f9946c;

        /* renamed from: d */
        private Reader f9947d;

        C2914a(BufferedSource bufferedSource, Charset charset) {
            this.f9944a = bufferedSource;
            this.f9945b = charset;
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            if (this.f9946c) {
                throw new IOException("Stream closed");
            }
            Reader reader = this.f9947d;
            if (reader == null) {
                InputStreamReader inputStreamReader = new InputStreamReader(this.f9944a.mo2234g(), C2930c.m2878a(this.f9944a, this.f9945b));
                this.f9947d = inputStreamReader;
                reader = inputStreamReader;
            }
            return reader.read(cArr, i, i2);
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f9946c = true;
            Reader reader = this.f9947d;
            if (reader != null) {
                reader.close();
            } else {
                this.f9944a.close();
            }
        }
    }
}
