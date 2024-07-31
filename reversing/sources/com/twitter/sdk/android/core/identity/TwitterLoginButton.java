package com.twitter.sdk.android.core.identity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import com.twitter.sdk.android.core.AbstractC2641c;
import com.twitter.sdk.android.core.R;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.internal.CommonUtils;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class TwitterLoginButton extends Button {

    /* renamed from: a */
    final WeakReference<Activity> f8456a;

    /* renamed from: b */
    volatile TwitterAuthClient f8457b;

    /* renamed from: c */
    View.OnClickListener f8458c;

    /* renamed from: d */
    AbstractC2641c<TwitterSession> f8459d;

    public TwitterLoginButton(Context context) {
        this(context, null);
    }

    public TwitterLoginButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842824);
    }

    public TwitterLoginButton(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    TwitterLoginButton(Context context, AttributeSet attributeSet, int i, TwitterAuthClient twitterAuthClient) {
        super(context, attributeSet, i);
        this.f8456a = new WeakReference<>(getActivity());
        this.f8457b = twitterAuthClient;
        m4548a();
        m4547b();
    }

    @TargetApi(21)
    /* renamed from: a */
    private void m4548a() {
        Resources resources = getResources();
        super.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(R.drawable.tw__ic_logo_default), (Drawable) null, (Drawable) null, (Drawable) null);
        super.setCompoundDrawablePadding(resources.getDimensionPixelSize(R.dimen.tw__login_btn_drawable_padding));
        super.setText(R.string.tw__login_btn_txt);
        super.setTextColor(resources.getColor(R.color.tw__solid_white));
        super.setTextSize(0, resources.getDimensionPixelSize(R.dimen.tw__login_btn_text_size));
        super.setTypeface(Typeface.DEFAULT_BOLD);
        super.setPadding(resources.getDimensionPixelSize(R.dimen.tw__login_btn_left_padding), 0, resources.getDimensionPixelSize(R.dimen.tw__login_btn_right_padding), 0);
        super.setBackgroundResource(R.drawable.tw__login_btn);
        super.setOnClickListener(new View$OnClickListenerC2647a());
        if (Build.VERSION.SDK_INT >= 21) {
            super.setAllCaps(false);
        }
    }

    public void setCallback(AbstractC2641c<TwitterSession> abstractC2641c) {
        if (abstractC2641c == null) {
            throw new IllegalArgumentException("Callback cannot be null");
        }
        this.f8459d = abstractC2641c;
    }

    public AbstractC2641c<TwitterSession> getCallback() {
        return this.f8459d;
    }

    protected Activity getActivity() {
        if (getContext() instanceof Activity) {
            return (Activity) getContext();
        }
        if (isInEditMode()) {
            return null;
        }
        throw new IllegalStateException("TwitterLoginButton requires an activity. Override getActivity to provide the activity for this button.");
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f8458c = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.twitter.sdk.android.core.identity.TwitterLoginButton$a */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC2647a implements View.OnClickListener {
        private View$OnClickListenerC2647a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            m4545a(TwitterLoginButton.this.f8459d);
            m4546a(TwitterLoginButton.this.f8456a.get());
            TwitterLoginButton.this.getTwitterAuthClient().m4518a(TwitterLoginButton.this.f8456a.get(), TwitterLoginButton.this.f8459d);
            if (TwitterLoginButton.this.f8458c != null) {
                TwitterLoginButton.this.f8458c.onClick(view);
            }
        }

        /* renamed from: a */
        private void m4545a(AbstractC2641c abstractC2641c) {
            if (abstractC2641c == null) {
                CommonUtils.m4447a("Twitter", "Callback must not be null, did you call setCallback?");
            }
        }

        /* renamed from: a */
        private void m4546a(Activity activity) {
            if (activity == null || activity.isFinishing()) {
                CommonUtils.m4447a("Twitter", "TwitterLoginButton requires an activity. Override getActivity to provide the activity for this button.");
            }
        }
    }

    TwitterAuthClient getTwitterAuthClient() {
        if (this.f8457b == null) {
            synchronized (TwitterLoginButton.class) {
                if (this.f8457b == null) {
                    this.f8457b = new TwitterAuthClient();
                }
            }
        }
        return this.f8457b;
    }

    /* renamed from: b */
    private void m4547b() {
        if (isInEditMode()) {
            return;
        }
        try {
            TwitterCore.m4230a();
        } catch (IllegalStateException e) {
            Twitter.m4253h().mo4557c("Twitter", e.getMessage());
            setEnabled(false);
        }
    }
}
