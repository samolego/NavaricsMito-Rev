package org.apache.mina.filter.p136c;

import com.senseplay.sdk.tool.IniEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSession;
import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.filterchain.IoFilterChain;
import org.apache.mina.core.p129a.AbstractC3054b;
import org.apache.mina.core.p131c.DefaultWriteFuture;
import org.apache.mina.core.p131c.IoFuture;
import org.apache.mina.core.p131c.IoFutureListener;
import org.apache.mina.core.p131c.WriteFuture;
import org.apache.mina.core.p133e.IoAcceptor;
import org.apache.mina.core.session.AttributeKey;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.write.InterfaceC3088b;
import org.apache.mina.core.write.WriteRequestWrapper;
import org.apache.mina.core.write.WriteToClosedSessionException;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.mina.filter.c.a */
/* loaded from: classes2.dex */
public class SslFilter extends IoFilterAdapter {

    /* renamed from: g */
    final SSLContext f11584g;

    /* renamed from: k */
    private final boolean f11585k;

    /* renamed from: l */
    private boolean f11586l;

    /* renamed from: m */
    private boolean f11587m;

    /* renamed from: n */
    private boolean f11588n;

    /* renamed from: o */
    private String[] f11589o;

    /* renamed from: p */
    private String[] f11590p;

    /* renamed from: h */
    private static final InterfaceC3153b f11581h = C3154c.m262a(SslFilter.class);

    /* renamed from: a */
    public static final AttributeKey f11575a = new AttributeKey(SslFilter.class, "session");

    /* renamed from: b */
    public static final AttributeKey f11576b = new AttributeKey(SslFilter.class, "disableOnce");

    /* renamed from: c */
    public static final AttributeKey f11577c = new AttributeKey(SslFilter.class, "useNotification");

    /* renamed from: d */
    public static final AttributeKey f11578d = new AttributeKey(SslFilter.class, "peerAddress");

    /* renamed from: e */
    public static final C3095b f11579e = new C3095b("SESSION_SECURED");

    /* renamed from: f */
    public static final C3095b f11580f = new C3095b("SESSION_UNSECURED");

    /* renamed from: i */
    private static final AttributeKey f11582i = new AttributeKey(SslFilter.class, "nextFilter");

    /* renamed from: j */
    private static final AttributeKey f11583j = new AttributeKey(SslFilter.class, "handler");

    public SslFilter(SSLContext sSLContext) {
        this(sSLContext, true);
    }

    public SslFilter(SSLContext sSLContext, boolean z) {
        if (sSLContext == null) {
            throw new IllegalArgumentException("sslContext");
        }
        this.f11584g = sSLContext;
        this.f11585k = z;
    }

