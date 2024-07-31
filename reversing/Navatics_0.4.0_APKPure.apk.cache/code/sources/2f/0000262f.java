package org.apache.ftpserver.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: EncryptUtils.java */
/* renamed from: org.apache.ftpserver.util.b, reason: use source file name */
/* loaded from: classes2.dex */
public class EncryptUtils {
    /* renamed from: a */
    public static final byte[] m11206a(byte[] bArr, String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.reset();
        messageDigest.update(bArr);
        return messageDigest.digest();
    }

    /* renamed from: a */
    public static final String m11205a(String str, String str2) throws NoSuchAlgorithmException {
        return C3199f.m11218a(m11206a(str.getBytes(), str2));
    }

    /* renamed from: a */
    public static final String m11204a(String str) {
        if (str == null) {
            str = "";
        }
        try {
            return m11205a(str, "MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}