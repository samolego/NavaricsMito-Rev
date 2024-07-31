package com.senseplay.sdk.tool;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import com.senseplay.sdk.log.SPDebug;
import java.io.File;

/* loaded from: classes2.dex */
public class StorageTool {
    public static String getDcimPath() {
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath();
    }

    public static String getPicturePath() {
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath();
    }

    public static String getStoragePath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public static void refreshPicture(Activity activity, String str) {
        if (activity == null) {
            SPDebug.m7041w("refreshPicture", "activity is null");
            return;
        }
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        File file = new File(str);
        if (!file.exists()) {
            SPDebug.m7041w("refreshPicture", "file not exit");
        } else {
            intent.setData(Uri.fromFile(file));
            activity.sendBroadcast(intent);
        }
    }
}