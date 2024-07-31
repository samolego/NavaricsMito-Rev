package org.slf4j.helpers;

import java.io.ObjectStreamException;
import java.io.Serializable;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class NamedLoggerBase implements Serializable, InterfaceC3153b {
    private static final long serialVersionUID = 7535258609338176893L;
    protected String name;

    public String getName() {
        return this.name;
    }

    protected Object readResolve() throws ObjectStreamException {
        return C3154c.m260a(getName());
    }
}
