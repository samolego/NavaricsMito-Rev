package org.apache.ftpserver.p110a.p111a.p112a;

import java.util.StringTokenizer;
import org.slf4j.Marker;

/* renamed from: org.apache.ftpserver.a.a.a.f */
/* loaded from: classes2.dex */
public class ListArgumentParser {
    /* renamed from: a */
    public static ListArgument m1985a(String str) {
        String str2;
        str2 = "./";
        String str3 = "";
        String str4 = Marker.ANY_MARKER;
        if (str != null) {
            String trim = str.trim();
            StringBuilder sb = new StringBuilder(4);
            StringBuilder sb2 = new StringBuilder(16);
            StringTokenizer stringTokenizer = new StringTokenizer(trim, " ", true);
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                if (sb2.length() != 0) {
                    sb2.append(nextToken);
                } else if (!nextToken.equals(" ")) {
                    if (nextToken.charAt(0) == '-') {
                        if (nextToken.length() > 1) {
                            sb.append(nextToken.substring(1));
                        }
                    } else {
                        sb2.append(nextToken);
                    }
                }
            }
            str2 = sb2.length() != 0 ? sb2.toString() : "./";
            str3 = sb.toString();
        }
        int lastIndexOf = str2.lastIndexOf(47);
        if (lastIndexOf == -1) {
            if (m1984b(str2)) {
                str4 = str2;
                str2 = "./";
            }
        } else if (lastIndexOf != str2.length() - 1) {
            int i = lastIndexOf + 1;
            if (m1984b(str2.substring(i))) {
                str4 = str2.substring(i);
                str2 = str2.substring(0, i);
            }
            if (m1984b(str2)) {
                throw new IllegalArgumentException("Directory path can not contain regular expression");
            }
        }
        return new ListArgument(str2, (Marker.ANY_MARKER.equals(str4) || "".equals(str4)) ? null : null, str3.toCharArray());
    }

    /* renamed from: b */
    private static boolean m1984b(String str) {
        return str.indexOf(42) > -1 || str.indexOf(63) > -1 || str.indexOf(91) > -1;
    }
}
