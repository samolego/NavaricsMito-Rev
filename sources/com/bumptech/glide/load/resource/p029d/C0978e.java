package com.bumptech.glide.load.resource.p029d;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.resource.p027b.DrawableResource;

/* renamed from: com.bumptech.glide.load.resource.d.e */
/* loaded from: classes.dex */
public class GifDrawableResource extends DrawableResource<GifDrawable> implements Initializable {
    public GifDrawableResource(GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    /* renamed from: c */
    public Class<GifDrawable> mo11853c() {
        return GifDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    /* renamed from: e */
    public int mo11852e() {
        return ((GifDrawable) this.f1010a).m11870a();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    /* renamed from: f */
    public void mo11851f() {
        ((GifDrawable) this.f1010a).stop();
        ((GifDrawable) this.f1010a).m11864g();
    }

    @Override // com.bumptech.glide.load.resource.p027b.DrawableResource, com.bumptech.glide.load.engine.Initializable
    /* renamed from: a */
    public void mo11854a() {
        ((GifDrawable) this.f1010a).m11868b().prepareToDraw();
    }
}
