package org.opencv.imgcodecs;

import org.opencv.core.Mat;

/* loaded from: classes2.dex */
public class Imgcodecs {
    private static native long imdecode_0(long j, int i);

    /* renamed from: a */
    public static Mat m12544a(Mat mat, int i) {
        return new Mat(imdecode_0(mat.f12540a, i));
    }
}