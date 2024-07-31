package com.bumptech.glide.load.engine.p019b;

import com.bumptech.glide.util.C0780h;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: DiskCacheWriteLocker.java */
/* renamed from: com.bumptech.glide.load.engine.b.c, reason: use source file name */
/* loaded from: classes.dex */
final class DiskCacheWriteLocker {

    /* renamed from: a */
    private final Map<String, a> f820a = new HashMap();

    /* renamed from: b */
    private final b f821b = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m837a(String str) {
        a aVar;
        synchronized (this) {
            aVar = this.f820a.get(str);
            if (aVar == null) {
                aVar = this.f821b.m839a();
                this.f820a.put(str, aVar);
            }
            aVar.f823b++;
        }
        aVar.f822a.lock();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m838b(String str) {
        a aVar;
        synchronized (this) {
            aVar = (a) C0780h.m1362a(this.f820a.get(str));
            if (aVar.f823b < 1) {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f823b);
            }
            aVar.f823b--;
            if (aVar.f823b == 0) {
                a remove = this.f820a.remove(str);
                if (!remove.equals(aVar)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", safeKey: " + str);
                }
                this.f821b.m840a(remove);
            }
        }
        aVar.f822a.unlock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskCacheWriteLocker.java */
    /* renamed from: com.bumptech.glide.load.engine.b.c$a */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        final Lock f822a = new ReentrantLock();

        /* renamed from: b */
        int f823b;

        a() {
        }
    }

    /* compiled from: DiskCacheWriteLocker.java */
    /* renamed from: com.bumptech.glide.load.engine.b.c$b */
    /* loaded from: classes.dex */
    private static class b {

        /* renamed from: a */
        private final Queue<a> f824a = new ArrayDeque();

        b() {
        }

        /* renamed from: a */
        a m839a() {
            a poll;
            synchronized (this.f824a) {
                poll = this.f824a.poll();
            }
            return poll == null ? new a() : poll;
        }

        /* renamed from: a */
        void m840a(a aVar) {
            synchronized (this.f824a) {
                if (this.f824a.size() < 10) {
                    this.f824a.offer(aVar);
                }
            }
        }
    }
}