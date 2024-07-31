package com.navatics.app.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class ResetPwdActivity_ViewBinding implements Unbinder {

    /* renamed from: b */
    private ResetPwdActivity f3859b;

    /* renamed from: c */
    private View f3860c;

    /* renamed from: d */
    private View f3861d;

    @UiThread
    public ResetPwdActivity_ViewBinding(final ResetPwdActivity resetPwdActivity, View view) {
        this.f3859b = resetPwdActivity;
        resetPwdActivity.inputContainer = (LinearLayout) Utils.m12799a(view, R.id.inputContainer, "field 'inputContainer'", LinearLayout.class);
        resetPwdActivity.etPwd1 = (EditText) Utils.m12799a(view, R.id.etPwd1, "field 'etPwd1'", EditText.class);
        resetPwdActivity.etPwd2 = (EditText) Utils.m12799a(view, R.id.etPwd2, "field 'etPwd2'", EditText.class);
        View m12800a = Utils.m12800a(view, R.id.btnOK, "field 'btnOK' and method 'onClick'");
        resetPwdActivity.btnOK = (Button) Utils.m12798b(m12800a, R.id.btnOK, "field 'btnOK'", Button.class);
        this.f3860c = m12800a;
        m12800a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.navatics.app.activities.ResetPwdActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* renamed from: a */
            public void mo7462a(View view2) {
                resetPwdActivity.onClick(view2);
            }
        });
        View m12800a2 = Utils.m12800a(view, R.id.tvCancel, "field 'tvCancel' and method 'onClick'");
        resetPwdActivity.tvCancel = (TextView) Utils.m12798b(m12800a2, R.id.tvCancel, "field 'tvCancel'", TextView.class);
        this.f3861d = m12800a2;
        m12800a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.navatics.app.activities.ResetPwdActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* renamed from: a */
            public void mo7462a(View view2) {
                resetPwdActivity.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        ResetPwdActivity resetPwdActivity = this.f3859b;
        if (resetPwdActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3859b = null;
        resetPwdActivity.inputContainer = null;
        resetPwdActivity.etPwd1 = null;
        resetPwdActivity.etPwd2 = null;
        resetPwdActivity.btnOK = null;
        resetPwdActivity.tvCancel = null;
        this.f3860c.setOnClickListener(null);
        this.f3860c = null;
        this.f3861d.setOnClickListener(null);
        this.f3861d = null;
    }
}
