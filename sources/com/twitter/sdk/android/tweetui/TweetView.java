package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.util.AttributeSet;
import com.twitter.sdk.android.core.models.Tweet;

/* loaded from: classes2.dex */
public class TweetView extends BaseTweetView {
    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    /* renamed from: a */
    protected double mo4141a(int i) {
        return i == 4 ? 1.0d : 1.5d;
    }

    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    String getViewTypeName() {
        return "default";
    }

    public TweetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TweetView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    protected int getLayout() {
        return R.layout.tw__tweet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.twitter.sdk.android.tweetui.BaseTweetView, com.twitter.sdk.android.tweetui.AbstractTweetView
    /* renamed from: c */
    public void mo4132c() {
        super.mo4132c();
        setVerifiedCheck(this.f8918e);
    }

    private void setVerifiedCheck(Tweet tweet) {
        if (tweet != null && tweet.f8726D != null && tweet.f8726D.verified) {
            this.f8921h.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.tw__ic_tweet_verified, 0);
        } else {
            this.f8921h.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }
}
