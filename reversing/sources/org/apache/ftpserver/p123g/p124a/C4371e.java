package org.apache.ftpserver.p123g.p124a;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import org.apache.ftpserver.FtpServerConfigurationException;
import org.apache.ftpserver.ftplet.Authentication;
import org.apache.ftpserver.ftplet.AuthenticationFailedException;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.User;
import org.apache.ftpserver.p123g.AnonymousAuthentication;
import org.apache.ftpserver.p123g.PasswordEncryptor;
import org.apache.ftpserver.p123g.UsernamePasswordAuthentication;
import org.apache.ftpserver.util.BaseProperties;
import org.apache.ftpserver.util.IoUtils;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.g.a.e */
/* loaded from: classes2.dex */
public class PropertiesUserManager extends AbstractUserManager {

    /* renamed from: a */
    private final InterfaceC3153b f11118a;

    /* renamed from: b */
    private BaseProperties f11119b;

    /* renamed from: c */
    private File f11120c;

    /* renamed from: d */
    private URL f11121d;

    public PropertiesUserManager(PasswordEncryptor passwordEncryptor, File file, String str) {
        super(str, passwordEncryptor);
        this.f11118a = C3154c.m262a(PropertiesUserManager.class);
        m1699a(file);
    }

    public PropertiesUserManager(PasswordEncryptor passwordEncryptor, URL url, String str) {
        super(str, passwordEncryptor);
        this.f11118a = C3154c.m262a(PropertiesUserManager.class);
        m1697a(url);
    }

