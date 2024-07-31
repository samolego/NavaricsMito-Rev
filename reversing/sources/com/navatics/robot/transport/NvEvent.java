package com.navatics.robot.transport;

import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.transport.n */
/* loaded from: classes.dex */
public class NvEvent {

    /* renamed from: g */
    private static final C3044k f6558g = C3044k.m1564a(NvEvent.class);

    /* renamed from: h */
    private static int f6559h = 0;

    /* renamed from: k */
    private static ObjectPool<NvEvent> f6560k;

    /* renamed from: a */
    public int f6561a;

    /* renamed from: b */
    public int f6562b;

    /* renamed from: c */
    public int f6563c;

    /* renamed from: d */
    public int f6564d;

    /* renamed from: e */
    public int f6565e;

    /* renamed from: f */
    public Object f6566f;

    /* renamed from: i */
    private Object f6567i;

    /* renamed from: j */
    private NvEventHandler f6568j;

    /* renamed from: a */
    public static int m6260a(int i) {
        return i >> 16;
    }

    /* renamed from: a */
    public static boolean m6259a(int i, int i2) {
        return ((i >> 16) & i2) == i2;
    }

    /* renamed from: f */
    private static void m6235f() {
    }

    /* renamed from: d */
    private static boolean m6237d() {
        try {
            Class.forName("java.lang.management.ManagementFactory");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: e */
    private static void m6236e() {
        if (f6560k == null) {
            synchronized (NvEvent.class) {
                if (f6560k == null) {
                    GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
                    genericObjectPoolConfig.m2117a(m6237d());
                    f6560k = new GenericObjectPool(new NvEventFactory(), genericObjectPoolConfig);
                }
            }
        }
    }

    public String toString() {
        return "NvEvent(" + m6243b(this.f6561a, this.f6562b) + ")";
    }

    /* renamed from: b */
    public static String m6244b(int i) {
        return m6243b(m6260a(i), i);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0059  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m6243b(int r3, int r4) {
        /*
            r0 = 255(0xff, float:3.57E-43)
            r1 = 0
            if (r3 == r0) goto L43
            switch(r3) {
                case 1: goto L19;
                case 2: goto La;
                default: goto L8;
            }
        L8:
            goto L59
        La:
            java.lang.String r3 = "I/O"
            switch(r4) {
                case 131073: goto L13;
                case 131074: goto L10;
                default: goto Lf;
            }
        Lf:
            goto L15
        L10:
            java.lang.String r1 = "NEW_MSG"
            goto L15
        L13:
            java.lang.String r1 = "NEW_DATA_FROM_TS"
        L15:
            r2 = r1
            r1 = r3
            r3 = r2
            goto L5a
        L19:
            java.lang.String r3 = "Connectivity"
            switch(r4) {
                case 65537: goto L3d;
                case 65538: goto L3a;
                case 65539: goto L37;
                case 65540: goto L34;
                case 65541: goto L31;
                case 65542: goto L1e;
                case 65543: goto L2e;
                case 65544: goto L2b;
                case 65545: goto L28;
                case 65546: goto L25;
                case 65547: goto L22;
                case 65548: goto L1f;
                default: goto L1e;
            }
        L1e:
            goto L3f
        L1f:
            java.lang.String r1 = "GNDSTA_DISCONNECTED"
            goto L3f
        L22:
            java.lang.String r1 = "GNDSTA_CONNECTED"
            goto L3f
        L25:
            java.lang.String r1 = "GNDSTA_AUTH_SUCCESS"
            goto L3f
        L28:
            java.lang.String r1 = "GNDSTA_BIND_SUCCESS"
            goto L3f
        L2b:
            java.lang.String r1 = "DEVICE_BIND_SUCCESS"
            goto L3f
        L2e:
            java.lang.String r1 = "DEVICE_AUTH_SUCCESS"
            goto L3f
        L31:
            java.lang.String r1 = "DEVICE_DISCONNECTED"
            goto L3f
        L34:
            java.lang.String r1 = "DEVICE_CONNECTED"
            goto L3f
        L37:
            java.lang.String r1 = "SEARCH_RESULT"
            goto L3f
        L3a:
            java.lang.String r1 = "SEARCH_STOPPED"
            goto L3f
        L3d:
            java.lang.String r1 = "SEARCH_STARTED"
        L3f:
            r2 = r1
            r1 = r3
            r3 = r2
            goto L5a
        L43:
            switch(r4) {
                case 16711681: goto L56;
                case 16711682: goto L53;
                case 16711683: goto L50;
                case 16711684: goto L4d;
                case 16711685: goto L4a;
                case 16711686: goto L47;
                default: goto L46;
            }
        L46:
            goto L59
        L47:
            java.lang.String r3 = "GNDSTA_BIND_ERR"
            goto L5a
        L4a:
            java.lang.String r3 = "GNDSTA_AUTH_ERR"
            goto L5a
        L4d:
            java.lang.String r3 = "GNDSTA_CONN_ERR"
            goto L5a
        L50:
            java.lang.String r3 = "DEVICE_BIND_ERR"
            goto L5a
        L53:
            java.lang.String r3 = "DEVICE_AUTH_ERR"
            goto L5a
        L56:
            java.lang.String r3 = "DEVICE_CONN_ERR"
            goto L5a
        L59:
            r3 = r1
        L5a:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            java.lang.String r0 = ";"
            r4.append(r0)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.navatics.robot.transport.NvEvent.m6243b(int, int):java.lang.String");
    }

    /* renamed from: a */
    public static NvEvent m6253a(NvEventHandler nvEventHandler, Object obj, int i, Object obj2) {
        return m6257a(nvEventHandler, obj, 255, i, obj2);
    }

    /* renamed from: b */
    public static NvEvent m6242b(NvEventHandler nvEventHandler, Object obj, int i, Object obj2) {
        return m6252a(nvEventHandler, obj, i, obj2, 0);
    }

    /* renamed from: a */
    public static NvEvent m6252a(NvEventHandler nvEventHandler, Object obj, int i, Object obj2, int i2) {
        return m6251a(nvEventHandler, obj, i, obj2, i2, 0);
    }

    /* renamed from: a */
    public static NvEvent m6251a(NvEventHandler nvEventHandler, Object obj, int i, Object obj2, int i2, int i3) {
        return m6255a(nvEventHandler, obj, 1, i, obj2, i2, i3);
    }

    /* renamed from: a */
    public static NvEvent m6249a(Object obj, int i, Object obj2) {
        return m6248a(obj, i, obj2, 0);
    }

    /* renamed from: c */
    public static NvEvent m6238c(NvEventHandler nvEventHandler, Object obj, int i, Object obj2) {
        return m6241b(nvEventHandler, obj, i, obj2, 0);
    }

    /* renamed from: a */
    public static NvEvent m6248a(Object obj, int i, Object obj2, int i2) {
        return m6247a(obj, i, obj2, i2, 0);
    }

    /* renamed from: b */
    public static NvEvent m6241b(NvEventHandler nvEventHandler, Object obj, int i, Object obj2, int i2) {
        return m6240b(nvEventHandler, obj, i, obj2, i2, 0);
    }

    /* renamed from: a */
    public static NvEvent m6247a(Object obj, int i, Object obj2, int i2, int i3) {
        return m6246a(obj, i, obj2, i2, i3, 0);
    }

    /* renamed from: b */
    public static NvEvent m6240b(NvEventHandler nvEventHandler, Object obj, int i, Object obj2, int i2, int i3) {
        return m6250a(nvEventHandler, obj, i, obj2, i2, i3, 0);
    }

    /* renamed from: a */
    public static NvEvent m6246a(Object obj, int i, Object obj2, int i2, int i3, int i4) {
        return m6254a(null, obj, 2, i, obj2, i2, i3, i4);
    }

    /* renamed from: a */
    public static NvEvent m6250a(NvEventHandler nvEventHandler, Object obj, int i, Object obj2, int i2, int i3, int i4) {
        return m6254a(nvEventHandler, obj, 2, i, obj2, i2, i3, i4);
    }

    /* renamed from: a */
    public static NvEvent m6257a(NvEventHandler nvEventHandler, Object obj, int i, int i2, Object obj2) {
        return m6256a(nvEventHandler, obj, i, i2, obj2, 0);
    }

    /* renamed from: a */
    public static NvEvent m6256a(NvEventHandler nvEventHandler, Object obj, int i, int i2, Object obj2, int i3) {
        return m6255a(nvEventHandler, obj, i, i2, obj2, i3, 0);
    }

    /* renamed from: a */
    public static NvEvent m6255a(NvEventHandler nvEventHandler, Object obj, int i, int i2, Object obj2, int i3, int i4) {
        return m6254a(nvEventHandler, obj, i, i2, obj2, i3, i4, 0);
    }

    /* renamed from: a */
    public static NvEvent m6254a(NvEventHandler nvEventHandler, Object obj, int i, int i2, Object obj2, int i3, int i4, int i5) {
        m6236e();
        try {
            NvEvent mo2030a = f6560k.mo2030a();
            mo2030a.f6568j = nvEventHandler;
            mo2030a.f6567i = obj;
            mo2030a.f6561a = i;
            mo2030a.f6562b = i2;
            mo2030a.f6566f = obj2;
            mo2030a.f6563c = i3;
            mo2030a.f6564d = i4;
            mo2030a.f6565e = i5;
            m6235f();
            return mo2030a;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static void m6258a(NvEvent nvEvent) {
        if (nvEvent == null) {
            return;
        }
        nvEvent.f6561a = 0;
        nvEvent.f6562b = 0;
        nvEvent.f6567i = null;
        nvEvent.f6568j = null;
        nvEvent.f6566f = 0;
        nvEvent.f6563c = 0;
        nvEvent.f6564d = 0;
    }

    /* renamed from: a */
    public void m6261a() {
        NvEventLoop.m6232a().mo6287a(this);
    }

    /* renamed from: b */
    public void m6245b() {
        try {
            f6560k.mo2028a(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public NvEventHandler m6239c() {
        return this.f6568j;
    }
}
