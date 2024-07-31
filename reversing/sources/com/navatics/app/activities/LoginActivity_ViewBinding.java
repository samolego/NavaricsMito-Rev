package com.navatics.app.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class LoginActivity_ViewBinding implements Unbinder {

    /* renamed from: b */
    private LoginActivity f3622b;

    /* renamed from: c */
    private View f3623c;

    /* renamed from: d */
    private View f3624d;

    /* renamed from: e */
    private View f3625e;

    /* renamed from: f */
    private View f3626f;

    @UiThread
    public LoginActivity_ViewBinding(final LoginActivity loginActivity, View view) {
        this.f3622b = loginActivity;
        loginActivity.etEmail = (EditText) Utils.m12799a(view, R.id.etEmail, "field 'etEmail'", EditText.class);
        loginActivity.etPwd = (EditText) Utils.m12799a(view, R.id.etPwd, "field 'etPwd'", EditText.class);
        View m12800a = Utils.m12800a(view, R.id.btnSignIn, "field 'btnSignIn' and method 'onClicked'");
        loginActivity.btnSignIn = (Button) Utils.m12798b(m12800a, R.id.btnSignIn, "field 'btnSignIn'", Button.class);
        this.f3623c = m12800a;
        m12800a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.navatics.app.activities.LoginActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* renamed from: a */
            public void mo7462a(View view2) {
                loginActivity.onClicked(view2);
            }
        });
        View m12800a2 = Utils.m12800a(view, R.id.txForgotPwd, "field 'txForgotPwd' and method 'onClicked'");
        loginActivity.txForgotPwd = (TextView) Utils.m12798b(m12800a2, R.id.txForgotPwd, "field 'txForgotPwd'", TextView.class);
        this.f3624d = m12800a2;
        m12800a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.navatics.app.activities.LoginActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* renamed from: a */
            public void mo7462a(View view2) {
                loginActivity.onClicked(view2);
            }
        });
        View m12800a3 = Utils.m12800a(view, R.id.txCreateNew, "field 'txCreateNew' and method 'onClicked'");
        loginActivity.txCreateNew = (TextView) Utils.m12798b(m12800a3, R.id.txCreateNew, "field 'txCreateNew'", TextView.class);
        this.f3625e = m12800a3;
        m12800a3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.navatics.app.activities.LoginActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            /* renamed from: a */
            public void mo7462a(View view2) {
                loginActivity.onClicked(view2);
            }
        });
        View m12800a4 = Utils.m12800a(view, R.id.btnBack, "field 'btnBack' and method 'onClicked'");
        loginActivity.btnBack = (ImageView) Utils.m12798b(m12800a4, R.id.btnBack, "field 'btnBack'", ImageView.class);
        this.f3626f = m12800a4;
        m12800a4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.navatics.app.activities.LoginActivity_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            /* renamed from: a */
            public void mo7462a(View view2) {
                loginActivity.onClicked(view2);
            }
        });
        loginActivity.inputContainer = (LinearLayout) Utils.m12799a(view, R.id.inputContainer, "field 'inputContainer'", LinearLayout.class);
        loginActivity.loginRootContainer = (RelativeLayout) Utils.m12799a(view, R.id.loginRootContainer, "field 'loginRootContainer'", RelativeLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        LoginActivity loginActivity = this.f3622b;
        if (loginActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3622b = null;
        loginActivity.etEmail = null;
        loginActivity.etPwd = null;
        loginActivity.btnSignIn = null;
        loginActivity.txForgotPwd = null;
        loginActivity.txCreateNew = null;
        loginActivity.btnBack = null;
        loginActivity.inputContainer = null;
        loginActivity.loginRootContainer = null;
        this.f3623c.setOnClickListener(null);
        this.f3623c = null;
        this.f3624d.setOnClickListener(null);
        this.f3624d = null;
        this.f3625e.setOnClickListener(null);
        this.f3625e = null;
        this.f3626f.setOnClickListener(null);
        this.f3626f = null;
    }
}
