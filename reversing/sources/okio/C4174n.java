package okio;

import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: okio.n */
/* loaded from: classes2.dex */
public final class Segment {

    /* renamed from: a */
    final byte[] f10703a;

    /* renamed from: b */
    int f10704b;

    /* renamed from: c */
    int f10705c;

    /* renamed from: d */
    boolean f10706d;

    /* renamed from: e */
    boolean f10707e;

    /* renamed from: f */
    Segment f10708f;

    /* renamed from: g */
    Segment f10709g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Segment() {
        this.f10703a = new byte[8192];
        this.f10707e = true;
        this.f10706d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Segment(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f10703a = bArr;
        this.f10704b = i;
        this.f10705c = i2;
        this.f10706d = z;
        this.f10707e = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public Segment m2224a() {
        this.f10706d = true;
        return new Segment(this.f10703a, this.f10704b, this.f10705c, true, false);
    }

    @Nullable
    /* renamed from: b */
    public Segment m2220b() {
        Segment segment = this.f10708f;
        if (segment == this) {
            segment = null;
        }
        Segment segment2 = this.f10709g;
        segment2.f10708f = this.f10708f;
        this.f10708f.f10709g = segment2;
        this.f10708f = null;
        this.f10709g = null;
        return segment;
    }

    /* renamed from: a */
    public Segment m2222a(Segment segment) {
        segment.f10709g = this;
        segment.f10708f = this.f10708f;
        this.f10708f.f10709g = segment;
        this.f10708f = segment;
        return segment;
    }

    /* renamed from: a */
    public Segment m2223a(int i) {
        Segment m2218a;
        if (i <= 0 || i > this.f10705c - this.f10704b) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            m2218a = m2224a();
        } else {
            m2218a = SegmentPool.m2218a();
            System.arraycopy(this.f10703a, this.f10704b, m2218a.f10703a, 0, i);
        }
        m2218a.f10705c = m2218a.f10704b + i;
        this.f10704b += i;
        this.f10709g.m2222a(m2218a);
        return m2218a;
    }

    /* renamed from: c */
    public void m2219c() {
        Segment segment = this.f10709g;
        if (segment == this) {
            throw new IllegalStateException();
        }
        if (segment.f10707e) {
            int i = this.f10705c - this.f10704b;
            if (i > (8192 - segment.f10705c) + (segment.f10706d ? 0 : segment.f10704b)) {
                return;
            }
            m2221a(this.f10709g, i);
            m2220b();
            SegmentPool.m2217a(this);
        }
    }

    /* renamed from: a */
    public void m2221a(Segment segment, int i) {
        if (!segment.f10707e) {
            throw new IllegalArgumentException();
        }
        int i2 = segment.f10705c;
        if (i2 + i > 8192) {
            if (segment.f10706d) {
                throw new IllegalArgumentException();
            }
            int i3 = segment.f10704b;
            if ((i2 + i) - i3 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = segment.f10703a;
            System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
            segment.f10705c -= segment.f10704b;
            segment.f10704b = 0;
        }
        System.arraycopy(this.f10703a, this.f10704b, segment.f10703a, segment.f10705c, i);
        segment.f10705c += i;
        this.f10704b += i;
    }
}
