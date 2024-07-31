package org.apache.ftpserver.p123g;

import java.io.File;
import java.net.URL;
import org.apache.ftpserver.ftplet.UserManager;
import org.apache.ftpserver.p123g.p124a.PropertiesUserManager;

/* renamed from: org.apache.ftpserver.g.d */
/* loaded from: classes2.dex */
public class PropertiesUserManagerFactory {

    /* renamed from: b */
    private File f11131b;

    /* renamed from: c */
    private URL f11132c;

    /* renamed from: a */
    private String f11130a = "admin";

    /* renamed from: d */
    private PasswordEncryptor f11133d = new Md5PasswordEncryptor();

    /* renamed from: a */
    public UserManager m1680a() {
        URL url = this.f11132c;
        if (url != null) {
            return new PropertiesUserManager(this.f11133d, url, this.f11130a);
        }
        return new PropertiesUserManager(this.f11133d, this.f11131b, this.f11130a);
    }
}
