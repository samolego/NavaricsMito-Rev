package org.apache.mina.p126a.p127a;

import org.apache.mina.core.session.AbstractIoSessionConfig;
import org.apache.mina.core.session.IoSessionConfig;

/* renamed from: org.apache.mina.a.a.b */
/* loaded from: classes2.dex */
public abstract class AbstractSocketSessionConfig extends AbstractIoSessionConfig implements SocketSessionConfig {
    /* renamed from: h */
    protected boolean mo1422h() {
        return true;
    }

    /* renamed from: i */
    protected boolean mo1421i() {
        return true;
    }

    /* renamed from: j */
    protected boolean mo1420j() {
        return true;
    }

    /* renamed from: k */
    protected boolean mo1419k() {
        return true;
    }

    /* renamed from: l */
    protected boolean mo1418l() {
        return true;
    }

    /* renamed from: m */
    protected boolean mo1417m() {
        return true;
    }

    /* renamed from: n */
    protected boolean mo1416n() {
        return true;
    }

    /* renamed from: o */
    protected boolean mo1415o() {
        return true;
    }

    @Override // org.apache.mina.core.session.AbstractIoSessionConfig, org.apache.mina.core.session.IoSessionConfig
    /* renamed from: a */
    public void mo978a(IoSessionConfig ioSessionConfig) {
        super.mo978a(ioSessionConfig);
        if (ioSessionConfig instanceof SocketSessionConfig) {
            if (ioSessionConfig instanceof AbstractSocketSessionConfig) {
                AbstractSocketSessionConfig abstractSocketSessionConfig = (AbstractSocketSessionConfig) ioSessionConfig;
                if (abstractSocketSessionConfig.mo1422h()) {
                    mo1410c(abstractSocketSessionConfig.mo1399t());
                }
                if (abstractSocketSessionConfig.mo1421i()) {
                    mo1409d(abstractSocketSessionConfig.mo1398u());
                }
                if (abstractSocketSessionConfig.mo1420j()) {
                    mo1407g(abstractSocketSessionConfig.mo1402q());
                }
                if (abstractSocketSessionConfig.mo1419k()) {
                    mo1411b(abstractSocketSessionConfig.mo1403p());
                }
                if (abstractSocketSessionConfig.mo1418l()) {
                    mo1406h(abstractSocketSessionConfig.mo1401r());
                }
                if (abstractSocketSessionConfig.mo1417m()) {
                    mo1404j(abstractSocketSessionConfig.mo1397v());
                }
                if (abstractSocketSessionConfig.mo1416n()) {
                    mo1408e(abstractSocketSessionConfig.mo1396w());
                }
                if (!abstractSocketSessionConfig.mo1415o() || mo1400s() == abstractSocketSessionConfig.mo1400s()) {
                    return;
                }
                mo1405i(abstractSocketSessionConfig.mo1400s());
                return;
            }
            SocketSessionConfig socketSessionConfig = (SocketSessionConfig) ioSessionConfig;
            mo1410c(socketSessionConfig.mo1399t());
            mo1409d(socketSessionConfig.mo1398u());
            mo1407g(socketSessionConfig.mo1402q());
            mo1411b(socketSessionConfig.mo1403p());
            mo1406h(socketSessionConfig.mo1401r());
            mo1404j(socketSessionConfig.mo1397v());
            mo1408e(socketSessionConfig.mo1396w());
            if (mo1400s() != socketSessionConfig.mo1400s()) {
                mo1405i(socketSessionConfig.mo1400s());
            }
        }
    }
}
