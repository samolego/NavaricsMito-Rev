package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.event.C2586i;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

/* renamed from: com.tencent.wxop.stat.ap */
/* loaded from: classes2.dex */
class RunnableC2541ap implements Runnable {

    /* renamed from: a */
    private Context f7955a;

    /* renamed from: b */
    private Map<String, Integer> f7956b;

    /* renamed from: c */
    private StatSpecifyReportedInfo f7957c;

    public RunnableC2541ap(Context context, Map<String, Integer> map, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f7955a = null;
        this.f7956b = null;
        this.f7957c = null;
        this.f7955a = context;
        this.f7957c = statSpecifyReportedInfo;
        if (map != null) {
            this.f7956b = map;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private NetworkMonitor m4928a(String str, int i) {
        StatLogger statLogger;
        StatLogger statLogger2;
        StatLogger statLogger3;
        int i2;
        StatLogger statLogger4;
        StatLogger statLogger5;
        NetworkMonitor networkMonitor = new NetworkMonitor();
        Socket socket = new Socket();
        try {
            try {
                networkMonitor.setDomain(str);
                networkMonitor.setPort(i);
                long currentTimeMillis = System.currentTimeMillis();
                InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
                socket.connect(inetSocketAddress, 30000);
                networkMonitor.setMillisecondsConsume(System.currentTimeMillis() - currentTimeMillis);
                networkMonitor.setRemoteIp(inetSocketAddress.getAddress().getHostAddress());
                socket.close();
                try {
                    socket.close();
                } catch (Throwable th) {
                    statLogger5 = StatServiceImpl.f7905q;
                    statLogger5.m4878e(th);
                }
                i2 = 0;
                socket = socket;
            } catch (IOException e) {
                statLogger = StatServiceImpl.f7905q;
                statLogger.m4878e((Throwable) e);
                try {
                    socket.close();
                    statLogger3 = socket;
                } catch (Throwable th2) {
                    statLogger2 = StatServiceImpl.f7905q;
                    statLogger2.m4878e(th2);
                    statLogger3 = statLogger2;
                }
                i2 = -1;
                socket = statLogger3;
            }
            networkMonitor.setStatusCode(i2);
            return networkMonitor;
        } catch (Throwable th3) {
            try {
                socket.close();
            } catch (Throwable th4) {
                statLogger4 = StatServiceImpl.f7905q;
                statLogger4.m4878e(th4);
            }
            throw th3;
        }
    }

    /* renamed from: a */
    private Map<String, Integer> m4929a() {
        String str;
        StatLogger statLogger;
        HashMap hashMap = new HashMap();
        String m4982a = StatConfig.m4982a("__MTA_TEST_SPEED__", (String) null);
        if (m4982a != null && m4982a.trim().length() != 0) {
            for (String str2 : m4982a.split(";")) {
                String[] split = str2.split(",");
                if (split != null && split.length == 2 && (str = split[0]) != null && str.trim().length() != 0) {
                    try {
                        hashMap.put(str, Integer.valueOf(Integer.valueOf(split[1]).intValue()));
                    } catch (NumberFormatException e) {
                        statLogger = StatServiceImpl.f7905q;
                        statLogger.m4878e((Throwable) e);
                    }
                }
            }
        }
        return hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        StatLogger statLogger;
        StatLogger statLogger2;
        StatLogger statLogger3;
        String str;
        try {
            if (this.f7956b == null) {
                this.f7956b = m4929a();
            }
            if (this.f7956b != null && this.f7956b.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, Integer> entry : this.f7956b.entrySet()) {
                    String key = entry.getKey();
                    if (key != null && key.length() != 0) {
                        if (entry.getValue() == null) {
                            statLogger3 = StatServiceImpl.f7905q;
                            str = "port is null for " + key;
                            statLogger3.m4875w(str);
                        } else {
                            jSONArray.put(m4928a(entry.getKey(), entry.getValue().intValue()).toJSONObject());
                        }
                    }
                    statLogger3 = StatServiceImpl.f7905q;
                    str = "empty domain name.";
                    statLogger3.m4875w(str);
                }
                if (jSONArray.length() == 0) {
                    return;
                }
                C2586i c2586i = new C2586i(this.f7955a, StatServiceImpl.m4967a(this.f7955a, false, this.f7957c), this.f7957c);
                c2586i.m4765a(jSONArray.toString());
                new C2542aq(c2586i).m4927a();
                return;
            }
            statLogger2 = StatServiceImpl.f7905q;
            statLogger2.m4877i("empty domain list.");
        } catch (Throwable th) {
            statLogger = StatServiceImpl.f7905q;
            statLogger.m4878e(th);
        }
    }
}
