package com.navatics.robot.transport;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

/* renamed from: com.navatics.robot.transport.o */
/* loaded from: classes.dex */
public class NvEventFactory extends BasePooledObjectFactory<NvEvent> {
    @Override // org.apache.commons.pool2.BasePooledObjectFactory
    /* renamed from: a */
    public NvEvent mo2191b() throws Exception {
        return new NvEvent();
    }

    @Override // org.apache.commons.pool2.BasePooledObjectFactory
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public PooledObject<NvEvent> mo2192a(NvEvent nvEvent) {
        return new DefaultPooledObject(nvEvent);
    }

    @Override // org.apache.commons.pool2.BasePooledObjectFactory, org.apache.commons.pool2.PooledObjectFactory
    /* renamed from: a */
    public void mo2184a(PooledObject<NvEvent> pooledObject) throws Exception {
        NvEvent.m6258a(pooledObject.mo2097a());
    }
}
