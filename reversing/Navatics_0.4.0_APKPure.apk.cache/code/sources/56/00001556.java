package com.navatics.app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.graphics.drawable.PathInterpolatorCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.InputDeviceCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;
import com.navatics.app.activities.BindRemoteActivity;
import com.navatics.app.activities.BindRobotActivity;
import com.navatics.app.activities.HomepageActivity;
import com.navatics.app.activities.PreviewActivityV2;
import com.navatics.app.framework.BuoyStatus;
import com.navatics.app.framework.GroundStation;
import com.navatics.app.framework.Navatics;
import com.navatics.app.framework.NvBuoy;
import com.navatics.app.framework.NvConnection;
import com.navatics.app.framework.NvRobot;
import com.navatics.app.framework.RobotStatus;
import com.navatics.app.framework.annotation.EventHandler;
import com.navatics.app.framework.firmware.FirmwareUpdateManager;
import com.navatics.app.widget.ViewOnClickListenerC1888c;
import com.navatics.app.widget.dialog.TextHintDialog;
import com.navatics.robot.transport.NvDeviceInfo;
import com.navatics.robot.transport.NvError;
import io.reactivex.disposables.Disposable;
import io.reactivex.p082a.p084b.AndroidSchedulers;
import io.reactivex.p085b.Consumer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: classes.dex */
public abstract class NvBaseActivity extends AppCompatActivity {
    public static final int MSG_DISCONNECT_TIMEOUT = 101;
    public static final int MSG_MOTORS_BLOCKED = 103;
    public static final int MSG_ROBOT_STATUS_UPDATE = 104;
    private static final int MSG_SEND_ALERT = 1;
    private static NvConnection mConnection;
    private static NvRobot mCurrentRobot;
    private Disposable mBuoyDisposable;
    private C1391a mConfig;
    private NvBuoy mCurrentBuoy;
    private AlertDialog mRemoteInitFailedAlert;
    private Disposable mRobotDisposable;
    private TextHintDialog textHintDialog;
    private static final Logger logger = Logger.getLogger(NvBaseActivity.class);
    private static volatile boolean hasShowControllerToast = false;
    private static volatile HashMap<String, String> toastMap = new HashMap<>();
    private static volatile boolean getRobotStatusUpdate = false;

    /* renamed from: mH */
    private Handler f3470mH = new HandlerC1392b(this);
    private boolean level_5_GroundStation_hint = false;
    private boolean level_10_GroundStation_hint = false;
    private boolean level_5_Buoy_hint = false;
    private boolean level_10_Buoy_hint = false;
    private boolean level_5_Robot_hint = false;
    private boolean level_10_Robot_hint = false;

    protected void onConnectionAuthenticationFailed(NvConnection nvConnection, NvError nvError) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onConnectionLost(NvConnection nvConnection) {
    }

    protected void onCurrentConnectionChanged(NvConnection nvConnection, NvConnection nvConnection2) {
    }

    protected void onCurrentGroundStationChanged(GroundStation groundStation, GroundStation groundStation2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDeviceAuthenticationSuccess(NvConnection nvConnection) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDeviceConnected(NvConnection nvConnection) {
    }

    protected void onDeviceConnecting(GroundStation groundStation, NvDeviceInfo nvDeviceInfo) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGroundStationAuthenticationFailed(GroundStation groundStation, NvError nvError) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGroundStationAuthenticationSuccess(GroundStation groundStation) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGroundStationConnected(GroundStation groundStation) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGroundStationDisconnected(GroundStation groundStation) {
    }

    protected void onGroundStationInitFailed(GroundStation groundStation) {
    }

    protected void onGroundStationNewInstance(GroundStation groundStation) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onIsCompassInCalibration(boolean z) {
    }

    protected void onMessage(Message message) {
    }

    protected void onNewDeviceInstance(NvConnection nvConnection) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mConfig = onCreateConfig();
        logger.conditionalLog3(this.mConfig);
        if (this.mConfig.f3474c) {
            return;
        }
        Navatics.m4989b().m4436a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (!this.mConfig.f3474c) {
            Navatics.m4989b().m4438b(this);
        }
        removeMessage(104);
        removeMessage(103);
        removeMessage(101);
    }

