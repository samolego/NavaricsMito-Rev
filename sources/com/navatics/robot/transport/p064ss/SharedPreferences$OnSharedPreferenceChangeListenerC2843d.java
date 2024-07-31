package com.navatics.robot.transport.p064ss;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.graphics.drawable.PathInterpolatorCompat;
import android.support.p008v4.view.InputDeviceCompat;
import android.util.Log;
import com.navatics.robot.transport.AbstractC2794ab;
import com.navatics.robot.transport.AbstractC2856t;
import com.navatics.robot.transport.AbstractC2867y;
import com.navatics.robot.transport.C2830m;
import com.navatics.robot.transport.C2831n;
import com.navatics.robot.transport.C2834q;
import com.navatics.robot.transport.C2835s;
import com.navatics.robot.transport.C2857u;
import com.navatics.robot.transport.InterfaceC2818e;
import com.navatics.robot.transport.InterfaceC2822i;
import com.navatics.robot.transport.InterfaceC2823j;
import com.navatics.robot.transport.InterfaceC2833p;
import com.navatics.robot.transport.IoChannel;
import com.navatics.robot.transport.NvAddress;
import com.navatics.robot.transport.NvAddressExtra;
import com.navatics.robot.transport.NvChannel;
import com.navatics.robot.transport.NvDeviceInfo;
import com.navatics.robot.transport.NvException;
import com.navatics.robot.transport.ProtoMeta;
import com.navatics.robot.transport.TransportType;
import com.navatics.robot.transport.p064ss.SensethinkGroundStation;
import com.navatics.robot.utils.C2904n;
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
import com.takisoft.fix.support.p069v7.preference.PreferenceFragmentCompatDividers;
import hu.akarnokd.rxjava2.consumers.C3798b;
import io.reactivex.AbstractC3979j;
import io.reactivex.InterfaceC3981k;
import io.reactivex.InterfaceC3982l;
import io.reactivex.disposables.C3876a;
import io.reactivex.disposables.InterfaceC3877b;
import io.reactivex.p093a.p095b.C3857a;
import io.reactivex.p096b.InterfaceC3864a;
import io.reactivex.p096b.InterfaceC3868e;
import io.reactivex.p099e.C3880a;
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
public class SensethinkGroundStation implements SharedPreferences.OnSharedPreferenceChangeListener, InterfaceC2818e {

    /* renamed from: a */
    private static final String f6599a = "d";

    /* renamed from: b */
    private static final Logger logger = Logger.m1561a(SensethinkGroundStation.class);

    /* renamed from: A */
    private InterfaceC3877b f6601A;

    /* renamed from: B */
    private InterfaceC2833p f6602B;

    /* renamed from: D */
    private C2851c f6603D;

    /* renamed from: G */
    private C2840a f6604G;

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
    private long f6610i;

    /* renamed from: j */
    private boolean f6611j;

    /* renamed from: k */
    private boolean f6612k;

    /* renamed from: l */
    private boolean f6613l;

    /* renamed from: m */
    private List<ProtoMeta> f6614m;

    /* renamed from: n */
    private DeviceInfo f6615n;

    /* renamed from: o */
    private NvDeviceInfo f6616o;

    /* renamed from: p */
    private BatteryStatus f6617p;

    /* renamed from: q */
    private int f6618q;

    /* renamed from: r */
    private int f6619r;

    /* renamed from: s */
    private int f6620s;

    /* renamed from: t */
    private long f6621t;

    /* renamed from: u */
    private InterfaceC3877b f6622u;

    /* renamed from: v */
    private InterfaceC3877b f6623v;

    /* renamed from: w */
    private InterfaceC3877b f6624w;

    /* renamed from: x */
    private InterfaceC3877b f6625x;

    /* renamed from: y */
    private InterfaceC3877b f6626y;

    /* renamed from: z */
    private InterfaceC3877b f6627z;

    /* renamed from: h */
    private boolean f6628h = false;

    /* renamed from: C */
    private HashMap<String, NvDeviceInfo> f6629C = new HashMap<>();

    /* renamed from: E */
    private C2848a f6630E = new C2848a();

    /* renamed from: F */
    private C3876a f6631F = new C3876a();

    @Override // com.navatics.robot.transport.InterfaceC2818e
    /* renamed from: l */
    public int mo6092l() {
        return 1;
    }

    public SensethinkGroundStation(DeviceInfo deviceInfo) {
        if (deviceInfo == null) {
            throw new RuntimeException("rc info is null");
        }
        this.f6614m = new ArrayList();
        this.f6614m.add(new ProtoMeta("Dawn", 7));
        this.f6615n = deviceInfo;
        this.f6616o = new NvDeviceInfo(3, new NvAddress(TransportType.SensethinkWireless, this.f6615n.getSerialNo()), String.valueOf(this.f6615n.getModelID()), String.valueOf(this.f6615n.getManufacturerID()), this.f6615n.getSerialNo(), this.f6615n.getManufactureDate(), String.valueOf(this.f6615n.getHardwareVersion()), String.valueOf(this.f6615n.getFirmwareVersion()), this.f6615n.getFirmwareVersionStr(), this.f6614m);
        m6082s();
        m6081t();
        SPSearch.getInstance().getLinkInfo(this.f6630E);
    }

    /* renamed from: s */
    private void m6082s() {
        Context m6013a = C2857u.m6013a();
        SharedPreferences sharedPreferences = m6013a.getSharedPreferences("developer_setting", 0);
        this.enableAuth = sharedPreferences.getBoolean("enableAuth", m6013a.getResources().getBoolean(R.bool.enable_auth));
        this.enableSimulateSenseThinkApi = sharedPreferences.getBoolean("enableSimulateSenseThinkApi", m6013a.getResources().getBoolean(R.bool.enable_simulate_sensethink_api));
        this.controllerBindResult = sharedPreferences.getBoolean("controllerBindResult", m6013a.getResources().getBoolean(R.bool.controller_bind_result));
        this.rollerBindResult = sharedPreferences.getBoolean("rollerBindResult", m6013a.getResources().getBoolean(R.bool.roller_bind_result));
        this.alwaysNotifySearchResult = sharedPreferences.getBoolean("alwaysNotifySearchResult", m6013a.getResources().getBoolean(R.bool.always_notify_search_result));
    }

    /* renamed from: t */
    private void m6081t() {
        Logger logger2 = logger;
        logger2.mo1508a((Object) ("SimulateSenseThinkSdkApi " + this.enableSimulateSenseThinkApi));
        Logger logger3 = logger;
        logger3.mo1508a((Object) ("SimulateControllerActiveResultTrue " + this.controllerBindResult));
        Logger logger4 = logger;
        logger4.mo1508a((Object) ("SimulateDeviceActiveResultTrue " + this.rollerBindResult));
    }

