package com.bumptech.glide.load.resource;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.engine.InterfaceC0667s;
import com.bumptech.glide.util.C0780h;

/* compiled from: SimpleResource.java */
/* renamed from: com.bumptech.glide.load.resource.a, reason: use source file name */
/* loaded from: classes.dex */
public class SimpleResource<T> implements InterfaceC0667s<T> {

    /* renamed from: a */
    protected final T f1009a;

    @Override // com.bumptech.glide.load.engine.InterfaceC0667s
    /* renamed from: e */
    public final int mo939e() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0667s
    /* renamed from: f */
    public void mo940f() {
    }

    public SimpleResource(@NonNull T t) {
        this.f1009a = (T) C0780h.m1362a(t);
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0667s
    @NonNull
    /* renamed from: c */
    public Class<T> mo937c() {
        return (Class<T>) this.f1009a.getClass();
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0667s
    @NonNull
    /* renamed from: d */
    public final T mo938d() {
        return this.f1009a;
    }
}