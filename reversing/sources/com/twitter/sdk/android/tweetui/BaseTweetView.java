package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.p008v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.AbstractC2641c;
import com.twitter.sdk.android.core.C2644g;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.internal.UserUtils;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.TweetBuilder;
import com.twitter.sdk.android.tweetui.AbstractTweetView;
import java.util.Locale;

/* loaded from: classes2.dex */
public abstract class BaseTweetView extends AbstractTweetView {

    /* renamed from: A */
    View f8876A;

    /* renamed from: B */
    int f8877B;

    /* renamed from: C */
    int f8878C;

    /* renamed from: D */
    int f8879D;

    /* renamed from: E */
    ColorDrawable f8880E;

    /* renamed from: t */
    TextView f8881t;

    /* renamed from: u */
    TweetActionBarView f8882u;

    /* renamed from: v */
    ImageView f8883v;

    /* renamed from: w */
    TextView f8884w;

    /* renamed from: x */
    ImageView f8885x;

    /* renamed from: y */
    ViewGroup f8886y;

    /* renamed from: z */
    QuoteTweetView f8887z;

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

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseTweetView(Context context, Tweet tweet, int i) {
        this(context, tweet, i, new AbstractTweetView.C2727a());
    }

    BaseTweetView(Context context, Tweet tweet, int i, AbstractTweetView.C2727a c2727a) {
        super(context, null, i, c2727a);
        m4163b(i);
        mo4158h();
        if (m4142a()) {
            m4159j();
            setTweet(tweet);
        }
    }

