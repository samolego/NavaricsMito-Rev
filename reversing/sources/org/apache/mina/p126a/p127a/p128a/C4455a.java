package org.apache.mina.p126a.p127a.p128a;

import java.io.IOException;
import java.nio.channels.ByteChannel;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Set;
import org.apache.mina.core.p129a.AbstractC3054b;
import org.apache.mina.core.p130b.FileRegion;
import org.apache.mina.core.p132d.AbstractPollingIoProcessor;
import org.apache.mina.core.session.SessionState;

/* renamed from: org.apache.mina.a.a.a.a */
/* loaded from: classes2.dex */
public final class NioProcessor extends AbstractPollingIoProcessor<NioSession> {

    /* renamed from: b */
    private Selector f11292b;

    /* renamed from: c */
    private SelectorProvider f11293c;

    @Override // org.apache.mina.core.p132d.AbstractPollingIoProcessor
    /* renamed from: c */
    protected void mo1265c() throws Exception {
        this.f11292b.close();
    }

    @Override // org.apache.mina.core.p132d.AbstractPollingIoProcessor
    /* renamed from: a */
    protected int mo1284a(long j) throws Exception {
        return this.f11292b.select(j);
    }

    @Override // org.apache.mina.core.p132d.AbstractPollingIoProcessor
    /* renamed from: d */
    protected boolean mo1260d() {
        return this.f11292b.keys().isEmpty();
    }

    @Override // org.apache.mina.core.p132d.AbstractPollingIoProcessor
    /* renamed from: e */
    protected void mo1257e() {
        this.f11355a.getAndSet(true);
        this.f11292b.wakeup();
    }

    @Override // org.apache.mina.core.p132d.AbstractPollingIoProcessor
    /* renamed from: f */
    protected Iterator<NioSession> mo1254f() {
        return new C3049a(this.f11292b.keys());
    }

