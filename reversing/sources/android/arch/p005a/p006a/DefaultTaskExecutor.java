package android.arch.p005a.p006a;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: android.arch.a.a.b */
/* loaded from: classes.dex */
public class DefaultTaskExecutor extends TaskExecutor {

    /* renamed from: a */
    private final Object f17a = new Object();

    /* renamed from: b */
    private ExecutorService f18b = Executors.newFixedThreadPool(2);
    @Nullable

    /* renamed from: c */
    private volatile Handler f19c;

    @Override // android.arch.p005a.p006a.TaskExecutor
    /* renamed from: a */
    public void mo12928a(Runnable runnable) {
        this.f18b.execute(runnable);
    }

    @Override // android.arch.p005a.p006a.TaskExecutor
    /* renamed from: b */
    public void mo12926b(Runnable runnable) {
        if (this.f19c == null) {
            synchronized (this.f17a) {
                if (this.f19c == null) {
                    this.f19c = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.f19c.post(runnable);
    }

    @Override // android.arch.p005a.p006a.TaskExecutor
    /* renamed from: b */
    public boolean mo12927b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
