package com.navatics.robot.transport;

import com.navatics.robot.transport.p062a.IDimension;
import com.navatics.robot.utils.C2160n;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.navatics.robot.transport.l */
/* loaded from: classes.dex */
public class NvDimension {

    /* renamed from: a */
    public static final C2125c f6537a = new C2125c();

    /* renamed from: b */
    public static final C2124b f6538b = new C2124b();

    /* renamed from: c */
    public static final C2126d f6539c = new C2126d();

    /* renamed from: a */
    public static String m6275a(int i) {
        switch (i) {
            case 0:
                return "Metric";
            case 1:
                return "Imperial";
            default:
                throw new RuntimeException("Unknown dimension int : " + i);
        }
    }

    /* renamed from: a */
    public static IDimension m6272a(String str) {
        if (C2160n.m5855a((CharSequence) str)) {
            return null;
        }
        f6537a.getClass();
        if (str.equals("Storage")) {
            return f6537a;
        }
        f6538b.getClass();
        if (str.equals("Length")) {
            return f6538b;
        }
        f6539c.getClass();
        if (str.equals("Temperature")) {
            return f6539c;
        }
        return null;
    }

    /* renamed from: b */
    public static IDimension m6271b(int i) {
        switch (i) {
            case 1:
                return f6537a;
            case 2:
                return f6538b;
            case 3:
                return f6539c;
            default:
                return null;
        }
    }

    /* renamed from: a */
    public static NvUnit m6274a(int i, int i2) {
        switch (i2) {
            case 0:
                break;
            default:
                return null;
            case 1:
                switch (i) {
                    case 2:
                        return NvUnit.f6688f;
                    case 3:
                        return NvUnit.f6691i;
                }
        }
        switch (i) {
            case 2:
                return NvUnit.f6689g;
            case 3:
                return NvUnit.f6690h;
            default:
                return null;
        }
    }

    /* renamed from: a */
    public static boolean m6273a(NvUnit nvUnit, int i) {
        switch (i) {
            case 0:
                String m6003d = nvUnit.m6003d();
                return m6003d.equals("Meter") || m6003d.equals("Celsius");
            case 1:
                String m6003d2 = nvUnit.m6003d();
                return m6003d2.equals("Feet") || m6003d2.equals("Fahrenheit");
            default:
                return false;
        }
    }

    /* compiled from: NvDimension.java */
    /* renamed from: com.navatics.robot.transport.l$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractC2123a implements IDimension {

        /* renamed from: a */
        private Map<String, NvUnit> f6540a = new HashMap();

        /* renamed from: a */
        void m6270a(NvUnit nvUnit) {
            this.f6540a.put(nvUnit.m6003d(), nvUnit);
        }

        public String toString() {
            return "DimenBase{name=" + mo6267b() + '}';
        }

        @Override // com.navatics.robot.transport.p062a.IDimension
        /* renamed from: b */
        public boolean mo6269b(NvUnit nvUnit) {
            return nvUnit.m6004c() == mo6268a();
        }
    }

    /* compiled from: NvDimension.java */
    /* renamed from: com.navatics.robot.transport.l$c */
    /* loaded from: classes.dex */
    public static class C2125c extends AbstractC2123a {

        /* renamed from: a */
        public final String f6545a = "Storage";

        /* renamed from: b */
        public final int f6546b = 1;

        /* renamed from: c */
        public final NvUnit f6547c = NvUnit.f6683a;

        /* renamed from: d */
        public final NvUnit f6548d = NvUnit.f6684b;

        /* renamed from: e */
        public final NvUnit f6549e = NvUnit.f6685c;

        /* renamed from: f */
        public final NvUnit f6550f = NvUnit.f6686d;

        @Override // com.navatics.robot.transport.p062a.IDimension
        /* renamed from: a */
        public int mo6268a() {
            return 1;
        }

        @Override // com.navatics.robot.transport.p062a.IDimension
        /* renamed from: b */
        public String mo6267b() {
            return "Storage";
        }

        C2125c() {
            m6270a(this.f6547c);
            m6270a(this.f6548d);
            m6270a(this.f6549e);
            m6270a(this.f6550f);
        }
    }

    /* compiled from: NvDimension.java */
    /* renamed from: com.navatics.robot.transport.l$b */
    /* loaded from: classes.dex */
    public static class C2124b extends AbstractC2123a {

        /* renamed from: a */
        public final String f6541a = "Length";

        /* renamed from: b */
        public final int f6542b = 2;

        /* renamed from: c */
        public final NvUnit f6543c = NvUnit.f6689g;

        /* renamed from: d */
        public final NvUnit f6544d = NvUnit.f6688f;

        @Override // com.navatics.robot.transport.p062a.IDimension
        /* renamed from: a */
        public int mo6268a() {
            return 2;
        }

        @Override // com.navatics.robot.transport.p062a.IDimension
        /* renamed from: b */
        public String mo6267b() {
            return "Length";
        }

        C2124b() {
            m6270a(this.f6543c);
            m6270a(this.f6544d);
        }
    }

    /* compiled from: NvDimension.java */
    /* renamed from: com.navatics.robot.transport.l$d */
    /* loaded from: classes.dex */
    public static class C2126d extends AbstractC2123a {

        /* renamed from: a */
        public final String f6551a = "Temperature";

        /* renamed from: b */
        public final int f6552b = 3;

        /* renamed from: c */
        public final NvUnit f6553c = NvUnit.f6690h;

        /* renamed from: d */
        public final NvUnit f6554d = NvUnit.f6691i;

        @Override // com.navatics.robot.transport.p062a.IDimension
        /* renamed from: a */
        public int mo6268a() {
            return 3;
        }

        @Override // com.navatics.robot.transport.p062a.IDimension
        /* renamed from: b */
        public String mo6267b() {
            return "Temperature";
        }

        C2126d() {
            m6270a(this.f6553c);
            m6270a(this.f6554d);
        }
    }
}
