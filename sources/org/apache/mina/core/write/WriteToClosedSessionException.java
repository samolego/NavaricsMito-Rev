package org.apache.mina.core.write;

import java.util.Collection;

/* loaded from: classes2.dex */
public class WriteToClosedSessionException extends WriteException {
    private static final long serialVersionUID = 5550204573739301393L;

    public WriteToClosedSessionException(Collection<InterfaceC3088b> collection, String str, Throwable th) {
        super(collection, str, th);
    }

    public WriteToClosedSessionException(Collection<InterfaceC3088b> collection, String str) {
        super(collection, str);
    }

    public WriteToClosedSessionException(Collection<InterfaceC3088b> collection, Throwable th) {
        super(collection, th);
    }

    public WriteToClosedSessionException(Collection<InterfaceC3088b> collection) {
        super(collection);
    }

    public WriteToClosedSessionException(InterfaceC3088b interfaceC3088b, String str, Throwable th) {
        super(interfaceC3088b, str, th);
    }

    public WriteToClosedSessionException(InterfaceC3088b interfaceC3088b, String str) {
        super(interfaceC3088b, str);
    }

    public WriteToClosedSessionException(InterfaceC3088b interfaceC3088b, Throwable th) {
        super(interfaceC3088b, th);
    }

    public WriteToClosedSessionException(InterfaceC3088b interfaceC3088b) {
        super(interfaceC3088b);
    }
}
