package org.apache.ftpserver.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: org.apache.ftpserver.util.b */
/* loaded from: classes2.dex */
public class EncryptUtils {
    /* renamed from: a */
    public static final byte[] m1666a(byte[] bArr, String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.reset();
        messageDigest.update(bArr);
        return messageDigest.digest();
    }

    /* renamed from: a */
    public static final String m1667a(String str, String str2) throws NoSuchAlgorithmException {
        return C3035f.m1654a(m1666a(str.getBytes(), str2));
    }

    /* renamed from: a */
    public static final String m1668a(String str) {
        if (str == null) {
            str = "";
        }
        try {
            return m1667a(str, "MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
