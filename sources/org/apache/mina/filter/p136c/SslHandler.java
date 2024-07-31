package org.apache.mina.filter.p136c;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.filterchain.IoFilterEvent;
import org.apache.mina.core.p129a.AbstractC3054b;
import org.apache.mina.core.p131c.DefaultWriteFuture;
import org.apache.mina.core.p131c.WriteFuture;
import org.apache.mina.core.session.IoEventType;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.write.DefaultWriteRequest;
import org.apache.mina.core.write.InterfaceC3088b;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: org.apache.mina.filter.c.b */
/* loaded from: classes2.dex */
public class SslHandler {

    /* renamed from: a */
    private static final InterfaceC3153b f11596a = C3154c.m262a(SslHandler.class);

    /* renamed from: b */
    private final SslFilter f11597b;

    /* renamed from: c */
    private final IoSession f11598c;

    /* renamed from: g */
    private SSLEngine f11602g;

    /* renamed from: h */
    private AbstractC3054b f11603h;

    /* renamed from: i */
    private AbstractC3054b f11604i;

    /* renamed from: j */
    private AbstractC3054b f11605j;

    /* renamed from: l */
    private SSLEngineResult.HandshakeStatus f11607l;

    /* renamed from: m */
    private boolean f11608m;

    /* renamed from: n */
    private boolean f11609n;

    /* renamed from: o */
    private boolean f11610o;

    /* renamed from: d */
    private final Queue<IoFilterEvent> f11599d = new ConcurrentLinkedQueue();

    /* renamed from: e */
    private final Queue<IoFilterEvent> f11600e = new ConcurrentLinkedQueue();

    /* renamed from: f */
    private final Queue<IoFilterEvent> f11601f = new ConcurrentLinkedQueue();

    /* renamed from: k */
    private final AbstractC3054b f11606k = AbstractC3054b.m1362h(0);

    /* renamed from: p */
    private ReentrantLock f11611p = new ReentrantLock();

    /* renamed from: q */
    private final AtomicInteger f11612q = new AtomicInteger(0);

