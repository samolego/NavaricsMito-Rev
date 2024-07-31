package org.apache.mina.core.session;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class AttributeKey implements Serializable {
    private static final long serialVersionUID = -583377473376683096L;
    private final String name;

    public AttributeKey(Class<?> cls, String str) {
        this.name = cls.getName() + '.' + str + '@' + Integer.toHexString(hashCode());
    }

    public String toString() {
        return this.name;
    }

    public int hashCode() {
        String str = this.name;
        return (str == null ? 0 : str.hashCode()) + 629;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AttributeKey) {
            return this.name.equals(((AttributeKey) obj).name);
        }
        return false;
    }
}
