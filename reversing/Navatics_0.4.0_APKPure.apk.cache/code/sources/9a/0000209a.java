package com.tencent.wxop.stat.common;

import java.io.File;

/* renamed from: com.tencent.wxop.stat.common.p */
/* loaded from: classes2.dex */
class C2445p {

    /* renamed from: a */
    private static int f8131a = -1;

    /* renamed from: a */
    public static boolean m8056a() {
        int i = f8131a;
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
                    f8131a = 1;
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        f8131a = 0;
        return false;
    }
}