package com.navatics.app.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.navatics.app.R;
import com.navatics.app.activities.OperationalRobotActivity;
import com.navatics.app.framework.GroundStation;
import com.navatics.app.settings.ControllerModeDialogFragment;
import com.navatics.robot.transport.KeyMapProvider;
import com.navatics.robot.transport.NvError;
import com.senseplay.sdk.model.keymap.KeyMapParse;
import io.reactivex.InterfaceC2900o;
import io.reactivex.disposables.Disposable;

/* loaded from: classes.dex */
public class ControllerModeActivity extends OperationalRobotActivity implements View.OnClickListener {

    /* renamed from: b */
    private Unbinder f5023b;

    /* renamed from: d */
    private SharedPreferences f5025d;

    /* renamed from: e */
    private SharedPreferences.Editor f5026e;

    /* renamed from: f */
    private ControllerModeDialogFragment f5027f;

    /* renamed from: g */
    private GroundStation f5028g;
    @BindView
    ImageView ivBack;
    @BindView
    ImageView ivSelect1;
    @BindView
    ImageView ivSelect2;
    @BindView
    ImageView ivSelect3;
    @BindView
    TextView ivTitle;

    /* renamed from: j */
    private KeyMapProvider f5031j;

    /* renamed from: k */
    private Disposable f5032k;
    @BindView
    RelativeLayout rlMode1;
    @BindView
    RelativeLayout rlMode2;
    @BindView
    RelativeLayout rlMode3;
    @BindView
    TextView tvMode1More;
    @BindView
    TextView tvMode2More;
    @BindView
    TextView tvMode3More;

    /* renamed from: c */
    private int f5024c = 3;

    /* renamed from: h */
    private boolean f5029h = false;

