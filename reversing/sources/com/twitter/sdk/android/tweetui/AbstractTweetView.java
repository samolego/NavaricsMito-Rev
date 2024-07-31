package com.twitter.sdk.android.tweetui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.C2644g;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.internal.UserUtils;
import com.twitter.sdk.android.core.internal.VineCardUtils;
import com.twitter.sdk.android.core.internal.scribe.ScribeItem;
import com.twitter.sdk.android.core.models.Card;
import com.twitter.sdk.android.core.models.ImageValue;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.internal.AspectRatioFrameLayout;
import com.twitter.sdk.android.tweetui.internal.MediaBadgeView;
import com.twitter.sdk.android.tweetui.internal.SpanClickHandler;
import com.twitter.sdk.android.tweetui.internal.TweetMediaUtils;
import com.twitter.sdk.android.tweetui.internal.TweetMediaView;
import java.text.DateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* renamed from: com.twitter.sdk.android.tweetui.a */
/* loaded from: classes2.dex */
abstract class AbstractTweetView extends RelativeLayout {

    /* renamed from: a */
    static final int f8914a = R.style.tw__TweetLightStyle;

    /* renamed from: b */
    final C2727a f8915b;

    /* renamed from: c */
    TweetLinkClickListener f8916c;

    /* renamed from: d */
    TweetMediaClickListener f8917d;

    /* renamed from: e */
    Tweet f8918e;

    /* renamed from: f */
    int f8919f;

    /* renamed from: g */
    boolean f8920g;

    /* renamed from: h */
    TextView f8921h;

    /* renamed from: i */
    TextView f8922i;

    /* renamed from: j */
    AspectRatioFrameLayout f8923j;

    /* renamed from: k */
    TweetMediaView f8924k;

    /* renamed from: l */
    TextView f8925l;

    /* renamed from: m */
    MediaBadgeView f8926m;

    /* renamed from: n */
    int f8927n;

    /* renamed from: o */
    int f8928o;

    /* renamed from: p */
    int f8929p;

    /* renamed from: q */
    int f8930q;

    /* renamed from: r */
    int f8931r;

    /* renamed from: s */
    int f8932s;

    /* renamed from: t */
    private LinkClickListener f8933t;

    /* renamed from: u */
    private Uri f8934u;

    /* renamed from: a */
    protected abstract double mo4141a(int i);

    abstract int getLayout();

    abstract String getViewTypeName();

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractTweetView(Context context, AttributeSet attributeSet, int i, C2727a c2727a) {
        super(context, attributeSet, i);
        this.f8915b = c2727a;
        m4139a(context);
        mo4133b();
    }

