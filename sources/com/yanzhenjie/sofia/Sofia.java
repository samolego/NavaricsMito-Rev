package com.yanzhenjie.sofia;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: com.yanzhenjie.sofia.c */
/* loaded from: classes2.dex */
public class Sofia {
    /* renamed from: a */
    public static Bar m3725a(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView().findViewById(16908290);
        if (viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof Bar) {
                return (Bar) childAt;
            }
        }
        return new HostLayout(activity);
    }
}
