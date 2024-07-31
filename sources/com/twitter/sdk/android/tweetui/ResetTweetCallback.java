package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.AbstractC2641c;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;

/* renamed from: com.twitter.sdk.android.tweetui.n */
/* loaded from: classes2.dex */
class ResetTweetCallback extends AbstractC2641c<Tweet> {

    /* renamed from: a */
    final BaseTweetView f9115a;

    /* renamed from: b */
    final TweetRepository f9116b;

    /* renamed from: c */
    final AbstractC2641c<Tweet> f9117c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResetTweetCallback(BaseTweetView baseTweetView, TweetRepository tweetRepository, AbstractC2641c<Tweet> abstractC2641c) {
        this.f9115a = baseTweetView;
        this.f9116b = tweetRepository;
        this.f9117c = abstractC2641c;
    }

    @Override // com.twitter.sdk.android.core.AbstractC2641c
    /* renamed from: a */
    public void mo3867a(Result<Tweet> result) {
        this.f9116b.m3870b(result.f8688a);
        this.f9115a.setTweet(result.f8688a);
        AbstractC2641c<Tweet> abstractC2641c = this.f9117c;
        if (abstractC2641c != null) {
            abstractC2641c.mo3867a(result);
        }
    }

    @Override // com.twitter.sdk.android.core.AbstractC2641c
    /* renamed from: a */
    public void mo3868a(TwitterException twitterException) {
        AbstractC2641c<Tweet> abstractC2641c = this.f9117c;
        if (abstractC2641c != null) {
            abstractC2641c.mo3868a(twitterException);
        }
    }
}
