package org.aspectj.p139a.p141b;

import org.aspectj.lang.p142a.InterfaceC3110a;

/* renamed from: org.aspectj.a.b.a */
/* loaded from: classes2.dex */
abstract class CodeSignatureImpl extends MemberSignatureImpl implements InterfaceC3110a {

    /* renamed from: a */
    Class[] f11668a;

    /* renamed from: b */
    String[] f11669b;

    /* renamed from: c */
    Class[] f11670c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CodeSignatureImpl(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.f11668a = clsArr;
        this.f11669b = strArr;
        this.f11670c = clsArr2;
    }

    /* renamed from: a */
    public Class[] m801a() {
        if (this.f11668a == null) {
            this.f11668a = m780d(3);
        }
        return this.f11668a;
    }

    /* renamed from: b */
    public Class[] m800b() {
        if (this.f11670c == null) {
            this.f11670c = m780d(5);
        }
        return this.f11670c;
    }
}
