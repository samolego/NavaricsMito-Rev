package com.navatics.robot.transport;

import com.navatics.xlog.WLog;
import java.io.IOException;
import java.util.Map;
import org.apache.log4j.Logger;

/* renamed from: com.navatics.robot.transport.t */
/* loaded from: classes.dex */
public abstract class AbstractC2856t {

    /* renamed from: a */
    private static final Logger f6664a = Logger.m1561a(AbstractC2856t.class);

    /* renamed from: b */
    private static final String f6665b = AbstractC2856t.class.getSimpleName();

    /* renamed from: c */
    private static int f6666c = 0;

    /* renamed from: d */
    private int f6667d;

    /* renamed from: e */
    private NvDeviceInfo f6668e;

    /* renamed from: f */
    private NvChannel f6669f;

    /* renamed from: g */
    private AbstractC2867y f6670g;

    /* renamed from: h */
    private boolean f6671h;

    /* renamed from: i */
    private boolean f6672i;

    /* renamed from: j */
    private boolean f6673j;

    /* renamed from: k */
    private boolean f6674k;

    /* renamed from: l */
    private boolean f6675l;

    /* renamed from: a */
    public abstract void mo6027a(Map map);

    /* renamed from: b */
    public abstract void mo6024b(Map map);

    /* renamed from: c */
    public abstract void mo6021c(Map map);

    public AbstractC2856t(NvDeviceInfo nvDeviceInfo, boolean z) {
        this();
        this.f6668e = nvDeviceInfo;
        this.f6674k = z;
    }

    private AbstractC2856t() {
        this.f6673j = false;
        this.f6674k = false;
        int i = f6666c;
        f6666c = i + 1;
        this.f6667d = i;
        String str = f6665b;
        WLog.m5839i(str, "new socket, id " + this.f6667d);
    }

    /* renamed from: a */
    public int m6030a() {
        return this.f6667d;
    }

    /* renamed from: b */
    public NvDeviceInfo m6025b() {
        return this.f6668e;
    }

    /* renamed from: a */
    public void m6029a(NvChannel nvChannel) {
        this.f6669f = nvChannel;
    }

    /* renamed from: a */
    public void m6028a(AbstractC2867y abstractC2867y) {
        this.f6670g = abstractC2867y;
    }

    /* renamed from: c */
    public NvChannel m6022c() {
        return this.f6669f;
    }

    /* renamed from: d */
    public AbstractC2867y m6020d() {
        return this.f6670g;
    }

    /* renamed from: e */
    public boolean m6019e() {
        return this.f6671h;
    }

    /* renamed from: a */
    public void m6026a(boolean z) {
        this.f6671h = z;
    }

    /* renamed from: b */
    public void m6023b(boolean z) {
        this.f6672i = z;
    }

    /* renamed from: f */
    public void mo6018f() {
        this.f6673j = true;
    }

    /* renamed from: g */
    public boolean m6017g() {
        return this.f6673j;
    }

    /* renamed from: h */
    public boolean m6016h() {
        return this.f6674k;
    }

    /* renamed from: i */
    public boolean m6015i() {
        return this.f6675l;
    }

    /* renamed from: j */
    public void mo6014j() throws IOException {
        this.f6675l = true;
    }
}
