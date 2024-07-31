package com.bumptech.glide.load.p020b;

import android.support.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.p018a.DataFetcher;
import com.bumptech.glide.load.p020b.ModelLoader;
import com.bumptech.glide.p017d.ObjectKey;

/* renamed from: com.bumptech.glide.load.b.v */
/* loaded from: classes.dex */
public class UnitModelLoader<Model> implements ModelLoader<Model, Model> {

    /* renamed from: a */
    private static final UnitModelLoader<?> f685a = new UnitModelLoader<>();

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a */
    public boolean mo7359a(@NonNull Model model) {
        return true;
    }

    /* renamed from: a */
    public static <T> UnitModelLoader<T> m12289a() {
        return (UnitModelLoader<T>) f685a;
    }

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a */
    public ModelLoader.C0656a<Model> mo7358a(@NonNull Model model, int i, int i2, @NonNull Options options) {
        return new ModelLoader.C0656a<>(new ObjectKey(model), new C0671b(model));
    }

    /* compiled from: UnitModelLoader.java */
    /* renamed from: com.bumptech.glide.load.b.v$b */
    /* loaded from: classes.dex */
    private static class C0671b<Model> implements DataFetcher<Model> {

        /* renamed from: a */
        private final Model f687a;

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        /* renamed from: b */
        public void mo7364b() {
        }

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        /* renamed from: c */
        public void mo7363c() {
        }

        C0671b(Model model) {
            this.f687a = model;
        }

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        /* renamed from: a */
        public void mo7365a(@NonNull Priority priority, @NonNull DataFetcher.InterfaceC0615a<? super Model> interfaceC0615a) {
            interfaceC0615a.mo12019a((DataFetcher.InterfaceC0615a<? super Model>) ((Model) this.f687a));
        }

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        @NonNull
        /* renamed from: a */
        public Class<Model> mo7366a() {
            return (Class<Model>) this.f687a.getClass();
        }

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        @NonNull
        /* renamed from: d */
        public DataSource mo7362d() {
            return DataSource.LOCAL;
        }
    }

    /* compiled from: UnitModelLoader.java */
    /* renamed from: com.bumptech.glide.load.b.v$a */
    /* loaded from: classes.dex */
    public static class C0670a<Model> implements ModelLoaderFactory<Model, Model> {

        /* renamed from: a */
        private static final C0670a<?> f686a = new C0670a<>();

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        /* renamed from: a */
        public void mo7357a() {
        }

        /* renamed from: b */
        public static <T> C0670a<T> m12288b() {
            return (C0670a<T>) f686a;
        }

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        @NonNull
        /* renamed from: a */
        public ModelLoader<Model, Model> mo7356a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return UnitModelLoader.m12289a();
        }
    }
}
