package com.twitter.sdk.android.core;

import android.content.Context;
import android.content.Intent;

/* compiled from: IntentUtils.java */
/* renamed from: com.twitter.sdk.android.core.g */
/* loaded from: classes2.dex */
public class C2644g {
    /* renamed from: a */
    public static boolean m4564a(Context context, Intent intent) {
        return !context.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }

    /* renamed from: b */
    public static boolean m4563b(Context context, Intent intent) {
        if (m4564a(context, intent)) {
            context.startActivity(intent);
            return true;
        }
        return false;
    }
}
