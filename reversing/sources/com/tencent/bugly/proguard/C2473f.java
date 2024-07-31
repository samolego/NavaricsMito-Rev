package com.tencent.bugly.proguard;

import android.support.p008v4.app.NotificationCompat;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.f */
/* loaded from: classes2.dex */
public final class C2473f extends AbstractC2479k {

    /* renamed from: e */
    public byte[] f7644e;

    /* renamed from: i */
    private Map<String, String> f7648i;

    /* renamed from: j */
    private Map<String, String> f7649j;

    /* renamed from: m */
    private static /* synthetic */ boolean f7639m = !C2473f.class.desiredAssertionStatus();

    /* renamed from: k */
    private static byte[] f7637k = null;

    /* renamed from: l */
    private static Map<String, String> f7638l = null;

    /* renamed from: a */
    public short f7640a = 0;

    /* renamed from: f */
    private byte f7645f = 0;

    /* renamed from: g */
    private int f7646g = 0;

    /* renamed from: b */
    public int f7641b = 0;

    /* renamed from: c */
    public String f7642c = null;

    /* renamed from: d */
    public String f7643d = null;

    /* renamed from: h */
    private int f7647h = 0;

    public final boolean equals(Object obj) {
        C2473f c2473f = (C2473f) obj;
        return C2480l.m5196a(1, (int) c2473f.f7640a) && C2480l.m5196a(1, (int) c2473f.f7645f) && C2480l.m5196a(1, c2473f.f7646g) && C2480l.m5196a(1, c2473f.f7641b) && C2480l.m5194a((Object) 1, (Object) c2473f.f7642c) && C2480l.m5194a((Object) 1, (Object) c2473f.f7643d) && C2480l.m5194a((Object) 1, (Object) c2473f.f7644e) && C2480l.m5196a(1, c2473f.f7647h) && C2480l.m5194a((Object) 1, (Object) c2473f.f7648i) && C2480l.m5194a((Object) 1, (Object) c2473f.f7649j);
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f7639m) {
                return null;
            }
            throw new AssertionError();
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC2479k
    /* renamed from: a */
    public final void mo5198a(C2478j c2478j) {
        c2478j.m5204a(this.f7640a, 1);
        c2478j.m5214a(this.f7645f, 2);
        c2478j.m5212a(this.f7646g, 3);
        c2478j.m5212a(this.f7641b, 4);
        c2478j.m5207a(this.f7642c, 5);
        c2478j.m5207a(this.f7643d, 6);
        c2478j.m5202a(this.f7644e, 7);
        c2478j.m5212a(this.f7647h, 8);
        c2478j.m5205a((Map) this.f7648i, 9);
        c2478j.m5205a((Map) this.f7649j, 10);
    }

    @Override // com.tencent.bugly.proguard.AbstractC2479k
    /* renamed from: a */
    public final void mo5199a(C2476i c2476i) {
        try {
            this.f7640a = c2476i.m5227a(this.f7640a, 1, true);
            this.f7645f = c2476i.m5240a(this.f7645f, 2, true);
            this.f7646g = c2476i.m5236a(this.f7646g, 3, true);
            this.f7641b = c2476i.m5236a(this.f7641b, 4, true);
            this.f7642c = c2476i.m5224b(5, true);
            this.f7643d = c2476i.m5224b(6, true);
            if (f7637k == null) {
                f7637k = new byte[]{0};
            }
            byte[] bArr = f7637k;
            this.f7644e = c2476i.m5222c(7, true);
            this.f7647h = c2476i.m5236a(this.f7647h, 8, true);
            if (f7638l == null) {
                HashMap hashMap = new HashMap();
                f7638l = hashMap;
                hashMap.put("", "");
            }
            this.f7648i = (Map) c2476i.m5231a((C2476i) f7638l, 9, true);
            if (f7638l == null) {
                HashMap hashMap2 = new HashMap();
                f7638l = hashMap2;
                hashMap2.put("", "");
            }
            this.f7649j = (Map) c2476i.m5231a((C2476i) f7638l, 10, true);
        } catch (Exception e) {
            e.printStackTrace();
            PrintStream printStream = System.out;
            printStream.println("RequestPacket decode error " + C2472e.m5255a(this.f7644e));
            throw new RuntimeException(e);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC2479k
    /* renamed from: a */
    public final void mo5197a(StringBuilder sb, int i) {
        C2475h c2475h = new C2475h(sb, i);
        c2475h.m5246a(this.f7640a, "iVersion");
        c2475h.m5254a(this.f7645f, "cPacketType");
        c2475h.m5253a(this.f7646g, "iMessageType");
        c2475h.m5253a(this.f7641b, "iRequestId");
        c2475h.m5248a(this.f7642c, "sServantName");
        c2475h.m5248a(this.f7643d, "sFuncName");
        c2475h.m5244a(this.f7644e, "sBuffer");
        c2475h.m5253a(this.f7647h, "iTimeout");
        c2475h.m5247a((Map) this.f7648i, "context");
        c2475h.m5247a((Map) this.f7649j, NotificationCompat.CATEGORY_STATUS);
    }
}
