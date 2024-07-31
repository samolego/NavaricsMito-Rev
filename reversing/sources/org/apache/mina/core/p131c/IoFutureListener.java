package org.apache.mina.core.p131c;

import java.util.EventListener;
import org.apache.mina.core.p131c.IoFuture;

/* renamed from: org.apache.mina.core.c.h */
/* loaded from: classes2.dex */
public interface IoFutureListener<F extends IoFuture> extends EventListener {

    /* renamed from: a */
    public static final IoFutureListener<IoFuture> f11339a = new IoFutureListener<IoFuture>() { // from class: org.apache.mina.core.c.h.1
        @Override // org.apache.mina.core.p131c.IoFutureListener
        /* renamed from: a */
        public void mo894a(IoFuture ioFuture) {
            ioFuture.mo960e().mo1016a();
        }
    };

    /* renamed from: a */
    void mo894a(F f);
}
