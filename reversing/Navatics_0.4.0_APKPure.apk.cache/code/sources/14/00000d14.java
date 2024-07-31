package com.facebook.appevents.ml;

import android.text.TextUtils;
import java.nio.charset.Charset;

/* compiled from: Utils.java */
/* renamed from: com.facebook.appevents.ml.d */
/* loaded from: classes.dex */
public class C0875d {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static int[] m2058a(String str, int i) {
        int[] iArr = new int[i];
        byte[] bytes = m2057a(str).getBytes(Charset.forName("UTF-8"));
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 < bytes.length) {
                iArr[i2] = bytes[i2] & 255;
            } else {
                iArr[i2] = 0;
            }
        }
        return iArr;
    }

    /* renamed from: a */
    static String m2057a(String str) {
        return TextUtils.join(" ", str.trim().split("\\s+"));
    }
}