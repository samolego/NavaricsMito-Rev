package com.bumptech.glide.load.engine.p022a;

import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* renamed from: com.bumptech.glide.load.engine.a.j */
/* loaded from: classes.dex */
public final class LruArrayPool implements ArrayPool {

    /* renamed from: a */
    private final GroupedLinkedMap<C0693a, Object> f775a;

    /* renamed from: b */
    private final C0694b f776b;

    /* renamed from: c */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f777c;

    /* renamed from: d */
    private final Map<Class<?>, ArrayAdapterInterface<?>> f778d;

    /* renamed from: e */
    private final int f779e;

    /* renamed from: f */
    private int f780f;

    @VisibleForTesting
    public LruArrayPool() {
        this.f775a = new GroupedLinkedMap<>();
        this.f776b = new C0694b();
        this.f777c = new HashMap();
        this.f778d = new HashMap();
        this.f779e = 4194304;
    }

    public LruArrayPool(int i) {
        this.f775a = new GroupedLinkedMap<>();
        this.f776b = new C0694b();
        this.f777c = new HashMap();
        this.f778d = new HashMap();
        this.f779e = i;
    }

    @Override // com.bumptech.glide.load.engine.p022a.ArrayPool
    /* renamed from: a */
    public synchronized <T> void mo12195a(T t) {
        Class<?> cls = t.getClass();
        ArrayAdapterInterface<T> m12191b = m12191b((Class) cls);
        int mo12206a = m12191b.mo12206a((ArrayAdapterInterface<T>) t);
        int mo12204b = m12191b.mo12204b() * mo12206a;
        if (m12193b(mo12204b)) {
            C0693a m12184a = this.f776b.m12184a(mo12206a, cls);
            this.f775a.m12215a(m12184a, t);
            NavigableMap<Integer, Integer> m12196a = m12196a(cls);
            Integer num = (Integer) m12196a.get(Integer.valueOf(m12184a.f781a));
            Integer valueOf = Integer.valueOf(m12184a.f781a);
            int i = 1;
            if (num != null) {
                i = 1 + num.intValue();
            }
            m12196a.put(valueOf, Integer.valueOf(i));
            this.f780f += mo12204b;
            m12189c();
        }
    }

    @Override // com.bumptech.glide.load.engine.p022a.ArrayPool
    /* renamed from: b */
    public synchronized <T> T mo12192b(int i, Class<T> cls) {
        return (T) m12197a(this.f776b.m12184a(i, cls), cls);
    }

    @Override // com.bumptech.glide.load.engine.p022a.ArrayPool
    /* renamed from: a */
    public synchronized <T> T mo12200a(int i, Class<T> cls) {
        C0693a m12184a;
        Integer ceilingKey = m12196a((Class<?>) cls).ceilingKey(Integer.valueOf(i));
        if (m12199a(i, ceilingKey)) {
            m12184a = this.f776b.m12184a(ceilingKey.intValue(), cls);
        } else {
            m12184a = this.f776b.m12184a(i, cls);
        }
        return (T) m12197a(m12184a, cls);
    }

    /* renamed from: a */
    private <T> T m12197a(C0693a c0693a, Class<T> cls) {
        ArrayAdapterInterface<T> m12191b = m12191b((Class) cls);
        T t = (T) m12198a(c0693a);
        if (t != null) {
            this.f780f -= m12191b.mo12206a((ArrayAdapterInterface<T>) t) * m12191b.mo12204b();
            m12187c(m12191b.mo12206a((ArrayAdapterInterface<T>) t), cls);
        }
        if (t == null) {
            if (Log.isLoggable(m12191b.mo12208a(), 2)) {
                Log.v(m12191b.mo12208a(), "Allocated " + c0693a.f781a + " bytes");
            }
            return m12191b.mo12207a(c0693a.f781a);
        }
        return t;
    }

    @Nullable
    /* renamed from: a */
    private <T> T m12198a(C0693a c0693a) {
        return (T) this.f775a.m12216a((GroupedLinkedMap<C0693a, Object>) c0693a);
    }

    /* renamed from: b */
    private boolean m12193b(int i) {
        return i <= this.f779e / 2;
    }

    /* renamed from: a */
    private boolean m12199a(int i, Integer num) {
        return num != null && (m12194b() || num.intValue() <= i * 8);
    }

    /* renamed from: b */
    private boolean m12194b() {
        int i = this.f780f;
        return i == 0 || this.f779e / i >= 2;
    }

