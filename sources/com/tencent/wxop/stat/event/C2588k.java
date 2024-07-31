package com.tencent.wxop.stat.event;

import android.content.Context;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.common.C2559b;
import com.tencent.wxop.stat.common.C2569l;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.event.k */
/* loaded from: classes2.dex */
public class C2588k extends AbstractC2582e {

    /* renamed from: a */
    private C2559b f8135a;

    /* renamed from: m */
    private JSONObject f8136m;

    public C2588k(Context context, int i, JSONObject jSONObject, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f8136m = null;
        this.f8135a = new C2559b(context);
        this.f8136m = jSONObject;
    }

    @Override // com.tencent.wxop.stat.event.AbstractC2582e
    /* renamed from: a */
    public EventType mo4764a() {
        return EventType.SESSION_ENV;
    }

    @Override // com.tencent.wxop.stat.event.AbstractC2582e
    /* renamed from: a */
    public boolean mo4763a(JSONObject jSONObject) {
        if (this.f8117e != null) {
            jSONObject.put("ut", this.f8117e.m4870d());
        }
        JSONObject jSONObject2 = this.f8136m;
        if (jSONObject2 != null) {
            jSONObject.put("cfg", jSONObject2);
        }
        if (C2569l.m4807w(this.f8123l)) {
            jSONObject.put("ncts", 1);
        }
        this.f8135a.m4867a(jSONObject, (Thread) null);
        return true;
    }
}
