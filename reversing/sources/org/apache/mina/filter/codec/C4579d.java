package org.apache.mina.filter.codec;

import java.net.SocketAddress;
import java.util.Queue;
import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.filterchain.IoFilterChain;
import org.apache.mina.core.p129a.AbstractC3054b;
import org.apache.mina.core.p130b.FileRegion;
import org.apache.mina.core.p131c.WriteFuture;
import org.apache.mina.core.session.AttributeKey;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.write.DefaultWriteRequest;
import org.apache.mina.core.write.InterfaceC3088b;
import org.apache.mina.core.write.WriteRequestWrapper;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.mina.filter.codec.d */
/* loaded from: classes2.dex */
public class ProtocolCodecFilter extends IoFilterAdapter {

    /* renamed from: a */
    private static final InterfaceC3153b f11636a = C3154c.m262a(ProtocolCodecFilter.class);

    /* renamed from: b */
    private static final Class<?>[] f11637b = new Class[0];

    /* renamed from: c */
    private static final AbstractC3054b f11638c = AbstractC3054b.m1372b(new byte[0]);

    /* renamed from: d */
    private static final AttributeKey f11639d = new AttributeKey(ProtocolCodecFilter.class, "encoder");

    /* renamed from: e */
    private static final AttributeKey f11640e = new AttributeKey(ProtocolCodecFilter.class, "decoder");

    /* renamed from: f */
    private static final AttributeKey f11641f = new AttributeKey(ProtocolCodecFilter.class, "decoderOut");

    /* renamed from: g */
    private static final AttributeKey f11642g = new AttributeKey(ProtocolCodecFilter.class, "encoderOut");

    /* renamed from: h */
    private final ProtocolCodecFactory f11643h;

