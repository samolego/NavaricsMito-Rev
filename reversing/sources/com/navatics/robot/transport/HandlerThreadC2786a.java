package com.navatics.robot.transport;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import java.util.HashMap;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.transport.a */
/* loaded from: classes.dex */
public class AndroidHandlerThreadLooper extends HandlerThread implements Handler.Callback, IEventLooper {

    /* renamed from: a */
    private static final C3044k f6487a = C3044k.m1564a(AndroidHandlerThreadLooper.class);

    /* renamed from: b */
    private final Object f6488b;

    /* renamed from: c */
    private boolean f6489c;

    /* renamed from: d */
    private HashMap<Integer, NvEventHandler> f6490d;

    /* renamed from: e */
    private Handler f6491e;

    /* renamed from: f */
    private transient int f6492f;

    /* renamed from: g */
    private transient int f6493g;

    /* renamed from: h */
    private C2113b f6494h;

    /* renamed from: b */
    static /* synthetic */ int m6339b(AndroidHandlerThreadLooper androidHandlerThreadLooper) {
        int i = androidHandlerThreadLooper.f6493g;
        androidHandlerThreadLooper.f6493g = i + 1;
        return i;
    }

    /* renamed from: c */
    static /* synthetic */ int m6338c(AndroidHandlerThreadLooper androidHandlerThreadLooper) {
        int i = androidHandlerThreadLooper.f6493g;
        androidHandlerThreadLooper.f6493g = i - 1;
        return i;
    }

    public AndroidHandlerThreadLooper() {
        super("NvEventLooper-Android");
        this.f6488b = new Object();
        this.f6490d = new HashMap<>();
        this.f6492f = 0;
        this.f6493g = 0;
        this.f6494h = new C2113b();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            m6341a(message);
            return true;
        }
        int i = message.what;
        try {
            ((C2112a) message.obj).f6496b.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f6494h.m6337a(i);
        return true;
    }

