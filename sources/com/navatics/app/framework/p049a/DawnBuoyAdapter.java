package com.navatics.app.framework.p049a;

import com.navatics.app.framework.BuoyStatus;
import com.navatics.app.framework.INvBuoyAdapter;
import com.navatics.robot.protocol.BuoyStatusMessage;
import com.navatics.robot.protocol.Dawn;
import com.navatics.robot.protocol.InputMessage;
import com.navatics.robot.transport.NvCallback;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.app.framework.a.a */
/* loaded from: classes.dex */
public class DawnBuoyAdapter implements INvBuoyAdapter, Dawn.InterfaceC2105a {

    /* renamed from: a */
    private static final C3044k f4190a = C3044k.m1564a(DawnBuoyAdapter.class);

    /* renamed from: b */
    private Dawn f4191b;

    /* renamed from: c */
    private NvCallback<BuoyStatus> f4192c;

    /* renamed from: d */
    private BuoyStatus f4193d = new BuoyStatus();

    public DawnBuoyAdapter(Dawn dawn) {
        this.f4191b = dawn;
        dawn.m6407b(this);
    }

    @Override // com.navatics.app.framework.INvBuoyAdapter
    /* renamed from: a */
    public void mo8050a(NvCallback<BuoyStatus> nvCallback) {
        this.f4192c = nvCallback;
    }

    @Override // com.navatics.robot.protocol.Dawn.InterfaceC2105a
    /* renamed from: a */
    public void mo6393a(InputMessage inputMessage) {
        if (inputMessage.m6503k() != 36) {
            return;
        }
        BuoyStatusMessage buoyStatusMessage = (BuoyStatusMessage) inputMessage;
        this.f4193d.m8413a(System.currentTimeMillis());
        this.f4193d.m8415a(buoyStatusMessage.m6565b());
        this.f4193d.m8411b(buoyStatusMessage.m6563c());
        this.f4193d.m8414a(buoyStatusMessage.m6562d());
        NvCallback<BuoyStatus> nvCallback = this.f4192c;
        if (nvCallback != null) {
            nvCallback.mo6276a(this.f4193d);
        }
    }
}
