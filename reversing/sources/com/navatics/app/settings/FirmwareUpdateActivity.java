package com.navatics.app.settings;

import android.support.p008v4.view.InputDeviceCompat;
import android.support.p011v7.widget.LinearLayoutManager;
import android.support.p011v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import butterknife.BindView;
import com.navatics.app.R;
import com.navatics.app.activities.base.BaseMvpActivity;
import com.navatics.app.adapters.FirmwareUpdateAdapter;
import com.navatics.app.framework.GroundStation;
import com.navatics.app.framework.NvConnection;
import com.navatics.app.framework.NvRobot;
import com.navatics.app.framework.firmware.FirmwareUpdateInfo;
import com.navatics.app.p048a.FirmwareUpdatePresenter;
import com.navatics.app.p048a.IFirmwareUpdateView;
import java.util.List;

/* loaded from: classes.dex */
public class FirmwareUpdateActivity extends BaseMvpActivity<FirmwareUpdatePresenter> implements IFirmwareUpdateView {

    /* renamed from: b */
    private FirmwareUpdateAdapter f5049b;
    @BindView
    ImageView ivBack;
    @BindView
    RecyclerView recyclerView;

    @Override // com.navatics.app.activities.base.BaseMvpActivity
    /* renamed from: c */
    protected int mo7471c() {
        return R.layout.activity_firmware_update;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.activities.base.BaseMvpActivity
    /* renamed from: d */
    public FirmwareUpdatePresenter mo7476a() {
        return new FirmwareUpdatePresenter(this);
    }

    @Override // com.navatics.app.activities.base.BaseMvpActivity
    /* renamed from: b */
    protected void mo7472b() {
        this.f5049b = new FirmwareUpdateAdapter(this);
        this.f5049b.m8833a(new FirmwareUpdateAdapter.InterfaceC1709a() { // from class: com.navatics.app.settings.FirmwareUpdateActivity.1
            @Override // com.navatics.app.adapters.FirmwareUpdateAdapter.InterfaceC1709a
            /* renamed from: a */
            public void mo7469a(FirmwareUpdateInfo firmwareUpdateInfo) {
                ((FirmwareUpdatePresenter) FirmwareUpdateActivity.this.f3974a).m9515a(firmwareUpdateInfo);
            }
        });
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView.setAdapter(this.f5049b);
        ((FirmwareUpdatePresenter) this.f3974a).m9507h();
        this.ivBack.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.settings.FirmwareUpdateActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FirmwareUpdateActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.NvBaseActivity
    public void onGroundStationAuthenticationSuccess(GroundStation groundStation) {
        super.onGroundStationAuthenticationSuccess(groundStation);
        if (groundStation == null || !groundStation.m8120c()) {
            return;
        }
        ((FirmwareUpdatePresenter) this.f3974a).m9513a(groundStation.m8104g());
        NvConnection m8098m = groundStation.m8098m();
        if (m8098m != null && m8098m.m7875j() && m8098m.m7875j()) {
            ((FirmwareUpdatePresenter) this.f3974a).m9514a((NvRobot) m8098m.m7898a(InputDeviceCompat.SOURCE_TOUCHSCREEN));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.NvBaseActivity
    public void onGroundStationConnected(GroundStation groundStation) {
        super.onGroundStationConnected(groundStation);
    }

    @Override // com.navatics.app.p048a.IFirmwareUpdateView
    /* renamed from: a */
    public void mo7475a(FirmwareUpdateInfo firmwareUpdateInfo) {
        this.f5049b.m8831a(firmwareUpdateInfo);
    }

    @Override // com.navatics.app.p048a.IFirmwareUpdateView
    /* renamed from: a */
    public void mo7473a(List<FirmwareUpdateInfo> list) {
        this.f5049b.m8830a(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.activities.base.BaseMvpActivity, com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
