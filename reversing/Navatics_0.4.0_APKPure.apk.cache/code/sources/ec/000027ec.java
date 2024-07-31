package org.opencv.core;

import org.slf4j.Marker;

/* loaded from: classes2.dex */
public class Mat {

    /* renamed from: a */
    public final long f12540a;

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
        this.f12540a = j;
    }

    public Mat() {
        this.f12540a = n_Mat();
    }

    public Mat(int i, int i2, int i3) {
        this.f12540a = n_Mat(i, i2, i3);
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Mat clone() {
        return new Mat(n_clone(this.f12540a));
    }

    /* renamed from: b */
    public int m12523b() {
        return n_cols(this.f12540a);
    }

    /* renamed from: c */
    public long m12524c() {
        return n_dataAddr(this.f12540a);
    }

    /* renamed from: d */
    public boolean m12525d() {
        return n_empty(this.f12540a);
    }

    /* renamed from: e */
    public boolean m12526e() {
        return n_isContinuous(this.f12540a);
    }

    /* renamed from: f */
    public boolean m12527f() {
        return n_isSubmatrix(this.f12540a);
    }

    /* renamed from: g */
    public void m12528g() {
        n_release(this.f12540a);
    }

    /* renamed from: h */
    public int m12529h() {
        return n_rows(this.f12540a);
    }

    /* renamed from: a */
    public Mat m12522a(int i, int i2, int i3, int i4) {
        return new Mat(n_submat_rr(this.f12540a, i, i2, i3, i4));
    }

    /* renamed from: i */
    public int m12530i() {
        return n_type(this.f12540a);
    }

    protected void finalize() throws Throwable {
        n_delete(this.f12540a);
        super.finalize();
    }

    public String toString() {
        return "Mat [ " + m12529h() + Marker.ANY_MARKER + m12523b() + Marker.ANY_MARKER + CvType.m12542j(m12530i()) + ", isCont=" + m12526e() + ", isSubmat=" + m12527f() + ", nativeObj=0x" + Long.toHexString(this.f12540a) + ", dataAddr=0x" + Long.toHexString(m12524c()) + " ]";
    }

    /* renamed from: a */
    public int m12520a(int i, int i2, byte[] bArr) {
        int m12530i = m12530i();
        if (bArr == null || bArr.length % CvType.m12540h(m12530i) != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Provided data element number (");
            sb.append(bArr == null ? 0 : bArr.length);
            sb.append(") should be multiple of the Mat channels count (");
            sb.append(CvType.m12540h(m12530i));
            sb.append(")");
            throw new UnsupportedOperationException(sb.toString());
        }
        if (CvType.m12541i(m12530i) == 0 || CvType.m12541i(m12530i) == 1) {
            return nPutB(this.f12540a, i, i2, bArr.length, bArr);
        }
        throw new UnsupportedOperationException("Mat data type is not compatible: " + m12530i);
    }

    /* renamed from: j */
    public long m12531j() {
        return this.f12540a;
    }
}