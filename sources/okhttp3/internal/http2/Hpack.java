package okhttp3.internal.http2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.internal.C2930c;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: okhttp3.internal.http2.b */
/* loaded from: classes2.dex */
public final class Hpack {

    /* renamed from: a */
    static final Header[] f10313a = {new Header(Header.f10309f, ""), new Header(Header.f10306c, "GET"), new Header(Header.f10306c, "POST"), new Header(Header.f10307d, "/"), new Header(Header.f10307d, "/index.html"), new Header(Header.f10308e, "http"), new Header(Header.f10308e, "https"), new Header(Header.f10305b, "200"), new Header(Header.f10305b, "204"), new Header(Header.f10305b, "206"), new Header(Header.f10305b, "304"), new Header(Header.f10305b, "400"), new Header(Header.f10305b, "404"), new Header(Header.f10305b, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};

    /* renamed from: b */
    static final Map<ByteString, Integer> f10314b = m2750a();

    /* compiled from: Hpack.java */
    /* renamed from: okhttp3.internal.http2.b$a */
    /* loaded from: classes2.dex */
    static final class C2948a {

        /* renamed from: a */
        Header[] f10315a;

        /* renamed from: b */
        int f10316b;

        /* renamed from: c */
        int f10317c;

        /* renamed from: d */
        int f10318d;

        /* renamed from: e */
        private final List<Header> f10319e;

        /* renamed from: f */
        private final BufferedSource f10320f;

        /* renamed from: g */
        private final int f10321g;

        /* renamed from: h */
        private int f10322h;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C2948a(int i, Source source) {
            this(i, i, source);
        }

        C2948a(int i, int i2, Source source) {
            this.f10319e = new ArrayList();
            this.f10315a = new Header[8];
            this.f10316b = this.f10315a.length - 1;
            this.f10317c = 0;
            this.f10318d = 0;
            this.f10321g = i;
            this.f10322h = i2;
            this.f10320f = Okio.m2263a(source);
        }

        /* renamed from: d */
        private void m2740d() {
            int i = this.f10322h;
            int i2 = this.f10318d;
            if (i < i2) {
                if (i == 0) {
                    m2738e();
                } else {
                    m2747a(i2 - i);
                }
            }
        }

        /* renamed from: e */
        private void m2738e() {
            Arrays.fill(this.f10315a, (Object) null);
            this.f10316b = this.f10315a.length - 1;
            this.f10317c = 0;
            this.f10318d = 0;
        }

        /* renamed from: a */
        private int m2747a(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f10315a.length;
                while (true) {
                    length--;
                    if (length < this.f10316b || i <= 0) {
                        break;
                    }
                    i -= this.f10315a[length].f10312i;
                    this.f10318d -= this.f10315a[length].f10312i;
                    this.f10317c--;
                    i2++;
                }
                Header[] headerArr = this.f10315a;
                int i3 = this.f10316b;
                System.arraycopy(headerArr, i3 + 1, headerArr, i3 + 1 + i2, this.f10317c);
                this.f10316b += i2;
            }
            return i2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public void m2748a() throws IOException {
            while (!this.f10320f.mo2236f()) {
                int mo2232i = this.f10320f.mo2232i() & 255;
                if (mo2232i == 128) {
                    throw new IOException("index == 0");
                }
                if ((mo2232i & 128) == 128) {
                    m2743b(m2746a(mo2232i, 127) - 1);
                } else if (mo2232i == 64) {
                    m2734g();
                } else if ((mo2232i & 64) == 64) {
                    m2737e(m2746a(mo2232i, 63) - 1);
                } else if ((mo2232i & 32) == 32) {
                    this.f10322h = m2746a(mo2232i, 31);
                    int i = this.f10322h;
                    if (i < 0 || i > this.f10321g) {
                        throw new IOException("Invalid dynamic table size update " + this.f10322h);
                    }
                    m2740d();
                } else if (mo2232i == 16 || mo2232i == 0) {
                    m2736f();
                } else {
                    m2739d(m2746a(mo2232i, 15) - 1);
                }
            }
        }

        /* renamed from: b */
        public List<Header> m2744b() {
            ArrayList arrayList = new ArrayList(this.f10319e);
            this.f10319e.clear();
            return arrayList;
        }

        /* renamed from: b */
        private void m2743b(int i) throws IOException {
            if (m2733g(i)) {
                this.f10319e.add(Hpack.f10313a[i]);
                return;
            }
            int m2741c = m2741c(i - Hpack.f10313a.length);
            if (m2741c >= 0) {
                Header[] headerArr = this.f10315a;
                if (m2741c < headerArr.length) {
                    this.f10319e.add(headerArr[m2741c]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        /* renamed from: c */
        private int m2741c(int i) {
            return this.f10316b + 1 + i;
        }

        /* renamed from: d */
        private void m2739d(int i) throws IOException {
            this.f10319e.add(new Header(m2735f(i), m2742c()));
        }

        /* renamed from: f */
        private void m2736f() throws IOException {
            this.f10319e.add(new Header(Hpack.m2749a(m2742c()), m2742c()));
        }

        /* renamed from: e */
        private void m2737e(int i) throws IOException {
            m2745a(-1, new Header(m2735f(i), m2742c()));
        }

        /* renamed from: g */
        private void m2734g() throws IOException {
            m2745a(-1, new Header(Hpack.m2749a(m2742c()), m2742c()));
        }

        /* renamed from: f */
        private ByteString m2735f(int i) throws IOException {
            if (m2733g(i)) {
                return Hpack.f10313a[i].f10310g;
            }
            int m2741c = m2741c(i - Hpack.f10313a.length);
            if (m2741c >= 0) {
                Header[] headerArr = this.f10315a;
                if (m2741c < headerArr.length) {
                    return headerArr[m2741c].f10310g;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        /* renamed from: g */
        private boolean m2733g(int i) {
            return i >= 0 && i <= Hpack.f10313a.length - 1;
        }

        /* renamed from: a */
        private void m2745a(int i, Header header) {
            this.f10319e.add(header);
            int i2 = header.f10312i;
            if (i != -1) {
                i2 -= this.f10315a[m2741c(i)].f10312i;
            }
            int i3 = this.f10322h;
            if (i2 > i3) {
                m2738e();
                return;
            }
            int m2747a = m2747a((this.f10318d + i2) - i3);
            if (i == -1) {
                int i4 = this.f10317c + 1;
                Header[] headerArr = this.f10315a;
                if (i4 > headerArr.length) {
                    Header[] headerArr2 = new Header[headerArr.length * 2];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.f10316b = this.f10315a.length - 1;
                    this.f10315a = headerArr2;
                }
                int i5 = this.f10316b;
                this.f10316b = i5 - 1;
                this.f10315a[i5] = header;
                this.f10317c++;
            } else {
                this.f10315a[i + m2741c(i) + m2747a] = header;
            }
            this.f10318d += i2;
        }

        /* renamed from: h */
        private int m2732h() throws IOException {
            return this.f10320f.mo2232i() & 255;
        }

        /* renamed from: a */
        int m2746a(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int m2732h = m2732h();
                if ((m2732h & 128) == 0) {
                    return i2 + (m2732h << i4);
                }
                i2 += (m2732h & 127) << i4;
                i4 += 7;
            }
        }

        /* renamed from: c */
        ByteString m2742c() throws IOException {
            int m2732h = m2732h();
            boolean z = (m2732h & 128) == 128;
            int m2746a = m2746a(m2732h, 127);
            if (z) {
                return ByteString.m2330of(Huffman.m2607a().m2603a(this.f10320f.mo2233h(m2746a)));
            }
            return this.f10320f.mo2237d(m2746a);
        }
    }

    /* renamed from: a */
    private static Map<ByteString, Integer> m2750a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f10313a.length);
        int i = 0;
        while (true) {
            Header[] headerArr = f10313a;
            if (i < headerArr.length) {
                if (!linkedHashMap.containsKey(headerArr[i].f10310g)) {
                    linkedHashMap.put(f10313a[i].f10310g, Integer.valueOf(i));
                }
                i++;
            } else {
                return Collections.unmodifiableMap(linkedHashMap);
            }
        }
    }

    /* compiled from: Hpack.java */
    /* renamed from: okhttp3.internal.http2.b$b */
    /* loaded from: classes2.dex */
    static final class C2949b {

        /* renamed from: a */
        int f10323a;

        /* renamed from: b */
        int f10324b;

        /* renamed from: c */
        Header[] f10325c;

        /* renamed from: d */
        int f10326d;

        /* renamed from: e */
        int f10327e;

        /* renamed from: f */
        int f10328f;

        /* renamed from: g */
        private final Buffer f10329g;

        /* renamed from: h */
        private final boolean f10330h;

        /* renamed from: i */
        private int f10331i;

        /* renamed from: j */
        private boolean f10332j;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C2949b(Buffer buffer) {
            this(4096, true, buffer);
        }

        C2949b(int i, boolean z, Buffer buffer) {
            this.f10331i = Integer.MAX_VALUE;
            this.f10325c = new Header[8];
            this.f10326d = this.f10325c.length - 1;
            this.f10327e = 0;
            this.f10328f = 0;
            this.f10323a = i;
            this.f10324b = i;
            this.f10330h = z;
            this.f10329g = buffer;
        }

        /* renamed from: a */
        private void m2731a() {
            Arrays.fill(this.f10325c, (Object) null);
            this.f10326d = this.f10325c.length - 1;
            this.f10327e = 0;
            this.f10328f = 0;
        }

        /* renamed from: b */
        private int m2724b(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f10325c.length;
                while (true) {
                    length--;
                    if (length < this.f10326d || i <= 0) {
                        break;
                    }
                    i -= this.f10325c[length].f10312i;
                    this.f10328f -= this.f10325c[length].f10312i;
                    this.f10327e--;
                    i2++;
                }
                Header[] headerArr = this.f10325c;
                int i3 = this.f10326d;
                System.arraycopy(headerArr, i3 + 1, headerArr, i3 + 1 + i2, this.f10327e);
                Header[] headerArr2 = this.f10325c;
                int i4 = this.f10326d;
                Arrays.fill(headerArr2, i4 + 1, i4 + 1 + i2, (Object) null);
                this.f10326d += i2;
            }
            return i2;
        }

        /* renamed from: a */
        private void m2727a(Header header) {
            int i = header.f10312i;
            int i2 = this.f10324b;
            if (i > i2) {
                m2731a();
                return;
            }
            m2724b((this.f10328f + i) - i2);
            int i3 = this.f10327e + 1;
            Header[] headerArr = this.f10325c;
            if (i3 > headerArr.length) {
                Header[] headerArr2 = new Header[headerArr.length * 2];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.f10326d = this.f10325c.length - 1;
                this.f10325c = headerArr2;
            }
            int i4 = this.f10326d;
            this.f10326d = i4 - 1;
            this.f10325c[i4] = header;
            this.f10327e++;
            this.f10328f += i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public void m2728a(List<Header> list) throws IOException {
            int i;
            int i2;
            if (this.f10332j) {
                int i3 = this.f10331i;
                if (i3 < this.f10324b) {
                    m2729a(i3, 31, 32);
                }
                this.f10332j = false;
                this.f10331i = Integer.MAX_VALUE;
                m2729a(this.f10324b, 31, 32);
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                Header header = list.get(i4);
                ByteString asciiLowercase = header.f10310g.toAsciiLowercase();
                ByteString byteString = header.f10311h;
                Integer num = Hpack.f10314b.get(asciiLowercase);
                if (num != null) {
                    i = num.intValue() + 1;
                    if (i > 1 && i < 8) {
                        if (C2930c.m2895a(Hpack.f10313a[i - 1].f10311h, byteString)) {
                            i2 = i;
                        } else if (C2930c.m2895a(Hpack.f10313a[i].f10311h, byteString)) {
                            i2 = i;
                            i++;
                        }
                    }
                    i2 = i;
                    i = -1;
                } else {
                    i = -1;
                    i2 = -1;
                }
                if (i == -1) {
                    int i5 = this.f10326d + 1;
                    int length = this.f10325c.length;
                    while (true) {
                        if (i5 >= length) {
                            break;
                        }
                        if (C2930c.m2895a(this.f10325c[i5].f10310g, asciiLowercase)) {
                            if (C2930c.m2895a(this.f10325c[i5].f10311h, byteString)) {
                                i = Hpack.f10313a.length + (i5 - this.f10326d);
                                break;
                            } else if (i2 == -1) {
                                i2 = (i5 - this.f10326d) + Hpack.f10313a.length;
                            }
                        }
                        i5++;
                    }
                }
                if (i != -1) {
                    m2729a(i, 127, 128);
                } else if (i2 == -1) {
                    this.f10329g.mo2251i(64);
                    m2726a(asciiLowercase);
                    m2726a(byteString);
                    m2727a(header);
                } else if (asciiLowercase.startsWith(Header.f10304a) && !Header.f10309f.equals(asciiLowercase)) {
                    m2729a(i2, 15, 0);
                    m2726a(byteString);
                } else {
                    m2729a(i2, 63, 64);
                    m2726a(byteString);
                    m2727a(header);
                }
            }
        }

        /* renamed from: a */
        void m2729a(int i, int i2, int i3) {
            if (i < i2) {
                this.f10329g.mo2251i(i | i3);
                return;
            }
            this.f10329g.mo2251i(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.f10329g.mo2251i(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.f10329g.mo2251i(i4);
        }

        /* renamed from: a */
        void m2726a(ByteString byteString) throws IOException {
            if (this.f10330h && Huffman.m2607a().m2605a(byteString) < byteString.size()) {
                Buffer buffer = new Buffer();
                Huffman.m2607a().m2604a(byteString, buffer);
                ByteString m2286o = buffer.m2286o();
                m2729a(m2286o.size(), 127, 128);
                this.f10329g.mo2256b(m2286o);
                return;
            }
            m2729a(byteString.size(), 127, 0);
            this.f10329g.mo2256b(byteString);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public void m2730a(int i) {
            this.f10323a = i;
            int min = Math.min(i, 16384);
            int i2 = this.f10324b;
            if (i2 == min) {
                return;
            }
            if (min < i2) {
                this.f10331i = Math.min(this.f10331i, min);
            }
            this.f10332j = true;
            this.f10324b = min;
            m2725b();
        }

        /* renamed from: b */
        private void m2725b() {
            int i = this.f10324b;
            int i2 = this.f10328f;
            if (i < i2) {
                if (i == 0) {
                    m2731a();
                } else {
                    m2724b(i2 - i);
                }
            }
        }
    }

    /* renamed from: a */
    static ByteString m2749a(ByteString byteString) throws IOException {
        int size = byteString.size();
        for (int i = 0; i < size; i++) {
            byte b = byteString.getByte(i);
            if (b >= 65 && b <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }
}
