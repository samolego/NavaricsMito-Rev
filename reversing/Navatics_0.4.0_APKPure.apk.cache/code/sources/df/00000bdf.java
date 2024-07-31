package com.bumptech.glide.util.p029a;

import android.support.annotation.NonNull;
import android.support.v4.util.Pools;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FactoryPools.java */
/* renamed from: com.bumptech.glide.util.a.a, reason: use source file name */
/* loaded from: classes.dex */
public final class FactoryPools {

    /* renamed from: a */
    private static final d<Object> f1288a = new d<Object>() { // from class: com.bumptech.glide.util.a.a.1
        @Override // com.bumptech.glide.util.p029a.FactoryPools.d
        /* renamed from: a */
        public void mo1333a(@NonNull Object obj) {
        }
    };

    /* compiled from: FactoryPools.java */
    /* renamed from: com.bumptech.glide.util.a.a$a */
    /* loaded from: classes.dex */
    public interface a<T> {
        /* renamed from: b */
        T mo863b();
    }

    /* compiled from: FactoryPools.java */
    /* renamed from: com.bumptech.glide.util.a.a$c */
    /* loaded from: classes.dex */
    public interface c {
        @NonNull
        /* renamed from: a_ */
        AbstractC0773c mo721a_();
    }

    /* compiled from: FactoryPools.java */
    /* renamed from: com.bumptech.glide.util.a.a$d */
    /* loaded from: classes.dex */
    public interface d<T> {
        /* renamed from: a */
        void mo1333a(@NonNull T t);
    }

    @NonNull
    /* renamed from: a */
    public static <T extends c> Pools.Pool<T> m1328a(int i, @NonNull a<T> aVar) {
        return m1329a(new Pools.SimplePool(i), aVar);
    }

    @NonNull
    /* renamed from: b */
    public static <T extends c> Pools.Pool<T> m1331b(int i, @NonNull a<T> aVar) {
        return m1329a(new Pools.SynchronizedPool(i), aVar);
    }

    @NonNull
    /* renamed from: a */
    public static <T> Pools.Pool<List<T>> m1326a() {
        return m1327a(20);
    }

    @NonNull
    /* renamed from: a */
    public static <T> Pools.Pool<List<T>> m1327a(int i) {
        return m1330a(new Pools.SynchronizedPool(i), new a<List<T>>() { // from class: com.bumptech.glide.util.a.a.2
            @Override // com.bumptech.glide.util.p029a.FactoryPools.a
            @NonNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public List<T> mo863b() {
                return new ArrayList();
            }
        }, new d<List<T>>() { // from class: com.bumptech.glide.util.a.a.3
            @Override // com.bumptech.glide.util.p029a.FactoryPools.d
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void mo1333a(@NonNull List<T> list) {
                list.clear();
            }
        });
    }

    @NonNull
    /* renamed from: a */
    private static <T extends c> Pools.Pool<T> m1329a(@NonNull Pools.Pool<T> pool, @NonNull a<T> aVar) {
        return m1330a(pool, aVar, m1332b());
    }

    @NonNull
    /* renamed from: a */
    private static <T> Pools.Pool<T> m1330a(@NonNull Pools.Pool<T> pool, @NonNull a<T> aVar, @NonNull d<T> dVar) {
        return new b(pool, aVar, dVar);
    }

    @NonNull
    /* renamed from: b */
    private static <T> d<T> m1332b() {
        return (d<T>) f1288a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FactoryPools.java */
    /* renamed from: com.bumptech.glide.util.a.a$b */
    /* loaded from: classes.dex */
    public static final class b<T> implements Pools.Pool<T> {

        /* renamed from: a */
        private final a<T> f1289a;

        /* renamed from: b */
        private final d<T> f1290b;

        /* renamed from: c */
        private final Pools.Pool<T> f1291c;

        b(@NonNull Pools.Pool<T> pool, @NonNull a<T> aVar, @NonNull d<T> dVar) {
            this.f1291c = pool;
            this.f1289a = aVar;
            this.f1290b = dVar;
        }

        @Override // android.support.v4.util.Pools.Pool
        public T acquire() {
            T acquire = this.f1291c.acquire();
            if (acquire == null) {
                acquire = this.f1289a.mo863b();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + acquire.getClass());
                }
            }
            if (acquire instanceof c) {
                acquire.mo721a_().mo1341a(false);
            }
            return (T) acquire;
        }

        @Override // android.support.v4.util.Pools.Pool
        public boolean release(@NonNull T t) {
            if (t instanceof c) {
                ((c) t).mo721a_().mo1341a(true);
            }
            this.f1290b.mo1333a(t);
            return this.f1291c.release(t);
        }
    }
}