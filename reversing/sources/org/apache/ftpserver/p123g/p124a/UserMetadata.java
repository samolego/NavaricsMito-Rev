package org.apache.ftpserver.p123g.p124a;

import java.net.InetAddress;
import java.security.cert.Certificate;

/* renamed from: org.apache.ftpserver.g.a.h */
/* loaded from: classes2.dex */
public class UserMetadata {

    /* renamed from: a */
    private Certificate[] f11126a;

    /* renamed from: b */
    private InetAddress f11127b;

    /* renamed from: a */
    public void m1686a(Certificate[] certificateArr) {
        if (certificateArr != null) {
            this.f11126a = (Certificate[]) certificateArr.clone();
        } else {
            this.f11126a = null;
        }
    }

    /* renamed from: a */
    public void m1687a(InetAddress inetAddress) {
        this.f11127b = inetAddress;
    }
}
