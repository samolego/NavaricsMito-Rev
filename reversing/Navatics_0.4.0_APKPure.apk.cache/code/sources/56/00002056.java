package com.tencent.mm.opensdk.utils;

import android.os.Bundle;

/* renamed from: com.tencent.mm.opensdk.utils.a */
/* loaded from: classes2.dex */
public final class C2393a {
    /* renamed from: a */
    public static int m7857a(Bundle bundle, String str) {
        if (bundle == null) {
            return -1;
        }
        try {
            return bundle.getInt(str, -1);
        } catch (Exception e) {
            Log.m7853e("MicroMsg.IntentUtil", "getIntExtra exception:" + e.getMessage());
            return -1;
        }
    }

    /* renamed from: b */
    public static String m7858b(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        try {
            return bundle.getString(str);
        } catch (Exception e) {
            Log.m7853e("MicroMsg.IntentUtil", "getStringExtra exception:" + e.getMessage());
            return null;
        }
    }
}