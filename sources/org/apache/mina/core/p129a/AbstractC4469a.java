package org.apache.mina.core.p129a;

import com.senseplay.sdk.tool.IniEditor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;

/* renamed from: org.apache.mina.core.a.a */
/* loaded from: classes2.dex */
public abstract class AbstractIoBuffer extends AbstractC3054b {

    /* renamed from: a */
    private final boolean f11314a;

    /* renamed from: b */
    private boolean f11315b;

    /* renamed from: c */
    private boolean f11316c;

    /* renamed from: d */
    private boolean f11317d;

    /* renamed from: e */
    private int f11318e;

    /* renamed from: f */
    private int f11319f = -1;

    /* renamed from: a */
    protected abstract void mo1346a(ByteBuffer byteBuffer);

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractIoBuffer(IoBufferAllocator ioBufferAllocator, int i) {
        this.f11317d = true;
        m1379a(ioBufferAllocator);
        this.f11317d = true;
        this.f11314a = false;
        this.f11318e = i;
    }

    /* renamed from: a */
    public final boolean m1395a() {
        return mo1344t().isDirect();
    }

    @Override // org.apache.mina.core.p129a.AbstractC3054b
    /* renamed from: a */
    public final AbstractC3054b mo1383a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("minimumCapacity: " + i);
        }
        this.f11318e = i;
        return this;
    }

    @Override // org.apache.mina.core.p129a.AbstractC3054b
    /* renamed from: b */
    public final int mo1376b() {
        return mo1344t().capacity();
    }

    @Override // org.apache.mina.core.p129a.AbstractC3054b
    /* renamed from: b */
    public final AbstractC3054b mo1375b(int i) {
        if (!this.f11317d) {
            throw new IllegalStateException("Derived buffers and their parent can't be expanded.");
        }
        if (i > mo1376b()) {
            int mo1366f = mo1366f();
            int mo1364g = mo1364g();
            ByteOrder m1384p = m1384p();
            ByteBuffer t = mo1344t();
            ByteBuffer mo1347b = m1352r().mo1347b(i, m1395a());
            t.clear();
            mo1347b.put(t);
            mo1346a(mo1347b);
            mo1344t().limit(mo1364g);
            if (this.f11319f >= 0) {
                mo1344t().position(this.f11319f);
                mo1344t().mark();
            }
            mo1344t().position(mo1366f);
            mo1344t().order(m1384p);
        }
        return this;
    }

    /* renamed from: c */
    public final boolean m1388c() {
        return this.f11315b && this.f11317d;
    }

    /* renamed from: d */
    public final boolean m1387d() {
        return this.f11316c && this.f11317d;
    }

    @Override // org.apache.mina.core.p129a.AbstractC3054b
    /* renamed from: a */
    public final AbstractC3054b mo1378a(boolean z) {
        if (!this.f11317d) {
            throw new IllegalStateException("Derived buffers and their parent can't be expanded.");
        }
        this.f11315b = z;
        return this;
    }

    @Override // org.apache.mina.core.p129a.AbstractC3054b
    /* renamed from: c */
    public final AbstractC3054b mo1371c(int i) {
        return m1392a(mo1366f(), i, false);
    }

    /* renamed from: b */
    private AbstractC3054b m1389b(int i, boolean z) {
        return m1392a(mo1366f(), i, z);
    }

    /* renamed from: a */
    private AbstractC3054b m1392a(int i, int i2, boolean z) {
        if (!this.f11317d) {
            throw new IllegalStateException("Derived buffers and their parent can't be expanded.");
        }
        int i3 = i + i2;
        int m1360i = z ? AbstractC3054b.m1360i(i3) : i3;
        if (m1360i > mo1376b()) {
            mo1375b(m1360i);
        }
        if (i3 > mo1364g()) {
            mo1344t().limit(i3);
        }
        return this;
    }

    @Override // org.apache.mina.core.p129a.AbstractC3054b
    /* renamed from: e */
    public final AbstractC3054b mo1368e() {
        if (!this.f11317d) {
            throw new IllegalStateException("Derived buffers and their parent can't be expanded.");
        }
        int mo1366f = mo1366f();
        int mo1376b = mo1376b();
        int mo1364g = mo1364g();
        if (mo1376b == mo1364g) {
            return this;
        }
        int max = Math.max(this.f11318e, mo1364g);
        int i = mo1376b;
        while (true) {
            int i2 = i >>> 1;
            if (i2 < max) {
                break;
            } else if (max == 0) {
                i = i2;
                break;
            } else {
                i = i2;
            }
        }
        int max2 = Math.max(max, i);
        if (max2 == mo1376b) {
            return this;
        }
        ByteOrder m1384p = m1384p();
        ByteBuffer t = mo1344t();
        ByteBuffer mo1347b = m1352r().mo1347b(max2, m1395a());
        t.position(0);
        t.limit(mo1364g);
        mo1347b.put(t);
        mo1346a(mo1347b);
        mo1344t().position(mo1366f);
        mo1344t().limit(mo1364g);
        mo1344t().order(m1384p);
        this.f11319f = -1;
        return this;
    }

    @Override // org.apache.mina.core.p129a.AbstractC3054b
    /* renamed from: f */
    public final int mo1366f() {
        return mo1344t().position();
    }

    @Override // org.apache.mina.core.p129a.AbstractC3054b
    /* renamed from: d */
    public final AbstractC3054b mo1369d(int i) {
        m1393a(i, 0);
        mo1344t().position(i);
        if (this.f11319f > i) {
            this.f11319f = -1;
        }
        return this;
    }

    @Override // org.apache.mina.core.p129a.AbstractC3054b
    /* renamed from: g */
    public final int mo1364g() {
        return mo1344t().limit();
    }

    @Override // org.apache.mina.core.p129a.AbstractC3054b
    /* renamed from: e */
    public final AbstractC3054b mo1367e(int i) {
        m1393a(i, 0);
        mo1344t().limit(i);
        if (this.f11319f > i) {
            this.f11319f = -1;
        }
        return this;
    }

    @Override // org.apache.mina.core.p129a.AbstractC3054b
    /* renamed from: h */
    public final AbstractC3054b mo1363h() {
        ByteBuffer t = mo1344t();
        t.mark();
        this.f11319f = t.position();
        return this;
    }

    @Override // org.apache.mina.core.p129a.AbstractC3054b
    /* renamed from: i */
    public final AbstractC3054b mo1361i() {
        mo1344t().reset();
        return this;
    }

    @Override // org.apache.mina.core.p129a.AbstractC3054b
    /* renamed from: j */
    public final AbstractC3054b mo1359j() {
        mo1344t().clear();
        this.f11319f = -1;
        return this;
    }

    @Override // org.apache.mina.core.p129a.AbstractC3054b
    /* renamed from: k */
    public final AbstractC3054b mo1358k() {
        mo1344t().flip();
        this.f11319f = -1;
        return this;
    }

    @Override // org.apache.mina.core.p129a.AbstractC3054b
    /* renamed from: l */
    public final int mo1357l() {
        ByteBuffer t = mo1344t();
        return t.limit() - t.position();
    }

    @Override // org.apache.mina.core.p129a.AbstractC3054b
    /* renamed from: m */
    public final boolean mo1356m() {
        ByteBuffer t = mo1344t();
        return t.limit() > t.position();
    }

    @Override // org.apache.mina.core.p129a.AbstractC3054b
    /* renamed from: n */
    public final byte mo1355n() {
        return mo1344t().get();
    }

    @Override // org.apache.mina.core.p129a.AbstractC3054b
    /* renamed from: f */
    public final byte mo1365f(int i) {
        return mo1344t().get(i);
    }

    /* renamed from: a */
    public final AbstractC3054b m1390a(byte[] bArr, int i, int i2) {
        mo1344t().get(bArr, i, i2);
        return this;
    }

    @Override // org.apache.mina.core.p129a.AbstractC3054b
    /* renamed from: b */
    public final AbstractC3054b mo1374b(ByteBuffer byteBuffer) {
        m1385j(byteBuffer.remaining());
        mo1344t().put(byteBuffer);
        return this;
    }

    @Override // org.apache.mina.core.p129a.AbstractC3054b
    /* renamed from: o */
    public final AbstractC3054b mo1354o() {
        int i;
        int mo1357l = mo1357l();
        int mo1376b = mo1376b();
        if (mo1376b == 0) {
            return this;
        }
        if (m1387d() && mo1357l <= (mo1376b >>> 2) && mo1376b > (i = this.f11318e)) {
            int max = Math.max(i, mo1357l << 1);
            int i2 = mo1376b;
            while (true) {
                int i3 = i2 >>> 1;
                if (i3 < max) {
                    break;
                }
                i2 = i3;
            }
            int max2 = Math.max(max, i2);
            if (max2 == mo1376b) {
                return this;
            }
            ByteOrder m1384p = m1384p();
            if (mo1357l > max2) {
                throw new IllegalStateException("The amount of the remaining bytes is greater than the new capacity.");
            }
            ByteBuffer t = mo1344t();
            ByteBuffer mo1347b = m1352r().mo1347b(max2, m1395a());
            mo1347b.put(t);
            mo1346a(mo1347b);
            mo1344t().order(m1384p);
        } else {
            mo1344t().compact();
        }
        this.f11319f = -1;
        return this;
    }

    /* renamed from: p */
    public final ByteOrder m1384p() {
        return mo1344t().order();
    }

    public int hashCode() {
        int mo1366f = mo1366f();
        int i = 1;
        for (int mo1364g = mo1364g() - 1; mo1364g >= mo1366f; mo1364g--) {
            i = (i * 31) + mo1365f(mo1364g);
        }
        return i;
    }

    public boolean equals(Object obj) {
        if (obj instanceof AbstractC3054b) {
            AbstractC3054b abstractC3054b = (AbstractC3054b) obj;
            if (mo1357l() != abstractC3054b.mo1357l()) {
                return false;
            }
            int mo1366f = mo1366f();
            int mo1364g = mo1364g() - 1;
            int mo1364g2 = abstractC3054b.mo1364g() - 1;
            while (mo1364g >= mo1366f) {
                if (mo1365f(mo1364g) != abstractC3054b.mo1365f(mo1364g2)) {
                    return false;
                }
                mo1364g--;
                mo1364g2--;
            }
            return true;
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(AbstractC3054b abstractC3054b) {
        int mo1366f = mo1366f() + Math.min(mo1357l(), abstractC3054b.mo1357l());
        int mo1366f2 = mo1366f();
        int mo1366f3 = abstractC3054b.mo1366f();
        while (mo1366f2 < mo1366f) {
            byte mo1365f = mo1365f(mo1366f2);
            byte mo1365f2 = abstractC3054b.mo1365f(mo1366f3);
            if (mo1365f != mo1365f2) {
                return mo1365f < mo1365f2 ? -1 : 1;
            }
            mo1366f2++;
            mo1366f3++;
        }
        return mo1357l() - abstractC3054b.mo1357l();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (m1395a()) {
            sb.append("DirectBuffer");
        } else {
            sb.append("HeapBuffer");
        }
        sb.append("[pos=");
        sb.append(mo1366f());
        sb.append(" lim=");
        sb.append(mo1364g());
        sb.append(" cap=");
        sb.append(mo1376b());
        sb.append(": ");
        sb.append(m1386g(16));
        sb.append(IniEditor.Section.HEADER_END);
        return sb.toString();
    }

    @Override // org.apache.mina.core.p129a.AbstractC3054b
    /* renamed from: a */
    public AbstractC3054b mo1377a(byte[] bArr) {
        return m1390a(bArr, 0, bArr.length);
    }

    @Override // org.apache.mina.core.p129a.AbstractC3054b
    /* renamed from: b */
    public AbstractC3054b mo1373b(AbstractC3054b abstractC3054b) {
        return mo1374b(abstractC3054b.mo1344t());
    }

    @Override // org.apache.mina.core.p129a.AbstractC3054b
    /* renamed from: q */
    public String mo1353q() {
        return m1386g(Integer.MAX_VALUE);
    }

    /* renamed from: g */
    public String m1386g(int i) {
        return IoBufferHexDumper.m1351a(this, i);
    }

    @Override // org.apache.mina.core.p129a.AbstractC3054b
    /* renamed from: a */
    public String mo1380a(CharsetDecoder charsetDecoder) throws CharacterCodingException {
        int i;
        int i2;
        CoderResult flush;
        if (!mo1356m()) {
            return "";
        }
        boolean startsWith = charsetDecoder.charset().name().startsWith("UTF-16");
        int mo1366f = mo1366f();
        int mo1364g = mo1364g();
        if (startsWith) {
            int i3 = mo1366f;
            while (true) {
                boolean z = mo1365f(i3) == 0;
                i3++;
                if (i3 >= mo1364g) {
                    break;
                } else if (mo1365f(i3) != 0) {
                    i3++;
                    if (i3 >= mo1364g) {
                        break;
                    }
                } else if (z) {
                    i = i3 - 1;
                    break;
                }
            }
            i = -1;
            if (i < 0) {
                i = ((mo1364g - mo1366f) & (-2)) + mo1366f;
                i2 = i;
            } else {
                int i4 = i + 2;
                i2 = i4 <= mo1364g ? i4 : i;
            }
        } else {
            i = m1394a((byte) 0);
            if (i < 0) {
                i = mo1364g;
                i2 = i;
            } else {
                i2 = i + 1;
            }
        }
        if (mo1366f == i) {
            mo1369d(i2);
            return "";
        }
        mo1367e(i);
        charsetDecoder.reset();
        int mo1357l = ((int) (mo1357l() * charsetDecoder.averageCharsPerByte())) + 1;
        CharBuffer allocate = CharBuffer.allocate(mo1357l);
        while (true) {
            if (mo1356m()) {
                flush = charsetDecoder.decode(mo1344t(), allocate, true);
            } else {
                flush = charsetDecoder.flush(allocate);
            }
            if (!flush.isUnderflow()) {
                if (flush.isOverflow()) {
                    CharBuffer allocate2 = CharBuffer.allocate(allocate.capacity() + mo1357l);
                    allocate.flip();
                    allocate2.put(allocate);
                    allocate = allocate2;
                } else if (flush.isError()) {
                    mo1367e(mo1364g);
                    mo1369d(mo1366f);
                    flush.throwException();
                }
            } else {
                mo1367e(mo1364g);
                mo1369d(i2);
                return allocate.flip().toString();
            }
        }
    }

    @Override // org.apache.mina.core.p129a.AbstractC3054b
    /* renamed from: a */
    public AbstractC3054b mo1381a(CharSequence charSequence, CharsetEncoder charsetEncoder) throws CharacterCodingException {
        CoderResult flush;
        if (charSequence.length() == 0) {
            return this;
        }
        CharBuffer wrap = CharBuffer.wrap(charSequence);
        charsetEncoder.reset();
        int i = 0;
        while (true) {
            if (wrap.hasRemaining()) {
                flush = charsetEncoder.encode(wrap, mo1344t(), true);
            } else {
                flush = charsetEncoder.flush(mo1344t());
            }
            if (flush.isUnderflow()) {
                return this;
            }
            if (!flush.isOverflow()) {
                i = 0;
            } else if (m1388c()) {
                switch (i) {
                    case 0:
                        m1385j((int) Math.ceil(wrap.remaining() * charsetEncoder.averageBytesPerChar()));
                        i++;
                        continue;
                    case 1:
                        m1385j((int) Math.ceil(wrap.remaining() * charsetEncoder.maxBytesPerChar()));
                        i++;
                        continue;
                    default:
                        throw new RuntimeException("Expanded by " + ((int) Math.ceil(wrap.remaining() * charsetEncoder.maxBytesPerChar())) + " but that wasn't enough for '" + ((Object) charSequence) + "'");
                }
            }
            flush.throwException();
        }
    }

    /* renamed from: a */
    public int m1394a(byte b) {
        if (mo1343u()) {
            int w = mo1341w();
            int mo1364g = mo1364g() + w;
            byte[] v = mo1342v();
            for (int mo1366f = mo1366f() + w; mo1366f < mo1364g; mo1366f++) {
                if (v[mo1366f] == b) {
                    return mo1366f - w;
                }
            }
            return -1;
        }
        int mo1364g2 = mo1364g();
        for (int mo1366f2 = mo1366f(); mo1366f2 < mo1364g2; mo1366f2++) {
            if (mo1365f(mo1366f2) == b) {
                return mo1366f2;
            }
        }
        return -1;
    }

    /* renamed from: j */
    private AbstractC3054b m1385j(int i) {
        if (m1388c()) {
            m1389b(i, true);
        }
        return this;
    }

    /* renamed from: a */
    private AbstractC3054b m1393a(int i, int i2) {
        if (m1388c()) {
            m1392a(i, i2, true);
        }
        return this;
    }
}
