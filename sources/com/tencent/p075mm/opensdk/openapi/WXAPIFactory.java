package com.tencent.p075mm.opensdk.openapi;

import android.content.Context;
import com.tencent.p075mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.openapi.WXAPIFactory */
/* loaded from: classes2.dex */
public class WXAPIFactory {
    private static final String TAG = "MicroMsg.PaySdk.WXFactory";

    private WXAPIFactory() {
        throw new RuntimeException(getClass().getSimpleName() + " should not be instantiated");
    }

    public static IWXAPI createWXAPI(Context context, String str) {
        return createWXAPI(context, str, true);
    }

    public static IWXAPI createWXAPI(Context context, String str, boolean z) {
        Log.m5001d(TAG, "createWXAPI, appId = " + str + ", checkSignature = " + z);
        return new WXApiImplV10(context, str, z);
    }
}
