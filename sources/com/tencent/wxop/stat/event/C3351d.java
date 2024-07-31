package com.tencent.wxop.stat.event;

import android.content.Context;
import com.tencent.wxop.stat.StatConfig;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.common.C2559b;
import com.tencent.wxop.stat.common.C2575r;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.event.d */
/* loaded from: classes2.dex */
public class C2581d extends AbstractC2582e {

    /* renamed from: a */
    private String f8108a;

    /* renamed from: m */
    private int f8109m;

    /* renamed from: n */
    private int f8110n;

    /* renamed from: o */
    private Thread f8111o;

    public C2581d(Context context, int i, int i2, Throwable th, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f8110n = 100;
        this.f8111o = null;
        m4772a(i2, th);
    }

    public C2581d(Context context, int i, int i2, Throwable th, Thread thread, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f8110n = 100;
        this.f8111o = null;
        m4772a(i2, th);
        this.f8111o = thread;
    }

    public C2581d(Context context, int i, String str, int i2, int i3, Thread thread, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f8110n = 100;
        this.f8111o = null;
        if (str != null) {
            i3 = i3 <= 0 ? StatConfig.getMaxReportEventLength() : i3;
            if (str.length() <= i3) {
                this.f8108a = str;
            } else {
                this.f8108a = str.substring(0, i3);
            }
        }
        this.f8111o = thread;
        this.f8109m = i2;
    }

    /* renamed from: a */
    private void m4772a(int i, Throwable th) {
        if (th != null) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            this.f8108a = stringWriter.toString();
            this.f8109m = i;
            printWriter.close();
        }
    }

    @Override // com.tencent.wxop.stat.event.AbstractC2582e
    /* renamed from: a */
    public EventType mo4764a() {
        return EventType.ERROR;
    }

    @Override // com.tencent.wxop.stat.event.AbstractC2582e
    /* renamed from: a */
    public boolean mo4763a(JSONObject jSONObject) {
        C2575r.m4787a(jSONObject, "er", this.f8108a);
        jSONObject.put("ea", this.f8109m);
        int i = this.f8109m;
        if (i == 2 || i == 3) {
            new C2559b(this.f8123l).m4867a(jSONObject, this.f8111o);
            return true;
        }
        return true;
    }
}
