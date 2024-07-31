package com.navatics.robot.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

/* compiled from: Des3.java */
/* renamed from: com.navatics.robot.utils.e */
/* loaded from: classes2.dex */
public class Des3 {
    /* renamed from: a */
    public static String m6961a(String str) throws Exception {
        SecretKey generateSecret = SecretKeyFactory.getInstance("desede").generateSecret(new DESedeKeySpec("2bbed6c983be989b0a4a525caee23622".getBytes()));
        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        cipher.init(1, generateSecret, new IvParameterSpec("01234567".getBytes()));
        return Base64.toBase64(cipher.doFinal(str.getBytes("utf-8")));
    }
}