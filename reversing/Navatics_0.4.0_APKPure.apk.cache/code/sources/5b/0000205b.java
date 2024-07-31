package com.tencent.mm.opensdk.utils;

/* renamed from: com.tencent.mm.opensdk.utils.d */
/* loaded from: classes2.dex */
public final class C2396d {
    /* renamed from: c */
    public static boolean m7861c(int i) {
        return i == 36 || i == 46;
    }

    /* renamed from: i */
    public static boolean m7862i(String str) {
        return str == null || str.length() <= 0;
    }

    /* renamed from: j */
    public static int m7863j(String str) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    return Integer.parseInt(str);
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }
}