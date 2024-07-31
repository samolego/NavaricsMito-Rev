package com.navatics.app.settings;

import android.app.Activity;

/* renamed from: com.navatics.app.settings.c */
/* loaded from: classes.dex */
public class DimensionSetting extends SingleChoiceSetting {

    /* renamed from: a */
    private static final String[] f5090a = {"Metric", "Imperial"};

    public DimensionSetting(Activity activity, String str) {
        super(activity, str, f5090a, "key_dimension_setting", 0);
    }
}
