package com.navatics.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.navatics.app.R;
import com.navatics.app.framework.GroundStation;
import com.navatics.app.framework.Navatics;
import com.navatics.app.utils.StringUtils;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class BindRemoteActivity extends StatusBarLightActivity {

    /* renamed from: a */
    private static final C3044k f3493a = C3044k.m1564a(ActivationActivity.class);

    /* renamed from: b */
    private long f3494b;
    @BindView
    Button btnInputCode;
    @BindView
    Button btnScanQRCode;
    @BindView
    ImageView ivClose;
    @BindView
    TextView tvSerialNum;

    public static /* synthetic */ void lambda$4HPScIAO4vvR9OX2oKsusuUtwQc(BindRemoteActivity bindRemoteActivity, View view) {
        bindRemoteActivity.m9483a(view);
    }

    public static /* synthetic */ void lambda$OoaxKgkalg3h0XRDvd1QMrWOu20(BindRemoteActivity bindRemoteActivity, View view) {
        bindRemoteActivity.m9481c(view);
    }

    public static /* synthetic */ void lambda$Vafh98KJ4jiHDro_GYGGdM4mvWA(BindRemoteActivity bindRemoteActivity, View view) {
        bindRemoteActivity.m9482b(view);
    }

    @Override // com.navatics.app.activities.StatusBarLightActivity, com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bind_remote_activity);
        ButterKnife.m12805a(this);
        this.btnScanQRCode.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$BindRemoteActivity$OoaxKgkalg3h0XRDvd1QMrWOu20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BindRemoteActivity.lambda$OoaxKgkalg3h0XRDvd1QMrWOu20(BindRemoteActivity.this, view);
            }
        });
        this.btnInputCode.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$BindRemoteActivity$Vafh98KJ4jiHDro_GYGGdM4mvWA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BindRemoteActivity.lambda$Vafh98KJ4jiHDro_GYGGdM4mvWA(BindRemoteActivity.this, view);
            }
        });
        this.ivClose.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$BindRemoteActivity$4HPScIAO4vvR9OX2oKsusuUtwQc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BindRemoteActivity.lambda$4HPScIAO4vvR9OX2oKsusuUtwQc(BindRemoteActivity.this, view);
            }
        });
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            f3493a.mo1504b((Object) "data is null");
            finish();
            return;
        }
        this.f3494b = extras.getLong("remote_id", -1L);
        if (this.f3494b < 0) {
            C3044k c3044k = f3493a;
            c3044k.mo1504b((Object) ("invalid remote id " + this.f3494b));
            finish();
        }
        GroundStation m7958a = Navatics.m7958a(this.f3494b);
        if (m7958a != null) {
            this.tvSerialNum.setText(m7958a.m8104g().getSerialNumber());
        }
    }

    /* renamed from: c */
    public /* synthetic */ void m9481c(View view) {
        startActivityForResult(new Intent(this, ScanQRCodeActivity.class), 1);
    }

    /* renamed from: b */
    public /* synthetic */ void m9482b(View view) {
        startActivityForResult(new Intent(this, ActivationCodeInputActivity.class), 2);
    }

    /* renamed from: a */
    public /* synthetic */ void m9483a(View view) {
        finish();
    }

    @Override // android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (intent.getExtras() == null) {
                Toast.makeText(this, "Internal Error", 0).show();
                return;
            }
            String string = intent.getExtras().getString("qrcode");
            if (StringUtils.m7354a(string)) {
                Toast.makeText(this, "Invalid activation code Code", 0).show();
                return;
            }
            Intent intent2 = new Intent(this, ActivationActivity.class);
            intent2.putExtra("qrcode", string);
            intent2.putExtra("remote_id", this.f3494b);
            intent2.putExtra("activation_type", 1);
            startActivity(intent2);
        } else {
            Toast.makeText(this, "Get activation code failed", 0).show();
        }
        super.onActivityResult(i, i2, intent);
    }
}
