package com.navatics.robot.transport;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

/* renamed from: com.navatics.robot.transport.h */
/* loaded from: classes.dex */
public class IoBufferFactory extends BasePooledObjectFactory<IoBuffer> {
    @Override // org.apache.commons.pool2.BasePooledObjectFactory
    /* renamed from: a */
    public IoBuffer mo2191b() throws Exception {
        return new IoBuffer();
    }

    @Override // org.apache.commons.pool2.BasePooledObjectFactory
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public PooledObject<IoBuffer> mo2192a(IoBuffer ioBuffer) {
        return new DefaultPooledObject(ioBuffer);
    }

    @Override // org.apache.commons.pool2.BasePooledObjectFactory, org.apache.commons.pool2.PooledObjectFactory
    /* renamed from: a */
    public void mo2184a(PooledObject<IoBuffer> pooledObject) throws Exception {
        IoBuffer.m6282a(pooledObject.mo2097a());
    }
}
