package com.twitter.sdk.android.core.internal;

import android.net.Uri;
import android.os.Build;
import java.text.Normalizer;

/* renamed from: com.twitter.sdk.android.core.internal.n */
/* loaded from: classes2.dex */
public class TwitterApi {

    /* renamed from: a */
    private final String f8538a;

    public TwitterApi() {
        this("https://api.twitter.com");
    }

    public TwitterApi(String str) {
        this.f8538a = str;
    }

    /* renamed from: a */
    public String m4426a() {
        return this.f8538a;
    }

    /* renamed from: a */
    public Uri.Builder m4423a(String... strArr) {
        Uri.Builder buildUpon = Uri.parse(m4426a()).buildUpon();
        if (strArr != null) {
            for (String str : strArr) {
                buildUpon.appendPath(str);
            }
        }
        return buildUpon;
    }

    /* renamed from: a */
    public static String m4424a(String str, String str2) {
        return m4425a(str + '/' + str2 + ' ' + Build.MODEL + '/' + Build.VERSION.RELEASE + " (" + Build.MANUFACTURER + ';' + Build.MODEL + ';' + Build.BRAND + ';' + Build.PRODUCT + ')');
    }

    /* renamed from: a */
    static String m4425a(String str) {
        return m4422b(Normalizer.normalize(str, Normalizer.Form.NFD));
    }

    /* renamed from: b */
    static String m4422b(String str) {
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
