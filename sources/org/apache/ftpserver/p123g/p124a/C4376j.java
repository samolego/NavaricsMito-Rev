package org.apache.ftpserver.p123g.p124a;

import org.apache.ftpserver.ftplet.AuthorizationRequest;

/* renamed from: org.apache.ftpserver.g.a.j */
/* loaded from: classes2.dex */
public class WriteRequest implements AuthorizationRequest {

    /* renamed from: a */
    private String f11129a;

    public WriteRequest() {
        this("/");
    }

    public WriteRequest(String str) {
        this.f11129a = str;
    }

    /* renamed from: a */
    public String m1683a() {
        return this.f11129a;
    }
}
