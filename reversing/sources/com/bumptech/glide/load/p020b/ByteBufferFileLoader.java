package com.bumptech.glide.load.p020b;

import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.p018a.DataFetcher;
import com.bumptech.glide.load.p020b.ModelLoader;
import com.bumptech.glide.p017d.ObjectKey;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.load.b.d */
/* loaded from: classes.dex */
public class ByteBufferFileLoader implements ModelLoader<File, ByteBuffer> {
    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public boolean mo7359a(@NonNull File file) {
        return true;
    }

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public ModelLoader.C0656a<ByteBuffer> mo7358a(@NonNull File file, int i, int i2, @NonNull Options options) {
        return new ModelLoader.C0656a<>(new ObjectKey(file), new C0636a(file));
    }

    /* compiled from: ByteBufferFileLoader.java */
    /* renamed from: com.bumptech.glide.load.b.d$b */
    /* loaded from: classes.dex */
    public static class C0637b implements ModelLoaderFactory<File, ByteBuffer> {
        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        /* renamed from: a */
        public void mo7357a() {
        }

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        @NonNull
        /* renamed from: a */
        public ModelLoader<File, ByteBuffer> mo7356a(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteBufferFileLoader();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ByteBufferFileLoader.java */
    /* renamed from: com.bumptech.glide.load.b.d$a */
    /* loaded from: classes.dex */
    public static final class C0636a implements DataFetcher<ByteBuffer> {

        /* renamed from: a */
        private final File f613a;

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        /* renamed from: b */
        public void mo7364b() {
        }

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        /* renamed from: c */
        public void mo7363c() {
        }

        C0636a(File file) {
            this.f613a = file;
        }

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        /* renamed from: a */
        public void mo7365a(@NonNull Priority priority, @NonNull DataFetcher.InterfaceC0615a<? super ByteBuffer> interfaceC0615a) {
            try {
                interfaceC0615a.mo12019a((DataFetcher.InterfaceC0615a<? super ByteBuffer>) ByteBufferUtil.m11625a(this.f613a));
            } catch (IOException e) {
                if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                    Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e);
                }
                interfaceC0615a.mo12020a((Exception) e);
            }
        }

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        @NonNull
        /* renamed from: a */
        public Class<ByteBuffer> mo7366a() {
            return ByteBuffer.class;
        }

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        @NonNull
        /* renamed from: d */
        public DataSource mo7362d() {
            return DataSource.LOCAL;
        }
    }
}
