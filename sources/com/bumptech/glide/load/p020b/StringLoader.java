package com.bumptech.glide.load.p020b;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.p020b.ModelLoader;
import java.io.File;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.b.u */
/* loaded from: classes.dex */
public class StringLoader<Data> implements ModelLoader<String, Data> {

    /* renamed from: a */
    private final ModelLoader<Uri, Data> f684a;

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public boolean mo7359a(@NonNull String str) {
        return true;
    }

    public StringLoader(ModelLoader<Uri, Data> modelLoader) {
        this.f684a = modelLoader;
    }

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public ModelLoader.C0656a<Data> mo7358a(@NonNull String str, int i, int i2, @NonNull Options options) {
        Uri m12291b = m12291b(str);
        if (m12291b == null) {
            return null;
        }
        return this.f684a.mo7358a(m12291b, i, i2, options);
    }

    @Nullable
    /* renamed from: b */
    private static Uri m12291b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return m12290c(str);
        }
        Uri parse = Uri.parse(str);
        return parse.getScheme() == null ? m12290c(str) : parse;
    }

    /* renamed from: c */
    private static Uri m12290c(String str) {
        return Uri.fromFile(new File(str));
    }

    /* compiled from: StringLoader.java */
    /* renamed from: com.bumptech.glide.load.b.u$c */
    /* loaded from: classes.dex */
    public static class C0669c implements ModelLoaderFactory<String, InputStream> {
        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        /* renamed from: a */
        public void mo7357a() {
        }

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        @NonNull
        /* renamed from: a */
        public ModelLoader<String, InputStream> mo7356a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new StringLoader(multiModelLoaderFactory.m12302b(Uri.class, InputStream.class));
        }
    }

    /* compiled from: StringLoader.java */
    /* renamed from: com.bumptech.glide.load.b.u$b */
    /* loaded from: classes.dex */
    public static class C0668b implements ModelLoaderFactory<String, ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        /* renamed from: a */
        public void mo7357a() {
        }

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        @NonNull
        /* renamed from: a */
        public ModelLoader<String, ParcelFileDescriptor> mo7356a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new StringLoader(multiModelLoaderFactory.m12302b(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* compiled from: StringLoader.java */
    /* renamed from: com.bumptech.glide.load.b.u$a */
    /* loaded from: classes.dex */
    public static final class C0667a implements ModelLoaderFactory<String, AssetFileDescriptor> {
        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        /* renamed from: a */
        public void mo7357a() {
        }

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        /* renamed from: a */
        public ModelLoader<String, AssetFileDescriptor> mo7356a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new StringLoader(multiModelLoaderFactory.m12302b(Uri.class, AssetFileDescriptor.class));
        }
    }
}
