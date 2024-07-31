package com.navatics.robot.transport;

import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/* renamed from: com.navatics.robot.transport.g */
/* loaded from: classes.dex */
public class IoBuffer implements IBuffer {

    /* renamed from: a */
    private static ObjectPool<IoBuffer> f6533a;

    /* renamed from: b */
    private byte[] f6534b;

    /* renamed from: c */
    private int f6535c;

    /* renamed from: d */
    private IBuffer f6536d;

    /* renamed from: e */
    public static IoBuffer m6281e() {
        m6279g();
        try {
            return f6533a.mo2030a();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static void m6282a(IoBuffer ioBuffer) {
        ioBuffer.f6534b = null;
        ioBuffer.f6535c = 0;
        ioBuffer.f6536d = null;
    }

    /* renamed from: f */
    private static boolean m6280f() {
        try {
            Class.forName("java.lang.management.ManagementFactory");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: g */
    private static void m6279g() {
        if (f6533a == null) {
            synchronized (IoBuffer.class) {
                if (f6533a == null) {
                    GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
                    genericObjectPoolConfig.m2117a(m6280f());
                    f6533a = new GenericObjectPool(new IoBufferFactory(), genericObjectPoolConfig);
                }
            }
        }
    }

    @Override // com.navatics.robot.transport.IBuffer
    /* renamed from: a */
    public byte[] mo6202a() {
        IBuffer iBuffer = this.f6536d;
        if (iBuffer != null) {
            return iBuffer.mo6202a();
        }
        return this.f6534b;
    }

    @Override // com.navatics.robot.transport.IBuffer
    /* renamed from: b */
    public int mo6201b() {
        IBuffer iBuffer = this.f6536d;
        if (iBuffer != null) {
            return iBuffer.mo6201b();
        }
        return this.f6534b.length;
    }

    @Override // com.navatics.robot.transport.IBuffer
    /* renamed from: c */
    public int mo6200c() {
        IBuffer iBuffer = this.f6536d;
        if (iBuffer != null) {
            return iBuffer.mo6200c();
        }
        return this.f6535c;
    }

    @Override // com.navatics.robot.transport.IBuffer
    /* renamed from: d */
    public void mo6199d() {
        IBuffer iBuffer = this.f6536d;
        if (iBuffer != null) {
            iBuffer.mo6199d();
        }
        try {
            f6533a.mo2028a(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m6283a(IBuffer iBuffer) {
        this.f6536d = iBuffer;
    }
}
