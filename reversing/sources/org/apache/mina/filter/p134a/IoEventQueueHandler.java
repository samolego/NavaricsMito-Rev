package org.apache.mina.filter.p134a;

import java.util.EventListener;
import org.apache.mina.core.session.IoEvent;

/* renamed from: org.apache.mina.filter.a.b */
/* loaded from: classes2.dex */
public interface IoEventQueueHandler extends EventListener {

    /* renamed from: a */
    public static final IoEventQueueHandler f11553a = new IoEventQueueHandler() { // from class: org.apache.mina.filter.a.b.1
        @Override // org.apache.mina.filter.p134a.IoEventQueueHandler
        /* renamed from: a */
        public boolean mo947a(Object obj, IoEvent ioEvent) {
            return true;
        }

        @Override // org.apache.mina.filter.p134a.IoEventQueueHandler
        /* renamed from: b */
        public void mo946b(Object obj, IoEvent ioEvent) {
        }

        @Override // org.apache.mina.filter.p134a.IoEventQueueHandler
        /* renamed from: c */
        public void mo945c(Object obj, IoEvent ioEvent) {
        }
    };

    /* renamed from: a */
    boolean mo947a(Object obj, IoEvent ioEvent);

    /* renamed from: b */
    void mo946b(Object obj, IoEvent ioEvent);

    /* renamed from: c */
    void mo945c(Object obj, IoEvent ioEvent);
}
