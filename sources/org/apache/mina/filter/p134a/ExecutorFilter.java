package org.apache.mina.filter.p134a;

import java.util.EnumSet;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.filterchain.IoFilterChain;
import org.apache.mina.core.filterchain.IoFilterEvent;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoEventType;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.write.InterfaceC3088b;

/* renamed from: org.apache.mina.filter.a.a */
/* loaded from: classes2.dex */
public class ExecutorFilter extends IoFilterAdapter {

    /* renamed from: d */
    private static final IoEventType[] f11549d = {IoEventType.EXCEPTION_CAUGHT, IoEventType.MESSAGE_RECEIVED, IoEventType.MESSAGE_SENT, IoEventType.SESSION_CLOSED, IoEventType.SESSION_IDLE, IoEventType.SESSION_OPENED};

    /* renamed from: a */
    private EnumSet<IoEventType> f11550a;

    /* renamed from: b */
    private Executor f11551b;

    /* renamed from: c */
    private boolean f11552c;

    public ExecutorFilter() {
        m950a(m951a(0, 16, 30L, TimeUnit.SECONDS, Executors.defaultThreadFactory(), null), true, new IoEventType[0]);
    }

    public ExecutorFilter(Executor executor) {
        m950a(executor, false, new IoEventType[0]);
    }

    /* renamed from: a */
    private Executor m951a(int i, int i2, long j, TimeUnit timeUnit, ThreadFactory threadFactory, IoEventQueueHandler ioEventQueueHandler) {
        return new OrderedThreadPoolExecutor(i, i2, j, timeUnit, threadFactory, ioEventQueueHandler);
    }

    /* renamed from: a */
    private void m948a(IoEventType... ioEventTypeArr) {
        if (ioEventTypeArr == null || ioEventTypeArr.length == 0) {
            ioEventTypeArr = f11549d;
        }
        this.f11550a = EnumSet.of(ioEventTypeArr[0], ioEventTypeArr);
        if (this.f11550a.contains(IoEventType.SESSION_CREATED)) {
            this.f11550a = null;
            throw new IllegalArgumentException(IoEventType.SESSION_CREATED + " is not allowed.");
        }
    }

    /* renamed from: a */
    private void m950a(Executor executor, boolean z, IoEventType... ioEventTypeArr) {
        if (executor == null) {
            throw new IllegalArgumentException("executor");
        }
        m948a(ioEventTypeArr);
        this.f11551b = executor;
        this.f11552c = z;
    }

    /* renamed from: a */
    protected void m949a(IoFilterEvent ioFilterEvent) {
        this.f11551b.execute(ioFilterEvent);
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: a */
    public void mo845a(IoFilterChain ioFilterChain, String str, IoFilter.InterfaceC3073a interfaceC3073a) throws Exception {
        if (ioFilterChain.mo1095b(this)) {
            throw new IllegalArgumentException("You can't add the same filter instance more than once.  Create another instance and add it.");
        }
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: c */
    public final void mo810c(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession) {
        if (this.f11550a.contains(IoEventType.SESSION_OPENED)) {
            m949a(new IoFilterEvent(interfaceC3073a, IoEventType.SESSION_OPENED, ioSession, null));
        } else {
            interfaceC3073a.mo1110b(ioSession);
        }
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: d */
    public final void mo809d(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession) {
        if (this.f11550a.contains(IoEventType.SESSION_CLOSED)) {
            m949a(new IoFilterEvent(interfaceC3073a, IoEventType.SESSION_CLOSED, ioSession, null));
        } else {
            interfaceC3073a.mo1108c(ioSession);
        }
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: a */
    public final void mo815a(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession, IdleStatus idleStatus) {
        if (this.f11550a.contains(IoEventType.SESSION_IDLE)) {
            m949a(new IoFilterEvent(interfaceC3073a, IoEventType.SESSION_IDLE, ioSession, idleStatus));
        } else {
            interfaceC3073a.mo1112a(ioSession, idleStatus);
        }
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: a */
    public final void mo816a(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession, Throwable th) {
        if (this.f11550a.contains(IoEventType.EXCEPTION_CAUGHT)) {
            m949a(new IoFilterEvent(interfaceC3073a, IoEventType.EXCEPTION_CAUGHT, ioSession, th));
        } else {
            interfaceC3073a.mo1113a(ioSession, th);
        }
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: a */
    public final void mo817a(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession, Object obj) {
        if (this.f11550a.contains(IoEventType.MESSAGE_RECEIVED)) {
            m949a(new IoFilterEvent(interfaceC3073a, IoEventType.MESSAGE_RECEIVED, ioSession, obj));
        } else {
            interfaceC3073a.mo1114a(ioSession, obj);
        }
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: b */
    public final void mo811b(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession, InterfaceC3088b interfaceC3088b) {
        if (this.f11550a.contains(IoEventType.MESSAGE_SENT)) {
            m949a(new IoFilterEvent(interfaceC3073a, IoEventType.MESSAGE_SENT, ioSession, interfaceC3088b));
        } else {
            interfaceC3073a.mo1111a(ioSession, interfaceC3088b);
        }
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: a */
    public final void mo827a(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession, InterfaceC3088b interfaceC3088b) {
        if (this.f11550a.contains(IoEventType.WRITE)) {
            m949a(new IoFilterEvent(interfaceC3073a, IoEventType.WRITE, ioSession, interfaceC3088b));
        } else {
            interfaceC3073a.mo1109b(ioSession, interfaceC3088b);
        }
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: b */
    public final void mo826b(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession) throws Exception {
        if (this.f11550a.contains(IoEventType.CLOSE)) {
            m949a(new IoFilterEvent(interfaceC3073a, IoEventType.CLOSE, ioSession, null));
        } else {
            interfaceC3073a.mo1106e(ioSession);
        }
    }
}
