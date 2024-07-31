package com.navatics.app.framework.firmware;

import android.content.Context;
import com.navatics.app.framework.Navatics;
import com.navatics.app.framework.NvRobot;
import com.navatics.app.framework.RobotVersionInfo;
import com.navatics.app.framework.firmware.Firmware;
import com.navatics.app.framework.firmware.FirmwareUpdateManager;
import com.navatics.app.framework.user.NvUserManager;
import com.navatics.app.framework.user.Result;
import com.navatics.robot.transport.NvDeviceInfo;
import com.navatics.robot.transport.p063b.NvExceptionHandler;
import com.navatics.robot.transport.p063b.NvObservable;
import com.navatics.robot.transport.p063b.NvObserver;
import com.navatics.robot.utils.C2160n;
import com.senseplay.sdk.SPOta;
import com.senseplay.sdk.model.ota.OtaListener;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.p093a.p095b.AndroidSchedulers;
import io.reactivex.p096b.Consumer;
import io.reactivex.p096b.Function;
import java.io.File;
import java.io.IOException;
import retrofit2.C3204l;

/* renamed from: com.navatics.app.framework.firmware.g */
/* loaded from: classes.dex */
public class FirmwareUpdateManager {

    /* renamed from: b */
    private static volatile FirmwareUpdateManager f4609b;

    /* renamed from: a */
    public InterfaceC1830a f4610a;

    /* renamed from: c */
    private Context f4611c;

    /* renamed from: d */
    private InterfaceC1831b f4612d;

    /* renamed from: e */
    private Disposable f4613e;

    /* compiled from: FirmwareUpdateManager.java */
    /* renamed from: com.navatics.app.framework.firmware.g$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1830a {
        /* renamed from: a */
        void mo8178a(FirmwareUpdateInfo firmwareUpdateInfo);

