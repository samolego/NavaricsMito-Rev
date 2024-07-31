package okhttp3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okhttp3.internal.C2930c;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* renamed from: okhttp3.aa */
/* loaded from: classes2.dex */
public abstract class RequestBody {
    /* renamed from: a */
    public abstract void mo76a(BufferedSink bufferedSink) throws IOException;

    @Nullable
    /* renamed from: b */
    public abstract MediaType mo75b();

    /* renamed from: c */
    public long mo74c() throws IOException {
        return -1L;
    }

    /* renamed from: a */
    public static RequestBody m3038a(@Nullable MediaType mediaType, String str) {
        Charset charset = C2930c.f10183e;
        if (mediaType != null && (charset = mediaType.m2419b()) == null) {
            charset = C2930c.f10183e;
            mediaType = MediaType.m2418b(mediaType + "; charset=utf-8");
        }
        return m3036a(mediaType, str.getBytes(charset));
    }

    /* renamed from: a */
    public static RequestBody m3037a(@Nullable final MediaType mediaType, final ByteString byteString) {
        return new RequestBody() { // from class: okhttp3.aa.1
            @Override // okhttp3.RequestBody
            @Nullable
            /* renamed from: b */
            public MediaType mo75b() {
                return MediaType.this;
            }

            @Override // okhttp3.RequestBody
            /* renamed from: c */
            public long mo74c() throws IOException {
                return byteString.size();
            }

            @Override // okhttp3.RequestBody
            /* renamed from: a */
            public void mo76a(BufferedSink bufferedSink) throws IOException {
                bufferedSink.mo2256b(byteString);
            }
        };
    }

    /* renamed from: a */
    public static RequestBody m3036a(@Nullable MediaType mediaType, byte[] bArr) {
        return m3035a(mediaType, bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static RequestBody m3035a(@Nullable final MediaType mediaType, final byte[] bArr, final int i, final int i2) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        C2930c.m2898a(bArr.length, i, i2);
        return new RequestBody() { // from class: okhttp3.aa.2
            @Override // okhttp3.RequestBody
            @Nullable
            /* renamed from: b */
            public MediaType mo75b() {
                return MediaType.this;
            }

            @Override // okhttp3.RequestBody
            /* renamed from: c */
            public long mo74c() {
                return i2;
            }

            @Override // okhttp3.RequestBody
            /* renamed from: a */
            public void mo76a(BufferedSink bufferedSink) throws IOException {
                bufferedSink.mo2254c(bArr, i, i2);
            }
        };
    }

    /* renamed from: a */
    public static RequestBody m3039a(@Nullable final MediaType mediaType, final File file) {
        if (file == null) {
            throw new NullPointerException("content == null");
        }
        return new RequestBody() { // from class: okhttp3.aa.3
            @Override // okhttp3.RequestBody
            @Nullable
            /* renamed from: b */
            public MediaType mo75b() {
                return MediaType.this;
            }

            @Override // okhttp3.RequestBody
            /* renamed from: c */
            public long mo74c() {
                return file.length();
            }

            @Override // okhttp3.RequestBody
            /* renamed from: a */
            public void mo76a(BufferedSink bufferedSink) throws IOException {
                Source source = null;
                try {
                    source = Okio.m2270a(file);
                    bufferedSink.mo2258a(source);
                } finally {
                    C2930c.m2897a(source);
                }
            }
        };
    }
}
