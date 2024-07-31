package com.navatics.common.fileprovidercompat;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.support.p008v4.content.FileProvider;
import java.io.File;

/* renamed from: com.navatics.common.fileprovidercompat.a */
/* loaded from: classes.dex */
public class FileProviderCompat {
    /* renamed from: a */
    public static Uri m6871a(Context context, File file) {
        if (Build.VERSION.SDK_INT >= 24) {
            return m6870b(context, file);
        }
        return Uri.fromFile(file);
    }

    /* renamed from: b */
    public static Uri m6870b(Context context, File file) {
        return FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovidercompat", file);
    }
}
