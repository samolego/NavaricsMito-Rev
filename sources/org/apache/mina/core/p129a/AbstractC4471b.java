package org.apache.mina.core.p129a;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/* compiled from: IoBuffer.java */
/* renamed from: org.apache.mina.core.a.b */
/* loaded from: classes2.dex */
public abstract class AbstractC3054b implements Comparable<AbstractC3054b> {

    /* renamed from: a */
    private static IoBufferAllocator f11320a = new SimpleBufferAllocator();

    /* renamed from: b */
    private static boolean f11321b = false;

    /* renamed from: a */
    public abstract String mo1380a(CharsetDecoder charsetDecoder) throws CharacterCodingException;

    /* renamed from: a */
    public abstract AbstractC3054b mo1383a(int i);

    /* renamed from: a */
    public abstract AbstractC3054b mo1381a(CharSequence charSequence, CharsetEncoder charsetEncoder) throws CharacterCodingException;

    /* renamed from: a */
    public abstract AbstractC3054b mo1378a(boolean z);

    /* renamed from: a */
    public abstract AbstractC3054b mo1377a(byte[] bArr);

    /* renamed from: b */
    public abstract int mo1376b();

    /* renamed from: b */
    public abstract AbstractC3054b mo1375b(int i);

    /* renamed from: b */
    public abstract AbstractC3054b mo1374b(ByteBuffer byteBuffer);

    /* renamed from: b */
    public abstract AbstractC3054b mo1373b(AbstractC3054b abstractC3054b);

    /* renamed from: c */
    public abstract AbstractC3054b mo1371c(int i);

    /* renamed from: d */
    public abstract AbstractC3054b mo1369d(int i);

    /* renamed from: e */
    public abstract AbstractC3054b mo1368e();

    /* renamed from: e */
    public abstract AbstractC3054b mo1367e(int i);

    /* renamed from: f */
    public abstract byte mo1365f(int i);

    /* renamed from: f */
    public abstract int mo1366f();

    /* renamed from: g */
    public abstract int mo1364g();

    /* renamed from: h */
    public abstract AbstractC3054b mo1363h();

    /* renamed from: i */
    public abstract AbstractC3054b mo1361i();

    /* renamed from: j */
    public abstract AbstractC3054b mo1359j();

    /* renamed from: k */
    public abstract AbstractC3054b mo1358k();

    /* renamed from: l */
    public abstract int mo1357l();

    /* renamed from: m */
    public abstract boolean mo1356m();

    /* renamed from: n */
    public abstract byte mo1355n();

    /* renamed from: o */
    public abstract AbstractC3054b mo1354o();

    /* renamed from: q */
    public abstract String mo1353q();

    /* renamed from: s */
    public abstract void mo1345s();

    /* renamed from: t */
    public abstract ByteBuffer mo1344t();

    /* renamed from: u */
    public abstract boolean mo1343u();

    /* renamed from: v */
    public abstract byte[] mo1342v();

    /* renamed from: w */
    public abstract int mo1341w();

    /* renamed from: r */
    public static IoBufferAllocator m1352r() {
        return f11320a;
    }

    /* renamed from: a */
    public static void m1379a(IoBufferAllocator ioBufferAllocator) {
        if (ioBufferAllocator == null) {
            throw new IllegalArgumentException("allocator");
        }
        IoBufferAllocator ioBufferAllocator2 = f11320a;
        f11320a = ioBufferAllocator;
        if (ioBufferAllocator2 != null) {
            ioBufferAllocator2.mo1350a();
        }
    }

    /* renamed from: h */
    public static AbstractC3054b m1362h(int i) {
        return m1382a(i, f11321b);
    }

    /* renamed from: a */
    public static AbstractC3054b m1382a(int i, boolean z) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity: " + i);
        }
        return f11320a.mo1349a(i, z);
    }

    /* renamed from: c */
    public static AbstractC3054b m1370c(ByteBuffer byteBuffer) {
        return f11320a.mo1348a(byteBuffer);
    }

    /* renamed from: b */
    public static AbstractC3054b m1372b(byte[] bArr) {
        return m1370c(ByteBuffer.wrap(bArr));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i */
    public static int m1360i(int i) {
        if (i < 0) {
            return Integer.MAX_VALUE;
        }
        int highestOneBit = Integer.highestOneBit(i);
        int i2 = highestOneBit << (highestOneBit < i ? 1 : 0);
        if (i2 < 0) {
            return Integer.MAX_VALUE;
        }
        return i2;
    }
}
