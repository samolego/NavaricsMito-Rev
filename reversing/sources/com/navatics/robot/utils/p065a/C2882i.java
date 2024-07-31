package com.navatics.robot.utils.p065a;

import android.content.Context;
import android.util.TypedValue;
import android.widget.Toast;

/* renamed from: com.navatics.robot.utils.a.i */
/* loaded from: classes2.dex */
public class LoggerUtil {

    /* renamed from: a */
    private static Toast f6738a = null;

    /* renamed from: b */
    private static String f6739b = "";

    /* renamed from: a */
    public static void m5931a(Object obj) {
        if (BaseConstants.f6733a) {
            return;
        }
        C2152g.m5941a("COMMON_LOG");
        C2152g.m5940a(obj + "", new Object[0]);
    }

    /* renamed from: a */
    public static void m5929a(String str, String str2) {
        if (BaseConstants.f6733a) {
            return;
        }
        C2152g.m5941a(str);
        C2152g.m5939b(str2, new Object[0]);
    }

    /* renamed from: a */
    public static void m5930a(String str) {
        if (BaseConstants.f6733a) {
            return;
        }
        C2152g.m5941a("COMMON_LOG");
        C2152g.m5939b(str, new Object[0]);
    }

    /* renamed from: b */
    private static boolean m5928b(String str) {
        return str == null || f6739b.equals(str) || "null".equals(str);
    }

    /* renamed from: a */
    private static void m5934a(Context context) {
        f6738a = Toast.makeText(context.getApplicationContext(), "", 0);
    }

    /* renamed from: a */
    private static void m5933a(Context context, CharSequence charSequence, int i, int i2) {
        try {
            m5934a(context);
            f6738a.setText(charSequence);
            f6738a.setDuration(i);
            if (i2 != -1) {
                f6738a.setGravity(i2, 0, 0);
            } else {
                f6738a.setGravity(81, 0, -((int) TypedValue.applyDimension(1, 48.0f, context.getResources().getDisplayMetrics())));
            }
            f6738a.show();
        } catch (Exception e) {
            m5930a(e.getMessage());
        }
    }

    /* renamed from: a */
    public static void m5932a(Context context, String str) {
        if (m5928b(str)) {
            return;
        }
        m5933a(context, str, 0, 17);
    }
}
