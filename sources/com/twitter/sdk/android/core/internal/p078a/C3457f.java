package com.twitter.sdk.android.core.internal.p078a;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.TreeMap;

/* renamed from: com.twitter.sdk.android.core.internal.a.f */
/* loaded from: classes2.dex */
public final class UrlUtils {
    /* renamed from: a */
    public static TreeMap<String, String> m4486a(URI uri, boolean z) {
        return m4487a(uri.getRawQuery(), z);
    }

    /* renamed from: a */
    public static TreeMap<String, String> m4487a(String str, boolean z) {
        TreeMap<String, String> treeMap = new TreeMap<>();
        if (str == null) {
            return treeMap;
        }
        for (String str2 : str.split("&")) {
            String[] split = str2.split("=");
            if (split.length == 2) {
                if (z) {
                    treeMap.put(m4485b(split[0]), m4485b(split[1]));
                } else {
                    treeMap.put(split[0], split[1]);
                }
            } else if (!TextUtils.isEmpty(split[0])) {
                if (z) {
                    treeMap.put(m4485b(split[0]), "");
                } else {
                    treeMap.put(split[0], "");
                }
            }
        }
        return treeMap;
    }

    /* renamed from: a */
    public static String m4488a(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /* renamed from: b */
    public static String m4485b(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLDecoder.decode(str, "UTF8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /* renamed from: c */
    public static String m4484c(String str) {
        int i;
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String m4488a = m4488a(str);
        int length = m4488a.length();
        int i2 = 0;
        while (i2 < length) {
            char charAt = m4488a.charAt(i2);
            if (charAt == '*') {
                sb.append("%2A");
            } else if (charAt == '+') {
                sb.append("%20");
            } else if (charAt == '%' && (i = i2 + 2) < length && m4488a.charAt(i2 + 1) == '7' && m4488a.charAt(i) == 'E') {
                sb.append('~');
                i2 = i;
            } else {
                sb.append(charAt);
            }
            i2++;
        }
        return sb.toString();
    }
}
