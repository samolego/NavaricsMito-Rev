package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* renamed from: okio.h */
/* loaded from: classes2.dex */
public class ForwardingTimeout extends Timeout {

    /* renamed from: a */
    private Timeout f10680a;

    public ForwardingTimeout(Timeout timeout) {
        if (timeout == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f10680a = timeout;
    }

    /* renamed from: a */
    public final Timeout m2278a() {
        return this.f10680a;
    }

    /* renamed from: a */
    public final ForwardingTimeout m2277a(Timeout timeout) {
        if (timeout == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f10680a = timeout;
        return this;
    }

    @Override // okio.Timeout
    /* renamed from: a */
    public Timeout mo2207a(long j, TimeUnit timeUnit) {
        return this.f10680a.mo2207a(j, timeUnit);
    }

    @Override // okio.Timeout
    /* renamed from: h_ */
    public long mo2211h_() {
        return this.f10680a.mo2211h_();
    }

    @Override // okio.Timeout
    /* renamed from: i_ */
    public boolean mo2210i_() {
        return this.f10680a.mo2210i_();
    }

    @Override // okio.Timeout
    /* renamed from: d */
    public long mo2213d() {
        return this.f10680a.mo2213d();
    }

    @Override // okio.Timeout
    /* renamed from: a */
    public Timeout mo2208a(long j) {
        return this.f10680a.mo2208a(j);
    }

    @Override // okio.Timeout
    /* renamed from: j_ */
    public Timeout mo2209j_() {
        return this.f10680a.mo2209j_();
    }

    @Override // okio.Timeout
    /* renamed from: f */
    public Timeout mo2212f() {
        return this.f10680a.mo2212f();
    }

    @Override // okio.Timeout
    /* renamed from: g */
    public void mo2206g() throws IOException {
        this.f10680a.mo2206g();
    }
}
