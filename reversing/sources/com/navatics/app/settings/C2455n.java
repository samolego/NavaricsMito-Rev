package com.navatics.app.settings;

import android.app.Activity;
import android.content.Intent;
import com.navatics.app.settings.SettingEntry;

/* renamed from: com.navatics.app.settings.n */
/* loaded from: classes.dex */
public class UnbindSetting extends SimpleSetting {
    public static /* synthetic */ void lambda$x_RGTVOI7mAOLDByG_hJ2udSSIQ(UnbindSetting unbindSetting, SettingEntry settingEntry) {
        unbindSetting.m7410a(settingEntry);
    }

    public UnbindSetting(Activity activity, String str) {
        super(activity, str);
        setOnClickListener(new SettingEntry.InterfaceC1906a() { // from class: com.navatics.app.settings.-$$Lambda$n$x_RGTVOI7mAOLDByG_hJ2udSSIQ
            @Override // com.navatics.app.settings.SettingEntry.InterfaceC1906a
            public final void onClick(SettingEntry settingEntry) {
                UnbindSetting.lambda$x_RGTVOI7mAOLDByG_hJ2udSSIQ(UnbindSetting.this, settingEntry);
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m7410a(SettingEntry settingEntry) {
        m7426g().startActivity(new Intent(m7426g(), UnbindActivity.class));
    }
}
