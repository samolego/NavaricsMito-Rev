package org.opencv.core;

/* loaded from: classes2.dex */
public class Core {

    /* renamed from: a */
    public static final String f12493a = m297d();

    /* renamed from: b */
    public static final String f12494b = m296e();

    /* renamed from: c */
    public static final int f12495c = m295f();

    /* renamed from: d */
    public static final int f12496d = m294g();

    /* renamed from: e */
    public static final int f12497e = m293h();

    /* renamed from: f */
    public static final String f12498f = m292i();

    /* renamed from: d */
    private static String m297d() {
        return "3.3.0";
    }

    /* renamed from: e */
    private static String m296e() {
        return "opencv_java330";
    }

    /* renamed from: f */
    private static int m295f() {
        return 3;
    }

    private static native void flip_0(long j, long j2, int i);

    /* renamed from: g */
    private static int m294g() {
        return 3;
    }

    private static native String getBuildInformation_0();

    private static native long getTickCount_0();

    private static native double getTickFrequency_0();

    /* renamed from: h */
    private static int m293h() {
        return 0;
    }

    /* renamed from: i */
    private static String m292i() {
        return "";
    }

    private static native void rotate_0(long j, long j2, int i);

    /* renamed from: a */
    public static String m302a() {
        return getBuildInformation_0();
    }

    /* renamed from: b */
    public static double m300b() {
        return getTickFrequency_0();
    }

    /* renamed from: c */
    public static long m298c() {
        return getTickCount_0();
    }

    /* renamed from: a */
    public static void m301a(Mat mat, Mat mat2, int i) {
        flip_0(mat.f12499a, mat2.f12499a, i);
    }

    /* renamed from: b */
    public static void m299b(Mat mat, Mat mat2, int i) {
        rotate_0(mat.f12499a, mat2.f12499a, i);
    }
}
