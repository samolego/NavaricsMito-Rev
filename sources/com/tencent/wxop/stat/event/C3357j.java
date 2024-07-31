package com.tencent.wxop.stat.event;

import android.content.Context;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.common.C2575r;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.event.j */
/* loaded from: classes2.dex */
public class C2587j extends AbstractC2582e {

    /* renamed from: a */
    Long f8132a;

    /* renamed from: m */
    String f8133m;

    /* renamed from: n */
    String f8134n;

    public C2587j(Context context, String str, String str2, int i, Long l, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f8132a = null;
        this.f8134n = str;
        this.f8133m = str2;
        this.f8132a = l;
    }

    @Override // com.tencent.wxop.stat.event.AbstractC2582e
    /* renamed from: a */
    public EventType mo4764a() {
        return EventType.PAGE_VIEW;
    }

    @Override // com.tencent.wxop.stat.event.AbstractC2582e
    /* renamed from: a */
    public boolean mo4763a(JSONObject jSONObject) {
        C2575r.m4787a(jSONObject, "pi", this.f8133m);
        C2575r.m4787a(jSONObject, "rf", this.f8134n);
        Long l = this.f8132a;
        if (l != null) {
            jSONObject.put("du", l);
            return true;
        }
        return true;
    }
}
