package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.C2569l;
import com.tencent.wxop.stat.common.C2574q;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.event.AbstractC2582e;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.aq */
/* loaded from: classes2.dex */
public class C2542aq {

    /* renamed from: f */
    private static volatile long f7958f;

    /* renamed from: a */
    private AbstractC2582e f7959a;

    /* renamed from: b */
    private StatReportStrategy f7960b;

    /* renamed from: c */
    private boolean f7961c;

    /* renamed from: d */
    private Context f7962d;

    /* renamed from: e */
    private long f7963e = System.currentTimeMillis();

    public C2542aq(AbstractC2582e abstractC2582e) {
        this.f7960b = null;
        this.f7961c = false;
        this.f7962d = null;
        this.f7959a = abstractC2582e;
        this.f7960b = StatConfig.getStatSendStrategy();
        this.f7961c = abstractC2582e.m4767f();
        this.f7962d = abstractC2582e.m4768e();
    }

    /* renamed from: a */
    private void m4925a(InterfaceC2591h interfaceC2591h) {
        Context context;
        context = StatServiceImpl.f7908t;
        C2592i.m4751b(context).m4754a(this.f7959a, interfaceC2591h);
    }

    /* renamed from: b */
    private void m4924b() {
        StatLogger statLogger;
        StatLogger statLogger2;
        Context context;
        StatLogger statLogger3;
        StatLogger statLogger4;
        Context context2;
        if (this.f7959a.m4769d() != null && this.f7959a.m4769d().isSendImmediately()) {
            this.f7960b = StatReportStrategy.INSTANT;
        }
        if (StatConfig.f7867j) {
            context2 = StatServiceImpl.f7908t;
            if (C2525a.m4944a(context2).m4937e()) {
                this.f7960b = StatReportStrategy.INSTANT;
            }
        }
        if (StatConfig.isDebugEnable()) {
            statLogger4 = StatServiceImpl.f7905q;
            statLogger4.m4877i("strategy=" + this.f7960b.name());
        }
        switch (C2532ag.f7936a[this.f7960b.ordinal()]) {
            case 1:
                m4922c();
                return;
            case 2:
                C2546au.m4916a(this.f7962d).m4908a(this.f7959a, (InterfaceC2591h) null, this.f7961c, false);
                if (StatConfig.isDebugEnable()) {
                    statLogger2 = StatServiceImpl.f7905q;
                    statLogger2.m4877i("PERIOD currTime=" + this.f7963e + ",nextPeriodSendTs=" + StatServiceImpl.f7891c + ",difftime=" + (StatServiceImpl.f7891c - this.f7963e));
                }
                if (StatServiceImpl.f7891c == 0) {
                    StatServiceImpl.f7891c = C2574q.m4796a(this.f7962d, "last_period_ts", 0L);
                    if (this.f7963e > StatServiceImpl.f7891c) {
                        StatServiceImpl.m4954e(this.f7962d);
                    }
                    long sendPeriodMinutes = this.f7963e + (StatConfig.getSendPeriodMinutes() * 60 * 1000);
                    if (StatServiceImpl.f7891c > sendPeriodMinutes) {
                        StatServiceImpl.f7891c = sendPeriodMinutes;
                    }
                    C2576d.m4779a(this.f7962d).m4780a();
                }
                if (StatConfig.isDebugEnable()) {
                    statLogger = StatServiceImpl.f7905q;
                    statLogger.m4877i("PERIOD currTime=" + this.f7963e + ",nextPeriodSendTs=" + StatServiceImpl.f7891c + ",difftime=" + (StatServiceImpl.f7891c - this.f7963e));
                }
                if (this.f7963e > StatServiceImpl.f7891c) {
                    StatServiceImpl.m4954e(this.f7962d);
                    return;
                }
                return;
            case 3:
            case 4:
                C2546au.m4916a(this.f7962d).m4908a(this.f7959a, (InterfaceC2591h) null, this.f7961c, false);
                return;
            case 5:
                C2546au.m4916a(this.f7962d).m4908a(this.f7959a, (InterfaceC2591h) new C2543ar(this), this.f7961c, true);
                return;
            case 6:
                context = StatServiceImpl.f7908t;
                if (C2525a.m4944a(context).m4939c() == 1) {
                    m4922c();
                    return;
                } else {
                    C2546au.m4916a(this.f7962d).m4908a(this.f7959a, (InterfaceC2591h) null, this.f7961c, false);
                    return;
                }
            case 7:
                if (C2569l.m4828e(this.f7962d)) {
                    m4925a(new C2544as(this));
                    return;
                }
                return;
            default:
                statLogger3 = StatServiceImpl.f7905q;
                statLogger3.error("Invalid stat strategy:" + StatConfig.getStatSendStrategy());
                return;
        }
    }

