package org.apache.mina.core.session;

/* renamed from: org.apache.mina.core.session.e */
/* loaded from: classes2.dex */
public class IdleStatus {

    /* renamed from: a */
    public static final IdleStatus f11535a = new IdleStatus("reader idle");

    /* renamed from: b */
    public static final IdleStatus f11536b = new IdleStatus("writer idle");

    /* renamed from: c */
    public static final IdleStatus f11537c = new IdleStatus("both idle");

    /* renamed from: d */
    private final String f11538d;

    private IdleStatus(String str) {
        this.f11538d = str;
    }

    public String toString() {
        return this.f11538d;
    }
}
