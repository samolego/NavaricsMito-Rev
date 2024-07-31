package org.apache.mina.core.session;

/* loaded from: classes2.dex */
public class IoSessionInitializationException extends RuntimeException {
    private static final long serialVersionUID = -1205810145763696189L;

    public IoSessionInitializationException() {
    }

    public IoSessionInitializationException(String str, Throwable th) {
        super(str, th);
    }

    public IoSessionInitializationException(String str) {
        super(str);
    }

    public IoSessionInitializationException(Throwable th) {
        super(th);
    }
}