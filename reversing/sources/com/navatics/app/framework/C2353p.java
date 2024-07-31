package com.navatics.app.framework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import android.support.p008v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.util.LongSparseArray;
import com.navatics.app.framework.divelog.DiveLogManager;
import com.navatics.app.framework.firmware.FirmwareManager;
import com.navatics.app.framework.network.p056a.C1838b;
import com.navatics.app.framework.network.p056a.ConnectionUtils;
import com.navatics.app.framework.network.service.ConnectionsService;
import com.navatics.app.framework.p050b.EventPipeline;
import com.navatics.app.framework.p050b.SystemStateMonitor;
import com.navatics.app.framework.p054f.AndroidServerSocketProvider;
import com.navatics.app.framework.p054f.NvLocalServerPlayer;
import com.navatics.app.framework.recevier.SystemKeyReceiver;
import com.navatics.app.framework.user.NvUser;
import com.navatics.app.framework.user.NvUserManager;
import com.navatics.app.framework.user.SSUsrInfo;
import com.navatics.nvtsshare.NvtsShare;
import com.navatics.p057cv.NavaticsCV;
import com.navatics.robot.protocol.NvProtocol;
import com.navatics.robot.transport.INvGroundStation;
import com.navatics.robot.transport.NvDeviceInfo;
import com.navatics.robot.transport.NvEvent;
import com.navatics.robot.transport.NvEventHandler;
import com.navatics.robot.transport.NvTransport;
import com.navatics.robot.transport.NvUsbManager;
import com.navatics.robot.transport.p063b.NvAction;
import com.navatics.robot.transport.p064ss.SensethinkNvTransport;
import com.navatics.robot.utils.C2160n;
import com.navatics.xlog.AndroidSystem;
import com.navatics.xlog.WLog;
import com.navatics.xlog.Xlog;
import io.objectbox.BoxStore;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.p093a.p095b.AndroidSchedulers;
import io.reactivex.p096b.Consumer;
import io.reactivex.p098d.RxJavaPlugins;
import io.reactivex.p099e.Schedulers;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.log4j.C3044k;
import org.apache.log4j.Level;
import org.mp4parser.Mp4parserContext;
import p000a.p001a.p002a.p003a.p004a.LogConfigurator;

/* renamed from: com.navatics.app.framework.p */
/* loaded from: classes.dex */
public class Navatics {

    /* renamed from: c */
    private static Context f4743c;

    /* renamed from: d */
    private static BoxStore f4744d;

    /* renamed from: e */
    private static boolean f4745e;

    /* renamed from: f */
    private static GroundStation f4746f;

    /* renamed from: i */
    private static C1841a f4749i;

    /* renamed from: a */
    private static final C3044k f4741a = C3044k.m1564a(Navatics.class);

    /* renamed from: b */
    private static long f4742b = 1;

    /* renamed from: g */
    private static List<GroundStation> f4747g = new ArrayList();

    /* renamed from: h */
    private static LongSparseArray<GroundStation> f4748h = new LongSparseArray<>();

    /* renamed from: j */
    private static List<NvRootHandler> f4750j = new CopyOnWriteArrayList();

    /* renamed from: k */
    private static SystemStateMonitor f4751k = new SystemStateMonitor();

    /* renamed from: l */
    private static SystemKeyReceiver f4752l = new SystemKeyReceiver();

