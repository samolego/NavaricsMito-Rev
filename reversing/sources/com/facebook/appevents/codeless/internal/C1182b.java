package com.facebook.appevents.codeless.internal;

import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;

/* renamed from: com.facebook.appevents.codeless.internal.b */
/* loaded from: classes.dex */
public class SensitiveUserDataUtils {
    /* renamed from: a */
    public static boolean m11118a(View view) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            return m11117a(textView) || m11112f(textView) || m11115c(textView) || m11114d(textView) || m11113e(textView) || m11116b(textView);
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m11117a(TextView textView) {
        if (textView.getInputType() == 128) {
            return true;
        }
        return textView.getTransformationMethod() instanceof PasswordTransformationMethod;
    }

    /* renamed from: b */
    private static boolean m11116b(TextView textView) {
        if (textView.getInputType() == 32) {
            return true;
        }
        String m11099e = ViewHierarchy.m11099e(textView);
        if (m11099e == null || m11099e.length() == 0) {
            return false;
        }
        return Patterns.EMAIL_ADDRESS.matcher(m11099e).matches();
    }

    /* renamed from: c */
    private static boolean m11115c(TextView textView) {
        return textView.getInputType() == 96;
    }

    /* renamed from: d */
    private static boolean m11114d(TextView textView) {
        return textView.getInputType() == 112;
    }

    /* renamed from: e */
    private static boolean m11113e(TextView textView) {
        return textView.getInputType() == 3;
    }

    /* renamed from: f */
    private static boolean m11112f(TextView textView) {
        String replaceAll = ViewHierarchy.m11099e(textView).replaceAll("\\s", "");
        int length = replaceAll.length();
        if (length < 12 || length > 19) {
            return false;
        }
        int i = 0;
        boolean z = false;
        for (int i2 = length - 1; i2 >= 0; i2--) {
            char charAt = replaceAll.charAt(i2);
            if (charAt < '0' || charAt > '9') {
                return false;
            }
            int i3 = charAt - '0';
            if (z && (i3 = i3 * 2) > 9) {
                i3 = (i3 % 10) + 1;
            }
            i += i3;
            z = !z;
        }
        return i % 10 == 0;
    }
}
