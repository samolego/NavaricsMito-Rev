package org.apache.ftpserver.util;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

/* compiled from: SocketAddressEncoder.java */
/* renamed from: org.apache.ftpserver.util.e, reason: use source file name */
/* loaded from: classes2.dex */
public class SocketAddressEncoder {
    /* renamed from: b */
    private static int m11216b(String str) {
        int parseInt = Integer.parseInt(str);
        if (parseInt < 0) {
            throw new IllegalArgumentException("Token can not be less than 0");
        }
        if (parseInt <= 255) {
            return parseInt;
        }
        throw new IllegalArgumentException("Token can not be larger than 255");
    }

    /* renamed from: a */
    public static InetSocketAddress m11215a(String str) throws UnknownHostException {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        if (stringTokenizer.countTokens() != 6) {
            throw new IllegalInetAddressException("Illegal amount of tokens");
        }
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(m11216b(stringTokenizer.nextToken()));
            sb.append('.');
            sb.append(m11216b(stringTokenizer.nextToken()));
            sb.append('.');
            sb.append(m11216b(stringTokenizer.nextToken()));
            sb.append('.');
            sb.append(m11216b(stringTokenizer.nextToken()));
            try {
                return new InetSocketAddress(InetAddress.getByName(sb.toString()), m11216b(stringTokenizer.nextToken()) | (m11216b(stringTokenizer.nextToken()) << 8));
            } catch (IllegalArgumentException unused) {
                throw new IllegalPortException("Invalid data port: " + str);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalInetAddressException(e.getMessage());
        }
    }

    /* renamed from: a */
    public static String m11214a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        int port = inetSocketAddress.getPort();
        return address.getHostAddress().replace('.', ',') + ',' + (port >> 8) + ',' + (port & 255);
    }
}