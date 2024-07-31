package com.bumptech.glide.load.p020b.p021a;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.p018a.p019a.MediaStoreUtil;
import com.bumptech.glide.load.p018a.p019a.ThumbFetcher;
import com.bumptech.glide.load.p020b.ModelLoader;
import com.bumptech.glide.load.p020b.ModelLoaderFactory;
import com.bumptech.glide.load.p020b.MultiModelLoaderFactory;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.p017d.ObjectKey;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.b.a.d */
/* loaded from: classes.dex */
public class MediaStoreVideoThumbLoader implements ModelLoader<Uri, InputStream> {

    /* renamed from: a */
    private final Context f605a;

    public MediaStoreVideoThumbLoader(Context context) {
        this.f605a = context.getApplicationContext();
    }

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    @Nullable
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public ModelLoader.C0656a<InputStream> mo7358a(@NonNull Uri uri, int i, int i2, @NonNull Options options) {
        if (MediaStoreUtil.m12423a(i, i2) && m12369a(options)) {
            return new ModelLoader.C0656a<>(new ObjectKey(uri), ThumbFetcher.m12416b(this.f605a, uri));
        }
        return null;
    }

    /* renamed from: a */
    private boolean m12369a(Options options) {
        Long l = (Long) options.m12014a(VideoDecoder.f1082a);
        return l != null && l.longValue() == -1;
    }

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public boolean mo7359a(@NonNull Uri uri) {
        return MediaStoreUtil.m12421b(uri);
    }

    /* compiled from: MediaStoreVideoThumbLoader.java */
    /* renamed from: com.bumptech.glide.load.b.a.d$a */
    /* loaded from: classes.dex */
    public static class C0628a implements ModelLoaderFactory<Uri, InputStream> {

        /* renamed from: a */
        private final Context f606a;

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        /* renamed from: a */
        public void mo7357a() {
        }

        public C0628a(Context context) {
            this.f606a = context;
        }

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        @NonNull
        /* renamed from: a */
        public ModelLoader<Uri, InputStream> mo7356a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreVideoThumbLoader(this.f606a);
        }
    }
}
