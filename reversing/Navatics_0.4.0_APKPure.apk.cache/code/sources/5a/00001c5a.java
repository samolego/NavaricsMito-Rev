package com.navatics.robot.transport.ss;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.graphics.drawable.PathInterpolatorCompat;
import android.support.v4.view.InputDeviceCompat;
import android.util.Log;
import com.navatics.robot.transport.INvGroundStation;
import com.navatics.robot.transport.IoChannel;
import com.navatics.robot.transport.IoHandler;
import com.navatics.robot.transport.KeyMapProvider;
import com.navatics.robot.transport.NvAddress;
import com.navatics.robot.transport.NvAddressExtra;
import com.navatics.robot.transport.NvChannel;
import com.navatics.robot.transport.NvDeviceInfo;
import com.navatics.robot.transport.NvError;
import com.navatics.robot.transport.NvEvent;
import com.navatics.robot.transport.NvEventHandler;
import com.navatics.robot.transport.NvEventLoop;
import com.navatics.robot.transport.NvException;
import com.navatics.robot.transport.NvSelector;
import com.navatics.robot.transport.NvSocket;
import com.navatics.robot.transport.NvTransport;
import com.navatics.robot.transport.NvVideoChannel;
import com.navatics.robot.transport.ProtoMeta;
import com.navatics.robot.transport.TransportType;
import com.navatics.robot.transport.VideoInputStream;
import com.navatics.robot.transport.ss.SensethinkGroundStation;
import com.navatics.robot.utils.StringUtils;
import com.navatics.xlog.WLog;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.SPDevice;
import com.senseplay.sdk.SPRc;
import com.senseplay.sdk.SPSearch;
import com.senseplay.sdk.SPUsb;
import com.senseplay.sdk.bean.CallBackMsg;
import com.senseplay.sdk.cache.DeviceSearchListener;
import com.senseplay.sdk.model.device.BatteryStatus;
import com.senseplay.sdk.model.device.DeviceInfo;
import com.senseplay.sdk.model.device.DeviceUser;
import com.senseplay.sdk.model.device.LinkInfo;
import com.takisoft.fix.support.p059v7.preference.PreferenceFragmentCompatDividers;
import hu.akarnokd.rxjava2.consumers.ObservableConsumers;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.p082a.p084b.AndroidSchedulers;
import io.reactivex.p085b.Consumer;
import io.reactivex.p085b.InterfaceC2824a;
import io.reactivex.p088e.Schedulers;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: SensethinkGroundStation.java */
/* renamed from: com.navatics.robot.transport.ss.d */
/* loaded from: classes2.dex */
public class SensethinkGroundStation implements SharedPreferences.OnSharedPreferenceChangeListener, INvGroundStation {

    /* renamed from: a */
    private static final String f6629a = "d";

    /* renamed from: b */
    private static final Logger logger = Logger.getLogger(SensethinkGroundStation.class);

    /* renamed from: A */
    private Disposable f6631A;

    /* renamed from: B */
    private NvEventHandler f6632B;

    /* renamed from: D */
    private c f6634D;

    /* renamed from: G */
    private LocalKeyMapProvider f6637G;

    /* renamed from: c */
    private boolean enableAuth;

    /* renamed from: d */
    private boolean enableSimulateSenseThinkApi;

    /* renamed from: e */
    private boolean controllerBindResult;

    /* renamed from: f */
    private boolean rollerBindResult;

    /* renamed from: g */
    private boolean alwaysNotifySearchResult;

    /* renamed from: i */
    private long f6644i;

    /* renamed from: j */
    private boolean isAuthenticated;

    /* renamed from: k */
    private boolean remoteBinded;

    /* renamed from: l */
    private boolean f6647l;

    /* renamed from: m */
    private List<ProtoMeta> protoMetas;

    /* renamed from: n */
    private DeviceInfo deviceInfo;

    /* renamed from: o */
    private NvDeviceInfo nvDeviceInfo;

    /* renamed from: p */
    private BatteryStatus baterryStatus;

    /* renamed from: q */
    private int f6652q;

    /* renamed from: r */
    private int f6653r;

    /* renamed from: s */
    private int f6654s;

    /* renamed from: t */
    private long f6655t;

    /* renamed from: u */
    private Disposable controllerConnection;

    /* renamed from: v */
    private Disposable f6657v;

    /* renamed from: w */
    private Disposable f6658w;

    /* renamed from: x */
    private Disposable f6659x;

    /* renamed from: y */
    private Disposable f6660y;

    /* renamed from: z */
    private Disposable f6661z;

    /* renamed from: h */
    private boolean invalid = false;

    /* renamed from: C */
    private HashMap<String, NvDeviceInfo> f6633C = new HashMap<>();

    /* renamed from: E */
    private a f6635E = new a();

    /* renamed from: F */
    private CompositeDisposable f6636F = new CompositeDisposable();

    @Override // com.navatics.robot.transport.INvGroundStation
    /* renamed from: l */
    public int mo6605l() {
        return 1;
    }

    public SensethinkGroundStation(DeviceInfo deviceInfo) {
        if (deviceInfo == null) {
            throw new RuntimeException("rc info is null");
        }
        this.protoMetas = new ArrayList();
        this.protoMetas.add(new ProtoMeta("Dawn", 7));
        this.deviceInfo = deviceInfo;
        this.nvDeviceInfo = new NvDeviceInfo(3, new NvAddress(TransportType.SensethinkWireless, this.deviceInfo.getSerialNo()), String.valueOf(this.deviceInfo.getModelID()), String.valueOf(this.deviceInfo.getManufacturerID()), this.deviceInfo.getSerialNo(), this.deviceInfo.getManufactureDate(), String.valueOf(this.deviceInfo.getHardwareVersion()), String.valueOf(this.deviceInfo.getFirmwareVersion()), this.deviceInfo.getFirmwareVersionStr(), this.protoMetas);
        devSettings();
        logFields();
        SPSearch.getInstance().getLinkInfo(this.f6635E);
    }

    /* renamed from: s */
    private void devSettings() {
        Context context = NvTransport.getContext();
        SharedPreferences sharedPreferences = context.getSharedPreferences("developer_setting", 0);
        this.enableAuth = sharedPreferences.getBoolean("enableAuth", context.getResources().getBoolean(R.bool.enable_auth));
        this.enableSimulateSenseThinkApi = sharedPreferences.getBoolean("enableSimulateSenseThinkApi", context.getResources().getBoolean(R.bool.enable_simulate_sensethink_api));
        this.controllerBindResult = sharedPreferences.getBoolean("controllerBindResult", context.getResources().getBoolean(R.bool.controller_bind_result));
        this.rollerBindResult = sharedPreferences.getBoolean("rollerBindResult", context.getResources().getBoolean(R.bool.roller_bind_result));
        this.alwaysNotifySearchResult = sharedPreferences.getBoolean("alwaysNotifySearchResult", context.getResources().getBoolean(R.bool.always_notify_search_result));
    }

    /* renamed from: t */
    private void logFields() {
        logger.conditionalLog3((Object) ("SimulateSenseThinkSdkApi " + this.enableSimulateSenseThinkApi));
        logger.conditionalLog3((Object) ("SimulateControllerActiveResultTrue " + this.controllerBindResult));
        logger.conditionalLog3((Object) ("SimulateDeviceActiveResultTrue " + this.rollerBindResult));
    }

