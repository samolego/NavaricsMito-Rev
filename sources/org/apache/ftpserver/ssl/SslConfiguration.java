package org.apache.ftpserver.ssl;

import java.security.GeneralSecurityException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: org.apache.ftpserver.ssl.a */
/* loaded from: classes2.dex */
public interface SslConfiguration {
    /* renamed from: a */
    SSLSocketFactory m1677a() throws GeneralSecurityException;

    /* renamed from: b */
    SSLContext m1676b() throws GeneralSecurityException;

    /* renamed from: c */
    String[] m1675c();

    /* renamed from: d */
    ClientAuth m1674d();
}
