package org.apache.mina.p126a.p127a;

import org.apache.mina.core.p133e.IoService;

/* renamed from: org.apache.mina.a.a.d */
/* loaded from: classes2.dex */
public class DefaultSocketSessionConfig extends AbstractSocketSessionConfig {

    /* renamed from: a */
    protected IoService f11304a;

    /* renamed from: b */
    private boolean f11305b;

    /* renamed from: c */
    private boolean f11306c;

    /* renamed from: d */
    private int f11307d = -1;

    /* renamed from: e */
    private int f11308e = -1;

    /* renamed from: f */
    private int f11309f = 0;

    /* renamed from: g */
    private boolean f11310g = false;

    /* renamed from: h */
    private boolean f11311h = false;

    /* renamed from: i */
    private int f11312i = -1;

    /* renamed from: j */
    private boolean f11313j = false;

    /* renamed from: a */
    public void m1423a(IoService ioService) {
        this.f11304a = ioService;
        if (ioService instanceof SocketAcceptor) {
            this.f11305b = true;
        } else {
            this.f11305b = false;
        }
        this.f11306c = this.f11305b;
    }

    @Override // org.apache.mina.p126a.p127a.SocketSessionConfig
    /* renamed from: p */
    public boolean mo1403p() {
        return this.f11306c;
    }

    @Override // org.apache.mina.p126a.p127a.SocketSessionConfig
    /* renamed from: b */
    public void mo1411b(boolean z) {
        this.f11306c = z;
    }

    @Override // org.apache.mina.p126a.p127a.SocketSessionConfig
    /* renamed from: q */
    public int mo1402q() {
        return this.f11307d;
    }

    @Override // org.apache.mina.p126a.p127a.SocketSessionConfig
    /* renamed from: g */
    public void mo1407g(int i) {
        this.f11307d = i;
    }

    @Override // org.apache.mina.p126a.p127a.SocketSessionConfig
    /* renamed from: r */
    public int mo1401r() {
        return this.f11308e;
    }

    @Override // org.apache.mina.p126a.p127a.SocketSessionConfig
    /* renamed from: h */
    public void mo1406h(int i) {
        this.f11308e = i;
    }

    @Override // org.apache.mina.p126a.p127a.SocketSessionConfig
    /* renamed from: s */
    public int mo1400s() {
        return this.f11309f;
    }

    @Override // org.apache.mina.p126a.p127a.SocketSessionConfig
    /* renamed from: i */
    public void mo1405i(int i) {
        this.f11309f = i;
    }

    @Override // org.apache.mina.p126a.p127a.SocketSessionConfig
    /* renamed from: t */
    public boolean mo1399t() {
        return this.f11310g;
    }

    @Override // org.apache.mina.p126a.p127a.SocketSessionConfig
    /* renamed from: c */
    public void mo1410c(boolean z) {
        this.f11310g = z;
    }

    @Override // org.apache.mina.p126a.p127a.SocketSessionConfig
    /* renamed from: u */
    public boolean mo1398u() {
        return this.f11311h;
    }

    @Override // org.apache.mina.p126a.p127a.SocketSessionConfig
    /* renamed from: d */
    public void mo1409d(boolean z) {
        this.f11311h = z;
    }

    @Override // org.apache.mina.p126a.p127a.SocketSessionConfig
    /* renamed from: v */
    public int mo1397v() {
        return this.f11312i;
    }

    @Override // org.apache.mina.p126a.p127a.SocketSessionConfig
    /* renamed from: j */
    public void mo1404j(int i) {
        this.f11312i = i;
    }

    @Override // org.apache.mina.p126a.p127a.SocketSessionConfig
    /* renamed from: w */
    public boolean mo1396w() {
        return this.f11313j;
    }

    @Override // org.apache.mina.p126a.p127a.SocketSessionConfig
    /* renamed from: e */
    public void mo1408e(boolean z) {
        this.f11313j = z;
    }

    @Override // org.apache.mina.p126a.p127a.AbstractSocketSessionConfig
    /* renamed from: h */
    protected boolean mo1422h() {
        return this.f11310g;
    }

    @Override // org.apache.mina.p126a.p127a.AbstractSocketSessionConfig
    /* renamed from: i */
    protected boolean mo1421i() {
        return this.f11311h;
    }

    @Override // org.apache.mina.p126a.p127a.AbstractSocketSessionConfig
    /* renamed from: j */
    protected boolean mo1420j() {
        return this.f11307d != -1;
    }

    @Override // org.apache.mina.p126a.p127a.AbstractSocketSessionConfig
    /* renamed from: k */
    protected boolean mo1419k() {
        return this.f11306c != this.f11305b;
    }

    @Override // org.apache.mina.p126a.p127a.AbstractSocketSessionConfig
    /* renamed from: l */
    protected boolean mo1418l() {
        return this.f11308e != -1;
    }

    @Override // org.apache.mina.p126a.p127a.AbstractSocketSessionConfig
    /* renamed from: m */
    protected boolean mo1417m() {
        return this.f11312i != -1;
    }

    @Override // org.apache.mina.p126a.p127a.AbstractSocketSessionConfig
    /* renamed from: n */
    protected boolean mo1416n() {
        return this.f11313j;
    }

    @Override // org.apache.mina.p126a.p127a.AbstractSocketSessionConfig
    /* renamed from: o */
    protected boolean mo1415o() {
        return this.f11309f != 0;
    }
}
