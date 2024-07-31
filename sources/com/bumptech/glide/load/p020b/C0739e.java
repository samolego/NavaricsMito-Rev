package com.bumptech.glide.load.p020b;

import android.support.annotation.NonNull;
import android.util.Base64;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.p018a.DataFetcher;
import com.bumptech.glide.load.p020b.ModelLoader;
import com.bumptech.glide.p017d.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.b.e */
/* loaded from: classes.dex */
public final class DataUrlLoader<Model, Data> implements ModelLoader<Model, Data> {

    /* renamed from: a */
    private final InterfaceC0638a<Data> f614a;

    /* compiled from: DataUrlLoader.java */
    /* renamed from: com.bumptech.glide.load.b.e$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0638a<Data> {
        /* renamed from: a */
        Class<Data> mo12357a();

        /* renamed from: a */
        Data mo12354a(String str) throws IllegalArgumentException;

        /* renamed from: a */
        void mo12355a(Data data) throws IOException;
    }

    public DataUrlLoader(InterfaceC0638a<Data> interfaceC0638a) {
        this.f614a = interfaceC0638a;
    }

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a */
    public ModelLoader.C0656a<Data> mo7358a(@NonNull Model model, int i, int i2, @NonNull Options options) {
        return new ModelLoader.C0656a<>(new ObjectKey(model), new C0639b(model.toString(), this.f614a));
    }

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a */
    public boolean mo7359a(@NonNull Model model) {
        return model.toString().startsWith("data:image");
    }

    /* compiled from: DataUrlLoader.java */
    /* renamed from: com.bumptech.glide.load.b.e$b */
    /* loaded from: classes.dex */
    private static final class C0639b<Data> implements DataFetcher<Data> {

        /* renamed from: a */
        private final String f615a;

        /* renamed from: b */
        private final InterfaceC0638a<Data> f616b;

        /* renamed from: c */
        private Data f617c;

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        /* renamed from: c */
        public void mo7363c() {
        }

        C0639b(String str, InterfaceC0638a<Data> interfaceC0638a) {
            this.f615a = str;
            this.f616b = interfaceC0638a;
        }

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        /* renamed from: a */
        public void mo7365a(@NonNull Priority priority, @NonNull DataFetcher.InterfaceC0615a<? super Data> interfaceC0615a) {
            try {
                this.f617c = this.f616b.mo12354a(this.f615a);
                interfaceC0615a.mo12019a((DataFetcher.InterfaceC0615a<? super Data>) ((Data) this.f617c));
            } catch (IllegalArgumentException e) {
                interfaceC0615a.mo12020a((Exception) e);
            }
        }

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        /* renamed from: b */
        public void mo7364b() {
            try {
                this.f616b.mo12355a((InterfaceC0638a<Data>) this.f617c);
            } catch (IOException unused) {
            }
        }

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        @NonNull
        /* renamed from: a */
        public Class<Data> mo7366a() {
            return this.f616b.mo12357a();
        }

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        @NonNull
        /* renamed from: d */
        public DataSource mo7362d() {
            return DataSource.LOCAL;
        }
    }

    /* compiled from: DataUrlLoader.java */
    /* renamed from: com.bumptech.glide.load.b.e$c */
    /* loaded from: classes.dex */
    public static final class C0640c<Model> implements ModelLoaderFactory<Model, InputStream> {

        /* renamed from: a */
        private final InterfaceC0638a<InputStream> f618a = new InterfaceC0638a<InputStream>() { // from class: com.bumptech.glide.load.b.e.c.1
            @Override // com.bumptech.glide.load.p020b.DataUrlLoader.InterfaceC0638a
            /* renamed from: b */
            public InputStream mo12354a(String str) {
                if (!str.startsWith("data:image")) {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
                int indexOf = str.indexOf(44);
                if (indexOf == -1) {
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                if (!str.substring(0, indexOf).endsWith(";base64")) {
                    throw new IllegalArgumentException("Not a base64 image data URL.");
                }
                return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
            }

            @Override // com.bumptech.glide.load.p020b.DataUrlLoader.InterfaceC0638a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void mo12355a(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // com.bumptech.glide.load.p020b.DataUrlLoader.InterfaceC0638a
            /* renamed from: a */
            public Class<InputStream> mo12357a() {
                return InputStream.class;
            }
        };

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        /* renamed from: a */
        public void mo7357a() {
        }

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        @NonNull
        /* renamed from: a */
        public ModelLoader<Model, InputStream> mo7356a(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new DataUrlLoader(this.f618a);
        }
    }
}
