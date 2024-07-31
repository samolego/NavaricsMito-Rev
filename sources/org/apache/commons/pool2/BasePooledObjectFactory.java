package org.apache.commons.pool2;

/* renamed from: org.apache.commons.pool2.c */
/* loaded from: classes2.dex */
public abstract class BasePooledObjectFactory<T> extends BaseObject implements PooledObjectFactory<T> {
    /* renamed from: a */
    public abstract PooledObject<T> mo2192a(T t);

    /* renamed from: a */
    public void mo2184a(PooledObject<T> pooledObject) throws Exception {
    }

    /* renamed from: b */
    public abstract T mo2191b() throws Exception;

    @Override // org.apache.commons.pool2.PooledObjectFactory
    /* renamed from: b */
    public void mo2183b(PooledObject<T> pooledObject) throws Exception {
    }

    @Override // org.apache.commons.pool2.PooledObjectFactory
    /* renamed from: c */
    public boolean mo2181c(PooledObject<T> pooledObject) {
        return true;
    }

    @Override // org.apache.commons.pool2.PooledObjectFactory
    /* renamed from: d */
    public void mo2180d(PooledObject<T> pooledObject) throws Exception {
    }

    @Override // org.apache.commons.pool2.PooledObjectFactory
    /* renamed from: c */
    public PooledObject<T> mo2182c() throws Exception {
        return mo2192a((BasePooledObjectFactory<T>) mo2191b());
    }
}
