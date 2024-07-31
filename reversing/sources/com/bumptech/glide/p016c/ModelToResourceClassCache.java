package com.bumptech.glide.p016c;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p008v4.util.ArrayMap;
import com.bumptech.glide.util.MultiClassKey;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.bumptech.glide.c.d */
/* loaded from: classes.dex */
public class ModelToResourceClassCache {

    /* renamed from: a */
    private final AtomicReference<MultiClassKey> f410a = new AtomicReference<>();

    /* renamed from: b */
    private final ArrayMap<MultiClassKey, List<Class<?>>> f411b = new ArrayMap<>();

    @Nullable
    /* renamed from: a */
    public List<Class<?>> m12541a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        List<Class<?>> list;
        MultiClassKey andSet = this.f410a.getAndSet(null);
        if (andSet == null) {
            andSet = new MultiClassKey(cls, cls2);
        } else {
            andSet.m11582a(cls, cls2);
        }
        synchronized (this.f411b) {
            list = this.f411b.get(andSet);
        }
        this.f410a.set(andSet);
        return list;
    }

    /* renamed from: a */
    public void m12540a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull List<Class<?>> list) {
        synchronized (this.f411b) {
            this.f411b.put(new MultiClassKey(cls, cls2), list);
        }
    }
}
