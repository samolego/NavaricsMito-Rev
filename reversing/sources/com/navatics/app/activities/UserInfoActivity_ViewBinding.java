package com.navatics.app.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class UserInfoActivity_ViewBinding implements Unbinder {

    /* renamed from: b */
    private UserInfoActivity f3931b;

    /* renamed from: c */
    private View f3932c;

    /* renamed from: d */
    private View f3933d;

    /* renamed from: e */
    private View f3934e;

    /* renamed from: f */
    private View f3935f;

    @UiThread
    public UserInfoActivity_ViewBinding(final UserInfoActivity userInfoActivity, View view) {
        this.f3931b = userInfoActivity;
        View m12800a = Utils.m12800a(view, R.id.ivBack, "field 'ivBack' and method 'onClick'");
        userInfoActivity.ivBack = (ImageView) Utils.m12798b(m12800a, R.id.ivBack, "field 'ivBack'", ImageView.class);
        this.f3932c = m12800a;
        m12800a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.navatics.app.activities.UserInfoActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* renamed from: a */
            public void mo7462a(View view2) {
                userInfoActivity.onClick(view2);
            }
        });
        View m12800a2 = Utils.m12800a(view, R.id.ivUsrImg, "field 'ivUsrImg' and method 'onClick'");
        userInfoActivity.ivUsrImg = (ImageView) Utils.m12798b(m12800a2, R.id.ivUsrImg, "field 'ivUsrImg'", ImageView.class);
        this.f3933d = m12800a2;
        m12800a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.navatics.app.activities.UserInfoActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* renamed from: a */
            public void mo7462a(View view2) {
                userInfoActivity.onClick(view2);
            }
        });
        View m12800a3 = Utils.m12800a(view, R.id.tvUsrName, "field 'tvUsrName' and method 'onClick'");
        userInfoActivity.tvUsrName = (TextView) Utils.m12798b(m12800a3, R.id.tvUsrName, "field 'tvUsrName'", TextView.class);
        this.f3934e = m12800a3;
        m12800a3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.navatics.app.activities.UserInfoActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            /* renamed from: a */
            public void mo7462a(View view2) {
                userInfoActivity.onClick(view2);
            }
        });
        View m12800a4 = Utils.m12800a(view, R.id.btnSignOut, "field 'btnSignOut' and method 'onClick'");
        userInfoActivity.btnSignOut = (Button) Utils.m12798b(m12800a4, R.id.btnSignOut, "field 'btnSignOut'", Button.class);
        this.f3935f = m12800a4;
        m12800a4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.navatics.app.activities.UserInfoActivity_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            /* renamed from: a */
            public void mo7462a(View view2) {
                userInfoActivity.onClick(view2);
            }
        });
        userInfoActivity.etName = (EditText) Utils.m12799a(view, R.id.et_name, "field 'etName'", EditText.class);
        userInfoActivity.tvCancel = (TextView) Utils.m12799a(view, R.id.tv_cancel, "field 'tvCancel'", TextView.class);
        userInfoActivity.tvSave = (TextView) Utils.m12799a(view, R.id.tv_save, "field 'tvSave'", TextView.class);
        userInfoActivity.llEditName = (LinearLayout) Utils.m12799a(view, R.id.ll_edit_name, "field 'llEditName'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        UserInfoActivity userInfoActivity = this.f3931b;
        if (userInfoActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3931b = null;
        userInfoActivity.ivBack = null;
        userInfoActivity.ivUsrImg = null;
        userInfoActivity.tvUsrName = null;
        userInfoActivity.btnSignOut = null;
        userInfoActivity.etName = null;
        userInfoActivity.tvCancel = null;
        userInfoActivity.tvSave = null;
        userInfoActivity.llEditName = null;
        this.f3932c.setOnClickListener(null);
        this.f3932c = null;
        this.f3933d.setOnClickListener(null);
        this.f3933d = null;
        this.f3934e.setOnClickListener(null);
        this.f3934e = null;
        this.f3935f.setOnClickListener(null);
        this.f3935f = null;
    }
}
