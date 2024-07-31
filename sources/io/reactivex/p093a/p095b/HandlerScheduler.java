package io.reactivex.p093a.p095b;

import android.os.Handler;
import android.os.Message;
import io.reactivex.AbstractC2901p;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.p098d.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

/* renamed from: io.reactivex.a.b.b */
/* loaded from: classes2.dex */
final class HandlerScheduler extends AbstractC2901p {

    /* renamed from: b */
    private final Handler f9606b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerScheduler(Handler handler) {
        this.f9606b = handler;
    }

    @Override // io.reactivex.AbstractC2901p
    /* renamed from: a */
    public Disposable mo3060a(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable != null) {
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            RunnableC2847b runnableC2847b = new RunnableC2847b(this.f9606b, RxJavaPlugins.m3234a(runnable));
            this.f9606b.postDelayed(runnableC2847b, timeUnit.toMillis(j));
            return runnableC2847b;
        }
        throw new NullPointerException("run == null");
    }

    @Override // io.reactivex.AbstractC2901p
    /* renamed from: a */
    public AbstractC2901p.AbstractC2904c mo3063a() {
        return new C2846a(this.f9606b);
    }

    /* compiled from: HandlerScheduler.java */
    /* renamed from: io.reactivex.a.b.b$a */
    /* loaded from: classes2.dex */
    private static final class C2846a extends AbstractC2901p.AbstractC2904c {

        /* renamed from: a */
        private final Handler f9607a;

        /* renamed from: b */
        private volatile boolean f9608b;

        C2846a(Handler handler) {
            this.f9607a = handler;
        }

        @Override // io.reactivex.AbstractC2901p.AbstractC2904c
        /* renamed from: a */
        public Disposable mo3056a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (runnable != null) {
                if (timeUnit == null) {
                    throw new NullPointerException("unit == null");
                }
                if (this.f9608b) {
                    return Disposables.m3222a();
                }
                RunnableC2847b runnableC2847b = new RunnableC2847b(this.f9607a, RxJavaPlugins.m3234a(runnable));
                Message obtain = Message.obtain(this.f9607a, runnableC2847b);
                obtain.obj = this;
                this.f9607a.sendMessageDelayed(obtain, timeUnit.toMillis(j));
                if (this.f9608b) {
                    this.f9607a.removeCallbacks(runnableC2847b);
                    return Disposables.m3222a();
                }
                return runnableC2847b;
            }
            throw new NullPointerException("run == null");
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f9608b = true;
            this.f9607a.removeCallbacksAndMessages(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f9608b;
        }
    }

    /* compiled from: HandlerScheduler.java */
    /* renamed from: io.reactivex.a.b.b$b */
    /* loaded from: classes2.dex */
    private static final class RunnableC2847b implements Disposable, Runnable {

        /* renamed from: a */
        private final Handler f9609a;

        /* renamed from: b */
        private final Runnable f9610b;

        /* renamed from: c */
        private volatile boolean f9611c;

        RunnableC2847b(Handler handler, Runnable runnable) {
            this.f9609a = handler;
            this.f9610b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f9610b.run();
            } catch (Throwable th) {
                RxJavaPlugins.m3233a(th);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f9611c = true;
            this.f9609a.removeCallbacks(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f9611c;
        }
    }
}
