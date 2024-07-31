package org.apache.ftpserver.ssl;

import java.security.GeneralSecurityException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: SslConfiguration.java */
/* renamed from: org.apache.ftpserver.ssl.a, reason: use source file name */
/* loaded from: classes2.dex */
public interface SslConfiguration {
    /* renamed from: a */
    SSLSocketFactory m11195a() throws GeneralSecurityException;

    /* renamed from: b */
    SSLContext m11196b() throws GeneralSecurityException;

    /* renamed from: c */
    String[] m11197c();

    /* renamed from: d */
    ClientAuth m11198d();
}