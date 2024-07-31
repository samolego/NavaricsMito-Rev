package com.senseplay.sdk.zxing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.senseplay.sdk.zxing.encode.EncodingUtils;

/* loaded from: classes2.dex */
public class SPZxing {
    private static final String TAG = "SPZxing";
    public static SPZxingCallBack callBack;
    private static SPZxing spZxing;
    private Activity activity;
    private Context mContext;

    public static SPZxing getInstance(Context context) {
        if (spZxing == null) {
            synchronized (SPZxing.class) {
                if (spZxing == null) {
                    spZxing = new SPZxing(context);
                }
            }
        }
        return spZxing;
    }

    private SPZxing(Context context) {
        this.mContext = context;
    }

    public void scanCode(SPZxingCallBack sPZxingCallBack) {
        callBack = sPZxingCallBack;
        ((Activity) this.mContext).startActivityForResult(new Intent(this.mContext, CaptureActivity.class), 0);
    }

    public Bitmap createQRBitmap(String str, int i, int i2, Bitmap bitmap) {
        return EncodingUtils.createQRCode(str, i, i2, bitmap);
    }

    public Bitmap createBarBitmap(String str, int i, int i2) {
        return EncodingUtils.creatBarcode(str, i, i2);
    }
}
