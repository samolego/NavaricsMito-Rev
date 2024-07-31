package com.bumptech.glide.load.p020b;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.p020b.ModelLoader;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.b.s */
/* loaded from: classes.dex */
public class ResourceLoader<Data> implements ModelLoader<Integer, Data> {

    /* renamed from: a */
    private final ModelLoader<Uri, Data> f677a;

    /* renamed from: b */
    private final Resources f678b;

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public boolean mo7359a(@NonNull Integer num) {
        return true;
    }

    public ResourceLoader(Resources resources, ModelLoader<Uri, Data> modelLoader) {
        this.f678b = resources;
        this.f677a = modelLoader;
    }

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public ModelLoader.C0656a<Data> mo7358a(@NonNull Integer num, int i, int i2, @NonNull Options options) {
        Uri m12295b = m12295b(num);
        if (m12295b == null) {
            return null;
        }
        return this.f677a.mo7358a(m12295b, i, i2, options);
    }

    @Nullable
    /* renamed from: b */
    private Uri m12295b(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f678b.getResourcePackageName(num.intValue()) + '/' + this.f678b.getResourceTypeName(num.intValue()) + '/' + this.f678b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                Log.w("ResourceLoader", "Received invalid resource id: " + num, e);
                return null;
            }
            return null;
        }
    }

    /* compiled from: ResourceLoader.java */
    /* renamed from: com.bumptech.glide.load.b.s$c */
    /* loaded from: classes.dex */
    public static class C0665c implements ModelLoaderFactory<Integer, InputStream> {

        /* renamed from: a */
        private final Resources f681a;

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        /* renamed from: a */
        public void mo7357a() {
        }

        public C0665c(Resources resources) {
            this.f681a = resources;
        }

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        @NonNull
        /* renamed from: a */
        public ModelLoader<Integer, InputStream> mo7356a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f681a, multiModelLoaderFactory.m12302b(Uri.class, InputStream.class));
        }
    }

    /* compiled from: ResourceLoader.java */
    /* renamed from: com.bumptech.glide.load.b.s$b */
    /* loaded from: classes.dex */
    public static class C0664b implements ModelLoaderFactory<Integer, ParcelFileDescriptor> {

        /* renamed from: a */
        private final Resources f680a;

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        /* renamed from: a */
        public void mo7357a() {
        }

        public C0664b(Resources resources) {
            this.f680a = resources;
        }

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        @NonNull
        /* renamed from: a */
        public ModelLoader<Integer, ParcelFileDescriptor> mo7356a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f680a, multiModelLoaderFactory.m12302b(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* compiled from: ResourceLoader.java */
    /* renamed from: com.bumptech.glide.load.b.s$a */
    /* loaded from: classes.dex */
    public static final class C0663a implements ModelLoaderFactory<Integer, AssetFileDescriptor> {

        /* renamed from: a */
        private final Resources f679a;

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        /* renamed from: a */
        public void mo7357a() {
        }

        public C0663a(Resources resources) {
            this.f679a = resources;
        }

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        /* renamed from: a */
        public ModelLoader<Integer, AssetFileDescriptor> mo7356a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f679a, multiModelLoaderFactory.m12302b(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* compiled from: ResourceLoader.java */
    /* renamed from: com.bumptech.glide.load.b.s$d */
    /* loaded from: classes.dex */
    public static class C0666d implements ModelLoaderFactory<Integer, Uri> {

        /* renamed from: a */
        private final Resources f682a;

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        /* renamed from: a */
        public void mo7357a() {
        }

        public C0666d(Resources resources) {
            this.f682a = resources;
        }

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        @NonNull
        /* renamed from: a */
        public ModelLoader<Integer, Uri> mo7356a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f682a, UnitModelLoader.m12289a());
        }
    }
}
