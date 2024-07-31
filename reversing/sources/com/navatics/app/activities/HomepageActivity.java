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
import android.support.p008v4.view.InputDeviceCompat;
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
import com.navatics.app.framework.AbstractC2362s;
import com.navatics.app.framework.C2326g;
import com.navatics.app.framework.C2353p;
import com.navatics.app.framework.C2385y;
import com.navatics.app.framework.firmware.C2302f;
import com.navatics.app.framework.firmware.C2303g;
import com.navatics.app.framework.p055g.C2330d;
import com.navatics.app.framework.user.C2374a;
import com.navatics.app.framework.user.NvUser;
import com.navatics.app.framework.user.NvUserManager;
import com.navatics.app.utils.C2468h;
import com.navatics.app.widget.WebViewWrapper;
import com.navatics.app.widget.badge.BadgeView;
import com.navatics.robot.transport.NvDeviceInfo;
import com.navatics.robot.utils.p065a.C2883i;
import com.navatics.xlog.WLog;
import io.reactivex.disposables.InterfaceC3877b;
import io.reactivex.p093a.p095b.C3857a;
import io.reactivex.p096b.InterfaceC3868e;
import io.reactivex.p099e.C3880a;
import java.io.IOException;
import org.apache.log4j.Logger;

/* loaded from: classes.dex */
public class HomepageActivity extends LocationActivity {

    /* renamed from: b */
    private static final Logger f3580b = Logger.m1561a(HomepageActivity.class);

    /* renamed from: a */
    InterfaceC3877b f3581a;
    @BindView
    Button btnConnect;

    /* renamed from: c */
    private BadgeView f3582c;

