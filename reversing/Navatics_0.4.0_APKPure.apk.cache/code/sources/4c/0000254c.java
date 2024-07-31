package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: Timeout.java */
/* renamed from: okio.r, reason: use source file name */
/* loaded from: classes2.dex */
public class Timeout {

    /* renamed from: c */
    public static final Timeout f10753c = new Timeout() { // from class: okio.r.1
        @Override // okio.Timeout
        /* renamed from: a */
        public Timeout mo10596a(long j) {
            return this;
        }

        @Override // okio.Timeout
        /* renamed from: a */
        public Timeout mo10597a(long j, TimeUnit timeUnit) {
            return this;
        }

        @Override // okio.Timeout
        /* renamed from: g */
        public void mo10600g() throws IOException {
        }
    };

    /* renamed from: a */
    private boolean f10754a;

    /* renamed from: b */
    private long f10755b;

    /* renamed from: d */
    private long f10756d;

    /* renamed from: a */
    public Timeout mo10597a(long j, TimeUnit timeUnit) {
        if (j >= 0) {
            if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            }
            this.f10756d = timeUnit.toNanos(j);
            return this;
        }
        throw new IllegalArgumentException("timeout < 0: " + j);
    }

    /* renamed from: h_ */
    public long mo10601h_() {
        return this.f10756d;
    }

    /* renamed from: i_ */
    public boolean mo10602i_() {
        return this.f10754a;
    }

    /* renamed from: d */
    public long mo10598d() {
        if (!this.f10754a) {
            throw new IllegalStateException("No deadline");
        }
        return this.f10755b;
    }

    /* renamed from: a */
    public Timeout mo10596a(long j) {
        this.f10754a = true;
        this.f10755b = j;
        return this;
    }

    /* renamed from: j_ */
    public Timeout mo10603j_() {
        this.f10756d = 0L;
        return this;
    }

    /* renamed from: f */
    public Timeout mo10599f() {
        this.f10754a = false;
        return this;
    }

    /* renamed from: g */
    public void mo10600g() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        }
        if (this.f10754a && this.f10755b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}