package android.arch.p005a.p006a;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.concurrent.Executor;

/* compiled from: ArchTaskExecutor.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: android.arch.a.a.a, reason: use source file name */
/* loaded from: classes.dex */
public class ArchTaskExecutor extends TaskExecutor {

    /* renamed from: a */
    private static volatile ArchTaskExecutor f12a;

    /* renamed from: d */
    @NonNull
    private static final Executor f13d = new Executor() { // from class: android.arch.a.a.a.1
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            ArchTaskExecutor.m27a().mo29b(runnable);
        }
    };

    /* renamed from: e */
    @NonNull
    private static final Executor f14e = new Executor() { // from class: android.arch.a.a.a.2
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            ArchTaskExecutor.m27a().mo28a(runnable);
        }
    };

    /* renamed from: c */
    @NonNull
    private TaskExecutor f16c = new DefaultTaskExecutor();

    /* renamed from: b */
    @NonNull
    private TaskExecutor f15b = this.f16c;

    private ArchTaskExecutor() {
    }

    @NonNull
    /* renamed from: a */
    public static ArchTaskExecutor m27a() {
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
    public void mo28a(Runnable runnable) {
        this.f15b.mo28a(runnable);
    }

    @Override // android.arch.p005a.p006a.TaskExecutor
    /* renamed from: b */
    public void mo29b(Runnable runnable) {
        this.f15b.mo29b(runnable);
    }

    @Override // android.arch.p005a.p006a.TaskExecutor
    /* renamed from: b */
    public boolean mo30b() {
        return this.f15b.mo30b();
    }
}