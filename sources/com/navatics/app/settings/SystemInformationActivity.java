package com.navatics.app.settings;

import android.os.Bundle;
import android.support.p008v4.app.FragmentTransaction;
import android.support.p008v4.view.InputDeviceCompat;
import android.text.Html;
import com.navatics.app.framework.GroundStation;
import com.navatics.app.framework.Navatics;
import com.navatics.app.framework.NvBuoy;
import com.navatics.app.framework.NvConnection;
import com.navatics.app.framework.NvRobot;
import com.navatics.app.framework.RobotVersionInfo;
import com.navatics.app.framework.annotation.EventHandler;
import com.navatics.robot.transport.NvDeviceInfo;
import com.navatics.robot.transport.p063b.AndroidMainThreadExecutor;
import com.navatics.robot.transport.p063b.NvExceptionHandler;
import com.navatics.robot.transport.p063b.NvObserver;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class SystemInformationActivity extends SettingsActivity {

    /* renamed from: g */
    private static final C3044k f5080g = C3044k.m1564a(SystemInformationActivity.class);

    /* renamed from: d */
    SimpleSetting f5081d;

    /* renamed from: e */
    SimpleSetting f5082e;

    /* renamed from: f */
    SimpleSetting f5083f;

    /* renamed from: lambda$CkRY2V9M1-cYc7rCJ9RJLFzUDFg */
    public static /* synthetic */ void m13091lambda$CkRY2V9M1cYc7rCJ9RJLFzUDFg(SystemInformationActivity systemInformationActivity, Throwable th) {
        systemInformationActivity.m7451a(th);
    }

    public static /* synthetic */ void lambda$NKd7yIqFZiuJE1ZVqyBqNU8pCtc(SystemInformationActivity systemInformationActivity, RobotVersionInfo robotVersionInfo) {
        systemInformationActivity.m7452a(robotVersionInfo);
    }

    @Override // com.navatics.app.settings.SettingsActivity, com.navatics.app.activities.StatusBarLightActivity, com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5083f = new SimpleSetting(this, "Controller FirmwareVer:");
        this.f5081d = new SimpleSetting(this, "Buoy FirmwareVer:");
        this.f5082e = new SimpleSetting(this, "Robot FirmwareVer:");
        this.f5083f.m7419h();
        this.f5081d.m7419h();
        this.f5082e.m7419h();
        m7454a(this.f5083f);
        m7454a(this.f5081d);
        m7454a(this.f5082e);
        m7453b();
    }

    @Override // com.navatics.app.settings.SettingsActivity, com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        Navatics.m7947b().m8577a(this);
    }

    @Override // com.navatics.app.settings.SettingsActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        Navatics.m7947b().m8573b(this);
    }

    @Override // com.navatics.app.NvBaseActivity
    @EventHandler(m8585b = 65547, m8584c = 1)
    public void onGroundStationConnected(GroundStation groundStation) {
        f5080g.mo1511a((Object) "onGroundStationConnected");
        NvDeviceInfo m8104g = groundStation.m8104g();
        SimpleSetting simpleSetting = this.f5083f;
        simpleSetting.m7424a("Controller FirmwareVer:" + m8104g.getFirmwareVersion());
    }

    @EventHandler(m8585b = 65543)
    void onConnectionReady(NvConnection nvConnection) {
        f5080g.mo1511a((Object) "onConnectionReady");
        NvRobot nvRobot = (NvRobot) nvConnection.m7898a(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        NvBuoy nvBuoy = (NvBuoy) nvConnection.m7898a(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        if (nvRobot != null) {
            nvRobot.m7678p().mo6311a(AndroidMainThreadExecutor.m6303b()).mo6312a(new NvObserver() { // from class: com.navatics.app.settings.-$$Lambda$SystemInformationActivity$NKd7yIqFZiuJE1ZVqyBqNU8pCtc
                @Override // com.navatics.robot.transport.p063b.NvObserver
                public final void onNext(Object obj) {
                    SystemInformationActivity.lambda$NKd7yIqFZiuJE1ZVqyBqNU8pCtc(SystemInformationActivity.this, (RobotVersionInfo) obj);
                }
            }, new NvExceptionHandler() { // from class: com.navatics.app.settings.-$$Lambda$SystemInformationActivity$CkRY2V9M1-cYc7rCJ9RJLFzUDFg
                @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                public final void onError(Throwable th) {
                    SystemInformationActivity.m13091lambda$CkRY2V9M1cYc7rCJ9RJLFzUDFg(SystemInformationActivity.this, th);
                }
            });
        }
        if (nvBuoy != null) {
            NvDeviceInfo d = nvBuoy.m7856d();
            d.getFirmwareVersion();
            SimpleSetting simpleSetting = this.f5081d;
            simpleSetting.m7424a(((Object) this.f5081d.m7420d()) + d.getFirmwareVersion());
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m7452a(RobotVersionInfo robotVersionInfo) throws Exception {
        SimpleSetting simpleSetting = this.f5082e;
        simpleSetting.m7424a("Robot FirmwareVer:" + robotVersionInfo);
    }

    /* renamed from: a */
    public /* synthetic */ void m7451a(Throwable th) {
        SimpleSetting simpleSetting = this.f5082e;
        simpleSetting.m7424a(Html.fromHtml(((Object) this.f5082e.m7420d()) + "<font color='#ff0000'>Error getting ver for robot</font><br>").toString());
    }
}
