package com.navatics.app.settings;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.navatics.app.R;
import com.navatics.app.framework.AbstractConnectionHandler;
import com.navatics.app.framework.AbstractGroundStationHandler;
import com.navatics.app.framework.AbstractRootHandler;
import com.navatics.app.framework.GroundStation;
import com.navatics.app.framework.Navatics;
import com.navatics.app.framework.NvConnection;
import com.navatics.app.framework.NvDisposableHandler;
import com.navatics.app.settings.ConnectionStateSetting;
import com.navatics.robot.transport.NvDeviceInfo;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class ConnectionStateSetting extends SettingEntry {

    /* renamed from: h */
    private static final C3044k f5011h = C3044k.m1564a(ConnectionStateSetting.class);

    /* renamed from: a */
    C1890c f5012a;

    /* renamed from: b */
    C1889b f5013b;
    @BindView
    ViewGroup btnContainer;

    /* renamed from: c */
    C1888a f5014c;

    /* renamed from: d */
    GroundStation f5015d;

    /* renamed from: e */
    NvConnection f5016e;

    /* renamed from: f */
    ObjectAnimator f5017f;
    @BindView
    ImageView ivBuoy;
    @BindView
    ImageView ivConnSymbol1;
    @BindView
    ImageView ivConnSymbol2;
    @BindView
    ImageView ivInProgress;
    @BindView
    ImageView ivPhone;
    @BindView
    ImageView ivRemote;
    @BindView
    ImageView ivRobot;
    @BindView
    ProgressBar pgDisconnect;
    @BindView
    TextView tvDisconnect;

    /* renamed from: lambda$aq1S-qQ2vdFWq7cgrmJA17f8c4c */
    public static /* synthetic */ void m13083lambda$aq1SqQ2vdFWq7cgrmJA17f8c4c(ConnectionStateSetting connectionStateSetting, View view) {
        connectionStateSetting.m7525a(view);
    }

    /* renamed from: com.navatics.app.settings.ConnectionStateSetting$c */
    /* loaded from: classes.dex */
    class C1890c extends AbstractRootHandler {
        public static /* synthetic */ void lambda$kX5cgRzNWYSzaCuo2R4ZR87i6MY(ConnectionStateSetting connectionStateSetting) {
            connectionStateSetting.m7516j();
        }

        public static /* synthetic */ void lambda$tPxpXM3oRmHg8AtrQ2mM17wtrOs(ConnectionStateSetting connectionStateSetting) {
            connectionStateSetting.m7517i();
        }

        C1890c() {
            ConnectionStateSetting.this = r1;
        }

        @Override // com.navatics.app.framework.AbstractRootHandler, com.navatics.app.framework.NvRootHandler
        /* renamed from: a */
        public void mo7502a(GroundStation groundStation, GroundStation groundStation2) {
            ConnectionStateSetting.f5011h.mo1511a((Object) "onCurrentGroundStationChanged");
            NvDisposableHandler.m7731a((NvDisposableHandler) ConnectionStateSetting.this.f5013b);
            final ConnectionStateSetting connectionStateSetting = ConnectionStateSetting.this;
            connectionStateSetting.m7431a(new Runnable() { // from class: com.navatics.app.settings.-$$Lambda$ConnectionStateSetting$c$tPxpXM3oRmHg8AtrQ2mM17wtrOs
                @Override // java.lang.Runnable
                public final void run() {
                    ConnectionStateSetting.C1890c.lambda$tPxpXM3oRmHg8AtrQ2mM17wtrOs(ConnectionStateSetting.this);
                }
            });
            ConnectionStateSetting connectionStateSetting2 = ConnectionStateSetting.this;
            connectionStateSetting2.f5015d = groundStation2;
            connectionStateSetting2.f5013b = new C1889b();
            ConnectionStateSetting.this.f5015d.m8137a(ConnectionStateSetting.this.f5013b);
        }

        @Override // com.navatics.app.framework.AbstractRootHandler, com.navatics.app.framework.NvRootHandler
        /* renamed from: b */
        public void mo7500b(GroundStation groundStation) {
            ConnectionStateSetting.f5011h.mo1511a((Object) "onGroundStationDisconnected");
            if (ConnectionStateSetting.this.f5015d == null || ConnectionStateSetting.this.f5015d.m8129b() != groundStation.m8129b()) {
                return;
            }
            final ConnectionStateSetting connectionStateSetting = ConnectionStateSetting.this;
            connectionStateSetting.m7431a(new Runnable() { // from class: com.navatics.app.settings.-$$Lambda$ConnectionStateSetting$c$kX5cgRzNWYSzaCuo2R4ZR87i6MY
                @Override // java.lang.Runnable
                public final void run() {
                    ConnectionStateSetting.C1890c.lambda$kX5cgRzNWYSzaCuo2R4ZR87i6MY(ConnectionStateSetting.this);
                }
            });
            ConnectionStateSetting.this.f5015d = null;
        }
    }

    /* renamed from: com.navatics.app.settings.ConnectionStateSetting$b */
    /* loaded from: classes.dex */
    class C1889b extends AbstractGroundStationHandler {
        public static /* synthetic */ void lambda$8B0f92yBCwLNNqQX4jqTEl972YA(ConnectionStateSetting connectionStateSetting) {
            connectionStateSetting.m7515k();
        }

        public static /* synthetic */ void lambda$Rbxdmik1Q9ATZDci1t1_iWWn8L4(ConnectionStateSetting connectionStateSetting) {
            connectionStateSetting.m7513m();
        }

        C1889b() {
            ConnectionStateSetting.this = r1;
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: a */
        public void mo7506a(GroundStation groundStation, NvDeviceInfo nvDeviceInfo) {
            ConnectionStateSetting.f5011h.mo1511a((Object) "onConnectionInitializing");
            if (ConnectionStateSetting.this.f5016e == null) {
                final ConnectionStateSetting connectionStateSetting = ConnectionStateSetting.this;
                connectionStateSetting.m7431a(new Runnable() { // from class: com.navatics.app.settings.-$$Lambda$ConnectionStateSetting$b$8B0f92yBCwLNNqQX4jqTEl972YA
                    @Override // java.lang.Runnable
                    public final void run() {
                        ConnectionStateSetting.C1889b.lambda$8B0f92yBCwLNNqQX4jqTEl972YA(ConnectionStateSetting.this);
                    }
                });
            }
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: a */
        public void mo7507a(GroundStation groundStation, NvConnection nvConnection, NvConnection nvConnection2) {
            ConnectionStateSetting.f5011h.mo1511a((Object) "onConnectionChanged");
            NvDisposableHandler.m7731a((NvDisposableHandler) ConnectionStateSetting.this.f5014c);
            if (nvConnection2 != null) {
                ConnectionStateSetting connectionStateSetting = ConnectionStateSetting.this;
                connectionStateSetting.f5016e = nvConnection2;
                connectionStateSetting.f5014c = new C1888a();
                ConnectionStateSetting.this.f5016e.m7896a(ConnectionStateSetting.this.f5014c);
            }
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: a */
        public void mo7508a(GroundStation groundStation, NvConnection nvConnection) {
            ConnectionStateSetting.f5011h.mo1511a((Object) "onNewDevice");
            final ConnectionStateSetting connectionStateSetting = ConnectionStateSetting.this;
            connectionStateSetting.m7431a(new Runnable() { // from class: com.navatics.app.settings.-$$Lambda$ConnectionStateSetting$b$Rbxdmik1Q9ATZDci1t1_iWWn8L4
                @Override // java.lang.Runnable
                public final void run() {
                    ConnectionStateSetting.C1889b.lambda$Rbxdmik1Q9ATZDci1t1_iWWn8L4(ConnectionStateSetting.this);
                }
            });
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: b */
        public void mo7504b(GroundStation groundStation, NvConnection nvConnection) {
            ConnectionStateSetting.f5011h.mo1511a((Object) "onConnectionLost");
        }
    }

    /* renamed from: com.navatics.app.settings.ConnectionStateSetting$a */
    /* loaded from: classes.dex */
    class C1888a extends AbstractConnectionHandler {
        /* renamed from: lambda$1HFIp3hfLPpV-e3jtIkiEfvd17A */
        public static /* synthetic */ void m13084lambda$1HFIp3hfLPpVe3jtIkiEfvd17A(ConnectionStateSetting connectionStateSetting) {
            connectionStateSetting.m7514l();
        }

        public static /* synthetic */ void lambda$zXgLnXHO6MuNQrMdA0EE3Hvcb_g(ConnectionStateSetting connectionStateSetting) {
            connectionStateSetting.m7513m();
        }

        C1888a() {
            ConnectionStateSetting.this = r1;
        }

        @Override // com.navatics.app.framework.AbstractConnectionHandler, com.navatics.app.framework.NvConnectionHandler
        /* renamed from: b */
        public void mo7511b(NvConnection nvConnection) {
            ConnectionStateSetting.f5011h.mo1511a((Object) "onAuthSuccess");
            if (ConnectionStateSetting.this.f5016e == nvConnection) {
                final ConnectionStateSetting connectionStateSetting = ConnectionStateSetting.this;
                connectionStateSetting.m7431a(new Runnable() { // from class: com.navatics.app.settings.-$$Lambda$ConnectionStateSetting$a$1HFIp3hfLPpV-e3jtIkiEfvd17A
                    @Override // java.lang.Runnable
                    public final void run() {
                        ConnectionStateSetting.C1888a.m13084lambda$1HFIp3hfLPpVe3jtIkiEfvd17A(ConnectionStateSetting.this);
                    }
                });
            }
        }

        @Override // com.navatics.app.framework.AbstractConnectionHandler, com.navatics.app.framework.NvConnectionHandler
        /* renamed from: e */
        public void mo7509e(NvConnection nvConnection) {
            ConnectionStateSetting.f5011h.mo1511a((Object) "onDisconnected");
            final ConnectionStateSetting connectionStateSetting = ConnectionStateSetting.this;
            connectionStateSetting.m7431a(new Runnable() { // from class: com.navatics.app.settings.-$$Lambda$ConnectionStateSetting$a$zXgLnXHO6MuNQrMdA0EE3Hvcb_g
                @Override // java.lang.Runnable
                public final void run() {
                    ConnectionStateSetting.C1888a.lambda$zXgLnXHO6MuNQrMdA0EE3Hvcb_g(ConnectionStateSetting.this);
                }
            });
            ConnectionStateSetting connectionStateSetting2 = ConnectionStateSetting.this;
            connectionStateSetting2.f5016e = null;
            NvDisposableHandler.m7731a((NvDisposableHandler) connectionStateSetting2.f5014c);
        }
    }

    public ConnectionStateSetting(Activity activity) {
        super(activity);
    }

    @Override // com.navatics.app.settings.SettingEntry
    /* renamed from: a */
    public View mo7411a() {
        this.f5093g = ((LayoutInflater) m7426g().getSystemService("layout_inflater")).inflate(R.layout.connection_state_setting_layout, (ViewGroup) null, false);
        ButterKnife.m12803a(this, this.f5093g);
        this.tvDisconnect.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.settings.-$$Lambda$ConnectionStateSetting$aq1S-qQ2vdFWq7cgrmJA17f8c4c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConnectionStateSetting.m13083lambda$aq1SqQ2vdFWq7cgrmJA17f8c4c(ConnectionStateSetting.this, view);
            }
        });
        return this.f5093g;
    }

    /* renamed from: a */
    public /* synthetic */ void m7525a(View view) {
        if (this.f5016e != null) {
            this.pgDisconnect.setVisibility(0);
            this.tvDisconnect.setClickable(false);
            this.tvDisconnect.setVisibility(4);
            this.f5016e.m7874k();
        }
    }

    /* renamed from: h */
    private void m7518h() {
        if (this.f5093g == null) {
            return;
        }
        this.ivConnSymbol1.setImageResource(R.drawable.settings_disconnected_cable);
        this.ivRemote.setImageResource(R.drawable.settings_disconnected_remote);
        this.ivInProgress.setImageResource(R.drawable.settings_connect_not);
        this.ivBuoy.setImageResource(R.drawable.settings_disconnected_buoy);
        this.ivConnSymbol2.setImageResource(R.drawable.settings_disconnected_cable);
        this.ivRobot.setImageResource(R.drawable.settings_disconnected_robot);
        this.btnContainer.setBackgroundResource(R.drawable.setting_btn_disable_bg);
    }

    @Override // com.navatics.app.settings.SettingEntry
    /* renamed from: b */
    public void mo7430b() {
        super.mo7430b();
        m7518h();
        this.f5012a = new C1890c();
        Navatics.m7952a(this.f5012a);
    }

    @Override // com.navatics.app.settings.SettingEntry
    /* renamed from: c */
    public void mo7429c() {
        NvDisposableHandler.m7731a((NvDisposableHandler) this.f5014c);
        NvDisposableHandler.m7731a((NvDisposableHandler) this.f5013b);
        Navatics.m7945b(this.f5012a);
        this.f5012a = null;
    }

    /* renamed from: i */
    public void m7517i() {
        f5011h.mo1511a((Object) "gsConnected");
        this.ivRemote.setImageResource(R.drawable.settings_connected_remote);
        this.ivConnSymbol1.setImageResource(R.drawable.settings_connected_cable);
    }

    /* renamed from: j */
    public void m7516j() {
        f5011h.mo1511a((Object) "gsDisconnected");
        this.ivRemote.setImageResource(R.drawable.settings_disconnected_remote);
        this.ivConnSymbol1.setImageResource(R.drawable.settings_disconnected_cable);
    }

    /* renamed from: k */
    public void m7515k() {
        f5011h.mo1511a((Object) "buoyConnecting");
        this.ivInProgress.setImageResource(R.drawable.settings_connecting);
        this.f5017f = ObjectAnimator.ofFloat(this.ivInProgress, "rotation", 0.0f, 360.0f);
        this.f5017f.setDuration(1000L);
        this.f5017f.setRepeatCount(-1);
        this.f5017f.addListener(new AnimatorListenerAdapter() { // from class: com.navatics.app.settings.ConnectionStateSetting.1
            {
                ConnectionStateSetting.this = this;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator, boolean z) {
                ConnectionStateSetting.this.ivInProgress.setRotation(0.0f);
            }
        });
        this.f5017f.start();
    }

    /* renamed from: l */
    public void m7514l() {
        f5011h.mo1511a((Object) "buoyConnected");
        ObjectAnimator objectAnimator = this.f5017f;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f5017f = null;
        }
        this.ivInProgress.setImageResource(R.drawable.settings_connect_yes);
        this.ivBuoy.setImageResource(R.drawable.settings_connected_buoy);
        this.ivConnSymbol2.setImageResource(R.drawable.settings_connected_cable);
        this.ivRobot.setImageResource(R.drawable.settings_connected_robot);
        this.btnContainer.setBackgroundResource(R.drawable.setting_btn_bg);
        this.tvDisconnect.setClickable(true);
    }

    /* renamed from: m */
    public void m7513m() {
        f5011h.mo1511a((Object) "buoyDisconnected");
        this.ivInProgress.setImageResource(R.drawable.settings_connect_not);
        this.ivBuoy.setImageResource(R.drawable.settings_disconnected_buoy);
        this.ivConnSymbol2.setImageResource(R.drawable.settings_disconnected_cable);
        this.ivRobot.setImageResource(R.drawable.settings_disconnected_robot);
        this.btnContainer.setBackgroundResource(R.drawable.setting_btn_disable_bg);
        this.pgDisconnect.setVisibility(4);
        this.tvDisconnect.setVisibility(0);
    }
}
