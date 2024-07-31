package com.navatics.app.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class BindRemoteActivity_ViewBinding implements Unbinder {

    /* renamed from: b */
    private BindRemoteActivity f3495b;

    @UiThread
    public BindRemoteActivity_ViewBinding(BindRemoteActivity bindRemoteActivity, View view) {
        this.f3495b = bindRemoteActivity;
        bindRemoteActivity.btnScanQRCode = (Button) Utils.m12799a(view, R.id.btnScanQRCode, "field 'btnScanQRCode'", Button.class);
        bindRemoteActivity.btnInputCode = (Button) Utils.m12799a(view, R.id.btnInputCode, "field 'btnInputCode'", Button.class);
        bindRemoteActivity.ivClose = (ImageView) Utils.m12799a(view, R.id.ivClose, "field 'ivClose'", ImageView.class);
        bindRemoteActivity.tvSerialNum = (TextView) Utils.m12799a(view, R.id.tvSerialNum, "field 'tvSerialNum'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        BindRemoteActivity bindRemoteActivity = this.f3495b;
        if (bindRemoteActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3495b = null;
        bindRemoteActivity.btnScanQRCode = null;
        bindRemoteActivity.btnInputCode = null;
        bindRemoteActivity.ivClose = null;
        bindRemoteActivity.tvSerialNum = null;
    }
}
