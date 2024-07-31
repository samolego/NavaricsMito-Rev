package org.apache.mina.core.filterchain;

/* loaded from: classes2.dex */
public class IoFilterLifeCycleException extends RuntimeException {
    private static final long serialVersionUID = -5542098881633506449L;

    public IoFilterLifeCycleException() {
    }

    public IoFilterLifeCycleException(String str) {
        super(str);
    }

    public IoFilterLifeCycleException(String str, Throwable th) {
        super(str, th);
    }

    public IoFilterLifeCycleException(Throwable th) {
        super(th);
    }
}