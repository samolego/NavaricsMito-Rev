package com.bumptech.glide.load.p014a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

/* compiled from: DataFetcher.java */
/* renamed from: com.bumptech.glide.load.a.d */
/* loaded from: classes.dex */
public interface InterfaceC0571d<T> {

    /* compiled from: DataFetcher.java */
    /* renamed from: com.bumptech.glide.load.a.d$a */
    /* loaded from: classes.dex */
    public interface a<T> {
        /* renamed from: a */
        void mo593a(@NonNull Exception exc);

        /* renamed from: a */
        void mo594a(@Nullable T t);
    }

    @NonNull
    /* renamed from: a */
    Class<T> mo564a();

    /* renamed from: a */
    void mo579a(@NonNull Priority priority, @NonNull a<? super T> aVar);

    /* renamed from: b */
    void mo580b();

    /* renamed from: c */
    void mo581c();

    @NonNull
    /* renamed from: d */
    DataSource mo582d();
}