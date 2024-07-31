package okio;

import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Segment.java */
/* renamed from: okio.n, reason: use source file name */
/* loaded from: classes2.dex */
public final class Segment {

    /* renamed from: a */
    final byte[] f10744a;

    /* renamed from: b */
    int f10745b;

    /* renamed from: c */
    int f10746c;

    /* renamed from: d */
    boolean f10747d;

    /* renamed from: e */
    boolean f10748e;

    /* renamed from: f */
    Segment f10749f;

    /* renamed from: g */
    Segment f10750g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Segment() {
        this.f10744a = new byte[8192];
        this.f10748e = true;
        this.f10747d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Segment(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f10744a = bArr;
        this.f10745b = i;
        this.f10746c = i2;
        this.f10747d = z;
        this.f10748e = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public Segment m10622a() {
        this.f10747d = true;
        return new Segment(this.f10744a, this.f10745b, this.f10746c, true, false);
    }

    @Nullable
    /* renamed from: b */
    public Segment m10626b() {
        Segment segment = this.f10749f;
        if (segment == this) {
            segment = null;
        }
        Segment segment2 = this.f10750g;
        segment2.f10749f = this.f10749f;
        this.f10749f.f10750g = segment2;
        this.f10749f = null;
        this.f10750g = null;
        return segment;
    }

    /* renamed from: a */
    public Segment m10624a(Segment segment) {
        segment.f10750g = this;
        segment.f10749f = this.f10749f;
        this.f10749f.f10750g = segment;
        this.f10749f = segment;
        return segment;
    }

    /* renamed from: a */
    public Segment m10623a(int i) {
        Segment m10628a;
        if (i <= 0 || i > this.f10746c - this.f10745b) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            m10628a = m10622a();
        } else {
            m10628a = SegmentPool.m10628a();
            System.arraycopy(this.f10744a, this.f10745b, m10628a.f10744a, 0, i);
        }
        m10628a.f10746c = m10628a.f10745b + i;
        this.f10745b += i;
        this.f10750g.m10624a(m10628a);
        return m10628a;
    }

    /* renamed from: c */
    public void m10627c() {
        Segment segment = this.f10750g;
        if (segment == this) {
            throw new IllegalStateException();
        }
        if (segment.f10748e) {
            int i = this.f10746c - this.f10745b;
            if (i > (8192 - segment.f10746c) + (segment.f10747d ? 0 : segment.f10745b)) {
                return;
            }
            m10625a(this.f10750g, i);
            m10626b();
            SegmentPool.m10629a(this);
        }
    }

    /* renamed from: a */
    public void m10625a(Segment segment, int i) {
        if (!segment.f10748e) {
            throw new IllegalArgumentException();
        }
        int i2 = segment.f10746c;
        if (i2 + i > 8192) {
            if (segment.f10747d) {
                throw new IllegalArgumentException();
            }
            int i3 = segment.f10745b;
            if ((i2 + i) - i3 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = segment.f10744a;
            System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
            segment.f10746c -= segment.f10745b;
            segment.f10745b = 0;
        }
        System.arraycopy(this.f10744a, this.f10745b, segment.f10744a, segment.f10746c, i);
        segment.f10746c += i;
        this.f10745b += i;
    }
}