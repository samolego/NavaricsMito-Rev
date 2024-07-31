package com.navatics.robot.transport;

import org.apache.commons.pool2.InterfaceC4191f;
import org.apache.commons.pool2.impl.C4221m;
import org.apache.commons.pool2.impl.C4222n;
import org.apache.log4j.Logger;

/* renamed from: com.navatics.robot.transport.n */
/* loaded from: classes.dex */
public class C2831n {

    /* renamed from: g */
    private static final Logger f6558g = Logger.m1561a(C2831n.class);

    /* renamed from: h */
    private static int f6559h = 0;

    /* renamed from: k */
    private static InterfaceC4191f f6560k;

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
    private InterfaceC2833p f6568j;

    /* renamed from: a */
    public static int m6256a(int i) {
        return i >> 16;
    }

    /* renamed from: a */
    public static boolean m6255a(int i, int i2) {
        return ((i >> 16) & i2) == i2;
    }

    /* renamed from: f */
    private static void m6231f() {
    }

    /* renamed from: d */
    private static boolean m6233d() {
        try {
            Class.forName("java.lang.management.ManagementFactory");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: e */
    private static void m6232e() {
        if (f6560k == null) {
            synchronized (C2831n.class) {
                if (f6560k == null) {
                    C4222n c4222n = new C4222n();
                    c4222n.m2114a(m6233d());
                    f6560k = new C4221m(new C2832o(), c4222n);
                }
            }
        }
    }

    public String toString() {
        return "NvEvent(" + m6239b(this.f6561a, this.f6562b) + ")";
    }

    /* renamed from: b */
    public static String m6240b(int i) {
        return m6239b(m6256a(i), i);
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0059  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m6239b(int r3, int r4) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.navatics.robot.transport.C2831n.m6239b(int, int):java.lang.String");
    }

    /* renamed from: a */
    public static C2831n m6249a(InterfaceC2833p interfaceC2833p, Object obj, int i, Object obj2) {
        return m6253a(interfaceC2833p, obj, 255, i, obj2);
    }

    /* renamed from: b */
    public static C2831n m6238b(InterfaceC2833p interfaceC2833p, Object obj, int i, Object obj2) {
        return m6248a(interfaceC2833p, obj, i, obj2, 0);
    }

    /* renamed from: a */
    public static C2831n m6248a(InterfaceC2833p interfaceC2833p, Object obj, int i, Object obj2, int i2) {
        return m6247a(interfaceC2833p, obj, i, obj2, i2, 0);
    }

    /* renamed from: a */
    public static C2831n m6247a(InterfaceC2833p interfaceC2833p, Object obj, int i, Object obj2, int i2, int i3) {
        return m6251a(interfaceC2833p, obj, 1, i, obj2, i2, i3);
    }

    /* renamed from: a */
    public static C2831n m6245a(Object obj, int i, Object obj2) {
        return m6244a(obj, i, obj2, 0);
    }

    /* renamed from: c */
    public static C2831n m6234c(InterfaceC2833p interfaceC2833p, Object obj, int i, Object obj2) {
        return m6237b(interfaceC2833p, obj, i, obj2, 0);
    }

    /* renamed from: a */
    public static C2831n m6244a(Object obj, int i, Object obj2, int i2) {
        return m6243a(obj, i, obj2, i2, 0);
    }

    /* renamed from: b */
    public static C2831n m6237b(InterfaceC2833p interfaceC2833p, Object obj, int i, Object obj2, int i2) {
        return m6236b(interfaceC2833p, obj, i, obj2, i2, 0);
    }

    /* renamed from: a */
    public static C2831n m6243a(Object obj, int i, Object obj2, int i2, int i3) {
        return m6242a(obj, i, obj2, i2, i3, 0);
    }

    /* renamed from: b */
    public static C2831n m6236b(InterfaceC2833p interfaceC2833p, Object obj, int i, Object obj2, int i2, int i3) {
        return m6246a(interfaceC2833p, obj, i, obj2, i2, i3, 0);
    }

    /* renamed from: a */
    public static C2831n m6242a(Object obj, int i, Object obj2, int i2, int i3, int i4) {
        return m6250a(null, obj, 2, i, obj2, i2, i3, i4);
    }

    /* renamed from: a */
    public static C2831n m6246a(InterfaceC2833p interfaceC2833p, Object obj, int i, Object obj2, int i2, int i3, int i4) {
        return m6250a(interfaceC2833p, obj, 2, i, obj2, i2, i3, i4);
    }

    /* renamed from: a */
    public static C2831n m6253a(InterfaceC2833p interfaceC2833p, Object obj, int i, int i2, Object obj2) {
        return m6252a(interfaceC2833p, obj, i, i2, obj2, 0);
    }

    /* renamed from: a */
    public static C2831n m6252a(InterfaceC2833p interfaceC2833p, Object obj, int i, int i2, Object obj2, int i3) {
        return m6251a(interfaceC2833p, obj, i, i2, obj2, i3, 0);
    }

    /* renamed from: a */
    public static C2831n m6251a(InterfaceC2833p interfaceC2833p, Object obj, int i, int i2, Object obj2, int i3, int i4) {
        return m6250a(interfaceC2833p, obj, i, i2, obj2, i3, i4, 0);
    }

    /* renamed from: a */
    public static C2831n m6250a(InterfaceC2833p interfaceC2833p, Object obj, int i, int i2, Object obj2, int i3, int i4, int i5) {
        m6232e();
        try {
            C2831n c2831n = (C2831n) f6560k.mo2027a();
            c2831n.f6568j = interfaceC2833p;
            c2831n.f6567i = obj;
            c2831n.f6561a = i;
            c2831n.f6562b = i2;
            c2831n.f6566f = obj2;
            c2831n.f6563c = i3;
            c2831n.f6564d = i4;
            c2831n.f6565e = i5;
            m6231f();
            return c2831n;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static void m6254a(C2831n c2831n) {
        if (c2831n == null) {
            return;
        }
        c2831n.f6561a = 0;
        c2831n.f6562b = 0;
        c2831n.f6567i = null;
        c2831n.f6568j = null;
        c2831n.f6566f = 0;
        c2831n.f6563c = 0;
        c2831n.f6564d = 0;
    }

    /* renamed from: a */
    public void m6257a() {
        C2834q.m6227a().mo6287a(this);
    }

    /* renamed from: b */
    public void m6241b() {
        try {
            f6560k.mo2025a(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public InterfaceC2833p m6235c() {
        return this.f6568j;
    }
}
