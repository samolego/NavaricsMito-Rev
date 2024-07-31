package com.twitter.sdk.android.tweetui;

import android.os.Handler;
import android.support.p008v4.util.LruCache;
import android.text.TextUtils;
import com.twitter.sdk.android.core.AbstractC2641c;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.models.Tweet;

/* renamed from: com.twitter.sdk.android.tweetui.y */
/* loaded from: classes2.dex */
class TweetRepository {

    /* renamed from: a */
    final LruCache<Long, Tweet> f9139a;

    /* renamed from: b */
    final LruCache<Long, FormattedTweetText> f9140b;

    /* renamed from: c */
    private final TwitterCore f9141c;

    /* renamed from: d */
    private final Handler f9142d;

    /* renamed from: e */
    private final SessionManager<TwitterSession> f9143e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TweetRepository(Handler handler, SessionManager<TwitterSession> sessionManager) {
        this(handler, sessionManager, TwitterCore.m4230a());
    }

    TweetRepository(Handler handler, SessionManager<TwitterSession> sessionManager, TwitterCore twitterCore) {
        this.f9141c = twitterCore;
        this.f9142d = handler;
        this.f9143e = sessionManager;
        this.f9139a = new LruCache<>(20);
        this.f9140b = new LruCache<>(20);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public FormattedTweetText m3874a(Tweet tweet) {
        if (tweet == null) {
            return null;
        }
        FormattedTweetText formattedTweetText = this.f9140b.get(Long.valueOf(tweet.f8739i));
        if (formattedTweetText != null) {
            return formattedTweetText;
        }
        FormattedTweetText m4106a = TweetTextUtils.m4106a(tweet);
        if (m4106a != null && !TextUtils.isEmpty(m4106a.f8955a)) {
            this.f9140b.put(Long.valueOf(tweet.f8739i), m4106a);
        }
        return m4106a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m3870b(Tweet tweet) {
        this.f9139a.put(Long.valueOf(tweet.f8739i), tweet);
    }

    /* renamed from: a */
    private void m3873a(final Tweet tweet, final AbstractC2641c<Tweet> abstractC2641c) {
        if (abstractC2641c == null) {
            return;
        }
        this.f9142d.post(new Runnable() { // from class: com.twitter.sdk.android.tweetui.y.1
            @Override // java.lang.Runnable
            public void run() {
                abstractC2641c.mo3867a(new Result(tweet, null));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m3876a(final long j, final AbstractC2641c<Tweet> abstractC2641c) {
        m3875a(new LoggingCallback<TwitterSession>(abstractC2641c, Twitter.m4253h()) { // from class: com.twitter.sdk.android.tweetui.y.2
            @Override // com.twitter.sdk.android.core.AbstractC2641c
            /* renamed from: a */
            public void mo3867a(Result<TwitterSession> result) {
                TweetRepository.this.f9141c.m4229a(result.f8688a).m4239b().create(Long.valueOf(j), false).mo140a(abstractC2641c);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m3871b(final long j, final AbstractC2641c<Tweet> abstractC2641c) {
        m3875a(new LoggingCallback<TwitterSession>(abstractC2641c, Twitter.m4253h()) { // from class: com.twitter.sdk.android.tweetui.y.3
            @Override // com.twitter.sdk.android.core.AbstractC2641c
            /* renamed from: a */
            public void mo3867a(Result<TwitterSession> result) {
                TweetRepository.this.f9141c.m4229a(result.f8688a).m4239b().destroy(Long.valueOf(j), false).mo140a(abstractC2641c);
            }
        });
    }

    /* renamed from: a */
    void m3875a(AbstractC2641c<TwitterSession> abstractC2641c) {
        TwitterSession mo4266b = this.f9143e.mo4266b();
        if (mo4266b == null) {
            abstractC2641c.mo3868a(new TwitterAuthException("User authorization required"));
        } else {
            abstractC2641c.mo3867a(new Result<>(mo4266b, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m3869c(long j, AbstractC2641c<Tweet> abstractC2641c) {
        Tweet tweet = this.f9139a.get(Long.valueOf(j));
        if (tweet != null) {
            m3873a(tweet, abstractC2641c);
        } else {
            this.f9141c.m4222h().m4238c().show(Long.valueOf(j), null, null, null).mo140a(new C2773a(abstractC2641c));
        }
    }

    /* compiled from: TweetRepository.java */
    /* renamed from: com.twitter.sdk.android.tweetui.y$a */
    /* loaded from: classes2.dex */
    class C2773a extends AbstractC2641c<Tweet> {

        /* renamed from: a */
        final AbstractC2641c<Tweet> f9153a;

        C2773a(AbstractC2641c<Tweet> abstractC2641c) {
            this.f9153a = abstractC2641c;
        }

        @Override // com.twitter.sdk.android.core.AbstractC2641c
        /* renamed from: a */
        public void mo3867a(Result<Tweet> result) {
            Tweet tweet = result.f8688a;
            TweetRepository.this.m3870b(tweet);
            AbstractC2641c<Tweet> abstractC2641c = this.f9153a;
            if (abstractC2641c != null) {
                abstractC2641c.mo3867a(new Result<>(tweet, result.f8689b));
            }
        }

        @Override // com.twitter.sdk.android.core.AbstractC2641c
        /* renamed from: a */
        public void mo3868a(TwitterException twitterException) {
            this.f9153a.mo3868a(twitterException);
        }
    }
}
