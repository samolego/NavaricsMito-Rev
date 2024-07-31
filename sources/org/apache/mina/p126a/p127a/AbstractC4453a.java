package org.apache.mina.p126a.p127a;

import org.apache.mina.core.session.AbstractIoSessionConfig;
import org.apache.mina.core.session.IoSessionConfig;

/* renamed from: org.apache.mina.a.a.a */
/* loaded from: classes2.dex */
public abstract class AbstractDatagramSessionConfig extends AbstractIoSessionConfig implements DatagramSessionConfig {

    /* renamed from: a */
    private boolean f11291a = true;

    /* renamed from: h */
    protected boolean m1463h() {
        return true;
    }

    /* renamed from: i */
    protected boolean m1462i() {
        return true;
    }

    /* renamed from: j */
    protected boolean m1461j() {
        return true;
    }

    /* renamed from: k */
    protected boolean m1460k() {
        return true;
    }

    /* renamed from: l */
    protected boolean m1459l() {
        return true;
    }

    @Override // org.apache.mina.core.session.AbstractIoSessionConfig, org.apache.mina.core.session.IoSessionConfig
    /* renamed from: a */
    public void mo978a(IoSessionConfig ioSessionConfig) {
        super.mo978a(ioSessionConfig);
        if (ioSessionConfig instanceof DatagramSessionConfig) {
            if (ioSessionConfig instanceof AbstractDatagramSessionConfig) {
                AbstractDatagramSessionConfig abstractDatagramSessionConfig = (AbstractDatagramSessionConfig) ioSessionConfig;
                if (abstractDatagramSessionConfig.m1463h()) {
                    m1433a(abstractDatagramSessionConfig.m1428n());
                }
                if (abstractDatagramSessionConfig.m1462i()) {
                    m1431b_(abstractDatagramSessionConfig.m1426p());
                }
                if (abstractDatagramSessionConfig.m1461j()) {
                    m1432b(abstractDatagramSessionConfig.m1427o());
                }
                if (abstractDatagramSessionConfig.m1460k()) {
                    m1430c_(abstractDatagramSessionConfig.m1425q());
                }
                if (!abstractDatagramSessionConfig.m1459l() || m1424r() == abstractDatagramSessionConfig.m1424r()) {
                    return;
                }
                m1429e(abstractDatagramSessionConfig.m1424r());
                return;
            }
            DatagramSessionConfig datagramSessionConfig = (DatagramSessionConfig) ioSessionConfig;
            m1433a(datagramSessionConfig.m1428n());
            m1431b_(datagramSessionConfig.m1426p());
            m1432b(datagramSessionConfig.m1427o());
            m1430c_(datagramSessionConfig.m1425q());
            if (m1424r() != datagramSessionConfig.m1424r()) {
                m1429e(datagramSessionConfig.m1424r());
            }
        }
    }

    /* renamed from: m */
    public boolean m1458m() {
        return this.f11291a;
    }
}
