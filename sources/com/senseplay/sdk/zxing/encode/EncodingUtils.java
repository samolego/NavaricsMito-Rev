package com.senseplay.sdk.zxing.encode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.p008v4.view.ViewCompat;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.EnumMap;

/* loaded from: classes2.dex */
public class EncodingUtils {
    public static Bitmap createQRCode(String str, int i, int i2, Bitmap bitmap) {
        EnumMap enumMap;
        if (str != null) {
            try {
                if (!"".equals(str)) {
                    String guessAppropriateEncoding = guessAppropriateEncoding(str);
                    if (guessAppropriateEncoding != null) {
                        EnumMap enumMap2 = new EnumMap(EncodeHintType.class);
                        enumMap2.put((EnumMap) EncodeHintType.CHARACTER_SET, (EncodeHintType) guessAppropriateEncoding);
                        enumMap = enumMap2;
                    } else {
                        enumMap = null;
                    }
                    try {
                        BitMatrix encode = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, i, i2, enumMap);
                        int width = encode.getWidth();
                        int height = encode.getHeight();
                        int[] iArr = new int[width * height];
                        for (int i3 = 0; i3 < height; i3++) {
                            int i4 = i3 * width;
                            for (int i5 = 0; i5 < width; i5++) {
                                iArr[i4 + i5] = encode.get(i5, i3) ? ViewCompat.MEASURED_STATE_MASK : -1;
                            }
                        }
                        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
                        return bitmap != null ? addLogo(createBitmap, bitmap) : createBitmap;
                    } catch (IllegalArgumentException unused) {
                        return null;
                    }
                }
            } catch (WriterException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private static String guessAppropriateEncoding(CharSequence charSequence) {
        for (int i = 0; i < charSequence.length(); i++) {
            if (charSequence.charAt(i) > 255) {
                return "UTF-8";
            }
        }
        return null;
    }

    private static Bitmap addLogo(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap2 == null) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = bitmap2.getWidth();
        int height2 = bitmap2.getHeight();
        if (width == 0 || height == 0) {
            return null;
        }
        if (width2 == 0 || height2 == 0) {
            return bitmap;
        }
        float f = ((width * 1.0f) / 5.0f) / width2;
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            canvas.scale(f, f, width / 2, height / 2);
            canvas.drawBitmap(bitmap2, (width - width2) / 2, (height - height2) / 2, (Paint) null);
            canvas.save(31);
            canvas.restore();
            return createBitmap;
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }

    public static Bitmap creatBarcode(String str, int i, int i2) {
        return encodeAsBitmap(str, BarcodeFormat.CODE_128, i, i2);
    }

    protected static Bitmap encodeAsBitmap(String str, BarcodeFormat barcodeFormat, int i, int i2) {
        BitMatrix bitMatrix;
        try {
            bitMatrix = new MultiFormatWriter().encode(str, barcodeFormat, i, i2, null);
        } catch (WriterException e) {
            e.printStackTrace();
            bitMatrix = null;
        }
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        int[] iArr = new int[width * height];
        for (int i3 = 0; i3 < height; i3++) {
            int i4 = i3 * width;
            for (int i5 = 0; i5 < width; i5++) {
                iArr[i4 + i5] = bitMatrix.get(i5, i3) ? ViewCompat.MEASURED_STATE_MASK : -1;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return createBitmap;
    }
}
