package retrofit2;

import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.C2984s;
import okhttp3.C2993z;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RequestBuilder.java */
/* renamed from: retrofit2.k */
/* loaded from: classes2.dex */
public final class C3202k {

    /* renamed from: a */
    private static final char[] f12666a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b */
    private final String f12667b;

    /* renamed from: c */
    private final HttpUrl f12668c;
    @Nullable

    /* renamed from: d */
    private String f12669d;
    @Nullable

    /* renamed from: e */
    private HttpUrl.C2986a f12670e;

    /* renamed from: f */
    private final C2993z.C2994a f12671f = new C2993z.C2994a();
    @Nullable

    /* renamed from: g */
    private MediaType f12672g;

    /* renamed from: h */
    private final boolean f12673h;
    @Nullable

    /* renamed from: i */
    private MultipartBody.C2988a f12674i;
    @Nullable

    /* renamed from: j */
    private FormBody.C2983a f12675j;
    @Nullable

    /* renamed from: k */
    private RequestBody f12676k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3202k(String str, HttpUrl httpUrl, @Nullable String str2, @Nullable C2984s c2984s, @Nullable MediaType mediaType, boolean z, boolean z2, boolean z3) {
        this.f12667b = str;
        this.f12668c = httpUrl;
        this.f12669d = str2;
        this.f12672g = mediaType;
        this.f12673h = z;
        if (c2984s != null) {
            this.f12671f.m2338a(c2984s);
        }
        if (z2) {
            this.f12675j = new FormBody.C2983a();
        } else if (z3) {
            this.f12674i = new MultipartBody.C2988a();
            this.f12674i.m2413a(MultipartBody.f10572e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m86a(Object obj) {
        this.f12669d = obj.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m85a(String str, String str2) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            MediaType m2418b = MediaType.m2418b(str2);
            if (m2418b == null) {
                throw new IllegalArgumentException("Malformed content type: " + str2);
            }
            this.f12672g = m2418b;
            return;
        }
        this.f12671f.m2335b(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m84a(String str, String str2, boolean z) {
        String str3 = this.f12669d;
        if (str3 == null) {
            throw new AssertionError();
        }
        this.f12669d = str3.replace("{" + str + "}", m83a(str2, z));
    }

    /* renamed from: a */
    private static String m83a(String str, boolean z) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt >= 32 && codePointAt < 127 && " \"<>^`{}|\\?#".indexOf(codePointAt) == -1 && (z || (codePointAt != 47 && codePointAt != 37))) {
                i += Character.charCount(codePointAt);
            } else {
                Buffer buffer = new Buffer();
                buffer.m2307a(str, 0, i);
                m79a(buffer, str, i, length, z);
                return buffer.m2285p();
            }
        }
        return str;
    }

    /* renamed from: a */
    private static void m79a(Buffer buffer, String str, int i, int i2, boolean z) {
        Buffer buffer2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt < 32 || codePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.m2311a(codePointAt);
                    while (!buffer2.mo2236f()) {
                        int mo2232i = buffer2.mo2232i() & 255;
                        buffer.mo2251i(37);
                        buffer.mo2251i((int) f12666a[(mo2232i >> 4) & 15]);
                        buffer.mo2251i((int) f12666a[mo2232i & 15]);
                    }
                } else {
                    buffer.m2311a(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m78b(String str, @Nullable String str2, boolean z) {
        String str3 = this.f12669d;
        if (str3 != null) {
            this.f12670e = this.f12668c.m2467d(str3);
            if (this.f12670e == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f12668c + ", Relative: " + this.f12669d);
            }
            this.f12669d = null;
        }
        if (z) {
            this.f12670e.m2442b(str, str2);
        } else {
            this.f12670e.m2447a(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m77c(String str, String str2, boolean z) {
        if (z) {
            this.f12675j.m2506b(str, str2);
        } else {
            this.f12675j.m2507a(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m81a(C2984s c2984s, RequestBody requestBody) {
        this.f12674i.m2414a(c2984s, requestBody);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m80a(MultipartBody.C2989b c2989b) {
        this.f12674i.m2412a(c2989b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m82a(RequestBody requestBody) {
        this.f12676k = requestBody;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public C2993z m87a() {
        HttpUrl m2469c;
        HttpUrl.C2986a c2986a = this.f12670e;
        if (c2986a != null) {
            m2469c = c2986a.m2441c();
        } else {
            m2469c = this.f12668c.m2469c(this.f12669d);
            if (m2469c == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f12668c + ", Relative: " + this.f12669d);
            }
        }
        C3203a c3203a = this.f12676k;
        if (c3203a == null) {
            FormBody.C2983a c2983a = this.f12675j;
            if (c2983a != null) {
                c3203a = c2983a.m2508a();
            } else {
                MultipartBody.C2988a c2988a = this.f12674i;
                if (c2988a != null) {
                    c3203a = c2988a.m2415a();
                } else if (this.f12673h) {
                    c3203a = RequestBody.m3036a((MediaType) null, new byte[0]);
                }
            }
        }
        MediaType mediaType = this.f12672g;
        if (mediaType != null) {
            if (c3203a != null) {
                c3203a = new C3203a(c3203a, mediaType);
            } else {
                this.f12671f.m2335b("Content-Type", mediaType.toString());
            }
        }
        return this.f12671f.m2337a(m2469c).m2339a(this.f12667b, c3203a).m2342a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RequestBuilder.java */
    /* renamed from: retrofit2.k$a */
    /* loaded from: classes2.dex */
    public static class C3203a extends RequestBody {

        /* renamed from: a */
        private final RequestBody f12677a;

        /* renamed from: b */
        private final MediaType f12678b;

        C3203a(RequestBody requestBody, MediaType mediaType) {
            this.f12677a = requestBody;
            this.f12678b = mediaType;
        }

        @Override // okhttp3.RequestBody
        /* renamed from: b */
        public MediaType mo75b() {
            return this.f12678b;
        }

        @Override // okhttp3.RequestBody
        /* renamed from: c */
        public long mo74c() throws IOException {
            return this.f12677a.mo74c();
        }

        @Override // okhttp3.RequestBody
        /* renamed from: a */
        public void mo76a(BufferedSink bufferedSink) throws IOException {
            this.f12677a.mo76a(bufferedSink);
        }
    }
}
