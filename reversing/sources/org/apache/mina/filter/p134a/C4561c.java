package org.apache.mina.filter.p134a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.mina.core.session.AttributeKey;
import org.apache.mina.core.session.DummySession;
import org.apache.mina.core.session.IoEvent;
import org.apache.mina.core.session.IoSession;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.mina.filter.a.c */
/* loaded from: classes2.dex */
public class OrderedThreadPoolExecutor extends ThreadPoolExecutor {

    /* renamed from: a */
    private static final InterfaceC3153b f11554a = C3154c.m262a(OrderedThreadPoolExecutor.class);

    /* renamed from: b */
    private static final IoSession f11555b = new DummySession();

    /* renamed from: c */
    private final AttributeKey f11556c;

    /* renamed from: d */
    private final BlockingQueue<IoSession> f11557d;

    /* renamed from: e */
    private final Set<RunnableC3092b> f11558e;

    /* renamed from: f */
    private volatile int f11559f;

    /* renamed from: g */
    private final AtomicInteger f11560g;

    /* renamed from: h */
    private long f11561h;

    /* renamed from: i */
    private volatile boolean f11562i;

    /* renamed from: j */
    private final IoEventQueueHandler f11563j;

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void purge() {
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler) {
    }

    public OrderedThreadPoolExecutor() {
        this(0, 16, 30L, TimeUnit.SECONDS, Executors.defaultThreadFactory(), null);
    }

    public OrderedThreadPoolExecutor(int i) {
        this(0, i, 30L, TimeUnit.SECONDS, Executors.defaultThreadFactory(), null);
    }

