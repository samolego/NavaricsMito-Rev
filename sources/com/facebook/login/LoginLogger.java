package com.facebook.login;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.login.LoginClient;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.facebook.login.b */
/* loaded from: classes.dex */
class LoginLogger {

    /* renamed from: a */
    private final InternalAppEventsLogger f2214a;

    /* renamed from: b */
    private String f2215b;

    /* renamed from: c */
    private String f2216c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LoginLogger(Context context, String str) {
        PackageInfo packageInfo;
        this.f2215b = str;
        this.f2214a = new InternalAppEventsLogger(context, str);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (packageInfo = packageManager.getPackageInfo("com.facebook.katana", 0)) == null) {
                return;
            }
            this.f2216c = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    /* renamed from: a */
    public String m10243a() {
        return this.f2215b;
    }

    /* renamed from: a */
    static Bundle m10242a(String str) {
        Bundle bundle = new Bundle();
        bundle.putLong("1_timestamp_ms", System.currentTimeMillis());
        bundle.putString("0_auth_logger_id", str);
        bundle.putString("3_method", "");
        bundle.putString("2_result", "");
        bundle.putString("5_error_message", "");
        bundle.putString("4_error_code", "");
        bundle.putString("6_extras", "");
        return bundle;
    }

    /* renamed from: a */
    public void m10241a(String str, String str2) {
        Bundle m10242a = m10242a(str);
        m10242a.putString("3_method", str2);
        this.f2214a.m11053b("fb_mobile_login_method_start", m10242a);
    }

    /* renamed from: a */
    public void m10239a(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        Bundle m10242a = m10242a(str);
        if (str3 != null) {
            m10242a.putString("2_result", str3);
        }
        if (str4 != null) {
            m10242a.putString("5_error_message", str4);
        }
        if (str5 != null) {
            m10242a.putString("4_error_code", str5);
        }
        if (map != null && !map.isEmpty()) {
            m10242a.putString("6_extras", new JSONObject(map).toString());
        }
        m10242a.putString("3_method", str2);
        this.f2214a.m11053b("fb_mobile_login_method_complete", m10242a);
    }

    /* renamed from: b */
    public void m10238b(String str, String str2) {
        Bundle m10242a = m10242a(str);
        m10242a.putString("3_method", str2);
        this.f2214a.m11053b("fb_mobile_login_method_not_tried", m10242a);
    }

    /* renamed from: a */
    public void m10240a(String str, String str2, String str3) {
        Bundle m10242a = m10242a("");
        m10242a.putString("2_result", LoginClient.Result.Code.ERROR.getLoggingValue());
        m10242a.putString("5_error_message", str2);
        m10242a.putString("3_method", str3);
        this.f2214a.m11053b(str, m10242a);
    }
}
