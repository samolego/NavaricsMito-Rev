package org.apache.ftpserver.p123g.p124a;

import org.apache.ftpserver.ftplet.Authority;
import org.apache.ftpserver.ftplet.AuthorizationRequest;

/* renamed from: org.apache.ftpserver.g.a.f */
/* loaded from: classes2.dex */
public class TransferRatePermission implements Authority {

    /* renamed from: a */
    private int f11122a;

    /* renamed from: b */
    private int f11123b;

    public TransferRatePermission(int i, int i2) {
        this.f11122a = i;
        this.f11123b = i2;
    }

    @Override // org.apache.ftpserver.ftplet.Authority
    /* renamed from: b */
    public AuthorizationRequest mo1684b(AuthorizationRequest authorizationRequest) {
        if (authorizationRequest instanceof TransferRateRequest) {
            TransferRateRequest transferRateRequest = (TransferRateRequest) authorizationRequest;
            transferRateRequest.m1690a(this.f11122a);
            transferRateRequest.m1688b(this.f11123b);
            return transferRateRequest;
        }
        return null;
    }

    @Override // org.apache.ftpserver.ftplet.Authority
    /* renamed from: a */
    public boolean mo1685a(AuthorizationRequest authorizationRequest) {
        return authorizationRequest instanceof TransferRateRequest;
    }
}