    /* renamed from: u */
    private void destroy() {
        this.remoteBinded = false;
        this.isAuthenticated = false;
        this.f6647l = false;
        this.baterryStatus = null;
        Disposable disposable = this.controllerConnection;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.f6657v;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        Disposable disposable3 = this.f6658w;
        if (disposable3 != null) {
            disposable3.dispose();
        }
        Disposable disposable4 = this.f6659x;
        if (disposable4 != null) {
            disposable4.dispose();
        }
        Disposable disposable5 = this.f6660y;
        if (disposable5 != null) {
            disposable5.dispose();
        }
        Disposable disposable6 = this.f6661z;
        if (disposable6 != null) {
            disposable6.dispose();
        }
        Disposable disposable7 = this.f6631A;
        if (disposable7 != null) {
            disposable7.dispose();
        }
        this.controllerConnection = null;
        this.f6657v = null;
        this.f6658w = null;
        this.f6659x = null;
        this.f6660y = null;
        this.f6661z = null;
        this.f6631A = null;
        this.f6633C.clear();
        SPSearch.getInstance().getLinkInfo(null);
        try {
            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f6636F.dispose();
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        SharedPreferences sharedPreferences2 = NvTransport.getContext().getSharedPreferences("developer_setting", 0);
        if ("enableSimulateSenseThinkApi".equals(str)) {
            this.enableSimulateSenseThinkApi = sharedPreferences2.getBoolean("enableSimulateSenseThinkApi", true);
        } else if ("controllerBindResult".equals(str)) {
            this.controllerBindResult = sharedPreferences2.getBoolean("controllerBindResult", true);
        } else if ("rollerBindResult".equals(str)) {
            this.rollerBindResult = sharedPreferences2.getBoolean("rollerBindResult", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6710a(int i) {
        NvEvent.onEvent(this.f6632B, this, i, null).m6658a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void onEvent(int i, Object obj) {
        NvEvent.onEvent(this.f6632B, this, i, obj).m6658a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public void m6778v() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f6655t > 1000) {
            this.f6655t = currentTimeMillis;
            NvEvent.m12964c(this.f6632B, this, IjkMediaPlayer.OnNativeInvokeListener.CTRL_WILL_HTTP_OPEN, this).m6658a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, NvError nvError) {
        NvEvent.m6639a(this.f6632B, this, i, nvError).m6658a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public void invalidate() {
        if (this.invalid) {
            return;
        }
        this.invalid = true;
        destroy();
        NvEvent.onEvent(this.f6632B, this, 65549, Long.valueOf(this.f6644i)).m6658a();
    }

    @Override // com.navatics.robot.transport.INvGroundStation
    /* renamed from: a */
    public long getId() {
        return this.f6644i;
    }

    @Override // com.navatics.robot.transport.INvGroundStation
    /* renamed from: a */
    public void mo6589a(long j) {
        this.f6644i = j;
    }

    @Override // com.navatics.robot.transport.INvGroundStation
    /* renamed from: a */
    public void mo6591a(@NonNull NvEventHandler nvEventHandler) {
        this.f6632B = nvEventHandler;
    }

    @Override // com.navatics.robot.transport.INvGroundStation
    /* renamed from: a */
    public KeyMapProvider mo6588a(Context context) {
        if (this.f6637G == null) {
            this.f6637G = new LocalKeyMapProvider(context);
        }
        return this.f6637G;
    }

    @Override // com.navatics.robot.transport.INvGroundStation
    /* renamed from: b */
    public NvDeviceInfo getDeviceInfo() {
        return this.nvDeviceInfo;
    }

    @Override // com.navatics.robot.transport.INvGroundStation
    /* renamed from: c */
    public int mo6595c() {
        return this.f6653r;
    }

    @Override // com.navatics.robot.transport.INvGroundStation
    /* renamed from: d */
    public int mo6597d() {
        return this.f6654s;
    }

    @Override // com.navatics.robot.transport.INvGroundStation
    /* renamed from: e */
    public int mo6598e() {
        return this.f6652q;
    }

    @Override // com.navatics.robot.transport.INvGroundStation
    /* renamed from: f */
    public int getBatteryLevel() {
        BatteryStatus batteryStatus = this.baterryStatus;
        if (batteryStatus != null) {
            return batteryStatus.energyLevel;
        }
        return 0;
    }

    /* renamed from: w */
    private Observable<DeviceInfo> m6779w() {
        return Observable.create((ObservableOnSubscribe) new ObservableOnSubscribe() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$S1J8xZg5v89aCqNo5u-TGFC7mog
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                SensethinkGroundStation.m6723a(observableEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m6723a(final ObservableEmitter observableEmitter) throws Exception {
        SPDevice.getInstance().getDevInfo(new MCallBack() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$wSIdiZHRIIrqTMhPZ_LGKdAjpGE
            @Override // com.senseplay.mframe.client.MCallBack
            public final void onResult(Object obj) {
                SensethinkGroundStation.m6726a(ObservableEmitter.this, (DeviceInfo) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m6726a(ObservableEmitter observableEmitter, DeviceInfo deviceInfo) {
        observableEmitter.onNext(deviceInfo);
        observableEmitter.onComplete();
    }

    @Override // com.navatics.robot.transport.INvGroundStation
    /* renamed from: g */
    public void searchDevices() {
        if (this.enableAuth) {
            checkValid();
            if (this.f6647l) {
                logger.conditionalLog3((Object) "still in searching, ignore.");
                return;
            }
            logger.conditionalLog((Object) "start searching...");
            this.f6647l = true;
            this.f6633C.clear();
            m6710a(65537);
            SPSearch.getInstance().deviceSearch(new DeviceSearchListener() { // from class: com.navatics.robot.transport.ss.d.1
                @Override // com.senseplay.sdk.cache.DeviceSearchListener
                public void search(DeviceInfo deviceInfo) {
                    if (SensethinkGroundStation.this.invalid) {
                        SensethinkGroundStation.logger.conditionalLog2("deviceSearch receive device search callback after destroy");
                        return;
                    }
                    if (!SensethinkGroundStation.this.f6647l) {
                        SensethinkGroundStation.logger.conditionalLog2("DeviceSearch receive device search callback but we are not in search right now.");
                        return;
                    }
                    if (SensethinkGroundStation.this.f6660y != null || SensethinkGroundStation.this.f6634D != null) {
                        SensethinkGroundStation.logger.conditionalLog3((Object) ("DeviceSearch callback, mDevConnDisposable " + SensethinkGroundStation.this.f6660y + ", mActiveConn " + SensethinkGroundStation.this.f6634D));
                        return;
                    }
                    if (deviceInfo == null) {
                        SensethinkGroundStation.logger.log((Object) "Search callback got deviceInfo is null");
                        return;
                    }
                    if (StringUtils.isEmpty((CharSequence) deviceInfo.getLinkID())) {
                        SensethinkGroundStation.logger.log((Object) ("Device : " + deviceInfo.getSerialNo() + ", linkID is null"));
                        return;
                    }
                    String serialNo = deviceInfo.getSerialNo();
                    if (StringUtils.isEmpty((CharSequence) serialNo) || !serialNo.startsWith("STMAEP")) {
                        SensethinkGroundStation.logger.conditionalLog2("Found a device not our product : sn(" + serialNo + "), skip it.");
                        return;
                    }
                    if (SensethinkGroundStation.this.f6633C.containsKey(serialNo)) {
                        SensethinkGroundStation.logger.conditionalLog3((Object) ("Found a device already exist in search result list : " + serialNo));
                        return;
                    }
                    NvDeviceInfo nvDeviceInfo = new NvDeviceInfo(2, new NvAddress(TransportType.SensethinkWireless, deviceInfo.getSerialNo(), new SenseThinkAddrExtra(deviceInfo)), String.valueOf(deviceInfo.getModelID()), String.valueOf(deviceInfo.getManufacturerID()), deviceInfo.getSerialNo(), deviceInfo.getManufactureDate(), String.valueOf(deviceInfo.getHardwareVersion()), String.valueOf(deviceInfo.getFirmwareVersion()), SensethinkGroundStation.this.protoMetas);
                    SensethinkGroundStation.logger.conditionalLog((Object) ("Found device : " + nvDeviceInfo));
                    SensethinkGroundStation.this.f6633C.put(deviceInfo.getSerialNo(), nvDeviceInfo);
                    SensethinkGroundStation sensethinkGroundStation = SensethinkGroundStation.this;
                    sensethinkGroundStation.onEvent(PreferenceFragmentCompatDividers.DIVIDER_DEFAULT, new ArrayList(sensethinkGroundStation.f6633C.values()));
                }

                @Override // com.senseplay.sdk.cache.DeviceSearchListener
                public void finish() {
                    SensethinkGroundStation.logger.conditionalLog((Object) "search stopped.");
                    SensethinkGroundStation.this.f6647l = false;
                    SensethinkGroundStation.this.m6710a(65538);
                }
            });
        }
    }

    @Override // com.navatics.robot.transport.INvGroundStation
    /* renamed from: h */
    public boolean mo6601h() {
        return this.f6657v != null;
    }

    @Override // com.navatics.robot.transport.INvGroundStation
    /* renamed from: i */
    public boolean mo6602i() {
        return this.controllerConnection != null;
    }

    @Override // com.navatics.robot.transport.INvGroundStation
    /* renamed from: j */
    public boolean mo6603j() {
        return this.f6647l;
    }

    @Override // com.navatics.robot.transport.INvGroundStation
    /* renamed from: m */
    public List<NvSocket> mo6606m() {
        if (this.f6634D == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f6634D);
        return arrayList;
    }

    /* renamed from: a */
    private Observable<Boolean> m6704a(final DeviceInfo deviceInfo) {
        if (deviceInfo == null) {
            return Observable.m9733a((Throwable) new NvException(new NvError(49, "deviceInfo is null")));
        }
        logger.conditionalLog((Object) ("deviceConnect, linkID " + deviceInfo.getLinkID() + ", serialNo " + deviceInfo.getSerialNo()));
        return Observable.create(new ObservableOnSubscribe() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$BEQzCMYSAtaknJrfcb27XsUR1f8
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                SensethinkGroundStation.m6722a(DeviceInfo.this, observableEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m6722a(DeviceInfo deviceInfo, final ObservableEmitter observableEmitter) throws Exception {
        SPSearch.getInstance().deviceLink(deviceInfo.getLinkID(), deviceInfo.getSerialNo(), new MCallBack() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$K_UhNWydaEtHNqLRJ01P7LQiuL4
            @Override // com.senseplay.mframe.client.MCallBack
            public final void onResult(Object obj) {
                SensethinkGroundStation.m6728a(ObservableEmitter.this, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m6728a(ObservableEmitter observableEmitter, Boolean bool) {
        if (bool.booleanValue()) {
            observableEmitter.onNext(bool);
            observableEmitter.onComplete();
        } else {
            observableEmitter.onError(new NvException(new NvError(68, "failed to connect to device")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Observable<DeviceUser> m6705a(final String str) {
        return Observable.create(new ObservableOnSubscribe() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$fBKxwcmVgZYGvh69CaBhPUnBFrE
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                SensethinkGroundStation.m6756c(str, observableEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static /* synthetic */ void m6756c(String str, final ObservableEmitter observableEmitter) throws Exception {
        SPDevice.getInstance().verifyUid(str, new MCallBack() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$e6wNnBllgfDGR5u9D6vSl-cxBR8
            @Override // com.senseplay.mframe.client.MCallBack
            public final void onResult(Object obj) {
                SensethinkGroundStation.m6745b(ObservableEmitter.this, (DeviceUser) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m6745b(ObservableEmitter observableEmitter, DeviceUser deviceUser) {
        observableEmitter.onNext(deviceUser);
        observableEmitter.onComplete();
    }

    /* renamed from: b */
    private Observable<DeviceUser> createUserObservable(final String str) {
        return Observable.create(new ObservableOnSubscribe() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$UF_FV0-wh94-3trzgE71xGZru9Q
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                SensethinkGroundStation.m6746b(str, observableEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m6746b(String str, final ObservableEmitter observableEmitter) throws Exception {
        SPRc.getInstance().verifyUid(str, new MCallBack() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$23oBtIBkuBo7jOawDA6slD1_tiQ
            @Override // com.senseplay.mframe.client.MCallBack
            public final void onResult(Object obj) {
                SensethinkGroundStation.m6727a(ObservableEmitter.this, (DeviceUser) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m6727a(ObservableEmitter observableEmitter, DeviceUser deviceUser) {
        observableEmitter.onNext(deviceUser);
        observableEmitter.onComplete();
    }

    /* renamed from: x */
    private void checkValid() {
        if (this.invalid) {
            throw new RuntimeException("This GroundStation is already invalid.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public c m6692a(NvDeviceInfo nvDeviceInfo) {
        c cVar = new c(nvDeviceInfo, true);
        b bVar = new b(cVar, 1);
        d dVar = new d(cVar, 2);
        cVar.setChannel(bVar);
        cVar.setVideoChannel((NvVideoChannel) dVar);
        return cVar;
    }

    @Override // com.navatics.robot.transport.INvGroundStation
    /* renamed from: a */
    public void mo6590a(final NvDeviceInfo nvDeviceInfo, Map<String, Object> map) {
        checkValid();
        if (this.enableAuth) {
            NvAddressExtra extra = nvDeviceInfo.getAddress().getExtra();
            final DeviceInfo m6676a = ((SenseThinkAddrExtra) extra).m6676a();
            if (!extra.isValidate()) {
                String str = "addressExtra is not valid : " + extra.toString();
                logger.log((Object) str);
                a(16711681, new NvError(49, str, nvDeviceInfo));
                return;
            }
            if (this.f6660y != null) {
                logger.log((Object) "already in connecting...");
                return;
            }
            logger.conditionalLog((Object) ("connecting to device : " + nvDeviceInfo));
            if (this.f6647l) {
                this.f6647l = false;
            }
            this.f6660y = m6704a(m6676a).m9762b(Schedulers.m9619b()).m9743a(new Consumer() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$0MWFbzBmH5F0qxyf_tI-fbQcQRs
                @Override // io.reactivex.p085b.Consumer
                public final void accept(Object obj) {
                    SensethinkGroundStation.this.m6721a(m6676a, nvDeviceInfo, (Boolean) obj);
                }
            }, new Consumer() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$jlmhF8ooisaB7BW9cwtjzKH1hGM
                @Override // io.reactivex.p085b.Consumer
                public final void accept(Object obj) {
                    SensethinkGroundStation.this.m6713a(nvDeviceInfo, (Throwable) obj);
                }
            }, new InterfaceC2824a() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$XVGwcFfgGmlyWrZbH4PgIP8tKfQ
                @Override // io.reactivex.p085b.InterfaceC2824a
                public final void run() {
                    SensethinkGroundStation.this.m6691D();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m6721a(DeviceInfo deviceInfo, NvDeviceInfo nvDeviceInfo, Boolean bool) throws Exception {
        logger.conditionalLog3((Object) ("deviceConnect result, isLinked -> " + bool));
        this.f6633C.remove(deviceInfo.getSerialNo());
        this.f6634D = m6692a(nvDeviceInfo);
        onEvent(InputDeviceCompat.SOURCE_TRACKBALL, this.f6634D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m6713a(NvDeviceInfo nvDeviceInfo, Throwable th) throws Exception {
        if (!(th instanceof NvException)) {
            th = new NvException(th.getMessage(), th, new NvError(255, th.getMessage()));
        }
        NvError error = ((NvException) th).getError();
        error.m6631a(nvDeviceInfo);
        a(16711681, error);
        this.f6660y.dispose();
        this.f6660y = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public /* synthetic */ void m6691D() throws Exception {
        logger.conditionalLog3((Object) "deviceConnect finish");
        this.f6660y.dispose();
        this.f6660y = null;
    }

    /* renamed from: a */
    public void m6783a(NvSocket nvSocket) {
        if (nvSocket == this.f6634D) {
            closeConn();
            SPDevice.getInstance().disConnect();
        }
    }

    @Override // com.navatics.robot.transport.INvGroundStation
    /* renamed from: n */
    public boolean isControllerAuthed() {
        checkValid();
        if (this.enableAuth) {
            return this.isAuthenticated;
        }
        return true;
    }

    @Override // com.navatics.robot.transport.INvGroundStation
    /* renamed from: k */
    public boolean isValid() {
        return !this.invalid;
    }

    /* renamed from: a */
    private Observable<CallBackMsg> m6706a(final String str, final String str2) {
        return Observable.create(new ObservableOnSubscribe() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$y6gmwigaC2RDBFkTPoJ7qcKX63I
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                SensethinkGroundStation.this.m6730a(str, str2, observableEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m6730a(String str, String str2, final ObservableEmitter observableEmitter) throws Exception {
        MCallBack mCallBack = new MCallBack() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$m3DC2LQSda8zgNSvPnsmPngnNhQ
            @Override // com.senseplay.mframe.client.MCallBack
            public final void onResult(Object obj) {
                SensethinkGroundStation.this.m6762d(observableEmitter, (CallBackMsg) obj);
            }
        };
        Method declaredMethod = SPRc.class.getDeclaredMethod("setUid", String.class, String.class, MCallBack.class);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(SPRc.getInstance(), str, str2, mCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m6762d(ObservableEmitter observableEmitter, CallBackMsg callBackMsg) {
        if (callBackMsg.getCode() == 0) {
            observableEmitter.onNext(callBackMsg);
            observableEmitter.onComplete();
        } else {
            observableEmitter.onError(new NvException(new NvError(49, callBackMsg.getMessage(), this)));
        }
    }

    /* renamed from: c */
    private Observable<CallBackMsg> m6753c(final String str) {
        return Observable.create(new ObservableOnSubscribe() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$Fb7W_xQ1hEAaUZtPjIK9JM94198
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                SensethinkGroundStation.this.m6729a(str, observableEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m6729a(String str, final ObservableEmitter observableEmitter) throws Exception {
        MCallBack mCallBack = new MCallBack() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$Ulo0vtXR4eM-0WLJ1fJ4tWfrJQc
            @Override // com.senseplay.mframe.client.MCallBack
            public final void onResult(Object obj) {
                SensethinkGroundStation.this.m6755c(observableEmitter, (CallBackMsg) obj);
            }
        };
        Method declaredMethod = SPRc.class.getDeclaredMethod("deleteUid", String.class, MCallBack.class);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(SPRc.getInstance(), str, mCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m6755c(ObservableEmitter observableEmitter, CallBackMsg callBackMsg) {
        if (callBackMsg.getCode() == 0) {
            logger.conditionalLog((Object) "remote deactivate success !!!!!!!!!!!!!!");
            observableEmitter.onNext(callBackMsg);
            observableEmitter.onComplete();
            return;
        }
        observableEmitter.onError(new NvException(new NvError(65, "remote deactivate success", this)));
    }

    /* renamed from: a */
    private Observable<CallBackMsg> m6698a(final c cVar, final String str, final String str2) {
        return Observable.create(new ObservableOnSubscribe() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$ZWHqVTSt1uAanPmTRXlfdHU2qBg
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                SensethinkGroundStation.m6716a(SensethinkGroundStation.c.this, str, str2, observableEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m6716a(final c cVar, String str, String str2, final ObservableEmitter observableEmitter) throws Exception {
        MCallBack mCallBack = new MCallBack() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$Ne40WqnDCleExqsgwPpyfP2d4Do
            @Override // com.senseplay.mframe.client.MCallBack
            public final void onResult(Object obj) {
                SensethinkGroundStation.m6761d(ObservableEmitter.this, cVar, (CallBackMsg) obj);
            }
        };
        Method declaredMethod = SPDevice.class.getDeclaredMethod("setUid", String.class, String.class, MCallBack.class);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(SPDevice.getInstance(), str, str2, mCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static /* synthetic */ void m6761d(ObservableEmitter observableEmitter, c cVar, CallBackMsg callBackMsg) {
        if (callBackMsg.getCode() == 0) {
            logger.conditionalLog((Object) "activate success !!!!!!!!!!!!!!");
            observableEmitter.onNext(callBackMsg);
            observableEmitter.onComplete();
            return;
        }
        observableEmitter.onError(new NvException(new NvError(49, callBackMsg.getMessage(), cVar)));
    }

    /* renamed from: a */
    private Observable<CallBackMsg> m6697a(final c cVar, final String str) {
        return Observable.create(new ObservableOnSubscribe() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$2lKlX_05HAIZ2SBeKP9yrPJpvXo
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                SensethinkGroundStation.m6715a(SensethinkGroundStation.c.this, str, observableEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m6715a(final c cVar, String str, final ObservableEmitter observableEmitter) throws Exception {
        MCallBack mCallBack = new MCallBack() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$EuuRoL4MA_xUzNND5Yz60qGRUZE
            @Override // com.senseplay.mframe.client.MCallBack
            public final void onResult(Object obj) {
                SensethinkGroundStation.m6754c(ObservableEmitter.this, cVar, (CallBackMsg) obj);
            }
        };
        Method declaredMethod = SPDevice.class.getDeclaredMethod("deleteUid", String.class, MCallBack.class);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(SPDevice.getInstance(), str, mCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static /* synthetic */ void m6754c(ObservableEmitter observableEmitter, c cVar, CallBackMsg callBackMsg) {
        if (callBackMsg.getCode() == 0) {
            logger.conditionalLog((Object) "clear uid success !!!!!!!!!!!!!!");
            observableEmitter.onNext(callBackMsg);
            observableEmitter.onComplete();
            return;
        }
        observableEmitter.onError(new NvException(new NvError(65, "clear uid failed", cVar)));
    }

    /* renamed from: a */
    private String getErrorStringFromSensethinkErrorCode(int i, String str) {
        logger.log((Object) ("getErrorStringFromSensethinkErrorCode : " + i + ", ssMsg " + str));
        if (i == 255) {
            return "Get remote information failed, please unplug the remote and try again(255)";
        }
        if (i == 900) {
            return "Please check your network connection (900)";
        }
        if (i == 998) {
            return "Device disconnected, please try again(998)";
        }
        if (i == 999) {
            return "Please login to your account(999)";
        }
        if (i == 901) {
            return "Please check your network connection (901)";
        }
        if (i == 100010) {
            return "Wrong activation code";
        }
        if (i == 100014) {
            return "This device haven't been bound to any user.";
        }
        if (i == 100101) {
            return "The device has been bound";
        }
        if (i == 100105) {
            return str + "(" + i + ")";
        }
        return "Unknown error(" + i + ")";
    }

    @SuppressLint({"HandlerLeak"})
    /* renamed from: a */
    private Observable<CallBackMsg> m6708a(final String str, final String str2, final String str3, final String str4) {
        if (this.enableSimulateSenseThinkApi) {
            if (this.controllerBindResult) {
                return m6706a(str2, str);
            }
            return Observable.m9733a((Throwable) new NvException(new NvError(254, "simulate remote active err", this)));
        }
        return Observable.create(new ObservableOnSubscribe() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$cxoj9Y3Yg17JueQdBWY4B_Zxx0g
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                SensethinkGroundStation.this.m6734a(str2, str, str3, str4, observableEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m6734a(String str, String str2, String str3, String str4, final ObservableEmitter observableEmitter) throws Exception {
        Log.d("ContentValues", "rc绑定参数 ：uuId = " + str + ", rcSn = " + str2 + "， accessToken = " + str3 + ", verifyCode = " + str4);
        SPRc.getInstance().bindRc(str, str2, str3, str4, new MCallBack() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$53fvTjkpWrGmGfBbO9cxlvcGwek
            @Override // com.senseplay.mframe.client.MCallBack
            public final void onResult(Object obj) {
                SensethinkGroundStation.this.m6744b(observableEmitter, (CallBackMsg) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m6744b(ObservableEmitter observableEmitter, CallBackMsg callBackMsg) {
        if (callBackMsg.getCode() == 0) {
            logger.conditionalLog((Object) "activate success !!!!!!!!!!!!!!");
            observableEmitter.onNext(callBackMsg);
            observableEmitter.onComplete();
            return;
        }
        observableEmitter.onError(new NvException(new NvError(49, getErrorStringFromSensethinkErrorCode(callBackMsg.getCode(), callBackMsg.getMessage()), this)));
    }

    /* renamed from: a */
    private Observable<CallBackMsg> m6707a(final String str, final String str2, final String str3) {
        if (this.enableSimulateSenseThinkApi) {
            if (this.controllerBindResult) {
                return m6753c(str2);
            }
            return Observable.m9733a((Throwable) new NvException(new NvError(254, "simulate remote active err", this)));
        }
        return Observable.create(new ObservableOnSubscribe() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$ycDH85E0SFrjBYPWTAB68K4qWXw
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                SensethinkGroundStation.this.m6732a(str2, str, str3, observableEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m6732a(String str, String str2, String str3, final ObservableEmitter observableEmitter) throws Exception {
        Log.d("ContentValues", "rc绑定参数 ：uuId = " + str + ", rcSn = " + str2 + "， accessToken = " + str3);
        SPRc.getInstance().unBindRc(str, str2, str3, new MCallBack() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$N7aTjzPe_IETI8QDzJ1TPtOWJIQ
            @Override // com.senseplay.mframe.client.MCallBack
            public final void onResult(Object obj) {
                SensethinkGroundStation.this.m6725a(observableEmitter, (CallBackMsg) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m6725a(ObservableEmitter observableEmitter, CallBackMsg callBackMsg) {
        if (callBackMsg.getCode() == 0) {
            logger.conditionalLog((Object) "remote deactivate success !!!!!!!!!!!!!!");
            observableEmitter.onNext(callBackMsg);
            observableEmitter.onComplete();
            return;
        }
        observableEmitter.onError(new NvException(new NvError(65, getErrorStringFromSensethinkErrorCode(callBackMsg.getCode(), callBackMsg.getMessage()), this)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})
    /* renamed from: a */
    public Observable<CallBackMsg> m6700a(final c cVar, final String str, final String str2, final String str3, final String str4) {
        if (this.enableSimulateSenseThinkApi) {
            if (this.rollerBindResult) {
                return m6698a(cVar, str2, str);
            }
            return Observable.m9733a((Throwable) new NvException(new NvError(254, "simulate remote active err", cVar)));
        }
        return Observable.create(new ObservableOnSubscribe() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$7a9GMen1LmbLLtKu1DyVJs9olks
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                SensethinkGroundStation.this.m6733a(str2, str, str3, str4, cVar, observableEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m6733a(String str, String str2, String str3, String str4, final c cVar, final ObservableEmitter observableEmitter) throws Exception {
        Log.d("ContentValues", "rc绑定参数 ：uuId = " + str + ", rcSn = " + str2 + "， accessToken = " + str3 + ", verifyCode = " + str4);
        SPDevice.getInstance().bindDevice(str, str2, str3, str4, new MCallBack() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$CMxYC34NlcR-7iTakGOH3ffTudY
            @Override // com.senseplay.mframe.client.MCallBack
            public final void onResult(Object obj) {
                SensethinkGroundStation.this.m6743b(observableEmitter, cVar, (CallBackMsg) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m6743b(ObservableEmitter observableEmitter, c cVar, CallBackMsg callBackMsg) {
        if (callBackMsg.getCode() == 0) {
            Log.i("ContentValues", "device activate success !!!!!!!!!!!!!!");
            observableEmitter.onNext(callBackMsg);
            observableEmitter.onComplete();
            return;
        }
        observableEmitter.onError(new NvException(new NvError(49, getErrorStringFromSensethinkErrorCode(callBackMsg.getCode(), callBackMsg.getMessage()), cVar)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Observable<CallBackMsg> m6699a(final c cVar, final String str, final String str2, final String str3) {
        if (this.enableSimulateSenseThinkApi) {
            if (this.rollerBindResult) {
                return m6697a(cVar, str2);
            }
            return Observable.m9733a((Throwable) new NvException(new NvError(254, "simulate remote active err", cVar)));
        }
        return Observable.create(new ObservableOnSubscribe() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$t7VOwOj9CKBMYSloVaZfDVlqQXs
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                SensethinkGroundStation.m6731a(str2, str, str3, cVar, observableEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m6731a(String str, String str2, String str3, final c cVar, final ObservableEmitter observableEmitter) throws Exception {
        Log.d("ContentValues", "rc绑定参数 ：uuId = " + str + ", rcSn = " + str2 + "， accessToken = " + str3);
        SPDevice.getInstance().unBindDevice(str, str2, str3, new MCallBack() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$k7cSgDmJYYW9sp1f8Dg2zpp1plo
            @Override // com.senseplay.mframe.client.MCallBack
            public final void onResult(Object obj) {
                SensethinkGroundStation.deactivateDevice(ObservableEmitter.this, cVar, (CallBackMsg) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void deactivateDevice(ObservableEmitter observableEmitter, c cVar, CallBackMsg callBackMsg) {
        if (callBackMsg.getCode() == 0) {
            Log.i("ContentValues", "device deactivate success !!!!!!!!!!!!!!");
            observableEmitter.onNext(callBackMsg);
            observableEmitter.onComplete();
            return;
        }
        observableEmitter.onError(new NvException(new NvError(49, "device deactivate failed", cVar)));
    }

    /* renamed from: y */
    private void onRemoteLoginSuccess() {
        this.isAuthenticated = true;
        this.remoteBinded = true;
        onEvent(65546, (Object) new NvError(0, "remote login success", this));
        ObservableConsumers.m9342a(m6779w(), this.f6636F, new Consumer() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$eqZzm4du3YqN3mq8v2qO-bzKggI
            @Override // io.reactivex.p085b.Consumer
            public final void accept(Object obj) {
                SensethinkGroundStation.this.m6742b((DeviceInfo) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m6742b(DeviceInfo deviceInfo) throws Exception {
        final c cVar = new c(new NvDeviceInfo(2, new NvAddress(TransportType.SensethinkWireless, deviceInfo.getSerialNo(), new SenseThinkAddrExtra(deviceInfo)), String.valueOf(deviceInfo.getModelID()), String.valueOf(deviceInfo.getManufacturerID()), deviceInfo.getSerialNo(), deviceInfo.getManufactureDate(), String.valueOf(deviceInfo.getHardwareVersion()), String.valueOf(deviceInfo.getFirmwareVersion()), this.protoMetas), false);
        b bVar = new b(cVar, 1);
        d dVar = new d(cVar, 2);
        cVar.setChannel(bVar);
        cVar.setVideoChannel((NvVideoChannel) dVar);
        logger.conditionalLog((Object) ("set SPRc getLinkInfo to socket " + cVar.getSocketId()));
        this.f6634D = cVar;
        onEvent(InputDeviceCompat.SOURCE_TRACKBALL, cVar);
        NvEventLoop.m6662a().mo6527a(new Runnable() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$7kZOHGZG69dP8Nllk9MYiJgRwSY
            @Override // java.lang.Runnable
            public final void run() {
                SensethinkGroundStation.this.m6714a(cVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m6714a(c cVar) {
        cVar.m6830b(true);
        cVar.setAuthed(true);
        cVar.mo6806f();
        onEvent(65543, cVar);
    }

    @Override // com.navatics.robot.transport.INvGroundStation
    /* renamed from: a */
    public void tryLoginToController(Map<String, Object> properties) {
        checkValid();
        if (!this.enableAuth) {
            onRemoteLoginSuccess();
        } else if (!SPUsb.getInstance().checkUsb()) {
            a(16711685, new NvError(50, "usb not ready", this));
        } else {
            this.controllerConnection = createUserObservable((String) properties.get("uuid")).m9762b(AndroidSchedulers.m9582a()).m9743a(new AnonymousClass2(), new Consumer() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$tveHg1w4_Y9GtyLirPZzgkFWwFM
                @Override // io.reactivex.p085b.Consumer
                public final void accept(Object obj) {
                    SensethinkGroundStation.this.m6757c((Throwable) obj);
                }
            }, new InterfaceC2824a() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$m_xuan0TuGJ4VSa64jyaAC3gfsU
                @Override // io.reactivex.p085b.InterfaceC2824a
                public final void run() {
                    SensethinkGroundStation.this.m6690C();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SensethinkGroundStation.java */
    /* renamed from: com.navatics.robot.transport.ss.d$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass2 implements Consumer<DeviceUser> {
        AnonymousClass2() {
        }

        @Override // io.reactivex.p085b.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(DeviceUser deviceUser) throws Exception {
            if (deviceUser == null) {
                SensethinkGroundStation sensethinkGroundStation = SensethinkGroundStation.this;
                sensethinkGroundStation.a(16711685, new NvError(48, "remote login failed, deviceUser is null", sensethinkGroundStation));
                return;
            }
            boolean z = deviceUser.getCode() == 0 && deviceUser.isBind() && deviceUser.isOwner();
            SensethinkGroundStation.logger.conditionalLog3((Object) ("SensethinkGroundStation auth done, isLoginSucc=" + z + ", isBind=" + deviceUser.isBind() + ", isOwner=" + deviceUser.isOwner()));
            if (deviceUser.getCode() != -1) {
                SensethinkGroundStation.this.remoteBinded = deviceUser.isBind();
                if (z) {
                    SensethinkGroundStation.this.isAuthenticated = true;
                    if (SensethinkGroundStation.this.f6635E.m6788a()) {
                        SensethinkGroundStation.logger.conditionalLog((Object) "device already connected detected, getting deviceInfo...");
                        SPDevice.getInstance().getDevInfo(new MCallBack() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$2$HziMdO4geEehUprwisc6H6islFQ
                            @Override // com.senseplay.mframe.client.MCallBack
                            public final void onResult(Object obj) {
                                SensethinkGroundStation.AnonymousClass2.this.getDevInfo((DeviceInfo) obj);
                            }
                        });
                        return;
                    } else {
                        SensethinkGroundStation sensethinkGroundStation2 = SensethinkGroundStation.this;
                        sensethinkGroundStation2.onEvent(65546, (Object) new NvError(0, "remote login success", sensethinkGroundStation2));
                        return;
                    }
                }
                if (deviceUser.isBind()) {
                    SensethinkGroundStation.logger.log((Object) "login failed because current user not the owner");
                    SensethinkGroundStation sensethinkGroundStation3 = SensethinkGroundStation.this;
                    sensethinkGroundStation3.a(16711685, new NvError(51, "not the remote owner", sensethinkGroundStation3));
                    return;
                } else {
                    SensethinkGroundStation.logger.log((Object) "login failed because remote haven't been bound");
                    SensethinkGroundStation sensethinkGroundStation4 = SensethinkGroundStation.this;
                    sensethinkGroundStation4.a(16711685, new NvError(52, "remote haven't been bound", sensethinkGroundStation4));
                    return;
                }
            }
            SensethinkGroundStation sensethinkGroundStation5 = SensethinkGroundStation.this;
            sensethinkGroundStation5.a(16711685, new NvError(48, "I/O error", sensethinkGroundStation5));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void getDevInfo(DeviceInfo deviceInfo) {
            if (deviceInfo == null) {
                SensethinkGroundStation.logger.log((Object) "getDevInfo error when detected connection inited for ground station");
                SensethinkGroundStation.this.remoteBinded = false;
                SensethinkGroundStation.this.isAuthenticated = false;
                NvEvent.m6639a(SensethinkGroundStation.this.f6632B, this, 16711689, new NvError(48, "Controller internal error, please unplug and plugin again")).m6658a();
                return;
            }
            SensethinkGroundStation.logger.conditionalLog3((Object) "Get deviceInfo done.");
            NvDeviceInfo nvDeviceInfo = new NvDeviceInfo(2, new NvAddress(TransportType.SensethinkWireless, deviceInfo.getSerialNo(), new SenseThinkAddrExtra(deviceInfo)), String.valueOf(deviceInfo.getModelID()), String.valueOf(deviceInfo.getManufacturerID()), deviceInfo.getSerialNo(), deviceInfo.getManufactureDate(), String.valueOf(deviceInfo.getHardwareVersion()), String.valueOf(deviceInfo.getFirmwareVersion()), SensethinkGroundStation.this.protoMetas);
            SensethinkGroundStation.logger.conditionalLog((Object) ("coreboard version : " + deviceInfo.getFirmwareVersion() + ", date : " + deviceInfo.getManufactureDate()));
            Logger logger = SensethinkGroundStation.logger;
            StringBuilder sb = new StringBuilder();
            sb.append("Get deviceInfo : ");
            sb.append(nvDeviceInfo);
            logger.conditionalLog3((Object) sb.toString());
            SensethinkGroundStation sensethinkGroundStation = SensethinkGroundStation.this;
            sensethinkGroundStation.f6634D = sensethinkGroundStation.m6692a(nvDeviceInfo);
            SensethinkGroundStation sensethinkGroundStation2 = SensethinkGroundStation.this;
            sensethinkGroundStation2.onEvent(65546, (Object) new NvError(0, "remote login success", sensethinkGroundStation2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m6757c(Throwable th) throws Exception {
        logger.log((Object) "GndStaAuthDisposable err.");
        if (!(th instanceof NvException)) {
            th.printStackTrace();
            th = new NvException(th.getMessage(), th, new NvError(255, th.getMessage(), this));
        }
        a(16711685, ((NvException) th).getError());
        this.controllerConnection.dispose();
        this.controllerConnection = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public /* synthetic */ void m6690C() throws Exception {
        logger.conditionalLog3((Object) "GndStaAuthDisposable done.");
        this.controllerConnection.dispose();
        this.controllerConnection = null;
    }

    @Override // com.navatics.robot.transport.INvGroundStation
    /* renamed from: o */
    public boolean isRemoteBinded() {
        checkValid();
        if (this.enableAuth) {
            return this.remoteBinded;
        }
        return true;
    }

    @Override // com.navatics.robot.transport.INvGroundStation
    /* renamed from: b */
    public void mo6594b(Map<String, Object> map) {
        checkValid();
        String str = (String) map.get("sn");
        String str2 = (String) map.get("uuid");
        String str3 = (String) map.get("access_token");
        String str4 = (String) map.get("qrCode");
        logger.conditionalLog3((Object) ("bind : sn=" + str + ", uuid=" + str2 + ", accessToken=" + str3 + ", verifyCode=" + str4));
        if (this.f6657v != null) {
            return;
        }
        this.f6657v = m6708a(str, str2, str3, str4).m9743a(new Consumer() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$awe9hncqV6t4C9MoRmuyReiRKx8
            @Override // io.reactivex.p085b.Consumer
            public final void accept(Object obj) {
                SensethinkGroundStation.this.bindRemote((CallBackMsg) obj);
            }
        }, new Consumer() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$7k6rOhDiCCQjCTEC1957mu6d-nI
            @Override // io.reactivex.p085b.Consumer
            public final void accept(Object obj) {
                SensethinkGroundStation.this.m6747b((Throwable) obj);
            }
        }, new InterfaceC2824a() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$-Hk11m2NMjPefFEiJxzUXQ8ytyE
            @Override // io.reactivex.p085b.InterfaceC2824a
            public final void run() {
                SensethinkGroundStation.this.m6689B();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void bindRemote(CallBackMsg callBackMsg) throws Exception {
        logger.conditionalLog3((Object) "GndStaBindDisposable success.");
        this.remoteBinded = true;
        onEvent(65545, (Object) new NvError(0, "remote bind success", this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m6747b(Throwable th) throws Exception {
        logger.log((Object) "GndStaBindDisposable err.");
        a(16711686, ((NvException) th).getError());
        this.f6657v.dispose();
        this.f6657v = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public /* synthetic */ void m6689B() throws Exception {
        logger.conditionalLog3((Object) "GndStaBindDisposable done.");
        this.f6657v.dispose();
        this.f6657v = null;
    }

    @Override // com.navatics.robot.transport.INvGroundStation
    /* renamed from: c */
    public void tryLoginToController2(Map<String, Object> map) {
        checkValid();
        if (!this.isAuthenticated) {
            logger.log((Object) "You haven't login to the controller yet.");
            a(16711687, new NvError(66, "You haven't login to the controller yet.", this));
            return;
        }
        String uuid = (String) map.get("uuid");
        String sn = (String) map.get("sn");
        String accessToken = (String) map.get("access_token");
        logger.conditionalLog3((Object) ("unbind : sn=" + sn + ", uuid=" + uuid + ", accessToken=" + accessToken));
        if (this.f6658w != null) {
            return;
        }
        if (StringUtils.isEmpty((CharSequence) sn) || StringUtils.isEmpty((CharSequence) uuid) || StringUtils.isEmpty((CharSequence) accessToken)) {
            a(16711687, new NvError(49, "sn or uuid or accessToken is invalid", this));
        } else {
            this.f6658w = m6707a(sn, uuid, accessToken).m9743a(new Consumer() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$8lTVKFx4lhlnuW5yrDFBHAifKh4
                @Override // io.reactivex.p085b.Consumer
                public final void accept(Object obj) {
                    SensethinkGroundStation.this.mGndStaUnbindDisposable((CallBackMsg) obj);
                }
            }, new Consumer() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$lqXcjZiqI1sZ9hIuKGuMJ_ERoyM
                @Override // io.reactivex.p085b.Consumer
                public final void accept(Object obj) {
                    SensethinkGroundStation.this.mGndStaUnbindDisposable((Throwable) obj);
                }
            }, new InterfaceC2824a() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$OpyWmoeONrSY8Yc_cXZzdqNAgqE
                @Override // io.reactivex.p085b.InterfaceC2824a
                public final void run() {
                    SensethinkGroundStation.this.mGndStaUnbindDisposable();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void mGndStaUnbindDisposable(CallBackMsg callBackMsg) throws Exception {
        logger.conditionalLog3((Object) "mGndStaUnbindDisposable success.");
        destroy();
        onEvent(65566, (Object) new NvError(0, "remote unbind success", this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void mGndStaUnbindDisposable(Throwable th) throws Exception {
        logger.log((Object) "mGndStaUnbindDisposable err.");
        a(16711687, ((NvException) th).getError());
        this.f6658w.dispose();
        this.f6658w = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public /* synthetic */ void mGndStaUnbindDisposable() throws Exception {
        logger.conditionalLog3((Object) "mGndStaUnbindDisposable done.");
        this.f6658w.dispose();
        this.f6658w = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public void closeConn() {
        if (this.f6634D == null) {
            return;
        }
        WLog.m7004i(f6629a, "closeConn, send DEVICE_DISCONNECTED");
        try {
            c cVar = this.f6634D;
            this.f6634D.m6808k();
            this.f6634D = null;
            onEvent(65541, cVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SensethinkGroundStation.java */
    /* renamed from: com.navatics.robot.transport.ss.d$a */
    /* loaded from: classes2.dex */
    public class a implements MCallBack<LinkInfo> {

        /* renamed from: a */
        boolean f6664a;

        /* renamed from: b */
        long f6665b;

        /* renamed from: c */
        RunnableC3594a f6666c = new RunnableC3594a();

        /* renamed from: d */
        final int f6667d = PathInterpolatorCompat.MAX_NUM_POINTS;

        a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SensethinkGroundStation.java */
        /* renamed from: com.navatics.robot.transport.ss.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC3594a implements Runnable {
            RunnableC3594a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (SensethinkGroundStation.this.f6634D == null) {
                    WLog.m7008w(SensethinkGroundStation.f6629a, "warning, connection broken detected, but no active conn");
                    return;
                }
                WLog.m7008w(SensethinkGroundStation.f6629a, " connection [" + SensethinkGroundStation.this.f6634D.getSocketId() + "] broken detected from rc");
                a aVar = a.this;
                aVar.f6664a = false;
                SensethinkGroundStation.this.closeConn();
            }
        }

        /* renamed from: a */
        boolean m6788a() {
            return this.f6664a;
        }

        /* renamed from: a */
        void disconnectDetector(LinkInfo linkInfo) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean isLinked = linkInfo.isLinked();
            if (!this.f6664a && isLinked) {
                WLog.m7004i(SensethinkGroundStation.f6629a, "connection [" + SensethinkGroundStation.this.getId() + "] init detected.");
                this.f6664a = true;
            }
            if (isLinked || !this.f6664a || this.f6665b != 0) {
                if (this.f6665b <= 0 || !isLinked) {
                    return;
                }
                SensethinkGroundStation.logger.conditionalLog3((Object) "remove disconnectDetector");
                NvEventLoop.m6662a().mo6530b(this.f6666c);
                this.f6665b = 0L;
                return;
            }
            if (SensethinkGroundStation.this.f6647l && SensethinkGroundStation.this.f6634D != null) {
                this.f6664a = false;
                SensethinkGroundStation.this.closeConn();
            } else {
                this.f6665b = currentTimeMillis;
                SensethinkGroundStation.logger.conditionalLog3((Object) "post disconnectDetector");
                NvEventLoop.m6662a().mo6528a(this.f6666c, 3000L);
            }
        }

        @Override // com.senseplay.mframe.client.MCallBack
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onResult(LinkInfo linkInfo) {
            SensethinkGroundStation.this.f6652q = linkInfo.getDev_snr0();
            SensethinkGroundStation.this.f6653r = linkInfo.getDev_rssi0();
            SensethinkGroundStation.this.f6654s = 0;
            SensethinkGroundStation.this.baterryStatus = SPRc.getInstance().getBatteryStatus();
            SensethinkGroundStation.this.m6778v();
            disconnectDetector(linkInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SensethinkGroundStation.java */
    /* renamed from: com.navatics.robot.transport.ss.d$c */
    /* loaded from: classes2.dex */
    public class c extends NvSocket {
        c(NvDeviceInfo nvDeviceInfo, boolean z) {
            super(nvDeviceInfo, z);
        }

        @Override // com.navatics.robot.transport.NvSocket
        /* renamed from: f */
        public void mo6806f() {
            if (m6834g()) {
                return;
            }
            super.mo6806f();
            getChannel().mo6517d();
        }

        @Override // com.navatics.robot.transport.NvSocket
        /* renamed from: a */
        public void mo6803a(Map<String, Object> map) {
            if (SensethinkGroundStation.this.enableAuth) {
                if (!SPUsb.getInstance().checkUsb()) {
                    SensethinkGroundStation.this.a(16711682, new NvError(50, "usb not ready", this));
                    return;
                }
                String str = (String) map.get("uuid");
                SensethinkGroundStation sensethinkGroundStation = SensethinkGroundStation.this;
                sensethinkGroundStation.f6661z = sensethinkGroundStation.m6705a(str).m9762b(AndroidSchedulers.m9582a()).m9743a(new Consumer() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$c$r5SctuvmXjIdaeeUMPRXhaMb9Us
                    @Override // io.reactivex.p085b.Consumer
                    public final void accept(Object obj) {
                        SensethinkGroundStation.c.this.loginUser((DeviceUser) obj);
                    }
                }, new Consumer() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$c$J7LK6fJqZacuP2BeNw3Tf6N3Yfc
                    @Override // io.reactivex.p085b.Consumer
                    public final void accept(Object obj) {
                        SensethinkGroundStation.c.this.m6799c((Throwable) obj);
                    }
                }, new InterfaceC2824a() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$c$yCkOY6m2ERL6b-qsmst4H-ub2fU
                    @Override // io.reactivex.p085b.InterfaceC2824a
                    public final void run() {
                        SensethinkGroundStation.c.this.m6802n();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void loginUser(DeviceUser deviceUser) throws Exception {
            if (deviceUser == null) {
                SensethinkGroundStation.this.a(16711682, new NvError(48, "device login failed, deviceUser is null", this));
                return;
            }
            boolean authenticated = deviceUser.getCode() == 0 && deviceUser.isBind() && deviceUser.isOwner();
            m6830b(deviceUser.isBind());
            setAuthed(authenticated);
            if (authenticated) {
                SensethinkGroundStation.this.onEvent(65543, this);
                if (m6835h()) {
                    mo6806f();
                    return;
                }
                return;
            }
            if (deviceUser.isBind()) {
                SensethinkGroundStation.this.a(16711682, new NvError(51, "not the device owner", this));
            } else {
                SensethinkGroundStation.this.a(16711682, new NvError(52, "device haven't been bound", this));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void m6799c(Throwable th) throws Exception {
            if (!(th instanceof NvException)) {
                th = new NvException(th.getMessage(), th, new NvError(255, th.getMessage(), this));
            }
            SensethinkGroundStation.this.a(16711682, ((NvException) th).getError());
            SensethinkGroundStation.this.f6661z.dispose();
            SensethinkGroundStation.this.f6661z = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: n */
        public /* synthetic */ void m6802n() throws Exception {
            SensethinkGroundStation.this.f6661z.dispose();
            SensethinkGroundStation.this.f6661z = null;
        }

        @Override // com.navatics.robot.transport.NvSocket
        /* renamed from: b */
        public void bindDevice(Map<String, Object> properties) {
            if (SensethinkGroundStation.this.enableAuth) {
                if (hasClosedConnection()) {
                    throw new RuntimeException("try to bind to a device which connection already closed.");
                }
                String str = (String) properties.get("sn");
                String str2 = (String) properties.get("uuid");
                String str3 = (String) properties.get("access_token");
                String str4 = (String) properties.get("qrCode");
                if (SensethinkGroundStation.this.f6631A != null) {
                    return;
                }
                Log.d("ContentValues", "Device绑定参数 ：uuId = " + str2 + ", rcSn = " + str + "， accessToken = " + str3 + ", verifyCode = " + str4);
                SensethinkGroundStation sensethinkGroundStation = SensethinkGroundStation.this;
                sensethinkGroundStation.f6631A = sensethinkGroundStation.m6700a(this, str, str2, str3, str4).m9743a(new Consumer() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$c$BdVNauP_tB5twNkdqzR_mg800OU
                    @Override // io.reactivex.p085b.Consumer
                    public final void accept(Object obj) {
                        SensethinkGroundStation.c.this.m6797b((CallBackMsg) obj);
                    }
                }, new Consumer() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$c$FBOqRK45ossu9MCsLfCckNPS640
                    @Override // io.reactivex.p085b.Consumer
                    public final void accept(Object obj) {
                        SensethinkGroundStation.c.this.m6798b((Throwable) obj);
                    }
                }, new InterfaceC2824a() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$c$jhvDE5OFeE7WsN3kBPZd7eCbgQc
                    @Override // io.reactivex.p085b.InterfaceC2824a
                    public final void run() {
                        SensethinkGroundStation.c.this.m6801m();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void m6797b(CallBackMsg callBackMsg) throws Exception {
            m6830b(true);
            SensethinkGroundStation.this.onEvent(65544, (Object) new NvError(0, "device bind success", this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void m6798b(Throwable th) throws Exception {
            if (!(th instanceof NvException)) {
                th = new NvException(th.getMessage(), th, new NvError(255, th.getMessage(), this));
            }
            SensethinkGroundStation.this.a(16711683, ((NvException) th).getError());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: m */
        public /* synthetic */ void m6801m() throws Exception {
            SensethinkGroundStation.this.f6631A.dispose();
            SensethinkGroundStation.this.f6631A = null;
        }

        @Override // com.navatics.robot.transport.NvSocket
        /* renamed from: c */
        public void unbindDevice(Map<String, Object> map) {
            if (SensethinkGroundStation.this.enableAuth) {
                if (hasClosedConnection()) {
                    throw new RuntimeException("try to unbind a device which connection already closed.");
                }
                String str = (String) map.get("sn");
                String str2 = (String) map.get("uuid");
                String str3 = (String) map.get("access_token");
                if (SensethinkGroundStation.this.f6659x != null) {
                    return;
                }
                Log.d("ContentValues", "Device unbind ：uuId = " + str2 + ", rcSn = " + str + "， accessToken = " + str3);
                SensethinkGroundStation sensethinkGroundStation = SensethinkGroundStation.this;
                sensethinkGroundStation.f6659x = sensethinkGroundStation.m6699a(this, str, str2, str3).m9743a(new Consumer() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$c$lB7GwkX6lnEyRDF8wG-20wyyseQ
                    @Override // io.reactivex.p085b.Consumer
                    public final void accept(Object obj) {
                        SensethinkGroundStation.c.this.mDevicedUnbindDisposable((CallBackMsg) obj);
                    }
                }, new Consumer() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$c$7msPUOb1caPkhSfprcFKE55rYY0
                    @Override // io.reactivex.p085b.Consumer
                    public final void accept(Object obj) {
                        SensethinkGroundStation.c.this.m6796a((Throwable) obj);
                    }
                }, new InterfaceC2824a() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$c$DUsTOyVnf15qc4xHzE6b7yiVtac
                    @Override // io.reactivex.p085b.InterfaceC2824a
                    public final void run() {
                        SensethinkGroundStation.c.this.m6800l();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void mDevicedUnbindDisposable(CallBackMsg callBackMsg) throws Exception {
            SensethinkGroundStation.logger.conditionalLog3((Object) "mDevicedUnbindDisposable success.");
            SensethinkGroundStation.this.onEvent(65567, (Object) new NvError(0, "device unbind success", this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void m6796a(Throwable th) throws Exception {
            SensethinkGroundStation.logger.log((Object) "mDevicedUnbindDisposable err.");
            if (!(th instanceof NvException)) {
                th = new NvException(th.getMessage(), th, new NvError(255, th.getMessage(), this));
            }
            SensethinkGroundStation.this.a(16711688, ((NvException) th).getError());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: l */
        public /* synthetic */ void m6800l() throws Exception {
            SensethinkGroundStation.logger.conditionalLog3((Object) "mDevicedUnbindDisposable done.");
            SensethinkGroundStation.this.f6659x.dispose();
            SensethinkGroundStation.this.f6659x = null;
        }

        /* renamed from: k */
        void m6808k() {
            getChannel().mo6518e();
            getVideoChannel().mo6518e();
        }

        @Override // com.navatics.robot.transport.NvSocket
        /* renamed from: j */
        public void closeConnection() throws IOException {
            if (hasClosedConnection()) {
                return;
            }
            super.closeConnection();
            SensethinkGroundStation.logger.conditionalLog2("close connection");
            SensethinkGroundStation.this.m6783a((NvSocket) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SensethinkGroundStation.java */
    /* renamed from: com.navatics.robot.transport.ss.d$b */
    /* loaded from: classes2.dex */
    public class b extends NvChannel implements IoHandler {

        /* renamed from: b */
        c f6670b;

        /* renamed from: c */
        SenseThinkIoChannel f6671c;

        b(c cVar, int i) {
            super(i, 1, 6, 1);
            this.f6670b = cVar;
            this.f6671c = SenseThinkIoChannel.m6681d();
            this.f6671c.m6507a(IoChannel.IoMode.NONBLOCKING);
        }

        @Override // com.navatics.robot.transport.NvChannel
        /* renamed from: e */
        public void mo6518e() {
            if (m6519f()) {
                return;
            }
            super.mo6518e();
            m6791j();
            try {
                try {
                    this.f6671c.m6687e();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } finally {
                this.f6671c = null;
            }
        }

        @Override // com.navatics.robot.transport.NvChannel
        /* renamed from: d */
        public void mo6517d() {
            if (m6520g()) {
                return;
            }
            if (m6519f()) {
                throw new IllegalStateException("can't start a channel already been closed.");
            }
            super.mo6517d();
            m6790i();
        }

        @Override // com.navatics.robot.transport.NvChannel
        /* renamed from: c */
        public void mo6516c() {
            if (m6520g()) {
                super.mo6516c();
                m6791j();
            }
        }

        /* renamed from: i */
        private void m6790i() {
            NvSelector selector = NvTransport.getSelector();
            if (selector == null) {
                throw new NvException(new NvError(48, "NvTransport.getSelector() is null"));
            }
            selector.m6671a(this.f6671c, 2, this);
            m6792k();
        }

        /* renamed from: j */
        private void m6791j() {
            m6793l();
            NvSelector selector = NvTransport.getSelector();
            if (selector == null) {
                throw new NvException(new NvError(48, "NvTransport.getSelector() is null"));
            }
            selector.m6670a(this.f6671c);
        }

        /* renamed from: k */
        private void m6792k() {
            if (!SPUsb.getInstance().checkUsb()) {
                SensethinkGroundStation.logger.log((Object) "please open usb connection to the controller first.");
            } else {
                SPRc.getInstance().setRcCommond(true);
            }
        }

        /* renamed from: l */
        private void m6793l() {
            if (!SPUsb.getInstance().checkUsb()) {
                SensethinkGroundStation.logger.log((Object) "please open usb connection to the controller first.");
            } else {
                SPRc.getInstance().setRcCommond(false);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:38:0x00b2, code lost:
        
            if (0 == 0) goto L33;
         */
        @Override // com.navatics.robot.transport.IoHandler
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void mo6620a(int r8, com.navatics.robot.transport.IoChannel r9) {
            /*
                r7 = this;
                boolean r0 = r7.m6519f()
                if (r0 == 0) goto L10
                org.apache.log4j.k r8 = com.navatics.robot.transport.ss.SensethinkGroundStation.m6773q()
                java.lang.String r9 = "receive data after channel closed."
                r8.conditionalLog2(r9)
                return
            L10:
                r8 = r8 & 2
                if (r8 == 0) goto Lc4
                com.navatics.robot.transport.g r8 = com.navatics.robot.transport.IoBuffer.m6615e()
                if (r8 != 0) goto L24
                org.apache.log4j.k r8 = com.navatics.robot.transport.ss.SensethinkGroundStation.m6773q()
                java.lang.String r9 = "Failed to apply for IoBuffer."
                r8.log(r9)
                return
            L24:
                r0 = 0
                int r9 = r9.mo6505a(r8)     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                if (r9 <= 0) goto L7d
                com.navatics.robot.transport.p r9 = r7.m6515b()     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                if (r9 == 0) goto L71
                r2 = 131073(0x20001, float:1.83672E-40)
                byte[] r3 = r8.mo6583a()     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                r4 = 1
                r5 = 0
                int r6 = r8.mo6585c()     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                r1 = r7
                com.navatics.robot.transport.n r0 = com.navatics.robot.transport.NvEvent.onEvent(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                if (r0 == 0) goto L4d
                com.navatics.robot.transport.p r9 = r7.m6515b()     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                r9.handleEvent(r0)     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                goto L7a
            L4d:
                org.apache.log4j.k r9 = com.navatics.robot.transport.ss.SensethinkGroundStation.m6773q()     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                r1.<init>()     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                java.lang.String r2 = "NvEvent.obtain failed, will miss message, length = "
                r1.append(r2)     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                int r2 = r8.mo6585c()     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                r1.append(r2)     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                r9.log(r1)     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                java.lang.String r1 = "Can't obtain NvEvent."
                r9.<init>(r1)     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                throw r9     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
            L71:
                org.apache.log4j.k r9 = com.navatics.robot.transport.ss.SensethinkGroundStation.m6773q()     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                java.lang.String r1 = "Will discard this data because no eventHandler attached to this channel."
                r9.conditionalLog2(r1)     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
            L7a:
                if (r0 == 0) goto Lb7
                goto Lb4
            L7d:
                org.apache.log4j.k r1 = com.navatics.robot.transport.ss.SensethinkGroundStation.m6773q()     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                r2.<init>()     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                java.lang.String r3 = "onIoEvent readLen "
                r2.append(r3)     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                r2.append(r9)     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                r1.log(r2)     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                java.io.IOException r1 = new java.io.IOException     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                r2.<init>()     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                java.lang.String r3 = "readLen is "
                r2.append(r3)     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                r2.append(r9)     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                java.lang.String r9 = r2.toString()     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                r1.<init>(r9)     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                throw r1     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
            Lac:
                r9 = move-exception
                goto Lbb
            Lae:
                r9 = move-exception
                r9.printStackTrace()     // Catch: java.lang.Throwable -> Lac
                if (r0 == 0) goto Lb7
            Lb4:
                r0.m6659b()
            Lb7:
                r8.mo6586d()
                goto Lc4
            Lbb:
                if (r0 == 0) goto Lc0
                r0.m6659b()
            Lc0:
                r8.mo6586d()
                throw r9
            Lc4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.navatics.robot.transport.ss.SensethinkGroundStation.b.mo6620a(int, com.navatics.robot.transport.IoChannel):void");
        }

        @Override // com.navatics.robot.transport.NvChannel
        /* renamed from: a */
        public int mo6512a(byte[] bArr) throws IOException {
            if (m6519f()) {
                StringBuilder sb = new StringBuilder();
                sb.append("[s:");
                sb.append(this.f6670b.getSocketId());
                sb.append("]");
                throw new IOException(((Object) sb) + "write operation detected after channel closed.");
            }
            SenseThinkIoChannel senseThinkIoChannel = this.f6671c;
            if (senseThinkIoChannel == null) {
                SensethinkGroundStation.logger.log((Object) ("ioChannel is null, State : " + m6513a()));
                return -1;
            }
            return senseThinkIoChannel.m6685a(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SensethinkGroundStation.java */
    /* renamed from: com.navatics.robot.transport.ss.d$d */
    /* loaded from: classes2.dex */
    public class d extends NvVideoChannel implements VideoInputStream.a {

        /* renamed from: c */
        private SsVideoInputStream f6675c;

        d(c cVar, int i) {
            super(i);
            this.f6506a = NvChannel.State.RUNNING;
        }

        @Override // com.navatics.robot.transport.NvVideoChannel
        /* renamed from: i */
        public InputStream mo6809i() throws IOException {
            if (this.f6675c != null) {
                throw new IOException("someone is using the input stream of this channel now.");
            }
            this.f6675c = new SsVideoInputStream(SPUsb.getInstance().getUsb());
            this.f6675c.addOnClosedListener(this);
            return this.f6675c;
        }

        @Override // com.navatics.robot.transport.VideoInputStream.a
        /* renamed from: a */
        public void mo6544a(VideoInputStream videoInputStream) {
            this.f6675c.removeOnClosedListener(this);
            this.f6675c = null;
        }

        @Override // com.navatics.robot.transport.NvVideoChannel
        /* renamed from: j */
        public boolean mo6810j() {
            SsVideoInputStream ssVideoInputStream = this.f6675c;
            return ssVideoInputStream == null || ssVideoInputStream.m6824a();
        }

        @Override // com.navatics.robot.transport.NvChannel
        /* renamed from: e */
        public void mo6518e() {
            super.mo6518e();
            SsVideoInputStream ssVideoInputStream = this.f6675c;
            if (ssVideoInputStream != null) {
                try {
                    ssVideoInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}