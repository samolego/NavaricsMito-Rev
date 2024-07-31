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

/* renamed from: com.twitter.sdk.android.tweetcomposer.d */
/* loaded from: classes2.dex */
class FileUtils {
    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(19)
    /* renamed from: a */
    public static String m4185a(Context context, Uri uri) {
        if ((Build.VERSION.SDK_INT >= 19) && m4183a(uri)) {
            String[] split = DocumentsContract.getDocumentId(uri).split(":");
            if ("image".equals(split[0])) {
                return m4184a(context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=?", new String[]{split[1]});
            }
            return null;
        } else if (m4180b(uri)) {
            return m4184a(context, uri, null, null);
        } else {
            if (m4179c(uri)) {
                return uri.getPath();
            }
            return null;
        }
    }

    /* renamed from: a */
    static boolean m4183a(Uri uri) {
        return "com.android.providers.media.documents".equalsIgnoreCase(uri.getAuthority());
    }

    /* renamed from: b */
    static boolean m4180b(Uri uri) {
        return "content".equalsIgnoreCase(uri.getScheme());
    }

    /* renamed from: c */
    static boolean m4179c(Uri uri) {
        return "file".equalsIgnoreCase(uri.getScheme());
    }

    /* renamed from: a */
    static String m4184a(Context context, Uri uri, String str, String[] strArr) {
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
    public static String m4182a(File file) {
        String m4181a = m4181a(file.getName());
        return !TextUtils.isEmpty(m4181a) ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(m4181a) : "application/octet-stream";
    }

    /* renamed from: a */
    static String m4181a(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(".");
        return lastIndexOf < 0 ? "" : str.substring(lastIndexOf + 1);
    }
}
