package org.apache.mina.filter.codec;

/* loaded from: classes2.dex */
public class ProtocolDecoderException extends ProtocolCodecException {
    private static final long serialVersionUID = 3545799879533408565L;
    private String hexdump;

    public ProtocolDecoderException() {
    }

    public ProtocolDecoderException(String str) {
        super(str);
    }

    public ProtocolDecoderException(Throwable th) {
        super(th);
    }

    public ProtocolDecoderException(String str, Throwable th) {
        super(str, th);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        if (message == null) {
            message = "";
        }
        if (this.hexdump != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(message);
            sb.append(message.length() > 0 ? " " : "");
            sb.append("(Hexdump: ");
            sb.append(this.hexdump);
            sb.append(')');
            return sb.toString();
        }
        return message;
    }

    public String getHexdump() {
        return this.hexdump;
    }

    public void setHexdump(String str) {
        if (this.hexdump != null) {
            throw new IllegalStateException("Hexdump cannot be set more than once.");
        }
        this.hexdump = str;
    }
}
