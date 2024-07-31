package com.navatics.app.framework.p050b;

import android.support.p008v4.view.InputDeviceCompat;
import com.navatics.app.framework.AbstractConnectionHandler;
import com.navatics.app.framework.AbstractGroundStationHandler;
import com.navatics.app.framework.AbstractRootHandler;
import com.navatics.app.framework.GroundStation;
import com.navatics.app.framework.Navatics;
import com.navatics.app.framework.NvConnection;
import com.navatics.app.framework.NvDisposableHandler;
import com.navatics.robot.transport.NvDeviceInfo;
import com.navatics.robot.transport.NvError;
import com.navatics.robot.transport.NvEvent;
import org.apache.log4j.C3044k;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* renamed from: com.navatics.app.framework.b.z */
/* loaded from: classes.dex */
public class SystemStateMonitor {

    /* renamed from: a */
    private final C3044k f4291a = C3044k.m1564a(SystemStateMonitor.class);

    /* renamed from: b */
    private EventPipeline f4292b = new EventPipeline();

    /* renamed from: c */
    private C1755c f4293c = new C1755c();

    /* renamed from: d */
    private C1754b f4294d = new C1754b();

    /* renamed from: e */
    private C1753a f4295e = new C1753a();

    /* renamed from: f */
    private GroundStation f4296f;

    /* renamed from: g */
    private NvConnection f4297g;

    /* renamed from: a */
    public EventPipeline m8568a() {
        return this.f4292b;
    }

    /* renamed from: b */
    public void m8562b() {
        Navatics.m7952a(this.f4293c);
    }

