package com.navatics.app.framework.firmware;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.p008v4.view.InputDeviceCompat;
import android.util.Log;
import android.util.SparseArray;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.navatics.app.framework.GroundStation;
import com.navatics.app.framework.Navatics;
import com.navatics.app.framework.NvConnection;
import com.navatics.app.framework.NvRobot;
import com.navatics.app.framework.R;
import com.navatics.app.framework.RobotVersionInfo;
import com.navatics.app.framework.Settings;
import com.navatics.app.framework.annotation.EventHandler;
import com.navatics.app.framework.firmware.Downloader;
import com.navatics.app.framework.firmware.Firmware;
import com.navatics.app.framework.firmware.FirmwareManager;
import com.navatics.app.framework.p055g.NotificationUtils;
import com.navatics.app.framework.p055g.Version;
import com.navatics.app.framework.user.Result;
import com.navatics.app.framework.user.UnsafeOkHttpClient;
import com.navatics.robot.transport.NvError;
import com.navatics.robot.transport.NvEventLoop;
import com.navatics.robot.transport.p063b.NvExceptionHandler;
import com.navatics.robot.transport.p063b.NvObserver;
import com.navatics.robot.utils.C2160n;
import com.navatics.robot.utils.NetworkUtil;
import io.reactivex.AbstractC2901p;
import io.reactivex.InterfaceC2900o;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.p093a.p095b.AndroidSchedulers;
import io.reactivex.p096b.Consumer;
import io.reactivex.p096b.InterfaceC2848a;
import io.reactivex.p099e.Schedulers;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.apache.log4j.C3044k;
import retrofit2.C3204l;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.p153a.p154a.GsonConverterFactory;

