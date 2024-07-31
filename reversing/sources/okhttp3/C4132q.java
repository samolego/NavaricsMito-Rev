package okhttp3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.C2930c;
import okio.Buffer;
import okio.BufferedSink;

/* renamed from: okhttp3.q */
/* loaded from: classes2.dex */
public final class FormBody extends RequestBody {

    /* renamed from: a */
    private static final MediaType f10532a = MediaType.m2421a("application/x-www-form-urlencoded");

    /* renamed from: b */
    private final List<String> f10533b;

    /* renamed from: c */
    private final List<String> f10534c;

    FormBody(List<String> list, List<String> list2) {
        this.f10533b = C2930c.m2881a(list);
        this.f10534c = C2930c.m2881a(list2);
    }

    /* renamed from: a */
    public int m2513a() {
        return this.f10533b.size();
    }

    /* renamed from: a */
    public String m2512a(int i) {
        return this.f10533b.get(i);
    }

    /* renamed from: b */
    public String m2510b(int i) {
        return this.f10534c.get(i);
    }

    /* renamed from: c */
    public String m2509c(int i) {
        return HttpUrl.m2479a(m2510b(i), true);
    }

    @Override // okhttp3.RequestBody
    /* renamed from: b */
    public MediaType mo75b() {
        return f10532a;
    }

    @Override // okhttp3.RequestBody
    /* renamed from: c */
    public long mo74c() {
        return m2511a((BufferedSink) null, true);
    }

    @Override // okhttp3.RequestBody
    /* renamed from: a */
    public void mo76a(BufferedSink bufferedSink) throws IOException {
        m2511a(bufferedSink, false);
    }

    /* renamed from: a */
    private long m2511a(@Nullable BufferedSink bufferedSink, boolean z) {
        Buffer mo2238c;
        if (z) {
            mo2238c = new Buffer();
        } else {
            mo2238c = bufferedSink.mo2238c();
        }
        int size = this.f10533b.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                mo2238c.mo2251i(38);
            }
            mo2238c.mo2257b(this.f10533b.get(i));
            mo2238c.mo2251i(61);
            mo2238c.mo2257b(this.f10534c.get(i));
        }
        if (z) {
            long m2302b = mo2238c.m2302b();
            mo2238c.m2282t();
            return m2302b;
        }
        return 0L;
    }

    /* compiled from: FormBody.java */
    /* renamed from: okhttp3.q$a */
    /* loaded from: classes2.dex */
    public static final class C2983a {

        /* renamed from: a */
        private final List<String> f10535a;

        /* renamed from: b */
        private final List<String> f10536b;

        /* renamed from: c */
        private final Charset f10537c;

        public C2983a() {
            this(null);
        }

        public C2983a(Charset charset) {
            this.f10535a = new ArrayList();
            this.f10536b = new ArrayList();
            this.f10537c = charset;
        }

        /* renamed from: a */
        public C2983a m2507a(String str, String str2) {
            if (str != null) {
                if (str2 == null) {
                    throw new NullPointerException("value == null");
                }
                this.f10535a.add(HttpUrl.m2480a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f10537c));
                this.f10536b.add(HttpUrl.m2480a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f10537c));
                return this;
            }
            throw new NullPointerException("name == null");
        }

        /* renamed from: b */
        public C2983a m2506b(String str, String str2) {
            if (str != null) {
                if (str2 == null) {
                    throw new NullPointerException("value == null");
                }
                this.f10535a.add(HttpUrl.m2480a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.f10537c));
                this.f10536b.add(HttpUrl.m2480a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.f10537c));
                return this;
            }
            throw new NullPointerException("name == null");
        }

        /* renamed from: a */
        public FormBody m2508a() {
            return new FormBody(this.f10535a, this.f10536b);
        }
    }
}
