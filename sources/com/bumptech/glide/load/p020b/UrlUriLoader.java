package com.bumptech.glide.load.p020b;

import android.net.Uri;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.p020b.ModelLoader;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.bumptech.glide.load.b.x */
/* loaded from: classes.dex */
public class UrlUriLoader<Data> implements ModelLoader<Uri, Data> {

    /* renamed from: a */
    private static final Set<String> f693a = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* renamed from: b */
    private final ModelLoader<GlideUrl, Data> f694b;

    public UrlUriLoader(ModelLoader<GlideUrl, Data> modelLoader) {
        this.f694b = modelLoader;
    }

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public ModelLoader.C0656a<Data> mo7358a(@NonNull Uri uri, int i, int i2, @NonNull Options options) {
        return this.f694b.mo7358a(new GlideUrl(uri.toString()), i, i2, options);
    }

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public boolean mo7359a(@NonNull Uri uri) {
        return f693a.contains(uri.getScheme());
    }

    /* compiled from: UrlUriLoader.java */
    /* renamed from: com.bumptech.glide.load.b.x$a */
    /* loaded from: classes.dex */
    public static class C0676a implements ModelLoaderFactory<Uri, InputStream> {
        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        /* renamed from: a */
        public void mo7357a() {
        }

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        @NonNull
        /* renamed from: a */
        public ModelLoader<Uri, InputStream> mo7356a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UrlUriLoader(multiModelLoaderFactory.m12302b(GlideUrl.class, InputStream.class));
        }
    }
}
