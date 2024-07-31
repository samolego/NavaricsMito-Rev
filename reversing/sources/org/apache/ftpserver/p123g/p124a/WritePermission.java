package org.apache.ftpserver.p123g.p124a;

import org.apache.ftpserver.ftplet.Authority;
import org.apache.ftpserver.ftplet.AuthorizationRequest;

/* renamed from: org.apache.ftpserver.g.a.i */
/* loaded from: classes2.dex */
public class WritePermission implements Authority {

    /* renamed from: a */
    private String f11128a = "/";

    @Override // org.apache.ftpserver.ftplet.Authority
    /* renamed from: b */
    public AuthorizationRequest mo1684b(AuthorizationRequest authorizationRequest) {
        if (authorizationRequest instanceof WriteRequest) {
            WriteRequest writeRequest = (WriteRequest) authorizationRequest;
            if (writeRequest.m1683a().startsWith(this.f11128a)) {
                return writeRequest;
            }
            return null;
        }
        return null;
    }

    @Override // org.apache.ftpserver.ftplet.Authority
    /* renamed from: a */
    public boolean mo1685a(AuthorizationRequest authorizationRequest) {
        return authorizationRequest instanceof WriteRequest;
    }
}
