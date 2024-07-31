package com.navatics.app.settings;

import android.app.Activity;
import android.content.Intent;
import com.navatics.app.settings.SettingEntry;

/* renamed from: com.navatics.app.settings.b */
/* loaded from: classes.dex */
public class ControllerModeSetting extends SimpleSetting {
    /* renamed from: lambda$MueQqnbrkA-_XDTS8Lf1yV552eQ */
    public static /* synthetic */ void m13094lambda$MueQqnbrkA_XDTS8Lf1yV552eQ(ControllerModeSetting controllerModeSetting, SettingEntry settingEntry) {
        controllerModeSetting.m7435a(settingEntry);
    }

    public ControllerModeSetting(Activity activity, String str) {
        super(activity, str);
        setOnClickListener(new SettingEntry.InterfaceC1906a() { // from class: com.navatics.app.settings.-$$Lambda$b$MueQqnbrkA-_XDTS8Lf1yV552eQ
            @Override // com.navatics.app.settings.SettingEntry.InterfaceC1906a
            public final void onClick(SettingEntry settingEntry) {
                ControllerModeSetting.m13094lambda$MueQqnbrkA_XDTS8Lf1yV552eQ(ControllerModeSetting.this, settingEntry);
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m7435a(SettingEntry settingEntry) {
        m7426g().startActivity(new Intent(m7426g(), ControllerModeActivity.class));
    }
}
