package com.navatics.app.settings;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.navatics.app.R;

/* renamed from: com.navatics.app.settings.m */
/* loaded from: classes.dex */
public class UnbindDescription extends SettingEntry {
    /* JADX INFO: Access modifiers changed from: package-private */
    public UnbindDescription(Activity activity) {
        super(activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.navatics.app.settings.SettingEntry
    /* renamed from: a */
    public View mo7411a() {
        this.f5093g = ((LayoutInflater) m7426g().getSystemService("layout_inflater")).inflate(R.layout.unbind_device_setting_desc_layout, (ViewGroup) null, false);
        return this.f5093g;
    }
}
