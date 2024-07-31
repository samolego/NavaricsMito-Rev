package org.apache.mina.core.p133e;

import java.util.EventListener;
import org.apache.mina.core.session.IoSession;

/* renamed from: org.apache.mina.core.e.j */
/* loaded from: classes2.dex */
public interface IoServiceListener extends EventListener {
    /* renamed from: a */
    void mo1190a(IoService ioService) throws Exception;

    /* renamed from: a */
    void mo1189a(IoSession ioSession) throws Exception;

    /* renamed from: b */
    void mo1188b(IoService ioService) throws Exception;

    /* renamed from: b */
    void mo1187b(IoSession ioSession) throws Exception;
}
