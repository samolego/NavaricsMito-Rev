package android.arch.p005a.p007b;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: android.arch.a.b.b */
/* loaded from: classes.dex */
public class SafeIterableMap<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a */
    private C0005c<K, V> f21a;

    /* renamed from: b */
    private C0005c<K, V> f22b;

    /* renamed from: c */
    private WeakHashMap<InterfaceC0008f<K, V>, Boolean> f23c = new WeakHashMap<>();

    /* renamed from: d */
    private int f24d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* renamed from: android.arch.a.b.b$f */
    /* loaded from: classes.dex */
    public interface InterfaceC0008f<K, V> {
        /* renamed from: a_ */
        void mo12908a_(@NonNull C0005c<K, V> c0005c);
    }

    /* renamed from: a */
    protected C0005c<K, V> mo12921a(K k) {
        C0005c<K, V> c0005c = this.f21a;
        while (c0005c != null && !c0005c.f25a.equals(k)) {
            c0005c = c0005c.f27c;
        }
        return c0005c;
    }

    /* renamed from: a */
    public V mo12920a(@NonNull K k, @NonNull V v) {
        C0005c<K, V> mo12921a = mo12921a((SafeIterableMap<K, V>) k);
        if (mo12921a != null) {
            return mo12921a.f26b;
        }
        m12917b(k, v);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public C0005c<K, V> m12917b(@NonNull K k, @NonNull V v) {
        C0005c<K, V> c0005c = new C0005c<>(k, v);
        this.f24d++;
        C0005c<K, V> c0005c2 = this.f22b;
        if (c0005c2 == null) {
            this.f21a = c0005c;
            this.f22b = this.f21a;
            return c0005c;
        }
        c0005c2.f27c = c0005c;
        c0005c.f28d = c0005c2;
        this.f22b = c0005c;
        return c0005c;
    }

    /* renamed from: b */
    public V mo12918b(@NonNull K k) {
        C0005c<K, V> mo12921a = mo12921a((SafeIterableMap<K, V>) k);
        if (mo12921a == null) {
            return null;
        }
        this.f24d--;
        if (!this.f23c.isEmpty()) {
            for (InterfaceC0008f<K, V> interfaceC0008f : this.f23c.keySet()) {
                interfaceC0008f.mo12908a_(mo12921a);
            }
        }
        if (mo12921a.f28d != null) {
            mo12921a.f28d.f27c = mo12921a.f27c;
        } else {
            this.f21a = mo12921a.f27c;
        }
        if (mo12921a.f27c != null) {
            mo12921a.f27c.f28d = mo12921a.f28d;
        } else {
            this.f22b = mo12921a.f28d;
        }
        mo12921a.f27c = null;
        mo12921a.f28d = null;
        return mo12921a.f26b;
    }

    /* renamed from: a */
    public int m12923a() {
        return this.f24d;
    }

    @Override // java.lang.Iterable
    @NonNull
    public Iterator<Map.Entry<K, V>> iterator() {
        C0003a c0003a = new C0003a(this.f21a, this.f22b);
        this.f23c.put(c0003a, false);
        return c0003a;
    }

    /* renamed from: b */
    public Iterator<Map.Entry<K, V>> m12919b() {
        C0004b c0004b = new C0004b(this.f22b, this.f21a);
        this.f23c.put(c0004b, false);
        return c0004b;
    }

    /* renamed from: c */
    public SafeIterableMap<K, V>.C0006d m12916c() {
        SafeIterableMap<K, V>.C0006d c0006d = new C0006d();
        this.f23c.put(c0006d, false);
        return c0006d;
    }

    /* renamed from: d */
    public Map.Entry<K, V> m12915d() {
        return this.f21a;
    }

    /* renamed from: e */
    public Map.Entry<K, V> m12914e() {
        return this.f22b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SafeIterableMap) {
            SafeIterableMap safeIterableMap = (SafeIterableMap) obj;
            if (m12923a() != safeIterableMap.m12923a()) {
                return false;
            }
            Iterator<Map.Entry<K, V>> it = iterator();
            Iterator<Map.Entry<K, V>> it2 = safeIterableMap.iterator();
            while (it.hasNext() && it2.hasNext()) {
                Map.Entry<K, V> next = it.next();
                Map.Entry<K, V> next2 = it2.next();
                if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                    return false;
                }
            }
            return (it.hasNext() || it2.hasNext()) ? false : true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: android.arch.a.b.b$e */
    /* loaded from: classes.dex */
    private static abstract class AbstractC0007e<K, V> implements InterfaceC0008f<K, V>, Iterator<Map.Entry<K, V>> {

        /* renamed from: a */
        C0005c<K, V> f32a;

        /* renamed from: b */
        C0005c<K, V> f33b;

        /* renamed from: a */
        abstract C0005c<K, V> mo12911a(C0005c<K, V> c0005c);

        /* renamed from: b */
        abstract C0005c<K, V> mo12909b(C0005c<K, V> c0005c);

        AbstractC0007e(C0005c<K, V> c0005c, C0005c<K, V> c0005c2) {
            this.f32a = c0005c2;
            this.f33b = c0005c;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f33b != null;
        }

        @Override // android.arch.p005a.p007b.SafeIterableMap.InterfaceC0008f
        /* renamed from: a_ */
        public void mo12908a_(@NonNull C0005c<K, V> c0005c) {
            if (this.f32a == c0005c && c0005c == this.f33b) {
                this.f33b = null;
                this.f32a = null;
            }
            C0005c<K, V> c0005c2 = this.f32a;
            if (c0005c2 == c0005c) {
                this.f32a = mo12909b(c0005c2);
            }
            if (this.f33b == c0005c) {
                this.f33b = m12910b();
            }
        }

        /* renamed from: b */
        private C0005c<K, V> m12910b() {
            C0005c<K, V> c0005c = this.f33b;
            C0005c<K, V> c0005c2 = this.f32a;
            if (c0005c == c0005c2 || c0005c2 == null) {
                return null;
            }
            return mo12911a(c0005c);
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public Map.Entry<K, V> next() {
            C0005c<K, V> c0005c = this.f33b;
            this.f33b = m12910b();
            return c0005c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* renamed from: android.arch.a.b.b$a */
    /* loaded from: classes.dex */
    public static class C0003a<K, V> extends AbstractC0007e<K, V> {
        C0003a(C0005c<K, V> c0005c, C0005c<K, V> c0005c2) {
            super(c0005c, c0005c2);
        }

        @Override // android.arch.p005a.p007b.SafeIterableMap.AbstractC0007e
        /* renamed from: a */
        C0005c<K, V> mo12911a(C0005c<K, V> c0005c) {
            return c0005c.f27c;
        }

        @Override // android.arch.p005a.p007b.SafeIterableMap.AbstractC0007e
        /* renamed from: b */
        C0005c<K, V> mo12909b(C0005c<K, V> c0005c) {
            return c0005c.f28d;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: android.arch.a.b.b$b */
    /* loaded from: classes.dex */
    private static class C0004b<K, V> extends AbstractC0007e<K, V> {
        C0004b(C0005c<K, V> c0005c, C0005c<K, V> c0005c2) {
            super(c0005c, c0005c2);
        }

        @Override // android.arch.p005a.p007b.SafeIterableMap.AbstractC0007e
        /* renamed from: a */
        C0005c<K, V> mo12911a(C0005c<K, V> c0005c) {
            return c0005c.f28d;
        }

        @Override // android.arch.p005a.p007b.SafeIterableMap.AbstractC0007e
        /* renamed from: b */
        C0005c<K, V> mo12909b(C0005c<K, V> c0005c) {
            return c0005c.f27c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SafeIterableMap.java */
    /* renamed from: android.arch.a.b.b$d */
    /* loaded from: classes.dex */
    public class C0006d implements InterfaceC0008f<K, V>, Iterator<Map.Entry<K, V>> {

        /* renamed from: b */
        private C0005c<K, V> f30b;

        /* renamed from: c */
        private boolean f31c;

        private C0006d() {
            this.f31c = true;
        }

        @Override // android.arch.p005a.p007b.SafeIterableMap.InterfaceC0008f
        /* renamed from: a_ */
        public void mo12908a_(@NonNull C0005c<K, V> c0005c) {
            C0005c<K, V> c0005c2 = this.f30b;
            if (c0005c == c0005c2) {
                this.f30b = c0005c2.f28d;
                this.f31c = this.f30b == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f31c) {
                return SafeIterableMap.this.f21a != null;
            }
            C0005c<K, V> c0005c = this.f30b;
            return (c0005c == null || c0005c.f27c == null) ? false : true;
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public Map.Entry<K, V> next() {
            if (this.f31c) {
                this.f31c = false;
                this.f30b = SafeIterableMap.this.f21a;
            } else {
                C0005c<K, V> c0005c = this.f30b;
                this.f30b = c0005c != null ? c0005c.f27c : null;
            }
            return this.f30b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* renamed from: android.arch.a.b.b$c */
    /* loaded from: classes.dex */
    public static class C0005c<K, V> implements Map.Entry<K, V> {
        @NonNull

        /* renamed from: a */
        final K f25a;
        @NonNull

        /* renamed from: b */
        final V f26b;

        /* renamed from: c */
        C0005c<K, V> f27c;

        /* renamed from: d */
        C0005c<K, V> f28d;

        C0005c(@NonNull K k, @NonNull V v) {
            this.f25a = k;
            this.f26b = v;
        }

        @Override // java.util.Map.Entry
        @NonNull
        public K getKey() {
            return this.f25a;
        }

        @Override // java.util.Map.Entry
        @NonNull
        public V getValue() {
            return this.f26b;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f25a + "=" + this.f26b;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof C0005c) {
                C0005c c0005c = (C0005c) obj;
                return this.f25a.equals(c0005c.f25a) && this.f26b.equals(c0005c.f26b);
            }
            return false;
        }
    }
}