    /* renamed from: c */
    private void m4922c() {
        if (C2546au.m4900b().f7970a <= 0 || !StatConfig.f7869l) {
            m4925a(new C2545at(this));
            return;
        }
        C2546au.m4900b().m4908a(this.f7959a, (InterfaceC2591h) null, this.f7961c, true);
        C2546au.m4900b().m4918a(-1);
    }

    /* renamed from: d */
    private boolean m4920d() {
        long j;
        Map map;
        Map map2;
        Map map3;
        StatLogger statLogger;
        Map map4;
        StatLogger statLogger2;
        long j2;
        if (StatConfig.f7865h > 0) {
            long j3 = this.f7963e;
            j = StatServiceImpl.f7896h;
            if (j3 > j) {
                map4 = StatServiceImpl.f7895g;
                map4.clear();
                long unused = StatServiceImpl.f7896h = this.f7963e + StatConfig.f7866i;
                if (StatConfig.isDebugEnable()) {
                    statLogger2 = StatServiceImpl.f7905q;
                    StringBuilder sb = new StringBuilder("clear methodsCalledLimitMap, nextLimitCallClearTime=");
                    j2 = StatServiceImpl.f7896h;
                    sb.append(j2);
                    statLogger2.m4877i(sb.toString());
                }
            }
            Integer valueOf = Integer.valueOf(this.f7959a.mo4764a().m4776a());
            map = StatServiceImpl.f7895g;
            Integer num = (Integer) map.get(valueOf);
            if (num == null) {
                map2 = StatServiceImpl.f7895g;
                map2.put(valueOf, 1);
                return false;
            }
            map3 = StatServiceImpl.f7895g;
            map3.put(valueOf, Integer.valueOf(num.intValue() + 1));
            if (num.intValue() > StatConfig.f7865h) {
                if (StatConfig.isDebugEnable()) {
                    statLogger = StatServiceImpl.f7905q;
                    statLogger.m4879e("event " + this.f7959a.m4766g() + " was discard, cause of called limit, current:" + num + ", limit:" + StatConfig.f7865h + ", period:" + StatConfig.f7866i + " ms");
                }
                return true;
            }
            return false;
        }
        return false;
    }

    /* renamed from: a */
    public void m4927a() {
        StatLogger statLogger;
        StatLogger statLogger2;
        if (m4920d()) {
            return;
        }
        if (StatConfig.f7870m > 0 && this.f7963e >= f7958f) {
            StatServiceImpl.flushDataToDB(this.f7962d);
            f7958f = this.f7963e + StatConfig.f7871n;
            if (StatConfig.isDebugEnable()) {
                statLogger2 = StatServiceImpl.f7905q;
                statLogger2.m4877i("nextFlushTime=" + f7958f);
            }
        }
        if (!C2525a.m4944a(this.f7962d).m4936f()) {
            C2546au.m4916a(this.f7962d).m4908a(this.f7959a, (InterfaceC2591h) null, this.f7961c, false);
            return;
        }
        if (StatConfig.isDebugEnable()) {
            statLogger = StatServiceImpl.f7905q;
            statLogger.m4877i("sendFailedCount=" + StatServiceImpl.f7889a);
        }
        if (!StatServiceImpl.m4973a()) {
            m4924b();
            return;
        }
        C2546au.m4916a(this.f7962d).m4908a(this.f7959a, (InterfaceC2591h) null, this.f7961c, false);
        if (this.f7963e - StatServiceImpl.f7890b > 1800000) {
            StatServiceImpl.m4956d(this.f7962d);
        }
    }
}
