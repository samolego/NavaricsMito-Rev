package org.slf4j.impl;

import org.slf4j.helpers.C3498g;

/* compiled from: VersionUtil.java */
/* renamed from: org.slf4j.impl.e, reason: use source file name */
/* loaded from: classes2.dex */
public class VersionUtil {
    /* renamed from: a */
    public static int m12638a() {
        return m12639a(C3498g.m12624a("java.version"));
    }

    /* renamed from: a */
    static int m12639a(String str) {
        if (str == null) {
            return 5;
        }
        if (str.startsWith("1.")) {
            return str.charAt(2) - '0';
        }
        try {
            Object invoke = Runtime.class.getMethod("version", new Class[0]).invoke(null, new Object[0]);
            return ((Integer) invoke.getClass().getMethod("major", new Class[0]).invoke(invoke, new Object[0])).intValue();
        } catch (Exception unused) {
            return 5;
        }
    }
}