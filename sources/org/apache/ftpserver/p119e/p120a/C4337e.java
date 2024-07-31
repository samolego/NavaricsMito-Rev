package org.apache.ftpserver.p119e.p120a;

import java.nio.charset.Charset;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.p137a.TextLineDecoder;

/* renamed from: org.apache.ftpserver.e.a.e */
/* loaded from: classes2.dex */
public class FtpServerProtocolCodecFactory implements ProtocolCodecFactory {

    /* renamed from: a */
    private final ProtocolDecoder f11072a = new TextLineDecoder(Charset.forName("UTF-8"));

    /* renamed from: b */
    private final ProtocolEncoder f11073b = new FtpResponseEncoder();

    @Override // org.apache.mina.filter.codec.ProtocolCodecFactory
    /* renamed from: a */
    public ProtocolDecoder mo848a(IoSession ioSession) throws Exception {
        return this.f11072a;
    }

    @Override // org.apache.mina.filter.codec.ProtocolCodecFactory
    /* renamed from: b */
    public ProtocolEncoder mo847b(IoSession ioSession) throws Exception {
        return this.f11073b;
    }
}
