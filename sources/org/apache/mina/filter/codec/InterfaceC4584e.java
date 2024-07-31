package org.apache.mina.filter.codec;

import org.apache.mina.core.p129a.AbstractC3054b;
import org.apache.mina.core.session.IoSession;

/* renamed from: org.apache.mina.filter.codec.e */
/* loaded from: classes2.dex */
public interface ProtocolDecoder {
    /* renamed from: a */
    void mo835a(IoSession ioSession) throws Exception;

    /* renamed from: a */
    void mo834a(IoSession ioSession, AbstractC3054b abstractC3054b, ProtocolDecoderOutput protocolDecoderOutput) throws Exception;

    /* renamed from: a */
    void mo833a(IoSession ioSession, ProtocolDecoderOutput protocolDecoderOutput) throws Exception;
}
