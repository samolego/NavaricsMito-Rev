package org.apache.ftpserver.p112g.p113a;

import org.apache.ftpserver.ftplet.AuthorizationRequest;

/* compiled from: ConcurrentLoginRequest.java */
/* renamed from: org.apache.ftpserver.g.a.d, reason: use source file name */
/* loaded from: classes2.dex */
public class ConcurrentLoginRequest implements AuthorizationRequest {

    /* renamed from: a */
    private final int f11155a;

    /* renamed from: b */
    private final int f11156b;

    /* renamed from: c */
    private int f11157c = 0;

    /* renamed from: d */
    private int f11158d = 0;

    public ConcurrentLoginRequest(int i, int i2) {
        this.f11155a = i;
        this.f11156b = i2;
    }

    /* renamed from: a */
    public int m11172a() {
        return this.f11155a;
    }

    /* renamed from: b */
    public int m11174b() {
        return this.f11156b;
    }

    /* renamed from: c */
    public int m11176c() {
        return this.f11157c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m11173a(int i) {
        this.f11157c = i;
    }

    /* renamed from: d */
    public int m11177d() {
        return this.f11158d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m11175b(int i) {
        this.f11158d = i;
    }
}