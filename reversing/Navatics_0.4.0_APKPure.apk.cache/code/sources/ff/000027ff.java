package org.slf4j.helpers;

/* compiled from: FormattingTuple.java */
/* renamed from: org.slf4j.helpers.a, reason: use source file name */
/* loaded from: classes2.dex */
public class FormattingTuple {

    /* renamed from: a */
    public static FormattingTuple f12591a = new FormattingTuple(null);

    /* renamed from: b */
    private String f12592b;

    /* renamed from: c */
    private Throwable f12593c;

    /* renamed from: d */
    private Object[] f12594d;

    public FormattingTuple(String str) {
        this(str, null, null);
    }

    public FormattingTuple(String str, Object[] objArr, Throwable th) {
        this.f12592b = str;
        this.f12593c = th;
        this.f12594d = objArr;
    }

    /* renamed from: a */
    public String m12591a() {
        return this.f12592b;
    }

    /* renamed from: b */
    public Throwable m12592b() {
        return this.f12593c;
    }
}