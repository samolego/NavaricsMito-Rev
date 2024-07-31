package com.navatics.app.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class ForgetPwdActivity_ViewBinding implements Unbinder {

    /* renamed from: b */
    private ForgetPwdActivity f3560b;

    /* renamed from: c */
    private View f3561c;

    /* renamed from: d */
    private View f3562d;

    @UiThread
    public ForgetPwdActivity_ViewBinding(final ForgetPwdActivity forgetPwdActivity, View view) {
        this.f3560b = forgetPwdActivity;
        forgetPwdActivity.txHelpText = (TextView) Utils.m12799a(view, R.id.txHelpText, "field 'txHelpText'", TextView.class);
        forgetPwdActivity.etInputBox = (EditText) Utils.m12799a(view, R.id.etInputBox, "field 'etInputBox'", EditText.class);
        View m12800a = Utils.m12800a(view, R.id.btnResend, "field 'btnResend' and method 'onClick'");
        forgetPwdActivity.btnResend = (Button) Utils.m12798b(m12800a, R.id.btnResend, "field 'btnResend'", Button.class);
        this.f3561c = m12800a;
        m12800a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.navatics.app.activities.ForgetPwdActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* renamed from: a */
            public void mo7462a(View view2) {
                forgetPwdActivity.onClick(view2);
            }
        });
        View m12800a2 = Utils.m12800a(view, R.id.tvCancel, "method 'onClick'");
        this.f3562d = m12800a2;
        m12800a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.navatics.app.activities.ForgetPwdActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* renamed from: a */
            public void mo7462a(View view2) {
                forgetPwdActivity.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        ForgetPwdActivity forgetPwdActivity = this.f3560b;
        if (forgetPwdActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3560b = null;
        forgetPwdActivity.txHelpText = null;
        forgetPwdActivity.etInputBox = null;
        forgetPwdActivity.btnResend = null;
        this.f3561c.setOnClickListener(null);
        this.f3561c = null;
        this.f3562d.setOnClickListener(null);
        this.f3562d = null;
    }
}
