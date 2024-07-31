package com.navatics.app.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class BindRobotActivity_ViewBinding implements Unbinder {

    /* renamed from: b */
    private BindRobotActivity f3499b;

    @UiThread
    public BindRobotActivity_ViewBinding(BindRobotActivity bindRobotActivity, View view) {
        this.f3499b = bindRobotActivity;
        bindRobotActivity.btnScanQRCode = (Button) Utils.m12799a(view, R.id.btnScanQRCode, "field 'btnScanQRCode'", Button.class);
        bindRobotActivity.btnInputCode = (Button) Utils.m12799a(view, R.id.btnInputCode, "field 'btnInputCode'", Button.class);
        bindRobotActivity.tvSN = (TextView) Utils.m12799a(view, R.id.tvSN, "field 'tvSN'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        BindRobotActivity bindRobotActivity = this.f3499b;
        if (bindRobotActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3499b = null;
        bindRobotActivity.btnScanQRCode = null;
        bindRobotActivity.btnInputCode = null;
        bindRobotActivity.tvSN = null;
    }
}
