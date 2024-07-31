package okhttp3;

import com.common.LOGIN_ACK_REL;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;
import okhttp3.internal.C2930c;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

/* renamed from: okhttp3.w */
/* loaded from: classes2.dex */
public final class MultipartBody extends RequestBody {

    /* renamed from: a */
    public static final MediaType f10568a = MediaType.m2421a("multipart/mixed");

    /* renamed from: b */
    public static final MediaType f10569b = MediaType.m2421a("multipart/alternative");

    /* renamed from: c */
    public static final MediaType f10570c = MediaType.m2421a("multipart/digest");

    /* renamed from: d */
    public static final MediaType f10571d = MediaType.m2421a("multipart/parallel");

    /* renamed from: e */
    public static final MediaType f10572e = MediaType.m2421a("multipart/form-data");

    /* renamed from: f */
    private static final byte[] f10573f = {58, 32};

    /* renamed from: g */
    private static final byte[] f10574g = {LOGIN_ACK_REL.LOGIN_ACK_REL_SN_ERR, 10};

    /* renamed from: h */
    private static final byte[] f10575h = {45, 45};

    /* renamed from: i */
    private final ByteString f10576i;

    /* renamed from: j */
    private final MediaType f10577j;

    /* renamed from: k */
    private final MediaType f10578k;

    /* renamed from: l */
    private final List<C2989b> f10579l;

    /* renamed from: m */
    private long f10580m = -1;

    MultipartBody(ByteString byteString, MediaType mediaType, List<C2989b> list) {
        this.f10576i = byteString;
        this.f10577j = mediaType;
        this.f10578k = MediaType.m2421a(mediaType + "; boundary=" + byteString.utf8());
        this.f10579l = C2930c.m2881a(list);
    }

    @Override // okhttp3.RequestBody
    /* renamed from: b */
    public MediaType mo75b() {
        return this.f10578k;
    }

    @Override // okhttp3.RequestBody
    /* renamed from: c */
    public long mo74c() throws IOException {
        long j = this.f10580m;
        if (j != -1) {
            return j;
        }
        long m2416a = m2416a((BufferedSink) null, true);
        this.f10580m = m2416a;
        return m2416a;
    }

    @Override // okhttp3.RequestBody
    /* renamed from: a */
    public void mo76a(BufferedSink bufferedSink) throws IOException {
        m2416a(bufferedSink, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private long m2416a(@Nullable BufferedSink bufferedSink, boolean z) throws IOException {
        Buffer buffer;
        if (z) {
            bufferedSink = new Buffer();
            buffer = bufferedSink;
        } else {
            buffer = 0;
        }
        int size = this.f10579l.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            C2989b c2989b = this.f10579l.get(i);
            C2984s c2984s = c2989b.f10584a;
            RequestBody requestBody = c2989b.f10585b;
            bufferedSink.mo2255c(f10575h);
            bufferedSink.mo2256b(this.f10576i);
            bufferedSink.mo2255c(f10574g);
            if (c2984s != null) {
                int m2502a = c2984s.m2502a();
                for (int i2 = 0; i2 < m2502a; i2++) {
                    bufferedSink.mo2257b(c2984s.m2501a(i2)).mo2255c(f10573f).mo2257b(c2984s.m2496b(i2)).mo2255c(f10574g);
                }
            }
            MediaType mo75b = requestBody.mo75b();
            if (mo75b != null) {
                bufferedSink.mo2257b("Content-Type: ").mo2257b(mo75b.toString()).mo2255c(f10574g);
            }
            long mo74c = requestBody.mo74c();
            if (mo74c != -1) {
                bufferedSink.mo2257b("Content-Length: ").mo2249m(mo74c).mo2255c(f10574g);
            } else if (z) {
                buffer.m2282t();
                return -1L;
            }
            bufferedSink.mo2255c(f10574g);
            if (z) {
                j += mo74c;
            } else {
                requestBody.mo76a(bufferedSink);
            }
            bufferedSink.mo2255c(f10574g);
        }
        bufferedSink.mo2255c(f10575h);
        bufferedSink.mo2256b(this.f10576i);
        bufferedSink.mo2255c(f10575h);
        bufferedSink.mo2255c(f10574g);
        if (z) {
            long m2302b = j + buffer.m2302b();
            buffer.m2282t();
            return m2302b;
        }
        return j;
    }

    /* renamed from: a */
    static StringBuilder m2417a(StringBuilder sb, String str) {
        sb.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\n') {
                sb.append("%0A");
            } else if (charAt == '\r') {
                sb.append("%0D");
            } else if (charAt == '\"') {
                sb.append("%22");
            } else {
                sb.append(charAt);
            }
        }
        sb.append('\"');
        return sb;
    }

    /* compiled from: MultipartBody.java */
    /* renamed from: okhttp3.w$b */
    /* loaded from: classes2.dex */
    public static final class C2989b {
        @Nullable

        /* renamed from: a */
        final C2984s f10584a;

        /* renamed from: b */
        final RequestBody f10585b;

        /* renamed from: a */
        public static C2989b m2410a(@Nullable C2984s c2984s, RequestBody requestBody) {
            if (requestBody == null) {
                throw new NullPointerException("body == null");
            }
            if (c2984s != null && c2984s.m2500a("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (c2984s != null && c2984s.m2500a("Content-Length") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
            return new C2989b(c2984s, requestBody);
        }

        /* renamed from: a */
        public static C2989b m2411a(String str, @Nullable String str2, RequestBody requestBody) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            StringBuilder sb = new StringBuilder("form-data; name=");
            MultipartBody.m2417a(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                MultipartBody.m2417a(sb, str2);
            }
            return m2410a(C2984s.m2499a("Content-Disposition", sb.toString()), requestBody);
        }

        private C2989b(@Nullable C2984s c2984s, RequestBody requestBody) {
            this.f10584a = c2984s;
            this.f10585b = requestBody;
        }
    }

    /* compiled from: MultipartBody.java */
    /* renamed from: okhttp3.w$a */
    /* loaded from: classes2.dex */
    public static final class C2988a {

        /* renamed from: a */
        private final ByteString f10581a;

        /* renamed from: b */
        private MediaType f10582b;

        /* renamed from: c */
        private final List<C2989b> f10583c;

        public C2988a() {
            this(UUID.randomUUID().toString());
        }

        public C2988a(String str) {
            this.f10582b = MultipartBody.f10568a;
            this.f10583c = new ArrayList();
            this.f10581a = ByteString.encodeUtf8(str);
        }

        /* renamed from: a */
        public C2988a m2413a(MediaType mediaType) {
            if (mediaType == null) {
                throw new NullPointerException("type == null");
            }
            if (!mediaType.m2422a().equals("multipart")) {
                throw new IllegalArgumentException("multipart != " + mediaType);
            }
            this.f10582b = mediaType;
            return this;
        }

        /* renamed from: a */
        public C2988a m2414a(@Nullable C2984s c2984s, RequestBody requestBody) {
            return m2412a(C2989b.m2410a(c2984s, requestBody));
        }

        /* renamed from: a */
        public C2988a m2412a(C2989b c2989b) {
            if (c2989b == null) {
                throw new NullPointerException("part == null");
            }
            this.f10583c.add(c2989b);
            return this;
        }

        /* renamed from: a */
        public MultipartBody m2415a() {
            if (this.f10583c.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new MultipartBody(this.f10581a, this.f10582b, this.f10583c);
        }
    }
}
