package org.apache.commons.pool2.impl;

/* renamed from: org.apache.commons.pool2.impl.n */
/* loaded from: classes2.dex */
public class GenericObjectPoolConfig<T> extends BaseObjectPoolConfig<T> {

    /* renamed from: c */
    private int f10854c = 8;

    /* renamed from: d */
    private int f10855d = 8;

    /* renamed from: e */
    private int f10856e = 0;

    /* renamed from: s */
    public int m2009s() {
        return this.f10854c;
    }

    /* renamed from: a */
    public void m2011a(int i) {
        this.f10854c = i;
    }

    /* renamed from: t */
    public int m2008t() {
        return this.f10855d;
    }

    /* renamed from: u */
    public int m2007u() {
        return this.f10856e;
    }

    /* renamed from: v */
    public GenericObjectPoolConfig<T> clone() {
        try {
            return (GenericObjectPoolConfig) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.pool2.impl.BaseObjectPoolConfig, org.apache.commons.pool2.BaseObject
    /* renamed from: a */
    public void mo2010a(StringBuilder sb) {
        super.mo2010a(sb);
        sb.append(", maxTotal=");
        sb.append(this.f10854c);
        sb.append(", maxIdle=");
        sb.append(this.f10855d);
        sb.append(", minIdle=");
        sb.append(this.f10856e);
    }
}