    @Override // org.apache.mina.core.p132d.AbstractPollingIoProcessor
    /* renamed from: g */
    protected Iterator<NioSession> mo1251g() {
        return new C3049a(this.f11292b.selectedKeys());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.mina.core.p132d.AbstractPollingIoProcessor
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo1258d(NioSession nioSession) throws Exception {
        SelectableChannel selectableChannel = (SelectableChannel) nioSession.mo1440C();
        selectableChannel.configureBlocking(false);
        nioSession.m1446a(selectableChannel.register(this.f11292b, 1, nioSession));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.mina.core.p132d.AbstractPollingIoProcessor
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public void mo1255e(NioSession nioSession) throws Exception {
        ByteChannel mo1440C = nioSession.mo1440C();
        SelectionKey m1447D = nioSession.m1447D();
        if (m1447D != null) {
            m1447D.cancel();
        }
        if (mo1440C.isOpen()) {
            mo1440C.close();
        }
    }

    @Override // org.apache.mina.core.p132d.AbstractPollingIoProcessor
    /* renamed from: h */
    protected void mo1248h() throws IOException {
        Selector openSelector;
        synchronized (this.f11292b) {
            Set<SelectionKey> keys = this.f11292b.keys();
            if (this.f11293c == null) {
                openSelector = Selector.open();
            } else {
                openSelector = this.f11293c.openSelector();
            }
            for (SelectionKey selectionKey : keys) {
                SelectableChannel channel = selectionKey.channel();
                NioSession nioSession = (NioSession) selectionKey.attachment();
                nioSession.m1446a(channel.register(openSelector, selectionKey.interestOps(), nioSession));
            }
            this.f11292b.close();
            this.f11292b = openSelector;
        }
    }

    @Override // org.apache.mina.core.p132d.AbstractPollingIoProcessor
    /* renamed from: i */
    protected boolean mo1245i() throws IOException {
        boolean z;
        synchronized (this.f11292b) {
            z = false;
            for (SelectionKey selectionKey : this.f11292b.keys()) {
                SelectableChannel channel = selectionKey.channel();
                if (((channel instanceof DatagramChannel) && !((DatagramChannel) channel).isConnected()) || ((channel instanceof SocketChannel) && !((SocketChannel) channel).isConnected())) {
                    selectionKey.cancel();
                    z = true;
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.mina.core.p132d.AbstractPollingIoProcessor
    /* renamed from: c  reason: avoid collision after fix types in other method */
    public SessionState mo1280a(NioSession nioSession) {
        SelectionKey m1447D = nioSession.m1447D();
        if (m1447D == null) {
            return SessionState.OPENING;
        }
        if (m1447D.isValid()) {
            return SessionState.OPENED;
        }
        return SessionState.CLOSING;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.mina.core.p132d.AbstractPollingIoProcessor
    /* renamed from: d  reason: avoid collision after fix types in other method */
    public boolean mo1261c(NioSession nioSession) {
        SelectionKey m1447D = nioSession.m1447D();
        return m1447D != null && m1447D.isValid() && m1447D.isReadable();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.mina.core.p132d.AbstractPollingIoProcessor
    /* renamed from: e  reason: avoid collision after fix types in other method */
    public boolean mo1269b(NioSession nioSession) {
        SelectionKey m1447D = nioSession.m1447D();
        return m1447D != null && m1447D.isValid() && m1447D.isWritable();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.mina.core.p132d.AbstractPollingIoProcessor
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo1266b(NioSession nioSession, boolean z) throws Exception {
        SelectionKey m1447D = nioSession.m1447D();
        if (m1447D == null || !m1447D.isValid()) {
            return;
        }
        int interestOps = m1447D.interestOps();
        int i = z ? interestOps | 1 : interestOps & (-2);
        if (interestOps != i) {
            m1447D.interestOps(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.mina.core.p132d.AbstractPollingIoProcessor
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public void mo1273a(NioSession nioSession, boolean z) throws Exception {
        SelectionKey m1447D = nioSession.m1447D();
        if (m1447D == null || !m1447D.isValid()) {
            return;
        }
        int interestOps = m1447D.interestOps();
        m1447D.interestOps(z ? interestOps | 4 : interestOps & (-5));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.mina.core.p132d.AbstractPollingIoProcessor
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public int mo1278a(NioSession nioSession, AbstractC3054b abstractC3054b) throws Exception {
        return nioSession.mo1440C().read(abstractC3054b.mo1344t());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.mina.core.p132d.AbstractPollingIoProcessor
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public int mo1277a(NioSession nioSession, AbstractC3054b abstractC3054b, int i) throws IOException {
        if (abstractC3054b.mo1357l() <= i) {
            return nioSession.mo1440C().write(abstractC3054b.mo1344t());
        }
        int mo1364g = abstractC3054b.mo1364g();
        abstractC3054b.mo1367e(abstractC3054b.mo1366f() + i);
        try {
            return nioSession.mo1440C().write(abstractC3054b.mo1344t());
        } finally {
            abstractC3054b.mo1367e(mo1364g);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.mina.core.p132d.AbstractPollingIoProcessor
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public int mo1276a(NioSession nioSession, FileRegion fileRegion, int i) throws Exception {
        try {
            return (int) fileRegion.mo1338b().transferTo(fileRegion.mo1337c(), i, nioSession.mo1440C());
        } catch (IOException e) {
            String message = e.getMessage();
            if (message == null || !message.contains("temporarily unavailable")) {
                throw e;
            }
            return 0;
        }
    }

    /* compiled from: NioProcessor.java */
    /* renamed from: org.apache.mina.a.a.a.a$a */
    /* loaded from: classes2.dex */
    protected static class C3049a<NioSession> implements Iterator<NioSession> {

        /* renamed from: a */
        private final Iterator<SelectionKey> f11294a;

        private C3049a(Set<SelectionKey> set) {
            this.f11294a = set.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f11294a.hasNext();
        }

        @Override // java.util.Iterator
        public NioSession next() {
            return (NioSession) this.f11294a.next().attachment();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f11294a.remove();
        }
    }
}
