package com.bumptech.glide.p016c;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.ResourceDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.bumptech.glide.c.e */
/* loaded from: classes.dex */
public class ResourceDecoderRegistry {

    /* renamed from: a */
    private final List<String> f412a = new ArrayList();

    /* renamed from: b */
    private final Map<String, List<C0605a<?, ?>>> f413b = new HashMap();

    /* renamed from: a */
    public synchronized void m12536a(@NonNull List<String> list) {
        ArrayList<String> arrayList = new ArrayList(this.f412a);
        this.f412a.clear();
        this.f412a.addAll(list);
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.f412a.add(str);
            }
        }
    }

    @NonNull
    /* renamed from: a */
    public synchronized <T, R> List<ResourceDecoder<T, R>> m12539a(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f412a) {
            List<C0605a<?, ?>> list = this.f413b.get(str);
            if (list != null) {
                for (C0605a<?, ?> c0605a : list) {
                    if (c0605a.m12534a(cls, cls2)) {
                        arrayList.add(c0605a.f415b);
                    }
                }
            }
        }
        return arrayList;
    }

    @NonNull
    /* renamed from: b */
    public synchronized <T, R> List<Class<R>> m12535b(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f412a) {
            List<C0605a<?, ?>> list = this.f413b.get(str);
            if (list != null) {
                for (C0605a<?, ?> c0605a : list) {
                    if (c0605a.m12534a(cls, cls2) && !arrayList.contains(c0605a.f414a)) {
                        arrayList.add(c0605a.f414a);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public synchronized <T, R> void m12537a(@NonNull String str, @NonNull ResourceDecoder<T, R> resourceDecoder, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        m12538a(str).add(new C0605a<>(cls, cls2, resourceDecoder));
    }

    @NonNull
    /* renamed from: a */
    private synchronized List<C0605a<?, ?>> m12538a(@NonNull String str) {
        List<C0605a<?, ?>> list;
        if (!this.f412a.contains(str)) {
            this.f412a.add(str);
        }
        list = this.f413b.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f413b.put(str, list);
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ResourceDecoderRegistry.java */
    /* renamed from: com.bumptech.glide.c.e$a */
    /* loaded from: classes.dex */
    public static class C0605a<T, R> {

        /* renamed from: a */
        final Class<R> f414a;

        /* renamed from: b */
        final ResourceDecoder<T, R> f415b;

        /* renamed from: c */
        private final Class<T> f416c;

        public C0605a(@NonNull Class<T> cls, @NonNull Class<R> cls2, ResourceDecoder<T, R> resourceDecoder) {
            this.f416c = cls;
            this.f414a = cls2;
            this.f415b = resourceDecoder;
        }

        /* renamed from: a */
        public boolean m12534a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.f416c.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f414a);
        }
    }
}
