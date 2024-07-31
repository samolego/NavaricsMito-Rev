package org.apache.ftpserver.p123g.p124a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.ftpserver.ftplet.Authority;
import org.apache.ftpserver.ftplet.AuthorizationRequest;
import org.apache.ftpserver.ftplet.User;

/* renamed from: org.apache.ftpserver.g.a.b */
/* loaded from: classes2.dex */
public class BaseUser implements User {

    /* renamed from: a */
    private String f11106a = null;

    /* renamed from: b */
    private String f11107b = null;

    /* renamed from: c */
    private int f11108c = 0;

    /* renamed from: d */
    private String f11109d = null;

    /* renamed from: e */
    private boolean f11110e = true;

    /* renamed from: f */
    private List<? extends Authority> f11111f = new ArrayList();

    @Override // org.apache.ftpserver.ftplet.User
    /* renamed from: a */
    public String mo1717a() {
        return this.f11106a;
    }

    /* renamed from: a */
    public void m1715a(String str) {
        this.f11106a = str;
    }

    @Override // org.apache.ftpserver.ftplet.User
    /* renamed from: b */
    public String mo1711b() {
        return this.f11107b;
    }

    /* renamed from: b */
    public void m1710b(String str) {
        this.f11107b = str;
    }

    /* renamed from: a */
    public void m1714a(List<Authority> list) {
        if (list != null) {
            this.f11111f = Collections.unmodifiableList(list);
        } else {
            this.f11111f = null;
        }
    }

    @Override // org.apache.ftpserver.ftplet.User
    /* renamed from: c */
    public int mo1709c() {
        return this.f11108c;
    }

    /* renamed from: a */
    public void m1716a(int i) {
        this.f11108c = i;
        if (this.f11108c < 0) {
            this.f11108c = 0;
        }
    }

    @Override // org.apache.ftpserver.ftplet.User
    /* renamed from: d */
    public boolean mo1707d() {
        return this.f11110e;
    }

    /* renamed from: a */
    public void m1712a(boolean z) {
        this.f11110e = z;
    }

    @Override // org.apache.ftpserver.ftplet.User
    /* renamed from: e */
    public String mo1706e() {
        return this.f11109d;
    }

    /* renamed from: c */
    public void m1708c(String str) {
        this.f11109d = str;
    }

    public String toString() {
        return this.f11106a;
    }

    @Override // org.apache.ftpserver.ftplet.User
    /* renamed from: a */
    public AuthorizationRequest mo1713a(AuthorizationRequest authorizationRequest) {
        List<? extends Authority> list = this.f11111f;
        if (list == null) {
            return null;
        }
        boolean z = false;
        for (Authority authority : list) {
            if (authority.mo1685a(authorizationRequest)) {
                z = true;
                authorizationRequest = authority.mo1684b(authorizationRequest);
                if (authorizationRequest == null) {
                    return null;
                }
            }
        }
        if (z) {
            return authorizationRequest;
        }
        return null;
    }
}
