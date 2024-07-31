package com.navatics.robot.transport;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;

/* compiled from: NvTransport.java */
/* renamed from: com.navatics.robot.transport.u, reason: use source file name */
/* loaded from: classes.dex */
public class NvTransport {

    /* renamed from: b */
    private static Context context;

    /* renamed from: c */
    private static NvSelector selector;

    /* renamed from: d */
    private static a f6709d;

    /* renamed from: e */
    private static NvEventHandler evtHandler;

    /* renamed from: a */
    private static final Logger logger = Logger.getLogger(NvTransport.class);

    /* renamed from: f */
    private static List<INvGroundStation> connectedGroundStations = new ArrayList();

    /* renamed from: g */
    private static HashMap<TransportType, INvTransport> f6712g = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NvTransport.java */
    /* renamed from: com.navatics.robot.transport.u$a */
    /* loaded from: classes.dex */
    public static class a implements NvEventHandler {
        a() {
        }

        @Override // com.navatics.robot.transport.NvEventHandler
        /* renamed from: a */
        public void handleEvent(NvEvent nvEvent) {
            int i = nvEvent.f6590a;
            if (i == 1) {
                NvTransport.handleEvent(nvEvent);
                return;
            }
            if (i != 255) {
                NvTransport.logger.log((Object) ("unknown event type: " + nvEvent.f6590a));
            }
        }
    }

    /* renamed from: a */
    public static void m6838a(Context context2) {
        context = context2.getApplicationContext();
        f6709d = new a();
        selector = NvSelector.m6666a();
        selector.start();
    }

    /* renamed from: a */
    public static Context getContext() {
        return context;
    }

    /* renamed from: b */
    public static Collection<INvTransport> m6842b() {
        return f6712g.values();
    }

    /* renamed from: a */
    public static void m6839a(INvTransport iNvTransport) {
        if (iNvTransport == null) {
            return;
        }
        f6712g.put(iNvTransport.mo6609a(), iNvTransport);
        iNvTransport.setEventHandler(f6709d);
    }

    /* renamed from: c */
    public static void m6844c() {
        Iterator<INvTransport> it = f6712g.values().iterator();
        while (it.hasNext()) {
            it.next().mo6612c();
        }
    }

    /* renamed from: a */
    public static void m6841a(NvEventHandler nvEventHandler) {
        evtHandler = nvEventHandler;
    }

    /* renamed from: d */
    public static NvSelector getSelector() {
        return selector;
    }

    /* renamed from: e */
    public static void m6846e() {
        Iterator<INvTransport> it = f6712g.values().iterator();
        while (it.hasNext()) {
            it.next().mo6613d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void handleEvent(NvEvent nvEvent) {
        int i = nvEvent.f6591b;
        if (i != 16711689) {
            switch (i) {
                case 65547:
                    logger.conditionalLog3((Object) "GNDSTA_CONNECTED");
                    INvGroundStation iNvGroundStation = (INvGroundStation) nvEvent.f6595f;
                    connectedGroundStations.add(iNvGroundStation);
                    NvEvent.onEvent(evtHandler, NvTransport.class, 65547, iNvGroundStation).m6658a();
                    return;
                case 65548:
                    logger.conditionalLog3((Object) "GNDSTA_DISCONNECTED");
                    INvGroundStation iNvGroundStation2 = (INvGroundStation) nvEvent.f6595f;
                    connectedGroundStations.remove(iNvGroundStation2);
                    NvEvent.onEvent(evtHandler, NvTransport.class, 65548, iNvGroundStation2).m6658a();
                    return;
                default:
                    return;
            }
        }
        NvEvent.onEvent(evtHandler, NvTransport.class, nvEvent.f6591b, nvEvent.f6595f).m6658a();
    }
}