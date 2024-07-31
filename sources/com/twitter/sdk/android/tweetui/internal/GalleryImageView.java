package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.squareup.picasso.InterfaceC2371w;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener;

/* loaded from: classes2.dex */
public class GalleryImageView extends FrameLayout implements InterfaceC2371w {

    /* renamed from: a */
    final MultiTouchImageView f8972a;

    /* renamed from: b */
    final ProgressBar f8973b;

    @Override // com.squareup.picasso.InterfaceC2371w
    /* renamed from: a */
    public void mo4058a(Drawable drawable) {
    }

    public GalleryImageView(Context context) {
        this(context, new MultiTouchImageView(context), new ProgressBar(context));
    }

    GalleryImageView(Context context, MultiTouchImageView multiTouchImageView, ProgressBar progressBar) {
        super(context);
        this.f8972a = multiTouchImageView;
        this.f8973b = progressBar;
        progressBar.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        addView(progressBar);
        multiTouchImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        addView(multiTouchImageView);
    }

    public void setSwipeToDismissCallback(SwipeToDismissTouchListener.InterfaceC2759a interfaceC2759a) {
        this.f8972a.setOnTouchListener(SwipeToDismissTouchListener.m3938a(this.f8972a, interfaceC2759a));
    }

    @Override // com.squareup.picasso.InterfaceC2371w
    /* renamed from: a */
    public void mo4059a(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
        this.f8972a.setImageBitmap(bitmap);
        this.f8973b.setVisibility(8);
    }

    @Override // com.squareup.picasso.InterfaceC2371w
    /* renamed from: b */
    public void mo4057b(Drawable drawable) {
        this.f8972a.setImageResource(17170445);
        this.f8973b.setVisibility(0);
    }
}
