package org.apache.commons.pool2.impl;

/* renamed from: org.apache.commons.pool2.impl.l */
/* loaded from: classes2.dex */
public class GenericKeyedObjectPoolConfig<T> extends BaseObjectPoolConfig<T> {

    /* renamed from: c */
    private int f10840c = 0;

    /* renamed from: d */
    private int f10841d = 8;

    /* renamed from: e */
    private int f10842e = 8;

    /* renamed from: f */
    private int f10843f = -1;

    /* renamed from: s */
    public int m2036s() {
        return this.f10843f;
    }

    /* renamed from: t */
    public int m2035t() {
        return this.f10842e;
    }

    /* renamed from: u */
    public int m2034u() {
        return this.f10840c;
    }

    /* renamed from: v */
    public int m2033v() {
        return this.f10841d;
    }

    /* renamed from: w */
    public GenericKeyedObjectPoolConfig<T> clone() {
        try {
            return (GenericKeyedObjectPoolConfig) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.pool2.impl.BaseObjectPoolConfig, org.apache.commons.pool2.BaseObject
    /* renamed from: a */
    public void mo2010a(StringBuilder sb) {
        super.mo2010a(sb);
        sb.append(", minIdlePerKey=");
        sb.append(this.f10840c);
        sb.append(", maxIdlePerKey=");
        sb.append(this.f10841d);
        sb.append(", maxTotalPerKey=");
        sb.append(this.f10842e);
        sb.append(", maxTotal=");
        sb.append(this.f10843f);
    }
}
