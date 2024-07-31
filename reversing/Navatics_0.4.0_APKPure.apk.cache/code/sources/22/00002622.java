package org.apache.ftpserver.p112g;

import org.apache.ftpserver.ftplet.InterfaceC3155a;
import org.apache.ftpserver.p112g.p113a.UserMetadata;

/* compiled from: UsernamePasswordAuthentication.java */
/* renamed from: org.apache.ftpserver.g.e, reason: use source file name */
/* loaded from: classes2.dex */
public class UsernamePasswordAuthentication implements InterfaceC3155a {

    /* renamed from: a */
    private String f11175a;

    /* renamed from: b */
    private String f11176b;

    /* renamed from: c */
    private UserMetadata f11177c;

    public UsernamePasswordAuthentication(String str, String str2) {
        this.f11175a = str;
        this.f11176b = str2;
    }

    public UsernamePasswordAuthentication(String str, String str2, UserMetadata userMetadata) {
        this(str, str2);
        this.f11177c = userMetadata;
    }

    /* renamed from: a */
    public String m11192a() {
        return this.f11176b;
    }

    /* renamed from: b */
    public String m11193b() {
        return this.f11175a;
    }
}