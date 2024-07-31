package com.navatics.robot.transport;

import android.content.Context;
import android.support.annotation.NonNull;
import java.util.List;
import java.util.Map;

/* renamed from: com.navatics.robot.transport.e */
/* loaded from: classes.dex */
public interface INvGroundStation {
    /* renamed from: a */
    long mo6194a();

    /* renamed from: a */
    KeyMapProvider mo6188a(Context context);

    /* renamed from: a */
    void mo6189a(long j);

    /* renamed from: a */
    void mo6185a(NvDeviceInfo nvDeviceInfo, Map<String, Object> map);

    /* renamed from: a */
    void mo6184a(@NonNull NvEventHandler nvEventHandler);

    /* renamed from: a */
    void mo6142a(Map<String, Object> map);

    /* renamed from: b */
    NvDeviceInfo mo6141b();

    /* renamed from: b */
    void mo6128b(Map<String, Object> map);

    /* renamed from: c */
    int mo6127c();

    /* renamed from: c */
    void mo6117c(Map<String, Object> map);

    /* renamed from: d */
    int mo6116d();

    /* renamed from: e */
    int mo6111e();

    /* renamed from: f */
    int mo6109f();

    /* renamed from: g */
    void mo6107g();

    /* renamed from: h */
    boolean mo6105h();

    /* renamed from: i */
    boolean mo6103i();

    /* renamed from: j */
    boolean mo6101j();

    /* renamed from: k */
    boolean mo6099k();

    /* renamed from: l */
    int mo6097l();

    /* renamed from: m */
    List<NvSocket> mo6095m();

    /* renamed from: n */
    boolean mo6093n();

    /* renamed from: o */
    boolean mo6091o();
}
