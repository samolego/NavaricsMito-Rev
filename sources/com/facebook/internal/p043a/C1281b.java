package com.facebook.internal.p043a;

import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.internal.Utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: com.facebook.internal.a.b */
/* loaded from: classes.dex */
public final class InstrumentUtility {
    @Nullable
    /* renamed from: a */
    public static String m10769a(Throwable th) {
        if (th == null) {
            return null;
        }
        if (th.getCause() == null) {
            return th.toString();
        }
        return th.getCause().toString();
    }

    @Nullable
    /* renamed from: b */
    public static String m10767b(Throwable th) {
        Throwable th2 = null;
        if (th == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        while (true) {
            Throwable th3 = th2;
            th2 = th;
            if (th2 == null || th2 == th3) {
                break;
            }
            for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
                jSONArray.put(stackTraceElement.toString());
            }
            th = th2.getCause();
        }
        return jSONArray.toString();
    }

    /* renamed from: c */
    public static boolean m10766c(@Nullable Throwable th) {
        if (th == null) {
            return false;
        }
        Throwable th2 = null;
        while (true) {
            Throwable th3 = th2;
            th2 = th;
            if (th2 == null || th2 == th3) {
                break;
            }
            for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
                if (stackTraceElement.getClassName().startsWith("com.facebook")) {
                    return true;
                }
            }
            th = th2.getCause();
        }
        return false;
    }

    /* renamed from: a */
    public static File[] m10774a() {
        File m10768b = m10768b();
        if (m10768b == null) {
            return new File[0];
        }
        File[] listFiles = m10768b.listFiles(new FilenameFilter() { // from class: com.facebook.internal.a.b.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.matches(String.format("^%s[0-9]+.json$", "crash_log_"));
            }
        });
        return listFiles != null ? listFiles : new File[0];
    }

    @Nullable
    /* renamed from: a */
    public static JSONObject m10770a(@Nullable String str, boolean z) {
        File m10768b = m10768b();
        if (m10768b == null || str == null) {
            return null;
        }
        try {
            return new JSONObject(Utility.m10536a((InputStream) new FileInputStream(new File(m10768b, str))));
        } catch (Exception unused) {
            if (z) {
                m10773a(str);
            }
            return null;
        }
    }

    /* renamed from: a */
    public static void m10772a(@Nullable String str, @Nullable String str2) {
        File m10768b = m10768b();
        if (m10768b == null || str == null || str2 == null) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(m10768b, str));
            fileOutputStream.write(str2.getBytes());
            fileOutputStream.close();
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static boolean m10773a(@Nullable String str) {
        File m10768b = m10768b();
        if (m10768b == null || str == null) {
            return false;
        }
        return new File(m10768b, str).delete();
    }

    /* renamed from: a */
    public static void m10771a(String str, JSONArray jSONArray, GraphRequest.InterfaceC0829b interfaceC0829b) {
        if (jSONArray.length() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, jSONArray.toString());
            GraphRequest.m11394a((AccessToken) null, String.format("%s/instruments", FacebookSdk.m10865l()), jSONObject, interfaceC0829b).m11348j();
        } catch (JSONException unused) {
        }
    }

    @Nullable
    /* renamed from: b */
    public static File m10768b() {
        File file = new File(FacebookSdk.m10869h().getCacheDir(), "instrument");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }
}
