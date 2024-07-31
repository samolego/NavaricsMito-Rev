package com.bumptech.glide.load.engine;

import android.support.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.p018a.DataFetcher;

/* renamed from: com.bumptech.glide.load.engine.e */
/* loaded from: classes.dex */
interface DataFetcherGenerator {

    /* compiled from: DataFetcherGenerator.java */
    /* renamed from: com.bumptech.glide.load.engine.e$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0719a {
        /* renamed from: a */
        void mo12022a(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource);

        /* renamed from: a */
        void mo12021a(Key key, @Nullable Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2);

        /* renamed from: c */
        void mo12016c();
    }

    /* renamed from: a */
    boolean mo12023a();

    /* renamed from: b */
    void mo12018b();
}
