package com.navatics.app.settings;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.p011v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class FirmwareUpdateActivity_ViewBinding implements Unbinder {

    /* renamed from: b */
    private FirmwareUpdateActivity f5052b;

    @UiThread
    public FirmwareUpdateActivity_ViewBinding(FirmwareUpdateActivity firmwareUpdateActivity, View view) {
        this.f5052b = firmwareUpdateActivity;
        firmwareUpdateActivity.ivBack = (ImageView) Utils.m12799a(view, R.id.ivBack, "field 'ivBack'", ImageView.class);
        firmwareUpdateActivity.recyclerView = (RecyclerView) Utils.m12799a(view, R.id.recycler_view, "field 'recyclerView'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        FirmwareUpdateActivity firmwareUpdateActivity = this.f5052b;
        if (firmwareUpdateActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f5052b = null;
        firmwareUpdateActivity.ivBack = null;
        firmwareUpdateActivity.recyclerView = null;
    }
}
