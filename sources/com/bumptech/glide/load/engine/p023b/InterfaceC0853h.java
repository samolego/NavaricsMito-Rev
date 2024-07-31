package com.bumptech.glide.load.engine.p023b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;

/* renamed from: com.bumptech.glide.load.engine.b.h */
/* loaded from: classes.dex */
public interface MemoryCache {

    /* compiled from: MemoryCache.java */
    /* renamed from: com.bumptech.glide.load.engine.b.h$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0706a {
        /* renamed from: b */
        void mo12070b(@NonNull Resource<?> resource);
    }

    @Nullable
    /* renamed from: a */
    Resource<?> mo12134a(@NonNull Key key);

    /* renamed from: a */
    void m12136a();

    /* renamed from: a */
    void mo12135a(int i);

    /* renamed from: a */
    void mo12133a(@NonNull InterfaceC0706a interfaceC0706a);

    @Nullable
    /* renamed from: b */
    Resource<?> mo12132b(@NonNull Key key, @Nullable Resource<?> resource);
}
