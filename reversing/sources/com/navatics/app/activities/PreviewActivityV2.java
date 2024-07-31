package com.navatics.app.activities;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.annotation.CallSuper;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.p008v4.content.ContextCompat;
import android.support.p008v4.internal.view.SupportMenu;
import android.support.p008v4.view.InputDeviceCompat;
import android.support.p008v4.view.ViewCompat;
import android.support.p011v7.widget.helper.ItemTouchHelper;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.navatics.app.ICameraSettingManager;
import com.navatics.app.R;
import com.navatics.app.activities.PreviewActivityV2;
import com.navatics.app.fragments.CalibrateFragment;
import com.navatics.app.fragments.ParametersSettingFragment;
import com.navatics.app.framework.BuoyStatus;
import com.navatics.app.framework.GroundStation;
import com.navatics.app.framework.MotorStatus;
import com.navatics.app.framework.NvConnection;
import com.navatics.app.framework.NvRobot;
import com.navatics.app.framework.RobotStatus;
import com.navatics.app.framework.Settings;
import com.navatics.app.framework.divelog.DiveLogManager;
import com.navatics.app.framework.international.InternationalTextView;
import com.navatics.app.framework.provider.PhotosProvider;
import com.navatics.app.player.widget.media.IjkVideoView;
import com.navatics.app.utils.AnimatorEndListener;
import com.navatics.app.utils.AnimatorStartListener;
import com.navatics.app.utils.DialogFactory;
import com.navatics.app.utils.ImageUtils;
import com.navatics.app.utils.IntentUtils;
import com.navatics.app.utils.LayoutUtils;
import com.navatics.app.utils.MeasureUtil;
import com.navatics.app.widget.CommonDialog;
import com.navatics.app.widget.ContentLayout;
import com.navatics.app.widget.InfoHoverView2;
import com.navatics.app.widget.LayoutHelper;
import com.navatics.app.widget.MorphingImageButton;
import com.navatics.app.widget.NvNumberPicker;
import com.navatics.app.widget.NvSurfacePreview;
import com.navatics.app.widget.PitchView;
import com.navatics.app.widget.PreviewLoadingOverlay;
import com.navatics.app.widget.PreviewRoot;
import com.navatics.app.widget.RobotCompass;
import com.navatics.app.widget.ShadowView;
import com.navatics.app.widget.TextDrawable;
import com.navatics.app.widget.UserGuideView;
import com.navatics.app.widget.xbar.XBar;
import com.navatics.common.fileprovidercompat.FileProviderCompat;
import com.navatics.robot.protocol.CameraSettingMessage;
import com.navatics.robot.protocol.ErrorResponse;
import com.navatics.robot.transport.NvEventLoop;
import com.navatics.robot.transport.NvException;
import com.navatics.robot.transport.NvValue;
import com.navatics.robot.transport.StorageInfo;
import com.navatics.robot.transport.WhiteBalance;
import com.navatics.robot.transport.p063b.NvExceptionHandler;
import com.navatics.robot.transport.p063b.NvObserver;
import com.navatics.robot.transport.p063b.NvObserverExecutor;
import com.navatics.robot.utils.DpiUtils;
import com.navatics.robot.utils.RxTimer;
import com.p034dd.morphingbutton.MorphingButton;
import com.senseplay.sdk.config.CacheConfig;
import hu.akarnokd.rxjava2.consumers.CompletableConsumers;
import hu.akarnokd.rxjava2.consumers.ObservableConsumers;
import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.p093a.p095b.AndroidSchedulers;
import io.reactivex.p096b.Consumer;
import io.reactivex.p096b.InterfaceC2848a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.C3044k;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* loaded from: classes.dex */
public class PreviewActivityV2 extends OperationalRobotActivity {

    /* renamed from: b */
    protected static final C3044k f3730b = C3044k.m1564a(PreviewActivityV2.class);
    @BindView
    ShadowView bottomShadowBackground;
    @BindView
    TextView btnSkip;
    @BindView
    TextView btnStart;

    /* renamed from: c */
    boolean f3731c;
    @BindView
    ConstraintLayout constraintLayout;
    @BindView
    ContentLayout contentLayout;

    /* renamed from: d */
    ObjectAnimator f3732d;

    /* renamed from: h */
    Snackbar f3736h;

    /* renamed from: i */
    ParametersSettingFragment f3737i;
    @BindView
    InfoHoverView2 infoHoverView;
    @BindView
    ImageView ivBuoyStatus;
    @BindView
    ImageView ivCameraExposureMode;
    @BindView
    ImageView ivCameraMode;
    @BindView
    ImageView ivCameraSetting;
    @BindView
    ImageView ivCloseSetting;
    @BindView
    ImageView ivCompassClose;
    @BindView
    ImageView ivDebugSetting;
    @BindView
    ImageView ivIMUSetting;
    @BindView
    ImageView ivImagePreview;
    @BindView
    ImageView ivLedStatus;
    @BindView
    ImageView ivMotorEnableStatus;
    @BindView
    ImageView ivNoSdIcon;
    @BindView
    ImageView ivParametersSetting;
    @BindView
    MorphingImageButton ivRecord;
    @BindView
    ImageView ivSetting;

    /* renamed from: j */
    CalibrateFragment f3738j;
    @BindView
    LayoutHelper layoutHelper;
    @BindView
    LinearLayout llLedStatusContainer;
    @BindView
    PreviewLoadingOverlay loadingOverlay;

    /* renamed from: m */
    String f3741m;
    @BindView
    ViewGroup mBottomContainer;
    @BindView
    PitchView mPitchView;
    @BindView
    RelativeLayout mRightCtrlPanel;
    @BindView
    RobotCompass mRobotCompass;
    @BindView
    ViewGroup mSettingContainer;
    @BindView
    View mSettingContent;
    @BindView
    ViewGroup mTopContainer;
    @BindView
    ViewGroup motorInfoContainer;

    /* renamed from: n */
    int f3742n;

    /* renamed from: o */
    boolean f3743o;

    /* renamed from: p */
    boolean f3744p;
    @BindView
    PreviewRoot previewRoot;
    @BindView
    ImageView preview_back;

    /* renamed from: q */
    private ControlPanel f3745q;
    @BindView
    RelativeLayout rlAltitudeContainer;
    @BindView
    RelativeLayout rlBatteryContainer;
    @BindView
    RelativeLayout rlGuideHint;
    @BindView
    RelativeLayout rlUserGuide;

    /* renamed from: s */
    private Disposable f3747s;
    @BindView
    IjkVideoView streamingView;
    @BindView
    NvSurfacePreview surfaceStreamingView;
    @BindView
    ShadowView topShadowBackground;
    @BindView
    InternationalTextView tvAltitudeCurrent;
    @BindView
    InternationalTextView tvAltitudeRef;
    @BindView
    TextView tvBatteryBouy;
    @BindView
    TextView tvBatteryRemote;
    @BindView
    TextView tvBatteryRobot;
    @BindView
    TextView tvMotorBehind;
    @BindView
    TextView tvMotorFront;
    @BindView
    TextView tvMotorLeft;
    @BindView
    TextView tvMotorRight;
    @BindView
    TextView tvNext;
    @BindView
    TextView tvNoConnText;
    @BindView
    TextView tvRecordTime;
    @BindView
    TextView tvSkip;
    @BindView
    InternationalTextView tvTemperature;

    /* renamed from: u */
    private CommonDialog f3749u;
    @BindView
    UserGuideView userGuideView;

    /* renamed from: v */
    private CommonDialog f3750v;

    /* renamed from: w */
    private CommonDialog f3751w;
    @BindView
    XBar xbarPitch;

    /* renamed from: e */
    boolean f3733e = false;

    /* renamed from: f */
    boolean f3734f = false;

    /* renamed from: g */
    C1654h f3735g = new C1654h();

    /* renamed from: k */
    boolean f3739k = false;

    /* renamed from: l */
    boolean f3740l = false;

    /* renamed from: r */
    private CompositeDisposable f3746r = new CompositeDisposable();

    /* renamed from: t */
    private boolean f3748t = true;

    /* renamed from: x */
    private C1657k f3752x = new C1657k();

    /* renamed from: y */
    private HashMap<String, Object> f3753y = new HashMap<>();

    /* renamed from: z */
    private boolean f3754z = false;

    /* renamed from: l */
    public static /* synthetic */ void m9198l(View view) {
    }

    public static /* synthetic */ void lambda$1f49mVA4iJasfmyF1FOz6HQOUOI(PreviewActivityV2 previewActivityV2, CompletableEmitter completableEmitter, Integer num) {
        previewActivityV2.m9209i(completableEmitter, num);
    }

    public static /* synthetic */ void lambda$2G5O2WAjTQk60mPZ_U24lgoHotM(CompletableEmitter completableEmitter, Throwable th) {
        completableEmitter.tryOnError(th);
    }

    /* renamed from: lambda$2UrHOlHTfX7SZRxSr4UmKNGZQ-8 */
    public static /* synthetic */ void m12981lambda$2UrHOlHTfX7SZRxSr4UmKNGZQ8(PreviewActivityV2 previewActivityV2, Throwable th) {
        previewActivityV2.m9259a(th);
    }

    /* renamed from: lambda$39z52QCQBuYMBo-B_P7mecw4kXc */
    public static /* synthetic */ void m12982lambda$39z52QCQBuYMBoB_P7mecw4kXc(PreviewActivityV2 previewActivityV2, CompletableEmitter completableEmitter) {
        previewActivityV2.m9240d(completableEmitter);
    }

    public static /* synthetic */ void lambda$3HP5sJPhObPMbbzNtuH0MXbZiq4(CompletableEmitter completableEmitter, Throwable th) {
        completableEmitter.tryOnError(th);
    }

    public static /* synthetic */ void lambda$5Og3TIeMSEXTi1TSSJKVlmyuJOk(View view) {
        m9198l(view);
    }

    /* renamed from: lambda$5o0lZ2_enPmyhFGq3-yDU8x7TRs */
    public static /* synthetic */ void m12983lambda$5o0lZ2_enPmyhFGq3yDU8x7TRs(PreviewActivityV2 previewActivityV2, CompletableEmitter completableEmitter, Integer num) {
        previewActivityV2.m9262a(completableEmitter, num);
    }

    public static /* synthetic */ void lambda$9uXiRg80XLzs0MCbphhMZ4yPGwo(PreviewActivityV2 previewActivityV2, View view) {
        previewActivityV2.m9201k(view);
    }

    public static /* synthetic */ void lambda$B5W8Emp_w5CxQDypfz1Sg54Q5DM(PreviewActivityV2 previewActivityV2, CompletableEmitter completableEmitter) {
        previewActivityV2.m9253b(completableEmitter);
    }

    public static /* synthetic */ void lambda$BGFNr5jpKOUr_fdKA4GnXG_5fRI(PreviewActivityV2 previewActivityV2, View view) {
        previewActivityV2.m9242d(view);
    }

    public static /* synthetic */ void lambda$CdpZ2zI5xClR1QU9ZKMpoID_sdc(CompletableEmitter completableEmitter, Throwable th) {
        completableEmitter.onError(th);
    }

    public static /* synthetic */ void lambda$ChpPTwmCJ8MwPfOXHbDXvaiP_w0(PreviewActivityV2 previewActivityV2) {
        previewActivityV2.m9276K();
    }

    public static /* synthetic */ void lambda$IJ6oGwAIJh6flPcGxzqOepXaHn0(PreviewActivityV2 previewActivityV2, CompletableEmitter completableEmitter, Integer num) {
        previewActivityV2.m9239d(completableEmitter, num);
    }

    public static /* synthetic */ void lambda$IxozAHN3FT1jnNw_xRT9kh7O_zQ(PreviewActivityV2 previewActivityV2, View view) {
        previewActivityV2.m9212i(view);
    }

    /* renamed from: lambda$Kx-txoWSz38rpob7mz_YxIPiMBI */
    public static /* synthetic */ void m12984lambda$KxtxoWSz38rpob7mz_YxIPiMBI(PreviewActivityV2 previewActivityV2, CompletableEmitter completableEmitter) {
        previewActivityV2.m9246c(completableEmitter);
    }

    public static /* synthetic */ void lambda$MKzCLq_iNtKi6EkaPNQYaYL2TxA(PreviewActivityV2 previewActivityV2, View view) {
        previewActivityV2.m9218h(view);
    }

    public static /* synthetic */ void lambda$MdXVKQgXOwj_GN9hw6CR8ZolSM4(PreviewActivityV2 previewActivityV2, View view) {
        previewActivityV2.m9236e(view);
    }

    public static /* synthetic */ void lambda$NoFtczu0FCIPDELgOm2u1W6xPNU(CompletableEmitter completableEmitter, Throwable th) {
        completableEmitter.tryOnError(th);
    }

    /* renamed from: lambda$O-bJIlnGcsuSVjG1ZCs3HQJmS2Q */
    public static /* synthetic */ void m12985lambda$ObJIlnGcsuSVjG1ZCs3HQJmS2Q(PreviewActivityV2 previewActivityV2, View view) {
        previewActivityV2.m9272a(view);
    }

    public static /* synthetic */ void lambda$OddEoshGHSu7gNmbpCXfSqIqtUc(CompletableEmitter completableEmitter, Throwable th) {
        completableEmitter.tryOnError(th);
    }

    public static /* synthetic */ void lambda$QEtoYlfv_CsIakHtL86YKgGK3Zo(CompletableEmitter completableEmitter, Throwable th) {
        completableEmitter.tryOnError(th);
    }

    public static /* synthetic */ void lambda$UbRCvrQymlfQeZbxClpgmXFcOic(CompletableEmitter completableEmitter, Throwable th) {
        completableEmitter.tryOnError(th);
    }

    public static /* synthetic */ void lambda$YmaSK3cyQyaHrjB0Va206RBMDwM(PreviewActivityV2 previewActivityV2, CompletableEmitter completableEmitter) {
        previewActivityV2.m9216h(completableEmitter);
    }

    public static /* synthetic */ void lambda$Yz9kWHMJwItyt_cVTYoayqSs3q4(PreviewActivityV2 previewActivityV2, CompletableEmitter completableEmitter, Integer num) {
        previewActivityV2.m9221g(completableEmitter, num);
    }

    public static /* synthetic */ void lambda$_5YBvGcVNmABoI8KAWrFO9UUrpc(PreviewActivityV2 previewActivityV2, CompletableEmitter completableEmitter, Integer num) {
        previewActivityV2.m9227f(completableEmitter, num);
    }

    public static /* synthetic */ void lambda$_Ao43cyAsrW2Ns9HLS5NrRpE8dY(PreviewActivityV2 previewActivityV2, CompletableEmitter completableEmitter) {
        previewActivityV2.m9222g(completableEmitter);
    }

    /* renamed from: lambda$_gS-J9OvEp17HtzhMgwOip9-gh4 */
    public static /* synthetic */ void m12986lambda$_gSJ9OvEp17HtzhMgwOip9gh4(PreviewActivityV2 previewActivityV2, CompletableEmitter completableEmitter, Integer num) {
        previewActivityV2.m9252b(completableEmitter, num);
    }

    /* renamed from: lambda$ddM-bA-Avm969gYlfPvvE9lTblw */
    public static /* synthetic */ void m12987lambda$ddMbAAvm969gYlfPvvE9lTblw(PreviewActivityV2 previewActivityV2, CompletableEmitter completableEmitter) {
        previewActivityV2.m9228f(completableEmitter);
    }

    public static /* synthetic */ void lambda$edqiIRQSqX7_f9UxMgt2qfatCDQ(CompletableEmitter completableEmitter, Throwable th) {
        completableEmitter.tryOnError(th);
    }

    public static /* synthetic */ void lambda$ekadRQP3tTBfHvgQ5EMijG5zf9s(CompletableEmitter completableEmitter, Throwable th) {
        completableEmitter.tryOnError(th);
    }

    public static /* synthetic */ void lambda$hiVYzjkFZSmYdp8MxSZXhY59rk8(PreviewActivityV2 previewActivityV2, CompletableEmitter completableEmitter, Integer num) {
        previewActivityV2.m9245c(completableEmitter, num);
    }

    public static /* synthetic */ void lambda$htawnJ2p4XGJLYM88ksOdG5eE5Q(PreviewActivityV2 previewActivityV2) {
        previewActivityV2.m9274M();
    }

    /* renamed from: lambda$i8kdEA8WsU_2gUOw4DzYI-mVzow */
    public static /* synthetic */ void m12988lambda$i8kdEA8WsU_2gUOw4DzYImVzow(PreviewActivityV2 previewActivityV2, CompletableEmitter completableEmitter, WhiteBalance whiteBalance) {
        previewActivityV2.m9263a(completableEmitter, whiteBalance);
    }

    public static /* synthetic */ void lambda$iVAuNi4JmVObi1RPpmr9TE6nHxI(PreviewActivityV2 previewActivityV2, Long l) {
        previewActivityV2.m9260a(l);
    }

    /* renamed from: lambda$iZvbvSxQ7OT5Um9n7YhYM-YJESs */
    public static /* synthetic */ void m12989lambda$iZvbvSxQ7OT5Um9n7YhYMYJESs(PreviewActivityV2 previewActivityV2, View view) {
        previewActivityV2.m9206j(view);
    }

    public static /* synthetic */ void lambda$isugOtxkaKJvv88HpJW6WXlkinM(PreviewActivityV2 previewActivityV2, View view) {
        previewActivityV2.m9230f(view);
    }

    public static /* synthetic */ void lambda$jJ_LVO16g_Dj2MuHRk7BWcG23_k(PreviewActivityV2 previewActivityV2, CompletableEmitter completableEmitter) {
        previewActivityV2.m9264a(completableEmitter);
    }

    public static /* synthetic */ void lambda$jUaBrHZcVCh2CiBTOyJa2ChUZYM(PreviewActivityV2 previewActivityV2, View view) {
        previewActivityV2.m9249c(view);
    }

    public static /* synthetic */ void lambda$k7OlmCpONCo_Cnqh5De34e5QN4M(PreviewActivityV2 previewActivityV2) {
        previewActivityV2.m9275L();
    }

    public static /* synthetic */ void lambda$mVzTjEgRB9A1pF1sSqAWIF5eWn0(PreviewActivityV2 previewActivityV2, View view) {
        previewActivityV2.m9224g(view);
    }

    /* renamed from: lambda$mv7AWV6dV-l-zUmWaGivHvLJOQ0 */
    public static /* synthetic */ void m12990lambda$mv7AWV6dVlzUmWaGivHvLJOQ0(PreviewActivityV2 previewActivityV2, CompletableEmitter completableEmitter) {
        previewActivityV2.m9234e(completableEmitter);
    }

    public static /* synthetic */ void lambda$om_FiEjh4h_EER0D5kOBxoXcE5c(CompletableEmitter completableEmitter, Throwable th) {
        completableEmitter.tryOnError(th);
    }

    public static /* synthetic */ void lambda$qy1Bkf7vLZgIP3ucrRO5K5TRhLc(PreviewActivityV2 previewActivityV2, CompletableEmitter completableEmitter, Integer num) {
        previewActivityV2.m9215h(completableEmitter, num);
    }

    public static /* synthetic */ void lambda$s2V2jhzJW3nD_Q9yOBFnXL0Fuew(PreviewActivityV2 previewActivityV2, CompletableEmitter completableEmitter, Integer num) {
        previewActivityV2.m9233e(completableEmitter, num);
    }

    public static /* synthetic */ void lambda$soBRFMTZuGuslpA219CF_HGXJxQ(PreviewActivityV2 previewActivityV2, CompletableEmitter completableEmitter) {
        previewActivityV2.m9204j(completableEmitter);
    }

    public static /* synthetic */ void lambda$t3wCId7JfA4IsDD_xLrB9sGIpKY(PreviewActivityV2 previewActivityV2, CompletableEmitter completableEmitter) {
        previewActivityV2.m9210i(completableEmitter);
    }

    public static /* synthetic */ void lambda$wW3V_SCLjH4rE7dAca8ocbTwmsA(PreviewActivityV2 previewActivityV2, View view) {
        previewActivityV2.m9257b(view);
    }

