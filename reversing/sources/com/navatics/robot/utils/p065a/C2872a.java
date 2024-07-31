package com.navatics.robot.utils.p065a;

/* renamed from: com.navatics.robot.utils.a.a */
/* loaded from: classes2.dex */
public class AndroidLogAdapter implements LogAdapter {

    /* renamed from: a */
    private final FormatStrategy f6732a = PrettyFormatStrategy.m5927a().m5916a();

    @Override // com.navatics.robot.utils.p065a.LogAdapter
    /* renamed from: a */
    public boolean mo5944a(int i, String str) {
        return true;
    }

    @Override // com.navatics.robot.utils.p065a.LogAdapter
    /* renamed from: a */
    public void mo5943a(int i, String str, String str2) {
        this.f6732a.mo5924a(i, str, str2);
    }
}
