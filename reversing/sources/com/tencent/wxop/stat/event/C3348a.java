package com.tencent.wxop.stat.event;

import android.content.Context;
import com.tencent.wxop.stat.StatAccount;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.common.C2575r;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.event.a */
/* loaded from: classes2.dex */
public class C2578a extends AbstractC2582e {

    /* renamed from: a */
    private StatAccount f8102a;

    public C2578a(Context context, int i, StatAccount statAccount, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f8102a = null;
        this.f8102a = statAccount;
    }

    @Override // com.tencent.wxop.stat.event.AbstractC2582e
    /* renamed from: a */
    public EventType mo4764a() {
        return EventType.ADDITION;
    }

    @Override // com.tencent.wxop.stat.event.AbstractC2582e
    /* renamed from: a */
    public boolean mo4763a(JSONObject jSONObject) {
        C2575r.m4787a(jSONObject, "qq", this.f8102a.getAccount());
        jSONObject.put("acc", this.f8102a.toJsonString());
        return true;
    }
}
