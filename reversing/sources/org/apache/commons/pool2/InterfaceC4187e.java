package org.apache.commons.pool2;

/* renamed from: org.apache.commons.pool2.e */
/* loaded from: classes2.dex */
public interface KeyedPooledObjectFactory<K, V> {
    /* renamed from: a */
    void mo2190a(K k, PooledObject<V> pooledObject) throws Exception;

    /* renamed from: b */
    void mo2189b(K k, PooledObject<V> pooledObject) throws Exception;

    /* renamed from: c */
    PooledObject<V> mo2188c(K k) throws Exception;

    /* renamed from: c */
    boolean mo2187c(K k, PooledObject<V> pooledObject);

    /* renamed from: d */
    void mo2186d(K k, PooledObject<V> pooledObject) throws Exception;
}
