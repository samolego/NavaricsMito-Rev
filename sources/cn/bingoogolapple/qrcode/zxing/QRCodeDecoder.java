package cn.bingoogolapple.qrcode.zxing;

import android.graphics.Bitmap;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.common.GlobalHistogramBinarizer;
import com.google.zxing.common.HybridBinarizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

/* renamed from: cn.bingoogolapple.qrcode.zxing.a */
/* loaded from: classes.dex */
public class QRCodeDecoder {

    /* renamed from: a */
    static final Map<DecodeHintType, Object> f259a = new EnumMap(DecodeHintType.class);

    /* renamed from: b */
    static final Map<DecodeHintType, Object> f260b;

    /* renamed from: c */
    static final Map<DecodeHintType, Object> f261c;

    /* renamed from: d */
    static final Map<DecodeHintType, Object> f262d;

    /* renamed from: e */
    static final Map<DecodeHintType, Object> f263e;

    /* renamed from: f */
    static final Map<DecodeHintType, Object> f264f;

    /* renamed from: g */
    static final Map<DecodeHintType, Object> f265g;

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add(BarcodeFormat.AZTEC);
        arrayList.add(BarcodeFormat.CODABAR);
        arrayList.add(BarcodeFormat.CODE_39);
        arrayList.add(BarcodeFormat.CODE_93);
        arrayList.add(BarcodeFormat.CODE_128);
        arrayList.add(BarcodeFormat.DATA_MATRIX);
        arrayList.add(BarcodeFormat.EAN_8);
        arrayList.add(BarcodeFormat.EAN_13);
        arrayList.add(BarcodeFormat.ITF);
        arrayList.add(BarcodeFormat.MAXICODE);
        arrayList.add(BarcodeFormat.PDF_417);
        arrayList.add(BarcodeFormat.QR_CODE);
        arrayList.add(BarcodeFormat.RSS_14);
        arrayList.add(BarcodeFormat.RSS_EXPANDED);
        arrayList.add(BarcodeFormat.UPC_A);
        arrayList.add(BarcodeFormat.UPC_E);
        arrayList.add(BarcodeFormat.UPC_EAN_EXTENSION);
        f259a.put(DecodeHintType.POSSIBLE_FORMATS, arrayList);
        f259a.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        f259a.put(DecodeHintType.CHARACTER_SET, "utf-8");
        f260b = new EnumMap(DecodeHintType.class);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(BarcodeFormat.CODABAR);
        arrayList2.add(BarcodeFormat.CODE_39);
        arrayList2.add(BarcodeFormat.CODE_93);
        arrayList2.add(BarcodeFormat.CODE_128);
        arrayList2.add(BarcodeFormat.EAN_8);
        arrayList2.add(BarcodeFormat.EAN_13);
        arrayList2.add(BarcodeFormat.ITF);
        arrayList2.add(BarcodeFormat.PDF_417);
        arrayList2.add(BarcodeFormat.RSS_14);
        arrayList2.add(BarcodeFormat.RSS_EXPANDED);
        arrayList2.add(BarcodeFormat.UPC_A);
        arrayList2.add(BarcodeFormat.UPC_E);
        arrayList2.add(BarcodeFormat.UPC_EAN_EXTENSION);
        f260b.put(DecodeHintType.POSSIBLE_FORMATS, arrayList2);
        f260b.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        f260b.put(DecodeHintType.CHARACTER_SET, "utf-8");
        f261c = new EnumMap(DecodeHintType.class);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(BarcodeFormat.AZTEC);
        arrayList3.add(BarcodeFormat.DATA_MATRIX);
        arrayList3.add(BarcodeFormat.MAXICODE);
        arrayList3.add(BarcodeFormat.QR_CODE);
        f261c.put(DecodeHintType.POSSIBLE_FORMATS, arrayList3);
        f261c.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        f261c.put(DecodeHintType.CHARACTER_SET, "utf-8");
        f262d = new EnumMap(DecodeHintType.class);
        f262d.put(DecodeHintType.POSSIBLE_FORMATS, Collections.singletonList(BarcodeFormat.QR_CODE));
        f262d.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        f262d.put(DecodeHintType.CHARACTER_SET, "utf-8");
        f263e = new EnumMap(DecodeHintType.class);
        f263e.put(DecodeHintType.POSSIBLE_FORMATS, Collections.singletonList(BarcodeFormat.CODE_128));
        f263e.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        f263e.put(DecodeHintType.CHARACTER_SET, "utf-8");
        f264f = new EnumMap(DecodeHintType.class);
        f264f.put(DecodeHintType.POSSIBLE_FORMATS, Collections.singletonList(BarcodeFormat.EAN_13));
        f264f.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        f264f.put(DecodeHintType.CHARACTER_SET, "utf-8");
        f265g = new EnumMap(DecodeHintType.class);
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(BarcodeFormat.QR_CODE);
        arrayList4.add(BarcodeFormat.UPC_A);
        arrayList4.add(BarcodeFormat.EAN_13);
        arrayList4.add(BarcodeFormat.CODE_128);
        f265g.put(DecodeHintType.POSSIBLE_FORMATS, arrayList4);
        f265g.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        f265g.put(DecodeHintType.CHARACTER_SET, "utf-8");
    }

    /* renamed from: a */
    public static String m12691a(Bitmap bitmap) {
        RGBLuminanceSource rGBLuminanceSource;
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            rGBLuminanceSource = new RGBLuminanceSource(width, height, iArr);
            try {
                return new MultiFormatReader().decode(new BinaryBitmap(new HybridBinarizer(rGBLuminanceSource)), f259a).getText();
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                if (rGBLuminanceSource != null) {
                    try {
                        return new MultiFormatReader().decode(new BinaryBitmap(new GlobalHistogramBinarizer(rGBLuminanceSource)), f259a).getText();
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        } catch (Exception e2) {
            e = e2;
            rGBLuminanceSource = null;
        }
    }
}
