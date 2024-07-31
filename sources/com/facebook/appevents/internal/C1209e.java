package com.facebook.appevents.internal;

import android.support.annotation.Nullable;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

/* renamed from: com.facebook.appevents.internal.e */
/* loaded from: classes.dex */
final class HashUtils {
    @Nullable
    /* renamed from: a */
    public static final String m11005a(String str) throws Exception {
        return m11006a(new File(str));
    }

    @Nullable
    /* renamed from: a */
    private static String m11006a(File file) throws Exception {
        int read;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 1024);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[1024];
            do {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                }
            } while (read != -1);
            String bigInteger = new BigInteger(1, messageDigest.digest()).toString(16);
            bufferedInputStream.close();
            return bigInteger;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (th != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                } else {
                    bufferedInputStream.close();
                }
                throw th2;
            }
        }
    }
}
