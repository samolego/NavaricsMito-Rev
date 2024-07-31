package com.twitter.sdk.android.core;

import com.twitter.sdk.android.core.internal.oauth.GuestAuthToken;
import com.twitter.sdk.android.core.internal.oauth.OAuth2Service;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.twitter.sdk.android.core.f */
/* loaded from: classes2.dex */
public class GuestSessionProvider {

    /* renamed from: a */
    private final OAuth2Service f8441a;

    /* renamed from: b */
    private final SessionManager<GuestSession> f8442b;

    public GuestSessionProvider(OAuth2Service oAuth2Service, SessionManager<GuestSession> sessionManager) {
        this.f8441a = oAuth2Service;
        this.f8442b = sessionManager;
    }

    /* renamed from: a */
    public synchronized GuestSession m4569a() {
        GuestSession mo4266b = this.f8442b.mo4266b();
        if (m4565b(mo4266b)) {
            return mo4266b;
        }
        m4566b();
        return this.f8442b.mo4266b();
    }

    /* renamed from: a */
    public synchronized GuestSession m4568a(GuestSession guestSession) {
        GuestSession mo4266b = this.f8442b.mo4266b();
        if (guestSession != null && guestSession.equals(mo4266b)) {
            m4566b();
        }
        return this.f8442b.mo4266b();
    }

    /* renamed from: b */
    void m4566b() {
        Twitter.m4253h().mo4561a("GuestSessionProvider", "Refreshing expired guest session.");
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f8441a.m4407a(new AbstractC2641c<GuestAuthToken>() { // from class: com.twitter.sdk.android.core.f.1
            @Override // com.twitter.sdk.android.core.AbstractC2641c
            /* renamed from: a */
            public void mo3867a(Result<GuestAuthToken> result) {
                GuestSessionProvider.this.f8442b.mo4267a((SessionManager) new GuestSession(result.f8688a));
                countDownLatch.countDown();
            }

            @Override // com.twitter.sdk.android.core.AbstractC2641c
            /* renamed from: a */
            public void mo3868a(TwitterException twitterException) {
                GuestSessionProvider.this.f8442b.mo4264c(0L);
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            this.f8442b.mo4264c(0L);
        }
    }

    /* renamed from: b */
    boolean m4565b(GuestSession guestSession) {
        return (guestSession == null || guestSession.m4270a() == null || guestSession.m4270a().mo4403b()) ? false : true;
    }
}