    protected void postDelay(Runnable runnable, long j) {
        this.f3470mH.postDelayed(runnable, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendMessageDelay(int i, long j) {
        this.f3470mH.sendMessageDelayed(this.f3470mH.obtainMessage(i), j);
    }

    protected void sendMessage(int i, Object obj) {
        this.f3470mH.obtainMessage(i, obj).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeMessage(int i) {
        this.f3470mH.removeMessages(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public NvRobot getRobot() {
        return mCurrentRobot;
    }

    protected NvBuoy getBuoy() {
        return this.mCurrentBuoy;
    }

    protected C1391a onCreateConfig() {
        return new C1391a.a().m3362a().m3365b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGroundStationStateUpdate(GroundStation groundStation) {
        isShowLowBatteryAlert(groundStation.getGroundStationStatus().getBatteryInfo().getLevel(), "GroundStation");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRobotStatusUpdate(RobotStatus robotStatus) {
        isShowLowBatteryAlert(robotStatus.m4377w(), "Robot");
        getRobotStatusUpdate = true;
        if (getRobot().m5221f().m4366l()) {
            sendMessage(103, 1);
        } else {
            sendMessage(103, 0);
        }
        if (getRobot() != null && !getRobot().m5238r()) {
            onIsCompassInCalibration(false);
        } else {
            onIsCompassInCalibration(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onBuoyStatusUpdate(BuoyStatus buoyStatus) {
        isShowLowBatteryAlert(buoyStatus.m4575c(), "Buoy");
    }

    @EventHandler(m4423b = 65547, m4424c = 1)
    private void handleOnGroundStationConnected(GroundStation groundStation) {
        logger.conditionalLog3((Object) "onGroundStationConnected 1");
        if (this.mConfig.f3472a) {
            if (this.mConfig.f3473b == 1) {
                showConnectWarning(getString(R.string.controller_connected));
            } else if (this.mConfig.f3473b == 2) {
                logger.conditionalLog3((Object) "onGroundStationConnected 2");
                showControllerConnectedToast();
            }
        }
        onGroundStationConnected(groundStation);
    }

    @EventHandler(m4423b = 65568, m4424c = 1)
    private void handleOnGroundStationNewInstance(GroundStation groundStation) {
        logger.conditionalLog3((Object) "handleOnGroundStationNewInstance");
        onGroundStationNewInstance(groundStation);
        Intent intent = new Intent(this, (Class<?>) BindRemoteActivity.class);
        intent.putExtra("remote_id", groundStation.getRemoteId());
        startActivity(intent);
    }

    @EventHandler(m4423b = 65546, m4424c = 1)
    private void handleOnGroundStationAuthenticationSuccess(GroundStation groundStation) {
        logger.conditionalLog3((Object) "handleOnGroundStationAuthenticationSuccess");
        onGroundStationAuthenticationSuccess(groundStation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        FirmwareUpdateManager.m4786a(this).registerFirmwareFinishListener(new FirmwareUpdateManager.b() { // from class: com.navatics.app.NvBaseActivity.1
            @Override // com.navatics.app.framework.firmware.FirmwareUpdateManager.b
            /* renamed from: a */
            public void mo3361a(int i) {
                if (i == 1) {
                    NvBaseActivity nvBaseActivity = NvBaseActivity.this;
                    nvBaseActivity.textHintDialog = new TextHintDialog(nvBaseActivity, nvBaseActivity.getResources().getString(R.string.remote_control_update_complete), NvBaseActivity.this.getResources().getString(R.string.i_see));
                    NvBaseActivity.this.textHintDialog.show();
                }
            }
        });
    }

    @EventHandler(m4423b = 196609, m4424c = 1)
    private void handleOnCurrentGroundStationChanged(GroundStation groundStation, GroundStation groundStation2) {
        onCurrentGroundStationChanged(groundStation, groundStation2);
    }

    @EventHandler(m4423b = 65548, m4424c = 1)
    private void handleOnGroundStationDisconnected(GroundStation groundStation) {
        logger.conditionalLog3((Object) "onGroundStationDisconnected");
        if (this.mConfig.f3472a) {
            if (this.mConfig.f3473b == 1) {
                showConnectWarning(getString(R.string.Controller_disconnected));
            } else if (this.mConfig.f3473b == 2) {
                showControllerDisconnectedToast();
            }
        }
        postDelay(new Runnable() { // from class: com.navatics.app.-$$Lambda$NNg0WlfmYCWNFlIoSXlxu6SekUQ
            @Override // java.lang.Runnable
            public final void run() {
                NvBaseActivity.this.goToHomeScreen();
            }
        }, 1000L);
        onGroundStationDisconnected(groundStation);
    }

    @EventHandler(m4423b = IjkMediaPlayer.OnNativeInvokeListener.CTRL_WILL_HTTP_OPEN, m4424c = 1)
    private void handleOnGroundStationStateUpdate(GroundStation groundStation) {
        onGroundStationStateUpdate(groundStation);
    }

    @EventHandler(m4423b = 65570, m4424c = 1)
    private void handleOnDeviceConnecting(GroundStation groundStation, NvDeviceInfo nvDeviceInfo) {
        onDeviceConnecting(groundStation, nvDeviceInfo);
    }

    @EventHandler(m4423b = InputDeviceCompat.SOURCE_TRACKBALL, m4424c = 1)
    private void handleOnDeviceConnected(NvConnection nvConnection) {
        onDeviceConnected(nvConnection);
        removeMessage(104);
        sendMessageDelay(104, 5000L);
        removeMessage(101);
    }

    @EventHandler(m4423b = 65569, m4424c = 1)
    private void handleOnNewDeviceInstance(GroundStation groundStation, NvConnection nvConnection) {
        onNewDeviceInstance(nvConnection);
        Intent intent = new Intent(this, (Class<?>) BindRobotActivity.class);
        intent.putExtra("remote_id", groundStation.getRemoteId());
        intent.putExtra("conn_id", nvConnection.getConnectionId());
        startActivity(intent);
    }

    @EventHandler(m4423b = 65543, m4424c = 1)
    private void handleOnDeviceAuthenticationSuccess(NvConnection nvConnection) {
        mCurrentRobot = (NvRobot) nvConnection.m5049a(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        this.mCurrentBuoy = (NvBuoy) nvConnection.m5049a(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        mConnection = nvConnection;
        if (this.mConfig.f3472a) {
            showConnectWarning(getString(R.string.buoy_connected));
        }
        if (nvConnection != null && nvConnection.isAuthed()) {
            attachConnection(nvConnection);
        }
        onDeviceAuthenticationSuccess(nvConnection);
    }

    @EventHandler(m4423b = 196610, m4424c = 1)
    private void handleOnCurrentConnectionChanged(NvConnection nvConnection, NvConnection nvConnection2) {
        if (nvConnection2 != null && nvConnection2.isAuthed()) {
            attachConnection(nvConnection2);
        }
        onCurrentConnectionChanged(nvConnection, nvConnection2);
    }

    @EventHandler(m4423b = 65541, m4424c = 1)
    private void handleOnConnectionLost(NvConnection nvConnection) {
        logger.conditionalLog3((Object) "onConnectionLost ");
        if (this.mConfig.f3472a) {
            logger.conditionalLog3((Object) "onConnectionLost1 ");
            showConnectWarning(getString(R.string.connection_lost));
        }
        removeMessage(101);
        sendMessageDelay(101, 20000L);
        removeMessage(104);
        detachConnection(nvConnection);
        onConnectionLost(nvConnection);
    }

    @EventHandler(m4423b = 16711689, m4424c = 1)
    private void handleOnGroundStationInitFailed(GroundStation groundStation) {
        showInitControllerFailedDialog();
        onGroundStationInitFailed(groundStation);
    }

    @EventHandler(m4422a = 255, m4423b = 0, m4424c = 1)
    private void handleOnError(int i, Object obj, NvError nvError) {
        if (obj instanceof GroundStation) {
            GroundStation groundStation = (GroundStation) obj;
            if (i != 16711681) {
                if (i != 16711685) {
                    return;
                }
                switch (nvError.m6630a()) {
                    case 48:
                        showInitControllerFailedDialog();
                        break;
                    case 50:
                        if (this.mConfig.f3472a) {
                            showWarning("Authentication Failed(" + nvError.m6630a() + ")");
                            break;
                        }
                        break;
                    case 51:
                        if (this.mConfig.f3472a) {
                            showWarning("You are not the owner of this controller.");
                            break;
                        }
                        break;
                }
                onGroundStationAuthenticationFailed(groundStation, nvError);
                return;
            }
            if (nvError.m6630a() == 54) {
                if (this.mConfig.f3472a) {
                    showWarning("Bug detected(et=16711681, ec=54, l=hp");
                    return;
                }
                return;
            }
            if (nvError.m6630a() == 49) {
                if (this.mConfig.f3472a) {
                    showWarning("Connect error because of invalid params");
                    return;
                }
                return;
            } else if (nvError.m6630a() == 48) {
                if (this.mConfig.f3472a) {
                    showWarning("Timeout when connecting to roller");
                    return;
                }
                return;
            } else if (nvError.m6630a() == 255) {
                if (this.mConfig.f3472a) {
                    showWarning("Connection failed for unknown reason");
                    return;
                }
                return;
            } else {
                if (this.mConfig.f3472a) {
                    showWarning(NvError.getType(nvError.m6630a()));
                    return;
                }
                return;
            }
        }
        if (obj instanceof NvConnection) {
            NvConnection nvConnection = (NvConnection) obj;
            if (i == 16711682) {
                onConnectionAuthenticationFailed(nvConnection, nvError);
            }
            if (this.mConfig.f3472a) {
                showWarning("Authentication Failed ! Cause : " + nvError);
            }
        }
    }

    protected void showControllerConnectedToast() {
        if (hasShowControllerToast) {
            return;
        }
        hasShowControllerToast = true;
        Toast toast = new Toast(this);
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.remote_connected_toast);
        toast.setView(imageView);
        toast.setDuration(0);
        toast.setGravity(17, 0, 0);
        toast.show();
    }

    protected void showControllerDisconnectedToast() {
        hasShowControllerToast = false;
        Toast toast = new Toast(this);
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.remote_disconnected_toast);
        toast.setView(imageView);
        toast.setDuration(0);
        toast.setGravity(17, 0, 0);
        toast.show();
    }

    protected void isShowLowBatteryAlert(int i, String str) {
        if (5 < i && i <= 10) {
            String string = getString(R.string.low_battery_hint);
            if ("GroundStation".equals(str)) {
                if (!this.level_10_GroundStation_hint) {
                    showWarning(String.format(string, getResources().getString(R.string.controller), i + "%"));
                }
                this.level_10_GroundStation_hint = true;
            } else if ("Buoy".equals(str)) {
                if (!this.level_10_Buoy_hint) {
                    showWarning(String.format(string, getResources().getString(R.string.buoy), i + "%"));
                }
                this.level_10_Buoy_hint = true;
            } else if ("Robot".equals(str)) {
                if (!this.level_10_Robot_hint) {
                    showWarning(String.format(string, getResources().getString(R.string.underwater_robot), i + "%"));
                }
                this.level_10_Robot_hint = true;
            }
        }
        if (i < 0 || i > 5) {
            return;
        }
        String string2 = getString(R.string.low_battery_hint);
        if ("GroundStation".equals(str)) {
            if (!this.level_5_GroundStation_hint) {
                showWarning(String.format(string2, getResources().getString(R.string.controller), i + "%"));
            }
            this.level_5_GroundStation_hint = true;
            return;
        }
        if ("Buoy".equals(str)) {
            if (!this.level_5_Buoy_hint) {
                showWarning(String.format(string2, getResources().getString(R.string.buoy), i + "%"));
            }
            this.level_5_Buoy_hint = true;
            return;
        }
        if ("Robot".equals(str)) {
            if (!this.level_5_Robot_hint) {
                showWarning(String.format(string2, getResources().getString(R.string.underwater_robot), i + "%"));
            }
            this.level_5_Robot_hint = true;
        }
    }

    private void attachConnection(NvConnection nvConnection) {
        if (this.mRobotDisposable == null && this.mBuoyDisposable == null) {
            mConnection = nvConnection;
            mCurrentRobot = (NvRobot) nvConnection.m5049a(InputDeviceCompat.SOURCE_TOUCHSCREEN);
            this.mCurrentBuoy = (NvBuoy) nvConnection.m5049a(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            this.mRobotDisposable = mCurrentRobot.m5224g().m9772e(200L, TimeUnit.MILLISECONDS).m9757a(AndroidSchedulers.m9582a()).m9742a(new Consumer() { // from class: com.navatics.app.-$$Lambda$WPKuInFzMH1Ynm7Kr01MpqLjCN4
                @Override // io.reactivex.p085b.Consumer
                public final void accept(Object obj) {
                    NvBaseActivity.this.onRobotStatusUpdate((RobotStatus) obj);
                }
            }, new Consumer() { // from class: com.navatics.app.-$$Lambda$e27-Kr4VJxN1zC_AGmQwWE7CADQ
                @Override // io.reactivex.p085b.Consumer
                public final void accept(Object obj) {
                    ((Throwable) obj).printStackTrace();
                }
            });
            this.mBuoyDisposable = this.mCurrentBuoy.m5034b().m9772e(200L, TimeUnit.MILLISECONDS).m9757a(AndroidSchedulers.m9582a()).m9742a(new Consumer() { // from class: com.navatics.app.-$$Lambda$O-JJ-ouYsjJVME2wJlPHnMnZAR4
                @Override // io.reactivex.p085b.Consumer
                public final void accept(Object obj) {
                    NvBaseActivity.this.onBuoyStatusUpdate((BuoyStatus) obj);
                }
            }, new Consumer() { // from class: com.navatics.app.-$$Lambda$e27-Kr4VJxN1zC_AGmQwWE7CADQ
                @Override // io.reactivex.p085b.Consumer
                public final void accept(Object obj) {
                    ((Throwable) obj).printStackTrace();
                }
            });
        }
    }

    private void detachConnection(NvConnection nvConnection) {
        Disposable disposable = this.mRobotDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        this.mRobotDisposable = null;
        Disposable disposable2 = this.mBuoyDisposable;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        this.mBuoyDisposable = null;
        mCurrentRobot = null;
        this.mCurrentBuoy = null;
        mConnection = null;
    }

    protected void showInitControllerFailedDialog() {
        this.mRemoteInitFailedAlert = new AlertDialog.Builder(this).setMessage(getString(R.string.init_controller_failed_unplug_try_again)).setPositiveButton(getString(R.string.f3486ok), new DialogInterface.OnClickListener() { // from class: com.navatics.app.-$$Lambda$NvBaseActivity$d8cEXd_twOeVPl44XLCxAEV3VU8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                NvBaseActivity.this.goToHomeScreen();
            }
        }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.navatics.app.-$$Lambda$NvBaseActivity$TwEWT2m8OeDdIkZN2SYC7VOzkL8
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                NvBaseActivity.this.mRemoteInitFailedAlert = null;
            }
        }).create();
        this.mRemoteInitFailedAlert.setCanceledOnTouchOutside(false);
        this.mRemoteInitFailedAlert.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void goToHomeScreen() {
        if ((this instanceof HomepageActivity) || (this instanceof PreviewActivityV2)) {
            return;
        }
        finish();
        startActivity(new Intent(this, (Class<?>) HomepageActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideAnyDialog() {
        AlertDialog alertDialog = this.mRemoteInitFailedAlert;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    protected void showWarning(String str) {
        if (Thread.currentThread() == getMainLooper().getThread()) {
            showWarningImpl(str);
        } else {
            sendMessage(1, str);
        }
    }

    protected void showConnectWarning(String str) {
        if (toastMap.containsKey(str) && toastMap.get(str).equals("1")) {
            return;
        }
        if (str.equals(getString(R.string.connection_lost))) {
            toastMap.put(getString(R.string.buoy_connected), "0");
        } else if (str.equals(getString(R.string.Controller_disconnected))) {
            toastMap.put(getString(R.string.controller_connected), "0");
        } else {
            toastMap.put(str, "1");
        }
        if (Thread.currentThread() == getMainLooper().getThread()) {
            showWarningImpl(str);
        } else {
            sendMessage(1, str);
        }
    }

    private void showWarningImpl(String str) {
        ViewOnClickListenerC1888c.m5870a(this).m5876a(str).m5875a(PathInterpolatorCompat.MAX_NUM_POINTS).m5878b();
    }

    /* renamed from: com.navatics.app.NvBaseActivity$b */
    /* loaded from: classes.dex */
    static class HandlerC1392b extends Handler {

        /* renamed from: a */
        WeakReference<NvBaseActivity> f3478a;

        HandlerC1392b(NvBaseActivity nvBaseActivity) {
            this.f3478a = new WeakReference<>(nvBaseActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            NvBaseActivity nvBaseActivity = this.f3478a.get();
            if (nvBaseActivity == null) {
                return;
            }
            int i = message.what;
            if (i == 1) {
                nvBaseActivity.showWarning((String) message.obj);
                return;
            }
            if (i == 104) {
                if (nvBaseActivity instanceof PreviewActivityV2) {
                    removeMessages(104);
                    if (NvBaseActivity.mConnection != null && NvBaseActivity.mConnection.getSocket().getChannel().m6521h()) {
                        boolean unused = NvBaseActivity.getRobotStatusUpdate = true;
                    }
                    if (NvBaseActivity.getRobotStatusUpdate || !NvBaseActivity.mCurrentRobot.m5228i()) {
                        message.obj = 1;
                    } else {
                        message.obj = 0;
                    }
                    boolean unused2 = NvBaseActivity.getRobotStatusUpdate = false;
                    nvBaseActivity.sendMessageDelay(104, 5000L);
                    nvBaseActivity.onMessage(message);
                    return;
                }
                return;
            }
            nvBaseActivity.onMessage(message);
        }
    }

    /* renamed from: com.navatics.app.NvBaseActivity$a */
    /* loaded from: classes.dex */
    public static class C1391a {

        /* renamed from: a */
        boolean f3472a;

        /* renamed from: b */
        int f3473b;

        /* renamed from: c */
        boolean f3474c;

        public C1391a(boolean z, int i, boolean z2) {
            this.f3472a = z;
            this.f3473b = i;
            this.f3474c = z2;
        }

        public String toString() {
            return "Config{enableSystemStatusNotify=" + this.f3472a + ", gndDisconnNoticeType=" + this.f3473b + ", disableAll=" + this.f3474c + '}';
        }

        /* renamed from: com.navatics.app.NvBaseActivity$a$a */
        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a */
            boolean f3475a = false;

            /* renamed from: b */
            int f3476b = 2;

            /* renamed from: c */
            boolean f3477c = false;

            /* renamed from: a */
            a m3362a() {
                return this;
            }

            /* renamed from: a */
            public a m3363a(boolean z) {
                this.f3475a = z;
                return this;
            }

            /* renamed from: b */
            public a m3364b(boolean z) {
                this.f3477c = z;
                return this;
            }

            /* renamed from: b */
            public C1391a m3365b() {
                return new C1391a(this.f3475a, this.f3476b, this.f3477c);
            }
        }
    }
}