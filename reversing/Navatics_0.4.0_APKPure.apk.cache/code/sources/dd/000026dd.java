package org.apache.mina.core.session;

/* compiled from: IdleStatus.java */
/* renamed from: org.apache.mina.core.session.e, reason: use source file name */
/* loaded from: classes2.dex */
public class IdleStatus {

    /* renamed from: a */
    public static final IdleStatus f11576a = new IdleStatus("reader idle");

    /* renamed from: b */
    public static final IdleStatus f11577b = new IdleStatus("writer idle");

    /* renamed from: c */
    public static final IdleStatus f11578c = new IdleStatus("both idle");

    /* renamed from: d */
    private final String f11579d;

    private IdleStatus(String str) {
        this.f11579d = str;
    }

    public String toString() {
        return this.f11579d;
    }
}