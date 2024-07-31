package org.apache.ftpserver.p123g.p124a;

import org.apache.ftpserver.ftplet.AuthorizationRequest;

/* renamed from: org.apache.ftpserver.g.a.d */
/* loaded from: classes2.dex */
public class ConcurrentLoginRequest implements AuthorizationRequest {

    /* renamed from: a */
    private final int f11114a;

    /* renamed from: b */
    private final int f11115b;

    /* renamed from: c */
    private int f11116c = 0;

    /* renamed from: d */
    private int f11117d = 0;

    public ConcurrentLoginRequest(int i, int i2) {
        this.f11114a = i;
        this.f11115b = i2;
    }

    /* renamed from: a */
    public int m1705a() {
        return this.f11114a;
    }

    /* renamed from: b */
    public int m1703b() {
        return this.f11115b;
    }

    /* renamed from: c */
    public int m1701c() {
        return this.f11116c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m1704a(int i) {
        this.f11116c = i;
    }

    /* renamed from: d */
    public int m1700d() {
        return this.f11117d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m1702b(int i) {
        this.f11117d = i;
    }
}
