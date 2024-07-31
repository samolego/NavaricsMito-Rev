package com.twitter.sdk.android.core;

import android.annotation.SuppressLint;
import android.content.Context;
import com.twitter.sdk.android.core.GuestSession;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.internal.SessionMonitor;
import com.twitter.sdk.android.core.internal.TwitterApi;
import com.twitter.sdk.android.core.internal.TwitterSessionVerifier;
import com.twitter.sdk.android.core.internal.oauth.OAuth2Service;
import com.twitter.sdk.android.core.internal.p079b.PreferenceStoreImpl;
import com.twitter.sdk.android.core.internal.scribe.TwitterCoreScribeClientHolder;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.twitter.sdk.android.core.q */
/* loaded from: classes2.dex */
public class TwitterCore {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a */
    static volatile TwitterCore f8812a;

    /* renamed from: b */
    SessionManager<TwitterSession> f8813b;

    /* renamed from: c */
    SessionManager<GuestSession> f8814c;

    /* renamed from: d */
    SessionMonitor<TwitterSession> f8815d;

    /* renamed from: e */
    private final TwitterAuthConfig f8816e;

    /* renamed from: f */
    private final ConcurrentHashMap<Session, TwitterApiClient> f8817f;

    /* renamed from: g */
    private final Context f8818g;

    /* renamed from: h */
    private volatile TwitterApiClient f8819h;

    /* renamed from: i */
    private volatile GuestSessionProvider f8820i;

    /* renamed from: b */
    public String m4228b() {
        return "3.1.1.9";
    }

    /* renamed from: e */
    public String m4225e() {
        return "com.twitter.sdk.android:twitter-core";
    }

    TwitterCore(TwitterAuthConfig twitterAuthConfig) {
        this(twitterAuthConfig, new ConcurrentHashMap(), null);
    }

    TwitterCore(TwitterAuthConfig twitterAuthConfig, ConcurrentHashMap<Session, TwitterApiClient> concurrentHashMap, TwitterApiClient twitterApiClient) {
        this.f8816e = twitterAuthConfig;
        this.f8817f = concurrentHashMap;
        this.f8819h = twitterApiClient;
        this.f8818g = Twitter.m4260b().m4261a(m4225e());
        this.f8813b = new PersistedSessionManager(new PreferenceStoreImpl(this.f8818g, "session_store"), new TwitterSession.C2695a(), "active_twittersession", "twittersession");
        this.f8814c = new PersistedSessionManager(new PreferenceStoreImpl(this.f8818g, "session_store"), new GuestSession.C2642a(), "active_guestsession", "guestsession");
        this.f8815d = new SessionMonitor<>(this.f8813b, Twitter.m4260b().m4256e(), new TwitterSessionVerifier());
    }

    /* renamed from: a */
    public static TwitterCore m4230a() {
        if (f8812a == null) {
            synchronized (TwitterCore.class) {
                if (f8812a == null) {
                    f8812a = new TwitterCore(Twitter.m4260b().m4257d());
                    Twitter.m4260b().m4256e().execute(new Runnable() { // from class: com.twitter.sdk.android.core.q.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TwitterCore.f8812a.m4226d();
                        }
                    });
                }
            }
        }
        return f8812a;
    }

    /* renamed from: c */
    public TwitterAuthConfig m4227c() {
        return this.f8816e;
    }

    /* renamed from: d */
    void m4226d() {
        this.f8813b.mo4266b();
        this.f8814c.mo4266b();
        m4223g();
        m4220j();
        this.f8815d.m4433a(Twitter.m4260b().m4255f());
    }

    /* renamed from: j */
    private void m4220j() {
        TwitterCoreScribeClientHolder.m4271a(this.f8818g, m4224f(), m4223g(), Twitter.m4260b().m4258c(), "TwitterCore", m4228b());
    }

    /* renamed from: f */
    public SessionManager<TwitterSession> m4224f() {
        return this.f8813b;
    }

    /* renamed from: g */
    public GuestSessionProvider m4223g() {
        if (this.f8820i == null) {
            m4219k();
        }
        return this.f8820i;
    }

    /* renamed from: k */
    private synchronized void m4219k() {
        if (this.f8820i == null) {
            this.f8820i = new GuestSessionProvider(new OAuth2Service(this, new TwitterApi()), this.f8814c);
        }
    }

    /* renamed from: h */
    public TwitterApiClient m4222h() {
        TwitterSession mo4266b = this.f8813b.mo4266b();
        if (mo4266b == null) {
            return m4221i();
        }
        return m4229a(mo4266b);
    }

    /* renamed from: a */
    public TwitterApiClient m4229a(TwitterSession twitterSession) {
        if (!this.f8817f.containsKey(twitterSession)) {
            this.f8817f.putIfAbsent(twitterSession, new TwitterApiClient(twitterSession));
        }
        return this.f8817f.get(twitterSession);
    }

    /* renamed from: i */
    public TwitterApiClient m4221i() {
        if (this.f8819h == null) {
            m4218l();
        }
        return this.f8819h;
    }

    /* renamed from: l */
    private synchronized void m4218l() {
        if (this.f8819h == null) {
            this.f8819h = new TwitterApiClient();
        }
    }
}
