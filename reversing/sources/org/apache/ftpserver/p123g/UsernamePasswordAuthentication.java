package org.apache.ftpserver.p123g;

import org.apache.ftpserver.ftplet.Authentication;
import org.apache.ftpserver.p123g.p124a.UserMetadata;

/* renamed from: org.apache.ftpserver.g.e */
/* loaded from: classes2.dex */
public class UsernamePasswordAuthentication implements Authentication {

    /* renamed from: a */
    private String f11134a;

    /* renamed from: b */
    private String f11135b;

    /* renamed from: c */
    private UserMetadata f11136c;

    public UsernamePasswordAuthentication(String str, String str2) {
        this.f11134a = str;
        this.f11135b = str2;
    }

    public UsernamePasswordAuthentication(String str, String str2, UserMetadata userMetadata) {
        this(str, str2);
        this.f11136c = userMetadata;
    }

    /* renamed from: a */
    public String m1679a() {
        return this.f11135b;
    }

    /* renamed from: b */
    public String m1678b() {
        return this.f11134a;
    }
}
