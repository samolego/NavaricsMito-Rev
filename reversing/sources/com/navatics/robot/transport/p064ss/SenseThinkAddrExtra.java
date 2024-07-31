package com.navatics.robot.transport.p064ss;

import com.navatics.robot.transport.NvAddressExtra;
import com.navatics.robot.utils.C2160n;
import com.senseplay.sdk.model.device.DeviceInfo;
import java.util.Objects;

/* renamed from: com.navatics.robot.transport.ss.b */
/* loaded from: classes2.dex */
public class SenseThinkAddrExtra extends NvAddressExtra {

    /* renamed from: a */
    DeviceInfo f6590a;

    public SenseThinkAddrExtra() {
    }

    public SenseThinkAddrExtra(DeviceInfo deviceInfo) {
        this.f6590a = deviceInfo;
    }

    /* renamed from: a */
    public DeviceInfo m6217a() {
        return this.f6590a;
    }

    @Override // com.navatics.robot.transport.NvAddressExtra
    public boolean isValidate() {
        return (C2160n.m5855a((CharSequence) this.f6590a.getLinkID()) || C2160n.m5855a((CharSequence) this.f6590a.getSerialNo())) ? false : true;
    }

    /* renamed from: b */
    private String m6216b() {
        return "DeviceInfo{category='" + this.f6590a.getCategory() + "', manufacturerID=" + this.f6590a.getManufacturerID() + ", modelID=" + this.f6590a.getModelID() + ", serialNo='" + this.f6590a.getSerialNo() + "', linkID='" + this.f6590a.getLinkID() + "', manufactureDate='" + this.f6590a.getManufactureDate() + "', hardwareVersion=" + this.f6590a.getHardwareVersion() + ", firmwareVersion=" + this.f6590a.getFirmwareVersion() + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SenseThinkAddrExtra) {
            return Objects.equals(this.f6590a.getSerialNo(), ((SenseThinkAddrExtra) obj).f6590a.getSerialNo());
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.f6590a.getSerialNo());
    }

    public String toString() {
        return "SenseThinkAddrExtra{ssInfo=" + m6216b() + '}';
    }
}
