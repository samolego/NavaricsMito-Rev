package org.opencv.android;

import android.content.Context;
import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

/* loaded from: classes2.dex */
public class Utils {
    private static native void nBitmapToMat2(Bitmap bitmap, long j, boolean z);

    private static native void nMatToBitmap2(long j, Bitmap bitmap, boolean z);

    /* renamed from: a */
    public static Mat m345a(Context context, int i) throws IOException {
        return m344a(context, i, -1);
    }

    /* renamed from: a */
    public static Mat m344a(Context context, int i, int i2) throws IOException {
        InputStream openRawResource = context.getResources().openRawResource(i);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(openRawResource.available());
        byte[] bArr = new byte[4096];
        while (true) {
            int read = openRawResource.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                openRawResource.close();
                Mat mat = new Mat(1, byteArrayOutputStream.size(), 0);
                mat.m289a(0, 0, byteArrayOutputStream.toByteArray());
                byteArrayOutputStream.close();
                Mat m267a = Imgcodecs.m267a(mat, i2);
                mat.m283g();
                return m267a;
            }
        }
    }

    /* renamed from: a */
    public static void m342a(Bitmap bitmap, Mat mat, boolean z) {
        if (bitmap == null) {
            throw new IllegalArgumentException("bmp == null");
        }
        if (mat == null) {
            throw new IllegalArgumentException("mat == null");
        }
        nBitmapToMat2(bitmap, mat.f12499a, z);
    }

    /* renamed from: a */
    public static void m343a(Bitmap bitmap, Mat mat) {
        m342a(bitmap, mat, false);
    }

    /* renamed from: a */
    public static void m340a(Mat mat, Bitmap bitmap, boolean z) {
        if (mat == null) {
            throw new IllegalArgumentException("mat == null");
        }
        if (bitmap == null) {
            throw new IllegalArgumentException("bmp == null");
        }
        nMatToBitmap2(mat.f12499a, bitmap, z);
    }

    /* renamed from: a */
    public static void m341a(Mat mat, Bitmap bitmap) {
        m340a(mat, bitmap, false);
    }
}
