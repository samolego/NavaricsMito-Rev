package com.bumptech.glide.load.p020b;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.p018a.DataFetcher;
import com.bumptech.glide.load.p018a.FileDescriptorAssetPathFetcher;
import com.bumptech.glide.load.p018a.StreamAssetPathFetcher;
import com.bumptech.glide.load.p020b.ModelLoader;
import com.bumptech.glide.p017d.ObjectKey;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.b.a */
/* loaded from: classes.dex */
public class AssetUriLoader<Data> implements ModelLoader<Uri, Data> {

    /* renamed from: a */
    private static final int f593a = 22;

    /* renamed from: b */
    private final AssetManager f594b;

    /* renamed from: c */
    private final InterfaceC0622a<Data> f595c;

    /* compiled from: AssetUriLoader.java */
    /* renamed from: com.bumptech.glide.load.b.a$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0622a<Data> {
        /* renamed from: a */
        DataFetcher<Data> mo12374a(AssetManager assetManager, String str);
    }

    public AssetUriLoader(AssetManager assetManager, InterfaceC0622a<Data> interfaceC0622a) {
        this.f594b = assetManager;
        this.f595c = interfaceC0622a;
    }

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public ModelLoader.C0656a<Data> mo7358a(@NonNull Uri uri, int i, int i2, @NonNull Options options) {
        return new ModelLoader.C0656a<>(new ObjectKey(uri), this.f595c.mo12374a(this.f594b, uri.toString().substring(f593a)));
    }

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public boolean mo7359a(@NonNull Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }

    /* compiled from: AssetUriLoader.java */
    /* renamed from: com.bumptech.glide.load.b.a$c */
    /* loaded from: classes.dex */
    public static class C0624c implements InterfaceC0622a<InputStream>, ModelLoaderFactory<Uri, InputStream> {

        /* renamed from: a */
        private final AssetManager f597a;

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        /* renamed from: a */
        public void mo7357a() {
        }

        public C0624c(AssetManager assetManager) {
            this.f597a = assetManager;
        }

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        @NonNull
        /* renamed from: a */
        public ModelLoader<Uri, InputStream> mo7356a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new AssetUriLoader(this.f597a, this);
        }

        @Override // com.bumptech.glide.load.p020b.AssetUriLoader.InterfaceC0622a
        /* renamed from: a */
        public DataFetcher<InputStream> mo12374a(AssetManager assetManager, String str) {
            return new StreamAssetPathFetcher(assetManager, str);
        }
    }

    /* compiled from: AssetUriLoader.java */
    /* renamed from: com.bumptech.glide.load.b.a$b */
    /* loaded from: classes.dex */
    public static class C0623b implements InterfaceC0622a<ParcelFileDescriptor>, ModelLoaderFactory<Uri, ParcelFileDescriptor> {

        /* renamed from: a */
        private final AssetManager f596a;

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        /* renamed from: a */
        public void mo7357a() {
        }

        public C0623b(AssetManager assetManager) {
            this.f596a = assetManager;
        }

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        @NonNull
        /* renamed from: a */
        public ModelLoader<Uri, ParcelFileDescriptor> mo7356a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new AssetUriLoader(this.f596a, this);
        }

        @Override // com.bumptech.glide.load.p020b.AssetUriLoader.InterfaceC0622a
        /* renamed from: a */
        public DataFetcher<ParcelFileDescriptor> mo12374a(AssetManager assetManager, String str) {
            return new FileDescriptorAssetPathFetcher(assetManager, str);
        }
    }
}
