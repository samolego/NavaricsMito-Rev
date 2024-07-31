package com.navatics.app.settings;

import android.app.Activity;
import android.content.Intent;
import com.navatics.app.settings.SettingEntry;

/* renamed from: com.navatics.app.settings.e */
/* loaded from: classes.dex */
public class FirmwareSetting extends SimpleSetting {
    /* renamed from: lambda$_-ZDwgIqVDBeW70KBP0FOubQ01Q */
    public static /* synthetic */ void m13095lambda$_ZDwgIqVDBeW70KBP0FOubQ01Q(FirmwareSetting firmwareSetting, SettingEntry settingEntry) {
        firmwareSetting.m7434a(settingEntry);
    }

    public FirmwareSetting(Activity activity, String str) {
        super(activity, str);
        setOnClickListener(new SettingEntry.InterfaceC1906a() { // from class: com.navatics.app.settings.-$$Lambda$e$_-ZDwgIqVDBeW70KBP0FOubQ01Q
            @Override // com.navatics.app.settings.SettingEntry.InterfaceC1906a
            public final void onClick(SettingEntry settingEntry) {
                FirmwareSetting.m13095lambda$_ZDwgIqVDBeW70KBP0FOubQ01Q(FirmwareSetting.this, settingEntry);
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m7434a(SettingEntry settingEntry) {
        m7426g().startActivity(new Intent(m7426g(), FirmwareUpdateActivity.class));
    }
}
