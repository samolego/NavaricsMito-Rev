package com.navatics.app.framework;

import com.navatics.app.framework.annotation.SearchState;
import com.navatics.robot.transport.NvDeviceInfo;
import com.navatics.robot.transport.NvError;

/* renamed from: com.navatics.app.framework.x */
/* loaded from: classes.dex */
public interface NvGroundStationHandler {
    /* renamed from: a */
    void mo7730a(GroundStation groundStation);

    /* renamed from: a */
    void mo7729a(GroundStation groundStation, @SearchState int i);

    /* renamed from: a */
    void mo7728a(GroundStation groundStation, int i, NvError nvError);

    /* renamed from: a */
    void mo7508a(GroundStation groundStation, NvConnection nvConnection);

    /* renamed from: a */
    void mo7507a(GroundStation groundStation, NvConnection nvConnection, NvConnection nvConnection2);

    /* renamed from: a */
    void mo7506a(GroundStation groundStation, NvDeviceInfo nvDeviceInfo);

    /* renamed from: a */
    void mo7727a(NvDeviceInfo nvDeviceInfo);

    /* renamed from: b */
    void mo7726b(GroundStation groundStation);

    /* renamed from: b */
    void mo7504b(GroundStation groundStation, NvConnection nvConnection);

    /* renamed from: c */
    void mo7725c(GroundStation groundStation);

    /* renamed from: d */
    void mo7724d(GroundStation groundStation);
}