    public ProtocolCodecFilter(ProtocolCodecFactory protocolCodecFactory) {
        if (protocolCodecFactory == null) {
            throw new IllegalArgumentException("factory");
        }
        this.f11643h = protocolCodecFactory;
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: a */
    public void mo845a(IoFilterChain ioFilterChain, String str, IoFilter.InterfaceC3073a interfaceC3073a) throws Exception {
        if (ioFilterChain.mo1095b(this)) {
            throw new IllegalArgumentException("You can't add the same filter instance more than once.  Create another instance and add it.");
        }
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: d */
    public void mo839d(IoFilterChain ioFilterChain, String str, IoFilter.InterfaceC3073a interfaceC3073a) throws Exception {
        m844a(ioFilterChain.mo1104a());
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: a */
    public void mo817a(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession, Object obj) throws Exception {
        ProtocolDecoderException protocolDecoderException;
        f11636a.debug("Processing a MESSAGE_RECEIVED for session {}", Long.valueOf(ioSession.mo999g()));
        if (!(obj instanceof AbstractC3054b)) {
            interfaceC3073a.mo1114a(ioSession, obj);
            return;
        }
        AbstractC3054b abstractC3054b = (AbstractC3054b) obj;
        ProtocolDecoder mo848a = this.f11643h.mo848a(ioSession);
        ProtocolDecoderOutput m843a = m843a(ioSession, interfaceC3073a);
        while (abstractC3054b.mo1356m()) {
            int mo1366f = abstractC3054b.mo1366f();
            try {
                synchronized (ioSession) {
                    mo848a.mo834a(ioSession, abstractC3054b, m843a);
                }
                m843a.mo831a(interfaceC3073a, ioSession);
            } catch (Exception e) {
                if (e instanceof ProtocolDecoderException) {
                    protocolDecoderException = (ProtocolDecoderException) e;
                } else {
                    protocolDecoderException = new ProtocolDecoderException(e);
                }
                if (protocolDecoderException.getHexdump() == null) {
                    int mo1366f2 = abstractC3054b.mo1366f();
                    abstractC3054b.mo1369d(mo1366f);
                    protocolDecoderException.setHexdump(abstractC3054b.mo1353q());
                    abstractC3054b.mo1369d(mo1366f2);
                }
                m843a.mo831a(interfaceC3073a, ioSession);
                interfaceC3073a.mo1113a(ioSession, (Throwable) protocolDecoderException);
                if (!(e instanceof RecoverableProtocolDecoderException) || abstractC3054b.mo1366f() == mo1366f) {
                    return;
                }
            }
        }
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: b */
    public void mo811b(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession, InterfaceC3088b interfaceC3088b) throws Exception {
        if (interfaceC3088b instanceof C3099a) {
            return;
        }
        if (interfaceC3088b instanceof C3100b) {
            interfaceC3073a.mo1111a(ioSession, ((C3100b) interfaceC3088b).m952f());
        } else {
            interfaceC3073a.mo1111a(ioSession, interfaceC3088b);
        }
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: a */
    public void mo827a(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession, InterfaceC3088b interfaceC3088b) throws Exception {
        Object poll;
        Object mo836b = interfaceC3088b.mo836b();
        if ((mo836b instanceof AbstractC3054b) || (mo836b instanceof FileRegion)) {
            interfaceC3073a.mo1109b(ioSession, interfaceC3088b);
            return;
        }
        ProtocolEncoder mo847b = this.f11643h.mo847b(ioSession);
        ProtocolEncoderOutput m842a = m842a(ioSession, interfaceC3073a, interfaceC3088b);
        if (mo847b == null) {
            throw new ProtocolEncoderException("The encoder is null for the session " + ioSession);
        }
        try {
            mo847b.mo830a(ioSession, mo836b, m842a);
            Queue<Object> m849a = ((AbstractProtocolEncoderOutput) m842a).m849a();
            while (!m849a.isEmpty() && (poll = m849a.poll()) != null) {
                if (!(poll instanceof AbstractC3054b) || ((AbstractC3054b) poll).mo1356m()) {
                    interfaceC3073a.mo1109b(ioSession, new C3099a(poll, null, interfaceC3088b.mo953d()));
                }
            }
            interfaceC3073a.mo1109b(ioSession, new C3100b(interfaceC3088b));
        } catch (Exception e) {
            if (e instanceof ProtocolEncoderException) {
                throw ((ProtocolEncoderException) e);
            }
            throw new ProtocolEncoderException(e);
        }
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: d */
    public void mo809d(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession) throws Exception {
        ProtocolDecoder mo848a = this.f11643h.mo848a(ioSession);
        ProtocolDecoderOutput m843a = m843a(ioSession, interfaceC3073a);
        try {
            try {
                mo848a.mo833a(ioSession, m843a);
                m844a(ioSession);
                m843a.mo831a(interfaceC3073a, ioSession);
                interfaceC3073a.mo1108c(ioSession);
            } catch (Exception e) {
                if (e instanceof ProtocolDecoderException) {
                    throw ((ProtocolDecoderException) e);
                }
                throw new ProtocolDecoderException(e);
            }
        } catch (Throwable th) {
            m844a(ioSession);
            m843a.mo831a(interfaceC3073a, ioSession);
            throw th;
        }
    }

    /* compiled from: ProtocolCodecFilter.java */
    /* renamed from: org.apache.mina.filter.codec.d$a */
    /* loaded from: classes2.dex */
    private static class C3099a extends DefaultWriteRequest {
        @Override // org.apache.mina.core.write.DefaultWriteRequest, org.apache.mina.core.write.InterfaceC3088b
        /* renamed from: e */
        public boolean mo837e() {
            return true;
        }

        public C3099a(Object obj, WriteFuture writeFuture, SocketAddress socketAddress) {
            super(obj, writeFuture, socketAddress);
        }
    }

    /* compiled from: ProtocolCodecFilter.java */
    /* renamed from: org.apache.mina.filter.codec.d$b */
    /* loaded from: classes2.dex */
    private static class C3100b extends WriteRequestWrapper {
        public C3100b(InterfaceC3088b interfaceC3088b) {
            super(interfaceC3088b);
        }

        @Override // org.apache.mina.core.write.WriteRequestWrapper, org.apache.mina.core.write.InterfaceC3088b
        /* renamed from: b */
        public Object mo836b() {
            return ProtocolCodecFilter.f11638c;
        }

        @Override // org.apache.mina.core.write.WriteRequestWrapper
        public String toString() {
            return "MessageWriteRequest, parent : " + super.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProtocolCodecFilter.java */
    /* renamed from: org.apache.mina.filter.codec.d$c */
    /* loaded from: classes2.dex */
    public static class C3101c extends AbstractProtocolDecoderOutput {
        @Override // org.apache.mina.filter.codec.ProtocolDecoderOutput
        /* renamed from: a */
        public void mo831a(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession) {
            Queue<Object> a = m865a();
            while (!a.isEmpty()) {
                interfaceC3073a.mo1114a(ioSession, a.poll());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProtocolCodecFilter.java */
    /* renamed from: org.apache.mina.filter.codec.d$d */
    /* loaded from: classes2.dex */
    public static class C3102d extends AbstractProtocolEncoderOutput {

        /* renamed from: a */
        private final IoSession f11644a;

        /* renamed from: b */
        private final IoFilter.InterfaceC3073a f11645b;

        /* renamed from: c */
        private final SocketAddress f11646c;

        public C3102d(IoSession ioSession, IoFilter.InterfaceC3073a interfaceC3073a, InterfaceC3088b interfaceC3088b) {
            this.f11644a = ioSession;
            this.f11645b = interfaceC3073a;
            this.f11646c = interfaceC3088b.mo953d();
        }
    }

    /* renamed from: a */
    private void m844a(IoSession ioSession) {
        m841b(ioSession);
        m840c(ioSession);
        m838d(ioSession);
    }

    /* renamed from: b */
    private void m841b(IoSession ioSession) {
        ProtocolEncoder protocolEncoder = (ProtocolEncoder) ioSession.mo1006c(f11639d);
        if (protocolEncoder == null) {
            return;
        }
        try {
            protocolEncoder.mo829a(ioSession);
        } catch (Exception unused) {
            InterfaceC3153b interfaceC3153b = f11636a;
            interfaceC3153b.warn("Failed to dispose: " + protocolEncoder.getClass().getName() + " (" + protocolEncoder + ')');
        }
    }

    /* renamed from: c */
    private void m840c(IoSession ioSession) {
        ProtocolDecoder protocolDecoder = (ProtocolDecoder) ioSession.mo1006c(f11640e);
        if (protocolDecoder == null) {
            return;
        }
        try {
            protocolDecoder.mo835a(ioSession);
        } catch (Exception unused) {
            InterfaceC3153b interfaceC3153b = f11636a;
            interfaceC3153b.warn("Failed to dispose: " + protocolDecoder.getClass().getName() + " (" + protocolDecoder + ')');
        }
    }

    /* renamed from: a */
    private ProtocolDecoderOutput m843a(IoSession ioSession, IoFilter.InterfaceC3073a interfaceC3073a) {
        ProtocolDecoderOutput protocolDecoderOutput = (ProtocolDecoderOutput) ioSession.mo1009b(f11641f);
        if (protocolDecoderOutput == null) {
            C3101c c3101c = new C3101c();
            ioSession.mo1008b(f11641f, c3101c);
            return c3101c;
        }
        return protocolDecoderOutput;
    }

    /* renamed from: a */
    private ProtocolEncoderOutput m842a(IoSession ioSession, IoFilter.InterfaceC3073a interfaceC3073a, InterfaceC3088b interfaceC3088b) {
        ProtocolEncoderOutput protocolEncoderOutput = (ProtocolEncoderOutput) ioSession.mo1009b(f11642g);
        if (protocolEncoderOutput == null) {
            C3102d c3102d = new C3102d(ioSession, interfaceC3073a, interfaceC3088b);
            ioSession.mo1008b(f11642g, c3102d);
            return c3102d;
        }
        return protocolEncoderOutput;
    }

    /* renamed from: d */
    private void m838d(IoSession ioSession) {
        ioSession.mo1006c(f11641f);
    }
}
