package com.navatics.app.framework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import android.support.p008v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.util.LongSparseArray;
import com.navatics.app.framework.divelog.SharedPreferences$OnSharedPreferenceChangeListenerC2239a;
import com.navatics.app.framework.firmware.SharedPreferences$OnSharedPreferenceChangeListenerC2291e;
import com.navatics.app.framework.network.p056a.C2349a;
import com.navatics.app.framework.network.p056a.C2350b;
import com.navatics.app.framework.network.service.ConnectionsService;
import com.navatics.app.framework.p050b.C2188l;
import com.navatics.app.framework.p050b.C2204z;
import com.navatics.app.framework.p054f.C2264c;
import com.navatics.app.framework.p054f.C2274j;
import com.navatics.app.framework.recevier.SystemKeyReceiver;
import com.navatics.app.framework.user.NvUser;
import com.navatics.app.framework.user.NvUserManager;
import com.navatics.app.framework.user.SSUsrInfo;
import com.navatics.nvtsshare.C2655c;
import com.navatics.p057cv.NavaticsCV;
import com.navatics.robot.protocol.C2730ae;
import com.navatics.robot.transport.C2831n;
import com.navatics.robot.transport.C2858u;
import com.navatics.robot.transport.C2861w;
import com.navatics.robot.transport.InterfaceC2818e;
import com.navatics.robot.transport.InterfaceC2833p;
import com.navatics.robot.transport.NvDeviceInfo;
import com.navatics.robot.transport.p063b.InterfaceC2803d;
import com.navatics.robot.transport.p064ss.C2854e;
import com.navatics.robot.utils.C2905n;
import com.navatics.xlog.AndroidSystem;
import com.navatics.xlog.WLog;
import com.navatics.xlog.Xlog;
import io.objectbox.BoxStore;
import io.reactivex.AbstractC3979j;
import io.reactivex.InterfaceC3981k;
import io.reactivex.InterfaceC3982l;
import io.reactivex.p093a.p095b.C3857a;
import io.reactivex.p096b.InterfaceC3868e;
import io.reactivex.p098d.C3875a;
import io.reactivex.p099e.C3880a;
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
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.mp4parser.C4693f;
import p000a.p001a.p002a.p003a.p004a.C0001b;

/* compiled from: Navatics.java */
/* renamed from: com.navatics.app.framework.p */
/* loaded from: classes.dex */
public class C2353p {

    /* renamed from: c */
    private static Context f4741c;

    /* renamed from: d */
    private static BoxStore f4742d;

    /* renamed from: e */
    private static boolean f4743e;

    /* renamed from: f */
    private static C2326g f4744f;

    /* renamed from: i */
    private static C2356a f4745i;

    /* renamed from: a */
    private static final Logger f4746a = Logger.m1561a(C2353p.class);

    /* renamed from: b */
    private static long f4747b = 1;

    /* renamed from: g */
    private static List f4748g = new ArrayList();

    /* renamed from: h */
    private static LongSparseArray f4749h = new LongSparseArray();

    /* renamed from: j */
    private static List f4750j = new CopyOnWriteArrayList();

    /* renamed from: k */
    private static C2204z f4751k = new C2204z();

    /* renamed from: l */
    private static SystemKeyReceiver f4752l = new SystemKeyReceiver();

    /* renamed from: m */
    private static BroadcastReceiver f4753m = new C23541();

    /* renamed from: lambda$pD-bAx6eBCQc2K9enPOYPx9lVy0 */
    public static /* synthetic */ void m13071lambda$pDbAx6eBCQc2K9enPOYPx9lVy0(InterfaceC2388z interfaceC2388z) {
        m7941c(interfaceC2388z);
    }

    /* renamed from: a */
    static /* synthetic */ void m7952a(InterfaceC2818e interfaceC2818e) {
        m7940c(interfaceC2818e);
    }

    /* renamed from: b */
    static /* synthetic */ void m7945b(InterfaceC2818e interfaceC2818e) {
        m7937d(interfaceC2818e);
    }

    /* renamed from: k */
    static /* synthetic */ Logger m7929k() {
        return f4746a;
    }

    /* renamed from: l */
    static /* synthetic */ C2356a m7928l() {
        return f4745i;
    }

