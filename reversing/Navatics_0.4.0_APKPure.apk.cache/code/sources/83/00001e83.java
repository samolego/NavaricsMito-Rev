package com.senseplay.sdk.video;

import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.Image;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.util.Log;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes2.dex */
public class VideoToImage {
    private static final int COLOR_FormatI420 = 1;
    private static final int COLOR_FormatNV21 = 2;
    private static final String TAG = "VideoToImage";
    private static final boolean VERBOSE = true;
    public static boolean isSaveImage = false;

    public static String getPath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/image_" + new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + ".jpg";
    }

    @RequiresApi(api = 21)
    public static void scompressToJpeg(String str, Image image) {
        if (image == null) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            Rect cropRect = image.getCropRect();
            new YuvImage(getDataFromImage(image, 2), 17, cropRect.width(), cropRect.height(), null).compressToJpeg(cropRect, 100, fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static boolean isImageFormatSupported(Image image) {
        int format = image.getFormat();
        return format == 17 || format == 35 || format == 842094169;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0062. Please report as an issue. */
    @RequiresApi(api = 21)
    private static byte[] getDataFromImage(Image image, int i) {
        int i2;
        int i3 = i;
        int i4 = 2;
        int i5 = 1;
        if (i3 != 1 && i3 != 2) {
            throw new IllegalArgumentException("only support COLOR_FormatI420 and COLOR_FormatNV21");
        }
        if (!isImageFormatSupported(image)) {
            throw new RuntimeException("can't convert Image to byte array, format " + image.getFormat());
        }
        Rect cropRect = image.getCropRect();
        int format = image.getFormat();
        int width = cropRect.width();
        int height = cropRect.height();
        Image.Plane[] planes = image.getPlanes();
        int i6 = width * height;
        byte[] bArr = new byte[(ImageFormat.getBitsPerPixel(format) * i6) / 8];
        byte[] bArr2 = new byte[planes[0].getRowStride()];
        Log.v(TAG, "get data from " + planes.length + " planes");
        int i7 = 0;
        int i8 = 0;
        int i9 = 1;
        while (i7 < planes.length) {
            switch (i7) {
                case 0:
                    i8 = 0;
                    i9 = 1;
                    break;
                case 1:
                    if (i3 == i5) {
                        i8 = i6;
                        i9 = 1;
                        break;
                    } else if (i3 == i4) {
                        i8 = i6 + 1;
                        i9 = 2;
                        break;
                    }
                    break;
                case 2:
                    if (i3 == i5) {
                        i8 = (int) (i6 * 1.25d);
                        i9 = 1;
                        break;
                    } else if (i3 == i4) {
                        i8 = i6;
                        i9 = 2;
                        break;
                    }
                    break;
            }
            ByteBuffer buffer = planes[i7].getBuffer();
            int rowStride = planes[i7].getRowStride();
            int pixelStride = planes[i7].getPixelStride();
            Log.v(TAG, "pixelStride " + pixelStride);
            Log.v(TAG, "rowStride " + rowStride);
            Log.v(TAG, "width " + width);
            Log.v(TAG, "height " + height);
            Log.v(TAG, "buffer size " + buffer.remaining());
            int i10 = i7 == 0 ? 0 : 1;
            int i11 = width >> i10;
            int i12 = height >> i10;
            int i13 = width;
            int i14 = height;
            buffer.position(((cropRect.top >> i10) * rowStride) + ((cropRect.left >> i10) * pixelStride));
            for (int i15 = 0; i15 < i12; i15++) {
                if (pixelStride == 1 && i9 == 1) {
                    buffer.get(bArr, i8, i11);
                    i8 += i11;
                    i2 = i11;
                } else {
                    i2 = ((i11 - 1) * pixelStride) + 1;
                    buffer.get(bArr2, 0, i2);
                    int i16 = i8;
                    for (int i17 = 0; i17 < i11; i17++) {
                        bArr[i16] = bArr2[i17 * pixelStride];
                        i16 += i9;
                    }
                    i8 = i16;
                }
                if (i15 < i12 - 1) {
                    buffer.position((buffer.position() + rowStride) - i2);
                }
            }
            Log.v(TAG, "Finished reading data from plane " + i7);
            i7++;
            width = i13;
            height = i14;
            i3 = i;
            i4 = 2;
            i5 = 1;
        }
        return bArr;
    }
}