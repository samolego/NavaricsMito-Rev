package com.navatics.robot.transport.p064ss;

import com.adapt.SPM_Manager;
import com.common.SP_ACK;
import com.navatics.robot.transport.C2820g;
import com.navatics.robot.transport.InterfaceC2816c;
import com.navatics.robot.transport.IoChannel;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.apache.log4j.Logger;

/* renamed from: com.navatics.robot.transport.ss.c */
/* loaded from: classes2.dex */
public class C2844c extends IoChannel {

    /* renamed from: a */
    private static final Logger f6591a = Logger.m1561a(C2844c.class);

    /* renamed from: b */
    private int f6592b;

    /* renamed from: c */
    private int f6593c;

    /* renamed from: d */
    private ConcurrentLinkedQueue f6594d = new ConcurrentLinkedQueue();

    /* renamed from: e */
    private ConcurrentLinkedQueue f6595e = new ConcurrentLinkedQueue();

    /* renamed from: e */
    public void m6201e() throws IOException {
    }

    /* renamed from: a */
    static /* synthetic */ ConcurrentLinkedQueue m6209a(C2844c c2844c) {
        return c2844c.f6595e;
    }

    /* renamed from: b */
    static /* synthetic */ ConcurrentLinkedQueue m6206b(C2844c c2844c) {
        return c2844c.f6594d;
    }

    /* renamed from: c */
    static /* synthetic */ int m6204c(C2844c c2844c) {
        int i = c2844c.f6592b;
        c2844c.f6592b = i - 1;
        return i;
    }

    /* renamed from: d */
    static /* synthetic */ int m6202d(C2844c c2844c) {
        int i = c2844c.f6593c;
        c2844c.f6593c = i + 1;
        return i;
    }

    /* renamed from: e */
    static /* synthetic */ void m6200e(C2844c c2844c) {
        c2844c.m6198g();
    }

    /* renamed from: d */
    public static C2844c m6203d() {
        return new C2844c();
    }

    private C2844c() {
        for (int i = 0; i < 2; i++) {
            if (this.f6594d.add(new C2845a())) {
                this.f6593c++;
            }
        }
    }

    /* renamed from: a */
    public int m6208a(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return 0;
        }
        SPM_Manager.GetInstance().GetUserCmd().SendCmd((byte) -16, bArr);
        return bArr.length;
    }

    /* renamed from: a */
    public int m6207a(byte[] bArr, int i, int i2) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return 0;
        }
        C2845a c2845a = (C2845a) this.f6595e.peek();
        if (c2845a == null) {
            f6591a.mo1508a((Object) "(peek)request data but we don't have more of it");
            return 0;
        }
        int i3 = c2845a.f6597b;
        if (i3 > i2) {
            Logger logger = f6591a;
            logger.log((Object) ("provided buf length is " + i2 + ", but we need at least " + i3));
            return -53;
        }
        C2845a c2845a2 = (C2845a) this.f6595e.poll();
        if (c2845a2 == null) {
            f6591a.mo1508a((Object) "(poll)request data but we don't have more of it");
            return 0;
        }
        System.arraycopy(c2845a2.f6596a, 0, bArr, i, i3);
        this.f6595e.add(c2845a2);
        return i3;
    }

    /* renamed from: a */
    public int mo6351a(C2820g c2820g) throws IOException {
        if (c2820g == null) {
            f6591a.log((Object) "readBuffer invalid param, buf is null.");
            return 0;
        } else if (c2820g.mo6283a() == null) {
            C2845a c2845a = (C2845a) this.f6595e.poll();
            if (c2845a == null) {
                if (m6350b() == IoChannel.IoMode.NONBLOCKING) {
                    f6591a.mo1508a((Object) "(poll,rb)request data but we don't have more of it");
                    return 0;
                }
                throw new IOException("Blocking read is not implemented yet.");
            }
            c2820g.m6282a(c2845a);
            return c2845a.f6597b;
        } else {
            return m6207a(c2820g.mo6283a(), 0, c2820g.mo6280b());
        }
    }

    /* renamed from: f */
    private int m6199f() {
        return !this.f6595e.isEmpty() ? 2 : 0;
    }

    /* renamed from: c */
    public int mo6349c() {
        SP_ACK GetAckInfo = SPM_Manager.GetInstance().GetUserCmd().GetAckInfo();
        if (GetAckInfo == null || GetAckInfo.parameters == null || GetAckInfo.parameters.length == 0) {
            long a = m6354a();
            m6353a(15 + a);
            if (a > 250) {
                m6353a(250L);
            }
            return m6199f() | 1;
        }
        C2845a c2845a = (C2845a) this.f6594d.poll();
        if (c2845a == null) {
            f6591a.mo1496d("[" + this + "] data available but we don't have free buffer now, discard it.");
            return m6199f() | 1;
        }
        byte[] bArr = GetAckInfo.parameters;
        int length = bArr.length;
        if (length > c2845a.f6596a.length) {
            f6591a.mo1496d("the available data packet size is larger than per buffer size, will discard this data, pls offer a bigger buffer");
            this.f6594d.add(c2845a);
            return m6199f() | 1;
        }
        this.f6593c--;
        System.arraycopy(bArr, 0, c2845a.f6596a, 0, length);
        c2845a.f6597b = length;
        this.f6595e.add(c2845a);
        this.f6592b++;
        m6198g();
        m6353a(15L);
        return 3;
    }

    /* renamed from: g */
    private void m6198g() {
        if (this.f6592b + this.f6593c == 2) {
            return;
        }
        throw new RuntimeException("wtf ?! bufInUsed + bufFreed = " + (this.f6592b + this.f6593c) + ", but MAX_BUFFER_CNT is2");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SenseThinkIoChannel.java */
    /* renamed from: com.navatics.robot.transport.ss.c$a */
    /* loaded from: classes2.dex */
    public class C2845a implements InterfaceC2816c {

        /* renamed from: a */
        byte[] f6596a = new byte[1024];

        /* renamed from: b */
        int f6597b;

        C2845a() {
        }

        /* renamed from: a */
        public byte[] mo6283a() {
            return this.f6596a;
        }

        /* renamed from: b */
        public int mo6280b() {
            return this.f6596a.length;
        }

        /* renamed from: c */
        public int mo6279c() {
            return this.f6597b;
        }

        /* renamed from: d */
        public void mo6278d() {
            C2844c.m6209a(C2844c.this).remove(this);
            C2844c.m6206b(C2844c.this).add(this);
            C2844c.m6204c(C2844c.this);
            C2844c.m6202d(C2844c.this);
            C2844c.m6200e(C2844c.this);
        }
    }
}