    /* renamed from: m */
    private static BroadcastReceiver f4753m = new BroadcastReceiver() { // from class: com.navatics.app.framework.p.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("com.navatics.app.framework.action.START_FTPSERVER".equals(action)) {
                Intent intent2 = new Intent(context, ConnectionsService.class);
                if (intent.getExtras() != null) {
                    intent2.putExtras(intent.getExtras());
                }
                if (ConnectionUtils.m7977e(context)) {
                    return;
                }
                context.startService(intent2);
            } else if ("com.navatics.app.framework.action.STOP_FTPSERVER".equals(action)) {
                Intent intent3 = new Intent(context, ConnectionsService.class);
                if (intent.getExtras() != null) {
                    intent3.putExtras(intent.getExtras());
                }
                context.stopService(intent3);
            } else if ("com.navatics.app.framework.action.FTPSERVER_STARTED".equals(action)) {
                C1838b.m7975a(context, intent, 916);
            } else if ("com.navatics.app.framework.action.FTPSERVER_STOPPED".equals(action)) {
                C1838b.m7976a(context, 916);
            }
        }
    };

    /* renamed from: lambda$pD-bAx6eBCQc2K9enPOYPx9lVy0 */
    public static /* synthetic */ void m13071lambda$pDbAx6eBCQc2K9enPOYPx9lVy0(NvRootHandler nvRootHandler) {
        m7945b(nvRootHandler);
    }

    /* renamed from: a */
    public static synchronized Observable<Boolean> m7959a() {
        Observable<Boolean> m3091a;
        synchronized (Navatics.class) {
            m3091a = Observable.m3097a((ObservableOnSubscribe) new ObservableOnSubscribe<Boolean>() { // from class: com.navatics.app.framework.p.2
                @Override // io.reactivex.ObservableOnSubscribe
                public void subscribe(ObservableEmitter<Boolean> observableEmitter) throws Exception {
                    Navatics.m7942c();
                    observableEmitter.onNext(true);
                    observableEmitter.onComplete();
                }
            }).m3075b(Schedulers.m3217b()).m3091a(AndroidSchedulers.m3250a());
        }
        return m3091a;
    }

    /* renamed from: b */
    public static synchronized EventPipeline m7947b() {
        EventPipeline m8568a;
        synchronized (Navatics.class) {
            m8568a = f4751k.m8568a();
        }
        return m8568a;
    }

    /* renamed from: a */
    public static void m7957a(Context context) {
        f4743c = context;
        f4744d = MyObjectBox.m7961a().m3377a(context).m3380a();
    }

    /* renamed from: c */
    public static synchronized void m7942c() {
        synchronized (Navatics.class) {
            if (f4745e) {
                return;
            }
            NvLocalServerPlayer.m8382a(new AndroidServerSocketProvider());
            RxJavaPlugins.m3243a(new Consumer() { // from class: com.navatics.app.framework.-$$Lambda$e27-Kr4VJxN1zC_AGmQwWE7CADQ
                @Override // io.reactivex.p096b.Consumer
                public final void accept(Object obj) {
                    ((Throwable) obj).printStackTrace();
                }
            });
            f4749i = new C1841a();
            m7926m();
            Settings.m8617a(f4743c);
            m7925n();
            Mp4parserContext.m521a(f4743c);
            NvUserManager.m7851a();
            WeatherManager.m8593a();
            DiveLogManager.m8489a();
            FirmwareManager.m8298a();
            m7956a(f4743c, "libs");
            m7956a(f4743c, "libs-arm64");
            m7955a(f4743c, "Filter", "libs");
            m7955a(f4743c, "Filter-arm64", "libs-arm64");
            NavaticsCV.m6861a(f4743c);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.navatics.app.framework.action.START_FTPSERVER");
            intentFilter.addAction("com.navatics.app.framework.action.STOP_FTPSERVER");
            intentFilter.addAction("com.navatics.app.framework.action.FTPSERVER_STARTED");
            intentFilter.addAction("com.navatics.app.framework.action.FTPSERVER_STOPPED");
            f4743c.registerReceiver(f4753m, intentFilter);
            f4743c.registerReceiver(f4752l, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
            NvTransport.m6017a(f4743c);
            NvTransport.m6016a(new SensethinkNvTransport());
            NvTransport.m6014a(f4749i);
            NvProtocol.m6532a(f4743c);
            Settings.m8618a().m8613b();
            NvTransport.m6011c();
            f4745e = true;
            f4751k.m8562b();
        }
    }

    /* renamed from: d */
    public static void m7938d() {
        f4751k.m8560c();
        f4743c.unregisterReceiver(f4753m);
        f4743c.unregisterReceiver(f4752l);
        NvUserManager.m7828b().m7815c();
        NvUsbManager.m6002a();
    }

    /* renamed from: m */
    private static void m7926m() {
        NvtsShare.C2044b c2044b = new NvtsShare.C2044b();
        c2044b.m6600a(f4743c.getResources().getString(R.string.WX_APP_ID)).m6599b(f4743c.getResources().getString(R.string.com_twitterp_sdk_android_CONSUMER_KEY)).m6598c(f4743c.getResources().getString(R.string.com_twitter_sdk_android_CONSUMER_SECRET));
        NvtsShare.m6613a(f4743c, c2044b);
    }

    /* renamed from: n */
    private static void m7925n() {
        LogConfigurator logConfigurator = new LogConfigurator();
        logConfigurator.m12942c(Settings.m8618a().m8603i() + File.separator + "app.log");
        logConfigurator.m12948a(Level.WARN);
        logConfigurator.m12949a("org.apache", Level.ERROR);
        logConfigurator.m12950a("%d %-5p [%c{2}]-[%L] %m%n");
        logConfigurator.m12951a(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
        logConfigurator.m12944b(false);
        logConfigurator.m12947a(true);
        logConfigurator.m12941c(true);
        logConfigurator.m12945b("%d %-5p [%c{2}]-[%L] %m%n");
        logConfigurator.m12952a();
        m7924o();
    }

    /* renamed from: o */
    private static void m7924o() {
        String str = Settings.m8618a().m8603i() + File.separator + "binlog";
        Xlog.open(true, 1, 0, str + File.separator + "cache", str, "navatics", "");
        Xlog.setConsoleLogOpen(false);
        WLog.setSystemInterface(new AndroidSystem());
        WLog.setLogImp(new Xlog());
    }

    /* renamed from: e */
    public static Context m7935e() {
        return f4743c;
    }

    /* renamed from: f */
    public static BoxStore m7933f() {
        return f4744d;
    }

    /* renamed from: g */
    public static List<GroundStation> m7932g() {
        return f4747g;
    }

    /* renamed from: a */
    public static void m7952a(final NvRootHandler nvRootHandler) {
        if (nvRootHandler != null) {
            f4750j.add(nvRootHandler);
            if (nvRootHandler instanceof AbstractRootHandler) {
                ((AbstractRootHandler) nvRootHandler).m6324a(new NvAction() { // from class: com.navatics.app.framework.-$$Lambda$p$pD-bAx6eBCQc2K9enPOYPx9lVy0
                    @Override // com.navatics.robot.transport.p063b.NvAction
                    public final void run() {
                        Navatics.m13071lambda$pDbAx6eBCQc2K9enPOYPx9lVy0(NvRootHandler.this);
                    }
                });
            }
            GroundStation groundStation = f4746f;
            if (groundStation != null) {
                nvRootHandler.mo7502a(null, groundStation);
            }
        }
    }

    /* renamed from: b */
    public static void m7945b(NvRootHandler nvRootHandler) {
        f4750j.remove(nvRootHandler);
    }

    /* renamed from: c */
    private static void m7941c(GroundStation groundStation) {
        for (NvRootHandler nvRootHandler : f4750j) {
            nvRootHandler.mo7664a(groundStation);
        }
    }

    /* renamed from: d */
    private static void m7937d(GroundStation groundStation) {
        for (NvRootHandler nvRootHandler : f4750j) {
            nvRootHandler.mo7500b(groundStation);
        }
    }

    /* renamed from: a */
    private static void m7953a(GroundStation groundStation, GroundStation groundStation2) {
        for (NvRootHandler nvRootHandler : f4750j) {
            nvRootHandler.mo7502a(groundStation, groundStation2);
        }
    }

    /* renamed from: a */
    public static GroundStation m7958a(long j) {
        return f4748h.get(j);
    }

    /* renamed from: a */
    public static GroundStation m7948a(String str) {
        for (GroundStation groundStation : f4747g) {
            if (groundStation.m8104g().getSerialNumber().equals(str)) {
                return groundStation;
            }
        }
        return null;
    }

    /* renamed from: b */
    public static NvConnection m7943b(String str) {
        NvConnection m8132a;
        for (GroundStation groundStation : f4747g) {
            if (groundStation.m8120c() && (m8132a = groundStation.m8132a(str)) != null && m8132a.m7875j()) {
                return m8132a;
            }
        }
        return null;
    }

    /* renamed from: h */
    public static GroundStation m7931h() {
        GroundStation groundStation = f4746f;
        if (groundStation == null || !groundStation.m8109e()) {
            return null;
        }
        return f4746f;
    }

    /* renamed from: i */
    public static NvConnection m7930i() {
        C3044k c3044k = f4741a;
        StringBuilder sb = new StringBuilder();
        sb.append("currentActiveConnection 1, sCurrentGndSta is ");
        sb.append(f4746f == null ? "null" : " not null");
        c3044k.mo1511a((Object) sb.toString());
        GroundStation groundStation = f4746f;
        if (groundStation != null && groundStation.m8109e() && f4746f.m8120c()) {
            NvConnection m8098m = f4746f.m8098m();
            C3044k c3044k2 = f4741a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("currentActiveConnection 2, ");
            sb2.append(m8098m != null ? Boolean.valueOf(m8098m.m7875j()) : "connection null");
            c3044k2.mo1511a((Object) sb2.toString());
            if (m8098m == null || !m8098m.m7875j()) {
                return null;
            }
            return m8098m;
        }
        return null;
    }

    /* renamed from: j */
    public static void m7929j() {
        NvTransport.m6009e();
        for (GroundStation groundStation : f4747g) {
            if (groundStation.m8102i() == 0) {
                m7954a(groundStation);
            }
        }
    }

    /* renamed from: e */
    private static synchronized void m7934e(GroundStation groundStation) {
        synchronized (Navatics.class) {
            if (f4746f == groundStation) {
                return;
            }
            GroundStation groundStation2 = f4746f;
            if (groundStation2 != null) {
                groundStation2.m8097n();
            }
            f4746f = groundStation;
            f4746f.m8096o();
            m7953a(groundStation2, f4746f);
        }
    }

    /* renamed from: c */
    public static void m7939c(INvGroundStation iNvGroundStation) {
        GroundStation groundStation = new GroundStation(iNvGroundStation);
        long j = f4742b;
        f4742b = 1 + j;
        groundStation.m8143a(j);
        f4747g.add(groundStation);
        f4748h.put(iNvGroundStation.mo6194a(), groundStation);
        C3044k c3044k = f4741a;
        c3044k.mo1500c((Object) ("add remote, id = " + iNvGroundStation.mo6194a()));
        m7941c(groundStation);
        if (f4746f == null) {
            m7934e(groundStation);
        }
        m7954a(groundStation);
    }

    /* renamed from: a */
    public static void m7954a(GroundStation groundStation) {
        NvUser m7806d = NvUserManager.m7828b().m7806d();
        if (m7806d == null) {
            f4741a.mo1511a((Object) "doGroundStationAuthentication, no active user now");
            return;
        }
        NvDeviceInfo m8104g = groundStation.m8104g();
        f4741a.mo1511a((Object) "doGroundStationAuthentication remote plugin detected.");
        f4741a.mo1511a((Object) m8104g.toString());
        if (m7806d.getSsUsrInfo() == null) {
            f4741a.mo1499d("user not bind to sensethink account");
            return;
        }
        SSUsrInfo target = m7806d.getSsUsrInfo().getTarget();
        if (target == null) {
            f4741a.mo1499d("user not bind to sensethink account or db is corrupt.");
        } else if (C2160n.m5855a((CharSequence) target.uuid)) {
            f4741a.mo1499d("user sensethink uuid is null");
        } else {
            groundStation.m8138a(NvUserManager.m7828b().m7806d());
            HashMap hashMap = new HashMap();
            hashMap.put("uuid", target.uuid);
            groundStation.m8131a(hashMap);
        }
    }

    /* renamed from: d */
    public static void m7936d(INvGroundStation iNvGroundStation) {
        if (iNvGroundStation == null) {
            return;
        }
        GroundStation groundStation = f4748h.get(iNvGroundStation.mo6194a());
        if (groundStation == null) {
            C3044k c3044k = f4741a;
            c3044k.mo1499d("handlerGNDSTADisconnected can't find sta with id " + iNvGroundStation.mo6194a());
            return;
        }
        f4748h.remove(iNvGroundStation.mo6194a());
        f4747g.remove(groundStation);
        if (f4746f == groundStation) {
            f4746f = null;
        }
        m7937d(groundStation);
    }

    /* renamed from: b */
    public static void m7946b(GroundStation groundStation) {
        for (NvRootHandler nvRootHandler : f4750j) {
            nvRootHandler.mo7663c(groundStation);
        }
    }

    /* compiled from: Navatics.java */
    /* renamed from: com.navatics.app.framework.p$a */
    /* loaded from: classes.dex */
    public static class C1841a implements NvEventHandler {
        C1841a() {
        }

        @Override // com.navatics.robot.transport.NvEventHandler
        /* renamed from: a */
        public void mo6007a(NvEvent nvEvent) {
            int i = nvEvent.f6562b;
            if (i != 16711689) {
                switch (i) {
                    case 65547:
                        Navatics.f4741a.mo1511a((Object) "GNDSTA_CONNECTED");
                        Navatics.m7939c((INvGroundStation) nvEvent.f6566f);
                        return;
                    case 65548:
                        Navatics.f4741a.mo1511a((Object) "GNDSTA_DISCONNECTED");
                        Navatics.m7936d((INvGroundStation) nvEvent.f6566f);
                        return;
                    default:
                        return;
                }
            }
            NvEvent.m6242b(Navatics.f4749i, NvTransport.class, nvEvent.f6562b, nvEvent.f6566f).m6261a();
        }
    }

    /* renamed from: a */
    private static void m7950a(File file, File file2) throws IOException {
        FileChannel fileChannel;
        FileChannel channel;
        if (!file2.exists()) {
            file2.createNewFile();
        }
        FileChannel fileChannel2 = null;
        try {
            channel = new FileInputStream(file).getChannel();
            try {
                fileChannel = new FileOutputStream(file2).getChannel();
            } catch (Throwable th) {
                fileChannel2 = channel;
                th = th;
                fileChannel = null;
            }
        } catch (Throwable th2) {
            th = th2;
            fileChannel = null;
        }
        try {
            fileChannel.transferFrom(channel, 0L, channel.size());
            if (channel != null) {
                channel.close();
            }
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (Throwable th3) {
            fileChannel2 = channel;
            th = th3;
            if (fileChannel2 != null) {
                fileChannel2.close();
            }
            if (fileChannel != null) {
                fileChannel.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    private static void m7949a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x00ed A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0035  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void m7956a(android.content.Context r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.navatics.app.framework.Navatics.m7956a(android.content.Context, java.lang.String):void");
    }

    /* renamed from: a */
    private static void m7955a(Context context, String str, String str2) {
        File file = new File(Environment.getExternalStorageDirectory().getPath() + "/Navatics/Library/" + str);
        File dir = context.getDir(str2, 0);
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.getName().endsWith(".so")) {
                try {
                    m7950a(file2, new File(dir, file2.getName()));
                    Log.i("", "copy success : " + file2.getName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