    /* renamed from: d */
    private boolean f3583d = false;
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
    public void onGroundStationDisconnected(C2326g c2326g) {
        m9385e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.NvBaseActivity
    public void onGroundStationAuthenticationSuccess(C2326g c2326g) {
        hideAnyDialog();
        C2303g.m8213a(this).m8200a(c2326g.m8105g()).m3089a(C2330d.m8073a()).m3104a(new InterfaceC3868e<C2302f>() { // from class: com.navatics.app.activities.HomepageActivity.1
            @Override // io.reactivex.p096b.InterfaceC3868e
            /* renamed from: a */
            public void mo9497a(C2302f c2302f) throws Exception {
                if (c2302f.m8217f() == 0) {
                    HomepageActivity.this.m9384f();
                }
            }
        }, new InterfaceC3868e<Throwable>() { // from class: com.navatics.app.activities.HomepageActivity.2
            @Override // io.reactivex.p096b.InterfaceC3868e
            /* renamed from: a */
            public void mo9497a(Throwable th) throws Exception {
            }
        });
    }

    @Override // com.navatics.app.NvBaseActivity
    protected void onDeviceConnecting(C2326g c2326g, NvDeviceInfo nvDeviceInfo) {
        this.btnConnect.setText(getString(R.string.connecting));
    }

    @Override // com.navatics.app.NvBaseActivity
    public void onDeviceAuthenticationSuccess(AbstractC2362s abstractC2362s) {
        m9385e();
        if (abstractC2362s != null && abstractC2362s.m7876j() && abstractC2362s.m7876j()) {
            try {
                C2303g.m8213a(this).m8201a((C2385y) abstractC2362s.m7899a(InputDeviceCompat.SOURCE_TOUCHSCREEN)).m3089a(C2330d.m8073a()).m3104a(new InterfaceC3868e<C2302f>() { // from class: com.navatics.app.activities.HomepageActivity.3
                    @Override // io.reactivex.p096b.InterfaceC3868e
                    /* renamed from: a */
                    public void mo9497a(C2302f c2302f) throws Exception {
                        if (c2302f.m8217f() != 0 || c2302f.m8224c() == null) {
                            return;
                        }
                        HomepageActivity.this.m9384f();
                    }
                }, new InterfaceC3868e<Throwable>() { // from class: com.navatics.app.activities.HomepageActivity.4
                    @Override // io.reactivex.p096b.InterfaceC3868e
                    /* renamed from: a */
                    public void mo9497a(Throwable th) throws Exception {
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.activities.LocationActivity, com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 23) {
            getWindow().getDecorView().setSystemUiVisibility(8192);
            getWindow().setStatusBarColor(-1);
        }
        setContentView(R.layout.activity_homepage);
        ButterKnife.m12776a(this);
        this.ivRobotImg.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$HomepageActivity$DH1IlLsifarTx2pTV6tAIOYlYNQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2353p.m7930j();
            }
        });
        this.tvConnSignal.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$HomepageActivity$xBRccX9--ppyivaQ-unqJiTJ0Xk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomepageActivity.this.m9390b(view);
            }
        });
        this.ivTitleIcon.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$HomepageActivity$7W4YRwC3AtLrMTrsQoX6gNmq3-0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomepageActivity.this.m9394a(view);
            }
        });
        m9388c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m9390b(View view) {
        f3580b.mo1508a((Object) "tvConnSignal onclick");
        startActivity(new Intent(this, SearchDeviceActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m9394a(View view) {
        Toast.makeText(this, "0.4.0", 1).show();
    }

    @Override // com.navatics.app.NvBaseActivity
    protected NvBaseActivity.C1917a onCreateConfig() {
        return new NvBaseActivity.C1917a.C1918a().m9544a(true).m9543b();
    }

    /* renamed from: c */
    private void m9388c() {
        if (PreferenceManager.getDefaultSharedPreferences(this).getBoolean("key_agree_privacy_policy", false)) {
            return;
        }
        m9386d();
    }

    /* renamed from: d */
    private void m9386d() {
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
        webViewWrapper.m7067a("https://www.navatics.com/privacy_policy.html");
        negativeButton.show();
    }

    /* renamed from: e */
    private void m9385e() {
        AbstractC2362s m8099m;
        C2326g m7932h = C2353p.m7932h();
        if (m7932h != null && m7932h.m8110e() && m7932h.m8121c() && (m8099m = m7932h.m8099m()) != null && m8099m.m7876j()) {
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
    @Override // com.navatics.app.activities.LocationActivity, com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        WLog.appenderClose();
    }

    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setRequestedOrientation(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.f3581a = NvUserManager.m7829b().m7792i().m3072b(C3880a.m3214b()).m3088a(C3857a.m3247a()).m3104a(new InterfaceC3868e() { // from class: com.navatics.app.activities.-$$Lambda$HomepageActivity$9K0QVetXMEzmS-4_RhCfiM6B4Fg
            @Override // io.reactivex.p096b.InterfaceC3868e
            /* renamed from: accept */
            public final void mo9497a(Object obj) {
                HomepageActivity.this.m9391a((C2374a) obj);
            }
        }, C$$Lambda$e27Kr4VJxN1zC_AGmQwWE7CADQ.INSTANCE);
        m9385e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        InterfaceC3877b interfaceC3877b = this.f3581a;
        if (interfaceC3877b == null || interfaceC3877b.isDisposed()) {
            return;
        }
        this.f3581a.dispose();
        this.f3581a = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9391a(C2374a c2374a) {
        Logger logger = f3580b;
        logger.mo1508a((Object) ("handleUserEvent, event : " + c2374a.m7778b()));
        switch (c2374a.m7778b()) {
            case 0:
            default:
                return;
            case 1:
            case 2:
                m9392a(c2374a.m7779a());
                C2353p.m7930j();
                return;
        }
    }

    /* renamed from: a */
    private void m9392a(NvUser nvUser) {
        Logger logger = f3580b;
        logger.mo1508a((Object) ("updateUiByUser, " + nvUser));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m9384f() {
        this.f3583d = true;
        BadgeView badgeView = this.f3582c;
        if (badgeView == null) {
            this.f3582c = new BadgeView(this);
            this.f3582c.m7018a(this.ivSetting);
            this.f3582c.m7017a("");
            this.f3582c.m7012b(false);
            this.f3582c.m7024a(0.0f, 5.0f, true);
            return;
        }
        badgeView.setVisibility(0);
    }

    /* renamed from: b */
    private void connectButtonAction(NvUser nvUser) {
        AbstractC2362s m7931i = C2353p.m7931i();
        if (nvUser == null) {
            Toast.makeText(this, getString(R.string.login_account), 0).show();
            return;
        }
        C2326g m7932h = C2353p.m7932h();
        if (m7932h == null) {
            C2883i.m5927a(this, getString(R.string.controller_not_connected));
        } else if (!m7932h.m8110e()) {
            Toast.makeText(this, getString(R.string.restart_connect_controller), 0).show();
        } else if (m7932h.m8103i() == 0) {
        } else {
            if (m7932h.m8103i() == 1) {
                Toast.makeText(this, getString(R.string.logging_controller), 0).show();
            } else if (!m7932h.m8114d()) {
                Intent intent = new Intent(this, BindRemoteActivity.class);
                intent.putExtra("remote_id", m7932h.m8130b());
                startActivity(intent);
            } else if (!m7932h.m8121c()) {
                Toast.makeText(this, getString(R.string.controller_authentication_failed), 0).show();
            } else if (m7931i != null && m7931i.m7876j()) {
                startActivity(new Intent(this, PreviewActivityV2.class));
            } else {
                startActivity(new Intent(this, SearchDeviceActivity.class));
            }
        }
    }

    /* renamed from: g */
    private void m9383g() {
        if (this.f3583d) {
            C2468h.m7389a(this, 1);
        } else {
            C2468h.m7387b((Activity) this);
        }
    }

    @OnClick
    public void onClicked(View view) {
        NvUser nvUser = NvUserManager.m7829b().getUser();
        switch (view.getId()) {
            case R.id.btnConnect /* 2131296321 */:
                connectButtonAction(nvUser);
                return;
            case R.id.ivDiveLogIcon /* 2131296600 */:
                if (nvUser == null) {
                    Toast.makeText(this, getString(R.string.login_first), 0).show();
                    return;
                } else {
                    startActivity(new Intent(this, DiveLogHomeActivity.class));
                    return;
                }
            case R.id.ivMediaLibraryIcon /* 2131296620 */:
                startActivity(new Intent(this, MediaLibraryActivity.class));
                overridePendingTransition(0, 0);
                return;
            case R.id.ivSetting /* 2131296639 */:
                m9383g();
                return;
            case R.id.ivUsrImg /* 2131296646 */:
                if (nvUser == null) {
                    startActivity(new Intent(this, LoginActivity.class));
                    return;
                } else {
                    C2468h.m7390a((Activity) this);
                    return;
                }
            default:
                return;
        }
    }
}
