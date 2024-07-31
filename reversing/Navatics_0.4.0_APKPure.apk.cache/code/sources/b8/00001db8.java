package com.senseplay.sdk.log;

import android.content.Context;
import android.widget.Toast;
import com.senseplay.sdk.config.SPConfig;

/* loaded from: classes2.dex */
public class SPToast {
    private static final boolean isDebug = SPConfig.isDebug();

    public static void shortShow(Context context, String str) {
        Toast.makeText(context, str, 0).show();
    }

    public static void shortShowDebug(Context context, String str) {
        if (isDebug) {
            Toast.makeText(context, str, 0).show();
        }
    }

    public static void longShowDebug(Context context, String str) {
        if (isDebug) {
            Toast.makeText(context, str, 1).show();
        }
    }
}