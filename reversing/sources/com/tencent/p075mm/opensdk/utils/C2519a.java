package com.tencent.p075mm.opensdk.utils;

import android.os.Bundle;

/* renamed from: com.tencent.mm.opensdk.utils.a */
/* loaded from: classes2.dex */
public final class C2519a {
    /* renamed from: a */
    public static int m4996a(Bundle bundle, String str) {
        if (bundle == null) {
            return -1;
        }
        try {
            return bundle.getInt(str, -1);
        } catch (Exception e) {
            Log.m5000e("MicroMsg.IntentUtil", "getIntExtra exception:" + e.getMessage());
            return -1;
        }
    }

    /* renamed from: b */
    public static String m4995b(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        try {
            return bundle.getString(str);
        } catch (Exception e) {
            Log.m5000e("MicroMsg.IntentUtil", "getStringExtra exception:" + e.getMessage());
            return null;
        }
    }
}
