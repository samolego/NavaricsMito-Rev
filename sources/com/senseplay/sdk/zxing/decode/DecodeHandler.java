package com.senseplay.sdk.zxing.decode;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.senseplay.sdk.C2189R;
import com.senseplay.sdk.zxing.CaptureActivity;
import java.io.ByteArrayOutputStream;
import java.util.Map;

/* loaded from: classes2.dex */
final class DecodeHandler extends Handler {
    private static final String TAG = "DecodeHandler";
    private final CaptureActivity activity;
    private boolean running = true;
    private final MultiFormatReader multiFormatReader = new MultiFormatReader();

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecodeHandler(CaptureActivity captureActivity, Map<DecodeHintType, Object> map) {
        this.multiFormatReader.setHints(map);
        this.activity = captureActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message == null || !this.running) {
            return;
        }
        int i = message.what;
        if (i == C2189R.C2191id.decode) {
            decode((byte[]) message.obj, message.arg1, message.arg2);
        } else if (i == C2189R.C2191id.quit) {
            this.running = false;
            Looper.myLooper().quit();
        }
    }

    private void decode(byte[] bArr, int i, int i2) {
        Result result;
        long currentTimeMillis = System.currentTimeMillis();
        Point bestPreviewSize = this.activity.getCameraManager().getBestPreviewSize();
        byte[] rotateYUV420Degree90 = rotateYUV420Degree90(bArr, bestPreviewSize.x, bestPreviewSize.y);
        int i3 = bestPreviewSize.y;
        int i4 = bestPreviewSize.x;
        Rect cropRect = this.activity.getCropRect();
        try {
            result = this.multiFormatReader.decodeWithState(new BinaryBitmap(new HybridBinarizer(new PlanarYUVLuminanceSource(rotateYUV420Degree90, i3, i4, cropRect.left, cropRect.top, cropRect.width(), cropRect.height(), false))));
            this.multiFormatReader.reset();
        } catch (ReaderException unused) {
            this.multiFormatReader.reset();
            result = null;
        } catch (Throwable th) {
            this.multiFormatReader.reset();
            throw th;
        }
        Handler handler = this.activity.getHandler();
        if (result == null) {
            if (handler != null) {
                Message.obtain(handler, C2189R.C2191id.decode_failed).sendToTarget();
                return;
            }
            return;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        String str = TAG;
        Log.d(str, "Found barcode in " + (currentTimeMillis2 - currentTimeMillis) + " ms");
        if (handler != null) {
            Message obtain = Message.obtain(handler, C2189R.C2191id.decode_succeeded, result);
            obtain.setData(new Bundle());
            obtain.sendToTarget();
        }
    }

    private byte[] rotateYUV420Degree90(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        int i4 = (i3 * 3) / 2;
        byte[] bArr2 = new byte[i4];
        int i5 = 0;
        for (int i6 = 0; i6 < i; i6++) {
            for (int i7 = i2 - 1; i7 >= 0; i7--) {
                bArr2[i5] = bArr[(i7 * i) + i6];
                i5++;
            }
        }
        int i8 = i4 - 1;
        int i9 = i - 1;
        while (i9 > 0) {
            int i10 = i8;
            for (int i11 = 0; i11 < i2 / 2; i11++) {
                int i12 = (i11 * i) + i3;
                bArr2[i10] = bArr[i12 + i9];
                int i13 = i10 - 1;
                bArr2[i13] = bArr[i12 + (i9 - 1)];
                i10 = i13 - 1;
            }
            i9 -= 2;
            i8 = i10;
        }
        return bArr2;
    }

    private static void bundleThumbnail(PlanarYUVLuminanceSource planarYUVLuminanceSource, Bundle bundle) {
        int[] renderThumbnail = planarYUVLuminanceSource.renderThumbnail();
        int thumbnailWidth = planarYUVLuminanceSource.getThumbnailWidth();
        Bitmap createBitmap = Bitmap.createBitmap(renderThumbnail, 0, thumbnailWidth, thumbnailWidth, planarYUVLuminanceSource.getThumbnailHeight(), Bitmap.Config.ARGB_8888);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        bundle.putByteArray(DecodeThread.BARCODE_BITMAP, byteArrayOutputStream.toByteArray());
        bundle.putFloat(DecodeThread.BARCODE_SCALED_FACTOR, thumbnailWidth / planarYUVLuminanceSource.getWidth());
    }
}
