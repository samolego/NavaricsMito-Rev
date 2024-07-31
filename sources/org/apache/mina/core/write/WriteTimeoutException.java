package org.apache.mina.core.write;

import java.util.Collection;

/* loaded from: classes2.dex */
public class WriteTimeoutException extends WriteException {
    private static final long serialVersionUID = 3906931157944579121L;

    public WriteTimeoutException(Collection<InterfaceC3088b> collection, String str, Throwable th) {
        super(collection, str, th);
    }

    public WriteTimeoutException(Collection<InterfaceC3088b> collection, String str) {
        super(collection, str);
    }

    public WriteTimeoutException(Collection<InterfaceC3088b> collection, Throwable th) {
        super(collection, th);
    }

    public WriteTimeoutException(Collection<InterfaceC3088b> collection) {
        super(collection);
    }

    public WriteTimeoutException(InterfaceC3088b interfaceC3088b, String str, Throwable th) {
        super(interfaceC3088b, str, th);
    }

    public WriteTimeoutException(InterfaceC3088b interfaceC3088b, String str) {
        super(interfaceC3088b, str);
    }

    public WriteTimeoutException(InterfaceC3088b interfaceC3088b, Throwable th) {
        super(interfaceC3088b, th);
    }

    public WriteTimeoutException(InterfaceC3088b interfaceC3088b) {
        super(interfaceC3088b);
    }
}
