package com.navatics.app.framework.p049a;

import com.navatics.app.framework.INvRobotAdapter;
import com.navatics.app.framework.RobotStatus;
import com.navatics.app.framework.RobotVersionInfo;
import com.navatics.robot.protocol.CalibrateCompassMessage;
import com.navatics.robot.protocol.CalibrateGyroMessage;
import com.navatics.robot.protocol.CameraSettingMessage;
import com.navatics.robot.protocol.Dawn;
import com.navatics.robot.protocol.GetCameraModeMessage;
import com.navatics.robot.protocol.GetCameraModeReply;
import com.navatics.robot.protocol.GetExposureModeReply;
import com.navatics.robot.protocol.GetExposureTargetReply;
import com.navatics.robot.protocol.GetFirmwareVersionMessage;
import com.navatics.robot.protocol.GetFirmwareVersionReply;
import com.navatics.robot.protocol.GetFrameRateReply;
import com.navatics.robot.protocol.GetISOReply;
import com.navatics.robot.protocol.GetResolutionReply;
import com.navatics.robot.protocol.GetSDCardInfoReply;
import com.navatics.robot.protocol.GetShutterSpeedReply;
import com.navatics.robot.protocol.GetWhiteBalanceModeReply;
import com.navatics.robot.protocol.GetWhiteBalanceValueReply;
import com.navatics.robot.protocol.GetWideAngleModeReply;
import com.navatics.robot.protocol.INvProtocol;
import com.navatics.robot.protocol.InputMessage;
import com.navatics.robot.protocol.OutputMessage;
import com.navatics.robot.protocol.ParameterSettingMessage;
import com.navatics.robot.protocol.PitchCtrlMessage;
import com.navatics.robot.protocol.RecordStartMessage;
import com.navatics.robot.protocol.RecordStopMessage;
import com.navatics.robot.protocol.RestartMessage;
import com.navatics.robot.protocol.StatusMessage;
import com.navatics.robot.protocol.StatusResponse;
import com.navatics.robot.protocol.SwitchModeMessage;
import com.navatics.robot.protocol.TakePhotoMessage;
import com.navatics.robot.transport.NvCallback;
import com.navatics.robot.transport.NvSocket;
import com.navatics.robot.transport.StorageInfo;
import com.navatics.robot.transport.WhiteBalance;
import com.navatics.robot.transport.p063b.NvExceptionHandler;
import com.navatics.robot.transport.p063b.NvFunction1;
import com.navatics.robot.transport.p063b.NvObservable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.app.framework.a.b */
/* loaded from: classes.dex */
public class DawnRobotAdapter implements INvRobotAdapter, Dawn.InterfaceC2105a {

    /* renamed from: a */
    private static final C3044k f4194a = C3044k.m1564a(DawnRobotAdapter.class);

    /* renamed from: b */
    private Dawn f4195b;

    /* renamed from: c */
    private RobotStatus f4196c = new RobotStatus();

    /* renamed from: d */
    private NvCallback<RobotStatus> f4197d;

    /* renamed from: e */
    private int f4198e;

    /* renamed from: f */
    private long f4199f;

    /* renamed from: lambda$-s2C0n2_xYA2boZ6WxsDEn4dJBk */
    public static /* synthetic */ void m13048lambda$s2C0n2_xYA2boZ6WxsDEn4dJBk(Dawn.C2106b c2106b, Throwable th) {
        c2106b.m6384e();
    }

    /* renamed from: lambda$7XKz5YsSFwLop1uWe-uKbhVRebc */
    public static /* synthetic */ void m13049lambda$7XKz5YsSFwLop1uWeuKbhVRebc(Dawn.C2106b c2106b, Throwable th) {
        c2106b.m6384e();
    }

    public static /* synthetic */ void lambda$7asfHXIf0kHqhsWpS1nuYIHjQAs(Dawn.C2106b c2106b, Throwable th) {
        c2106b.m6384e();
    }

    public static /* synthetic */ void lambda$8VG7s1Bg2bJ8lbnzzRNlxP30Lrg(Dawn.C2106b c2106b, Throwable th) {
        c2106b.m6384e();
    }

    /* renamed from: lambda$BgYv-6DXxRxPDrTLqXPpcdzCNrs */
    public static /* synthetic */ void m13050lambda$BgYv6DXxRxPDrTLqXPpcdzCNrs(Dawn.C2106b c2106b, Throwable th) {
        c2106b.m6384e();
    }

    /* renamed from: lambda$Bk4bUojuHf7j5JvtxJM-qABy4VI */
    public static /* synthetic */ Integer m13051lambda$Bk4bUojuHf7j5JvtxJMqABy4VI(Dawn.C2106b c2106b, Dawn.C2106b c2106b2) {
        return m8687h(c2106b, c2106b2);
    }

    public static /* synthetic */ void lambda$CSsdFxqkQ3PzmVAT9f1l2_2XIQM(Dawn.C2106b c2106b, Throwable th) {
        c2106b.m6384e();
    }

