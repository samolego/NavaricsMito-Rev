package com.navatics.app.framework;

import com.navatics.app.framework.p049a.DawnBuoyAdapter;
import com.navatics.app.framework.p049a.DawnRobotAdapter;
import com.navatics.robot.protocol.Dawn;
import com.navatics.robot.protocol.INvProtocol;
import com.navatics.robot.transport.NvSocket;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.navatics.app.framework.m */
/* loaded from: classes.dex */
public class MitoConnection extends NvConnection {

    /* renamed from: h */
    private NvRobot f4710h;

    /* renamed from: i */
    private NvBuoy f4711i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MitoConnection(GroundStation groundStation, NvSocket nvSocket) {
        super(groundStation, nvSocket);
    }

    @Override // com.navatics.app.framework.NvConnection
    /* renamed from: a */
    List<NvDevice> mo7899a() {
        this.f4710h = new NvRobot(this.f4790d, this.f4791e);
        this.f4711i = new NvBuoy(this.f4790d, this.f4792f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f4710h);
        arrayList.add(this.f4711i);
        return arrayList;
    }

    @Override // com.navatics.app.framework.NvConnection
    /* renamed from: a */
    INvRobotAdapter mo7895a(INvProtocol iNvProtocol) {
        return new DawnRobotAdapter((Dawn) iNvProtocol);
    }

    @Override // com.navatics.app.framework.NvConnection
    /* renamed from: b */
    INvBuoyAdapter mo7888b(INvProtocol iNvProtocol) {
        return new DawnBuoyAdapter((Dawn) iNvProtocol);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.navatics.app.framework.NvConnection
    /* renamed from: b */
    public void mo7891b() {
        super.mo7891b();
        this.f4710h.m7703b();
    }
}