    /* renamed from: lambda$yIcOC-VTMiF8ksp91rTMQRYGMBA */
    public static /* synthetic */ void m12991lambda$yIcOCVTMiF8ksp91rTMQRYGMBA(PreviewActivityV2 previewActivityV2, View view) {
        previewActivityV2.m9195m(view);
    }

    /* loaded from: classes.dex */
    public class WhiteBalancePanel_ViewBinding implements Unbinder {

        /* renamed from: b */
        private WhiteBalancePanel f3791b;

        @UiThread
        public WhiteBalancePanel_ViewBinding(WhiteBalancePanel whiteBalancePanel, View view) {
            this.f3791b = whiteBalancePanel;
            whiteBalancePanel.xbarWBManual = (XBar) Utils.m12799a(view, R.id.xbarWBManual, "field 'xbarWBManual'", XBar.class);
            whiteBalancePanel.ivWB_auto = (ImageView) Utils.m12799a(view, R.id.ivWB_auto, "field 'ivWB_auto'", ImageView.class);
            whiteBalancePanel.ivWB_manual = (ImageView) Utils.m12799a(view, R.id.ivWB_manual, "field 'ivWB_manual'", ImageView.class);
            whiteBalancePanel.ivWB_sunny = (ImageView) Utils.m12799a(view, R.id.ivWB_sunny, "field 'ivWB_sunny'", ImageView.class);
            whiteBalancePanel.ivWB_cloudy = (ImageView) Utils.m12799a(view, R.id.ivWB_cloudy, "field 'ivWB_cloudy'", ImageView.class);
            whiteBalancePanel.ivWB_warmlight = (ImageView) Utils.m12799a(view, R.id.ivWB_warmlight, "field 'ivWB_warmlight'", ImageView.class);
            whiteBalancePanel.ivWB_coldlight = (ImageView) Utils.m12799a(view, R.id.ivWB_coldlight, "field 'ivWB_coldlight'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        /* renamed from: a */
        public void mo7436a() {
            WhiteBalancePanel whiteBalancePanel = this.f3791b;
            if (whiteBalancePanel == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f3791b = null;
            whiteBalancePanel.xbarWBManual = null;
            whiteBalancePanel.ivWB_auto = null;
            whiteBalancePanel.ivWB_manual = null;
            whiteBalancePanel.ivWB_sunny = null;
            whiteBalancePanel.ivWB_cloudy = null;
            whiteBalancePanel.ivWB_warmlight = null;
            whiteBalancePanel.ivWB_coldlight = null;
        }
    }

    /* loaded from: classes.dex */
    public class ControlPanel_ViewBinding implements Unbinder {

        /* renamed from: b */
        private ControlPanel f3782b;

        @UiThread
        public ControlPanel_ViewBinding(ControlPanel controlPanel, View view) {
            this.f3782b = controlPanel;
            controlPanel.rightCtrlPanel = (RelativeLayout) Utils.m12799a(view, R.id.rightCtrlPanel, "field 'rightCtrlPanel'", RelativeLayout.class);
            controlPanel.rightCtrlPanelExpand = (RelativeLayout) Utils.m12799a(view, R.id.rightCtrlPanelExpand, "field 'rightCtrlPanelExpand'", RelativeLayout.class);
            controlPanel.cameraParametersContainer = (ViewGroup) Utils.m12799a(view, R.id.cameraParametersContainer, "field 'cameraParametersContainer'", ViewGroup.class);
            controlPanel.ivCameraMode = (ImageView) Utils.m12799a(view, R.id.ivCameraMode, "field 'ivCameraMode'", ImageView.class);
            controlPanel.ivCameraRes = (ImageView) Utils.m12799a(view, R.id.ivCameraResolution, "field 'ivCameraRes'", ImageView.class);
            controlPanel.ivCameraFPS = (ImageView) Utils.m12799a(view, R.id.ivCameraFPS, "field 'ivCameraFPS'", ImageView.class);
            controlPanel.ivCameraFOV = (ImageView) Utils.m12799a(view, R.id.ivCameraFOV, "field 'ivCameraFOV'", ImageView.class);
            controlPanel.ivCameraSD = (ImageView) Utils.m12799a(view, R.id.ivCameraSD, "field 'ivCameraSD'", ImageView.class);
            controlPanel.ivEVImage = (ImageView) Utils.m12799a(view, R.id.ivEVImage, "field 'ivEVImage'", ImageView.class);
            controlPanel.ivShutter = (ImageView) Utils.m12799a(view, R.id.ivShutter, "field 'ivShutter'", ImageView.class);
            controlPanel.ivISO = (ImageView) Utils.m12799a(view, R.id.ivISO, "field 'ivISO'", ImageView.class);
            controlPanel.ivWhiteBalance = (ImageView) Utils.m12799a(view, R.id.ivWhiteBalance, "field 'ivWhiteBalance'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        /* renamed from: a */
        public void mo7436a() {
            ControlPanel controlPanel = this.f3782b;
            if (controlPanel == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f3782b = null;
            controlPanel.rightCtrlPanel = null;
            controlPanel.rightCtrlPanelExpand = null;
            controlPanel.cameraParametersContainer = null;
            controlPanel.ivCameraMode = null;
            controlPanel.ivCameraRes = null;
            controlPanel.ivCameraFPS = null;
            controlPanel.ivCameraFOV = null;
            controlPanel.ivCameraSD = null;
            controlPanel.ivEVImage = null;
            controlPanel.ivShutter = null;
            controlPanel.ivISO = null;
            controlPanel.ivWhiteBalance = null;
        }
    }

    @Override // com.navatics.app.activities.LocationActivity, com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        getWindow().addFlags(128);
        getWindow().addFlags(512);
        getWindow().setNavigationBarColor(0);
        setContentView(R.layout.preview_activity_v2);
        ButterKnife.m12805a(this);
        findViewById(16908290).setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        m9185w();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m9219h();
    }

    @Override // com.navatics.app.activities.LocationActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f3754z = false;
    }

    /* renamed from: h */
    private void m9219h() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (defaultSharedPreferences.getBoolean("key_first_guide", true)) {
            SharedPreferences.Editor edit = defaultSharedPreferences.edit();
            edit.putBoolean("key_first_guide", false);
            edit.apply();
            m9213i();
        }
    }

    /* renamed from: i */
    private void m9213i() {
        this.rlUserGuide.setVisibility(0);
        this.userGuideView.m7072d();
        if (LayoutUtils.m7381b(this)) {
            ((RelativeLayout.LayoutParams) this.tvNext.getLayoutParams()).setMargins(0, 0, LayoutUtils.m7382a(this) + DpiUtils.m5887a(this, 18.0f), DpiUtils.m5887a(this, 23.0f));
        }
        this.userGuideView.setOnUserGuideListener(new UserGuideView.InterfaceC1955a() { // from class: com.navatics.app.activities.PreviewActivityV2.1
            @Override // com.navatics.app.widget.UserGuideView.InterfaceC1955a
            /* renamed from: a */
            public void mo7071a(UserGuideView userGuideView) {
            }

            {
                PreviewActivityV2.this = this;
            }

            @Override // com.navatics.app.widget.UserGuideView.InterfaceC1955a
            /* renamed from: b */
            public void mo7070b(UserGuideView userGuideView) {
                PreviewActivityV2 previewActivityV2 = PreviewActivityV2.this;
                previewActivityV2.f3740l = true;
                previewActivityV2.tvNext.setText(PreviewActivityV2.this.getString(R.string.done));
            }
        });
        this.btnSkip.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.PreviewActivityV2.5
            {
                PreviewActivityV2.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PreviewActivityV2.this.userGuideView.m7081b();
                PreviewActivityV2.this.rlUserGuide.setVisibility(8);
            }
        });
        this.btnStart.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.PreviewActivityV2.6
            {
                PreviewActivityV2.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PreviewActivityV2.this.rlGuideHint.setVisibility(8);
                PreviewActivityV2.this.userGuideView.m7086a(PreviewActivityV2.this.ivMotorEnableStatus, PreviewActivityV2.this.getString(R.string.motor_state_guide), PreviewActivityV2.this.getString(R.string.motor_state), DpiUtils.m5886b(PreviewActivityV2.this, 31.0f), 0, UserGuideView.Direction.LEFT, 3);
                PreviewActivityV2.this.userGuideView.m7086a(PreviewActivityV2.this.ivSetting, PreviewActivityV2.this.getString(R.string.mito_setting_guide), PreviewActivityV2.this.getString(R.string.mito_setting), -DpiUtils.m5886b(PreviewActivityV2.this, 85.0f), 0, UserGuideView.Direction.RIGHT, 5);
                PreviewActivityV2.this.userGuideView.m7086a(PreviewActivityV2.this.ivCameraSetting, PreviewActivityV2.this.getResources().getString(R.string.camera_settings_guide), PreviewActivityV2.this.getString(R.string.camera_settings), -DpiUtils.m5886b(PreviewActivityV2.this, 85.0f), 0, UserGuideView.Direction.RIGHT, 5);
                PreviewActivityV2.this.userGuideView.m7087a(PreviewActivityV2.this.rlBatteryContainer, PreviewActivityV2.this.getResources().getString(R.string.state_charge), 0, DpiUtils.m5886b(PreviewActivityV2.this, 25.0f), UserGuideView.Direction.TOP);
                LinkedHashMap<View, String> linkedHashMap = new LinkedHashMap<>(2);
                linkedHashMap.put(PreviewActivityV2.this.mPitchView, PreviewActivityV2.this.getResources().getString(R.string.pitch_angle));
                linkedHashMap.put(PreviewActivityV2.this.xbarPitch, PreviewActivityV2.this.getResources().getString(R.string.pitch_silder));
                LinkedHashMap<View, UserGuideView.Direction> linkedHashMap2 = new LinkedHashMap<>(2);
                linkedHashMap2.put(PreviewActivityV2.this.mPitchView, UserGuideView.Direction.BOTTOM);
                linkedHashMap2.put(PreviewActivityV2.this.xbarPitch, UserGuideView.Direction.RIGHT);
                PreviewActivityV2.this.userGuideView.m7077b(PreviewActivityV2.this.mPitchView, -DpiUtils.m5886b(PreviewActivityV2.this, 20.0f));
                PreviewActivityV2.this.userGuideView.m7093a(PreviewActivityV2.this.xbarPitch, -DpiUtils.m5886b(PreviewActivityV2.this, 20.0f));
                PreviewActivityV2.this.userGuideView.m7082a(linkedHashMap, linkedHashMap2);
                PreviewActivityV2.this.userGuideView.m7086a(PreviewActivityV2.this.rlAltitudeContainer, PreviewActivityV2.this.getResources().getString(R.string.current_depth_target_depth_guide), PreviewActivityV2.this.getString(R.string.current_depth_target_depth), 0, -DpiUtils.m5887a(PreviewActivityV2.this, 26.0f), UserGuideView.Direction.BOTTOM, 17);
                PreviewActivityV2.this.userGuideView.m7087a(PreviewActivityV2.this.llLedStatusContainer, PreviewActivityV2.this.getResources().getString(R.string.light_intensity), 0, -DpiUtils.m5886b(PreviewActivityV2.this, 40.0f), UserGuideView.Direction.BOTTOM);
                PreviewActivityV2.this.userGuideView.m7073c(null, R.drawable.description_remote);
                PreviewActivityV2.this.userGuideView.m7092a(LayoutInflater.from(PreviewActivityV2.this).inflate(R.layout.guide_escription_remote_bg, (ViewGroup) null, false), MeasureUtil.m7373a(PreviewActivityV2.this)[0], MeasureUtil.m7373a(PreviewActivityV2.this)[1], null);
                PreviewActivityV2.this.userGuideView.m7098a();
                PreviewActivityV2.this.tvSkip.setVisibility(0);
                PreviewActivityV2.this.tvNext.setVisibility(0);
            }
        });
        this.tvSkip.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.PreviewActivityV2.7
            {
                PreviewActivityV2.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PreviewActivityV2.this.rlUserGuide.setVisibility(8);
                PreviewActivityV2.this.userGuideView.m7081b();
            }
        });
        this.tvNext.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.PreviewActivityV2.8
            {
                PreviewActivityV2.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PreviewActivityV2.this.f3740l) {
                    PreviewActivityV2.this.userGuideView.m7075c();
                    return;
                }
                PreviewActivityV2.this.userGuideView.m7081b();
                PreviewActivityV2.this.rlUserGuide.setVisibility(8);
            }
        });
    }

    @Override // com.navatics.app.activities.LocationActivity, com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f3746r.dispose();
        this.f3746r.m3224a();
        NvRobot robot = getRobot();
        if (robot == null || !robot.m7681m()) {
            return;
        }
        robot.m7682l();
        m9280G();
    }

    /* renamed from: com.navatics.app.activities.PreviewActivityV2$c */
    /* loaded from: classes.dex */
    public class C1648c {

        /* renamed from: b */
        private Integer f3799b;

        /* renamed from: c */
        private Integer f3800c;

        /* renamed from: d */
        private Integer f3801d;

        /* renamed from: e */
        private Integer f3802e;

        /* renamed from: f */
        private Integer f3803f;

        /* renamed from: g */
        private Integer f3804g;

        /* renamed from: h */
        private Integer f3805h;

        /* renamed from: i */
        private Integer f3806i;

        /* renamed from: j */
        private Integer f3807j;

        /* renamed from: k */
        private WhiteBalance f3808k;

        public C1648c(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, WhiteBalance whiteBalance) {
            PreviewActivityV2.this = r1;
            this.f3799b = num;
            this.f3800c = num2;
            this.f3801d = num3;
            this.f3802e = num4;
            this.f3803f = num5;
            this.f3804g = num6;
            this.f3805h = num7;
            this.f3806i = num8;
            this.f3807j = num9;
            this.f3808k = whiteBalance;
        }

        /* renamed from: a */
        public Integer m9122a() {
            if (this.f3799b == null) {
                this.f3799b = Integer.valueOf(Settings.m8618a().m8610c("robot.camera.camera_mode"));
            }
            return this.f3799b;
        }

        /* renamed from: b */
        public Integer m9121b() {
            if (this.f3800c == null) {
                this.f3800c = Integer.valueOf(Settings.m8618a().m8610c("robot.camera.fps"));
            }
            return this.f3800c;
        }

        /* renamed from: c */
        public Integer m9120c() {
            if (this.f3801d == null) {
                this.f3801d = Integer.valueOf(Settings.m8618a().m8610c("robot.camera.res"));
            }
            return this.f3801d;
        }

        /* renamed from: d */
        public Integer m9119d() {
            if (this.f3802e == null) {
                this.f3802e = Integer.valueOf(Settings.m8618a().m8610c("robot.camera.fov"));
            }
            return this.f3802e;
        }

        /* renamed from: e */
        public Integer m9118e() {
            if (this.f3803f == null) {
                this.f3803f = Integer.valueOf(Settings.m8618a().m8610c("robot.camera.camera_mode"));
            }
            return this.f3803f;
        }

        /* renamed from: f */
        public Integer m9117f() {
            if (this.f3804g == null) {
                this.f3804g = Integer.valueOf(Settings.m8618a().m8610c("robot.camera.camera_mode"));
            }
            return this.f3804g;
        }

        /* renamed from: g */
        public Integer m9116g() {
            if (this.f3805h == null) {
                this.f3805h = Integer.valueOf(Settings.m8618a().m8610c("robot.camera.camera_mode"));
            }
            return this.f3805h;
        }

        /* renamed from: h */
        public Integer m9115h() {
            if (this.f3806i == null) {
                this.f3806i = Integer.valueOf(Settings.m8618a().m8610c("robot.camera.camera_mode"));
            }
            return this.f3806i;
        }

        /* renamed from: i */
        public Integer m9114i() {
            if (this.f3807j == null) {
                this.f3807j = Integer.valueOf(Settings.m8618a().m8610c("robot.camera.camera_mode"));
            }
            return this.f3807j;
        }

        /* renamed from: j */
        public WhiteBalance m9113j() {
            if (this.f3808k == null) {
                this.f3808k = new WhiteBalance(Settings.m8618a().m8610c("robot.camera.camera_mode"), Settings.m8618a().m8610c("robot.camera.camera_mode"));
            }
            return this.f3808k;
        }
    }

    /* renamed from: j */
    private void m9207j() {
        NvRobot robot = getRobot();
        if (!this.f3731c || robot == null) {
            return;
        }
        ((TableLayout) findViewById(R.id.hud_view)).setVisibility(8);
        this.streamingView.setVideoPath(getRobot().m7689h());
        this.streamingView.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() { // from class: com.navatics.app.activities.-$$Lambda$qdy93X3roHO7Tm3OTTc_p8Hcb30
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
            public final void onPrepared(IMediaPlayer iMediaPlayer) {
                iMediaPlayer.start();
            }
        });
    }

    /* renamed from: k */
    private void m9202k() {
        if (getRobot() != null) {
            f3730b.mo1511a((Object) "loadSettingFromRobot showLoadingCover ");
            m9237d(true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(m9197m());
            arrayList.add(m9188t());
            arrayList.add(m9189s());
            arrayList.add(m9190r());
            arrayList.add(m9191q());
            arrayList.add(m9192p());
            arrayList.add(m9193o());
            arrayList.add(m9194n());
            arrayList.add(m9187u());
            arrayList.add(m9186v());
            CompletableConsumers.m3494a(Completable.m3258a(arrayList).m3259a(AndroidSchedulers.m3250a()), this.f3746r, new InterfaceC2848a() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$htawnJ2p4XGJLYM88ksOdG5eE5Q
                @Override // io.reactivex.p096b.InterfaceC2848a
                public final void run() {
                    PreviewActivityV2.lambda$htawnJ2p4XGJLYM88ksOdG5eE5Q(PreviewActivityV2.this);
                }
            }, new Consumer() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$2UrHOlHTfX7SZRxSr4UmKNGZQ-8
                @Override // io.reactivex.p096b.Consumer
                public final void accept(Object obj) {
                    PreviewActivityV2.m12981lambda$2UrHOlHTfX7SZRxSr4UmKNGZQ8(PreviewActivityV2.this, (Throwable) obj);
                }
            });
        }
    }

    /* renamed from: M */
    public /* synthetic */ void m9274M() throws Exception {
        m9200l();
        m9237d(false);
        m9207j();
        f3730b.mo1511a((Object) "loadSettingFromRobot done. showLoadingCover false");
    }

    /* renamed from: a */
    public /* synthetic */ void m9259a(Throwable th) throws Exception {
        th.printStackTrace();
        m9200l();
        m9237d(false);
        m9207j();
        f3730b.mo1504b((Object) "loadSettingFromRobot err. showLoadingCover false");
    }

    /* renamed from: l */
    private void m9200l() {
        this.f3745q.m9176a(new C1648c((Integer) this.f3753y.get("camera_mode"), (Integer) this.f3753y.get("fps"), (Integer) this.f3753y.get("res"), (Integer) this.f3753y.get("fov"), (Integer) this.f3753y.get("exposure_mode"), (Integer) this.f3753y.get("exposure_value"), (Integer) this.f3753y.get("iso"), (Integer) this.f3753y.get("shutter_speed"), (Integer) this.f3753y.get("wb_mode"), (WhiteBalance) this.f3753y.get("wb_value")));
    }

    /* renamed from: m */
    private Completable m9197m() {
        return Completable.m3260a(new CompletableOnSubscribe() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$soBRFMTZuGuslpA219CF_HGXJxQ
            @Override // io.reactivex.CompletableOnSubscribe
            public final void subscribe(CompletableEmitter completableEmitter) {
                PreviewActivityV2.lambda$soBRFMTZuGuslpA219CF_HGXJxQ(PreviewActivityV2.this, completableEmitter);
            }
        });
    }

    /* renamed from: j */
    public /* synthetic */ void m9204j(final CompletableEmitter completableEmitter) throws Exception {
        NvRobot robot = getRobot();
        if (robot == null) {
            completableEmitter.onError(new RuntimeException("getCameraMode but not connected"));
        } else {
            robot.m7675s().mo6312a(new NvObserver() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$1f49mVA4iJasfmyF1FOz6HQOUOI
                @Override // com.navatics.robot.transport.p063b.NvObserver
                public final void onNext(Object obj) {
                    PreviewActivityV2.lambda$1f49mVA4iJasfmyF1FOz6HQOUOI(PreviewActivityV2.this, completableEmitter, (Integer) obj);
                }
            }, new NvExceptionHandler() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$CdpZ2zI5xClR1QU9ZKMpoID_sdc
                @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                public final void onError(Throwable th) {
                    PreviewActivityV2.lambda$CdpZ2zI5xClR1QU9ZKMpoID_sdc(CompletableEmitter.this, th);
                }
            });
        }
    }

    /* renamed from: i */
    public /* synthetic */ void m9209i(CompletableEmitter completableEmitter, Integer num) throws Exception {
        C3044k c3044k = f3730b;
        c3044k.mo1511a((Object) ("getCameraMode value : " + num));
        Log.v("layout_debug", "getCameraMode value : " + num);
        this.f3753y.put("camera_mode", num);
        completableEmitter.onComplete();
    }

    /* renamed from: n */
    private Completable m9194n() {
        return Completable.m3260a(new CompletableOnSubscribe() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$t3wCId7JfA4IsDD_xLrB9sGIpKY
            @Override // io.reactivex.CompletableOnSubscribe
            public final void subscribe(CompletableEmitter completableEmitter) {
                PreviewActivityV2.lambda$t3wCId7JfA4IsDD_xLrB9sGIpKY(PreviewActivityV2.this, completableEmitter);
            }
        });
    }

    /* renamed from: i */
    public /* synthetic */ void m9210i(final CompletableEmitter completableEmitter) throws Exception {
        NvRobot robot = getRobot();
        if (robot == null) {
            completableEmitter.onError(new RuntimeException("getShutterSpeed but not connected"));
        } else {
            robot.m7723A().mo6312a(new NvObserver() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$qy1Bkf7vLZgIP3ucrRO5K5TRhLc
                @Override // com.navatics.robot.transport.p063b.NvObserver
                public final void onNext(Object obj) {
                    PreviewActivityV2.lambda$qy1Bkf7vLZgIP3ucrRO5K5TRhLc(PreviewActivityV2.this, completableEmitter, (Integer) obj);
                }
            }, new NvExceptionHandler() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$ekadRQP3tTBfHvgQ5EMijG5zf9s
                @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                public final void onError(Throwable th) {
                    PreviewActivityV2.lambda$ekadRQP3tTBfHvgQ5EMijG5zf9s(CompletableEmitter.this, th);
                }
            });
        }
    }

    /* renamed from: h */
    public /* synthetic */ void m9215h(CompletableEmitter completableEmitter, Integer num) throws Exception {
        C3044k c3044k = f3730b;
        c3044k.mo1511a((Object) ("getShutterSpeed value : " + num));
        this.f3753y.put("shutter_speed", num);
        completableEmitter.onComplete();
    }

    /* renamed from: o */
    private Completable m9193o() {
        return Completable.m3260a(new CompletableOnSubscribe() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$YmaSK3cyQyaHrjB0Va206RBMDwM
            @Override // io.reactivex.CompletableOnSubscribe
            public final void subscribe(CompletableEmitter completableEmitter) {
                PreviewActivityV2.lambda$YmaSK3cyQyaHrjB0Va206RBMDwM(PreviewActivityV2.this, completableEmitter);
            }
        });
    }

    /* renamed from: h */
    public /* synthetic */ void m9216h(final CompletableEmitter completableEmitter) throws Exception {
        NvRobot robot = getRobot();
        if (robot == null) {
            completableEmitter.onError(new RuntimeException("getISO but not connected"));
        } else {
            robot.m7722B().mo6312a(new NvObserver() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$Yz9kWHMJwItyt_cVTYoayqSs3q4
                @Override // com.navatics.robot.transport.p063b.NvObserver
                public final void onNext(Object obj) {
                    PreviewActivityV2.lambda$Yz9kWHMJwItyt_cVTYoayqSs3q4(PreviewActivityV2.this, completableEmitter, (Integer) obj);
                }
            }, new NvExceptionHandler() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$om_FiEjh4h_EER0D5kOBxoXcE5c
                @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                public final void onError(Throwable th) {
                    PreviewActivityV2.lambda$om_FiEjh4h_EER0D5kOBxoXcE5c(CompletableEmitter.this, th);
                }
            });
        }
    }

    /* renamed from: g */
    public /* synthetic */ void m9221g(CompletableEmitter completableEmitter, Integer num) throws Exception {
        C3044k c3044k = f3730b;
        c3044k.mo1511a((Object) ("getISO value : " + num));
        this.f3753y.put("iso", num);
        completableEmitter.onComplete();
    }

    /* renamed from: p */
    private Completable m9192p() {
        return Completable.m3260a(new CompletableOnSubscribe() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$_Ao43cyAsrW2Ns9HLS5NrRpE8dY
            @Override // io.reactivex.CompletableOnSubscribe
            public final void subscribe(CompletableEmitter completableEmitter) {
                PreviewActivityV2.lambda$_Ao43cyAsrW2Ns9HLS5NrRpE8dY(PreviewActivityV2.this, completableEmitter);
            }
        });
    }

    /* renamed from: g */
    public /* synthetic */ void m9222g(final CompletableEmitter completableEmitter) throws Exception {
        NvRobot robot = getRobot();
        if (robot == null) {
            completableEmitter.onError(new RuntimeException("getExposureValue but not connected"));
        } else {
            robot.m7668z().mo6312a(new NvObserver() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$_5YBvGcVNmABoI8KAWrFO9UUrpc
                @Override // com.navatics.robot.transport.p063b.NvObserver
                public final void onNext(Object obj) {
                    PreviewActivityV2.lambda$_5YBvGcVNmABoI8KAWrFO9UUrpc(PreviewActivityV2.this, completableEmitter, (Integer) obj);
                }
            }, new NvExceptionHandler() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$2G5O2WAjTQk60mPZ_U24lgoHotM
                @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                public final void onError(Throwable th) {
                    PreviewActivityV2.lambda$2G5O2WAjTQk60mPZ_U24lgoHotM(CompletableEmitter.this, th);
                }
            });
        }
    }

    /* renamed from: f */
    public /* synthetic */ void m9227f(CompletableEmitter completableEmitter, Integer num) throws Exception {
        C3044k c3044k = f3730b;
        c3044k.mo1511a((Object) ("getExposureValue value : " + num));
        this.f3753y.put("exposure_value", num);
        completableEmitter.onComplete();
    }

    /* renamed from: q */
    private Completable m9191q() {
        return Completable.m3260a(new CompletableOnSubscribe() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$ddM-bA-Avm969gYlfPvvE9lTblw
            @Override // io.reactivex.CompletableOnSubscribe
            public final void subscribe(CompletableEmitter completableEmitter) {
                PreviewActivityV2.m12987lambda$ddMbAAvm969gYlfPvvE9lTblw(PreviewActivityV2.this, completableEmitter);
            }
        });
    }

    /* renamed from: f */
    public /* synthetic */ void m9228f(final CompletableEmitter completableEmitter) throws Exception {
        NvRobot robot = getRobot();
        if (robot == null) {
            completableEmitter.onError(new RuntimeException("getExposureMode but not connected"));
        } else {
            robot.m7669y().mo6312a(new NvObserver() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$s2V2jhzJW3nD_Q9yOBFnXL0Fuew
                @Override // com.navatics.robot.transport.p063b.NvObserver
                public final void onNext(Object obj) {
                    PreviewActivityV2.lambda$s2V2jhzJW3nD_Q9yOBFnXL0Fuew(PreviewActivityV2.this, completableEmitter, (Integer) obj);
                }
            }, new NvExceptionHandler() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$QEtoYlfv_CsIakHtL86YKgGK3Zo
                @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                public final void onError(Throwable th) {
                    PreviewActivityV2.lambda$QEtoYlfv_CsIakHtL86YKgGK3Zo(CompletableEmitter.this, th);
                }
            });
        }
    }

    /* renamed from: e */
    public /* synthetic */ void m9233e(CompletableEmitter completableEmitter, Integer num) throws Exception {
        C3044k c3044k = f3730b;
        c3044k.mo1511a((Object) ("getExposureMode value : " + num));
        this.f3753y.put("exposure_mode", num);
        completableEmitter.onComplete();
    }

    /* renamed from: r */
    private Completable m9190r() {
        return Completable.m3260a(new CompletableOnSubscribe() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$mv7AWV6dV-l-zUmWaGivHvLJOQ0
            @Override // io.reactivex.CompletableOnSubscribe
            public final void subscribe(CompletableEmitter completableEmitter) {
                PreviewActivityV2.m12990lambda$mv7AWV6dVlzUmWaGivHvLJOQ0(PreviewActivityV2.this, completableEmitter);
            }
        });
    }

    /* renamed from: e */
    public /* synthetic */ void m9234e(final CompletableEmitter completableEmitter) throws Exception {
        NvRobot robot = getRobot();
        if (robot == null) {
            completableEmitter.onError(new RuntimeException("getFOVMode but not connected"));
        } else {
            robot.m7670x().mo6312a(new NvObserver() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$IJ6oGwAIJh6flPcGxzqOepXaHn0
                @Override // com.navatics.robot.transport.p063b.NvObserver
                public final void onNext(Object obj) {
                    PreviewActivityV2.lambda$IJ6oGwAIJh6flPcGxzqOepXaHn0(PreviewActivityV2.this, completableEmitter, (Integer) obj);
                }
            }, new NvExceptionHandler() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$NoFtczu0FCIPDELgOm2u1W6xPNU
                @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                public final void onError(Throwable th) {
                    PreviewActivityV2.lambda$NoFtczu0FCIPDELgOm2u1W6xPNU(CompletableEmitter.this, th);
                }
            });
        }
    }

    /* renamed from: d */
    public /* synthetic */ void m9239d(CompletableEmitter completableEmitter, Integer num) throws Exception {
        C3044k c3044k = f3730b;
        c3044k.mo1511a((Object) ("getFOVMode value : " + num));
        this.f3753y.put("fov", num);
        completableEmitter.onComplete();
    }

    /* renamed from: s */
    private Completable m9189s() {
        return Completable.m3260a(new CompletableOnSubscribe() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$39z52QCQBuYMBo-B_P7mecw4kXc
            @Override // io.reactivex.CompletableOnSubscribe
            public final void subscribe(CompletableEmitter completableEmitter) {
                PreviewActivityV2.m12982lambda$39z52QCQBuYMBoB_P7mecw4kXc(PreviewActivityV2.this, completableEmitter);
            }
        });
    }

    /* renamed from: d */
    public /* synthetic */ void m9240d(final CompletableEmitter completableEmitter) throws Exception {
        NvRobot robot = getRobot();
        if (robot == null) {
            completableEmitter.onError(new RuntimeException("getResolution but not connected"));
        } else {
            robot.m7672v().mo6312a(new NvObserver() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$hiVYzjkFZSmYdp8MxSZXhY59rk8
                @Override // com.navatics.robot.transport.p063b.NvObserver
                public final void onNext(Object obj) {
                    PreviewActivityV2.lambda$hiVYzjkFZSmYdp8MxSZXhY59rk8(PreviewActivityV2.this, completableEmitter, (Integer) obj);
                }
            }, new NvExceptionHandler() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$UbRCvrQymlfQeZbxClpgmXFcOic
                @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                public final void onError(Throwable th) {
                    PreviewActivityV2.lambda$UbRCvrQymlfQeZbxClpgmXFcOic(CompletableEmitter.this, th);
                }
            });
        }
    }

    /* renamed from: c */
    public /* synthetic */ void m9245c(CompletableEmitter completableEmitter, Integer num) throws Exception {
        C3044k c3044k = f3730b;
        c3044k.mo1511a((Object) ("getResolution value : " + num));
        this.f3753y.put("res", num);
        completableEmitter.onComplete();
    }

    /* renamed from: t */
    private Completable m9188t() {
        return Completable.m3260a(new CompletableOnSubscribe() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$Kx-txoWSz38rpob7mz_YxIPiMBI
            @Override // io.reactivex.CompletableOnSubscribe
            public final void subscribe(CompletableEmitter completableEmitter) {
                PreviewActivityV2.m12984lambda$KxtxoWSz38rpob7mz_YxIPiMBI(PreviewActivityV2.this, completableEmitter);
            }
        });
    }

    /* renamed from: c */
    public /* synthetic */ void m9246c(final CompletableEmitter completableEmitter) throws Exception {
        NvRobot robot = getRobot();
        if (robot == null) {
            completableEmitter.onError(new RuntimeException("getFPS but not connected"));
        } else {
            robot.m7671w().mo6312a(new NvObserver() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$_gS-J9OvEp17HtzhMgwOip9-gh4
                @Override // com.navatics.robot.transport.p063b.NvObserver
                public final void onNext(Object obj) {
                    PreviewActivityV2.m12986lambda$_gSJ9OvEp17HtzhMgwOip9gh4(PreviewActivityV2.this, completableEmitter, (Integer) obj);
                }
            }, new NvExceptionHandler() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$edqiIRQSqX7_f9UxMgt2qfatCDQ
                @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                public final void onError(Throwable th) {
                    PreviewActivityV2.lambda$edqiIRQSqX7_f9UxMgt2qfatCDQ(CompletableEmitter.this, th);
                }
            });
        }
    }

    /* renamed from: b */
    public /* synthetic */ void m9252b(CompletableEmitter completableEmitter, Integer num) throws Exception {
        C3044k c3044k = f3730b;
        c3044k.mo1511a((Object) ("getFPS value : " + num));
        this.f3753y.put("fps", num);
        completableEmitter.onComplete();
    }

    /* renamed from: u */
    private Completable m9187u() {
        return Completable.m3260a(new CompletableOnSubscribe() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$B5W8Emp_w5CxQDypfz1Sg54Q5DM
            @Override // io.reactivex.CompletableOnSubscribe
            public final void subscribe(CompletableEmitter completableEmitter) {
                PreviewActivityV2.lambda$B5W8Emp_w5CxQDypfz1Sg54Q5DM(PreviewActivityV2.this, completableEmitter);
            }
        });
    }

    /* renamed from: b */
    public /* synthetic */ void m9253b(final CompletableEmitter completableEmitter) throws Exception {
        NvRobot robot = getRobot();
        if (robot == null) {
            completableEmitter.onError(new RuntimeException("getWhiteBalanceMode but not connected"));
        } else {
            robot.m7721C().mo6312a(new NvObserver() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$5o0lZ2_enPmyhFGq3-yDU8x7TRs
                @Override // com.navatics.robot.transport.p063b.NvObserver
                public final void onNext(Object obj) {
                    PreviewActivityV2.m12983lambda$5o0lZ2_enPmyhFGq3yDU8x7TRs(PreviewActivityV2.this, completableEmitter, (Integer) obj);
                }
            }, new NvExceptionHandler() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$3HP5sJPhObPMbbzNtuH0MXbZiq4
                @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                public final void onError(Throwable th) {
                    PreviewActivityV2.lambda$3HP5sJPhObPMbbzNtuH0MXbZiq4(CompletableEmitter.this, th);
                }
            });
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m9262a(CompletableEmitter completableEmitter, Integer num) throws Exception {
        C3044k c3044k = f3730b;
        c3044k.mo1511a((Object) ("getWhiteBalanceMode value : " + num));
        this.f3753y.put("wb_mode", num);
        completableEmitter.onComplete();
    }

    /* renamed from: v */
    private Completable m9186v() {
        return Completable.m3260a(new CompletableOnSubscribe() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$jJ_LVO16g_Dj2MuHRk7BWcG23_k
            @Override // io.reactivex.CompletableOnSubscribe
            public final void subscribe(CompletableEmitter completableEmitter) {
                PreviewActivityV2.lambda$jJ_LVO16g_Dj2MuHRk7BWcG23_k(PreviewActivityV2.this, completableEmitter);
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m9264a(final CompletableEmitter completableEmitter) throws Exception {
        NvRobot robot = getRobot();
        if (robot == null) {
            completableEmitter.onError(new RuntimeException("getWhiteBalanceValue but not connected"));
        } else {
            robot.m7720D().mo6312a(new NvObserver() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$i8kdEA8WsU_2gUOw4DzYI-mVzow
                @Override // com.navatics.robot.transport.p063b.NvObserver
                public final void onNext(Object obj) {
                    PreviewActivityV2.m12988lambda$i8kdEA8WsU_2gUOw4DzYImVzow(PreviewActivityV2.this, completableEmitter, (WhiteBalance) obj);
                }
            }, new NvExceptionHandler() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$OddEoshGHSu7gNmbpCXfSqIqtUc
                @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                public final void onError(Throwable th) {
                    PreviewActivityV2.lambda$OddEoshGHSu7gNmbpCXfSqIqtUc(CompletableEmitter.this, th);
                }
            });
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m9263a(CompletableEmitter completableEmitter, WhiteBalance whiteBalance) throws Exception {
        C3044k c3044k = f3730b;
        c3044k.mo1511a((Object) ("getWhiteBalanceValue value : " + whiteBalance));
        this.f3753y.put("wb_value", whiteBalance);
        completableEmitter.onComplete();
    }

    /* renamed from: w */
    private void m9185w() {
        this.f3731c = getSharedPreferences("app_settings", 0).getBoolean("use_ijkplayer", false);
        if (this.f3731c) {
            this.surfaceStreamingView.setVisibility(8);
        } else {
            this.streamingView.setVisibility(8);
            findViewById(R.id.hud_view).setVisibility(8);
        }
        this.contentLayout.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$yIcOC-VTMiF8ksp91rTMQRYGMBA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PreviewActivityV2.m12991lambda$yIcOCVTMiF8ksp91rTMQRYGMBA(PreviewActivityV2.this, view);
            }
        });
        this.mSettingContainer.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$5Og3TIeMSEXTi1TSSJKVlmyuJOk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PreviewActivityV2.lambda$5Og3TIeMSEXTi1TSSJKVlmyuJOk(view);
            }
        });
        this.ivImagePreview.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$9uXiRg80XLzs0MCbphhMZ4yPGwo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PreviewActivityV2.lambda$9uXiRg80XLzs0MCbphhMZ4yPGwo(PreviewActivityV2.this, view);
            }
        });
        this.ivCompassClose.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.PreviewActivityV2.9
            {
                PreviewActivityV2.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IntentUtils.m7386a((Context) PreviewActivityV2.this);
            }
        });
        this.preview_back.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$iZvbvSxQ7OT5Um9n7YhYM-YJESs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PreviewActivityV2.m12989lambda$iZvbvSxQ7OT5Um9n7YhYMYJESs(PreviewActivityV2.this, view);
            }
        });
        this.motorInfoContainer.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$IxozAHN3FT1jnNw_xRT9kh7O_zQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PreviewActivityV2.lambda$IxozAHN3FT1jnNw_xRT9kh7O_zQ(PreviewActivityV2.this, view);
            }
        });
        this.ivMotorEnableStatus.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$MKzCLq_iNtKi6EkaPNQYaYL2TxA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PreviewActivityV2.lambda$MKzCLq_iNtKi6EkaPNQYaYL2TxA(PreviewActivityV2.this, view);
            }
        });
        m9285B();
        m9256b(this.ivRecord, R.color.white, 0);
        this.topShadowBackground.setRenderView(this.layoutHelper);
        this.bottomShadowBackground.setRenderView(this.layoutHelper);
        this.contentLayout.setRenderView(this.layoutHelper);
        m9279H();
        this.f3745q = new ControlPanel(this.contentLayout);
        this.contentLayout.setCameraSettingManager(this.f3745q);
        this.previewRoot.setGestureListener(new PreviewRoot.InterfaceC1953a() { // from class: com.navatics.app.activities.PreviewActivityV2.10
            {
                PreviewActivityV2.this = this;
            }

            @Override // com.navatics.app.widget.PreviewRoot.InterfaceC1953a
            /* renamed from: a */
            public void mo7109a() {
                if (PreviewActivityV2.this.f3748t) {
                    PreviewActivityV2.this.m9184x();
                    PreviewActivityV2.this.f3748t = false;
                }
            }

            @Override // com.navatics.app.widget.PreviewRoot.InterfaceC1953a
            /* renamed from: b */
            public void mo7108b() {
                if (PreviewActivityV2.this.f3748t) {
                    return;
                }
                PreviewActivityV2.this.m9183y();
                PreviewActivityV2.this.f3748t = true;
            }
        });
    }

    /* renamed from: m */
    public /* synthetic */ void m9195m(View view) {
        f3730b.mo1511a((Object) "contentLayout click");
        if (this.f3745q.m9164e()) {
            this.f3745q.m9152k();
        }
    }

    /* renamed from: k */
    public /* synthetic */ void m9201k(View view) {
        if (TextUtils.isEmpty(this.f3741m)) {
            return;
        }
        Cursor cursor = null;
        try {
            int i = 0;
            cursor = getContentResolver().query(PhotosProvider.f4767b, null, "path=?", new String[]{this.f3741m}, null);
            if (cursor != null && cursor.moveToFirst()) {
                i = cursor.getInt(cursor.getColumnIndex("_id"));
            }
            Intent intent = new Intent(this, PhotoViewer.class);
            intent.putExtra("key_path_of_photo", i);
            startActivity(intent);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* renamed from: j */
    public /* synthetic */ void m9206j(View view) {
        finish();
    }

    /* renamed from: i */
    public /* synthetic */ void m9212i(View view) {
        m9277J();
    }

    /* renamed from: h */
    public /* synthetic */ void m9218h(View view) {
        m9277J();
    }

    /* renamed from: x */
    public void m9184x() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f3745q.m9150m());
        arrayList.addAll(m9182z());
        this.f3745q.m9174a(arrayList);
        this.mRightCtrlPanel.setBackgroundColor(getResources().getColor(R.color.transparent));
    }

    /* renamed from: y */
    public void m9183y() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f3745q.m9149n());
        arrayList.addAll(m9286A());
        this.f3745q.m9174a(arrayList);
        this.mRightCtrlPanel.setBackgroundColor(getResources().getColor(R.color.mid_transparent_black));
    }

    /* renamed from: z */
    private List<Animator> m9182z() {
        ArrayList arrayList = new ArrayList();
        this.xbarPitch.setVisibility(8);
        ImageView imageView = this.ivCameraExposureMode;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "translationX", 0.0f, imageView.getRight());
        ImageView imageView2 = this.ivCameraSetting;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView2, "translationX", 0.0f, imageView2.getRight());
        ImageView imageView3 = this.ivSetting;
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView3, "translationX", 0.0f, imageView3.getRight());
        ImageView imageView4 = this.ivImagePreview;
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView4, "translationX", 0.0f, imageView4.getRight());
        ImageView imageView5 = this.ivCameraMode;
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(imageView5, "translationX", 0.0f, imageView5.getRight());
        ofFloat.setDuration(200L);
        ofFloat2.setDuration(200L);
        ofFloat3.setDuration(200L);
        ofFloat4.setDuration(200L);
        ofFloat5.setDuration(200L);
        arrayList.add(ofFloat);
        arrayList.add(ofFloat2);
        arrayList.add(ofFloat3);
        arrayList.add(ofFloat4);
        arrayList.add(ofFloat5);
        return arrayList;
    }

    /* renamed from: A */
    private List<Animator> m9286A() {
        this.xbarPitch.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        ImageView imageView = this.ivCameraExposureMode;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "translationX", imageView.getX() - this.ivCameraExposureMode.getLeft(), 0.0f);
        ImageView imageView2 = this.ivCameraSetting;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView2, "translationX", imageView2.getX() - this.ivCameraSetting.getLeft(), 0.0f);
        ImageView imageView3 = this.ivSetting;
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView3, "translationX", imageView3.getX() - this.ivSetting.getLeft(), 0.0f);
        ImageView imageView4 = this.ivImagePreview;
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView4, "translationX", imageView4.getX() - this.ivImagePreview.getLeft(), 0.0f);
        ImageView imageView5 = this.ivCameraMode;
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(imageView5, "translationX", imageView5.getX() - this.ivCameraMode.getLeft(), 0.0f);
        ofFloat.setDuration(200L);
        ofFloat2.setDuration(200L);
        ofFloat3.setDuration(200L);
        ofFloat4.setDuration(200L);
        ofFloat5.setDuration(200L);
        arrayList.add(ofFloat);
        arrayList.add(ofFloat2);
        arrayList.add(ofFloat3);
        arrayList.add(ofFloat4);
        arrayList.add(ofFloat5);
        return arrayList;
    }

    /* renamed from: B */
    private void m9285B() {
        this.xbarPitch.setMax(90);
        this.xbarPitch.setThumb(getDrawable(R.drawable.pitch_thumb));
        XBar xBar = this.xbarPitch;
        xBar.setPadding(0, xBar.getThumbOffset(), 0, this.xbarPitch.getThumbOffset());
        this.xbarPitch.setOnSeekBarChangeListener(new XBar.InterfaceC1980a() { // from class: com.navatics.app.activities.PreviewActivityV2.11
            {
                PreviewActivityV2.this = this;
            }

            @Override // com.navatics.app.widget.xbar.XBar.InterfaceC1980a
            /* renamed from: a */
            public void mo6877a(XBar xBar2, int i, boolean z) {
                if (z) {
                    PreviewActivityV2.this.f3742n = i - 45;
                }
            }

            @Override // com.navatics.app.widget.xbar.XBar.InterfaceC1980a
            /* renamed from: a */
            public void mo6878a(XBar xBar2) {
                PreviewActivityV2.this.removeMessage(100);
                PreviewActivityV2 previewActivityV2 = PreviewActivityV2.this;
                previewActivityV2.f3743o = true;
                previewActivityV2.f3735g.m9107a();
            }

            @Override // com.navatics.app.widget.xbar.XBar.InterfaceC1980a
            /* renamed from: b */
            public void mo6876b(XBar xBar2) {
                PreviewActivityV2.this.f3735g.m9106b();
                PreviewActivityV2.this.sendMessageDelay(100, 3000L);
            }
        });
    }

    /* renamed from: b */
    public void m9250b(boolean z) {
        if (z) {
            this.xbarPitch.setVisibility(0);
        } else {
            this.xbarPitch.setVisibility(8);
        }
    }

    @Override // com.navatics.app.NvBaseActivity
    public void onDeviceConnected(NvConnection nvConnection) {
        super.onDeviceConnected(nvConnection);
        CommonDialog commonDialog = this.f3751w;
        if (commonDialog != null) {
            commonDialog.m7339b();
            this.f3751w = null;
        }
    }

    @Override // com.navatics.app.NvBaseActivity
    protected void onMessage(Message message) {
        if (message.what == 100) {
            this.f3743o = false;
        } else if (message.what == 101) {
            Log.i("info1", "onMessage: MSG_DISCONNECT_TIMEOUT");
            m9284C();
        } else if (message.what == 103) {
            m9273a(message);
        } else if (message.what == 104) {
            m9258b(message);
        }
    }

    @Override // com.navatics.app.NvBaseActivity
    public void onIsCompassInCalibration(boolean z) {
        super.onIsCompassInCalibration(z);
        if (z) {
            m9231f();
        } else if (this.f3754z) {
            this.f3754z = false;
            this.constraintLayout.setVisibility(8);
        }
    }

    /* renamed from: f */
    public void m9231f() {
        if (this.f3754z) {
            return;
        }
        this.f3754z = true;
        this.constraintLayout.setVisibility(0);
    }

    /* renamed from: a */
    private void m9273a(Message message) {
        if (((Integer) message.obj).intValue() == 1 && !this.f3754z) {
            if (this.f3750v == null) {
                Log.i("info1", "showBlockedDialog: show ");
                this.f3750v = DialogFactory.m7401a(this);
                this.f3750v.m7340a(false).m7342a(R.id.tv_center_btn, getString(R.string.restart_now)).m7342a(R.id.tv_title, getResources().getString(R.string.thruster_blocked)).m7343a(R.id.tv_center_btn, new CommonDialog.InterfaceC1915b() { // from class: com.navatics.app.activities.PreviewActivityV2.12
                    {
                        PreviewActivityV2.this = this;
                    }

                    @Override // com.navatics.app.widget.CommonDialog.InterfaceC1915b
                    /* renamed from: a */
                    public void mo7335a(CommonDialog commonDialog) {
                        PreviewActivityV2.this.m9358e();
                        commonDialog.m7339b();
                    }
                }).m7346a();
                return;
            }
            return;
        }
        CommonDialog commonDialog = this.f3750v;
        if (commonDialog != null) {
            commonDialog.m7339b();
            this.f3750v = null;
        }
    }

    /* renamed from: b */
    private void m9258b(Message message) {
        if (((Integer) message.obj).intValue() == 1) {
            CommonDialog commonDialog = this.f3749u;
            if (commonDialog != null) {
                commonDialog.m7339b();
                this.f3749u = null;
            }
        } else if (this.f3749u != null || this.f3754z) {
        } else {
            this.f3749u = DialogFactory.m7400b(this);
            this.f3749u.setonDissmissLinsener(new CommonDialog.InterfaceC1914a() { // from class: com.navatics.app.activities.PreviewActivityV2.2
                {
                    PreviewActivityV2.this = this;
                }

                @Override // com.navatics.app.widget.CommonDialog.InterfaceC1914a
                /* renamed from: a */
                public void mo7336a() {
                    PreviewActivityV2.this.f3749u = null;
                }
            });
            this.f3749u.m7346a();
        }
    }

    /* renamed from: C */
    private void m9284C() {
        if (this.f3751w == null) {
            this.f3751w = DialogFactory.m7401a(this);
            this.f3751w.m7340a(false).m7343a(R.id.tv_center_btn, new CommonDialog.InterfaceC1915b() { // from class: com.navatics.app.activities.PreviewActivityV2.3
                {
                    PreviewActivityV2.this = this;
                }

                @Override // com.navatics.app.widget.CommonDialog.InterfaceC1915b
                /* renamed from: a */
                public void mo7335a(CommonDialog commonDialog) {
                    commonDialog.dismiss();
                    PreviewActivityV2.this.finish();
                }
            }).m7346a();
        }
    }

    /* renamed from: com.navatics.app.activities.PreviewActivityV2$h */
    /* loaded from: classes.dex */
    class C1654h implements RxTimer.InterfaceC2159a {

        /* renamed from: a */
        RxTimer f3828a;

        C1654h() {
            PreviewActivityV2.this = r1;
        }

        /* renamed from: a */
        void m9107a() {
            if (this.f3828a != null) {
                PreviewActivityV2.f3730b.mo1499d("PitchTracker already started");
                return;
            }
            this.f3828a = RxTimer.m5859a(this, 250L, true);
            this.f3828a.m5860a();
        }

        /* renamed from: b */
        void m9106b() {
            RxTimer rxTimer = this.f3828a;
            if (rxTimer == null) {
                return;
            }
            rxTimer.m5857b();
            this.f3828a = null;
            m9105c();
        }

        @Override // com.navatics.robot.utils.RxTimer.InterfaceC2159a
        /* renamed from: a */
        public void mo5856a(RxTimer rxTimer) {
            m9105c();
        }

        /* renamed from: c */
        private void m9105c() {
            NvRobot robot = PreviewActivityV2.this.getRobot();
            C3044k c3044k = PreviewActivityV2.f3730b;
            c3044k.mo1500c((Object) ("sending pitch : " + PreviewActivityV2.this.f3742n));
            if (robot != null) {
                robot.m7702b(PreviewActivityV2.this.f3742n);
            }
        }
    }

    /* renamed from: D */
    public void m9283D() {
        f3730b.mo1500c((Object) "renderViewSetTo4by3");
        Log.d("layout_debug", "renderViewSetTo4by3");
        this.layoutHelper.setAspectRatio(5);
        this.layoutHelper.m7250a(1600, 1200);
        this.layoutHelper.m7249b(1600, 1200);
        this.previewRoot.setMode(0);
        if (!this.f3731c) {
            this.surfaceStreamingView.m7170a(getRobot());
        }
        this.layoutHelper.forceLayout();
        this.contentLayout.forceLayout();
        this.topShadowBackground.forceLayout();
        this.bottomShadowBackground.forceLayout();
        this.infoHoverView.forceLayout();
    }

    /* renamed from: E */
    public void m9282E() {
        f3730b.mo1500c((Object) "renderViewSetTo16by9");
        Log.d("layout_debug", "renderViewSetTo16by9");
        this.layoutHelper.setAspectRatio(4);
        this.layoutHelper.m7250a(1920, 1080);
        this.layoutHelper.m7249b(1920, 1080);
        this.previewRoot.setMode(1);
        if (!this.f3731c) {
            this.surfaceStreamingView.m7170a(getRobot());
        }
        this.layoutHelper.forceLayout();
        this.contentLayout.forceLayout();
        this.topShadowBackground.forceLayout();
        this.bottomShadowBackground.forceLayout();
        this.infoHoverView.forceLayout();
    }

    /* renamed from: F */
    private void m9281F() {
        NvRobot robot = getRobot();
        if (robot == null) {
            return;
        }
        robot.m7683k();
        this.tvRecordTime.setVisibility(0);
        this.f3747s = Observable.m3113a(0L, 1L, TimeUnit.SECONDS).m3091a(AndroidSchedulers.m3250a()).m3071c(new Consumer() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$iVAuNi4JmVObi1RPpmr9TE6nHxI
            @Override // io.reactivex.p096b.Consumer
            public final void accept(Object obj) {
                PreviewActivityV2.lambda$iVAuNi4JmVObi1RPpmr9TE6nHxI(PreviewActivityV2.this, (Long) obj);
            }
        });
        if (this.f3752x.m9102a()) {
            f3730b.mo1504b((Object) "Sd status already enable");
        } else {
            this.f3752x.m9098a(true);
        }
        m9271a(this.ivRecord, R.color.mb_red, 200);
    }

    /* renamed from: a */
    public /* synthetic */ void m9260a(Long l) throws Exception {
        long currentTimeMillis = System.currentTimeMillis() - getRobot().m7680n();
        this.tvRecordTime.setText(String.format(Locale.getDefault(), "%02d:%02d:%02d", Long.valueOf((currentTimeMillis / 3600000) % 24), Long.valueOf((currentTimeMillis / 60000) % 60), Long.valueOf((currentTimeMillis / 1000) % 60)));
    }

    /* renamed from: G */
    private void m9280G() {
        NvRobot robot = getRobot();
        if (robot == null) {
            return;
        }
        robot.m7682l();
        if (this.f3752x.m9102a()) {
            this.f3752x.m9098a(false);
        }
        Disposable disposable = this.f3747s;
        if (disposable != null) {
            disposable.dispose();
            this.f3747s = null;
        }
        this.tvRecordTime.setText(R.string.default_record_time_str);
        this.tvRecordTime.setVisibility(4);
        m9256b(this.ivRecord, R.color.mb_red, 200);
    }

    /* renamed from: H */
    private void m9279H() {
        this.ivSetting.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$mVzTjEgRB9A1pF1sSqAWIF5eWn0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PreviewActivityV2.lambda$mVzTjEgRB9A1pF1sSqAWIF5eWn0(PreviewActivityV2.this, view);
            }
        });
        this.ivCameraSetting.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$isugOtxkaKJvv88HpJW6WXlkinM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PreviewActivityV2.lambda$isugOtxkaKJvv88HpJW6WXlkinM(PreviewActivityV2.this, view);
            }
        });
        this.ivRecord.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$MdXVKQgXOwj_GN9hw6CR8ZolSM4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PreviewActivityV2.lambda$MdXVKQgXOwj_GN9hw6CR8ZolSM4(PreviewActivityV2.this, view);
            }
        });
        this.ivCameraExposureMode.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$BGFNr5jpKOUr_fdKA4GnXG_5fRI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PreviewActivityV2.lambda$BGFNr5jpKOUr_fdKA4GnXG_5fRI(PreviewActivityV2.this, view);
            }
        });
        this.f3737i = new ParametersSettingFragment();
        this.f3738j = new CalibrateFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.settingContent, this.f3737i).commit();
        this.ivCloseSetting.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$jUaBrHZcVCh2CiBTOyJa2ChUZYM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PreviewActivityV2.lambda$jUaBrHZcVCh2CiBTOyJa2ChUZYM(PreviewActivityV2.this, view);
            }
        });
        this.ivParametersSetting.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$wW3V_SCLjH4rE7dAca8ocbTwmsA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PreviewActivityV2.lambda$wW3V_SCLjH4rE7dAca8ocbTwmsA(PreviewActivityV2.this, view);
            }
        });
        this.ivIMUSetting.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$O-bJIlnGcsuSVjG1ZCs3HQJmS2Q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PreviewActivityV2.m12985lambda$ObJIlnGcsuSVjG1ZCs3HQJmS2Q(PreviewActivityV2.this, view);
            }
        });
    }

    /* renamed from: g */
    public /* synthetic */ void m9224g(View view) {
        m9225g();
    }

    /* renamed from: f */
    public /* synthetic */ void m9230f(View view) {
        this.f3745q.m9151l();
        this.ivCameraSetting.setVisibility(4);
        this.ivCameraExposureMode.setVisibility(0);
    }

    /* renamed from: e */
    public /* synthetic */ void m9236e(View view) {
        if (this.f3745q.m9169c()) {
            if (m9360d()) {
                m9280G();
                return;
            } else {
                m9281F();
                return;
            }
        }
        m9278I();
        m9362c();
    }

    /* renamed from: d */
    public /* synthetic */ void m9242d(View view) {
        this.f3745q.m9156i();
    }

    /* renamed from: c */
    public /* synthetic */ void m9249c(View view) {
        m9225g();
    }

    /* renamed from: b */
    public /* synthetic */ void m9257b(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.settingContent, this.f3737i).commit();
    }

    /* renamed from: a */
    public /* synthetic */ void m9272a(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.settingContent, this.f3738j).commit();
    }

    /* renamed from: I */
    private void m9278I() {
        Bitmap frameBitmap;
        if (this.f3731c) {
            frameBitmap = this.streamingView.getFrameBitmap();
        } else {
            frameBitmap = this.surfaceStreamingView.getFrameBitmap();
        }
        String m8606f = Settings.m8618a().m8606f();
        if (TextUtils.isEmpty(m8606f)) {
            Toast.makeText(this, (int) R.string.capture_error, 0).show();
            return;
        }
        String m7392a = ImageUtils.m7392a(this, frameBitmap, m8606f, ImageUtils.m7390a(m8606f));
        if (m7392a != null) {
            this.f3741m = m7392a;
            Settings.m8618a().m8615a(this.f3741m);
            Toast.makeText(this, (int) R.string.capture_success, 0).show();
            DiveLogManager m8472b = DiveLogManager.m8472b();
            if (m8472b.m8462e()) {
                m8472b.m8486a(FileProviderCompat.m6871a(this, new File(m7392a)));
                return;
            }
            return;
        }
        Toast.makeText(this, (int) R.string.capture_error, 0).show();
    }

    /* renamed from: l */
    public int m9199l(@DimenRes int i) {
        return (int) getResources().getDimension(i);
    }

    /* renamed from: m */
    public int m9196m(@ColorRes int i) {
        return ContextCompat.getColor(this, i);
    }

    /* renamed from: a */
    private void m9271a(MorphingButton morphingButton, int i, int i2) {
        morphingButton.mo11488a(MorphingButton.C0799b.m11548a().m11537f(i2).m11547a(m9199l(R.dimen.mb_corner_radius_retangle)).m11545b(m9199l(R.dimen.mb_height_32)).m11543c(m9199l(R.dimen.mb_height_32)).m11541d(m9196m(i)).m11539e(m9196m(i)));
    }

    /* renamed from: b */
    public void m9256b(MorphingButton morphingButton, int i, int i2) {
        morphingButton.mo11488a(MorphingButton.C0799b.m11548a().m11537f(i2).m11547a(m9199l(R.dimen.mb_height_51)).m11545b(m9199l(R.dimen.mb_height_51)).m11543c(m9199l(R.dimen.mb_height_51)).m11541d(m9196m(i)).m11539e(m9196m(i)));
    }

    /* renamed from: J */
    private void m9277J() {
        if (this.f3733e) {
            this.motorInfoContainer.setVisibility(8);
            this.f3733e = false;
            return;
        }
        this.motorInfoContainer.setVisibility(0);
        this.f3733e = true;
    }

    @Override // com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.f3744p) {
            if (this.f3731c) {
                m9207j();
            } else {
                this.surfaceStreamingView.m7170a(getRobot());
            }
            this.f3744p = false;
        }
    }

    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        NvRobot robot = getRobot();
        if (robot != null) {
            if (robot.m7681m()) {
                m9280G();
            }
            this.f3744p = true;
            robot.m7685j();
        }
    }

    @Override // android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f3739k) {
            m9225g();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.navatics.app.NvBaseActivity
    public void onRobotStatusUpdate(RobotStatus robotStatus) {
        ObjectAnimator objectAnimator;
        super.onRobotStatusUpdate(robotStatus);
        if (this.f3745q.m9173b()) {
            this.mRobotCompass.setRobotRadian(robotStatus.m8672A());
            this.mPitchView.setPitchRadian(robotStatus.m8671B());
            this.tvTemperature.m8060a(robotStatus.m8632v());
            this.tvAltitudeCurrent.m8060a(robotStatus.m8640n());
            this.tvAltitudeRef.m8060a(robotStatus.m8638p());
            if (!this.f3743o) {
                this.f3742n = (int) ((robotStatus.m8670C() * 180.0f) / 3.141592653589793d);
                this.xbarPitch.setProgress((-this.f3742n) + 45);
            }
            switch (robotStatus.m8633u()) {
                case 0:
                    this.ivLedStatus.setImageResource(R.drawable.bottom_grade0);
                    break;
                case 1:
                    this.ivLedStatus.setImageResource(R.drawable.bottom_grade1);
                    break;
                case 2:
                    this.ivLedStatus.setImageResource(R.drawable.bottom_grade2);
                    break;
                case 3:
                    this.ivLedStatus.setImageResource(R.drawable.bottom_grade3);
                    break;
            }
            this.tvBatteryRobot.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf(robotStatus.m8631w())));
            MotorStatus m8629y = robotStatus.m8629y();
            if (m8629y.f4712a) {
                if (!this.f3734f) {
                    this.f3734f = true;
                    this.f3732d = ObjectAnimator.ofFloat(this.ivMotorEnableStatus, "rotation", 0.0f, 360.0f);
                    this.f3732d.setDuration(200L);
                    this.f3732d.setRepeatCount(-1);
                    this.f3732d.start();
                }
                if (this.f3733e) {
                    this.tvMotorFront.setText(String.format(Locale.getDefault(), "%drpm", Integer.valueOf(m8629y.f4713b)));
                    this.tvMotorBehind.setText(String.format(Locale.getDefault(), "%drpm", Integer.valueOf(m8629y.f4714c)));
                    this.tvMotorLeft.setText(String.format(Locale.getDefault(), "%drpm", Integer.valueOf(m8629y.f4715d)));
                    this.tvMotorRight.setText(String.format(Locale.getDefault(), "%drpm", Integer.valueOf(m8629y.f4716e)));
                }
            } else if (!this.f3734f || (objectAnimator = this.f3732d) == null) {
            } else {
                objectAnimator.cancel();
                this.f3732d = null;
                this.f3734f = false;
            }
        }
    }

    @Override // com.navatics.app.NvBaseActivity
    public void onBuoyStatusUpdate(BuoyStatus buoyStatus) {
        super.onBuoyStatusUpdate(buoyStatus);
        if (this.f3745q.m9173b()) {
            this.tvBatteryBouy.setText(String.valueOf(String.format(Locale.getDefault(), "%d%%", Integer.valueOf(buoyStatus.m8410c()))));
        }
    }

    @Override // com.navatics.app.NvBaseActivity
    public void onGroundStationStateUpdate(GroundStation groundStation) {
        super.onGroundStationStateUpdate(groundStation);
        this.tvBatteryRemote.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf(groundStation.m8103h().m8061a().getLevel())));
    }

    @Override // com.navatics.app.NvBaseActivity
    public void onDeviceAuthenticationSuccess(NvConnection nvConnection) {
        super.onDeviceAuthenticationSuccess(nvConnection);
        m9243c(false);
        m9202k();
    }

    @Override // com.navatics.app.NvBaseActivity
    public void onConnectionLost(NvConnection nvConnection) {
        super.onConnectionLost(nvConnection);
        m9243c(true);
    }

    /* renamed from: c */
    private void m9243c(boolean z) {
        if (z) {
            this.tvNoConnText.setVisibility(0);
            Snackbar snackbar = this.f3736h;
            if (snackbar == null) {
                this.f3736h = Snackbar.make(this.previewRoot, "Connection Loss", -2);
                View view = this.f3736h.getView();
                view.setBackgroundColor(SupportMenu.CATEGORY_MASK);
                ((TextView) view.findViewById(R.id.snackbar_text)).setTextColor(InputDeviceCompat.SOURCE_ANY);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                layoutParams.gravity = 48;
                view.setLayoutParams(layoutParams);
                this.f3736h.show();
                return;
            } else if (snackbar.isShown()) {
                return;
            } else {
                this.f3736h.show();
                return;
            }
        }
        this.tvNoConnText.setVisibility(8);
        Snackbar snackbar2 = this.f3736h;
        if (snackbar2 != null) {
            snackbar2.dismiss();
        }
    }

    /* renamed from: d */
    public void m9237d(boolean z) {
        if (z) {
            runOnUiThread(new Runnable() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$k7OlmCpONCo_Cnqh5De34e5QN4M
                @Override // java.lang.Runnable
                public final void run() {
                    PreviewActivityV2.lambda$k7OlmCpONCo_Cnqh5De34e5QN4M(PreviewActivityV2.this);
                }
            });
        } else {
            runOnUiThread(new Runnable() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$ChpPTwmCJ8MwPfOXHbDXvaiP_w0
                @Override // java.lang.Runnable
                public final void run() {
                    PreviewActivityV2.lambda$ChpPTwmCJ8MwPfOXHbDXvaiP_w0(PreviewActivityV2.this);
                }
            });
        }
    }

    /* renamed from: L */
    public /* synthetic */ void m9275L() {
        this.loadingOverlay.setVisibility(0);
    }

    /* renamed from: K */
    public /* synthetic */ void m9276K() {
        this.loadingOverlay.setVisibility(8);
    }

    /* renamed from: g */
    public void m9225g() {
        float measuredWidth;
        if (this.f3739k) {
            float x = this.mSettingContainer.getX();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mSettingContainer, "x", x, this.mSettingContainer.getWidth() + x + LayoutUtils.m7382a(this));
            ofFloat.setDuration(200L);
            ofFloat.addListener(new AnimatorEndListener() { // from class: com.navatics.app.activities.PreviewActivityV2.4
                {
                    PreviewActivityV2.this = this;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PreviewActivityV2.this.mSettingContainer.setVisibility(4);
                }
            });
            ofFloat.start();
            this.f3739k = false;
            return;
        }
        this.mSettingContainer.setVisibility(0);
        float width = this.contentLayout.getWidth();
        if (LayoutUtils.m7380c(this) && LayoutUtils.m7381b(this)) {
            measuredWidth = (width - this.mSettingContainer.getMeasuredWidth()) - LayoutUtils.m7382a(this);
        } else {
            measuredWidth = width - this.mSettingContainer.getMeasuredWidth();
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mSettingContainer, "x", width, measuredWidth);
        ofFloat2.setDuration(200L);
        ofFloat2.start();
        this.f3739k = true;
    }

    /* renamed from: com.navatics.app.activities.PreviewActivityV2$k */
    /* loaded from: classes.dex */
    public class C1657k {

        /* renamed from: a */
        boolean f3840a;

        /* renamed from: b */
        long f3841b;

        C1657k() {
            PreviewActivityV2.this = r1;
        }

        /* renamed from: a */
        void m9098a(boolean z) {
            this.f3840a = z;
            if (z) {
                m9101a(0L);
            }
        }

        /* renamed from: a */
        boolean m9102a() {
            return this.f3840a;
        }

        /* renamed from: b */
        public void m9097b() {
            NvRobot robot = PreviewActivityV2.this.getRobot();
            if (robot != null) {
                this.f3841b = System.currentTimeMillis();
                robot.m7719E().mo6311a(NvObserverExecutor.m6303b()).mo6312a(new NvObserver() { // from class: com.navatics.app.activities.-$$Lambda$Rdre_fdJ9GBsoQMl7klGIETI1Ak
                    @Override // com.navatics.robot.transport.p063b.NvObserver
                    public final void onNext(Object obj) {
                        PreviewActivityV2.C1657k.this.m9100a((StorageInfo) obj);
                    }
                }, new NvExceptionHandler() { // from class: com.navatics.app.activities.-$$Lambda$BdavfxSMfM0xUf8y-i0cae21QxY
                    @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                    public final void onError(Throwable th) {
                        PreviewActivityV2.C1657k.this.m9099a(th);
                    }
                });
            }
        }

        /* renamed from: a */
        public void m9100a(StorageInfo storageInfo) {
            C3044k c3044k = PreviewActivityV2.f3730b;
            c3044k.mo1511a((Object) ("handleResponse " + storageInfo));
            NvValue totalSpace = storageInfo.getTotalSpace();
            NvValue freeSpace = storageInfo.getFreeSpace();
            NvValue m5960g = freeSpace.m5960g();
            if (totalSpace.m5967c() == com.github.mikephil.charting.utils.Utils.DOUBLE_EPSILON && freeSpace.m5967c() == com.github.mikephil.charting.utils.Utils.DOUBLE_EPSILON) {
                PreviewActivityV2.f3730b.mo1499d("No sdcard detected");
                PreviewActivityV2.this.ivNoSdIcon.setVisibility(0);
            } else if (m5960g.m5967c() < 10.0d) {
                PreviewActivityV2.f3730b.mo1499d("Sdcard space not enough");
                PreviewActivityV2.this.ivNoSdIcon.setVisibility(0);
            } else {
                PreviewActivityV2.this.ivNoSdIcon.setVisibility(8);
            }
            m9096c();
        }

        /* renamed from: a */
        public void m9099a(Throwable th) {
            PreviewActivityV2.f3730b.mo1504b((Object) "handleError ");
            th.printStackTrace();
            m9096c();
        }

        /* renamed from: c */
        void m9096c() {
            if (m9102a()) {
                m9101a(Math.abs(3000 - (System.currentTimeMillis() - this.f3841b)));
            } else {
                PreviewActivityV2.this.ivNoSdIcon.setVisibility(8);
            }
        }

        /* renamed from: a */
        void m9101a(long j) {
            C3044k c3044k = PreviewActivityV2.f3730b;
            c3044k.mo1511a((Object) ("scheduleNextRequest : " + j));
            if (j < 0 || j > 3000) {
                C3044k c3044k2 = PreviewActivityV2.f3730b;
                c3044k2.mo1499d("SdStatusTracer scheduleNextRequest delayMS : " + j);
                j = 3000L;
            }
            NvEventLoop.m6231b().mo6285a(new Runnable() { // from class: com.navatics.app.activities.-$$Lambda$PwDMMZdhIoJLwlJZVAEsKdrQOjQ
                @Override // java.lang.Runnable
                public final void run() {
                    PreviewActivityV2.C1657k.this.m9097b();
                }
            }, j);
        }
    }

    /* loaded from: classes.dex */
    public class ControlPanel implements ICameraSettingManager {

        /* renamed from: a */
        boolean f3767a;

        /* renamed from: b */
        boolean f3768b;

        /* renamed from: c */
        int f3769c;
        @BindView
        ViewGroup cameraParametersContainer;

        /* renamed from: d */
        int f3770d;

        /* renamed from: e */
        List<AbstractC1644a> f3771e = new ArrayList();

        /* renamed from: f */
        List<AbstractC1647b> f3772f = new ArrayList();

        /* renamed from: g */
        AbstractC1644a f3773g;

        /* renamed from: h */
        AbstractC1647b f3774h;

        /* renamed from: i */
        View f3775i;
        @BindView
        ImageView ivCameraFOV;
        @BindView
        ImageView ivCameraFPS;
        @BindView
        ImageView ivCameraMode;
        @BindView
        ImageView ivCameraRes;
        @BindView
        ImageView ivCameraSD;
        @BindView
        ImageView ivEVImage;
        @BindView
        ImageView ivISO;
        @BindView
        ImageView ivShutter;
        @BindView
        ImageView ivWhiteBalance;

        /* renamed from: j */
        View f3776j;
        @BindView
        RelativeLayout rightCtrlPanel;
        @BindView
        RelativeLayout rightCtrlPanelExpand;

        /* renamed from: i */
        public static /* synthetic */ void m9155i(View view) {
        }

        /* renamed from: j */
        public static /* synthetic */ void m9153j(View view) {
        }

        public static /* synthetic */ void lambda$A6h6ooFhcQiDg1Zg7TpNzPas2Yg(ControlPanel controlPanel, View view) {
            controlPanel.m9163e(view);
        }

        public static /* synthetic */ void lambda$GJZmUk49YDPIBXYOM1bFw0OYK7c(ControlPanel controlPanel, Long l) {
            controlPanel.m9175a(l);
        }

        /* renamed from: lambda$I9vjDnZb-9TgpSn20EBi6MsaBlY */
        public static /* synthetic */ void m12992lambda$I9vjDnZb9TgpSn20EBi6MsaBlY(ControlPanel controlPanel, View view) {
            controlPanel.m9157h(view);
        }

        /* renamed from: lambda$NU9MCJ06igQur339bgu-T8HMiuo */
        public static /* synthetic */ void m12993lambda$NU9MCJ06igQur339bguT8HMiuo(ControlPanel controlPanel, View view) {
            controlPanel.m9167c(view);
        }

        public static /* synthetic */ void lambda$QWz7yZKOdOmnV2uf0zObmMmtrUQ(View view) {
            m9155i(view);
        }

        public static /* synthetic */ void lambda$bwZ6EfxVdGnExLqY92iToCVlMjg(ControlPanel controlPanel, View view) {
            controlPanel.m9165d(view);
        }

        public static /* synthetic */ void lambda$hUk_RwN5dC89Bb3MvT_N7YcN7fA(ControlPanel controlPanel, View view) {
            controlPanel.m9159g(view);
        }

        /* renamed from: lambda$idkWFN7nust3qF8-ttiHUiJ1jPg */
        public static /* synthetic */ void m12994lambda$idkWFN7nust3qF8ttiHUiJ1jPg(View view) {
            m9153j(view);
        }

        public static /* synthetic */ void lambda$ygrDDW2ostnbW8t8vFdW99rKaaM(ControlPanel controlPanel, View view) {
            controlPanel.m9161f(view);
        }

        ControlPanel(View view) {
            PreviewActivityV2.this = r2;
            ButterKnife.m12803a(this, view);
            this.f3771e.add(new C1655i(this).m9082j());
            this.f3771e.add(new C1652f(this).m9082j());
            this.f3771e.add(new C1651e(this).m9082j());
            this.f3771e.add(new C1656j(this));
            this.f3772f.add(new C1649d());
            this.f3772f.add(new C1659m());
            this.f3772f.add(new C1653g());
            this.f3772f.add(new WhiteBalancePanel());
            m9158h();
            m9144s();
        }

        /* renamed from: a */
        public void m9176a(C1648c c1648c) {
            int intValue = c1648c.m9122a().intValue();
            int intValue2 = c1648c.m9121b().intValue();
            int intValue3 = c1648c.m9120c().intValue();
            int intValue4 = c1648c.m9119d().intValue();
            int intValue5 = c1648c.m9118e().intValue();
            int intValue6 = c1648c.m9117f().intValue();
            int intValue7 = c1648c.m9116g().intValue();
            int intValue8 = c1648c.m9115h().intValue();
            int intValue9 = c1648c.m9114i().intValue();
            WhiteBalance m9113j = c1648c.m9113j();
            PreviewActivityV2.f3730b.mo1511a((Object) "ControlPanel inited.");
            AbstractC1658l abstractC1658l = (AbstractC1658l) m9172b(2);
            if (abstractC1658l != null) {
                abstractC1658l.m9087d(intValue2);
            }
            AbstractC1658l abstractC1658l2 = (AbstractC1658l) m9172b(1);
            if (abstractC1658l2 != null) {
                abstractC1658l2.m9087d(intValue3);
            }
            AbstractC1658l abstractC1658l3 = (AbstractC1658l) m9172b(3);
            if (abstractC1658l3 != null) {
                abstractC1658l3.m9087d(intValue4);
            }
            m9171b(intValue, false);
            m9180a(intValue5, false);
            AbstractC1647b m9168c = m9168c(1);
            if (m9168c != null) {
                m9168c.mo9079a(m9168c.m9123c(), Integer.valueOf(intValue6));
            }
            AbstractC1647b m9168c2 = m9168c(2);
            if (m9168c2 != null) {
                m9168c2.mo9079a(m9168c2.m9123c(), Integer.valueOf(intValue8));
            }
            AbstractC1647b m9168c3 = m9168c(3);
            if (m9168c3 != null) {
                m9168c3.mo9079a(m9168c3.m9123c(), Integer.valueOf(intValue7));
            }
            AbstractC1647b m9168c4 = m9168c(4);
            if (m9168c4 != null) {
                m9168c4.mo9079a("wb_mode", Integer.valueOf(intValue9));
                m9168c4.mo9079a("ch_red", Integer.valueOf(m9113j.m6331a()));
                m9168c4.mo9079a("ch_blue", Integer.valueOf(m9113j.m6330b()));
            }
            this.f3767a = true;
        }

        /* renamed from: b */
        boolean m9173b() {
            return this.f3767a;
        }

        /* renamed from: c */
        boolean m9169c() {
            return this.f3770d == 1;
        }

        /* renamed from: d */
        boolean m9166d() {
            return this.f3769c == 2;
        }

        @Override // com.navatics.app.ICameraSettingManager
        /* renamed from: a */
        public int mo8806a() {
            return this.f3770d == 1 ? 1 : 0;
        }

        /* renamed from: e */
        boolean m9164e() {
            return this.f3768b;
        }

        /* renamed from: f */
        boolean m9162f() {
            View view;
            return (this.f3773g == null || (view = this.f3775i) == null || !view.isShown()) ? false : true;
        }

        /* renamed from: g */
        boolean m9160g() {
            return this.f3774h != null;
        }

        /* renamed from: b */
        private void m9170b(View view) {
            View view2 = this.f3776j;
            if (view2 == null) {
                this.f3776j = view;
                View view3 = this.f3776j;
                if (view3 != null) {
                    view3.setSelected(true);
                }
            } else if (view == view2) {
                view.setSelected(!view.isSelected());
            } else {
                view2.setSelected(false);
                this.f3776j = view;
                View view4 = this.f3776j;
                if (view4 != null) {
                    view4.setSelected(true);
                }
            }
        }

        /* renamed from: s */
        private void m9144s() {
            this.rightCtrlPanelExpand.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$ControlPanel$idkWFN7nust3qF8-ttiHUiJ1jPg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PreviewActivityV2.ControlPanel.m12994lambda$idkWFN7nust3qF8ttiHUiJ1jPg(view);
                }
            });
            this.rightCtrlPanel.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$ControlPanel$QWz7yZKOdOmnV2uf0zObmMmtrUQ
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PreviewActivityV2.ControlPanel.lambda$QWz7yZKOdOmnV2uf0zObmMmtrUQ(view);
                }
            });
            this.ivEVImage.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$ControlPanel$I9vjDnZb-9TgpSn20EBi6MsaBlY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PreviewActivityV2.ControlPanel.m12992lambda$I9vjDnZb9TgpSn20EBi6MsaBlY(PreviewActivityV2.ControlPanel.this, view);
                }
            });
            this.ivShutter.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$ControlPanel$hUk_RwN5dC89Bb3MvT_N7YcN7fA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PreviewActivityV2.ControlPanel.lambda$hUk_RwN5dC89Bb3MvT_N7YcN7fA(PreviewActivityV2.ControlPanel.this, view);
                }
            });
            this.ivISO.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$ControlPanel$ygrDDW2ostnbW8t8vFdW99rKaaM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PreviewActivityV2.ControlPanel.lambda$ygrDDW2ostnbW8t8vFdW99rKaaM(PreviewActivityV2.ControlPanel.this, view);
                }
            });
            this.ivWhiteBalance.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$ControlPanel$A6h6ooFhcQiDg1Zg7TpNzPas2Yg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PreviewActivityV2.ControlPanel.lambda$A6h6ooFhcQiDg1Zg7TpNzPas2Yg(PreviewActivityV2.ControlPanel.this, view);
                }
            });
            this.ivCameraMode.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$ControlPanel$bwZ6EfxVdGnExLqY92iToCVlMjg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PreviewActivityV2.ControlPanel.lambda$bwZ6EfxVdGnExLqY92iToCVlMjg(PreviewActivityV2.ControlPanel.this, view);
                }
            });
            m9171b(1, false);
            m9180a(2, false);
        }

        /* renamed from: h */
        public /* synthetic */ void m9157h(View view) {
            m9181a(1);
        }

        /* renamed from: g */
        public /* synthetic */ void m9159g(View view) {
            m9181a(2);
        }

        /* renamed from: f */
        public /* synthetic */ void m9161f(View view) {
            m9181a(3);
        }

        /* renamed from: e */
        public /* synthetic */ void m9163e(View view) {
            m9181a(4);
        }

        /* renamed from: d */
        public /* synthetic */ void m9165d(View view) {
            PreviewActivityV2.this.f3745q.m9154j();
        }

        /* renamed from: h */
        void m9158h() {
            this.ivCameraRes.setTag(1);
            this.ivCameraRes.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$ControlPanel$NU9MCJ06igQur339bgu-T8HMiuo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PreviewActivityV2.ControlPanel.m12993lambda$NU9MCJ06igQur339bguT8HMiuo(PreviewActivityV2.ControlPanel.this, view);
                }
            });
            this.ivCameraFPS.setTag(2);
            this.ivCameraFPS.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$ControlPanel$NU9MCJ06igQur339bgu-T8HMiuo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PreviewActivityV2.ControlPanel.m12993lambda$NU9MCJ06igQur339bguT8HMiuo(PreviewActivityV2.ControlPanel.this, view);
                }
            });
            this.ivCameraFOV.setTag(3);
            this.ivCameraFOV.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$ControlPanel$NU9MCJ06igQur339bgu-T8HMiuo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PreviewActivityV2.ControlPanel.m12993lambda$NU9MCJ06igQur339bguT8HMiuo(PreviewActivityV2.ControlPanel.this, view);
                }
            });
            this.ivCameraSD.setTag(4);
            this.ivCameraSD.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$ControlPanel$NU9MCJ06igQur339bgu-T8HMiuo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PreviewActivityV2.ControlPanel.m12993lambda$NU9MCJ06igQur339bguT8HMiuo(PreviewActivityV2.ControlPanel.this, view);
                }
            });
        }

        /* renamed from: t */
        private void m9143t() {
            m9170b((View) null);
            AbstractC1647b abstractC1647b = this.f3774h;
            if (abstractC1647b != null) {
                abstractC1647b.mo9078a(false);
                PreviewActivityV2.this.contentLayout.removeView(this.f3774h.mo9081a());
                this.f3774h = null;
            }
        }

        /* renamed from: a */
        private void m9181a(int i) {
            AbstractC1647b m9168c = m9168c(i);
            if (m9168c == null) {
                C3044k c3044k = PreviewActivityV2.f3730b;
                c3044k.mo1504b((Object) ("can't find expand panel for type : " + i));
                return;
            }
            switch (i) {
                case 1:
                    m9170b(this.ivEVImage);
                    break;
                case 2:
                    m9170b(this.ivShutter);
                    break;
                case 3:
                    m9170b(this.ivISO);
                    break;
                case 4:
                    m9170b(this.ivWhiteBalance);
                    break;
            }
            View mo9081a = m9168c.mo9081a();
            AbstractC1647b abstractC1647b = this.f3774h;
            if (abstractC1647b == m9168c) {
                abstractC1647b.mo9078a(false);
                PreviewActivityV2.this.contentLayout.removeView(mo9081a);
                this.f3774h = null;
                return;
            }
            if (abstractC1647b != null) {
                abstractC1647b.mo9078a(false);
                PreviewActivityV2.this.contentLayout.removeView(this.f3774h.mo9081a());
            }
            if (mo9081a.getParent() != null) {
                ((ViewGroup) mo9081a.getParent()).removeView(mo9081a);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams.addRule(16, this.rightCtrlPanel.getId());
            layoutParams.setMargins(0, 0, (int) TypedValue.applyDimension(1, 60.0f, PreviewActivityV2.this.getResources().getDisplayMetrics()), 0);
            this.f3774h = m9168c;
            this.f3774h.mo9078a(true);
            PreviewActivityV2.this.contentLayout.addView(mo9081a, layoutParams);
        }

        /* renamed from: u */
        private void m9142u() {
            ArrayList arrayList = new ArrayList();
            if (PreviewActivityV2.this.f3748t) {
                arrayList.addAll(m9150m());
                PreviewActivityV2.this.f3748t = false;
            }
            arrayList.addAll(m9148o());
            arrayList.addAll(m9146q());
            m9174a(arrayList);
        }

        /* renamed from: v */
        private void m9141v() {
            ArrayList arrayList = new ArrayList();
            if (!PreviewActivityV2.this.f3748t) {
                arrayList.addAll(m9149n());
                PreviewActivityV2.this.f3748t = true;
            }
            arrayList.addAll(m9147p());
            arrayList.addAll(m9145r());
            if (m9162f()) {
                m9179a((View) null);
                arrayList.addAll(this.f3773g.m9126d());
            }
            m9143t();
            this.f3773g = null;
            this.f3775i = null;
            PreviewActivityV2.this.ivCameraSetting.setVisibility(0);
            PreviewActivityV2.this.ivCameraExposureMode.setVisibility(4);
            m9174a(arrayList);
        }

        /* renamed from: i */
        void m9156i() {
            m9180a(m9166d() ? 1 : 2, true);
        }

        /* renamed from: a */
        void m9180a(int i, boolean z) {
            this.f3769c = i;
            m9143t();
            if (this.f3769c == 1) {
                PreviewActivityV2.this.ivCameraExposureMode.setImageResource(R.drawable.camera_exposure_mode_manual);
                this.ivEVImage.setVisibility(4);
                this.ivShutter.setVisibility(0);
                this.ivISO.setVisibility(0);
                m9170b((View) null);
                if (z) {
                    PreviewActivityV2.this.m9359d(1);
                    return;
                }
                return;
            }
            PreviewActivityV2.this.ivCameraExposureMode.setImageResource(R.drawable.camera_exposure_mode_program);
            this.ivEVImage.setVisibility(0);
            this.ivShutter.setVisibility(4);
            this.ivISO.setVisibility(4);
            m9170b((View) null);
            if (z) {
                PreviewActivityV2.this.m9359d(2);
            }
        }

        /* renamed from: b */
        void m9171b(int i, boolean z) {
            C3044k c3044k = PreviewActivityV2.f3730b;
            c3044k.mo1511a((Object) ("setCameraMode mode " + i + ", mCameraMode " + this.f3770d));
            if (i != 1 && i != 2) {
                C3044k c3044k2 = PreviewActivityV2.f3730b;
                c3044k2.mo1504b((Object) ("mode is " + i));
                return;
            }
            this.f3770d = i;
            C3044k c3044k3 = PreviewActivityV2.f3730b;
            c3044k3.mo1511a((Object) ("setCameraMode mCameraMode " + this.f3770d));
            if (z) {
                PreviewActivityV2.f3730b.mo1511a((Object) "setCameraMode showLoadingCover");
                PreviewActivityV2.this.m9237d(true);
                ObservableConsumers.m3493a(Observable.m3081b(4L, TimeUnit.SECONDS), PreviewActivityV2.this.f3746r, new Consumer() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$ControlPanel$GJZmUk49YDPIBXYOM1bFw0OYK7c
                    @Override // io.reactivex.p096b.Consumer
                    public final void accept(Object obj) {
                        PreviewActivityV2.ControlPanel.lambda$GJZmUk49YDPIBXYOM1bFw0OYK7c(PreviewActivityV2.ControlPanel.this, (Long) obj);
                    }
                });
            }
            int i2 = this.f3770d;
            if (i2 == 1) {
                this.ivCameraRes.setVisibility(0);
                this.ivCameraFPS.setVisibility(0);
                this.ivCameraMode.setImageResource(R.drawable.camera_mode_video);
                this.rightCtrlPanel.setBackgroundColor(1291845632);
                this.rightCtrlPanelExpand.setBackgroundColor(1291845632);
                PreviewActivityV2 previewActivityV2 = PreviewActivityV2.this;
                previewActivityV2.m9256b(previewActivityV2.ivRecord, R.color.mb_red, 0);
                PreviewActivityV2.this.m9282E();
                if (z) {
                    PreviewActivityV2.this.m9361c(1);
                }
            } else if (i2 == 2) {
                AbstractC1644a m9172b = m9172b(2);
                if (m9172b != null && m9172b.m9128b()) {
                    m9172b.m9124f();
                }
                if (m9172b == this.f3773g) {
                    m9179a((View) null);
                }
                AbstractC1644a m9172b2 = m9172b(1);
                if (m9172b2 != null && m9172b2.m9128b()) {
                    m9172b2.m9124f();
                }
                if (m9172b2 == this.f3773g) {
                    m9179a((View) null);
                }
                this.ivCameraFPS.setVisibility(8);
                this.ivCameraRes.setVisibility(8);
                this.ivCameraMode.setImageResource(R.drawable.camera_mode_photo);
                this.rightCtrlPanel.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                this.rightCtrlPanelExpand.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                PreviewActivityV2 previewActivityV22 = PreviewActivityV2.this;
                previewActivityV22.m9256b(previewActivityV22.ivRecord, R.color.white, 0);
                PreviewActivityV2.this.m9283D();
                if (z) {
                    PreviewActivityV2.this.m9361c(2);
                }
            }
        }

        /* renamed from: a */
        public /* synthetic */ void m9175a(Long l) throws Exception {
            PreviewActivityV2.this.m9237d(false);
            PreviewActivityV2.f3730b.mo1511a((Object) "setCameraMode showLoadingCover done");
        }

        /* renamed from: j */
        void m9154j() {
            if (PreviewActivityV2.this.m9360d()) {
                Toast.makeText(PreviewActivityV2.this, "Please stop recording first", 1).show();
            } else {
                m9171b(m9169c() ? 2 : 1, true);
            }
        }

        /* renamed from: k */
        void m9152k() {
            if (!this.f3768b) {
                m9142u();
            } else if (m9162f()) {
                m9140w();
                return;
            } else if (m9160g()) {
                m9143t();
                return;
            } else {
                m9141v();
            }
            this.f3768b = !this.f3768b;
        }

        /* renamed from: l */
        void m9151l() {
            if (!this.f3768b) {
                m9142u();
            } else {
                m9141v();
            }
            this.f3768b = !this.f3768b;
        }

        /* renamed from: m */
        List<Animator> m9150m() {
            ObjectAnimator objectAnimator;
            ArrayList arrayList = new ArrayList();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(PreviewActivityV2.this.mTopContainer, "translationY", 0.0f, -PreviewActivityV2.this.mTopContainer.getHeight());
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(PreviewActivityV2.this.mBottomContainer, "translationY", 0.0f, PreviewActivityV2.this.mBottomContainer.getHeight());
            ofFloat.setDuration(200L);
            ofFloat2.setDuration(200L);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(PreviewActivityV2.this.mRobotCompass, "translationY", 0.0f, PreviewActivityV2.this.mRobotCompass.getHeight());
            ofFloat3.setDuration(200L);
            if (PreviewActivityV2.this.ivMotorEnableStatus.isShown()) {
                objectAnimator = ObjectAnimator.ofFloat(PreviewActivityV2.this.ivMotorEnableStatus, "translationX", 0.0f, -(((ViewGroup.MarginLayoutParams) PreviewActivityV2.this.ivMotorEnableStatus.getLayoutParams()).leftMargin + PreviewActivityV2.this.ivMotorEnableStatus.getWidth()));
                objectAnimator.setDuration(200L);
            } else {
                objectAnimator = null;
            }
            arrayList.add(ofFloat);
            arrayList.add(ofFloat2);
            arrayList.add(ofFloat3);
            if (objectAnimator != null) {
                arrayList.add(objectAnimator);
            }
            return arrayList;
        }

        /* renamed from: n */
        List<Animator> m9149n() {
            ObjectAnimator objectAnimator;
            ArrayList arrayList = new ArrayList();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(PreviewActivityV2.this.mTopContainer, "translationY", -PreviewActivityV2.this.mTopContainer.getHeight(), 0.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(PreviewActivityV2.this.mBottomContainer, "translationY", PreviewActivityV2.this.mBottomContainer.getHeight(), 0.0f);
            ofFloat.setStartDelay(100L);
            ofFloat.setDuration(200L);
            ofFloat2.setStartDelay(100L);
            ofFloat2.setDuration(200L);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(PreviewActivityV2.this.mRobotCompass, "translationY", PreviewActivityV2.this.mRobotCompass.getHeight(), 0.0f);
            ofFloat3.setStartDelay(100L);
            ofFloat3.setDuration(200L);
            if (PreviewActivityV2.this.ivMotorEnableStatus.isShown()) {
                objectAnimator = ObjectAnimator.ofFloat(PreviewActivityV2.this.ivMotorEnableStatus, "translationX", -(((ViewGroup.MarginLayoutParams) PreviewActivityV2.this.ivMotorEnableStatus.getLayoutParams()).getMarginStart() + PreviewActivityV2.this.ivMotorEnableStatus.getWidth()), 0.0f);
                objectAnimator.setStartDelay(100L);
                objectAnimator.setDuration(200L);
            } else {
                objectAnimator = null;
            }
            arrayList.add(ofFloat);
            arrayList.add(ofFloat2);
            arrayList.add(ofFloat3);
            if (objectAnimator != null) {
                arrayList.add(objectAnimator);
            }
            return arrayList;
        }

        /* renamed from: o */
        List<Animator> m9148o() {
            ArrayList arrayList = new ArrayList();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cameraParametersContainer, "translationX", -this.cameraParametersContainer.getWidth(), 0.0f);
            ofFloat.setStartDelay(80L);
            ofFloat.setDuration(200L);
            ofFloat.addListener(new AnimatorStartListener() { // from class: com.navatics.app.activities.PreviewActivityV2.ControlPanel.1
                {
                    ControlPanel.this = this;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    ControlPanel.this.cameraParametersContainer.setVisibility(0);
                }
            });
            arrayList.add(ofFloat);
            return arrayList;
        }

        /* renamed from: p */
        List<Animator> m9147p() {
            ArrayList arrayList = new ArrayList();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cameraParametersContainer, "translationX", 0.0f, -this.cameraParametersContainer.getWidth());
            ofFloat.setStartDelay(80L);
            ofFloat.setDuration(200L);
            ofFloat.addListener(new AnimatorEndListener() { // from class: com.navatics.app.activities.PreviewActivityV2.ControlPanel.2
                {
                    ControlPanel.this = this;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ControlPanel.this.cameraParametersContainer.setVisibility(4);
                }
            });
            arrayList.add(ofFloat);
            return arrayList;
        }

        /* renamed from: q */
        List<Animator> m9146q() {
            ArrayList arrayList = new ArrayList();
            float width = this.rightCtrlPanelExpand.getWidth();
            float x = this.rightCtrlPanelExpand.getX();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.rightCtrlPanelExpand, "x", x, x - width);
            ofFloat.setStartDelay(50L);
            ofFloat.setDuration(200L);
            ofFloat.addListener(new C16413());
            float x2 = PreviewActivityV2.this.xbarPitch.getX();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(PreviewActivityV2.this.xbarPitch, "x", x2, x2 - width);
            ofFloat2.setStartDelay(50L);
            ofFloat2.setDuration(200L);
            arrayList.add(ofFloat);
            arrayList.add(ofFloat2);
            return arrayList;
        }

        /* renamed from: com.navatics.app.activities.PreviewActivityV2$ControlPanel$3 */
        /* loaded from: classes.dex */
        public class C16413 extends AnimatorStartListener {
            /* renamed from: lambda$v8-olMEK8EL3HqrhoRdEBMpf8E8 */
            public static /* synthetic */ void m12995lambda$v8olMEK8EL3HqrhoRdEBMpf8E8(C16413 c16413, View view) {
                c16413.m9139a(view);
            }

            C16413() {
                ControlPanel.this = r1;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ControlPanel.this.rightCtrlPanelExpand.setVisibility(0);
                PreviewActivityV2.this.ivSetting.setImageResource(R.drawable.camera_mode_back);
                PreviewActivityV2.this.ivSetting.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$ControlPanel$3$v8-olMEK8EL3HqrhoRdEBMpf8E8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PreviewActivityV2.ControlPanel.C16413.m12995lambda$v8olMEK8EL3HqrhoRdEBMpf8E8(PreviewActivityV2.ControlPanel.C16413.this, view);
                    }
                });
            }

            /* renamed from: a */
            public /* synthetic */ void m9139a(View view) {
                ControlPanel.this.m9151l();
            }
        }

        /* renamed from: r */
        List<Animator> m9145r() {
            ArrayList arrayList = new ArrayList();
            float width = this.rightCtrlPanelExpand.getWidth();
            float x = this.rightCtrlPanelExpand.getX();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.rightCtrlPanelExpand, "x", x, x + width);
            ofFloat.setDuration(200L);
            ofFloat.addListener(new C16424());
            float x2 = PreviewActivityV2.this.xbarPitch.getX();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(PreviewActivityV2.this.xbarPitch, "x", x2, x2 + width);
            ofFloat2.setDuration(200L);
            arrayList.add(ofFloat);
            arrayList.add(ofFloat2);
            return arrayList;
        }

        /* renamed from: com.navatics.app.activities.PreviewActivityV2$ControlPanel$4 */
        /* loaded from: classes.dex */
        public class C16424 implements Animator.AnimatorListener {
            public static /* synthetic */ void lambda$_1uIhIMvgBi87213KaW01RCXJYg(C16424 c16424, View view) {
                c16424.m9138a(view);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            C16424() {
                ControlPanel.this = r1;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                PreviewActivityV2.this.ivSetting.setImageResource(R.drawable.top_setting);
                PreviewActivityV2.this.ivSetting.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$ControlPanel$4$_1uIhIMvgBi87213KaW01RCXJYg
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PreviewActivityV2.ControlPanel.C16424.lambda$_1uIhIMvgBi87213KaW01RCXJYg(PreviewActivityV2.ControlPanel.C16424.this, view);
                    }
                });
            }

            /* renamed from: a */
            public /* synthetic */ void m9138a(View view) {
                PreviewActivityV2.this.m9225g();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ControlPanel.this.rightCtrlPanelExpand.setVisibility(4);
            }
        }

        /* renamed from: a */
        void m9179a(View view) {
            View view2 = this.f3775i;
            if (view2 != null) {
                view2.setSelected(false);
                this.f3775i = null;
            }
            if (view != null) {
                view.setSelected(true);
                this.f3775i = view;
            }
        }

        /* renamed from: a */
        private void m9177a(AbstractC1644a abstractC1644a, View view) {
            AbstractC1644a abstractC1644a2 = this.f3773g;
            if (abstractC1644a2 == null || !abstractC1644a2.m9128b()) {
                m9174a(abstractC1644a.m9127c());
            } else {
                this.f3773g.m9124f();
                abstractC1644a.m9125e();
            }
            this.f3773g = abstractC1644a;
            m9179a(view);
        }

        /* renamed from: w */
        private void m9140w() {
            AbstractC1644a abstractC1644a = this.f3773g;
            if (abstractC1644a != null && abstractC1644a.m9128b()) {
                m9174a(this.f3773g.m9126d());
            }
            m9179a((View) null);
            this.f3773g = null;
        }

        /* renamed from: c */
        public void m9167c(View view) {
            AbstractC1644a m9172b = m9172b(((Integer) view.getTag()).intValue());
            if (m9172b == null) {
                return;
            }
            AbstractC1644a abstractC1644a = this.f3773g;
            if (abstractC1644a != null && abstractC1644a.m9128b() && this.f3773g == m9172b) {
                m9140w();
            } else {
                m9177a(m9172b, view);
            }
        }

        /* renamed from: b */
        private AbstractC1644a m9172b(int i) {
            for (AbstractC1644a abstractC1644a : this.f3771e) {
                if (abstractC1644a.mo9095a() == i) {
                    return abstractC1644a;
                }
            }
            return null;
        }

        /* renamed from: c */
        private AbstractC1647b m9168c(int i) {
            for (AbstractC1647b abstractC1647b : this.f3772f) {
                if (abstractC1647b.mo9077b() == i) {
                    return abstractC1647b;
                }
            }
            return null;
        }

        /* renamed from: a */
        public void m9174a(List<Animator> list) {
            AnimatorSet animatorSet = new AnimatorSet();
            AnimatorSet.Builder builder = null;
            for (Animator animator : list) {
                if (builder == null) {
                    builder = animatorSet.play(animator);
                } else {
                    builder.with(animator);
                }
            }
            animatorSet.start();
        }
    }

    /* renamed from: com.navatics.app.activities.PreviewActivityV2$a */
    /* loaded from: classes.dex */
    public abstract class AbstractC1644a {

        /* renamed from: a */
        View f3792a;

        /* renamed from: b */
        ControlPanel f3793b;

        /* renamed from: a */
        public static /* synthetic */ boolean m9129a(View view, MotionEvent motionEvent) {
            return true;
        }

        public static /* synthetic */ boolean lambda$VW3Ic5RKb60Nl2xXa2yH3_dfE1Q(View view, MotionEvent motionEvent) {
            return m9129a(view, motionEvent);
        }

        /* renamed from: a */
        abstract int mo9095a();

        /* renamed from: a */
        abstract void mo9092a(boolean z);

        AbstractC1644a(ControlPanel controlPanel, View view) {
            PreviewActivityV2.this = r1;
            this.f3793b = controlPanel;
            this.f3792a = view;
            this.f3792a.setOnTouchListener(new View.OnTouchListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$a$VW3Ic5RKb60Nl2xXa2yH3_dfE1Q
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    return PreviewActivityV2.AbstractC1644a.lambda$VW3Ic5RKb60Nl2xXa2yH3_dfE1Q(view2, motionEvent);
                }
            });
        }

        /* renamed from: b */
        public boolean m9128b() {
            View view = this.f3792a;
            return view != null && view.getVisibility() == 0;
        }

        /* renamed from: c */
        List<Animator> m9127c() {
            ArrayList arrayList = new ArrayList();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f3792a, "translationX", -this.f3792a.getWidth(), 0.0f);
            ofFloat.addListener(new AnimatorStartListener() { // from class: com.navatics.app.activities.PreviewActivityV2.a.1
                {
                    AbstractC1644a.this = this;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    AbstractC1644a.this.f3792a.setVisibility(0);
                }
            });
            ofFloat.setDuration(200L);
            arrayList.add(ofFloat);
            mo9092a(true);
            return arrayList;
        }

        /* renamed from: d */
        List<Animator> m9126d() {
            ArrayList arrayList = new ArrayList();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f3792a, "translationX", 0.0f, -this.f3792a.getWidth());
            ofFloat.addListener(new AnimatorEndListener() { // from class: com.navatics.app.activities.PreviewActivityV2.a.2
                {
                    AbstractC1644a.this = this;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AbstractC1644a.this.f3792a.setVisibility(4);
                }
            });
            ofFloat.setDuration(200L);
            arrayList.add(ofFloat);
            mo9092a(false);
            return arrayList;
        }

        /* renamed from: e */
        void m9125e() {
            if (Math.abs(this.f3792a.getAlpha() - 1.0f) > 0.0f) {
                this.f3792a.setAlpha(1.0f);
            }
            if (this.f3792a.getTranslationX() != 0.0f) {
                this.f3792a.setTranslationX(0.0f);
            }
            this.f3792a.setVisibility(0);
            mo9092a(true);
        }

        /* renamed from: f */
        void m9124f() {
            this.f3792a.setVisibility(4);
            mo9092a(false);
        }
    }

    /* renamed from: com.navatics.app.activities.PreviewActivityV2$l */
    /* loaded from: classes.dex */
    public abstract class AbstractC1658l extends AbstractC1644a {

        /* renamed from: j */
        int f3843j;

        /* renamed from: k */
        int f3844k;

        /* renamed from: l */
        View f3845l;

        /* renamed from: a */
        abstract void mo9094a(int i);

        /* renamed from: g */
        abstract int[] mo9085g();

        /* renamed from: h */
        abstract View[] mo9084h();

        /* renamed from: i */
        abstract int mo9083i();

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AbstractC1658l(ControlPanel controlPanel, View view, int i) {
            super(controlPanel, view);
            PreviewActivityV2.this = r1;
            this.f3843j = i;
        }

        /* renamed from: j */
        AbstractC1658l m9082j() {
            for (View view : mo9084h()) {
                view.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$onyT6sukormUqJIJC3Lz3Fel7R0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        PreviewActivityV2.AbstractC1658l.this.m9086d(view2);
                    }
                });
            }
            this.f3844k = mo9083i();
            return this;
        }

        @Override // com.navatics.app.activities.PreviewActivityV2.AbstractC1644a
        /* renamed from: a */
        int mo9095a() {
            return this.f3843j;
        }

        @Override // com.navatics.app.activities.PreviewActivityV2.AbstractC1644a
        /* renamed from: a */
        void mo9092a(boolean z) {
            if (z) {
                m9088c(m9089c(this.f3844k));
            }
        }

        /* renamed from: a */
        int m9093a(View view) {
            View[] mo9084h = mo9084h();
            for (int i = 0; i < mo9084h.length; i++) {
                if (mo9084h[i] == view) {
                    return i;
                }
            }
            return -1;
        }

        /* renamed from: b */
        int m9091b(int i) {
            int[] mo9085g = mo9085g();
            for (int i2 = 0; i2 < mo9085g.length; i2++) {
                if (mo9085g[i2] == i) {
                    return i2;
                }
            }
            return -1;
        }

        /* renamed from: b */
        int m9090b(View view) {
            int m9093a = m9093a(view);
            int[] mo9085g = mo9085g();
            if (m9093a < 0 || m9093a >= mo9085g.length) {
                return -1;
            }
            return mo9085g[m9093a];
        }

        /* renamed from: c */
        View m9089c(int i) {
            int m9091b = m9091b(i);
            View[] mo9084h = mo9084h();
            if (m9091b < 0 || m9091b >= mo9084h.length) {
                return null;
            }
            return mo9084h[m9091b];
        }

        /* renamed from: d */
        void m9087d(int i) {
            for (int i2 : mo9085g()) {
                if (i2 == i) {
                    this.f3844k = i;
                    return;
                }
            }
        }

        /* renamed from: c */
        void m9088c(View view) {
            View view2 = this.f3845l;
            if (view2 != null) {
                view2.setSelected(false);
                this.f3845l = null;
            }
            this.f3845l = view;
            View view3 = this.f3845l;
            if (view3 != null) {
                view3.setSelected(true);
            }
        }

        /* renamed from: d */
        public void m9086d(View view) {
            int m9090b = m9090b(view);
            if (m9090b < 0) {
                return;
            }
            m9088c(view);
            this.f3844k = m9090b;
            mo9094a(m9090b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.navatics.app.activities.PreviewActivityV2$i */
    /* loaded from: classes.dex */
    public class C1655i extends AbstractC1658l {

        /* renamed from: d */
        ImageView f3830d;

        /* renamed from: e */
        ImageView f3831e;

        /* renamed from: f */
        ImageView f3832f;

        /* renamed from: g */
        int[] f3833g;

        /* renamed from: h */
        View[] f3834h;

        @Override // com.navatics.app.activities.PreviewActivityV2.AbstractC1658l
        /* renamed from: i */
        int mo9083i() {
            return 1;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C1655i(ControlPanel controlPanel) {
            super(controlPanel, r3.findViewById(R.id.cameraParamResPanel), 1);
            PreviewActivityV2.this = r3;
            this.f3830d = (ImageView) this.f3792a.findViewById(R.id.ivRes4k);
            this.f3831e = (ImageView) this.f3792a.findViewById(R.id.ivRes2k);
            this.f3832f = (ImageView) this.f3792a.findViewById(R.id.ivRes1080p);
            this.f3833g = new int[]{3, 2, 1};
            this.f3834h = new View[]{this.f3832f, this.f3831e, this.f3830d};
        }

        @Override // com.navatics.app.activities.PreviewActivityV2.AbstractC1658l
        /* renamed from: g */
        int[] mo9085g() {
            return this.f3833g;
        }

        @Override // com.navatics.app.activities.PreviewActivityV2.AbstractC1658l
        /* renamed from: h */
        View[] mo9084h() {
            return this.f3834h;
        }

        @Override // com.navatics.app.activities.PreviewActivityV2.AbstractC1658l
        /* renamed from: a */
        void mo9094a(int i) {
            PreviewActivityV2.this.m9357e(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.navatics.app.activities.PreviewActivityV2$f */
    /* loaded from: classes.dex */
    public class C1652f extends AbstractC1658l {

        /* renamed from: d */
        TextView f3819d;

        /* renamed from: e */
        TextView f3820e;

        /* renamed from: f */
        int[] f3821f;

        /* renamed from: g */
        View[] f3822g;

        @Override // com.navatics.app.activities.PreviewActivityV2.AbstractC1658l
        /* renamed from: i */
        int mo9083i() {
            return 2;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C1652f(ControlPanel controlPanel) {
            super(controlPanel, r3.findViewById(R.id.cameraParamFPSPanel), 2);
            PreviewActivityV2.this = r3;
            this.f3819d = (TextView) this.f3792a.findViewById(R.id.tvFPS25);
            this.f3820e = (TextView) this.f3792a.findViewById(R.id.tvFPS30);
            this.f3821f = new int[]{1, 2};
            this.f3822g = new View[]{this.f3819d, this.f3820e};
        }

        @Override // com.navatics.app.activities.PreviewActivityV2.AbstractC1658l
        /* renamed from: g */
        int[] mo9085g() {
            return this.f3821f;
        }

        @Override // com.navatics.app.activities.PreviewActivityV2.AbstractC1658l
        /* renamed from: h */
        View[] mo9084h() {
            return this.f3822g;
        }

        @Override // com.navatics.app.activities.PreviewActivityV2.AbstractC1658l
        /* renamed from: a */
        void mo9094a(int i) {
            PreviewActivityV2.this.m9356f(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.navatics.app.activities.PreviewActivityV2$e */
    /* loaded from: classes.dex */
    public class C1651e extends AbstractC1658l {

        /* renamed from: d */
        ImageView f3814d;

        /* renamed from: e */
        ImageView f3815e;

        /* renamed from: f */
        int[] f3816f;

        /* renamed from: g */
        View[] f3817g;

        @Override // com.navatics.app.activities.PreviewActivityV2.AbstractC1658l
        /* renamed from: i */
        int mo9083i() {
            return 1;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C1651e(ControlPanel controlPanel) {
            super(controlPanel, r3.findViewById(R.id.cameraParamFOVPanel), 3);
            PreviewActivityV2.this = r3;
            this.f3814d = (ImageView) this.f3792a.findViewById(R.id.ivFOVWide);
            this.f3815e = (ImageView) this.f3792a.findViewById(R.id.ivFOVRectified);
            this.f3816f = new int[]{2, 1};
            this.f3817g = new View[]{this.f3815e, this.f3814d};
        }

        @Override // com.navatics.app.activities.PreviewActivityV2.AbstractC1658l
        /* renamed from: g */
        int[] mo9085g() {
            return this.f3816f;
        }

        @Override // com.navatics.app.activities.PreviewActivityV2.AbstractC1658l
        /* renamed from: h */
        View[] mo9084h() {
            return this.f3817g;
        }

        @Override // com.navatics.app.activities.PreviewActivityV2.AbstractC1658l
        /* renamed from: a */
        void mo9094a(int i) {
            PreviewActivityV2.this.m9355g(i);
        }
    }

    /* renamed from: com.navatics.app.activities.PreviewActivityV2$j */
    /* loaded from: classes.dex */
    public class C1656j extends AbstractC1644a {

        /* renamed from: d */
        ProgressBar f3836d;

        /* renamed from: e */
        TextView f3837e;

        /* renamed from: f */
        TextView f3838f;

        public static /* synthetic */ void lambda$bMlgExGaiBpd9GNyKMu0flXvhM0(C1656j c1656j, Throwable th) {
            c1656j.m9103a(th);
        }

        public static /* synthetic */ void lambda$zo7XGxQfmNdbgp2gI_vvafHT3iw(C1656j c1656j, StorageInfo storageInfo) {
            c1656j.m9104a(storageInfo);
        }

        @Override // com.navatics.app.activities.PreviewActivityV2.AbstractC1644a
        /* renamed from: a */
        int mo9095a() {
            return 4;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C1656j(ControlPanel controlPanel) {
            super(controlPanel, r7.findViewById(R.id.cameraParamSDPanel));
            PreviewActivityV2.this = r7;
            this.f3836d = (ProgressBar) this.f3792a.findViewById(R.id.sdUsageProgress);
            this.f3837e = (TextView) this.f3792a.findViewById(R.id.tvSDUsage);
            this.f3838f = (TextView) this.f3792a.findViewById(R.id.tvSDTotal);
            this.f3837e.setText(String.format(r7.getString(R.string.sd_usage), "25"));
            this.f3838f.setText(String.format(r7.getString(R.string.sd_usage_total), "100"));
        }

        @Override // com.navatics.app.activities.PreviewActivityV2.AbstractC1644a
        /* renamed from: a */
        void mo9092a(boolean z) {
            NvRobot robot = PreviewActivityV2.this.getRobot();
            if (!z || robot == null) {
                return;
            }
            robot.m7719E().mo6311a(NvObserverExecutor.m6303b()).mo6312a(new NvObserver() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$j$zo7XGxQfmNdbgp2gI_vvafHT3iw
                @Override // com.navatics.robot.transport.p063b.NvObserver
                public final void onNext(Object obj) {
                    PreviewActivityV2.C1656j.lambda$zo7XGxQfmNdbgp2gI_vvafHT3iw(PreviewActivityV2.C1656j.this, (StorageInfo) obj);
                }
            }, new NvExceptionHandler() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$j$bMlgExGaiBpd9GNyKMu0flXvhM0
                @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                public final void onError(Throwable th) {
                    PreviewActivityV2.C1656j.lambda$bMlgExGaiBpd9GNyKMu0flXvhM0(PreviewActivityV2.C1656j.this, th);
                }
            });
        }

        /* renamed from: a */
        public /* synthetic */ void m9104a(StorageInfo storageInfo) throws Exception {
            PreviewActivityV2.f3730b.mo1511a((Object) "getCameraStorageInfo success");
            NvValue totalSpace = storageInfo.getTotalSpace();
            NvValue m5978a = NvValue.m5978a(totalSpace.m5972b(), totalSpace.m5967c() - storageInfo.getFreeSpace().m5967c());
            this.f3837e.setText(String.format(PreviewActivityV2.this.getString(R.string.sd_usage), NvValue.m5974a(m5978a.m5961f())));
            this.f3838f.setText(String.format(PreviewActivityV2.this.getString(R.string.sd_usage_total), NvValue.m5974a(totalSpace.m5961f())));
            this.f3836d.setProgress((int) ((m5978a.m5967c() * 100.0d) / totalSpace.m5967c()));
        }

        /* renamed from: a */
        public /* synthetic */ void m9103a(Throwable th) {
            PreviewActivityV2.f3730b.mo1504b((Object) "getCameraStorageInfo fail");
            if (th instanceof NvException) {
                if (((ErrorResponse) ((NvException) th).getError().m6262c()) != null) {
                    Toast.makeText(PreviewActivityV2.this, "Request sd info failed", 0).show();
                } else {
                    Toast.makeText(PreviewActivityV2.this, "Sd info transaction failed", 0).show();
                }
            }
        }
    }

    /* renamed from: com.navatics.app.activities.PreviewActivityV2$b */
    /* loaded from: classes.dex */
    public abstract class AbstractC1647b {
        /* renamed from: a */
        abstract View mo9081a();

        /* renamed from: a */
        abstract void mo9079a(String str, Object obj);

        /* renamed from: a */
        abstract void mo9078a(boolean z);

        /* renamed from: b */
        abstract int mo9077b();

        /* renamed from: c */
        String m9123c() {
            return "default";
        }

        AbstractC1647b() {
            PreviewActivityV2.this = r1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.navatics.app.activities.PreviewActivityV2$d */
    /* loaded from: classes.dex */
    public class C1649d extends AbstractC1647b {

        /* renamed from: b */
        XBar f3809b;

        /* renamed from: c */
        View f3810c;

        /* renamed from: d */
        int f3811d;

        /* renamed from: b */
        public int m9110b(int i) {
            return (int) (((i * 1.0f) / 40.0f) * 255.0f);
        }

        @Override // com.navatics.app.activities.PreviewActivityV2.AbstractC1647b
        /* renamed from: b */
        int mo9077b() {
            return 1;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C1649d() {
            super();
            PreviewActivityV2.this = r1;
        }

        /* renamed from: a */
        public float m9112a(int i) {
            return Math.round((((i - 20) * 1.0f) / 10.0f) * 10.0f) / 10.0f;
        }

        @Override // com.navatics.app.activities.PreviewActivityV2.AbstractC1647b
        /* renamed from: a */
        View mo9081a() {
            if (this.f3809b == null) {
                this.f3810c = PreviewActivityV2.this.getLayoutInflater().inflate(R.layout.exposure_value_setting_view, (ViewGroup) null, false);
                this.f3809b = (XBar) this.f3810c.findViewById(R.id.xbarPModeEV);
                this.f3811d = 20;
                this.f3809b.setMax(40);
                this.f3809b.setProgress(20);
                this.f3809b.setThumb(TextDrawable.m6945a().mo6927a().mo6928c(2).mo6931a(DpiUtils.m5887a(PreviewActivityV2.this, 38.0f)).mo6929b(DpiUtils.m5887a(PreviewActivityV2.this, 22.0f)).mo6930b().mo6926a(String.valueOf(m9112a(20)), ViewCompat.MEASURED_STATE_MASK, 88));
                this.f3809b.setOnSeekBarChangeListener(new C1650a());
            }
            return this.f3810c;
        }

        @Override // com.navatics.app.activities.PreviewActivityV2.AbstractC1647b
        /* renamed from: a */
        void mo9078a(boolean z) {
            PreviewActivityV2.this.m9250b(!z);
            if (z) {
                this.f3809b.setProgress(this.f3811d);
            }
        }

        @Override // com.navatics.app.activities.PreviewActivityV2.AbstractC1647b
        /* renamed from: a */
        void mo9079a(String str, Object obj) {
            if (m9123c().equals(str)) {
                this.f3811d = ((Integer) obj).intValue();
            }
        }

        /* renamed from: com.navatics.app.activities.PreviewActivityV2$d$a */
        /* loaded from: classes.dex */
        class C1650a implements XBar.InterfaceC1980a {
            C1650a() {
                C1649d.this = r1;
            }

            @Override // com.navatics.app.widget.xbar.XBar.InterfaceC1980a
            /* renamed from: a */
            public void mo6878a(XBar xBar) {
                PreviewActivityV2.f3730b.mo1511a((Object) "onStartTrackingTouch");
            }

            @Override // com.navatics.app.widget.xbar.XBar.InterfaceC1980a
            /* renamed from: a */
            public void mo6877a(XBar xBar, int i, boolean z) {
                if (z) {
                    xBar.setThumb(TextDrawable.m6945a().mo6927a().mo6928c(2).mo6931a(DpiUtils.m5887a(PreviewActivityV2.this, 38.0f)).mo6929b(DpiUtils.m5887a(PreviewActivityV2.this, 22.0f)).mo6930b().mo6926a(String.valueOf(C1649d.this.m9112a(i)), ViewCompat.MEASURED_STATE_MASK, 88));
                }
                C1649d.this.f3811d = i;
            }

            @Override // com.navatics.app.widget.xbar.XBar.InterfaceC1980a
            /* renamed from: b */
            public void mo6876b(XBar xBar) {
                PreviewActivityV2 previewActivityV2 = PreviewActivityV2.this;
                C1649d c1649d = C1649d.this;
                previewActivityV2.m9354h(c1649d.m9110b(c1649d.f3811d));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.navatics.app.activities.PreviewActivityV2$m */
    /* loaded from: classes.dex */
    public class C1659m extends AbstractC1647b implements NvNumberPicker.InterfaceC1938b {

        /* renamed from: b */
        View f3847b;

        /* renamed from: c */
        NvNumberPicker f3848c;

        /* renamed from: d */
        int f3849d;

        /* renamed from: e */
        int[] f3850e;

        /* renamed from: a */
        public static /* synthetic */ void m9080a(View view) {
        }

        /* renamed from: lambda$yBnfuYCtyoUPIz56-2rMX5h2SLM */
        public static /* synthetic */ void m12998lambda$yBnfuYCtyoUPIz562rMX5h2SLM(View view) {
            m9080a(view);
        }

        @Override // com.navatics.app.activities.PreviewActivityV2.AbstractC1647b
        /* renamed from: b */
        int mo9077b() {
            return 2;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C1659m() {
            super();
            PreviewActivityV2.this = r1;
        }

        @Override // com.navatics.app.activities.PreviewActivityV2.AbstractC1647b
        /* renamed from: a */
        View mo9081a() {
            if (this.f3847b == null) {
                this.f3850e = new int[]{20, 25, 50, 100, CacheConfig.Post_Delayed, 200, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 500, 1000, 2000, 4000, 6000, 8000};
                String[] strArr = new String[this.f3850e.length];
                for (int i = 0; i < this.f3850e.length; i++) {
                    strArr[i] = String.format(Locale.getDefault(), "1/%d", Integer.valueOf(this.f3850e[i]));
                }
                this.f3847b = PreviewActivityV2.this.getLayoutInflater().inflate(R.layout.shutter_value_setting_view, (ViewGroup) null, false);
                this.f3847b.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$m$yBnfuYCtyoUPIz56-2rMX5h2SLM
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PreviewActivityV2.C1659m.m12998lambda$yBnfuYCtyoUPIz562rMX5h2SLM(view);
                    }
                });
                this.f3848c = (NvNumberPicker) this.f3847b.findViewById(R.id.shutterValuePicker);
                this.f3848c.setMaxValue(strArr.length - 1);
                this.f3848c.setMinValue(0);
                this.f3848c.setDisplayedValues(strArr);
                this.f3848c.setValue(strArr.length / 2);
                this.f3848c.setOnValueChangedListener(this);
            }
            return this.f3847b;
        }

        @Override // com.navatics.app.activities.PreviewActivityV2.AbstractC1647b
        /* renamed from: a */
        void mo9078a(boolean z) {
            PreviewActivityV2.this.m9250b(!z);
            if (z) {
                this.f3848c.setValue(this.f3849d);
            }
        }

        @Override // com.navatics.app.activities.PreviewActivityV2.AbstractC1647b
        /* renamed from: a */
        void mo9079a(String str, Object obj) {
            if (m9123c().equals(str)) {
                this.f3849d = ((Integer) obj).intValue();
            }
        }

        @Override // com.navatics.app.widget.NvNumberPicker.InterfaceC1938b
        /* renamed from: a */
        public void mo7172a(NvNumberPicker nvNumberPicker, int i, int i2) {
            int i3 = this.f3850e[i2];
            C3044k c3044k = PreviewActivityV2.f3730b;
            c3044k.mo1511a((Object) ("Shutter newVal " + i3));
            PreviewActivityV2.this.m9353i(i3);
            this.f3849d = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.navatics.app.activities.PreviewActivityV2$g */
    /* loaded from: classes.dex */
    public class C1653g extends AbstractC1647b implements NvNumberPicker.InterfaceC1938b {

        /* renamed from: b */
        View f3824b;

        /* renamed from: c */
        NvNumberPicker f3825c;

        /* renamed from: d */
        int f3826d;

        /* renamed from: a */
        public static /* synthetic */ void m9108a(View view) {
        }

        public static /* synthetic */ void lambda$f4HPdY30CDrFuOE2cEErZ94sJrs(View view) {
            m9108a(view);
        }

        @Override // com.navatics.app.activities.PreviewActivityV2.AbstractC1647b
        /* renamed from: b */
        int mo9077b() {
            return 3;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C1653g() {
            super();
            PreviewActivityV2.this = r1;
        }

        @Override // com.navatics.app.activities.PreviewActivityV2.AbstractC1647b
        /* renamed from: a */
        View mo9081a() {
            if (this.f3824b == null) {
                String[] strArr = {String.valueOf(CameraSettingMessage.m6444a(1)), String.valueOf(CameraSettingMessage.m6444a(2)), String.valueOf(CameraSettingMessage.m6444a(3)), String.valueOf(CameraSettingMessage.m6444a(4)), String.valueOf(CameraSettingMessage.m6444a(5)), String.valueOf(CameraSettingMessage.m6444a(6)), String.valueOf(CameraSettingMessage.m6444a(7))};
                this.f3824b = PreviewActivityV2.this.getLayoutInflater().inflate(R.layout.iso_value_setting_view, (ViewGroup) null, false);
                this.f3824b.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$g$f4HPdY30CDrFuOE2cEErZ94sJrs
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PreviewActivityV2.C1653g.lambda$f4HPdY30CDrFuOE2cEErZ94sJrs(view);
                    }
                });
                this.f3825c = (NvNumberPicker) this.f3824b.findViewById(R.id.isoValuePicker);
                this.f3825c.setMaxValue(strArr.length - 1);
                this.f3825c.setMinValue(0);
                this.f3825c.setDisplayedValues(strArr);
                this.f3825c.setValue(strArr.length / 2);
                this.f3825c.setOnValueChangedListener(this);
            }
            return this.f3824b;
        }

        @Override // com.navatics.app.activities.PreviewActivityV2.AbstractC1647b
        /* renamed from: a */
        void mo9078a(boolean z) {
            PreviewActivityV2.this.m9250b(!z);
            if (z) {
                this.f3825c.setValue(this.f3826d);
            }
        }

        @Override // com.navatics.app.activities.PreviewActivityV2.AbstractC1647b
        /* renamed from: a */
        void mo9079a(String str, Object obj) {
            if (m9123c().equals(str)) {
                this.f3826d = ((Integer) obj).intValue();
            }
        }

        @Override // com.navatics.app.widget.NvNumberPicker.InterfaceC1938b
        /* renamed from: a */
        public void mo7172a(NvNumberPicker nvNumberPicker, int i, int i2) {
            C3044k c3044k = PreviewActivityV2.f3730b;
            c3044k.mo1511a((Object) ("ISO newVal " + i2));
            PreviewActivityV2.this.m9352j(CameraSettingMessage.m6441b(i2));
            this.f3826d = i2;
        }
    }

    /* loaded from: classes.dex */
    public class WhiteBalancePanel extends AbstractC1647b {

        /* renamed from: b */
        RelativeLayout f3783b;

        /* renamed from: c */
        View f3784c;

        /* renamed from: d */
        int f3785d;

        /* renamed from: e */
        int f3786e;

        /* renamed from: f */
        int f3787f;

        /* renamed from: g */
        int f3788g;
        @BindView
        ImageView ivWB_auto;
        @BindView
        ImageView ivWB_cloudy;
        @BindView
        ImageView ivWB_coldlight;
        @BindView
        ImageView ivWB_manual;
        @BindView
        ImageView ivWB_sunny;
        @BindView
        ImageView ivWB_warmlight;
        @BindView
        XBar xbarWBManual;

        /* renamed from: lambda$-WPRl9pkQDxAZWvS422dknOgxEU */
        public static /* synthetic */ void m12996lambda$WPRl9pkQDxAZWvS422dknOgxEU(WhiteBalancePanel whiteBalancePanel, View view) {
            whiteBalancePanel.m9131f(view);
        }

        public static /* synthetic */ void lambda$1S5G_nqPCU1wB2YJyMh7wHGHbS8(WhiteBalancePanel whiteBalancePanel, View view) {
            whiteBalancePanel.m9133d(view);
        }

        /* renamed from: lambda$5j67zdpGqsUzv-1wEt8qwtv9MZk */
        public static /* synthetic */ void m12997lambda$5j67zdpGqsUzv1wEt8qwtv9MZk(WhiteBalancePanel whiteBalancePanel, View view) {
            whiteBalancePanel.m9136b(view);
        }

        public static /* synthetic */ void lambda$6QTnouQgeKSsmRfTM7hYZKDO7EM(WhiteBalancePanel whiteBalancePanel, View view) {
            whiteBalancePanel.m9132e(view);
        }

        public static /* synthetic */ void lambda$MAE9UWNDcIeh6MawRxd1_cEwjWU(WhiteBalancePanel whiteBalancePanel, View view) {
            whiteBalancePanel.m9134c(view);
        }

        public static /* synthetic */ void lambda$XXpZzbBntJXUbzgpzBVCleMFe2c(WhiteBalancePanel whiteBalancePanel, View view) {
            whiteBalancePanel.m9130g(view);
        }

        @Override // com.navatics.app.activities.PreviewActivityV2.AbstractC1647b
        /* renamed from: b */
        int mo9077b() {
            return 4;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WhiteBalancePanel() {
            super();
            PreviewActivityV2.this = r1;
        }

        /* renamed from: a */
        private void m9137a(View view) {
            View view2 = this.f3784c;
            if (view2 == null) {
                this.f3784c = view;
                this.f3784c.setSelected(true);
            } else if (view != view2) {
                view2.setSelected(false);
                this.f3784c = view;
                this.f3784c.setSelected(true);
            }
        }

        @Override // com.navatics.app.activities.PreviewActivityV2.AbstractC1647b
        /* renamed from: a */
        View mo9081a() {
            if (this.f3783b == null) {
                this.f3783b = (RelativeLayout) PreviewActivityV2.this.getLayoutInflater().inflate(R.layout.white_balance_setting_view, (ViewGroup) null, false);
                RelativeLayout relativeLayout = this.f3783b;
                if (relativeLayout == null) {
                    PreviewActivityV2.f3730b.mo1504b((Object) "wtf ?! whiteBalanceModeContainer is null");
                    throw new RuntimeException("wtf ?! whiteBalanceModeContainer is null");
                }
                ButterKnife.m12803a(this, relativeLayout);
                this.xbarWBManual.setMax(8);
                this.xbarWBManual.setProgress(2);
                this.xbarWBManual.setThumb(TextDrawable.m6945a().mo6927a().mo6928c(2).mo6931a(DpiUtils.m5887a(PreviewActivityV2.this, 38.0f)).mo6929b(DpiUtils.m5887a(PreviewActivityV2.this, 22.0f)).mo6930b().mo6926a(String.valueOf(this.xbarWBManual.getProgress()), ViewCompat.MEASURED_STATE_MASK, 88));
                this.xbarWBManual.setOnSeekBarChangeListener(new C1643a());
                this.ivWB_auto.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$WhiteBalancePanel$XXpZzbBntJXUbzgpzBVCleMFe2c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PreviewActivityV2.WhiteBalancePanel.lambda$XXpZzbBntJXUbzgpzBVCleMFe2c(PreviewActivityV2.WhiteBalancePanel.this, view);
                    }
                });
                this.ivWB_manual.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$WhiteBalancePanel$-WPRl9pkQDxAZWvS422dknOgxEU
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PreviewActivityV2.WhiteBalancePanel.m12996lambda$WPRl9pkQDxAZWvS422dknOgxEU(PreviewActivityV2.WhiteBalancePanel.this, view);
                    }
                });
                this.ivWB_sunny.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$WhiteBalancePanel$6QTnouQgeKSsmRfTM7hYZKDO7EM
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PreviewActivityV2.WhiteBalancePanel.lambda$6QTnouQgeKSsmRfTM7hYZKDO7EM(PreviewActivityV2.WhiteBalancePanel.this, view);
                    }
                });
                this.ivWB_cloudy.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$WhiteBalancePanel$1S5G_nqPCU1wB2YJyMh7wHGHbS8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PreviewActivityV2.WhiteBalancePanel.lambda$1S5G_nqPCU1wB2YJyMh7wHGHbS8(PreviewActivityV2.WhiteBalancePanel.this, view);
                    }
                });
                this.ivWB_warmlight.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$WhiteBalancePanel$MAE9UWNDcIeh6MawRxd1_cEwjWU
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PreviewActivityV2.WhiteBalancePanel.lambda$MAE9UWNDcIeh6MawRxd1_cEwjWU(PreviewActivityV2.WhiteBalancePanel.this, view);
                    }
                });
                this.ivWB_coldlight.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PreviewActivityV2$WhiteBalancePanel$5j67zdpGqsUzv-1wEt8qwtv9MZk
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PreviewActivityV2.WhiteBalancePanel.m12997lambda$5j67zdpGqsUzv1wEt8qwtv9MZk(PreviewActivityV2.WhiteBalancePanel.this, view);
                    }
                });
            }
            return this.f3783b;
        }

        /* renamed from: g */
        public /* synthetic */ void m9130g(View view) {
            m9137a(view);
            m9135b(false);
            PreviewActivityV2.this.m9351k(1);
        }

        /* renamed from: f */
        public /* synthetic */ void m9131f(View view) {
            m9137a(view);
            m9135b(true);
            PreviewActivityV2.this.m9351k(2);
        }

        /* renamed from: e */
        public /* synthetic */ void m9132e(View view) {
            m9137a(view);
            m9135b(false);
            PreviewActivityV2.this.m9351k(3);
        }

        /* renamed from: d */
        public /* synthetic */ void m9133d(View view) {
            m9137a(view);
            m9135b(false);
            PreviewActivityV2.this.m9351k(4);
        }

        /* renamed from: c */
        public /* synthetic */ void m9134c(View view) {
            m9137a(view);
            m9135b(false);
            PreviewActivityV2.this.m9351k(5);
        }

        /* renamed from: b */
        public /* synthetic */ void m9136b(View view) {
            m9137a(view);
            m9135b(false);
            PreviewActivityV2.this.m9351k(6);
        }

        @Override // com.navatics.app.activities.PreviewActivityV2.AbstractC1647b
        /* renamed from: a */
        void mo9078a(boolean z) {
            ImageView imageView;
            C3044k c3044k = PreviewActivityV2.f3730b;
            c3044k.mo1511a((Object) (getClass().getSimpleName() + " active " + z + ", currentMode " + this.f3785d));
            PreviewActivityV2.this.m9250b(z ^ true);
            if (z) {
                switch (this.f3785d) {
                    case 1:
                        imageView = this.ivWB_auto;
                        break;
                    case 2:
                        imageView = this.ivWB_manual;
                        break;
                    case 3:
                        imageView = this.ivWB_sunny;
                        break;
                    case 4:
                        imageView = this.ivWB_cloudy;
                        break;
                    case 5:
                        imageView = this.ivWB_warmlight;
                        break;
                    case 6:
                        imageView = this.ivWB_coldlight;
                        break;
                    default:
                        this.f3785d = 1;
                        imageView = this.ivWB_auto;
                        break;
                }
                m9137a(imageView);
                if (this.f3785d == 2) {
                    this.xbarWBManual.setVisibility(0);
                    this.xbarWBManual.setProgress(this.f3786e);
                    return;
                }
                this.xbarWBManual.setVisibility(8);
            }
        }

        @Override // com.navatics.app.activities.PreviewActivityV2.AbstractC1647b
        /* renamed from: a */
        void mo9079a(String str, Object obj) {
            if ("wb_mode".equals(str)) {
                C3044k c3044k = PreviewActivityV2.f3730b;
                c3044k.mo1511a((Object) ("ui_set wb_mode " + obj));
                this.f3785d = ((Integer) obj).intValue();
            } else if ("ch_red".equals(str)) {
                C3044k c3044k2 = PreviewActivityV2.f3730b;
                c3044k2.mo1511a((Object) ("ui_set ch_red " + obj));
                this.f3787f = ((Integer) obj).intValue();
            } else if ("ch_blue".equals(str)) {
                C3044k c3044k3 = PreviewActivityV2.f3730b;
                c3044k3.mo1511a((Object) ("ui_set ch_blue " + obj));
                this.f3788g = ((Integer) obj).intValue();
            }
        }

        /* renamed from: b */
        private void m9135b(boolean z) {
            this.xbarWBManual.setVisibility(z ? 0 : 8);
        }

        /* renamed from: com.navatics.app.activities.PreviewActivityV2$WhiteBalancePanel$a */
        /* loaded from: classes.dex */
        class C1643a implements XBar.InterfaceC1980a {
            C1643a() {
                WhiteBalancePanel.this = r1;
            }

            @Override // com.navatics.app.widget.xbar.XBar.InterfaceC1980a
            /* renamed from: a */
            public void mo6878a(XBar xBar) {
                PreviewActivityV2.f3730b.mo1511a((Object) "onStartTrackingTouch");
                WhiteBalancePanel.this.f3786e = xBar.getProgress();
            }

            @Override // com.navatics.app.widget.xbar.XBar.InterfaceC1980a
            /* renamed from: a */
            public void mo6877a(XBar xBar, int i, boolean z) {
                if (z) {
                    xBar.setThumb(TextDrawable.m6945a().mo6927a().mo6928c(2).mo6931a(DpiUtils.m5887a(PreviewActivityV2.this, 38.0f)).mo6929b(DpiUtils.m5887a(PreviewActivityV2.this, 22.0f)).mo6930b().mo6926a(String.valueOf(i), ViewCompat.MEASURED_STATE_MASK, 88));
                }
                WhiteBalancePanel.this.f3786e = i;
            }

            @Override // com.navatics.app.widget.xbar.XBar.InterfaceC1980a
            /* renamed from: b */
            public void mo6876b(XBar xBar) {
                int i;
                int i2;
                PreviewActivityV2.f3730b.mo1511a((Object) "onStopTrackingTouch");
                int i3 = (WhiteBalancePanel.this.f3786e + 2) * 1000;
                if (i3 > 6000) {
                    float f = i3 * 1.0f;
                    i2 = (int) ((((f - 6000.0f) / 4000.0f) * 30.0f) + 20.0f);
                    i = (int) (((10000.0f - f) / 4000.0f) * 24.0f);
                } else {
                    float f2 = i3 * 1.0f;
                    i = (int) (((6000.0f - f2) / 4000.0f) * 24.0f);
                    i2 = (int) (((f2 - 2000.0f) / 4000.0f) * 20.0f);
                }
                if (i2 < 0) {
                    i2 = 0;
                } else if (i2 > 255) {
                    i2 = 255;
                }
                if (i < 0) {
                    i = 0;
                } else if (i > 255) {
                    i = 255;
                }
                C3044k c3044k = PreviewActivityV2.f3730b;
                c3044k.mo1511a((Object) ("red " + i2 + ", blue " + i));
                PreviewActivityV2.this.m9363a(i2, i);
            }
        }
    }
}
