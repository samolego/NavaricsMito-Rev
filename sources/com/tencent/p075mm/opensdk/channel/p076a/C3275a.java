package com.tencent.p075mm.opensdk.channel.p076a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.p075mm.opensdk.constants.ConstantsAPI;
import com.tencent.p075mm.opensdk.utils.C2524d;
import com.tencent.p075mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.channel.a.a */
/* loaded from: classes2.dex */
public final class C2504a {

    /* renamed from: com.tencent.mm.opensdk.channel.a.a$a */
    /* loaded from: classes2.dex */
    public static class C2505a {

        /* renamed from: W */
        public String f7788W;

        /* renamed from: X */
        public long f7789X;
        public String action;
        public Bundle bundle;
        public String content;
    }

    /* renamed from: a */
    public static boolean m5015a(Context context, C2505a c2505a) {
        String str;
        String str2;
        if (context == null) {
            str = "MicroMsg.SDK.MMessage";
            str2 = "send fail, invalid argument";
        } else if (!C2524d.m4991i(c2505a.action)) {
            String str3 = null;
            if (!C2524d.m4991i(c2505a.f7788W)) {
                str3 = c2505a.f7788W + ".permission.MM_MESSAGE";
            }
            Intent intent = new Intent(c2505a.action);
            if (c2505a.bundle != null) {
                intent.putExtras(c2505a.bundle);
            }
            String packageName = context.getPackageName();
            intent.putExtra(ConstantsAPI.SDK_VERSION, 620953856);
            intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
            intent.putExtra(ConstantsAPI.CONTENT, c2505a.content);
            intent.putExtra(ConstantsAPI.APP_SUPORT_CONTENT_TYPE, c2505a.f7789X);
            intent.putExtra(ConstantsAPI.CHECK_SUM, C2506b.m5014a(c2505a.content, 620953856, packageName));
            context.sendBroadcast(intent, str3);
            Log.m5001d("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str3);
            return true;
        } else {
            str = "MicroMsg.SDK.MMessage";
            str2 = "send fail, action is null";
        }
        Log.m5000e(str, str2);
        return false;
    }
}
