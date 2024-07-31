package com.bumptech.glide.load.engine.p018a;

import android.support.annotation.Nullable;
import com.bumptech.glide.load.engine.p018a.InterfaceC0635m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: GroupedLinkedMap.java */
/* renamed from: com.bumptech.glide.load.engine.a.h, reason: use source file name */
/* loaded from: classes.dex */
class GroupedLinkedMap<K extends InterfaceC0635m, V> {

    /* renamed from: a */
    private final a<K, V> f773a = new a<>();

    /* renamed from: b */
    private final Map<K, a<K, V>> f774b = new HashMap();

    /* renamed from: a */
    public void m789a(K k, V v) {
        a<K, V> aVar = this.f774b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            m784b(aVar);
            this.f774b.put(k, aVar);
        } else {
            k.mo770a();
        }
        aVar.m791a(v);
    }

    @Nullable
    /* renamed from: a */
    public V m788a(K k) {
        a<K, V> aVar = this.f774b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            this.f774b.put(k, aVar);
        } else {
            k.mo770a();
        }
        m783a(aVar);
        return aVar.m790a();
    }

    @Nullable
    /* renamed from: a */
    public V m787a() {
        for (a aVar = this.f773a.f777c; !aVar.equals(this.f773a); aVar = aVar.f777c) {
            V v = (V) aVar.m790a();
            if (v != null) {
                return v;
            }
            m786d(aVar);
            this.f774b.remove(aVar.f775a);
            ((InterfaceC0635m) aVar.f775a).mo770a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a aVar = this.f773a.f776b; !aVar.equals(this.f773a); aVar = aVar.f776b) {
            z = true;
            sb.append('{');
            sb.append(aVar.f775a);
            sb.append(':');
            sb.append(aVar.m792b());
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }

    /* renamed from: a */
    private void m783a(a<K, V> aVar) {
        m786d(aVar);
        a<K, V> aVar2 = this.f773a;
        aVar.f777c = aVar2;
        aVar.f776b = aVar2.f776b;
        m785c(aVar);
    }

    /* renamed from: b */
    private void m784b(a<K, V> aVar) {
        m786d(aVar);
        aVar.f777c = this.f773a.f777c;
        aVar.f776b = this.f773a;
        m785c(aVar);
    }

    /* renamed from: c */
    private static <K, V> void m785c(a<K, V> aVar) {
        aVar.f776b.f777c = aVar;
        aVar.f777c.f776b = aVar;
    }

    /* renamed from: d */
    private static <K, V> void m786d(a<K, V> aVar) {
        aVar.f777c.f776b = aVar.f776b;
        aVar.f776b.f777c = aVar.f777c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GroupedLinkedMap.java */
    /* renamed from: com.bumptech.glide.load.engine.a.h$a */
    /* loaded from: classes.dex */
    public static class a<K, V> {

        /* renamed from: a */
        final K f775a;

        /* renamed from: b */
        a<K, V> f776b;

        /* renamed from: c */
        a<K, V> f777c;

        /* renamed from: d */
        private List<V> f778d;

        a() {
            this(null);
        }

        a(K k) {
            this.f777c = this;
            this.f776b = this;
            this.f775a = k;
        }

        @Nullable
        /* renamed from: a */
        public V m790a() {
            int m792b = m792b();
            if (m792b > 0) {
                return this.f778d.remove(m792b - 1);
            }
            return null;
        }

        /* renamed from: b */
        public int m792b() {
            List<V> list = this.f778d;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        /* renamed from: a */
        public void m791a(V v) {
            if (this.f778d == null) {
                this.f778d = new ArrayList();
            }
            this.f778d.add(v);
        }
    }
}