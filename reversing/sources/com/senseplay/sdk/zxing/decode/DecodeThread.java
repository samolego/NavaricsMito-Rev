package com.senseplay.sdk.zxing.decode;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.senseplay.sdk.zxing.CaptureActivity;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class DecodeThread extends Thread {
    public static final String BARCODE_BITMAP = "barcode_bitmap";
    public static final String BARCODE_SCALED_FACTOR = "barcode_scaled_factor";
    private final CaptureActivity activity;
    private Handler handler;
    private final CountDownLatch handlerInitLatch = new CountDownLatch(1);
    private final Map<DecodeHintType, Object> hints = new EnumMap(DecodeHintType.class);

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecodeThread(CaptureActivity captureActivity, Collection<BarcodeFormat> collection, String str) {
        this.activity = captureActivity;
        if (collection == null || collection.isEmpty()) {
            collection = EnumSet.noneOf(BarcodeFormat.class);
            collection.addAll(DecodeFormatManager.PRODUCT_FORMATS);
            collection.addAll(DecodeFormatManager.INDUSTRIAL_FORMATS);
            collection.addAll(DecodeFormatManager.QR_CODE_FORMATS);
            collection.addAll(DecodeFormatManager.DATA_MATRIX_FORMATS);
            collection.addAll(DecodeFormatManager.AZTEC_FORMATS);
            collection.addAll(DecodeFormatManager.PDF417_FORMATS);
        }
        this.hints.put(DecodeHintType.POSSIBLE_FORMATS, collection);
        if (str != null) {
            this.hints.put(DecodeHintType.CHARACTER_SET, str);
        }
        Log.i("DecodeThread", "Hints: " + this.hints);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler getHandler() {
        try {
            this.handlerInitLatch.await();
        } catch (InterruptedException unused) {
        }
        return this.handler;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.handler = new DecodeHandler(this.activity, this.hints);
        this.handlerInitLatch.countDown();
        Looper.loop();
    }
}
