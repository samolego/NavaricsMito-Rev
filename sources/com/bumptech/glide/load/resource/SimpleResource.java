package com.bumptech.glide.load.resource;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

/* renamed from: com.bumptech.glide.load.resource.a */
/* loaded from: classes.dex */
public class SimpleResource<T> implements Resource<T> {

    /* renamed from: a */
    protected final T f1005a;

    @Override // com.bumptech.glide.load.engine.Resource
    /* renamed from: e */
    public final int mo11852e() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    /* renamed from: f */
    public void mo11851f() {
    }

    public SimpleResource(@NonNull T t) {
        this.f1005a = (T) Preconditions.m11580a(t);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    /* renamed from: c */
    public Class<T> mo11853c() {
        return (Class<T>) this.f1005a.getClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    /* renamed from: d */
    public final T mo11898d() {
        return this.f1005a;
    }
}
