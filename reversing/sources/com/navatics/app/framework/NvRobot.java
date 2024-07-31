package com.navatics.app.framework;

import android.support.annotation.NonNull;
import android.support.p008v4.view.InputDeviceCompat;
import android.view.Surface;
import com.navatics.app.framework.NvRobot;
import com.navatics.app.framework.divelog.DiveLogManager;
import com.navatics.app.framework.p049a.DawnRobotAdapter;
import com.navatics.app.framework.p054f.MPEG4Recorder;
import com.navatics.app.framework.p054f.NvLocalServerPlayer;
import com.navatics.app.framework.p054f.NvMediaCodecPlayer;
import com.navatics.app.framework.p054f.OnH264DataAvailableCallback;
import com.navatics.robot.transport.NvCallback;
import com.navatics.robot.transport.NvSocket;
import com.navatics.robot.transport.NvValue;
import com.navatics.robot.transport.StorageInfo;
import com.navatics.robot.transport.WhiteBalance;
import com.navatics.robot.transport.p063b.NvObservable;
import com.navatics.robot.transport.p063b.NvReactive;
import com.navatics.robot.utils.RxTimer;
import com.navatics.xlog.WLog;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.p096b.Cancellable;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.app.framework.y */
/* loaded from: classes.dex */
public class NvRobot extends NvDevice implements NvCallback<RobotStatus> {

    /* renamed from: a */
    private static final String f4858a = "y";

    /* renamed from: b */
    private static final C3044k f4859b = C3044k.m1564a(NvRobot.class);

    /* renamed from: c */
    private final long f4860c;

    /* renamed from: d */
    private INvRobotAdapter f4861d;

    /* renamed from: e */
    private long f4862e;

    /* renamed from: f */
    private boolean f4863f;

    /* renamed from: g */
    private long f4864g;

    /* renamed from: h */
    private RobotStatus f4865h;

    /* renamed from: i */
    private C1859a f4866i;

    /* renamed from: j */
    private List<RobotStateHandler> f4867j;

    /* renamed from: k */
    private List<RobotForceUpdateHandler> f4868k;

    /* renamed from: l */
    private List<RobotSensorStateHandler> f4869l;

    /* renamed from: m */
    private List<Object> f4870m;

    /* renamed from: n */
    private boolean f4871n;

    /* renamed from: o */
    private long f4872o;

    /* renamed from: p */
    private INvVideoPlayer f4873p;

    /* renamed from: q */
    private SimpleDateFormat f4874q;

    /* renamed from: r */
    private MPEG4Recorder f4875r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NvRobot.java */
    /* renamed from: com.navatics.app.framework.y$a */
    /* loaded from: classes.dex */
    public class C1859a implements RxTimer.InterfaceC2159a {

        /* renamed from: a */
        RxTimer f4877a;

        C1859a() {
            NvRobot.this = r1;
        }

        /* renamed from: a */
        void m7666a() {
            this.f4877a = RxTimer.m5859a(this, 1000L, true);
            this.f4877a.m5860a();
        }

        /* renamed from: b */
        void m7665b() {
            this.f4877a.m5857b();
        }

        @Override // com.navatics.robot.utils.RxTimer.InterfaceC2159a
        /* renamed from: a */
        public void mo5856a(RxTimer rxTimer) {
            NvRobot.this.m7718F();
        }
    }

