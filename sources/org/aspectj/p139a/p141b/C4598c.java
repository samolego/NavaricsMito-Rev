package org.aspectj.p139a.p141b;

import org.aspectj.lang.InterfaceC3112b;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.p142a.SourceLocation;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: org.aspectj.a.b.c */
/* loaded from: classes2.dex */
public class JoinPointImpl implements InterfaceC3112b {

    /* renamed from: a */
    Object f11680a;

    /* renamed from: b */
    Object f11681b;

    /* renamed from: c */
    Object[] f11682c;

    /* renamed from: d */
    JoinPoint.InterfaceC3109a f11683d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JoinPointImpl.java */
    /* renamed from: org.aspectj.a.b.c$a */
    /* loaded from: classes2.dex */
    public static class C3106a implements JoinPoint.InterfaceC3109a {

        /* renamed from: a */
        String f11684a;

        /* renamed from: b */
        Signature f11685b;

        /* renamed from: c */
        SourceLocation f11686c;

        /* renamed from: d */
        private int f11687d;

        public C3106a(int i, String str, Signature signature, SourceLocation sourceLocation) {
            this.f11684a = str;
            this.f11685b = signature;
            this.f11686c = sourceLocation;
            this.f11687d = i;
        }

        /* renamed from: a */
        public String m791a() {
            return this.f11684a;
        }

        /* renamed from: b */
        public Signature m789b() {
            return this.f11685b;
        }

        /* renamed from: a */
        String m790a(StringMaker stringMaker) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(stringMaker.m766a(m791a()));
            stringBuffer.append("(");
            stringBuffer.append(((SignatureImpl) m789b()).m783b(stringMaker));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        @Override // org.aspectj.lang.JoinPoint.InterfaceC3109a
        public final String toString() {
            return m790a(StringMaker.f11704k);
        }
    }

    public JoinPointImpl(JoinPoint.InterfaceC3109a interfaceC3109a, Object obj, Object obj2, Object[] objArr) {
        this.f11683d = interfaceC3109a;
        this.f11680a = obj;
        this.f11681b = obj2;
        this.f11682c = objArr;
    }

    @Override // org.aspectj.lang.JoinPoint
    /* renamed from: a */
    public Object mo761a() {
        return this.f11681b;
    }

    public final String toString() {
        return this.f11683d.toString();
    }
}
