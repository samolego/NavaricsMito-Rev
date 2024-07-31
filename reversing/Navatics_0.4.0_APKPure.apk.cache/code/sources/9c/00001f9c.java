package com.tencent.bugly.proguard;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ae */
/* loaded from: classes2.dex */
public final class C2342ae implements InterfaceC2344ag {

    /* renamed from: a */
    private String f7554a = null;

    @Override // com.tencent.bugly.proguard.InterfaceC2344ag
    /* renamed from: a */
    public final byte[] mo7592a(byte[] bArr) throws Exception {
        if (this.f7554a == null || bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(((int) b) + " ");
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(this.f7554a.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(this.f7554a.getBytes()));
        byte[] doFinal = cipher.doFinal(bArr);
        StringBuffer stringBuffer2 = new StringBuffer();
        for (byte b2 : doFinal) {
            stringBuffer2.append(((int) b2) + " ");
        }
        return doFinal;
    }

    @Override // com.tencent.bugly.proguard.InterfaceC2344ag
    /* renamed from: b */
    public final byte[] mo7593b(byte[] bArr) throws Exception, NoSuchAlgorithmException {
        if (this.f7554a == null || bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(((int) b) + " ");
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(this.f7554a.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(this.f7554a.getBytes()));
        byte[] doFinal = cipher.doFinal(bArr);
        StringBuffer stringBuffer2 = new StringBuffer();
        for (byte b2 : doFinal) {
            stringBuffer2.append(((int) b2) + " ");
        }
        return doFinal;
    }

    @Override // com.tencent.bugly.proguard.InterfaceC2344ag
    /* renamed from: a */
    public final void mo7591a(String str) {
        if (str != null) {
            for (int length = str.length(); length < 16; length++) {
                str = str + "0";
            }
            this.f7554a = str.substring(0, 16);
        }
    }
}