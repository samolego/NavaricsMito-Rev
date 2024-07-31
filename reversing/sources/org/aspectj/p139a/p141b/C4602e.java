package org.aspectj.p139a.p141b;

import org.aspectj.lang.p142a.MethodSignature;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: org.aspectj.a.b.e */
/* loaded from: classes2.dex */
public class MethodSignatureImpl extends CodeSignatureImpl implements MethodSignature {

    /* renamed from: d */
    Class f11688d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MethodSignatureImpl(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        super(i, str, cls, clsArr, strArr, clsArr2);
        this.f11688d = cls2;
    }

    /* renamed from: c */
    public Class m788c() {
        if (this.f11688d == null) {
            this.f11688d = m782c(6);
        }
        return this.f11688d;
    }

    @Override // org.aspectj.p139a.p141b.SignatureImpl
    /* renamed from: a */
    protected String mo785a(StringMaker stringMaker) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(stringMaker.m770a(m781d()));
        if (stringMaker.f11707b) {
            stringBuffer.append(stringMaker.m769a(m788c()));
        }
        if (stringMaker.f11707b) {
            stringBuffer.append(" ");
        }
        stringBuffer.append(stringMaker.m768a(m778f(), m777g()));
        stringBuffer.append(".");
        stringBuffer.append(m779e());
        stringMaker.m763b(stringBuffer, m801a());
        stringMaker.m762c(stringBuffer, m800b());
        return stringBuffer.toString();
    }
}
