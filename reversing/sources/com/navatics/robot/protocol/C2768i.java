package com.navatics.robot.protocol;

/* renamed from: com.navatics.robot.protocol.i */
/* loaded from: classes.dex */
public class DawnProtoFactory implements IProtocolFactory {
    @Override // com.navatics.robot.protocol.IProtocolFactory
    /* renamed from: a */
    public String mo6379a() {
        return "Dawn";
    }

    @Override // com.navatics.robot.protocol.IProtocolFactory
    /* renamed from: b */
    public boolean mo6377b(int i) {
        return i == 7;
    }

    @Override // com.navatics.robot.protocol.IProtocolFactory
    /* renamed from: a */
    public INvProtocol mo6378a(int i) {
        if (i != 7) {
            return null;
        }
        return new DawnV007();
    }
}
