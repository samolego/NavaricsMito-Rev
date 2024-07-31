package com.bumptech.glide.load.p018a;

import android.support.annotation.NonNull;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.a.e */
/* loaded from: classes.dex */
public interface DataRewinder<T> {

    /* compiled from: DataRewinder.java */
    /* renamed from: com.bumptech.glide.load.a.e$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0616a<T> {
        @NonNull
        /* renamed from: a */
        DataRewinder<T> mo12006a(@NonNull T t);

        @NonNull
        /* renamed from: a */
        Class<T> mo12007a();
    }

    @NonNull
    /* renamed from: a */
    T mo12010a() throws IOException;

    /* renamed from: b */
    void mo12009b();
}