    /* renamed from: a */
    private void m6341a(Message message) {
        NvEvent nvEvent = (NvEvent) message.obj;
        try {
            try {
                if (nvEvent.m6239c() != null) {
                    nvEvent.m6239c().mo6007a(nvEvent);
                } else {
                    NvEventHandler nvEventHandler = this.f6490d.get(Integer.valueOf(nvEvent.f6562b));
                    if (nvEventHandler != null) {
                        nvEventHandler.mo6007a(nvEvent);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            this.f6492f--;
            nvEvent.m6245b();
        }
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        this.f6491e = new Handler(getLooper(), this);
        synchronized (this.f6488b) {
            this.f6489c = true;
            this.f6488b.notifyAll();
        }
    }

    @Override // com.navatics.robot.transport.IEventLooper
    /* renamed from: a */
    public void mo6288a() throws InterruptedException {
        if (this.f6489c) {
            return;
        }
        synchronized (this.f6488b) {
            while (!this.f6489c) {
                try {
                    this.f6488b.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.navatics.robot.transport.IEventLooper
    /* renamed from: a */
    public boolean mo6287a(@NonNull NvEvent nvEvent) {
        if (!this.f6489c) {
            f6487a.mo1504b((Object) "submit event failed because looper is not ready yet.");
            nvEvent.m6245b();
            return false;
        }
        this.f6492f++;
        this.f6491e.obtainMessage(1, nvEvent).sendToTarget();
        return true;
    }

    @Override // com.navatics.robot.transport.IEventLooper
    /* renamed from: a */
    public void mo6286a(Runnable runnable) {
        if (this.f6489c) {
            C2112a m6335b = this.f6494h.m6335b(runnable);
            if (m6335b == null) {
                throw new RuntimeException("no task available");
            }
            Message obtainMessage = this.f6491e.obtainMessage(m6335b.f6495a, m6335b);
            if (obtainMessage == null) {
                throw new RuntimeException("obtainMessage id " + m6335b.f6495a + " error");
            }
            this.f6491e.sendMessage(obtainMessage);
        }
    }

    @Override // com.navatics.robot.transport.IEventLooper
    /* renamed from: a */
    public void mo6285a(Runnable runnable, long j) {
        if (this.f6489c) {
            C2112a m6335b = this.f6494h.m6335b(runnable);
            if (m6335b == null) {
                throw new RuntimeException("no task available");
            }
            Message obtainMessage = this.f6491e.obtainMessage(m6335b.f6495a, m6335b);
            if (obtainMessage == null) {
                throw new RuntimeException("obtainMessage id " + m6335b.f6495a + " error");
            }
            C3044k c3044k = f6487a;
            c3044k.mo1511a((Object) ("post task " + m6335b.f6495a + ", delay " + j));
            this.f6491e.sendMessageDelayed(obtainMessage, j);
        }
    }

    @Override // com.navatics.robot.transport.IEventLooper
    /* renamed from: b */
    public void mo6284b(Runnable runnable) {
        C2112a m6336a = this.f6494h.m6336a(runnable);
        if (m6336a != null) {
            C3044k c3044k = f6487a;
            c3044k.mo1500c((Object) ("remove task :" + m6336a.f6495a));
            this.f6491e.removeCallbacks(m6336a.f6496b);
            this.f6494h.m6337a(m6336a.f6495a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AndroidHandlerThreadLooper.java */
    /* renamed from: com.navatics.robot.transport.a$a */
    /* loaded from: classes.dex */
    public class C2112a {

        /* renamed from: a */
        int f6495a;

        /* renamed from: b */
        Runnable f6496b;

        C2112a(int i, Runnable runnable) {
            this.f6495a = i;
            this.f6496b = runnable;
        }
    }

    /* compiled from: AndroidHandlerThreadLooper.java */
    /* renamed from: com.navatics.robot.transport.a$b */
    /* loaded from: classes.dex */
    class C2113b {

        /* renamed from: a */
        int[] f6498a = new int[20];

        /* renamed from: b */
        SparseArray<C2112a> f6499b = new SparseArray<>();

        /* renamed from: c */
        HashMap<Runnable, C2112a> f6500c = new HashMap<>();

        C2113b() {
        }

        /* renamed from: a */
        C2112a m6336a(Runnable runnable) {
            return this.f6500c.get(runnable);
        }

        /* renamed from: b */
        synchronized C2112a m6335b(Runnable runnable) {
            for (int i = 2; i < this.f6498a.length; i++) {
                if (this.f6498a[i] == 0 && !AndroidHandlerThreadLooper.this.f6491e.hasMessages(i)) {
                    C2112a c2112a = new C2112a(i, runnable);
                    this.f6498a[i] = 1;
                    this.f6499b.put(i, c2112a);
                    this.f6500c.put(runnable, c2112a);
                    AndroidHandlerThreadLooper.m6339b(AndroidHandlerThreadLooper.this);
                    return c2112a;
                }
            }
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0010, code lost:
            r3.f6500c.remove(r3.f6499b.get(r4).f6496b);
            r3.f6499b.remove(r4);
            r3.f6498a[r0] = 0;
            com.navatics.robot.transport.AndroidHandlerThreadLooper.m6338c(r3.f6501d);
         */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        synchronized void m6337a(int r4) {
            /*
                r3 = this;
                monitor-enter(r3)
                r0 = 2
            L2:
                int[] r1 = r3.f6498a     // Catch: java.lang.Throwable -> L34
                int r1 = r1.length     // Catch: java.lang.Throwable -> L34
                if (r0 >= r1) goto L32
                if (r0 != r4) goto L2f
                int[] r1 = r3.f6498a     // Catch: java.lang.Throwable -> L34
                r1 = r1[r0]     // Catch: java.lang.Throwable -> L34
                r2 = 1
                if (r1 != r2) goto L2f
                android.util.SparseArray<com.navatics.robot.transport.a$a> r1 = r3.f6499b     // Catch: java.lang.Throwable -> L34
                java.lang.Object r1 = r1.get(r4)     // Catch: java.lang.Throwable -> L34
                com.navatics.robot.transport.a$a r1 = (com.navatics.robot.transport.AndroidHandlerThreadLooper.C2112a) r1     // Catch: java.lang.Throwable -> L34
                java.util.HashMap<java.lang.Runnable, com.navatics.robot.transport.a$a> r2 = r3.f6500c     // Catch: java.lang.Throwable -> L34
                java.lang.Runnable r1 = r1.f6496b     // Catch: java.lang.Throwable -> L34
                r2.remove(r1)     // Catch: java.lang.Throwable -> L34
                android.util.SparseArray<com.navatics.robot.transport.a$a> r1 = r3.f6499b     // Catch: java.lang.Throwable -> L34
                r1.remove(r4)     // Catch: java.lang.Throwable -> L34
                int[] r4 = r3.f6498a     // Catch: java.lang.Throwable -> L34
                r1 = 0
                r4[r0] = r1     // Catch: java.lang.Throwable -> L34
                com.navatics.robot.transport.a r4 = com.navatics.robot.transport.AndroidHandlerThreadLooper.this     // Catch: java.lang.Throwable -> L34
                com.navatics.robot.transport.AndroidHandlerThreadLooper.m6338c(r4)     // Catch: java.lang.Throwable -> L34
                goto L32
            L2f:
                int r0 = r0 + 1
                goto L2
            L32:
                monitor-exit(r3)
                return
            L34:
                r4 = move-exception
                monitor-exit(r3)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.navatics.robot.transport.AndroidHandlerThreadLooper.C2113b.m6337a(int):void");
        }
    }
}
