package com.navatics.app.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class ActivationCodeInputActivity_ViewBinding implements Unbinder {

    /* renamed from: b */
    private ActivationCodeInputActivity f3489b;

    @UiThread
    public ActivationCodeInputActivity_ViewBinding(ActivationCodeInputActivity activationCodeInputActivity, View view) {
        this.f3489b = activationCodeInputActivity;
        activationCodeInputActivity.ivBack = (ImageView) Utils.m12799a(view, R.id.ivBack, "field 'ivBack'", ImageView.class);
        activationCodeInputActivity.etInputCode = (EditText) Utils.m12799a(view, R.id.etInputCode, "field 'etInputCode'", EditText.class);
        activationCodeInputActivity.btnOK = (Button) Utils.m12799a(view, R.id.btnOK, "field 'btnOK'", Button.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        ActivationCodeInputActivity activationCodeInputActivity = this.f3489b;
        if (activationCodeInputActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3489b = null;
        activationCodeInputActivity.ivBack = null;
        activationCodeInputActivity.etInputCode = null;
        activationCodeInputActivity.btnOK = null;
    }
}