    /* renamed from: i */
    private String f5030i = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.activities.LocationActivity, com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_mode_setting);
        this.f5023b = ButterKnife.m12805a(this);
        m7491f();
        m7490g();
    }

    /* renamed from: f */
    private void m7491f() {
        this.f5025d = getPreferences(0);
        this.f5026e = this.f5025d.edit();
        this.f5024c = this.f5025d.getInt("mode_index", 3);
        m7487n(this.f5024c);
        this.f5027f = new ControllerModeDialogFragment();
        this.f5027f.m7482a(new ControllerModeDialogFragment.InterfaceC1896a() { // from class: com.navatics.app.settings.ControllerModeActivity.1
            @Override // com.navatics.app.settings.ControllerModeDialogFragment.InterfaceC1896a
            /* renamed from: a */
            public void mo7478a(int i) {
                ControllerModeActivity.this.m7489l(i);
            }
        });
    }

    /* renamed from: g */
    private void m7490g() {
        this.ivBack.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.settings.ControllerModeActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ControllerModeActivity.this.finish();
            }
        });
        this.rlMode1.setOnClickListener(this);
        this.rlMode2.setOnClickListener(this);
        this.rlMode3.setOnClickListener(this);
        this.tvMode1More.setOnClickListener(this);
        this.tvMode2More.setOnClickListener(this);
        this.tvMode3More.setOnClickListener(this);
    }

    /* renamed from: m */
    private void m7488m(int i) {
        this.f5027f.m7483a(i, this.f5024c, this.f5029h);
        this.f5027f.show(getSupportFragmentManager(), "controller_mode");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.NvBaseActivity
    public void onGroundStationDisconnected(GroundStation groundStation) {
        super.onGroundStationDisconnected(groundStation);
        this.f5029h = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.NvBaseActivity
    public void onGroundStationConnected(GroundStation groundStation) {
        super.onGroundStationConnected(groundStation);
        if (this.f5028g == null) {
            this.f5028g = groundStation;
        }
        this.f5029h = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.NvBaseActivity
    public void onGroundStationAuthenticationSuccess(GroundStation groundStation) {
        super.onGroundStationAuthenticationSuccess(groundStation);
        this.f5029h = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.NvBaseActivity
    public void onGroundStationAuthenticationFailed(GroundStation groundStation, NvError nvError) {
        super.onGroundStationAuthenticationFailed(groundStation, nvError);
        this.f5029h = false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.rl_mode1 /* 2131296773 */:
                m7489l(1);
                return;
            case R.id.rl_mode2 /* 2131296774 */:
                m7489l(2);
                return;
            case R.id.rl_mode3 /* 2131296775 */:
                m7489l(3);
                return;
            default:
                switch (id) {
                    case R.id.tv_mode1_more /* 2131296999 */:
                        m7488m(1);
                        return;
                    case R.id.tv_mode2_more /* 2131297000 */:
                        m7488m(2);
                        return;
                    case R.id.tv_mode3_more /* 2131297001 */:
                        m7488m(3);
                        return;
                    default:
                        return;
                }
        }
    }

    /* renamed from: l */
    public void m7489l(final int i) {
        if (!this.f5029h || this.f5028g == null) {
            Toast.makeText(this, getString(R.string.controller_not_connected), 0).show();
            return;
        }
        m7487n(i);
        if (this.f5031j == null) {
            this.f5031j = this.f5028g.m8142a(this);
        }
        if (i == 1) {
            this.f5030i = this.f5031j.mo6220a("mode1", "MARINE", KeyMapParse.style_usa);
        } else if (i == 2) {
            this.f5030i = this.f5031j.mo6220a("mode2", "MARINE", KeyMapParse.style_usa);
        } else if (i == 3) {
            this.f5030i = this.f5031j.mo6220a("mode3", "MARINE", KeyMapParse.style_usa);
        }
        if (i != this.f5024c) {
            this.f5031j.mo6221a(this.f5030i).subscribe(new InterfaceC2900o<Boolean>() { // from class: com.navatics.app.settings.ControllerModeActivity.3
                @Override // io.reactivex.InterfaceC2900o
                public void onError(Throwable th) {
                }

                @Override // io.reactivex.InterfaceC2900o
                public void onSubscribe(Disposable disposable) {
                    ControllerModeActivity.this.f5032k = disposable;
                }

                @Override // io.reactivex.InterfaceC2900o
                /* renamed from: a */
                public void onNext(Boolean bool) {
                    if (bool.booleanValue()) {
                        ControllerModeActivity.this.f5026e.putInt("mode_index", i);
                        ControllerModeActivity.this.f5026e.commit();
                        ControllerModeActivity.this.f5024c = i;
                        return;
                    }
                    ControllerModeActivity controllerModeActivity = ControllerModeActivity.this;
                    controllerModeActivity.m7487n(controllerModeActivity.f5024c);
                }

                @Override // io.reactivex.InterfaceC2900o
                public void onComplete() {
                    if (ControllerModeActivity.this.f5032k != null) {
                        ControllerModeActivity.this.f5032k.dispose();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m7487n(int i) {
        for (int i2 = 1; i2 <= 3; i2++) {
            if (i == i2) {
                m7498a(i2, true);
            } else {
                m7498a(i2, false);
            }
        }
    }

    /* renamed from: a */
    private void m7498a(int i, boolean z) {
        if (z) {
            if (i == 1) {
                this.ivSelect1.setImageResource(R.drawable.settings_connect_yes);
            } else if (i == 2) {
                this.ivSelect2.setImageResource(R.drawable.settings_connect_yes);
            } else if (i == 3) {
                this.ivSelect3.setImageResource(R.drawable.settings_connect_yes);
            }
        } else if (i == 1) {
            this.ivSelect1.setImageResource(R.drawable.keymap_o);
        } else if (i == 2) {
            this.ivSelect2.setImageResource(R.drawable.keymap_o);
        } else if (i == 3) {
            this.ivSelect3.setImageResource(R.drawable.keymap_o);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.activities.LocationActivity, com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f5023b.mo7436a();
    }
}