    public static /* synthetic */ void lambda$Gxc7vYRMkhPw5cEGuPh5rVjGJ8M(Dawn.C2106b c2106b, Throwable th) {
        m8680k(c2106b, th);
    }

    public static /* synthetic */ void lambda$Hx4pOC1MAZex25tgBPkWcXjsWwE(Dawn.C2106b c2106b, Throwable th) {
        c2106b.m6384e();
    }

    public static /* synthetic */ Integer lambda$LZKciDyrLfJQFDlhDxIEOwpcFNE(Dawn.C2106b c2106b, Dawn.C2106b c2106b2) {
        return m8689g(c2106b, c2106b2);
    }

    /* renamed from: lambda$U-ngBTMYKaDJvFeVTD4E8degpyo */
    public static /* synthetic */ WhiteBalance m13052lambda$UngBTMYKaDJvFeVTD4E8degpyo(Dawn.C2106b c2106b, Dawn.C2106b c2106b2) {
        return m8691f(c2106b, c2106b2);
    }

    public static /* synthetic */ void lambda$XU5BRSzEwVHughqLTf140uM6m3o(Dawn.C2106b c2106b, Throwable th) {
        c2106b.m6384e();
    }

    public static /* synthetic */ void lambda$ZcCmNUPCr1tDnw2HJE0aSRnalqw(Dawn.C2106b c2106b, Throwable th) {
        c2106b.m6384e();
    }

    /* renamed from: lambda$b0vQQ-1qYvjtZj1QVe_jed2ozIc */
    public static /* synthetic */ Boolean m13053lambda$b0vQQ1qYvjtZj1QVe_jed2ozIc(Dawn.C2106b c2106b, Dawn.C2106b c2106b2) {
        return m8677m(c2106b, c2106b2);
    }

    public static /* synthetic */ Integer lambda$euF7Ip7Bb5JJGokLFs9ewg6ZgiI(Dawn.C2106b c2106b, Dawn.C2106b c2106b2) {
        return m8681k(c2106b, c2106b2);
    }

    public static /* synthetic */ Integer lambda$iCJR5_HifmMRzbdD_tm43kSgP8c(Dawn.C2106b c2106b, Dawn.C2106b c2106b2) {
        return m8699b(c2106b, c2106b2);
    }

    public static /* synthetic */ Integer lambda$jk6_r74H1mPqAGupyyQxzyPcS9g(Dawn.C2106b c2106b, Dawn.C2106b c2106b2) {
        return m8683j(c2106b, c2106b2);
    }

    /* renamed from: lambda$kP2Gm6x_pIyVOB-J0ERIdHzBo2s */
    public static /* synthetic */ Integer m13054lambda$kP2Gm6x_pIyVOBJ0ERIdHzBo2s(Dawn.C2106b c2106b, Dawn.C2106b c2106b2) {
        return m8695d(c2106b, c2106b2);
    }

    /* renamed from: lambda$kgj4aYj9s32HG7rRMeYrxu7gv-Y */
    public static /* synthetic */ Integer m13055lambda$kgj4aYj9s32HG7rRMeYrxu7gvY(Dawn.C2106b c2106b, Dawn.C2106b c2106b2) {
        return m8701a(c2106b, c2106b2);
    }

    public static /* synthetic */ void lambda$lHNZh6bK9KeZQzjPOCXBPApz8qw(Dawn.C2106b c2106b, Throwable th) {
        c2106b.m6384e();
    }

    /* renamed from: lambda$lKQRYfknH9i-PXGuxqOA2S_dEIc */
    public static /* synthetic */ StorageInfo m13056lambda$lKQRYfknH9iPXGuxqOA2S_dEIc(Dawn.C2106b c2106b, Dawn.C2106b c2106b2) {
        return m8693e(c2106b, c2106b2);
    }

    public static /* synthetic */ void lambda$s_0A2aty6b6cz8QiiLxcACO8ioQ(Dawn.C2106b c2106b, Throwable th) {
        c2106b.m6384e();
    }

    /* renamed from: lambda$sxKv8yIy2Z1lt7Ad9d0-PP45brU */
    public static /* synthetic */ Integer m13057lambda$sxKv8yIy2Z1lt7Ad9d0PP45brU(Dawn.C2106b c2106b, Dawn.C2106b c2106b2) {
        return m8685i(c2106b, c2106b2);
    }

    public static /* synthetic */ RobotVersionInfo lambda$vKmvY1dTCxhoDY2UNIBqvfFgq4E(Dawn.C2106b c2106b, Dawn.C2106b c2106b2) {
        return m8679l(c2106b, c2106b2);
    }

    public static /* synthetic */ void lambda$yEhPSglH96HtiTb2ECYo72XsIhE(Dawn.C2106b c2106b, Throwable th) {
        c2106b.m6384e();
    }

    public static /* synthetic */ Integer lambda$zZIhWYZMI9OOBCtJB586xD37vvQ(Dawn.C2106b c2106b, Dawn.C2106b c2106b2) {
        return m8697c(c2106b, c2106b2);
    }

