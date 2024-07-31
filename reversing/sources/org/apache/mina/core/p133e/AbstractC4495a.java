package org.apache.mina.core.p133e;

import java.io.IOException;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import org.apache.mina.core.RuntimeIoException;
import org.apache.mina.core.p133e.AbstractIoService;
import org.apache.mina.core.session.IoSessionConfig;

/* renamed from: org.apache.mina.core.e.a */
/* loaded from: classes2.dex */
public abstract class AbstractIoAcceptor extends AbstractIoService implements IoAcceptor {

    /* renamed from: a */
    private final List<SocketAddress> f11371a;

    /* renamed from: b */
    private final List<SocketAddress> f11372b;

    /* renamed from: c */
    protected final Object f11373c;

    /* renamed from: f */
    private final Set<SocketAddress> f11374f;

    /* renamed from: g */
    private boolean f11375g;

    /* renamed from: a */
    protected abstract Set<SocketAddress> mo1034a(List<? extends SocketAddress> list) throws Exception;

    /* renamed from: b */
    protected abstract void mo1033b(List<? extends SocketAddress> list) throws Exception;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractIoAcceptor(IoSessionConfig ioSessionConfig, Executor executor) {
        super(ioSessionConfig, executor);
        this.f11371a = new ArrayList();
        this.f11372b = Collections.unmodifiableList(this.f11371a);
        this.f11374f = new HashSet();
        this.f11375g = true;
        this.f11373c = new Object();
        this.f11371a.add(null);
    }

    /* renamed from: j */
    public SocketAddress mo1226j() {
        Set<SocketAddress> m1225k = m1225k();
        if (m1225k.isEmpty()) {
            return null;
        }
        return m1225k.iterator().next();
    }

    /* renamed from: k */
    public final Set<SocketAddress> m1225k() {
        HashSet hashSet = new HashSet();
        synchronized (this.f11374f) {
            hashSet.addAll(this.f11374f);
        }
        return hashSet;
    }

    @Override // org.apache.mina.core.p133e.IoAcceptor
    /* renamed from: l */
    public final boolean mo1207l() {
        return this.f11375g;
    }

    @Override // org.apache.mina.core.p133e.IoAcceptor
    /* renamed from: b */
    public final void mo1208b(SocketAddress socketAddress) throws IOException {
        if (socketAddress == null) {
            throw new IllegalArgumentException("localAddress");
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(socketAddress);
        m1229a((Iterable<? extends SocketAddress>) arrayList);
    }

    /* renamed from: a */
    public final void m1229a(Iterable<? extends SocketAddress> iterable) throws IOException {
        boolean isEmpty;
        if (m1217q()) {
            throw new IllegalStateException("The Accpetor disposed is being disposed.");
        }
        if (iterable == null) {
            throw new IllegalArgumentException("localAddresses");
        }
        ArrayList arrayList = new ArrayList();
        for (SocketAddress socketAddress : iterable) {
            m1228a(socketAddress);
            arrayList.add(socketAddress);
        }
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("localAddresses is empty.");
        }
        synchronized (this.f11373c) {
            synchronized (this.f11374f) {
                isEmpty = this.f11374f.isEmpty();
            }
            if (mo1192u() == null) {
                throw new IllegalStateException("handler is not set.");
            }
            try {
                try {
                    try {
                        Set<SocketAddress> mo1034a = mo1034a((List<? extends SocketAddress>) arrayList);
                        synchronized (this.f11374f) {
                            this.f11374f.addAll(mo1034a);
                        }
                    } catch (Exception e) {
                        throw new RuntimeIoException("Failed to bind to: " + m1225k(), e);
                    }
                } catch (RuntimeException e2) {
                    throw e2;
                }
            } catch (IOException e3) {
                throw e3;
            }
        }
        if (isEmpty) {
            m1213y().m1179e();
        }
    }

    @Override // org.apache.mina.core.p133e.IoAcceptor
    /* renamed from: m */
    public final void mo1206m() {
        m1227b(m1225k());
    }

    /* renamed from: b */
    public final void m1227b(Iterable<? extends SocketAddress> iterable) {
        if (iterable == null) {
            throw new IllegalArgumentException("localAddresses");
        }
        synchronized (this.f11373c) {
            synchronized (this.f11374f) {
                if (this.f11374f.isEmpty()) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                int i = 0;
                for (SocketAddress socketAddress : iterable) {
                    i++;
                    if (socketAddress != null && this.f11374f.contains(socketAddress)) {
                        arrayList.add(socketAddress);
                    }
                }
                if (i == 0) {
                    throw new IllegalArgumentException("localAddresses is empty.");
                }
                if (!arrayList.isEmpty()) {
                    try {
                        try {
                            mo1033b((List<? extends SocketAddress>) arrayList);
                            this.f11374f.removeAll(arrayList);
                            if (this.f11374f.isEmpty()) {
                                z = true;
                            }
                        } catch (Exception e) {
                            throw new RuntimeIoException("Failed to unbind from: " + m1225k(), e);
                        }
                    } catch (RuntimeException e2) {
                        throw e2;
                    }
                }
                if (z) {
                    m1213y().m1178f();
                }
            }
        }
    }

    public String toString() {
        String str;
        TransportMetadata z = mo1030z();
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append(z.mo1155c());
        sb.append(' ');
        sb.append(z.mo1154d());
        sb.append(" acceptor: ");
        if (m1218p()) {
            str = "localAddress(es): " + m1225k() + ", managedSessionCount: " + m1216t();
        } else {
            str = "not bound";
        }
        sb.append(str);
        sb.append(')');
        return sb.toString();
    }

    /* renamed from: a */
    private void m1228a(SocketAddress socketAddress) {
        if (socketAddress == null || mo1030z().mo1157a().isAssignableFrom(socketAddress.getClass())) {
            return;
        }
        throw new IllegalArgumentException("localAddress type: " + socketAddress.getClass().getSimpleName() + " (expected: " + mo1030z().mo1157a().getSimpleName() + ")");
    }

    /* compiled from: AbstractIoAcceptor.java */
    /* renamed from: org.apache.mina.core.e.a$a */
    /* loaded from: classes2.dex */
    public static class C3061a extends AbstractIoService.C3063a {

        /* renamed from: a */
        private final List<SocketAddress> f11376a;

        public C3061a(List<? extends SocketAddress> list) {
            this.f11376a = new ArrayList(list);
        }

        /* renamed from: a */
        public final List<SocketAddress> m1224a() {
            return Collections.unmodifiableList(this.f11376a);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Acceptor operation : ");
            List<SocketAddress> list = this.f11376a;
            if (list != null) {
                boolean z = true;
                for (SocketAddress socketAddress : list) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(socketAddress);
                }
            }
            return sb.toString();
        }
    }
}
