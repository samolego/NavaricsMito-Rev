package com.tencent.wxop.stat.event;

import android.content.Context;
import com.tencent.wxop.stat.StatServiceImpl;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import java.util.Map;
import java.util.Properties;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.event.b */
/* loaded from: classes2.dex */
public class C2579b extends AbstractC2582e {

    /* renamed from: a */
    protected C2580c f8103a;

    /* renamed from: m */
    private long f8104m;

    public C2579b(Context context, int i, String str, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f8103a = new C2580c();
        this.f8104m = -1L;
        this.f8103a.f8105a = str;
    }

    /* renamed from: h */
    private void m4773h() {
        Properties commonKeyValueForKVEvent;
        if (this.f8103a.f8105a == null || (commonKeyValueForKVEvent = StatServiceImpl.getCommonKeyValueForKVEvent(this.f8103a.f8105a)) == null || commonKeyValueForKVEvent.size() <= 0) {
            return;
        }
        if (this.f8103a.f8107c == null || this.f8103a.f8107c.length() == 0) {
            this.f8103a.f8107c = new JSONObject(commonKeyValueForKVEvent);
            return;
        }
        for (Map.Entry entry : commonKeyValueForKVEvent.entrySet()) {
            try {
                this.f8103a.f8107c.put(entry.getKey().toString(), entry.getValue());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.tencent.wxop.stat.event.AbstractC2582e
    /* renamed from: a */
    public EventType mo4764a() {
        return EventType.CUSTOM;
    }

    /* renamed from: a */
    public void m4775a(long j) {
        this.f8104m = j;
    }

    @Override // com.tencent.wxop.stat.event.AbstractC2582e
    /* renamed from: a */
    public boolean mo4763a(JSONObject jSONObject) {
        String str;
        Object obj;
        jSONObject.put("ei", this.f8103a.f8105a);
        long j = this.f8104m;
        if (j > 0) {
            jSONObject.put("du", j);
        }
        if (this.f8103a.f8106b == null) {
            m4773h();
            str = "kv";
            obj = this.f8103a.f8107c;
        } else {
            str = "ar";
            obj = this.f8103a.f8106b;
        }
        jSONObject.put(str, obj);
        return true;
    }

    /* renamed from: b */
    public C2580c m4774b() {
        return this.f8103a;
    }
}
