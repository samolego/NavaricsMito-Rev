package com.navatics.robot.transport;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.transport.u */
/* loaded from: classes.dex */
public class NvTransport {

    /* renamed from: b */
    private static Context f6677b;

    /* renamed from: c */
    private static NvSelector f6678c;

    /* renamed from: d */
    private static C2142a f6679d;

    /* renamed from: e */
    private static NvEventHandler f6680e;

    /* renamed from: a */
    private static final C3044k f6676a = C3044k.m1564a(NvTransport.class);

    /* renamed from: f */
    private static List<INvGroundStation> f6681f = new ArrayList();

    /* renamed from: g */
    private static HashMap<TransportType, INvTransport> f6682g = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NvTransport.java */
    /* renamed from: com.navatics.robot.transport.u$a */
    /* loaded from: classes.dex */
    public static class C2142a implements NvEventHandler {
        C2142a() {
        }

        @Override // com.navatics.robot.transport.NvEventHandler
        /* renamed from: a */
        public void mo6007a(NvEvent nvEvent) {
            int i = nvEvent.f6561a;
            if (i == 1) {
                NvTransport.m6012b(nvEvent);
            } else if (i != 255) {
                C3044k c3044k = NvTransport.f6676a;
                c3044k.mo1504b((Object) ("unknown event type: " + nvEvent.f6561a));
            }
        }
    }

    /* renamed from: a */
    public static void m6017a(Context context) {
        f6677b = context.getApplicationContext();
        f6679d = new C2142a();
        f6678c = NvSelector.m6228a();
        f6678c.start();
    }

    /* renamed from: a */
    public static Context m6018a() {
        return f6677b;
    }

    /* renamed from: b */
    public static Collection<INvTransport> m6013b() {
        return f6682g.values();
    }

    /* renamed from: a */
    public static void m6016a(INvTransport iNvTransport) {
        if (iNvTransport == null) {
            return;
        }
        f6682g.put(iNvTransport.mo6054a(), iNvTransport);
        iNvTransport.mo6053a(f6679d);
    }

    /* renamed from: c */
    public static void m6011c() {
        for (INvTransport iNvTransport : f6682g.values()) {
            iNvTransport.mo6048c();
        }
    }

    /* renamed from: a */
    public static void m6014a(NvEventHandler nvEventHandler) {
        f6680e = nvEventHandler;
    }

    /* renamed from: d */
    public static NvSelector m6010d() {
        return f6678c;
    }

    /* renamed from: e */
    public static void m6009e() {
        for (INvTransport iNvTransport : f6682g.values()) {
            iNvTransport.mo6047d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m6012b(NvEvent nvEvent) {
        int i = nvEvent.f6562b;
        if (i != 16711689) {
            switch (i) {
                case 65547:
                    f6676a.mo1511a((Object) "GNDSTA_CONNECTED");
                    INvGroundStation iNvGroundStation = (INvGroundStation) nvEvent.f6566f;
                    f6681f.add(iNvGroundStation);
                    NvEvent.m6242b(f6680e, NvTransport.class, 65547, iNvGroundStation).m6261a();
                    return;
                case 65548:
                    f6676a.mo1511a((Object) "GNDSTA_DISCONNECTED");
                    INvGroundStation iNvGroundStation2 = (INvGroundStation) nvEvent.f6566f;
                    f6681f.remove(iNvGroundStation2);
                    NvEvent.m6242b(f6680e, NvTransport.class, 65548, iNvGroundStation2).m6261a();
                    return;
                default:
                    return;
            }
        }
        NvEvent.m6242b(f6680e, NvTransport.class, nvEvent.f6562b, nvEvent.f6566f).m6261a();
    }
}
