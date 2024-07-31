package com.navatics.app.activities;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.navatics.app.NvBaseActivity;
import com.navatics.app.R;
import com.navatics.app.framework.GroundStation;
import com.navatics.robot.transport.NvDeviceInfo;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.SPOta;
import com.senseplay.sdk.model.ota.OtaListener;
import com.senseplay.sdk.model.ota.VersionInfo;
import java.io.File;

/* loaded from: classes.dex */
public class HandShankActivity extends NvBaseActivity {

    /* renamed from: a */
    private GroundStation f3574a;

    /* renamed from: b */
    private NvDeviceInfo f3575b;
    @BindView
    Button btnUpdate;
    @BindView
    SeekBar seekBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_hand_shank);
        ButterKnife.m12805a(this);
        m9407a();
    }

    /* renamed from: a */
    private void m9407a() {
        this.btnUpdate.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.HandShankActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HandShankActivity.this.m9405b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.NvBaseActivity
    public void onGroundStationConnected(GroundStation groundStation) {
        super.onGroundStationConnected(groundStation);
        this.f3574a = groundStation;
        this.f3575b = this.f3574a.m8104g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m9405b() {
        Log.i("info1", "showUpdate: ");
        Log.i("info1", "version: " + this.f3575b.getFirmwareVersionStr());
        Log.i("info1", "sn: " + this.f3575b.getSerialNumber());
        SPOta.getInstance().checkVersion("C1ROM", this.f3575b.getFirmwareVersionStr(), this.f3575b.getSerialNumber(), "en", "cn", new MCallBack<VersionInfo>() { // from class: com.navatics.app.activities.HandShankActivity.2
            @Override // com.senseplay.mframe.client.MCallBack
            /* renamed from: a */
            public void onResult(VersionInfo versionInfo) {
                versionInfo.getCode();
                if (versionInfo == null) {
                    Log.i("info1", "onResult:null ");
                } else if (versionInfo.getFiles() == null) {
                    Log.i("info1", "onResult:fill null ");
                }
                Log.i("info1", "onResult: ");
                String str = Environment.getExternalStorageDirectory() + "/C1-8B01-00-01.01.022.bin";
                Log.i("info1", "onResult: " + str);
                if (!new File(str).exists()) {
                    Log.i("info1", "onResult: no exists");
                } else {
                    SPOta.getInstance().rcOTA(str, new OtaListener() { // from class: com.navatics.app.activities.HandShankActivity.2.1
                        @Override // com.senseplay.sdk.model.ota.OtaListener
                        public void onProcessing(int i) {
                            HandShankActivity.this.seekBar.setProgress(i);
                            Log.i("info1", "onProcessing: " + i);
                        }

                        @Override // com.senseplay.sdk.model.ota.OtaListener
                        public void onResult(boolean z) {
                            if (z) {
                                Log.i("info1", "onResult: success   ");
                                Toast.makeText(HandShankActivity.this, "success", 0).show();
                                return;
                            }
                            Log.i("info1", "onResult: f    ");
                        }
                    });
                }
            }
        });
    }
}
