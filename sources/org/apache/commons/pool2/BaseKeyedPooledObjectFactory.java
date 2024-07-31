package org.apache.commons.pool2;

/* renamed from: org.apache.commons.pool2.a */
/* loaded from: classes2.dex */
public abstract class BaseKeyedPooledObjectFactory<K, V> extends BaseObject implements KeyedPooledObjectFactory<K, V> {
    /* renamed from: a */
    public abstract PooledObject<V> mo2194a(V v);

    /* renamed from: a */
    public void mo2190a(K k, PooledObject<V> pooledObject) throws Exception {
    }

    /* renamed from: b */
    public abstract V mo2193b(K k) throws Exception;

    @Override // org.apache.commons.pool2.KeyedPooledObjectFactory
    /* renamed from: b */
    public void mo2189b(K k, PooledObject<V> pooledObject) throws Exception {
    }

    @Override // org.apache.commons.pool2.KeyedPooledObjectFactory
    /* renamed from: c */
    public boolean mo2187c(K k, PooledObject<V> pooledObject) {
        return true;
    }

    @Override // org.apache.commons.pool2.KeyedPooledObjectFactory
    /* renamed from: d */
    public void mo2186d(K k, PooledObject<V> pooledObject) throws Exception {
    }

    @Override // org.apache.commons.pool2.KeyedPooledObjectFactory
    /* renamed from: c */
    public PooledObject<V> mo2188c(K k) throws Exception {
        return mo2194a((BaseKeyedPooledObjectFactory<K, V>) mo2193b(k));
    }
}
