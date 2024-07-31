package com.bumptech.glide.load.engine.p023b;

import com.bumptech.glide.util.Preconditions;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.bumptech.glide.load.engine.b.c */
/* loaded from: classes.dex */
final class DiskCacheWriteLocker {

    /* renamed from: a */
    private final Map<String, C0702a> f816a = new HashMap();

    /* renamed from: b */
    private final C0703b f817b = new C0703b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m12148a(String str) {
        C0702a c0702a;
        synchronized (this) {
            c0702a = this.f816a.get(str);
            if (c0702a == null) {
                c0702a = this.f817b.m12146a();
                this.f816a.put(str, c0702a);
            }
            c0702a.f819b++;
        }
        c0702a.f818a.lock();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m12147b(String str) {
        C0702a c0702a;
        synchronized (this) {
            c0702a = (C0702a) Preconditions.m11580a(this.f816a.get(str));
            if (c0702a.f819b < 1) {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + c0702a.f819b);
            }
            c0702a.f819b--;
            if (c0702a.f819b == 0) {
                C0702a remove = this.f816a.remove(str);
                if (!remove.equals(c0702a)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + c0702a + ", but actually removed: " + remove + ", safeKey: " + str);
                }
                this.f817b.m12145a(remove);
            }
        }
        c0702a.f818a.unlock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskCacheWriteLocker.java */
    /* renamed from: com.bumptech.glide.load.engine.b.c$a */
    /* loaded from: classes.dex */
    public static class C0702a {

        /* renamed from: a */
        final Lock f818a = new ReentrantLock();

        /* renamed from: b */
        int f819b;

        C0702a() {
        }
    }

    /* compiled from: DiskCacheWriteLocker.java */
    /* renamed from: com.bumptech.glide.load.engine.b.c$b */
    /* loaded from: classes.dex */
    private static class C0703b {

        /* renamed from: a */
        private final Queue<C0702a> f820a = new ArrayDeque();

        C0703b() {
        }

        /* renamed from: a */
        C0702a m12146a() {
            C0702a poll;
            synchronized (this.f820a) {
                poll = this.f820a.poll();
            }
            return poll == null ? new C0702a() : poll;
        }

        /* renamed from: a */
        void m12145a(C0702a c0702a) {
            synchronized (this.f820a) {
                if (this.f820a.size() < 10) {
                    this.f820a.offer(c0702a);
                }
            }
        }
    }
}
