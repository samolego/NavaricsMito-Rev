package com.facebook.internal.p043a.p044a;

import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import com.facebook.internal.Utility;
import com.facebook.internal.p043a.InstrumentUtility;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: com.facebook.internal.a.a.b */
/* loaded from: classes.dex */
public final class CrashReportData {

    /* renamed from: a */
    private String f1919a;
    @Nullable

    /* renamed from: b */
    private String f1920b;
    @Nullable

    /* renamed from: c */
    private String f1921c;
    @Nullable

    /* renamed from: d */
    private String f1922d;
    @Nullable

    /* renamed from: e */
    private Long f1923e;

    public CrashReportData(Throwable th) {
        this.f1920b = Utility.m10551a();
        this.f1921c = InstrumentUtility.m10769a(th);
        this.f1922d = InstrumentUtility.m10767b(th);
        this.f1923e = Long.valueOf(System.currentTimeMillis() / 1000);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("crash_log_");
        stringBuffer.append(this.f1923e.toString());
        stringBuffer.append(".json");
        this.f1919a = stringBuffer.toString();
    }

    public CrashReportData(File file) {
        this.f1919a = file.getName();
        JSONObject m10770a = InstrumentUtility.m10770a(this.f1919a, true);
        if (m10770a != null) {
            this.f1920b = m10770a.optString("app_version", null);
            this.f1921c = m10770a.optString("reason", null);
            this.f1922d = m10770a.optString("callstack", null);
            this.f1923e = Long.valueOf(m10770a.optLong("timestamp", 0L));
        }
    }

    /* renamed from: a */
    public int m10778a(CrashReportData crashReportData) {
        Long l = this.f1923e;
        if (l == null) {
            return -1;
        }
        Long l2 = crashReportData.f1923e;
        if (l2 == null) {
            return 1;
        }
        return l2.compareTo(l);
    }

    /* renamed from: a */
    public boolean m10779a() {
        return (this.f1922d == null || this.f1923e == null) ? false : true;
    }

    /* renamed from: b */
    public void m10777b() {
        if (m10779a()) {
            InstrumentUtility.m10772a(this.f1919a, toString());
        }
    }

    /* renamed from: c */
    public void m10776c() {
        InstrumentUtility.m10773a(this.f1919a);
    }

    @Nullable
    public String toString() {
        JSONObject m10775d = m10775d();
        if (m10775d == null) {
            return null;
        }
        return m10775d.toString();
    }

    @Nullable
    /* renamed from: d */
    public JSONObject m10775d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_os_version", Build.VERSION.RELEASE);
            jSONObject.put("device_model", Build.MODEL);
            if (this.f1920b != null) {
                jSONObject.put("app_version", this.f1920b);
            }
            if (this.f1923e != null) {
                jSONObject.put("timestamp", this.f1923e);
            }
            if (this.f1921c != null) {
                jSONObject.put("reason", this.f1921c);
            }
            if (this.f1922d != null) {
                jSONObject.put("callstack", this.f1922d);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
