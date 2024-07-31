package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.twitter.sdk.android.core.internal.VineCardUtils;
import com.twitter.sdk.android.core.internal.scribe.ScribeItem;
import com.twitter.sdk.android.core.models.Card;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.tweetui.R;

/* loaded from: classes2.dex */
public class MediaBadgeView extends FrameLayout {

    /* renamed from: a */
    TextView f8974a;

    /* renamed from: b */
    ImageView f8975b;

    public MediaBadgeView(Context context) {
        this(context, null);
    }

    public MediaBadgeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MediaBadgeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4055a(context);
    }

    /* renamed from: a */
    void m4055a(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.tw__media_badge, (ViewGroup) this, true);
        this.f8974a = (TextView) inflate.findViewById(R.id.tw__video_duration);
        this.f8975b = (ImageView) inflate.findViewById(R.id.tw__gif_badge);
    }

    public void setMediaEntity(MediaEntity mediaEntity) {
        if (ScribeItem.MediaDetails.GIF_TYPE.equals(mediaEntity.type)) {
            setBadge(getResources().getDrawable(R.drawable.tw__gif_badge));
        } else if ("video".equals(mediaEntity.type)) {
            setText(mediaEntity.videoInfo == null ? 0L : mediaEntity.videoInfo.durationMillis);
        } else {
            m4056a();
        }
    }

    public void setCard(Card card) {
        if (VineCardUtils.m4381a(card)) {
            setBadge(getResources().getDrawable(R.drawable.tw__vine_badge));
        } else {
            m4056a();
        }
    }

    void setText(long j) {
        this.f8974a.setVisibility(0);
        this.f8975b.setVisibility(8);
        this.f8974a.setText(MediaTimeUtils.m3954a(j));
    }

    void setBadge(Drawable drawable) {
        this.f8975b.setVisibility(0);
        this.f8974a.setVisibility(8);
        this.f8975b.setImageDrawable(drawable);
    }

    /* renamed from: a */
    void m4056a() {
        this.f8974a.setVisibility(8);
        this.f8975b.setVisibility(8);
    }
}
