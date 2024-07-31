package com.tencent.p070a.p071a.p072a.p073a;

import android.content.Context;

/* renamed from: com.tencent.a.a.a.a.f */
/* loaded from: classes2.dex */
public abstract class AbstractC2399f {

    /* renamed from: a */
    protected Context f7115a;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC2399f(Context context) {
        this.f7115a = null;
        this.f7115a = context;
    }

    /* renamed from: a */
    public final void m5570a(C2396c c2396c) {
        if (c2396c == null) {
            return;
        }
        String c2396c2 = c2396c.toString();
        if (mo5571a()) {
            mo5569a(C2401h.m5554d(c2396c2));
        }
    }

    /* renamed from: a */
    protected abstract void mo5569a(String str);

    /* renamed from: a */
    protected abstract boolean mo5571a();

    /* renamed from: b */
    protected abstract String mo5568b();

    /* renamed from: c */
    public final C2396c m5567c() {
        String m5555c = mo5571a() ? C2401h.m5555c(mo5568b()) : null;
        if (m5555c != null) {
            return C2396c.m5573a(m5555c);
        }
        return null;
    }
}