    /* renamed from: c */
    public void m8560c() {
        NvDisposableHandler.m7731a((NvDisposableHandler) this.f4295e);
        NvDisposableHandler.m7731a((NvDisposableHandler) this.f4294d);
        Navatics.m7945b(this.f4293c);
        this.f4293c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemStateMonitor.java */
    /* renamed from: com.navatics.app.framework.b.z$c */
    /* loaded from: classes.dex */
    public class C1755c extends AbstractRootHandler {
        C1755c() {
        }

        @Override // com.navatics.app.framework.AbstractRootHandler, com.navatics.app.framework.NvRootHandler
        /* renamed from: a */
        public void mo7664a(GroundStation groundStation) {
            SystemStateMonitor.this.f4291a.mo1511a((Object) "onGroundStationConnected");
            SystemStateMonitor.this.f4292b.m8575b(65547, groundStation);
        }

        @Override // com.navatics.app.framework.AbstractRootHandler, com.navatics.app.framework.NvRootHandler
        /* renamed from: c */
        public void mo7663c(GroundStation groundStation) {
            SystemStateMonitor.this.f4291a.mo1511a((Object) "onNewGroundStation");
            SystemStateMonitor.this.f4292b.m8581a(65568, groundStation);
        }

        @Override // com.navatics.app.framework.AbstractRootHandler, com.navatics.app.framework.NvRootHandler
        /* renamed from: a */
        public void mo7502a(GroundStation groundStation, GroundStation groundStation2) {
            SystemStateMonitor.this.f4291a.mo1511a((Object) "onCurrentGroundStationChanged");
            NvDisposableHandler.m7731a((NvDisposableHandler) SystemStateMonitor.this.f4294d);
            SystemStateMonitor.this.f4296f = groundStation2;
            SystemStateMonitor systemStateMonitor = SystemStateMonitor.this;
            systemStateMonitor.f4294d = new C1754b();
            SystemStateMonitor.this.f4296f.m8137a(SystemStateMonitor.this.f4294d);
            SystemStateMonitor.this.f4292b.m8575b(196609, groundStation, groundStation2);
        }

        @Override // com.navatics.app.framework.AbstractRootHandler, com.navatics.app.framework.NvRootHandler
        /* renamed from: b */
        public void mo7500b(GroundStation groundStation) {
            C3044k c3044k = SystemStateMonitor.this.f4291a;
            c3044k.mo1511a((Object) ("onGroundStationDisconnected, my id = " + SystemStateMonitor.this.f4296f + ", gta id = " + groundStation.m8129b()));
            if (SystemStateMonitor.this.f4296f == null || SystemStateMonitor.this.f4296f.m8129b() != groundStation.m8129b()) {
                return;
            }
            SystemStateMonitor.this.f4296f = null;
            SystemStateMonitor.this.f4292b.m8583a(65546);
            SystemStateMonitor.this.f4292b.m8583a(65547);
            SystemStateMonitor.this.f4292b.m8583a(196609);
            SystemStateMonitor.this.f4292b.m8581a(65548, groundStation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemStateMonitor.java */
    /* renamed from: com.navatics.app.framework.b.z$b */
    /* loaded from: classes.dex */
    public class C1754b extends AbstractGroundStationHandler {
        C1754b() {
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: b */
        public void mo7726b(GroundStation groundStation) {
            SystemStateMonitor.this.f4292b.m8581a(IjkMediaPlayer.OnNativeInvokeListener.CTRL_WILL_HTTP_OPEN, groundStation);
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: c */
        public void mo7725c(GroundStation groundStation) {
            SystemStateMonitor.this.f4291a.mo1511a((Object) "onGroundStationAuthSuccess");
            SystemStateMonitor.this.f4292b.m8575b(65546, groundStation);
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: a */
        public void mo7730a(GroundStation groundStation) {
            SystemStateMonitor.this.f4292b.m8581a(65545, groundStation);
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: d */
        public void mo7724d(GroundStation groundStation) {
            SystemStateMonitor.this.f4292b.m8581a(65566, groundStation);
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: a */
        public void mo7729a(GroundStation groundStation, int i) {
            SystemStateMonitor.this.f4292b.m8581a(65571, groundStation, Integer.valueOf(i));
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: a */
        public void mo7506a(GroundStation groundStation, NvDeviceInfo nvDeviceInfo) {
            SystemStateMonitor.this.f4291a.mo1511a((Object) "onConnectionInitializing");
            SystemStateMonitor.this.f4292b.m8581a(65570, groundStation, nvDeviceInfo);
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: a */
        public void mo7507a(GroundStation groundStation, NvConnection nvConnection, NvConnection nvConnection2) {
            SystemStateMonitor.this.f4291a.mo1511a((Object) "onConnectionChanged");
            NvDisposableHandler.m7731a((NvDisposableHandler) SystemStateMonitor.this.f4295e);
            SystemStateMonitor.this.f4292b.m8575b(196610, nvConnection, nvConnection2);
            if (nvConnection2 != null) {
                SystemStateMonitor.this.f4297g = nvConnection2;
                SystemStateMonitor systemStateMonitor = SystemStateMonitor.this;
                systemStateMonitor.f4295e = new C1753a();
                SystemStateMonitor.this.f4297g.m7896a(SystemStateMonitor.this.f4295e);
            }
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: b */
        public void mo7504b(GroundStation groundStation, NvConnection nvConnection) {
            SystemStateMonitor.this.f4291a.mo1511a((Object) "onConnectionLost");
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: a */
        public void mo7728a(GroundStation groundStation, int i, NvError nvError) {
            C3044k c3044k = SystemStateMonitor.this.f4291a;
            c3044k.mo1504b((Object) ("onError: err, " + i + ", " + NvEvent.m6244b(i)));
            SystemStateMonitor.this.f4292b.m8581a(i, Integer.valueOf(i), groundStation, nvError);
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: a */
        public void mo7508a(GroundStation groundStation, NvConnection nvConnection) {
            SystemStateMonitor.this.f4291a.mo1511a((Object) "onNewDevice");
            SystemStateMonitor.this.f4292b.m8581a(65569, groundStation, nvConnection);
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: a */
        public void mo7727a(NvDeviceInfo nvDeviceInfo) {
            SystemStateMonitor.this.f4292b.m8581a(65549, nvDeviceInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemStateMonitor.java */
    /* renamed from: com.navatics.app.framework.b.z$a */
    /* loaded from: classes.dex */
    public class C1753a extends AbstractConnectionHandler {
        C1753a() {
        }

        @Override // com.navatics.app.framework.AbstractConnectionHandler, com.navatics.app.framework.NvConnectionHandler
        /* renamed from: d */
        public void mo7858d(NvConnection nvConnection) {
            SystemStateMonitor.this.f4291a.mo1511a((Object) "onConnected");
            SystemStateMonitor.this.f4292b.m8575b(InputDeviceCompat.SOURCE_TRACKBALL, nvConnection);
        }

        @Override // com.navatics.app.framework.AbstractConnectionHandler, com.navatics.app.framework.NvConnectionHandler
        /* renamed from: e */
        public void mo7509e(NvConnection nvConnection) {
            SystemStateMonitor.this.f4291a.mo1511a((Object) "onDisconnected");
            SystemStateMonitor.this.f4297g = null;
            NvDisposableHandler.m7731a((NvDisposableHandler) SystemStateMonitor.this.f4295e);
            SystemStateMonitor.this.f4292b.m8583a(InputDeviceCompat.SOURCE_TRACKBALL);
            SystemStateMonitor.this.f4292b.m8583a(65543);
            if (!nvConnection.m7886c().m8101j()) {
                SystemStateMonitor.this.f4292b.m8583a(196610);
            }
            SystemStateMonitor.this.f4292b.m8581a(65541, nvConnection);
        }

        @Override // com.navatics.app.framework.AbstractConnectionHandler, com.navatics.app.framework.NvConnectionHandler
        /* renamed from: b */
        public void mo7511b(NvConnection nvConnection) {
            SystemStateMonitor.this.f4291a.mo1511a((Object) "onAuthSuccess");
            if (SystemStateMonitor.this.f4297g == nvConnection) {
                SystemStateMonitor.this.f4292b.m8575b(65543, nvConnection);
            }
        }

        @Override // com.navatics.app.framework.AbstractConnectionHandler, com.navatics.app.framework.NvConnectionHandler
        /* renamed from: a */
        public void mo7861a(NvConnection nvConnection) {
            SystemStateMonitor.this.f4292b.m8581a(65544, nvConnection);
        }

        @Override // com.navatics.app.framework.AbstractConnectionHandler, com.navatics.app.framework.NvConnectionHandler
        /* renamed from: c */
        public void mo7859c(NvConnection nvConnection) {
            SystemStateMonitor.this.f4292b.m8581a(65567, nvConnection);
        }

        @Override // com.navatics.app.framework.AbstractConnectionHandler, com.navatics.app.framework.NvConnectionHandler
        /* renamed from: a */
        public void mo7860a(NvConnection nvConnection, int i, NvError nvError) {
            SystemStateMonitor.this.f4291a.mo1511a((Object) "onError");
            SystemStateMonitor.this.f4292b.m8581a(i, Integer.valueOf(i), nvConnection, nvError);
        }
    }
}
