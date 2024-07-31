package org.apache.mina.core.p132d;

import java.io.IOException;
import java.net.PortUnreachableException;
import java.nio.channels.ClosedSelectorException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.mina.core.p129a.AbstractC3054b;
import org.apache.mina.core.p130b.FileRegion;
import org.apache.mina.core.p131c.DefaultIoFuture;
import org.apache.mina.core.p133e.AbstractIoService;
import org.apache.mina.core.p133e.IoProcessor;
import org.apache.mina.core.session.AbstractIoSession;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.session.IoSessionConfig;
import org.apache.mina.core.session.SessionState;
import org.apache.mina.core.write.InterfaceC3088b;
import org.apache.mina.core.write.WriteRequestQueue;
import org.apache.mina.core.write.WriteToClosedSessionException;
import org.apache.mina.p126a.p127a.AbstractDatagramSessionConfig;
import org.apache.mina.util.ExceptionMonitor;
import org.apache.mina.util.NamePreservingRunnable;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.mina.core.d.b */
/* loaded from: classes2.dex */
public abstract class AbstractPollingIoProcessor<S extends AbstractIoSession> implements IoProcessor<S> {

    /* renamed from: b */
    private static final InterfaceC3153b f11353b = C3154c.m262a(IoProcessor.class);

    /* renamed from: c */
    private static final ConcurrentHashMap<Class<?>, AtomicInteger> f11354c = new ConcurrentHashMap<>();

    /* renamed from: a */
    protected AtomicBoolean f11355a;

    /* renamed from: d */
    private final String f11356d;

    /* renamed from: e */
    private final Executor f11357e;

    /* renamed from: f */
    private final Queue<S> f11358f;

    /* renamed from: g */
    private final Queue<S> f11359g;

    /* renamed from: h */
    private final Queue<S> f11360h;

    /* renamed from: i */
    private final Queue<S> f11361i;

    /* renamed from: j */
    private final AtomicReference<AbstractPollingIoProcessor<S>.RunnableC3060a> f11362j;

    /* renamed from: k */
    private long f11363k;

    /* renamed from: l */
    private final Object f11364l;

    /* renamed from: m */
    private volatile boolean f11365m;

    /* renamed from: n */
    private volatile boolean f11366n;

    /* renamed from: o */
    private final DefaultIoFuture f11367o;

    /* renamed from: a */
    protected abstract int mo1284a(long j) throws Exception;

    /* renamed from: a */
    protected abstract int mo1278a(S s, AbstractC3054b abstractC3054b) throws Exception;

    /* renamed from: a */
    protected abstract int mo1277a(S s, AbstractC3054b abstractC3054b, int i) throws IOException;

    /* renamed from: a */
    protected abstract int mo1276a(S s, FileRegion fileRegion, int i) throws Exception;

    /* renamed from: a */
    protected abstract SessionState mo1280a(S s);

    /* renamed from: a */
    protected abstract void mo1273a(S s, boolean z) throws Exception;

    /* renamed from: b */
    protected abstract void mo1266b(S s, boolean z) throws Exception;

    /* renamed from: b */
    protected abstract boolean mo1269b(S s);

    /* renamed from: c */
    protected abstract void mo1265c() throws Exception;

    /* renamed from: c */
    protected abstract boolean mo1261c(S s);

    /* renamed from: d */
    protected abstract void mo1258d(S s) throws Exception;

    /* renamed from: d */
    protected abstract boolean mo1260d();

    /* renamed from: e */
    protected abstract void mo1257e();

    /* renamed from: e */
    protected abstract void mo1255e(S s) throws Exception;

    /* renamed from: f */
    protected abstract Iterator<S> mo1254f();

    /* renamed from: g */
    protected abstract Iterator<S> mo1251g();

    /* renamed from: h */
    protected abstract void mo1248h() throws IOException;

