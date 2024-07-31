package com.bumptech.glide.load.p018a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

/* renamed from: com.bumptech.glide.load.a.d */
/* loaded from: classes.dex */
public interface DataFetcher<T> {

    /* compiled from: DataFetcher.java */
    /* renamed from: com.bumptech.glide.load.a.d$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0615a<T> {
        /* renamed from: a */
        void mo12020a(@NonNull Exception exc);

        /* renamed from: a */
        void mo12019a(@Nullable T t);
    }

    @NonNull
    /* renamed from: a */
    Class<T> mo7366a();

    /* renamed from: a */
    void mo7365a(@NonNull Priority priority, @NonNull InterfaceC0615a<? super T> interfaceC0615a);

    /* renamed from: b */
    void mo7364b();

    /* renamed from: c */
    void mo7363c();

    @NonNull
    /* renamed from: d */
    DataSource mo7362d();
}
