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
public class CreateAccountActivity_ViewBinding implements Unbinder {

    /* renamed from: b */
    private CreateAccountActivity f3507b;

    /* renamed from: c */
    private View f3508c;

    /* renamed from: d */
    private View f3509d;

    /* renamed from: e */
    private View f3510e;

    @UiThread
    public CreateAccountActivity_ViewBinding(final CreateAccountActivity createAccountActivity, View view) {
        this.f3507b = createAccountActivity;
        createAccountActivity.etEmail = (EditText) Utils.m12799a(view, R.id.etEmail, "field 'etEmail'", EditText.class);
        View m12800a = Utils.m12800a(view, R.id.btnOK, "field 'btnOK' and method 'onClicked'");
        createAccountActivity.btnOK = (Button) Utils.m12798b(m12800a, R.id.btnOK, "field 'btnOK'", Button.class);
        this.f3508c = m12800a;
        m12800a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.navatics.app.activities.CreateAccountActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* renamed from: a */
            public void mo7462a(View view2) {
                createAccountActivity.onClicked(view2);
            }
        });
        createAccountActivity.inputContainer = (LinearLayout) Utils.m12799a(view, R.id.inputContainer, "field 'inputContainer'", LinearLayout.class);
        View m12800a2 = Utils.m12800a(view, R.id.txSignIn, "field 'txSignIn' and method 'onClicked'");
        createAccountActivity.txSignIn = (TextView) Utils.m12798b(m12800a2, R.id.txSignIn, "field 'txSignIn'", TextView.class);
        this.f3509d = m12800a2;
        m12800a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.navatics.app.activities.CreateAccountActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* renamed from: a */
            public void mo7462a(View view2) {
                createAccountActivity.onClicked(view2);
            }
        });
        View m12800a3 = Utils.m12800a(view, R.id.ivBack, "method 'onClicked'");
        this.f3510e = m12800a3;
        m12800a3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.navatics.app.activities.CreateAccountActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            /* renamed from: a */
            public void mo7462a(View view2) {
                createAccountActivity.onClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        CreateAccountActivity createAccountActivity = this.f3507b;
        if (createAccountActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3507b = null;
        createAccountActivity.etEmail = null;
        createAccountActivity.btnOK = null;
        createAccountActivity.inputContainer = null;
        createAccountActivity.txSignIn = null;
        this.f3508c.setOnClickListener(null);
        this.f3508c = null;
        this.f3509d.setOnClickListener(null);
        this.f3509d = null;
        this.f3510e.setOnClickListener(null);
        this.f3510e = null;
    }
}
