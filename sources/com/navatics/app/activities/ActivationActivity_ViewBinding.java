package com.navatics.app.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class ActivationActivity_ViewBinding implements Unbinder {

    /* renamed from: b */
    private ActivationActivity f3488b;

    @UiThread
    public ActivationActivity_ViewBinding(ActivationActivity activationActivity, View view) {
        this.f3488b = activationActivity;
        activationActivity.tvActivateResult = (TextView) Utils.m12799a(view, R.id.tvActivateResult, "field 'tvActivateResult'", TextView.class);
        activationActivity.ivActivationProgress = (ImageView) Utils.m12799a(view, R.id.ivActivationProgress, "field 'ivActivationProgress'", ImageView.class);
        activationActivity.ivActivationStatus = (ImageView) Utils.m12799a(view, R.id.ivActivationStatus, "field 'ivActivationStatus'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        ActivationActivity activationActivity = this.f3488b;
        if (activationActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3488b = null;
        activationActivity.tvActivateResult = null;
        activationActivity.ivActivationProgress = null;
        activationActivity.ivActivationStatus = null;
    }
}
