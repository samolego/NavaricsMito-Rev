package com.senseplay.sdk.tool;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.util.Log;

/* loaded from: classes2.dex */
public class FileTool {
    public static void refreshFile(Context context, String str) {
        if (context == null) {
            Log.e("FileTool", "content is null");
        } else {
            MediaScannerConnection.scanFile(context, new String[]{str}, null, null);
        }
    }
}