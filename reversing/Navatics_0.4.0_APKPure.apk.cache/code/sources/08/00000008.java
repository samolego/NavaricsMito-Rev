package android.arch.p005a.p007b;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: SafeIterableMap.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: android.arch.a.b.b, reason: use source file name */
/* loaded from: classes.dex */
public class SafeIterableMap<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a */
    private c<K, V> f21a;

    /* renamed from: b */
    private c<K, V> f22b;

    /* renamed from: c */
    private WeakHashMap<f<K, V>, Boolean> f23c = new WeakHashMap<>();

    /* renamed from: d */
    private int f24d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* renamed from: android.arch.a.b.b$f */
    /* loaded from: classes.dex */
    public interface f<K, V> {
        /* renamed from: a_ */
        void mo46a_(@NonNull c<K, V> cVar);
    }

    /* renamed from: a */
    protected c<K, V> mo31a(K k) {
        c<K, V> cVar = this.f21a;
        while (cVar != null && !cVar.f25a.equals(k)) {
            cVar = cVar.f27c;
        }
        return cVar;
    }

    /* renamed from: a */
    public V mo32a(@NonNull K k, @NonNull V v) {
        c<K, V> mo31a = mo31a((SafeIterableMap<K, V>) k);
        if (mo31a != null) {
            return mo31a.f26b;
        }
        m38b(k, v);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public c<K, V> m38b(@NonNull K k, @NonNull V v) {
        c<K, V> cVar = new c<>(k, v);
        this.f24d++;
        c<K, V> cVar2 = this.f22b;
        if (cVar2 == null) {
            this.f21a = cVar;
            this.f22b = this.f21a;
            return cVar;
        }
        cVar2.f27c = cVar;
        cVar.f28d = cVar2;
        this.f22b = cVar;
        return cVar;
    }

    /* renamed from: b */
    public V mo33b(@NonNull K k) {
        c<K, V> mo31a = mo31a((SafeIterableMap<K, V>) k);
        if (mo31a == null) {
            return null;
        }
        this.f24d--;
        if (!this.f23c.isEmpty()) {
            Iterator<f<K, V>> it = this.f23c.keySet().iterator();
            while (it.hasNext()) {
                it.next().mo46a_(mo31a);
            }
        }
        if (mo31a.f28d != null) {
            mo31a.f28d.f27c = mo31a.f27c;
        } else {
            this.f21a = mo31a.f27c;
        }
        if (mo31a.f27c != null) {
            mo31a.f27c.f28d = mo31a.f28d;
        } else {
            this.f22b = mo31a.f28d;
        }
        mo31a.f27c = null;
        mo31a.f28d = null;
        return mo31a.f26b;
    }

    /* renamed from: a */
    public int m37a() {
        return this.f24d;
    }

    @Override // java.lang.Iterable
    @NonNull
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f21a, this.f22b);
        this.f23c.put(aVar, false);
        return aVar;
    }

    /* renamed from: b */
    public Iterator<Map.Entry<K, V>> m39b() {
        b bVar = new b(this.f22b, this.f21a);
        this.f23c.put(bVar, false);
        return bVar;
    }

    /* renamed from: c */
    public SafeIterableMap<K, V>.d m40c() {
        SafeIterableMap<K, V>.d dVar = new d();
        this.f23c.put(dVar, false);
        return dVar;
    }

    /* renamed from: d */
    public Map.Entry<K, V> m41d() {
        return this.f21a;
    }

    /* renamed from: e */
    public Map.Entry<K, V> m42e() {
        return this.f22b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SafeIterableMap)) {
            return false;
        }
        SafeIterableMap safeIterableMap = (SafeIterableMap) obj;
        if (m37a() != safeIterableMap.m37a()) {
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
    private static abstract class e<K, V> implements f<K, V>, Iterator<Map.Entry<K, V>> {

        /* renamed from: a */
        c<K, V> f32a;

        /* renamed from: b */
        c<K, V> f33b;

        /* renamed from: a */
        abstract c<K, V> mo43a(c<K, V> cVar);

        /* renamed from: b */
        abstract c<K, V> mo44b(c<K, V> cVar);

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f32a = cVar2;
            this.f33b = cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f33b != null;
        }

        @Override // android.arch.p005a.p007b.SafeIterableMap.f
        /* renamed from: a_ */
        public void mo46a_(@NonNull c<K, V> cVar) {
            if (this.f32a == cVar && cVar == this.f33b) {
                this.f33b = null;
                this.f32a = null;
            }
            c<K, V> cVar2 = this.f32a;
            if (cVar2 == cVar) {
                this.f32a = mo44b(cVar2);
            }
            if (this.f33b == cVar) {
                this.f33b = m47b();
            }
        }

        /* renamed from: b */
        private c<K, V> m47b() {
            c<K, V> cVar = this.f33b;
            c<K, V> cVar2 = this.f32a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return mo43a(cVar);
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f33b;
            this.f33b = m47b();
            return cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* renamed from: android.arch.a.b.b$a */
    /* loaded from: classes.dex */
    public static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // android.arch.p005a.p007b.SafeIterableMap.e
        /* renamed from: a */
        c<K, V> mo43a(c<K, V> cVar) {
            return cVar.f27c;
        }

        @Override // android.arch.p005a.p007b.SafeIterableMap.e
        /* renamed from: b */
        c<K, V> mo44b(c<K, V> cVar) {
            return cVar.f28d;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: android.arch.a.b.b$b */
    /* loaded from: classes.dex */
    private static class b<K, V> extends e<K, V> {
        b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // android.arch.p005a.p007b.SafeIterableMap.e
        /* renamed from: a */
        c<K, V> mo43a(c<K, V> cVar) {
            return cVar.f28d;
        }

        @Override // android.arch.p005a.p007b.SafeIterableMap.e
        /* renamed from: b */
        c<K, V> mo44b(c<K, V> cVar) {
            return cVar.f27c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SafeIterableMap.java */
    /* renamed from: android.arch.a.b.b$d */
    /* loaded from: classes.dex */
    public class d implements f<K, V>, Iterator<Map.Entry<K, V>> {

        /* renamed from: b */
        private c<K, V> f30b;

        /* renamed from: c */
        private boolean f31c;

        private d() {
            this.f31c = true;
        }

        @Override // android.arch.p005a.p007b.SafeIterableMap.f
        /* renamed from: a_ */
        public void mo46a_(@NonNull c<K, V> cVar) {
            c<K, V> cVar2 = this.f30b;
            if (cVar == cVar2) {
                this.f30b = cVar2.f28d;
                this.f31c = this.f30b == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f31c) {
                return SafeIterableMap.this.f21a != null;
            }
            c<K, V> cVar = this.f30b;
            return (cVar == null || cVar.f27c == null) ? false : true;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (this.f31c) {
                this.f31c = false;
                this.f30b = SafeIterableMap.this.f21a;
            } else {
                c<K, V> cVar = this.f30b;
                this.f30b = cVar != null ? cVar.f27c : null;
            }
            return this.f30b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* renamed from: android.arch.a.b.b$c */
    /* loaded from: classes.dex */
    public static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: a */
        @NonNull
        final K f25a;

        /* renamed from: b */
        @NonNull
        final V f26b;

        /* renamed from: c */
        c<K, V> f27c;

        /* renamed from: d */
        c<K, V> f28d;

        c(@NonNull K k, @NonNull V v) {
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
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f25a.equals(cVar.f25a) && this.f26b.equals(cVar.f26b);
        }
    }
}