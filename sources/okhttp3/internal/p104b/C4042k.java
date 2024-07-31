package okhttp3.internal.p104b;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Protocol;

/* renamed from: okhttp3.internal.b.k */
/* loaded from: classes2.dex */
public final class StatusLine {

    /* renamed from: a */
    public final Protocol f10176a;

    /* renamed from: b */
    public final int f10177b;

    /* renamed from: c */
    public final String f10178c;

    public StatusLine(Protocol protocol, int i, String str) {
        this.f10176a = protocol;
        this.f10177b = i;
        this.f10178c = str;
    }

    /* renamed from: a */
    public static StatusLine m2901a(String str) throws IOException {
        Protocol protocol;
        int i = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                protocol = Protocol.HTTP_1_0;
            } else if (charAt == 1) {
                protocol = Protocol.HTTP_1_1;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            protocol = Protocol.HTTP_1_0;
            i = 4;
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        int i2 = i + 3;
        if (str.length() < i2) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            int parseInt = Integer.parseInt(str.substring(i, i2));
            String str2 = "";
            if (str.length() > i2) {
                if (str.charAt(i2) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                str2 = str.substring(i + 4);
            }
            return new StatusLine(protocol, parseInt, str2);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f10176a == Protocol.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f10177b);
        if (this.f10178c != null) {
            sb.append(' ');
            sb.append(this.f10178c);
        }
        return sb.toString();
    }
}