    @Override // com.bumptech.glide.load.engine.p022a.ArrayPool
    /* renamed from: a */
    public synchronized void mo12202a() {
        m12188c(0);
    }

    @Override // com.bumptech.glide.load.engine.p022a.ArrayPool
    /* renamed from: a */
    public synchronized void mo12201a(int i) {
        try {
            if (i >= 40) {
                mo12202a();
            } else if (i >= 20 || i == 15) {
                m12188c(this.f779e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* renamed from: c */
    private void m12189c() {
        m12188c(this.f779e);
    }

    /* renamed from: c */
    private void m12188c(int i) {
        while (this.f780f > i) {
            Object m12218a = this.f775a.m12218a();
            Preconditions.m11580a(m12218a);
            ArrayAdapterInterface m12190b = m12190b((LruArrayPool) m12218a);
            this.f780f -= m12190b.mo12206a((ArrayAdapterInterface) m12218a) * m12190b.mo12204b();
            m12187c(m12190b.mo12206a((ArrayAdapterInterface) m12218a), m12218a.getClass());
            if (Log.isLoggable(m12190b.mo12208a(), 2)) {
                Log.v(m12190b.mo12208a(), "evicted: " + m12190b.mo12206a((ArrayAdapterInterface) m12218a));
            }
        }
    }

    /* renamed from: c */
    private void m12187c(int i, Class<?> cls) {
        NavigableMap<Integer, Integer> m12196a = m12196a(cls);
        Integer num = (Integer) m12196a.get(Integer.valueOf(i));
        if (num == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
        } else if (num.intValue() == 1) {
            m12196a.remove(Integer.valueOf(i));
        } else {
            m12196a.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
        }
    }

    /* renamed from: a */
    private NavigableMap<Integer, Integer> m12196a(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f777c.get(cls);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.f777c.put(cls, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    /* renamed from: b */
    private <T> ArrayAdapterInterface<T> m12190b(T t) {
        return m12191b((Class) t.getClass());
    }

    /* renamed from: b */
    private <T> ArrayAdapterInterface<T> m12191b(Class<T> cls) {
        IntegerArrayAdapter integerArrayAdapter = (ArrayAdapterInterface<T>) this.f778d.get(cls);
        if (integerArrayAdapter == null) {
            if (cls.equals(int[].class)) {
                integerArrayAdapter = new IntegerArrayAdapter();
            } else if (cls.equals(byte[].class)) {
                integerArrayAdapter = new ByteArrayAdapter();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.f778d.put(cls, integerArrayAdapter);
        }
        return integerArrayAdapter;
    }

    /* compiled from: LruArrayPool.java */
    /* renamed from: com.bumptech.glide.load.engine.a.j$b */
    /* loaded from: classes.dex */
    private static final class C0694b extends BaseKeyPool<C0693a> {
        C0694b() {
        }

        /* renamed from: a */
        C0693a m12184a(int i, Class<?> cls) {
            C0693a c = m12221c();
            c.m12186a(i, cls);
            return c;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.p022a.BaseKeyPool
        /* renamed from: a */
        public C0693a mo12150b() {
            return new C0693a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LruArrayPool.java */
    /* renamed from: com.bumptech.glide.load.engine.a.j$a */
    /* loaded from: classes.dex */
    public static final class C0693a implements Poolable {

        /* renamed from: a */
        int f781a;

        /* renamed from: b */
        private final C0694b f782b;

        /* renamed from: c */
        private Class<?> f783c;

        C0693a(C0694b c0694b) {
            this.f782b = c0694b;
        }

        /* renamed from: a */
        void m12186a(int i, Class<?> cls) {
            this.f781a = i;
            this.f783c = cls;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0693a) {
                C0693a c0693a = (C0693a) obj;
                return this.f781a == c0693a.f781a && this.f783c == c0693a.f783c;
            }
            return false;
        }

        public String toString() {
            return "Key{size=" + this.f781a + "array=" + this.f783c + '}';
        }

        @Override // com.bumptech.glide.load.engine.p022a.Poolable
        /* renamed from: a */
        public void mo12154a() {
            this.f782b.m12222a(this);
        }

        public int hashCode() {
            int i = this.f781a * 31;
            Class<?> cls = this.f783c;
            return i + (cls != null ? cls.hashCode() : 0);
        }
    }
}
