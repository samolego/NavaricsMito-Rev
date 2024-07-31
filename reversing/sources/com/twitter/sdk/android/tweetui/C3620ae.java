package com.twitter.sdk.android.tweetui;

import android.net.Uri;
import android.text.TextUtils;
import com.twitter.sdk.android.core.models.Tweet;
import java.util.Locale;

/* renamed from: com.twitter.sdk.android.tweetui.ae */
/* loaded from: classes2.dex */
public final class TweetUtils {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m4092a(Tweet tweet) {
        return (tweet == null || tweet.f8739i <= 0 || tweet.f8726D == null || TextUtils.isEmpty(tweet.f8726D.screenName)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static Tweet m4089b(Tweet tweet) {
        return (tweet == null || tweet.f8755y == null) ? tweet : tweet.f8755y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static boolean m4087c(Tweet tweet) {
        return tweet.f8752v != null && tweet.f8730H == null && (tweet.f8734d == null || tweet.f8734d.f8794d == null || tweet.f8734d.f8794d.isEmpty());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static Uri m4090a(String str, long j) {
        String format;
        if (j <= 0) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            format = String.format(Locale.US, "https://twitter.com/%s/status/%d?ref_src=twsrc%%5Etwitterkit", "twitter_unknown", Long.valueOf(j));
        } else {
            format = String.format(Locale.US, "https://twitter.com/%s/status/%d?ref_src=twsrc%%5Etwitterkit", str, Long.valueOf(j));
        }
        return Uri.parse(format);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m4091a(String str) {
        return TextUtils.isEmpty(str) ? String.format(Locale.US, "https://twitter.com/%s?ref_src=twsrc%%5Etwitterkit", "twitter_unknown") : String.format(Locale.US, "https://twitter.com/%s?ref_src=twsrc%%5Etwitterkit", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static String m4088b(String str) {
        return String.format(Locale.US, "https://twitter.com/hashtag/%s?ref_src=twsrc%%5Etwitterkit", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static String m4086c(String str) {
        return String.format(Locale.US, "https://twitter.com/search?q=%%24%s&ref_src=twsrc%%5Etwitterkit", str);
    }
}
