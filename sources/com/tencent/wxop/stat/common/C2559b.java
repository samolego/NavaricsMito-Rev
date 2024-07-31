package com.tencent.wxop.stat.common;

import android.content.Context;
import com.tencent.wxop.stat.C2525a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.common.b */
/* loaded from: classes2.dex */
public class C2559b {

    /* renamed from: a */
    static C2561d f8021a;

    /* renamed from: d */
    private static StatLogger f8022d = C2569l.m4837b();

    /* renamed from: e */
    private static JSONObject f8023e = new JSONObject();

    /* renamed from: b */
    Integer f8024b;

    /* renamed from: c */
    String f8025c;

    public C2559b(Context context) {
        this.f8024b = null;
        this.f8025c = null;
        try {
            m4869a(context);
            this.f8024b = C2569l.m4819k(context.getApplicationContext());
            this.f8025c = C2525a.m4944a(context).m4941b();
        } catch (Throwable th) {
            f8022d.m4878e(th);
        }
    }

    /* renamed from: a */
    static synchronized C2561d m4869a(Context context) {
        C2561d c2561d;
        synchronized (C2559b.class) {
            if (f8021a == null) {
                f8021a = new C2561d(context.getApplicationContext());
            }
            c2561d = f8021a;
        }
        return c2561d;
    }

    /* renamed from: a */
    public static void m4868a(Context context, Map<String, String> map) {
        if (map == null) {
            return;
        }
        for (Map.Entry entry : new HashMap(map).entrySet()) {
            f8023e.put((String) entry.getKey(), entry.getValue());
        }
    }

    /* renamed from: a */
    public void m4867a(JSONObject jSONObject, Thread thread) {
        String str;
        String str2;
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (f8021a != null) {
                f8021a.m4866a(jSONObject2, thread);
            }
            C2575r.m4787a(jSONObject2, "cn", this.f8025c);
            if (this.f8024b != null) {
                jSONObject2.put("tn", this.f8024b);
            }
            if (thread == null) {
                str = "ev";
                str2 = jSONObject2;
            } else {
                str = "errkv";
                str2 = jSONObject2.toString();
            }
            jSONObject.put(str, str2);
            if (f8023e == null || f8023e.length() <= 0) {
                return;
            }
            jSONObject.put("eva", f8023e);
        } catch (Throwable th) {
            f8022d.m4878e(th);
        }
    }
}
