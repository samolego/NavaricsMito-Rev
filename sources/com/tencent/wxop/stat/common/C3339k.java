package com.tencent.wxop.stat.common;

import com.adapt.SPM_Rc;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.common.k */
/* loaded from: classes2.dex */
public class C2568k extends AbstractC2566i {

    /* renamed from: g */
    static final /* synthetic */ boolean f8059g = !C2565h.class.desiredAssertionStatus();

    /* renamed from: h */
    private static final byte[] f8060h = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, SPM_Rc.VIBRATION_MODE.CYCLE_MODE, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: i */
    private static final byte[] f8061i = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, SPM_Rc.VIBRATION_MODE.CYCLE_MODE, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* renamed from: c */
    int f8062c;

    /* renamed from: d */
    public final boolean f8063d;

    /* renamed from: e */
    public final boolean f8064e;

    /* renamed from: f */
    public final boolean f8065f;

    /* renamed from: j */
    private final byte[] f8066j;

    /* renamed from: k */
    private int f8067k;

    /* renamed from: l */
    private final byte[] f8068l;

    public C2568k(int i, byte[] bArr) {
        this.f8052a = bArr;
        this.f8063d = (i & 1) == 0;
        this.f8064e = (i & 2) == 0;
        this.f8065f = (i & 4) != 0;
        this.f8068l = (i & 8) == 0 ? f8060h : f8061i;
        this.f8066j = new byte[2];
        this.f8062c = 0;
        this.f8067k = this.f8064e ? 19 : -1;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:102:0x00e6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0094  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00de -> B:21:0x008a). Please submit an issue!!! */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m4851a(byte[] r18, int r19, int r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 534
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.common.C2568k.m4851a(byte[], int, int, boolean):boolean");
    }
}
