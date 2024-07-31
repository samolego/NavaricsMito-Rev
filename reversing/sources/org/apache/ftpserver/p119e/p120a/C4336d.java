package org.apache.ftpserver.p119e.p120a;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import org.apache.mina.core.p129a.AbstractC3054b;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

/* renamed from: org.apache.ftpserver.e.a.d */
/* loaded from: classes2.dex */
public class FtpResponseEncoder extends ProtocolEncoderAdapter {

    /* renamed from: a */
    private static final CharsetEncoder f11071a = Charset.forName("UTF-8").newEncoder();

    @Override // org.apache.mina.filter.codec.ProtocolEncoder
    /* renamed from: a */
    public void mo830a(IoSession ioSession, Object obj, ProtocolEncoderOutput protocolEncoderOutput) throws Exception {
        String obj2 = obj.toString();
        AbstractC3054b mo1378a = AbstractC3054b.m1362h(obj2.length()).mo1378a(true);
        mo1378a.mo1381a(obj2, f11071a);
        mo1378a.mo1358k();
        protocolEncoderOutput.mo828a(mo1378a);
    }
}
