package com.tencent.bugly.proguard;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.af */
/* loaded from: classes2.dex */
public final class C2343af implements InterfaceC2344ag {

    /* renamed from: a */
    private String f7555a = null;

    @Override // com.tencent.bugly.proguard.InterfaceC2344ag
    /* renamed from: a */
    public final byte[] mo7592a(byte[] bArr) throws Exception {
        if (this.f7555a == null || bArr == null) {
            return null;
        }
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(2, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(this.f7555a.getBytes("UTF-8"))), new IvParameterSpec(this.f7555a.getBytes("UTF-8")));
        return cipher.doFinal(bArr);
    }

    @Override // com.tencent.bugly.proguard.InterfaceC2344ag
    /* renamed from: b */
    public final byte[] mo7593b(byte[] bArr) throws Exception, NoSuchAlgorithmException {
        if (this.f7555a == null || bArr == null) {
            return null;
        }
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(1, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(this.f7555a.getBytes("UTF-8"))), new IvParameterSpec(this.f7555a.getBytes("UTF-8")));
        return cipher.doFinal(bArr);
    }

    @Override // com.tencent.bugly.proguard.InterfaceC2344ag
    /* renamed from: a */
    public final void mo7591a(String str) {
        if (str != null) {
            this.f7555a = str;
        }
    }
}