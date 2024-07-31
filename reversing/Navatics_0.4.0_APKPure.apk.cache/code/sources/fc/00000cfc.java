package com.facebook.appevents.internal;

import android.support.annotation.Nullable;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

/* compiled from: HashUtils.java */
/* renamed from: com.facebook.appevents.internal.e, reason: use source file name */
/* loaded from: classes.dex */
final class HashUtils {
    @Nullable
    /* renamed from: a */
    public static final String m1959a(String str) throws Exception {
        return m1958a(new File(str));
    }

    @Nullable
    /* renamed from: a */
    private static String m1958a(File file) throws Exception {
        int read;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 1024);
        Throwable th = null;
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
        } catch (Throwable th2) {
            if (0 != 0) {
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