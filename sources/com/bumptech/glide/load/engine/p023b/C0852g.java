package com.bumptech.glide.load.engine.p023b;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.p023b.MemoryCache;
import com.bumptech.glide.util.LruCache;

/* renamed from: com.bumptech.glide.load.engine.b.g */
/* loaded from: classes.dex */
public class LruResourceCache extends LruCache<Key, Resource<?>> implements MemoryCache {

    /* renamed from: a */
    private MemoryCache.InterfaceC0706a f830a;

    @Override // com.bumptech.glide.load.engine.p023b.MemoryCache
    @Nullable
    /* renamed from: a */
    public /* synthetic */ Resource mo12134a(@NonNull Key key) {
        return (Resource) super.m11585c(key);
    }

    @Override // com.bumptech.glide.load.engine.p023b.MemoryCache
    @Nullable
    /* renamed from: b */
    public /* bridge */ /* synthetic */ Resource mo12132b(@NonNull Key key, @Nullable Resource resource) {
        return (Resource) super.m11587b((LruResourceCache) key, (Key) resource);
    }

    public LruResourceCache(long j) {
        super(j);
    }

    @Override // com.bumptech.glide.load.engine.p023b.MemoryCache
    /* renamed from: a */
    public void mo12133a(@NonNull MemoryCache.InterfaceC0706a interfaceC0706a) {
        this.f830a = interfaceC0706a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.util.LruCache
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo11590a(@NonNull Key key, @Nullable Resource<?> resource) {
        MemoryCache.InterfaceC0706a interfaceC0706a = this.f830a;
        if (interfaceC0706a == null || resource == null) {
            return;
        }
        interfaceC0706a.mo12070b(resource);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.util.LruCache
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public int mo11591a(@Nullable Resource<?> resource) {
        if (resource == null) {
            return super.mo11591a((LruResourceCache) null);
        }
        return resource.mo11852e();
    }

    @Override // com.bumptech.glide.load.engine.p023b.MemoryCache
    @SuppressLint({"InlinedApi"})
    /* renamed from: a */
    public void mo12135a(int i) {
        if (i >= 40) {
            m11593a();
        } else if (i >= 20 || i == 15) {
            m11592a(m11589b() / 2);
        }
    }
}
