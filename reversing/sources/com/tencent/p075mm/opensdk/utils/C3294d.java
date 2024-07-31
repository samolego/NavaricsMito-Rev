package com.tencent.p075mm.opensdk.utils;

/* renamed from: com.tencent.mm.opensdk.utils.d */
/* loaded from: classes2.dex */
public final class C2524d {
    /* renamed from: c */
    public static boolean m4992c(int i) {
        return i == 36 || i == 46;
    }

    /* renamed from: i */
    public static boolean m4991i(String str) {
        return str == null || str.length() <= 0;
    }

    /* renamed from: j */
    public static int m4990j(String str) {
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
