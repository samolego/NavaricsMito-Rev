package io.objectbox;

import io.objectbox.annotation.apihint.Internal;
import java.io.Closeable;
import java.io.PrintStream;
import javax.annotation.concurrent.NotThreadSafe;

@Internal
@NotThreadSafe
/* loaded from: classes2.dex */
public class Transaction implements Closeable {
    @Internal

    /* renamed from: a */
    static boolean f9438a;

    /* renamed from: b */
    private final long f9439b;

    /* renamed from: c */
    private final BoxStore f9440c;

    /* renamed from: d */
    private final boolean f9441d;

    /* renamed from: e */
    private final Throwable f9442e;

    /* renamed from: f */
    private int f9443f;

    /* renamed from: g */
    private volatile boolean f9444g;

    static native void nativeAbort(long j);

    static native int[] nativeCommit(long j);

    static native long nativeCreateCursor(long j, String str, Class cls);

    static native void nativeDestroy(long j);

    static native boolean nativeIsActive(long j);

    static native boolean nativeIsReadOnly(long j);

    static native boolean nativeIsRecycled(long j);

    static native void nativeRecycle(long j);

    static native void nativeRenew(long j);

    public Transaction(BoxStore boxStore, long j, int i) {
        this.f9440c = boxStore;
        this.f9439b = j;
        this.f9443f = i;
        this.f9441d = nativeIsReadOnly(j);
        this.f9442e = f9438a ? new Throwable() : null;
    }

    protected void finalize() throws Throwable {
        if (!this.f9444g && nativeIsActive(this.f9439b)) {
            PrintStream printStream = System.err;
            printStream.println("Transaction was not finished (initial commit count: " + this.f9443f + ").");
            if (this.f9442e != null) {
                System.err.println("Transaction was initially created here:");
                this.f9442e.printStackTrace();
            }
            System.err.flush();
        }
        close();
        super.finalize();
    }

    /* renamed from: j */
    private void m3433j() {
        if (this.f9444g) {
            throw new IllegalStateException("Transaction is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (!this.f9444g) {
            this.f9444g = true;
            this.f9440c.m3489a(this);
            if (!this.f9440c.m3473e()) {
                nativeDestroy(this.f9439b);
            }
        }
    }

    /* renamed from: a */
    public void m3443a() {
        m3433j();
        this.f9440c.m3488a(this, nativeCommit(this.f9439b));
    }

    /* renamed from: b */
    public void m3441b() {
        m3443a();
        close();
    }

    /* renamed from: c */
    public void m3440c() {
        m3433j();
        nativeAbort(this.f9439b);
    }

    /* renamed from: d */
    public void m3439d() {
        m3433j();
        nativeRecycle(this.f9439b);
    }

    /* renamed from: e */
    public void m3438e() {
        m3433j();
        this.f9443f = this.f9440c.f9412h;
        nativeRenew(this.f9439b);
    }

    /* renamed from: a */
    public <T> Cursor<T> m3442a(Class<T> cls) {
        m3433j();
        EntityInfo m3476c = this.f9440c.m3476c(cls);
        return m3476c.getCursorFactory().mo3318a(this, nativeCreateCursor(this.f9439b, m3476c.getDbName(), cls), this.f9440c);
    }

    /* renamed from: f */
    public BoxStore m3437f() {
        return this.f9440c;
    }

    /* renamed from: g */
    public boolean m3436g() {
        m3433j();
        return nativeIsRecycled(this.f9439b);
    }

    /* renamed from: h */
    public boolean m3435h() {
        return this.f9444g;
    }

    /* renamed from: i */
    public boolean m3434i() {
        return this.f9441d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TX ");
        sb.append(Long.toString(this.f9439b, 16));
        sb.append(" (");
        sb.append(this.f9441d ? "read-only" : "write");
        sb.append(", initialCommitCount=");
        sb.append(this.f9443f);
        sb.append(")");
        return sb.toString();
    }
}
