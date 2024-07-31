package org.opencv.imgproc;

import org.opencv.core.Mat;

/* loaded from: classes2.dex */
public class Imgproc {
    private static native void cvtColor_0(long j, long j2, int i, int i2);

    private static native void cvtColor_1(long j, long j2, int i);

    /* renamed from: a */
    public static void m265a(Mat mat, Mat mat2, int i, int i2) {
        cvtColor_0(mat.f12499a, mat2.f12499a, i, i2);
    }

    /* renamed from: a */
    public static void m266a(Mat mat, Mat mat2, int i) {
        cvtColor_1(mat.f12499a, mat2.f12499a, i);
    }
}
