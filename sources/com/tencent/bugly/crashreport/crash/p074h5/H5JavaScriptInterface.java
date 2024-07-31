package com.tencent.bugly.crashreport.crash.p074h5;

import android.webkit.JavascriptInterface;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.inner.InnerApi;
import com.tencent.bugly.proguard.C2499x;
import com.tencent.bugly.proguard.C2503z;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.h5.H5JavaScriptInterface */
/* loaded from: classes2.dex */
public class H5JavaScriptInterface {

    /* renamed from: a */
    private static HashSet<Integer> f7473a = new HashSet<>();

    /* renamed from: b */
    private String f7474b = null;

    /* renamed from: c */
    private Thread f7475c = null;

    /* renamed from: d */
    private String f7476d = null;

    /* renamed from: e */
    private Map<String, String> f7477e = null;

    private H5JavaScriptInterface() {
    }

    public static H5JavaScriptInterface getInstance(CrashReport.WebViewInterface webViewInterface) {
        String str = null;
        if (webViewInterface == null || f7473a.contains(Integer.valueOf(webViewInterface.hashCode()))) {
            return null;
        }
        H5JavaScriptInterface h5JavaScriptInterface = new H5JavaScriptInterface();
        f7473a.add(Integer.valueOf(webViewInterface.hashCode()));
        h5JavaScriptInterface.f7475c = Thread.currentThread();
        Thread thread = h5JavaScriptInterface.f7475c;
        if (thread != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            for (int i = 2; i < thread.getStackTrace().length; i++) {
                StackTraceElement stackTraceElement = thread.getStackTrace()[i];
                if (!stackTraceElement.toString().contains("crashreport")) {
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                }
            }
            str = sb.toString();
        }
        h5JavaScriptInterface.f7476d = str;
        HashMap hashMap = new HashMap();
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) webViewInterface.getContentDescription());
        hashMap.put("[WebView] ContentDescription", sb2.toString());
        h5JavaScriptInterface.f7477e = hashMap;
        return h5JavaScriptInterface;
    }

    /* renamed from: a */
    private static C2444a m5308a(String str) {
        String string;
        if (str == null || str.length() <= 0) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            C2444a c2444a = new C2444a();
            c2444a.f7478a = jSONObject.getString("projectRoot");
            if (c2444a.f7478a == null) {
                return null;
            }
            c2444a.f7479b = jSONObject.getString("context");
            if (c2444a.f7479b == null) {
                return null;
            }
            c2444a.f7480c = jSONObject.getString("url");
            if (c2444a.f7480c == null) {
                return null;
            }
            c2444a.f7481d = jSONObject.getString("userAgent");
            if (c2444a.f7481d == null) {
                return null;
            }
            c2444a.f7482e = jSONObject.getString(IjkMediaMeta.IJKM_KEY_LANGUAGE);
            if (c2444a.f7482e == null) {
                return null;
            }
            c2444a.f7483f = jSONObject.getString("name");
            if (c2444a.f7483f == null || c2444a.f7483f.equals("null") || (string = jSONObject.getString("stacktrace")) == null) {
                return null;
            }
            int indexOf = string.indexOf("\n");
            if (indexOf < 0) {
                C2499x.m5084d("H5 crash stack's format is wrong!", new Object[0]);
                return null;
            }
            c2444a.f7485h = string.substring(indexOf + 1);
            c2444a.f7484g = string.substring(0, indexOf);
            int indexOf2 = c2444a.f7484g.indexOf(":");
            if (indexOf2 > 0) {
                c2444a.f7484g = c2444a.f7484g.substring(indexOf2 + 1);
            }
            c2444a.f7486i = jSONObject.getString("file");
            if (c2444a.f7483f == null) {
                return null;
            }
            c2444a.f7487j = jSONObject.getLong("lineNumber");
            if (c2444a.f7487j < 0) {
                return null;
            }
            c2444a.f7488k = jSONObject.getLong("columnNumber");
            if (c2444a.f7488k < 0) {
                return null;
            }
            C2499x.m5090a("H5 crash information is following: ", new Object[0]);
            C2499x.m5090a("[projectRoot]: " + c2444a.f7478a, new Object[0]);
            C2499x.m5090a("[context]: " + c2444a.f7479b, new Object[0]);
            C2499x.m5090a("[url]: " + c2444a.f7480c, new Object[0]);
            C2499x.m5090a("[userAgent]: " + c2444a.f7481d, new Object[0]);
            C2499x.m5090a("[language]: " + c2444a.f7482e, new Object[0]);
            C2499x.m5090a("[name]: " + c2444a.f7483f, new Object[0]);
            C2499x.m5090a("[message]: " + c2444a.f7484g, new Object[0]);
            C2499x.m5090a("[stacktrace]: \n" + c2444a.f7485h, new Object[0]);
            C2499x.m5090a("[file]: " + c2444a.f7486i, new Object[0]);
            C2499x.m5090a("[lineNumber]: " + c2444a.f7487j, new Object[0]);
            C2499x.m5090a("[columnNumber]: " + c2444a.f7488k, new Object[0]);
            return c2444a;
        } catch (Throwable th) {
            if (!C2499x.m5089a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    @JavascriptInterface
    public void printLog(String str) {
        C2499x.m5084d("Log from js: %s", str);
    }

    @JavascriptInterface
    public void reportJSException(String str) {
        if (str == null) {
            C2499x.m5084d("Payload from JS is null.", new Object[0]);
            return;
        }
        String m5023b = C2503z.m5023b(str.getBytes());
        String str2 = this.f7474b;
        if (str2 != null && str2.equals(m5023b)) {
            C2499x.m5084d("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
            return;
        }
        this.f7474b = m5023b;
        C2499x.m5084d("Handling JS exception ...", new Object[0]);
        C2444a m5308a = m5308a(str);
        if (m5308a == null) {
            C2499x.m5084d("Failed to parse payload.", new Object[0]);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        if (m5308a.f7478a != null) {
            linkedHashMap2.put("[JS] projectRoot", m5308a.f7478a);
        }
        if (m5308a.f7479b != null) {
            linkedHashMap2.put("[JS] context", m5308a.f7479b);
        }
        if (m5308a.f7480c != null) {
            linkedHashMap2.put("[JS] url", m5308a.f7480c);
        }
        if (m5308a.f7481d != null) {
            linkedHashMap2.put("[JS] userAgent", m5308a.f7481d);
        }
        if (m5308a.f7486i != null) {
            linkedHashMap2.put("[JS] file", m5308a.f7486i);
        }
        if (m5308a.f7487j != 0) {
            linkedHashMap2.put("[JS] lineNumber", Long.toString(m5308a.f7487j));
        }
        linkedHashMap.putAll(linkedHashMap2);
        linkedHashMap.putAll(this.f7477e);
        linkedHashMap.put("Java Stack", this.f7476d);
        Thread thread = this.f7475c;
        if (m5308a != null) {
            InnerApi.postH5CrashAsync(thread, m5308a.f7483f, m5308a.f7484g, m5308a.f7485h, linkedHashMap);
        }
    }
}
