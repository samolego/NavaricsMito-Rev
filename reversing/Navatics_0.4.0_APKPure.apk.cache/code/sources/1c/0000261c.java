package org.apache.ftpserver.p112g.p113a;

import java.net.InetAddress;
import java.security.cert.Certificate;

/* compiled from: UserMetadata.java */
/* renamed from: org.apache.ftpserver.g.a.h, reason: use source file name */
/* loaded from: classes2.dex */
public class UserMetadata {

    /* renamed from: a */
    private Certificate[] f11167a;

    /* renamed from: b */
    private InetAddress f11168b;

    /* renamed from: a */
    public void m11187a(Certificate[] certificateArr) {
        if (certificateArr != null) {
            this.f11167a = (Certificate[]) certificateArr.clone();
        } else {
            this.f11167a = null;
        }
    }

    /* renamed from: a */
    public void m11186a(InetAddress inetAddress) {
        this.f11168b = inetAddress;
    }
}