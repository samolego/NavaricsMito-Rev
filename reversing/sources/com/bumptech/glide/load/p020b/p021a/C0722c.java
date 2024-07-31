package com.bumptech.glide.load.p020b.p021a;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.p018a.p019a.MediaStoreUtil;
import com.bumptech.glide.load.p018a.p019a.ThumbFetcher;
import com.bumptech.glide.load.p020b.ModelLoader;
import com.bumptech.glide.load.p020b.ModelLoaderFactory;
import com.bumptech.glide.load.p020b.MultiModelLoaderFactory;
import com.bumptech.glide.p017d.ObjectKey;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.b.a.c */
/* loaded from: classes.dex */
public class MediaStoreImageThumbLoader implements ModelLoader<Uri, InputStream> {

    /* renamed from: a */
    private final Context f603a;

    public MediaStoreImageThumbLoader(Context context) {
        this.f603a = context.getApplicationContext();
    }

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public ModelLoader.C0656a<InputStream> mo7358a(@NonNull Uri uri, int i, int i2, @NonNull Options options) {
        if (MediaStoreUtil.m12423a(i, i2)) {
            return new ModelLoader.C0656a<>(new ObjectKey(uri), ThumbFetcher.m12418a(this.f603a, uri));
        }
        return null;
    }

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public boolean mo7359a(@NonNull Uri uri) {
        return MediaStoreUtil.m12420c(uri);
    }

    /* compiled from: MediaStoreImageThumbLoader.java */
    /* renamed from: com.bumptech.glide.load.b.a.c$a */
    /* loaded from: classes.dex */
    public static class C0627a implements ModelLoaderFactory<Uri, InputStream> {

        /* renamed from: a */
        private final Context f604a;

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        /* renamed from: a */
        public void mo7357a() {
        }

        public C0627a(Context context) {
            this.f604a = context;
        }

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        @NonNull
        /* renamed from: a */
        public ModelLoader<Uri, InputStream> mo7356a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreImageThumbLoader(this.f604a);
        }
    }
}
