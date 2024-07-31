package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.support.p008v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.C2644g;
import com.twitter.sdk.android.core.internal.VineCardUtils;
import com.twitter.sdk.android.core.internal.scribe.ScribeItem;
import com.twitter.sdk.android.core.models.Card;
import com.twitter.sdk.android.core.models.ImageValue;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.GalleryActivity;
import com.twitter.sdk.android.tweetui.PlayerActivity;
import com.twitter.sdk.android.tweetui.R;
import com.twitter.sdk.android.tweetui.TweetMediaClickListener;
import com.twitter.sdk.android.tweetui.TweetUi;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class TweetMediaView extends ViewGroup implements View.OnClickListener {

    /* renamed from: a */
    final float[] f8992a;

    /* renamed from: b */
    int f8993b;

    /* renamed from: c */
    int f8994c;

    /* renamed from: d */
    final C2736a f8995d;

    /* renamed from: e */
    boolean f8996e;

    /* renamed from: f */
    TweetMediaClickListener f8997f;

    /* renamed from: g */
    Tweet f8998g;

    /* renamed from: h */
    private final OverlayImageView[] f8999h;

    /* renamed from: i */
    private List<MediaEntity> f9000i;

    /* renamed from: j */
    private final Path f9001j;

    /* renamed from: k */
    private final RectF f9002k;

    /* renamed from: l */
    private final int f9003l;

    /* renamed from: m */
    private int f9004m;

    public TweetMediaView(Context context) {
        this(context, null);
    }

    public TweetMediaView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, new C2736a());
    }

    TweetMediaView(Context context, AttributeSet attributeSet, C2736a c2736a) {
        super(context, attributeSet);
        this.f8999h = new OverlayImageView[4];
        this.f9000i = Collections.emptyList();
        this.f9001j = new Path();
        this.f9002k = new RectF();
        this.f8992a = new float[8];
        this.f8993b = ViewCompat.MEASURED_STATE_MASK;
        this.f8995d = c2736a;
        this.f9003l = getResources().getDimensionPixelSize(R.dimen.tw__media_view_divider_size);
        this.f8994c = R.drawable.tw__ic_tweet_photo_error_dark;
    }

    /* renamed from: a */
    public void m4035a(int i, int i2, int i3, int i4) {
        float[] fArr = this.f8992a;
        float f = i;
        fArr[0] = f;
        fArr[1] = f;
        float f2 = i2;
        fArr[2] = f2;
        fArr[3] = f2;
        float f3 = i3;
        fArr[4] = f3;
        fArr[5] = f3;
        float f4 = i4;
        fArr[6] = f4;
        fArr[7] = f4;
        requestLayout();
    }

    public void setMediaBgColor(int i) {
        this.f8993b = i;
    }

    public void setTweetMediaClickListener(TweetMediaClickListener tweetMediaClickListener) {
        this.f8997f = tweetMediaClickListener;
    }

    public void setPhotoErrorResId(int i) {
        this.f8994c = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f9004m > 0) {
            m4039a();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        C2738c c2738c;
        if (this.f9004m > 0) {
            c2738c = m4037a(i, i2);
        } else {
            c2738c = C2738c.f9006a;
        }
        setMeasuredDimension(c2738c.f9007b, c2738c.f9008c);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f9001j.reset();
        this.f9002k.set(0.0f, 0.0f, i, i2);
        this.f9001j.addRoundRect(this.f9002k, this.f8992a, Path.Direction.CW);
        this.f9001j.close();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.f8996e && Build.VERSION.SDK_INT >= 18) {
            int save = canvas.save();
            canvas.clipPath(this.f9001j);
            super.dispatchDraw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer num = (Integer) view.getTag(R.id.tw__entity_index);
        if (this.f8997f != null) {
            this.f8997f.m3877a(this.f8998g, !this.f9000i.isEmpty() ? this.f9000i.get(num.intValue()) : null);
        } else if (!this.f9000i.isEmpty()) {
            MediaEntity mediaEntity = this.f9000i.get(num.intValue());
            if (TweetMediaUtils.m3926b(mediaEntity)) {
                m4032a(mediaEntity);
            } else if (TweetMediaUtils.m3929a(mediaEntity)) {
                m4038a(num.intValue());
            }
        } else {
            m4030a(this.f8998g);
        }
    }

    /* renamed from: a */
    public void m4032a(MediaEntity mediaEntity) {
        if (TweetMediaUtils.m3924c(mediaEntity) != null) {
            Intent intent = new Intent(getContext(), PlayerActivity.class);
            intent.putExtra("PLAYER_ITEM", new PlayerActivity.PlayerItem(TweetMediaUtils.m3924c(mediaEntity).url, TweetMediaUtils.m3922d(mediaEntity), TweetMediaUtils.m3920e(mediaEntity), null, null));
            C2644g.m4563b(getContext(), intent);
        }
    }

    /* renamed from: a */
    public void m4030a(Tweet tweet) {
        Card card = tweet.f8730H;
        Intent intent = new Intent(getContext(), PlayerActivity.class);
        intent.putExtra("PLAYER_ITEM", new PlayerActivity.PlayerItem(VineCardUtils.m4379c(card), true, false, null, null));
        intent.putExtra("SCRIBE_ITEM", ScribeItem.fromTweetCard(tweet.f8739i, card));
        C2644g.m4563b(getContext(), intent);
    }

    /* renamed from: a */
    public void m4038a(int i) {
        Intent intent = new Intent(getContext(), GalleryActivity.class);
        intent.putExtra("GALLERY_ITEM", new GalleryActivity.GalleryItem(this.f8998g.f8739i, i, this.f9000i));
        C2644g.m4563b(getContext(), intent);
    }

    /* renamed from: a */
    public void m4029a(Tweet tweet, List<MediaEntity> list) {
        if (tweet == null || list == null || list.isEmpty() || list.equals(this.f9000i)) {
            return;
        }
        this.f8998g = tweet;
        this.f9000i = list;
        m4026b();
        m4027a(list);
        if (TweetMediaUtils.m3929a(list.get(0))) {
            this.f8996e = true;
        } else {
            this.f8996e = false;
        }
        requestLayout();
    }

    public void setVineCard(Tweet tweet) {
        if (tweet == null || tweet.f8730H == null || !VineCardUtils.m4381a(tweet.f8730H)) {
            return;
        }
        this.f8998g = tweet;
        this.f9000i = Collections.emptyList();
        m4026b();
        m4031a(tweet.f8730H);
        this.f8996e = false;
        requestLayout();
    }

    /* renamed from: a */
    C2738c m4037a(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i3 = this.f9003l;
        int i4 = (size - i3) / 2;
        int i5 = (size2 - i3) / 2;
        switch (this.f9004m) {
            case 1:
                m4036a(0, size, size2);
                break;
            case 2:
                m4036a(0, i4, size2);
                m4036a(1, i4, size2);
                break;
            case 3:
                m4036a(0, i4, size2);
                m4036a(1, i4, i5);
                m4036a(2, i4, i5);
                break;
            case 4:
                m4036a(0, i4, i5);
                m4036a(1, i4, i5);
                m4036a(2, i4, i5);
                m4036a(3, i4, i5);
                break;
        }
        return C2738c.m4019a(size, size2);
    }

    /* renamed from: a */
    void m4036a(int i, int i2, int i3) {
        this.f8999h[i].measure(View.MeasureSpec.makeMeasureSpec(i2, 1073741824), View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
    }

    /* renamed from: a */
    void m4039a() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int i = this.f9003l;
        int i2 = (measuredWidth - i) / 2;
        int i3 = (measuredHeight - i) / 2;
        int i4 = i2 + i;
        switch (this.f9004m) {
            case 1:
                m4034a(0, 0, 0, measuredWidth, measuredHeight);
                return;
            case 2:
                m4034a(0, 0, 0, i2, measuredHeight);
                m4034a(1, i2 + this.f9003l, 0, measuredWidth, measuredHeight);
                return;
            case 3:
                m4034a(0, 0, 0, i2, measuredHeight);
                m4034a(1, i4, 0, measuredWidth, i3);
                m4034a(2, i4, i3 + this.f9003l, measuredWidth, measuredHeight);
                return;
            case 4:
                m4034a(0, 0, 0, i2, i3);
                m4034a(2, 0, i3 + this.f9003l, i2, measuredHeight);
                m4034a(1, i4, 0, measuredWidth, i3);
                m4034a(3, i4, i3 + this.f9003l, measuredWidth, measuredHeight);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    void m4034a(int i, int i2, int i3, int i4, int i5) {
        OverlayImageView overlayImageView = this.f8999h[i];
        if (overlayImageView.getLeft() == i2 && overlayImageView.getTop() == i3 && overlayImageView.getRight() == i4 && overlayImageView.getBottom() == i5) {
            return;
        }
        overlayImageView.layout(i2, i3, i4, i5);
    }

    /* renamed from: b */
    void m4026b() {
        for (int i = 0; i < this.f9004m; i++) {
            OverlayImageView overlayImageView = this.f8999h[i];
            if (overlayImageView != null) {
                overlayImageView.setVisibility(8);
            }
        }
        this.f9004m = 0;
    }

    /* renamed from: a */
    void m4027a(List<MediaEntity> list) {
        this.f9004m = Math.min(4, list.size());
        for (int i = 0; i < this.f9004m; i++) {
            OverlayImageView m4025b = m4025b(i);
            MediaEntity mediaEntity = list.get(i);
            m4033a(m4025b, mediaEntity.altText);
            m4024b(m4025b, m4023b(mediaEntity));
            m4028a(m4025b, TweetMediaUtils.m3926b(mediaEntity));
        }
    }

    /* renamed from: a */
    void m4031a(Card card) {
        this.f9004m = 1;
        OverlayImageView m4025b = m4025b(0);
        ImageValue m4378d = VineCardUtils.m4378d(card);
        m4033a(m4025b, m4378d.f8715d);
        m4024b(m4025b, m4378d.f8714c);
        m4028a(m4025b, true);
    }

    /* renamed from: b */
    OverlayImageView m4025b(int i) {
        OverlayImageView overlayImageView = this.f8999h[i];
        if (overlayImageView == null) {
            overlayImageView = new OverlayImageView(getContext());
            overlayImageView.setLayoutParams(generateDefaultLayoutParams());
            overlayImageView.setOnClickListener(this);
            this.f8999h[i] = overlayImageView;
            addView(overlayImageView, i);
        } else {
            m4036a(i, 0, 0);
            m4034a(i, 0, 0, 0, 0);
        }
        overlayImageView.setVisibility(0);
        overlayImageView.setBackgroundColor(this.f8993b);
        overlayImageView.setTag(R.id.tw__entity_index, Integer.valueOf(i));
        return overlayImageView;
    }

    /* renamed from: b */
    String m4023b(MediaEntity mediaEntity) {
        if (this.f9004m > 1) {
            return mediaEntity.mediaUrlHttps + ":small";
        }
        return mediaEntity.mediaUrlHttps;
    }

    /* renamed from: a */
    void m4033a(ImageView imageView, String str) {
        if (!TextUtils.isEmpty(str)) {
            imageView.setContentDescription(str);
        } else {
            imageView.setContentDescription(getResources().getString(R.string.tw__tweet_media));
        }
    }

    /* renamed from: a */
    void m4028a(OverlayImageView overlayImageView, boolean z) {
        if (z) {
            overlayImageView.setOverlayDrawable(getContext().getResources().getDrawable(R.drawable.tw__player_overlay));
        } else {
            overlayImageView.setOverlayDrawable(null);
        }
    }

    /* renamed from: b */
    void m4024b(ImageView imageView, String str) {
        Picasso m4022a = this.f8995d.m4022a();
        if (m4022a == null) {
            return;
        }
        m4022a.m5787a(str).m5658a().m5649c().m5657a(this.f8994c).m5652a(imageView, new C2737b(imageView));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.twitter.sdk.android.tweetui.internal.TweetMediaView$b */
    /* loaded from: classes2.dex */
    public static class C2737b implements Callback {

        /* renamed from: a */
        final WeakReference<ImageView> f9005a;

        @Override // com.squareup.picasso.Callback
        /* renamed from: b */
        public void mo4020b() {
        }

        C2737b(ImageView imageView) {
            this.f9005a = new WeakReference<>(imageView);
        }

        @Override // com.squareup.picasso.Callback
        /* renamed from: a */
        public void mo4021a() {
            ImageView imageView = this.f9005a.get();
            if (imageView != null) {
                imageView.setBackgroundResource(17170445);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.twitter.sdk.android.tweetui.internal.TweetMediaView$c */
    /* loaded from: classes2.dex */
    public static class C2738c {

        /* renamed from: a */
        static final C2738c f9006a = new C2738c();

        /* renamed from: b */
        final int f9007b;

        /* renamed from: c */
        final int f9008c;

        private C2738c() {
            this(0, 0);
        }

        private C2738c(int i, int i2) {
            this.f9007b = i;
            this.f9008c = i2;
        }

        /* renamed from: a */
        static C2738c m4019a(int i, int i2) {
            int max = Math.max(i, 0);
            int max2 = Math.max(i2, 0);
            return (max == 0 && max2 == 0) ? f9006a : new C2738c(max, max2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.twitter.sdk.android.tweetui.internal.TweetMediaView$a */
    /* loaded from: classes2.dex */
    public static class C2736a {
        C2736a() {
        }

        /* renamed from: a */
        Picasso m4022a() {
            return TweetUi.m4100a().m4094e();
        }
    }
}
