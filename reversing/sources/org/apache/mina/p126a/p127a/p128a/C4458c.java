package org.apache.mina.p126a.p127a.p128a;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Collection;
import java.util.Iterator;
import org.apache.mina.core.p132d.AbstractPollingIoAcceptor;
import org.apache.mina.core.p133e.IoProcessor;
import org.apache.mina.core.p133e.TransportMetadata;
import org.apache.mina.p126a.p127a.DefaultSocketSessionConfig;
import org.apache.mina.p126a.p127a.SocketAcceptor;

/* renamed from: org.apache.mina.a.a.a.c */
/* loaded from: classes2.dex */
public final class NioSocketAcceptor extends AbstractPollingIoAcceptor<NioSession, ServerSocketChannel> implements SocketAcceptor {

    /* renamed from: f */
    private volatile Selector f11299f;

    /* renamed from: g */
    private volatile SelectorProvider f11300g;

    public NioSocketAcceptor() {
        super(new DefaultSocketSessionConfig(), NioProcessor.class);
        this.f11300g = null;
        ((DefaultSocketSessionConfig) mo1031i()).m1423a(this);
    }

    public NioSocketAcceptor(int i) {
        super(new DefaultSocketSessionConfig(), NioProcessor.class, i);
        this.f11300g = null;
        ((DefaultSocketSessionConfig) mo1031i()).m1423a(this);
    }

    @Override // org.apache.mina.core.p132d.AbstractPollingIoAcceptor
    /* renamed from: a */
    protected void mo1308a(SelectorProvider selectorProvider) throws Exception {
        this.f11300g = selectorProvider;
        if (selectorProvider == null) {
            this.f11299f = Selector.open();
        } else {
            this.f11299f = selectorProvider.openSelector();
        }
    }

    @Override // org.apache.mina.core.p132d.AbstractPollingIoAcceptor
    /* renamed from: a */
    protected void mo1311a() throws Exception {
        if (this.f11299f != null) {
            this.f11299f.close();
        }
    }

    @Override // org.apache.mina.core.p133e.IoService
    /* renamed from: z */
    public TransportMetadata mo1030z() {
        return NioSocketSession.f11302f;
    }

    @Override // org.apache.mina.core.p133e.AbstractIoAcceptor
    /* renamed from: k_ */
    public InetSocketAddress mo1226j() {
        return (InetSocketAddress) super.mo1226j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.mina.core.p132d.AbstractPollingIoAcceptor
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public NioSession mo1304a(IoProcessor<NioSession> ioProcessor, ServerSocketChannel serverSocketChannel) throws Exception {
        SocketChannel accept;
        SelectionKey keyFor = serverSocketChannel != null ? serverSocketChannel.keyFor(this.f11299f) : null;
        if (keyFor == null || !keyFor.isValid() || !keyFor.isAcceptable() || (accept = serverSocketChannel.accept()) == null) {
            return null;
        }
        return new NioSocketSession(this, ioProcessor, accept);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.mina.core.p132d.AbstractPollingIoAcceptor
    /* renamed from: c */
    public ServerSocketChannel mo1309a(SocketAddress socketAddress) throws Exception {
        ServerSocketChannel open;
        if (this.f11300g != null) {
            open = this.f11300g.openServerSocketChannel();
        } else {
            open = ServerSocketChannel.open();
        }
        try {
            open.configureBlocking(false);
            ServerSocket socket = open.socket();
            socket.setReuseAddress(m1292g());
            try {
                socket.bind(socketAddress, m1294f());
                open.register(this.f11299f, 16);
                return open;
            } catch (IOException e) {
                IOException iOException = new IOException("Error while binding on " + socketAddress + "\noriginal message : " + e.getMessage());
                iOException.initCause(e.getCause());
                open.close();
                throw iOException;
            }
        } catch (Throwable th) {
            mo1301b(open);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.mina.core.p132d.AbstractPollingIoAcceptor
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public SocketAddress mo1310a(ServerSocketChannel serverSocketChannel) throws Exception {
        return serverSocketChannel.socket().getLocalSocketAddress();
    }

    @Override // org.apache.mina.core.p132d.AbstractPollingIoAcceptor
    /* renamed from: b */
    protected int mo1302b() throws Exception {
        return this.f11299f.select();
    }

    @Override // org.apache.mina.core.p132d.AbstractPollingIoAcceptor
    /* renamed from: d */
    protected Iterator<ServerSocketChannel> mo1297d() {
        return new C3051a(this.f11299f.selectedKeys());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.mina.core.p132d.AbstractPollingIoAcceptor
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public void mo1301b(ServerSocketChannel serverSocketChannel) throws Exception {
        SelectionKey keyFor = serverSocketChannel.keyFor(this.f11299f);
        if (keyFor != null) {
            keyFor.cancel();
        }
        serverSocketChannel.close();
    }

    @Override // org.apache.mina.core.p132d.AbstractPollingIoAcceptor
    /* renamed from: c */
    protected void mo1299c() {
        this.f11299f.wakeup();
    }

    /* compiled from: NioSocketAcceptor.java */
    /* renamed from: org.apache.mina.a.a.a.c$a */
    /* loaded from: classes2.dex */
    private static class C3051a implements Iterator<ServerSocketChannel> {

        /* renamed from: a */
        private final Iterator<SelectionKey> f11301a;

        private C3051a(Collection<SelectionKey> collection) {
            this.f11301a = collection.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f11301a.hasNext();
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public ServerSocketChannel next() {
            SelectionKey next = this.f11301a.next();
            if (next.isValid() && next.isAcceptable()) {
                return (ServerSocketChannel) next.channel();
            }
            return null;
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f11301a.remove();
        }
    }
}
