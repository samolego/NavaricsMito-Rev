package org.apache.mina.core.session;

import org.apache.mina.core.write.InterfaceC3088b;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: org.apache.mina.core.session.f */
/* loaded from: classes2.dex */
public class IoEvent implements Runnable {

    /* renamed from: a */
    private final IoEventType f11539a;

    /* renamed from: b */
    private final IoSession f11540b;

    /* renamed from: c */
    private final Object f11541c;

    public IoEvent(IoEventType ioEventType, IoSession ioSession, Object obj) {
        if (ioEventType == null) {
            throw new IllegalArgumentException(IjkMediaMeta.IJKM_KEY_TYPE);
        }
        if (ioSession == null) {
            throw new IllegalArgumentException("session");
        }
        this.f11539a = ioEventType;
        this.f11540b = ioSession;
        this.f11541c = obj;
    }

    /* renamed from: c */
    public IoEventType m1022c() {
        return this.f11539a;
    }

    /* renamed from: d */
    public IoSession m1021d() {
        return this.f11540b;
    }

    /* renamed from: e */
    public Object m1020e() {
        return this.f11541c;
    }

    @Override // java.lang.Runnable
    public void run() {
        mo1023b();
    }

    /* renamed from: b */
    public void mo1023b() {
        switch (m1022c()) {
            case MESSAGE_RECEIVED:
                m1021d().mo1002e().mo1103a(m1020e());
                return;
            case MESSAGE_SENT:
                m1021d().mo1002e().mo1099a((InterfaceC3088b) m1020e());
                return;
            case WRITE:
                m1021d().mo1002e().mo1094b((InterfaceC3088b) m1020e());
                return;
            case CLOSE:
                m1021d().mo1002e().mo1088g();
                return;
            case EXCEPTION_CAUGHT:
                m1021d().mo1002e().mo1101a((Throwable) m1020e());
                return;
            case SESSION_IDLE:
                m1021d().mo1002e().mo1100a((IdleStatus) m1020e());
                return;
            case SESSION_OPENED:
                m1021d().mo1002e().mo1091d();
                return;
            case SESSION_CREATED:
                m1021d().mo1002e().mo1093c();
                return;
            case SESSION_CLOSED:
                m1021d().mo1002e().mo1090e();
                return;
            default:
                throw new IllegalArgumentException("Unknown event type: " + m1022c());
        }
    }

    public String toString() {
        if (m1020e() == null) {
            return "[" + m1021d() + "] " + m1022c().name();
        }
        return "[" + m1021d() + "] " + m1022c().name() + ": " + m1020e();
    }
}
