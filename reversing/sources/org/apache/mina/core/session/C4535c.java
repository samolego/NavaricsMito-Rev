package org.apache.mina.core.session;

import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.apache.mina.core.write.InterfaceC3088b;
import org.apache.mina.core.write.WriteRequestQueue;

/* renamed from: org.apache.mina.core.session.c */
/* loaded from: classes2.dex */
public class DefaultIoSessionDataStructureFactory implements IoSessionDataStructureFactory {
    @Override // org.apache.mina.core.session.IoSessionDataStructureFactory
    /* renamed from: a */
    public IoSessionAttributeMap mo969a(IoSession ioSession) throws Exception {
        return new C3079a();
    }

    @Override // org.apache.mina.core.session.IoSessionDataStructureFactory
    /* renamed from: b */
    public WriteRequestQueue mo968b(IoSession ioSession) throws Exception {
        return new C3080b();
    }

    /* compiled from: DefaultIoSessionDataStructureFactory.java */
    /* renamed from: org.apache.mina.core.session.c$a */
    /* loaded from: classes2.dex */
    private static class C3079a implements IoSessionAttributeMap {

        /* renamed from: a */
        private final ConcurrentHashMap<Object, Object> f11521a = new ConcurrentHashMap<>(4);

        @Override // org.apache.mina.core.session.IoSessionAttributeMap
        /* renamed from: a */
        public void mo988a(IoSession ioSession) throws Exception {
        }

        @Override // org.apache.mina.core.session.IoSessionAttributeMap
        /* renamed from: a */
        public Object mo986a(IoSession ioSession, Object obj, Object obj2) {
            if (obj != null) {
                if (obj2 == null) {
                    return this.f11521a.get(obj);
                }
                Object putIfAbsent = this.f11521a.putIfAbsent(obj, obj2);
                return putIfAbsent == null ? obj2 : putIfAbsent;
            }
            throw new IllegalArgumentException("key");
        }

        @Override // org.apache.mina.core.session.IoSessionAttributeMap
        /* renamed from: b */
        public Object mo984b(IoSession ioSession, Object obj, Object obj2) {
            if (obj != null) {
                if (obj2 == null) {
                    return this.f11521a.remove(obj);
                }
                return this.f11521a.put(obj, obj2);
            }
            throw new IllegalArgumentException("key");
        }

        @Override // org.apache.mina.core.session.IoSessionAttributeMap
        /* renamed from: c */
        public Object mo983c(IoSession ioSession, Object obj, Object obj2) {
            if (obj != null) {
                if (obj2 == null) {
                    return null;
                }
                return this.f11521a.putIfAbsent(obj, obj2);
            }
            throw new IllegalArgumentException("key");
        }

        @Override // org.apache.mina.core.session.IoSessionAttributeMap
        /* renamed from: a */
        public Object mo987a(IoSession ioSession, Object obj) {
            if (obj == null) {
                throw new IllegalArgumentException("key");
            }
            return this.f11521a.remove(obj);
        }

        @Override // org.apache.mina.core.session.IoSessionAttributeMap
        /* renamed from: b */
        public boolean mo985b(IoSession ioSession, Object obj) {
            return this.f11521a.containsKey(obj);
        }
    }

    /* compiled from: DefaultIoSessionDataStructureFactory.java */
    /* renamed from: org.apache.mina.core.session.c$b */
    /* loaded from: classes2.dex */
    private static class C3080b implements WriteRequestQueue {

        /* renamed from: a */
        private final Queue<InterfaceC3088b> f11522a = new ConcurrentLinkedQueue();

        @Override // org.apache.mina.core.write.WriteRequestQueue
        /* renamed from: a */
        public void mo959a(IoSession ioSession) {
        }

        @Override // org.apache.mina.core.write.WriteRequestQueue
        /* renamed from: b */
        public boolean mo957b(IoSession ioSession) {
            return this.f11522a.isEmpty();
        }

        @Override // org.apache.mina.core.write.WriteRequestQueue
        /* renamed from: a */
        public void mo958a(IoSession ioSession, InterfaceC3088b interfaceC3088b) {
            this.f11522a.offer(interfaceC3088b);
        }

        @Override // org.apache.mina.core.write.WriteRequestQueue
        /* renamed from: c */
        public InterfaceC3088b mo956c(IoSession ioSession) {
            InterfaceC3088b poll = this.f11522a.poll();
            if (poll == AbstractIoSession.f11470b) {
                ioSession.mo1016a();
                mo959a(ioSession);
                return null;
            }
            return poll;
        }

        public String toString() {
            return this.f11522a.toString();
        }
    }
}
