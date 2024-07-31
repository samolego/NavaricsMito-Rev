package com.navatics.app.settings;

import android.content.Intent;
import android.os.Bundle;
import com.navatics.app.settings.SettingEntry;

/* loaded from: classes.dex */
public class DebugSettingActivity extends SettingsActivity {
    /* renamed from: lambda$bZ47FUxiWSzAdZjolVy4-1QbMJM */
    public static /* synthetic */ void m13085lambda$bZ47FUxiWSzAdZjolVy41QbMJM(DebugSettingActivity debugSettingActivity, SettingEntry settingEntry) {
        debugSettingActivity.m7477b(settingEntry);
    }

    @Override // com.navatics.app.settings.SettingsActivity, com.navatics.app.activities.StatusBarLightActivity, com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m7454a(new KeyMapTestingPanel(this));
        SimpleSetting simpleSetting = new SimpleSetting(this, "Pitch Control Debug Setting");
        simpleSetting.setOnClickListener(new SettingEntry.InterfaceC1906a() { // from class: com.navatics.app.settings.-$$Lambda$DebugSettingActivity$bZ47FUxiWSzAdZjolVy4-1QbMJM
            @Override // com.navatics.app.settings.SettingEntry.InterfaceC1906a
            public final void onClick(SettingEntry settingEntry) {
                DebugSettingActivity.m13085lambda$bZ47FUxiWSzAdZjolVy41QbMJM(DebugSettingActivity.this, settingEntry);
            }
        });
        m7454a(simpleSetting);
    }

    /* renamed from: b */
    public /* synthetic */ void m7477b(SettingEntry settingEntry) {
        startActivity(new Intent(this, PitchControlDebugSettingActivity.class));
    }
}
