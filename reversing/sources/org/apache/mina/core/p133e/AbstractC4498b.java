package org.apache.mina.core.p133e;

import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.mina.core.filterchain.DefaultIoFilterChain;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.filterchain.IoFilterChainBuilder;
import org.apache.mina.core.p131c.ConnectFuture;
import org.apache.mina.core.p131c.DefaultIoFuture;
import org.apache.mina.core.p131c.IoFuture;
import org.apache.mina.core.session.AbstractIoSession;
import org.apache.mina.core.session.DefaultIoSessionDataStructureFactory;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.session.IoSessionConfig;
import org.apache.mina.core.session.IoSessionDataStructureFactory;
import org.apache.mina.core.session.IoSessionInitializationException;
import org.apache.mina.core.session.IoSessionInitializer;
import org.apache.mina.util.ExceptionMonitor;
import org.apache.mina.util.NamePreservingRunnable;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.mina.core.e.b */
/* loaded from: classes2.dex */
public abstract class AbstractIoService implements IoService {

    /* renamed from: a */
    private static final InterfaceC3153b f11377a = C3154c.m262a(AbstractIoService.class);

    /* renamed from: b */
    private static final AtomicInteger f11378b = new AtomicInteger();

    /* renamed from: c */
    private final String f11379c;

    /* renamed from: d */
    protected final IoSessionConfig f11380d;

    /* renamed from: f */
    private final Executor f11382f;

    /* renamed from: g */
    private final boolean f11383g;

    /* renamed from: h */
    private InterfaceC3064f f11384h;

    /* renamed from: l */
    private final IoServiceListenerSupport f11388l;

    /* renamed from: m */
    private volatile boolean f11389m;

    /* renamed from: n */
    private volatile boolean f11390n;

    /* renamed from: i */
    private final IoServiceListener f11385i = new IoServiceListener() { // from class: org.apache.mina.core.e.b.1
        @Override // org.apache.mina.core.p133e.IoServiceListener
        /* renamed from: a */
        public void mo1189a(IoSession ioSession) throws Exception {
        }

        @Override // org.apache.mina.core.p133e.IoServiceListener
        /* renamed from: b */
        public void mo1188b(IoService ioService) throws Exception {
        }

        @Override // org.apache.mina.core.p133e.IoServiceListener
        /* renamed from: b */
        public void mo1187b(IoSession ioSession) throws Exception {
        }

        @Override // org.apache.mina.core.p133e.IoServiceListener
        /* renamed from: a */
        public void mo1190a(IoService ioService) {
            AbstractIoService abstractIoService = (AbstractIoService) ioService;
            IoServiceStatistics m1215w = abstractIoService.m1215w();
            m1215w.m1173a(abstractIoService.m1214x());
            m1215w.m1170b(abstractIoService.m1214x());
            m1215w.m1163f(abstractIoService.m1214x());
        }
    };

    /* renamed from: j */
    private IoFilterChainBuilder f11386j = new DefaultIoFilterChainBuilder();

    /* renamed from: k */
    private IoSessionDataStructureFactory f11387k = new DefaultIoSessionDataStructureFactory();

    /* renamed from: e */
    protected final Object f11381e = new Object();

    /* renamed from: o */
    private IoServiceStatistics f11391o = new IoServiceStatistics(this);

    /* renamed from: a */
    protected void m1221a(IoSession ioSession, IoFuture ioFuture) {
    }

    /* renamed from: e */
    protected abstract void mo1032e() throws Exception;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractIoService(IoSessionConfig ioSessionConfig, Executor executor) {
        if (ioSessionConfig == null) {
            throw new IllegalArgumentException("sessionConfig");
        }
        if (mo1030z() == null) {
            throw new IllegalArgumentException("TransportMetadata");
        }
        if (!mo1030z().mo1156b().isAssignableFrom(ioSessionConfig.getClass())) {
            throw new IllegalArgumentException("sessionConfig type: " + ioSessionConfig.getClass() + " (expected: " + mo1030z().mo1156b() + ")");
        }
        this.f11388l = new IoServiceListenerSupport(this);
        this.f11388l.m1185a(this.f11385i);
        this.f11380d = ioSessionConfig;
        ExceptionMonitor.m808a();
        if (executor == null) {
            this.f11382f = Executors.newCachedThreadPool();
            this.f11383g = true;
        } else {
            this.f11382f = executor;
            this.f11383g = false;
        }
        this.f11379c = getClass().getSimpleName() + '-' + f11378b.incrementAndGet();
    }

    @Override // org.apache.mina.core.p133e.IoService
    /* renamed from: n */
    public final IoFilterChainBuilder mo1196n() {
        return this.f11386j;
    }

    @Override // org.apache.mina.core.p133e.IoService
    /* renamed from: o */
    public final DefaultIoFilterChainBuilder mo1195o() {
        IoFilterChainBuilder ioFilterChainBuilder = this.f11386j;
        if (ioFilterChainBuilder instanceof DefaultIoFilterChainBuilder) {
            return (DefaultIoFilterChainBuilder) ioFilterChainBuilder;
        }
        throw new IllegalStateException("Current filter chain builder is not a DefaultIoFilterChainBuilder.");
    }

