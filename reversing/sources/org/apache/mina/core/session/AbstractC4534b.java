package org.apache.mina.core.session;

/* renamed from: org.apache.mina.core.session.b */
/* loaded from: classes2.dex */
public abstract class AbstractIoSessionConfig implements IoSessionConfig {

    /* renamed from: d */
    private int f11515d;

    /* renamed from: e */
    private int f11516e;

    /* renamed from: f */
    private int f11517f;

    /* renamed from: h */
    private boolean f11519h;

    /* renamed from: a */
    private int f11512a = 64;

    /* renamed from: b */
    private int f11513b = 2048;

    /* renamed from: c */
    private int f11514c = 65536;

    /* renamed from: g */
    private int f11518g = 60;

    /* renamed from: i */
    private int f11520i = 3;

    @Override // org.apache.mina.core.session.IoSessionConfig
    /* renamed from: a */
    public void mo978a(IoSessionConfig ioSessionConfig) {
        if (ioSessionConfig == null) {
            throw new IllegalArgumentException("config");
        }
        mo981a(ioSessionConfig.mo982a());
        m1039b(ioSessionConfig.mo977b());
        m1038c(ioSessionConfig.mo975c());
        mo979a(IdleStatus.f11537c, ioSessionConfig.mo980a(IdleStatus.f11537c));
        mo979a(IdleStatus.f11535a, ioSessionConfig.mo980a(IdleStatus.f11535a));
        mo979a(IdleStatus.f11536b, ioSessionConfig.mo980a(IdleStatus.f11536b));
        m1041a_(ioSessionConfig.mo974d());
        m1040a_(ioSessionConfig.mo971f());
        m1037f(ioSessionConfig.mo970g());
    }

    @Override // org.apache.mina.core.session.IoSessionConfig
    /* renamed from: a */
    public int mo982a() {
        return this.f11513b;
    }

    @Override // org.apache.mina.core.session.IoSessionConfig
    /* renamed from: a */
    public void mo981a(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("readBufferSize: " + i + " (expected: 1+)");
        }
        this.f11513b = i;
    }

    @Override // org.apache.mina.core.session.IoSessionConfig
    /* renamed from: b */
    public int mo977b() {
        return this.f11512a;
    }

    /* renamed from: b */
    public void m1039b(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("minReadBufferSize: " + i + " (expected: 1+)");
        } else if (i > this.f11514c) {
            throw new IllegalArgumentException("minReadBufferSize: " + i + " (expected: smaller than " + this.f11514c + ')');
        } else {
            this.f11512a = i;
        }
    }

    @Override // org.apache.mina.core.session.IoSessionConfig
    /* renamed from: c */
    public int mo975c() {
        return this.f11514c;
    }

    /* renamed from: c */
    public void m1038c(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxReadBufferSize: " + i + " (expected: 1+)");
        } else if (i < this.f11512a) {
            throw new IllegalArgumentException("maxReadBufferSize: " + i + " (expected: greater than " + this.f11512a + ')');
        } else {
            this.f11514c = i;
        }
    }

    @Override // org.apache.mina.core.session.IoSessionConfig
    /* renamed from: a */
    public int mo980a(IdleStatus idleStatus) {
        if (idleStatus == IdleStatus.f11537c) {
            return this.f11517f;
        }
        if (idleStatus == IdleStatus.f11535a) {
            return this.f11515d;
        }
        if (idleStatus == IdleStatus.f11536b) {
            return this.f11516e;
        }
        throw new IllegalArgumentException("Unknown idle status: " + idleStatus);
    }

    @Override // org.apache.mina.core.session.IoSessionConfig
    /* renamed from: b */
    public long mo976b(IdleStatus idleStatus) {
        return mo980a(idleStatus) * 1000;
    }

    @Override // org.apache.mina.core.session.IoSessionConfig
    /* renamed from: a */
    public void mo979a(IdleStatus idleStatus, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Illegal idle time: " + i);
        } else if (idleStatus == IdleStatus.f11537c) {
            this.f11517f = i;
        } else if (idleStatus == IdleStatus.f11535a) {
            this.f11515d = i;
        } else if (idleStatus == IdleStatus.f11536b) {
            this.f11516e = i;
        } else {
            throw new IllegalArgumentException("Unknown idle status: " + idleStatus);
        }
    }

    @Override // org.apache.mina.core.session.IoSessionConfig
    /* renamed from: d */
    public void mo973d(int i) {
        mo979a(IdleStatus.f11537c, i);
    }

    @Override // org.apache.mina.core.session.IoSessionConfig
    /* renamed from: d */
    public int mo974d() {
        return this.f11518g;
    }

    @Override // org.apache.mina.core.session.IoSessionConfig
    /* renamed from: e */
    public long mo972e() {
        return this.f11518g * 1000;
    }

    /* renamed from: a_ */
    public void m1041a_(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Illegal write timeout: " + i);
        }
        this.f11518g = i;
    }

    @Override // org.apache.mina.core.session.IoSessionConfig
    /* renamed from: f */
    public boolean mo971f() {
        return this.f11519h;
    }

    /* renamed from: a_ */
    public void m1040a_(boolean z) {
        this.f11519h = z;
    }

    @Override // org.apache.mina.core.session.IoSessionConfig
    /* renamed from: g */
    public int mo970g() {
        return this.f11520i;
    }

    /* renamed from: f */
    public void m1037f(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("throughputCalculationInterval: " + i);
        }
        this.f11520i = i;
    }
}
