package okhttp3.internal;

/* renamed from: okhttp3.internal.b */
/* loaded from: classes2.dex */
public abstract class NamedRunnable implements Runnable {

    /* renamed from: b */
    protected final String f10148b;

    /* renamed from: c */
    protected abstract void mo2351c();

    public NamedRunnable(String str, Object... objArr) {
        this.f10148b = C2930c.m2886a(str, objArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f10148b);
        try {
            mo2351c();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
