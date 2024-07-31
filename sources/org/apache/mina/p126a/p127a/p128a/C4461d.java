package org.apache.mina.p126a.p127a.p128a;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import org.apache.mina.core.RuntimeIoException;
import org.apache.mina.core.p129a.AbstractC3054b;
import org.apache.mina.core.p130b.FileRegion;
import org.apache.mina.core.p133e.DefaultTransportMetadata;
import org.apache.mina.core.p133e.IoProcessor;
import org.apache.mina.core.p133e.IoService;
import org.apache.mina.core.p133e.TransportMetadata;
import org.apache.mina.p126a.p127a.AbstractSocketSessionConfig;
import org.apache.mina.p126a.p127a.SocketSessionConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: org.apache.mina.a.a.a.d */
/* loaded from: classes2.dex */
public class NioSocketSession extends NioSession {

    /* renamed from: f */
    static final TransportMetadata f11302f = new DefaultTransportMetadata("nio", "socket", false, true, InetSocketAddress.class, SocketSessionConfig.class, AbstractC3054b.class, FileRegion.class);

    public NioSocketSession(IoService ioService, IoProcessor<NioSession> ioProcessor, SocketChannel socketChannel) {
        super(ioProcessor, ioService, socketChannel);
        this.f11490a = new C3053a();
        this.f11490a.mo978a(ioService.mo1031i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I */
    public Socket m1435I() {
        return ((SocketChannel) this.f11296e).socket();
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: n */
    public TransportMetadata mo992n() {
        return f11302f;
    }

    @Override // org.apache.mina.core.session.AbstractIoSession, org.apache.mina.core.session.IoSession
    /* renamed from: E */
    public SocketSessionConfig mo1007c() {
        return (SocketSessionConfig) this.f11490a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.apache.mina.p126a.p127a.p128a.NioSession
    /* renamed from: F */
    public SocketChannel mo1440C() {
        return (SocketChannel) this.f11296e;
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: G */
    public InetSocketAddress mo994l() {
        Socket m1435I;
        if (this.f11296e == null || (m1435I = m1435I()) == null) {
            return null;
        }
        return (InetSocketAddress) m1435I.getRemoteSocketAddress();
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: H */
    public InetSocketAddress mo995k() {
        Socket m1435I;
        if (this.f11296e == null || (m1435I = m1435I()) == null) {
            return null;
        }
        return (InetSocketAddress) m1435I.getLocalSocketAddress();
    }

    /* compiled from: NioSocketSession.java */
    /* renamed from: org.apache.mina.a.a.a.d$a */
    /* loaded from: classes2.dex */
    private class C3053a extends AbstractSocketSessionConfig {
        private C3053a() {
        }

        @Override // org.apache.mina.p126a.p127a.SocketSessionConfig
        /* renamed from: t */
        public boolean mo1399t() {
            try {
                return NioSocketSession.this.m1435I().getKeepAlive();
            } catch (SocketException e) {
                throw new RuntimeIoException(e);
            }
        }

        @Override // org.apache.mina.p126a.p127a.SocketSessionConfig
        /* renamed from: c */
        public void mo1410c(boolean z) {
            try {
                NioSocketSession.this.m1435I().setKeepAlive(z);
            } catch (SocketException e) {
                throw new RuntimeIoException(e);
            }
        }

        @Override // org.apache.mina.p126a.p127a.SocketSessionConfig
        /* renamed from: u */
        public boolean mo1398u() {
            try {
                return NioSocketSession.this.m1435I().getOOBInline();
            } catch (SocketException e) {
                throw new RuntimeIoException(e);
            }
        }

        @Override // org.apache.mina.p126a.p127a.SocketSessionConfig
        /* renamed from: d */
        public void mo1409d(boolean z) {
            try {
                NioSocketSession.this.m1435I().setOOBInline(z);
            } catch (SocketException e) {
                throw new RuntimeIoException(e);
            }
        }

        @Override // org.apache.mina.p126a.p127a.SocketSessionConfig
        /* renamed from: p */
        public boolean mo1403p() {
            try {
                return NioSocketSession.this.m1435I().getReuseAddress();
            } catch (SocketException e) {
                throw new RuntimeIoException(e);
            }
        }

        @Override // org.apache.mina.p126a.p127a.SocketSessionConfig
        /* renamed from: b */
        public void mo1411b(boolean z) {
            try {
                NioSocketSession.this.m1435I().setReuseAddress(z);
            } catch (SocketException e) {
                throw new RuntimeIoException(e);
            }
        }

        @Override // org.apache.mina.p126a.p127a.SocketSessionConfig
        /* renamed from: v */
        public int mo1397v() {
            try {
                return NioSocketSession.this.m1435I().getSoLinger();
            } catch (SocketException e) {
                throw new RuntimeIoException(e);
            }
        }

        @Override // org.apache.mina.p126a.p127a.SocketSessionConfig
        /* renamed from: j */
        public void mo1404j(int i) {
            try {
                if (i < 0) {
                    NioSocketSession.this.m1435I().setSoLinger(false, 0);
                } else {
                    NioSocketSession.this.m1435I().setSoLinger(true, i);
                }
            } catch (SocketException e) {
                throw new RuntimeIoException(e);
            }
        }

        @Override // org.apache.mina.p126a.p127a.SocketSessionConfig
        /* renamed from: w */
        public boolean mo1396w() {
            if (NioSocketSession.this.mo990p()) {
                try {
                    return NioSocketSession.this.m1435I().getTcpNoDelay();
                } catch (SocketException e) {
                    throw new RuntimeIoException(e);
                }
            }
            return false;
        }

        @Override // org.apache.mina.p126a.p127a.SocketSessionConfig
        /* renamed from: e */
        public void mo1408e(boolean z) {
            try {
                NioSocketSession.this.m1435I().setTcpNoDelay(z);
            } catch (SocketException e) {
                throw new RuntimeIoException(e);
            }
        }

        @Override // org.apache.mina.p126a.p127a.SocketSessionConfig
        /* renamed from: s */
        public int mo1400s() {
            try {
                return NioSocketSession.this.m1435I().getTrafficClass();
            } catch (SocketException e) {
                throw new RuntimeIoException(e);
            }
        }

        @Override // org.apache.mina.p126a.p127a.SocketSessionConfig
        /* renamed from: i */
        public void mo1405i(int i) {
            try {
                NioSocketSession.this.m1435I().setTrafficClass(i);
            } catch (SocketException e) {
                throw new RuntimeIoException(e);
            }
        }

        @Override // org.apache.mina.p126a.p127a.SocketSessionConfig
        /* renamed from: r */
        public int mo1401r() {
            try {
                return NioSocketSession.this.m1435I().getSendBufferSize();
            } catch (SocketException e) {
                throw new RuntimeIoException(e);
            }
        }

        @Override // org.apache.mina.p126a.p127a.SocketSessionConfig
        /* renamed from: h */
        public void mo1406h(int i) {
            try {
                NioSocketSession.this.m1435I().setSendBufferSize(i);
            } catch (SocketException e) {
                throw new RuntimeIoException(e);
            }
        }

        @Override // org.apache.mina.p126a.p127a.SocketSessionConfig
        /* renamed from: q */
        public int mo1402q() {
            try {
                return NioSocketSession.this.m1435I().getReceiveBufferSize();
            } catch (SocketException e) {
                throw new RuntimeIoException(e);
            }
        }

        @Override // org.apache.mina.p126a.p127a.SocketSessionConfig
        /* renamed from: g */
        public void mo1407g(int i) {
            try {
                NioSocketSession.this.m1435I().setReceiveBufferSize(i);
            } catch (SocketException e) {
                throw new RuntimeIoException(e);
            }
        }
    }
}
