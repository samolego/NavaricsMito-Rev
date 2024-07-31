package com.navatics.app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.graphics.drawable.PathInterpolatorCompat;
import android.support.p008v4.app.FragmentTransaction;
import android.support.p008v4.view.InputDeviceCompat;
import android.support.p011v7.app.AppCompatActivity;
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
import com.navatics.app.widget.NotificationView;
import com.navatics.app.widget.dialog.TextHintDialog;
import com.navatics.robot.transport.NvDeviceInfo;
import com.navatics.robot.transport.NvError;
import io.reactivex.disposables.Disposable;
import io.reactivex.p093a.p095b.AndroidSchedulers;
import io.reactivex.p096b.Consumer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.C3044k;
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
    private C1517a mConfig;
    private NvBuoy mCurrentBuoy;
    private AlertDialog mRemoteInitFailedAlert;
    private Disposable mRobotDisposable;
    private TextHintDialog textHintDialog;
    private static final C3044k logger = C3044k.m1564a(NvBaseActivity.class);
    private static volatile boolean hasShowControllerToast = false;
    private static volatile HashMap<String, String> toastMap = new HashMap<>();
    private static volatile boolean getRobotStatusUpdate = false;

    /* renamed from: mH */
    private Handler f3461mH = new HandlerC1519b(this);
    private boolean level_5_GroundStation_hint = false;
    private boolean level_10_GroundStation_hint = false;
    private boolean level_5_Buoy_hint = false;
    private boolean level_10_Buoy_hint = false;
    private boolean level_5_Robot_hint = false;
    private boolean level_10_Robot_hint = false;

    protected void onConnectionAuthenticationFailed(NvConnection nvConnection, NvError nvError) {
    }

    public void onConnectionLost(NvConnection nvConnection) {
    }

    protected void onCurrentConnectionChanged(NvConnection nvConnection, NvConnection nvConnection2) {
    }

    protected void onCurrentGroundStationChanged(GroundStation groundStation, GroundStation groundStation2) {
    }

    public void onDeviceAuthenticationSuccess(NvConnection nvConnection) {
    }

    public void onDeviceConnected(NvConnection nvConnection) {
    }

    protected void onDeviceConnecting(GroundStation groundStation, NvDeviceInfo nvDeviceInfo) {
    }

    public void onGroundStationAuthenticationFailed(GroundStation groundStation, NvError nvError) {
    }

    public void onGroundStationAuthenticationSuccess(GroundStation groundStation) {
    }

    public void onGroundStationConnected(GroundStation groundStation) {
    }

    public void onGroundStationDisconnected(GroundStation groundStation) {
    }

    protected void onGroundStationInitFailed(GroundStation groundStation) {
    }

    protected void onGroundStationNewInstance(GroundStation groundStation) {
    }

    public void onIsCompassInCalibration(boolean z) {
    }

    protected void onMessage(Message message) {
    }

    protected void onNewDeviceInstance(NvConnection nvConnection) {
    }

    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mConfig = onCreateConfig();
        logger.mo1511a(this.mConfig);
        if (this.mConfig.f3465c) {
            return;
        }
        Navatics.m7947b().m8577a(this);
    }

    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (!this.mConfig.f3465c) {
            Navatics.m7947b().m8573b(this);
        }
        removeMessage(104);
        removeMessage(103);
        removeMessage(101);
    }

    protected void postDelay(Runnable runnable, long j) {
        this.f3461mH.postDelayed(runnable, j);
    }

    public void sendMessageDelay(int i, long j) {
        this.f3461mH.sendMessageDelayed(this.f3461mH.obtainMessage(i), j);
    }

    protected void sendMessage(int i, Object obj) {
        this.f3461mH.obtainMessage(i, obj).sendToTarget();
    }

    public void removeMessage(int i) {
        this.f3461mH.removeMessages(i);
    }

    public NvRobot getRobot() {
        return mCurrentRobot;
    }

    protected NvBuoy getBuoy() {
        return this.mCurrentBuoy;
    }

    protected C1517a onCreateConfig() {
        return new C1517a.C1518a().m9566a().m9564b();
    }

    public void onGroundStationStateUpdate(GroundStation groundStation) {
        isShowLowBatteryAlert(groundStation.m8103h().m8061a().getLevel(), "GroundStation");
    }

    public void onRobotStatusUpdate(RobotStatus robotStatus) {
        isShowLowBatteryAlert(robotStatus.m8631w(), "Robot");
        getRobotStatusUpdate = true;
        if (getRobot().m7693f().m8642l()) {
            sendMessage(103, 1);
        } else {
            sendMessage(103, 0);
        }
        if (getRobot() != null && !getRobot().m7676r()) {
            onIsCompassInCalibration(false);
        } else {
            onIsCompassInCalibration(true);
        }
    }

    public void onBuoyStatusUpdate(BuoyStatus buoyStatus) {
        isShowLowBatteryAlert(buoyStatus.m8410c(), "Buoy");
    }

    @EventHandler(m8585b = 65547, m8584c = 1)
    private void handleOnGroundStationConnected(GroundStation groundStation) {
        logger.mo1511a((Object) "onGroundStationConnected 1");
        if (this.mConfig.f3463a) {
            if (this.mConfig.f3464b == 1) {
                showConnectWarning(getString(R.string.controller_connected));
            } else if (this.mConfig.f3464b == 2) {
                logger.mo1511a((Object) "onGroundStationConnected 2");
                showControllerConnectedToast();
            }
        }
        onGroundStationConnected(groundStation);
    }

    @EventHandler(m8585b = 65568, m8584c = 1)
    private void handleOnGroundStationNewInstance(GroundStation groundStation) {
        logger.mo1511a((Object) "handleOnGroundStationNewInstance");
        onGroundStationNewInstance(groundStation);
        Intent intent = new Intent(this, BindRemoteActivity.class);
        intent.putExtra("remote_id", groundStation.m8129b());
        startActivity(intent);
    }

    @EventHandler(m8585b = 65546, m8584c = 1)
    private void handleOnGroundStationAuthenticationSuccess(GroundStation groundStation) {
        logger.mo1511a((Object) "handleOnGroundStationAuthenticationSuccess");
        onGroundStationAuthenticationSuccess(groundStation);
    }

    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        FirmwareUpdateManager.m8212a(this).registerFirmwareFinishListener(new FirmwareUpdateManager.InterfaceC1831b() { // from class: com.navatics.app.NvBaseActivity.1
            {
                NvBaseActivity.this = this;
            }

            @Override // com.navatics.app.framework.firmware.FirmwareUpdateManager.InterfaceC1831b
            /* renamed from: a */
            public void mo8176a(int i) {
                if (i == 1) {
                    NvBaseActivity nvBaseActivity = NvBaseActivity.this;
                    nvBaseActivity.textHintDialog = new TextHintDialog(nvBaseActivity, nvBaseActivity.getResources().getString(R.string.remote_control_update_complete), NvBaseActivity.this.getResources().getString(R.string.i_see));
                    NvBaseActivity.this.textHintDialog.show();
                }
            }
        });
    }

    @EventHandler(m8585b = 196609, m8584c = 1)
    private void handleOnCurrentGroundStationChanged(GroundStation groundStation, GroundStation groundStation2) {
        onCurrentGroundStationChanged(groundStation, groundStation2);
    }

    @EventHandler(m8585b = 65548, m8584c = 1)
    private void handleOnGroundStationDisconnected(GroundStation groundStation) {
        logger.mo1511a((Object) "onGroundStationDisconnected");
        if (this.mConfig.f3463a) {
            if (this.mConfig.f3464b == 1) {
                showConnectWarning(getString(R.string.Controller_disconnected));
            } else if (this.mConfig.f3464b == 2) {
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

    @EventHandler(m8585b = IjkMediaPlayer.OnNativeInvokeListener.CTRL_WILL_HTTP_OPEN, m8584c = 1)
    private void handleOnGroundStationStateUpdate(GroundStation groundStation) {
        onGroundStationStateUpdate(groundStation);
    }

    @EventHandler(m8585b = 65570, m8584c = 1)
    private void handleOnDeviceConnecting(GroundStation groundStation, NvDeviceInfo nvDeviceInfo) {
        onDeviceConnecting(groundStation, nvDeviceInfo);
    }

    @EventHandler(m8585b = InputDeviceCompat.SOURCE_TRACKBALL, m8584c = 1)
    private void handleOnDeviceConnected(NvConnection nvConnection) {
        onDeviceConnected(nvConnection);
        removeMessage(104);
        sendMessageDelay(104, 5000L);
        removeMessage(101);
    }

    @EventHandler(m8585b = 65569, m8584c = 1)
    private void handleOnNewDeviceInstance(GroundStation groundStation, NvConnection nvConnection) {
        onNewDeviceInstance(nvConnection);
        Intent intent = new Intent(this, BindRobotActivity.class);
        intent.putExtra("remote_id", groundStation.m8129b());
        intent.putExtra("conn_id", nvConnection.m7881e());
        startActivity(intent);
    }

    @EventHandler(m8585b = 65543, m8584c = 1)
    private void handleOnDeviceAuthenticationSuccess(NvConnection nvConnection) {
        mCurrentRobot = (NvRobot) nvConnection.m7898a(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        this.mCurrentBuoy = (NvBuoy) nvConnection.m7898a(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        mConnection = nvConnection;
        if (this.mConfig.f3463a) {
            showConnectWarning(getString(R.string.buoy_connected));
        }
        if (nvConnection != null && nvConnection.m7875j()) {
            attachConnection(nvConnection);
        }
        onDeviceAuthenticationSuccess(nvConnection);
    }

    @EventHandler(m8585b = 196610, m8584c = 1)
    private void handleOnCurrentConnectionChanged(NvConnection nvConnection, NvConnection nvConnection2) {
        if (nvConnection2 != null && nvConnection2.m7875j()) {
            attachConnection(nvConnection2);
        }
        onCurrentConnectionChanged(nvConnection, nvConnection2);
    }

    @EventHandler(m8585b = 65541, m8584c = 1)
    private void handleOnConnectionLost(NvConnection nvConnection) {
        logger.mo1511a((Object) "onConnectionLost ");
        if (this.mConfig.f3463a) {
            logger.mo1511a((Object) "onConnectionLost1 ");
            showConnectWarning(getString(R.string.connection_lost));
        }
        removeMessage(101);
        sendMessageDelay(101, 20000L);
        removeMessage(104);
        detachConnection(nvConnection);
        onConnectionLost(nvConnection);
    }

    @EventHandler(m8585b = 16711689, m8584c = 1)
    private void handleOnGroundStationInitFailed(GroundStation groundStation) {
        showInitControllerFailedDialog();
        onGroundStationInitFailed(groundStation);
    }

    @EventHandler(m8586a = 255, m8585b = 0, m8584c = 1)
    private void handleOnError(int i, Object obj, NvError nvError) {
        if (obj instanceof GroundStation) {
            GroundStation groundStation = (GroundStation) obj;
            if (i != 16711681) {
                if (i != 16711685) {
                    return;
                }
                switch (nvError.m6266a()) {
                    case 48:
                        showInitControllerFailedDialog();
                        break;
                    case 50:
                        if (this.mConfig.f3463a) {
                            showWarning("Authentication Failed(" + nvError.m6266a() + ")");
                            break;
                        }
                        break;
                    case 51:
                        if (this.mConfig.f3463a) {
                            showWarning("You are not the owner of this controller.");
                            break;
                        }
                        break;
                }
                onGroundStationAuthenticationFailed(groundStation, nvError);
            } else if (nvError.m6266a() == 54) {
                if (this.mConfig.f3463a) {
                    showWarning("Bug detected(et=16711681, ec=54, l=hp");
                }
            } else if (nvError.m6266a() == 49) {
                if (this.mConfig.f3463a) {
                    showWarning("Connect error because of invalid params");
                }
            } else if (nvError.m6266a() == 48) {
                if (this.mConfig.f3463a) {
                    showWarning("Timeout when connecting to roller");
                }
            } else if (nvError.m6266a() == 255) {
                if (this.mConfig.f3463a) {
                    showWarning("Connection failed for unknown reason");
                }
            } else if (this.mConfig.f3463a) {
                showWarning(NvError.m6265a(nvError.m6266a()));
            }
        } else if (obj instanceof NvConnection) {
            NvConnection nvConnection = (NvConnection) obj;
            if (i == 16711682) {
                onConnectionAuthenticationFailed(nvConnection, nvError);
            }
            if (this.mConfig.f3463a) {
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
        } else if ("Buoy".equals(str)) {
            if (!this.level_5_Buoy_hint) {
                showWarning(String.format(string2, getResources().getString(R.string.buoy), i + "%"));
            }
            this.level_5_Buoy_hint = true;
        } else if ("Robot".equals(str)) {
            if (!this.level_5_Robot_hint) {
                showWarning(String.format(string2, getResources().getString(R.string.underwater_robot), i + "%"));
            }
            this.level_5_Robot_hint = true;
        }
    }

    private void attachConnection(NvConnection nvConnection) {
        if (this.mRobotDisposable == null && this.mBuoyDisposable == null) {
            mConnection = nvConnection;
            mCurrentRobot = (NvRobot) nvConnection.m7898a(InputDeviceCompat.SOURCE_TOUCHSCREEN);
            this.mCurrentBuoy = (NvBuoy) nvConnection.m7898a(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            this.mRobotDisposable = mCurrentRobot.m7691g().m3064e(200L, TimeUnit.MILLISECONDS).m3091a(AndroidSchedulers.m3250a()).m3107a(new Consumer() { // from class: com.navatics.app.-$$Lambda$WPKuInFzMH1Ynm7Kr01MpqLjCN4
                @Override // io.reactivex.p096b.Consumer
                public final void accept(Object obj) {
                    NvBaseActivity.this.onRobotStatusUpdate((RobotStatus) obj);
                }
            }, new Consumer() { // from class: com.navatics.app.-$$Lambda$e27-Kr4VJxN1zC_AGmQwWE7CADQ
                @Override // io.reactivex.p096b.Consumer
                public final void accept(Object obj) {
                    ((Throwable) obj).printStackTrace();
                }
            });
            this.mBuoyDisposable = this.mCurrentBuoy.m7903b().m3064e(200L, TimeUnit.MILLISECONDS).m3091a(AndroidSchedulers.m3250a()).m3107a(new Consumer() { // from class: com.navatics.app.-$$Lambda$O-JJ-ouYsjJVME2wJlPHnMnZAR4
                @Override // io.reactivex.p096b.Consumer
                public final void accept(Object obj) {
                    NvBaseActivity.this.onBuoyStatusUpdate((BuoyStatus) obj);
                }
            }, new Consumer() { // from class: com.navatics.app.-$$Lambda$e27-Kr4VJxN1zC_AGmQwWE7CADQ
                @Override // io.reactivex.p096b.Consumer
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
        this.mRemoteInitFailedAlert = new AlertDialog.Builder(this).setMessage(getString(R.string.init_controller_failed_unplug_try_again)).setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() { // from class: com.navatics.app.-$$Lambda$NvBaseActivity$d8cEXd_twOeVPl44XLCxAEV3VU8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                NvBaseActivity.lambda$showInitControllerFailedDialog$0(NvBaseActivity.this, dialogInterface, i);
            }
        }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.navatics.app.-$$Lambda$NvBaseActivity$TwEWT2m8OeDdIkZN2SYC7VOzkL8
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                NvBaseActivity.lambda$showInitControllerFailedDialog$1(NvBaseActivity.this, dialogInterface);
            }
        }).create();
        this.mRemoteInitFailedAlert.setCanceledOnTouchOutside(false);
        this.mRemoteInitFailedAlert.show();
    }

    public static /* synthetic */ void lambda$showInitControllerFailedDialog$0(NvBaseActivity nvBaseActivity, DialogInterface dialogInterface, int i) {
        nvBaseActivity.goToHomeScreen();
    }

    public static /* synthetic */ void lambda$showInitControllerFailedDialog$1(NvBaseActivity nvBaseActivity, DialogInterface dialogInterface) {
        nvBaseActivity.mRemoteInitFailedAlert = null;
    }

    public void goToHomeScreen() {
        if ((this instanceof HomepageActivity) || (this instanceof PreviewActivityV2)) {
            return;
        }
        finish();
        startActivity(new Intent(this, HomepageActivity.class));
    }

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
        NotificationView.m6993a(this).m6991a(str).m6994a(PathInterpolatorCompat.MAX_NUM_POINTS).m6990b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.navatics.app.NvBaseActivity$b */
    /* loaded from: classes.dex */
    public static class HandlerC1519b extends Handler {

        /* renamed from: a */
        WeakReference<NvBaseActivity> f3469a;

        HandlerC1519b(NvBaseActivity nvBaseActivity) {
            this.f3469a = new WeakReference<>(nvBaseActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            NvBaseActivity nvBaseActivity = this.f3469a.get();
            if (nvBaseActivity == null) {
                return;
            }
            int i = message.what;
            if (i == 1) {
                nvBaseActivity.showWarning((String) message.obj);
            } else if (i == 104) {
                if (nvBaseActivity instanceof PreviewActivityV2) {
                    removeMessages(104);
                    if (NvBaseActivity.mConnection != null && NvBaseActivity.mConnection.m7879f().m6027c().m6342h()) {
                        boolean unused = NvBaseActivity.getRobotStatusUpdate = true;
                    }
                    if (NvBaseActivity.getRobotStatusUpdate || !NvBaseActivity.mCurrentRobot.m7687i()) {
                        message.obj = 1;
                    } else {
                        message.obj = 0;
                    }
                    boolean unused2 = NvBaseActivity.getRobotStatusUpdate = false;
                    nvBaseActivity.sendMessageDelay(104, 5000L);
                    nvBaseActivity.onMessage(message);
                }
            } else {
                nvBaseActivity.onMessage(message);
            }
        }
    }

    /* renamed from: com.navatics.app.NvBaseActivity$a */
    /* loaded from: classes.dex */
    public static class C1517a {

        /* renamed from: a */
        boolean f3463a;

        /* renamed from: b */
        int f3464b;

        /* renamed from: c */
        boolean f3465c;

        public C1517a(boolean z, int i, boolean z2) {
            this.f3463a = z;
            this.f3464b = i;
            this.f3465c = z2;
        }

        public String toString() {
            return "Config{enableSystemStatusNotify=" + this.f3463a + ", gndDisconnNoticeType=" + this.f3464b + ", disableAll=" + this.f3465c + '}';
        }

        /* renamed from: com.navatics.app.NvBaseActivity$a$a */
        /* loaded from: classes.dex */
        public static class C1518a {

            /* renamed from: a */
            boolean f3466a = false;

            /* renamed from: b */
            int f3467b = 2;

            /* renamed from: c */
            boolean f3468c = false;

            /* renamed from: a */
            C1518a m9566a() {
                return this;
            }

            /* renamed from: a */
            public C1518a m9565a(boolean z) {
                this.f3466a = z;
                return this;
            }

            /* renamed from: b */
            public C1518a m9563b(boolean z) {
                this.f3468c = z;
                return this;
            }

            /* renamed from: b */
            public C1517a m9564b() {
                return new C1517a(this.f3466a, this.f3467b, this.f3468c);
            }
        }
    }
}
