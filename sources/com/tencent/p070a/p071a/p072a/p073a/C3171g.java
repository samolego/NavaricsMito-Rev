package com.tencent.p070a.p071a.p072a.p073a;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.a.a.a.a.g */
/* loaded from: classes2.dex */
public final class C2400g {

    /* renamed from: d */
    private static C2400g f7116d;

    /* renamed from: a */
    private Map<Integer, AbstractC2399f> f7117a;

    /* renamed from: b */
    private int f7118b = 0;

    /* renamed from: c */
    private Context f7119c;

    private C2400g(Context context) {
        this.f7117a = null;
        this.f7119c = null;
        this.f7119c = context.getApplicationContext();
        this.f7117a = new HashMap(3);
        this.f7117a.put(1, new C2398e(context));
        this.f7117a.put(2, new C2395b(context));
        this.f7117a.put(4, new C2397d(context));
    }

    /* renamed from: a */
    private C2396c m5563a(List<Integer> list) {
        C2396c m5567c;
        if (list.size() >= 0) {
            for (Integer num : list) {
                AbstractC2399f abstractC2399f = this.f7117a.get(num);
                if (abstractC2399f != null && (m5567c = abstractC2399f.m5567c()) != null && C2401h.m5556b(m5567c.f7113c)) {
                    return m5567c;
                }
            }
        }
        return new C2396c();
    }

    /* renamed from: a */
    public static synchronized C2400g m5565a(Context context) {
        C2400g c2400g;
        synchronized (C2400g.class) {
            if (f7116d == null) {
                f7116d = new C2400g(context);
            }
            c2400g = f7116d;
        }
        return c2400g;
    }

    /* renamed from: a */
    public final C2396c m5566a() {
        return m5563a(new ArrayList(Arrays.asList(1, 2, 4)));
    }

    /* renamed from: a */
    public final void m5564a(String str) {
        C2396c m5566a = m5566a();
        m5566a.f7113c = str;
        if (!C2401h.m5560a(m5566a.f7111a)) {
            m5566a.f7111a = C2401h.m5562a(this.f7119c);
        }
        if (!C2401h.m5560a(m5566a.f7112b)) {
            m5566a.f7112b = C2401h.m5557b(this.f7119c);
        }
        m5566a.f7114d = System.currentTimeMillis();
        for (Map.Entry<Integer, AbstractC2399f> entry : this.f7117a.entrySet()) {
            entry.getValue().m5570a(m5566a);
        }
    }
}
