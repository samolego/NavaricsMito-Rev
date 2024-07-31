package com.tencent.wxop.stat.common;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import com.tencent.wxop.stat.C2525a;
import com.tencent.wxop.stat.C2546au;
import com.tencent.wxop.stat.StatConfig;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Marker;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.common.d */
/* loaded from: classes2.dex */
public class C2561d {

    /* renamed from: a */
    String f8026a;

    /* renamed from: b */
    String f8027b;

    /* renamed from: c */
    DisplayMetrics f8028c;

    /* renamed from: d */
    int f8029d;

    /* renamed from: e */
    String f8030e;

    /* renamed from: f */
    String f8031f;

    /* renamed from: g */
    String f8032g;

    /* renamed from: h */
    String f8033h;

    /* renamed from: i */
    String f8034i;

    /* renamed from: j */
    String f8035j;

    /* renamed from: k */
    String f8036k;

    /* renamed from: l */
    int f8037l;

    /* renamed from: m */
    String f8038m;

    /* renamed from: n */
    String f8039n;

    /* renamed from: o */
    Context f8040o;

    /* renamed from: p */
    private String f8041p;

    /* renamed from: q */
    private String f8042q;

    /* renamed from: r */
    private String f8043r;

    /* renamed from: s */
    private String f8044s;

    private C2561d(Context context) {
        this.f8027b = StatConstants.VERSION;
        this.f8029d = Build.VERSION.SDK_INT;
        this.f8030e = Build.MODEL;
        this.f8031f = Build.MANUFACTURER;
        this.f8032g = Locale.getDefault().getLanguage();
        this.f8037l = 0;
        this.f8038m = null;
        this.f8039n = null;
        this.f8040o = null;
        this.f8041p = null;
        this.f8042q = null;
        this.f8043r = null;
        this.f8044s = null;
        this.f8040o = context.getApplicationContext();
        this.f8028c = C2569l.m4830d(this.f8040o);
        this.f8026a = C2569l.m4822h(this.f8040o);
        this.f8033h = StatConfig.getInstallChannel(this.f8040o);
        this.f8034i = C2569l.m4824g(this.f8040o);
        this.f8035j = TimeZone.getDefault().getID();
        this.f8037l = C2569l.m4817m(this.f8040o);
        this.f8036k = C2569l.m4816n(this.f8040o);
        this.f8038m = this.f8040o.getPackageName();
        if (this.f8029d >= 14) {
            this.f8041p = C2569l.m4810t(this.f8040o);
        }
        this.f8042q = C2569l.m4811s(this.f8040o).toString();
        this.f8043r = C2569l.m4812r(this.f8040o);
        this.f8044s = C2569l.m4831d();
        this.f8039n = C2569l.m4850A(this.f8040o);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m4866a(JSONObject jSONObject, Thread thread) {
        String str;
        String localMidOnly;
        if (thread == null) {
            if (this.f8028c != null) {
                jSONObject.put("sr", this.f8028c.widthPixels + Marker.ANY_MARKER + this.f8028c.heightPixels);
                jSONObject.put("dpi", this.f8028c.xdpi + Marker.ANY_MARKER + this.f8028c.ydpi);
            }
            if (C2525a.m4944a(this.f8040o).m4937e()) {
                JSONObject jSONObject2 = new JSONObject();
                C2575r.m4787a(jSONObject2, "bs", C2575r.m4783d(this.f8040o));
                C2575r.m4787a(jSONObject2, "ss", C2575r.m4782e(this.f8040o));
                if (jSONObject2.length() > 0) {
                    C2575r.m4787a(jSONObject, "wf", jSONObject2.toString());
                }
            }
            JSONArray m4790a = C2575r.m4790a(this.f8040o, 10);
            if (m4790a != null && m4790a.length() > 0) {
                C2575r.m4787a(jSONObject, "wflist", m4790a.toString());
            }
            str = "sen";
            localMidOnly = this.f8041p;
        } else {
            C2575r.m4787a(jSONObject, "thn", thread.getName());
            C2575r.m4787a(jSONObject, "qq", StatConfig.getQQ(this.f8040o));
            C2575r.m4787a(jSONObject, "cui", StatConfig.getCustomUserId(this.f8040o));
            if (C2569l.m4832c(this.f8043r) && this.f8043r.split("/").length == 2) {
                C2575r.m4787a(jSONObject, "fram", this.f8043r.split("/")[0]);
            }
            if (C2569l.m4832c(this.f8044s) && this.f8044s.split("/").length == 2) {
                C2575r.m4787a(jSONObject, "from", this.f8044s.split("/")[0]);
            }
            if (C2546au.m4916a(this.f8040o).m4898b(this.f8040o) != null) {
                jSONObject.put("ui", C2546au.m4916a(this.f8040o).m4898b(this.f8040o).m4872b());
            }
            str = "mid";
            localMidOnly = StatConfig.getLocalMidOnly(this.f8040o);
        }
        C2575r.m4787a(jSONObject, str, localMidOnly);
        C2575r.m4787a(jSONObject, "pcn", C2569l.m4815o(this.f8040o));
        C2575r.m4787a(jSONObject, "osn", Build.VERSION.RELEASE);
        C2575r.m4787a(jSONObject, "av", this.f8026a);
        C2575r.m4787a(jSONObject, "ch", this.f8033h);
        C2575r.m4787a(jSONObject, "mf", this.f8031f);
        C2575r.m4787a(jSONObject, "sv", this.f8027b);
        C2575r.m4787a(jSONObject, "osd", Build.DISPLAY);
        C2575r.m4787a(jSONObject, "prod", Build.PRODUCT);
        C2575r.m4787a(jSONObject, "tags", Build.TAGS);
        C2575r.m4787a(jSONObject, "id", Build.ID);
        C2575r.m4787a(jSONObject, "fng", Build.FINGERPRINT);
        C2575r.m4787a(jSONObject, "lch", this.f8039n);
        C2575r.m4787a(jSONObject, "ov", Integer.toString(this.f8029d));
        jSONObject.put("os", 1);
        C2575r.m4787a(jSONObject, "op", this.f8034i);
        C2575r.m4787a(jSONObject, "lg", this.f8032g);
        C2575r.m4787a(jSONObject, "md", this.f8030e);
        C2575r.m4787a(jSONObject, "tz", this.f8035j);
        int i = this.f8037l;
        if (i != 0) {
            jSONObject.put("jb", i);
        }
        C2575r.m4787a(jSONObject, "sd", this.f8036k);
        C2575r.m4787a(jSONObject, "apn", this.f8038m);
        C2575r.m4787a(jSONObject, "cpu", this.f8042q);
        C2575r.m4787a(jSONObject, "abi", Build.CPU_ABI);
        C2575r.m4787a(jSONObject, "abi2", Build.CPU_ABI2);
        C2575r.m4787a(jSONObject, "ram", this.f8043r);
        C2575r.m4787a(jSONObject, "rom", this.f8044s);
    }
}
