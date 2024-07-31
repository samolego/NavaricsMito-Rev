package org.apache.ftpserver.util;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

/* renamed from: org.apache.ftpserver.util.e */
/* loaded from: classes2.dex */
public class SocketAddressEncoder {
    /* renamed from: b */
    private static int m1656b(String str) {
        int parseInt = Integer.parseInt(str);
        if (parseInt >= 0) {
            if (parseInt <= 255) {
                return parseInt;
            }
            throw new IllegalArgumentException("Token can not be larger than 255");
        }
        throw new IllegalArgumentException("Token can not be less than 0");
    }

    /* renamed from: a */
    public static InetSocketAddress m1658a(String str) throws UnknownHostException {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        if (stringTokenizer.countTokens() != 6) {
            throw new IllegalInetAddressException("Illegal amount of tokens");
        }
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(m1656b(stringTokenizer.nextToken()));
            sb.append('.');
            sb.append(m1656b(stringTokenizer.nextToken()));
            sb.append('.');
            sb.append(m1656b(stringTokenizer.nextToken()));
            sb.append('.');
            sb.append(m1656b(stringTokenizer.nextToken()));
            InetAddress byName = InetAddress.getByName(sb.toString());
            try {
                int m1656b = m1656b(stringTokenizer.nextToken());
                return new InetSocketAddress(byName, m1656b(stringTokenizer.nextToken()) | (m1656b << 8));
            } catch (IllegalArgumentException unused) {
                throw new IllegalPortException("Invalid data port: " + str);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalInetAddressException(e.getMessage());
        }
    }

    /* renamed from: a */
    public static String m1657a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        int port = inetSocketAddress.getPort();
        return address.getHostAddress().replace('.', ',') + ',' + (port >> 8) + ',' + (port & 255);
    }
}
