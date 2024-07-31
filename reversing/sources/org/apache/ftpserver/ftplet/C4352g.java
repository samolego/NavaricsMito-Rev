package org.apache.ftpserver.ftplet;

/* renamed from: org.apache.ftpserver.ftplet.g */
/* loaded from: classes2.dex */
public class DefaultFtpReply implements FtpReply {

    /* renamed from: a */
    private int f11100a;

    /* renamed from: b */
    private String f11101b;

    /* renamed from: c */
    private long f11102c;

    /* renamed from: a */
    private boolean m1778a(char c) {
        return c >= '0' && c <= '9';
    }

    public DefaultFtpReply(int i, String str) {
        this.f11102c = 0L;
        this.f11100a = i;
        this.f11101b = str;
        this.f11102c = System.currentTimeMillis();
    }

    /* renamed from: a */
    public int m1779a() {
        return this.f11100a;
    }

    /* renamed from: b */
    public String m1777b() {
        return this.f11101b;
    }

    public String toString() {
        int m1779a = m1779a();
        String m1777b = m1777b();
        if (m1777b == null) {
            m1777b = "";
        }
        StringBuilder sb = new StringBuilder();
        String replace = m1777b.replace("\r", "");
        if (replace.endsWith("\n")) {
            replace = replace.substring(0, replace.length() - 1);
        }
        String[] split = replace.split("\n");
        if (split.length == 1) {
            sb.append(m1779a);
            sb.append(" ");
            sb.append(replace);
            sb.append("\r\n");
        } else {
            sb.append(m1779a);
            sb.append("-");
            int i = 0;
            while (i < split.length) {
                String str = split[i];
                int i2 = i + 1;
                if (i2 == split.length) {
                    sb.append(m1779a);
                    sb.append(" ");
                }
                if (i > 0 && i2 < split.length && str.length() > 2 && m1778a(str.charAt(0)) && m1778a(str.charAt(1)) && m1778a(str.charAt(2))) {
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
