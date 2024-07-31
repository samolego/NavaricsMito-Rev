package com.facebook.internal.p043a.p045b;

import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import com.facebook.internal.p043a.InstrumentUtility;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: com.facebook.internal.a.b.a */
/* loaded from: classes.dex */
public final class ErrorReportData {

    /* renamed from: a */
    private String f1924a;
    @Nullable

    /* renamed from: b */
    private String f1925b;
    @Nullable

    /* renamed from: c */
    private Long f1926c;

    public ErrorReportData(String str) {
        this.f1926c = Long.valueOf(System.currentTimeMillis() / 1000);
        this.f1925b = str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("error_log_");
        stringBuffer.append(this.f1926c);
        stringBuffer.append(".json");
        this.f1924a = stringBuffer.toString();
    }

    public ErrorReportData(File file) {
        this.f1924a = file.getName();
        JSONObject m10770a = InstrumentUtility.m10770a(this.f1924a, true);
        if (m10770a != null) {
            this.f1926c = Long.valueOf(m10770a.optLong("timestamp", 0L));
            this.f1925b = m10770a.optString("error_message", null);
        }
    }

    /* renamed from: a */
    public int m10764a(ErrorReportData errorReportData) {
        Long l = this.f1926c;
        if (l == null) {
            return -1;
        }
        Long l2 = errorReportData.f1926c;
        if (l2 == null) {
            return 1;
        }
        return l2.compareTo(l);
    }

    /* renamed from: a */
    public boolean m10765a() {
        return (this.f1925b == null || this.f1926c == null) ? false : true;
    }

    /* renamed from: b */
    public void m10763b() {
        if (m10765a()) {
            InstrumentUtility.m10772a(this.f1924a, toString());
        }
    }

    /* renamed from: c */
    public void m10762c() {
        InstrumentUtility.m10773a(this.f1924a);
    }

    @Nullable
    public String toString() {
        JSONObject m10761d = m10761d();
        if (m10761d == null) {
            return null;
        }
        return m10761d.toString();
    }

    @Nullable
    /* renamed from: d */
    public JSONObject m10761d() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f1926c != null) {
                jSONObject.put("timestamp", this.f1926c);
            }
            jSONObject.put("error_message", this.f1925b);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
