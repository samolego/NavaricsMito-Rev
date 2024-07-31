package com.bumptech.glide.p016c;

import android.support.annotation.Nullable;
import android.support.p008v4.util.ArrayMap;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.resource.p030e.UnitTranscoder;
import com.bumptech.glide.util.MultiClassKey;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.bumptech.glide.c.c */
/* loaded from: classes.dex */
public class LoadPathCache {

    /* renamed from: a */
    private static final LoadPath<?, ?, ?> f407a = new LoadPath<>(Object.class, Object.class, Object.class, Collections.singletonList(new DecodePath(Object.class, Object.class, Object.class, Collections.emptyList(), new UnitTranscoder(), null)), null);

    /* renamed from: b */
    private final ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> f408b = new ArrayMap<>();

    /* renamed from: c */
    private final AtomicReference<MultiClassKey> f409c = new AtomicReference<>();

    /* renamed from: a */
    public boolean m12545a(@Nullable LoadPath<?, ?, ?> loadPath) {
        return f407a.equals(loadPath);
    }

    @Nullable
    /* renamed from: a */
    public <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> m12544a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        LoadPath<Data, TResource, Transcode> loadPath;
        MultiClassKey m12542b = m12542b(cls, cls2, cls3);
        synchronized (this.f408b) {
            loadPath = (LoadPath<Data, TResource, Transcode>) this.f408b.get(m12542b);
        }
        this.f409c.set(m12542b);
        return loadPath;
    }

    /* renamed from: a */
    public void m12543a(Class<?> cls, Class<?> cls2, Class<?> cls3, @Nullable LoadPath<?, ?, ?> loadPath) {
        synchronized (this.f408b) {
            ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> arrayMap = this.f408b;
            MultiClassKey multiClassKey = new MultiClassKey(cls, cls2, cls3);
            if (loadPath == null) {
                loadPath = f407a;
            }
            arrayMap.put(multiClassKey, loadPath);
        }
    }

    /* renamed from: b */
    private MultiClassKey m12542b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        MultiClassKey andSet = this.f409c.getAndSet(null);
        if (andSet == null) {
            andSet = new MultiClassKey();
        }
        andSet.m11581a(cls, cls2, cls3);
        return andSet;
    }
}
