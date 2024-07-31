package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* renamed from: okio.r */
/* loaded from: classes2.dex */
public class Timeout {

    /* renamed from: c */
    public static final Timeout f10712c = new Timeout() { // from class: okio.r.1
        @Override // okio.Timeout
        /* renamed from: a */
        public Timeout mo2208a(long j) {
            return this;
        }

        @Override // okio.Timeout
        /* renamed from: a */
        public Timeout mo2207a(long j, TimeUnit timeUnit) {
            return this;
        }

        @Override // okio.Timeout
        /* renamed from: g */
        public void mo2206g() throws IOException {
        }
    };

    /* renamed from: a */
    private boolean f10713a;

    /* renamed from: b */
    private long f10714b;

    /* renamed from: d */
    private long f10715d;

    /* renamed from: a */
    public Timeout mo2207a(long j, TimeUnit timeUnit) {
        if (j >= 0) {
            if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            }
            this.f10715d = timeUnit.toNanos(j);
            return this;
        }
        throw new IllegalArgumentException("timeout < 0: " + j);
    }

    /* renamed from: h_ */
    public long mo2211h_() {
        return this.f10715d;
    }

    /* renamed from: i_ */
    public boolean mo2210i_() {
        return this.f10713a;
    }

    /* renamed from: d */
    public long mo2213d() {
        if (!this.f10713a) {
            throw new IllegalStateException("No deadline");
        }
        return this.f10714b;
    }

    /* renamed from: a */
    public Timeout mo2208a(long j) {
        this.f10713a = true;
        this.f10714b = j;
        return this;
    }

    /* renamed from: j_ */
    public Timeout mo2209j_() {
        this.f10715d = 0L;
        return this;
    }

    /* renamed from: f */
    public Timeout mo2212f() {
        this.f10713a = false;
        return this;
    }

    /* renamed from: g */
    public void mo2206g() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        }
        if (this.f10713a && this.f10714b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
