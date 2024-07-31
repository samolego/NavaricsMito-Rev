package com.navatics.app.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.apache.log4j.C3044k;
import org.opencv.core.Core;
import org.opencv.core.Mat;

/* renamed from: com.navatics.app.utils.g */
/* loaded from: classes.dex */
public class ImageUtils {

    /* renamed from: a */
    private static final C3044k f5128a = C3044k.m1564a(ImageUtils.class);

    /* renamed from: a */
    public static void m7389a(Mat mat, Mat mat2) {
        Core.m299b(mat, mat2, 0);
    }

    /* renamed from: a */
    public static String m7392a(Context context, Bitmap bitmap, String str, String str2) {
        File file = new File(str);
        if (!file.exists() ? file.mkdirs() : true) {
            File file2 = new File(file, str2);
            String absolutePath = file2.getAbsolutePath();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.close();
                m7391a(context, absolutePath);
                return absolutePath;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static String m7390a(String str) {
        File file = new File(str);
        String format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis()));
        int i = 0;
        while (true) {
            String str2 = format + String.format(Locale.getDefault(), "_%02d.png", Integer.valueOf(i));
            if (!new File(file, str2).exists()) {
                return str2;
            }
            i++;
        }
    }

    /* renamed from: a */
    private static void m7391a(Context context, String str) {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(new File(str)));
        context.sendBroadcast(intent);
    }
}
