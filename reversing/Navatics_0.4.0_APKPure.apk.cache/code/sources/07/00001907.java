package com.navatics.app.framework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.util.LongSparseArray;
import com.navatics.app.framework.divelog.SharedPreferencesOnSharedPreferenceChangeListenerC1669a;
import com.navatics.app.framework.firmware.SharedPreferencesOnSharedPreferenceChangeListenerC1696e;
import com.navatics.app.framework.network.p050a.ConnectionUtils;
import com.navatics.app.framework.network.p050a.NotificationUtils;
import com.navatics.app.framework.network.service.ConnectionsService;
import com.navatics.app.framework.p044b.EventPipeline;
import com.navatics.app.framework.p044b.SystemStateMonitor;
import com.navatics.app.framework.p048f.AndroidServerSocketProvider;
import com.navatics.app.framework.p048f.NvLocalServerPlayer;
import com.navatics.app.framework.recevier.SystemKeyReceiver;
import com.navatics.app.framework.user.NvUser;
import com.navatics.app.framework.user.NvUserManager;
import com.navatics.app.framework.user.SSUsrInfo;
import com.navatics.cv.NavaticsCV;
import com.navatics.nvtsshare.NvtsShare;
import com.navatics.robot.protocol.NvProtocol;
import com.navatics.robot.transport.INvGroundStation;
import com.navatics.robot.transport.NvDeviceInfo;
import com.navatics.robot.transport.NvEvent;
import com.navatics.robot.transport.NvEventHandler;
import com.navatics.robot.transport.NvTransport;
import com.navatics.robot.transport.NvUsbManager;
import com.navatics.robot.transport.p056b.NvAction;
import com.navatics.robot.transport.ss.SensethinkNvTransport;
import com.navatics.robot.utils.StringUtils;
import com.navatics.xlog.AndroidSystem;
import com.navatics.xlog.WLog;
import com.navatics.xlog.Xlog;
import io.objectbox.BoxStore;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.p082a.p084b.AndroidSchedulers;
import io.reactivex.p085b.Consumer;
import io.reactivex.p087d.RxJavaPlugins;
import io.reactivex.p088e.Schedulers;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.mp4parser.Mp4parserContext;
import p000a.p001a.p002a.p003a.p004a.LogConfigurator;

/* compiled from: Navatics.java */
/* renamed from: com.navatics.app.framework.p, reason: use source file name */
/* loaded from: classes.dex */
public class Navatics {

    /* renamed from: c */
    private static Context context;

    /* renamed from: d */
    private static BoxStore boxStore;

    /* renamed from: e */
    private static boolean f4767e;

    /* renamed from: f */
    private static GroundStation groundStation;

    /* renamed from: i */
    private static a f4771i;

    /* renamed from: a */
    private static final Logger f4763a = Logger.getLogger(Navatics.class);

    /* renamed from: b */
    private static long f4764b = 1;

    /* renamed from: g */
    private static List<GroundStation> groundStations = new ArrayList();

    /* renamed from: h */
    private static LongSparseArray<GroundStation> f4770h = new LongSparseArray<>();

    /* renamed from: j */
    private static List<NvRootHandler> rootHandlers = new CopyOnWriteArrayList();

    /* renamed from: k */
    private static SystemStateMonitor systemStateMonitor = new SystemStateMonitor();

    /* renamed from: l */
    private static SystemKeyReceiver systemKeyReceiver = new SystemKeyReceiver();

