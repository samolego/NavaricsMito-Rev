package com.bumptech.glide.p012c;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.InterfaceC0562a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: EncoderRegistry.java */
/* renamed from: com.bumptech.glide.c.a, reason: use source file name */
/* loaded from: classes.dex */
public class EncoderRegistry {

    /* renamed from: a */
    private final List<a<?>> f407a = new ArrayList();

    @Nullable
    /* renamed from: a */
    public synchronized <T> InterfaceC0562a<T> m414a(@NonNull Class<T> cls) {
        for (a<?> aVar : this.f407a) {
            if (aVar.m416a(cls)) {
                return (InterfaceC0562a<T>) aVar.f408a;
            }
        }
        return null;
    }

    /* renamed from: a */
    public synchronized <T> void m415a(@NonNull Class<T> cls, @NonNull InterfaceC0562a<T> interfaceC0562a) {
        this.f407a.add(new a<>(cls, interfaceC0562a));
    }

    /* compiled from: EncoderRegistry.java */
    /* renamed from: com.bumptech.glide.c.a$a */
    /* loaded from: classes.dex */
    private static final class a<T> {

        /* renamed from: a */
        final InterfaceC0562a<T> f408a;

        /* renamed from: b */
        private final Class<T> f409b;

        a(@NonNull Class<T> cls, @NonNull InterfaceC0562a<T> interfaceC0562a) {
            this.f409b = cls;
            this.f408a = interfaceC0562a;
        }

        /* renamed from: a */
        boolean m416a(@NonNull Class<?> cls) {
            return this.f409b.isAssignableFrom(cls);
        }
    }
}