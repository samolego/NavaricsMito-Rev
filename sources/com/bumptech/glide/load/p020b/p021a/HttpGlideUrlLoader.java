package com.bumptech.glide.load.p020b.p021a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.p018a.HttpUrlFetcher;
import com.bumptech.glide.load.p020b.GlideUrl;
import com.bumptech.glide.load.p020b.ModelCache;
import com.bumptech.glide.load.p020b.ModelLoader;
import com.bumptech.glide.load.p020b.ModelLoaderFactory;
import com.bumptech.glide.load.p020b.MultiModelLoaderFactory;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.b.a.a */
/* loaded from: classes.dex */
public class HttpGlideUrlLoader implements ModelLoader<GlideUrl, InputStream> {

    /* renamed from: a */
    public static final Option<Integer> f598a = Option.m12279a("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);
    @Nullable

    /* renamed from: b */
    private final ModelCache<GlideUrl, GlideUrl> f599b;

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public boolean mo7359a(@NonNull GlideUrl glideUrl) {
        return true;
    }

    public HttpGlideUrlLoader() {
        this(null);
    }

    public HttpGlideUrlLoader(@Nullable ModelCache<GlideUrl, GlideUrl> modelCache) {
        this.f599b = modelCache;
    }

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public ModelLoader.C0656a<InputStream> mo7358a(@NonNull GlideUrl glideUrl, int i, int i2, @NonNull Options options) {
        ModelCache<GlideUrl, GlideUrl> modelCache = this.f599b;
        if (modelCache != null) {
            GlideUrl m12327a = modelCache.m12327a(glideUrl, 0, 0);
            if (m12327a == null) {
                this.f599b.m12326a(glideUrl, 0, 0, glideUrl);
            } else {
                glideUrl = m12327a;
            }
        }
        return new ModelLoader.C0656a<>(glideUrl, new HttpUrlFetcher(glideUrl, ((Integer) options.m12014a(f598a)).intValue()));
    }

    /* compiled from: HttpGlideUrlLoader.java */
    /* renamed from: com.bumptech.glide.load.b.a.a$a */
    /* loaded from: classes.dex */
    public static class C0625a implements ModelLoaderFactory<GlideUrl, InputStream> {

        /* renamed from: a */
        private final ModelCache<GlideUrl, GlideUrl> f600a = new ModelCache<>(500);

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        /* renamed from: a */
        public void mo7357a() {
        }

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        @NonNull
        /* renamed from: a */
        public ModelLoader<GlideUrl, InputStream> mo7356a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new HttpGlideUrlLoader(this.f600a);
        }
    }
}
