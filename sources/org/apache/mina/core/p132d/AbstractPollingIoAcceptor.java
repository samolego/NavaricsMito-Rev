package org.apache.mina.core.p132d;

import java.net.SocketAddress;
import java.nio.channels.spi.SelectorProvider;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.mina.core.RuntimeIoException;
import org.apache.mina.core.p133e.AbstractIoAcceptor;
import org.apache.mina.core.p133e.AbstractIoService;
import org.apache.mina.core.p133e.IoProcessor;
import org.apache.mina.core.p133e.SimpleIoProcessorPool;
import org.apache.mina.core.session.AbstractIoSession;
import org.apache.mina.core.session.IoSessionConfig;
import org.apache.mina.p126a.p127a.SocketSessionConfig;
import org.apache.mina.util.ExceptionMonitor;

/* renamed from: org.apache.mina.core.d.a */
/* loaded from: classes2.dex */
public abstract class AbstractPollingIoAcceptor<S extends AbstractIoSession, H> extends AbstractIoAcceptor {

    /* renamed from: a */
    protected boolean f11340a;

    /* renamed from: b */
    protected int f11341b;

    /* renamed from: f */
    private final Semaphore f11342f;

    /* renamed from: g */
    private final IoProcessor<S> f11343g;

    /* renamed from: h */
    private final boolean f11344h;

    /* renamed from: i */
    private final Queue<AbstractIoAcceptor.C3061a> f11345i;

    /* renamed from: j */
    private final Queue<AbstractIoAcceptor.C3061a> f11346j;

    /* renamed from: k */
    private final Map<SocketAddress, H> f11347k;

    /* renamed from: l */
    private final AbstractIoService.C3063a f11348l;

    /* renamed from: m */
    private volatile boolean f11349m;

    /* renamed from: n */
    private AtomicReference<AbstractPollingIoAcceptor<S, H>.RunnableC3058a> f11350n;

    /* renamed from: a */
    protected abstract H mo1309a(SocketAddress socketAddress) throws Exception;

    /* renamed from: a */
    protected abstract SocketAddress mo1310a(H h) throws Exception;

    /* renamed from: a */
    protected abstract S mo1304a(IoProcessor<S> ioProcessor, H h) throws Exception;

    /* renamed from: a */
    protected abstract void mo1311a() throws Exception;

    /* renamed from: a */
    protected abstract void mo1308a(SelectorProvider selectorProvider) throws Exception;

    /* renamed from: b */
    protected abstract int mo1302b() throws Exception;

    /* renamed from: b */
    protected abstract void mo1301b(H h) throws Exception;

    /* renamed from: c */
    protected abstract void mo1299c();

