package com.navatics.app.settings;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.navatics.app.R;

/* compiled from: UnbindDescription.java */
/* renamed from: com.navatics.app.settings.m, reason: use source file name */
/* loaded from: classes.dex */
public class UnbindDescription extends SettingEntry {
    /* JADX INFO: Access modifiers changed from: package-private */
    public UnbindDescription(Activity activity) {
        super(activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.navatics.app.settings.SettingEntry
    /* renamed from: a */
    public View mo5398a() {
        this.f5115g = ((LayoutInflater) m5469g().getSystemService("layout_inflater")).inflate(R.layout.unbind_device_setting_desc_layout, (ViewGroup) null, false);
        return this.f5115g;
    }
}