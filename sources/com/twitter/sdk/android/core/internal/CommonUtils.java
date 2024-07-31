package com.twitter.sdk.android.core.internal;

import android.content.Context;
import android.content.res.Resources;
import com.twitter.sdk.android.core.Twitter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.twitter.sdk.android.core.internal.g */
/* loaded from: classes2.dex */
public class CommonUtils {

    /* renamed from: a */
    private static Boolean f8509a;

    /* renamed from: a */
    public static void m4448a(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    /* renamed from: a */
    public static void m4450a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m4449a(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                Twitter.m4253h().mo4556c("Twitter", str, e);
            }
        }
    }

    /* renamed from: a */
    static String m4456a(Context context) {
        int i = context.getApplicationContext().getApplicationInfo().icon;
        if (i > 0) {
            return context.getResources().getResourcePackageName(i);
        }
        return context.getPackageName();
    }

    /* renamed from: a */
    static int m4453a(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, m4456a(context));
    }

    /* renamed from: a */
    public static boolean m4451a(Context context, String str, boolean z) {
        Resources resources;
        if (context != null && (resources = context.getResources()) != null) {
            int m4453a = m4453a(context, str, "bool");
            if (m4453a > 0) {
                return resources.getBoolean(m4453a);
            }
            int m4453a2 = m4453a(context, str, "string");
            if (m4453a2 > 0) {
                return Boolean.parseBoolean(context.getString(m4453a2));
            }
        }
        return z;
    }

    /* renamed from: b */
    public static String m4445b(Context context, String str, String str2) {
        Resources resources;
        int m4453a;
        return (context == null || (resources = context.getResources()) == null || (m4453a = m4453a(context, str, "string")) <= 0) ? str2 : resources.getString(m4453a);
    }

    /* renamed from: b */
    static boolean m4446b(Context context) {
        if (f8509a == null) {
            f8509a = Boolean.valueOf(m4451a(context, "com.twitter.sdk.android.TRACE_ENABLED", false));
        }
        return f8509a.booleanValue();
    }

    /* renamed from: a */
    public static void m4454a(Context context, String str) {
        if (m4446b(context)) {
            Twitter.m4253h().mo4561a("Twitter", str);
        }
    }

    /* renamed from: a */
    public static void m4452a(Context context, String str, Throwable th) {
        if (m4446b(context)) {
            Twitter.m4253h().mo4557c("Twitter", str);
        }
    }

    /* renamed from: a */
    public static void m4455a(Context context, int i, String str, String str2) {
        if (m4446b(context)) {
            Twitter.m4253h().mo4562a(i, "Twitter", str2);
        }
    }

    /* renamed from: a */
    public static void m4447a(String str, String str2) {
        if (Twitter.m4254g()) {
            throw new IllegalStateException(str2);
        }
        Twitter.m4253h().mo4559b(str, str2);
    }
}
