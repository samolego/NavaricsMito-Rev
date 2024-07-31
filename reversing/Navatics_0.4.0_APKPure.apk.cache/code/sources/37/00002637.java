package org.apache.log4j.p114a;

/* compiled from: DefaultRenderer.java */
/* renamed from: org.apache.log4j.a.a, reason: use source file name */
/* loaded from: classes2.dex */
class DefaultRenderer implements InterfaceC3202b {
    @Override // org.apache.log4j.p114a.InterfaceC3202b
    /* renamed from: a */
    public String mo11225a(Object obj) {
        try {
            return obj.toString();
        } catch (Exception e) {
            return e.toString();
        }
    }
}