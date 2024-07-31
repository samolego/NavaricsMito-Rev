package com.navatics.robot.transport.p064ss;

import android.support.annotation.NonNull;
import com.navatics.robot.transport.INvTransport;
import com.navatics.robot.transport.NvAddressExtra;
import com.navatics.robot.transport.NvError;
import com.navatics.robot.transport.NvEvent;
import com.navatics.robot.transport.NvEventHandler;
import com.navatics.robot.transport.NvTransport;
import com.navatics.robot.transport.TransportType;
import com.navatics.robot.utils.C2160n;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.SPManager;
import com.senseplay.sdk.SPRc;
import com.senseplay.sdk.SPUsb;
import com.senseplay.sdk.model.device.DeviceInfo;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.transport.ss.e */
/* loaded from: classes2.dex */
public class SensethinkNvTransport implements INvTransport {

    /* renamed from: a */
    private static final C3044k f6646a = C3044k.m1564a(SensethinkNvTransport.class);

    /* renamed from: b */
    private NvEventHandler f6647b;

    /* renamed from: c */
    private SensethinkGroundStation f6648c;

    /* renamed from: d */
    private SensethinkGroundStation f6649d;

    /* renamed from: e */
    private SPUsb f6650e;

    /* renamed from: f */
    private boolean f6651f;

    /* renamed from: g */
    private boolean f6652g = false;

    /* renamed from: lambda$GLB6XSl-wzh8RHVoAJwO71fSAoo */
    public static /* synthetic */ void m13134lambda$GLB6XSlwzh8RHVoAJwO71fSAoo(SensethinkNvTransport sensethinkNvTransport, boolean z) {
        sensethinkNvTransport.m6050a(z);
    }

    /* renamed from: lambda$gbEVZzP0RQ6q1Uc-sqQuK0BpPGg */
    public static /* synthetic */ void m13135lambda$gbEVZzP0RQ6q1UcsqQuK0BpPGg(SensethinkNvTransport sensethinkNvTransport, Boolean bool) {
        sensethinkNvTransport.m6051a(bool);
    }

    /* renamed from: lambda$tmHgmRoqgg1c8rLik-XdOfPZm7A */
    public static /* synthetic */ void m13136lambda$tmHgmRoqgg1c8rLikXdOfPZm7A(SensethinkNvTransport sensethinkNvTransport, DeviceInfo deviceInfo) {
        sensethinkNvTransport.m6052a(deviceInfo);
    }

    @Override // com.navatics.robot.transport.INvTransport
    /* renamed from: a */
    public TransportType mo6054a() {
        return TransportType.SensethinkWireless;
    }

    @Override // com.navatics.robot.transport.INvTransport
    /* renamed from: a */
    public void mo6053a(@NonNull NvEventHandler nvEventHandler) {
        synchronized (this) {
            if (this.f6647b != null) {
                C3044k c3044k = f6646a;
                c3044k.mo1504b((Object) (getClass().getSimpleName() + " already have an event handler"));
                return;
            }
            this.f6647b = nvEventHandler;
            if (this.f6649d != null) {
                this.f6648c = this.f6649d;
                this.f6649d = null;
                NvEvent.m6242b(this.f6647b, this, 65547, this.f6648c).m6261a();
            }
        }
    }

    @Override // com.navatics.robot.transport.INvTransport
    /* renamed from: b */
    public Class<? extends NvAddressExtra> mo6049b() {
        return SenseThinkAddrExtra.class;
    }

