package io.objectbox.android;

import android.os.Handler;
import android.os.Looper;
import io.objectbox.p092b.RunWithParam;
import io.objectbox.p092b.Scheduler;
import java.util.ArrayDeque;
import java.util.Deque;

/* renamed from: io.objectbox.android.b */
/* loaded from: classes2.dex */
public class AndroidScheduler extends Handler implements Scheduler {

    /* renamed from: a */
    private static AndroidScheduler f9450a;

    /* renamed from: b */
    private final Deque<RunnableC2824a> f9451b;

    /* renamed from: a */
    public static synchronized Scheduler m3382a() {
        AndroidScheduler androidScheduler;
        synchronized (AndroidScheduler.class) {
            if (f9450a == null) {
                f9450a = new AndroidScheduler(Looper.getMainLooper());
            }
            androidScheduler = f9450a;
        }
        return androidScheduler;
    }

    public AndroidScheduler(Looper looper) {
        super(looper);
        this.f9451b = new ArrayDeque();
    }

    @Override // io.objectbox.p092b.Scheduler
    /* renamed from: a */
    public <T> void mo3365a(RunWithParam runWithParam, T t) {
        RunnableC2824a poll;
        synchronized (this.f9451b) {
            poll = this.f9451b.poll();
        }
        if (poll == null) {
            poll = new RunnableC2824a();
        }
        poll.f9452a = runWithParam;
        poll.f9453b = t;
        post(poll);
    }

    /* compiled from: AndroidScheduler.java */
    /* renamed from: io.objectbox.android.b$a */
    /* loaded from: classes2.dex */
    class RunnableC2824a implements Runnable {

        /* renamed from: a */
        RunWithParam f9452a;

        /* renamed from: b */
        Object f9453b;

        RunnableC2824a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f9452a.mo3350a(this.f9453b);
            this.f9452a = null;
            this.f9453b = null;
            synchronized (AndroidScheduler.this.f9451b) {
                if (AndroidScheduler.this.f9451b.size() < 20) {
                    AndroidScheduler.this.f9451b.add(this);
                }
            }
        }
    }
}
