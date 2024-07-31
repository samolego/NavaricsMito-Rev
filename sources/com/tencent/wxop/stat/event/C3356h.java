package com.tencent.wxop.stat.event;

import android.content.Context;
import com.tencent.wxop.stat.StatConfig;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.common.C2575r;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.event.h */
/* loaded from: classes2.dex */
public class C2585h extends AbstractC2582e {

    /* renamed from: a */
    public static final StatSpecifyReportedInfo f8128a;

    static {
        StatSpecifyReportedInfo statSpecifyReportedInfo = new StatSpecifyReportedInfo();
        f8128a = statSpecifyReportedInfo;
        statSpecifyReportedInfo.setAppKey("A9VH9B8L4GX4");
    }

    public C2585h(Context context) {
        super(context, 0, f8128a);
    }

    @Override // com.tencent.wxop.stat.event.AbstractC2582e
    /* renamed from: a */
    public EventType mo4764a() {
        return EventType.NETWORK_DETECTOR;
    }

    @Override // com.tencent.wxop.stat.event.AbstractC2582e
    /* renamed from: a */
    public boolean mo4763a(JSONObject jSONObject) {
        C2575r.m4787a(jSONObject, "actky", StatConfig.getAppKey(this.f8123l));
        return true;
    }
}
