package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import android.content.Intent;
import com.twitter.sdk.android.core.AbstractC2641c;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterSession;

/* renamed from: com.twitter.sdk.android.core.identity.d */
/* loaded from: classes2.dex */
class OAuthHandler extends AuthHandler {
    public OAuthHandler(TwitterAuthConfig twitterAuthConfig, AbstractC2641c<TwitterSession> abstractC2641c, int i) {
        super(twitterAuthConfig, abstractC2641c, i);
    }

    @Override // com.twitter.sdk.android.core.identity.AuthHandler
    /* renamed from: a */
    public boolean mo4524a(Activity activity) {
        activity.startActivityForResult(m4528b(activity), this.f8461a);
        return true;
    }

    /* renamed from: b */
    Intent m4528b(Activity activity) {
        Intent intent = new Intent(activity, OAuthActivity.class);
        intent.putExtra("auth_config", m4544a());
        return intent;
    }
}