    /* renamed from: a */
    public static NvRobot m7714a() {
        GroundStation m7931h = Navatics.m7931h();
        if (m7931h == null) {
            f4859b.mo1504b((Object) "wtf?! current sta is null?");
            return null;
        }
        NvConnection m8098m = m7931h.m8098m();
        if (m8098m == null) {
            f4859b.mo1504b((Object) "wtf?! current connection is null");
            return null;
        }
        NvDevice m7898a = m8098m.m7898a(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        if (m7898a == null) {
            f4859b.mo1499d("active robot is null");
            return null;
        }
        return (NvRobot) m7898a;
    }

    public NvRobot(NvSocket nvSocket, @NonNull INvRobotAdapter iNvRobotAdapter) {
        super(nvSocket, InputDeviceCompat.SOURCE_TOUCHSCREEN);
        this.f4860c = 120000L;
        this.f4863f = true;
        this.f4866i = new C1859a();
        this.f4867j = new ArrayList();
        this.f4868k = new ArrayList();
        this.f4869l = new ArrayList();
        this.f4870m = new ArrayList();
        this.f4874q = new SimpleDateFormat("[yyyy.MM.dd hh:mm:ss.SSS]", Locale.getDefault());
        this.f4861d = iNvRobotAdapter;
        this.f4861d.mo8046a(this);
        this.f4866i.m7666a();
    }

    /* renamed from: b */
    public void m7703b() {
        String str = f4858a;
        WLog.m5850d(str, this + "onDestroyed");
        this.f4866i.m7665b();
        DiveLogManager m8472b = DiveLogManager.m8472b();
        if (m8472b.m8462e()) {
            String str2 = f4858a;
            WLog.m5850d(str2, m7717G() + "called Robot onDestroyed, release logging now.");
            m8472b.m8464d();
        }
        INvVideoPlayer iNvVideoPlayer = this.f4873p;
        if (iNvVideoPlayer != null) {
            iNvVideoPlayer.mo8014b();
        }
    }

    @Override // com.navatics.robot.transport.NvCallback
    /* renamed from: a */
    public void mo6276a(RobotStatus robotStatus) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f4865h = robotStatus;
        if (this.f4865h.m8669a()) {
            m7716H();
            return;
        }
        DiveLogManager m8472b = DiveLogManager.m8472b();
        float m8640n = this.f4865h.m8640n();
        if (m8640n > 0.08f && this.f4865h.m8643k() && !m8472b.m8462e()) {
            String str = f4858a;
            WLog.m5850d(str, m7717G() + "Start dive log [depth " + NvValue.m5983a(m8640n) + ", RobotOperationState " + this.f4865h.m8643k() + ", isLogging " + m8472b.m8462e() + "]");
            this.f4863f = false;
            m8472b.m8467c();
        } else if (m8640n < 0.08f && !this.f4865h.m8643k() && m8472b.m8462e() && !this.f4863f) {
            String str2 = f4858a;
            WLog.m5850d(str2, "Robot motor off and depth less than 0.08 [depth " + m8640n + ", motorStatus " + this.f4865h.m8643k() + ", isLogging " + m8472b.m8462e() + ", robotDeactive " + this.f4863f + "]");
            this.f4863f = true;
            this.f4864g = currentTimeMillis;
        } else if (this.f4863f && this.f4865h.m8643k()) {
            this.f4863f = false;
        }
        if (this.f4863f && m8472b.m8462e() && currentTimeMillis - this.f4864g > 120000) {
            String str3 = f4858a;
            WLog.m5850d(str3, m7717G() + "Robot has not been active for " + (currentTimeMillis - this.f4864g) + "ms, release logging now.");
            m8472b.m8464d();
        }
        this.f4862e = currentTimeMillis;
        m7699b(this.f4865h);
        m7696c(this.f4865h);
    }

    /* renamed from: F */
    public void m7718F() {
        long currentTimeMillis = System.currentTimeMillis();
        DiveLogManager m8472b = DiveLogManager.m8472b();
        if (m8472b.m8462e() && currentTimeMillis - this.f4862e > 120000 && m7855e().m6025d().mo5953j()) {
            String str = f4858a;
            WLog.m5850d(str, m7717G() + "stop logging when checking robot status(now=" + m7711a(currentTimeMillis) + ", lastRobotStatusMsgTime=" + m7711a(this.f4862e) + ").");
            this.f4863f = true;
            m8472b.m8464d();
        }
    }

    /* renamed from: G */
    private String m7717G() {
        return "[" + this + "]";
    }

    /* renamed from: a */
    private String m7711a(long j) {
        return this.f4874q.format(new Date(j));
    }

    /* renamed from: f */
    public RobotStatus m7693f() {
        return this.f4865h;
    }

    /* compiled from: NvRobot.java */
    /* renamed from: com.navatics.app.framework.y$1 */
    /* loaded from: classes.dex */
    public class C18581 implements ObservableOnSubscribe<RobotStatus> {
        public static /* synthetic */ void lambda$z4ddsh2C5RZav6VbnoclwB5hnbE(C18581 c18581, RobotStateHandler robotStateHandler) {
            c18581.m7667a(robotStateHandler);
        }

        C18581() {
            NvRobot.this = r1;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(final ObservableEmitter<RobotStatus> observableEmitter) throws Exception {
            if (NvRobot.this.f4865h != null) {
                observableEmitter.onNext(NvRobot.this.f4865h);
            }
            observableEmitter.getClass();
            final RobotStateHandler robotStateHandler = new RobotStateHandler() { // from class: com.navatics.app.framework.-$$Lambda$atvRicc8dFwBcbvXmZJHeIx_uLw
                @Override // com.navatics.app.framework.RobotStateHandler
                public final void onRobotStateUpdate(RobotStatus robotStatus) {
                    ObservableEmitter.this.onNext(robotStatus);
                }
            };
            NvRobot.this.m7708a(robotStateHandler);
            observableEmitter.setCancellable(new Cancellable() { // from class: com.navatics.app.framework.-$$Lambda$y$1$z4ddsh2C5RZav6VbnoclwB5hnbE
                @Override // io.reactivex.p096b.Cancellable
                public final void cancel() {
                    NvRobot.C18581.lambda$z4ddsh2C5RZav6VbnoclwB5hnbE(NvRobot.C18581.this, robotStateHandler);
                }
            });
        }

        /* renamed from: a */
        public /* synthetic */ void m7667a(RobotStateHandler robotStateHandler) throws Exception {
            NvRobot.this.m7700b(robotStateHandler);
        }
    }

