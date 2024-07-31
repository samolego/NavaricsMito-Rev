package org.apache.log4j.p125a;

/* renamed from: org.apache.log4j.a.a */
/* loaded from: classes2.dex */
class DefaultRenderer implements ObjectRenderer {
    @Override // org.apache.log4j.p125a.ObjectRenderer
    /* renamed from: a */
    public String mo1653a(Object obj) {
        try {
            return obj.toString();
        } catch (Exception e) {
            return e.toString();
        }
    }
}
