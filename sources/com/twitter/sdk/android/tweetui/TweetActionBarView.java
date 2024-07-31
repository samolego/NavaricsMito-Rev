package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.twitter.sdk.android.core.AbstractC2641c;
import com.twitter.sdk.android.core.models.Tweet;

/* loaded from: classes2.dex */
public class TweetActionBarView extends LinearLayout {

    /* renamed from: a */
    final C2725a f8906a;

    /* renamed from: b */
    ToggleImageButton f8907b;

    /* renamed from: c */
    ImageButton f8908c;

    /* renamed from: d */
    AbstractC2641c<Tweet> f8909d;

    public TweetActionBarView(Context context) {
        this(context, null, new C2725a());
    }

    public TweetActionBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, new C2725a());
    }

    TweetActionBarView(Context context, AttributeSet attributeSet, C2725a c2725a) {
        super(context, attributeSet);
        this.f8906a = c2725a;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        m4146a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnActionCallback(AbstractC2641c<Tweet> abstractC2641c) {
        this.f8909d = abstractC2641c;
    }

    /* renamed from: a */
    void m4146a() {
        this.f8907b = (ToggleImageButton) findViewById(R.id.tw__tweet_like_button);
        this.f8908c = (ImageButton) findViewById(R.id.tw__tweet_share_button);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTweet(Tweet tweet) {
        setLike(tweet);
        setShare(tweet);
    }

    void setLike(Tweet tweet) {
        TweetUi m4145a = this.f8906a.m4145a();
        if (tweet != null) {
            this.f8907b.setToggledOn(tweet.f8737g);
            this.f8907b.setOnClickListener(new LikeTweetAction(tweet, m4145a, this.f8909d));
        }
    }

    void setShare(Tweet tweet) {
        TweetUi m4145a = this.f8906a.m4145a();
        if (tweet != null) {
            this.f8908c.setOnClickListener(new ShareTweetAction(tweet, m4145a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.twitter.sdk.android.tweetui.TweetActionBarView$a */
    /* loaded from: classes2.dex */
    public static class C2725a {
        C2725a() {
        }

        /* renamed from: a */
        TweetUi m4145a() {
            return TweetUi.m4100a();
        }
    }
}
