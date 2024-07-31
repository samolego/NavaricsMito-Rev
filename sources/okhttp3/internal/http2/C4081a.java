package okhttp3.internal.http2;

import okhttp3.internal.C2930c;
import okio.ByteString;

/* renamed from: okhttp3.internal.http2.a */
/* loaded from: classes2.dex */
public final class Header {

    /* renamed from: a */
    public static final ByteString f10304a = ByteString.encodeUtf8(":");

    /* renamed from: b */
    public static final ByteString f10305b = ByteString.encodeUtf8(":status");

    /* renamed from: c */
    public static final ByteString f10306c = ByteString.encodeUtf8(":method");

    /* renamed from: d */
    public static final ByteString f10307d = ByteString.encodeUtf8(":path");

    /* renamed from: e */
    public static final ByteString f10308e = ByteString.encodeUtf8(":scheme");

    /* renamed from: f */
    public static final ByteString f10309f = ByteString.encodeUtf8(":authority");

    /* renamed from: g */
    public final ByteString f10310g;

    /* renamed from: h */
    public final ByteString f10311h;

    /* renamed from: i */
    final int f10312i;

    public Header(String str, String str2) {
        this(ByteString.encodeUtf8(str), ByteString.encodeUtf8(str2));
    }

    public Header(ByteString byteString, String str) {
        this(byteString, ByteString.encodeUtf8(str));
    }

    public Header(ByteString byteString, ByteString byteString2) {
        this.f10310g = byteString;
        this.f10311h = byteString2;
        this.f10312i = byteString.size() + 32 + byteString2.size();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Header) {
            Header header = (Header) obj;
            return this.f10310g.equals(header.f10310g) && this.f10311h.equals(header.f10311h);
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.f10310g.hashCode()) * 31) + this.f10311h.hashCode();
    }

    public String toString() {
        return C2930c.m2886a("%s: %s", this.f10310g.utf8(), this.f10311h.utf8());
    }
}
