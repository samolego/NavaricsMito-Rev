package com.tencent.wxop.stat.event;

import android.content.Context;
import com.tencent.p070a.p071a.p072a.p073a.C2401h;
import com.tencent.wxop.stat.C2546au;
import com.tencent.wxop.stat.StatConfig;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.common.C2558a;
import com.tencent.wxop.stat.common.C2569l;
import com.tencent.wxop.stat.common.C2575r;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.event.e */
/* loaded from: classes2.dex */
public abstract class AbstractC2582e {

    /* renamed from: j */
    protected static String f8112j;

    /* renamed from: a */
    private StatSpecifyReportedInfo f8113a;

    /* renamed from: b */
    protected String f8114b;

    /* renamed from: c */
    protected long f8115c = System.currentTimeMillis() / 1000;

    /* renamed from: d */
    protected int f8116d;

    /* renamed from: e */
    protected C2558a f8117e;

    /* renamed from: f */
    protected int f8118f;

    /* renamed from: g */
    protected String f8119g;

    /* renamed from: h */
    protected String f8120h;

    /* renamed from: i */
    protected String f8121i;

    /* renamed from: k */
    protected boolean f8122k;

    /* renamed from: l */
    protected Context f8123l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC2582e(Context context, int i, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f8114b = null;
        this.f8117e = null;
        this.f8119g = null;
        this.f8120h = null;
        this.f8121i = null;
        this.f8122k = false;
        this.f8113a = null;
        this.f8123l = context;
        this.f8116d = i;
        this.f8120h = StatConfig.getInstallChannel(context);
        this.f8121i = C2569l.m4822h(context);
        this.f8114b = StatConfig.getAppKey(context);
        if (statSpecifyReportedInfo != null) {
            this.f8113a = statSpecifyReportedInfo;
            if (C2569l.m4832c(statSpecifyReportedInfo.getAppKey())) {
                this.f8114b = statSpecifyReportedInfo.getAppKey();
            }
            if (C2569l.m4832c(statSpecifyReportedInfo.getInstallChannel())) {
                this.f8120h = statSpecifyReportedInfo.getInstallChannel();
            }
            if (C2569l.m4832c(statSpecifyReportedInfo.getVersion())) {
                this.f8121i = statSpecifyReportedInfo.getVersion();
            }
            this.f8122k = statSpecifyReportedInfo.isImportant();
        }
        this.f8119g = StatConfig.getCustomUserId(context);
        this.f8117e = C2546au.m4916a(context).m4898b(context);
        this.f8118f = mo4764a() != EventType.NETWORK_DETECTOR ? C2569l.m4813q(context).intValue() : -EventType.NETWORK_DETECTOR.m4776a();
        if (C2401h.m5556b(f8112j)) {
            return;
        }
        String localMidOnly = StatConfig.getLocalMidOnly(context);
        f8112j = localMidOnly;
        if (C2569l.m4832c(localMidOnly)) {
            return;
        }
        f8112j = "0";
    }

    /* renamed from: a */
    public abstract EventType mo4764a();

    /* renamed from: a */
    public abstract boolean mo4763a(JSONObject jSONObject);

    /* renamed from: b */
    public boolean m4771b(JSONObject jSONObject) {
        try {
            C2575r.m4787a(jSONObject, "ky", this.f8114b);
            jSONObject.put("et", mo4764a().m4776a());
            if (this.f8117e != null) {
                jSONObject.put("ui", this.f8117e.m4872b());
                C2575r.m4787a(jSONObject, "mc", this.f8117e.m4871c());
                int m4870d = this.f8117e.m4870d();
                jSONObject.put("ut", m4870d);
                if (m4870d == 0 && C2569l.m4809u(this.f8123l) == 1) {
                    jSONObject.put("ia", 1);
                }
            }
            C2575r.m4787a(jSONObject, "cui", this.f8119g);
            if (mo4764a() != EventType.SESSION_ENV) {
                C2575r.m4787a(jSONObject, "av", this.f8121i);
                C2575r.m4787a(jSONObject, "ch", this.f8120h);
            }
            if (this.f8122k) {
                jSONObject.put("impt", 1);
            }
            C2575r.m4787a(jSONObject, "mid", f8112j);
            jSONObject.put("cch", "wxop");
            jSONObject.put("idx", this.f8118f);
            jSONObject.put("si", this.f8116d);
            jSONObject.put("ts", this.f8115c);
            jSONObject.put("dts", C2569l.m4842a(this.f8123l, false));
            return mo4763a(jSONObject);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: c */
    public long m4770c() {
        return this.f8115c;
    }

    /* renamed from: d */
    public StatSpecifyReportedInfo m4769d() {
        return this.f8113a;
    }

    /* renamed from: e */
    public Context m4768e() {
        return this.f8123l;
    }

    /* renamed from: f */
    public boolean m4767f() {
        return this.f8122k;
    }

    /* renamed from: g */
    public String m4766g() {
        try {
            JSONObject jSONObject = new JSONObject();
            m4771b(jSONObject);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
