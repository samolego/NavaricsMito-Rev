package com.tencent.mm.opensdk.utils;

import com.adapt.SPM_Rc;
import java.security.MessageDigest;

/* renamed from: com.tencent.mm.opensdk.utils.b */
/* loaded from: classes2.dex */
public final class C2394b {
    /* renamed from: e */
    public static final String m7859e(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length * 2];
            int i = 0;
            for (byte b : digest) {
                int i2 = i + 1;
                cArr2[i] = cArr[(b >>> 4) & 15];
                i = i2 + 1;
                cArr2[i2] = cArr[b & SPM_Rc.VIBRATION_MODE.MAX_VOLUME];
            }
            return new String(cArr2);
        } catch (Exception unused) {
            return null;
        }
    }
}