package com.navatics.app.settings;

import android.graphics.Color;
import android.os.Bundle;
import com.navatics.app.NvBaseActivity;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class Settings extends SettingsActivity {

    /* renamed from: d */
    private int f5074d = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.settings.SettingsActivity, com.navatics.app.activities.StatusBarLightActivity, com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m7454a(new ConnectionStateSetting(this));
        m7454a(new UnbindSetting(this, getString(R.string.unbind_devices)));
        m7454a(new ControllerModeSetting(this, getString(R.string.controller_mode)));
        m7454a(new DiveLogSyncSetting(this, getString(R.string.auto_sync_div_log)));
        m7454a(new AllowUpdateUsingCellularNetworkSetting(this, getString(R.string.allow_softeware_update)));
        m7454a(new PreviewSetting(this, getString(R.string.use_software_decoder)));
        m7454a(new DimensionSetting(this, getString(R.string.dimension_setting)));
        FirmwareSetting firmwareSetting = new FirmwareSetting(this, getString(R.string.firmware_update_setting));
        m7454a(firmwareSetting);
        m7454a(new SystemInformationPanel(this, getString(R.string.system_info)));
        if (getIntent().hasExtra("TYPE")) {
            this.f5074d = getIntent().getIntExtra("TYPE", 0);
        }
        m7456c();
        m7453b();
        if (this.f5074d == 1) {
            firmwareSetting.m7423a(true);
        }
    }

    @Override // com.navatics.app.NvBaseActivity
    protected NvBaseActivity.C1517a onCreateConfig() {
        return new NvBaseActivity.C1517a.C1518a().m9565a(true).m9564b();
    }

    /* renamed from: c */
    private void m7456c() {
        SimpleSetting simpleSetting = new SimpleSetting(this, "Version 0.4.0");
        simpleSetting.m7419h();
        simpleSetting.m7425a(Color.parseColor("#F5F5F5"));
        simpleSetting.m7418i();
        m7454a(simpleSetting);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_enter_from_left, R.anim.slide_exit_to_right);
    }
}
