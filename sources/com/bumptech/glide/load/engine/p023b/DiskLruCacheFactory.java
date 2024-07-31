package com.bumptech.glide.load.engine.p023b;

import com.bumptech.glide.load.engine.p023b.DiskCache;
import java.io.File;

/* renamed from: com.bumptech.glide.load.engine.b.d */
/* loaded from: classes.dex */
public class DiskLruCacheFactory implements DiskCache.InterfaceC0700a {

    /* renamed from: a */
    private final long f821a;

    /* renamed from: b */
    private final InterfaceC0704a f822b;

    /* compiled from: DiskLruCacheFactory.java */
    /* renamed from: com.bumptech.glide.load.engine.b.d$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0704a {
        /* renamed from: a */
        File mo12139a();
    }

    public DiskLruCacheFactory(InterfaceC0704a interfaceC0704a, long j) {
        this.f821a = j;
        this.f822b = interfaceC0704a;
    }

    @Override // com.bumptech.glide.load.engine.p023b.DiskCache.InterfaceC0700a
    /* renamed from: a */
    public DiskCache mo12144a() {
        File mo12139a = this.f822b.mo12139a();
        if (mo12139a == null) {
            return null;
        }
        if (mo12139a.mkdirs() || (mo12139a.exists() && mo12139a.isDirectory())) {
            return DiskLruCacheWrapper.m12140a(mo12139a, this.f821a);
        }
        return null;
    }
}
