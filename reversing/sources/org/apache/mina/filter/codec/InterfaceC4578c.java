package org.apache.mina.filter.codec;

import org.apache.mina.core.session.IoSession;

/* renamed from: org.apache.mina.filter.codec.c */
/* loaded from: classes2.dex */
public interface ProtocolCodecFactory {
    /* renamed from: a */
    ProtocolDecoder mo848a(IoSession ioSession) throws Exception;

    /* renamed from: b */
    ProtocolEncoder mo847b(IoSession ioSession) throws Exception;
}
