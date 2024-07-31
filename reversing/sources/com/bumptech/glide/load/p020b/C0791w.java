package com.bumptech.glide.load.p020b;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.p018a.AssetFileDescriptorLocalUriFetcher;
import com.bumptech.glide.load.p018a.DataFetcher;
import com.bumptech.glide.load.p018a.FileDescriptorLocalUriFetcher;
import com.bumptech.glide.load.p018a.StreamLocalUriFetcher;
import com.bumptech.glide.load.p020b.ModelLoader;
import com.bumptech.glide.p017d.ObjectKey;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.bumptech.glide.load.b.w */
/* loaded from: classes.dex */
public class UriLoader<Data> implements ModelLoader<Uri, Data> {

    /* renamed from: a */
    private static final Set<String> f688a = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "android.resource", "content")));

    /* renamed from: b */
    private final InterfaceC0674c<Data> f689b;

    /* compiled from: UriLoader.java */
    /* renamed from: com.bumptech.glide.load.b.w$c */
    /* loaded from: classes.dex */
    public interface InterfaceC0674c<Data> {
        /* renamed from: a */
        DataFetcher<Data> mo12285a(Uri uri);
    }

    public UriLoader(InterfaceC0674c<Data> interfaceC0674c) {
        this.f689b = interfaceC0674c;
    }

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public ModelLoader.C0656a<Data> mo7358a(@NonNull Uri uri, int i, int i2, @NonNull Options options) {
        return new ModelLoader.C0656a<>(new ObjectKey(uri), this.f689b.mo12285a(uri));
    }

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public boolean mo7359a(@NonNull Uri uri) {
        return f688a.contains(uri.getScheme());
    }

    /* compiled from: UriLoader.java */
    /* renamed from: com.bumptech.glide.load.b.w$d */
    /* loaded from: classes.dex */
    public static class C0675d implements ModelLoaderFactory<Uri, InputStream>, InterfaceC0674c<InputStream> {

        /* renamed from: a */
        private final ContentResolver f692a;

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        /* renamed from: a */
        public void mo7357a() {
        }

        public C0675d(ContentResolver contentResolver) {
            this.f692a = contentResolver;
        }

        @Override // com.bumptech.glide.load.p020b.UriLoader.InterfaceC0674c
        /* renamed from: a */
        public DataFetcher<InputStream> mo12285a(Uri uri) {
            return new StreamLocalUriFetcher(this.f692a, uri);
        }

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        @NonNull
        /* renamed from: a */
        public ModelLoader<Uri, InputStream> mo7356a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UriLoader(this);
        }
    }

    /* compiled from: UriLoader.java */
    /* renamed from: com.bumptech.glide.load.b.w$b */
    /* loaded from: classes.dex */
    public static class C0673b implements ModelLoaderFactory<Uri, ParcelFileDescriptor>, InterfaceC0674c<ParcelFileDescriptor> {

        /* renamed from: a */
        private final ContentResolver f691a;

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        /* renamed from: a */
        public void mo7357a() {
        }

        public C0673b(ContentResolver contentResolver) {
            this.f691a = contentResolver;
        }

        @Override // com.bumptech.glide.load.p020b.UriLoader.InterfaceC0674c
        /* renamed from: a */
        public DataFetcher<ParcelFileDescriptor> mo12285a(Uri uri) {
            return new FileDescriptorLocalUriFetcher(this.f691a, uri);
        }

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        @NonNull
        /* renamed from: a */
        public ModelLoader<Uri, ParcelFileDescriptor> mo7356a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UriLoader(this);
        }
    }

    /* compiled from: UriLoader.java */
    /* renamed from: com.bumptech.glide.load.b.w$a */
    /* loaded from: classes.dex */
    public static final class C0672a implements ModelLoaderFactory<Uri, AssetFileDescriptor>, InterfaceC0674c<AssetFileDescriptor> {

        /* renamed from: a */
        private final ContentResolver f690a;

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        /* renamed from: a */
        public void mo7357a() {
        }

        public C0672a(ContentResolver contentResolver) {
            this.f690a = contentResolver;
        }

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        /* renamed from: a */
        public ModelLoader<Uri, AssetFileDescriptor> mo7356a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UriLoader(this);
        }

        @Override // com.bumptech.glide.load.p020b.UriLoader.InterfaceC0674c
        /* renamed from: a */
        public DataFetcher<AssetFileDescriptor> mo12285a(Uri uri) {
            return new AssetFileDescriptorLocalUriFetcher(this.f690a, uri);
        }
    }
}
