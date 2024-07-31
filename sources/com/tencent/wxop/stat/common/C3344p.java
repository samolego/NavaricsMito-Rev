package com.tencent.wxop.stat.common;

import java.io.File;

/* renamed from: com.tencent.wxop.stat.common.p */
/* loaded from: classes2.dex */
class C2573p {

    /* renamed from: a */
    private static int f8093a = -1;

    /* renamed from: a */
    public static boolean m4799a() {
        int i = f8093a;
        if (i == 1) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        String[] strArr = {"/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        for (int i2 = 0; i2 < 6; i2++) {
            try {
                if (new File(strArr[i2] + "su").exists()) {
                    f8093a = 1;
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        f8093a = 0;
        return false;
    }
}
