package com.navatics.common.fileprovidercompat;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;
import java.io.File;

/* compiled from: FileProviderCompat.java */
/* renamed from: com.navatics.common.fileprovidercompat.a, reason: use source file name */
/* loaded from: classes.dex */
public class FileProviderCompat {
    /* renamed from: a */
    public static Uri m5990a(Context context, File file) {
        if (Build.VERSION.SDK_INT >= 24) {
            return m5991b(context, file);
        }
        return Uri.fromFile(file);
    }

    /* renamed from: b */
    public static Uri m5991b(Context context, File file) {
        return FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovidercompat", file);
    }
}