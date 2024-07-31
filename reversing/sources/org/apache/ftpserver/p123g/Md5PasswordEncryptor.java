package org.apache.ftpserver.p123g;

import org.apache.ftpserver.util.EncryptUtils;

/* renamed from: org.apache.ftpserver.g.b */
/* loaded from: classes2.dex */
public class Md5PasswordEncryptor implements PasswordEncryptor {
    @Override // org.apache.ftpserver.p123g.PasswordEncryptor
    /* renamed from: a */
    public String mo1682a(String str) {
        return EncryptUtils.m1668a(str);
    }

    @Override // org.apache.ftpserver.p123g.PasswordEncryptor
    /* renamed from: a */
    public boolean mo1681a(String str, String str2) {
        if (str2 != null) {
            if (str == null) {
                throw new NullPointerException("passwordToCheck can not be null");
            }
            return mo1682a(str).equalsIgnoreCase(str2);
        }
        throw new NullPointerException("storedPassword can not be null");
    }
}