    /* renamed from: a */
    private void m1699a(File file) {
        FileInputStream fileInputStream;
        Throwable th;
        try {
            this.f11119b = new BaseProperties();
            if (file == null) {
                return;
            }
            this.f11118a.debug("File configured, will try loading");
            if (file.exists()) {
                this.f11120c = file;
                this.f11118a.debug("File found on file system");
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        this.f11119b.load(fileInputStream);
                        IoUtils.m1662b(fileInputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        IoUtils.m1662b(fileInputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    fileInputStream = null;
                    th = th3;
                }
            } else {
                this.f11118a.debug("File not found on file system, try loading from classpath");
                InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(file.getPath());
                if (resourceAsStream != null) {
                    this.f11119b.load(resourceAsStream);
                    IoUtils.m1662b(resourceAsStream);
                    return;
                }
                throw new FtpServerConfigurationException("User data file specified but could not be located, neither on the file system or in the classpath: " + file.getPath());
            }
        } catch (IOException e) {
            throw new FtpServerConfigurationException("Error loading user data file : " + file, e);
        }
    }

    /* renamed from: a */
    private void m1697a(URL url) {
        try {
            this.f11119b = new BaseProperties();
            if (url != null) {
                this.f11118a.debug("URL configured, will try loading");
                this.f11121d = url;
                InputStream openStream = url.openStream();
                this.f11119b.load(openStream);
                IoUtils.m1662b(openStream);
            }
        } catch (IOException e) {
            throw new FtpServerConfigurationException("Error loading user data resource : " + url, e);
        }
    }

    @Override // org.apache.ftpserver.ftplet.UserManager
    /* renamed from: a */
    public synchronized void mo1695a(User user) throws FtpException {
        if (user.mo1717a() == null) {
            throw new NullPointerException("User name is null.");
        }
        String str = "ftpserver.user." + user.mo1717a() + '.';
        this.f11119b.setProperty(str + "userpassword", m1692b(user));
        String mo1706e = user.mo1706e();
        if (mo1706e == null) {
            mo1706e = "/";
        }
        this.f11119b.setProperty(str + "homedirectory", mo1706e);
        this.f11119b.setProperty(str + "enableflag", user.mo1707d());
        this.f11119b.setProperty(str + "writepermission", user.mo1713a(new WriteRequest()) != null);
        this.f11119b.setProperty(str + "idletime", user.mo1709c());
        TransferRateRequest transferRateRequest = (TransferRateRequest) user.mo1713a(new TransferRateRequest());
        if (transferRateRequest != null) {
            this.f11119b.setProperty(str + "uploadrate", transferRateRequest.m1689b());
            this.f11119b.setProperty(str + "downloadrate", transferRateRequest.m1691a());
        } else {
            this.f11119b.remove(str + "uploadrate");
            this.f11119b.remove(str + "downloadrate");
        }
        ConcurrentLoginRequest concurrentLoginRequest = (ConcurrentLoginRequest) user.mo1713a(new ConcurrentLoginRequest(0, 0));
        if (concurrentLoginRequest != null) {
            this.f11119b.setProperty(str + "maxloginnumber", concurrentLoginRequest.m1701c());
            this.f11119b.setProperty(str + "maxloginperip", concurrentLoginRequest.m1700d());
        } else {
            this.f11119b.remove(str + "maxloginnumber");
            this.f11119b.remove(str + "maxloginperip");
        }
        m1694b();
    }

    /* renamed from: b */
    private void m1694b() throws FtpException {
        FileOutputStream fileOutputStream;
        Throwable th;
        IOException e;
        File file = this.f11120c;
        if (file == null) {
            return;
        }
        File parentFile = file.getAbsoluteFile().getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new FtpServerConfigurationException("Cannot create directory for user data file : " + parentFile.getAbsolutePath());
        }
        try {
            fileOutputStream = new FileOutputStream(this.f11120c);
        } catch (IOException e2) {
            fileOutputStream = null;
            e = e2;
        } catch (Throwable th2) {
            fileOutputStream = null;
            th = th2;
            IoUtils.m1661b(fileOutputStream);
            throw th;
        }
        try {
            try {
                this.f11119b.store(fileOutputStream, "Generated file - don't edit (please)");
                IoUtils.m1661b(fileOutputStream);
            } catch (Throwable th3) {
                th = th3;
                IoUtils.m1661b(fileOutputStream);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            this.f11118a.error("Failed saving user data", (Throwable) e);
            throw new FtpException("Failed saving user data", e);
        }
    }

    /* renamed from: b */
    private String m1692b(User user) {
        String mo1717a = user.mo1717a();
        String mo1711b = user.mo1711b();
        if (mo1711b != null) {
            return m1719a().mo1682a(mo1711b);
        }
        String mo1682a = m1719a().mo1682a("");
        if (mo1693b(mo1717a)) {
            return this.f11119b.getProperty("ftpserver.user." + mo1717a + ".userpassword", mo1682a);
        }
        return mo1682a;
    }

    @Override // org.apache.ftpserver.ftplet.UserManager
    /* renamed from: a */
    public User mo1698a(String str) {
        if (mo1693b(str)) {
            String str2 = "ftpserver.user." + str + '.';
            BaseUser baseUser = new BaseUser();
            baseUser.m1715a(str);
            baseUser.m1712a(this.f11119b.getBoolean(str2 + "enableflag", true));
            baseUser.m1708c(this.f11119b.getProperty(str2 + "homedirectory", "/"));
            ArrayList arrayList = new ArrayList();
            if (this.f11119b.getBoolean(str2 + "writepermission", false)) {
                arrayList.add(new WritePermission());
            }
            arrayList.add(new ConcurrentLoginPermission(this.f11119b.getInteger(str2 + "maxloginnumber", 0), this.f11119b.getInteger(str2 + "maxloginperip", 0)));
            arrayList.add(new TransferRatePermission(this.f11119b.getInteger(str2 + "downloadrate", 0), this.f11119b.getInteger(str2 + "uploadrate", 0)));
            baseUser.m1714a(arrayList);
            baseUser.m1716a(this.f11119b.getInteger(str2 + "idletime", 0));
            return baseUser;
        }
        return null;
    }

    @Override // org.apache.ftpserver.ftplet.UserManager
    /* renamed from: b */
    public boolean mo1693b(String str) {
        return this.f11119b.containsKey("ftpserver.user." + str + ".homedirectory");
    }

    @Override // org.apache.ftpserver.ftplet.UserManager
    /* renamed from: a */
    public User mo1696a(Authentication authentication) throws AuthenticationFailedException {
        if (authentication instanceof UsernamePasswordAuthentication) {
            UsernamePasswordAuthentication usernamePasswordAuthentication = (UsernamePasswordAuthentication) authentication;
            String m1678b = usernamePasswordAuthentication.m1678b();
            String m1679a = usernamePasswordAuthentication.m1679a();
            if (m1678b == null) {
                throw new AuthenticationFailedException("Authentication failed");
            }
            if (m1679a == null) {
                m1679a = "";
            }
            BaseProperties baseProperties = this.f11119b;
            String property = baseProperties.getProperty("ftpserver.user." + m1678b + ".userpassword");
            if (property == null) {
                throw new AuthenticationFailedException("Authentication failed");
            }
            if (m1719a().mo1681a(m1679a, property)) {
                return mo1698a(m1678b);
            }
            throw new AuthenticationFailedException("Authentication failed");
        } else if (authentication instanceof AnonymousAuthentication) {
            if (mo1693b("anonymous")) {
                return mo1698a("anonymous");
            }
            throw new AuthenticationFailedException("Authentication failed");
        } else {
            throw new IllegalArgumentException("Authentication not supported by this user manager");
        }
    }
}
