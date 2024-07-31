package com.bumptech.glide.load.p014a;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.p014a.InterfaceC0572e;
import com.bumptech.glide.util.C0780h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: DataRewinderRegistry.java */
/* renamed from: com.bumptech.glide.load.a.f, reason: use source file name */
/* loaded from: classes.dex */
public class DataRewinderRegistry {

    /* renamed from: b */
    private static final InterfaceC0572e.a<?> f576b = new InterfaceC0572e.a<Object>() { // from class: com.bumptech.glide.load.a.f.1
        @Override // com.bumptech.glide.load.p014a.InterfaceC0572e.a
        @NonNull
        /* renamed from: a */
        public InterfaceC0572e<Object> mo597a(@NonNull Object obj) {
            return new a(obj);
        }

        @Override // com.bumptech.glide.load.p014a.InterfaceC0572e.a
        @NonNull
        /* renamed from: a */
        public Class<Object> mo598a() {
            throw new UnsupportedOperationException("Not implemented");
        }
    };

    /* renamed from: a */
    private final Map<Class<?>, InterfaceC0572e.a<?>> f577a = new HashMap();

    /* renamed from: a */
    public synchronized void m600a(@NonNull InterfaceC0572e.a<?> aVar) {
        this.f577a.put(aVar.mo598a(), aVar);
    }

    @NonNull
    /* renamed from: a */
    public synchronized <T> InterfaceC0572e<T> m599a(@NonNull T t) {
        InterfaceC0572e.a<?> aVar;
        C0780h.m1362a(t);
        aVar = this.f577a.get(t.getClass());
        if (aVar == null) {
            Iterator<InterfaceC0572e.a<?>> it = this.f577a.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                InterfaceC0572e.a<?> next = it.next();
                if (next.mo598a().isAssignableFrom(t.getClass())) {
                    aVar = next;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = f576b;
        }
        return (InterfaceC0572e<T>) aVar.mo597a(t);
    }

    /* compiled from: DataRewinderRegistry.java */
    /* renamed from: com.bumptech.glide.load.a.f$a */
    /* loaded from: classes.dex */
    private static final class a implements InterfaceC0572e<Object> {

        /* renamed from: a */
        private final Object f578a;

        @Override // com.bumptech.glide.load.p014a.InterfaceC0572e
        /* renamed from: b */
        public void mo596b() {
        }

        a(@NonNull Object obj) {
            this.f578a = obj;
        }

        @Override // com.bumptech.glide.load.p014a.InterfaceC0572e
        @NonNull
        /* renamed from: a */
        public Object mo595a() {
            return this.f578a;
        }
    }
}