/* renamed from: com.navatics.app.framework.firmware.e */
/* loaded from: classes.dex */
public class FirmwareManager implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: c */
    private static FirmwareManager f4566c;

    /* renamed from: f */
    private FirmwareService f4571f;

    /* renamed from: h */
    private GroundStation f4573h;

    /* renamed from: i */
    private FirmwareInfo f4574i;

    /* renamed from: n */
    private AbstractC1817d f4579n;

    /* renamed from: o */
    private Disposable f4580o;

    /* renamed from: b */
    private static final C3044k f4565b = C3044k.m1564a(FirmwareManager.class);

    /* renamed from: d */
    private static final DateFormat f4567d = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.US);

    /* renamed from: r */
    private static boolean f4568r = true;

    /* renamed from: g */
    private CompositeDisposable f4572g = new CompositeDisposable();

    /* renamed from: j */
    private SparseArray<List<C1815b>> f4575j = new SparseArray<>();

    /* renamed from: k */
    private SparseArray<RobotVersionInfo> f4576k = new SparseArray<>();

    /* renamed from: l */
    private SparseArray<List<InterfaceC1816c>> f4577l = new SparseArray<>();

    /* renamed from: m */
    private List<InterfaceC1816c> f4578m = new ArrayList();

    /* renamed from: p */
    private boolean f4581p = false;

    /* renamed from: a */
    public boolean f4569a = false;

    /* renamed from: q */
    private final HandlerThreadC1814a f4582q = new HandlerThreadC1814a();

    /* renamed from: e */
    private Context f4570e = Navatics.m7935e();

    /* compiled from: FirmwareManager.java */
    /* renamed from: com.navatics.app.framework.firmware.e$c */
    /* loaded from: classes.dex */
    public interface InterfaceC1816c {
        /* renamed from: a */
        void mo8235a(RobotVersionInfo robotVersionInfo, FirmwareInfo firmwareInfo);

        /* renamed from: a */
        void mo8234a(RobotVersionInfo robotVersionInfo, NvError nvError);

        /* renamed from: a */
        void mo8233a(FirmwareInfo firmwareInfo, NvError nvError);
    }

    /* renamed from: e */
    private String m8247e(int i) {
        if (i != 1) {
            return null;
        }
        return "MITO";
    }

    /* renamed from: lambda$7ITHYc7mHZB-TlumommL7y1---8 */
    public static /* synthetic */ void m13063lambda$7ITHYc7mHZBTlumommL7y18(InterfaceC2848a interfaceC2848a) {
        m8253c(interfaceC2848a);
    }

    public static /* synthetic */ void lambda$Frm_RmIXO34JTP83IYJggp1rqZY(FirmwareManager firmwareManager, boolean z, Throwable th) {
        firmwareManager.m8272a(z, th);
    }

    public static /* synthetic */ void lambda$JPDajdRhaaTCURGH58wB61hr7X4(FirmwareManager firmwareManager, RobotVersionInfo robotVersionInfo, FirmwareInfo firmwareInfo) {
        firmwareManager.m8257c(robotVersionInfo, firmwareInfo);
    }

    public static /* synthetic */ void lambda$LKP9468FIcGNbPNJDziNVc2OWQ0(FirmwareManager firmwareManager, RobotVersionInfo robotVersionInfo, NvError nvError) {
        firmwareManager.m8256c(robotVersionInfo, nvError);
    }

    /* renamed from: lambda$bwP4QMgPQe7Hu12rZenKA5Yku-c */
    public static /* synthetic */ void m13064lambda$bwP4QMgPQe7Hu12rZenKA5Ykuc(FirmwareManager firmwareManager, boolean z, RobotVersionInfo robotVersionInfo) {
        firmwareManager.m8273a(z, robotVersionInfo);
    }

    public static /* synthetic */ void lambda$iCSkuLAWNu0zUxg7CXRmvoGw6Eg(InterfaceC2848a interfaceC2848a, AbstractC2901p.AbstractC2904c abstractC2904c) {
        m8278a(interfaceC2848a, abstractC2904c);
    }

    /* renamed from: lambda$mL2fAvQDLolNJK-CrjFhd8u9fF0 */
    public static /* synthetic */ void m13065lambda$mL2fAvQDLolNJKCrjFhd8u9fF0(FirmwareManager firmwareManager, Boolean bool) {
        firmwareManager.m8276a(bool);
    }

    /* renamed from: lambda$y5JYwZEzIgb-pw5uB4S2LL5qOFw */
    public static /* synthetic */ void m13066lambda$y5JYwZEzIgbpw5uB4S2LL5qOFw(FirmwareManager firmwareManager, FirmwareInfo firmwareInfo, NvError nvError) {
        firmwareManager.m8254c(firmwareInfo, nvError);
    }

    public static /* synthetic */ void lambda$zZO6Vdg4w5omZcXywmMxxA5AqOU(InterfaceC2900o interfaceC2900o) {
        m8277a(interfaceC2900o);
    }

    /* renamed from: a */
    public static void m8298a() {
        f4566c = new FirmwareManager();
    }

    /* renamed from: b */
    public static FirmwareManager m8271b() {
        return f4566c;
    }

    /* compiled from: FirmwareManager.java */
    /* renamed from: com.navatics.app.framework.firmware.e$a */
    /* loaded from: classes.dex */
    public class HandlerThreadC1814a extends HandlerThread implements Handler.Callback {

        /* renamed from: a */
        Handler f4593a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerThreadC1814a() {
            super("Navatics-Firmware-Service");
            FirmwareManager.this = r1;
        }

        /* renamed from: a */
        Handler m8238a() {
            return this.f4593a;
        }

        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            this.f4593a = new Handler(getLooper(), this);
            synchronized (this) {
                notifyAll();
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    FirmwareManager.this.m8260b(((Boolean) message.obj).booleanValue());
                    break;
                case 2:
                    FirmwareManager.this.m8280a((NvRobot) message.obj, message.arg1 == 1);
                    break;
            }
            return true;
        }
    }

    /* compiled from: FirmwareManager.java */
    /* renamed from: com.navatics.app.framework.firmware.e$b */
    /* loaded from: classes.dex */
    public class C1815b {

        /* renamed from: a */
        int f4595a;

        /* renamed from: b */
        Firmware f4596b;

        /* renamed from: c */
        FirmwareInfo f4597c;

        public C1815b(int i, Firmware firmware, FirmwareInfo firmwareInfo) {
            FirmwareManager.this = r1;
            this.f4595a = i;
            this.f4596b = firmware;
            this.f4597c = firmwareInfo;
        }

        /* renamed from: a */
        public int m8237a() {
            return this.f4595a;
        }

        /* renamed from: b */
        FirmwareInfo m8236b() {
            return this.f4597c;
        }
    }

    /* compiled from: FirmwareManager.java */
    /* renamed from: com.navatics.app.framework.firmware.e$d */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1817d implements Firmware.InterfaceC1807b {

        /* renamed from: b */
        UpdateLogger f4599b;

        /* renamed from: a */
        public abstract void mo8232a(FirmwareInfo firmwareInfo, NvError nvError);

        public AbstractC1817d(UpdateLogger updateLogger) {
            this.f4599b = updateLogger;
        }

        /* renamed from: c */
        UpdateLogger m8231c() {
            return this.f4599b;
        }
    }

    private FirmwareManager() {
        SharedPreferences sharedPreferences = Navatics.m7935e().getSharedPreferences("app_settings", 0);
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        boolean z = sharedPreferences.getBoolean("use_test_environment", this.f4570e.getResources().getBoolean(R.bool.use_testing_server));
        C3044k c3044k = f4565b;
        c3044k.mo1500c((Object) ("testing " + z));
        StringBuilder sb = new StringBuilder();
        sb.append(z ? "http://192.168.69.41:45330/" : "http://47.254.82.90/");
        sb.append("firmwareupgrade/");
        this.f4571f = (FirmwareService) new Retrofit.C3206a().m52a(sb.toString()).m48a(UnsafeOkHttpClient.m7767a()).m46a(GsonConverterFactory.m168a(new GsonBuilder().serializeNulls().registerTypeAdapter(Date.class, new JsonDeserializer<Date>() { // from class: com.navatics.app.framework.firmware.e.2
            {
                FirmwareManager.this = this;
            }

            @Override // com.google.gson.JsonDeserializer
            /* renamed from: a */
            public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return new Date(jsonElement.getAsJsonPrimitive().getAsLong());
            }
        }).registerTypeAdapter(Date.class, new JsonSerializer<Date>() { // from class: com.navatics.app.framework.firmware.e.1
            {
                FirmwareManager.this = this;
            }

            @Override // com.google.gson.JsonSerializer
            /* renamed from: a */
            public JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
                return new JsonPrimitive((Number) Long.valueOf(date.getTime()));
            }
        }).create())).m47a(RxJava2CallAdapterFactory.m156a()).m53a().m64a(FirmwareService.class);
        this.f4582q.start();
        synchronized (this.f4582q) {
            try {
                this.f4582q.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Navatics.m7947b().m8577a(this);
        this.f4580o = m8246f().m3075b(Schedulers.m3217b()).m3091a(Schedulers.m3217b()).m3069c(new ObservableSource() { // from class: com.navatics.app.framework.firmware.-$$Lambda$e$zZO6Vdg4w5omZcXywmMxxA5AqOU
            @Override // io.reactivex.ObservableSource
            public final void subscribe(InterfaceC2900o interfaceC2900o) {
                FirmwareManager.lambda$zZO6Vdg4w5omZcXywmMxxA5AqOU(interfaceC2900o);
            }
        }).m3107a(new Consumer() { // from class: com.navatics.app.framework.firmware.-$$Lambda$e$mL2fAvQDLolNJK-CrjFhd8u9fF0
            @Override // io.reactivex.p096b.Consumer
            public final void accept(Object obj) {
                FirmwareManager.m13065lambda$mL2fAvQDLolNJKCrjFhd8u9fF0(FirmwareManager.this, (Boolean) obj);
            }
        }, new Consumer() { // from class: com.navatics.app.framework.firmware.-$$Lambda$e27-Kr4VJxN1zC_AGmQwWE7CADQ
            @Override // io.reactivex.p096b.Consumer
            public final void accept(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        });
        f4565b.mo1500c((Object) "firmware manager init done.");
    }

    /* renamed from: a */
    public static /* synthetic */ void m8277a(InterfaceC2900o interfaceC2900o) {
        interfaceC2900o.onNext(false);
    }

    /* renamed from: a */
    public /* synthetic */ void m8276a(Boolean bool) throws Exception {
        boolean z = Navatics.m7935e().getSharedPreferences("app_settings", 0).getBoolean("allow_update_cellular", false);
        if (bool.booleanValue() || z) {
            m8259c();
        }
    }

    /* renamed from: a */
    public void m8288a(AbstractC1817d abstractC1817d) {
        this.f4579n = abstractC1817d;
    }

    /* renamed from: a */
    public void m8292a(final FirmwareInfo firmwareInfo) {
        if (firmwareInfo == null) {
            throw new NullPointerException("firmware info is null when calling executeUpdate");
        }
        if (firmwareInfo.getDownUrl().startsWith("file:") || firmwareInfo.getDownUrl().startsWith("/")) {
            m8290a(firmwareInfo, this.f4579n);
        } else {
            new Downloader(this.f4570e, new Downloader.InterfaceC1805a() { // from class: com.navatics.app.framework.firmware.e.3
                {
                    FirmwareManager.this = this;
                }

                @Override // com.navatics.app.framework.firmware.Downloader.InterfaceC1805a
                /* renamed from: a */
                public void mo8241a() {
                    FirmwareManager.f4565b.mo1500c((Object) "download finished.");
                    FirmwareManager.this.f4579n.mo8232a(firmwareInfo, new NvError(0));
                    FirmwareManager firmwareManager = FirmwareManager.this;
                    firmwareManager.m8290a(firmwareInfo, firmwareManager.f4579n);
                }

                @Override // com.navatics.app.framework.firmware.Downloader.InterfaceC1805a
                /* renamed from: b */
                public void mo8240b() {
                    FirmwareManager.f4565b.mo1504b((Object) "download failed.");
                    FirmwareManager.this.f4579n.mo8232a(firmwareInfo, new NvError(255));
                }
            }).m8319a(firmwareInfo.downUrl, m8255c(firmwareInfo));
        }
    }

    /* renamed from: a */
    public void m8290a(final FirmwareInfo firmwareInfo, final AbstractC1817d abstractC1817d) {
        Firmware m8311a = Firmware.m8311a(Navatics.m7930i(), m8255c(firmwareInfo));
        C3044k c3044k = f4565b;
        StringBuilder sb = new StringBuilder();
        sb.append("firmware is ");
        sb.append(m8311a == null ? "null" : m8311a.m8305b());
        c3044k.mo1500c((Object) sb.toString());
        if (m8311a != null) {
            if (m8311a.m8318a() != 0) {
                C3044k c3044k2 = f4565b;
                c3044k2.mo1504b((Object) ("update cancel, firmware status is " + m8311a.m8318a()));
                return;
            }
            m8311a.m8306a(true);
            m8311a.m8312a(abstractC1817d.m8231c());
            m8311a.m8317a(new Firmware.InterfaceC1807b() { // from class: com.navatics.app.framework.firmware.e.4
                {
                    FirmwareManager.this = this;
                }

                @Override // com.navatics.app.framework.firmware.Firmware.InterfaceC1807b
                /* renamed from: a */
                public void mo8184a() {
                    abstractC1817d.mo8184a();
                    FirmwareManager.this.f4569a = true;
                }

                @Override // com.navatics.app.framework.firmware.Firmware.InterfaceC1807b
                /* renamed from: a */
                public void mo8183a(long j) {
                    abstractC1817d.mo8183a(j);
                }

                @Override // com.navatics.app.framework.firmware.Firmware.InterfaceC1807b
                /* renamed from: b */
                public void mo8181b() {
                    FirmwareManager.this.m8258c(1);
                    abstractC1817d.mo8181b();
                    FirmwareManager firmwareManager = FirmwareManager.this;
                    firmwareManager.f4569a = false;
                    firmwareManager.m8275a(firmwareManager.m8255c(firmwareInfo));
                    FirmwareManager.this.m8252c(false);
                }

                @Override // com.navatics.app.framework.firmware.Firmware.InterfaceC1807b
                /* renamed from: a */
                public void mo8182a(Throwable th) {
                    abstractC1817d.mo8182a(th);
                    FirmwareManager firmwareManager = FirmwareManager.this;
                    firmwareManager.f4569a = false;
                    firmwareManager.m8275a(firmwareManager.m8255c(firmwareInfo));
                }
            });
        }
    }

    /* renamed from: a */
    public static boolean m8291a(FirmwareInfo firmwareInfo, RobotVersionInfo robotVersionInfo) {
        return robotVersionInfo == null || Version.m8065a(firmwareInfo).compareTo(Version.m8066a(robotVersionInfo)) > 0;
    }

    /* renamed from: a */
    public void m8275a(String str) {
        File file = new File(Settings.m8618a().m8604h(), str);
        if (file.exists() && file.canWrite() && !file.delete()) {
            f4565b.mo1504b((Object) "delete cached firmware file failed.");
        }
    }

    /* renamed from: c */
    public void m8258c(int i) {
        this.f4575j.remove(i);
    }

    /* renamed from: e */
    private void m8248e() {
        this.f4575j.clear();
    }

    /* renamed from: d */
    private C1815b m8250d(int i) {
        List<C1815b> list = this.f4575j.get(i);
        C1815b c1815b = null;
        if (list == null) {
            return null;
        }
        for (C1815b c1815b2 : list) {
            if (c1815b == null || (c1815b2.m8236b() != null && c1815b.m8236b() != null && c1815b2.m8236b().getPublishTime().after(c1815b.m8236b().getPublishTime()))) {
                c1815b = c1815b2;
            }
        }
        return c1815b;
    }

    /* renamed from: b */
    private void m8269b(int i, InterfaceC1816c interfaceC1816c) {
        List<InterfaceC1816c> list = this.f4577l.get(i);
        if (list == null) {
            list = new ArrayList<>();
            this.f4577l.put(i, list);
        }
        list.add(interfaceC1816c);
        this.f4578m.add(interfaceC1816c);
        RobotVersionInfo robotVersionInfo = this.f4576k.get(i);
        if (robotVersionInfo != null) {
            interfaceC1816c.mo8234a(robotVersionInfo, new NvError(0, "success"));
        }
        C1815b m8250d = m8250d(i);
        if (m8250d == null) {
            return;
        }
        if (m8250d.m8236b() != null) {
            interfaceC1816c.mo8233a(m8250d.m8236b(), new NvError(0, "success"));
        }
        if (m8291a(m8250d.m8236b(), robotVersionInfo)) {
            interfaceC1816c.mo8235a(robotVersionInfo, m8250d.m8236b());
        }
    }

    /* renamed from: a */
    public void m8296a(int i, InterfaceC1816c interfaceC1816c) {
        int i2 = i & 1;
        if (i2 != 0) {
            m8269b(i2, interfaceC1816c);
        }
    }

    public void unregisterFirmwareManagerEventListener(InterfaceC1816c interfaceC1816c) {
        int size = this.f4577l.size();
        for (int i = 0; i < size; i++) {
            List<InterfaceC1816c> valueAt = this.f4577l.valueAt(i);
            if (valueAt != null) {
                valueAt.remove(interfaceC1816c);
            }
        }
        this.f4578m.remove(interfaceC1816c);
    }

    /* renamed from: a */
    public void m8256c(RobotVersionInfo robotVersionInfo, NvError nvError) {
        for (InterfaceC1816c interfaceC1816c : this.f4578m) {
            interfaceC1816c.mo8234a(robotVersionInfo, nvError);
        }
    }

    /* renamed from: b */
    private void m8265b(FirmwareInfo firmwareInfo) {
        int m8261b = m8261b(firmwareInfo.getProductName());
        if (m8261b == -1) {
            C3044k c3044k = f4565b;
            c3044k.mo1504b((Object) ("unknown product : " + firmwareInfo.getProductName()));
            return;
        }
        List<C1815b> list = this.f4575j.get(m8261b);
        if (list == null) {
            list = new ArrayList<>();
            this.f4575j.put(m8261b, list);
        }
        for (C1815b c1815b : list) {
            if (c1815b.m8237a() == m8261b && c1815b.m8236b().equals(firmwareInfo)) {
                C3044k c3044k2 = f4565b;
                c3044k2.mo1499d("already has this version : " + firmwareInfo);
                return;
            }
        }
        list.add(new C1815b(m8261b, null, firmwareInfo));
    }

    /* renamed from: a */
    public void m8254c(FirmwareInfo firmwareInfo, NvError nvError) {
        int intValue;
        if (nvError.m6266a() != 0) {
            return;
        }
        if (firmwareInfo != null) {
            intValue = m8261b(firmwareInfo.getProductName());
        } else {
            intValue = ((Integer) nvError.m6262c()).intValue();
        }
        List<InterfaceC1816c> list = this.f4577l.get(intValue);
        if (list == null) {
            return;
        }
        for (InterfaceC1816c interfaceC1816c : list) {
            interfaceC1816c.mo8233a(firmwareInfo, nvError);
        }
    }

    /* renamed from: a */
    public void m8257c(RobotVersionInfo robotVersionInfo, FirmwareInfo firmwareInfo) {
        int m8627a;
        if (firmwareInfo != null) {
            m8627a = m8261b(firmwareInfo.getProductName());
        } else {
            m8627a = robotVersionInfo.m8627a();
        }
        List<InterfaceC1816c> list = this.f4577l.get(m8627a);
        if (list == null) {
            return;
        }
        for (InterfaceC1816c interfaceC1816c : list) {
            interfaceC1816c.mo8235a(robotVersionInfo, firmwareInfo);
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("use_test_environment".equals(str)) {
            f4565b.mo1504b((Object) "Environment changed, please restart the app.");
            new Exception("Environment changed, please restart the app.").printStackTrace();
        }
    }

    /* renamed from: a */
    public RobotVersionInfo m8297a(int i) {
        return this.f4576k.get(i);
    }

    /* renamed from: b */
    public FirmwareInfo m8270b(int i) {
        C1815b m8250d = m8250d(i);
        if (m8250d == null) {
            return null;
        }
        return m8250d.m8236b();
    }

    /* compiled from: FirmwareManager.java */
    /* renamed from: com.navatics.app.framework.firmware.e$5 */
    /* loaded from: classes.dex */
    public class C18125 implements ObservableOnSubscribe<Boolean> {
        /* renamed from: lambda$8qy-6krdHX0wuE1Zj_vRRbPyJiw */
        public static /* synthetic */ void m13067lambda$8qy6krdHX0wuE1Zj_vRRbPyJiw(BroadcastReceiver broadcastReceiver) {
            m8239a(broadcastReceiver);
        }

        C18125() {
            FirmwareManager.this = r1;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(final ObservableEmitter<Boolean> observableEmitter) throws Exception {
            final BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.navatics.app.framework.firmware.e.5.1
                {
                    C18125.this = this;
                }

                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    boolean m5874b;
                    if (Navatics.m7935e().getSharedPreferences("app_settings", 0).getBoolean("allow_update_cellular", false)) {
                        m5874b = NetworkUtil.m5875a(context);
                    } else {
                        m5874b = NetworkUtil.m5874b(context);
                    }
                    observableEmitter.onNext(Boolean.valueOf(m5874b));
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            Navatics.m7935e().registerReceiver(broadcastReceiver, intentFilter);
            observableEmitter.setDisposable(FirmwareManager.m8262b(new InterfaceC2848a() { // from class: com.navatics.app.framework.firmware.-$$Lambda$e$5$8qy-6krdHX0wuE1Zj_vRRbPyJiw
                @Override // io.reactivex.p096b.InterfaceC2848a
                public final void run() {
                    FirmwareManager.C18125.m13067lambda$8qy6krdHX0wuE1Zj_vRRbPyJiw(broadcastReceiver);
                }
            }));
        }

        /* renamed from: a */
        public static /* synthetic */ void m8239a(BroadcastReceiver broadcastReceiver) throws Exception {
            FirmwareManager.m8268b(Navatics.m7935e(), broadcastReceiver);
        }
    }

    /* renamed from: f */
    private Observable<Boolean> m8246f() {
        return Observable.m3097a((ObservableOnSubscribe) new C18125());
    }

    /* renamed from: b */
    public static void m8268b(Context context, BroadcastReceiver broadcastReceiver) {
        try {
            context.unregisterReceiver(broadcastReceiver);
        } catch (Exception e) {
            f4565b.mo1503b("receiver was already unregistered", e);
        }
    }

    /* renamed from: b */
    public static Disposable m8262b(final InterfaceC2848a interfaceC2848a) {
        return Disposables.m3221a(new InterfaceC2848a() { // from class: com.navatics.app.framework.firmware.-$$Lambda$e$7ITHYc7mHZB-TlumommL7y1---8
            @Override // io.reactivex.p096b.InterfaceC2848a
            public final void run() {
                FirmwareManager.m13063lambda$7ITHYc7mHZBTlumommL7y18(InterfaceC2848a.this);
            }
        });
    }

    /* renamed from: c */
    public static /* synthetic */ void m8253c(final InterfaceC2848a interfaceC2848a) throws Exception {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            interfaceC2848a.run();
            return;
        }
        final AbstractC2901p.AbstractC2904c mo3063a = AndroidSchedulers.m3250a().mo3063a();
        mo3063a.mo3058a(new Runnable() { // from class: com.navatics.app.framework.firmware.-$$Lambda$e$iCSkuLAWNu0zUxg7CXRmvoGw6Eg
            @Override // java.lang.Runnable
            public final void run() {
                FirmwareManager.lambda$iCSkuLAWNu0zUxg7CXRmvoGw6Eg(InterfaceC2848a.this, mo3063a);
            }
        });
    }

    /* renamed from: a */
    public static /* synthetic */ void m8278a(InterfaceC2848a interfaceC2848a, AbstractC2901p.AbstractC2904c abstractC2904c) {
        try {
            interfaceC2848a.run();
        } catch (Exception e) {
            f4565b.mo1503b("Could not unregister receiver in UI Thread", e);
        }
        abstractC2904c.dispose();
    }

    /* renamed from: b */
    private int m8261b(String str) {
        return (!C2160n.m5855a((CharSequence) str) && str.equals("MITO")) ? 1 : -1;
    }

    /* renamed from: c */
    public String m8255c(FirmwareInfo firmwareInfo) {
        return firmwareInfo.versionValue + "." + f4567d.format(firmwareInfo.getPublishTime()) + ".bin";
    }

    /* renamed from: c */
    public void m8259c() {
        m8274a(false);
    }

    /* renamed from: b */
    private void m8266b(final RobotVersionInfo robotVersionInfo, final NvError nvError) {
        NvEventLoop.m6231b().mo6286a(new Runnable() { // from class: com.navatics.app.framework.firmware.-$$Lambda$e$LKP9468FIcGNbPNJDziNVc2OWQ0
            @Override // java.lang.Runnable
            public final void run() {
                FirmwareManager.lambda$LKP9468FIcGNbPNJDziNVc2OWQ0(FirmwareManager.this, robotVersionInfo, nvError);
            }
        });
    }

    /* renamed from: b */
    private void m8264b(final FirmwareInfo firmwareInfo, final NvError nvError) {
        NvEventLoop.m6231b().mo6286a(new Runnable() { // from class: com.navatics.app.framework.firmware.-$$Lambda$e$y5JYwZEzIgb-pw5uB4S2LL5qOFw
            @Override // java.lang.Runnable
            public final void run() {
                FirmwareManager.m13066lambda$y5JYwZEzIgbpw5uB4S2LL5qOFw(FirmwareManager.this, firmwareInfo, nvError);
            }
        });
    }

    /* renamed from: b */
    private void m8267b(final RobotVersionInfo robotVersionInfo, final FirmwareInfo firmwareInfo) {
        NvEventLoop.m6231b().mo6286a(new Runnable() { // from class: com.navatics.app.framework.firmware.-$$Lambda$e$JPDajdRhaaTCURGH58wB61hr7X4
            @Override // java.lang.Runnable
            public final void run() {
                FirmwareManager.lambda$JPDajdRhaaTCURGH58wB61hr7X4(FirmwareManager.this, robotVersionInfo, firmwareInfo);
            }
        });
    }

    /* renamed from: g */
    private synchronized void m8245g() {
        this.f4581p = false;
        f4565b.mo1499d("check done.");
    }

    /* renamed from: b */
    public void m8260b(boolean z) {
        GroundStation groundStation = this.f4573h;
        if (groundStation == null || !groundStation.m8120c()) {
            m8245g();
            return;
        }
        NvConnection m8098m = this.f4573h.m8098m();
        if (m8098m == null || !m8098m.m7875j()) {
            m8245g();
        } else if (!m8098m.m7875j()) {
            m8245g();
        } else {
            NvRobot nvRobot = (NvRobot) m8098m.m7898a(InputDeviceCompat.SOURCE_TOUCHSCREEN);
            C3044k c3044k = f4565b;
            c3044k.mo1499d("checkStart : " + nvRobot + ", force " + z);
            if (nvRobot != null) {
                RobotVersionInfo robotVersionInfo = this.f4576k.get(1);
                C3044k c3044k2 = f4565b;
                c3044k2.mo1511a((Object) ("checkStart : " + robotVersionInfo));
                if (robotVersionInfo != null && !z) {
                    m8266b(robotVersionInfo, new NvError(0));
                    m8249d(z);
                    return;
                }
                this.f4582q.m8238a().obtainMessage(2, z ? 1 : 0, 0, nvRobot).sendToTarget();
                return;
            }
            m8245g();
        }
    }

    /* renamed from: a */
    public void m8280a(NvRobot nvRobot, final boolean z) {
        nvRobot.m7678p().mo6312a(new NvObserver() { // from class: com.navatics.app.framework.firmware.-$$Lambda$e$bwP4QMgPQe7Hu12rZenKA5Yku-c
            @Override // com.navatics.robot.transport.p063b.NvObserver
            public final void onNext(Object obj) {
                FirmwareManager.m13064lambda$bwP4QMgPQe7Hu12rZenKA5Ykuc(FirmwareManager.this, z, (RobotVersionInfo) obj);
            }
        }, new NvExceptionHandler() { // from class: com.navatics.app.framework.firmware.-$$Lambda$e$Frm_RmIXO34JTP83IYJggp1rqZY
            @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
            public final void onError(Throwable th) {
                FirmwareManager.lambda$Frm_RmIXO34JTP83IYJggp1rqZY(FirmwareManager.this, z, th);
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m8273a(boolean z, RobotVersionInfo robotVersionInfo) throws Exception {
        C3044k c3044k = f4565b;
        c3044k.mo1511a((Object) ("robotVersion = " + robotVersionInfo));
        this.f4576k.put(1, robotVersionInfo);
        m8266b(robotVersionInfo, new NvError(0));
        m8249d(z);
    }

    /* renamed from: a */
    public /* synthetic */ void m8272a(boolean z, Throwable th) {
        f4565b.mo1504b((Object) "retrieveRobotInfo error");
        th.printStackTrace();
        m8266b((RobotVersionInfo) null, new NvError(48, "Get robot version error.", 1));
        m8249d(z);
    }

    /* renamed from: c */
    public void m8252c(boolean z) {
        GroundStation groundStation = this.f4573h;
        if (groundStation == null || !groundStation.m8120c()) {
            m8245g();
            return;
        }
        NvConnection m8098m = this.f4573h.m8098m();
        if (m8098m == null || !m8098m.m7875j()) {
            m8245g();
        } else if (!m8098m.m7875j()) {
            m8245g();
        } else {
            RobotVersionInfo m8063a = Version.m8063a(this.f4574i.versionValue);
            if (m8063a == null) {
                m8266b((RobotVersionInfo) null, new NvError(48, "Get robot version error.", 1));
                return;
            }
            this.f4576k.put(1, m8063a);
            m8266b(m8063a, new NvError(0));
        }
    }

    /* renamed from: d */
    private void m8249d(boolean z) {
        FirmwareInfo m8270b = m8270b(1);
        if (m8270b != null && !z) {
            m8264b(m8270b, new NvError(0));
            RobotVersionInfo robotVersionInfo = this.f4576k.get(m8261b(m8270b.getProductName()));
            if (m8291a(m8270b, robotVersionInfo)) {
                m8267b(robotVersionInfo, m8270b);
            }
            m8245g();
            return;
        }
        m8244h();
    }

    /* renamed from: h */
    private void m8244h() {
        C3204l<Result<FirmwareInfo>> mo142a;
        Result<FirmwareInfo> m67e;
        f4565b.mo1511a((Object) "retrieveFirmwareInfoFromServer 0");
        try {
            mo142a = this.f4571f.getOnlineFileInfoSync(m8247e(1), "latest").mo142a();
            m67e = mo142a.m67e();
        } catch (IOException e) {
            e.printStackTrace();
            m8264b((FirmwareInfo) null, new NvError(69, this.f4570e.getString(R.string.get_server_firmware_err, 69), e));
        }
        if (mo142a.m68d() && m67e != null && m67e.getCode() == 0) {
            FirmwareInfo data = m67e.getData();
            if (data == null) {
                m8264b((FirmwareInfo) null, new NvError(70, this.f4570e.getString(R.string.get_server_firmware_err, 70), m67e));
                m8245g();
                return;
            }
            this.f4574i = data;
            C3044k c3044k = f4565b;
            c3044k.mo1511a((Object) ("retrieveFirmwareInfoFromServer 1 : " + data));
            m8265b(data);
            m8264b(data, new NvError(0));
            RobotVersionInfo robotVersionInfo = this.f4576k.get(m8261b(data.getProductName()));
            if (m8291a(data, robotVersionInfo)) {
                m8267b(robotVersionInfo, data);
                NotificationUtils notificationUtils = new NotificationUtils(this.f4570e);
                Log.i("info", "retrieveFirmwareInfoFromServer: " + data.getVersionValue());
                notificationUtils.m8073c("New firmware available!", "New firmware " + data.getVersionValue() + " for robot is available");
            }
            m8245g();
            return;
        }
        f4565b.mo1504b((Object) "retrieveFirmwareInfoFromServer server error");
        m8264b((FirmwareInfo) null, new NvError(71, this.f4570e.getString(R.string.get_server_firmware_err, 71), m67e));
        m8245g();
    }

    /* renamed from: a */
    public synchronized void m8274a(boolean z) {
        if (this.f4573h != null && this.f4573h.m8120c()) {
            NvConnection m8098m = this.f4573h.m8098m();
            if (m8098m != null && m8098m.m7875j()) {
                if (!m8098m.m7875j()) {
                    f4565b.mo1504b((Object) "connection not been authenticated.");
                    return;
                } else if (this.f4581p) {
                    f4565b.mo1499d("checkForUpdate in progress...");
                    return;
                } else {
                    this.f4581p = true;
                    Handler m8238a = this.f4582q.m8238a();
                    C3044k c3044k = f4565b;
                    c3044k.mo1511a((Object) ("checkForUpdate : " + z));
                    m8238a.obtainMessage(1, Boolean.valueOf(z)).sendToTarget();
                    return;
                }
            }
            f4565b.mo1504b((Object) "checkForUpdate error, device not connected or not authenticated.");
            return;
        }
        f4565b.mo1504b((Object) "checkForUpdate error, gta not connected or not authenticated.");
    }

    @EventHandler(m8585b = 65547)
    void onGroundStationConnected(GroundStation groundStation) {
        f4565b.mo1511a((Object) "onGroundStationConnected");
        this.f4573h = groundStation;
    }

    @EventHandler(m8585b = 65548)
    void onGroundStationDisconnected(GroundStation groundStation) {
        f4565b.mo1511a((Object) "onGroundStationDisconnected");
        if (this.f4573h == groundStation) {
            this.f4573h = null;
        }
        m8248e();
    }

    @EventHandler(m8585b = 65543)
    void onConnectionReady(NvConnection nvConnection) {
        f4565b.mo1511a((Object) "onConnectionReady");
        m8259c();
    }
}
