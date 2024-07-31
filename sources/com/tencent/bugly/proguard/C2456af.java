package com.tencent.bugly.proguard;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.af */
/* loaded from: classes2.dex */
public final class C2456af implements InterfaceC2457ag {

    /* renamed from: a */
    private String f7517a = null;

    @Override // com.tencent.bugly.proguard.InterfaceC2457ag
    /* renamed from: a */
    public final byte[] mo5266a(byte[] bArr) throws Exception {
        if (this.f7517a == null || bArr == null) {
            return null;
        }
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(2, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(this.f7517a.getBytes("UTF-8"))), new IvParameterSpec(this.f7517a.getBytes("UTF-8")));
        return cipher.doFinal(bArr);
    }

    @Override // com.tencent.bugly.proguard.InterfaceC2457ag
    /* renamed from: b */
    public final byte[] mo5265b(byte[] bArr) throws Exception, NoSuchAlgorithmException {
        if (this.f7517a == null || bArr == null) {
            return null;
        }
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(1, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(this.f7517a.getBytes("UTF-8"))), new IvParameterSpec(this.f7517a.getBytes("UTF-8")));
        return cipher.doFinal(bArr);
    }

    @Override // com.tencent.bugly.proguard.InterfaceC2457ag
    /* renamed from: a */
    public final void mo5267a(String str) {
        if (str != null) {
            this.f7517a = str;
        }
    }
}
