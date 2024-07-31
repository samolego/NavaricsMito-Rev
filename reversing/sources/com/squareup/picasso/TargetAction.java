package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.Picasso;

/* renamed from: com.squareup.picasso.x */
/* loaded from: classes2.dex */
final class TargetAction extends Action<InterfaceC2371w> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TargetAction(Picasso picasso, InterfaceC2371w interfaceC2371w, C2365q c2365q, int i, int i2, Drawable drawable, String str, Object obj, int i3) {
        super(picasso, interfaceC2371w, c2365q, i, i2, i3, drawable, str, obj, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.squareup.picasso.Action
    /* renamed from: a */
    public void mo5618a(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
        if (bitmap == null) {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", this));
        }
        InterfaceC2371w d = m5779d();
        if (d != null) {
            d.mo4059a(bitmap, loadedFrom);
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Target callback must not recycle bitmap!");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.squareup.picasso.Action
    /* renamed from: a */
    public void mo5619a() {
        InterfaceC2371w d = m5779d();
        if (d != null) {
            if (this.f6888g != 0) {
                d.mo4058a(this.f6882a.f6850c.getResources().getDrawable(this.f6888g));
            } else {
                d.mo4058a(this.f6889h);
            }
        }
    }
}