    /* renamed from: m */
    private static BroadcastReceiver f4775m = new BroadcastReceiver() { // from class: com.navatics.app.framework.p.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context2, Intent intent) {
            String action = intent.getAction();
            if ("com.navatics.app.framework.action.START_FTPSERVER".equals(action)) {
                Intent intent2 = new Intent(context2, (Class<?>) ConnectionsService.class);
                if (intent.getExtras() != null) {
                    intent2.putExtras(intent.getExtras());
                }
                if (ConnectionUtils.m4959e(context2)) {
                    return;
                }
                context2.startService(intent2);
                return;
            }
            if ("com.navatics.app.framework.action.STOP_FTPSERVER".equals(action)) {
                Intent intent3 = new Intent(context2, (Class<?>) ConnectionsService.class);
                if (intent.getExtras() != null) {
                    intent3.putExtras(intent.getExtras());
                }
                context2.stopService(intent3);
                return;
            }
            if ("com.navatics.app.framework.action.FTPSERVER_STARTED".equals(action)) {
                NotificationUtils.m4961a(context2, intent, 916);
            } else if ("com.navatics.app.framework.action.FTPSERVER_STOPPED".equals(action)) {
                NotificationUtils.m4960a(context2, 916);
            }
        }
    };

    /* renamed from: a */
    public static synchronized Observable<Boolean> m4979a() {
        Observable<Boolean> m9757a;
        synchronized (Navatics.class) {
            m9757a = Observable.create((ObservableOnSubscribe) new ObservableOnSubscribe<Boolean>() { // from class: com.navatics.app.framework.p.2
                @Override // io.reactivex.ObservableOnSubscribe
                public void subscribe(ObservableEmitter<Boolean> observableEmitter) throws Exception {
                    Navatics.init();
                    observableEmitter.onNext(true);
                    observableEmitter.onComplete();
                }
            }).m9762b(Schedulers.m9619b()).m9757a(AndroidSchedulers.m9582a());
        }
        return m9757a;
    }

    /* renamed from: b */
    public static synchronized EventPipeline m4989b() {
        EventPipeline m4450a;
        synchronized (Navatics.class) {
            m4450a = systemStateMonitor.m4450a();
        }
        return m4450a;
    }

    /* renamed from: a */
    public static void m4980a(Context context2) {
        context = context2;
        boxStore = MyObjectBox.m4975a().m9461a(context2).m9460a();
    }

    /* renamed from: c */
    public static synchronized void init() {
        synchronized (Navatics.class) {
            if (f4767e) {
                return;
            }
            NvLocalServerPlayer.m4611a(new AndroidServerSocketProvider());
            RxJavaPlugins.m9601a(new Consumer() { // from class: com.navatics.app.framework.-$$Lambda$e27-Kr4VJxN1zC_AGmQwWE7CADQ
                @Override // io.reactivex.p085b.Consumer
                public final void accept(Object obj) {
                    ((Throwable) obj).printStackTrace();
                }
            });
            f4771i = new a();
            m5010m();
            C1618ag.m4391a(context);
            m5011n();
            Mp4parserContext.m12296a(context);
            NvUserManager.setupInstance();
            WeatherManager.m4415a();
            SharedPreferencesOnSharedPreferenceChangeListenerC1669a.m4510a();
            SharedPreferencesOnSharedPreferenceChangeListenerC1696e.m4705a();
            m4981a(context, "libs");
            m4981a(context, "libs-arm64");
            m4982a(context, "Filter", "libs");
            m4982a(context, "Filter-arm64", "libs-arm64");
            NavaticsCV.loadLibraries(context);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.navatics.app.framework.action.START_FTPSERVER");
            intentFilter.addAction("com.navatics.app.framework.action.STOP_FTPSERVER");
            intentFilter.addAction("com.navatics.app.framework.action.FTPSERVER_STARTED");
            intentFilter.addAction("com.navatics.app.framework.action.FTPSERVER_STOPPED");
            context.registerReceiver(f4775m, intentFilter);
            context.registerReceiver(systemKeyReceiver, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
            NvTransport.m6838a(context);
            NvTransport.m6839a(new SensethinkNvTransport());
            NvTransport.m6841a(f4771i);
            NvProtocol.m6337a(context);
            C1618ag.m4390a().m4404b();
            NvTransport.m6844c();
            f4767e = true;
            systemStateMonitor.m4451b();
        }
    }

    /* renamed from: d */
    public static void m4998d() {
        systemStateMonitor.m4452c();
        context.unregisterReceiver(f4775m);
        context.unregisterReceiver(systemKeyReceiver);
        NvUserManager.getInstance().m5140c();
        NvUsbManager.m6854a();
    }

    /* renamed from: m */
    private static void m5010m() {
        NvtsShare.b bVar = new NvtsShare.b();
        bVar.m6260a(context.getResources().getString(R.string.WX_APP_ID)).m6261b(context.getResources().getString(R.string.com_twitterp_sdk_android_CONSUMER_KEY)).m6262c(context.getResources().getString(R.string.com_twitter_sdk_android_CONSUMER_SECRET));
        NvtsShare.m6247a(context, bVar);
    }

    /* renamed from: n */
    private static void m5011n() {
        LogConfigurator logConfigurator = new LogConfigurator();
        logConfigurator.m16c(C1618ag.m4390a().m4412i() + File.separator + "app.log");
        logConfigurator.m10a(Level.WARN);
        logConfigurator.m9a("org.apache", Level.ERROR);
        logConfigurator.m8a("%d %-5p [%c{2}]-[%L] %m%n");
        logConfigurator.m7a(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
        logConfigurator.m14b(false);
        logConfigurator.m11a(true);
        logConfigurator.m17c(true);
        logConfigurator.m13b("%d %-5p [%c{2}]-[%L] %m%n");
        logConfigurator.m6a();
        m5012o();
    }

    /* renamed from: o */
    private static void m5012o() {
        String str = C1618ag.m4390a().m4412i() + File.separator + "binlog";
        Xlog.open(true, 1, 0, str + File.separator + "cache", str, "navatics", "");
        Xlog.setConsoleLogOpen(false);
        WLog.setSystemInterface(new AndroidSystem());
        WLog.setLogImp(new Xlog());
    }

    /* renamed from: e */
    public static Context getContext() {
        return context;
    }

    /* renamed from: f */
    public static BoxStore m5003f() {
        return boxStore;
    }

    /* renamed from: g */
    public static List<GroundStation> m5004g() {
        return groundStations;
    }

    /* renamed from: a */
    public static void m4985a(final NvRootHandler nvRootHandler) {
        if (nvRootHandler != null) {
            rootHandlers.add(nvRootHandler);
            if (nvRootHandler instanceof AbstractRootHandler) {
                ((AbstractRootHandler) nvRootHandler).m6558a(new NvAction() { // from class: com.navatics.app.framework.-$$Lambda$p$pD-bAx6eBCQc2K9enPOYPx9lVy0
                    @Override // com.navatics.robot.transport.p056b.NvAction
                    public final void run() {
                        Navatics.m4992b(NvRootHandler.this);
                    }
                });
            }
            GroundStation groundStation2 = groundStation;
            if (groundStation2 != null) {
                nvRootHandler.mo3925a(null, groundStation2);
            }
        }
    }

    /* renamed from: b */
    public static void m4992b(NvRootHandler nvRootHandler) {
        rootHandlers.remove(nvRootHandler);
    }

    /* renamed from: c */
    private static void m4995c(GroundStation groundStation2) {
        Iterator<NvRootHandler> it = rootHandlers.iterator();
        while (it.hasNext()) {
            it.next().mo3924a(groundStation2);
        }
    }

    /* renamed from: d */
    private static void m4999d(GroundStation groundStation2) {
        Iterator<NvRootHandler> it = rootHandlers.iterator();
        while (it.hasNext()) {
            it.next().onGroundStationDisconnected(groundStation2);
        }
    }

    /* renamed from: a */
    private static void m4984a(GroundStation groundStation2, GroundStation groundStation3) {
        Iterator<NvRootHandler> it = rootHandlers.iterator();
        while (it.hasNext()) {
            it.next().mo3925a(groundStation2, groundStation3);
        }
    }

    /* renamed from: a */
    public static GroundStation m4977a(long j) {
        return f4770h.get(j);
    }

    /* renamed from: a */
    public static GroundStation getStationBySerialNumber(String serial) {
        for (GroundStation groundStation2 : groundStations) {
            if (groundStation2.getDeviceInfo().getSerialNumber().equals(serial)) {
                return groundStation2;
            }
        }
        return null;
    }

    /* renamed from: b */
    public static NvConnection m4990b(String str) {
        NvConnection m4859a;
        for (GroundStation groundStation2 : groundStations) {
            if (groundStation2.isControllerAuthed() && (m4859a = groundStation2.m4859a(str)) != null && m4859a.isAuthed()) {
                return m4859a;
            }
        }
        return null;
    }

    /* renamed from: h */
    public static GroundStation getGroundStation() {
        GroundStation groundStation2 = groundStation;
        if (groundStation2 == null || !groundStation2.isValid()) {
            return null;
        }
        return groundStation;
    }

    /* renamed from: i */
    public static NvConnection currentActiveConnection() {
        Logger logger = f4763a;
        StringBuilder sb = new StringBuilder();
        sb.append("currentActiveConnection 1, sCurrentGndSta is ");
        sb.append(groundStation == null ? "null" : " not null");
        logger.conditionalLog3((Object) sb.toString());
        GroundStation groundStation2 = groundStation;
        if (groundStation2 == null || !groundStation2.isValid() || !groundStation.isControllerAuthed()) {
            return null;
        }
        NvConnection connection = groundStation.getConnection();
        Logger logger2 = f4763a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("currentActiveConnection 2, ");
        sb2.append(connection != null ? Boolean.valueOf(connection.isAuthed()) : "connection null");
        logger2.conditionalLog3((Object) sb2.toString());
        if (connection == null || !connection.isAuthed()) {
            return null;
        }
        return connection;
    }

    /* renamed from: j */
    public static void authenticateAllGroundStations() {
        NvTransport.m6846e();
        for (GroundStation groundStation2 : groundStations) {
            if (groundStation2.getState() == 0) {
                doGroundStationAuthentication(groundStation2);
            }
        }
    }

    /* renamed from: e */
    private static synchronized void setGroundStation(GroundStation newGroundStation) {
        synchronized (Navatics.class) {
            if (groundStation == newGroundStation) {
                return;
            }
            GroundStation groundStation2 = groundStation;
            if (groundStation2 != null) {
                groundStation2.m4886n();
            }
            groundStation = newGroundStation;
            groundStation.m4887o();
            m4984a(groundStation2, groundStation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void setupGroundStation(INvGroundStation iNvGroundStation) {
        GroundStation groundStation2 = new GroundStation(iNvGroundStation);
        long j = f4764b;
        f4764b = 1 + j;
        groundStation2.m4861a(j);
        groundStations.add(groundStation2);
        f4770h.put(iNvGroundStation.getId(), groundStation2);
        f4763a.conditionalLog((Object) ("add remote, id = " + iNvGroundStation.getId()));
        m4995c(groundStation2);
        if (groundStation == null) {
            setGroundStation(groundStation2);
        }
        doGroundStationAuthentication(groundStation2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void doGroundStationAuthentication(GroundStation groundStation2) {
        NvUser user = NvUserManager.getInstance().getUser();
        if (user == null) {
            f4763a.conditionalLog3((Object) "doGroundStationAuthentication, no active user now");
            return;
        }
        NvDeviceInfo deviceInfo = groundStation2.getDeviceInfo();
        f4763a.conditionalLog3((Object) "doGroundStationAuthentication remote plugin detected.");
        f4763a.conditionalLog3((Object) deviceInfo.toString());
        if (user.getSsUsrInfo() == null) {
            f4763a.conditionalLog2("user not bind to sensethink account");
            return;
        }
        SSUsrInfo target = user.getSsUsrInfo().getTarget();
        if (target == null) {
            f4763a.conditionalLog2("user not bind to sensethink account or db is corrupt.");
            return;
        }
        if (StringUtils.isEmpty((CharSequence) target.uuid)) {
            f4763a.conditionalLog2("user sensethink uuid is null");
            return;
        }
        groundStation2.setUser(NvUserManager.getInstance().getUser());
        HashMap properties = new HashMap();
        properties.put("uuid", target.uuid);
        groundStation2.loginToController(properties);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static void m5000d(INvGroundStation iNvGroundStation) {
        if (iNvGroundStation == null) {
            return;
        }
        GroundStation groundStation2 = f4770h.get(iNvGroundStation.getId());
        if (groundStation2 == null) {
            f4763a.conditionalLog2("handlerGNDSTADisconnected can't find sta with id " + iNvGroundStation.getId());
            return;
        }
        f4770h.remove(iNvGroundStation.getId());
        groundStations.remove(groundStation2);
        if (groundStation == groundStation2) {
            groundStation = null;
        }
        m4999d(groundStation2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static void m4991b(GroundStation groundStation2) {
        Iterator<NvRootHandler> it = rootHandlers.iterator();
        while (it.hasNext()) {
            it.next().onNewGroundStation(groundStation2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Navatics.java */
    /* renamed from: com.navatics.app.framework.p$a */
    /* loaded from: classes.dex */
    public static class a implements NvEventHandler {
        a() {
        }

        @Override // com.navatics.robot.transport.NvEventHandler
        /* renamed from: a */
        public void handleEvent(NvEvent nvEvent) {
            int i = nvEvent.f6591b;
            if (i != 16711689) {
                switch (i) {
                    case 65547:
                        Navatics.f4763a.conditionalLog3((Object) "GNDSTA_CONNECTED");
                        Navatics.setupGroundStation((INvGroundStation) nvEvent.f6595f);
                        return;
                    case 65548:
                        Navatics.f4763a.conditionalLog3((Object) "GNDSTA_DISCONNECTED");
                        Navatics.m5000d((INvGroundStation) nvEvent.f6595f);
                        return;
                    default:
                        return;
                }
            }
            NvEvent.onEvent(Navatics.f4771i, NvTransport.class, nvEvent.f6591b, nvEvent.f6595f).m6658a();
        }
    }

    /* renamed from: a */
    private static void m4987a(File file, File file2) throws IOException {
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
    private static void m4988a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x00ed A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0035  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void m4981a(android.content.Context r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.navatics.app.framework.Navatics.m4981a(android.content.Context, java.lang.String):void");
    }

    /* renamed from: a */
    private static void m4982a(Context context2, String str, String str2) {
        File file = new File(Environment.getExternalStorageDirectory().getPath() + "/Navatics/Library/" + str);
        File dir = context2.getDir(str2, 0);
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.getName().endsWith(".so")) {
                try {
                    m4987a(file2, new File(dir, file2.getName()));
                    Log.i("", "copy success : " + file2.getName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}