    /* renamed from: u */
    private void m6080u() {
        this.f6612k = false;
        this.f6611j = false;
        this.f6613l = false;
        this.f6617p = null;
        InterfaceC3877b interfaceC3877b = this.f6622u;
        if (interfaceC3877b != null) {
            interfaceC3877b.dispose();
        }
        InterfaceC3877b interfaceC3877b2 = this.f6623v;
        if (interfaceC3877b2 != null) {
            interfaceC3877b2.dispose();
        }
        InterfaceC3877b interfaceC3877b3 = this.f6624w;
        if (interfaceC3877b3 != null) {
            interfaceC3877b3.dispose();
        }
        InterfaceC3877b interfaceC3877b4 = this.f6625x;
        if (interfaceC3877b4 != null) {
            interfaceC3877b4.dispose();
        }
        InterfaceC3877b interfaceC3877b5 = this.f6626y;
        if (interfaceC3877b5 != null) {
            interfaceC3877b5.dispose();
        }
        InterfaceC3877b interfaceC3877b6 = this.f6627z;
        if (interfaceC3877b6 != null) {
            interfaceC3877b6.dispose();
        }
        InterfaceC3877b interfaceC3877b7 = this.f6601A;
        if (interfaceC3877b7 != null) {
            interfaceC3877b7.dispose();
        }
        this.f6622u = null;
        this.f6623v = null;
        this.f6624w = null;
        this.f6625x = null;
        this.f6626y = null;
        this.f6627z = null;
        this.f6601A = null;
        this.f6629C.clear();
        SPSearch.getInstance().getLinkInfo(null);
        try {
            m6075z();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f6631F.dispose();
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        SharedPreferences sharedPreferences2 = C2857u.m6013a().getSharedPreferences("developer_setting", 0);
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
    public void m6188a(int i) {
        C2831n.m6238b(this.f6602B, this, i, null).m6257a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6186a(int i, Object obj) {
        C2831n.m6238b(this.f6602B, this, i, obj).m6257a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public void m6079v() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f6621t > 1000) {
            this.f6621t = currentTimeMillis;
            C2831n.m6234c(this.f6602B, this, IjkMediaPlayer.OnNativeInvokeListener.CTRL_WILL_HTTP_OPEN, this).m6257a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6187a(int i, C2830m c2830m) {
        C2831n.m6249a(this.f6602B, this, i, c2830m).m6257a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public void m6085p() {
        if (this.f6628h) {
            return;
        }
        this.f6628h = true;
        m6080u();
        C2831n.m6238b(this.f6602B, this, 65549, Long.valueOf(this.f6610i)).m6257a();
    }

    @Override // com.navatics.robot.transport.InterfaceC2818e
    /* renamed from: a */
    public long mo6189a() {
        return this.f6610i;
    }

    @Override // com.navatics.robot.transport.InterfaceC2818e
    /* renamed from: a */
    public void mo6184a(long j) {
        this.f6610i = j;
    }

    @Override // com.navatics.robot.transport.InterfaceC2818e
    /* renamed from: a */
    public void mo6179a(@NonNull InterfaceC2833p interfaceC2833p) {
        this.f6602B = interfaceC2833p;
    }

    @Override // com.navatics.robot.transport.InterfaceC2818e
    /* renamed from: a */
    public InterfaceC2823j mo6183a(Context context) {
        if (this.f6604G == null) {
            this.f6604G = new C2840a(context);
        }
        return this.f6604G;
    }

    @Override // com.navatics.robot.transport.InterfaceC2818e
    /* renamed from: b */
    public NvDeviceInfo mo6136b() {
        return this.f6616o;
    }

    @Override // com.navatics.robot.transport.InterfaceC2818e
    /* renamed from: c */
    public int mo6122c() {
        return this.f6619r;
    }

    @Override // com.navatics.robot.transport.InterfaceC2818e
    /* renamed from: d */
    public int mo6111d() {
        return this.f6620s;
    }

    @Override // com.navatics.robot.transport.InterfaceC2818e
    /* renamed from: e */
    public int mo6106e() {
        return this.f6618q;
    }

    @Override // com.navatics.robot.transport.InterfaceC2818e
    /* renamed from: f */
    public int mo6104f() {
        BatteryStatus batteryStatus = this.f6617p;
        if (batteryStatus != null) {
            return batteryStatus.energyLevel;
        }
        return 0;
    }

    /* renamed from: w */
    private AbstractC3979j<DeviceInfo> m6078w() {
        return AbstractC3979j.m3094a((InterfaceC3982l) new InterfaceC3982l() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$S1J8xZg5v89aCqNo5u-TGFC7mog
            @Override // io.reactivex.InterfaceC3982l
            public final void subscribe(InterfaceC3981k interfaceC3965k) {
                SensethinkGroundStation.m6154a(interfaceC3965k);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m6154a(final InterfaceC3981k interfaceC3981k) throws Exception {
        SPDevice.getInstance().getDevInfo(new MCallBack() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$wSIdiZHRIIrqTMhPZ_LGKdAjpGE
            @Override // com.senseplay.mframe.client.MCallBack
            /* renamed from: onResult */
            public final void mo9395a(Object obj) {
                SensethinkGroundStation.m6151a(interfaceC3981k, (DeviceInfo) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m6151a(InterfaceC3981k interfaceC3981k, DeviceInfo deviceInfo) {
        interfaceC3981k.onNext(deviceInfo);
        interfaceC3981k.onComplete();
    }

    @Override // com.navatics.robot.transport.InterfaceC2818e
    /* renamed from: g */
    public void mo6102g() {
        if (this.enableAuth) {
            m6077x();
            if (this.f6613l) {
                logger.mo1508a((Object) "still in searching, ignore.");
                return;
            }
            logger.mo1497c((Object) "start searching...");
            this.f6613l = true;
            this.f6629C.clear();
            m6188a(65537);
            SPSearch.getInstance().deviceSearch(new DeviceSearchListener() { // from class: com.navatics.robot.transport.ss.d.1
                @Override // com.senseplay.sdk.cache.DeviceSearchListener
                public void search(DeviceInfo deviceInfo) {
                    if (SensethinkGroundStation.this.f6628h) {
                        SensethinkGroundStation.logger.mo1496d("deviceSearch receive device search callback after destroy");
                    } else if (!SensethinkGroundStation.this.f6613l) {
                        SensethinkGroundStation.logger.mo1496d("DeviceSearch receive device search callback but we are not in search right now.");
                    } else if (SensethinkGroundStation.this.f6626y != null || SensethinkGroundStation.this.f6603D != null) {
                        Logger logger2 = SensethinkGroundStation.logger;
                        logger2.mo1508a((Object) ("DeviceSearch callback, mDevConnDisposable " + SensethinkGroundStation.this.f6626y + ", mActiveConn " + SensethinkGroundStation.this.f6603D));
                    } else if (deviceInfo == null) {
                        SensethinkGroundStation.logger.log((Object) "Search callback got deviceInfo is null");
                    } else if (C2904n.m5850a((CharSequence) deviceInfo.getLinkID())) {
                        Logger logger3 = SensethinkGroundStation.logger;
                        logger3.log((Object) ("Device : " + deviceInfo.getSerialNo() + ", linkID is null"));
                    } else {
                        String serialNo = deviceInfo.getSerialNo();
                        if (C2904n.m5850a((CharSequence) serialNo) || !serialNo.startsWith("STMAEP")) {
                            Logger logger4 = SensethinkGroundStation.logger;
                            logger4.mo1496d("Found a device not our product : sn(" + serialNo + "), skip it.");
                        } else if (SensethinkGroundStation.this.f6629C.containsKey(serialNo)) {
                            Logger logger5 = SensethinkGroundStation.logger;
                            logger5.mo1508a((Object) ("Found a device already exist in search result list : " + serialNo));
                        } else {
                            NvDeviceInfo nvDeviceInfo = new NvDeviceInfo(2, new NvAddress(TransportType.SensethinkWireless, deviceInfo.getSerialNo(), new C2843b(deviceInfo)), String.valueOf(deviceInfo.getModelID()), String.valueOf(deviceInfo.getManufacturerID()), deviceInfo.getSerialNo(), deviceInfo.getManufactureDate(), String.valueOf(deviceInfo.getHardwareVersion()), String.valueOf(deviceInfo.getFirmwareVersion()), SensethinkGroundStation.this.f6614m);
                            Logger logger6 = SensethinkGroundStation.logger;
                            logger6.mo1497c((Object) ("Found device : " + nvDeviceInfo));
                            SensethinkGroundStation.this.f6629C.put(deviceInfo.getSerialNo(), nvDeviceInfo);
                            SensethinkGroundStation sensethinkGroundStation = SensethinkGroundStation.this;
                            sensethinkGroundStation.m6186a((int) PreferenceFragmentCompatDividers.DIVIDER_DEFAULT, new ArrayList(sensethinkGroundStation.f6629C.values()));
                        }
                    }
                }

                @Override // com.senseplay.sdk.cache.DeviceSearchListener
                public void finish() {
                    SensethinkGroundStation.logger.mo1497c((Object) "search stopped.");
                    SensethinkGroundStation.this.f6613l = false;
                    SensethinkGroundStation.this.m6188a(65538);
                }
            });
        }
    }

    @Override // com.navatics.robot.transport.InterfaceC2818e
    /* renamed from: h */
    public boolean mo6100h() {
        return this.f6623v != null;
    }

    @Override // com.navatics.robot.transport.InterfaceC2818e
    /* renamed from: i */
    public boolean mo6098i() {
        return this.f6622u != null;
    }

    @Override // com.navatics.robot.transport.InterfaceC2818e
    /* renamed from: j */
    public boolean mo6096j() {
        return this.f6613l;
    }

    @Override // com.navatics.robot.transport.InterfaceC2818e
    /* renamed from: m */
    public List<AbstractC2856t> mo6090m() {
        if (this.f6603D == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f6603D);
        return arrayList;
    }

    /* renamed from: a */
    private AbstractC3979j<Boolean> m6157a(final DeviceInfo deviceInfo) {
        if (deviceInfo == null) {
            return AbstractC3979j.m3084a((Throwable) new NvException(new C2830m(49, "deviceInfo is null")));
        }
        Logger logger2 = logger;
        logger2.mo1497c((Object) ("deviceConnect, linkID " + deviceInfo.getLinkID() + ", serialNo " + deviceInfo.getSerialNo()));
        return AbstractC3979j.m3094a(new InterfaceC3982l() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$BEQzCMYSAtaknJrfcb27XsUR1f8
            @Override // io.reactivex.InterfaceC3982l
            public final void subscribe(InterfaceC3981k interfaceC3965k) {
                SensethinkGroundStation.m6155a(deviceInfo, interfaceC3965k);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m6155a(DeviceInfo deviceInfo, final InterfaceC3981k interfaceC3981k) throws Exception {
        SPSearch.getInstance().deviceLink(deviceInfo.getLinkID(), deviceInfo.getSerialNo(), new MCallBack() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$K_UhNWydaEtHNqLRJ01P7LQiuL4
            @Override // com.senseplay.mframe.client.MCallBack
            /* renamed from: onResult */
            public final void mo9395a(Object obj) {
                SensethinkGroundStation.m6149a(interfaceC3981k, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m6149a(InterfaceC3981k interfaceC3981k, Boolean bool) {
        if (bool.booleanValue()) {
            interfaceC3981k.onNext(bool);
            interfaceC3981k.onComplete();
            return;
        }
        interfaceC3981k.onError(new NvException(new C2830m(68, "failed to connect to device")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public AbstractC3979j<DeviceUser> m6148a(final String str) {
        return AbstractC3979j.m3094a(new InterfaceC3982l() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$fBKxwcmVgZYGvh69CaBhPUnBFrE
            @Override // io.reactivex.InterfaceC3982l
            public final void subscribe(InterfaceC3981k interfaceC3965k) {
                SensethinkGroundStation.m6114c(str, interfaceC3965k);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static /* synthetic */ void m6114c(String str, final InterfaceC3981k interfaceC3981k) throws Exception {
        SPDevice.getInstance().verifyUid(str, new MCallBack() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$e6wNnBllgfDGR5u9D6vSl-cxBR8
            @Override // com.senseplay.mframe.client.MCallBack
            /* renamed from: onResult */
            public final void mo9395a(Object obj) {
                SensethinkGroundStation.m6127b(interfaceC3981k, (DeviceUser) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m6127b(InterfaceC3981k interfaceC3981k, DeviceUser deviceUser) {
        interfaceC3981k.onNext(deviceUser);
        interfaceC3981k.onComplete();
    }

    /* renamed from: b */
    private AbstractC3979j<DeviceUser> m6126b(final String str) {
        return AbstractC3979j.m3094a(new InterfaceC3982l() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$UF_FV0-wh94-3trzgE71xGZru9Q
            @Override // io.reactivex.InterfaceC3982l
            public final void subscribe(InterfaceC3981k interfaceC3965k) {
                SensethinkGroundStation.m6125b(str, interfaceC3965k);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m6125b(String str, final InterfaceC3981k interfaceC3981k) throws Exception {
        SPRc.getInstance().verifyUid(str, new MCallBack() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$23oBtIBkuBo7jOawDA6slD1_tiQ
            @Override // com.senseplay.mframe.client.MCallBack
            /* renamed from: onResult */
            public final void mo9395a(Object obj) {
                SensethinkGroundStation.m6150a(interfaceC3981k, (DeviceUser) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m6150a(InterfaceC3981k interfaceC3981k, DeviceUser deviceUser) {
        interfaceC3981k.onNext(deviceUser);
        interfaceC3981k.onComplete();
    }

    /* renamed from: x */
    private void m6077x() {
        if (this.f6628h) {
            throw new RuntimeException("This GroundStation is already invalid.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public C2851c m6182a(NvDeviceInfo nvDeviceInfo) {
        C2851c c2851c = new C2851c(nvDeviceInfo, true);
        C2850b c2850b = new C2850b(c2851c, 1);
        C2852d c2852d = new C2852d(c2851c, 2);
        c2851c.m6029a(c2850b);
        c2851c.m6028a((AbstractC2867y) c2852d);
        return c2851c;
    }

    @Override // com.navatics.robot.transport.InterfaceC2818e
    /* renamed from: a */
    public void mo6180a(final NvDeviceInfo nvDeviceInfo, Map<String, Object> map) {
        m6077x();
        if (this.enableAuth) {
            NvAddressExtra extra = nvDeviceInfo.getAddress().getExtra();
            final DeviceInfo m6212a = ((C2843b) extra).m6212a();
            if (!extra.isValidate()) {
                String str = "addressExtra is not valid : " + extra.toString();
                logger.log((Object) str);
                m6187a(16711681, new C2830m(49, str, nvDeviceInfo));
            } else if (this.f6626y != null) {
                logger.log((Object) "already in connecting...");
            } else {
                logger.mo1497c((Object) ("connecting to device : " + nvDeviceInfo));
                if (this.f6613l) {
                    this.f6613l = false;
                }
                this.f6626y = m6157a(m6212a).m3072b(C3880a.m3214b()).m3103a(new InterfaceC3868e() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$0MWFbzBmH5F0qxyf_tI-fbQcQRs
                    @Override // io.reactivex.p096b.InterfaceC3868e
                    /* renamed from: accept */
                    public final void mo9497a(Object obj) {
                        SensethinkGroundStation.this.m6156a(m6212a, nvDeviceInfo, (Boolean) obj);
                    }
                }, new InterfaceC3868e() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$jlmhF8ooisaB7BW9cwtjzKH1hGM
                    @Override // io.reactivex.p096b.InterfaceC3868e
                    /* renamed from: accept */
                    public final void mo9497a(Object obj) {
                        SensethinkGroundStation.this.m6181a(nvDeviceInfo, (Throwable) obj);
                    }
                }, new InterfaceC3864a() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$XVGwcFfgGmlyWrZbH4PgIP8tKfQ
                    @Override // io.reactivex.p096b.InterfaceC3864a
                    public final void run() {
                        SensethinkGroundStation.this.m6190D();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m6156a(DeviceInfo deviceInfo, NvDeviceInfo nvDeviceInfo, Boolean bool) throws Exception {
        Logger logger2 = logger;
        logger2.mo1508a((Object) ("deviceConnect result, isLinked -> " + bool));
        this.f6629C.remove(deviceInfo.getSerialNo());
        this.f6603D = m6182a(nvDeviceInfo);
        m6186a(InputDeviceCompat.SOURCE_TRACKBALL, this.f6603D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m6181a(NvDeviceInfo nvDeviceInfo, Throwable th) throws Exception {
        if (!(th instanceof NvException)) {
            th = new NvException(th.getMessage(), th, new C2830m(255, th.getMessage()));
        }
        C2830m error = ((NvException) th).getError();
        error.m6260a(nvDeviceInfo);
        m6187a(16711681, error);
        this.f6626y.dispose();
        this.f6626y = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public /* synthetic */ void m6190D() throws Exception {
        logger.mo1508a((Object) "deviceConnect finish");
        this.f6626y.dispose();
        this.f6626y = null;
    }

    /* renamed from: a */
    public void m6159a(AbstractC2856t abstractC2856t) {
        if (abstractC2856t == this.f6603D) {
            m6075z();
            SPDevice.getInstance().disConnect();
        }
    }

    @Override // com.navatics.robot.transport.InterfaceC2818e
    /* renamed from: n */
    public boolean mo6088n() {
        m6077x();
        if (this.enableAuth) {
            return this.f6611j;
        }
        return true;
    }

    @Override // com.navatics.robot.transport.InterfaceC2818e
    /* renamed from: k */
    public boolean mo6094k() {
        return !this.f6628h;
    }

    /* renamed from: a */
    private AbstractC3979j<CallBackMsg> m6146a(final String str, final String str2) {
        return AbstractC3979j.m3094a(new InterfaceC3982l() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$y6gmwigaC2RDBFkTPoJ7qcKX63I
            @Override // io.reactivex.InterfaceC3982l
            public final void subscribe(InterfaceC3981k interfaceC3965k) {
                SensethinkGroundStation.this.m6145a(str, str2, interfaceC3965k);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m6145a(String str, String str2, final InterfaceC3981k interfaceC3981k) throws Exception {
        MCallBack mCallBack = new MCallBack() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$m3DC2LQSda8zgNSvPnsmPngnNhQ
            @Override // com.senseplay.mframe.client.MCallBack
            /* renamed from: onResult */
            public final void mo9395a(Object obj) {
                SensethinkGroundStation.this.m6107d(interfaceC3981k, (CallBackMsg) obj);
            }
        };
        Method declaredMethod = SPRc.class.getDeclaredMethod("setUid", String.class, String.class, MCallBack.class);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(SPRc.getInstance(), str, str2, mCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m6107d(InterfaceC3981k interfaceC3981k, CallBackMsg callBackMsg) {
        if (callBackMsg.getCode() == 0) {
            interfaceC3981k.onNext(callBackMsg);
            interfaceC3981k.onComplete();
            return;
        }
        interfaceC3981k.onError(new NvException(new C2830m(49, callBackMsg.getMessage(), this)));
    }

    /* renamed from: c */
    private AbstractC3979j<CallBackMsg> m6115c(final String str) {
        return AbstractC3979j.m3094a(new InterfaceC3982l() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$Fb7W_xQ1hEAaUZtPjIK9JM94198
            @Override // io.reactivex.InterfaceC3982l
            public final void subscribe(InterfaceC3981k interfaceC3965k) {
                SensethinkGroundStation.this.m6147a(str, interfaceC3965k);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m6147a(String str, final InterfaceC3981k interfaceC3981k) throws Exception {
        MCallBack mCallBack = new MCallBack() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$Ulo0vtXR4eM-0WLJ1fJ4tWfrJQc
            @Override // com.senseplay.mframe.client.MCallBack
            /* renamed from: onResult */
            public final void mo9395a(Object obj) {
                SensethinkGroundStation.this.m6116c(interfaceC3981k, (CallBackMsg) obj);
            }
        };
        Method declaredMethod = SPRc.class.getDeclaredMethod("deleteUid", String.class, MCallBack.class);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(SPRc.getInstance(), str, mCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m6116c(InterfaceC3981k interfaceC3981k, CallBackMsg callBackMsg) {
        if (callBackMsg.getCode() == 0) {
            logger.mo1497c((Object) "remote deactivate success !!!!!!!!!!!!!!");
            interfaceC3981k.onNext(callBackMsg);
            interfaceC3981k.onComplete();
            return;
        }
        interfaceC3981k.onError(new NvException(new C2830m(65, "remote deactivate success", this)));
    }

    /* renamed from: a */
    private AbstractC3979j<CallBackMsg> m6175a(final C2851c c2851c, final String str, final String str2) {
        return AbstractC3979j.m3094a(new InterfaceC3982l() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$ZWHqVTSt1uAanPmTRXlfdHU2qBg
            @Override // io.reactivex.InterfaceC3982l
            public final void subscribe(InterfaceC3981k interfaceC3965k) {
                SensethinkGroundStation.m6174a(c2851c, str, str2, interfaceC3965k);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m6174a(final C2851c c2851c, String str, String str2, final InterfaceC3981k interfaceC3981k) throws Exception {
        MCallBack mCallBack = new MCallBack() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$Ne40WqnDCleExqsgwPpyfP2d4Do
            @Override // com.senseplay.mframe.client.MCallBack
            /* renamed from: onResult */
            public final void mo9395a(Object obj) {
                SensethinkGroundStation.m6108d(interfaceC3981k, c2851c, (CallBackMsg) obj);
            }
        };
        Method declaredMethod = SPDevice.class.getDeclaredMethod("setUid", String.class, String.class, MCallBack.class);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(SPDevice.getInstance(), str, str2, mCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static /* synthetic */ void m6108d(InterfaceC3981k interfaceC3981k, C2851c c2851c, CallBackMsg callBackMsg) {
        if (callBackMsg.getCode() == 0) {
            logger.mo1497c((Object) "activate success !!!!!!!!!!!!!!");
            interfaceC3981k.onNext(callBackMsg);
            interfaceC3981k.onComplete();
            return;
        }
        interfaceC3981k.onError(new NvException(new C2830m(49, callBackMsg.getMessage(), c2851c)));
    }

    /* renamed from: a */
    private AbstractC3979j<CallBackMsg> m6177a(final C2851c c2851c, final String str) {
        return AbstractC3979j.m3094a(new InterfaceC3982l() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$2lKlX_05HAIZ2SBeKP9yrPJpvXo
            @Override // io.reactivex.InterfaceC3982l
            public final void subscribe(InterfaceC3981k interfaceC3965k) {
                SensethinkGroundStation.m6176a(c2851c, str, interfaceC3965k);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m6176a(final C2851c c2851c, String str, final InterfaceC3981k interfaceC3981k) throws Exception {
        MCallBack mCallBack = new MCallBack() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$EuuRoL4MA_xUzNND5Yz60qGRUZE
            @Override // com.senseplay.mframe.client.MCallBack
            /* renamed from: onResult */
            public final void mo9395a(Object obj) {
                SensethinkGroundStation.m6117c(interfaceC3981k, c2851c, (CallBackMsg) obj);
            }
        };
        Method declaredMethod = SPDevice.class.getDeclaredMethod("deleteUid", String.class, MCallBack.class);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(SPDevice.getInstance(), str, mCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static /* synthetic */ void m6117c(InterfaceC3981k interfaceC3981k, C2851c c2851c, CallBackMsg callBackMsg) {
        if (callBackMsg.getCode() == 0) {
            logger.mo1497c((Object) "clear uid success !!!!!!!!!!!!!!");
            interfaceC3981k.onNext(callBackMsg);
            interfaceC3981k.onComplete();
            return;
        }
        interfaceC3981k.onError(new NvException(new C2830m(65, "clear uid failed", c2851c)));
    }

    /* renamed from: a */
    private String getErrorStringFromSensethinkErrorCode(int i, String str) {
        Logger logger2 = logger;
        logger2.log((Object) ("getErrorStringFromSensethinkErrorCode : " + i + ", ssMsg " + str));
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
    private AbstractC3979j<CallBackMsg> m6141a(final String str, final String str2, final String str3, final String str4) {
        if (this.enableSimulateSenseThinkApi) {
            if (this.controllerBindResult) {
                return m6146a(str2, str);
            }
            return AbstractC3979j.m3084a((Throwable) new NvException(new C2830m(254, "simulate remote active err", this)));
        }
        return AbstractC3979j.m3094a(new InterfaceC3982l() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$cxoj9Y3Yg17JueQdBWY4B_Zxx0g
            @Override // io.reactivex.InterfaceC3982l
            public final void subscribe(InterfaceC3981k interfaceC3965k) {
                SensethinkGroundStation.this.m6139a(str2, str, str3, str4, interfaceC3965k);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m6139a(String str, String str2, String str3, String str4, final InterfaceC3981k interfaceC3981k) throws Exception {
        Log.d("ContentValues", "rc绑定参数 ：uuId = " + str + ", rcSn = " + str2 + "， accessToken = " + str3 + ", verifyCode = " + str4);
        SPRc.getInstance().bindRc(str, str2, str3, str4, new MCallBack() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$53fvTjkpWrGmGfBbO9cxlvcGwek
            @Override // com.senseplay.mframe.client.MCallBack
            /* renamed from: onResult */
            public final void mo9395a(Object obj) {
                SensethinkGroundStation.this.m6128b(interfaceC3981k, (CallBackMsg) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m6128b(InterfaceC3981k interfaceC3981k, CallBackMsg callBackMsg) {
        if (callBackMsg.getCode() == 0) {
            logger.mo1497c((Object) "activate success !!!!!!!!!!!!!!");
            interfaceC3981k.onNext(callBackMsg);
            interfaceC3981k.onComplete();
            return;
        }
        interfaceC3981k.onError(new NvException(new C2830m(49, getErrorStringFromSensethinkErrorCode(callBackMsg.getCode(), callBackMsg.getMessage()), this)));
    }

    /* renamed from: a */
    private AbstractC3979j<CallBackMsg> m6144a(final String str, final String str2, final String str3) {
        if (this.enableSimulateSenseThinkApi) {
            if (this.controllerBindResult) {
                return m6115c(str2);
            }
            return AbstractC3979j.m3084a((Throwable) new NvException(new C2830m(254, "simulate remote active err", this)));
        }
        return AbstractC3979j.m3094a(new InterfaceC3982l() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$ycDH85E0SFrjBYPWTAB68K4qWXw
            @Override // io.reactivex.InterfaceC3982l
            public final void subscribe(InterfaceC3981k interfaceC3965k) {
                SensethinkGroundStation.this.m6142a(str2, str, str3, interfaceC3965k);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m6142a(String str, String str2, String str3, final InterfaceC3981k interfaceC3981k) throws Exception {
        Log.d("ContentValues", "rc绑定参数 ：uuId = " + str + ", rcSn = " + str2 + "， accessToken = " + str3);
        SPRc.getInstance().unBindRc(str, str2, str3, new MCallBack() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$N7aTjzPe_IETI8QDzJ1TPtOWJIQ
            @Override // com.senseplay.mframe.client.MCallBack
            /* renamed from: onResult */
            public final void mo9395a(Object obj) {
                SensethinkGroundStation.this.m6152a(interfaceC3981k, (CallBackMsg) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m6152a(InterfaceC3981k interfaceC3981k, CallBackMsg callBackMsg) {
        if (callBackMsg.getCode() == 0) {
            logger.mo1497c((Object) "remote deactivate success !!!!!!!!!!!!!!");
            interfaceC3981k.onNext(callBackMsg);
            interfaceC3981k.onComplete();
            return;
        }
        interfaceC3981k.onError(new NvException(new C2830m(65, getErrorStringFromSensethinkErrorCode(callBackMsg.getCode(), callBackMsg.getMessage()), this)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})
    /* renamed from: a */
    public AbstractC3979j<CallBackMsg> m6172a(final C2851c c2851c, final String str, final String str2, final String str3, final String str4) {
        if (this.enableSimulateSenseThinkApi) {
            if (this.rollerBindResult) {
                return m6175a(c2851c, str2, str);
            }
            return AbstractC3979j.m3084a((Throwable) new NvException(new C2830m(254, "simulate remote active err", c2851c)));
        }
        return AbstractC3979j.m3094a(new InterfaceC3982l() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$7a9GMen1LmbLLtKu1DyVJs9olks
            @Override // io.reactivex.InterfaceC3982l
            public final void subscribe(InterfaceC3981k interfaceC3965k) {
                SensethinkGroundStation.this.m6140a(str2, str, str3, str4, c2851c, interfaceC3965k);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m6140a(String str, String str2, String str3, String str4, final C2851c c2851c, final InterfaceC3981k interfaceC3981k) throws Exception {
        Log.d("ContentValues", "rc绑定参数 ：uuId = " + str + ", rcSn = " + str2 + "， accessToken = " + str3 + ", verifyCode = " + str4);
        SPDevice.getInstance().bindDevice(str, str2, str3, str4, new MCallBack() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$CMxYC34NlcR-7iTakGOH3ffTudY
            @Override // com.senseplay.mframe.client.MCallBack
            /* renamed from: onResult */
            public final void mo9395a(Object obj) {
                SensethinkGroundStation.this.m6129b(interfaceC3981k, c2851c, (CallBackMsg) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m6129b(InterfaceC3981k interfaceC3981k, C2851c c2851c, CallBackMsg callBackMsg) {
        if (callBackMsg.getCode() == 0) {
            Log.i("ContentValues", "device activate success !!!!!!!!!!!!!!");
            interfaceC3981k.onNext(callBackMsg);
            interfaceC3981k.onComplete();
            return;
        }
        interfaceC3981k.onError(new NvException(new C2830m(49, getErrorStringFromSensethinkErrorCode(callBackMsg.getCode(), callBackMsg.getMessage()), c2851c)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public AbstractC3979j<CallBackMsg> m6173a(final C2851c c2851c, final String str, final String str2, final String str3) {
        if (this.enableSimulateSenseThinkApi) {
            if (this.rollerBindResult) {
                return m6177a(c2851c, str2);
            }
            return AbstractC3979j.m3084a((Throwable) new NvException(new C2830m(254, "simulate remote active err", c2851c)));
        }
        return AbstractC3979j.m3094a(new InterfaceC3982l() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$t7VOwOj9CKBMYSloVaZfDVlqQXs
            @Override // io.reactivex.InterfaceC3982l
            public final void subscribe(InterfaceC3981k interfaceC3965k) {
                SensethinkGroundStation.m6143a(str2, str, str3, c2851c, interfaceC3965k);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m6143a(String str, String str2, String str3, final C2851c c2851c, final InterfaceC3981k interfaceC3981k) throws Exception {
        Log.d("ContentValues", "rc绑定参数 ：uuId = " + str + ", rcSn = " + str2 + "， accessToken = " + str3);
        SPDevice.getInstance().unBindDevice(str, str2, str3, new MCallBack() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$k7cSgDmJYYW9sp1f8Dg2zpp1plo
            @Override // com.senseplay.mframe.client.MCallBack
            /* renamed from: onResult */
            public final void mo9395a(Object obj) {
                SensethinkGroundStation.m6153a(interfaceC3981k, c2851c, (CallBackMsg) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m6153a(InterfaceC3981k interfaceC3981k, C2851c c2851c, CallBackMsg callBackMsg) {
        if (callBackMsg.getCode() == 0) {
            Log.i("ContentValues", "device deactivate success !!!!!!!!!!!!!!");
            interfaceC3981k.onNext(callBackMsg);
            interfaceC3981k.onComplete();
            return;
        }
        interfaceC3981k.onError(new NvException(new C2830m(49, "device deactivate failed", c2851c)));
    }

    /* renamed from: y */
    private void m6076y() {
        this.f6611j = true;
        this.f6612k = true;
        m6186a(65546, (Object) new C2830m(0, "remote login success", this));
        C3798b.m3489a(m6078w(), this.f6631F, new InterfaceC3868e() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$eqZzm4du3YqN3mq8v2qO-bzKggI
            @Override // io.reactivex.p096b.InterfaceC3868e
            /* renamed from: accept */
            public final void mo9497a(Object obj) {
                SensethinkGroundStation.this.m6130b((DeviceInfo) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m6130b(DeviceInfo deviceInfo) throws Exception {
        final C2851c c2851c = new C2851c(new NvDeviceInfo(2, new NvAddress(TransportType.SensethinkWireless, deviceInfo.getSerialNo(), new C2843b(deviceInfo)), String.valueOf(deviceInfo.getModelID()), String.valueOf(deviceInfo.getManufacturerID()), deviceInfo.getSerialNo(), deviceInfo.getManufactureDate(), String.valueOf(deviceInfo.getHardwareVersion()), String.valueOf(deviceInfo.getFirmwareVersion()), this.f6614m), false);
        C2850b c2850b = new C2850b(c2851c, 1);
        C2852d c2852d = new C2852d(c2851c, 2);
        c2851c.m6029a(c2850b);
        c2851c.m6028a((AbstractC2867y) c2852d);
        Logger logger2 = logger;
        logger2.mo1497c((Object) ("set SPRc getLinkInfo to socket " + c2851c.m6030a()));
        this.f6603D = c2851c;
        m6186a(InputDeviceCompat.SOURCE_TRACKBALL, c2851c);
        C2834q.m6227a().mo6286a(new Runnable() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$7kZOHGZG69dP8Nllk9MYiJgRwSY
            @Override // java.lang.Runnable
            public final void run() {
                SensethinkGroundStation.this.m6178a(c2851c);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m6178a(C2851c c2851c) {
        c2851c.m6023b(true);
        c2851c.m6026a(true);
        c2851c.mo6018f();
        m6186a(65543, c2851c);
    }

    @Override // com.navatics.robot.transport.InterfaceC2818e
    /* renamed from: a */
    public void mo6137a(Map<String, Object> map) {
        m6077x();
        if (!this.enableAuth) {
            m6076y();
        } else if (!SPUsb.getInstance().checkUsb()) {
            m6187a(16711685, new C2830m(50, "usb not ready", this));
        } else {
            this.f6622u = m6126b((String) map.get("uuid")).m3072b(C3857a.m3247a()).m3103a(new C28472(), new InterfaceC3868e() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$tveHg1w4_Y9GtyLirPZzgkFWwFM
                @Override // io.reactivex.p096b.InterfaceC3868e
                /* renamed from: accept */
                public final void mo9497a(Object obj) {
                    SensethinkGroundStation.this.m6113c((Throwable) obj);
                }
            }, new InterfaceC3864a() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$m_xuan0TuGJ4VSa64jyaAC3gfsU
                @Override // io.reactivex.p096b.InterfaceC3864a
                public final void run() {
                    SensethinkGroundStation.this.m6191C();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SensethinkGroundStation.java */
    /* renamed from: com.navatics.robot.transport.ss.d$2 */
    /* loaded from: classes2.dex */
    public class C28472 implements InterfaceC3868e<DeviceUser> {
        C28472() {
        }

        @Override // io.reactivex.p096b.InterfaceC3868e
        /* renamed from: a */
        public void mo9497a(DeviceUser deviceUser) throws Exception {
            if (deviceUser == null) {
                SensethinkGroundStation sensethinkGroundStation = SensethinkGroundStation.this;
                sensethinkGroundStation.m6187a(16711685, new C2830m(48, "remote login failed, deviceUser is null", sensethinkGroundStation));
                return;
            }
            boolean z = deviceUser.getCode() == 0 && deviceUser.isBind() && deviceUser.isOwner();
            Logger logger = SensethinkGroundStation.logger;
            logger.mo1508a((Object) ("SensethinkGroundStation auth done, isLoginSucc=" + z + ", isBind=" + deviceUser.isBind() + ", isOwner=" + deviceUser.isOwner()));
            if (deviceUser.getCode() != -1) {
                SensethinkGroundStation.this.f6612k = deviceUser.isBind();
                if (z) {
                    SensethinkGroundStation.this.f6611j = true;
                    if (SensethinkGroundStation.this.f6630E.m6072a()) {
                        SensethinkGroundStation.logger.mo1497c((Object) "device already connected detected, getting deviceInfo...");
                        SPDevice.getInstance().getDevInfo(new MCallBack() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$2$HziMdO4geEehUprwisc6H6islFQ
                            @Override // com.senseplay.mframe.client.MCallBack
                            /* renamed from: onResult */
                            public final void mo9395a(Object obj) {
                                SensethinkGroundStation.C28472.this.m6074a((DeviceInfo) obj);
                            }
                        });
                        return;
                    }
                    SensethinkGroundStation sensethinkGroundStation2 = SensethinkGroundStation.this;
                    sensethinkGroundStation2.m6186a(65546, (Object) new C2830m(0, "remote login success", sensethinkGroundStation2));
                    return;
                } else if (deviceUser.isBind()) {
                    SensethinkGroundStation.logger.log((Object) "login failed because current user not the owner");
                    SensethinkGroundStation sensethinkGroundStation3 = SensethinkGroundStation.this;
                    sensethinkGroundStation3.m6187a(16711685, new C2830m(51, "not the remote owner", sensethinkGroundStation3));
                    return;
                } else {
                    SensethinkGroundStation.logger.log((Object) "login failed because remote haven't been bound");
                    SensethinkGroundStation sensethinkGroundStation4 = SensethinkGroundStation.this;
                    sensethinkGroundStation4.m6187a(16711685, new C2830m(52, "remote haven't been bound", sensethinkGroundStation4));
                    return;
                }
            }
            SensethinkGroundStation sensethinkGroundStation5 = SensethinkGroundStation.this;
            sensethinkGroundStation5.m6187a(16711685, new C2830m(48, "I/O error", sensethinkGroundStation5));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void m6074a(DeviceInfo deviceInfo) {
            if (deviceInfo == null) {
                SensethinkGroundStation.logger.log((Object) "getDevInfo error when detected connection inited for ground station");
                SensethinkGroundStation.this.f6612k = false;
                SensethinkGroundStation.this.f6611j = false;
                C2831n.m6249a(SensethinkGroundStation.this.f6602B, this, 16711689, new C2830m(48, "Controller internal error, please unplug and plugin again")).m6257a();
                return;
            }
            SensethinkGroundStation.logger.mo1508a((Object) "Get deviceInfo done.");
            NvDeviceInfo nvDeviceInfo = new NvDeviceInfo(2, new NvAddress(TransportType.SensethinkWireless, deviceInfo.getSerialNo(), new C2843b(deviceInfo)), String.valueOf(deviceInfo.getModelID()), String.valueOf(deviceInfo.getManufacturerID()), deviceInfo.getSerialNo(), deviceInfo.getManufactureDate(), String.valueOf(deviceInfo.getHardwareVersion()), String.valueOf(deviceInfo.getFirmwareVersion()), SensethinkGroundStation.this.f6614m);
            Logger logger = SensethinkGroundStation.logger;
            logger.mo1497c((Object) ("coreboard version : " + deviceInfo.getFirmwareVersion() + ", date : " + deviceInfo.getManufactureDate()));
            Logger logger2 = SensethinkGroundStation.logger;
            StringBuilder sb = new StringBuilder();
            sb.append("Get deviceInfo : ");
            sb.append(nvDeviceInfo);
            logger2.mo1508a((Object) sb.toString());
            SensethinkGroundStation sensethinkGroundStation = SensethinkGroundStation.this;
            sensethinkGroundStation.f6603D = sensethinkGroundStation.m6182a(nvDeviceInfo);
            SensethinkGroundStation sensethinkGroundStation2 = SensethinkGroundStation.this;
            sensethinkGroundStation2.m6186a(65546, (Object) new C2830m(0, "remote login success", sensethinkGroundStation2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m6113c(Throwable th) throws Exception {
        logger.log((Object) "GndStaAuthDisposable err.");
        if (!(th instanceof NvException)) {
            th.printStackTrace();
            th = new NvException(th.getMessage(), th, new C2830m(255, th.getMessage(), this));
        }
        m6187a(16711685, ((NvException) th).getError());
        this.f6622u.dispose();
        this.f6622u = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public /* synthetic */ void m6191C() throws Exception {
        logger.mo1508a((Object) "GndStaAuthDisposable done.");
        this.f6622u.dispose();
        this.f6622u = null;
    }

    @Override // com.navatics.robot.transport.InterfaceC2818e
    /* renamed from: o */
    public boolean mo6086o() {
        m6077x();
        if (this.enableAuth) {
            return this.f6612k;
        }
        return true;
    }

    @Override // com.navatics.robot.transport.InterfaceC2818e
    /* renamed from: b */
    public void mo6123b(Map<String, Object> map) {
        m6077x();
        String str = (String) map.get("sn");
        String str2 = (String) map.get("uuid");
        String str3 = (String) map.get("access_token");
        String str4 = (String) map.get("qrCode");
        Logger logger2 = logger;
        logger2.mo1508a((Object) ("bind : sn=" + str + ", uuid=" + str2 + ", accessToken=" + str3 + ", verifyCode=" + str4));
        if (this.f6623v != null) {
            return;
        }
        this.f6623v = m6141a(str, str2, str3, str4).m3103a(new InterfaceC3868e() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$awe9hncqV6t4C9MoRmuyReiRKx8
            @Override // io.reactivex.p096b.InterfaceC3868e
            /* renamed from: accept */
            public final void mo9497a(Object obj) {
                SensethinkGroundStation.this.m6131b((CallBackMsg) obj);
            }
        }, new InterfaceC3868e() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$7k6rOhDiCCQjCTEC1957mu6d-nI
            @Override // io.reactivex.p096b.InterfaceC3868e
            /* renamed from: accept */
            public final void mo9497a(Object obj) {
                SensethinkGroundStation.this.m6124b((Throwable) obj);
            }
        }, new InterfaceC3864a() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$-Hk11m2NMjPefFEiJxzUXQ8ytyE
            @Override // io.reactivex.p096b.InterfaceC3864a
            public final void run() {
                SensethinkGroundStation.this.m6192B();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m6131b(CallBackMsg callBackMsg) throws Exception {
        logger.mo1508a((Object) "GndStaBindDisposable success.");
        this.f6612k = true;
        m6186a(65545, (Object) new C2830m(0, "remote bind success", this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m6124b(Throwable th) throws Exception {
        logger.log((Object) "GndStaBindDisposable err.");
        m6187a(16711686, ((NvException) th).getError());
        this.f6623v.dispose();
        this.f6623v = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public /* synthetic */ void m6192B() throws Exception {
        logger.mo1508a((Object) "GndStaBindDisposable done.");
        this.f6623v.dispose();
        this.f6623v = null;
    }

    @Override // com.navatics.robot.transport.InterfaceC2818e
    /* renamed from: c */
    public void mo6112c(Map<String, Object> map) {
        m6077x();
        if (!this.f6611j) {
            logger.log((Object) "You haven't login to the controller yet.");
            m6187a(16711687, new C2830m(66, "You haven't login to the controller yet.", this));
            return;
        }
        String str = (String) map.get("uuid");
        String str2 = (String) map.get("sn");
        String str3 = (String) map.get("access_token");
        Logger logger2 = logger;
        logger2.mo1508a((Object) ("unbind : sn=" + str2 + ", uuid=" + str + ", accessToken=" + str3));
        if (this.f6624w != null) {
            return;
        }
        if (C2904n.m5850a((CharSequence) str2) || C2904n.m5850a((CharSequence) str) || C2904n.m5850a((CharSequence) str3)) {
            m6187a(16711687, new C2830m(49, "sn or uuid or accessToken is invalid", this));
        } else {
            this.f6624w = m6144a(str2, str, str3).m3103a(new InterfaceC3868e() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$8lTVKFx4lhlnuW5yrDFBHAifKh4
                @Override // io.reactivex.p096b.InterfaceC3868e
                /* renamed from: accept */
                public final void mo9497a(Object obj) {
                    SensethinkGroundStation.this.m6158a((CallBackMsg) obj);
                }
            }, new InterfaceC3868e() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$lqXcjZiqI1sZ9hIuKGuMJ_ERoyM
                @Override // io.reactivex.p096b.InterfaceC3868e
                /* renamed from: accept */
                public final void mo9497a(Object obj) {
                    SensethinkGroundStation.this.m6138a((Throwable) obj);
                }
            }, new InterfaceC3864a() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$OpyWmoeONrSY8Yc_cXZzdqNAgqE
                @Override // io.reactivex.p096b.InterfaceC3864a
                public final void run() {
                    SensethinkGroundStation.this.m6193A();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m6158a(CallBackMsg callBackMsg) throws Exception {
        logger.mo1508a((Object) "mGndStaUnbindDisposable success.");
        m6080u();
        m6186a(65566, (Object) new C2830m(0, "remote unbind success", this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m6138a(Throwable th) throws Exception {
        logger.log((Object) "mGndStaUnbindDisposable err.");
        m6187a(16711687, ((NvException) th).getError());
        this.f6624w.dispose();
        this.f6624w = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public /* synthetic */ void m6193A() throws Exception {
        logger.mo1508a((Object) "mGndStaUnbindDisposable done.");
        this.f6624w.dispose();
        this.f6624w = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public void m6075z() {
        if (this.f6603D == null) {
            return;
        }
        WLog.m5839i(f6599a, "closeConn, send DEVICE_DISCONNECTED");
        try {
            C2851c c2851c = this.f6603D;
            this.f6603D.m6055k();
            this.f6603D = null;
            m6186a(65541, c2851c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SensethinkGroundStation.java */
    /* renamed from: com.navatics.robot.transport.ss.d$a */
    /* loaded from: classes2.dex */
    public class C2848a implements MCallBack<LinkInfo> {

        /* renamed from: a */
        boolean f6634a;

        /* renamed from: b */
        long f6635b;

        /* renamed from: c */
        RunnableC2849a f6636c = new RunnableC2849a();

        /* renamed from: d */
        final int f6637d = PathInterpolatorCompat.MAX_NUM_POINTS;

        C2848a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SensethinkGroundStation.java */
        /* renamed from: com.navatics.robot.transport.ss.d$a$a */
        /* loaded from: classes2.dex */
        public class RunnableC2849a implements Runnable {
            RunnableC2849a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (SensethinkGroundStation.this.f6603D == null) {
                    WLog.m5835w(SensethinkGroundStation.f6599a, "warning, connection broken detected, but no active conn");
                    return;
                }
                String str = SensethinkGroundStation.f6599a;
                WLog.m5835w(str, " connection [" + SensethinkGroundStation.this.f6603D.m6030a() + "] broken detected from rc");
                C2848a c2848a = C2848a.this;
                c2848a.f6634a = false;
                SensethinkGroundStation.this.m6075z();
            }
        }

        /* renamed from: a */
        boolean m6072a() {
            return this.f6634a;
        }

        /* renamed from: a */
        void m6071a(LinkInfo linkInfo) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean isLinked = linkInfo.isLinked();
            if (!this.f6634a && isLinked) {
                String str = SensethinkGroundStation.f6599a;
                WLog.m5839i(str, "connection [" + SensethinkGroundStation.this.mo6189a() + "] init detected.");
                this.f6634a = true;
            }
            if (!isLinked && this.f6634a && this.f6635b == 0) {
                if (SensethinkGroundStation.this.f6613l && SensethinkGroundStation.this.f6603D != null) {
                    this.f6634a = false;
                    SensethinkGroundStation.this.m6075z();
                    return;
                }
                this.f6635b = currentTimeMillis;
                SensethinkGroundStation.logger.mo1508a((Object) "post disconnectDetector");
                C2834q.m6227a().mo6285a(this.f6636c, 3000L);
            } else if (this.f6635b <= 0 || !isLinked) {
            } else {
                SensethinkGroundStation.logger.mo1508a((Object) "remove disconnectDetector");
                C2834q.m6227a().mo6284b(this.f6636c);
                this.f6635b = 0L;
            }
        }

        @Override // com.senseplay.mframe.client.MCallBack
        /* renamed from: b */
        public void mo9395a(LinkInfo linkInfo) {
            SensethinkGroundStation.this.f6618q = linkInfo.getDev_snr0();
            SensethinkGroundStation.this.f6619r = linkInfo.getDev_rssi0();
            SensethinkGroundStation.this.f6620s = 0;
            SensethinkGroundStation.this.f6617p = SPRc.getInstance().getBatteryStatus();
            SensethinkGroundStation.this.m6079v();
            m6071a(linkInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SensethinkGroundStation.java */
    /* renamed from: com.navatics.robot.transport.ss.d$c */
    /* loaded from: classes2.dex */
    public class C2851c extends AbstractC2856t {
        C2851c(NvDeviceInfo nvDeviceInfo, boolean z) {
            super(nvDeviceInfo, z);
        }

        @Override // com.navatics.robot.transport.AbstractC2856t
        /* renamed from: f */
        public void mo6018f() {
            if (m6017g()) {
                return;
            }
            super.mo6018f();
            m6022c().mo6066d();
        }

        @Override // com.navatics.robot.transport.AbstractC2856t
        /* renamed from: a */
        public void mo6027a(Map<String, Object> map) {
            if (SensethinkGroundStation.this.enableAuth) {
                if (!SPUsb.getInstance().checkUsb()) {
                    SensethinkGroundStation.this.m6187a(16711682, new C2830m(50, "usb not ready", this));
                    return;
                }
                SensethinkGroundStation sensethinkGroundStation = SensethinkGroundStation.this;
                sensethinkGroundStation.f6627z = sensethinkGroundStation.m6148a((String) map.get("uuid")).m3072b(C3857a.m3247a()).m3103a(new InterfaceC3868e() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$c$r5SctuvmXjIdaeeUMPRXhaMb9Us
                    @Override // io.reactivex.p096b.InterfaceC3868e
                    /* renamed from: accept */
                    public final void mo9497a(Object obj) {
                        SensethinkGroundStation.C2851c.this.m6060a((DeviceUser) obj);
                    }
                }, new InterfaceC3868e() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$c$J7LK6fJqZacuP2BeNw3Tf6N3Yfc
                    @Override // io.reactivex.p096b.InterfaceC3868e
                    /* renamed from: accept */
                    public final void mo9497a(Object obj) {
                        SensethinkGroundStation.C2851c.this.m6056c((Throwable) obj);
                    }
                }, new InterfaceC3864a() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$c$yCkOY6m2ERL6b-qsmst4H-ub2fU
                    @Override // io.reactivex.p096b.InterfaceC3864a
                    public final void run() {
                        SensethinkGroundStation.C2851c.this.m6052n();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void m6060a(DeviceUser deviceUser) throws Exception {
            if (deviceUser == null) {
                SensethinkGroundStation.this.m6187a(16711682, new C2830m(48, "device login failed, deviceUser is null", this));
                return;
            }
            boolean z = deviceUser.getCode() == 0 && deviceUser.isBind() && deviceUser.isOwner();
            m6023b(deviceUser.isBind());
            m6026a(z);
            if (z) {
                SensethinkGroundStation.this.m6186a(65543, this);
                if (m6016h()) {
                    mo6018f();
                }
            } else if (deviceUser.isBind()) {
                SensethinkGroundStation.this.m6187a(16711682, new C2830m(51, "not the device owner", this));
            } else {
                SensethinkGroundStation.this.m6187a(16711682, new C2830m(52, "device haven't been bound", this));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void m6056c(Throwable th) throws Exception {
            if (!(th instanceof NvException)) {
                th = new NvException(th.getMessage(), th, new C2830m(255, th.getMessage(), this));
            }
            SensethinkGroundStation.this.m6187a(16711682, ((NvException) th).getError());
            SensethinkGroundStation.this.f6627z.dispose();
            SensethinkGroundStation.this.f6627z = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: n */
        public /* synthetic */ void m6052n() throws Exception {
            SensethinkGroundStation.this.f6627z.dispose();
            SensethinkGroundStation.this.f6627z = null;
        }

        @Override // com.navatics.robot.transport.AbstractC2856t
        /* renamed from: b */
        public void mo6024b(Map<String, Object> map) {
            if (SensethinkGroundStation.this.enableAuth) {
                if (m6015i()) {
                    throw new RuntimeException("try to bind to a device which connection already closed.");
                }
                String str = (String) map.get("sn");
                String str2 = (String) map.get("uuid");
                String str3 = (String) map.get("access_token");
                String str4 = (String) map.get("qrCode");
                if (SensethinkGroundStation.this.f6601A != null) {
                    return;
                }
                Log.d("ContentValues", "Device绑定参数 ：uuId = " + str2 + ", rcSn = " + str + "， accessToken = " + str3 + ", verifyCode = " + str4);
                SensethinkGroundStation sensethinkGroundStation = SensethinkGroundStation.this;
                sensethinkGroundStation.f6601A = sensethinkGroundStation.m6172a(this, str, str2, str3, str4).m3103a(new InterfaceC3868e() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$c$BdVNauP_tB5twNkdqzR_mg800OU
                    @Override // io.reactivex.p096b.InterfaceC3868e
                    /* renamed from: accept */
                    public final void mo9497a(Object obj) {
                        SensethinkGroundStation.C2851c.this.m6058b((CallBackMsg) obj);
                    }
                }, new InterfaceC3868e() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$c$FBOqRK45ossu9MCsLfCckNPS640
                    @Override // io.reactivex.p096b.InterfaceC3868e
                    /* renamed from: accept */
                    public final void mo9497a(Object obj) {
                        SensethinkGroundStation.C2851c.this.m6057b((Throwable) obj);
                    }
                }, new InterfaceC3864a() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$c$jhvDE5OFeE7WsN3kBPZd7eCbgQc
                    @Override // io.reactivex.p096b.InterfaceC3864a
                    public final void run() {
                        SensethinkGroundStation.C2851c.this.m6053m();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void m6058b(CallBackMsg callBackMsg) throws Exception {
            m6023b(true);
            SensethinkGroundStation.this.m6186a(65544, (Object) new C2830m(0, "device bind success", this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void m6057b(Throwable th) throws Exception {
            if (!(th instanceof NvException)) {
                th = new NvException(th.getMessage(), th, new C2830m(255, th.getMessage(), this));
            }
            SensethinkGroundStation.this.m6187a(16711683, ((NvException) th).getError());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: m */
        public /* synthetic */ void m6053m() throws Exception {
            SensethinkGroundStation.this.f6601A.dispose();
            SensethinkGroundStation.this.f6601A = null;
        }

        @Override // com.navatics.robot.transport.AbstractC2856t
        /* renamed from: c */
        public void mo6021c(Map<String, Object> map) {
            if (SensethinkGroundStation.this.enableAuth) {
                if (m6015i()) {
                    throw new RuntimeException("try to unbind a device which connection already closed.");
                }
                String str = (String) map.get("sn");
                String str2 = (String) map.get("uuid");
                String str3 = (String) map.get("access_token");
                if (SensethinkGroundStation.this.f6625x != null) {
                    return;
                }
                Log.d("ContentValues", "Device unbind ：uuId = " + str2 + ", rcSn = " + str + "， accessToken = " + str3);
                SensethinkGroundStation sensethinkGroundStation = SensethinkGroundStation.this;
                sensethinkGroundStation.f6625x = sensethinkGroundStation.m6173a(this, str, str2, str3).m3103a(new InterfaceC3868e() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$c$lB7GwkX6lnEyRDF8wG-20wyyseQ
                    @Override // io.reactivex.p096b.InterfaceC3868e
                    /* renamed from: accept */
                    public final void mo9497a(Object obj) {
                        SensethinkGroundStation.C2851c.this.m6061a((CallBackMsg) obj);
                    }
                }, new InterfaceC3868e() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$c$7msPUOb1caPkhSfprcFKE55rYY0
                    @Override // io.reactivex.p096b.InterfaceC3868e
                    /* renamed from: accept */
                    public final void mo9497a(Object obj) {
                        SensethinkGroundStation.C2851c.this.m6059a((Throwable) obj);
                    }
                }, new InterfaceC3864a() { // from class: com.navatics.robot.transport.ss.-$$Lambda$d$c$DUsTOyVnf15qc4xHzE6b7yiVtac
                    @Override // io.reactivex.p096b.InterfaceC3864a
                    public final void run() {
                        SensethinkGroundStation.C2851c.this.m6054l();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void m6061a(CallBackMsg callBackMsg) throws Exception {
            SensethinkGroundStation.logger.mo1508a((Object) "mDevicedUnbindDisposable success.");
            SensethinkGroundStation.this.m6186a(65567, (Object) new C2830m(0, "device unbind success", this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void m6059a(Throwable th) throws Exception {
            SensethinkGroundStation.logger.log((Object) "mDevicedUnbindDisposable err.");
            if (!(th instanceof NvException)) {
                th = new NvException(th.getMessage(), th, new C2830m(255, th.getMessage(), this));
            }
            SensethinkGroundStation.this.m6187a(16711688, ((NvException) th).getError());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: l */
        public /* synthetic */ void m6054l() throws Exception {
            SensethinkGroundStation.logger.mo1508a((Object) "mDevicedUnbindDisposable done.");
            SensethinkGroundStation.this.f6625x.dispose();
            SensethinkGroundStation.this.f6625x = null;
        }

        /* renamed from: k */
        void m6055k() {
            m6022c().mo6050e();
            m6020d().mo6050e();
        }

        @Override // com.navatics.robot.transport.AbstractC2856t
        /* renamed from: j */
        public void mo6014j() throws IOException {
            if (m6015i()) {
                return;
            }
            super.mo6014j();
            SensethinkGroundStation.logger.mo1496d("close connection");
            SensethinkGroundStation.this.m6159a((AbstractC2856t) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SensethinkGroundStation.java */
    /* renamed from: com.navatics.robot.transport.ss.d$b */
    /* loaded from: classes2.dex */
    public class C2850b extends NvChannel implements InterfaceC2822i {

        /* renamed from: b */
        C2851c f6640b;

        /* renamed from: c */
        C2844c f6641c;

        C2850b(C2851c c2851c, int i) {
            super(i, 1, 6, 1);
            this.f6640b = c2851c;
            this.f6641c = C2844c.m6203d();
            this.f6641c.m6352a(IoChannel.IoMode.NONBLOCKING);
        }

        @Override // com.navatics.robot.transport.NvChannel
        /* renamed from: e */
        public void mo6050e() {
            if (m6344f()) {
                return;
            }
            super.mo6050e();
            m6064j();
            try {
                try {
                    this.f6641c.m6201e();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } finally {
                this.f6641c = null;
            }
        }

        @Override // com.navatics.robot.transport.NvChannel
        /* renamed from: d */
        public void mo6066d() {
            if (m6343g()) {
                return;
            }
            if (m6344f()) {
                throw new IllegalStateException("can't start a channel already been closed.");
            }
            super.mo6066d();
            m6065i();
        }

        @Override // com.navatics.robot.transport.NvChannel
        /* renamed from: c */
        public void mo6067c() {
            if (m6343g()) {
                super.mo6067c();
                m6064j();
            }
        }

        /* renamed from: i */
        private void m6065i() {
            C2835s m6005d = C2857u.m6005d();
            if (m6005d == null) {
                throw new NvException(new C2830m(48, "NvTransport.getSelector() is null"));
            }
            m6005d.m6220a(this.f6641c, 2, this);
            m6063k();
        }

        /* renamed from: j */
        private void m6064j() {
            m6062l();
            C2835s m6005d = C2857u.m6005d();
            if (m6005d == null) {
                throw new NvException(new C2830m(48, "NvTransport.getSelector() is null"));
            }
            m6005d.m6221a(this.f6641c);
        }

        /* renamed from: k */
        private void m6063k() {
            if (!SPUsb.getInstance().checkUsb()) {
                SensethinkGroundStation.logger.log((Object) "please open usb connection to the controller first.");
            } else {
                SPRc.getInstance().setRcCommond(true);
            }
        }

        /* renamed from: l */
        private void m6062l() {
            if (!SPUsb.getInstance().checkUsb()) {
                SensethinkGroundStation.logger.log((Object) "please open usb connection to the controller first.");
            } else {
                SPRc.getInstance().setRcCommond(false);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x00b2, code lost:
            if (0 == 0) goto L24;
         */
        @Override // com.navatics.robot.transport.InterfaceC2822i
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void mo6069a(int r8, com.navatics.robot.transport.IoChannel r9) {
            /*
                r7 = this;
                boolean r0 = r7.m6344f()
                if (r0 == 0) goto L10
                org.apache.log4j.k r8 = com.navatics.robot.transport.p064ss.SensethinkGroundStation.m6084q()
                java.lang.String r9 = "receive data after channel closed."
                r8.mo1496d(r9)
                return
            L10:
                r8 = r8 & 2
                if (r8 == 0) goto Lc4
                com.navatics.robot.transport.g r8 = com.navatics.robot.transport.C2820g.m6277e()
                if (r8 != 0) goto L24
                org.apache.log4j.k r8 = com.navatics.robot.transport.p064ss.SensethinkGroundStation.m6084q()
                java.lang.String r9 = "Failed to apply for IoBuffer."
                r8.log(r9)
                return
            L24:
                r0 = 0
                int r9 = r9.mo6351a(r8)     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                if (r9 <= 0) goto L7d
                com.navatics.robot.transport.p r9 = r7.m6345b()     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                if (r9 == 0) goto L71
                r2 = 131073(0x20001, float:1.83672E-40)
                byte[] r3 = r8.mo6283a()     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                r4 = 1
                r5 = 0
                int r6 = r8.mo6279c()     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                r1 = r7
                com.navatics.robot.transport.n r0 = com.navatics.robot.transport.C2831n.m6242a(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                if (r0 == 0) goto L4d
                com.navatics.robot.transport.p r9 = r7.m6345b()     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                r9.mo6228a(r0)     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                goto L7a
            L4d:
                org.apache.log4j.k r9 = com.navatics.robot.transport.p064ss.SensethinkGroundStation.m6084q()     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                r1.<init>()     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                java.lang.String r2 = "NvEvent.obtain failed, will miss message, length = "
                r1.append(r2)     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                int r2 = r8.mo6279c()     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                r1.append(r2)     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                r9.log(r1)     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                java.lang.String r1 = "Can't obtain NvEvent."
                r9.<init>(r1)     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                throw r9     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
            L71:
                org.apache.log4j.k r9 = com.navatics.robot.transport.p064ss.SensethinkGroundStation.m6084q()     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
                java.lang.String r1 = "Will discard this data because no eventHandler attached to this channel."
                r9.mo1496d(r1)     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
            L7a:
                if (r0 == 0) goto Lb7
                goto Lb4
            L7d:
                org.apache.log4j.k r1 = com.navatics.robot.transport.p064ss.SensethinkGroundStation.m6084q()     // Catch: java.lang.Throwable -> Lac java.io.IOException -> Lae
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
                r0.m6241b()
            Lb7:
                r8.mo6278d()
                goto Lc4
            Lbb:
                if (r0 == 0) goto Lc0
                r0.m6241b()
            Lc0:
                r8.mo6278d()
                throw r9
            Lc4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.navatics.robot.transport.p064ss.SensethinkGroundStation.C2850b.mo6069a(int, com.navatics.robot.transport.IoChannel):void");
        }

        @Override // com.navatics.robot.transport.NvChannel
        /* renamed from: a */
        public int mo6068a(byte[] bArr) throws IOException {
            if (m6344f()) {
                StringBuilder sb = new StringBuilder();
                sb.append("[s:");
                sb.append(this.f6640b.m6030a());
                sb.append("]");
                throw new IOException(((Object) sb) + "write operation detected after channel closed.");
            }
            C2844c c2844c = this.f6641c;
            if (c2844c == null) {
                Logger logger = SensethinkGroundStation.logger;
                logger.log((Object) ("ioChannel is null, State : " + m6348a()));
                return -1;
            }
            return c2844c.m6208a(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SensethinkGroundStation.java */
    /* renamed from: com.navatics.robot.transport.ss.d$d */
    /* loaded from: classes2.dex */
    public class C2852d extends AbstractC2867y implements AbstractC2794ab.InterfaceC2795a {

        /* renamed from: c */
        private C2854f f6645c;

        C2852d(C2851c c2851c, int i) {
            super(i);
            this.f6478a = NvChannel.State.RUNNING;
        }

        @Override // com.navatics.robot.transport.AbstractC2867y
        /* renamed from: i */
        public InputStream mo5949i() throws IOException {
            if (this.f6645c != null) {
                throw new IOException("someone is using the input stream of this channel now.");
            }
            this.f6645c = new C2854f(SPUsb.getInstance().getUsb());
            this.f6645c.addOnClosedListener(this);
            return this.f6645c;
        }

        @Override // com.navatics.robot.transport.AbstractC2794ab.InterfaceC2795a
        /* renamed from: a */
        public void mo6051a(AbstractC2794ab abstractC2794ab) {
            this.f6645c.removeOnClosedListener(this);
            this.f6645c = null;
        }

        @Override // com.navatics.robot.transport.AbstractC2867y
        /* renamed from: j */
        public boolean mo5948j() {
            C2854f c2854f = this.f6645c;
            return c2854f == null || c2854f.m6040a();
        }

        @Override // com.navatics.robot.transport.NvChannel
        /* renamed from: e */
        public void mo6050e() {
            super.mo6050e();
            C2854f c2854f = this.f6645c;
            if (c2854f != null) {
                try {
                    c2854f.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
