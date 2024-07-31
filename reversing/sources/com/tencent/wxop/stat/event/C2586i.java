package com.tencent.wxop.stat.event;

import android.content.Context;
import com.tencent.wxop.stat.C2525a;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.common.C2569l;
import com.tencent.wxop.stat.common.C2575r;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.event.i */
/* loaded from: classes2.dex */
public class C2586i extends AbstractC2582e {

    /* renamed from: a */
    private static String f8129a;

    /* renamed from: m */
    private String f8130m;

    /* renamed from: n */
    private String f8131n;

    public C2586i(Context context, int i, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f8130m = null;
        this.f8131n = null;
        this.f8130m = C2525a.m4944a(context).m4941b();
        if (f8129a == null) {
            f8129a = C2569l.m4824g(context);
        }
    }

    @Override // com.tencent.wxop.stat.event.AbstractC2582e
    /* renamed from: a */
    public EventType mo4764a() {
        return EventType.NETWORK_MONITOR;
    }

    /* renamed from: a */
    public void m4765a(String str) {
        this.f8131n = str;
    }

    @Override // com.tencent.wxop.stat.event.AbstractC2582e
    /* renamed from: a */
    public boolean mo4763a(JSONObject jSONObject) {
        C2575r.m4787a(jSONObject, "op", f8129a);
        C2575r.m4787a(jSONObject, "cn", this.f8130m);
        jSONObject.put("sp", this.f8131n);
        return true;
    }
}
