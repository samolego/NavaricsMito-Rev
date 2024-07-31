package com.twitter.sdk.android.tweetui.internal;

import java.util.Locale;

/* renamed from: com.twitter.sdk.android.tweetui.internal.d */
/* loaded from: classes2.dex */
final class MediaTimeUtils {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m3954a(long j) {
        int i = (int) (j / 1000);
        int i2 = i % 60;
        int i3 = (i / 60) % 60;
        int i4 = i / 3600;
        return i4 > 0 ? String.format(Locale.getDefault(), "%1$d:%2$02d:%3$02d", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2)) : String.format(Locale.getDefault(), "%1$d:%2$02d", Integer.valueOf(i3), Integer.valueOf(i2));
    }
}
