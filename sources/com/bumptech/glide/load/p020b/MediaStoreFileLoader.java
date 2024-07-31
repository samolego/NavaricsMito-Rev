package com.bumptech.glide.load.p020b;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.p018a.DataFetcher;
import com.bumptech.glide.load.p018a.p019a.MediaStoreUtil;
import com.bumptech.glide.load.p020b.ModelLoader;
import com.bumptech.glide.p017d.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;

/* renamed from: com.bumptech.glide.load.b.k */
/* loaded from: classes.dex */
public final class MediaStoreFileLoader implements ModelLoader<Uri, File> {

    /* renamed from: a */
    private final Context f642a;

    public MediaStoreFileLoader(Context context) {
        this.f642a = context;
    }

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public ModelLoader.C0656a<File> mo7358a(@NonNull Uri uri, int i, int i2, @NonNull Options options) {
        return new ModelLoader.C0656a<>(new ObjectKey(uri), new C0653b(this.f642a, uri));
    }

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public boolean mo7359a(@NonNull Uri uri) {
        return MediaStoreUtil.m12422a(uri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MediaStoreFileLoader.java */
    /* renamed from: com.bumptech.glide.load.b.k$b */
    /* loaded from: classes.dex */
    public static class C0653b implements DataFetcher<File> {

        /* renamed from: a */
        private static final String[] f644a = {"_data"};

        /* renamed from: b */
        private final Context f645b;

        /* renamed from: c */
        private final Uri f646c;

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        /* renamed from: b */
        public void mo7364b() {
        }

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        /* renamed from: c */
        public void mo7363c() {
        }

        C0653b(Context context, Uri uri) {
            this.f645b = context;
            this.f646c = uri;
        }

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        /* renamed from: a */
        public void mo7365a(@NonNull Priority priority, @NonNull DataFetcher.InterfaceC0615a<? super File> interfaceC0615a) {
            Cursor query = this.f645b.getContentResolver().query(this.f646c, f644a, null, null, null);
            if (query != null) {
                try {
                    r0 = query.moveToFirst() ? query.getString(query.getColumnIndexOrThrow("_data")) : null;
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(r0)) {
                interfaceC0615a.mo12020a((Exception) new FileNotFoundException("Failed to find file path for: " + this.f646c));
                return;
            }
            interfaceC0615a.mo12019a((DataFetcher.InterfaceC0615a<? super File>) new File(r0));
        }

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        @NonNull
        /* renamed from: a */
        public Class<File> mo7366a() {
            return File.class;
        }

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        @NonNull
        /* renamed from: d */
        public DataSource mo7362d() {
            return DataSource.LOCAL;
        }
    }

    /* compiled from: MediaStoreFileLoader.java */
    /* renamed from: com.bumptech.glide.load.b.k$a */
    /* loaded from: classes.dex */
    public static final class C0652a implements ModelLoaderFactory<Uri, File> {

        /* renamed from: a */
        private final Context f643a;

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        /* renamed from: a */
        public void mo7357a() {
        }

        public C0652a(Context context) {
            this.f643a = context;
        }

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        @NonNull
        /* renamed from: a */
        public ModelLoader<Uri, File> mo7356a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreFileLoader(this.f643a);
        }
    }
}
