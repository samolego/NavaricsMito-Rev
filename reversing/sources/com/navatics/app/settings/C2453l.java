package com.navatics.app.settings;

import android.app.Activity;
import android.content.Intent;
import com.navatics.app.settings.SettingEntry;

/* renamed from: com.navatics.app.settings.l */
/* loaded from: classes.dex */
public class SystemInformationPanel extends SimpleSetting {
    /* renamed from: lambda$ND0PKugkvA-yL5tUiC5-IFz4bwc */
    public static /* synthetic */ void m13097lambda$ND0PKugkvAyL5tUiC5IFz4bwc(SystemInformationPanel systemInformationPanel, SettingEntry settingEntry) {
        systemInformationPanel.m7412a(settingEntry);
    }

    public SystemInformationPanel(Activity activity, String str) {
        super(activity, str);
        setOnClickListener(new SettingEntry.InterfaceC1906a() { // from class: com.navatics.app.settings.-$$Lambda$l$ND0PKugkvA-yL5tUiC5-IFz4bwc
            @Override // com.navatics.app.settings.SettingEntry.InterfaceC1906a
            public final void onClick(SettingEntry settingEntry) {
                SystemInformationPanel.m13097lambda$ND0PKugkvAyL5tUiC5IFz4bwc(SystemInformationPanel.this, settingEntry);
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m7412a(SettingEntry settingEntry) {
        m7426g().startActivity(new Intent(m7426g(), SystemInformationActivity.class));
    }
}
