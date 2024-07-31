package org.apache.ftpserver.p123g.p124a;

import org.apache.ftpserver.ftplet.Authority;
import org.apache.ftpserver.ftplet.AuthorizationRequest;

/* renamed from: org.apache.ftpserver.g.a.c */
/* loaded from: classes2.dex */
public class ConcurrentLoginPermission implements Authority {

    /* renamed from: a */
    private final int f11112a;

    /* renamed from: b */
    private final int f11113b;

    public ConcurrentLoginPermission(int i, int i2) {
        this.f11112a = i;
        this.f11113b = i2;
    }

    @Override // org.apache.ftpserver.ftplet.Authority
    /* renamed from: b */
    public AuthorizationRequest mo1684b(AuthorizationRequest authorizationRequest) {
        if (authorizationRequest instanceof ConcurrentLoginRequest) {
            ConcurrentLoginRequest concurrentLoginRequest = (ConcurrentLoginRequest) authorizationRequest;
            int i = this.f11112a;
            if (i == 0 || i >= concurrentLoginRequest.m1705a()) {
                int i2 = this.f11113b;
                if (i2 == 0 || i2 >= concurrentLoginRequest.m1703b()) {
                    concurrentLoginRequest.m1704a(this.f11112a);
                    concurrentLoginRequest.m1702b(this.f11113b);
                    return concurrentLoginRequest;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    @Override // org.apache.ftpserver.ftplet.Authority
    /* renamed from: a */
    public boolean mo1685a(AuthorizationRequest authorizationRequest) {
        return authorizationRequest instanceof ConcurrentLoginRequest;
    }
}