    /* JADX INFO: Access modifiers changed from: package-private */
    public SslHandler(SslFilter sslFilter, IoSession ioSession) throws SSLException {
        this.f11597b = sslFilter;
        this.f11598c = ioSession;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m893a() throws SSLException {
        if (this.f11602g != null) {
            return;
        }
        f11596a.debug("{} Initializing the SSL Handler", this.f11597b.m905b(this.f11598c));
        InetSocketAddress inetSocketAddress = (InetSocketAddress) this.f11598c.mo1009b(SslFilter.f11578d);
        if (inetSocketAddress == null) {
            this.f11602g = this.f11597b.f11584g.createSSLEngine();
        } else {
            this.f11602g = this.f11597b.f11584g.createSSLEngine(inetSocketAddress.getHostName(), inetSocketAddress.getPort());
        }
        this.f11602g.setUseClientMode(this.f11597b.m914a());
        if (!this.f11602g.getUseClientMode()) {
            if (this.f11597b.m903c()) {
                this.f11602g.setWantClientAuth(true);
            }
            if (this.f11597b.m908b()) {
                this.f11602g.setNeedClientAuth(true);
            }
        }
        if (this.f11597b.m900d() != null) {
            this.f11602g.setEnabledCipherSuites(this.f11597b.m900d());
        }
        if (this.f11597b.m898e() != null) {
            this.f11602g.setEnabledProtocols(this.f11597b.m898e());
        }
        this.f11602g.beginHandshake();
        this.f11607l = this.f11602g.getHandshakeStatus();
        this.f11610o = false;
        this.f11608m = true;
        this.f11609n = false;
        if (f11596a.isDebugEnabled()) {
            f11596a.debug("{} SSL Handler Initialization done.", this.f11597b.m905b(this.f11598c));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m884b() {
        SSLEngine sSLEngine = this.f11602g;
        if (sSLEngine == null) {
            return;
        }
        try {
            sSLEngine.closeInbound();
        } catch (SSLException e) {
            f11596a.debug("Unexpected exception from SSLEngine.closeInbound().", (Throwable) e);
        }
        AbstractC3054b abstractC3054b = this.f11604i;
        if (abstractC3054b != null) {
            abstractC3054b.mo1375b(this.f11602g.getSession().getPacketBufferSize());
        } else {
            m892a(0);
        }
        do {
            try {
                this.f11604i.mo1359j();
            } catch (SSLException unused) {
            } catch (Throwable th) {
                this.f11604i.mo1345s();
                this.f11604i = null;
                throw th;
            }
        } while (this.f11602g.wrap(this.f11606k.mo1344t(), this.f11604i.mo1344t()).bytesProduced() > 0);
        this.f11604i.mo1345s();
        this.f11604i = null;
        this.f11602g.closeOutbound();
        this.f11602g = null;
        this.f11599d.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public SslFilter m881c() {
        return this.f11597b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public IoSession m879d() {
        return this.f11598c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean m878e() {
        return this.f11610o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean m877f() {
        return this.f11609n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean m876g() {
        SSLEngine sSLEngine = this.f11602g;
        return sSLEngine == null || sSLEngine.isInboundDone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean m875h() {
        SSLEngine sSLEngine = this.f11602g;
        return sSLEngine == null || sSLEngine.isOutboundDone();
    }

    /* renamed from: i */
    boolean m874i() {
        return this.f11607l == SSLEngineResult.HandshakeStatus.NEED_WRAP && !m876g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m885a(IoFilter.InterfaceC3073a interfaceC3073a, InterfaceC3088b interfaceC3088b) {
        this.f11599d.add(new IoFilterEvent(interfaceC3073a, IoEventType.WRITE, this.f11598c, interfaceC3088b));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public void m873j() throws SSLException {
        while (true) {
            IoFilterEvent poll = this.f11599d.poll();
            if (poll == null) {
                return;
            }
            this.f11597b.mo827a(poll.m1083a(), this.f11598c, (InterfaceC3088b) poll.m1020e());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m882b(IoFilter.InterfaceC3073a interfaceC3073a, InterfaceC3088b interfaceC3088b) {
        this.f11600e.add(new IoFilterEvent(interfaceC3073a, IoEventType.WRITE, this.f11598c, interfaceC3088b));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m888a(IoFilter.InterfaceC3073a interfaceC3073a, Object obj) {
        this.f11601f.add(new IoFilterEvent(interfaceC3073a, IoEventType.MESSAGE_RECEIVED, this.f11598c, obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public void m872k() {
        this.f11612q.incrementAndGet();
        if (!this.f11611p.tryLock()) {
            return;
        }
        while (true) {
            try {
                IoFilterEvent poll = this.f11600e.poll();
                if (poll != null) {
                    poll.m1083a().mo1109b(this.f11598c, (InterfaceC3088b) poll.m1020e());
                } else {
                    while (true) {
                        IoFilterEvent poll2 = this.f11601f.poll();
                        if (poll2 == null) {
                            break;
                        }
                        poll2.m1083a().mo1114a(this.f11598c, poll2.m1020e());
                    }
                    if (this.f11612q.decrementAndGet() <= 0) {
                        return;
                    }
                }
            } finally {
                this.f11611p.unlock();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m887a(IoFilter.InterfaceC3073a interfaceC3073a, ByteBuffer byteBuffer) throws SSLException {
        if (f11596a.isDebugEnabled()) {
            if (!m875h()) {
                f11596a.debug("{} Processing the received message", this.f11597b.m905b(this.f11598c));
            } else {
                f11596a.debug("{} Processing the received message", this.f11597b.m905b(this.f11598c));
            }
        }
        if (this.f11603h == null) {
            this.f11603h = AbstractC3054b.m1362h(byteBuffer.remaining()).mo1378a(true);
        }
        this.f11603h.mo1374b(byteBuffer);
        if (!this.f11609n) {
            m889a(interfaceC3073a);
        } else {
            this.f11603h.mo1358k();
            if (!this.f11603h.mo1356m()) {
                return;
            }
            SSLEngineResult m867p = m867p();
            if (this.f11603h.mo1356m()) {
                this.f11603h.mo1354o();
            } else {
                this.f11603h.mo1345s();
                this.f11603h = null;
            }
            m890a(m867p);
            m886a(interfaceC3073a, m867p);
        }
        if (m876g()) {
            AbstractC3054b abstractC3054b = this.f11603h;
            byteBuffer.position(byteBuffer.position() - (abstractC3054b == null ? 0 : abstractC3054b.mo1366f()));
            AbstractC3054b abstractC3054b2 = this.f11603h;
            if (abstractC3054b2 != null) {
                abstractC3054b2.mo1345s();
                this.f11603h = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public AbstractC3054b m871l() {
        AbstractC3054b abstractC3054b = this.f11605j;
        if (abstractC3054b == null) {
            return AbstractC3054b.m1362h(0);
        }
        AbstractC3054b mo1358k = abstractC3054b.mo1358k();
        this.f11605j = null;
        return mo1358k.mo1368e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public AbstractC3054b m870m() {
        AbstractC3054b abstractC3054b = this.f11604i;
        if (abstractC3054b == null) {
            return this.f11606k;
        }
        this.f11604i = null;
        return abstractC3054b.mo1368e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m891a(ByteBuffer byteBuffer) throws SSLException {
        if (!this.f11609n) {
            throw new IllegalStateException();
        }
        if (!byteBuffer.hasRemaining()) {
            if (this.f11604i == null) {
                this.f11604i = this.f11606k;
                return;
            }
            return;
        }
        m892a(byteBuffer.remaining());
        while (byteBuffer.hasRemaining()) {
            SSLEngineResult wrap = this.f11602g.wrap(byteBuffer, this.f11604i.mo1344t());
            if (wrap.getStatus() == SSLEngineResult.Status.OK) {
                if (wrap.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_TASK) {
                    m866q();
                }
            } else if (wrap.getStatus() == SSLEngineResult.Status.BUFFER_OVERFLOW) {
                AbstractC3054b abstractC3054b = this.f11604i;
                abstractC3054b.mo1375b(abstractC3054b.mo1376b() << 1);
                AbstractC3054b abstractC3054b2 = this.f11604i;
                abstractC3054b2.mo1367e(abstractC3054b2.mo1376b());
            } else {
                throw new SSLException("SSLEngine error during encrypt: " + wrap.getStatus() + " src: " + byteBuffer + "outNetBuffer: " + this.f11604i);
            }
        }
        this.f11604i.mo1358k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public boolean m869n() throws SSLException {
        SSLEngineResult wrap;
        SSLEngine sSLEngine = this.f11602g;
        if (sSLEngine == null || sSLEngine.isOutboundDone()) {
            return false;
        }
        this.f11602g.closeOutbound();
        m892a(0);
        while (true) {
            wrap = this.f11602g.wrap(this.f11606k.mo1344t(), this.f11604i.mo1344t());
            if (wrap.getStatus() != SSLEngineResult.Status.BUFFER_OVERFLOW) {
                break;
            }
            AbstractC3054b abstractC3054b = this.f11604i;
            abstractC3054b.mo1375b(abstractC3054b.mo1376b() << 1);
            AbstractC3054b abstractC3054b2 = this.f11604i;
            abstractC3054b2.mo1367e(abstractC3054b2.mo1376b());
        }
        if (wrap.getStatus() != SSLEngineResult.Status.CLOSED) {
            throw new SSLException("Improper close state: " + wrap);
        }
        this.f11604i.mo1358k();
        return true;
    }

    /* renamed from: a */
    private void m890a(SSLEngineResult sSLEngineResult) throws SSLException {
        SSLEngineResult.Status status = sSLEngineResult.getStatus();
        if (status != SSLEngineResult.Status.BUFFER_OVERFLOW) {
            return;
        }
        throw new SSLException("SSLEngine error during decrypt: " + status + " inNetBuffer: " + this.f11603h + "appBuffer: " + this.f11605j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SslHandler.java */
    /* renamed from: org.apache.mina.filter.c.b$1 */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C30961 {

        /* renamed from: a */
        static final /* synthetic */ int[] f11613a = new int[SSLEngineResult.HandshakeStatus.values().length];

        static {
            try {
                f11613a[SSLEngineResult.HandshakeStatus.FINISHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11613a[SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11613a[SSLEngineResult.HandshakeStatus.NEED_TASK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11613a[SSLEngineResult.HandshakeStatus.NEED_UNWRAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11613a[SSLEngineResult.HandshakeStatus.NEED_WRAP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m889a(IoFilter.InterfaceC3073a interfaceC3073a) throws SSLException {
        while (true) {
            switch (C30961.f11613a[this.f11607l.ordinal()]) {
                case 1:
                case 2:
                    if (f11596a.isDebugEnabled()) {
                        f11596a.debug("{} processing the FINISHED state", this.f11597b.m905b(this.f11598c));
                    }
                    this.f11598c.mo1008b(SslFilter.f11575a, this.f11602g.getSession());
                    this.f11609n = true;
                    if (this.f11608m && this.f11598c.mo1015a(SslFilter.f11577c)) {
                        this.f11608m = false;
                        m888a(interfaceC3073a, SslFilter.f11579e);
                    }
                    if (f11596a.isDebugEnabled()) {
                        if (!m875h()) {
                            f11596a.debug("{} is now secured", this.f11597b.m905b(this.f11598c));
                            return;
                        } else {
                            f11596a.debug("{} is not secured yet", this.f11597b.m905b(this.f11598c));
                            return;
                        }
                    }
                    return;
                case 3:
                    if (f11596a.isDebugEnabled()) {
                        f11596a.debug("{} processing the NEED_TASK state", this.f11597b.m905b(this.f11598c));
                    }
                    this.f11607l = m866q();
                    break;
                case 4:
                    if (f11596a.isDebugEnabled()) {
                        f11596a.debug("{} processing the NEED_UNWRAP state", this.f11597b.m905b(this.f11598c));
                    }
                    if ((m880c(interfaceC3073a) != SSLEngineResult.Status.BUFFER_UNDERFLOW || this.f11607l == SSLEngineResult.HandshakeStatus.FINISHED) && !m876g()) {
                        break;
                    } else {
                        return;
                    }
                case 5:
                    if (f11596a.isDebugEnabled()) {
                        f11596a.debug("{} processing the NEED_WRAP state", this.f11597b.m905b(this.f11598c));
                    }
                    AbstractC3054b abstractC3054b = this.f11604i;
                    if (abstractC3054b != null && abstractC3054b.mo1356m()) {
                        return;
                    }
                    m892a(0);
                    while (true) {
                        SSLEngineResult wrap = this.f11602g.wrap(this.f11606k.mo1344t(), this.f11604i.mo1344t());
                        if (wrap.getStatus() == SSLEngineResult.Status.BUFFER_OVERFLOW) {
                            AbstractC3054b abstractC3054b2 = this.f11604i;
                            abstractC3054b2.mo1375b(abstractC3054b2.mo1376b() << 1);
                            AbstractC3054b abstractC3054b3 = this.f11604i;
                            abstractC3054b3.mo1367e(abstractC3054b3.mo1376b());
                        } else {
                            this.f11604i.mo1358k();
                            this.f11607l = wrap.getHandshakeStatus();
                            m883b(interfaceC3073a);
                            break;
                        }
                    }
                    break;
                default:
                    String str = "Invalid Handshaking State" + this.f11607l + " while processing the Handshake for session " + this.f11598c.mo999g();
                    f11596a.error(str);
                    throw new IllegalStateException(str);
            }
        }
    }

    /* renamed from: a */
    private void m892a(int i) {
        int max = Math.max(i, this.f11602g.getSession().getPacketBufferSize());
        AbstractC3054b abstractC3054b = this.f11604i;
        if (abstractC3054b != null) {
            abstractC3054b.mo1375b(max);
        } else {
            this.f11604i = AbstractC3054b.m1362h(max).mo1383a(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public WriteFuture m883b(IoFilter.InterfaceC3073a interfaceC3073a) throws SSLException {
        AbstractC3054b abstractC3054b = this.f11604i;
        if (abstractC3054b == null || !abstractC3054b.mo1356m()) {
            return null;
        }
        this.f11610o = true;
        try {
            AbstractC3054b m870m = m870m();
            DefaultWriteFuture defaultWriteFuture = new DefaultWriteFuture(this.f11598c);
            this.f11597b.mo827a(interfaceC3073a, this.f11598c, (InterfaceC3088b) new DefaultWriteRequest(m870m, defaultWriteFuture));
            while (m874i()) {
                try {
                    m889a(interfaceC3073a);
                    AbstractC3054b m870m2 = m870m();
                    if (m870m2 != null && m870m2.mo1356m()) {
                        defaultWriteFuture = new DefaultWriteFuture(this.f11598c);
                        this.f11597b.mo827a(interfaceC3073a, this.f11598c, (InterfaceC3088b) new DefaultWriteRequest(m870m2, defaultWriteFuture));
                    }
                } catch (SSLException e) {
                    SSLHandshakeException sSLHandshakeException = new SSLHandshakeException("SSL handshake failed.");
                    sSLHandshakeException.initCause(e);
                    throw sSLHandshakeException;
                }
            }
            return defaultWriteFuture;
        } finally {
            this.f11610o = false;
        }
    }

    /* renamed from: c */
    private SSLEngineResult.Status m880c(IoFilter.InterfaceC3073a interfaceC3073a) throws SSLException {
        AbstractC3054b abstractC3054b = this.f11603h;
        if (abstractC3054b != null) {
            abstractC3054b.mo1358k();
        }
        AbstractC3054b abstractC3054b2 = this.f11603h;
        if (abstractC3054b2 == null || !abstractC3054b2.mo1356m()) {
            return SSLEngineResult.Status.BUFFER_UNDERFLOW;
        }
        SSLEngineResult m867p = m867p();
        this.f11607l = m867p.getHandshakeStatus();
        m890a(m867p);
        if (this.f11607l == SSLEngineResult.HandshakeStatus.FINISHED && m867p.getStatus() == SSLEngineResult.Status.OK && this.f11603h.mo1356m()) {
            m867p = m867p();
            if (this.f11603h.mo1356m()) {
                this.f11603h.mo1354o();
            } else {
                this.f11603h.mo1345s();
                this.f11603h = null;
            }
            m886a(interfaceC3073a, m867p);
        } else if (this.f11603h.mo1356m()) {
            this.f11603h.mo1354o();
        } else {
            this.f11603h.mo1345s();
            this.f11603h = null;
        }
        return m867p.getStatus();
    }

    /* renamed from: a */
    private void m886a(IoFilter.InterfaceC3073a interfaceC3073a, SSLEngineResult sSLEngineResult) throws SSLException {
        if (sSLEngineResult.getStatus() == SSLEngineResult.Status.CLOSED || sSLEngineResult.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW || sSLEngineResult.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {
            return;
        }
        this.f11609n = false;
        this.f11607l = sSLEngineResult.getHandshakeStatus();
        m889a(interfaceC3073a);
    }

    /* renamed from: p */
    private SSLEngineResult m867p() throws SSLException {
        SSLEngineResult unwrap;
        AbstractC3054b abstractC3054b = this.f11605j;
        if (abstractC3054b == null) {
            this.f11605j = AbstractC3054b.m1362h(this.f11603h.mo1357l());
        } else {
            abstractC3054b.mo1371c(this.f11603h.mo1357l());
        }
        while (true) {
            unwrap = this.f11602g.unwrap(this.f11603h.mo1344t(), this.f11605j.mo1344t());
            SSLEngineResult.Status status = unwrap.getStatus();
            SSLEngineResult.HandshakeStatus handshakeStatus = unwrap.getHandshakeStatus();
            if (status == SSLEngineResult.Status.BUFFER_OVERFLOW) {
                int applicationBufferSize = this.f11602g.getSession().getApplicationBufferSize();
                if (this.f11605j.mo1357l() >= applicationBufferSize) {
                    throw new SSLException("SSL buffer overflow");
                }
                this.f11605j.mo1371c(applicationBufferSize);
            }
            if ((status == SSLEngineResult.Status.OK || status == SSLEngineResult.Status.BUFFER_OVERFLOW) && (handshakeStatus == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING || handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_UNWRAP)) {
            }
        }
        return unwrap;
    }

    /* renamed from: q */
    private SSLEngineResult.HandshakeStatus m866q() {
        while (true) {
            Runnable delegatedTask = this.f11602g.getDelegatedTask();
            if (delegatedTask != null) {
                delegatedTask.run();
            } else {
                return this.f11602g.getHandshakeStatus();
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SSLStatus <");
        if (this.f11609n) {
            sb.append("SSL established");
        } else {
            sb.append("Processing Handshake");
            sb.append("; ");
            sb.append("Status : ");
            sb.append(this.f11607l);
            sb.append("; ");
        }
        sb.append(", ");
        sb.append("HandshakeComplete :");
        sb.append(this.f11609n);
        sb.append(", ");
        sb.append(">");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public void m868o() {
        AbstractC3054b abstractC3054b = this.f11603h;
        if (abstractC3054b != null) {
            abstractC3054b.mo1345s();
            this.f11603h = null;
        }
        AbstractC3054b abstractC3054b2 = this.f11604i;
        if (abstractC3054b2 != null) {
            abstractC3054b2.mo1345s();
            this.f11604i = null;
        }
    }
}
