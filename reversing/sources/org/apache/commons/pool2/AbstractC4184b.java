package org.apache.commons.pool2;

/* renamed from: org.apache.commons.pool2.b */
/* loaded from: classes2.dex */
public abstract class BaseObject {
    /* renamed from: a */
    protected void mo2010a(StringBuilder sb) {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        mo2010a(sb);
        sb.append("]");
        return sb.toString();
    }
}
