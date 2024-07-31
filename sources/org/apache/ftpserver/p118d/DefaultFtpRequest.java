package org.apache.ftpserver.p118d;

import org.apache.ftpserver.ftplet.FtpRequest;

/* renamed from: org.apache.ftpserver.d.d */
/* loaded from: classes2.dex */
public class DefaultFtpRequest implements FtpRequest {

    /* renamed from: a */
    private final String f10985a;

    /* renamed from: b */
    private final String f10986b;

    /* renamed from: c */
    private final String f10987c;

    /* renamed from: d */
    private final long f10988d = System.currentTimeMillis();

    public DefaultFtpRequest(String str) {
        this.f10985a = str.trim();
        int indexOf = this.f10985a.indexOf(32);
        this.f10986b = m1935a(this.f10985a, indexOf);
        this.f10987c = m1934b(this.f10985a, indexOf);
    }

    /* renamed from: a */
    private String m1935a(String str, int i) {
        String upperCase;
        if (i != -1) {
            upperCase = this.f10985a.substring(0, i).toUpperCase();
        } else {
            upperCase = this.f10985a.toUpperCase();
        }
        return (upperCase.length() <= 0 || upperCase.charAt(0) != 'X') ? upperCase : upperCase.substring(1);
    }

    /* renamed from: b */
    private String m1934b(String str, int i) {
        if (i != -1) {
            String substring = this.f10985a.substring(i + 1);
            if (substring.equals("")) {
                return null;
            }
            return substring;
        }
        return null;
    }

    @Override // org.apache.ftpserver.ftplet.FtpRequest
    /* renamed from: b */
    public String mo1749b() {
        return this.f10986b;
    }

    @Override // org.apache.ftpserver.ftplet.FtpRequest
    /* renamed from: c */
    public String mo1748c() {
        return this.f10987c;
    }

    @Override // org.apache.ftpserver.ftplet.FtpRequest
    /* renamed from: a */
    public String mo1750a() {
        return this.f10985a;
    }

    @Override // org.apache.ftpserver.ftplet.FtpRequest
    /* renamed from: d */
    public boolean mo1747d() {
        return mo1748c() != null;
    }

    public String toString() {
        return mo1750a();
    }
}
