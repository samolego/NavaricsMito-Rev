package com.tencent.wxop.stat.event;

import android.content.Context;
import com.tencent.wxop.stat.StatGameUser;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.common.C2575r;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.event.f */
/* loaded from: classes2.dex */
public class C2583f extends AbstractC2582e {

    /* renamed from: a */
    private StatGameUser f8124a;

    public C2583f(Context context, int i, StatGameUser statGameUser, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f8124a = null;
        this.f8124a = statGameUser.m13138clone();
    }

    @Override // com.tencent.wxop.stat.event.AbstractC2582e
    /* renamed from: a */
    public EventType mo4764a() {
        return EventType.MTA_GAME_USER;
    }

    @Override // com.tencent.wxop.stat.event.AbstractC2582e
    /* renamed from: a */
    public boolean mo4763a(JSONObject jSONObject) {
        StatGameUser statGameUser = this.f8124a;
        if (statGameUser == null) {
            return false;
        }
        C2575r.m4787a(jSONObject, "wod", statGameUser.getWorldName());
        C2575r.m4787a(jSONObject, "gid", this.f8124a.getAccount());
        C2575r.m4787a(jSONObject, "lev", this.f8124a.getLevel());
        return true;
    }
}
