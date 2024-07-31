package com.bumptech.glide.load.p020b.p021a;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.p020b.GlideUrl;
import com.bumptech.glide.load.p020b.ModelLoader;
import com.bumptech.glide.load.p020b.ModelLoaderFactory;
import com.bumptech.glide.load.p020b.MultiModelLoaderFactory;
import java.io.InputStream;
import java.net.URL;

/* renamed from: com.bumptech.glide.load.b.a.e */
/* loaded from: classes.dex */
public class UrlLoader implements ModelLoader<URL, InputStream> {

    /* renamed from: a */
    private final ModelLoader<GlideUrl, InputStream> f607a;

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public boolean mo7359a(@NonNull URL url) {
        return true;
    }

    public UrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        this.f607a = modelLoader;
    }

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public ModelLoader.C0656a<InputStream> mo7358a(@NonNull URL url, int i, int i2, @NonNull Options options) {
        return this.f607a.mo7358a(new GlideUrl(url), i, i2, options);
    }

    /* compiled from: UrlLoader.java */
    /* renamed from: com.bumptech.glide.load.b.a.e$a */
    /* loaded from: classes.dex */
    public static class C0629a implements ModelLoaderFactory<URL, InputStream> {
        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        /* renamed from: a */
        public void mo7357a() {
        }

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        @NonNull
        /* renamed from: a */
        public ModelLoader<URL, InputStream> mo7356a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UrlLoader(multiModelLoaderFactory.m12302b(GlideUrl.class, InputStream.class));
        }
    }
}
