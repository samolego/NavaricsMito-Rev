package com.bumptech.glide.p017d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.bumptech.glide.load.Key;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.bumptech.glide.d.a */
/* loaded from: classes.dex */
public final class ApplicationVersionSignature {

    /* renamed from: a */
    private static final ConcurrentMap<String, Key> f420a = new ConcurrentHashMap();

    @NonNull
    /* renamed from: a */
    public static Key m12530a(@NonNull Context context) {
        String packageName = context.getPackageName();
        Key key = f420a.get(packageName);
        if (key == null) {
            Key m12528b = m12528b(context);
            Key putIfAbsent = f420a.putIfAbsent(packageName, m12528b);
            return putIfAbsent == null ? m12528b : putIfAbsent;
        }
        return key;
    }

    @NonNull
    /* renamed from: b */
    private static Key m12528b(@NonNull Context context) {
        return new ObjectKey(m12529a(m12527c(context)));
    }

    @NonNull
    /* renamed from: a */
    private static String m12529a(@Nullable PackageInfo packageInfo) {
        if (packageInfo != null) {
            return String.valueOf(packageInfo.versionCode);
        }
        return UUID.randomUUID().toString();
    }

    @Nullable
    /* renamed from: c */
    private static PackageInfo m12527c(@NonNull Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("AppVersionSignature", "Cannot resolve info for" + context.getPackageName(), e);
            return null;
        }
    }
}