    /* renamed from: a */
    public void m6050a(boolean z) {
        C3044k c3044k = f6646a;
        c3044k.mo1511a((Object) ("openDeviceResult : " + z));
        if (z) {
            SPRc.getInstance().getRcInfo(new MCallBack() { // from class: com.navatics.robot.transport.ss.-$$Lambda$e$tmHgmRoqgg1c8rLik-XdOfPZm7A
                @Override // com.senseplay.mframe.client.MCallBack
                public final void onResult(Object obj) {
                    SensethinkNvTransport.m13136lambda$tmHgmRoqgg1c8rLikXdOfPZm7A(SensethinkNvTransport.this, (DeviceInfo) obj);
                }
            });
        } else {
            synchronized (this) {
                this.f6651f = false;
                if (this.f6647b != null && this.f6648c != null) {
                    NvEvent.m6242b(this.f6647b, this, 65548, this.f6648c).m6261a();
                }
                if (this.f6648c != null) {
                    this.f6648c.m6090p();
                }
                this.f6648c = null;
                if (this.f6649d != null) {
                    this.f6649d.m6090p();
                }
                this.f6649d = null;
            }
        }
        synchronized (this) {
            this.f6652g = false;
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m6052a(DeviceInfo deviceInfo) {
        if (deviceInfo == null) {
            f6646a.mo1499d("getRcInfo return null");
            synchronized (this) {
                this.f6652g = false;
            }
        } else if (C2160n.m5855a((CharSequence) deviceInfo.getSerialNo())) {
            NvEvent.m6253a(this.f6647b, this, 16711689, new NvError(48, "Remote init failed.")).m6261a();
        } else {
            synchronized (this) {
                if (this.f6648c == null && this.f6649d == null) {
                    if (this.f6647b == null) {
                        this.f6649d = new SensethinkGroundStation(deviceInfo);
                    } else {
                        this.f6648c = new SensethinkGroundStation(deviceInfo);
                        NvEvent.m6242b(this.f6647b, this, 65547, this.f6648c).m6261a();
                    }
                    this.f6651f = true;
                    return;
                }
                f6646a.mo1504b((Object) "openDeviceResult success, but we already have a sta");
                synchronized (this) {
                    this.f6652g = false;
                }
            }
        }
    }

    @Override // com.navatics.robot.transport.INvTransport
    /* renamed from: d */
    public void mo6047d() {
        if (this.f6651f) {
            f6646a.mo1500c((Object) "checkConnectivity already connected");
        } else {
            m6046e();
        }
    }

    @Override // com.navatics.robot.transport.INvTransport
    /* renamed from: c */
    public void mo6048c() {
        SPManager sPManager = SPManager.getInstance();
        sPManager.init(NvTransport.m6018a());
        sPManager.setClient("44E7F9DC2DE558BFBC5D808E38267111", "F851C75F9F55610C2C321F1AC167BBBB");
        this.f6650e = SPUsb.getInstance();
        this.f6650e.registerUsbReceiver(NvTransport.m6018a(), new MCallBack() { // from class: com.navatics.robot.transport.ss.-$$Lambda$e$gbEVZzP0RQ6q1Uc-sqQuK0BpPGg
            @Override // com.senseplay.mframe.client.MCallBack
            public final void onResult(Object obj) {
                SensethinkNvTransport.m13135lambda$gbEVZzP0RQ6q1UcsqQuK0BpPGg(SensethinkNvTransport.this, (Boolean) obj);
            }
        });
        m6046e();
    }

    /* renamed from: a */
    public /* synthetic */ void m6051a(Boolean bool) {
        if (bool.booleanValue()) {
            m6046e();
        } else {
            m6050a(false);
        }
    }

    /* renamed from: e */
    private synchronized void m6046e() {
        if (this.f6652g) {
            f6646a.mo1499d("still in openUsb, ignore");
            return;
        }
        this.f6652g = true;
        f6646a.mo1511a((Object) "call ss openUsb");
        this.f6650e.openUsb(new MCallBack() { // from class: com.navatics.robot.transport.ss.-$$Lambda$e$GLB6XSl-wzh8RHVoAJwO71fSAoo
            @Override // com.senseplay.mframe.client.MCallBack
            public final void onResult(Object obj) {
                SensethinkNvTransport.m13134lambda$GLB6XSlwzh8RHVoAJwO71fSAoo(SensethinkNvTransport.this, ((Boolean) obj).booleanValue());
            }
        });
    }
}
