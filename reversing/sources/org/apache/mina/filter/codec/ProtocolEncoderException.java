package org.apache.mina.filter.codec;

/* loaded from: classes2.dex */
public class ProtocolEncoderException extends ProtocolCodecException {
    private static final long serialVersionUID = 8752989973624459604L;

    public ProtocolEncoderException() {
    }

    public ProtocolEncoderException(String str) {
        super(str);
    }

    public ProtocolEncoderException(Throwable th) {
        super(th);
    }

    public ProtocolEncoderException(String str, Throwable th) {
        super(str, th);
    }
}