    /* renamed from: i */
    protected abstract boolean mo1245i() throws IOException;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.mina.core.p133e.IoProcessor
    /* renamed from: a */
    public /* synthetic */ void mo1028a(IoSession ioSession) {
        m1249g((AbstractPollingIoProcessor<S>) ((AbstractIoSession) ioSession));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.mina.core.p133e.IoProcessor
    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo1027a(IoSession ioSession, InterfaceC3088b interfaceC3088b) {
        m1275a((AbstractPollingIoProcessor<S>) ((AbstractIoSession) ioSession), interfaceC3088b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.mina.core.p133e.IoProcessor
    /* renamed from: b */
    public /* synthetic */ void mo1025b(IoSession ioSession) {
        m1246h((AbstractPollingIoProcessor<S>) ((AbstractIoSession) ioSession));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.mina.core.p133e.IoProcessor
    /* renamed from: c */
    public /* synthetic */ void mo1024c(IoSession ioSession) {
        m1252f((AbstractPollingIoProcessor<S>) ((AbstractIoSession) ioSession));
    }

    @Override // org.apache.mina.core.p133e.IoProcessor
    /* renamed from: a */
    public final boolean mo1029a() {
        return this.f11365m;
    }

    @Override // org.apache.mina.core.p133e.IoProcessor
    /* renamed from: b */
    public final void mo1026b() {
        if (this.f11366n || this.f11365m) {
            return;
        }
        synchronized (this.f11364l) {
            this.f11365m = true;
            m1240k();
        }
        this.f11367o.mo1318d();
        this.f11366n = true;
    }

    /* renamed from: f */
    public final void m1252f(S s) {
        if (this.f11366n || this.f11365m) {
            throw new IllegalStateException("Already disposed.");
        }
        this.f11358f.add(s);
        m1240k();
    }

    /* renamed from: g */
    public final void m1249g(S s) {
        m1241j(s);
        m1240k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m1241j(S s) {
        if (this.f11359g.contains(s)) {
            return;
        }
        this.f11359g.add(s);
    }

    /* renamed from: a */
    public void m1275a(S s, InterfaceC3088b interfaceC3088b) {
        s.mo1018P().mo958a(s, interfaceC3088b);
        if (s.mo1017Q()) {
            return;
        }
        m1246h((AbstractPollingIoProcessor<S>) s);
    }

    /* renamed from: h */
    public final void m1246h(S s) {
        if (s.m1055b(true)) {
            this.f11360h.add(s);
            mo1257e();
        }
    }

    /* renamed from: k */
    private void m1239k(S s) {
        if (s.m1055b(true)) {
            this.f11360h.add(s);
        }
    }

    /* renamed from: k */
    private void m1240k() {
        if (this.f11362j.get() == null) {
            AbstractPollingIoProcessor<S>.RunnableC3060a runnableC3060a = new RunnableC3060a();
            if (this.f11362j.compareAndSet(null, runnableC3060a)) {
                this.f11357e.execute(new NamePreservingRunnable(runnableC3060a, this.f11356d));
            }
        }
        mo1257e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public int m1238l() {
        S poll = this.f11358f.poll();
        int i = 0;
        while (poll != null) {
            if (m1237l(poll)) {
                i++;
            }
            poll = this.f11358f.poll();
        }
        return i;
    }

    /* renamed from: l */
    private boolean m1237l(S s) {
        try {
            mo1258d((AbstractPollingIoProcessor<S>) s);
            s.mo993m().mo1196n().mo1084a(s.mo1002e());
            ((AbstractIoService) s.mo993m()).m1213y().m1184a(s);
            return true;
        } catch (Exception e) {
            ExceptionMonitor.m808a().mo807a(e);
            try {
                mo1255e((AbstractPollingIoProcessor<S>) s);
                return false;
            } catch (Exception e2) {
                ExceptionMonitor.m808a().mo807a(e2);
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public int m1236m() {
        S poll = this.f11359g.poll();
        int i = 0;
        while (poll != null) {
            SessionState mo1280a = mo1280a((AbstractPollingIoProcessor<S>) poll);
            switch (mo1280a) {
                case OPENED:
                    if (!m1235m(poll)) {
                        break;
                    } else {
                        i++;
                        break;
                    }
                case CLOSING:
                    i++;
                    break;
                case OPENING:
                    this.f11358f.remove(poll);
                    if (!m1235m(poll)) {
                        break;
                    } else {
                        i++;
                        break;
                    }
                default:
                    throw new IllegalStateException(String.valueOf(mo1280a));
            }
            poll = this.f11359g.poll();
        }
        return i;
    }

    /* renamed from: m */
    private boolean m1235m(S s) {
        m1233n(s);
        try {
            try {
                mo1255e((AbstractPollingIoProcessor<S>) s);
                try {
                    m1233n(s);
                    ((AbstractIoService) s.mo993m()).m1213y().m1182b(s);
                } catch (Exception e) {
                    s.mo1002e().mo1101a((Throwable) e);
                }
                return true;
            } catch (Exception e2) {
                s.mo1002e().mo1101a((Throwable) e2);
                try {
                    m1233n(s);
                    ((AbstractIoService) s.mo993m()).m1213y().m1182b(s);
                    return false;
                } catch (Exception e3) {
                    s.mo1002e().mo1101a((Throwable) e3);
                    return false;
                }
            }
        } catch (Throwable th) {
            try {
                m1233n(s);
                ((AbstractIoService) s.mo993m()).m1213y().m1182b(s);
            } catch (Exception e4) {
                s.mo1002e().mo1101a((Throwable) e4);
            }
            throw th;
        }
    }

    /* renamed from: n */
    private void m1233n(S s) {
        WriteRequestQueue mo1018P = s.mo1018P();
        ArrayList<InterfaceC3088b> arrayList = new ArrayList();
        InterfaceC3088b mo956c = mo1018P.mo956c(s);
        if (mo956c != null) {
            Object mo836b = mo956c.mo836b();
            if (mo836b instanceof AbstractC3054b) {
                AbstractC3054b abstractC3054b = (AbstractC3054b) mo836b;
                if (abstractC3054b.mo1356m()) {
                    abstractC3054b.mo1361i();
                    arrayList.add(mo956c);
                } else {
                    s.mo1002e().mo1099a(mo956c);
                }
            } else {
                arrayList.add(mo956c);
            }
            while (true) {
                InterfaceC3088b mo956c2 = mo1018P.mo956c(s);
                if (mo956c2 == null) {
                    break;
                }
                arrayList.add(mo956c2);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        WriteToClosedSessionException writeToClosedSessionException = new WriteToClosedSessionException(arrayList);
        for (InterfaceC3088b interfaceC3088b : arrayList) {
            s.m1056b(interfaceC3088b);
            interfaceC3088b.mo955a().mo962a(writeToClosedSessionException);
        }
        s.mo1002e().mo1101a((Throwable) writeToClosedSessionException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m1234n() throws Exception {
        Iterator<S> mo1251g = mo1251g();
        while (mo1251g.hasNext()) {
            m1231o(mo1251g.next());
            mo1251g.remove();
        }
    }

    /* renamed from: o */
    private void m1231o(S s) {
        if (mo1261c((AbstractPollingIoProcessor<S>) s) && !s.m1045y()) {
            m1230p(s);
        }
        if (mo1269b((AbstractPollingIoProcessor<S>) s) && !s.mo1017Q() && s.m1055b(true)) {
            this.f11360h.add(s);
        }
    }

    /* renamed from: p */
    private void m1230p(S s) {
        int mo1278a;
        IoSessionConfig mo1007c = s.mo1007c();
        AbstractC3054b m1362h = AbstractC3054b.m1362h(mo1007c.mo982a());
        boolean mo1152f = s.mo992n().mo1152f();
        int i = 0;
        try {
            if (mo1152f) {
                do {
                    mo1278a = mo1278a((AbstractPollingIoProcessor<S>) s, m1362h);
                    if (mo1278a <= 0) {
                        break;
                    }
                    i += mo1278a;
                } while (m1362h.mo1356m());
            } else {
                mo1278a = mo1278a((AbstractPollingIoProcessor<S>) s, m1362h);
                if (mo1278a > 0) {
                    i = mo1278a;
                }
            }
            m1362h.mo1358k();
            if (i > 0) {
                s.mo1002e().mo1103a(m1362h);
                if (mo1152f) {
                    if ((i << 1) < mo1007c.mo982a()) {
                        s.m1081B();
                    } else if (i == mo1007c.mo982a()) {
                        s.m1082A();
                    }
                }
            }
            if (mo1278a < 0) {
                s.mo1002e().mo1089f();
            }
        } catch (Exception e) {
            if ((e instanceof IOException) && (!(e instanceof PortUnreachableException) || !AbstractDatagramSessionConfig.class.isAssignableFrom(mo1007c.getClass()) || ((AbstractDatagramSessionConfig) mo1007c).m1458m())) {
                m1241j(s);
            }
            s.mo1002e().mo1101a((Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m1272b(long j) throws Exception {
        if (j - this.f11363k >= 1000) {
            this.f11363k = j;
            AbstractIoSession.m1068a(mo1254f(), j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: c */
    public void m1264c(long j) {
        if (this.f11360h.isEmpty()) {
            return;
        }
        do {
            S poll = this.f11360h.poll();
            if (poll == null) {
                return;
            }
            poll.m1050t();
            SessionState mo1280a = mo1280a((AbstractPollingIoProcessor<S>) poll);
            switch (mo1280a) {
                case OPENED:
                    try {
                        if (m1279a((AbstractPollingIoProcessor<S>) poll, j) && !poll.mo1018P().mo957b(poll) && !poll.m1051s()) {
                            m1239k(poll);
                            break;
                        }
                    } catch (Exception e) {
                        m1241j(poll);
                        poll.mo1016a();
                        poll.mo1002e().mo1101a(e);
                        break;
                    }
                    break;
                case CLOSING:
                    break;
                case OPENING:
                    m1239k(poll);
                    return;
                default:
                    throw new IllegalStateException(String.valueOf(mo1280a));
            }
        } while (!this.f11360h.isEmpty());
    }

    /* renamed from: a */
    private boolean m1279a(S s, long j) {
        InterfaceC3088b interfaceC3088b;
        Object obj;
        int m1267b;
        if (!s.mo990p()) {
            m1241j(s);
            return false;
        }
        boolean mo1152f = s.mo992n().mo1152f();
        WriteRequestQueue mo1018P = s.mo1018P();
        int mo975c = s.mo1007c().mo975c() + (s.mo1007c().mo975c() >>> 1);
        InterfaceC3088b interfaceC3088b2 = null;
        try {
            mo1273a((AbstractPollingIoProcessor<S>) s, false);
            int i = 0;
            while (true) {
                interfaceC3088b2 = s.mo1019N();
                if (interfaceC3088b2 == null) {
                    InterfaceC3088b mo956c = mo1018P.mo956c(s);
                    if (mo956c == null) {
                        break;
                    }
                    s.mo1012a(mo956c);
                    interfaceC3088b = mo956c;
                } else {
                    interfaceC3088b = interfaceC3088b2;
                }
                try {
                    Object mo836b = interfaceC3088b.mo836b();
                    if (mo836b instanceof AbstractC3054b) {
                        obj = mo836b;
                        m1267b = m1274a(s, interfaceC3088b, mo1152f, mo975c - i, j);
                        if (m1267b > 0 && ((AbstractC3054b) obj).mo1356m()) {
                            mo1273a((AbstractPollingIoProcessor<S>) s, true);
                            return false;
                        }
                    } else {
                        obj = mo836b;
                        if (obj instanceof FileRegion) {
                            m1267b = m1267b(s, interfaceC3088b, mo1152f, mo975c - i, j);
                            if (m1267b > 0 && ((FileRegion) obj).mo1340a() > 0) {
                                mo1273a((AbstractPollingIoProcessor<S>) s, true);
                                return false;
                            }
                        } else {
                            throw new IllegalStateException("Don't know how to handle message of type '" + obj.getClass().getName() + "'.  Are you missing a protocol encoder?");
                        }
                    }
                    if (m1267b != 0) {
                        i += m1267b;
                        if (i >= mo975c) {
                            m1239k(s);
                            return false;
                        }
                    } else if (!interfaceC3088b.equals(AbstractIoSession.f11471c)) {
                        mo1273a((AbstractPollingIoProcessor<S>) s, true);
                        return false;
                    }
                    if (obj instanceof AbstractC3054b) {
                        ((AbstractC3054b) obj).mo1345s();
                    }
                    if (i >= mo975c) {
                        break;
                    }
                } catch (Exception e) {
                    e = e;
                    if (interfaceC3088b != null) {
                        interfaceC3088b.mo955a().mo962a(e);
                    }
                    s.mo1002e().mo1101a((Throwable) e);
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            e = e2;
            interfaceC3088b = interfaceC3088b2;
        }
    }

    /* renamed from: a */
    private int m1274a(S s, InterfaceC3088b interfaceC3088b, boolean z, int i, long j) throws Exception {
        int mo1357l;
        AbstractC3054b abstractC3054b = (AbstractC3054b) interfaceC3088b.mo836b();
        int i2 = 0;
        if (abstractC3054b.mo1356m()) {
            if (z) {
                mo1357l = Math.min(abstractC3054b.mo1357l(), i);
            } else {
                mo1357l = abstractC3054b.mo1357l();
            }
            try {
                i2 = mo1277a((AbstractPollingIoProcessor<S>) s, abstractC3054b, mo1357l);
            } catch (IOException unused) {
                abstractC3054b.mo1345s();
                s.mo1016a();
                m1235m(s);
                return 0;
            }
        }
        s.m1073a(i2, j);
        if (!abstractC3054b.mo1356m() || (!z && i2 != 0)) {
            if (interfaceC3088b.mo954c().mo836b() instanceof AbstractC3054b) {
                AbstractC3054b abstractC3054b2 = (AbstractC3054b) interfaceC3088b.mo954c().mo836b();
                int mo1366f = abstractC3054b2.mo1366f();
                abstractC3054b2.mo1361i();
                m1268b((AbstractPollingIoProcessor<S>) s, interfaceC3088b);
                abstractC3054b2.mo1369d(mo1366f);
            } else {
                m1268b((AbstractPollingIoProcessor<S>) s, interfaceC3088b);
            }
        }
        return i2;
    }

    /* renamed from: b */
    private int m1267b(S s, InterfaceC3088b interfaceC3088b, boolean z, int i, long j) throws Exception {
        int i2;
        int min;
        FileRegion fileRegion = (FileRegion) interfaceC3088b.mo836b();
        if (fileRegion.mo1340a() > 0) {
            if (z) {
                min = (int) Math.min(fileRegion.mo1340a(), i);
            } else {
                min = (int) Math.min(2147483647L, fileRegion.mo1340a());
            }
            i2 = mo1276a((AbstractPollingIoProcessor<S>) s, fileRegion, min);
            fileRegion.mo1339a(i2);
        } else {
            i2 = 0;
        }
        s.m1073a(i2, j);
        if (fileRegion.mo1340a() <= 0 || (!z && i2 != 0)) {
            m1268b((AbstractPollingIoProcessor<S>) s, interfaceC3088b);
        }
        return i2;
    }

    /* renamed from: b */
    private void m1268b(S s, InterfaceC3088b interfaceC3088b) {
        s.mo1012a(null);
        s.mo1002e().mo1099a(interfaceC3088b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m1232o() {
        for (int size = this.f11361i.size(); size > 0; size--) {
            S poll = this.f11361i.poll();
            if (poll == null) {
                return;
            }
            SessionState mo1280a = mo1280a((AbstractPollingIoProcessor<S>) poll);
            switch (mo1280a) {
                case OPENED:
                    m1243i((AbstractPollingIoProcessor<S>) poll);
                    break;
                case CLOSING:
                    break;
                case OPENING:
                    this.f11361i.add(poll);
                    break;
                default:
                    throw new IllegalStateException(String.valueOf(mo1280a));
            }
        }
    }

    /* renamed from: i */
    public void m1243i(S s) {
        boolean z = true;
        try {
            mo1266b((AbstractPollingIoProcessor<S>) s, !s.m1045y());
        } catch (Exception e) {
            s.mo1002e().mo1101a((Throwable) e);
        }
        try {
            if (s.mo1018P().mo957b(s) || s.mo1017Q()) {
                z = false;
            }
            mo1273a((AbstractPollingIoProcessor<S>) s, z);
        } catch (Exception e2) {
            s.mo1002e().mo1101a((Throwable) e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractPollingIoProcessor.java */
    /* renamed from: org.apache.mina.core.d.b$a */
    /* loaded from: classes2.dex */
    public class RunnableC3060a implements Runnable {

        /* renamed from: a */
        static final /* synthetic */ boolean f11369a = !AbstractPollingIoProcessor.class.desiredAssertionStatus();

        private RunnableC3060a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!f11369a && AbstractPollingIoProcessor.this.f11362j.get() != this) {
                throw new AssertionError();
            }
            AbstractPollingIoProcessor.this.f11363k = System.currentTimeMillis();
            int i = 10;
            int i2 = 0;
            while (true) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    int mo1284a = AbstractPollingIoProcessor.this.mo1284a(1000L);
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (AbstractPollingIoProcessor.this.f11355a.getAndSet(false) || mo1284a != 0 || currentTimeMillis2 >= 100) {
                        i = 10;
                    } else if (AbstractPollingIoProcessor.this.mo1245i()) {
                        AbstractPollingIoProcessor.f11353b.warn("Broken connection");
                    } else if (i == 0) {
                        AbstractPollingIoProcessor.f11353b.warn("Create a new selector. Selected is 0, delta = " + currentTimeMillis2);
                        AbstractPollingIoProcessor.this.mo1248h();
                        i = 10;
                    } else {
                        i--;
                    }
                    int m1238l = i2 + AbstractPollingIoProcessor.this.m1238l();
                    AbstractPollingIoProcessor.this.m1232o();
                    if (mo1284a > 0) {
                        AbstractPollingIoProcessor.this.m1234n();
                    }
                    long currentTimeMillis3 = System.currentTimeMillis();
                    AbstractPollingIoProcessor.this.m1264c(currentTimeMillis3);
                    i2 = m1238l - AbstractPollingIoProcessor.this.m1236m();
                    AbstractPollingIoProcessor.this.m1272b(currentTimeMillis3);
                    if (i2 == 0) {
                        AbstractPollingIoProcessor.this.f11362j.set(null);
                        if (AbstractPollingIoProcessor.this.f11358f.isEmpty() && AbstractPollingIoProcessor.this.mo1260d()) {
                            if (!f11369a && AbstractPollingIoProcessor.this.f11362j.get() == this) {
                                throw new AssertionError();
                            }
                        } else {
                            if (!f11369a && AbstractPollingIoProcessor.this.f11362j.get() == this) {
                                throw new AssertionError();
                            }
                            if (!AbstractPollingIoProcessor.this.f11362j.compareAndSet(null, this)) {
                                if (!f11369a && AbstractPollingIoProcessor.this.f11362j.get() == this) {
                                    throw new AssertionError();
                                }
                            } else if (!f11369a && AbstractPollingIoProcessor.this.f11362j.get() != this) {
                                throw new AssertionError();
                            }
                        }
                    }
                    if (AbstractPollingIoProcessor.this.mo1029a()) {
                        Iterator<S> mo1254f = AbstractPollingIoProcessor.this.mo1254f();
                        boolean z = false;
                        while (mo1254f.hasNext()) {
                            S next = mo1254f.next();
                            if (next.mo989q()) {
                                AbstractPollingIoProcessor.this.m1241j(next);
                                z = true;
                            }
                        }
                        if (z) {
                            AbstractPollingIoProcessor.this.mo1257e();
                        }
                    }
                } catch (ClosedSelectorException e) {
                    ExceptionMonitor.m808a().mo807a(e);
                } catch (Exception e2) {
                    ExceptionMonitor.m808a().mo807a(e2);
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e3) {
                        ExceptionMonitor.m808a().mo807a(e3);
                    }
                }
            }
            try {
                try {
                    synchronized (AbstractPollingIoProcessor.this.f11364l) {
                        if (AbstractPollingIoProcessor.this.f11365m) {
                            AbstractPollingIoProcessor.this.mo1265c();
                        }
                    }
                } catch (Exception e4) {
                    ExceptionMonitor.m808a().mo807a(e4);
                }
            } finally {
                AbstractPollingIoProcessor.this.f11367o.m1328a((Object) true);
            }
        }
    }
}
