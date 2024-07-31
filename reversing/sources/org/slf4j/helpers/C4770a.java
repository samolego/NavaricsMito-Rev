package org.slf4j.helpers;

/* renamed from: org.slf4j.helpers.a */
/* loaded from: classes2.dex */
public class FormattingTuple {

    /* renamed from: a */
    public static FormattingTuple f12550a = new FormattingTuple(null);

    /* renamed from: b */
    private String f12551b;

    /* renamed from: c */
    private Throwable f12552c;

    /* renamed from: d */
    private Object[] f12553d;

    public FormattingTuple(String str) {
        this(str, null, null);
    }

    public FormattingTuple(String str, Object[] objArr, Throwable th) {
        this.f12551b = str;
        this.f12552c = th;
        this.f12553d = objArr;
    }

    /* renamed from: a */
    public String m223a() {
        return this.f12551b;
    }

    /* renamed from: b */
    public Throwable m222b() {
        return this.f12552c;
    }
}
