package com.bumptech.glide.load.p018a;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.p018a.DataRewinder;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.a.f */
/* loaded from: classes.dex */
public class DataRewinderRegistry {

    /* renamed from: b */
    private static final DataRewinder.InterfaceC0616a<?> f572b = new DataRewinder.InterfaceC0616a<Object>() { // from class: com.bumptech.glide.load.a.f.1
        @Override // com.bumptech.glide.load.p018a.DataRewinder.InterfaceC0616a
        @NonNull
        /* renamed from: a */
        public DataRewinder<Object> mo12006a(@NonNull Object obj) {
            return new C0618a(obj);
        }

        @Override // com.bumptech.glide.load.p018a.DataRewinder.InterfaceC0616a
        @NonNull
        /* renamed from: a */
        public Class<Object> mo12007a() {
            throw new UnsupportedOperationException("Not implemented");
        }
    };

    /* renamed from: a */
    private final Map<Class<?>, DataRewinder.InterfaceC0616a<?>> f573a = new HashMap();

    /* renamed from: a */
    public synchronized void m12406a(@NonNull DataRewinder.InterfaceC0616a<?> interfaceC0616a) {
        this.f573a.put(interfaceC0616a.mo12007a(), interfaceC0616a);
    }

    @NonNull
    /* renamed from: a */
    public synchronized <T> DataRewinder<T> m12405a(@NonNull T t) {
        DataRewinder.InterfaceC0616a<?> interfaceC0616a;
        Preconditions.m11580a(t);
        interfaceC0616a = this.f573a.get(t.getClass());
        if (interfaceC0616a == null) {
            Iterator<DataRewinder.InterfaceC0616a<?>> it = this.f573a.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DataRewinder.InterfaceC0616a<?> next = it.next();
                if (next.mo12007a().isAssignableFrom(t.getClass())) {
                    interfaceC0616a = next;
                    break;
                }
            }
        }
        if (interfaceC0616a == null) {
            interfaceC0616a = f572b;
        }
        return (DataRewinder<T>) interfaceC0616a.mo12006a(t);
    }

    /* compiled from: DataRewinderRegistry.java */
    /* renamed from: com.bumptech.glide.load.a.f$a */
    /* loaded from: classes.dex */
    private static final class C0618a implements DataRewinder<Object> {

        /* renamed from: a */
        private final Object f574a;

        @Override // com.bumptech.glide.load.p018a.DataRewinder
        /* renamed from: b */
        public void mo12009b() {
        }

        C0618a(@NonNull Object obj) {
            this.f574a = obj;
        }

        @Override // com.bumptech.glide.load.p018a.DataRewinder
        @NonNull
        /* renamed from: a */
        public Object mo12010a() {
            return this.f574a;
        }
    }
}
