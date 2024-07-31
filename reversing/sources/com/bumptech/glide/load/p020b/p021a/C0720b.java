package com.bumptech.glide.load.p020b.p021a;

import android.net.Uri;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.p020b.GlideUrl;
import com.bumptech.glide.load.p020b.ModelLoader;
import com.bumptech.glide.load.p020b.ModelLoaderFactory;
import com.bumptech.glide.load.p020b.MultiModelLoaderFactory;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.bumptech.glide.load.b.a.b */
/* loaded from: classes.dex */
public class HttpUriLoader implements ModelLoader<Uri, InputStream> {

    /* renamed from: a */
    private static final Set<String> f601a = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* renamed from: b */
    private final ModelLoader<GlideUrl, InputStream> f602b;

    public HttpUriLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        this.f602b = modelLoader;
    }

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public ModelLoader.C0656a<InputStream> mo7358a(@NonNull Uri uri, int i, int i2, @NonNull Options options) {
        return this.f602b.mo7358a(new GlideUrl(uri.toString()), i, i2, options);
    }

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public boolean mo7359a(@NonNull Uri uri) {
        return f601a.contains(uri.getScheme());
    }

    /* compiled from: HttpUriLoader.java */
    /* renamed from: com.bumptech.glide.load.b.a.b$a */
    /* loaded from: classes.dex */
    public static class C0626a implements ModelLoaderFactory<Uri, InputStream> {
        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        /* renamed from: a */
        public void mo7357a() {
        }

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        @NonNull
        /* renamed from: a */
        public ModelLoader<Uri, InputStream> mo7356a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new HttpUriLoader(multiModelLoaderFactory.m12302b(GlideUrl.class, InputStream.class));
        }
    }
}
