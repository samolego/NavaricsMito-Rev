package org.opencv.core;

import org.slf4j.Marker;

/* loaded from: classes2.dex */
public class Mat {

    /* renamed from: a */
    public final long f12499a;

    private static native int nPutB(long j, int i, int i2, int i3, byte[] bArr);

    private static native long n_Mat();

    private static native long n_Mat(int i, int i2, int i3);

    private static native long n_clone(long j);

    private static native int n_cols(long j);

    private static native long n_dataAddr(long j);

    private static native void n_delete(long j);

    private static native boolean n_empty(long j);

    private static native boolean n_isContinuous(long j);

    private static native boolean n_isSubmatrix(long j);

    private static native void n_release(long j);

    private static native int n_rows(long j);

    private static native long n_submat_rr(long j, int i, int i2, int i3, int i4);

    private static native int n_type(long j);

    public Mat(long j) {
        if (j == 0) {
            throw new UnsupportedOperationException("Native object address is NULL");
        }
        this.f12499a = j;
    }

    public Mat() {
        this.f12499a = n_Mat();
    }

    public Mat(int i, int i2, int i3) {
        this.f12499a = n_Mat(i, i2, i3);
    }

    /* renamed from: a */
    public Mat clone() {
        return new Mat(n_clone(this.f12499a));
    }

    /* renamed from: b */
    public int m288b() {
        return n_cols(this.f12499a);
    }

    /* renamed from: c */
    public long m287c() {
        return n_dataAddr(this.f12499a);
    }

    /* renamed from: d */
    public boolean m286d() {
        return n_empty(this.f12499a);
    }

    /* renamed from: e */
    public boolean m285e() {
        return n_isContinuous(this.f12499a);
    }

    /* renamed from: f */
    public boolean m284f() {
        return n_isSubmatrix(this.f12499a);
    }

    /* renamed from: g */
    public void m283g() {
        n_release(this.f12499a);
    }

    /* renamed from: h */
    public int m282h() {
        return n_rows(this.f12499a);
    }

    /* renamed from: a */
    public Mat m290a(int i, int i2, int i3, int i4) {
        return new Mat(n_submat_rr(this.f12499a, i, i2, i3, i4));
    }

    /* renamed from: i */
    public int m281i() {
        return n_type(this.f12499a);
    }

    protected void finalize() throws Throwable {
        n_delete(this.f12499a);
        super.finalize();
    }

    public String toString() {
        return "Mat [ " + m282h() + Marker.ANY_MARKER + m288b() + Marker.ANY_MARKER + CvType.m269j(m281i()) + ", isCont=" + m285e() + ", isSubmat=" + m284f() + ", nativeObj=0x" + Long.toHexString(this.f12499a) + ", dataAddr=0x" + Long.toHexString(m287c()) + " ]";
    }

    /* renamed from: a */
    public int m289a(int i, int i2, byte[] bArr) {
        int m281i = m281i();
        if (bArr == null || bArr.length % CvType.m271h(m281i) != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Provided data element number (");
            sb.append(bArr == null ? 0 : bArr.length);
            sb.append(") should be multiple of the Mat channels count (");
            sb.append(CvType.m271h(m281i));
            sb.append(")");
            throw new UnsupportedOperationException(sb.toString());
        } else if (CvType.m270i(m281i) == 0 || CvType.m270i(m281i) == 1) {
            return nPutB(this.f12499a, i, i2, bArr.length, bArr);
        } else {
            throw new UnsupportedOperationException("Mat data type is not compatible: " + m281i);
        }
    }

    /* renamed from: j */
    public long m280j() {
        return this.f12499a;
    }
}
