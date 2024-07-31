package com.navatics.app.framework.p054f;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

/* renamed from: com.navatics.app.framework.f.i */
/* loaded from: classes.dex */
public class NalUnitFactory extends BasePooledObjectFactory<NalUnit> {
    @Override // org.apache.commons.pool2.BasePooledObjectFactory
    /* renamed from: a */
    public NalUnit mo2191b() throws Exception {
        return new NalUnit();
    }

    @Override // org.apache.commons.pool2.BasePooledObjectFactory
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public PooledObject<NalUnit> mo2192a(NalUnit nalUnit) {
        return new DefaultPooledObject(nalUnit);
    }

    @Override // org.apache.commons.pool2.BasePooledObjectFactory, org.apache.commons.pool2.PooledObjectFactory
    /* renamed from: a */
    public void mo2184a(PooledObject<NalUnit> pooledObject) throws Exception {
        pooledObject.mo2097a().m8388c();
    }
}
