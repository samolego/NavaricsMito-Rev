package com.tencent.wxop.stat.event;

import android.content.Context;
import com.tencent.wxop.stat.C2525a;
import com.tencent.wxop.stat.StatAppMonitor;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.common.C2569l;
import com.tencent.wxop.stat.common.C2575r;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.event.g */
/* loaded from: classes2.dex */
public class C2584g extends AbstractC2582e {

    /* renamed from: m */
    private static String f8125m;

    /* renamed from: n */
    private static String f8126n;

    /* renamed from: a */
    private StatAppMonitor f8127a;

    public C2584g(Context context, int i, StatAppMonitor statAppMonitor, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f8127a = null;
        this.f8127a = statAppMonitor.m13137clone();
    }

    @Override // com.tencent.wxop.stat.event.AbstractC2582e
    /* renamed from: a */
    public EventType mo4764a() {
        return EventType.MONITOR_STAT;
    }

    @Override // com.tencent.wxop.stat.event.AbstractC2582e
    /* renamed from: a */
    public boolean mo4763a(JSONObject jSONObject) {
        StatAppMonitor statAppMonitor = this.f8127a;
        if (statAppMonitor == null) {
            return false;
        }
        jSONObject.put("na", statAppMonitor.getInterfaceName());
        jSONObject.put("rq", this.f8127a.getReqSize());
        jSONObject.put("rp", this.f8127a.getRespSize());
        jSONObject.put("rt", this.f8127a.getResultType());
        jSONObject.put("tm", this.f8127a.getMillisecondsConsume());
        jSONObject.put("rc", this.f8127a.getReturnCode());
        jSONObject.put("sp", this.f8127a.getSampling());
        if (f8126n == null) {
            f8126n = C2569l.m4818l(this.f8123l);
        }
        C2575r.m4787a(jSONObject, "av", f8126n);
        if (f8125m == null) {
            f8125m = C2569l.m4824g(this.f8123l);
        }
        C2575r.m4787a(jSONObject, "op", f8125m);
        jSONObject.put("cn", C2525a.m4944a(this.f8123l).m4941b());
        return true;
    }
}
