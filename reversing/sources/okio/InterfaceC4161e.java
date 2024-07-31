package okio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* renamed from: okio.e */
/* loaded from: classes2.dex */
public interface BufferedSource extends ReadableByteChannel, Source {
    /* renamed from: a */
    long mo2247a(byte b) throws IOException;

    /* renamed from: a */
    long mo2241a(Sink sink) throws IOException;

    /* renamed from: a */
    String mo2242a(Charset charset) throws IOException;

    /* renamed from: a */
    void mo2245a(long j) throws IOException;

    /* renamed from: a */
    void mo2240a(byte[] bArr) throws IOException;

    /* renamed from: a */
    boolean mo2244a(long j, ByteString byteString) throws IOException;

    /* renamed from: b */
    boolean mo2239b(long j) throws IOException;

    /* renamed from: c */
    Buffer mo2238c();

    /* renamed from: d */
    ByteString mo2237d(long j) throws IOException;

    /* renamed from: f */
    String mo2235f(long j) throws IOException;

    /* renamed from: f */
    boolean mo2236f() throws IOException;

    /* renamed from: g */
    InputStream mo2234g();

    /* renamed from: h */
    byte[] mo2233h(long j) throws IOException;

    /* renamed from: i */
    byte mo2232i() throws IOException;

    /* renamed from: i */
    void mo2231i(long j) throws IOException;

    /* renamed from: j */
    short mo2230j() throws IOException;

    /* renamed from: k */
    int mo2229k() throws IOException;

    /* renamed from: l */
    short mo2228l() throws IOException;

    /* renamed from: m */
    int mo2227m() throws IOException;

    /* renamed from: n */
    long mo2226n() throws IOException;

    /* renamed from: q */
    String mo2225q() throws IOException;
}
