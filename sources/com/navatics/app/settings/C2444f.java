package com.navatics.app.settings;

import android.app.Activity;
import android.content.Intent;
import com.navatics.app.settings.SettingEntry;

/* renamed from: com.navatics.app.settings.f */
/* loaded from: classes.dex */
public class KeyMapTestingPanel extends SimpleSetting {
    /* renamed from: lambda$2pGwzXmsP3ge9c-W8c0KquO0c-s */
    public static /* synthetic */ void m13096lambda$2pGwzXmsP3ge9cW8c0KquO0cs(KeyMapTestingPanel keyMapTestingPanel, SettingEntry settingEntry) {
        keyMapTestingPanel.m7433a(settingEntry);
    }

    public KeyMapTestingPanel(Activity activity) {
        super(activity, "Key map Testing");
        setOnClickListener(new SettingEntry.InterfaceC1906a() { // from class: com.navatics.app.settings.-$$Lambda$f$2pGwzXmsP3ge9c-W8c0KquO0c-s
            @Override // com.navatics.app.settings.SettingEntry.InterfaceC1906a
            public final void onClick(SettingEntry settingEntry) {
                KeyMapTestingPanel.m13096lambda$2pGwzXmsP3ge9cW8c0KquO0cs(KeyMapTestingPanel.this, settingEntry);
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m7433a(SettingEntry settingEntry) {
        m7426g().startActivity(new Intent(m7426g(), KeymapTestingActivity.class));
    }
}
