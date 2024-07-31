package org.apache.mina.core.session;

import java.io.IOException;
import java.net.SocketAddress;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import org.apache.log4j.spi.LocationInfo;
import org.apache.mina.core.filterchain.DefaultIoFilterChain;
import org.apache.mina.core.filterchain.IoFilterChain;
import org.apache.mina.core.p130b.FileRegion;
import org.apache.mina.core.p133e.AbstractIoAcceptor;
import org.apache.mina.core.p133e.DefaultTransportMetadata;
import org.apache.mina.core.p133e.InterfaceC3064f;
import org.apache.mina.core.p133e.IoHandlerAdapter;
import org.apache.mina.core.p133e.IoProcessor;
import org.apache.mina.core.p133e.IoService;
import org.apache.mina.core.p133e.TransportMetadata;
import org.apache.mina.core.write.InterfaceC3088b;

/* renamed from: org.apache.mina.core.session.d */
/* loaded from: classes2.dex */
public class DummySession extends AbstractIoSession {

    /* renamed from: d */
    private static final TransportMetadata f11523d = new DefaultTransportMetadata("mina", "dummy", false, false, SocketAddress.class, IoSessionConfig.class, Object.class);

    /* renamed from: e */
    private static final SocketAddress f11524e = new SocketAddress() { // from class: org.apache.mina.core.session.DummySession$1
        private static final long serialVersionUID = -496112902353454179L;

        public String toString() {
            return LocationInfo.f11272NA;
        }
    };

    /* renamed from: f */
    private volatile IoService f11525f;

    /* renamed from: g */
    private volatile IoSessionConfig f11526g;

    /* renamed from: h */
    private final IoFilterChain f11527h;

    /* renamed from: i */
    private final IoProcessor<IoSession> f11528i;

    /* renamed from: j */
    private volatile InterfaceC3064f f11529j;

    /* renamed from: k */
    private volatile SocketAddress f11530k;

    /* renamed from: l */
    private volatile SocketAddress f11531l;

    /* renamed from: m */
    private volatile TransportMetadata f11532m;

    public DummySession() {
        super(new AbstractIoAcceptor(new AbstractIoSessionConfig() { // from class: org.apache.mina.core.session.d.2
        }, new Executor() { // from class: org.apache.mina.core.session.d.3
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
            }
        }) { // from class: org.apache.mina.core.session.d.4
            @Override // org.apache.mina.core.p133e.AbstractIoService
            /* renamed from: e */
            protected void mo1032e() throws Exception {
            }

            @Override // org.apache.mina.core.p133e.AbstractIoAcceptor
            /* renamed from: a */
            protected Set<SocketAddress> mo1034a(List<? extends SocketAddress> list) throws Exception {
                throw new UnsupportedOperationException();
            }

            @Override // org.apache.mina.core.p133e.AbstractIoAcceptor
            /* renamed from: b */
            protected void mo1033b(List<? extends SocketAddress> list) throws Exception {
                throw new UnsupportedOperationException();
            }

            @Override // org.apache.mina.core.p133e.IoService
            /* renamed from: z */
            public TransportMetadata mo1030z() {
                return DummySession.f11523d;
            }

            @Override // org.apache.mina.core.p133e.IoService
            /* renamed from: i */
            public IoSessionConfig mo1031i() {
                return this.f11380d;
            }
        });
        this.f11526g = new AbstractIoSessionConfig() { // from class: org.apache.mina.core.session.d.1
        };
        this.f11527h = new DefaultIoFilterChain(this);
        this.f11529j = new IoHandlerAdapter();
        SocketAddress socketAddress = f11524e;
        this.f11530k = socketAddress;
        this.f11531l = socketAddress;
        this.f11532m = f11523d;
        this.f11528i = new IoProcessor<IoSession>() { // from class: org.apache.mina.core.session.d.5
            @Override // org.apache.mina.core.p133e.IoProcessor
            /* renamed from: a */
            public boolean mo1029a() {
                return false;
            }

            @Override // org.apache.mina.core.p133e.IoProcessor
            /* renamed from: b */
            public void mo1026b() {
            }

            @Override // org.apache.mina.core.p133e.IoProcessor
            /* renamed from: c */
            public void mo1024c(IoSession ioSession) {
            }

            @Override // org.apache.mina.core.p133e.IoProcessor
            /* renamed from: b */
            public void mo1025b(IoSession ioSession) {
                DummySession dummySession = (DummySession) ioSession;
                InterfaceC3088b mo956c = dummySession.mo1018P().mo956c(ioSession);
                if (mo956c != null) {
                    Object mo836b = mo956c.mo836b();
                    if (mo836b instanceof FileRegion) {
                        FileRegion fileRegion = (FileRegion) mo836b;
                        try {
                            fileRegion.mo1338b().position(fileRegion.mo1337c() + fileRegion.mo1340a());
                            fileRegion.mo1339a(fileRegion.mo1340a());
                        } catch (IOException e) {
                            dummySession.mo1002e().mo1101a((Throwable) e);
                        }
                    }
                    DummySession.this.mo1002e().mo1099a(mo956c);
                }
            }

            @Override // org.apache.mina.core.p133e.IoProcessor
            /* renamed from: a */
            public void mo1027a(IoSession ioSession, InterfaceC3088b interfaceC3088b) {
                ioSession.mo1018P().mo958a(ioSession, interfaceC3088b);
                if (ioSession.mo1017Q()) {
                    return;
                }
                mo1025b(ioSession);
            }

            @Override // org.apache.mina.core.p133e.IoProcessor
            /* renamed from: a */
            public void mo1028a(IoSession ioSession) {
                if (ioSession.mo1010b().mo1334a()) {
                    return;
                }
                ioSession.mo1002e().mo1090e();
            }
        };
        this.f11525f = super.mo993m();
        try {
            DefaultIoSessionDataStructureFactory defaultIoSessionDataStructureFactory = new DefaultIoSessionDataStructureFactory();
            m1062a(defaultIoSessionDataStructureFactory.mo969a(this));
            m1060a(defaultIoSessionDataStructureFactory.mo968b(this));
        } catch (Exception unused) {
            throw new InternalError();
        }
    }

    @Override // org.apache.mina.core.session.AbstractIoSession, org.apache.mina.core.session.IoSession
    /* renamed from: c */
    public IoSessionConfig mo1007c() {
        return this.f11526g;
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: e */
    public IoFilterChain mo1002e() {
        return this.f11527h;
    }

    @Override // org.apache.mina.core.session.AbstractIoSession, org.apache.mina.core.session.IoSession
    /* renamed from: f */
    public InterfaceC3064f mo1000f() {
        return this.f11529j;
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: k */
    public SocketAddress mo995k() {
        return this.f11530k;
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: l */
    public SocketAddress mo994l() {
        return this.f11531l;
    }

    @Override // org.apache.mina.core.session.AbstractIoSession, org.apache.mina.core.session.IoSession
    /* renamed from: m */
    public IoService mo993m() {
        return this.f11525f;
    }

    @Override // org.apache.mina.core.session.AbstractIoSession
    /* renamed from: r */
    public final IoProcessor<IoSession> mo1035r() {
        return this.f11528i;
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: n */
    public TransportMetadata mo992n() {
        return this.f11532m;
    }
}