    public OrderedThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, ThreadFactory threadFactory, IoEventQueueHandler ioEventQueueHandler) {
        super(0, 1, j, timeUnit, new SynchronousQueue(), threadFactory, new ThreadPoolExecutor.AbortPolicy());
        this.f11556c = new AttributeKey(getClass(), "tasksQueue");
        this.f11557d = new LinkedBlockingQueue();
        this.f11558e = new HashSet();
        this.f11560g = new AtomicInteger();
        if (i < 0) {
            throw new IllegalArgumentException("corePoolSize: " + i);
        } else if (i2 == 0 || i2 < i) {
            throw new IllegalArgumentException("maximumPoolSize: " + i2);
        } else {
            super.setCorePoolSize(i);
            super.setMaximumPoolSize(i2);
            if (ioEventQueueHandler == null) {
                this.f11563j = IoEventQueueHandler.f11553a;
            } else {
                this.f11563j = ioEventQueueHandler;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public C3091a m941a(IoSession ioSession) {
        C3091a c3091a = (C3091a) ioSession.mo1009b(this.f11556c);
        if (c3091a == null) {
            C3091a c3091a2 = new C3091a();
            C3091a c3091a3 = (C3091a) ioSession.mo1005c(this.f11556c, c3091a2);
            return c3091a3 != null ? c3091a3 : c3091a2;
        }
        return c3091a;
    }

    /* renamed from: a */
    public IoEventQueueHandler m944a() {
        return this.f11563j;
    }

    /* renamed from: c */
    private void m931c() {
        synchronized (this.f11558e) {
            if (this.f11558e.size() >= super.getMaximumPoolSize()) {
                return;
            }
            RunnableC3092b runnableC3092b = new RunnableC3092b();
            Thread newThread = getThreadFactory().newThread(runnableC3092b);
            this.f11560g.incrementAndGet();
            newThread.start();
            this.f11558e.add(runnableC3092b);
            if (this.f11558e.size() > this.f11559f) {
                this.f11559f = this.f11558e.size();
            }
        }
    }

    /* renamed from: d */
    private void m929d() {
        if (this.f11560g.get() == 0) {
            synchronized (this.f11558e) {
                if (this.f11558e.isEmpty() || this.f11560g.get() == 0) {
                    m931c();
                }
            }
        }
    }

    /* renamed from: e */
    private void m927e() {
        synchronized (this.f11558e) {
            if (this.f11558e.size() <= super.getCorePoolSize()) {
                return;
            }
            this.f11557d.offer(f11555b);
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public int getMaximumPoolSize() {
        return super.getMaximumPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setMaximumPoolSize(int i) {
        if (i <= 0 || i < super.getCorePoolSize()) {
            throw new IllegalArgumentException("maximumPoolSize: " + i);
        }
        synchronized (this.f11558e) {
            super.setMaximumPoolSize(i);
            for (int size = this.f11558e.size() - i; size > 0; size--) {
                m927e();
            }
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis() + timeUnit.toMillis(j);
        synchronized (this.f11558e) {
            while (!isTerminated()) {
                long currentTimeMillis2 = currentTimeMillis - System.currentTimeMillis();
                if (currentTimeMillis2 <= 0) {
                    break;
                }
                this.f11558e.wait(currentTimeMillis2);
            }
        }
        return isTerminated();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f11562i;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        boolean isEmpty;
        if (this.f11562i) {
            synchronized (this.f11558e) {
                isEmpty = this.f11558e.isEmpty();
            }
            return isEmpty;
        }
        return false;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        if (this.f11562i) {
            return;
        }
        this.f11562i = true;
        synchronized (this.f11558e) {
            for (int size = this.f11558e.size(); size > 0; size--) {
                this.f11557d.offer(f11555b);
            }
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        shutdown();
        ArrayList arrayList = new ArrayList();
        while (true) {
            IoSession poll = this.f11557d.poll();
            if (poll == null) {
                return arrayList;
            }
            IoSession ioSession = f11555b;
            if (poll == ioSession) {
                this.f11557d.offer(ioSession);
                Thread.yield();
            } else {
                C3091a c3091a = (C3091a) poll.mo1009b(this.f11556c);
                synchronized (c3091a.f11565b) {
                    for (Runnable runnable : c3091a.f11565b) {
                        m944a().mo945c(this, (IoEvent) runnable);
                        arrayList.add(runnable);
                    }
                    c3091a.f11565b.clear();
                }
            }
        }
    }

    /* renamed from: a */
    private void m942a(Queue<Runnable> queue, IoEvent ioEvent) {
        StringBuilder sb = new StringBuilder();
        sb.append("Adding event ");
        sb.append(ioEvent.m1022c());
        sb.append(" to session ");
        sb.append(ioEvent.m1021d().mo999g());
        sb.append("\nQueue : [");
        boolean z = true;
        for (Runnable runnable : queue) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(((IoEvent) runnable).m1022c());
            sb.append(", ");
        }
        sb.append("]\n");
        f11554a.debug(sb.toString());
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (this.f11562i) {
            m943a(runnable);
        }
        m934b(runnable);
        IoEvent ioEvent = (IoEvent) runnable;
        IoSession m1021d = ioEvent.m1021d();
        C3091a m941a = m941a(m1021d);
        Queue<Runnable> queue = m941a.f11565b;
        boolean mo947a = this.f11563j.mo947a(this, ioEvent);
        boolean z = false;
        if (mo947a) {
            synchronized (queue) {
                queue.offer(ioEvent);
                if (m941a.f11566c) {
                    m941a.f11566c = false;
                    z = true;
                }
                if (f11554a.isDebugEnabled()) {
                    m942a(queue, ioEvent);
                }
            }
        }
        if (z) {
            this.f11557d.offer(m1021d);
        }
        m929d();
        if (mo947a) {
            this.f11563j.mo946b(this, ioEvent);
        }
    }

    /* renamed from: a */
    private void m943a(Runnable runnable) {
        getRejectedExecutionHandler().rejectedExecution(runnable, this);
    }

    /* renamed from: b */
    private void m934b(Runnable runnable) {
        if (!(runnable instanceof IoEvent)) {
            throw new IllegalArgumentException("task must be an IoEvent or its subclass.");
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public int getActiveCount() {
        int size;
        synchronized (this.f11558e) {
            size = this.f11558e.size() - this.f11560g.get();
        }
        return size;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public long getCompletedTaskCount() {
        long j;
        synchronized (this.f11558e) {
            j = this.f11561h;
            for (RunnableC3092b runnableC3092b : this.f11558e) {
                j += runnableC3092b.f11568b.get();
            }
        }
        return j;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public int getLargestPoolSize() {
        return this.f11559f;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public int getPoolSize() {
        int size;
        synchronized (this.f11558e) {
            size = this.f11558e.size();
        }
        return size;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public long getTaskCount() {
        return getCompletedTaskCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public boolean isTerminating() {
        boolean z;
        synchronized (this.f11558e) {
            z = isShutdown() && !isTerminated();
        }
        return z;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public int prestartAllCoreThreads() {
        int i;
        synchronized (this.f11558e) {
            i = 0;
            for (int corePoolSize = super.getCorePoolSize() - this.f11558e.size(); corePoolSize > 0; corePoolSize--) {
                m931c();
                i++;
            }
        }
        return i;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public boolean prestartCoreThread() {
        synchronized (this.f11558e) {
            if (this.f11558e.size() < super.getCorePoolSize()) {
                m931c();
                return true;
            }
            return false;
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public BlockingQueue<Runnable> getQueue() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public boolean remove(Runnable runnable) {
        boolean remove;
        m934b(runnable);
        IoEvent ioEvent = (IoEvent) runnable;
        C3091a c3091a = (C3091a) ioEvent.m1021d().mo1009b(this.f11556c);
        if (c3091a == null) {
            return false;
        }
        Queue queue = c3091a.f11565b;
        synchronized (queue) {
            remove = queue.remove(runnable);
        }
        if (remove) {
            m944a().mo945c(this, ioEvent);
        }
        return remove;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public int getCorePoolSize() {
        return super.getCorePoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setCorePoolSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("corePoolSize: " + i);
        } else if (i > super.getMaximumPoolSize()) {
            throw new IllegalArgumentException("corePoolSize exceeds maximumPoolSize");
        } else {
            synchronized (this.f11558e) {
                if (super.getCorePoolSize() > i) {
                    for (int corePoolSize = super.getCorePoolSize() - i; corePoolSize > 0; corePoolSize--) {
                        m927e();
                    }
                }
                super.setCorePoolSize(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OrderedThreadPoolExecutor.java */
    /* renamed from: org.apache.mina.filter.a.c$b */
    /* loaded from: classes2.dex */
    public class RunnableC3092b implements Runnable {

        /* renamed from: b */
        private AtomicLong f11568b;

        /* renamed from: c */
        private Thread f11569c;

        private RunnableC3092b() {
            this.f11568b = new AtomicLong(0L);
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x002e, code lost:
            r7.f11567a.f11558e.remove(r7);
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r7 = this;
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r7.f11569c = r0
            L6:
                org.apache.mina.core.session.g r0 = r7.m922a()     // Catch: java.lang.Throwable -> L94
                org.apache.mina.filter.a.c r1 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.this     // Catch: java.lang.Throwable -> L94
                java.util.concurrent.atomic.AtomicInteger r1 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.m940a(r1)     // Catch: java.lang.Throwable -> L94
                r1.decrementAndGet()     // Catch: java.lang.Throwable -> L94
                if (r0 != 0) goto L3e
                org.apache.mina.filter.a.c r1 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.this     // Catch: java.lang.Throwable -> L94
                java.util.Set r1 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.m933b(r1)     // Catch: java.lang.Throwable -> L94
                monitor-enter(r1)     // Catch: java.lang.Throwable -> L94
                org.apache.mina.filter.a.c r2 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.this     // Catch: java.lang.Throwable -> L3b
                java.util.Set r2 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.m933b(r2)     // Catch: java.lang.Throwable -> L3b
                int r2 = r2.size()     // Catch: java.lang.Throwable -> L3b
                org.apache.mina.filter.a.c r3 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.this     // Catch: java.lang.Throwable -> L3b
                int r3 = r3.getCorePoolSize()     // Catch: java.lang.Throwable -> L3b
                if (r2 <= r3) goto L39
                org.apache.mina.filter.a.c r0 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.this     // Catch: java.lang.Throwable -> L3b
                java.util.Set r0 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.m933b(r0)     // Catch: java.lang.Throwable -> L3b
                r0.remove(r7)     // Catch: java.lang.Throwable -> L3b
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L3b
                goto L44
            L39:
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L3b
                goto L3e
            L3b:
                r0 = move-exception
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L3b
                throw r0     // Catch: java.lang.Throwable -> L94
            L3e:
                org.apache.mina.core.session.g r1 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.m935b()     // Catch: java.lang.Throwable -> L94
                if (r0 != r1) goto L72
            L44:
                org.apache.mina.filter.a.c r0 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.this
                java.util.Set r1 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.m933b(r0)
                monitor-enter(r1)
                org.apache.mina.filter.a.c r0 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.this     // Catch: java.lang.Throwable -> L6f
                java.util.Set r0 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.m933b(r0)     // Catch: java.lang.Throwable -> L6f
                r0.remove(r7)     // Catch: java.lang.Throwable -> L6f
                org.apache.mina.filter.a.c r0 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.this     // Catch: java.lang.Throwable -> L6f
                long r2 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.m930c(r0)     // Catch: java.lang.Throwable -> L6f
                java.util.concurrent.atomic.AtomicLong r4 = r7.f11568b     // Catch: java.lang.Throwable -> L6f
                long r4 = r4.get()     // Catch: java.lang.Throwable -> L6f
                long r2 = r2 + r4
                org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.m939a(r0, r2)     // Catch: java.lang.Throwable -> L6f
                org.apache.mina.filter.a.c r0 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.this     // Catch: java.lang.Throwable -> L6f
                java.util.Set r0 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.m933b(r0)     // Catch: java.lang.Throwable -> L6f
                r0.notifyAll()     // Catch: java.lang.Throwable -> L6f
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L6f
                return
            L6f:
                r0 = move-exception
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L6f
                throw r0
            L72:
                if (r0 == 0) goto L89
                org.apache.mina.filter.a.c r1 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.this     // Catch: java.lang.Throwable -> L7e
                org.apache.mina.filter.a.c$a r0 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.m936a(r1, r0)     // Catch: java.lang.Throwable -> L7e
                r7.m920a(r0)     // Catch: java.lang.Throwable -> L7e
                goto L89
            L7e:
                r0 = move-exception
                org.apache.mina.filter.a.c r1 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.this     // Catch: java.lang.Throwable -> L94
                java.util.concurrent.atomic.AtomicInteger r1 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.m940a(r1)     // Catch: java.lang.Throwable -> L94
                r1.incrementAndGet()     // Catch: java.lang.Throwable -> L94
                throw r0     // Catch: java.lang.Throwable -> L94
            L89:
                org.apache.mina.filter.a.c r0 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.this     // Catch: java.lang.Throwable -> L94
                java.util.concurrent.atomic.AtomicInteger r0 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.m940a(r0)     // Catch: java.lang.Throwable -> L94
                r0.incrementAndGet()     // Catch: java.lang.Throwable -> L94
                goto L6
            L94:
                r0 = move-exception
                org.apache.mina.filter.a.c r1 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.this
                java.util.Set r1 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.m933b(r1)
                monitor-enter(r1)
                org.apache.mina.filter.a.c r2 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.this     // Catch: java.lang.Throwable -> Lc0
                java.util.Set r2 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.m933b(r2)     // Catch: java.lang.Throwable -> Lc0
                r2.remove(r7)     // Catch: java.lang.Throwable -> Lc0
                org.apache.mina.filter.a.c r2 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.this     // Catch: java.lang.Throwable -> Lc0
                long r3 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.m930c(r2)     // Catch: java.lang.Throwable -> Lc0
                java.util.concurrent.atomic.AtomicLong r5 = r7.f11568b     // Catch: java.lang.Throwable -> Lc0
                long r5 = r5.get()     // Catch: java.lang.Throwable -> Lc0
                long r3 = r3 + r5
                org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.m939a(r2, r3)     // Catch: java.lang.Throwable -> Lc0
                org.apache.mina.filter.a.c r2 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.this     // Catch: java.lang.Throwable -> Lc0
                java.util.Set r2 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.m933b(r2)     // Catch: java.lang.Throwable -> Lc0
                r2.notifyAll()     // Catch: java.lang.Throwable -> Lc0
                monitor-exit(r1)     // Catch: java.lang.Throwable -> Lc0
                throw r0
            Lc0:
                r0 = move-exception
                monitor-exit(r1)     // Catch: java.lang.Throwable -> Lc0
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.RunnableC3092b.run():void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x002e, code lost:
            return r5;
         */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private org.apache.mina.core.session.IoSession m922a() {
            /*
                r10 = this;
                long r0 = java.lang.System.currentTimeMillis()
                org.apache.mina.filter.a.c r2 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.this
                java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS
                long r2 = r2.getKeepAliveTime(r3)
                long r2 = r2 + r0
                r4 = 0
            Le:
                long r5 = r2 - r0
                r7 = 0
                int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r9 > 0) goto L17
                goto L2e
            L17:
                org.apache.mina.filter.a.c r7 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.this     // Catch: java.lang.Throwable -> L2f
                java.util.concurrent.BlockingQueue r7 = org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.m928d(r7)     // Catch: java.lang.Throwable -> L2f
                java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L2f
                java.lang.Object r5 = r7.poll(r5, r8)     // Catch: java.lang.Throwable -> L2f
                org.apache.mina.core.session.g r5 = (org.apache.mina.core.session.IoSession) r5     // Catch: java.lang.Throwable -> L2f
                if (r5 != 0) goto L2d
                java.lang.System.currentTimeMillis()     // Catch: java.lang.InterruptedException -> L2b
                goto L2d
            L2b:
                r4 = r5
                goto Le
            L2d:
                r4 = r5
            L2e:
                return r4
            L2f:
                r5 = move-exception
                if (r4 != 0) goto L36
                long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.InterruptedException -> Le
            L36:
                throw r5     // Catch: java.lang.InterruptedException -> Le
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.mina.filter.p134a.OrderedThreadPoolExecutor.RunnableC3092b.m922a():org.apache.mina.core.session.g");
        }

        /* renamed from: a */
        private void m920a(C3091a c3091a) {
            Runnable runnable;
            while (true) {
                Queue queue = c3091a.f11565b;
                synchronized (queue) {
                    runnable = (Runnable) queue.poll();
                    if (runnable == null) {
                        c3091a.f11566c = true;
                        return;
                    }
                }
                OrderedThreadPoolExecutor.this.f11563j.mo945c(OrderedThreadPoolExecutor.this, (IoEvent) runnable);
                m921a(runnable);
            }
        }

        /* renamed from: a */
        private void m921a(Runnable runnable) {
            boolean z;
            OrderedThreadPoolExecutor.this.beforeExecute(this.f11569c, runnable);
            try {
                runnable.run();
                z = true;
            } catch (RuntimeException e) {
                e = e;
                z = false;
            }
            try {
                OrderedThreadPoolExecutor.this.afterExecute(runnable, null);
                this.f11568b.incrementAndGet();
            } catch (RuntimeException e2) {
                e = e2;
                if (!z) {
                    OrderedThreadPoolExecutor.this.afterExecute(runnable, e);
                }
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OrderedThreadPoolExecutor.java */
    /* renamed from: org.apache.mina.filter.a.c$a */
    /* loaded from: classes2.dex */
    public class C3091a {

        /* renamed from: b */
        private final Queue<Runnable> f11565b;

        /* renamed from: c */
        private boolean f11566c;

        private C3091a() {
            this.f11565b = new ConcurrentLinkedQueue();
            this.f11566c = true;
        }
    }
}