    /* compiled from: Navatics.java */
    /* renamed from: com.navatics.app.framework.p$1 */
    /* loaded from: classes.dex */
    static class C23541 extends BroadcastReceiver {
        C23541() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("com.navatics.app.framework.action.START_FTPSERVER".equals(action)) {
                Intent intent2 = new Intent(context, ConnectionsService.class);
                if (intent.getExtras() != null) {
                    intent2.putExtras(intent.getExtras());
                }
                if (C2349a.m7978e(context)) {
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
                C2350b.m7976a(context, intent, 916);
            } else if ("com.navatics.app.framework.action.FTPSERVER_STOPPED".equals(action)) {
                C2350b.m7977a(context, 916);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Navatics.java */
    /* renamed from: com.navatics.app.framework.p$2 */
    /* loaded from: classes.dex */
    public static class C23552 implements InterfaceC3982l {
        C23552() {
        }

        public void subscribe(InterfaceC3981k interfaceC3981k) throws Exception {
            C2353p.m7943c();
            interfaceC3981k.onNext(true);
            interfaceC3981k.onComplete();
        }
    }

    /* renamed from: a */
    public static synchronized AbstractC3979j m7960a() {
        AbstractC3979j m3088a;
        synchronized (C2353p.class) {
            m3088a = AbstractC3979j.m3094a((InterfaceC3982l) new C23552()).m3072b(C3880a.m3214b()).m3088a(C3857a.m3247a());
        }
        return m3088a;
    }

    /* renamed from: b */
    public static synchronized C2188l m7948b() {
        C2188l m8569a;
        synchronized (C2353p.class) {
            m8569a = f4751k.m8569a();
        }
        return m8569a;
    }

    /* renamed from: a */
    public static void m7958a(Context context) {
        f4741c = context;
        f4742d = C2352o.m7962a().m3373a(context).m3376a();
    }

    /* renamed from: c */
    public static synchronized void m7943c() {
        synchronized (C2353p.class) {
            if (f4743e) {
                return;
            }
            C2274j.m8383a(new C2264c());
            C3875a.m3240a(new InterfaceC3868e() { // from class: com.navatics.app.framework.-$$Lambda$e27-Kr4VJxN1zC_AGmQwWE7CADQ
                @Override // io.reactivex.p096b.InterfaceC3868e
                /* renamed from: accept */
                public final void mo9497a(Object obj) {
                    ((Throwable) obj).printStackTrace();
                }
            });
            f4745i = new C2356a();
            m7927m();
            C2174ag.m8618a(f4741c);
            m7926n();
            C4693f.m519a(f4741c);
            NvUserManager.m7852a();
            C2175ah.m8594a();
            SharedPreferences$OnSharedPreferenceChangeListenerC2239a.m8490a();
            SharedPreferences$OnSharedPreferenceChangeListenerC2291e.m8299a();
            m7957a(f4741c, "libs");
            m7957a(f4741c, "libs-arm64");
            m7956a(f4741c, "Filter", "libs");
            m7956a(f4741c, "Filter-arm64", "libs-arm64");
            NavaticsCV.m6863a(f4741c);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.navatics.app.framework.action.START_FTPSERVER");
            intentFilter.addAction("com.navatics.app.framework.action.STOP_FTPSERVER");
            intentFilter.addAction("com.navatics.app.framework.action.FTPSERVER_STARTED");
            intentFilter.addAction("com.navatics.app.framework.action.FTPSERVER_STOPPED");
            f4741c.registerReceiver(f4753m, intentFilter);
            f4741c.registerReceiver(f4752l, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
            C2858u.m6012a(f4741c);
            C2858u.m6011a(new C2854e());
            C2858u.m6009a(f4745i);
            C2730ae.m6534a(f4741c);
            C2174ag.m8619a().m8614b();
            C2858u.m6006c();
            f4743e = true;
            f4751k.m8563b();
        }
    }

    /* renamed from: d */
    public static void m7939d() {
        f4751k.m8561c();
        f4741c.unregisterReceiver(f4753m);
        f4741c.unregisterReceiver(f4752l);
        NvUserManager.m7829b().m7816c();
        C2861w.m5997a();
    }

    /* renamed from: m */
    private static void m7927m() {
        C2655c.C2657b c2657b = new C2655c.C2657b();
        c2657b.m6602a(f4741c.getResources().getString(R.string.WX_APP_ID)).m6601b(f4741c.getResources().getString(R.string.com_twitterp_sdk_android_CONSUMER_KEY)).m6600c(f4741c.getResources().getString(R.string.com_twitter_sdk_android_CONSUMER_SECRET));
        C2655c.m6615a(f4741c, c2657b);
    }

    /* renamed from: n */
    private static void m7926n() {
        C0001b c0001b = new C0001b();
        c0001b.m12913c(C2174ag.m8619a().m8604i() + File.separator + "app.log");
        c0001b.m12919a(Level.WARN);
        c0001b.m12920a("org.apache", Level.ERROR);
        c0001b.m12921a("%d %-5p [%c{2}]-[%L] %m%n");
        c0001b.m12922a(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
        c0001b.m12915b(false);
        c0001b.m12918a(true);
        c0001b.m12912c(true);
        c0001b.m12916b("%d %-5p [%c{2}]-[%L] %m%n");
        c0001b.m12923a();
        m7925o();
    }

    /* renamed from: o */
    private static void m7925o() {
        String str = C2174ag.m8619a().m8604i() + File.separator + "binlog";
        Xlog.open(true, 1, 0, str + File.separator + "cache", str, "navatics", "");
        Xlog.setConsoleLogOpen(false);
        WLog.setSystemInterface(new AndroidSystem());
        WLog.setLogImp(new Xlog());
    }

    /* renamed from: e */
    public static Context m7936e() {
        return f4741c;
    }

    /* renamed from: f */
    public static BoxStore m7934f() {
        return f4742d;
    }

    /* renamed from: g */
    public static List m7933g() {
        return f4748g;
    }

    /* renamed from: a */
    public static void m7953a(final InterfaceC2388z interfaceC2388z) {
        if (interfaceC2388z != null) {
            f4750j.add(interfaceC2388z);
            if (interfaceC2388z instanceof AbstractC2210d) {
                ((AbstractC2210d) interfaceC2388z).m6324a(new InterfaceC2803d() { // from class: com.navatics.app.framework.-$$Lambda$p$pD-bAx6eBCQc2K9enPOYPx9lVy0
                    @Override // com.navatics.robot.transport.p063b.InterfaceC2803d
                    public final void run() {
                        C2353p.m13071lambda$pDbAx6eBCQc2K9enPOYPx9lVy0(interfaceC2388z);
                    }
                });
            }
            C2326g c2326g = f4744f;
            if (c2326g != null) {
                interfaceC2388z.mo7503a(null, c2326g);
            }
        }
    }

    /* renamed from: c */
    private static /* synthetic */ void m7941c(InterfaceC2388z interfaceC2388z) throws Exception {
        m7946b(interfaceC2388z);
    }

    /* renamed from: b */
    public static void m7946b(InterfaceC2388z interfaceC2388z) {
        f4750j.remove(interfaceC2388z);
    }

    /* renamed from: c */
    private static void m7942c(C2326g c2326g) {
        for (InterfaceC2388z interfaceC2388z : f4750j) {
            interfaceC2388z.mo7665a(c2326g);
        }
    }

    /* renamed from: d */
    private static void m7938d(C2326g c2326g) {
        for (InterfaceC2388z interfaceC2388z : f4750j) {
            interfaceC2388z.mo7501b(c2326g);
        }
    }

    /* renamed from: a */
    private static void m7954a(C2326g c2326g, C2326g c2326g2) {
        for (InterfaceC2388z interfaceC2388z : f4750j) {
            interfaceC2388z.mo7503a(c2326g, c2326g2);
        }
    }

    /* renamed from: a */
    public static C2326g m7959a(long j) {
        return (C2326g) f4749h.get(j);
    }

    /* renamed from: a */
    public static C2326g m7949a(String str) {
        for (C2326g c2326g : f4748g) {
            if (c2326g.m8105g().getSerialNumber().equals(str)) {
                return c2326g;
            }
        }
        return null;
    }

    /* renamed from: b */
    public static AbstractC2362s m7944b(String str) {
        AbstractC2362s m8133a;
        for (C2326g c2326g : f4748g) {
            if (c2326g.m8121c() && (m8133a = c2326g.m8133a(str)) != null && m8133a.m7876j()) {
                return m8133a;
            }
        }
        return null;
    }

    /* renamed from: h */
    public static C2326g m7932h() {
        C2326g c2326g = f4744f;
        if (c2326g == null || !c2326g.m8110e()) {
            return null;
        }
        return f4744f;
    }

    /* renamed from: i */
    public static AbstractC2362s m7931i() {
        Logger logger = f4746a;
        StringBuilder sb = new StringBuilder();
        sb.append("currentActiveConnection 1, sCurrentGndSta is ");
        sb.append(f4744f == null ? "null" : " not null");
        logger.mo1508a((Object) sb.toString());
        C2326g c2326g = f4744f;
        if (c2326g != null && c2326g.m8110e() && f4744f.m8121c()) {
            AbstractC2362s m8099m = f4744f.m8099m();
            Logger logger2 = f4746a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("currentActiveConnection 2, ");
            sb2.append(m8099m != null ? Boolean.valueOf(m8099m.m7876j()) : "connection null");
            logger2.mo1508a((Object) sb2.toString());
            if (m8099m == null || !m8099m.m7876j()) {
                return null;
            }
            return m8099m;
        }
        return null;
    }

    /* renamed from: j */
    public static void m7930j() {
        C2858u.m6004e();
        for (C2326g c2326g : f4748g) {
            if (c2326g.m8103i() == 0) {
                m7955a(c2326g);
            }
        }
    }

    /* renamed from: e */
    private static synchronized void m7935e(C2326g c2326g) {
        synchronized (C2353p.class) {
            if (f4744f == c2326g) {
                return;
            }
            C2326g c2326g2 = f4744f;
            if (c2326g2 != null) {
                c2326g2.m8098n();
            }
            f4744f = c2326g;
            f4744f.m8097o();
            m7954a(c2326g2, f4744f);
        }
    }

    /* renamed from: c */
    private static void m7940c(InterfaceC2818e interfaceC2818e) {
        C2326g c2326g = new C2326g(interfaceC2818e);
        long j = f4747b;
        f4747b = 1 + j;
        c2326g.m8144a(j);
        f4748g.add(c2326g);
        f4749h.put(interfaceC2818e.mo6189a(), c2326g);
        Logger logger = f4746a;
        logger.mo1497c((Object) ("add remote, id = " + interfaceC2818e.mo6189a()));
        m7942c(c2326g);
        if (f4744f == null) {
            m7935e(c2326g);
        }
        m7955a(c2326g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m7955a(C2326g c2326g) {
        NvUser user = NvUserManager.m7829b().getUser();
        if (user == null) {
            f4746a.mo1508a((Object) "doGroundStationAuthentication, no active user now");
            return;
        }
        NvDeviceInfo m8105g = c2326g.m8105g();
        f4746a.mo1508a((Object) "doGroundStationAuthentication remote plugin detected.");
        f4746a.mo1508a((Object) m8105g.toString());
        if (user.getSsUsrInfo() == null) {
            f4746a.mo1496d("user not bind to sensethink account");
            return;
        }
        SSUsrInfo target = user.getSsUsrInfo().getTarget();
        if (target == null) {
            f4746a.mo1496d("user not bind to sensethink account or db is corrupt.");
        } else if (C2905n.m5850a((CharSequence) target.uuid)) {
            f4746a.mo1496d("user sensethink uuid is null");
        } else {
            c2326g.m8139a(NvUserManager.m7829b().getUser());
            HashMap hashMap = new HashMap();
            hashMap.put("uuid", target.uuid);
            c2326g.m8132a(hashMap);
        }
    }

    /* renamed from: d */
    private static void m7937d(InterfaceC2818e interfaceC2818e) {
        if (interfaceC2818e == null) {
            return;
        }
        C2326g c2326g = (C2326g) f4749h.get(interfaceC2818e.mo6189a());
        if (c2326g == null) {
            Logger logger = f4746a;
            logger.mo1496d("handlerGNDSTADisconnected can't find sta with id " + interfaceC2818e.mo6189a());
            return;
        }
        f4749h.remove(interfaceC2818e.mo6189a());
        f4748g.remove(c2326g);
        if (f4744f == c2326g) {
            f4744f = null;
        }
        m7938d(c2326g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static void m7947b(C2326g c2326g) {
        for (InterfaceC2388z interfaceC2388z : f4750j) {
            interfaceC2388z.mo7664c(c2326g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Navatics.java */
    /* renamed from: com.navatics.app.framework.p$a */
    /* loaded from: classes.dex */
    public static class C2356a implements InterfaceC2833p {
        C2356a() {
        }

        /* renamed from: a */
        public void mo6228a(C2831n c2831n) {
            int i = c2831n.f6562b;
            if (i != 16711689) {
                switch (i) {
                    case 65547:
                        C2353p.m7929k().mo1508a((Object) "GNDSTA_CONNECTED");
                        C2353p.m7952a((InterfaceC2818e) c2831n.f6566f);
                        return;
                    case 65548:
                        C2353p.m7929k().mo1508a((Object) "GNDSTA_DISCONNECTED");
                        C2353p.m7945b((InterfaceC2818e) c2831n.f6566f);
                        return;
                    default:
                        return;
                }
            }
            C2831n.m6238b(C2353p.m7928l(), C2858u.class, c2831n.f6562b, c2831n.f6566f).m6257a();
        }
    }

    /* renamed from: a */
    private static void m7951a(File file, File file2) throws IOException {
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
    private static void m7950a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ed A[ORIG_RETURN, RETURN] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void m7957a(android.content.Context r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.navatics.app.framework.C2353p.m7957a(android.content.Context, java.lang.String):void");
    }

    /* renamed from: a */
    private static void m7956a(Context context, String str, String str2) {
        File file = new File(Environment.getExternalStorageDirectory().getPath() + "/Navatics/Library/" + str);
        File dir = context.getDir(str2, 0);
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.getName().endsWith(".so")) {
                try {
                    m7951a(file2, new File(dir, file2.getName()));
                    Log.i("", "copy success : " + file2.getName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
