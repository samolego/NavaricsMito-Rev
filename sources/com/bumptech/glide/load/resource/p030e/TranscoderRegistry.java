package com.bumptech.glide.load.resource.p030e;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bumptech.glide.load.resource.e.f */
/* loaded from: classes.dex */
public class TranscoderRegistry {

    /* renamed from: a */
    private final List<C0767a<?, ?>> f1145a = new ArrayList();

    /* renamed from: a */
    public synchronized <Z, R> void m11816a(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull ResourceTranscoder<Z, R> resourceTranscoder) {
        this.f1145a.add(new C0767a<>(cls, cls2, resourceTranscoder));
    }

    @NonNull
    /* renamed from: a */
    public synchronized <Z, R> ResourceTranscoder<Z, R> m11817a(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return UnitTranscoder.m11813a();
        }
        for (C0767a<?, ?> c0767a : this.f1145a) {
            if (c0767a.m11814a(cls, cls2)) {
                return (ResourceTranscoder<Z, R>) c0767a.f1146a;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    @NonNull
    /* renamed from: b */
    public synchronized <Z, R> List<Class<R>> m11815b(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (C0767a<?, ?> c0767a : this.f1145a) {
            if (c0767a.m11814a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    /* compiled from: TranscoderRegistry.java */
    /* renamed from: com.bumptech.glide.load.resource.e.f$a */
    /* loaded from: classes.dex */
    private static final class C0767a<Z, R> {

        /* renamed from: a */
        final ResourceTranscoder<Z, R> f1146a;

        /* renamed from: b */
        private final Class<Z> f1147b;

        /* renamed from: c */
        private final Class<R> f1148c;

        C0767a(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull ResourceTranscoder<Z, R> resourceTranscoder) {
            this.f1147b = cls;
            this.f1148c = cls2;
            this.f1146a = resourceTranscoder;
        }

        /* renamed from: a */
        public boolean m11814a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.f1147b.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f1148c);
        }
    }
}