    /* renamed from: d */
    protected abstract Iterator<H> mo1297d();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractPollingIoAcceptor(IoSessionConfig ioSessionConfig, Class<? extends IoProcessor<S>> cls) {
        this(ioSessionConfig, null, new SimpleIoProcessorPool(cls), true, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractPollingIoAcceptor(IoSessionConfig ioSessionConfig, Class<? extends IoProcessor<S>> cls, int i) {
        this(ioSessionConfig, null, new SimpleIoProcessorPool(cls, i), true, null);
    }

    private AbstractPollingIoAcceptor(IoSessionConfig ioSessionConfig, Executor executor, IoProcessor<S> ioProcessor, boolean z, SelectorProvider selectorProvider) {
        super(ioSessionConfig, executor);
        this.f11342f = new Semaphore(1);
        this.f11345i = new ConcurrentLinkedQueue();
        this.f11346j = new ConcurrentLinkedQueue();
        this.f11347k = Collections.synchronizedMap(new HashMap());
        this.f11348l = new AbstractIoService.C3063a();
        this.f11350n = new AtomicReference<>();
        this.f11340a = false;
        this.f11341b = 50;
        if (ioProcessor == null) {
            throw new IllegalArgumentException("processor");
        }
        this.f11343g = ioProcessor;
        this.f11344h = z;
        try {
            try {
                try {
                    mo1308a(selectorProvider);
                    this.f11349m = true;
                    if (this.f11349m) {
                        return;
                    }
                    try {
                        mo1311a();
                    } catch (Exception e) {
                        ExceptionMonitor.m808a().mo807a(e);
                    }
                } catch (RuntimeException e2) {
                    throw e2;
                }
            } catch (Exception e3) {
                throw new RuntimeIoException("Failed to initialize.", e3);
            }
        } catch (Throwable th) {
            if (!this.f11349m) {
                try {
                    mo1311a();
                } catch (Exception e4) {
                    ExceptionMonitor.m808a().mo807a(e4);
                }
            }
            throw th;
        }
    }

    @Override // org.apache.mina.core.p133e.AbstractIoService
    /* renamed from: e */
    protected void mo1032e() throws Exception {
        mo1206m();
        m1314A();
        mo1299c();
    }

    @Override // org.apache.mina.core.p133e.AbstractIoAcceptor
    /* renamed from: a */
    protected final Set<SocketAddress> mo1034a(List<? extends SocketAddress> list) throws Exception {
        AbstractIoAcceptor.C3061a c3061a = new AbstractIoAcceptor.C3061a(list);
        this.f11345i.add(c3061a);
        m1314A();
        try {
            this.f11342f.acquire();
            mo1299c();
            this.f11342f.release();
            c3061a.mo1318d();
            if (c3061a.m1210c() != null) {
                throw c3061a.m1210c();
            }
            HashSet hashSet = new HashSet();
            for (H h : this.f11347k.values()) {
                hashSet.add(mo1310a((AbstractPollingIoAcceptor<S, H>) h));
            }
            return hashSet;
        } catch (Throwable th) {
            this.f11342f.release();
            throw th;
        }
    }

    /* renamed from: A */
    private void m1314A() throws InterruptedException {
        if (!this.f11349m) {
            this.f11345i.clear();
            this.f11346j.clear();
        }
        if (this.f11350n.get() == null) {
            this.f11342f.acquire();
            AbstractPollingIoAcceptor<S, H>.RunnableC3058a runnableC3058a = new RunnableC3058a();
            if (this.f11350n.compareAndSet(null, runnableC3058a)) {
                m1223a((Runnable) runnableC3058a);
            } else {
                this.f11342f.release();
            }
        }
    }

    @Override // org.apache.mina.core.p133e.AbstractIoAcceptor
    /* renamed from: b */
    protected final void mo1033b(List<? extends SocketAddress> list) throws Exception {
        AbstractIoAcceptor.C3061a c3061a = new AbstractIoAcceptor.C3061a(list);
        this.f11346j.add(c3061a);
        m1314A();
        mo1299c();
        c3061a.mo1318d();
        if (c3061a.m1210c() != null) {
            throw c3061a.m1210c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractPollingIoAcceptor.java */
    /* renamed from: org.apache.mina.core.d.a$a */
    /* loaded from: classes2.dex */
    public class RunnableC3058a implements Runnable {

        /* renamed from: a */
        static final /* synthetic */ boolean f11351a = !AbstractPollingIoAcceptor.class.desiredAssertionStatus();

        private RunnableC3058a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:42:0x00af, code lost:
            m1285a(r5.f11352b.mo1297d());
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 376
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.mina.core.p132d.AbstractPollingIoAcceptor.RunnableC3058a.run():void");
        }

        /* renamed from: a */
        private void m1285a(Iterator<H> it) throws Exception {
            while (it.hasNext()) {
                H next = it.next();
                it.remove();
                AbstractPollingIoAcceptor abstractPollingIoAcceptor = AbstractPollingIoAcceptor.this;
                AbstractIoSession mo1304a = abstractPollingIoAcceptor.mo1304a(abstractPollingIoAcceptor.f11343g, (IoProcessor<S>) next);
                if (mo1304a != null) {
                    AbstractPollingIoAcceptor.this.m1220a(mo1304a, null, null);
                    mo1304a.mo1035r().mo1024c(mo1304a);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: B */
    public int m1313B() {
        while (true) {
            AbstractIoAcceptor.C3061a poll = this.f11345i.poll();
            if (poll == null) {
                return 0;
            }
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            try {
                for (SocketAddress socketAddress : poll.m1224a()) {
                    Object mo1309a = mo1309a(socketAddress);
                    concurrentHashMap.put(mo1310a((AbstractPollingIoAcceptor<S, H>) mo1309a), mo1309a);
                }
                this.f11347k.putAll(concurrentHashMap);
                poll.m1211b();
                return concurrentHashMap.size();
            } catch (Exception e) {
                try {
                    poll.m1212a(e);
                    if (poll.m1210c() != null) {
                        for (Object obj : concurrentHashMap.values()) {
                            try {
                                mo1301b((AbstractPollingIoAcceptor<S, H>) obj);
                            } catch (Exception e2) {
                                ExceptionMonitor.m808a().mo807a(e2);
                            }
                        }
                        mo1299c();
                    }
                } finally {
                    if (poll.m1210c() != null) {
                        for (Object next : concurrentHashMap.values()) {
                            try {
                                mo1301b((AbstractPollingIoAcceptor<S, H>) next);
                            } catch (Exception e3) {
                                ExceptionMonitor.m808a().mo807a(e3);
                            }
                        }
                        mo1299c();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public int m1312C() {
        int i = 0;
        while (true) {
            AbstractIoAcceptor.C3061a poll = this.f11346j.poll();
            if (poll == null) {
                return i;
            }
            for (SocketAddress socketAddress : poll.m1224a()) {
                H remove = this.f11347k.remove(socketAddress);
                if (remove != null) {
                    try {
                        mo1301b((AbstractPollingIoAcceptor<S, H>) remove);
                        mo1299c();
                    } catch (Exception e) {
                        ExceptionMonitor.m808a().mo807a(e);
                    }
                    i++;
                }
            }
            poll.m1211b();
        }
    }

    /* renamed from: f */
    public int m1294f() {
        return this.f11341b;
    }

    /* renamed from: g */
    public boolean m1292g() {
        return this.f11340a;
    }

    /* renamed from: a */
    public void m1303a(boolean z) {
        synchronized (this.f11373c) {
            if (m1218p()) {
                throw new IllegalStateException("backlog can't be set while the acceptor is bound.");
            }
            this.f11340a = z;
        }
    }

    @Override // org.apache.mina.core.p133e.IoService
    /* renamed from: h */
    public SocketSessionConfig mo1031i() {
        return (SocketSessionConfig) this.f11380d;
    }
}
