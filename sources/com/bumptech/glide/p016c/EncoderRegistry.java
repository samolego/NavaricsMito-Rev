package com.bumptech.glide.p016c;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Encoder;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bumptech.glide.c.a */
/* loaded from: classes.dex */
public class EncoderRegistry {

    /* renamed from: a */
    private final List<C0604a<?>> f403a = new ArrayList();

    @Nullable
    /* renamed from: a */
    public synchronized <T> Encoder<T> m12550a(@NonNull Class<T> cls) {
        for (C0604a<?> c0604a : this.f403a) {
            if (c0604a.m12548a(cls)) {
                return (Encoder<T>) c0604a.f404a;
            }
        }
        return null;
    }

    /* renamed from: a */
    public synchronized <T> void m12549a(@NonNull Class<T> cls, @NonNull Encoder<T> encoder) {
        this.f403a.add(new C0604a<>(cls, encoder));
    }

    /* compiled from: EncoderRegistry.java */
    /* renamed from: com.bumptech.glide.c.a$a */
    /* loaded from: classes.dex */
    private static final class C0604a<T> {

        /* renamed from: a */
        final Encoder<T> f404a;

        /* renamed from: b */
        private final Class<T> f405b;

        C0604a(@NonNull Class<T> cls, @NonNull Encoder<T> encoder) {
            this.f405b = cls;
            this.f404a = encoder;
        }

        /* renamed from: a */
        boolean m12548a(@NonNull Class<?> cls) {
            return this.f405b.isAssignableFrom(cls);
        }
    }
}
