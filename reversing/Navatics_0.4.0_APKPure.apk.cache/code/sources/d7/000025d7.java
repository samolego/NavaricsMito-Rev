package org.apache.ftpserver.p107d;

import org.apache.ftpserver.ftplet.InterfaceC3167m;

/* compiled from: DefaultFtpRequest.java */
/* renamed from: org.apache.ftpserver.d.d, reason: use source file name */
/* loaded from: classes2.dex */
public class DefaultFtpRequest implements InterfaceC3167m {

    /* renamed from: a */
    private final String f11026a;

    /* renamed from: b */
    private final String f11027b;

    /* renamed from: c */
    private final String f11028c;

    /* renamed from: d */
    private final long f11029d = System.currentTimeMillis();

    public DefaultFtpRequest(String str) {
        this.f11026a = str.trim();
        int indexOf = this.f11026a.indexOf(32);
        this.f11027b = m10934a(this.f11026a, indexOf);
        this.f11028c = m10935b(this.f11026a, indexOf);
    }

    /* renamed from: a */
    private String m10934a(String str, int i) {
        String upperCase;
        if (i != -1) {
            upperCase = this.f11026a.substring(0, i).toUpperCase();
        } else {
            upperCase = this.f11026a.toUpperCase();
        }
        return (upperCase.length() <= 0 || upperCase.charAt(0) != 'X') ? upperCase : upperCase.substring(1);
    }

    /* renamed from: b */
    private String m10935b(String str, int i) {
        if (i == -1) {
            return null;
        }
        String substring = this.f11026a.substring(i + 1);
        if (substring.equals("")) {
            return null;
        }
        return substring;
    }

    @Override // org.apache.ftpserver.ftplet.InterfaceC3167m
    /* renamed from: b */
    public String mo10937b() {
        return this.f11027b;
    }

    @Override // org.apache.ftpserver.ftplet.InterfaceC3167m
    /* renamed from: c */
    public String mo10938c() {
        return this.f11028c;
    }

    @Override // org.apache.ftpserver.ftplet.InterfaceC3167m
    /* renamed from: a */
    public String mo10936a() {
        return this.f11026a;
    }

    @Override // org.apache.ftpserver.ftplet.InterfaceC3167m
    /* renamed from: d */
    public boolean mo10939d() {
        return mo10938c() != null;
    }

    public String toString() {
        return mo10936a();
    }
}