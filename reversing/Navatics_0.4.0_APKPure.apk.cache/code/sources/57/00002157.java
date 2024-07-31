package com.twitter.sdk.android.core.internal;

import android.net.Uri;
import android.os.Build;
import java.text.Normalizer;

/* compiled from: TwitterApi.java */
/* renamed from: com.twitter.sdk.android.core.internal.n, reason: use source file name */
/* loaded from: classes2.dex */
public class TwitterApi {

    /* renamed from: a */
    private final String f8578a;

    public TwitterApi() {
        this("https://api.twitter.com");
    }

    public TwitterApi(String str) {
        this.f8578a = str;
    }

    /* renamed from: a */
    public String m8441a() {
        return this.f8578a;
    }

    /* renamed from: a */
    public Uri.Builder m8440a(String... strArr) {
        Uri.Builder buildUpon = Uri.parse(m8441a()).buildUpon();
        if (strArr != null) {
            for (String str : strArr) {
                buildUpon.appendPath(str);
            }
        }
        return buildUpon;
    }

    /* renamed from: a */
    public static String m8438a(String str, String str2) {
        return m8437a(str + '/' + str2 + ' ' + Build.MODEL + '/' + Build.VERSION.RELEASE + " (" + Build.MANUFACTURER + ';' + Build.MODEL + ';' + Build.BRAND + ';' + Build.PRODUCT + ')');
    }

    /* renamed from: a */
    static String m8437a(String str) {
        return m8439b(Normalizer.normalize(str, Normalizer.Form.NFD));
    }

    /* renamed from: b */
    static String m8439b(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt > 31 && charAt < 127) {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }
}