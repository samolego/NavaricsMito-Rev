package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import com.twitter.sdk.android.core.AbstractC2641c;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterSession;

/* renamed from: com.twitter.sdk.android.core.identity.a */
/* loaded from: classes2.dex */
public abstract class AuthHandler {

    /* renamed from: a */
    protected final int f8461a;

    /* renamed from: b */
    private final TwitterAuthConfig f8462b;

    /* renamed from: c */
    private final AbstractC2641c<TwitterSession> f8463c;

    /* renamed from: a */
    public abstract boolean mo4524a(Activity activity);

    /* JADX INFO: Access modifiers changed from: package-private */
    public AuthHandler(TwitterAuthConfig twitterAuthConfig, AbstractC2641c<TwitterSession> abstractC2641c, int i) {
        this.f8462b = twitterAuthConfig;
        this.f8463c = abstractC2641c;
        this.f8461a = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public TwitterAuthConfig m4544a() {
        return this.f8462b;
    }
}
