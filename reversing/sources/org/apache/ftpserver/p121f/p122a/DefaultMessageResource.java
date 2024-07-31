package org.apache.ftpserver.p121f.p122a;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.ftpserver.FtpServerConfigurationException;
import org.apache.ftpserver.p121f.MessageResource;
import org.apache.ftpserver.util.IoUtils;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.f.a.a */
/* loaded from: classes2.dex */
public class DefaultMessageResource implements MessageResource {

    /* renamed from: a */
    private final InterfaceC3153b f11090a = C3154c.m262a(DefaultMessageResource.class);

    /* renamed from: b */
    private final List<String> f11091b;

    /* renamed from: c */
    private final Map<String, C3029a> f11092c;

    public DefaultMessageResource(List<String> list, File file) {
        if (list != null) {
            this.f11091b = Collections.unmodifiableList(list);
        } else {
            this.f11091b = null;
        }
        this.f11092c = new HashMap();
        if (list != null) {
            for (String str : list) {
                this.f11092c.put(str, m1786a(str, file));
            }
        }
        this.f11092c.put(null, m1786a(null, file));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefaultMessageResource.java */
    /* renamed from: org.apache.ftpserver.f.a.a$a */
    /* loaded from: classes2.dex */
    public static class C3029a {

        /* renamed from: a */
        public Properties f11093a;

        /* renamed from: b */
        public Properties f11094b;

        private C3029a() {
            this.f11093a = new Properties();
            this.f11094b = new Properties();
        }
    }

    /* renamed from: a */
    private C3029a m1786a(String str, File file) {
        String str2;
        InputStream inputStream;
        File file2;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        C3029a c3029a = new C3029a();
        if (str == null) {
            str2 = "org/apache/ftpserver/message/FtpStatus.properties";
        } else {
            str2 = "org/apache/ftpserver/message/FtpStatus_" + str + ".properties";
        }
        try {
            inputStream = getClass().getClassLoader().getResourceAsStream(str2);
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            if (inputStream != null) {
                try {
                    c3029a.f11093a.load(inputStream);
                    IoUtils.m1662b(inputStream);
                    if (str == null) {
                        file2 = new File(file, "FtpStatus.gen");
                    } else {
                        file2 = new File(file, "FtpStatus_" + str + ".gen");
                    }
                    try {
                        try {
                            if (file2.exists()) {
                                fileInputStream = new FileInputStream(file2);
                                try {
                                    c3029a.f11094b.load(fileInputStream);
                                } catch (Exception e) {
                                    e = e;
                                    fileInputStream2 = fileInputStream;
                                    this.f11090a.warn("MessageResourceImpl.createPropertiesPair()", (Throwable) e);
                                    throw new FtpServerConfigurationException("MessageResourceImpl.createPropertiesPair()", e);
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileInputStream2 = fileInputStream;
                                    IoUtils.m1662b(fileInputStream2);
                                    throw th;
                                }
                            } else {
                                fileInputStream = null;
                            }
                            IoUtils.m1662b(fileInputStream);
                            return c3029a;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (IOException unused) {
                    throw new FtpServerConfigurationException("Failed to load messages from \"" + str2 + "\", file not found in classpath");
                }
            } else {
                throw new FtpServerConfigurationException("Failed to load messages from \"" + str2 + "\", file not found in classpath");
            }
        } catch (Throwable th4) {
            th = th4;
            IoUtils.m1662b(inputStream);
            throw th;
        }
    }

    @Override // org.apache.ftpserver.p121f.MessageResource
    /* renamed from: a */
    public List<String> mo1788a() {
        List<String> list = this.f11091b;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    @Override // org.apache.ftpserver.p121f.MessageResource
    /* renamed from: a */
    public String mo1787a(int i, String str, String str2) {
        String str3;
        C3029a c3029a;
        String valueOf = String.valueOf(i);
        if (str != null) {
            valueOf = valueOf + '.' + str;
        }
        if (str2 != null) {
            C3029a c3029a2 = this.f11092c.get(str2.toLowerCase());
            if (c3029a2 != null) {
                String property = c3029a2.f11094b.getProperty(valueOf);
                str3 = property == null ? c3029a2.f11093a.getProperty(valueOf) : property;
                if (str3 != null && (c3029a = this.f11092c.get(null)) != null) {
                    String property2 = c3029a.f11094b.getProperty(valueOf);
                    return property2 == null ? c3029a.f11093a.getProperty(valueOf) : property2;
                }
            }
        }
        str3 = null;
        return str3 != null ? str3 : str3;
    }
}
