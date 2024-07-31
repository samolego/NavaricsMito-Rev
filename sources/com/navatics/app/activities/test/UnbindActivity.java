package com.navatics.app.activities.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p011v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.navatics.app.R;
import com.navatics.app.activities.test.UnbindActivity;
import com.navatics.app.framework.AbstractConnectionHandler;
import com.navatics.app.framework.AbstractGroundStationHandler;
import com.navatics.app.framework.GroundStation;
import com.navatics.app.framework.Navatics;
import com.navatics.app.framework.NvConnection;
import com.navatics.app.framework.NvDisposableHandler;
import com.navatics.app.framework.NvRootHandler;
import com.navatics.app.framework.user.NvUser;
import com.navatics.app.framework.user.NvUserManager;
import com.navatics.app.framework.user.SSUsrInfo;
import com.navatics.robot.transport.NvDeviceInfo;
import com.navatics.robot.transport.NvError;
import java.util.HashMap;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class UnbindActivity extends AppCompatActivity {

    /* renamed from: a */
    private static final C3044k f4006a = C3044k.m1564a(UnbindActivity.class);

    /* renamed from: b */
    private C1701c f4007b = new C1701c();
    @BindView
    Button btnUnbindCoreboard;
    @BindView
    Button btnUnbindRemote;

    /* renamed from: c */
    private C1700b f4008c;

    /* renamed from: d */
    private C1699a f4009d;

    /* renamed from: com.navatics.app.activities.test.UnbindActivity$c */
    /* loaded from: classes.dex */
    class C1701c implements NvRootHandler {
        C1701c() {
            UnbindActivity.this = r1;
        }

        @Override // com.navatics.app.framework.NvRootHandler
        /* renamed from: a */
        public void mo7664a(GroundStation groundStation) {
            UnbindActivity.f4006a.mo1511a((Object) "onGroundStationConnected");
        }

        @Override // com.navatics.app.framework.NvRootHandler
        /* renamed from: c */
        public void mo7663c(GroundStation groundStation) {
            UnbindActivity.f4006a.mo1511a((Object) "onNewGroundStation");
        }

        @Override // com.navatics.app.framework.NvRootHandler
        /* renamed from: a */
        public void mo7502a(GroundStation groundStation, GroundStation groundStation2) {
            UnbindActivity.f4006a.mo1511a((Object) "onCurrentGroundStationChanged, newGta ");
            UnbindActivity unbindActivity = UnbindActivity.this;
            unbindActivity.f4008c = new C1700b();
            groundStation2.m8137a(UnbindActivity.this.f4008c);
        }

        @Override // com.navatics.app.framework.NvRootHandler
        /* renamed from: b */
        public void mo7500b(GroundStation groundStation) {
            UnbindActivity.f4006a.mo1511a((Object) "onGroundStationDisconnected");
            NvDisposableHandler.m7731a((NvDisposableHandler) UnbindActivity.this.f4008c);
        }
    }

    /* renamed from: com.navatics.app.activities.test.UnbindActivity$b */
    /* loaded from: classes.dex */
    class C1700b extends AbstractGroundStationHandler {
        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: a */
        public void mo7506a(GroundStation groundStation, NvDeviceInfo nvDeviceInfo) {
        }

        C1700b() {
            UnbindActivity.this = r1;
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: b */
        public void mo7726b(GroundStation groundStation) {
            UnbindActivity.f4006a.mo1511a((Object) "gta state update");
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: a */
        public void mo7507a(GroundStation groundStation, NvConnection nvConnection, NvConnection nvConnection2) {
            UnbindActivity.f4006a.mo1511a((Object) "onConnectionChanged");
            UnbindActivity unbindActivity = UnbindActivity.this;
            unbindActivity.f4009d = new C1699a();
            nvConnection2.m7896a(UnbindActivity.this.f4009d);
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: c */
        public void mo7725c(GroundStation groundStation) {
            UnbindActivity.f4006a.mo1511a((Object) "onGroundStationAuthSuccess");
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: a */
        public void mo7730a(GroundStation groundStation) {
            UnbindActivity.f4006a.mo1511a((Object) "onGroundStationBindSuccess.");
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: a */
        public void mo7508a(GroundStation groundStation, NvConnection nvConnection) {
            UnbindActivity.f4006a.mo1511a((Object) "onNewDevice.");
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: a */
        public void mo7728a(GroundStation groundStation, int i, NvError nvError) {
            if (i != 16711687) {
                return;
            }
            UnbindActivity unbindActivity = UnbindActivity.this;
            Toast.makeText(unbindActivity, "Failed ! Cause : " + nvError, 1).show();
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: a */
        public void mo7727a(NvDeviceInfo nvDeviceInfo) {
            C3044k c3044k = UnbindActivity.f4006a;
            c3044k.mo1499d("GroundStation " + nvDeviceInfo.getSerialNumber() + " destroyed.");
        }
    }

    /* renamed from: com.navatics.app.activities.test.UnbindActivity$a */
    /* loaded from: classes.dex */
    public class C1699a extends AbstractConnectionHandler {
        /* renamed from: lambda$7TaHpHaPIG8sz-l5uuBIFcgTLqo */
        public static /* synthetic */ void m13041lambda$7TaHpHaPIG8szl5uuBIFcgTLqo(C1699a c1699a) {
            c1699a.m8841b();
        }

        public static /* synthetic */ void lambda$qJZvIdtmlflgRdv9Ui33crOTBc4(C1699a c1699a, NvError nvError) {
            c1699a.m8842a(nvError);
        }

        @Override // com.navatics.app.framework.AbstractConnectionHandler, com.navatics.app.framework.NvConnectionHandler
        /* renamed from: a */
        public void mo7861a(NvConnection nvConnection) {
        }

        @Override // com.navatics.app.framework.AbstractConnectionHandler, com.navatics.app.framework.NvConnectionHandler
        /* renamed from: b */
        public void mo7511b(NvConnection nvConnection) {
        }

        C1699a() {
            UnbindActivity.this = r1;
        }

        /* renamed from: b */
        public /* synthetic */ void m8841b() {
            Toast.makeText(UnbindActivity.this, "Success", 1).show();
        }

        @Override // com.navatics.app.framework.AbstractConnectionHandler, com.navatics.app.framework.NvConnectionHandler
        /* renamed from: c */
        public void mo7859c(NvConnection nvConnection) {
            UnbindActivity.this.runOnUiThread(new Runnable() { // from class: com.navatics.app.activities.test.-$$Lambda$UnbindActivity$a$7TaHpHaPIG8sz-l5uuBIFcgTLqo
                @Override // java.lang.Runnable
                public final void run() {
                    UnbindActivity.C1699a.m13041lambda$7TaHpHaPIG8szl5uuBIFcgTLqo(UnbindActivity.C1699a.this);
                }
            });
        }

        /* renamed from: a */
        public /* synthetic */ void m8842a(NvError nvError) {
            UnbindActivity unbindActivity = UnbindActivity.this;
            Toast.makeText(unbindActivity, "Failed ! Cause : " + nvError, 1).show();
        }

        @Override // com.navatics.app.framework.AbstractConnectionHandler, com.navatics.app.framework.NvConnectionHandler
        /* renamed from: a */
        public void mo7860a(NvConnection nvConnection, int i, final NvError nvError) {
            if (i != 16711688) {
                return;
            }
            UnbindActivity.this.runOnUiThread(new Runnable() { // from class: com.navatics.app.activities.test.-$$Lambda$UnbindActivity$a$qJZvIdtmlflgRdv9Ui33crOTBc4
                @Override // java.lang.Runnable
                public final void run() {
                    UnbindActivity.C1699a.lambda$qJZvIdtmlflgRdv9Ui33crOTBc4(UnbindActivity.C1699a.this, nvError);
                }
            });
        }
    }

    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.test_unbind_activity);
        ButterKnife.m12805a(this);
    }

    @OnClick
    public void onUnBindRemoteClicked(View view) {
        f4006a.mo1511a((Object) "btnUnbindRemote 1");
        SSUsrInfo m8844b = m8844b();
        if (m8844b == null) {
            f4006a.mo1504b((Object) "ssUsrInfo is null");
            Toast.makeText(this, "Have you login ?", 1).show();
            return;
        }
        GroundStation m7931h = Navatics.m7931h();
        if (m7931h == null) {
            Toast.makeText(this, "Have you plugin the remote ?", 1).show();
        } else if (!m7931h.m8120c()) {
            Toast.makeText(this, "Have you activate the remote ?", 1).show();
        } else {
            String serialNumber = m7931h.m8104g().getSerialNumber();
            String uuid = m8844b.getUuid();
            String accessToken = m8844b.getAccessToken();
            HashMap hashMap = new HashMap();
            hashMap.put("sn", serialNumber);
            hashMap.put("uuid", uuid);
            hashMap.put("access_token", accessToken);
            m7931h.m8114c(hashMap);
        }
    }

    @OnClick
    public void onUnBindDeviceClicked(View view) {
        SSUsrInfo m8844b = m8844b();
        if (m8844b == null) {
            f4006a.mo1504b((Object) "ssUsrInfo is null");
            Toast.makeText(this, "Have you login ?", 1).show();
            return;
        }
        GroundStation m7931h = Navatics.m7931h();
        if (m7931h == null) {
            Toast.makeText(this, "Have you plugin the remote ?", 1).show();
        } else if (!m7931h.m8120c()) {
            Toast.makeText(this, "Have you activate the remote ?", 1).show();
        } else {
            NvConnection m7930i = Navatics.m7930i();
            if (m7930i == null) {
                Toast.makeText(this, "Have you connect to the roller ?", 1).show();
            } else if (!m7930i.m7875j()) {
                Toast.makeText(this, "Have you activate the roller ?", 1).show();
            } else {
                String serialNumber = m7930i.m7876i().getSerialNumber();
                String uuid = m8844b.getUuid();
                String accessToken = m8844b.getAccessToken();
                HashMap hashMap = new HashMap();
                hashMap.put("sn", serialNumber);
                hashMap.put("uuid", uuid);
                hashMap.put("access_token", accessToken);
                m7930i.m7884c(hashMap);
            }
        }
    }

    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        Navatics.m7952a(this.f4007b);
    }

    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        Navatics.m7945b(this.f4007b);
        NvDisposableHandler.m7731a((NvDisposableHandler) this.f4008c);
        NvDisposableHandler.m7731a((NvDisposableHandler) this.f4009d);
    }

    /* renamed from: b */
    private SSUsrInfo m8844b() {
        NvUser m7806d = NvUserManager.m7828b().m7806d();
        if (m7806d == null) {
            f4006a.mo1504b((Object) "user is null");
            return null;
        } else if (m7806d.getSsUsrInfo() == null) {
            f4006a.mo1504b((Object) "user doesn't have ss info");
            return null;
        } else {
            return m7806d.getSsUsrInfo().getTarget();
        }
    }
}
