package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.AbstractC2403a;
import com.tencent.bugly.C2404b;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.info.C2419a;
import com.tencent.bugly.crashreport.common.info.C2420b;
import com.tencent.bugly.crashreport.common.strategy.C2422a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.spi.LocationInfo;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.a */
/* loaded from: classes2.dex */
public class C2450a {

    /* renamed from: a */
    protected HashMap<String, HashMap<String, byte[]>> f7512a = new HashMap<>();

    /* renamed from: b */
    protected String f7513b;

    /* renamed from: c */
    C2476i f7514c;

    /* renamed from: d */
    private HashMap<String, Object> f7515d;

    /* renamed from: a */
    public static InterfaceC2457ag m5280a(int i) {
        if (i == 1) {
            return new C2456af();
        }
        if (i == 3) {
            return new C2455ae();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2450a() {
        new HashMap();
        this.f7515d = new HashMap<>();
        this.f7513b = "GBK";
        this.f7514c = new C2476i();
    }

    /* renamed from: a */
    public void mo5264a(String str) {
        this.f7513b = str;
    }

    /* renamed from: a */
    public static C2467aq m5278a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        C2467aq c2467aq = new C2467aq();
        c2467aq.f7615a = userInfoBean.f7156e;
        c2467aq.f7619e = userInfoBean.f7161j;
        c2467aq.f7618d = userInfoBean.f7154c;
        c2467aq.f7617c = userInfoBean.f7155d;
        c2467aq.f7621g = C2419a.m5470b().m5453i();
        c2467aq.f7622h = userInfoBean.f7166o == 1;
        switch (userInfoBean.f7153b) {
            case 1:
                c2467aq.f7616b = (byte) 1;
                break;
            case 2:
                c2467aq.f7616b = (byte) 4;
                break;
            case 3:
                c2467aq.f7616b = (byte) 2;
                break;
            case 4:
                c2467aq.f7616b = (byte) 3;
                break;
            default:
                if (userInfoBean.f7153b < 10 || userInfoBean.f7153b >= 20) {
                    C2499x.m5083e("unknown uinfo type %d ", Integer.valueOf(userInfoBean.f7153b));
                    return null;
                }
                c2467aq.f7616b = (byte) userInfoBean.f7153b;
                break;
        }
        c2467aq.f7620f = new HashMap();
        if (userInfoBean.f7167p >= 0) {
            Map<String, String> map = c2467aq.f7620f;
            StringBuilder sb = new StringBuilder();
            sb.append(userInfoBean.f7167p);
            map.put("C01", sb.toString());
        }
        if (userInfoBean.f7168q >= 0) {
            Map<String, String> map2 = c2467aq.f7620f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(userInfoBean.f7168q);
            map2.put("C02", sb2.toString());
        }
        if (userInfoBean.f7169r != null && userInfoBean.f7169r.size() > 0) {
            for (Map.Entry<String, String> entry : userInfoBean.f7169r.entrySet()) {
                Map<String, String> map3 = c2467aq.f7620f;
                map3.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        if (userInfoBean.f7170s != null && userInfoBean.f7170s.size() > 0) {
            for (Map.Entry<String, String> entry2 : userInfoBean.f7170s.entrySet()) {
                Map<String, String> map4 = c2467aq.f7620f;
                map4.put("C04_" + entry2.getKey(), entry2.getValue());
            }
        }
        Map<String, String> map5 = c2467aq.f7620f;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(!userInfoBean.f7163l);
        map5.put("A36", sb3.toString());
        Map<String, String> map6 = c2467aq.f7620f;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(userInfoBean.f7158g);
        map6.put("F02", sb4.toString());
        Map<String, String> map7 = c2467aq.f7620f;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(userInfoBean.f7159h);
        map7.put("F03", sb5.toString());
        Map<String, String> map8 = c2467aq.f7620f;
        map8.put("F04", userInfoBean.f7161j);
        Map<String, String> map9 = c2467aq.f7620f;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(userInfoBean.f7160i);
        map9.put("F05", sb6.toString());
        Map<String, String> map10 = c2467aq.f7620f;
        map10.put("F06", userInfoBean.f7164m);
        Map<String, String> map11 = c2467aq.f7620f;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(userInfoBean.f7162k);
        map11.put("F10", sb7.toString());
        C2499x.m5085c("summary type %d vm:%d", Byte.valueOf(c2467aq.f7616b), Integer.valueOf(c2467aq.f7620f.size()));
        return c2467aq;
    }

    /* renamed from: a */
    public static String m5275a(ArrayList<String> arrayList) {
        int i;
        int i2;
        int i3;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            String str = arrayList.get(i4);
            if (str.equals("java.lang.Integer") || str.equals("int")) {
                str = "int32";
            } else if (str.equals("java.lang.Boolean") || str.equals("boolean")) {
                str = "bool";
            } else if (str.equals("java.lang.Byte") || str.equals("byte")) {
                str = "char";
            } else if (str.equals("java.lang.Double") || str.equals("double")) {
                str = "double";
            } else if (str.equals("java.lang.Float") || str.equals("float")) {
                str = "float";
            } else if (str.equals("java.lang.Long") || str.equals("long")) {
                str = "int64";
            } else if (str.equals("java.lang.Short") || str.equals("short")) {
                str = "short";
            } else if (str.equals("java.lang.Character")) {
                throw new IllegalArgumentException("can not support java.lang.Character");
            } else {
                if (str.equals("java.lang.String")) {
                    str = "string";
                } else if (str.equals("java.util.List")) {
                    str = "list";
                } else if (str.equals("java.util.Map")) {
                    str = "map";
                }
            }
            arrayList.set(i4, str);
        }
        Collections.reverse(arrayList);
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            String str2 = arrayList.get(i5);
            if (str2.equals("list")) {
                arrayList.set(i5 - 1, "<" + arrayList.get(i3));
                arrayList.set(0, arrayList.get(0) + ">");
            } else if (str2.equals("map")) {
                arrayList.set(i5 - 1, "<" + arrayList.get(i2) + ",");
                arrayList.set(0, arrayList.get(0) + ">");
            } else if (str2.equals("Array")) {
                arrayList.set(i5 - 1, "<" + arrayList.get(i));
                arrayList.set(0, arrayList.get(0) + ">");
            }
        }
        Collections.reverse(arrayList);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public <T> void mo5261a(String str, T t) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t == null) {
            throw new IllegalArgumentException("put value can not is null");
        }
        if (t instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        }
        C2478j c2478j = new C2478j();
        c2478j.m5208a(this.f7513b);
        c2478j.m5209a(t, 0);
        byte[] m5193a = C2480l.m5193a(c2478j.m5215a());
        HashMap<String, byte[]> hashMap = new HashMap<>(1);
        ArrayList<String> arrayList = new ArrayList<>(1);
        m5274a(arrayList, t);
        hashMap.put(m5275a(arrayList), m5193a);
        this.f7515d.remove(str);
        this.f7512a.put(str, hashMap);
    }