    /* renamed from: p */
    public final boolean m1218p() {
        return this.f11388l.m1180d();
    }

    /* renamed from: q */
    public final boolean m1217q() {
        return this.f11389m;
    }

    @Override // org.apache.mina.core.p133e.IoService
    /* renamed from: r */
    public final void mo1194r() {
        m1219b(false);
    }

    /* renamed from: b */
    public final void m1219b(boolean z) {
        if (this.f11390n) {
            return;
        }
        synchronized (this.f11381e) {
            if (!this.f11389m) {
                this.f11389m = true;
                try {
                    mo1032e();
                } catch (Exception e) {
                    ExceptionMonitor.m808a().mo807a(e);
                }
            }
        }
        if (this.f11383g) {
            ExecutorService executorService = (ExecutorService) this.f11382f;
            executorService.shutdownNow();
            if (z) {
                try {
                    f11377a.debug("awaitTermination on {} called by thread=[{}]", this, Thread.currentThread().getName());
                    executorService.awaitTermination(2147483647L, TimeUnit.SECONDS);
                    f11377a.debug("awaitTermination on {} finished", this);
                } catch (InterruptedException unused) {
                    f11377a.warn("awaitTermination on [{}] was interrupted", this);
                    Thread.currentThread().interrupt();
                }
            }
        }
        this.f11390n = true;
    }

    @Override // org.apache.mina.core.p133e.IoService
    /* renamed from: s */
    public final Map<Long, IoSession> mo1193s() {
        return this.f11388l.m1183b();
    }

    /* renamed from: t */
    public final int m1216t() {
        return this.f11388l.m1181c();
    }

    @Override // org.apache.mina.core.p133e.IoService
    /* renamed from: u */
    public final InterfaceC3064f mo1192u() {
        return this.f11384h;
    }

    @Override // org.apache.mina.core.p133e.IoService
    /* renamed from: a */
    public final void mo1197a(InterfaceC3064f interfaceC3064f) {
        if (interfaceC3064f == null) {
            throw new IllegalArgumentException("handler cannot be null");
        }
        if (m1218p()) {
            throw new IllegalStateException("handler cannot be set while the service is active.");
        }
        this.f11384h = interfaceC3064f;
    }

    @Override // org.apache.mina.core.p133e.IoService
    /* renamed from: v */
    public final IoSessionDataStructureFactory mo1191v() {
        return this.f11387k;
    }

    /* renamed from: w */
    public IoServiceStatistics m1215w() {
        return this.f11391o;
    }

    /* renamed from: x */
    public final long m1214x() {
        return this.f11388l.m1186a();
    }

    /* renamed from: y */
    public final IoServiceListenerSupport m1213y() {
        return this.f11388l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m1223a(Runnable runnable) {
        m1222a(runnable, (String) null);
    }

    /* renamed from: a */
    protected final void m1222a(Runnable runnable, String str) {
        String str2 = this.f11379c;
        if (str != null) {
            str2 = str2 + '-' + str;
        }
        this.f11382f.execute(new NamePreservingRunnable(runnable, str2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m1220a(IoSession ioSession, IoFuture ioFuture, IoSessionInitializer ioSessionInitializer) {
        if (this.f11391o.m1176a() == 0) {
            this.f11391o.m1173a(m1214x());
        }
        if (this.f11391o.m1171b() == 0) {
            this.f11391o.m1170b(m1214x());
        }
        try {
            ((AbstractIoSession) ioSession).m1062a(ioSession.mo993m().mo1191v().mo969a(ioSession));
            try {
                ((AbstractIoSession) ioSession).m1060a(ioSession.mo993m().mo1191v().mo968b(ioSession));
                if (ioFuture != null && (ioFuture instanceof ConnectFuture)) {
                    ioSession.mo1008b(DefaultIoFilterChain.f11443a, ioFuture);
                }
                if (ioSessionInitializer != null) {
                    ioSessionInitializer.m967a(ioSession, ioFuture);
                }
                m1221a(ioSession, ioFuture);
            } catch (IoSessionInitializationException e) {
                throw e;
            } catch (Exception e2) {
                throw new IoSessionInitializationException("Failed to initialize a writeRequestQueue.", e2);
            }
        } catch (IoSessionInitializationException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new IoSessionInitializationException("Failed to initialize an attributeMap.", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: AbstractIoService.java */
    /* renamed from: org.apache.mina.core.e.b$a */
    /* loaded from: classes2.dex */
    public static class C3063a extends DefaultIoFuture {
        public C3063a() {
            super(null);
        }

        @Override // org.apache.mina.core.p131c.DefaultIoFuture
        /* renamed from: f */
        public final boolean mo1209f() {
            return m1325g() == Boolean.TRUE;
        }

        /* renamed from: b */
        public final void m1211b() {
            m1328a(Boolean.TRUE);
        }

        /* renamed from: c */
        public final Exception m1210c() {
            if (m1325g() instanceof Exception) {
                return (Exception) m1325g();
            }
            return null;
        }

        /* renamed from: a */
        public final void m1212a(Exception exc) {
            if (exc == null) {
                throw new IllegalArgumentException("exception");
            }
            m1328a((Object) exc);
        }
    }
}
