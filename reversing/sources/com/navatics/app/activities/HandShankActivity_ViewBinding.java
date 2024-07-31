package com.navatics.app.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class HandShankActivity_ViewBinding implements Unbinder {

    /* renamed from: b */
    private HandShankActivity f3579b;

    @UiThread
    public HandShankActivity_ViewBinding(HandShankActivity handShankActivity, View view) {
        this.f3579b = handShankActivity;
        handShankActivity.btnUpdate = (Button) Utils.m12799a(view, R.id.btn_update, "field 'btnUpdate'", Button.class);
        handShankActivity.seekBar = (SeekBar) Utils.m12799a(view, R.id.seek_bar, "field 'seekBar'", SeekBar.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        HandShankActivity handShankActivity = this.f3579b;
        if (handShankActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3579b = null;
        handShankActivity.btnUpdate = null;
        handShankActivity.seekBar = null;
    }
}
