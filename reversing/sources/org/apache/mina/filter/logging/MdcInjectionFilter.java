package org.apache.mina.filter.logging;

import java.net.InetSocketAddress;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.mina.core.filterchain.IoFilterEvent;
import org.apache.mina.core.session.AttributeKey;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.p138d.CommonEventFilter;
import org.slf4j.C3155d;

/* loaded from: classes2.dex */
public class MdcInjectionFilter extends CommonEventFilter {

    /* renamed from: a */
    private static final AttributeKey f11648a = new AttributeKey(MdcInjectionFilter.class, "context");

    /* renamed from: b */
    private ThreadLocal<Integer> f11649b = new ThreadLocal<Integer>() { // from class: org.apache.mina.filter.logging.MdcInjectionFilter.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public Integer initialValue() {
            return 0;
        }
    };

    /* renamed from: c */
    private EnumSet<MdcKey> f11650c = EnumSet.allOf(MdcKey.class);

    /* loaded from: classes2.dex */
    public enum MdcKey {
        handlerClass,
        remoteAddress,
        localAddress,
        remoteIp,
        remotePort,
        localIp,
        localPort
    }

    @Override // org.apache.mina.filter.p138d.CommonEventFilter
    /* renamed from: a */
    protected void mo825a(IoFilterEvent ioFilterEvent) throws Exception {
        int intValue = this.f11649b.get().intValue();
        this.f11649b.set(Integer.valueOf(intValue + 1));
        Map<String, String> m824a = m824a(ioFilterEvent.m1021d());
        if (intValue == 0) {
            for (Map.Entry<String, String> entry : m824a.entrySet()) {
                C3155d.m242a(entry.getKey(), entry.getValue());
            }
        }
        try {
            ioFilterEvent.mo1023b();
            if (intValue == 0) {
                for (String str : m824a.keySet()) {
                    C3155d.m243a(str);
                }
                this.f11649b.remove();
                return;
            }
            this.f11649b.set(Integer.valueOf(intValue));
        } catch (Throwable th) {
            if (intValue == 0) {
                for (String str2 : m824a.keySet()) {
                    C3155d.m243a(str2);
                }
                this.f11649b.remove();
            } else {
                this.f11649b.set(Integer.valueOf(intValue));
            }
            throw th;
        }
    }

    /* renamed from: a */
    private Map<String, String> m824a(IoSession ioSession) {
        Map<String, String> m820b = m820b(ioSession);
        if (m820b.isEmpty()) {
            m821a(ioSession, m820b);
        }
        return m820b;
    }

    /* renamed from: b */
    private static Map<String, String> m820b(IoSession ioSession) {
        Map<String, String> map = (Map) ioSession.mo1009b(f11648a);
        if (map == null) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            ioSession.mo1008b(f11648a, concurrentHashMap);
            return concurrentHashMap;
        }
        return map;
    }

    /* renamed from: a */
    protected void m821a(IoSession ioSession, Map<String, String> map) {
        if (this.f11650c.contains(MdcKey.handlerClass)) {
            map.put(MdcKey.handlerClass.name(), ioSession.mo1000f().getClass().getName());
        }
        if (this.f11650c.contains(MdcKey.remoteAddress)) {
            map.put(MdcKey.remoteAddress.name(), ioSession.mo994l().toString());
        }
        if (this.f11650c.contains(MdcKey.localAddress)) {
            map.put(MdcKey.localAddress.name(), ioSession.mo995k().toString());
        }
        if (ioSession.mo992n().mo1157a() == InetSocketAddress.class) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) ioSession.mo994l();
            InetSocketAddress inetSocketAddress2 = (InetSocketAddress) ioSession.mo995k();
            if (this.f11650c.contains(MdcKey.remoteIp)) {
                map.put(MdcKey.remoteIp.name(), inetSocketAddress.getAddress().getHostAddress());
            }
            if (this.f11650c.contains(MdcKey.remotePort)) {
                map.put(MdcKey.remotePort.name(), String.valueOf(inetSocketAddress.getPort()));
            }
            if (this.f11650c.contains(MdcKey.localIp)) {
                map.put(MdcKey.localIp.name(), inetSocketAddress2.getAddress().getHostAddress());
            }
            if (this.f11650c.contains(MdcKey.localPort)) {
                map.put(MdcKey.localPort.name(), String.valueOf(inetSocketAddress2.getPort()));
            }
        }
    }

    /* renamed from: a */
    public static void m822a(IoSession ioSession, String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("key should not be null");
        }
        if (str2 == null) {
            m823a(ioSession, str);
        }
        m820b(ioSession).put(str, str2);
        C3155d.m242a(str, str2);
    }

    /* renamed from: a */
    public static void m823a(IoSession ioSession, String str) {
        if (str == null) {
            throw new IllegalArgumentException("key should not be null");
        }
        m820b(ioSession).remove(str);
        C3155d.m243a(str);
    }
}
