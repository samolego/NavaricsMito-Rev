package com.bumptech.glide.util.p033a;

import android.support.annotation.NonNull;
import android.support.p008v4.util.Pools;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bumptech.glide.util.a.a */
/* loaded from: classes.dex */
public final class FactoryPools {

    /* renamed from: a */
    private static final InterfaceC0788d<Object> f1287a = new InterfaceC0788d<Object>() { // from class: com.bumptech.glide.util.a.a.1
        @Override // com.bumptech.glide.util.p033a.FactoryPools.InterfaceC0788d
        /* renamed from: a */
        public void mo11609a(@NonNull Object obj) {
        }
    };

    /* compiled from: FactoryPools.java */
    /* renamed from: com.bumptech.glide.util.a.a$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0785a<T> {
        /* renamed from: b */
        T mo11611b();
    }

    /* compiled from: FactoryPools.java */
    /* renamed from: com.bumptech.glide.util.a.a$c */
    /* loaded from: classes.dex */
    public interface InterfaceC0787c {
        @NonNull
        /* renamed from: a_ */
        StateVerifier mo11610a_();
    }

    /* compiled from: FactoryPools.java */
    /* renamed from: com.bumptech.glide.util.a.a$d */
    /* loaded from: classes.dex */
    public interface InterfaceC0788d<T> {
        /* renamed from: a */
        void mo11609a(@NonNull T t);
    }

    @NonNull
    /* renamed from: a */
    public static <T extends InterfaceC0787c> Pools.Pool<T> m11618a(int i, @NonNull InterfaceC0785a<T> interfaceC0785a) {
        return m11617a(new Pools.SimplePool(i), interfaceC0785a);
    }

    @NonNull
    /* renamed from: b */
    public static <T extends InterfaceC0787c> Pools.Pool<T> m11614b(int i, @NonNull InterfaceC0785a<T> interfaceC0785a) {
        return m11617a(new Pools.SynchronizedPool(i), interfaceC0785a);
    }

    @NonNull
    /* renamed from: a */
    public static <T> Pools.Pool<List<T>> m11620a() {
        return m11619a(20);
    }

    @NonNull
    /* renamed from: a */
    public static <T> Pools.Pool<List<T>> m11619a(int i) {
        return m11616a(new Pools.SynchronizedPool(i), new InterfaceC0785a<List<T>>() { // from class: com.bumptech.glide.util.a.a.2
            @Override // com.bumptech.glide.util.p033a.FactoryPools.InterfaceC0785a
            @NonNull
            /* renamed from: a */
            public List<T> mo11611b() {
                return new ArrayList();
            }
        }, new InterfaceC0788d<List<T>>() { // from class: com.bumptech.glide.util.a.a.3
            @Override // com.bumptech.glide.util.p033a.FactoryPools.InterfaceC0788d
            /* renamed from: a */
            public /* bridge */ /* synthetic */ void mo11609a(@NonNull Object obj) {
                m11612a((List) ((List) obj));
            }

            /* renamed from: a */
            public void m11612a(@NonNull List<T> list) {
                list.clear();
            }
        });
    }

    @NonNull
    /* renamed from: a */
    private static <T extends InterfaceC0787c> Pools.Pool<T> m11617a(@NonNull Pools.Pool<T> pool, @NonNull InterfaceC0785a<T> interfaceC0785a) {
        return m11616a(pool, interfaceC0785a, m11615b());
    }

    @NonNull
    /* renamed from: a */
    private static <T> Pools.Pool<T> m11616a(@NonNull Pools.Pool<T> pool, @NonNull InterfaceC0785a<T> interfaceC0785a, @NonNull InterfaceC0788d<T> interfaceC0788d) {
        return new C0786b(pool, interfaceC0785a, interfaceC0788d);
    }

    @NonNull
    /* renamed from: b */
    private static <T> InterfaceC0788d<T> m11615b() {
        return (InterfaceC0788d<T>) f1287a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FactoryPools.java */
    /* renamed from: com.bumptech.glide.util.a.a$b */
    /* loaded from: classes.dex */
    public static final class C0786b<T> implements Pools.Pool<T> {

        /* renamed from: a */
        private final InterfaceC0785a<T> f1288a;

        /* renamed from: b */
        private final InterfaceC0788d<T> f1289b;

        /* renamed from: c */
        private final Pools.Pool<T> f1290c;

        C0786b(@NonNull Pools.Pool<T> pool, @NonNull InterfaceC0785a<T> interfaceC0785a, @NonNull InterfaceC0788d<T> interfaceC0788d) {
            this.f1290c = pool;
            this.f1288a = interfaceC0785a;
            this.f1289b = interfaceC0788d;
        }

        @Override // android.support.p008v4.util.Pools.Pool
        public T acquire() {
            T acquire = this.f1290c.acquire();
            if (acquire == null) {
                acquire = this.f1288a.mo11611b();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + acquire.getClass());
                }
            }
            if (acquire instanceof InterfaceC0787c) {
                ((InterfaceC0787c) acquire).mo11610a_().mo11603a(false);
            }
            return acquire;
        }

        @Override // android.support.p008v4.util.Pools.Pool
        public boolean release(@NonNull T t) {
            if (t instanceof InterfaceC0787c) {
                ((InterfaceC0787c) t).mo11610a_().mo11603a(true);
            }
            this.f1289b.mo11609a(t);
            return this.f1290c.release(t);
        }
    }
}