    public DawnRobotAdapter(Dawn dawn) {
        this.f4195b = dawn;
        dawn.m6416a(this);
        dawn.m6402c(this);
    }

    /* renamed from: t */
    public INvProtocol m8675t() {
        return this.f4195b;
    }

    @Override // com.navatics.app.framework.INvRobotAdapter
    /* renamed from: a */
    public void mo8046a(NvCallback<RobotStatus> nvCallback) {
        this.f4197d = nvCallback;
    }

    @Override // com.navatics.app.framework.INvRobotAdapter
    /* renamed from: s */
    public NvObservable<Boolean> mo8018s() {
        return m8702a(RestartMessage.m6510c());
    }

    @Override // com.navatics.robot.protocol.Dawn.InterfaceC2105a
    /* renamed from: a */
    public void mo6393a(InputMessage inputMessage) {
        int k = inputMessage.m6503k();
        if (k != 35) {
            if (k != 254) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.f4196c.m8669a()) {
                this.f4198e++;
            }
            if (this.f4198e > 3) {
                this.f4196c.m8663a(true);
            }
            this.f4199f = currentTimeMillis;
            return;
        }
        StatusMessage statusMessage = (StatusMessage) inputMessage;
        this.f4196c.m8666a(System.currentTimeMillis());
        this.f4196c.m8664a(statusMessage.m6501b(), statusMessage.m6499c(), statusMessage.m6498d(), statusMessage.m6497f());
        this.f4196c.m8659b(statusMessage.m6496h(), statusMessage.m6495i(), statusMessage.m6494l(), statusMessage.m6493m());
        this.f4196c.m8660b(statusMessage.m6492n());
        this.f4196c.m8657c(statusMessage.m6491o());
        this.f4196c.m8656c((short) statusMessage.m6490p(), (short) statusMessage.m6489q(), (short) statusMessage.m6488r(), (short) statusMessage.m6487s());
        this.f4196c.m8654d(statusMessage.m6486t());
        this.f4196c.m8652e(statusMessage.m6485u());
        this.f4196c.m8650f(statusMessage.m6484v());
        this.f4196c.m8648g(statusMessage.m6483w());
        this.f4196c.m8646h(statusMessage.m6482x());
        int m6483w = statusMessage.m6483w();
        this.f4196c.m8667a(m6483w & 1, (m6483w & 4) >> 2, (m6483w & 2) >> 1, (m6483w & 8) >> 3);
        this.f4196c.m8662a((statusMessage.m6482x() & 1) == 1, statusMessage.m6490p(), statusMessage.m6489q(), statusMessage.m6488r(), statusMessage.m6487s());
        NvCallback<RobotStatus> nvCallback = this.f4197d;
        if (nvCallback != null) {
            nvCallback.mo6276a(this.f4196c);
        }
    }

    @Override // com.navatics.app.framework.INvRobotAdapter
    /* renamed from: a */
    public void mo8049a() {
        NvSocket mo6410b = this.f4195b.mo6410b();
        if (mo6410b.m6025d() == null) {
            return;
        }
        mo6410b.m6025d().mo6055e();
    }

    /* renamed from: a */
    private NvObservable<Boolean> m8702a(OutputMessage outputMessage) {
        final Dawn.C2106b m6417a = this.f4195b.m6417a(outputMessage);
        return m6417a.m6323a(new NvFunction1() { // from class: com.navatics.app.framework.a.-$$Lambda$b$b0vQQ-1qYvjtZj1QVe_jed2ozIc
            @Override // com.navatics.robot.transport.p063b.NvFunction1
            public final Object apply(Object obj) {
                return DawnRobotAdapter.m13053lambda$b0vQQ1qYvjtZj1QVe_jed2ozIc(Dawn.C2106b.this, (Dawn.C2106b) obj);
            }
        }).mo6314a(new NvExceptionHandler() { // from class: com.navatics.app.framework.a.-$$Lambda$b$7XKz5YsSFwLop1uWe-uKbhVRebc
            @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
            public final void onError(Throwable th) {
                DawnRobotAdapter.m13049lambda$7XKz5YsSFwLop1uWeuKbhVRebc(Dawn.C2106b.this, th);
            }
        });
    }

    /* renamed from: m */
    public static /* synthetic */ Boolean m8677m(Dawn.C2106b c2106b, Dawn.C2106b c2106b2) throws Exception {
        InputMessage m6386c = c2106b2.m6386c();
        if (!(m6386c instanceof StatusResponse)) {
            throw new Exception();
        }
        boolean z = m6386c.mo6451e() == 0;
        c2106b.m6384e();
        return Boolean.valueOf(z);
    }

    @Override // com.navatics.app.framework.INvRobotAdapter
    /* renamed from: b */
    public NvObservable<Boolean> mo8044b() {
        return m8702a(RecordStartMessage.m6523c());
    }

    @Override // com.navatics.app.framework.INvRobotAdapter
    /* renamed from: c */
    public NvObservable<Boolean> mo8042c() {
        return m8702a(RecordStopMessage.m6521c());
    }

    @Override // com.navatics.app.framework.INvRobotAdapter
    /* renamed from: d */
    public NvObservable<Boolean> mo8040d() {
        return m8702a(TakePhotoMessage.m6478c());
    }

    @Override // com.navatics.app.framework.INvRobotAdapter
    /* renamed from: e */
    public NvObservable<RobotVersionInfo> mo8038e() {
        final Dawn.C2106b m6417a = this.f4195b.m6417a(GetFirmwareVersionMessage.m6367c());
        return m6417a.m6323a(new NvFunction1() { // from class: com.navatics.app.framework.a.-$$Lambda$b$vKmvY1dTCxhoDY2UNIBqvfFgq4E
            @Override // com.navatics.robot.transport.p063b.NvFunction1
            public final Object apply(Object obj) {
                return DawnRobotAdapter.lambda$vKmvY1dTCxhoDY2UNIBqvfFgq4E(Dawn.C2106b.this, (Dawn.C2106b) obj);
            }
        }).mo6314a(new NvExceptionHandler() { // from class: com.navatics.app.framework.a.-$$Lambda$b$8VG7s1Bg2bJ8lbnzzRNlxP30Lrg
            @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
            public final void onError(Throwable th) {
                DawnRobotAdapter.lambda$8VG7s1Bg2bJ8lbnzzRNlxP30Lrg(Dawn.C2106b.this, th);
            }
        });
    }

    /* renamed from: l */
    public static /* synthetic */ RobotVersionInfo m8679l(Dawn.C2106b c2106b, Dawn.C2106b c2106b2) throws Exception {
        InputMessage m6386c = c2106b2.m6386c();
        if (!(m6386c instanceof GetFirmwareVersionReply)) {
            throw new Exception("Expect GetFirmwareVersionReply but we got " + m6386c.getClass().getSimpleName());
        }
        GetFirmwareVersionReply getFirmwareVersionReply = (GetFirmwareVersionReply) m6386c;
        RobotVersionInfo robotVersionInfo = new RobotVersionInfo(1, getFirmwareVersionReply.m6365c(), getFirmwareVersionReply.m6364d(), getFirmwareVersionReply.m6363f());
        C3044k c3044k = f4194a;
        c3044k.mo1500c((Object) ("Get Robot Version : " + robotVersionInfo));
        c2106b.m6384e();
        return robotVersionInfo;
    }

    @Override // com.navatics.app.framework.INvRobotAdapter
    /* renamed from: a */
    public NvObservable<Boolean> mo8048a(int i) {
        return m8702a(SwitchModeMessage.m6480a(i));
    }

    @Override // com.navatics.app.framework.INvRobotAdapter
    /* renamed from: f */
    public NvObservable<Boolean> mo8036f() {
        return m8702a(CalibrateCompassMessage.m6448c());
    }

    @Override // com.navatics.app.framework.INvRobotAdapter
    /* renamed from: g */
    public NvObservable<Boolean> mo8034g() {
        return m8702a(CalibrateGyroMessage.m6446c());
    }

    @Override // com.navatics.app.framework.INvRobotAdapter
    /* renamed from: a */
    public NvObservable<Boolean> mo8045a(Map<String, Object> map) {
        return m8702a(ParameterSettingMessage.m6527a(map));
    }

    @Override // com.navatics.app.framework.INvRobotAdapter
    /* renamed from: b */
    public void mo8043b(int i) {
        try {
            this.f4195b.m6408b(PitchCtrlMessage.m6525a(i));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // com.navatics.app.framework.INvRobotAdapter
    /* renamed from: c */
    public NvObservable<Boolean> mo8041c(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("key_res", Integer.valueOf(i));
        return m8702a(CameraSettingMessage.m6443a(1, 0, hashMap));
    }

    @Override // com.navatics.app.framework.INvRobotAdapter
    /* renamed from: d */
    public NvObservable<Boolean> mo8039d(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("key_fps", Integer.valueOf(i));
        return m8702a(CameraSettingMessage.m6443a(2, 0, hashMap));
    }

    @Override // com.navatics.app.framework.INvRobotAdapter
    /* renamed from: e */
    public NvObservable<Boolean> mo8037e(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("key_fov", Integer.valueOf(i));
        return m8702a(CameraSettingMessage.m6443a(3, 0, hashMap));
    }

    @Override // com.navatics.app.framework.INvRobotAdapter
    /* renamed from: f */
    public NvObservable<Boolean> mo8035f(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("key_exposure_mode", Integer.valueOf(i));
        return m8702a(CameraSettingMessage.m6443a(7, 0, hashMap));
    }

    @Override // com.navatics.app.framework.INvRobotAdapter
    /* renamed from: g */
    public NvObservable<Boolean> mo8033g(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("key_exposure_target", Integer.valueOf(i));
        return m8702a(CameraSettingMessage.m6443a(9, 0, hashMap));
    }

    @Override // com.navatics.app.framework.INvRobotAdapter
    /* renamed from: h */
    public NvObservable<Boolean> mo8031h(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("key_shutter_speed", Integer.valueOf(i));
        return m8702a(CameraSettingMessage.m6443a(8, 0, hashMap));
    }

    @Override // com.navatics.app.framework.INvRobotAdapter
    /* renamed from: i */
    public NvObservable<Boolean> mo8029i(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("key_iso_value", Integer.valueOf(i));
        return m8702a(CameraSettingMessage.m6443a(13, 0, hashMap));
    }

    @Override // com.navatics.app.framework.INvRobotAdapter
    /* renamed from: j */
    public NvObservable<Boolean> mo8027j(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("key_wb_mode", Integer.valueOf(i));
        return m8702a(CameraSettingMessage.m6443a(10, 0, hashMap));
    }

    @Override // com.navatics.app.framework.INvRobotAdapter
    /* renamed from: a */
    public NvObservable<Boolean> mo8047a(int i, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("key_wb_red_channel_value", Integer.valueOf(i));
        hashMap.put("key_wb_blue_channel_value", Integer.valueOf(i2));
        return m8702a(CameraSettingMessage.m6443a(11, 0, hashMap));
    }

    @Override // com.navatics.app.framework.INvRobotAdapter
    /* renamed from: h */
    public NvObservable<Integer> mo8032h() {
        final Dawn.C2106b m6417a = this.f4195b.m6417a(CameraSettingMessage.m6443a(1, 1, null));
        return m6417a.m6323a(new NvFunction1() { // from class: com.navatics.app.framework.a.-$$Lambda$b$euF7Ip7Bb5JJGokLFs9ewg6ZgiI
            @Override // com.navatics.robot.transport.p063b.NvFunction1
            public final Object apply(Object obj) {
                return DawnRobotAdapter.lambda$euF7Ip7Bb5JJGokLFs9ewg6ZgiI(Dawn.C2106b.this, (Dawn.C2106b) obj);
            }
        }).mo6314a(new NvExceptionHandler() { // from class: com.navatics.app.framework.a.-$$Lambda$b$Gxc7vYRMkhPw5cEGuPh5rVjGJ8M
            @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
            public final void onError(Throwable th) {
                DawnRobotAdapter.lambda$Gxc7vYRMkhPw5cEGuPh5rVjGJ8M(Dawn.C2106b.this, th);
            }
        });
    }

    /* renamed from: k */
    public static /* synthetic */ Integer m8681k(Dawn.C2106b c2106b, Dawn.C2106b c2106b2) throws Exception {
        f4194a.mo1511a((Object) "Transaction_DEBUG getResolution map");
        InputMessage m6386c = c2106b2.m6386c();
        if (!(m6386c instanceof GetResolutionReply)) {
            C3044k c3044k = f4194a;
            c3044k.mo1504b((Object) ("Transaction_DEBUG inputMessage not GetResolutionReply :" + m6386c.getClass().getSimpleName()));
            throw new Exception("inputMessage not GetResolutionReply");
        }
        int m6360c = ((GetResolutionReply) m6386c).m6360c();
        c2106b.m6384e();
        f4194a.mo1511a((Object) "Transaction_DEBUG getResolution done.");
        return Integer.valueOf(m6360c);
    }

    /* renamed from: k */
    public static /* synthetic */ void m8680k(Dawn.C2106b c2106b, Throwable th) {
        f4194a.mo1511a((Object) "Transaction_DEBUG getResolution doOnError");
        c2106b.m6384e();
    }

    @Override // com.navatics.app.framework.INvRobotAdapter
    /* renamed from: i */
    public NvObservable<Integer> mo8030i() {
        final Dawn.C2106b m6417a = this.f4195b.m6417a(CameraSettingMessage.m6443a(2, 1, null));
        return m6417a.m6323a(new NvFunction1() { // from class: com.navatics.app.framework.a.-$$Lambda$b$jk6_r74H1mPqAGupyyQxzyPcS9g
            @Override // com.navatics.robot.transport.p063b.NvFunction1
            public final Object apply(Object obj) {
                return DawnRobotAdapter.lambda$jk6_r74H1mPqAGupyyQxzyPcS9g(Dawn.C2106b.this, (Dawn.C2106b) obj);
            }
        }).mo6314a(new NvExceptionHandler() { // from class: com.navatics.app.framework.a.-$$Lambda$b$7asfHXIf0kHqhsWpS1nuYIHjQAs
            @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
            public final void onError(Throwable th) {
                DawnRobotAdapter.lambda$7asfHXIf0kHqhsWpS1nuYIHjQAs(Dawn.C2106b.this, th);
            }
        });
    }

    /* renamed from: j */
    public static /* synthetic */ Integer m8683j(Dawn.C2106b c2106b, Dawn.C2106b c2106b2) throws Exception {
        InputMessage m6386c = c2106b2.m6386c();
        if (!(m6386c instanceof GetFrameRateReply)) {
            throw new Exception();
        }
        int m6362c = ((GetFrameRateReply) m6386c).m6362c();
        c2106b.m6384e();
        return Integer.valueOf(m6362c);
    }

    @Override // com.navatics.app.framework.INvRobotAdapter
    /* renamed from: k */
    public NvObservable<Integer> mo8026k() {
        final Dawn.C2106b m6417a = this.f4195b.m6417a(CameraSettingMessage.m6443a(7, 1, null));
        return m6417a.m6323a(new NvFunction1() { // from class: com.navatics.app.framework.a.-$$Lambda$b$sxKv8yIy2Z1lt7Ad9d0-PP45brU
            @Override // com.navatics.robot.transport.p063b.NvFunction1
            public final Object apply(Object obj) {
                return DawnRobotAdapter.m13057lambda$sxKv8yIy2Z1lt7Ad9d0PP45brU(Dawn.C2106b.this, (Dawn.C2106b) obj);
            }
        }).mo6314a(new NvExceptionHandler() { // from class: com.navatics.app.framework.a.-$$Lambda$b$lHNZh6bK9KeZQzjPOCXBPApz8qw
            @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
            public final void onError(Throwable th) {
                DawnRobotAdapter.lambda$lHNZh6bK9KeZQzjPOCXBPApz8qw(Dawn.C2106b.this, th);
            }
        });
    }

    /* renamed from: i */
    public static /* synthetic */ Integer m8685i(Dawn.C2106b c2106b, Dawn.C2106b c2106b2) throws Exception {
        InputMessage m6386c = c2106b2.m6386c();
        if (!(m6386c instanceof GetExposureModeReply)) {
            throw new Exception();
        }
        int m6371c = ((GetExposureModeReply) m6386c).m6371c();
        c2106b.m6384e();
        return Integer.valueOf(m6371c);
    }

    @Override // com.navatics.app.framework.INvRobotAdapter
    /* renamed from: l */
    public NvObservable<Integer> mo8025l() {
        final Dawn.C2106b m6417a = this.f4195b.m6417a(CameraSettingMessage.m6443a(9, 1, null));
        return m6417a.m6323a(new NvFunction1() { // from class: com.navatics.app.framework.a.-$$Lambda$b$Bk4bUojuHf7j5JvtxJM-qABy4VI
            @Override // com.navatics.robot.transport.p063b.NvFunction1
            public final Object apply(Object obj) {
                return DawnRobotAdapter.m13051lambda$Bk4bUojuHf7j5JvtxJMqABy4VI(Dawn.C2106b.this, (Dawn.C2106b) obj);
            }
        }).mo6314a(new NvExceptionHandler() { // from class: com.navatics.app.framework.a.-$$Lambda$b$yEhPSglH96HtiTb2ECYo72XsIhE
            @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
            public final void onError(Throwable th) {
                DawnRobotAdapter.lambda$yEhPSglH96HtiTb2ECYo72XsIhE(Dawn.C2106b.this, th);
            }
        });
    }

    /* renamed from: h */
    public static /* synthetic */ Integer m8687h(Dawn.C2106b c2106b, Dawn.C2106b c2106b2) throws Exception {
        InputMessage m6386c = c2106b2.m6386c();
        if (!(m6386c instanceof GetExposureTargetReply)) {
            throw new Exception();
        }
        int m6370c = ((GetExposureTargetReply) m6386c).m6370c();
        c2106b.m6384e();
        return Integer.valueOf(m6370c);
    }

    @Override // com.navatics.app.framework.INvRobotAdapter
    /* renamed from: o */
    public NvObservable<Integer> mo8022o() {
        final Dawn.C2106b m6417a = this.f4195b.m6417a(CameraSettingMessage.m6443a(10, 1, null));
        return m6417a.m6323a(new NvFunction1() { // from class: com.navatics.app.framework.a.-$$Lambda$b$LZKciDyrLfJQFDlhDxIEOwpcFNE
            @Override // com.navatics.robot.transport.p063b.NvFunction1
            public final Object apply(Object obj) {
                return DawnRobotAdapter.lambda$LZKciDyrLfJQFDlhDxIEOwpcFNE(Dawn.C2106b.this, (Dawn.C2106b) obj);
            }
        }).mo6314a(new NvExceptionHandler() { // from class: com.navatics.app.framework.a.-$$Lambda$b$BgYv-6DXxRxPDrTLqXPpcdzCNrs
            @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
            public final void onError(Throwable th) {
                DawnRobotAdapter.m13050lambda$BgYv6DXxRxPDrTLqXPpcdzCNrs(Dawn.C2106b.this, th);
            }
        });
    }

    /* renamed from: g */
    public static /* synthetic */ Integer m8689g(Dawn.C2106b c2106b, Dawn.C2106b c2106b2) throws Exception {
        InputMessage m6386c = c2106b2.m6386c();
        if (!(m6386c instanceof GetWhiteBalanceModeReply)) {
            throw new Exception();
        }
        int m6356c = ((GetWhiteBalanceModeReply) m6386c).m6356c();
        c2106b.m6384e();
        return Integer.valueOf(m6356c);
    }

    @Override // com.navatics.app.framework.INvRobotAdapter
    /* renamed from: p */
    public NvObservable<WhiteBalance> mo8021p() {
        final Dawn.C2106b m6417a = this.f4195b.m6417a(CameraSettingMessage.m6443a(11, 1, null));
        return m6417a.m6323a(new NvFunction1() { // from class: com.navatics.app.framework.a.-$$Lambda$b$U-ngBTMYKaDJvFeVTD4E8degpyo
            @Override // com.navatics.robot.transport.p063b.NvFunction1
            public final Object apply(Object obj) {
                return DawnRobotAdapter.m13052lambda$UngBTMYKaDJvFeVTD4E8degpyo(Dawn.C2106b.this, (Dawn.C2106b) obj);
            }
        }).mo6314a(new NvExceptionHandler() { // from class: com.navatics.app.framework.a.-$$Lambda$b$-s2C0n2_xYA2boZ6WxsDEn4dJBk
            @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
            public final void onError(Throwable th) {
                DawnRobotAdapter.m13048lambda$s2C0n2_xYA2boZ6WxsDEn4dJBk(Dawn.C2106b.this, th);
            }
        });
    }

    /* renamed from: f */
    public static /* synthetic */ WhiteBalance m8691f(Dawn.C2106b c2106b, Dawn.C2106b c2106b2) throws Exception {
        InputMessage m6386c = c2106b2.m6386c();
        if (!(m6386c instanceof GetWhiteBalanceValueReply)) {
            throw new Exception();
        }
        GetWhiteBalanceValueReply getWhiteBalanceValueReply = (GetWhiteBalanceValueReply) m6386c;
        WhiteBalance whiteBalance = new WhiteBalance(getWhiteBalanceValueReply.m6354c(), getWhiteBalanceValueReply.m6353d());
        c2106b.m6384e();
        return whiteBalance;
    }

    @Override // com.navatics.app.framework.INvRobotAdapter
    /* renamed from: q */
    public NvObservable<StorageInfo> mo8020q() {
        final Dawn.C2106b m6417a = this.f4195b.m6417a(CameraSettingMessage.m6443a(6, 1, null));
        return m6417a.m6323a(new NvFunction1() { // from class: com.navatics.app.framework.a.-$$Lambda$b$lKQRYfknH9i-PXGuxqOA2S_dEIc
            @Override // com.navatics.robot.transport.p063b.NvFunction1
            public final Object apply(Object obj) {
                return DawnRobotAdapter.m13056lambda$lKQRYfknH9iPXGuxqOA2S_dEIc(Dawn.C2106b.this, (Dawn.C2106b) obj);
            }
        }).mo6314a(new NvExceptionHandler() { // from class: com.navatics.app.framework.a.-$$Lambda$b$s_0A2aty6b6cz8QiiLxcACO8ioQ
            @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
            public final void onError(Throwable th) {
                DawnRobotAdapter.lambda$s_0A2aty6b6cz8QiiLxcACO8ioQ(Dawn.C2106b.this, th);
            }
        });
    }

    /* renamed from: e */
    public static /* synthetic */ StorageInfo m8693e(Dawn.C2106b c2106b, Dawn.C2106b c2106b2) throws Exception {
        InputMessage m6386c = c2106b2.m6386c();
        if (!(m6386c instanceof GetSDCardInfoReply)) {
            throw new Exception();
        }
        GetSDCardInfoReply getSDCardInfoReply = (GetSDCardInfoReply) m6386c;
        c2106b.m6384e();
        return new StorageInfo(getSDCardInfoReply.m6359c(), getSDCardInfoReply.m6358d());
    }

    @Override // com.navatics.app.framework.INvRobotAdapter
    /* renamed from: j */
    public NvObservable<Integer> mo8028j() {
        final Dawn.C2106b m6417a = this.f4195b.m6417a(CameraSettingMessage.m6443a(3, 1, null));
        return m6417a.m6323a(new NvFunction1() { // from class: com.navatics.app.framework.a.-$$Lambda$b$kP2Gm6x_pIyVOB-J0ERIdHzBo2s
            @Override // com.navatics.robot.transport.p063b.NvFunction1
            public final Object apply(Object obj) {
                return DawnRobotAdapter.m13054lambda$kP2Gm6x_pIyVOBJ0ERIdHzBo2s(Dawn.C2106b.this, (Dawn.C2106b) obj);
            }
        }).mo6314a(new NvExceptionHandler() { // from class: com.navatics.app.framework.a.-$$Lambda$b$XU5BRSzEwVHughqLTf140uM6m3o
            @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
            public final void onError(Throwable th) {
                DawnRobotAdapter.lambda$XU5BRSzEwVHughqLTf140uM6m3o(Dawn.C2106b.this, th);
            }
        });
    }

    /* renamed from: d */
    public static /* synthetic */ Integer m8695d(Dawn.C2106b c2106b, Dawn.C2106b c2106b2) throws Exception {
        InputMessage m6386c = c2106b2.m6386c();
        if (!(m6386c instanceof GetWideAngleModeReply)) {
            throw new Exception();
        }
        int m6535c = ((GetWideAngleModeReply) m6386c).m6535c();
        c2106b.m6384e();
        return Integer.valueOf(m6535c);
    }

    @Override // com.navatics.app.framework.INvRobotAdapter
    /* renamed from: m */
    public NvObservable<Integer> mo8024m() {
        final Dawn.C2106b m6417a = this.f4195b.m6417a(CameraSettingMessage.m6443a(8, 1, null));
        return m6417a.m6323a(new NvFunction1() { // from class: com.navatics.app.framework.a.-$$Lambda$b$zZIhWYZMI9OOBCtJB586xD37vvQ
            @Override // com.navatics.robot.transport.p063b.NvFunction1
            public final Object apply(Object obj) {
                return DawnRobotAdapter.lambda$zZIhWYZMI9OOBCtJB586xD37vvQ(Dawn.C2106b.this, (Dawn.C2106b) obj);
            }
        }).mo6314a(new NvExceptionHandler() { // from class: com.navatics.app.framework.a.-$$Lambda$b$ZcCmNUPCr1tDnw2HJE0aSRnalqw
            @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
            public final void onError(Throwable th) {
                DawnRobotAdapter.lambda$ZcCmNUPCr1tDnw2HJE0aSRnalqw(Dawn.C2106b.this, th);
            }
        });
    }

    /* renamed from: c */
    public static /* synthetic */ Integer m8697c(Dawn.C2106b c2106b, Dawn.C2106b c2106b2) throws Exception {
        InputMessage m6386c = c2106b2.m6386c();
        if (!(m6386c instanceof GetShutterSpeedReply)) {
            throw new Exception();
        }
        int m6357c = ((GetShutterSpeedReply) m6386c).m6357c();
        c2106b.m6384e();
        return Integer.valueOf(m6357c);
    }

    @Override // com.navatics.app.framework.INvRobotAdapter
    /* renamed from: n */
    public NvObservable<Integer> mo8023n() {
        final Dawn.C2106b m6417a = this.f4195b.m6417a(CameraSettingMessage.m6443a(13, 1, null));
        return m6417a.m6323a(new NvFunction1() { // from class: com.navatics.app.framework.a.-$$Lambda$b$iCJR5_HifmMRzbdD_tm43kSgP8c
            @Override // com.navatics.robot.transport.p063b.NvFunction1
            public final Object apply(Object obj) {
                return DawnRobotAdapter.lambda$iCJR5_HifmMRzbdD_tm43kSgP8c(Dawn.C2106b.this, (Dawn.C2106b) obj);
            }
        }).mo6314a(new NvExceptionHandler() { // from class: com.navatics.app.framework.a.-$$Lambda$b$Hx4pOC1MAZex25tgBPkWcXjsWwE
            @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
            public final void onError(Throwable th) {
                DawnRobotAdapter.lambda$Hx4pOC1MAZex25tgBPkWcXjsWwE(Dawn.C2106b.this, th);
            }
        });
    }

    /* renamed from: b */
    public static /* synthetic */ Integer m8699b(Dawn.C2106b c2106b, Dawn.C2106b c2106b2) throws Exception {
        InputMessage m6386c = c2106b2.m6386c();
        if (!(m6386c instanceof GetISOReply)) {
            throw new Exception();
        }
        int m6361c = ((GetISOReply) m6386c).m6361c();
        c2106b.m6384e();
        return Integer.valueOf(m6361c);
    }

    @Override // com.navatics.app.framework.INvRobotAdapter
    /* renamed from: r */
    public NvObservable<Integer> mo8019r() {
        final Dawn.C2106b m6417a = this.f4195b.m6417a(GetCameraModeMessage.m6374c());
        return m6417a.m6323a(new NvFunction1() { // from class: com.navatics.app.framework.a.-$$Lambda$b$kgj4aYj9s32HG7rRMeYrxu7gv-Y
            @Override // com.navatics.robot.transport.p063b.NvFunction1
            public final Object apply(Object obj) {
                return DawnRobotAdapter.m13055lambda$kgj4aYj9s32HG7rRMeYrxu7gvY(Dawn.C2106b.this, (Dawn.C2106b) obj);
            }
        }).mo6314a(new NvExceptionHandler() { // from class: com.navatics.app.framework.a.-$$Lambda$b$CSsdFxqkQ3PzmVAT9f1l2_2XIQM
            @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
            public final void onError(Throwable th) {
                DawnRobotAdapter.lambda$CSsdFxqkQ3PzmVAT9f1l2_2XIQM(Dawn.C2106b.this, th);
            }
        });
    }

    /* renamed from: a */
    public static /* synthetic */ Integer m8701a(Dawn.C2106b c2106b, Dawn.C2106b c2106b2) throws Exception {
        InputMessage m6386c = c2106b2.m6386c();
        if (!(m6386c instanceof GetCameraModeReply)) {
            throw new Exception();
        }
        int m6372c = ((GetCameraModeReply) m6386c).m6372c();
        c2106b.m6384e();
        return Integer.valueOf(m6372c);
    }
}
