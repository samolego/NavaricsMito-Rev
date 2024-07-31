package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.util.AttributeSet;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.core.models.Tweet;

/* loaded from: classes2.dex */
public class CompactTweetView extends BaseTweetView {
    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    /* renamed from: a */
    protected double mo4141a(int i) {
        return 1.6d;
    }

    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    String getViewTypeName() {
        return "compact";
    }

    public CompactTweetView(Context context, Tweet tweet, int i) {
        super(context, tweet, i);
    }

    public CompactTweetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CompactTweetView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    protected int getLayout() {
        return R.layout.tw__tweet_compact;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.twitter.sdk.android.tweetui.BaseTweetView, com.twitter.sdk.android.tweetui.AbstractTweetView
    /* renamed from: c */
    public void mo4132c() {
        super.mo4132c();
        this.f8922i.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.twitter.sdk.android.tweetui.BaseTweetView
    /* renamed from: h */
    public void mo4158h() {
        super.mo4158h();
        setPadding(0, getResources().getDimensionPixelSize(R.dimen.tw__compact_tweet_container_padding_top), 0, 0);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tw__media_view_radius);
        this.f8924k.m4035a(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    /* renamed from: a */
    public double mo4138a(MediaEntity mediaEntity) {
        double a = super.mo4138a(mediaEntity);
        if (a <= 1.0d) {
            return 1.0d;
        }
        if (a > 3.0d) {
            return 3.0d;
        }
        if (a < 1.3333333333333333d) {
            return 1.3333333333333333d;
        }
        return a;
    }
}
