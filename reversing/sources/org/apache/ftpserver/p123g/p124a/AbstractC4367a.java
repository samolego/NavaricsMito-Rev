package org.apache.ftpserver.p123g.p124a;

import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.UserManager;
import org.apache.ftpserver.p123g.PasswordEncryptor;

/* renamed from: org.apache.ftpserver.g.a.a */
/* loaded from: classes2.dex */
public abstract class AbstractUserManager implements UserManager {

    /* renamed from: a */
    private final String f11104a;

    /* renamed from: b */
    private final PasswordEncryptor f11105b;

    public AbstractUserManager(String str, PasswordEncryptor passwordEncryptor) {
        this.f11104a = str;
        this.f11105b = passwordEncryptor;
    }

    @Override // org.apache.ftpserver.ftplet.UserManager
    /* renamed from: c */
    public boolean mo1718c(String str) throws FtpException {
        return this.f11104a.equals(str);
    }

    /* renamed from: a */
    public PasswordEncryptor m1719a() {
        return this.f11105b;
    }
}
