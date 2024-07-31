package com.bumptech.glide.p016c;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.ResourceEncoder;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bumptech.glide.c.f */
/* loaded from: classes.dex */
public class ResourceEncoderRegistry {

    /* renamed from: a */
    private final List<C0606a<?>> f417a = new ArrayList();

    /* renamed from: a */
    public synchronized <Z> void m12532a(@NonNull Class<Z> cls, @NonNull ResourceEncoder<Z> resourceEncoder) {
        this.f417a.add(new C0606a<>(cls, resourceEncoder));
    }

    @Nullable
    /* renamed from: a */
    public synchronized <Z> ResourceEncoder<Z> m12533a(@NonNull Class<Z> cls) {
        int size = this.f417a.size();
        for (int i = 0; i < size; i++) {
            C0606a<?> c0606a = this.f417a.get(i);
            if (c0606a.m12531a(cls)) {
                return (ResourceEncoder<Z>) c0606a.f418a;
            }
        }
        return null;
    }

    /* compiled from: ResourceEncoderRegistry.java */
    /* renamed from: com.bumptech.glide.c.f$a */
    /* loaded from: classes.dex */
    private static final class C0606a<T> {

        /* renamed from: a */
        final ResourceEncoder<T> f418a;

        /* renamed from: b */
        private final Class<T> f419b;

        C0606a(@NonNull Class<T> cls, @NonNull ResourceEncoder<T> resourceEncoder) {
            this.f419b = cls;
            this.f418a = resourceEncoder;
        }

        /* renamed from: a */
        boolean m12531a(@NonNull Class<?> cls) {
            return this.f419b.isAssignableFrom(cls);
        }
    }
}
