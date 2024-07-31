package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class SegmentedByteString extends ByteString {
    final transient int[] directory;
    final transient byte[][] segments;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SegmentedByteString(Buffer buffer, int i) {
        super(null);
        C3006s.m2204a(buffer.f10675b, 0L, i);
        int i2 = 0;
        Segment segment = buffer.f10674a;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (segment.f10705c == segment.f10704b) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += segment.f10705c - segment.f10704b;
            i4++;
            segment = segment.f10708f;
        }
        this.segments = new byte[i4];
        this.directory = new int[i4 * 2];
        Segment segment2 = buffer.f10674a;
        int i5 = 0;
        while (i2 < i) {
            this.segments[i5] = segment2.f10703a;
            i2 += segment2.f10705c - segment2.f10704b;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.directory;
            iArr[i5] = i2;
            iArr[this.segments.length + i5] = segment2.f10704b;
            segment2.f10706d = true;
            i5++;
            segment2 = segment2.f10708f;
        }
    }

    @Override // okio.ByteString
    public String utf8() {
        return m2328a().utf8();
    }

    @Override // okio.ByteString
    public String string(Charset charset) {
        return m2328a().string(charset);
    }

    @Override // okio.ByteString
    public String base64() {
        return m2328a().base64();
    }

    @Override // okio.ByteString
    public String hex() {
        return m2328a().hex();
    }

    @Override // okio.ByteString
    public ByteString toAsciiLowercase() {
        return m2328a().toAsciiLowercase();
    }

    @Override // okio.ByteString
    public ByteString toAsciiUppercase() {
        return m2328a().toAsciiUppercase();
    }

    @Override // okio.ByteString
    public ByteString md5() {
        return m2328a().md5();
    }

    @Override // okio.ByteString
    public ByteString sha1() {
        return m2328a().sha1();
    }

    @Override // okio.ByteString
    public ByteString sha256() {
        return m2328a().sha256();
    }

    @Override // okio.ByteString
    public ByteString hmacSha1(ByteString byteString) {
        return m2328a().hmacSha1(byteString);
    }

    @Override // okio.ByteString
    public ByteString hmacSha256(ByteString byteString) {
        return m2328a().hmacSha256(byteString);
    }

    @Override // okio.ByteString
    public String base64Url() {
        return m2328a().base64Url();
    }

    @Override // okio.ByteString
    public ByteString substring(int i) {
        return m2328a().substring(i);
    }

    @Override // okio.ByteString
    public ByteString substring(int i, int i2) {
        return m2328a().substring(i, i2);
    }

    @Override // okio.ByteString
    public byte getByte(int i) {
        C3006s.m2204a(this.directory[this.segments.length - 1], i, 1L);
        int m2327a = m2327a(i);
        int i2 = m2327a == 0 ? 0 : this.directory[m2327a - 1];
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        return bArr[m2327a][(i - i2) + iArr[bArr.length + m2327a]];
    }

    /* renamed from: a */
    private int m2327a(int i) {
        int binarySearch = Arrays.binarySearch(this.directory, 0, this.segments.length, i + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    @Override // okio.ByteString
    public int size() {
        return this.directory[this.segments.length - 1];
    }

    @Override // okio.ByteString
    public byte[] toByteArray() {
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.directory;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.segments[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // okio.ByteString
    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // okio.ByteString
    public void write(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        int length = this.segments.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.directory;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            outputStream.write(this.segments[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // okio.ByteString
    public void write(Buffer buffer) {
        int length = this.segments.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.directory;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            Segment segment = new Segment(this.segments[i], i3, (i3 + i4) - i2, true, false);
            if (buffer.f10674a == null) {
                segment.f10709g = segment;
                segment.f10708f = segment;
                buffer.f10674a = segment;
            } else {
                buffer.f10674a.f10709g.m2222a(segment);
            }
            i++;
            i2 = i4;
        }
        buffer.f10675b += i2;
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i, ByteString byteString, int i2, int i3) {
        if (i < 0 || i > size() - i3) {
            return false;
        }
        int m2327a = m2327a(i);
        while (i3 > 0) {
            int i4 = m2327a == 0 ? 0 : this.directory[m2327a - 1];
            int min = Math.min(i3, ((this.directory[m2327a] - i4) + i4) - i);
            int[] iArr = this.directory;
            byte[][] bArr = this.segments;
            if (!byteString.rangeEquals(i2, bArr[m2327a], (i - i4) + iArr[bArr.length + m2327a], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            m2327a++;
        }
        return true;
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > size() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int m2327a = m2327a(i);
        while (i3 > 0) {
            int i4 = m2327a == 0 ? 0 : this.directory[m2327a - 1];
            int min = Math.min(i3, ((this.directory[m2327a] - i4) + i4) - i);
            int[] iArr = this.directory;
            byte[][] bArr2 = this.segments;
            if (!C3006s.m2201a(bArr2[m2327a], (i - i4) + iArr[bArr2.length + m2327a], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            m2327a++;
        }
        return true;
    }

    @Override // okio.ByteString
    public int indexOf(byte[] bArr, int i) {
        return m2328a().indexOf(bArr, i);
    }

    @Override // okio.ByteString
    public int lastIndexOf(byte[] bArr, int i) {
        return m2328a().lastIndexOf(bArr, i);
    }

    /* renamed from: a */
    private ByteString m2328a() {
        return new ByteString(toByteArray());
    }

    @Override // okio.ByteString
    byte[] internalArray() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    @Override // okio.ByteString
    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int length = this.segments.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.segments[i2];
            int[] iArr = this.directory;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.hashCode = i3;
        return i3;
    }

    @Override // okio.ByteString
    public String toString() {
        return m2328a().toString();
    }

    private Object writeReplace() {
        return m2328a();
    }
}
