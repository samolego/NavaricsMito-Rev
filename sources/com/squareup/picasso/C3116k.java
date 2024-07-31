package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.squareup.picasso.k */
/* loaded from: classes2.dex */
public class ImageViewAction extends Action<ImageView> {

    /* renamed from: m */
    Callback f6953m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageViewAction(Picasso picasso, ImageView imageView, C2365q c2365q, int i, int i2, int i3, Drawable drawable, String str, Object obj, Callback callback, boolean z) {
        super(picasso, imageView, c2365q, i, i2, i3, drawable, str, obj, z);
        this.f6953m = callback;
    }

    @Override // com.squareup.picasso.Action
    /* renamed from: a */
    public void mo5618a(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
        if (bitmap == null) {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", this));
        }
        ImageView imageView = (ImageView) this.f6884c.get();
        if (imageView == null) {
            return;
        }
        PicassoDrawable.m5675a(imageView, this.f6882a.f6850c, bitmap, loadedFrom, this.f6885d, this.f6882a.f6858k);
        Callback callback = this.f6953m;
        if (callback != null) {
            callback.mo4021a();
        }
    }

    @Override // com.squareup.picasso.Action
    /* renamed from: a */
    public void mo5619a() {
        ImageView imageView = (ImageView) this.f6884c.get();
        if (imageView == null) {
            return;
        }
        if (this.f6888g != 0) {
            imageView.setImageResource(this.f6888g);
        } else if (this.f6889h != null) {
            imageView.setImageDrawable(this.f6889h);
        }
        Callback callback = this.f6953m;
        if (callback != null) {
            callback.mo4020b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.squareup.picasso.Action
    /* renamed from: b */
    public void mo5688b() {
        super.mo5688b();
        if (this.f6953m != null) {
            this.f6953m = null;
        }
    }
}
