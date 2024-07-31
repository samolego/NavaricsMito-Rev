package com.navatics.app.framework;

import com.navatics.robot.transport.NvDeviceInfo;
import com.navatics.robot.transport.NvError;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.app.framework.v */
/* loaded from: classes.dex */
public class NvDeviceEntry {

    /* renamed from: a */
    private static final C3044k f4850a = C3044k.m1564a(NvDeviceEntry.class);

    /* renamed from: b */
    private GroundStation f4851b;

    /* renamed from: c */
    private NvDeviceInfo f4852c;

    /* renamed from: d */
    private NvConnection f4853d;

    /* renamed from: e */
    private int f4854e = 1;

    /* renamed from: f */
    private long f4855f;

    /* renamed from: g */
    private int f4856g;

    /* renamed from: h */
    private NvError f4857h;

    /* renamed from: a */
    public static String m7756a(int i) {
        if (i != -1) {
            if (i != 254) {
                switch (i) {
                    case 1:
                        return "DEVICE_STATE_NOT_CONNECTED";
                    case 2:
                        return "DEVICE_STATE_CONNECTING";
                    case 3:
                        return "DEVICE_STATE_UNAUTHENTICATED";
                    case 4:
                        return "DEVICE_STATE_AUTHENTICATING";
                    case 5:
                        return "DEVICE_STATE_UNBOUND";
                    case 6:
                        return "DEVICE_STATE_BINDING";
                    case 7:
                        return "DEVICE_STATE_AUTHENTICATED";
                    default:
                        throw new RuntimeException("unknown state : " + i);
                }
            }
            return "DEVICE_STATE_DESTROYED";
        }
        return "DEVICE_STATE_ERROR";
    }

    public NvDeviceEntry(GroundStation groundStation, NvDeviceInfo nvDeviceInfo) {
        this.f4851b = groundStation;
        this.f4852c = nvDeviceInfo;
    }

    /* renamed from: a */
    public NvDeviceInfo m7757a() {
        return this.f4852c;
    }

    /* renamed from: b */
    public boolean m7752b() {
        return this.f4854e == 1;
    }

    /* renamed from: c */
    public boolean m7750c() {
        return this.f4854e == 2;
    }

    /* renamed from: d */
    public boolean m7749d() {
        return this.f4854e == 3;
    }

    /* renamed from: e */
    public boolean m7748e() {
        return this.f4854e == 4;
    }

    /* renamed from: f */
    public boolean m7747f() {
        return this.f4854e == 7;
    }

    /* renamed from: g */
    public boolean m7746g() {
        return this.f4854e == 6;
    }

    /* renamed from: h */
    public boolean m7745h() {
        return this.f4854e == 5;
    }

    /* renamed from: i */
    public boolean m7744i() {
        return this.f4854e == -1;
    }

    /* renamed from: j */
    public int m7743j() {
        return this.f4854e;
    }

    /* renamed from: b */
    private void m7751b(int i) {
        C3044k c3044k = f4850a;
        c3044k.mo1499d("from " + m7756a(this.f4854e) + " to " + m7756a(i));
        if (this.f4854e == 254) {
            throw new IllegalStateException("changing state from DEAD state");
        }
        this.f4854e = i;
        this.f4851b.m8100k();
    }

    /* renamed from: k */
    public NvError m7742k() {
        return this.f4857h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public void m7741l() {
        m7751b(2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public void m7740m() {
        m7751b(6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public void m7739n() {
        NvConnection nvConnection = this.f4853d;
        if (nvConnection == null) {
            throw new IllegalStateException("onBound called with on connection");
        }
        nvConnection.m7871n();
        m7751b(3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public void m7738o() {
        m7751b(5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public void m7737p() {
        m7751b(4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public void m7736q() {
        m7751b(7);
        int i = this.f4854e;
        if (i != -1) {
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                default:
                    return;
                case 7:
                    this.f4853d.m7872m();
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m7755a(int i, NvError nvError) {
        this.f4856g = i;
        this.f4857h = nvError;
        int i2 = this.f4854e;
        if (i2 == 2) {
            m7751b(1);
        } else if (i2 == 4) {
            m7751b(3);
            this.f4853d.m7897a(i, nvError);
        } else {
            switch (i2) {
                case 6:
                    m7751b(5);
                    this.f4853d.m7897a(i, nvError);
                    return;
                case 7:
                    m7751b(-1);
                    return;
                default:
                    m7751b(-1);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m7753a(NvConnection nvConnection) {
        if (nvConnection == null) {
            return;
        }
        if (!nvConnection.m7876i().equals(this.f4852c)) {
            throw new RuntimeException("NvDeviceEntry onConnected conn not the same deviceInfo as deviceInfo");
        }
        this.f4853d = nvConnection;
        m7751b(3);
        nvConnection.m7870o();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: r */
    public void m7735r() {
        m7751b(254);
        this.f4853d.m7869p();
        this.f4853d = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: s */
    public NvConnection m7734s() {
        return this.f4853d;
    }

    /* renamed from: t */
    public long m7733t() {
        return this.f4855f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m7754a(long j) {
        this.f4855f = j;
    }
}