    /* renamed from: g */
    public Observable<RobotStatus> m7691g() {
        return Observable.m3097a((ObservableOnSubscribe) new C18581());
    }

    /* renamed from: a */
    public void m7709a(RobotSensorStateHandler robotSensorStateHandler) {
        if (robotSensorStateHandler != null) {
            this.f4869l.add(robotSensorStateHandler);
        }
    }

    /* renamed from: b */
    public void m7701b(RobotSensorStateHandler robotSensorStateHandler) {
        this.f4869l.remove(robotSensorStateHandler);
    }

    /* renamed from: a */
    public void m7708a(RobotStateHandler robotStateHandler) {
        m7707a(robotStateHandler, DispatchStrategy.THREAD_BACKGROUND);
    }

    /* renamed from: a */
    public void m7707a(RobotStateHandler robotStateHandler, DispatchStrategy dispatchStrategy) {
        if (robotStateHandler != null) {
            this.f4867j.add(robotStateHandler);
        }
    }

    /* renamed from: b */
    public void m7700b(RobotStateHandler robotStateHandler) {
        this.f4867j.remove(robotStateHandler);
    }

    /* renamed from: b */
    private void m7699b(RobotStatus robotStatus) {
        for (RobotStateHandler robotStateHandler : this.f4867j) {
            robotStateHandler.onRobotStateUpdate(robotStatus);
        }
    }

    /* renamed from: c */
    private void m7696c(RobotStatus robotStatus) {
        for (RobotSensorStateHandler robotSensorStateHandler : this.f4869l) {
            robotSensorStateHandler.mo8673a(robotStatus.m8628z());
        }
    }

    /* renamed from: H */
    private void m7716H() {
        for (RobotForceUpdateHandler robotForceUpdateHandler : this.f4868k) {
            robotForceUpdateHandler.m8674a();
        }
    }

    /* renamed from: h */
    public String m7689h() {
        INvVideoPlayer iNvVideoPlayer = this.f4873p;
        if (iNvVideoPlayer == null || !(iNvVideoPlayer instanceof NvLocalServerPlayer)) {
            INvVideoPlayer iNvVideoPlayer2 = this.f4873p;
            if (iNvVideoPlayer2 != null) {
                iNvVideoPlayer2.mo8014b();
            }
            this.f4873p = NvLocalServerPlayer.m8379a(m7855e().m6025d());
            this.f4873p.mo8017a();
        }
        return this.f4873p.mo8013c();
    }

    /* renamed from: a */
    public void m7710a(Surface surface) {
        INvVideoPlayer iNvVideoPlayer = this.f4873p;
        if (iNvVideoPlayer != null) {
            iNvVideoPlayer.mo8014b();
        }
        this.f4873p = new NvMediaCodecPlayer(m7855e().m6025d());
        this.f4873p.mo8016a(surface);
        this.f4873p.mo8017a();
    }

    /* renamed from: i */
    public boolean m7687i() {
        return m7855e().m6025d().mo5953j();
    }

    /* renamed from: j */
    public void m7685j() {
        this.f4861d.mo8049a();
        INvVideoPlayer iNvVideoPlayer = this.f4873p;
        if (iNvVideoPlayer != null) {
            iNvVideoPlayer.mo8014b();
            this.f4873p = null;
        }
    }

    /* renamed from: k */
    public NvObservable<Boolean> m7683k() {
        this.f4871n = true;
        this.f4872o = System.currentTimeMillis();
        try {
            this.f4875r = new MPEG4Recorder(new File(m7715I()));
            this.f4873p.mo8015a(this.f4875r);
            return this.f4861d.mo8044b();
        } catch (IOException e) {
            e.printStackTrace();
            return NvReactive.m6294a((Throwable) new IOException("create recorder failed."));
        }
    }

    /* renamed from: l */
    public NvObservable<Boolean> m7682l() {
        this.f4871n = false;
        this.f4872o = 0L;
        this.f4873p.mo8015a((OnH264DataAvailableCallback) null);
        MPEG4Recorder mPEG4Recorder = this.f4875r;
        if (mPEG4Recorder != null) {
            mPEG4Recorder.m8406a();
            this.f4875r = null;
        }
        return this.f4861d.mo8042c();
    }

