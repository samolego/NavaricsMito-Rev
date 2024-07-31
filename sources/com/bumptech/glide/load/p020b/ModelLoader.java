package com.bumptech.glide.load.p020b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.p018a.DataFetcher;
import com.bumptech.glide.util.Preconditions;
import java.util.Collections;
import java.util.List;

/* renamed from: com.bumptech.glide.load.b.n */
/* loaded from: classes.dex */
public interface ModelLoader<Model, Data> {
    @Nullable
    /* renamed from: a */
    C0656a<Data> mo7358a(@NonNull Model model, int i, int i2, @NonNull Options options);

    /* renamed from: a */
    boolean mo7359a(@NonNull Model model);

    /* compiled from: ModelLoader.java */
    /* renamed from: com.bumptech.glide.load.b.n$a */
    /* loaded from: classes.dex */
    public static class C0656a<Data> {

        /* renamed from: a */
        public final Key f653a;

        /* renamed from: b */
        public final List<Key> f654b;

        /* renamed from: c */
        public final DataFetcher<Data> f655c;

        public C0656a(@NonNull Key key, @NonNull DataFetcher<Data> dataFetcher) {
            this(key, Collections.emptyList(), dataFetcher);
        }

        public C0656a(@NonNull Key key, @NonNull List<Key> list, @NonNull DataFetcher<Data> dataFetcher) {
            this.f653a = (Key) Preconditions.m11580a(key);
            this.f654b = (List) Preconditions.m11580a(list);
            this.f655c = (DataFetcher) Preconditions.m11580a(dataFetcher);
        }
    }
}
