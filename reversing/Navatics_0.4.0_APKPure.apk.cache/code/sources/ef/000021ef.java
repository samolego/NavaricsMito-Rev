package com.twitter.sdk.android.tweetcomposer;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;

/* compiled from: FileUtils.java */
/* renamed from: com.twitter.sdk.android.tweetcomposer.d */
/* loaded from: classes2.dex */
class C2633d {
    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(19)
    /* renamed from: a */
    public static String m8668a(Context context, Uri uri) {
        if ((Build.VERSION.SDK_INT >= 19) && m8672a(uri)) {
            String[] split = DocumentsContract.getDocumentId(uri).split(":");
            if ("image".equals(split[0])) {
                return m8669a(context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=?", new String[]{split[1]});
            }
            return null;
        }
        if (m8673b(uri)) {
            return m8669a(context, uri, null, null);
        }
        if (m8674c(uri)) {
            return uri.getPath();
        }
        return null;
    }

    /* renamed from: a */
    static boolean m8672a(Uri uri) {
        return "com.android.providers.media.documents".equalsIgnoreCase(uri.getAuthority());
    }

    /* renamed from: b */
    static boolean m8673b(Uri uri) {
        return "content".equalsIgnoreCase(uri.getScheme());
    }

    /* renamed from: c */
    static boolean m8674c(Uri uri) {
        return "file".equalsIgnoreCase(uri.getScheme());
    }

    /* renamed from: a */
    static String m8669a(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursor;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                        if (cursor != null) {
                            cursor.close();
                        }
                        return string;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m8670a(File file) {
        String m8671a = m8671a(file.getName());
        return !TextUtils.isEmpty(m8671a) ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(m8671a) : "application/octet-stream";
    }

    /* renamed from: a */
    static String m8671a(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(".");
        return lastIndexOf < 0 ? "" : str.substring(lastIndexOf + 1);
    }
}