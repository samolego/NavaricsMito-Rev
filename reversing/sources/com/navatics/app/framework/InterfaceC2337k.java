package com.navatics.app.framework;

import com.navatics.robot.transport.NvCallback;
import com.navatics.robot.transport.StorageInfo;
import com.navatics.robot.transport.WhiteBalance;
import com.navatics.robot.transport.p063b.NvObservable;
import java.util.Map;

/* renamed from: com.navatics.app.framework.k */
/* loaded from: classes.dex */
public interface INvRobotAdapter {
    /* renamed from: a */
    NvObservable<Boolean> mo8048a(int i);

    /* renamed from: a */
    NvObservable<Boolean> mo8047a(int i, int i2);

    /* renamed from: a */
    NvObservable<Boolean> mo8045a(Map<String, Object> map);

    /* renamed from: a */
    void mo8049a();

    /* renamed from: a */
    void mo8046a(NvCallback<RobotStatus> nvCallback);

    /* renamed from: b */
    NvObservable<Boolean> mo8044b();

    /* renamed from: b */
    void mo8043b(int i);

    /* renamed from: c */
    NvObservable<Boolean> mo8042c();

    /* renamed from: c */
    NvObservable<Boolean> mo8041c(int i);

    /* renamed from: d */
    NvObservable<Boolean> mo8040d();

    /* renamed from: d */
    NvObservable<Boolean> mo8039d(int i);

    /* renamed from: e */
    NvObservable<RobotVersionInfo> mo8038e();

    /* renamed from: e */
    NvObservable<Boolean> mo8037e(int i);

    /* renamed from: f */
    NvObservable<Boolean> mo8036f();

    /* renamed from: f */
    NvObservable<Boolean> mo8035f(int i);

    /* renamed from: g */
    NvObservable<Boolean> mo8034g();

    /* renamed from: g */
    NvObservable<Boolean> mo8033g(int i);

    /* renamed from: h */
    NvObservable<Integer> mo8032h();

    /* renamed from: h */
    NvObservable<Boolean> mo8031h(int i);

    /* renamed from: i */
    NvObservable<Integer> mo8030i();

    /* renamed from: i */
    NvObservable<Boolean> mo8029i(int i);

    /* renamed from: j */
    NvObservable<Integer> mo8028j();

    /* renamed from: j */
    NvObservable<Boolean> mo8027j(int i);

    /* renamed from: k */
    NvObservable<Integer> mo8026k();

    /* renamed from: l */
    NvObservable<Integer> mo8025l();

    /* renamed from: m */
    NvObservable<Integer> mo8024m();

    /* renamed from: n */
    NvObservable<Integer> mo8023n();

    /* renamed from: o */
    NvObservable<Integer> mo8022o();

    /* renamed from: p */
    NvObservable<WhiteBalance> mo8021p();

    /* renamed from: q */
    NvObservable<StorageInfo> mo8020q();

    /* renamed from: r */
    NvObservable<Integer> mo8019r();

    /* renamed from: s */
    NvObservable<Boolean> mo8018s();
}
