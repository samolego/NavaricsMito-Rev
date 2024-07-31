package com.twitter.sdk.android.tweetui;

import android.content.Context;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.AbstractTweetView;

/* loaded from: classes2.dex */
public class QuoteTweetView extends AbstractTweetView {
    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    /* renamed from: a */
    protected double mo4141a(int i) {
        return 1.6d;
    }

    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    String getViewTypeName() {
        return "quote";
    }

    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    public /* bridge */ /* synthetic */ Tweet getTweet() {
        return super.getTweet();
    }

    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    public /* bridge */ /* synthetic */ long getTweetId() {
        return super.getTweetId();
    }

    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    public /* bridge */ /* synthetic */ void setTweet(Tweet tweet) {
        super.setTweet(tweet);
    }

    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    public /* bridge */ /* synthetic */ void setTweetLinkClickListener(TweetLinkClickListener tweetLinkClickListener) {
        super.setTweetLinkClickListener(tweetLinkClickListener);
    }

    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    public /* bridge */ /* synthetic */ void setTweetMediaClickListener(TweetMediaClickListener tweetMediaClickListener) {
        super.setTweetMediaClickListener(tweetMediaClickListener);
    }

    public QuoteTweetView(Context context) {
        this(context, new AbstractTweetView.C2727a());
    }

    QuoteTweetView(Context context, AbstractTweetView.C2727a c2727a) {
        super(context, null, 0, c2727a);
    }

    /* renamed from: a */
    public void m4149a(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f8927n = i;
        this.f8928o = i2;
        this.f8929p = i3;
        this.f8930q = i4;
        this.f8931r = i5;
        this.f8932s = i6;
        m4148h();
    }

    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    protected int getLayout() {
        return R.layout.tw__tweet_quote;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    /* renamed from: c */
    public void mo4132c() {
        super.mo4132c();
        this.f8922i.requestLayout();
    }

    /* renamed from: h */
    protected void m4148h() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tw__media_view_radius);
        this.f8924k.m4035a(0, 0, dimensionPixelSize, dimensionPixelSize);
        setBackgroundResource(R.drawable.tw__quote_tweet_border);
        this.f8921h.setTextColor(this.f8927n);
        this.f8922i.setTextColor(this.f8928o);
        this.f8925l.setTextColor(this.f8927n);
        this.f8924k.setMediaBgColor(this.f8931r);
        this.f8924k.setPhotoErrorResId(this.f8932s);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    /* renamed from: a */
    public double mo4138a(MediaEntity mediaEntity) {
        double mo4138a = super.mo4138a(mediaEntity);
        if (mo4138a <= 1.0d) {
            return 1.0d;
        }
        if (mo4138a > 3.0d) {
            return 3.0d;
        }
        if (mo4138a < 1.3333333333333333d) {
            return 1.3333333333333333d;
        }
        return mo4138a;
    }
}
