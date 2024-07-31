package com.facebook.internal;

/* compiled from: InternalSettings.java */
/* renamed from: com.facebook.internal.o, reason: use source file name */
/* loaded from: classes.dex */
public class InternalSettings {

    /* renamed from: a */
    private static volatile String f2022a;

    /* renamed from: a */
    public static String m2334a() {
        return f2022a;
    }

    /* renamed from: b */
    public static boolean m2335b() {
        return f2022a != null && f2022a.startsWith("Unity.");
    }
}