package com.bumptech.glide.load.resource.p027b;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.p029d.GifDrawable;
import com.bumptech.glide.util.Preconditions;

/* renamed from: com.bumptech.glide.load.resource.b.b */
/* loaded from: classes.dex */
public abstract class DrawableResource<T extends Drawable> implements Initializable, Resource<T> {

    /* renamed from: a */
    protected final T f1010a;

    public DrawableResource(T t) {
        this.f1010a = (T) Preconditions.m11580a(t);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    /* renamed from: b */
    public final T mo11898d() {
        Drawable.ConstantState constantState = this.f1010a.getConstantState();
        if (constantState == null) {
            return this.f1010a;
        }
        return (T) constantState.newDrawable();
    }

    @Override // com.bumptech.glide.load.engine.Initializable
    /* renamed from: a */
    public void mo11854a() {
        T t = this.f1010a;
        if (t instanceof BitmapDrawable) {
            ((BitmapDrawable) t).getBitmap().prepareToDraw();
        } else if (t instanceof GifDrawable) {
            ((GifDrawable) t).m11868b().prepareToDraw();
        }
    }
}
