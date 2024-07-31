package com.navatics.robot.transport;

import com.navatics.xlog.WLog;
import java.io.IOException;
import java.util.Map;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.transport.t */
/* loaded from: classes.dex */
public abstract class NvSocket {

    /* renamed from: a */
    private static final C3044k f6664a = C3044k.m1564a(NvSocket.class);

    /* renamed from: b */
    private static final String f6665b = NvSocket.class.getSimpleName();

    /* renamed from: c */
    private static int f6666c = 0;

    /* renamed from: d */
    private int f6667d;

    /* renamed from: e */
    private NvDeviceInfo f6668e;

    /* renamed from: f */
    private NvChannel f6669f;

    /* renamed from: g */
    private NvVideoChannel f6670g;

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
    public abstract void mo6032a(Map<String, Object> map);

    /* renamed from: b */
    public abstract void mo6029b(Map<String, Object> map);

    /* renamed from: c */
    public abstract void mo6026c(Map<String, Object> map);

    public NvSocket(NvDeviceInfo nvDeviceInfo, boolean z) {
        this();
        this.f6668e = nvDeviceInfo;
        this.f6674k = z;
    }

    private NvSocket() {
        this.f6673j = false;
        this.f6674k = false;
        int i = f6666c;
        f6666c = i + 1;
        this.f6667d = i;
        String str = f6665b;
        WLog.m5844i(str, "new socket, id " + this.f6667d);
    }

    /* renamed from: a */
    public int m6035a() {
        return this.f6667d;
    }

    /* renamed from: b */
    public NvDeviceInfo m6030b() {
        return this.f6668e;
    }

    /* renamed from: a */
    public void m6034a(NvChannel nvChannel) {
        this.f6669f = nvChannel;
    }

    /* renamed from: a */
    public void m6033a(NvVideoChannel nvVideoChannel) {
        this.f6670g = nvVideoChannel;
    }

    /* renamed from: c */
    public NvChannel m6027c() {
        return this.f6669f;
    }

    /* renamed from: d */
    public NvVideoChannel m6025d() {
        return this.f6670g;
    }

    /* renamed from: e */
    public boolean m6024e() {
        return this.f6671h;
    }

    /* renamed from: a */
    public void m6031a(boolean z) {
        this.f6671h = z;
    }

    /* renamed from: b */
    public void m6028b(boolean z) {
        this.f6672i = z;
    }

    /* renamed from: f */
    public void mo6023f() {
        this.f6673j = true;
    }

    /* renamed from: g */
    public boolean m6022g() {
        return this.f6673j;
    }

    /* renamed from: h */
    public boolean m6021h() {
        return this.f6674k;
    }

    /* renamed from: i */
    public boolean m6020i() {
        return this.f6675l;
    }

    /* renamed from: j */
    public void mo6019j() throws IOException {
        this.f6675l = true;
    }
}
