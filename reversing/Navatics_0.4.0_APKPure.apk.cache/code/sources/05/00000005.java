package android.arch.p005a.p006a;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: DefaultTaskExecutor.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: android.arch.a.a.b, reason: use source file name */
/* loaded from: classes.dex */
public class DefaultTaskExecutor extends TaskExecutor {

    /* renamed from: a */
    private final Object f17a = new Object();

    /* renamed from: b */
    private ExecutorService f18b = Executors.newFixedThreadPool(2);

    /* renamed from: c */
    @Nullable
    private volatile Handler f19c;

    @Override // android.arch.p005a.p006a.TaskExecutor
    /* renamed from: a */
    public void mo28a(Runnable runnable) {
        this.f18b.execute(runnable);
    }

    @Override // android.arch.p005a.p006a.TaskExecutor
    /* renamed from: b */
    public void mo29b(Runnable runnable) {
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
    public boolean mo30b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}