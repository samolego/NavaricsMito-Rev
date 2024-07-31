package com.bumptech.glide.load.engine.p022a;

import com.bumptech.glide.load.engine.p022a.Poolable;
import com.bumptech.glide.util.C0791i;
import java.util.Queue;

/* renamed from: com.bumptech.glide.load.engine.a.d */
/* loaded from: classes.dex */
abstract class BaseKeyPool<T extends Poolable> {

    /* renamed from: a */
    private final Queue<T> f768a = C0791i.m11572a(20);

    /* renamed from: b */
    abstract T mo12150b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public T m12221c() {
        T poll = this.f768a.poll();
        return poll == null ? mo12150b() : poll;
    }

    /* renamed from: a */
    public void m12222a(T t) {
        if (this.f768a.size() < 20) {
            this.f768a.offer(t);
        }
    }
}
