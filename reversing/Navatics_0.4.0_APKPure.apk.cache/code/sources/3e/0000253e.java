package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* compiled from: ForwardingTimeout.java */
/* renamed from: okio.h, reason: use source file name */
/* loaded from: classes2.dex */
public class ForwardingTimeout extends Timeout {

    /* renamed from: a */
    private Timeout f10721a;

    public ForwardingTimeout(Timeout timeout) {
        if (timeout == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f10721a = timeout;
    }

    /* renamed from: a */
    public final Timeout m10595a() {
        return this.f10721a;
    }

    /* renamed from: a */
    public final ForwardingTimeout m10594a(Timeout timeout) {
        if (timeout == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f10721a = timeout;
        return this;
    }

    @Override // okio.Timeout
    /* renamed from: a */
    public Timeout mo10597a(long j, TimeUnit timeUnit) {
        return this.f10721a.mo10597a(j, timeUnit);
    }

    @Override // okio.Timeout
    /* renamed from: h_ */
    public long mo10601h_() {
        return this.f10721a.mo10601h_();
    }

    @Override // okio.Timeout
    /* renamed from: i_ */
    public boolean mo10602i_() {
        return this.f10721a.mo10602i_();
    }

    @Override // okio.Timeout
    /* renamed from: d */
    public long mo10598d() {
        return this.f10721a.mo10598d();
    }

    @Override // okio.Timeout
    /* renamed from: a */
    public Timeout mo10596a(long j) {
        return this.f10721a.mo10596a(j);
    }

    @Override // okio.Timeout
    /* renamed from: j_ */
    public Timeout mo10603j_() {
        return this.f10721a.mo10603j_();
    }

    @Override // okio.Timeout
    /* renamed from: f */
    public Timeout mo10599f() {
        return this.f10721a.mo10599f();
    }

    @Override // okio.Timeout
    /* renamed from: g */
    public void mo10600g() throws IOException {
        this.f10721a.mo10600g();
    }
}