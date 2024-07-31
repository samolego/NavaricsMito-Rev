package com.twitter.sdk.android.core;

import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.internal.p079b.PreferenceStore;
import com.twitter.sdk.android.core.internal.p079b.PreferenceStoreStrategy;
import com.twitter.sdk.android.core.internal.p079b.SerializationStrategy;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.twitter.sdk.android.core.i */
/* loaded from: classes2.dex */
public class PersistedSessionManager<T extends Session> implements SessionManager<T> {

    /* renamed from: a */
    private final PreferenceStore f8445a;

    /* renamed from: b */
    private final SerializationStrategy<T> f8446b;

    /* renamed from: c */
    private final ConcurrentHashMap<Long, T> f8447c;

    /* renamed from: d */
    private final ConcurrentHashMap<Long, PreferenceStoreStrategy<T>> f8448d;

    /* renamed from: e */
    private final PreferenceStoreStrategy<T> f8449e;

    /* renamed from: f */
    private final AtomicReference<T> f8450f;

    /* renamed from: g */
    private final String f8451g;

    /* renamed from: h */
    private volatile boolean f8452h;

    public PersistedSessionManager(PreferenceStore preferenceStore, SerializationStrategy<T> serializationStrategy, String str, String str2) {
        this(preferenceStore, serializationStrategy, new ConcurrentHashMap(1), new ConcurrentHashMap(1), new PreferenceStoreStrategy(preferenceStore, serializationStrategy, str), str2);
    }

    PersistedSessionManager(PreferenceStore preferenceStore, SerializationStrategy<T> serializationStrategy, ConcurrentHashMap<Long, T> concurrentHashMap, ConcurrentHashMap<Long, PreferenceStoreStrategy<T>> concurrentHashMap2, PreferenceStoreStrategy<T> preferenceStoreStrategy, String str) {
        this.f8452h = true;
        this.f8445a = preferenceStore;
        this.f8446b = serializationStrategy;
        this.f8447c = concurrentHashMap;
        this.f8448d = concurrentHashMap2;
        this.f8449e = preferenceStoreStrategy;
        this.f8450f = new AtomicReference<>();
        this.f8451g = str;
    }

    /* renamed from: a */
    void m4555a() {
        if (this.f8452h) {
            m4551d();
        }
    }

    /* renamed from: d */
    private synchronized void m4551d() {
        if (this.f8452h) {
            m4549f();
            m4550e();
            this.f8452h = false;
        }
    }

    /* renamed from: e */
    private void m4550e() {
        T mo4214b;
        for (Map.Entry<String, ?> entry : this.f8445a.mo4481a().getAll().entrySet()) {
            if (m4553a(entry.getKey()) && (mo4214b = this.f8446b.mo4214b((String) entry.getValue())) != null) {
                m4554a(mo4214b.m4269b(), mo4214b, false);
            }
        }
    }

    /* renamed from: f */
    private void m4549f() {
        T m4478a = this.f8449e.m4478a();
        if (m4478a != null) {
            m4554a(m4478a.m4269b(), m4478a, false);
        }
    }

    /* renamed from: a */
    boolean m4553a(String str) {
        return str.startsWith(this.f8451g);
    }

    @Override // com.twitter.sdk.android.core.SessionManager
    /* renamed from: b */
    public T mo4266b() {
        m4555a();
        return this.f8450f.get();
    }

    @Override // com.twitter.sdk.android.core.SessionManager
    /* renamed from: a */
    public void mo4267a(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Session must not be null!");
        }
        m4555a();
        m4554a(t.m4269b(), t, true);
    }

    @Override // com.twitter.sdk.android.core.SessionManager
    /* renamed from: a */
    public T mo4268a(long j) {
        m4555a();
        return this.f8447c.get(Long.valueOf(j));
    }

    @Override // com.twitter.sdk.android.core.SessionManager
    /* renamed from: c */
    public Map<Long, T> mo4265c() {
        m4555a();
        return Collections.unmodifiableMap(this.f8447c);
    }

    /* renamed from: a */
    private void m4554a(long j, T t, boolean z) {
        this.f8447c.put(Long.valueOf(j), t);
        PreferenceStoreStrategy<T> preferenceStoreStrategy = this.f8448d.get(Long.valueOf(j));
        if (preferenceStoreStrategy == null) {
            preferenceStoreStrategy = new PreferenceStoreStrategy<>(this.f8445a, this.f8446b, m4552b(j));
            this.f8448d.putIfAbsent(Long.valueOf(j), preferenceStoreStrategy);
        }
        preferenceStoreStrategy.m4477a(t);
        T t2 = this.f8450f.get();
        if (t2 == null || t2.m4269b() == j || z) {
            synchronized (this) {
                this.f8450f.compareAndSet(t2, t);
                this.f8449e.m4477a(t);
            }
        }
    }

    /* renamed from: b */
    String m4552b(long j) {
        return this.f8451g + "_" + j;
    }

    @Override // com.twitter.sdk.android.core.SessionManager
    /* renamed from: c */
    public void mo4264c(long j) {
        m4555a();
        if (this.f8450f.get() != null && this.f8450f.get().m4269b() == j) {
            synchronized (this) {
                this.f8450f.set(null);
                this.f8449e.m4476b();
            }
        }
        this.f8447c.remove(Long.valueOf(j));
        PreferenceStoreStrategy<T> remove = this.f8448d.remove(Long.valueOf(j));
        if (remove != null) {
            remove.m4476b();
        }
    }
}