    public BaseTweetView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseTweetView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, new AbstractTweetView.C2727a());
        m4164a(context, attributeSet);
        mo4158h();
    }

    /* renamed from: b */
    private void m4163b(int i) {
        this.f8919f = i;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(i, R.styleable.tw__TweetView);
        try {
            setStyleAttributes(obtainStyledAttributes);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: a */
    private void m4164a(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.tw__TweetView, 0, 0);
        try {
            setXmlDataAttributes(obtainStyledAttributes);
            setStyleAttributes(obtainStyledAttributes);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void setXmlDataAttributes(TypedArray typedArray) {
        long longValue = C2731af.m4082a(typedArray.getString(R.styleable.tw__TweetView_tw__tweet_id), -1L).longValue();
        if (longValue <= 0) {
            throw new IllegalArgumentException("Invalid tw__tweet_id");
        }
        m4134a((String) null, Long.valueOf(longValue));
        this.f8918e = new TweetBuilder().m4245a(longValue).m4246a();
    }

    private void setStyleAttributes(TypedArray typedArray) {
        this.f8877B = typedArray.getColor(R.styleable.tw__TweetView_tw__container_bg_color, getResources().getColor(R.color.tw__tweet_light_container_bg_color));
        this.f8927n = typedArray.getColor(R.styleable.tw__TweetView_tw__primary_text_color, getResources().getColor(R.color.tw__tweet_light_primary_text_color));
        this.f8929p = typedArray.getColor(R.styleable.tw__TweetView_tw__action_color, getResources().getColor(R.color.tw__tweet_action_color));
        this.f8930q = typedArray.getColor(R.styleable.tw__TweetView_tw__action_highlight_color, getResources().getColor(R.color.tw__tweet_action_light_highlight_color));
        this.f8920g = typedArray.getBoolean(R.styleable.tw__TweetView_tw__tweet_actions_enabled, false);
        boolean m4074a = ColorUtils.m4074a(this.f8877B);
        if (m4074a) {
            this.f8932s = R.drawable.tw__ic_tweet_photo_error_light;
            this.f8878C = R.drawable.tw__ic_logo_blue;
            this.f8879D = R.drawable.tw__ic_retweet_light;
        } else {
            this.f8932s = R.drawable.tw__ic_tweet_photo_error_dark;
            this.f8878C = R.drawable.tw__ic_logo_white;
            this.f8879D = R.drawable.tw__ic_retweet_dark;
        }
        this.f8928o = ColorUtils.m4075a(m4074a ? 0.4d : 0.35d, m4074a ? -1 : ViewCompat.MEASURED_STATE_MASK, this.f8927n);
        this.f8931r = ColorUtils.m4075a(m4074a ? 0.08d : 0.12d, m4074a ? ViewCompat.MEASURED_STATE_MASK : -1, this.f8877B);
        this.f8880E = new ColorDrawable(this.f8931r);
    }

    /* renamed from: i */
    private void m4160i() {
        final long tweetId = getTweetId();
        this.f8915b.m4126a().m4095d().m3869c(getTweetId(), new AbstractC2641c<Tweet>() { // from class: com.twitter.sdk.android.tweetui.BaseTweetView.1
            @Override // com.twitter.sdk.android.core.AbstractC2641c
            /* renamed from: a */
            public void mo3867a(Result<Tweet> result) {
                BaseTweetView.this.setTweet(result.f8688a);
            }

            @Override // com.twitter.sdk.android.core.AbstractC2641c
            /* renamed from: a */
            public void mo3868a(TwitterException twitterException) {
                Twitter.m4253h().mo4561a("TweetUi", String.format(Locale.ENGLISH, "loadTweet failure for Tweet Id %d.", Long.valueOf(tweetId)));
            }
        });
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (m4142a()) {
            m4159j();
            m4160i();
        }
    }

    /* renamed from: j */
    private void m4159j() {
        setTweetActionsEnabled(this.f8920g);
        this.f8882u.setOnActionCallback(new ResetTweetCallback(this, this.f8915b.m4126a().m4095d(), null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    /* renamed from: b */
    public void mo4133b() {
        super.mo4133b();
        this.f8885x = (ImageView) findViewById(R.id.tw__tweet_author_avatar);
        this.f8884w = (TextView) findViewById(R.id.tw__tweet_timestamp);
        this.f8883v = (ImageView) findViewById(R.id.tw__twitter_logo);
        this.f8881t = (TextView) findViewById(R.id.tw__tweet_retweeted_by);
        this.f8882u = (TweetActionBarView) findViewById(R.id.tw__tweet_action_bar);
        this.f8886y = (ViewGroup) findViewById(R.id.quote_tweet_holder);
        this.f8876A = findViewById(R.id.bottom_separator);
    }

    public void setOnActionCallback(AbstractC2641c<Tweet> abstractC2641c) {
        this.f8882u.setOnActionCallback(new ResetTweetCallback(this, this.f8915b.m4126a().m4095d(), abstractC2641c));
        this.f8882u.setTweet(this.f8918e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    /* renamed from: c */
    public void mo4132c() {
        super.mo4132c();
        Tweet m4089b = TweetUtils.m4089b(this.f8918e);
        setProfilePhotoView(m4089b);
        m4161c(m4089b);
        setTimestamp(m4089b);
        setTweetActions(this.f8918e);
        m4162b(this.f8918e);
        setQuoteTweet(this.f8918e);
    }

    void setQuoteTweet(Tweet tweet) {
        this.f8887z = null;
        this.f8886y.removeAllViews();
        if (tweet != null && TweetUtils.m4087c(tweet)) {
            this.f8887z = new QuoteTweetView(getContext());
            this.f8887z.m4149a(this.f8927n, this.f8928o, this.f8929p, this.f8930q, this.f8931r, this.f8932s);
            this.f8887z.setTweet(tweet.f8752v);
            this.f8887z.setTweetLinkClickListener(this.f8916c);
            this.f8887z.setTweetMediaClickListener(this.f8917d);
            this.f8886y.setVisibility(0);
            this.f8886y.addView(this.f8887z);
            return;
        }
        this.f8886y.setVisibility(8);
    }

    /* renamed from: b */
    void m4162b(Tweet tweet) {
        if (tweet == null || tweet.f8755y == null) {
            this.f8881t.setVisibility(8);
            return;
        }
        this.f8881t.setText(getResources().getString(R.string.tw__retweeted_by_format, tweet.f8726D.name));
        this.f8881t.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public void mo4158h() {
        setBackgroundColor(this.f8877B);
        this.f8921h.setTextColor(this.f8927n);
        this.f8922i.setTextColor(this.f8928o);
        this.f8925l.setTextColor(this.f8927n);
        this.f8924k.setMediaBgColor(this.f8931r);
        this.f8924k.setPhotoErrorResId(this.f8932s);
        this.f8885x.setImageDrawable(this.f8880E);
        this.f8884w.setTextColor(this.f8928o);
        this.f8883v.setImageResource(this.f8878C);
        this.f8881t.setTextColor(this.f8928o);
    }

    private void setTimestamp(Tweet tweet) {
        String str;
        if (tweet == null || tweet.f8732b == null || !TweetDateUtils.m3883b(tweet.f8732b)) {
            str = "";
        } else {
            str = TweetDateUtils.m3882c(TweetDateUtils.m3885a(getResources(), System.currentTimeMillis(), Long.valueOf(TweetDateUtils.m3884a(tweet.f8732b)).longValue()));
        }
        this.f8884w.setText(str);
    }

    void setProfilePhotoView(Tweet tweet) {
        Picasso m4123d = this.f8915b.m4123d();
        if (m4123d == null) {
            return;
        }
        m4123d.m5787a((tweet == null || tweet.f8726D == null) ? null : UserUtils.m4512a(tweet.f8726D, UserUtils.AvatarSize.REASONABLY_SMALL)).m5654a(this.f8880E).m5653a(this.f8885x);
    }

    /* renamed from: c */
    void m4161c(final Tweet tweet) {
        if (tweet == null || tweet.f8726D == null) {
            return;
        }
        this.f8885x.setOnClickListener(new View.OnClickListener() { // from class: com.twitter.sdk.android.tweetui.BaseTweetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BaseTweetView.this.f8916c != null) {
                    TweetLinkClickListener tweetLinkClickListener = BaseTweetView.this.f8916c;
                    Tweet tweet2 = tweet;
                    tweetLinkClickListener.m3878a(tweet2, TweetUtils.m4091a(tweet2.f8726D.screenName));
                    return;
                }
                if (C2644g.m4563b(BaseTweetView.this.getContext(), new Intent("android.intent.action.VIEW", Uri.parse(TweetUtils.m4091a(tweet.f8726D.screenName))))) {
                    return;
                }
                Twitter.m4253h().mo4557c("TweetUi", "Activity cannot be found to open URL");
            }
        });
        this.f8885x.setOnTouchListener(new View.OnTouchListener() { // from class: com.twitter.sdk.android.tweetui.BaseTweetView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ImageView imageView = (ImageView) view;
                int action = motionEvent.getAction();
                if (action != 3) {
                    switch (action) {
                        case 0:
                            imageView.getDrawable().setColorFilter(BaseTweetView.this.getResources().getColor(R.color.tw__black_opacity_10), PorterDuff.Mode.SRC_ATOP);
                            imageView.invalidate();
                            return false;
                        case 1:
                            view.performClick();
                            break;
                        default:
                            return false;
                    }
                }
                imageView.getDrawable().clearColorFilter();
                imageView.invalidate();
                return false;
            }
        });
    }

    void setTweetActions(Tweet tweet) {
        this.f8882u.setTweet(tweet);
    }

    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    public void setTweetMediaClickListener(TweetMediaClickListener tweetMediaClickListener) {
        super.setTweetMediaClickListener(tweetMediaClickListener);
        QuoteTweetView quoteTweetView = this.f8887z;
        if (quoteTweetView != null) {
            quoteTweetView.setTweetMediaClickListener(tweetMediaClickListener);
        }
    }

    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    public void setTweetLinkClickListener(TweetLinkClickListener tweetLinkClickListener) {
        super.setTweetLinkClickListener(tweetLinkClickListener);
        QuoteTweetView quoteTweetView = this.f8887z;
        if (quoteTweetView != null) {
            quoteTweetView.setTweetLinkClickListener(tweetLinkClickListener);
        }
    }

    public void setTweetActionsEnabled(boolean z) {
        this.f8920g = z;
        if (this.f8920g) {
            this.f8882u.setVisibility(0);
            this.f8876A.setVisibility(8);
            return;
        }
        this.f8882u.setVisibility(8);
        this.f8876A.setVisibility(0);
    }
}
