package org.apache.commons.pool2.impl;

import org.apache.commons.pool2.PooledObject;

/* renamed from: org.apache.commons.pool2.impl.i */
/* loaded from: classes2.dex */
public interface EvictionPolicy<T> {
    /* renamed from: a */
    boolean mo2077a(EvictionConfig evictionConfig, PooledObject<T> pooledObject, int i);
}
