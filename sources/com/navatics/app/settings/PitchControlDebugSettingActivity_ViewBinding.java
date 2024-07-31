package com.navatics.app.settings;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class PitchControlDebugSettingActivity_ViewBinding implements Unbinder {

    /* renamed from: b */
    private PitchControlDebugSettingActivity f5073b;

    @UiThread
    public PitchControlDebugSettingActivity_ViewBinding(PitchControlDebugSettingActivity pitchControlDebugSettingActivity, View view) {
        this.f5073b = pitchControlDebugSettingActivity;
        pitchControlDebugSettingActivity.sbPitchSetting = (SeekBar) Utils.m12799a(view, R.id.sbPitchSetting, "field 'sbPitchSetting'", SeekBar.class);
        pitchControlDebugSettingActivity.tvPitchValue = (TextView) Utils.m12799a(view, R.id.tvPitchValue, "field 'tvPitchValue'", TextView.class);
        pitchControlDebugSettingActivity.btnPitchSend = (Button) Utils.m12799a(view, R.id.btnPitchSend, "field 'btnPitchSend'", Button.class);
        pitchControlDebugSettingActivity.tvStateQuaternion = (TextView) Utils.m12799a(view, R.id.tvStateQuaternion, "field 'tvStateQuaternion'", TextView.class);
        pitchControlDebugSettingActivity.tvStatePitch = (TextView) Utils.m12799a(view, R.id.tvStatePitch, "field 'tvStatePitch'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        PitchControlDebugSettingActivity pitchControlDebugSettingActivity = this.f5073b;
        if (pitchControlDebugSettingActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f5073b = null;
        pitchControlDebugSettingActivity.sbPitchSetting = null;
        pitchControlDebugSettingActivity.tvPitchValue = null;
        pitchControlDebugSettingActivity.btnPitchSend = null;
        pitchControlDebugSettingActivity.tvStateQuaternion = null;
        pitchControlDebugSettingActivity.tvStatePitch = null;
    }
}
