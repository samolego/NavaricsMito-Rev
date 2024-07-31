package com.twitter.sdk.android.core;

import android.content.Context;
import android.content.Intent;

/* compiled from: IntentUtils.java */
/* renamed from: com.twitter.sdk.android.core.g */
/* loaded from: classes2.dex */
public class C2513g {
    /* renamed from: a */
    public static boolean m8299a(Context context, Intent intent) {
        return !context.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }

    /* renamed from: b */
    public static boolean m8300b(Context context, Intent intent) {
        if (!m8299a(context, intent)) {
            return false;
        }
        context.startActivity(intent);
        return true;
    }
}