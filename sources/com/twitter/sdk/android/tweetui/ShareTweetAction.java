package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.twitter.sdk.android.core.C2644g;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.models.Tweet;

/* renamed from: com.twitter.sdk.android.tweetui.o */
/* loaded from: classes2.dex */
class ShareTweetAction implements View.OnClickListener {

    /* renamed from: a */
    final Tweet f9118a;

    /* renamed from: b */
    final TweetUi f9119b;

    /* renamed from: c */
    final TweetScribeClient f9120c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShareTweetAction(Tweet tweet, TweetUi tweetUi) {
        this(tweet, tweetUi, new TweetScribeClientImpl(tweetUi));
    }

    ShareTweetAction(Tweet tweet, TweetUi tweetUi, TweetScribeClient tweetScribeClient) {
        this.f9118a = tweet;
        this.f9119b = tweetUi;
        this.f9120c = tweetScribeClient;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        m3903a(view.getContext(), view.getResources());
    }

    /* renamed from: a */
    void m3904a() {
        this.f9120c.mo3866a(this.f9118a);
    }

    /* renamed from: a */
    void m3903a(Context context, Resources resources) {
        Tweet tweet = this.f9118a;
        if (tweet == null || tweet.f8726D == null) {
            return;
        }
        m3904a();
        m3902a(Intent.createChooser(m3900a(m3899b(resources), m3901a(resources)), resources.getString(R.string.tw__share_tweet)), context);
    }

    /* renamed from: a */
    String m3901a(Resources resources) {
        return resources.getString(R.string.tw__share_content_format, this.f9118a.f8726D.screenName, Long.toString(this.f9118a.f8739i));
    }

    /* renamed from: b */
    String m3899b(Resources resources) {
        return resources.getString(R.string.tw__share_subject_format, this.f9118a.f8726D.name, this.f9118a.f8726D.screenName);
    }

    /* renamed from: a */
    void m3902a(Intent intent, Context context) {
        if (C2644g.m4563b(context, intent)) {
            return;
        }
        Twitter.m4253h().mo4557c("TweetUi", "Activity cannot be found to handle share intent");
    }

    /* renamed from: a */
    Intent m3900a(String str, String str2) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.SUBJECT", str);
        intent.putExtra("android.intent.extra.TEXT", str2);
        intent.setType("text/plain");
        return intent;
    }
}
