package com.bumptech.glide.load.p020b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.p008v4.util.Pools;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.p020b.ModelLoader;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: com.bumptech.glide.load.b.r */
/* loaded from: classes.dex */
public class MultiModelLoaderFactory {

    /* renamed from: a */
    private static final C0662c f668a = new C0662c();

    /* renamed from: b */
    private static final ModelLoader<Object, Object> f669b = new C0660a();

    /* renamed from: c */
    private final List<C0661b<?, ?>> f670c;

    /* renamed from: d */
    private final C0662c f671d;

    /* renamed from: e */
    private final Set<C0661b<?, ?>> f672e;

    /* renamed from: f */
    private final Pools.Pool<List<Throwable>> f673f;

    public MultiModelLoaderFactory(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(pool, f668a);
    }

    @VisibleForTesting
    MultiModelLoaderFactory(@NonNull Pools.Pool<List<Throwable>> pool, @NonNull C0662c c0662c) {
        this.f670c = new ArrayList();
        this.f672e = new HashSet();
        this.f673f = pool;
        this.f671d = c0662c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized <Model, Data> void m12306a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        m12305a(cls, cls2, modelLoaderFactory, true);
    }

    /* renamed from: a */
    private <Model, Data> void m12305a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory, boolean z) {
        C0661b<?, ?> c0661b = new C0661b<>(cls, cls2, modelLoaderFactory);
        List<C0661b<?, ?>> list = this.f670c;
        list.add(z ? list.size() : 0, c0661b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: b */
    public synchronized <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> m12301b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        List<ModelLoaderFactory<? extends Model, ? extends Data>> m12307a;
        m12307a = m12307a(cls, cls2);
        m12306a(cls, cls2, modelLoaderFactory);
        return m12307a;
    }

    @NonNull
    /* renamed from: a */
    synchronized <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> m12307a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<C0661b<?, ?>> it = this.f670c.iterator();
        while (it.hasNext()) {
            C0661b<?, ?> next = it.next();
            if (next.m12299a(cls, cls2)) {
                it.remove();
                arrayList.add(m12309a(next));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: a */
    public synchronized <Model> List<ModelLoader<Model, ?>> m12308a(@NonNull Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (C0661b<?, ?> c0661b : this.f670c) {
                if (!this.f672e.contains(c0661b) && c0661b.m12300a(cls)) {
                    this.f672e.add(c0661b);
                    arrayList.add(m12304b(c0661b));
                    this.f672e.remove(c0661b);
                }
            }
        } catch (Throwable th) {
            this.f672e.clear();
            throw th;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: b */
    public synchronized List<Class<?>> m12303b(@NonNull Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (C0661b<?, ?> c0661b : this.f670c) {
            if (!arrayList.contains(c0661b.f674a) && c0661b.m12300a(cls)) {
                arrayList.add(c0661b.f674a);
            }
        }
        return arrayList;
    }

    @NonNull
    /* renamed from: b */
    public synchronized <Model, Data> ModelLoader<Model, Data> m12302b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (C0661b<?, ?> c0661b : this.f670c) {
                if (this.f672e.contains(c0661b)) {
                    z = true;
                } else if (c0661b.m12299a(cls, cls2)) {
                    this.f672e.add(c0661b);
                    arrayList.add(m12304b(c0661b));
                    this.f672e.remove(c0661b);
                }
            }
            if (arrayList.size() > 1) {
                return this.f671d.m12298a(arrayList, this.f673f);
            } else if (arrayList.size() == 1) {
                return (ModelLoader) arrayList.get(0);
            } else if (z) {
                return m12310a();
            } else {
                throw new Registry.NoModelLoaderAvailableException(cls, cls2);
            }
        } catch (Throwable th) {
            this.f672e.clear();
            throw th;
        }
    }

    @NonNull
    /* renamed from: a */
    private <Model, Data> ModelLoaderFactory<Model, Data> m12309a(@NonNull C0661b<?, ?> c0661b) {
        return (ModelLoaderFactory<Model, Data>) c0661b.f675b;
    }

    @NonNull
    /* renamed from: b */
    private <Model, Data> ModelLoader<Model, Data> m12304b(@NonNull C0661b<?, ?> c0661b) {
        return (ModelLoader) Preconditions.m11580a(c0661b.f675b.mo7356a(this));
    }

    @NonNull
    /* renamed from: a */
    private static <Model, Data> ModelLoader<Model, Data> m12310a() {
        return (ModelLoader<Model, Data>) f669b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MultiModelLoaderFactory.java */
    /* renamed from: com.bumptech.glide.load.b.r$b */
    /* loaded from: classes.dex */
    public static class C0661b<Model, Data> {

        /* renamed from: a */
        final Class<Data> f674a;

        /* renamed from: b */
        final ModelLoaderFactory<? extends Model, ? extends Data> f675b;

        /* renamed from: c */
        private final Class<Model> f676c;

        public C0661b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
            this.f676c = cls;
            this.f674a = cls2;
            this.f675b = modelLoaderFactory;
        }

        /* renamed from: a */
        public boolean m12299a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return m12300a(cls) && this.f674a.isAssignableFrom(cls2);
        }

        /* renamed from: a */
        public boolean m12300a(@NonNull Class<?> cls) {
            return this.f676c.isAssignableFrom(cls);
        }
    }

    /* compiled from: MultiModelLoaderFactory.java */
    /* renamed from: com.bumptech.glide.load.b.r$c */
    /* loaded from: classes.dex */
    static class C0662c {
        C0662c() {
        }

        @NonNull
        /* renamed from: a */
        public <Model, Data> MultiModelLoader<Model, Data> m12298a(@NonNull List<ModelLoader<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            return new MultiModelLoader<>(list, pool);
        }
    }

    /* compiled from: MultiModelLoaderFactory.java */
    /* renamed from: com.bumptech.glide.load.b.r$a */
    /* loaded from: classes.dex */
    private static class C0660a implements ModelLoader<Object, Object> {
        @Override // com.bumptech.glide.load.p020b.ModelLoader
        @Nullable
        /* renamed from: a */
        public ModelLoader.C0656a<Object> mo7358a(@NonNull Object obj, int i, int i2, @NonNull Options options) {
            return null;
        }

        @Override // com.bumptech.glide.load.p020b.ModelLoader
        /* renamed from: a */
        public boolean mo7359a(@NonNull Object obj) {
            return false;
        }

        C0660a() {
        }
    }
}
