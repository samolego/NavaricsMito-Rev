package com.navatics.app.activities.test;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.navatics.app.R;
import com.navatics.app.widget.PreviewLoadingOverlay;

/* loaded from: classes.dex */
public class CmdTestActivity_ViewBinding implements Unbinder {

    /* renamed from: b */
    private CmdTestActivity f3997b;

    /* renamed from: c */
    private View f3998c;

    /* renamed from: d */
    private View f3999d;

    @UiThread
    public CmdTestActivity_ViewBinding(final CmdTestActivity cmdTestActivity, View view) {
        this.f3997b = cmdTestActivity;
        cmdTestActivity.recordStart = (Switch) Utils.m12799a(view, R.id.recordStart, "field 'recordStart'", Switch.class);
        cmdTestActivity.setFPS = (Switch) Utils.m12799a(view, R.id.setFPS, "field 'setFPS'", Switch.class);
        cmdTestActivity.setShutterSpeed = (Switch) Utils.m12799a(view, R.id.setShutterSpeed, "field 'setShutterSpeed'", Switch.class);
        cmdTestActivity.setWBValue = (Switch) Utils.m12799a(view, R.id.setWBValue, "field 'setWBValue'", Switch.class);
        cmdTestActivity.setISO = (Switch) Utils.m12799a(view, R.id.setISO, "field 'setISO'", Switch.class);
        cmdTestActivity.setRes = (Switch) Utils.m12799a(view, R.id.setRes, "field 'setRes'", Switch.class);
        cmdTestActivity.setWideAngle = (Switch) Utils.m12799a(view, R.id.setWideAngle, "field 'setWideAngle'", Switch.class);
        cmdTestActivity.setExposureValue = (Switch) Utils.m12799a(view, R.id.setExposureValue, "field 'setExposureValue'", Switch.class);
        cmdTestActivity.setExposureMode = (Switch) Utils.m12799a(view, R.id.setExposureMode, "field 'setExposureMode'", Switch.class);
        cmdTestActivity.setWBMode = (Switch) Utils.m12799a(view, R.id.setWBMode, "field 'setWBMode'", Switch.class);
        cmdTestActivity.recordStop = (Switch) Utils.m12799a(view, R.id.recordStop, "field 'recordStop'", Switch.class);
        cmdTestActivity.takePhoto = (Switch) Utils.m12799a(view, R.id.takePhoto, "field 'takePhoto'", Switch.class);
        cmdTestActivity.switchCameraMode = (Switch) Utils.m12799a(view, R.id.switchCameraMode, "field 'switchCameraMode'", Switch.class);
        cmdTestActivity.getCameraMode = (Switch) Utils.m12799a(view, R.id.getCameraMode, "field 'getCameraMode'", Switch.class);
        cmdTestActivity.getRes = (Switch) Utils.m12799a(view, R.id.getRes, "field 'getRes'", Switch.class);
        cmdTestActivity.getFps = (Switch) Utils.m12799a(view, R.id.getFps, "field 'getFps'", Switch.class);
        cmdTestActivity.getWideAngleMode = (Switch) Utils.m12799a(view, R.id.getWideAngleMode, "field 'getWideAngleMode'", Switch.class);
        cmdTestActivity.getSdInfo = (Switch) Utils.m12799a(view, R.id.getSdInfo, "field 'getSdInfo'", Switch.class);
        cmdTestActivity.getExposeMode = (Switch) Utils.m12799a(view, R.id.getExposeMode, "field 'getExposeMode'", Switch.class);
        cmdTestActivity.getExposeValue = (Switch) Utils.m12799a(view, R.id.getExposeValue, "field 'getExposeValue'", Switch.class);
        cmdTestActivity.getShutterSpeed = (Switch) Utils.m12799a(view, R.id.getShutterSpeed, "field 'getShutterSpeed'", Switch.class);
        cmdTestActivity.getISO = (Switch) Utils.m12799a(view, R.id.getISO, "field 'getISO'", Switch.class);
        cmdTestActivity.getWBMode = (Switch) Utils.m12799a(view, R.id.getWBMode, "field 'getWBMode'", Switch.class);
        cmdTestActivity.getWBValue = (Switch) Utils.m12799a(view, R.id.getWBValue, "field 'getWBValue'", Switch.class);
        View m12800a = Utils.m12800a(view, R.id.btnSend, "field 'btnSend' and method 'onClick'");
        cmdTestActivity.btnSend = (Button) Utils.m12798b(m12800a, R.id.btnSend, "field 'btnSend'", Button.class);
        this.f3998c = m12800a;
        m12800a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.navatics.app.activities.test.CmdTestActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* renamed from: a */
            public void mo7462a(View view2) {
                cmdTestActivity.onClick(view2);
            }
        });
        View m12800a2 = Utils.m12800a(view, R.id.btnReset, "field 'btnReset' and method 'onClick'");
        cmdTestActivity.btnReset = (Button) Utils.m12798b(m12800a2, R.id.btnReset, "field 'btnReset'", Button.class);
        this.f3999d = m12800a2;
        m12800a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.navatics.app.activities.test.CmdTestActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* renamed from: a */
            public void mo7462a(View view2) {
                cmdTestActivity.onClick(view2);
            }
        });
        cmdTestActivity.loadingOverlay = (PreviewLoadingOverlay) Utils.m12799a(view, R.id.loadingOverlay, "field 'loadingOverlay'", PreviewLoadingOverlay.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        CmdTestActivity cmdTestActivity = this.f3997b;
        if (cmdTestActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3997b = null;
        cmdTestActivity.recordStart = null;
        cmdTestActivity.setFPS = null;
        cmdTestActivity.setShutterSpeed = null;
        cmdTestActivity.setWBValue = null;
        cmdTestActivity.setISO = null;
        cmdTestActivity.setRes = null;
        cmdTestActivity.setWideAngle = null;
        cmdTestActivity.setExposureValue = null;
        cmdTestActivity.setExposureMode = null;
        cmdTestActivity.setWBMode = null;
        cmdTestActivity.recordStop = null;
        cmdTestActivity.takePhoto = null;
        cmdTestActivity.switchCameraMode = null;
        cmdTestActivity.getCameraMode = null;
        cmdTestActivity.getRes = null;
        cmdTestActivity.getFps = null;
        cmdTestActivity.getWideAngleMode = null;
        cmdTestActivity.getSdInfo = null;
        cmdTestActivity.getExposeMode = null;
        cmdTestActivity.getExposeValue = null;
        cmdTestActivity.getShutterSpeed = null;
        cmdTestActivity.getISO = null;
        cmdTestActivity.getWBMode = null;
        cmdTestActivity.getWBValue = null;
        cmdTestActivity.btnSend = null;
        cmdTestActivity.btnReset = null;
        cmdTestActivity.loadingOverlay = null;
        this.f3998c.setOnClickListener(null);
        this.f3998c = null;
        this.f3999d.setOnClickListener(null);
        this.f3999d = null;
    }
}