    /* renamed from: a */
    public static C2468ar m5273a(List<UserInfoBean> list, int i) {
        C2419a m5470b;
        if (list == null || list.size() == 0 || (m5470b = C2419a.m5470b()) == null) {
            return null;
        }
        m5470b.m5442t();
        C2468ar c2468ar = new C2468ar();
        c2468ar.f7626b = m5470b.f7258d;
        c2468ar.f7627c = m5470b.m5454h();
        ArrayList<C2467aq> arrayList = new ArrayList<>();
        for (UserInfoBean userInfoBean : list) {
            C2467aq m5278a = m5278a(userInfoBean);
            if (m5278a != null) {
                arrayList.add(m5278a);
            }
        }
        c2468ar.f7628d = arrayList;
        c2468ar.f7629e = new HashMap();
        Map<String, String> map = c2468ar.f7629e;
        map.put("A7", m5470b.f7260f);
        Map<String, String> map2 = c2468ar.f7629e;
        map2.put("A6", m5470b.m5443s());
        Map<String, String> map3 = c2468ar.f7629e;
        map3.put("A5", m5470b.m5444r());
        Map<String, String> map4 = c2468ar.f7629e;
        StringBuilder sb = new StringBuilder();
        sb.append(m5470b.m5446p());
        map4.put("A2", sb.toString());
        Map<String, String> map5 = c2468ar.f7629e;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(m5470b.m5446p());
        map5.put("A1", sb2.toString());
        Map<String, String> map6 = c2468ar.f7629e;
        map6.put("A24", m5470b.f7262h);
        Map<String, String> map7 = c2468ar.f7629e;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(m5470b.m5445q());
        map7.put("A17", sb3.toString());
        Map<String, String> map8 = c2468ar.f7629e;
        map8.put("A15", m5470b.m5439w());
        Map<String, String> map9 = c2468ar.f7629e;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(m5470b.m5438x());
        map9.put("A13", sb4.toString());
        Map<String, String> map10 = c2468ar.f7629e;
        map10.put("F08", m5470b.f7276v);
        Map<String, String> map11 = c2468ar.f7629e;
        map11.put("F09", m5470b.f7277w);
        Map<String, String> m5490G = m5470b.m5490G();
        if (m5490G != null && m5490G.size() > 0) {
            for (Map.Entry<String, String> entry : m5490G.entrySet()) {
                Map<String, String> map12 = c2468ar.f7629e;
                map12.put("C04_" + entry.getKey(), entry.getValue());
            }
        }
        switch (i) {
            case 1:
                c2468ar.f7625a = (byte) 1;
                break;
            case 2:
                c2468ar.f7625a = (byte) 2;
                break;
            default:
                C2499x.m5083e("unknown up type %d ", Integer.valueOf(i));
                return null;
        }
        return c2468ar;
    }

