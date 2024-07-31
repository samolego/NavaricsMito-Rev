package com.navatics.app.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.navatics.app.R;
import com.navatics.app.framework.international.InternationalTextView;
import com.navatics.app.player.widget.media.IjkVideoView;
import com.navatics.app.widget.ContentLayout;
import com.navatics.app.widget.InfoHoverView2;
import com.navatics.app.widget.LayoutHelper;
import com.navatics.app.widget.MorphingImageButton;
import com.navatics.app.widget.NvSurfacePreview;
import com.navatics.app.widget.PitchView;
import com.navatics.app.widget.PreviewLoadingOverlay;
import com.navatics.app.widget.PreviewRoot;
import com.navatics.app.widget.RobotCompass;
import com.navatics.app.widget.ShadowView;
import com.navatics.app.widget.UserGuideView;
import com.navatics.app.widget.xbar.XBar;

/* loaded from: classes.dex */
public class PreviewActivityV2_ViewBinding implements Unbinder {

    /* renamed from: b */
    private PreviewActivityV2 f3852b;

    @UiThread
    public PreviewActivityV2_ViewBinding(PreviewActivityV2 previewActivityV2, View view) {
        this.f3852b = previewActivityV2;
        previewActivityV2.previewRoot = (PreviewRoot) Utils.m12799a(view, R.id.contentContainer, "field 'previewRoot'", PreviewRoot.class);
        previewActivityV2.contentLayout = (ContentLayout) Utils.m12799a(view, R.id.contentLayout, "field 'contentLayout'", ContentLayout.class);
        previewActivityV2.topShadowBackground = (ShadowView) Utils.m12799a(view, R.id.topShadowBackground, "field 'topShadowBackground'", ShadowView.class);
        previewActivityV2.bottomShadowBackground = (ShadowView) Utils.m12799a(view, R.id.bottomShadowBackground, "field 'bottomShadowBackground'", ShadowView.class);
        previewActivityV2.loadingOverlay = (PreviewLoadingOverlay) Utils.m12799a(view, R.id.loadingOverlay, "field 'loadingOverlay'", PreviewLoadingOverlay.class);
        previewActivityV2.rlBatteryContainer = (RelativeLayout) Utils.m12799a(view, R.id.batteryContainer, "field 'rlBatteryContainer'", RelativeLayout.class);
        previewActivityV2.llLedStatusContainer = (LinearLayout) Utils.m12799a(view, R.id.ledStatusContainer, "field 'llLedStatusContainer'", LinearLayout.class);
        previewActivityV2.mRightCtrlPanel = (RelativeLayout) Utils.m12799a(view, R.id.rightCtrlPanel, "field 'mRightCtrlPanel'", RelativeLayout.class);
        previewActivityV2.streamingView = (IjkVideoView) Utils.m12799a(view, R.id.streamingView, "field 'streamingView'", IjkVideoView.class);
        previewActivityV2.layoutHelper = (LayoutHelper) Utils.m12799a(view, R.id.layoutHelper, "field 'layoutHelper'", LayoutHelper.class);
        previewActivityV2.surfaceStreamingView = (NvSurfacePreview) Utils.m12799a(view, R.id.surfaceStreamingView, "field 'surfaceStreamingView'", NvSurfacePreview.class);
        previewActivityV2.tvTemperature = (InternationalTextView) Utils.m12799a(view, R.id.tvTempText, "field 'tvTemperature'", InternationalTextView.class);
        previewActivityV2.ivLedStatus = (ImageView) Utils.m12799a(view, R.id.ivLEDStatus, "field 'ivLedStatus'", ImageView.class);
        previewActivityV2.tvBatteryRobot = (TextView) Utils.m12799a(view, R.id.tvBatteryRobot, "field 'tvBatteryRobot'", TextView.class);
        previewActivityV2.tvBatteryBouy = (TextView) Utils.m12799a(view, R.id.tvBatteryBouy, "field 'tvBatteryBouy'", TextView.class);
        previewActivityV2.tvBatteryRemote = (TextView) Utils.m12799a(view, R.id.tvBatteryRemote, "field 'tvBatteryRemote'", TextView.class);
        previewActivityV2.ivBuoyStatus = (ImageView) Utils.m12799a(view, R.id.ivBuoyStatus, "field 'ivBuoyStatus'", ImageView.class);
        previewActivityV2.tvNoConnText = (TextView) Utils.m12799a(view, R.id.tvNoConnText, "field 'tvNoConnText'", TextView.class);
        previewActivityV2.preview_back = (ImageView) Utils.m12799a(view, R.id.preview_back, "field 'preview_back'", ImageView.class);
        previewActivityV2.ivImagePreview = (ImageView) Utils.m12799a(view, R.id.ivImagePreview, "field 'ivImagePreview'", ImageView.class);
        previewActivityV2.tvRecordTime = (TextView) Utils.m12799a(view, R.id.tvRecordTime, "field 'tvRecordTime'", TextView.class);
        previewActivityV2.ivRecord = (MorphingImageButton) Utils.m12799a(view, R.id.ivRecord, "field 'ivRecord'", MorphingImageButton.class);
        previewActivityV2.motorInfoContainer = (ViewGroup) Utils.m12799a(view, R.id.motorInfoContainer, "field 'motorInfoContainer'", ViewGroup.class);
        previewActivityV2.ivMotorEnableStatus = (ImageView) Utils.m12799a(view, R.id.ivMotorEnableStatus, "field 'ivMotorEnableStatus'", ImageView.class);
        previewActivityV2.tvMotorFront = (TextView) Utils.m12799a(view, R.id.tvMotorFront, "field 'tvMotorFront'", TextView.class);
        previewActivityV2.tvMotorBehind = (TextView) Utils.m12799a(view, R.id.tvMotorBehind, "field 'tvMotorBehind'", TextView.class);
        previewActivityV2.tvMotorRight = (TextView) Utils.m12799a(view, R.id.tvMotorRight, "field 'tvMotorRight'", TextView.class);
        previewActivityV2.tvMotorLeft = (TextView) Utils.m12799a(view, R.id.tvMotorLeft, "field 'tvMotorLeft'", TextView.class);
        previewActivityV2.tvAltitudeRef = (InternationalTextView) Utils.m12799a(view, R.id.tvAltitudeRef, "field 'tvAltitudeRef'", InternationalTextView.class);
        previewActivityV2.tvAltitudeCurrent = (InternationalTextView) Utils.m12799a(view, R.id.tvAltitudeCurrent, "field 'tvAltitudeCurrent'", InternationalTextView.class);
        previewActivityV2.mRobotCompass = (RobotCompass) Utils.m12799a(view, R.id.ivRadarPanel, "field 'mRobotCompass'", RobotCompass.class);
        previewActivityV2.mPitchView = (PitchView) Utils.m12799a(view, R.id.ivPitchPanel, "field 'mPitchView'", PitchView.class);
        previewActivityV2.infoHoverView = (InfoHoverView2) Utils.m12799a(view, R.id.infoHoverView, "field 'infoHoverView'", InfoHoverView2.class);
        previewActivityV2.mTopContainer = (ViewGroup) Utils.m12799a(view, R.id.topContainer, "field 'mTopContainer'", ViewGroup.class);
        previewActivityV2.mBottomContainer = (ViewGroup) Utils.m12799a(view, R.id.bottomContainer, "field 'mBottomContainer'", ViewGroup.class);
        previewActivityV2.mSettingContent = Utils.m12800a(view, R.id.settingContent, "field 'mSettingContent'");
        previewActivityV2.mSettingContainer = (ViewGroup) Utils.m12799a(view, R.id.settingContainer, "field 'mSettingContainer'", ViewGroup.class);
        previewActivityV2.ivSetting = (ImageView) Utils.m12799a(view, R.id.ivSetting, "field 'ivSetting'", ImageView.class);
        previewActivityV2.ivCameraSetting = (ImageView) Utils.m12799a(view, R.id.ivCameraSetting, "field 'ivCameraSetting'", ImageView.class);
        previewActivityV2.ivCloseSetting = (ImageView) Utils.m12799a(view, R.id.ivCloseSetting, "field 'ivCloseSetting'", ImageView.class);
        previewActivityV2.ivParametersSetting = (ImageView) Utils.m12799a(view, R.id.ivParametersSetting, "field 'ivParametersSetting'", ImageView.class);
        previewActivityV2.ivIMUSetting = (ImageView) Utils.m12799a(view, R.id.ivIMUSetting, "field 'ivIMUSetting'", ImageView.class);
        previewActivityV2.ivDebugSetting = (ImageView) Utils.m12799a(view, R.id.ivDebugSetting, "field 'ivDebugSetting'", ImageView.class);
        previewActivityV2.ivCameraExposureMode = (ImageView) Utils.m12799a(view, R.id.ivCameraExposureMode, "field 'ivCameraExposureMode'", ImageView.class);
        previewActivityV2.ivNoSdIcon = (ImageView) Utils.m12799a(view, R.id.ivNoSdIcon, "field 'ivNoSdIcon'", ImageView.class);
        previewActivityV2.ivCameraMode = (ImageView) Utils.m12799a(view, R.id.ivCameraMode, "field 'ivCameraMode'", ImageView.class);
        previewActivityV2.xbarPitch = (XBar) Utils.m12799a(view, R.id.xbarPitch, "field 'xbarPitch'", XBar.class);
        previewActivityV2.userGuideView = (UserGuideView) Utils.m12799a(view, R.id.ug_view, "field 'userGuideView'", UserGuideView.class);
        previewActivityV2.rlUserGuide = (RelativeLayout) Utils.m12799a(view, R.id.rl_userGuide, "field 'rlUserGuide'", RelativeLayout.class);
        previewActivityV2.rlGuideHint = (RelativeLayout) Utils.m12799a(view, R.id.rl_guide_hint, "field 'rlGuideHint'", RelativeLayout.class);
        previewActivityV2.tvSkip = (TextView) Utils.m12799a(view, R.id.tv_skip, "field 'tvSkip'", TextView.class);
        previewActivityV2.btnSkip = (TextView) Utils.m12799a(view, R.id.btn_skip, "field 'btnSkip'", TextView.class);
        previewActivityV2.tvNext = (TextView) Utils.m12799a(view, R.id.btn_next, "field 'tvNext'", TextView.class);
        previewActivityV2.btnStart = (TextView) Utils.m12799a(view, R.id.btn_start, "field 'btnStart'", TextView.class);
        previewActivityV2.rlAltitudeContainer = (RelativeLayout) Utils.m12799a(view, R.id.altitudeContainer, "field 'rlAltitudeContainer'", RelativeLayout.class);
        previewActivityV2.constraintLayout = (ConstraintLayout) Utils.m12799a(view, R.id.view_compass_calibrate, "field 'constraintLayout'", ConstraintLayout.class);
        previewActivityV2.ivCompassClose = (ImageView) Utils.m12799a(view, R.id.ivCompassClose, "field 'ivCompassClose'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        PreviewActivityV2 previewActivityV2 = this.f3852b;
        if (previewActivityV2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3852b = null;
        previewActivityV2.previewRoot = null;
        previewActivityV2.contentLayout = null;
        previewActivityV2.topShadowBackground = null;
        previewActivityV2.bottomShadowBackground = null;
        previewActivityV2.loadingOverlay = null;
        previewActivityV2.rlBatteryContainer = null;
        previewActivityV2.llLedStatusContainer = null;
        previewActivityV2.mRightCtrlPanel = null;
        previewActivityV2.streamingView = null;
        previewActivityV2.layoutHelper = null;
        previewActivityV2.surfaceStreamingView = null;
        previewActivityV2.tvTemperature = null;
        previewActivityV2.ivLedStatus = null;
        previewActivityV2.tvBatteryRobot = null;
        previewActivityV2.tvBatteryBouy = null;
        previewActivityV2.tvBatteryRemote = null;
        previewActivityV2.ivBuoyStatus = null;
        previewActivityV2.tvNoConnText = null;
        previewActivityV2.preview_back = null;
        previewActivityV2.ivImagePreview = null;
        previewActivityV2.tvRecordTime = null;
        previewActivityV2.ivRecord = null;
        previewActivityV2.motorInfoContainer = null;
        previewActivityV2.ivMotorEnableStatus = null;
        previewActivityV2.tvMotorFront = null;
        previewActivityV2.tvMotorBehind = null;
        previewActivityV2.tvMotorRight = null;
        previewActivityV2.tvMotorLeft = null;
        previewActivityV2.tvAltitudeRef = null;
        previewActivityV2.tvAltitudeCurrent = null;
        previewActivityV2.mRobotCompass = null;
        previewActivityV2.mPitchView = null;
        previewActivityV2.infoHoverView = null;
        previewActivityV2.mTopContainer = null;
        previewActivityV2.mBottomContainer = null;
        previewActivityV2.mSettingContent = null;
        previewActivityV2.mSettingContainer = null;
        previewActivityV2.ivSetting = null;
        previewActivityV2.ivCameraSetting = null;
        previewActivityV2.ivCloseSetting = null;
        previewActivityV2.ivParametersSetting = null;
        previewActivityV2.ivIMUSetting = null;
        previewActivityV2.ivDebugSetting = null;
        previewActivityV2.ivCameraExposureMode = null;
        previewActivityV2.ivNoSdIcon = null;
        previewActivityV2.ivCameraMode = null;
        previewActivityV2.xbarPitch = null;
        previewActivityV2.userGuideView = null;
        previewActivityV2.rlUserGuide = null;
        previewActivityV2.rlGuideHint = null;
        previewActivityV2.tvSkip = null;
        previewActivityV2.btnSkip = null;
        previewActivityV2.tvNext = null;
        previewActivityV2.btnStart = null;
        previewActivityV2.rlAltitudeContainer = null;
        previewActivityV2.constraintLayout = null;
        previewActivityV2.ivCompassClose = null;
    }
}
