package org.apache.mina.filter.codec;

/* loaded from: classes2.dex */
public class ProtocolCodecException extends Exception {
    private static final long serialVersionUID = 5939878548186330695L;

    public ProtocolCodecException() {
    }

    public ProtocolCodecException(String str) {
        super(str);
    }

    public ProtocolCodecException(Throwable th) {
        super(th);
    }

    public ProtocolCodecException(String str, Throwable th) {
        super(str, th);
    }
}