    /* renamed from: a */
    private void m4139a(Context context) {
        LayoutInflater.from(context).inflate(getLayout(), (ViewGroup) this, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m4142a() {
        if (isInEditMode()) {
            return false;
        }
        try {
            this.f8915b.m4126a();
            return true;
        } catch (IllegalStateException e) {
            Twitter.m4253h().mo4557c("TweetUi", e.getMessage());
            setEnabled(false);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4133b() {
        this.f8921h = (TextView) findViewById(R.id.tw__tweet_author_full_name);
        this.f8922i = (TextView) findViewById(R.id.tw__tweet_author_screen_name);
        this.f8923j = (AspectRatioFrameLayout) findViewById(R.id.tw__aspect_ratio_media_container);
        this.f8924k = (TweetMediaView) findViewById(R.id.tweet_media_view);
        this.f8925l = (TextView) findViewById(R.id.tw__tweet_text);
        this.f8926m = (MediaBadgeView) findViewById(R.id.tw__tweet_media_badge);
    }

    public long getTweetId() {
        Tweet tweet = this.f8918e;
        if (tweet == null) {
            return -1L;
        }
        return tweet.f8739i;
    }

    public void setTweet(Tweet tweet) {
        this.f8918e = tweet;
        mo4132c();
    }

    public Tweet getTweet() {
        return this.f8918e;
    }

    public void setTweetMediaClickListener(TweetMediaClickListener tweetMediaClickListener) {
        this.f8917d = tweetMediaClickListener;
        this.f8924k.setTweetMediaClickListener(tweetMediaClickListener);
    }

    public void setTweetLinkClickListener(TweetLinkClickListener tweetLinkClickListener) {
        this.f8916c = tweetLinkClickListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo4132c() {
        Tweet m4089b = TweetUtils.m4089b(this.f8918e);
        setName(m4089b);
        setScreenName(m4089b);
        setTweetMedia(m4089b);
        setText(m4089b);
        setContentDescription(m4089b);
        if (TweetUtils.m4092a(this.f8918e)) {
            m4134a(this.f8918e.f8726D.screenName, Long.valueOf(getTweetId()));
        } else {
            this.f8934u = null;
        }
        m4127h();
        m4130e();
    }

    Uri getPermalinkUri() {
        return this.f8934u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m4134a(String str, Long l) {
        if (l.longValue() <= 0) {
            return;
        }
        this.f8934u = TweetUtils.m4090a(str, l.longValue());
    }

    /* renamed from: h */
    private void m4127h() {
        setOnClickListener(new View$OnClickListenerC2728b());
    }

    /* renamed from: d */
    void m4131d() {
        if (C2644g.m4563b(getContext(), new Intent("android.intent.action.VIEW", getPermalinkUri()))) {
            return;
        }
        Twitter.m4253h().mo4557c("TweetUi", "Activity cannot be found to open permalink URI");
    }

    /* renamed from: e */
    void m4130e() {
        if (this.f8918e != null) {
            this.f8915b.m4125b().mo3864a(this.f8918e, getViewTypeName(), this.f8920g);
        }
    }

    /* renamed from: f */
    void m4129f() {
        if (this.f8918e != null) {
            this.f8915b.m4125b().mo3865a(this.f8918e, getViewTypeName());
        }
    }

    /* renamed from: a */
    void m4135a(Long l, Card card) {
        this.f8915b.m4124c().mo4079a(ScribeItem.fromTweetCard(l.longValue(), card));
    }

    /* renamed from: a */
    void m4140a(long j, MediaEntity mediaEntity) {
        this.f8915b.m4124c().mo4079a(ScribeItem.fromMediaEntity(j, mediaEntity));
    }

    private void setName(Tweet tweet) {
        if (tweet != null && tweet.f8726D != null) {
            this.f8921h.setText(C2731af.m4083a(tweet.f8726D.name));
        } else {
            this.f8921h.setText("");
        }
    }

    private void setScreenName(Tweet tweet) {
        if (tweet != null && tweet.f8726D != null) {
            this.f8922i.setText(UserUtils.m4511a(C2731af.m4083a(tweet.f8726D.screenName)));
        } else {
            this.f8922i.setText("");
        }
    }

    @TargetApi(16)
    private void setText(Tweet tweet) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f8925l.setImportantForAccessibility(2);
        }
        CharSequence m4085a = C2731af.m4085a(m4136a(tweet));
        SpanClickHandler.m3951a(this.f8925l);
        if (!TextUtils.isEmpty(m4085a)) {
            this.f8925l.setText(m4085a);
            this.f8925l.setVisibility(0);
            return;
        }
        this.f8925l.setText("");
        this.f8925l.setVisibility(8);
    }

    final void setTweetMedia(Tweet tweet) {
        m4128g();
        if (tweet == null) {
            return;
        }
        if (tweet.f8730H != null && VineCardUtils.m4381a(tweet.f8730H)) {
            Card card = tweet.f8730H;
            ImageValue m4378d = VineCardUtils.m4378d(card);
            String m4379c = VineCardUtils.m4379c(card);
            if (m4378d == null || TextUtils.isEmpty(m4379c)) {
                return;
            }
            setViewsForMedia(m4137a(m4378d));
            this.f8924k.setVineCard(tweet);
            this.f8926m.setVisibility(0);
            this.f8926m.setCard(card);
            m4135a(Long.valueOf(tweet.f8739i), card);
        } else if (TweetMediaUtils.m3919e(tweet)) {
            MediaEntity m3921d = TweetMediaUtils.m3921d(tweet);
            setViewsForMedia(mo4138a(m3921d));
            this.f8924k.m4029a(this.f8918e, Collections.singletonList(m3921d));
            this.f8926m.setVisibility(0);
            this.f8926m.setMediaEntity(m3921d);
            m4140a(tweet.f8739i, m3921d);
        } else if (TweetMediaUtils.m3923c(tweet)) {
            List<MediaEntity> m3925b = TweetMediaUtils.m3925b(tweet);
            setViewsForMedia(mo4141a(m3925b.size()));
            this.f8924k.m4029a(tweet, m3925b);
            this.f8926m.setVisibility(8);
        }
    }

    void setViewsForMedia(double d) {
        this.f8923j.setVisibility(0);
        this.f8923j.setAspectRatio(d);
        this.f8924k.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public double mo4138a(MediaEntity mediaEntity) {
        if (mediaEntity == null || mediaEntity.sizes == null || mediaEntity.sizes.medium == null || mediaEntity.sizes.medium.f8703w == 0 || mediaEntity.sizes.medium.f8702h == 0) {
            return 1.7777777777777777d;
        }
        return mediaEntity.sizes.medium.f8703w / mediaEntity.sizes.medium.f8702h;
    }

    /* renamed from: a */
    protected double m4137a(ImageValue imageValue) {
        if (imageValue == null || imageValue.f8713b == 0 || imageValue.f8712a == 0) {
            return 1.7777777777777777d;
        }
        return imageValue.f8713b / imageValue.f8712a;
    }

    /* renamed from: g */
    protected void m4128g() {
        this.f8923j.setVisibility(8);
    }

    /* renamed from: a */
    protected CharSequence m4136a(Tweet tweet) {
        FormattedTweetText m3874a = this.f8915b.m4126a().m4095d().m3874a(tweet);
        if (m3874a == null) {
            return null;
        }
        return TweetTextLinkifier.m4115a(m3874a, getLinkClickListener(), this.f8929p, this.f8930q, TweetUtils.m4087c(tweet), tweet.f8730H != null && VineCardUtils.m4381a(tweet.f8730H));
    }

    void setContentDescription(Tweet tweet) {
        if (!TweetUtils.m4092a(tweet)) {
            setContentDescription(getResources().getString(R.string.tw__loading_tweet));
            return;
        }
        FormattedTweetText m3874a = this.f8915b.m4126a().m4095d().m3874a(tweet);
        String str = m3874a != null ? m3874a.f8955a : null;
        long m3884a = TweetDateUtils.m3884a(tweet.f8732b);
        setContentDescription(getResources().getString(R.string.tw__tweet_content_description, C2731af.m4083a(tweet.f8726D.name), C2731af.m4083a(str), C2731af.m4083a(m3884a != -1 ? DateFormat.getDateInstance().format(new Date(m3884a)) : null)));
    }

    protected LinkClickListener getLinkClickListener() {
        if (this.f8933t == null) {
            this.f8933t = new LinkClickListener() { // from class: com.twitter.sdk.android.tweetui.a.1
                @Override // com.twitter.sdk.android.tweetui.LinkClickListener
                /* renamed from: a */
                public void mo3915a(String str) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    if (AbstractTweetView.this.f8916c != null) {
                        AbstractTweetView.this.f8916c.m3878a(AbstractTweetView.this.f8918e, str);
                        return;
                    }
                    if (C2644g.m4563b(AbstractTweetView.this.getContext(), new Intent("android.intent.action.VIEW", Uri.parse(str)))) {
                        return;
                    }
                    Twitter.m4253h().mo4557c("TweetUi", "Activity cannot be found to open URL");
                }
            };
        }
        return this.f8933t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractTweetView.java */
    /* renamed from: com.twitter.sdk.android.tweetui.a$b */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC2728b implements View.OnClickListener {
        View$OnClickListenerC2728b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AbstractTweetView.this.getPermalinkUri() == null) {
                return;
            }
            AbstractTweetView.this.m4129f();
            AbstractTweetView.this.m4131d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractTweetView.java */
    /* renamed from: com.twitter.sdk.android.tweetui.a$a */
    /* loaded from: classes2.dex */
    public static class C2727a {

        /* renamed from: a */
        TweetScribeClient f8936a;

        /* renamed from: b */
        VideoScribeClient f8937b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public TweetUi m4126a() {
            return TweetUi.m4100a();
        }

        /* renamed from: b */
        TweetScribeClient m4125b() {
            if (this.f8936a == null) {
                this.f8936a = new TweetScribeClientImpl(m4126a());
            }
            return this.f8936a;
        }

        /* renamed from: c */
        VideoScribeClient m4124c() {
            if (this.f8937b == null) {
                this.f8937b = new VideoScribeClientImpl(m4126a());
            }
            return this.f8937b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: d */
        public Picasso m4123d() {
            return TweetUi.m4100a().m4094e();
        }
    }
}
