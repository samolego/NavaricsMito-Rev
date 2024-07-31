package com.bumptech.glide.load.p020b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p008v4.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.p018a.DataFetcher;
import com.bumptech.glide.load.p020b.ModelLoader;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.bumptech.glide.load.b.q */
/* loaded from: classes.dex */
class MultiModelLoader<Model, Data> implements ModelLoader<Model, Data> {

    /* renamed from: a */
    private final List<ModelLoader<Model, Data>> f660a;

    /* renamed from: b */
    private final Pools.Pool<List<Throwable>> f661b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiModelLoader(@NonNull List<ModelLoader<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        this.f660a = list;
        this.f661b = pool;
    }

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a */
    public ModelLoader.C0656a<Data> mo7358a(@NonNull Model model, int i, int i2, @NonNull Options options) {
        ModelLoader.C0656a<Data> mo7358a;
        int size = this.f660a.size();
        ArrayList arrayList = new ArrayList(size);
        Key key = null;
        for (int i3 = 0; i3 < size; i3++) {
            ModelLoader<Model, Data> modelLoader = this.f660a.get(i3);
            if (modelLoader.mo7359a(model) && (mo7358a = modelLoader.mo7358a(model, i, i2, options)) != null) {
                key = mo7358a.f653a;
                arrayList.add(mo7358a.f655c);
            }
        }
        if (arrayList.isEmpty() || key == null) {
            return null;
        }
        return new ModelLoader.C0656a<>(key, new C0659a(arrayList, this.f661b));
    }

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a */
    public boolean mo7359a(@NonNull Model model) {
        for (ModelLoader<Model, Data> modelLoader : this.f660a) {
            if (modelLoader.mo7359a(model)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f660a.toArray()) + '}';
    }

    /* compiled from: MultiModelLoader.java */
    /* renamed from: com.bumptech.glide.load.b.q$a */
    /* loaded from: classes.dex */
    static class C0659a<Data> implements DataFetcher<Data>, DataFetcher.InterfaceC0615a<Data> {

        /* renamed from: a */
        private final List<DataFetcher<Data>> f662a;

        /* renamed from: b */
        private final Pools.Pool<List<Throwable>> f663b;

        /* renamed from: c */
        private int f664c;

        /* renamed from: d */
        private Priority f665d;

        /* renamed from: e */
        private DataFetcher.InterfaceC0615a<? super Data> f666e;
        @Nullable

        /* renamed from: f */
        private List<Throwable> f667f;

        C0659a(@NonNull List<DataFetcher<Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            this.f663b = pool;
            Preconditions.m11577a(list);
            this.f662a = list;
            this.f664c = 0;
        }

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        /* renamed from: a */
        public void mo7365a(@NonNull Priority priority, @NonNull DataFetcher.InterfaceC0615a<? super Data> interfaceC0615a) {
            this.f665d = priority;
            this.f666e = interfaceC0615a;
            this.f667f = this.f663b.acquire();
            this.f662a.get(this.f664c).mo7365a(priority, this);
        }

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        /* renamed from: b */
        public void mo7364b() {
            List<Throwable> list = this.f667f;
            if (list != null) {
                this.f663b.release(list);
            }
            this.f667f = null;
            for (DataFetcher<Data> dataFetcher : this.f662a) {
                dataFetcher.mo7364b();
            }
        }

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        /* renamed from: c */
        public void mo7363c() {
            for (DataFetcher<Data> dataFetcher : this.f662a) {
                dataFetcher.mo7363c();
            }
        }

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        @NonNull
        /* renamed from: a */
        public Class<Data> mo7366a() {
            return this.f662a.get(0).mo7366a();
        }

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        @NonNull
        /* renamed from: d */
        public DataSource mo7362d() {
            return this.f662a.get(0).mo7362d();
        }

        @Override // com.bumptech.glide.load.p018a.DataFetcher.InterfaceC0615a
        /* renamed from: a */
        public void mo12019a(@Nullable Data data) {
            if (data != null) {
                this.f666e.mo12019a((DataFetcher.InterfaceC0615a<? super Data>) data);
            } else {
                m12311e();
            }
        }

        @Override // com.bumptech.glide.load.p018a.DataFetcher.InterfaceC0615a
        /* renamed from: a */
        public void mo12020a(@NonNull Exception exc) {
            ((List) Preconditions.m11580a(this.f667f)).add(exc);
            m12311e();
        }

        /* renamed from: e */
        private void m12311e() {
            if (this.f664c < this.f662a.size() - 1) {
                this.f664c++;
                mo7365a(this.f665d, this.f666e);
                return;
            }
            Preconditions.m11580a(this.f667f);
            this.f666e.mo12020a((Exception) new GlideException("Fetch failed", new ArrayList(this.f667f)));
        }
    }
}