        /* renamed from: a */
        void mo8177a(Throwable th);
    }

    /* compiled from: FirmwareUpdateManager.java */
    /* renamed from: com.navatics.app.framework.firmware.g$b */
    /* loaded from: classes.dex */
    public interface InterfaceC1831b {
        /* renamed from: a */
        void mo8176a(int i);
    }

    private FirmwareUpdateManager(Context context) {
        this.f4611c = context;
    }

    /* renamed from: a */
    public static FirmwareUpdateManager m8212a(Context context) {
        if (f4609b == null) {
            synchronized (FirmwareUpdateManager.class) {
                if (f4609b == null) {
                    f4609b = new FirmwareUpdateManager(context);
                }
            }
        }
        return f4609b;
    }

    public void registerFirmwareFinishListener(InterfaceC1831b interfaceC1831b) {
        this.f4612d = interfaceC1831b;
    }

    /* renamed from: a */
    public Observable<FirmwareUpdateInfo> m8199a(NvDeviceInfo nvDeviceInfo) {
        this.f4611c.getSharedPreferences("app_settings", 0).edit().putString("Controller", FirmwareUtil.m8172b(nvDeviceInfo.getFirmwareVersionStr())).commit();
        final FirmwareUpdateInfo firmwareUpdateInfo = new FirmwareUpdateInfo();
        firmwareUpdateInfo.m8222c(1);
        firmwareUpdateInfo.m8224b("Controller");
        firmwareUpdateInfo.m8221c(FirmwareUtil.m8172b(nvDeviceInfo.getFirmwareVersionStr()));
        return Observable.m3097a((ObservableOnSubscribe) new ObservableOnSubscribe<FirmwareUpdateInfo>() { // from class: com.navatics.app.framework.firmware.g.1
            {
                FirmwareUpdateManager.this = this;
            }

            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(ObservableEmitter<FirmwareUpdateInfo> observableEmitter) throws Exception {
                observableEmitter.onNext(FirmwareUpdateManager.this.m8197b(firmwareUpdateInfo));
                observableEmitter.onComplete();
            }
        });
    }

    /* renamed from: a */
    public Observable<FirmwareUpdateInfo> m8200a(NvRobot nvRobot) throws IOException {
        FirmwareUpdateInfo firmwareUpdateInfo = new FirmwareUpdateInfo();
        firmwareUpdateInfo.m8224b("MITO");
        firmwareUpdateInfo.m8222c(0);
        return Observable.m3097a((ObservableOnSubscribe) new C18192(nvRobot, firmwareUpdateInfo));
    }

    /* compiled from: FirmwareUpdateManager.java */
    /* renamed from: com.navatics.app.framework.firmware.g$2 */
    /* loaded from: classes.dex */
    public class C18192 implements ObservableOnSubscribe<FirmwareUpdateInfo> {

        /* renamed from: a */
        final /* synthetic */ NvRobot f4616a;

        /* renamed from: b */
        final /* synthetic */ FirmwareUpdateInfo f4617b;

        public static /* synthetic */ void lambda$I5ujL5hnwzFOsAObosB1lWuxBoo(C18192 c18192, ObservableEmitter observableEmitter, FirmwareUpdateInfo firmwareUpdateInfo, Throwable th) {
            c18192.m8190a(observableEmitter, firmwareUpdateInfo, th);
        }

        public static /* synthetic */ void lambda$xqwYM6Y4RA18FKK52EVCb20ZS7Q(C18192 c18192, FirmwareUpdateInfo firmwareUpdateInfo, ObservableEmitter observableEmitter, RobotVersionInfo robotVersionInfo) {
            c18192.m8191a(firmwareUpdateInfo, observableEmitter, robotVersionInfo);
        }

        C18192(NvRobot nvRobot, FirmwareUpdateInfo firmwareUpdateInfo) {
            FirmwareUpdateManager.this = r1;
            this.f4616a = nvRobot;
            this.f4617b = firmwareUpdateInfo;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(final ObservableEmitter<FirmwareUpdateInfo> observableEmitter) throws Exception {
            NvObservable<RobotVersionInfo> m7678p = this.f4616a.m7678p();
            final FirmwareUpdateInfo firmwareUpdateInfo = this.f4617b;
            m7678p.mo6312a(new NvObserver() { // from class: com.navatics.app.framework.firmware.-$$Lambda$g$2$xqwYM6Y4RA18FKK52EVCb20ZS7Q
                @Override // com.navatics.robot.transport.p063b.NvObserver
                public final void onNext(Object obj) {
                    FirmwareUpdateManager.C18192.lambda$xqwYM6Y4RA18FKK52EVCb20ZS7Q(FirmwareUpdateManager.C18192.this, firmwareUpdateInfo, observableEmitter, (RobotVersionInfo) obj);
                }
            }, new NvExceptionHandler() { // from class: com.navatics.app.framework.firmware.-$$Lambda$g$2$I5ujL5hnwzFOsAObosB1lWuxBoo
                @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                public final void onError(Throwable th) {
                    FirmwareUpdateManager.C18192.lambda$I5ujL5hnwzFOsAObosB1lWuxBoo(FirmwareUpdateManager.C18192.this, observableEmitter, firmwareUpdateInfo, th);
                }
            });
        }

        /* renamed from: a */
        public /* synthetic */ void m8191a(FirmwareUpdateInfo firmwareUpdateInfo, ObservableEmitter observableEmitter, RobotVersionInfo robotVersionInfo) throws Exception {
            FirmwareUpdateManager.this.f4611c.getSharedPreferences("app_settings", 0).edit().putString("MITO", FirmwareUpdateManager.this.m8198a(robotVersionInfo.toString())).commit();
            firmwareUpdateInfo.m8221c(robotVersionInfo.toString());
            observableEmitter.onNext(FirmwareUpdateManager.this.m8209a(firmwareUpdateInfo, robotVersionInfo));
            observableEmitter.onComplete();
        }

        /* renamed from: a */
        public /* synthetic */ void m8190a(ObservableEmitter observableEmitter, FirmwareUpdateInfo firmwareUpdateInfo, Throwable th) {
            observableEmitter.onNext(FirmwareUpdateManager.this.m8209a(firmwareUpdateInfo, (RobotVersionInfo) null));
            observableEmitter.onComplete();
        }
    }

    /* renamed from: a */
    public String m8198a(String str) {
        return (str == null || str.length() <= 2) ? "" : str.substring(2);
    }

    /* renamed from: a */
    public FirmwareUpdateInfo m8209a(FirmwareUpdateInfo firmwareUpdateInfo, RobotVersionInfo robotVersionInfo) {
        FirmwareInfo data;
        try {
            C3204l<Result<FirmwareInfo>> mo142a = NvUserManager.m7828b().m7809c(FirmwareUtil.m8175a(1), "RT").mo142a();
            Result<FirmwareInfo> m67e = mo142a.m67e();
            if (!mo142a.m68d() || m67e == null || m67e.getCode() != 0 || (data = m67e.getData()) == null) {
                return firmwareUpdateInfo;
            }
            if (FirmwareUtil.m8174a(data, robotVersionInfo)) {
                firmwareUpdateInfo.m8229a(0);
                firmwareUpdateInfo.m8227a(data.getVersionValue());
                firmwareUpdateInfo.m8219d(data.getRemark());
                firmwareUpdateInfo.m8217e(data.getDownUrl());
            } else {
                firmwareUpdateInfo.m8229a(3);
            }
            return firmwareUpdateInfo;
        } catch (IOException e) {
            e.printStackTrace();
            return firmwareUpdateInfo;
        }
    }

    /* renamed from: b */
    public FirmwareUpdateInfo m8197b(FirmwareUpdateInfo firmwareUpdateInfo) {
        FirmwareInfo data;
        try {
            C3204l<Result<FirmwareInfo>> mo142a = NvUserManager.m7828b().m7809c(FirmwareUtil.m8175a(1), "GD").mo142a();
            Result<FirmwareInfo> m67e = mo142a.m67e();
            if (!mo142a.m68d() || m67e == null || m67e.getCode() != 0 || (data = m67e.getData()) == null) {
                return firmwareUpdateInfo;
            }
            if (!firmwareUpdateInfo.m8223c().equals(FirmwareUtil.m8172b(data.getVersionValue()))) {
                firmwareUpdateInfo.m8229a(0);
                firmwareUpdateInfo.m8227a(FirmwareUtil.m8172b(data.getVersionValue()));
                firmwareUpdateInfo.m8219d(data.getRemark());
                firmwareUpdateInfo.m8217e(data.getDownUrl());
            } else {
                firmwareUpdateInfo.m8229a(3);
            }
            return firmwareUpdateInfo;
        } catch (IOException e) {
            e.printStackTrace();
            return firmwareUpdateInfo;
        }
    }

    /* renamed from: c */
    private Observable<Integer> m8194c(final FirmwareUpdateInfo firmwareUpdateInfo) {
        return Observable.m3097a((ObservableOnSubscribe) new ObservableOnSubscribe<Integer>() { // from class: com.navatics.app.framework.firmware.g.3
            {
                FirmwareUpdateManager.this = this;
            }

            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(final ObservableEmitter<Integer> observableEmitter) throws Exception {
                if (C2160n.m5855a((CharSequence) firmwareUpdateInfo.m8213i())) {
                    observableEmitter.onError(new Throwable("get version info failed"));
                    observableEmitter.onComplete();
                    return;
                }
                String m8173a = FirmwareUtil.m8173a(firmwareUpdateInfo.m8213i());
                String m8213i = firmwareUpdateInfo.m8213i();
                String substring = m8213i.substring(m8213i.indexOf(m8173a));
                DownloadUtil.m8324a(m8173a, substring, FirmwareUpdateManager.this.f4611c.getCacheDir().getAbsolutePath() + "/" + firmwareUpdateInfo.m8226b() + "/" + firmwareUpdateInfo.m8230a() + ".bin", new DownloadListener() { // from class: com.navatics.app.framework.firmware.g.3.1
                    @Override // com.navatics.app.framework.firmware.DownloadListener
                    /* renamed from: a */
                    public void mo8189a() {
                    }

                    {
                        C18203.this = this;
                    }

                    @Override // com.navatics.app.framework.firmware.DownloadListener
                    /* renamed from: a */
                    public void mo8188a(int i) {
                        observableEmitter.onNext(Integer.valueOf((int) (i * 0.2f)));
                    }

                    @Override // com.navatics.app.framework.firmware.DownloadListener
                    /* renamed from: a */
                    public void mo8187a(String str) {
                        observableEmitter.onNext(200);
                        observableEmitter.onComplete();
                    }

                    @Override // com.navatics.app.framework.firmware.DownloadListener
                    /* renamed from: b */
                    public void mo8186b(String str) {
                        observableEmitter.onError(new Throwable("down load failed"));
                        observableEmitter.onComplete();
                    }
                });
            }
        });
    }

    /* renamed from: d */
    private Observable<FirmwareUpdateInfo> m8193d(final FirmwareUpdateInfo firmwareUpdateInfo) {
        final String str = this.f4611c.getCacheDir().getAbsolutePath() + "/" + firmwareUpdateInfo.m8226b() + "/" + firmwareUpdateInfo.m8230a() + ".bin";
        if (new File(str).exists()) {
            return m8208a(firmwareUpdateInfo, str, true);
        }
        return m8194c(firmwareUpdateInfo).m3091a(AndroidSchedulers.m3250a()).m3078b(new Function<Integer, ObservableSource<FirmwareUpdateInfo>>() { // from class: com.navatics.app.framework.firmware.g.4
            {
                FirmwareUpdateManager.this = this;
            }

            @Override // io.reactivex.p096b.Function
            /* renamed from: a */
            public ObservableSource<FirmwareUpdateInfo> apply(Integer num) throws Exception {
                if (num.intValue() == 200 || num.intValue() < 0 || num.intValue() > 100) {
                    return num.intValue() == 200 ? FirmwareUpdateManager.this.m8208a(firmwareUpdateInfo, str, false) : FirmwareUpdateManager.this.m8192e(firmwareUpdateInfo);
                }
                return FirmwareUpdateManager.this.m8210a(firmwareUpdateInfo, num.intValue());
            }
        }).m3069c(m8192e(firmwareUpdateInfo));
    }

    /* renamed from: a */
    public Observable<FirmwareUpdateInfo> m8210a(final FirmwareUpdateInfo firmwareUpdateInfo, final int i) {
        return Observable.m3097a((ObservableOnSubscribe) new ObservableOnSubscribe<FirmwareUpdateInfo>() { // from class: com.navatics.app.framework.firmware.g.5
            {
                FirmwareUpdateManager.this = this;
            }

            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(ObservableEmitter<FirmwareUpdateInfo> observableEmitter) throws Exception {
                firmwareUpdateInfo.m8225b(i);
                firmwareUpdateInfo.m8229a(1);
                observableEmitter.onNext(firmwareUpdateInfo);
            }
        });
    }

    /* renamed from: a */
    public Observable<FirmwareUpdateInfo> m8208a(final FirmwareUpdateInfo firmwareUpdateInfo, final String str, final boolean z) {
        return Observable.m3097a((ObservableOnSubscribe) new ObservableOnSubscribe<FirmwareUpdateInfo>() { // from class: com.navatics.app.framework.firmware.g.6
            {
                FirmwareUpdateManager.this = this;
            }

            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(final ObservableEmitter<FirmwareUpdateInfo> observableEmitter) throws Exception {
                if (firmwareUpdateInfo.m8214h() == 1) {
                    SPOta.getInstance().rcOTA(str, new OtaListener() { // from class: com.navatics.app.framework.firmware.g.6.1
                        {
                            C18246.this = this;
                        }

                        @Override // com.senseplay.sdk.model.ota.OtaListener
                        public void onProcessing(int i) {
                            if (z) {
                                firmwareUpdateInfo.m8225b(i);
                            } else {
                                firmwareUpdateInfo.m8225b(((int) (i * 0.8f)) + 20);
                            }
                            firmwareUpdateInfo.m8229a(1);
                            observableEmitter.onNext(firmwareUpdateInfo);
                        }

                        @Override // com.senseplay.sdk.model.ota.OtaListener
                        public void onResult(boolean z2) {
                            if (z2) {
                                if (FirmwareUpdateManager.this.f4612d != null) {
                                    FirmwareUpdateManager.this.f4612d.mo8176a(1);
                                }
                                firmwareUpdateInfo.m8229a(3);
                                observableEmitter.onNext(firmwareUpdateInfo);
                                observableEmitter.onComplete();
                                return;
                            }
                            firmwareUpdateInfo.m8229a(2);
                            observableEmitter.onNext(firmwareUpdateInfo);
                            observableEmitter.onComplete();
                        }
                    });
                } else if (firmwareUpdateInfo.m8214h() == 0) {
                    Firmware firmware = new Firmware(Navatics.m7930i(), str);
                    if (firmware.m8318a() != 0) {
                        return;
                    }
                    firmware.m8306a(true);
                    firmware.m8317a(new Firmware.InterfaceC1807b() { // from class: com.navatics.app.framework.firmware.g.6.2
                        @Override // com.navatics.app.framework.firmware.Firmware.InterfaceC1807b
                        /* renamed from: a */
                        public void mo8184a() {
                        }

                        {
                            C18246.this = this;
                        }

                        @Override // com.navatics.app.framework.firmware.Firmware.InterfaceC1807b
                        /* renamed from: a */
                        public void mo8183a(long j) {
                            int i = (int) j;
                            if (z) {
                                firmwareUpdateInfo.m8225b(i);
                            } else {
                                firmwareUpdateInfo.m8225b(((int) (i * 0.8f)) + 20);
                            }
                            firmwareUpdateInfo.m8229a(1);
                            observableEmitter.onNext(firmwareUpdateInfo);
                        }

                        @Override // com.navatics.app.framework.firmware.Firmware.InterfaceC1807b
                        /* renamed from: b */
                        public void mo8181b() {
                            if (FirmwareUpdateManager.this.f4612d != null) {
                                FirmwareUpdateManager.this.f4612d.mo8176a(0);
                            }
                            firmwareUpdateInfo.m8229a(3);
                            observableEmitter.onNext(firmwareUpdateInfo);
                            observableEmitter.onComplete();
                        }

                        @Override // com.navatics.app.framework.firmware.Firmware.InterfaceC1807b
                        /* renamed from: a */
                        public void mo8182a(Throwable th) {
                            firmwareUpdateInfo.m8229a(2);
                            observableEmitter.onNext(firmwareUpdateInfo);
                            observableEmitter.onComplete();
                        }
                    });
                }
            }
        });
    }

    /* renamed from: e */
    public Observable<FirmwareUpdateInfo> m8192e(final FirmwareUpdateInfo firmwareUpdateInfo) {
        return Observable.m3097a((ObservableOnSubscribe) new ObservableOnSubscribe<FirmwareUpdateInfo>() { // from class: com.navatics.app.framework.firmware.g.7
            {
                FirmwareUpdateManager.this = this;
            }

            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(ObservableEmitter<FirmwareUpdateInfo> observableEmitter) throws Exception {
                firmwareUpdateInfo.m8229a(2);
            }
        });
    }

    /* renamed from: a */
    public void m8211a(FirmwareUpdateInfo firmwareUpdateInfo) {
        firmwareUpdateInfo.m8229a(1);
        InterfaceC1830a interfaceC1830a = this.f4610a;
        if (interfaceC1830a != null) {
            interfaceC1830a.mo8178a(firmwareUpdateInfo);
        }
        this.f4613e = m8193d(firmwareUpdateInfo).m3091a(AndroidSchedulers.m3250a()).m3107a(new Consumer<FirmwareUpdateInfo>() { // from class: com.navatics.app.framework.firmware.g.8
            {
                FirmwareUpdateManager.this = this;
            }

            @Override // io.reactivex.p096b.Consumer
            /* renamed from: a */
            public void accept(FirmwareUpdateInfo firmwareUpdateInfo2) throws Exception {
                if (FirmwareUpdateManager.this.f4610a != null) {
                    FirmwareUpdateManager.this.f4610a.mo8178a(firmwareUpdateInfo2);
                }
            }
        }, new Consumer<Throwable>() { // from class: com.navatics.app.framework.firmware.g.9
            {
                FirmwareUpdateManager.this = this;
            }

            @Override // io.reactivex.p096b.Consumer
            /* renamed from: a */
            public void accept(Throwable th) throws Exception {
                if (FirmwareUpdateManager.this.f4610a != null) {
                    FirmwareUpdateManager.this.f4610a.mo8177a(th);
                }
            }
        });
    }

    /* renamed from: a */
    public void m8207a(InterfaceC1830a interfaceC1830a) {
        this.f4610a = interfaceC1830a;
    }
}
