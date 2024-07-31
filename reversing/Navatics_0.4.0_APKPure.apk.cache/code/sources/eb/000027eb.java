package org.opencv.core;

/* loaded from: classes2.dex */
public class Core {

    /* renamed from: a */
    public static final String f12534a = m12514d();

    /* renamed from: b */
    public static final String f12535b = m12515e();

    /* renamed from: c */
    public static final int f12536c = m12516f();

    /* renamed from: d */
    public static final int f12537d = m12517g();

    /* renamed from: e */
    public static final int f12538e = m12518h();

    /* renamed from: f */
    public static final String f12539f = m12519i();

    /* renamed from: d */
    private static String m12514d() {
        return "3.3.0";
    }

    /* renamed from: e */
    private static String m12515e() {
        return "opencv_java330";
    }

    /* renamed from: f */
    private static int m12516f() {
        return 3;
    }

    private static native void flip_0(long j, long j2, int i);

    /* renamed from: g */
    private static int m12517g() {
        return 3;
    }

    private static native String getBuildInformation_0();

    private static native long getTickCount_0();

    private static native double getTickFrequency_0();

    /* renamed from: h */
    private static int m12518h() {
        return 0;
    }

    /* renamed from: i */
    private static String m12519i() {
        return "";
    }

    private static native void rotate_0(long j, long j2, int i);

    /* renamed from: a */
    public static String m12509a() {
        return getBuildInformation_0();
    }

    /* renamed from: b */
    public static double m12511b() {
        return getTickFrequency_0();
    }

    /* renamed from: c */
    public static long m12513c() {
        return getTickCount_0();
    }

    /* renamed from: a */
    public static void m12510a(Mat mat, Mat mat2, int i) {
        flip_0(mat.f12540a, mat2.f12540a, i);
    }

    /* renamed from: b */
    public static void m12512b(Mat mat, Mat mat2, int i) {
        rotate_0(mat.f12540a, mat2.f12540a, i);
    }
}