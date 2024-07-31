package com.twitter.sdk.android.tweetui;

import android.graphics.Color;

/* renamed from: com.twitter.sdk.android.tweetui.c */
/* loaded from: classes2.dex */
final class ColorUtils {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static int m4075a(double d, int i, int i2) {
        double d2 = 1.0d - d;
        return Color.rgb((int) ((Color.red(i2) * d2) + (Color.red(i) * d)), (int) ((Color.green(i2) * d2) + (Color.green(i) * d)), (int) ((d2 * Color.blue(i2)) + (d * Color.blue(i))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m4074a(int i) {
        return ((((double) Color.red(i)) * 0.21d) + (((double) Color.green(i)) * 0.72d)) + (((double) Color.blue(i)) * 0.07d) > 128.0d;
    }
}
