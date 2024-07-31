package com.twitter.sdk.android.core.internal;

import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.internal.scribe.DefaultScribeClient;
import com.twitter.sdk.android.core.internal.scribe.EventNamespace;
import com.twitter.sdk.android.core.internal.scribe.TwitterCoreScribeClientHolder;
import com.twitter.sdk.android.core.services.AccountService;
import java.io.IOException;

/* renamed from: com.twitter.sdk.android.core.internal.o */
/* loaded from: classes2.dex */
public class TwitterSessionVerifier implements SessionVerifier<TwitterSession> {

    /* renamed from: a */
    private final C2667a f8539a = new C2667a();

    /* renamed from: b */
    private final DefaultScribeClient f8540b = TwitterCoreScribeClientHolder.m4272a();

    @Override // com.twitter.sdk.android.core.internal.SessionVerifier
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo4420a(TwitterSession twitterSession) {
        AccountService m4418a = this.f8539a.m4418a(twitterSession);
        try {
            m4421a();
            m4418a.verifyCredentials(true, false, false).mo142a();
        } catch (IOException | RuntimeException unused) {
        }
    }

    /* renamed from: a */
    private void m4421a() {
        if (this.f8540b == null) {
            return;
        }
        this.f8540b.m4359a(new EventNamespace.C2678a().m4347a("android").m4346b("credentials").m4345c("").m4344d("").m4343e("").m4342f("impression").m4348a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: TwitterSessionVerifier.java */
    /* renamed from: com.twitter.sdk.android.core.internal.o$a */
    /* loaded from: classes2.dex */
    public static class C2667a {
        protected C2667a() {
        }

        /* renamed from: a */
        public AccountService m4418a(TwitterSession twitterSession) {
            return new TwitterApiClient(twitterSession).m4242a();
        }
    }
}
