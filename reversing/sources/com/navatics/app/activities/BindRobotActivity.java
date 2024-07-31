package com.navatics.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.navatics.app.R;
import com.navatics.app.framework.GroundStation;
import com.navatics.app.framework.Navatics;
import com.navatics.app.framework.NvConnection;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class BindRobotActivity extends StatusBarLightActivity {

    /* renamed from: a */
    private static final C3044k f3496a = C3044k.m1564a(ActivationActivity.class);

    /* renamed from: b */
    private long f3497b;
    @BindView
    Button btnInputCode;
    @BindView
    Button btnScanQRCode;

    /* renamed from: c */
    private long f3498c;
    @BindView
    TextView tvSN;

    public static /* synthetic */ void lambda$UgVcVdZ5rFaySCOojNFUNUs3Nzo(BindRobotActivity bindRobotActivity, View view) {
        bindRobotActivity.m9480a(view);
    }

    /* renamed from: lambda$voUp9Gn6YgZH-rpfazTUy67nrpA */
    public static /* synthetic */ void m12968lambda$voUp9Gn6YgZHrpfazTUy67nrpA(BindRobotActivity bindRobotActivity, View view) {
        bindRobotActivity.m9479b(view);
    }

    @Override // com.navatics.app.activities.StatusBarLightActivity, com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bind_robot_activity);
        ButterKnife.m12805a(this);
        this.btnScanQRCode.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$BindRobotActivity$voUp9Gn6YgZH-rpfazTUy67nrpA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BindRobotActivity.m12968lambda$voUp9Gn6YgZHrpfazTUy67nrpA(BindRobotActivity.this, view);
            }
        });
        this.btnInputCode.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$BindRobotActivity$UgVcVdZ5rFaySCOojNFUNUs3Nzo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BindRobotActivity.lambda$UgVcVdZ5rFaySCOojNFUNUs3Nzo(BindRobotActivity.this, view);
            }
        });
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            f3496a.mo1504b((Object) "data is null");
            finish();
            return;
        }
        this.f3497b = extras.getLong("remote_id", -1L);
        if (this.f3497b < 0) {
            C3044k c3044k = f3496a;
            c3044k.mo1504b((Object) ("invalid remote id " + this.f3497b));
            finish();
        }
        this.f3498c = extras.getLong("conn_id", -1L);
        if (this.f3498c < 0) {
            C3044k c3044k2 = f3496a;
            c3044k2.mo1504b((Object) ("invalid conn id " + this.f3498c));
            finish();
        }
        GroundStation m7958a = Navatics.m7958a(this.f3497b);
        if (m7958a == null) {
            finish();
            return;
        }
        NvConnection m8128b = m7958a.m8128b(this.f3498c);
        if (m8128b == null) {
            finish();
        } else {
            this.tvSN.setText(m8128b.m7876i().getSerialNumber());
        }
    }

    /* renamed from: b */
    public /* synthetic */ void m9479b(View view) {
        startActivityForResult(new Intent(this, ScanQRCodeActivity.class), 1);
    }

    /* renamed from: a */
    public /* synthetic */ void m9480a(View view) {
        startActivityForResult(new Intent(this, ActivationCodeInputActivity.class), 2);
    }

    @Override // android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (intent.getExtras() == null) {
                Toast.makeText(this, "Internal Error", 0).show();
                return;
            }
            String string = intent.getExtras().getString("qrcode");
            Intent intent2 = new Intent(this, ActivationActivity.class);
            intent2.putExtra("qrcode", string);
            intent2.putExtra("remote_id", this.f3497b);
            intent2.putExtra("conn_id", this.f3498c);
            intent2.putExtra("activation_type", 2);
            startActivity(intent2);
            finish();
        } else {
            Toast.makeText(this, "Recognize qr code failed", 0).show();
        }
        super.onActivityResult(i, i2, intent);
    }
}
