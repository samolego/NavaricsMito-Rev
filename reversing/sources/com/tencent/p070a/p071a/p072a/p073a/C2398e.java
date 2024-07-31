package com.tencent.p070a.p071a.p072a.p073a;

import android.content.Context;
import android.util.Log;
import com.tencent.wxop.stat.common.C2564g;

/* renamed from: com.tencent.a.a.a.a.e */
/* loaded from: classes2.dex */
public final class C2398e extends AbstractC2399f {
    public C2398e(Context context) {
        super(context);
    }

    @Override // com.tencent.p070a.p071a.p072a.p073a.AbstractC2399f
    /* renamed from: a */
    protected final void mo5569a(String str) {
        synchronized (this) {
            Log.i("MID", "write mid to Settings.System");
            C2564g.m4859a(this.f7115a).m4857a(C2401h.m5555c("4kU71lN96TJUomD1vOU9lgj9Tw=="), str);
        }
    }

    @Override // com.tencent.p070a.p071a.p072a.p073a.AbstractC2399f
    /* renamed from: a */
    protected final boolean mo5571a() {
        return C2401h.m5561a(this.f7115a, "android.permission.WRITE_SETTINGS");
    }

    @Override // com.tencent.p070a.p071a.p072a.p073a.AbstractC2399f
    /* renamed from: b */
    protected final String mo5568b() {
        String m4858a;
        synchronized (this) {
            Log.i("MID", "read mid from Settings.System");
            m4858a = C2564g.m4859a(this.f7115a).m4858a(C2401h.m5555c("4kU71lN96TJUomD1vOU9lgj9Tw=="));
        }
        return m4858a;
    }
}
