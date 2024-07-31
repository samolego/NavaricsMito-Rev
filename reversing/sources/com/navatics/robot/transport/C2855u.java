package com.navatics.robot.transport;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;

/* renamed from: com.navatics.robot.transport.u */
/* loaded from: classes.dex */
public class C2857u {

    /* renamed from: b */
    private static Context f6676b;

    /* renamed from: c */
    private static C2835s f6677c;

    /* renamed from: d */
    private static C2858a f6678d;

    /* renamed from: e */
    private static InterfaceC2833p f6679e;

    /* renamed from: a */
    private static final Logger f6680a = Logger.m1561a(C2857u.class);

    /* renamed from: f */
    private static List f6681f = new ArrayList();

    /* renamed from: g */
    private static HashMap f6682g = new HashMap();

    /* renamed from: a */
    static /* synthetic */ void m6010a(C2831n c2831n) {
        m6007b(c2831n);
    }

    /* renamed from: f */
    static /* synthetic */ Logger m6003f() {
        return f6680a;
    }

    /* compiled from: NvTransport.java */
    /* renamed from: com.navatics.robot.transport.u$a */
    /* loaded from: classes.dex */
    public static class C2858a implements InterfaceC2833p {
        C2858a() {
        }

        /* renamed from: a */
        public void mo6228a(C2831n c2831n) {
            int i = c2831n.f6561a;
            if (i == 1) {
                C2857u.m6010a(c2831n);
            } else if (i != 255) {
                Logger m6003f = C2857u.m6003f();
                m6003f.log((Object) ("unknown event type: " + c2831n.f6561a));
            }
        }
    }

    /* renamed from: a */
    public static void m6012a(Context context) {
        f6676b = context.getApplicationContext();
        f6678d = new C2858a();
        f6677c = C2835s.m6223a();
        f6677c.start();
    }

    /* renamed from: a */
    public static Context m6013a() {
        return f6676b;
    }

    /* renamed from: b */
    public static Collection m6008b() {
        return f6682g.values();
    }

    /* renamed from: a */
    public static void m6011a(InterfaceC2819f interfaceC2819f) {
        if (interfaceC2819f == null) {
            return;
        }
        f6682g.put(interfaceC2819f.mo6049a(), interfaceC2819f);
        interfaceC2819f.mo6048a(f6678d);
    }

    /* renamed from: c */
    public static void m6006c() {
        for (InterfaceC2819f interfaceC2819f : f6682g.values()) {
            interfaceC2819f.mo6043c();
        }
    }

    /* renamed from: a */
    public static void m6009a(InterfaceC2833p interfaceC2833p) {
        f6679e = interfaceC2833p;
    }

    /* renamed from: d */
    public static C2835s m6005d() {
        return f6677c;
    }

    /* renamed from: e */
    public static void m6004e() {
        for (InterfaceC2819f interfaceC2819f : f6682g.values()) {
            interfaceC2819f.mo6042d();
        }
    }

    /* renamed from: b */
    private static void m6007b(C2831n c2831n) {
        int i = c2831n.f6562b;
        if (i != 16711689) {
            switch (i) {
                case 65547:
                    f6680a.mo1508a((Object) "GNDSTA_CONNECTED");
                    InterfaceC2818e interfaceC2818e = (InterfaceC2818e) c2831n.f6566f;
                    f6681f.add(interfaceC2818e);
                    C2831n.m6238b(f6679e, C2857u.class, 65547, interfaceC2818e).m6257a();
                    return;
                case 65548:
                    f6680a.mo1508a((Object) "GNDSTA_DISCONNECTED");
                    InterfaceC2818e interfaceC2818e2 = (InterfaceC2818e) c2831n.f6566f;
                    f6681f.remove(interfaceC2818e2);
                    C2831n.m6238b(f6679e, C2857u.class, 65548, interfaceC2818e2).m6257a();
                    return;
                default:
                    return;
            }
        }
        C2831n.m6238b(f6679e, C2857u.class, c2831n.f6562b, c2831n.f6566f).m6257a();
    }
}
