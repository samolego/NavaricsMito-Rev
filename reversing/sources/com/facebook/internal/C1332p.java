package com.facebook.internal;

import com.facebook.FacebookSdk;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;

/* renamed from: com.facebook.internal.p */
/* loaded from: classes.dex */
public class LockOnGetVariable<T> {

    /* renamed from: a */
    private T f2016a;

    /* renamed from: b */
    private CountDownLatch f2017b = new CountDownLatch(1);

    public LockOnGetVariable(final Callable<T> callable) {
        FacebookSdk.m10871f().execute(new FutureTask(new Callable<Void>() { // from class: com.facebook.internal.p.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() throws Exception {
                try {
                    LockOnGetVariable.this.f2016a = callable.call();
                    LockOnGetVariable.this.f2017b.countDown();
                    return null;
                } catch (Throwable th) {
                    LockOnGetVariable.this.f2017b.countDown();
                    throw th;
                }
            }
        }));
    }

    /* renamed from: a */
    public T m10642a() {
        m10639b();
        return this.f2016a;
    }

    /* renamed from: b */
    private void m10639b() {
        CountDownLatch countDownLatch = this.f2017b;
        if (countDownLatch == null) {
            return;
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
    }
}
