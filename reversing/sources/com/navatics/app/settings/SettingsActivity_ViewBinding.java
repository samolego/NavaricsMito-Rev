package com.navatics.app.settings;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class SettingsActivity_ViewBinding implements Unbinder {

    /* renamed from: b */
    private SettingsActivity f5079b;

    @UiThread
    public SettingsActivity_ViewBinding(SettingsActivity settingsActivity, View view) {
        this.f5079b = settingsActivity;
        settingsActivity.lvList = (ListView) Utils.m12799a(view, R.id.lvList, "field 'lvList'", ListView.class);
        settingsActivity.ivBack = (ImageView) Utils.m12799a(view, R.id.ivBack, "field 'ivBack'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        SettingsActivity settingsActivity = this.f5079b;
        if (settingsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f5079b = null;
        settingsActivity.lvList = null;
        settingsActivity.ivBack = null;
    }
}
