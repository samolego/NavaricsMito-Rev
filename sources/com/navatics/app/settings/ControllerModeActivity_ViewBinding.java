package com.navatics.app.settings;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class ControllerModeActivity_ViewBinding implements Unbinder {

    /* renamed from: b */
    private ControllerModeActivity f5037b;

    @UiThread
    public ControllerModeActivity_ViewBinding(ControllerModeActivity controllerModeActivity, View view) {
        this.f5037b = controllerModeActivity;
        controllerModeActivity.ivBack = (ImageView) Utils.m12799a(view, R.id.ivBack, "field 'ivBack'", ImageView.class);
        controllerModeActivity.ivTitle = (TextView) Utils.m12799a(view, R.id.ivTitle, "field 'ivTitle'", TextView.class);
        controllerModeActivity.rlMode1 = (RelativeLayout) Utils.m12799a(view, R.id.rl_mode1, "field 'rlMode1'", RelativeLayout.class);
        controllerModeActivity.rlMode2 = (RelativeLayout) Utils.m12799a(view, R.id.rl_mode2, "field 'rlMode2'", RelativeLayout.class);
        controllerModeActivity.rlMode3 = (RelativeLayout) Utils.m12799a(view, R.id.rl_mode3, "field 'rlMode3'", RelativeLayout.class);
        controllerModeActivity.tvMode1More = (TextView) Utils.m12799a(view, R.id.tv_mode1_more, "field 'tvMode1More'", TextView.class);
        controllerModeActivity.tvMode2More = (TextView) Utils.m12799a(view, R.id.tv_mode2_more, "field 'tvMode2More'", TextView.class);
        controllerModeActivity.tvMode3More = (TextView) Utils.m12799a(view, R.id.tv_mode3_more, "field 'tvMode3More'", TextView.class);
        controllerModeActivity.ivSelect1 = (ImageView) Utils.m12799a(view, R.id.iv_select1, "field 'ivSelect1'", ImageView.class);
        controllerModeActivity.ivSelect2 = (ImageView) Utils.m12799a(view, R.id.iv_select2, "field 'ivSelect2'", ImageView.class);
        controllerModeActivity.ivSelect3 = (ImageView) Utils.m12799a(view, R.id.iv_select3, "field 'ivSelect3'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        ControllerModeActivity controllerModeActivity = this.f5037b;
        if (controllerModeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f5037b = null;
        controllerModeActivity.ivBack = null;
        controllerModeActivity.ivTitle = null;
        controllerModeActivity.rlMode1 = null;
        controllerModeActivity.rlMode2 = null;
        controllerModeActivity.rlMode3 = null;
        controllerModeActivity.tvMode1More = null;
        controllerModeActivity.tvMode2More = null;
        controllerModeActivity.tvMode3More = null;
        controllerModeActivity.ivSelect1 = null;
        controllerModeActivity.ivSelect2 = null;
        controllerModeActivity.ivSelect3 = null;
    }
}
