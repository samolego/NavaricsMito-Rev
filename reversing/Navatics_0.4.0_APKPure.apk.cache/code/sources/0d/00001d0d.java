package com.senseplay.mframe.ota;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

/* loaded from: classes2.dex */
public class OtaFile {
    public static long downloadFile(Context context, String str, String str2, String str3) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
        request.setAllowedNetworkTypes(2);
        request.setTitle(str2);
        request.setDescription(str3);
        request.setAllowedOverRoaming(false);
        request.setNotificationVisibility(1);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, str.substring(str.lastIndexOf("/") + 1));
        return ((DownloadManager) context.getSystemService("download")).enqueue(request);
    }

    public static void install(Context context, long j) {
        DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(268435456);
        Uri uriForDownloadedFile = downloadManager.getUriForDownloadedFile(j);
        Log.d("OtaFile", "apk存储路径 : " + uriForDownloadedFile);
        intent.setDataAndType(uriForDownloadedFile, "application/vnd.android.package-archive");
        if (uriForDownloadedFile != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                intent.addFlags(1);
            }
            context.startActivity(intent);
        }
    }
}