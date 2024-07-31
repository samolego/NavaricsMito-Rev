package com.tencent.p075mm.opensdk.channel.p076a;

import com.tencent.p075mm.opensdk.utils.C2520b;

/* renamed from: com.tencent.mm.opensdk.channel.a.b */
/* loaded from: classes2.dex */
public final class C2506b {
    /* renamed from: a */
    public static byte[] m5014a(String str, int i, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        return C2520b.m4994e(stringBuffer.toString().substring(1, 9).getBytes()).getBytes();
    }
}
