package com.tencent.mm.opensdk.channel.p065a;

import com.tencent.mm.opensdk.utils.C2394b;

/* renamed from: com.tencent.mm.opensdk.channel.a.b */
/* loaded from: classes2.dex */
public final class C2382b {
    /* renamed from: a */
    public static byte[] m7839a(String str, int i, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        return C2394b.m7859e(stringBuffer.toString().substring(1, 9).getBytes()).getBytes();
    }
}