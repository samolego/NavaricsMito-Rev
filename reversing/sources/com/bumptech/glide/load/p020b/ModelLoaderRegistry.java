package com.bumptech.glide.load.p020b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p008v4.util.Pools;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.b.p */
/* loaded from: classes.dex */
public class ModelLoaderRegistry {

    /* renamed from: a */
    private final MultiModelLoaderFactory f656a;

    /* renamed from: b */
    private final C0657a f657b;

    public ModelLoaderRegistry(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(new MultiModelLoaderFactory(pool));
    }

    private ModelLoaderRegistry(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
        this.f657b = new C0657a();
        this.f656a = multiModelLoaderFactory;
    }

    /* renamed from: a */
    public synchronized <Model, Data> void m12320a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.f656a.m12306a(cls, cls2, modelLoaderFactory);
        this.f657b.m12314a();
    }

    /* renamed from: b */
    public synchronized <Model, Data> void m12316b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        m12318a((List) this.f656a.m12301b(cls, cls2, modelLoaderFactory));
        this.f657b.m12314a();
    }

    /* renamed from: a */
    private <Model, Data> void m12318a(@NonNull List<ModelLoaderFactory<? extends Model, ? extends Data>> list) {
        for (ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory : list) {
            modelLoaderFactory.mo7357a();
        }
    }

    @NonNull
    /* renamed from: a */
    public synchronized <A> List<ModelLoader<A, ?>> m12319a(@NonNull A a) {
        ArrayList arrayList;
        List<ModelLoader<A, ?>> m12317b = m12317b((Class) m12315b(a));
        int size = m12317b.size();
        arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            ModelLoader<A, ?> modelLoader = m12317b.get(i);
            if (modelLoader.mo7359a(a)) {
                arrayList.add(modelLoader);
            }
        }
        return arrayList;
    }

    @NonNull
    /* renamed from: a */
    public synchronized List<Class<?>> m12321a(@NonNull Class<?> cls) {
        return this.f656a.m12303b(cls);
    }

    @NonNull
    /* renamed from: b */
    private <A> List<ModelLoader<A, ?>> m12317b(@NonNull Class<A> cls) {
        List<ModelLoader<A, ?>> m12313a = this.f657b.m12313a(cls);
        if (m12313a == null) {
            List<ModelLoader<A, ?>> unmodifiableList = Collections.unmodifiableList(this.f656a.m12308a(cls));
            this.f657b.m12312a(cls, unmodifiableList);
            return unmodifiableList;
        }
        return m12313a;
    }

    @NonNull
    /* renamed from: b */
    private static <A> Class<A> m12315b(@NonNull A a) {
        return (Class<A>) a.getClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ModelLoaderRegistry.java */
    /* renamed from: com.bumptech.glide.load.b.p$a */
    /* loaded from: classes.dex */
    public static class C0657a {

        /* renamed from: a */
        private final Map<Class<?>, C0658a<?>> f658a = new HashMap();

        C0657a() {
        }

        /* renamed from: a */
        public void m12314a() {
            this.f658a.clear();
        }

        /* renamed from: a */
        public <Model> void m12312a(Class<Model> cls, List<ModelLoader<Model, ?>> list) {
            if (this.f658a.put(cls, new C0658a<>(list)) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }

        @Nullable
        /* renamed from: a */
        public <Model> List<ModelLoader<Model, ?>> m12313a(Class<Model> cls) {
            C0658a<?> c0658a = this.f658a.get(cls);
            if (c0658a == null) {
                return null;
            }
            return (List<ModelLoader<Model, ?>>) c0658a.f659a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: ModelLoaderRegistry.java */
        /* renamed from: com.bumptech.glide.load.b.p$a$a */
        /* loaded from: classes.dex */
        public static class C0658a<Model> {

            /* renamed from: a */
            final List<ModelLoader<Model, ?>> f659a;

            public C0658a(List<ModelLoader<Model, ?>> list) {
                this.f659a = list;
            }
        }
    }
}
