package com.bumptech.glide.load.p020b;

import android.support.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.p018a.DataFetcher;
import com.bumptech.glide.load.p020b.ModelLoader;
import com.bumptech.glide.p017d.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.load.b.b */
/* loaded from: classes.dex */
public class ByteArrayLoader<Data> implements ModelLoader<byte[], Data> {

    /* renamed from: a */
    private final InterfaceC0632b<Data> f608a;

    /* compiled from: ByteArrayLoader.java */
    /* renamed from: com.bumptech.glide.load.b.b$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0632b<Data> {
        /* renamed from: a */
        Class<Data> mo12363a();

        /* renamed from: b */
        Data mo12361b(byte[] bArr);
    }

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public boolean mo7359a(@NonNull byte[] bArr) {
        return true;
    }

    public ByteArrayLoader(InterfaceC0632b<Data> interfaceC0632b) {
        this.f608a = interfaceC0632b;
    }

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public ModelLoader.C0656a<Data> mo7358a(@NonNull byte[] bArr, int i, int i2, @NonNull Options options) {
        return new ModelLoader.C0656a<>(new ObjectKey(bArr), new C0633c(bArr, this.f608a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ByteArrayLoader.java */
    /* renamed from: com.bumptech.glide.load.b.b$c */
    /* loaded from: classes.dex */
    public static class C0633c<Data> implements DataFetcher<Data> {

        /* renamed from: a */
        private final byte[] f610a;

        /* renamed from: b */
        private final InterfaceC0632b<Data> f611b;

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        /* renamed from: b */
        public void mo7364b() {
        }

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        /* renamed from: c */
        public void mo7363c() {
        }

        C0633c(byte[] bArr, InterfaceC0632b<Data> interfaceC0632b) {
            this.f610a = bArr;
            this.f611b = interfaceC0632b;
        }

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        /* renamed from: a */
        public void mo7365a(@NonNull Priority priority, @NonNull DataFetcher.InterfaceC0615a<? super Data> interfaceC0615a) {
            interfaceC0615a.mo12019a((DataFetcher.InterfaceC0615a<? super Data>) ((Data) this.f611b.mo12361b(this.f610a)));
        }

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        @NonNull
        /* renamed from: a */
        public Class<Data> mo7366a() {
            return this.f611b.mo12363a();
        }

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        @NonNull
        /* renamed from: d */
        public DataSource mo7362d() {
            return DataSource.LOCAL;
        }
    }

    /* compiled from: ByteArrayLoader.java */
    /* renamed from: com.bumptech.glide.load.b.b$a */
    /* loaded from: classes.dex */
    public static class C0630a implements ModelLoaderFactory<byte[], ByteBuffer> {
        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        /* renamed from: a */
        public void mo7357a() {
        }

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        @NonNull
        /* renamed from: a */
        public ModelLoader<byte[], ByteBuffer> mo7356a(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteArrayLoader(new InterfaceC0632b<ByteBuffer>() { // from class: com.bumptech.glide.load.b.b.a.1
                @Override // com.bumptech.glide.load.p020b.ByteArrayLoader.InterfaceC0632b
                /* renamed from: a */
                public ByteBuffer mo12361b(byte[] bArr) {
                    return ByteBuffer.wrap(bArr);
                }

                @Override // com.bumptech.glide.load.p020b.ByteArrayLoader.InterfaceC0632b
                /* renamed from: a */
                public Class<ByteBuffer> mo12363a() {
                    return ByteBuffer.class;
                }
            });
        }
    }

    /* compiled from: ByteArrayLoader.java */
    /* renamed from: com.bumptech.glide.load.b.b$d */
    /* loaded from: classes.dex */
    public static class C0634d implements ModelLoaderFactory<byte[], InputStream> {
        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        /* renamed from: a */
        public void mo7357a() {
        }

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        @NonNull
        /* renamed from: a */
        public ModelLoader<byte[], InputStream> mo7356a(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteArrayLoader(new InterfaceC0632b<InputStream>() { // from class: com.bumptech.glide.load.b.b.d.1
                @Override // com.bumptech.glide.load.p020b.ByteArrayLoader.InterfaceC0632b
                /* renamed from: a */
                public InputStream mo12361b(byte[] bArr) {
                    return new ByteArrayInputStream(bArr);
                }

                @Override // com.bumptech.glide.load.p020b.ByteArrayLoader.InterfaceC0632b
                /* renamed from: a */
                public Class<InputStream> mo12363a() {
                    return InputStream.class;
                }
            });
        }
    }
}
