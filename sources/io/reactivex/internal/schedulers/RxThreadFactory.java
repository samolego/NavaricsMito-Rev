package io.reactivex.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;
    final boolean nonBlocking;
    final String prefix;
    final int priority;

    public RxThreadFactory(String str) {
        this(str, 5, false);
    }

    public RxThreadFactory(String str, int i) {
        this(str, i, false);
    }

    public RxThreadFactory(String str, int i, boolean z) {
        this.prefix = str;
        this.priority = i;
        this.nonBlocking = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str = this.prefix + '-' + incrementAndGet();
        Thread c2885a = this.nonBlocking ? new C2885a(runnable, str) : new Thread(runnable, str);
        c2885a.setPriority(this.priority);
        c2885a.setDaemon(true);
        return c2885a;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return "RxThreadFactory[" + this.prefix + "]";
    }

    /* renamed from: io.reactivex.internal.schedulers.RxThreadFactory$a */
    /* loaded from: classes2.dex */
    static final class C2885a extends Thread {
        C2885a(Runnable runnable, String str) {
            super(runnable, str);
        }
    }
}
