package com.bumptech.glide.load.engine.p022a;

import android.support.annotation.Nullable;
import com.bumptech.glide.load.engine.p022a.Poolable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.engine.a.h */
/* loaded from: classes.dex */
class GroupedLinkedMap<K extends Poolable, V> {

    /* renamed from: a */
    private final C0692a<K, V> f769a = new C0692a<>();

    /* renamed from: b */
    private final Map<K, C0692a<K, V>> f770b = new HashMap();

    /* renamed from: a */
    public void m12215a(K k, V v) {
        C0692a<K, V> c0692a = this.f770b.get(k);
        if (c0692a == null) {
            c0692a = new C0692a<>(k);
            m12214b(c0692a);
            this.f770b.put(k, c0692a);
        } else {
            k.mo12154a();
        }
        c0692a.m12210a(v);
    }

    @Nullable
    /* renamed from: a */
    public V m12216a(K k) {
        C0692a<K, V> c0692a = this.f770b.get(k);
        if (c0692a == null) {
            c0692a = new C0692a<>(k);
            this.f770b.put(k, c0692a);
        } else {
            k.mo12154a();
        }
        m12217a(c0692a);
        return c0692a.m12211a();
    }

    @Nullable
    /* renamed from: a */
    public V m12218a() {
        for (C0692a c0692a = this.f769a.f773c; !c0692a.equals(this.f769a); c0692a = c0692a.f773c) {
            V v = (V) c0692a.m12211a();
            if (v != null) {
                return v;
            }
            m12212d(c0692a);
            this.f770b.remove(c0692a.f771a);
            ((Poolable) c0692a.f771a).mo12154a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (C0692a c0692a = this.f769a.f772b; !c0692a.equals(this.f769a); c0692a = c0692a.f772b) {
            z = true;
            sb.append('{');
            sb.append(c0692a.f771a);
            sb.append(':');
            sb.append(c0692a.m12209b());
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }

    /* renamed from: a */
    private void m12217a(C0692a<K, V> c0692a) {
        m12212d(c0692a);
        C0692a<K, V> c0692a2 = this.f769a;
        c0692a.f773c = c0692a2;
        c0692a.f772b = c0692a2.f772b;
        m12213c(c0692a);
    }

    /* renamed from: b */
    private void m12214b(C0692a<K, V> c0692a) {
        m12212d(c0692a);
        c0692a.f773c = this.f769a.f773c;
        c0692a.f772b = this.f769a;
        m12213c(c0692a);
    }

    /* renamed from: c */
    private static <K, V> void m12213c(C0692a<K, V> c0692a) {
        c0692a.f772b.f773c = c0692a;
        c0692a.f773c.f772b = c0692a;
    }

    /* renamed from: d */
    private static <K, V> void m12212d(C0692a<K, V> c0692a) {
        c0692a.f773c.f772b = c0692a.f772b;
        c0692a.f772b.f773c = c0692a.f773c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GroupedLinkedMap.java */
    /* renamed from: com.bumptech.glide.load.engine.a.h$a */
    /* loaded from: classes.dex */
    public static class C0692a<K, V> {

        /* renamed from: a */
        final K f771a;

        /* renamed from: b */
        C0692a<K, V> f772b;

        /* renamed from: c */
        C0692a<K, V> f773c;

        /* renamed from: d */
        private List<V> f774d;

        C0692a() {
            this(null);
        }

        C0692a(K k) {
            this.f773c = this;
            this.f772b = this;
            this.f771a = k;
        }

        @Nullable
        /* renamed from: a */
        public V m12211a() {
            int m12209b = m12209b();
            if (m12209b > 0) {
                return this.f774d.remove(m12209b - 1);
            }
            return null;
        }

        /* renamed from: b */
        public int m12209b() {
            List<V> list = this.f774d;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        /* renamed from: a */
        public void m12210a(V v) {
            if (this.f774d == null) {
                this.f774d = new ArrayList();
            }
            this.f774d.add(v);
        }
    }
}
