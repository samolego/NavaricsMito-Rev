package com.tencent.wxop.stat;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.wxop.stat.common.C2562e;
import com.tencent.wxop.stat.common.C2569l;
import com.tencent.wxop.stat.common.C2575r;
import com.tencent.wxop.stat.common.StatConstants;
import com.tencent.wxop.stat.common.StatLogger;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.a */
/* loaded from: classes2.dex */
public class C2525a {

    /* renamed from: g */
    private static C2525a f7914g;

    /* renamed from: e */
    private C2562e f7919e;

    /* renamed from: h */
    private Context f7921h;

    /* renamed from: i */
    private StatLogger f7922i;

    /* renamed from: a */
    private List<String> f7915a = null;

    /* renamed from: b */
    private volatile int f7916b = 2;

    /* renamed from: c */
    private volatile String f7917c = "";

    /* renamed from: d */
    private volatile HttpHost f7918d = null;

    /* renamed from: f */
    private int f7920f = 0;

    private C2525a(Context context) {
        this.f7919e = null;
        this.f7921h = null;
        this.f7922i = null;
        this.f7921h = context.getApplicationContext();
        this.f7919e = new C2562e();
        C2592i.m4755a(context);
        this.f7922i = C2569l.m4837b();
        m4930l();
        m4933i();
        m4935g();
    }

    /* renamed from: a */
    public static C2525a m4944a(Context context) {
        if (f7914g == null) {
            synchronized (C2525a.class) {
                if (f7914g == null) {
                    f7914g = new C2525a(context);
                }
            }
        }
        return f7914g;
    }

    /* renamed from: b */
    private boolean m4940b(String str) {
        return Pattern.compile("(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})").matcher(str).matches();
    }

    /* renamed from: i */
    private void m4933i() {
        this.f7915a = new ArrayList(10);
        this.f7915a.add("117.135.169.101");
        this.f7915a.add("140.207.54.125");
        this.f7915a.add("180.153.8.53");
        this.f7915a.add("120.198.203.175");
        this.f7915a.add("14.17.43.18");
        this.f7915a.add("163.177.71.186");
        this.f7915a.add("111.30.131.31");
        this.f7915a.add("123.126.121.167");
        this.f7915a.add("123.151.152.111");
        this.f7915a.add("113.142.45.79");
        this.f7915a.add("123.138.162.90");
        this.f7915a.add("103.7.30.94");
    }

    /* renamed from: j */
    private String m4932j() {
        try {
            return !m4940b(StatConstants.MTA_SERVER_HOST) ? InetAddress.getByName(StatConstants.MTA_SERVER_HOST).getHostAddress() : "";
        } catch (Exception e) {
            this.f7922i.m4878e((Throwable) e);
            return "";
        }
    }

    /* renamed from: k */
    private void m4931k() {
        String m4932j = m4932j();
        if (StatConfig.isDebugEnable()) {
            StatLogger statLogger = this.f7922i;
            statLogger.m4877i("remoteIp ip is " + m4932j);
        }
        if (C2569l.m4832c(m4932j)) {
            if (!this.f7915a.contains(m4932j)) {
                String str = this.f7915a.get(this.f7920f);
                if (StatConfig.isDebugEnable()) {
                    StatLogger statLogger2 = this.f7922i;
                    statLogger2.m4875w(m4932j + " not in ip list, change to:" + str);
                }
                m4932j = str;
            }
            StatConfig.setStatReportUrl("http://" + m4932j + ":80/mstat/report");
        }
    }

    /* renamed from: l */
    private void m4930l() {
        this.f7916b = 0;
        this.f7918d = null;
        this.f7917c = null;
    }

    /* renamed from: a */
    public HttpHost m4945a() {
        return this.f7918d;
    }

    /* renamed from: a */
    public void m4942a(String str) {
        String[] split;
        if (StatConfig.isDebugEnable()) {
            this.f7922i.m4877i("updateIpList " + str);
        }
        try {
            if (C2569l.m4832c(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.length() > 0) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String string = jSONObject.getString(keys.next());
                        if (C2569l.m4832c(string)) {
                            for (String str2 : string.split(";")) {
                                if (C2569l.m4832c(str2)) {
                                    String[] split2 = str2.split(":");
                                    if (split2.length > 1) {
                                        String str3 = split2[0];
                                        if (m4940b(str3) && !this.f7915a.contains(str3)) {
                                            if (StatConfig.isDebugEnable()) {
                                                this.f7922i.m4877i("add new ip:" + str3);
                                            }
                                            this.f7915a.add(str3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.f7922i.m4878e((Throwable) e);
        }
        this.f7920f = new Random().nextInt(this.f7915a.size());
    }

    /* renamed from: b */
    public String m4941b() {
        return this.f7917c;
    }

    /* renamed from: c */
    public int m4939c() {
        return this.f7916b;
    }

    /* renamed from: d */
    public void m4938d() {
        this.f7920f = (this.f7920f + 1) % this.f7915a.size();
    }

    /* renamed from: e */
    public boolean m4937e() {
        return this.f7916b == 1;
    }

    /* renamed from: f */
    public boolean m4936f() {
        return this.f7916b != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public void m4935g() {
        if (!C2575r.m4781f(this.f7921h)) {
            if (StatConfig.isDebugEnable()) {
                this.f7922i.m4877i("NETWORK TYPE: network is close.");
            }
            m4930l();
            return;
        }
        if (StatConfig.f7864g) {
            m4931k();
        }
        this.f7917c = C2569l.m4820j(this.f7921h);
        if (StatConfig.isDebugEnable()) {
            StatLogger statLogger = this.f7922i;
            statLogger.m4877i("NETWORK name:" + this.f7917c);
        }
        if (C2569l.m4832c(this.f7917c)) {
            this.f7916b = "WIFI".equalsIgnoreCase(this.f7917c) ? 1 : 2;
            this.f7918d = C2569l.m4845a(this.f7921h);
        }
        if (StatServiceImpl.m4973a()) {
            StatServiceImpl.m4956d(this.f7921h);
        }
    }

    /* renamed from: h */
    public void m4934h() {
        this.f7921h.getApplicationContext().registerReceiver(new C2552b(this), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }
}
