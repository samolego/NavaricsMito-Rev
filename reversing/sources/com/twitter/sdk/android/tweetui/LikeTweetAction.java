package com.twitter.sdk.android.tweetui;

import android.view.View;
import com.twitter.sdk.android.core.AbstractC2641c;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiException;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.TweetBuilder;

/* renamed from: com.twitter.sdk.android.tweetui.j */
/* loaded from: classes2.dex */
class LikeTweetAction extends BaseTweetAction implements View.OnClickListener {

    /* renamed from: b */
    final Tweet f9092b;

    /* renamed from: c */
    final TweetRepository f9093c;

    /* renamed from: d */
    final TweetUi f9094d;

    /* renamed from: e */
    final TweetScribeClient f9095e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LikeTweetAction(Tweet tweet, TweetUi tweetUi, AbstractC2641c<Tweet> abstractC2641c) {
        this(tweet, tweetUi, abstractC2641c, new TweetScribeClientImpl(tweetUi));
    }

    LikeTweetAction(Tweet tweet, TweetUi tweetUi, AbstractC2641c<Tweet> abstractC2641c, TweetScribeClient tweetScribeClient) {
        super(abstractC2641c);
        this.f9092b = tweet;
        this.f9094d = tweetUi;
        this.f9095e = tweetScribeClient;
        this.f9093c = tweetUi.m4095d();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof ToggleImageButton) {
            ToggleImageButton toggleImageButton = (ToggleImageButton) view;
            if (this.f9092b.f8737g) {
                m3916c();
                this.f9093c.m3871b(this.f9092b.f8739i, new C2761a(toggleImageButton, this.f9092b, m4076a()));
                return;
            }
            m3917b();
            this.f9093c.m3876a(this.f9092b.f8739i, new C2761a(toggleImageButton, this.f9092b, m4076a()));
        }
    }

    /* renamed from: b */
    void m3917b() {
        this.f9095e.mo3863b(this.f9092b);
    }

    /* renamed from: c */
    void m3916c() {
        this.f9095e.mo3862c(this.f9092b);
    }

    /* compiled from: LikeTweetAction.java */
    /* renamed from: com.twitter.sdk.android.tweetui.j$a */
    /* loaded from: classes2.dex */
    static class C2761a extends AbstractC2641c<Tweet> {

        /* renamed from: a */
        final ToggleImageButton f9096a;

        /* renamed from: b */
        final Tweet f9097b;

        /* renamed from: c */
        final AbstractC2641c<Tweet> f9098c;

        C2761a(ToggleImageButton toggleImageButton, Tweet tweet, AbstractC2641c<Tweet> abstractC2641c) {
            this.f9096a = toggleImageButton;
            this.f9097b = tweet;
            this.f9098c = abstractC2641c;
        }

        @Override // com.twitter.sdk.android.core.AbstractC2641c
        /* renamed from: a */
        public void mo3867a(Result<Tweet> result) {
            this.f9098c.mo3867a(result);
        }

        @Override // com.twitter.sdk.android.core.AbstractC2641c
        /* renamed from: a */
        public void mo3868a(TwitterException twitterException) {
            if (twitterException instanceof TwitterApiException) {
                int errorCode = ((TwitterApiException) twitterException).getErrorCode();
                if (errorCode == 139) {
                    this.f9098c.mo3867a(new Result<>(new TweetBuilder().m4244a(this.f9097b).m4243a(true).m4246a(), null));
                    return;
                } else if (errorCode == 144) {
                    this.f9098c.mo3867a(new Result<>(new TweetBuilder().m4244a(this.f9097b).m4243a(false).m4246a(), null));
                    return;
                } else {
                    this.f9096a.setToggledOn(this.f9097b.f8737g);
                    this.f9098c.mo3868a(twitterException);
                    return;
                }
            }
            this.f9096a.setToggledOn(this.f9097b.f8737g);
            this.f9098c.mo3868a(twitterException);
        }
    }
}
