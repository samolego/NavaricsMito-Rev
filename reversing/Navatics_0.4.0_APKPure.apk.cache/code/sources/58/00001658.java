package com.navatics.app.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.view.InputDeviceCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.navatics.app.NvBaseActivity;
import com.navatics.app.R;
import com.navatics.app.framework.GroundStation;
import com.navatics.app.framework.Navatics;
import com.navatics.app.framework.NvConnection;
import com.navatics.app.framework.NvRobot;
import com.navatics.app.framework.firmware.FirmwareUpdateInfo;
import com.navatics.app.framework.firmware.FirmwareUpdateManager;
import com.navatics.app.framework.p049g.RxUtils;
import com.navatics.app.framework.user.NvUser;
import com.navatics.app.framework.user.NvUserEvent;
import com.navatics.app.framework.user.NvUserManager;
import com.navatics.app.utils.IntentUtils;
import com.navatics.app.widget.WebViewWrapper;
import com.navatics.app.widget.badge.BadgeView;
import com.navatics.robot.transport.NvDeviceInfo;
import com.navatics.robot.utils.logging.LoggerUtil;
import com.navatics.xlog.WLog;
import io.reactivex.disposables.Disposable;
import io.reactivex.p082a.p084b.AndroidSchedulers;
import io.reactivex.p085b.Consumer;
import io.reactivex.p088e.Schedulers;
import java.io.IOException;
import org.apache.log4j.Logger;

/* loaded from: classes.dex */
public class HomepageActivity extends LocationActivity {

    /* renamed from: b */
    private static final Logger logger = Logger.getLogger(HomepageActivity.class);

    /* renamed from: a */
    Disposable f3602a;

    @BindView
    Button btnConnect;

    /* renamed from: c */
    private BadgeView f3603c;

    /* renamed from: d */
    private boolean f3604d = false;

    @BindView
    ImageView ivDiveLogIcon;

    @BindView
    ImageView ivMediaLibraryIcon;

    @BindView
    ImageView ivRobotImg;

    @BindView
    ImageView ivSetting;

    @BindView
    ImageView ivTitleIcon;

    @BindView
    ImageView ivUsrImg;

    @BindView
    RelativeLayout rootLayout;

    @BindView
    RelativeLayout selectorContainer;

