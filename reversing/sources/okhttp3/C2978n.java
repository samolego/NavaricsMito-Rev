package okhttp3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.RealCall;
import okhttp3.internal.C2930c;

/* compiled from: Dispatcher.java */
/* renamed from: okhttp3.n */
/* loaded from: classes2.dex */
public final class C2978n {
    @Nullable

    /* renamed from: c */
    private Runnable f10524c;
    @Nullable

    /* renamed from: d */
    private ExecutorService f10525d;

    /* renamed from: a */
    private int f10522a = 64;

    /* renamed from: b */
    private int f10523b = 5;

    /* renamed from: e */
    private final Deque<RealCall.C2992a> f10526e = new ArrayDeque();

    /* renamed from: f */
    private final Deque<RealCall.C2992a> f10527f = new ArrayDeque();

    /* renamed from: g */
    private final Deque<RealCall> f10528g = new ArrayDeque();

    /* renamed from: a */
    public synchronized ExecutorService m2545a() {
        if (this.f10525d == null) {
            this.f10525d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), C2930c.m2887a("OkHttp Dispatcher", false));
        }
        return this.f10525d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void m2543a(RealCall.C2992a c2992a) {
        if (this.f10527f.size() < this.f10522a && m2537c(c2992a) < this.f10523b) {
            this.f10527f.add(c2992a);
            m2545a().execute(c2992a);
        } else {
            this.f10526e.add(c2992a);
        }
    }

    /* renamed from: c */
    private void m2538c() {
        if (this.f10527f.size() < this.f10522a && !this.f10526e.isEmpty()) {
            Iterator<RealCall.C2992a> it = this.f10526e.iterator();
            while (it.hasNext()) {
                RealCall.C2992a next = it.next();
                if (m2537c(next) < this.f10523b) {
                    it.remove();
                    this.f10527f.add(next);
                    m2545a().execute(next);
                }
                if (this.f10527f.size() >= this.f10522a) {
                    return;
                }
            }
        }
    }

    /* renamed from: c */
    private int m2537c(RealCall.C2992a c2992a) {
        int i = 0;
        for (RealCall.C2992a c2992a2 : this.f10527f) {
            if (!c2992a2.m2352b().f10645d && c2992a2.m2353a().equals(c2992a.m2353a())) {
                i++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void m2542a(RealCall realCall) {
        this.f10528g.add(realCall);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m2540b(RealCall.C2992a c2992a) {
        m2544a(this.f10527f, c2992a, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m2539b(RealCall realCall) {
        m2544a(this.f10528g, realCall, false);
    }

    /* renamed from: a */
    private <T> void m2544a(Deque<T> deque, T t, boolean z) {
        int m2541b;
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            if (z) {
                m2538c();
            }
            m2541b = m2541b();
            runnable = this.f10524c;
        }
        if (m2541b != 0 || runnable == null) {
            return;
        }
        runnable.run();
    }

    /* renamed from: b */
    public synchronized int m2541b() {
        return this.f10527f.size() + this.f10528g.size();
    }
}
