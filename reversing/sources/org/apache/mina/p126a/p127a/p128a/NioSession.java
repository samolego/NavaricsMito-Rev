package org.apache.mina.p126a.p127a.p128a;

import java.nio.channels.ByteChannel;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import org.apache.mina.core.filterchain.DefaultIoFilterChain;
import org.apache.mina.core.filterchain.IoFilterChain;
import org.apache.mina.core.p133e.IoProcessor;
import org.apache.mina.core.p133e.IoService;
import org.apache.mina.core.session.AbstractIoSession;

/* renamed from: org.apache.mina.a.a.a.b */
/* loaded from: classes2.dex */
public abstract class NioSession extends AbstractIoSession {

    /* renamed from: d */
    protected final IoProcessor<NioSession> f11295d;

    /* renamed from: e */
    protected final Channel f11296e;

    /* renamed from: f */
    private SelectionKey f11297f;

    /* renamed from: g */
    private final IoFilterChain f11298g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: C */
    public abstract ByteChannel mo1440C();

    /* JADX INFO: Access modifiers changed from: protected */
    public NioSession(IoProcessor<NioSession> ioProcessor, IoService ioService, Channel channel) {
        super(ioService);
        this.f11296e = channel;
        this.f11295d = ioProcessor;
        this.f11298g = new DefaultIoFilterChain(this);
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: e */
    public IoFilterChain mo1002e() {
        return this.f11298g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: D */
    public SelectionKey m1447D() {
        return this.f11297f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m1446a(SelectionKey selectionKey) {
        this.f11297f = selectionKey;
    }

    @Override // org.apache.mina.core.session.AbstractIoSession
    /* renamed from: r */
    public IoProcessor<NioSession> mo1035r() {
        return this.f11295d;
    }

    @Override // org.apache.mina.core.session.AbstractIoSession, org.apache.mina.core.session.IoSession
    /* renamed from: q */
    public final boolean mo989q() {
        return this.f11297f.isValid();
    }
}
