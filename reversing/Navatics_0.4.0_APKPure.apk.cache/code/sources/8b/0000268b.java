package org.apache.mina.core;

/* loaded from: classes2.dex */
public class RuntimeIoException extends RuntimeException {
    private static final long serialVersionUID = 9029092241311939548L;

    public RuntimeIoException() {
    }

    public RuntimeIoException(String str) {
        super(str);
    }

    public RuntimeIoException(String str, Throwable th) {
        super(str, th);
    }

    public RuntimeIoException(Throwable th) {
        super(th);
    }
}