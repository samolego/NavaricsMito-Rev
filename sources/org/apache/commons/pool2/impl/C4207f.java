package org.apache.commons.pool2.impl;

import org.apache.commons.pool2.PooledObject;

/* renamed from: org.apache.commons.pool2.impl.f */
/* loaded from: classes2.dex */
public class DefaultEvictionPolicy<T> implements EvictionPolicy<T> {
    @Override // org.apache.commons.pool2.impl.EvictionPolicy
    /* renamed from: a */
    public boolean mo2077a(EvictionConfig evictionConfig, PooledObject<T> pooledObject, int i) {
        return (evictionConfig.m2079b() < pooledObject.mo2090c() && evictionConfig.m2078c() < i) || evictionConfig.m2080a() < pooledObject.mo2090c();
    }
}
