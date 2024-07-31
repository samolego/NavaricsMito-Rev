package com.navatics.app.framework.p054f;

import java.nio.ByteBuffer;
import java.security.InvalidParameterException;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.mp4parser.streaming.input.h264.H264NalUnitHeader;

/* renamed from: com.navatics.app.framework.f.h */
/* loaded from: classes.dex */
public class NalUnit {

    /* renamed from: f */
    private static ObjectPool<NalUnit> f4490f;

    /* renamed from: a */
    private byte[] f4491a;

    /* renamed from: b */
    private ByteBuffer f4492b;

    /* renamed from: c */
    private ByteBuffer f4493c;

    /* renamed from: d */
    private int f4494d;

    /* renamed from: e */
    private H264NalUnitHeader f4495e;

    /* renamed from: e */
    private static boolean m8386e() {
        try {
            Class.forName("java.lang.management.ManagementFactory");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: f */
    private static void m8385f() {
        if (f4490f == null) {
            synchronized (NalUnit.class) {
                if (f4490f == null) {
                    GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
                    genericObjectPoolConfig.m2011a(20);
                    genericObjectPoolConfig.m2117a(m8386e());
                    f4490f = new GenericObjectPool(new NalUnitFactory(), genericObjectPoolConfig);
                }
            }
        }
    }

    /* renamed from: a */
    public static NalUnit m8391a(byte[] bArr, int i) {
        m8385f();
        try {
            NalUnit mo2030a = f4490f.mo2030a();
            mo2030a.m8389b(bArr, i);
            return mo2030a;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    private void m8389b(byte[] bArr, int i) {
        this.f4491a = bArr;
        this.f4492b = ByteBuffer.wrap(bArr);
        this.f4494d = i;
        if (i != 3 && i != 4 && i != 0) {
            throw new InvalidParameterException("The startCodeSize must be 3 or 4 or 0");
        }
        if (i > 0) {
            if (i == 3) {
                this.f4492b.position(3);
            } else {
                this.f4492b.position(4);
            }
            this.f4493c = this.f4492b.slice();
            this.f4492b.rewind();
        } else {
            this.f4493c = this.f4492b;
        }
        this.f4495e = m8393a(this.f4493c);
    }

    /* renamed from: a */
    private H264NalUnitHeader m8393a(ByteBuffer byteBuffer) {
        H264NalUnitHeader h264NalUnitHeader = new H264NalUnitHeader();
        byte b = byteBuffer.get(0);
        h264NalUnitHeader.f12221a = (b >> 5) & 3;
        h264NalUnitHeader.f12222b = b & 31;
        return h264NalUnitHeader;
    }

    /* renamed from: a */
    public H264NalUnitHeader m8394a() {
        return this.f4495e;
    }

    /* renamed from: b */
    public byte[] m8390b() {
        return this.f4491a;
    }

    /* renamed from: a */
    public ByteBuffer m8392a(boolean z) {
        return z ? this.f4492b : this.f4493c;
    }

    /* renamed from: c */
    public void m8388c() {
        this.f4492b = null;
        this.f4493c = null;
        this.f4494d = 0;
        this.f4495e = null;
    }

    /* renamed from: d */
    public void m8387d() {
        try {
            f4490f.mo2028a(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
