package okio;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* renamed from: okio.d */
/* loaded from: classes2.dex */
public interface BufferedSink extends WritableByteChannel, Sink {
    /* renamed from: a */
    long mo2258a(Source source) throws IOException;

    /* renamed from: b */
    BufferedSink mo2257b(String str) throws IOException;

    /* renamed from: b */
    BufferedSink mo2256b(ByteString byteString) throws IOException;

    /* renamed from: c */
    Buffer mo2238c();

    /* renamed from: c */
    BufferedSink mo2255c(byte[] bArr) throws IOException;

    /* renamed from: c */
    BufferedSink mo2254c(byte[] bArr, int i, int i2) throws IOException;

    void flush() throws IOException;

    /* renamed from: g */
    BufferedSink mo2253g(int i) throws IOException;

    /* renamed from: h */
    BufferedSink mo2252h(int i) throws IOException;

    /* renamed from: i */
    BufferedSink mo2251i(int i) throws IOException;

    /* renamed from: l */
    BufferedSink mo2250l(long j) throws IOException;

    /* renamed from: m */
    BufferedSink mo2249m(long j) throws IOException;

    /* renamed from: w */
    BufferedSink mo2248w() throws IOException;
}