    @BindView
    TextView tvConnSignal;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.NvBaseActivity
    public void onGroundStationDisconnected(GroundStation groundStation) {
        m3533e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.NvBaseActivity
    public void onGroundStationAuthenticationSuccess(GroundStation groundStation) {
        hideAnyDialog();
        FirmwareUpdateManager.m4786a(this).m4800a(groundStation.getDeviceInfo()).m9756a(RxUtils.m4906a()).m9742a(new Consumer<FirmwareUpdateInfo>() { // from class: com.navatics.app.activities.HomepageActivity.1
            @Override // io.reactivex.p085b.Consumer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(FirmwareUpdateInfo firmwareUpdateInfo) throws Exception {
                if (firmwareUpdateInfo.m4778f() == 0) {
                    HomepageActivity.this.m3534f();
                }
            }
        }, new Consumer<Throwable>() { // from class: com.navatics.app.activities.HomepageActivity.2
            @Override // io.reactivex.p085b.Consumer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(Throwable th) throws Exception {
            }
        });
    }

    @Override // com.navatics.app.NvBaseActivity
    protected void onDeviceConnecting(GroundStation groundStation, NvDeviceInfo nvDeviceInfo) {
        this.btnConnect.setText(getString(R.string.connecting));
    }

    @Override // com.navatics.app.NvBaseActivity
    public void onDeviceAuthenticationSuccess(NvConnection nvConnection) {
        m3533e();
        if (nvConnection != null && nvConnection.isAuthed() && nvConnection.isAuthed()) {
            try {
                FirmwareUpdateManager.m4786a(this).m4799a((NvRobot) nvConnection.m5049a(InputDeviceCompat.SOURCE_TOUCHSCREEN)).m9756a(RxUtils.m4906a()).m9742a(new Consumer<FirmwareUpdateInfo>() { // from class: com.navatics.app.activities.HomepageActivity.3
                    @Override // io.reactivex.p085b.Consumer
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void accept(FirmwareUpdateInfo firmwareUpdateInfo) throws Exception {
                        if (firmwareUpdateInfo.m4778f() != 0 || firmwareUpdateInfo.m4771c() == null) {
                            return;
                        }
                        HomepageActivity.this.m3534f();
                    }
                }, new Consumer<Throwable>() { // from class: com.navatics.app.activities.HomepageActivity.4
                    @Override // io.reactivex.p085b.Consumer
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void accept(Throwable th) throws Exception {
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.activities.LocationActivity, com.navatics.app.NvBaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 23) {
            getWindow().getDecorView().setSystemUiVisibility(8192);
            getWindow().setStatusBarColor(-1);
        }
        setContentView(R.layout.activity_homepage);
        ButterKnife.m151a(this);
        this.ivRobotImg.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$HomepageActivity$DH1IlLsifarTx2pTV6tAIOYlYNQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Navatics.authenticateAllGroundStations();
            }
        });
        this.tvConnSignal.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$HomepageActivity$xBRccX9--ppyivaQ-unqJiTJ0Xk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomepageActivity.this.onClick(view);
            }
        });
        this.ivTitleIcon.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$HomepageActivity$7W4YRwC3AtLrMTrsQoX6gNmq3-0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomepageActivity.this.showAppVersionInToast(view);
            }
        });
        m3530c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void onClick(View view) {
        logger.conditionalLog3((Object) "tvConnSignal onclick");
        startActivity(new Intent(this, (Class<?>) SearchDeviceActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void showAppVersionInToast(View view) {
        Toast.makeText(this, "0.4.0", 1).show();
    }

    @Override // com.navatics.app.NvBaseActivity
    protected NvBaseActivity.C1391a onCreateConfig() {
        return new NvBaseActivity.C1391a.a().m3363a(true).m3365b();
    }

    /* renamed from: c */
    private void m3530c() {
        if (PreferenceManager.getDefaultSharedPreferences(this).getBoolean("key_agree_privacy_policy", false)) {
            return;
        }
        poliycDialog();
    }

    /* renamed from: d */
    private void poliycDialog() {
        final SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        WebViewWrapper webViewWrapper = new WebViewWrapper(this);
        AlertDialog.Builder negativeButton = new AlertDialog.Builder(this).setTitle(getString(R.string.privacy_policy)).setView(webViewWrapper).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.navatics.app.activities.HomepageActivity.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (defaultSharedPreferences.getBoolean("key_agree_privacy_policy", false)) {
                    return;
                }
                Process.killProcess(Process.myPid());
            }
        }).setPositiveButton(getString(R.string.agree_text), new DialogInterface.OnClickListener() { // from class: com.navatics.app.activities.HomepageActivity.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                SharedPreferences.Editor edit = defaultSharedPreferences.edit();
                edit.putBoolean("key_agree_privacy_policy", true);
                edit.apply();
            }
        }).setNegativeButton(getString(R.string.no_text), new DialogInterface.OnClickListener() { // from class: com.navatics.app.activities.HomepageActivity.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Process.killProcess(Process.myPid());
            }
        });
        webViewWrapper.m5804a("https://www.navatics.com/privacy_policy.html");
        negativeButton.show();
    }

    /* renamed from: e */
    private void m3533e() {
        NvConnection connection;
        GroundStation groundStation = Navatics.getGroundStation();
        if (groundStation != null && groundStation.isValid() && groundStation.isControllerAuthed() && (connection = groundStation.getConnection()) != null && connection.isAuthed()) {
            this.tvConnSignal.setVisibility(0);
            this.ivRobotImg.setImageResource(R.drawable.homepage_mito_connected);
            this.btnConnect.setBackgroundResource(R.drawable.homepage_conn_btn_bg_connected);
            this.btnConnect.setTextColor(getResources().getColor(R.color.white));
            this.btnConnect.setText(getString(R.string.start_diving));
            return;
        }
        this.tvConnSignal.setVisibility(8);
        this.ivRobotImg.setImageResource(R.drawable.homepage_mito);
        this.btnConnect.setBackgroundResource(R.drawable.homepage_conn_btn_bg_disconnected);
        this.btnConnect.setText(getString(R.string.connect));
        this.btnConnect.setTextColor(getResources().getColor(R.color.black));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.activities.LocationActivity, com.navatics.app.NvBaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        WLog.appenderClose();
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setRequestedOrientation(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.NvBaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.f3602a = NvUserManager.getInstance().m5148i().m9762b(Schedulers.m9619b()).m9757a(AndroidSchedulers.m9582a()).m9742a(new Consumer() { // from class: com.navatics.app.activities.-$$Lambda$HomepageActivity$9K0QVetXMEzmS-4_RhCfiM6B4Fg
            @Override // io.reactivex.p085b.Consumer
            public final void accept(Object obj) {
                HomepageActivity.this.handleUserEvent((NvUserEvent) obj);
            }
        }, $$Lambda$e27Kr4VJxN1zC_AGmQwWE7CADQ.INSTANCE);
        m3533e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        Disposable disposable = this.f3602a;
        if (disposable == null || disposable.isDisposed()) {
            return;
        }
        this.f3602a.dispose();
        this.f3602a = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void handleUserEvent(NvUserEvent nvUserEvent) {
        logger.conditionalLog3((Object) ("handleUserEvent, event : " + nvUserEvent.getId()));
        switch (nvUserEvent.getId()) {
            case 0:
            default:
                return;
            case 1:
            case 2:
                updateUiByUser(nvUserEvent.getUser());
                Navatics.authenticateAllGroundStations();
                return;
        }
    }

    /* renamed from: a */
    private void updateUiByUser(NvUser nvUser) {
        logger.conditionalLog3((Object) ("updateUiByUser, " + nvUser));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m3534f() {
        this.f3604d = true;
        BadgeView badgeView = this.f3603c;
        if (badgeView == null) {
            this.f3603c = new BadgeView(this);
            this.f3603c.m5859a(this.ivSetting);
            this.f3603c.m5860a("");
            this.f3603c.m5863b(false);
            this.f3603c.m5857a(0.0f, 5.0f, true);
            return;
        }
        badgeView.setVisibility(0);
    }

    /* renamed from: b */
    private void connectButtonAction(NvUser nvUser) {
        NvConnection currentActiveConnection = Navatics.currentActiveConnection();
        if (nvUser == null) {
            Toast.makeText(this, getString(R.string.login_account), 0).show();
            return;
        }
        GroundStation groundStation = Navatics.getGroundStation();
        if (groundStation == null) {
            LoggerUtil.m6924a(this, getString(R.string.controller_not_connected));
            return;
        }
        if (!groundStation.isValid()) {
            Toast.makeText(this, getString(R.string.restart_connect_controller), 0).show();
            return;
        }
        if (groundStation.getState() == 0) {
            return;
        }
        if (groundStation.getState() == 1) {
            Toast.makeText(this, getString(R.string.logging_controller), 0).show();
            return;
        }
        if (!groundStation.isRemoteBinded()) {
            Intent intent = new Intent(this, (Class<?>) BindRemoteActivity.class);
            intent.putExtra("remote_id", groundStation.getRemoteId());
            startActivity(intent);
        } else if (!groundStation.isControllerAuthed()) {
            Toast.makeText(this, getString(R.string.controller_authentication_failed), 0).show();
        } else if (currentActiveConnection != null && currentActiveConnection.isAuthed()) {
            startActivity(new Intent(this, (Class<?>) PreviewActivityV2.class));
        } else {
            startActivity(new Intent(this, (Class<?>) SearchDeviceActivity.class));
        }
    }

    /* renamed from: g */
    private void m3535g() {
        if (this.f3604d) {
            IntentUtils.m5503a(this, 1);
        } else {
            IntentUtils.m5505b((Activity) this);
        }
    }

    @OnClick
    public void onClicked(View view) {
        NvUser nvUser = NvUserManager.getInstance().getUser();
        switch (view.getId()) {
            case R.id.btnConnect /* 2131296321 */:
                connectButtonAction(nvUser);
                return;
            case R.id.ivDiveLogIcon /* 2131296600 */:
                if (nvUser == null) {
                    Toast.makeText(this, getString(R.string.login_first), 0).show();
                    return;
                } else {
                    startActivity(new Intent(this, (Class<?>) DiveLogHomeActivity.class));
                    return;
                }
            case R.id.ivMediaLibraryIcon /* 2131296620 */:
                startActivity(new Intent(this, (Class<?>) MediaLibraryActivity.class));
                overridePendingTransition(0, 0);
                return;
            case R.id.ivSetting /* 2131296639 */:
                m3535g();
                return;
            case R.id.ivUsrImg /* 2131296646 */:
                if (nvUser == null) {
                    startActivity(new Intent(this, (Class<?>) LoginActivity.class));
                    return;
                } else {
                    IntentUtils.m5502a((Activity) this);
                    return;
                }
            default:
                return;
        }
    }
}