    /* renamed from: a */
    public SSLSession m911a(IoSession ioSession) {
        return (SSLSession) ioSession.mo1009b(f11575a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public String m905b(IoSession ioSession) {
        StringBuilder sb = new StringBuilder();
        if (ioSession.mo993m() instanceof IoAcceptor) {
            sb.append("Session Server");
        } else {
            sb.append("Session Client");
        }
        sb.append(IniEditor.Section.HEADER_START);
        sb.append(ioSession.mo999g());
        sb.append(IniEditor.Section.HEADER_END);
        SslHandler sslHandler = (SslHandler) ioSession.mo1009b(f11583j);
        if (sslHandler == null) {
            sb.append("(no sslEngine)");
        } else if (m901c(ioSession)) {
            if (sslHandler.m877f()) {
                sb.append("(SSL)");
            } else {
                sb.append("(ssl...)");
            }
        }
        return sb.toString();
    }

    /* renamed from: c */
    public boolean m901c(IoSession ioSession) {
        boolean z;
        SslHandler sslHandler = (SslHandler) ioSession.mo1009b(f11583j);
        if (sslHandler == null) {
            return false;
        }
        synchronized (sslHandler) {
            z = sslHandler.m875h() ? false : true;
        }
        return z;
    }

    /* renamed from: d */
    public WriteFuture m899d(IoSession ioSession) throws SSLException {
        WriteFuture m895g;
        SslHandler m897e = m897e(ioSession);
        IoFilter.InterfaceC3073a interfaceC3073a = (IoFilter.InterfaceC3073a) ioSession.mo1009b(f11582i);
        try {
            synchronized (m897e) {
                m895g = m895g(interfaceC3073a, ioSession);
            }
            m897e.m872k();
            return m895g;
        } catch (SSLException e) {
            m897e.m868o();
            throw e;
        }
    }

    /* renamed from: a */
    public boolean m914a() {
        return this.f11586l;
    }

    /* renamed from: b */
    public boolean m908b() {
        return this.f11587m;
    }

    /* renamed from: a */
    public void m910a(boolean z) {
        this.f11587m = z;
    }

    /* renamed from: c */
    public boolean m903c() {
        return this.f11588n;
    }

    /* renamed from: b */
    public void m904b(boolean z) {
        this.f11588n = z;
    }

    /* renamed from: d */
    public String[] m900d() {
        return this.f11589o;
    }

    /* renamed from: a */
    public void m909a(String[] strArr) {
        this.f11589o = strArr;
    }

    /* renamed from: e */
    public String[] m898e() {
        return this.f11590p;
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: a */
    public void mo845a(IoFilterChain ioFilterChain, String str, IoFilter.InterfaceC3073a interfaceC3073a) throws SSLException {
        if (ioFilterChain.mo1092c(SslFilter.class)) {
            f11581h.error("Only one SSL filter is permitted in a chain.");
            throw new IllegalStateException("Only one SSL filter is permitted in a chain.");
        }
        f11581h.debug("Adding the SSL Filter {} to the chain", str);
        IoSession mo1104a = ioFilterChain.mo1104a();
        mo1104a.mo1008b(f11582i, interfaceC3073a);
        SslHandler sslHandler = new SslHandler(this, mo1104a);
        String[] strArr = this.f11589o;
        if (strArr == null || strArr.length == 0) {
            this.f11589o = this.f11584g.getServerSocketFactory().getSupportedCipherSuites();
        }
        sslHandler.m893a();
        mo1104a.mo1008b(f11583j, sslHandler);
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: b */
    public void mo906b(IoFilterChain ioFilterChain, String str, IoFilter.InterfaceC3073a interfaceC3073a) throws SSLException {
        if (this.f11585k) {
            m896f(interfaceC3073a, ioFilterChain.mo1104a());
        }
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: c */
    public void mo902c(IoFilterChain ioFilterChain, String str, IoFilter.InterfaceC3073a interfaceC3073a) throws SSLException {
        IoSession mo1104a = ioFilterChain.mo1104a();
        m899d(mo1104a);
        mo1104a.mo1006c(f11582i);
        mo1104a.mo1006c(f11583j);
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: d */
    public void mo809d(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession) throws SSLException {
        SslHandler m897e = m897e(ioSession);
        try {
            synchronized (m897e) {
                m897e.m884b();
            }
        } finally {
            interfaceC3073a.mo1108c(ioSession);
        }
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: a */
    public void mo817a(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession, Object obj) throws SSLException {
        if (f11581h.isDebugEnabled()) {
            f11581h.debug("{}: Message received : {}", m905b(ioSession), obj);
        }
        SslHandler m897e = m897e(ioSession);
        synchronized (m897e) {
            if (!m901c(ioSession) && m897e.m876g()) {
                m897e.m888a(interfaceC3073a, obj);
            } else {
                AbstractC3054b abstractC3054b = (AbstractC3054b) obj;
                try {
                    m897e.m887a(interfaceC3073a, abstractC3054b.mo1344t());
                    m912a(interfaceC3073a, m897e);
                    if (m897e.m876g()) {
                        if (m897e.m875h()) {
                            m897e.m884b();
                        } else {
                            m895g(interfaceC3073a, ioSession);
                        }
                        if (abstractC3054b.mo1356m()) {
                            m897e.m888a(interfaceC3073a, abstractC3054b);
                        }
                    }
                } catch (SSLException e) {
                    if (!m897e.m877f()) {
                        SSLHandshakeException sSLHandshakeException = new SSLHandshakeException("SSL handshake failed.");
                        sSLHandshakeException.initCause(e);
                        ioSession.mo1016a();
                        throw sSLHandshakeException;
                    }
                    m897e.m868o();
                    throw e;
                }
            }
        }
        m897e.m872k();
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: b */
    public void mo811b(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession, InterfaceC3088b interfaceC3088b) {
        if (interfaceC3088b instanceof C3094a) {
            interfaceC3073a.mo1111a(ioSession, ((C3094a) interfaceC3088b).m952f());
        }
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: a */
    public void mo816a(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession, Throwable th) throws Exception {
        if (th instanceof WriteToClosedSessionException) {
            List<InterfaceC3088b> requests = ((WriteToClosedSessionException) th).getRequests();
            boolean z = false;
            Iterator<InterfaceC3088b> it = requests.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (m913a(it.next().mo836b())) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (z) {
                if (requests.size() == 1) {
                    return;
                }
                ArrayList arrayList = new ArrayList(requests.size() - 1);
                for (InterfaceC3088b interfaceC3088b : requests) {
                    if (!m913a(interfaceC3088b.mo836b())) {
                        arrayList.add(interfaceC3088b);
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                th = new WriteToClosedSessionException(arrayList, th.getMessage(), th.getCause());
            }
        }
        interfaceC3073a.mo1113a(ioSession, th);
    }

    /* renamed from: a */
    private boolean m913a(Object obj) {
        if (obj instanceof AbstractC3054b) {
            AbstractC3054b abstractC3054b = (AbstractC3054b) obj;
            int mo1366f = abstractC3054b.mo1366f();
            if (abstractC3054b.mo1365f(mo1366f + 0) == 21 && abstractC3054b.mo1365f(mo1366f + 1) == 3) {
                int i = mo1366f + 2;
                return (abstractC3054b.mo1365f(i) == 0 || abstractC3054b.mo1365f(i) == 1 || abstractC3054b.mo1365f(i) == 2 || abstractC3054b.mo1365f(i) == 3) && abstractC3054b.mo1365f(mo1366f + 3) == 0;
            }
            return false;
        }
        return false;
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: a */
    public void mo827a(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession, InterfaceC3088b interfaceC3088b) throws SSLException {
        if (f11581h.isDebugEnabled()) {
            f11581h.debug("{}: Writing Message : {}", m905b(ioSession), interfaceC3088b);
        }
        boolean z = true;
        SslHandler m897e = m897e(ioSession);
        try {
            synchronized (m897e) {
                if (!m901c(ioSession)) {
                    m897e.m882b(interfaceC3073a, interfaceC3088b);
                } else if (ioSession.mo1015a(f11576b)) {
                    ioSession.mo1006c(f11576b);
                    m897e.m882b(interfaceC3073a, interfaceC3088b);
                } else {
                    AbstractC3054b abstractC3054b = (AbstractC3054b) interfaceC3088b.mo836b();
                    if (m897e.m878e()) {
                        m897e.m882b(interfaceC3073a, interfaceC3088b);
                    } else if (m897e.m877f()) {
                        abstractC3054b.mo1363h();
                        m897e.m891a(abstractC3054b.mo1344t());
                        m897e.m882b(interfaceC3073a, new C3094a(interfaceC3088b, m897e.m870m()));
                    } else {
                        if (ioSession.mo990p()) {
                            m897e.m885a(interfaceC3073a, interfaceC3088b);
                        }
                        z = false;
                    }
                }
            }
            if (z) {
                m897e.m872k();
            }
        } catch (SSLException e) {
            m897e.m868o();
            throw e;
        }
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: b */
    public void mo826b(final IoFilter.InterfaceC3073a interfaceC3073a, final IoSession ioSession) throws SSLException {
        SslHandler sslHandler = (SslHandler) ioSession.mo1009b(f11583j);
        if (sslHandler == null) {
            interfaceC3073a.mo1106e(ioSession);
            return;
        }
        WriteFuture writeFuture = null;
        try {
            try {
                synchronized (sslHandler) {
                    if (m901c(ioSession)) {
                        writeFuture = m895g(interfaceC3073a, ioSession);
                        writeFuture.mo961a(new IoFutureListener<IoFuture>() { // from class: org.apache.mina.filter.c.a.1
                            @Override // org.apache.mina.core.p131c.IoFutureListener
                            /* renamed from: a */
                            public void mo894a(IoFuture ioFuture) {
                                interfaceC3073a.mo1106e(ioSession);
                            }
                        });
                    }
                }
                sslHandler.m872k();
            } catch (SSLException e) {
                sslHandler.m868o();
                throw e;
            }
        } finally {
            if (0 == 0) {
                interfaceC3073a.mo1106e(ioSession);
            }
        }
    }

    /* renamed from: f */
    private void m896f(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession) throws SSLException {
        f11581h.debug("{} : Starting the first handshake", m905b(ioSession));
        SslHandler m897e = m897e(ioSession);
        try {
            synchronized (m897e) {
                m897e.m889a(interfaceC3073a);
            }
            m897e.m872k();
        } catch (SSLException e) {
            m897e.m868o();
            throw e;
        }
    }

    /* renamed from: g */
    private WriteFuture m895g(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession) throws SSLException {
        SslHandler m897e = m897e(ioSession);
        try {
            if (!m897e.m869n()) {
                return DefaultWriteFuture.m1321a(ioSession, new IllegalStateException("SSL session is shut down already."));
            }
            WriteFuture m883b = m897e.m883b(interfaceC3073a);
            if (m883b == null) {
                m883b = DefaultWriteFuture.m1322a(ioSession);
            }
            if (m897e.m876g()) {
                m897e.m884b();
            }
            if (ioSession.mo1015a(f11577c)) {
                m897e.m888a(interfaceC3073a, f11580f);
            }
            return m883b;
        } catch (SSLException e) {
            m897e.m868o();
            throw e;
        }
    }

    /* renamed from: a */
    private void m912a(IoFilter.InterfaceC3073a interfaceC3073a, SslHandler sslHandler) throws SSLException {
        if (f11581h.isDebugEnabled()) {
            f11581h.debug("{}: Processing the SSL Data ", m905b(sslHandler.m879d()));
        }
        if (sslHandler.m877f()) {
            sslHandler.m873j();
        }
        sslHandler.m883b(interfaceC3073a);
        m907b(interfaceC3073a, sslHandler);
    }

    /* renamed from: b */
    private void m907b(IoFilter.InterfaceC3073a interfaceC3073a, SslHandler sslHandler) {
        AbstractC3054b m871l = sslHandler.m871l();
        if (m871l.mo1356m()) {
            sslHandler.m888a(interfaceC3073a, m871l);
        }
    }

    /* renamed from: e */
    private SslHandler m897e(IoSession ioSession) {
        SslHandler sslHandler = (SslHandler) ioSession.mo1009b(f11583j);
        if (sslHandler == null) {
            throw new IllegalStateException();
        }
        if (sslHandler.m881c() == this) {
            return sslHandler;
        }
        throw new IllegalArgumentException("Not managed by this filter.");
    }

    /* compiled from: SslFilter.java */
    /* renamed from: org.apache.mina.filter.c.a$b */
    /* loaded from: classes2.dex */
    public static class C3095b {

        /* renamed from: a */
        private final String f11595a;

        private C3095b(String str) {
            this.f11595a = str;
        }

        public String toString() {
            return this.f11595a;
        }
    }

    /* compiled from: SslFilter.java */
    /* renamed from: org.apache.mina.filter.c.a$a */
    /* loaded from: classes2.dex */
    private static class C3094a extends WriteRequestWrapper {

        /* renamed from: a */
        private final AbstractC3054b f11594a;

        private C3094a(InterfaceC3088b interfaceC3088b, AbstractC3054b abstractC3054b) {
            super(interfaceC3088b);
            this.f11594a = abstractC3054b;
        }

        @Override // org.apache.mina.core.write.WriteRequestWrapper, org.apache.mina.core.write.InterfaceC3088b
        /* renamed from: b */
        public Object mo836b() {
            return this.f11594a;
        }
    }
}
