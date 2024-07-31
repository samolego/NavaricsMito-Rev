package com.navatics.app.framework.divelog;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Location;
import android.net.Uri;
import android.os.Looper;
import android.support.p008v4.app.FragmentTransaction;
import android.support.p008v4.view.InputDeviceCompat;
import android.text.TextUtils;
import android.util.Log;
import com.example.divelog.dao.entity.CommandCard;
import com.example.divelog.dao.entity.DiveLogItem;
import com.google.gson.JsonObject;
import com.navatics.app.framework.BuoyStatus;
import com.navatics.app.framework.GroundStation;
import com.navatics.app.framework.Navatics;
import com.navatics.app.framework.NvBuoy;
import com.navatics.app.framework.NvConnection;
import com.navatics.app.framework.NvRobot;
import com.navatics.app.framework.RobotStatus;
import com.navatics.app.framework.WeatherManager;
import com.navatics.app.framework.divelog.DiveLogManager;
import com.navatics.app.framework.location.NvLocation;
import com.navatics.app.framework.location.NvLocationManager;
import com.navatics.app.framework.p052d.DiveLogBuildHelper;
import com.navatics.app.framework.user.DiveLogList;
import com.navatics.app.framework.user.NvUser;
import com.navatics.app.framework.user.NvUserEvent;
import com.navatics.app.framework.user.NvUserManager;
import com.navatics.app.framework.user.Result;
import com.navatics.robot.transport.NvBatteryInfo;
import com.navatics.robot.utils.CargoMsg;
import com.navatics.robot.utils.CargoThread;
import com.navatics.robot.utils.NetworkUtil;
import com.navatics.robot.utils.RxTimer;
import com.navatics.xlog.WLog;
import io.objectbox.Box;
import io.reactivex.AbstractC2901p;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.p093a.p095b.AndroidSchedulers;
import io.reactivex.p096b.Consumer;
import io.reactivex.p096b.Function;
import io.reactivex.p096b.InterfaceC2848a;
import io.reactivex.p099e.Schedulers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.app.framework.divelog.a */
/* loaded from: classes.dex */
public class DiveLogManager implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a */
    private static final String f4403a = "a";

    /* renamed from: b */
    private static final C3044k f4404b = C3044k.m1564a(DiveLogManager.class);

    /* renamed from: c */
    private static DiveLogManager f4405c;

    /* renamed from: d */
    private C1791a f4406d;

    /* renamed from: e */
    private Disposable f4407e;

    /* renamed from: f */
    private Disposable f4408f;

    /* renamed from: g */
    private Disposable f4409g;

    /* renamed from: h */
    private boolean f4410h;

    /* renamed from: i */
    private List<InterfaceC1793c> f4411i = new ArrayList();

    /* compiled from: DiveLogManager.java */
    /* renamed from: com.navatics.app.framework.divelog.a$c */
    /* loaded from: classes.dex */
    public interface InterfaceC1793c {
        /* renamed from: a */
        void mo8443a();

        /* renamed from: b */
        void mo8442b();
    }

    public static /* synthetic */ void lambda$51UHAi2WBb4alIsc7AsErD1331A(DiveLogManager diveLogManager, Boolean bool) {
        diveLogManager.m8478a(bool);
    }

    /* renamed from: lambda$7iAi6NbOiS2lmLhqu5yz7-NEHnI */
    public static /* synthetic */ void m13059lambda$7iAi6NbOiS2lmLhqu5yz7NEHnI(InterfaceC2848a interfaceC2848a, AbstractC2901p.AbstractC2904c abstractC2904c) {
        m8479a(interfaceC2848a, abstractC2904c);
    }

    public static /* synthetic */ void lambda$8wkWuVINtjjm400k1weBfKxshFs(DiveLogManager diveLogManager) {
        diveLogManager.m8453n();
    }

    /* renamed from: lambda$9u08YQHni-e6OglPA8npYn2xYoQ */
    public static /* synthetic */ ObservableSource m13060lambda$9u08YQHnie6OglPA8npYn2xYoQ(DiveLogManager diveLogManager, List list, Result result) {
        return diveLogManager.m8475a(list, result);
    }

    public static /* synthetic */ Observable lambda$JKLNodDjtqvt2ItL7u0tVqjE0Zk(DiveLogManager diveLogManager, String str) {
        return diveLogManager.m8477a(str);
    }

    public static /* synthetic */ void lambda$WNmhqECK6Y_07WbGwqaJpwuysZk(DiveLogManager diveLogManager, NvUserEvent nvUserEvent) {
        diveLogManager.m8481a(nvUserEvent);
    }

    public static /* synthetic */ void lambda$prCs58NvNircJSDG5XHJcieMY8M(InterfaceC2848a interfaceC2848a) {
        m8466c(interfaceC2848a);
    }

    public static /* synthetic */ void lambda$rARNYwSU5SfvHVj7AYwZqX7V1P8(DiveLogManager diveLogManager, Throwable th) {
        diveLogManager.m8476a(th);
    }

    /* renamed from: a */
    public static synchronized void m8489a() {
        synchronized (DiveLogManager.class) {
            f4405c = new DiveLogManager();
        }
    }

    /* renamed from: b */
    public static DiveLogManager m8472b() {
        return f4405c;
    }

    private DiveLogManager() {
        SharedPreferences sharedPreferences = Navatics.m7935e().getSharedPreferences("app_settings", 0);
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        this.f4410h = sharedPreferences.getBoolean("auto_sync_divelog", true);
        this.f4407e = m8455l().m3075b(Schedulers.m3217b()).m3091a(Schedulers.m3217b()).m3071c(new Consumer() { // from class: com.navatics.app.framework.divelog.-$$Lambda$a$51UHAi2WBb4alIsc7AsErD1331A
            @Override // io.reactivex.p096b.Consumer
            public final void accept(Object obj) {
                DiveLogManager.lambda$51UHAi2WBb4alIsc7AsErD1331A(DiveLogManager.this, (Boolean) obj);
            }
        });
        this.f4408f = NvUserManager.m7828b().m7791i().m3075b(Schedulers.m3217b()).m3091a(AndroidSchedulers.m3250a()).m3107a(new Consumer() { // from class: com.navatics.app.framework.divelog.-$$Lambda$a$WNmhqECK6Y_07WbGwqaJpwuysZk
            @Override // io.reactivex.p096b.Consumer
            public final void accept(Object obj) {
                DiveLogManager.lambda$WNmhqECK6Y_07WbGwqaJpwuysZk(DiveLogManager.this, (NvUserEvent) obj);
            }
        }, new Consumer() { // from class: com.navatics.app.framework.divelog.-$$Lambda$e27-Kr4VJxN1zC_AGmQwWE7CADQ
            @Override // io.reactivex.p096b.Consumer
            public final void accept(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m8478a(Boolean bool) throws Exception {
        if (bool.booleanValue() && this.f4410h) {
            m8460g();
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("auto_sync_divelog".equals(str)) {
            this.f4410h = sharedPreferences.getBoolean("auto_sync_divelog", true);
            if (this.f4410h) {
                m8460g();
            }
        }
    }

    public void addSyncListener(InterfaceC1793c interfaceC1793c) {
        if (interfaceC1793c == null || this.f4411i.contains(interfaceC1793c)) {
            return;
        }
        this.f4411i.add(interfaceC1793c);
    }

    public void removeSyncListener(InterfaceC1793c interfaceC1793c) {
        this.f4411i.remove(interfaceC1793c);
    }

    /* renamed from: j */
    private void m8457j() {
        for (InterfaceC1793c interfaceC1793c : this.f4411i) {
            interfaceC1793c.mo8443a();
        }
    }

    /* renamed from: k */
    private void m8456k() {
        for (InterfaceC1793c interfaceC1793c : this.f4411i) {
            interfaceC1793c.mo8442b();
        }
    }

    /* renamed from: a */
    public void m8481a(NvUserEvent nvUserEvent) {
        switch (nvUserEvent.m7777b()) {
            case 0:
                Disposable disposable = this.f4408f;
                if (disposable != null) {
                    disposable.dispose();
                    this.f4408f = null;
                    return;
                }
                return;
            case 1:
            case 2:
                if (this.f4410h) {
                    m8460g();
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* compiled from: DiveLogManager.java */
    /* renamed from: com.navatics.app.framework.divelog.a$1 */
    /* loaded from: classes.dex */
    public class C17831 implements ObservableOnSubscribe<Boolean> {
        public static /* synthetic */ void lambda$nPW7PmT_jAIw890niSVL2v_LWIE(BroadcastReceiver broadcastReceiver) {
            m8452a(broadcastReceiver);
        }

        C17831() {
            DiveLogManager.this = r1;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(final ObservableEmitter<Boolean> observableEmitter) throws Exception {
            final BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.navatics.app.framework.divelog.a.1.1
                {
                    C17831.this = this;
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
            observableEmitter.setDisposable(DiveLogManager.m8469b(new InterfaceC2848a() { // from class: com.navatics.app.framework.divelog.-$$Lambda$a$1$nPW7PmT_jAIw890niSVL2v_LWIE
                @Override // io.reactivex.p096b.InterfaceC2848a
                public final void run() {
                    DiveLogManager.C17831.lambda$nPW7PmT_jAIw890niSVL2v_LWIE(broadcastReceiver);
                }
            }));
        }

        /* renamed from: a */
        public static /* synthetic */ void m8452a(BroadcastReceiver broadcastReceiver) throws Exception {
            DiveLogManager.m8471b(Navatics.m7935e(), broadcastReceiver);
        }
    }

    /* renamed from: l */
    private Observable<Boolean> m8455l() {
        return Observable.m3097a((ObservableOnSubscribe) new C17831());
    }

    /* renamed from: b */
    public static void m8471b(Context context, BroadcastReceiver broadcastReceiver) {
        try {
            context.unregisterReceiver(broadcastReceiver);
        } catch (Exception e) {
            f4404b.mo1503b("receiver was already unregistered", e);
        }
    }

    /* renamed from: b */
    public static Disposable m8469b(final InterfaceC2848a interfaceC2848a) {
        return Disposables.m3221a(new InterfaceC2848a() { // from class: com.navatics.app.framework.divelog.-$$Lambda$a$prCs58NvNircJSDG5XHJcieMY8M
            @Override // io.reactivex.p096b.InterfaceC2848a
            public final void run() {
                DiveLogManager.lambda$prCs58NvNircJSDG5XHJcieMY8M(InterfaceC2848a.this);
            }
        });
    }

    /* renamed from: c */
    public static /* synthetic */ void m8466c(final InterfaceC2848a interfaceC2848a) throws Exception {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            interfaceC2848a.run();
            return;
        }
        final AbstractC2901p.AbstractC2904c mo3063a = AndroidSchedulers.m3250a().mo3063a();
        mo3063a.mo3058a(new Runnable() { // from class: com.navatics.app.framework.divelog.-$$Lambda$a$7iAi6NbOiS2lmLhqu5yz7-NEHnI
            @Override // java.lang.Runnable
            public final void run() {
                DiveLogManager.m13059lambda$7iAi6NbOiS2lmLhqu5yz7NEHnI(InterfaceC2848a.this, mo3063a);
            }
        });
    }

    /* renamed from: a */
    public static /* synthetic */ void m8479a(InterfaceC2848a interfaceC2848a, AbstractC2901p.AbstractC2904c abstractC2904c) {
        try {
            interfaceC2848a.run();
        } catch (Exception e) {
            f4404b.mo1503b("Could not unregister recneiver in UI Thread", e);
        }
        abstractC2904c.dispose();
    }

    /* renamed from: c */
    public synchronized void m8467c() {
        if (m8462e()) {
            return;
        }
        if (NvUserManager.m7828b().m7806d() == null) {
            WLog.m5850d(f4403a, "request startLogging, but user is null, ignore the request.");
            return;
        }
        WLog.m5850d(f4403a, "-----> dive log start");
        this.f4406d = new C1791a();
        this.f4406d.m8449a();
    }

    /* renamed from: d */
    public synchronized void m8464d() {
        if (m8462e()) {
            if (this.f4406d != null) {
                WLog.m5850d(f4403a, "stopLogging, waiting thread to be stopped.");
                this.f4406d.m8444b();
                this.f4406d = null;
                if (this.f4410h) {
                    m8460g();
                }
            }
            WLog.m5850d(f4403a, "<----- dive log end.");
        }
    }

    /* renamed from: e */
    public boolean m8462e() {
        return this.f4406d != null;
    }

    /* renamed from: a */
    public DiveLog m8473a(boolean z) {
        GroundStation groundStation;
        DiveLog diveLog;
        WeatherManager m8592b = WeatherManager.m8592b();
        NvUser m7806d = NvUserManager.m7828b().m7806d();
        NvConnection nvConnection = null;
        if (m7806d == null) {
            f4404b.mo1504b((Object) "wtf?! user is null?");
            return null;
        }
        if (z) {
            groundStation = null;
        } else {
            GroundStation m7931h = Navatics.m7931h();
            if (m7931h == null) {
                f4404b.mo1504b((Object) "wtf?! current sta is null?");
                return null;
            }
            groundStation = m7931h;
        }
        if (!z) {
            NvConnection m8098m = groundStation.m8098m();
            if (m8098m == null) {
                f4404b.mo1504b((Object) "wtf?! current connection is null");
                return null;
            }
            nvConnection = m8098m;
        }
        if (!z) {
            diveLog = new DiveLog((NvRobot) nvConnection.m7898a(InputDeviceCompat.SOURCE_TOUCHSCREEN), (NvBuoy) nvConnection.m7898a(FragmentTransaction.TRANSIT_FRAGMENT_OPEN), groundStation, m7806d.getEmail(), Calendar.getInstance().getTime(), System.currentTimeMillis(), m8592b.m8591c(), m8592b.m8589e());
        } else {
            diveLog = new DiveLog(null, null, null, m7806d.getEmail(), Calendar.getInstance().getTime(), System.currentTimeMillis(), m8592b.m8591c(), m8592b.m8589e());
        }
        Navatics.m7933f().m3474d(DiveLog.class).m3421b((Box) diveLog);
        return diveLog;
    }

    /* renamed from: f */
    public DiveLog m8461f() {
        return m8473a(false);
    }

    /* renamed from: a */
    public void m8488a(long j, DiveLog diveLog, int i, int i2) {
        if (j - diveLog.getStartTime() < 60000) {
            diveLog.delete();
            String str = f4403a;
            WLog.m5850d(str, "delete divelog(" + diveLog.getStartTime() + ") because its duration is " + (j - diveLog.getStartTime()));
            return;
        }
        diveLog.setEndTime(j);
        diveLog.setAverageDepth(i);
        diveLog.setMaxDepth(i2);
        Navatics.m7933f().m3474d(DiveLog.class).m3421b((Box) diveLog);
        String str2 = f4403a;
        WLog.m5850d(str2, "endDiveLog(" + diveLog.getStartTime() + "), duration=" + (j - diveLog.getStartTime()));
    }

    /* renamed from: a */
    public void m8486a(Uri uri) {
        C1791a c1791a;
        if (!m8462e() || (c1791a = this.f4406d) == null) {
            return;
        }
        c1791a.m8447a(uri);
    }

    /* renamed from: g */
    public synchronized void m8460g() {
        if (NetworkUtil.m5875a(Navatics.m7935e()) && NvUserManager.m7828b().m7806d() != null) {
            m8454m();
        }
    }

    /* renamed from: m */
    private synchronized void m8454m() {
        if (this.f4409g == null || this.f4409g.isDisposed()) {
            WLog.m5850d(f4403a, "DiveLogManager sync start");
            m8457j();
            NvUserManager m7828b = NvUserManager.m7828b();
            NvUser m7806d = NvUserManager.m7828b().m7806d();
            final List m3300e = Navatics.m7933f().m3474d(DiveLog.class).m3416e().m3290a(DiveLog_.email, m7806d.getEmail()).m3293a(DiveLog_.startTime).m3288b().m3300e();
            StartTimes startTimes = new StartTimes();
            if (m3300e != null) {
                Iterator it = m3300e.iterator();
                while (it.hasNext()) {
                    startTimes.addStartTime(((DiveLog) it.next()).getStartTime() + "");
                }
            }
            this.f4409g = m7828b.m7836a(m7806d.getEmail(), startTimes).m3091a(Schedulers.m3217b()).m3078b(new Function() { // from class: com.navatics.app.framework.divelog.-$$Lambda$a$9u08YQHni-e6OglPA8npYn2xYoQ
                @Override // io.reactivex.p096b.Function
                public final Object apply(Object obj) {
                    return DiveLogManager.m13060lambda$9u08YQHnie6OglPA8npYn2xYoQ(DiveLogManager.this, m3300e, (Result) obj);
                }
            }).m3074c().m3256b(Schedulers.m3217b()).m3259a(AndroidSchedulers.m3250a()).m3261a(new InterfaceC2848a() { // from class: com.navatics.app.framework.divelog.-$$Lambda$a$8wkWuVINtjjm400k1weBfKxshFs
                @Override // io.reactivex.p096b.InterfaceC2848a
                public final void run() {
                    DiveLogManager.lambda$8wkWuVINtjjm400k1weBfKxshFs(DiveLogManager.this);
                }
            }, new Consumer() { // from class: com.navatics.app.framework.divelog.-$$Lambda$a$rARNYwSU5SfvHVj7AYwZqX7V1P8
                @Override // io.reactivex.p096b.Consumer
                public final void accept(Object obj) {
                    DiveLogManager.lambda$rARNYwSU5SfvHVj7AYwZqX7V1P8(DiveLogManager.this, (Throwable) obj);
                }
            });
        }
    }

    /* renamed from: a */
    public /* synthetic */ ObservableSource m8475a(List list, Result result) throws Exception {
        if (result.getCode() != 0) {
            throw new RuntimeException("getStartTimeByEmail failed.");
        }
        return Observable.m3094a(m8474a(list, (List) result.getData()), m8465c(list, (List) result.getData()));
    }

    /* renamed from: n */
    public /* synthetic */ void m8453n() throws Exception {
        WLog.m5844i(f4403a, "sync finish");
        m8456k();
        this.f4409g = null;
    }

    /* renamed from: a */
    public /* synthetic */ void m8476a(Throwable th) throws Exception {
        String str = f4403a;
        WLog.m5848e(str, "dive log sync failed, method : getStartTimeByEmail, msg : " + th.getMessage());
        th.printStackTrace();
        m8456k();
        this.f4409g = null;
    }

    /* renamed from: a */
    private Observable<Object<String, DiveLog>> m8474a(final List<DiveLog> list, final List<DiveLogList> list2) {
        return Observable.m3097a((ObservableOnSubscribe) new ObservableOnSubscribe<List<DiveLog>>() { // from class: com.navatics.app.framework.divelog.a.2
            {
                DiveLogManager.this = this;
            }

            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(ObservableEmitter<List<DiveLog>> observableEmitter) throws Exception {
                List<DiveLog> m8468b = DiveLogManager.this.m8468b(list, list2);
                String str = DiveLogManager.f4403a;
                WLog.m5850d(str, "diveLogNeedUpload size " + m8468b.size());
                observableEmitter.onNext(m8468b);
                observableEmitter.onComplete();
            }
        }).m3078b($$Lambda$BZQvAeJChT7FwCbY4NohBgLRpmU.INSTANCE).m3103a(new Function() { // from class: com.navatics.app.framework.divelog.-$$Lambda$a$ZskTeazPIXUOVPgVLO8nNBZaQ2g
            @Override // io.reactivex.p096b.Function
            public final Object apply(Object obj) {
                Observable m8485a;
                m8485a = DiveLogManager.this.m8485a((DiveLog) obj);
                return m8485a;
            }
        });
    }

    /* renamed from: b */
    public List<DiveLog> m8468b(List<DiveLog> list, List<DiveLogList> list2) {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (int i = 0; i < list2.size(); i++) {
            hashMap.put(list2.get(i).getStartTime(), Integer.valueOf(list2.get(i).getMaxversion()));
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!hashMap.containsKey(list.get(i2).getStartTime() + "")) {
                Log.i("info1", "getNeedUploadLog:client " + list.get(i2).getStartTime());
                arrayList.add(list.get(i2));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public Observable<Object<String, DiveLog>> m8485a(final DiveLog diveLog) throws IOException {
        return DiveLogBuildHelper.m8554a(diveLog).m3069c(Observable.m3082b()).m3078b(new Function<Boolean, ObservableSource<Object<String, DiveLog>>>() { // from class: com.navatics.app.framework.divelog.a.3
            {
                DiveLogManager.this = this;
            }

            @Override // io.reactivex.p096b.Function
            /* renamed from: a */
            public ObservableSource<Object<String, DiveLog>> apply(Boolean bool) throws Exception {
                final Result result;
                if (bool.booleanValue()) {
                    result = new Result(0, "Success", diveLog);
                } else {
                    result = new Result(1010, "failed", diveLog);
                }
                return Observable.m3097a((ObservableOnSubscribe) new ObservableOnSubscribe<Object<String, DiveLog>>() { // from class: com.navatics.app.framework.divelog.a.3.1
                    {
                        C17863.this = this;
                    }

                    @Override // io.reactivex.ObservableOnSubscribe
                    public void subscribe(ObservableEmitter<Object<String, DiveLog>> observableEmitter) throws Exception {
                        observableEmitter.onNext(result);
                        observableEmitter.onComplete();
                    }
                });
            }
        });
    }

    /* renamed from: c */
    private Observable<Object<String, DiveLog>> m8465c(final List<DiveLog> list, final List<DiveLogList> list2) {
        return Observable.m3097a((ObservableOnSubscribe) new ObservableOnSubscribe<List<String>>() { // from class: com.navatics.app.framework.divelog.a.4
            {
                DiveLogManager.this = this;
            }

            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(ObservableEmitter<List<String>> observableEmitter) throws Exception {
                observableEmitter.onNext(DiveLogManager.this.m8463d(list, list2));
                observableEmitter.onComplete();
            }
        }).m3078b($$Lambda$BZQvAeJChT7FwCbY4NohBgLRpmU.INSTANCE).m3103a(new Function() { // from class: com.navatics.app.framework.divelog.-$$Lambda$a$JKLNodDjtqvt2ItL7u0tVqjE0Zk
            @Override // io.reactivex.p096b.Function
            public final Object apply(Object obj) {
                return DiveLogManager.lambda$JKLNodDjtqvt2ItL7u0tVqjE0Zk(DiveLogManager.this, (String) obj);
            }
        });
    }

    /* renamed from: d */
    public List<String> m8463d(List<DiveLog> list, List<DiveLogList> list2) {
        int i;
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < list.size(); i2++) {
            hashMap.put(list.get(i2).startTime + "", list.get(i2));
        }
        for (int i3 = 0; i3 < list2.size(); i3++) {
            if (!hashMap.containsKey(list2.get(i3).getStartTime())) {
                arrayList.add(list2.get(i3).getStartTime());
            } else {
                LocalDiveLogRecord localDiveLogRecord = (LocalDiveLogRecord) Navatics.m7933f().m3474d(LocalDiveLogRecord.class).m3416e().m3290a(LocalDiveLogRecord_.email, NvUserManager.m7828b().m7806d().getEmail()).m3290a(LocalDiveLogRecord_.startTime, list2.get(i3).getStartTime()).m3288b().m3302c();
                if (localDiveLogRecord != null) {
                    i = localDiveLogRecord.m8505a();
                } else {
                    ((DiveLog) hashMap.get(list2.get(i3).getStartTime())).delete();
                    i = 0;
                }
                if (i < list2.get(i3).getMaxversion() || (localDiveLogRecord != null && i == list2.get(i3).getMaxversion() && localDiveLogRecord.m8494f().size() != 0)) {
                    arrayList.add(list2.get(i3).getStartTime());
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public Observable<Object<String, DiveLog>> m8477a(String str) throws IOException {
        return DiveLogBuildHelper.m8548c(str).m3069c(Observable.m3082b()).m3078b(new Function<DiveLog, ObservableSource<Object<String, DiveLog>>>() { // from class: com.navatics.app.framework.divelog.a.5
            {
                DiveLogManager.this = this;
            }

            @Override // io.reactivex.p096b.Function
            /* renamed from: a */
            public ObservableSource<Object<String, DiveLog>> apply(DiveLog diveLog) throws Exception {
                final Result result = new Result(0, "Success", diveLog);
                return Observable.m3097a((ObservableOnSubscribe) new ObservableOnSubscribe<Object<String, DiveLog>>() { // from class: com.navatics.app.framework.divelog.a.5.1
                    {
                        C17895.this = this;
                    }

                    @Override // io.reactivex.ObservableOnSubscribe
                    public void subscribe(ObservableEmitter<Object<String, DiveLog>> observableEmitter) throws Exception {
                        observableEmitter.onNext(result);
                        observableEmitter.onComplete();
                    }
                });
            }
        });
    }

    /* renamed from: a */
    public void m8484a(DiveLog diveLog, String str) {
        int i;
        RobotStatus m7693f = diveLog.getRobot().m7693f();
        BuoyStatus m7907a = diveLog.getBuoy().m7907a();
        GroundStation groundStation = diveLog.getGroundStation();
        NvBatteryInfo m8095p = groundStation.m8095p();
        Intent registerReceiver = Navatics.m7935e().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int m8641m = m7693f.m8641m();
        int m8632v = m7693f.m8632v();
        C1791a c1791a = this.f4406d;
        if (c1791a == null) {
            return;
        }
        c1791a.f4438k = (int) (((c1791a.f4438k + m8641m) * 1.0f) / 2.0f);
        C1791a c1791a2 = this.f4406d;
        c1791a2.f4434g = m8641m > c1791a2.f4434g ? m8641m : this.f4406d.f4434g;
        C1791a c1791a3 = this.f4406d;
        c1791a3.f4435h = m8641m < c1791a3.f4435h ? m8641m : this.f4406d.f4435h;
        C1791a c1791a4 = this.f4406d;
        c1791a4.f4436i = m8632v > c1791a4.f4436i ? m8632v : this.f4406d.f4436i;
        C1791a c1791a5 = this.f4406d;
        if (m8632v >= c1791a5.f4437j) {
            m8632v = this.f4406d.f4437j;
        }
        c1791a5.f4437j = m8632v;
        int i2 = -1;
        if (registerReceiver != null) {
            i = registerReceiver.getIntExtra("level", -1);
            i2 = registerReceiver.getIntExtra("scale", -1);
        } else {
            i = 0;
        }
        WeatherManager m8592b = WeatherManager.m8592b();
        DiveLogEntry diveLogEntry = new DiveLogEntry();
        diveLogEntry.setTimestamp(System.currentTimeMillis());
        diveLogEntry.setAirTemperature(m8592b.m8591c());
        diveLogEntry.setWeather(m8592b.m8590d());
        diveLogEntry.setWindVelocity(m8592b.m8588f());
        diveLogEntry.setWindDirection(m8592b.m8587g());
        diveLogEntry.setBuoyLongitude(m7907a.m8416a());
        diveLogEntry.setBuoyLatitude(m7907a.m8412b());
        diveLogEntry.setPhoneLongitude(0.0f);
        diveLogEntry.setPhoneLatitude(0.0f);
        diveLogEntry.setStateQuaternionW(m7693f.m8661b());
        diveLogEntry.setStateQuaternionX(m7693f.m8658c());
        diveLogEntry.setStateQuaternionY(m7693f.m8655d());
        diveLogEntry.setStateQuaternionZ(m7693f.m8653e());
        diveLogEntry.setRefStateQuaternionW(m7693f.m8649g());
        diveLogEntry.setRefStateQuaternionX(m7693f.m8647h());
        diveLogEntry.setRefStateQuaternionY(m7693f.m8645i());
        diveLogEntry.setRefStateQuaternionZ(m7693f.m8644j());
        diveLogEntry.setTemperature(m7693f.m8632v());
        diveLogEntry.setWaterTemperature(m7693f.m8632v());
        diveLogEntry.setAirTemperature(m7693f.m8632v());
        diveLogEntry.setStateDepth(m8641m);
        diveLogEntry.setRefStateDepth(m7693f.m8639o());
        diveLogEntry.setRpmMotor0(m7693f.m8637q());
        diveLogEntry.setRpmMotor1(m7693f.m8636r());
        diveLogEntry.setRpmMotor2(m7693f.m8635s());
        diveLogEntry.setRpmMotor3(m7693f.m8634t());
        diveLogEntry.setLedState(m7693f.m8633u());
        diveLogEntry.setBatteryState(m7693f.m8631w());
        diveLogEntry.setSensorsState(m7693f.f4213a);
        diveLogEntry.setRobotOperationState(m7693f.m8630x());
        diveLogEntry.setRemoteBattery(m8095p != null ? m8095p.getLevel() : 0);
        diveLogEntry.setBuoyBattery(m7907a.m8410c());
        diveLogEntry.setPhoneBattery((int) (i / i2));
        diveLogEntry.setRemotePER(groundStation.m8093r());
        diveLogEntry.setRemoteRSSI(groundStation.m8094q());
        diveLogEntry.setRemoteSNR(groundStation.m8092s());
        diveLogEntry.parent.setTargetId(diveLog.getId());
        diveLogEntry.setPhotoUri(str);
        diveLog.setEndTime(System.currentTimeMillis());
        diveLog.setAverageDepth(this.f4406d.f4438k);
        diveLog.setMaxDepth(this.f4406d.f4434g);
        diveLog.setMinDepth(this.f4406d.f4435h);
        diveLog.setMaxTemp(this.f4406d.f4436i);
        diveLog.setMinTemp(this.f4406d.f4437j);
        diveLog.entries.add(diveLogEntry);
        String uuid = UUID.randomUUID().toString();
        DiveLogItem buildDivelogItem = diveLogEntry.buildDivelogItem(diveLog.getStartTime() + "", uuid);
        CommandCard command = CommandCard.builder().setCommand(CommandCard.ADD_ITEM);
        DiveLogBuildHelper.m8553a(diveLog, command.setStartTime(diveLog.getStartTime() + "").setCreateTime(new Date()).setJson(buildDivelogItem));
        if (diveLog.getStatus() == 0) {
            diveLog.setStatus(1);
        }
        diveLog.save();
    }

    /* compiled from: DiveLogManager.java */
    /* renamed from: com.navatics.app.framework.divelog.a$a */
    /* loaded from: classes.dex */
    public class C1791a implements RxTimer.InterfaceC2159a {

        /* renamed from: a */
        DiveLog f4428a;

        /* renamed from: b */
        RxTimer f4429b;

        /* renamed from: c */
        C1792b f4430c;

        /* renamed from: d */
        double f4431d;

        /* renamed from: e */
        double f4432e;

        /* renamed from: f */
        Disposable f4433f;

        /* renamed from: g */
        int f4434g;

        /* renamed from: h */
        int f4435h;

        /* renamed from: i */
        int f4436i;

        /* renamed from: j */
        int f4437j;

        /* renamed from: k */
        int f4438k;

        public static /* synthetic */ ObservableSource lambda$3USww6RTe_u8WNpKzzR9MVMcq_g(C1791a c1791a, NvLocation nvLocation) {
            return c1791a.m8446a(nvLocation);
        }

        public static /* synthetic */ void lambda$SAKbpJprSl1rBGCS9pgcJ9x3t6k(C1791a c1791a, Address address) {
            c1791a.m8448a(address);
        }

        public static /* synthetic */ void lambda$xz560S7yUwEs13WXUD5BagcKaJM(C1791a c1791a, Throwable th) {
            c1791a.m8445a(th);
        }

        C1791a() {
            DiveLogManager.this = r1;
        }

        /* renamed from: a */
        void m8449a() {
            this.f4428a = DiveLogManager.this.m8461f();
            if (this.f4428a == null) {
                DiveLogManager.f4404b.mo1504b((Object) "newDiveLog error");
                return;
            }
            DiveLogBuildHelper.m8553a(this.f4428a, CommandCard.builder(new Date()).setCommand(CommandCard.CREATE).setJson(this.f4428a.buildBaseDiveLogInfo()).setVersion(1));
            this.f4433f = NvLocationManager.m8005a().m7997b(4).m3078b(new Function() { // from class: com.navatics.app.framework.divelog.-$$Lambda$a$a$3USww6RTe_u8WNpKzzR9MVMcq_g
                @Override // io.reactivex.p096b.Function
                public final Object apply(Object obj) {
                    return DiveLogManager.C1791a.lambda$3USww6RTe_u8WNpKzzR9MVMcq_g(DiveLogManager.C1791a.this, (NvLocation) obj);
                }
            }).m3075b(Schedulers.m3217b()).m3107a(new Consumer() { // from class: com.navatics.app.framework.divelog.-$$Lambda$a$a$SAKbpJprSl1rBGCS9pgcJ9x3t6k
                @Override // io.reactivex.p096b.Consumer
                public final void accept(Object obj) {
                    DiveLogManager.C1791a.lambda$SAKbpJprSl1rBGCS9pgcJ9x3t6k(DiveLogManager.C1791a.this, (Address) obj);
                }
            }, new Consumer() { // from class: com.navatics.app.framework.divelog.-$$Lambda$a$a$xz560S7yUwEs13WXUD5BagcKaJM
                @Override // io.reactivex.p096b.Consumer
                public final void accept(Object obj) {
                    DiveLogManager.C1791a.lambda$xz560S7yUwEs13WXUD5BagcKaJM(DiveLogManager.C1791a.this, (Throwable) obj);
                }
            });
            this.f4430c = new C1792b(this.f4428a);
            this.f4430c.start();
            this.f4429b = RxTimer.m5859a(this, 1000L, true);
            this.f4429b.m5860a();
        }

        /* renamed from: a */
        public /* synthetic */ ObservableSource m8446a(NvLocation nvLocation) throws Exception {
            Location m8008a = nvLocation.m8008a();
            this.f4431d = m8008a.getLongitude();
            this.f4432e = m8008a.getLatitude();
            this.f4428a.setLongitude(String.valueOf(this.f4431d));
            this.f4428a.setLatitude(String.valueOf(this.f4432e));
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("longitude", Double.valueOf(this.f4431d));
            CommandCard filedName = CommandCard.builder().setCommand(CommandCard.UPDATE).setFiledName("longitude");
            CommandCard json = filedName.setStartTime(this.f4428a.getStartTime() + "").setCreateTime(new Date()).setJson(jsonObject.toString());
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("latitude", Double.valueOf(this.f4432e));
            CommandCard filedName2 = CommandCard.builder().setCommand(CommandCard.UPDATE).setFiledName("latitude");
            CommandCard json2 = filedName2.setStartTime(this.f4428a.getStartTime() + "").setCreateTime(new Date()).setJson(jsonObject2.toString());
            DiveLogBuildHelper.m8553a(this.f4428a, json);
            DiveLogBuildHelper.m8553a(this.f4428a, json2);
            return nvLocation.m8006b();
        }

        /* renamed from: a */
        public /* synthetic */ void m8448a(Address address) throws Exception {
            String str = null;
            if (TextUtils.isEmpty(address.getCountryName())) {
                str = ((String) null) + address.getCountryName();
            }
            if (TextUtils.isEmpty(address.getLocality())) {
                str = str + ", " + address.getLocality();
            }
            this.f4428a.setPlace(str);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("place", str);
            DiveLogBuildHelper.m8553a(this.f4428a, CommandCard.builder().setCommand(CommandCard.UPDATE).setFiledName("place").setStartTime(this.f4428a.getStartTime() + "").setCreateTime(new Date()).setJson(jsonObject.toString()));
        }

        /* renamed from: a */
        public /* synthetic */ void m8445a(Throwable th) throws Exception {
            try {
                this.f4428a.setPlace("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* renamed from: b */
        void m8444b() {
            this.f4429b.m5857b();
            this.f4430c.m5895c();
            this.f4433f.dispose();
            DiveLogManager.this.m8488a(System.currentTimeMillis(), this.f4428a, this.f4438k, this.f4434g);
        }

        /* renamed from: a */
        void m8447a(Uri uri) {
            try {
                this.f4430c.m5899a(2, uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override // com.navatics.robot.utils.RxTimer.InterfaceC2159a
        /* renamed from: a */
        public void mo5856a(RxTimer rxTimer) {
            try {
                this.f4430c.m5900a(1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: DiveLogManager.java */
    /* renamed from: com.navatics.app.framework.divelog.a$b */
    /* loaded from: classes.dex */
    public class C1792b extends CargoThread {

        /* renamed from: a */
        DiveLog f4440a;

        C1792b(DiveLog diveLog) {
            DiveLogManager.this = r1;
            this.f4440a = diveLog;
        }

        @Override // com.navatics.robot.utils.CargoThread
        /* renamed from: a */
        protected void mo5898a(CargoMsg cargoMsg) throws Exception {
            if (cargoMsg.m5909a() == 1) {
                switch (cargoMsg.m5904b()) {
                    case 1:
                        DiveLogManager.this.m8484a(this.f4440a, (String) null);
                        return;
                    case 2:
                        DiveLogManager.this.m8484a(this.f4440a, cargoMsg.m5903c().toString());
                        return;
                    default:
                        C3044k c3044k = DiveLogManager.f4404b;
                        c3044k.mo1504b((Object) ("LogThread unknown cmd " + cargoMsg.m5904b()));
                        return;
                }
            }
        }

        @Override // com.navatics.robot.utils.CargoThread
        /* renamed from: a */
        protected void mo5901a() {
            this.f4440a.setStatus(2);
            WLog.m5850d(DiveLogManager.f4403a, "dive log actually release");
        }
    }
}
