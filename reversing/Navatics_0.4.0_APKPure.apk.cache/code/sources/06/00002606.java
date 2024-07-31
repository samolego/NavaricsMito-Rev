package org.apache.ftpserver.ftplet;

/* compiled from: DefaultFtpReply.java */
/* renamed from: org.apache.ftpserver.ftplet.g, reason: use source file name */
/* loaded from: classes2.dex */
public class DefaultFtpReply implements InterfaceC3166l {

    /* renamed from: a */
    private int f11141a;

    /* renamed from: b */
    private String f11142b;

    /* renamed from: c */
    private long f11143c;

    /* renamed from: a */
    private boolean m11151a(char c) {
        return c >= '0' && c <= '9';
    }

    public DefaultFtpReply(int i, String str) {
        this.f11143c = 0L;
        this.f11141a = i;
        this.f11142b = str;
        this.f11143c = System.currentTimeMillis();
    }

    /* renamed from: a */
    public int m11152a() {
        return this.f11141a;
    }

    /* renamed from: b */
    public String m11153b() {
        return this.f11142b;
    }

    public String toString() {
        int m11152a = m11152a();
        String m11153b = m11153b();
        if (m11153b == null) {
            m11153b = "";
        }
        StringBuilder sb = new StringBuilder();
        String replace = m11153b.replace("\r", "");
        if (replace.endsWith("\n")) {
            replace = replace.substring(0, replace.length() - 1);
        }
        String[] split = replace.split("\n");
        if (split.length == 1) {
            sb.append(m11152a);
            sb.append(" ");
            sb.append(replace);
            sb.append("\r\n");
        } else {
            sb.append(m11152a);
            sb.append("-");
            int i = 0;
            while (i < split.length) {
                String str = split[i];
                int i2 = i + 1;
                if (i2 == split.length) {
                    sb.append(m11152a);
                    sb.append(" ");
                }
                if (i > 0 && i2 < split.length && str.length() > 2 && m11151a(str.charAt(0)) && m11151a(str.charAt(1)) && m11151a(str.charAt(2))) {
                    sb.append("  ");
                }
                sb.append(str);
                sb.append("\r\n");
                i = i2;
            }
        }
        return sb.toString();
    }
}