    /* renamed from: a */
    public static <T extends AbstractC2479k> T m5272a(byte[] bArr, Class<T> cls) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            T newInstance = cls.newInstance();
            C2476i c2476i = new C2476i(bArr);
            c2476i.m5230a("utf-8");
            newInstance.mo5199a(c2476i);
            return newInstance;
        } catch (Throwable th) {
            if (!C2499x.m5086b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    public static C2463am m5279a(Context context, int i, byte[] bArr) {
        C2419a m5470b = C2419a.m5470b();
        StrategyBean m5390c = C2422a.m5399a().m5390c();
        if (m5470b == null || m5390c == null) {
            C2499x.m5083e("Can not create request pkg for parameters is invalid.", new Object[0]);
            return null;
        }
        try {
            C2463am c2463am = new C2463am();
            synchronized (m5470b) {
                c2463am.f7563a = 1;
                c2463am.f7564b = m5470b.m5458f();
                c2463am.f7565c = m5470b.f7257c;
                c2463am.f7566d = m5470b.f7264j;
                c2463am.f7567e = m5470b.f7266l;
                m5470b.getClass();
                c2463am.f7568f = "2.8.6";
                c2463am.f7569g = i;
                c2463am.f7570h = bArr == null ? "".getBytes() : bArr;
                c2463am.f7571i = m5470b.f7261g;
                c2463am.f7572j = m5470b.f7262h;
                c2463am.f7573k = new HashMap();
                c2463am.f7574l = m5470b.m5460e();
                c2463am.f7575m = m5390c.f7301p;
                c2463am.f7577o = m5470b.m5454h();
                c2463am.f7578p = C2420b.m5429c(context);
                c2463am.f7579q = System.currentTimeMillis();
                c2463am.f7580r = m5470b.m5451k();
                c2463am.f7581s = m5470b.m5452j();
                c2463am.f7582t = m5470b.m5449m();
                c2463am.f7583u = m5470b.m5450l();
                c2463am.f7584v = m5470b.m5448n();
                c2463am.f7585w = c2463am.f7578p;
                m5470b.getClass();
                c2463am.f7576n = "com.tencent.bugly";
                Map<String, String> map = c2463am.f7573k;
                map.put("A26", m5470b.m5437y());
                Map<String, String> map2 = c2463am.f7573k;
                map2.put("A60", m5470b.m5436z());
                Map<String, String> map3 = c2463am.f7573k;
                map3.put("A61", m5470b.m5496A());
                Map<String, String> map4 = c2463am.f7573k;
                StringBuilder sb = new StringBuilder();
                sb.append(m5470b.m5479R());
                map4.put("A62", sb.toString());
                Map<String, String> map5 = c2463am.f7573k;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(m5470b.m5478S());
                map5.put("A63", sb2.toString());
                Map<String, String> map6 = c2463am.f7573k;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(m5470b.f7280z);
                map6.put("F11", sb3.toString());
                Map<String, String> map7 = c2463am.f7573k;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(m5470b.f7279y);
                map7.put("F12", sb4.toString());
                Map<String, String> map8 = c2463am.f7573k;
                map8.put("G1", m5470b.m5441u());
                Map<String, String> map9 = c2463am.f7573k;
                map9.put("A64", m5470b.m5477T());
                if (m5470b.f7205B) {
                    Map<String, String> map10 = c2463am.f7573k;
                    map10.put("G2", m5470b.m5485L());
                    Map<String, String> map11 = c2463am.f7573k;
                    map11.put("G3", m5470b.m5484M());
                    Map<String, String> map12 = c2463am.f7573k;
                    map12.put("G4", m5470b.m5483N());
                    Map<String, String> map13 = c2463am.f7573k;
                    map13.put("G5", m5470b.m5482O());
                    Map<String, String> map14 = c2463am.f7573k;
                    map14.put("G6", m5470b.m5481P());
                    Map<String, String> map15 = c2463am.f7573k;
                    map15.put("G7", Long.toString(m5470b.m5480Q()));
                }
                Map<String, String> map16 = c2463am.f7573k;
                map16.put("D3", m5470b.f7265k);
                if (C2404b.f7145b != null) {
                    for (AbstractC2403a abstractC2403a : C2404b.f7145b) {
                        if (abstractC2403a.versionKey != null && abstractC2403a.version != null) {
                            c2463am.f7573k.put(abstractC2403a.versionKey, abstractC2403a.version);
                        }
                    }
                }
                c2463am.f7573k.put("G15", C2503z.m5025b("G15", ""));
                c2463am.f7573k.put("D4", C2503z.m5025b("D4", "0"));
            }
            C2492u m5135a = C2492u.m5135a();
            if (m5135a != null && !m5135a.f7712a && bArr != null) {
                c2463am.f7570h = C2503z.m5035a(c2463am.f7570h, 2, 1, m5390c.f7306u);
                if (c2463am.f7570h == null) {
                    C2499x.m5083e("reqPkg sbuffer error!", new Object[0]);
                    return null;
                }
            }
            Map<String, String> m5491F = m5470b.m5491F();
            if (m5491F != null) {
                for (Map.Entry<String, String> entry : m5491F.entrySet()) {
                    c2463am.f7573k.put(entry.getKey(), entry.getValue());
                }
            }
            return c2463am;
        } catch (Throwable th) {
            if (!C2499x.m5086b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    private void m5274a(ArrayList<String> arrayList, Object obj) {
        if (obj.getClass().isArray()) {
            if (!obj.getClass().getComponentType().toString().equals("byte")) {
                throw new IllegalArgumentException("only byte[] is supported");
            }
            if (Array.getLength(obj) > 0) {
                arrayList.add("java.util.List");
                m5274a(arrayList, Array.get(obj, 0));
                return;
            }
            arrayList.add("Array");
            arrayList.add(LocationInfo.f11272NA);
        } else if (obj instanceof Array) {
            throw new IllegalArgumentException("can not support Array, please use List");
        } else {
            if (obj instanceof List) {
                arrayList.add("java.util.List");
                List list = (List) obj;
                if (list.size() > 0) {
                    m5274a(arrayList, list.get(0));
                } else {
                    arrayList.add(LocationInfo.f11272NA);
                }
            } else if (obj instanceof Map) {
                arrayList.add("java.util.Map");
                Map map = (Map) obj;
                if (map.size() > 0) {
                    Object next = map.keySet().iterator().next();
                    Object obj2 = map.get(next);
                    arrayList.add(next.getClass().getName());
                    m5274a(arrayList, obj2);
                    return;
                }
                arrayList.add(LocationInfo.f11272NA);
                arrayList.add(LocationInfo.f11272NA);
            } else {
                arrayList.add(obj.getClass().getName());
            }
        }
    }

    /* renamed from: a */
    public byte[] mo5262a() {
        C2478j c2478j = new C2478j(0);
        c2478j.m5208a(this.f7513b);
        c2478j.m5205a((Map) this.f7512a, 0);
        return C2480l.m5193a(c2478j.m5215a());
    }

    /* renamed from: a */
    public void mo5260a(byte[] bArr) {
        this.f7514c.m5226a(bArr);
        this.f7514c.m5230a(this.f7513b);
        HashMap hashMap = new HashMap(1);
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("", new byte[0]);
        hashMap.put("", hashMap2);
        this.f7512a = this.f7514c.m5229a((Map) hashMap, 0, false);
    }

    /* renamed from: a */
    public static byte[] m5276a(Object obj) {
        try {
            C2471d c2471d = new C2471d();
            c2471d.mo5259b();
            c2471d.mo5264a("utf-8");
            c2471d.m5258b(1);
            c2471d.m5257b("RqdServer");
            c2471d.m5256c("sync");
            c2471d.mo5261a("detail", (String) obj);
            return c2471d.mo5262a();
        } catch (Throwable th) {
            if (C2499x.m5086b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static C2464an m5271a(byte[] bArr, boolean z) {
        if (bArr != null) {
            try {
                C2471d c2471d = new C2471d();
                c2471d.mo5259b();
                c2471d.mo5264a("utf-8");
                c2471d.mo5260a(bArr);
                Object b = c2471d.m5263b("detail", new C2464an());
                C2464an c2464an = C2464an.class.isInstance(b) ? (C2464an) C2464an.class.cast(b) : null;
                if (!z && c2464an != null && c2464an.f7591c != null && c2464an.f7591c.length > 0) {
                    C2499x.m5085c("resp buf %d", Integer.valueOf(c2464an.f7591c.length));
                    c2464an.f7591c = C2503z.m5021b(c2464an.f7591c, 2, 1, StrategyBean.f7289d);
                    if (c2464an.f7591c == null) {
                        C2499x.m5083e("resp sbuffer error!", new Object[0]);
                        return null;
                    }
                }
                return c2464an;
            } catch (Throwable th) {
                if (!C2499x.m5086b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public static byte[] m5277a(AbstractC2479k abstractC2479k) {
        try {
            C2478j c2478j = new C2478j();
            c2478j.m5208a("utf-8");
            abstractC2479k.mo5198a(c2478j);
            return c2478j.m5201b();
        } catch (Throwable th) {
            if (C2499x.m5086b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
