package com.navatics.app.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class VerificationCodeActivity_ViewBinding implements Unbinder {

    /* renamed from: b */
    private VerificationCodeActivity f3955b;

    @UiThread
    public VerificationCodeActivity_ViewBinding(VerificationCodeActivity verificationCodeActivity, View view) {
        this.f3955b = verificationCodeActivity;
        verificationCodeActivity.etCode1 = (EditText) Utils.m12799a(view, R.id.etCode1, "field 'etCode1'", EditText.class);
        verificationCodeActivity.etCode2 = (EditText) Utils.m12799a(view, R.id.etCode2, "field 'etCode2'", EditText.class);
        verificationCodeActivity.etCode3 = (EditText) Utils.m12799a(view, R.id.etCode3, "field 'etCode3'", EditText.class);
        verificationCodeActivity.etCode4 = (EditText) Utils.m12799a(view, R.id.etCode4, "field 'etCode4'", EditText.class);
        verificationCodeActivity.etCode5 = (EditText) Utils.m12799a(view, R.id.etCode5, "field 'etCode5'", EditText.class);
        verificationCodeActivity.etCode6 = (EditText) Utils.m12799a(view, R.id.etCode6, "field 'etCode6'", EditText.class);
        verificationCodeActivity.btnResend = (Button) Utils.m12799a(view, R.id.btnResend, "field 'btnResend'", Button.class);
        verificationCodeActivity.tvCancel = (TextView) Utils.m12799a(view, R.id.tvCancel, "field 'tvCancel'", TextView.class);
        verificationCodeActivity.inputContainer = (LinearLayout) Utils.m12799a(view, R.id.inputContainer, "field 'inputContainer'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        VerificationCodeActivity verificationCodeActivity = this.f3955b;
        if (verificationCodeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3955b = null;
        verificationCodeActivity.etCode1 = null;
        verificationCodeActivity.etCode2 = null;
        verificationCodeActivity.etCode3 = null;
        verificationCodeActivity.etCode4 = null;
        verificationCodeActivity.etCode5 = null;
        verificationCodeActivity.etCode6 = null;
        verificationCodeActivity.btnResend = null;
        verificationCodeActivity.tvCancel = null;
        verificationCodeActivity.inputContainer = null;
    }
}
