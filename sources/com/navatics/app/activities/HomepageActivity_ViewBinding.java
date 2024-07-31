package com.navatics.app.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class HomepageActivity_ViewBinding implements Unbinder {

    /* renamed from: b */
    private HomepageActivity f3593b;

    /* renamed from: c */
    private View f3594c;

    /* renamed from: d */
    private View f3595d;

    /* renamed from: e */
    private View f3596e;

    /* renamed from: f */
    private View f3597f;

    /* renamed from: g */
    private View f3598g;

    @UiThread
    public HomepageActivity_ViewBinding(final HomepageActivity homepageActivity, View view) {
        this.f3593b = homepageActivity;
        View m12800a = Utils.m12800a(view, R.id.ivUsrImg, "field 'ivUsrImg' and method 'onClicked'");
        homepageActivity.ivUsrImg = (ImageView) Utils.m12798b(m12800a, R.id.ivUsrImg, "field 'ivUsrImg'", ImageView.class);
        this.f3594c = m12800a;
        m12800a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.navatics.app.activities.HomepageActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* renamed from: a */
            public void mo7462a(View view2) {
                homepageActivity.onClicked(view2);
            }
        });
        View m12800a2 = Utils.m12800a(view, R.id.ivMediaLibraryIcon, "field 'ivMediaLibraryIcon' and method 'onClicked'");
        homepageActivity.ivMediaLibraryIcon = (ImageView) Utils.m12798b(m12800a2, R.id.ivMediaLibraryIcon, "field 'ivMediaLibraryIcon'", ImageView.class);
        this.f3595d = m12800a2;
        m12800a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.navatics.app.activities.HomepageActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* renamed from: a */
            public void mo7462a(View view2) {
                homepageActivity.onClicked(view2);
            }
        });
        View m12800a3 = Utils.m12800a(view, R.id.ivDiveLogIcon, "field 'ivDiveLogIcon' and method 'onClicked'");
        homepageActivity.ivDiveLogIcon = (ImageView) Utils.m12798b(m12800a3, R.id.ivDiveLogIcon, "field 'ivDiveLogIcon'", ImageView.class);
        this.f3596e = m12800a3;
        m12800a3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.navatics.app.activities.HomepageActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            /* renamed from: a */
            public void mo7462a(View view2) {
                homepageActivity.onClicked(view2);
            }
        });
        homepageActivity.selectorContainer = (RelativeLayout) Utils.m12799a(view, R.id.selectorContainer, "field 'selectorContainer'", RelativeLayout.class);
        View m12800a4 = Utils.m12800a(view, R.id.btnConnect, "field 'btnConnect' and method 'onClicked'");
        homepageActivity.btnConnect = (Button) Utils.m12798b(m12800a4, R.id.btnConnect, "field 'btnConnect'", Button.class);
        this.f3597f = m12800a4;
        m12800a4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.navatics.app.activities.HomepageActivity_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            /* renamed from: a */
            public void mo7462a(View view2) {
                homepageActivity.onClicked(view2);
            }
        });
        View m12800a5 = Utils.m12800a(view, R.id.ivSetting, "field 'ivSetting' and method 'onClicked'");
        homepageActivity.ivSetting = (ImageView) Utils.m12798b(m12800a5, R.id.ivSetting, "field 'ivSetting'", ImageView.class);
        this.f3598g = m12800a5;
        m12800a5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.navatics.app.activities.HomepageActivity_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            /* renamed from: a */
            public void mo7462a(View view2) {
                homepageActivity.onClicked(view2);
            }
        });
        homepageActivity.ivRobotImg = (ImageView) Utils.m12799a(view, R.id.ivRobotImg, "field 'ivRobotImg'", ImageView.class);
        homepageActivity.tvConnSignal = (TextView) Utils.m12799a(view, R.id.tvConnSignal, "field 'tvConnSignal'", TextView.class);
        homepageActivity.ivTitleIcon = (ImageView) Utils.m12799a(view, R.id.ivTitleIcon, "field 'ivTitleIcon'", ImageView.class);
        homepageActivity.rootLayout = (RelativeLayout) Utils.m12799a(view, R.id.rootLayout, "field 'rootLayout'", RelativeLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        HomepageActivity homepageActivity = this.f3593b;
        if (homepageActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3593b = null;
        homepageActivity.ivUsrImg = null;
        homepageActivity.ivMediaLibraryIcon = null;
        homepageActivity.ivDiveLogIcon = null;
        homepageActivity.selectorContainer = null;
        homepageActivity.btnConnect = null;
        homepageActivity.ivSetting = null;
        homepageActivity.ivRobotImg = null;
        homepageActivity.tvConnSignal = null;
        homepageActivity.ivTitleIcon = null;
        homepageActivity.rootLayout = null;
        this.f3594c.setOnClickListener(null);
        this.f3594c = null;
        this.f3595d.setOnClickListener(null);
        this.f3595d = null;
        this.f3596e.setOnClickListener(null);
        this.f3596e = null;
        this.f3597f.setOnClickListener(null);
        this.f3597f = null;
        this.f3598g.setOnClickListener(null);
        this.f3598g = null;
    }
}
