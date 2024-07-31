package android.arch.p005a.p006a;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.concurrent.Executor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: android.arch.a.a.a */
/* loaded from: classes.dex */
public class ArchTaskExecutor extends TaskExecutor {

    /* renamed from: a */
    private static volatile ArchTaskExecutor f12a;
    @NonNull

    /* renamed from: d */
    private static final Executor f13d = new Executor() { // from class: android.arch.a.a.a.1
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            ArchTaskExecutor.m12929a().mo12926b(runnable);
        }
    };
    @NonNull

    /* renamed from: e */
    private static final Executor f14e = new Executor() { // from class: android.arch.a.a.a.2
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            ArchTaskExecutor.m12929a().mo12928a(runnable);
        }
    };
    @NonNull

    /* renamed from: c */
    private TaskExecutor f16c = new DefaultTaskExecutor();
    @NonNull

    /* renamed from: b */
    private TaskExecutor f15b = this.f16c;

    private ArchTaskExecutor() {
    }

    @NonNull
    /* renamed from: a */
    public static ArchTaskExecutor m12929a() {
        if (f12a != null) {
            return f12a;
        }
        synchronized (ArchTaskExecutor.class) {
            if (f12a == null) {
                f12a = new ArchTaskExecutor();
            }
        }
        return f12a;
    }

    @Override // android.arch.p005a.p006a.TaskExecutor
    /* renamed from: a */
    public void mo12928a(Runnable runnable) {
        this.f15b.mo12928a(runnable);
    }

    @Override // android.arch.p005a.p006a.TaskExecutor
    /* renamed from: b */
    public void mo12926b(Runnable runnable) {
        this.f15b.mo12926b(runnable);
    }

    @Override // android.arch.p005a.p006a.TaskExecutor
    /* renamed from: b */
    public boolean mo12927b() {
        return this.f15b.mo12927b();
    }
}
