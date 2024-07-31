package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import android.content.Context;
import com.twitter.sdk.android.core.AbstractC2641c;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.internal.scribe.DefaultScribeClient;
import com.twitter.sdk.android.core.internal.scribe.EventNamespace;
import com.twitter.sdk.android.core.internal.scribe.TwitterCoreScribeClientHolder;

/* renamed from: com.twitter.sdk.android.core.identity.h */
/* loaded from: classes2.dex */
public class TwitterAuthClient {

    /* renamed from: a */
    final TwitterCore f8475a;

    /* renamed from: b */
    final AuthState f8476b;

    /* renamed from: c */
    final SessionManager<TwitterSession> f8477c;

    /* renamed from: d */
    final TwitterAuthConfig f8478d;

    /* compiled from: TwitterAuthClient.java */
    /* renamed from: com.twitter.sdk.android.core.identity.h$a */
    /* loaded from: classes2.dex */
    private static class C2652a {

        /* renamed from: a */
        private static final AuthState f8479a = new AuthState();
    }

    public TwitterAuthClient() {
        this(TwitterCore.m4230a(), TwitterCore.m4230a().m4227c(), TwitterCore.m4230a().m4224f(), C2652a.f8479a);
    }

    TwitterAuthClient(TwitterCore twitterCore, TwitterAuthConfig twitterAuthConfig, SessionManager<TwitterSession> sessionManager, AuthState authState) {
        this.f8475a = twitterCore;
        this.f8476b = authState;
        this.f8478d = twitterAuthConfig;
        this.f8477c = sessionManager;
    }

    /* renamed from: a */
    public void m4518a(Activity activity, AbstractC2641c<TwitterSession> abstractC2641c) {
        if (activity == null) {
            throw new IllegalArgumentException("Activity must not be null.");
        }
        if (abstractC2641c == null) {
            throw new IllegalArgumentException("Callback must not be null.");
        }
        if (activity.isFinishing()) {
            Twitter.m4253h().mo4556c("Twitter", "Cannot authorize, activity is finishing.", null);
        } else {
            m4515b(activity, abstractC2641c);
        }
    }

    /* renamed from: b */
    private void m4515b(Activity activity, AbstractC2641c<TwitterSession> abstractC2641c) {
        m4516b();
        C2653b c2653b = new C2653b(this.f8477c, abstractC2641c);
        if (m4517a(activity, c2653b) || m4514b(activity, c2653b)) {
            return;
        }
        c2653b.mo3868a(new TwitterAuthException("Authorize failed."));
    }

    /* renamed from: a */
    private boolean m4517a(Activity activity, C2653b c2653b) {
        if (SSOAuthHandler.m4523a((Context) activity)) {
            Twitter.m4253h().mo4561a("Twitter", "Using SSO");
            AuthState authState = this.f8476b;
            TwitterAuthConfig twitterAuthConfig = this.f8478d;
            return authState.m4542a(activity, new SSOAuthHandler(twitterAuthConfig, c2653b, twitterAuthConfig.m4581c()));
        }
        return false;
    }

    /* renamed from: b */
    private boolean m4514b(Activity activity, C2653b c2653b) {
        Twitter.m4253h().mo4561a("Twitter", "Using OAuth");
        AuthState authState = this.f8476b;
        TwitterAuthConfig twitterAuthConfig = this.f8478d;
        return authState.m4542a(activity, new OAuthHandler(twitterAuthConfig, c2653b, twitterAuthConfig.m4581c()));
    }

    /* renamed from: b */
    private void m4516b() {
        DefaultScribeClient m4519a = m4519a();
        if (m4519a == null) {
            return;
        }
        m4519a.m4359a(new EventNamespace.C2678a().m4347a("android").m4346b("login").m4345c("").m4344d("").m4343e("").m4342f("impression").m4348a());
    }

    /* renamed from: a */
    protected DefaultScribeClient m4519a() {
        return TwitterCoreScribeClientHolder.m4272a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TwitterAuthClient.java */
    /* renamed from: com.twitter.sdk.android.core.identity.h$b */
    /* loaded from: classes2.dex */
    public static class C2653b extends AbstractC2641c<TwitterSession> {

        /* renamed from: a */
        private final SessionManager<TwitterSession> f8480a;

        /* renamed from: b */
        private final AbstractC2641c<TwitterSession> f8481b;

        C2653b(SessionManager<TwitterSession> sessionManager, AbstractC2641c<TwitterSession> abstractC2641c) {
            this.f8480a = sessionManager;
            this.f8481b = abstractC2641c;
        }

        @Override // com.twitter.sdk.android.core.AbstractC2641c
        /* renamed from: a */
        public void mo3867a(Result<TwitterSession> result) {
            Twitter.m4253h().mo4561a("Twitter", "Authorization completed successfully");
            this.f8480a.mo4267a((SessionManager<TwitterSession>) result.f8688a);
            this.f8481b.mo3867a(result);
        }

        @Override // com.twitter.sdk.android.core.AbstractC2641c
        /* renamed from: a */
        public void mo3868a(TwitterException twitterException) {
            Twitter.m4253h().mo4556c("Twitter", "Authorization completed with an error", twitterException);
            this.f8481b.mo3868a(twitterException);
        }
    }
}