    /* renamed from: I */
    private String m7715I() {
        File file = new File(Settings.m8618a().m8607e());
        boolean mkdirs = !file.exists() ? file.mkdirs() : true;
        if (!mkdirs || !file.exists() || !file.canWrite()) {
            WLog.m5850d(f4858a, "create record file failed(" + mkdirs + ", " + file.exists() + ", " + file.canWrite() + "). path is : " + file.getAbsolutePath());
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.getDefault());
        return file.getPath() + File.separator + (simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())) + ".mp4");
    }

    /* renamed from: m */
    public boolean m7681m() {
        return this.f4871n;
    }

    /* renamed from: n */
    public long m7680n() {
        return this.f4872o;
    }

    /* renamed from: o */
    public NvObservable<Boolean> m7679o() {
        return this.f4861d.mo8040d();
    }

    /* renamed from: p */
    public NvObservable<RobotVersionInfo> m7678p() {
        return this.f4861d.mo8038e();
    }

    /* renamed from: q */
    public NvObservable<Boolean> m7677q() {
        return this.f4861d.mo8018s();
    }

    /* renamed from: r */
    public boolean m7676r() {
        SensorStatus m8628z;
        return (m7693f() == null || (m8628z = m7693f().m8628z()) == null || (m8628z.m8624b() & 1) == 1) ? false : true;
    }

    /* renamed from: a */
    public NvObservable<Boolean> m7713a(int i) {
        return this.f4861d.mo8048a(i);
    }

    /* renamed from: s */
    public NvObservable<Integer> m7675s() {
        C3044k c3044k = f4859b;
        c3044k.mo1511a((Object) ("conn id " + ((DawnRobotAdapter) this.f4861d).m8675t().mo6410b().m6035a()));
        return this.f4861d.mo8019r();
    }

    /* renamed from: t */
    public NvObservable<Boolean> m7674t() {
        return this.f4861d.mo8036f();
    }

    /* renamed from: u */
    public NvObservable<Boolean> m7673u() {
        return this.f4861d.mo8034g();
    }

    /* renamed from: a */
    public NvObservable<Boolean> m7704a(Map<String, Object> map) {
        return this.f4861d.mo8045a(map);
    }

    /* renamed from: b */
    public void m7702b(int i) {
        if (i < -45) {
            i = -45;
        } else if (i > 45) {
            i = 45;
        }
        this.f4861d.mo8043b(i);
    }

    /* renamed from: c */
    public NvObservable<Boolean> m7697c(int i) {
        return this.f4861d.mo8041c(i);
    }

    /* renamed from: d */
    public NvObservable<Boolean> m7695d(int i) {
        return this.f4861d.mo8039d(i);
    }

    /* renamed from: e */
    public NvObservable<Boolean> m7694e(int i) {
        return this.f4861d.mo8037e(i);
    }

    /* renamed from: f */
    public NvObservable<Boolean> m7692f(int i) {
        return this.f4861d.mo8035f(i);
    }

    /* renamed from: g */
    public NvObservable<Boolean> m7690g(int i) {
        return this.f4861d.mo8033g(i);
    }

    /* renamed from: h */
    public NvObservable<Boolean> m7688h(int i) {
        return this.f4861d.mo8031h(i);
    }

    /* renamed from: i */
    public NvObservable<Boolean> m7686i(int i) {
        return this.f4861d.mo8029i(i);
    }

    /* renamed from: j */
    public NvObservable<Boolean> m7684j(int i) {
        return this.f4861d.mo8027j(i);
    }

    /* renamed from: a */
    public NvObservable<Boolean> m7712a(int i, int i2) {
        return this.f4861d.mo8047a(i, i2);
    }

    /* renamed from: v */
    public NvObservable<Integer> m7672v() {
        return this.f4861d.mo8032h();
    }

    /* renamed from: w */
    public NvObservable<Integer> m7671w() {
        return this.f4861d.mo8030i();
    }

    /* renamed from: x */
    public NvObservable<Integer> m7670x() {
        return this.f4861d.mo8028j();
    }

    /* renamed from: y */
    public NvObservable<Integer> m7669y() {
        return this.f4861d.mo8026k();
    }

    /* renamed from: z */
    public NvObservable<Integer> m7668z() {
        return this.f4861d.mo8025l();
    }

    /* renamed from: A */
    public NvObservable<Integer> m7723A() {
        return this.f4861d.mo8024m();
    }

    /* renamed from: B */
    public NvObservable<Integer> m7722B() {
        return this.f4861d.mo8023n();
    }

    /* renamed from: C */
    public NvObservable<Integer> m7721C() {
        return this.f4861d.mo8022o();
    }

    /* renamed from: D */
    public NvObservable<WhiteBalance> m7720D() {
        return this.f4861d.mo8021p();
    }

    /* renamed from: E */
    public NvObservable<StorageInfo> m7719E() {
        return this.f4861d.mo8020q();
    }
}
