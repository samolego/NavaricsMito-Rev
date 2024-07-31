package org.apache.mina.core.write;

import java.net.SocketAddress;
import org.apache.mina.core.p131c.IoFutureListener;
import org.apache.mina.core.p131c.WriteFuture;
import org.apache.mina.core.session.IoSession;

/* renamed from: org.apache.mina.core.write.a */
/* loaded from: classes2.dex */
public class DefaultWriteRequest implements InterfaceC3088b {

    /* renamed from: a */
    public static final byte[] f11543a = new byte[0];

    /* renamed from: b */
    private static final WriteFuture f11544b = new WriteFuture() { // from class: org.apache.mina.core.write.a.1
        @Override // org.apache.mina.core.p131c.WriteFuture
        /* renamed from: a */
        public void mo964a() {
        }

        @Override // org.apache.mina.core.p131c.WriteFuture
        /* renamed from: a */
        public void mo962a(Throwable th) {
        }

        @Override // org.apache.mina.core.p131c.IoFuture
        /* renamed from: a */
        public boolean mo963a(long j) {
            return true;
        }

        @Override // org.apache.mina.core.p131c.IoFuture
        /* renamed from: e */
        public IoSession mo960e() {
            return null;
        }

        @Override // org.apache.mina.core.p131c.WriteFuture
        /* renamed from: a */
        public WriteFuture mo961a(IoFutureListener<?> ioFutureListener) {
            throw new IllegalStateException("You can't add a listener to a dummy future.");
        }
    };

    /* renamed from: c */
    private final Object f11545c;

    /* renamed from: d */
    private final WriteFuture f11546d;

    /* renamed from: e */
    private final SocketAddress f11547e;

    @Override // org.apache.mina.core.write.InterfaceC3088b
    /* renamed from: c */
    public InterfaceC3088b mo954c() {
        return this;
    }

    @Override // org.apache.mina.core.write.InterfaceC3088b
    /* renamed from: e */
    public boolean mo837e() {
        return false;
    }

    public DefaultWriteRequest(Object obj) {
        this(obj, null, null);
    }

    public DefaultWriteRequest(Object obj, WriteFuture writeFuture) {
        this(obj, writeFuture, null);
    }

    public DefaultWriteRequest(Object obj, WriteFuture writeFuture, SocketAddress socketAddress) {
        if (obj == null) {
            throw new IllegalArgumentException("message");
        }
        writeFuture = writeFuture == null ? f11544b : writeFuture;
        this.f11545c = obj;
        this.f11546d = writeFuture;
        this.f11547e = socketAddress;
    }

    @Override // org.apache.mina.core.write.InterfaceC3088b
    /* renamed from: a */
    public WriteFuture mo955a() {
        return this.f11546d;
    }

    @Override // org.apache.mina.core.write.InterfaceC3088b
    /* renamed from: b */
    public Object mo836b() {
        return this.f11545c;
    }

    @Override // org.apache.mina.core.write.InterfaceC3088b
    /* renamed from: d */
    public SocketAddress mo953d() {
        return this.f11547e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WriteRequest: ");
        if (this.f11545c.getClass().getName().equals(Object.class.getName())) {
            sb.append("CLOSE_REQUEST");
        } else if (mo953d() == null) {
            sb.append(this.f11545c);
        } else {
            sb.append(this.f11545c);
            sb.append(" => ");
            sb.append(mo953d());
        }
        return sb.toString();
    }
}
