package com.twitter.sdk.android.core.internal.oauth;

import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import java.util.Map;

/* renamed from: com.twitter.sdk.android.core.internal.oauth.b */
/* loaded from: classes2.dex */
public class OAuth1aHeaders {
    /* renamed from: a */
    public String m4396a(TwitterAuthConfig twitterAuthConfig, TwitterAuthToken twitterAuthToken, String str, String str2, String str3, Map<String, String> map) {
        return m4395b(twitterAuthConfig, twitterAuthToken, str, str2, str3, map).m4394a();
    }

    /* renamed from: b */
    OAuth1aParameters m4395b(TwitterAuthConfig twitterAuthConfig, TwitterAuthToken twitterAuthToken, String str, String str2, String str3, Map<String, String> map) {
        return new OAuth1aParameters(twitterAuthConfig, twitterAuthToken, str, str2, str3, map);
    }
}
