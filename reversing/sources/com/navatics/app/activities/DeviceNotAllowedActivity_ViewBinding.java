package com.navatics.app.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class DeviceNotAllowedActivity_ViewBinding implements Unbinder {

    /* renamed from: b */
    private DeviceNotAllowedActivity f3517b;

    @UiThread
    public DeviceNotAllowedActivity_ViewBinding(DeviceNotAllowedActivity deviceNotAllowedActivity, View view) {
        this.f3517b = deviceNotAllowedActivity;
        deviceNotAllowedActivity.tvNote = (TextView) Utils.m12799a(view, R.id.tvNote, "field 'tvNote'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        DeviceNotAllowedActivity deviceNotAllowedActivity = this.f3517b;
        if (deviceNotAllowedActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3517b = null;
        deviceNotAllowedActivity.tvNote = null;
    }
}
