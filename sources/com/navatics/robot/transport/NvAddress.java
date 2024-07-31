package com.navatics.robot.transport;

import com.navatics.robot.utils.C2160n;
import java.util.Objects;

/* loaded from: classes.dex */
public class NvAddress {
    private String address;
    private NvAddressExtra extra;
    private TransportType transportType;

    public NvAddress(TransportType transportType) {
        this.transportType = transportType;
    }

    public NvAddress(TransportType transportType, String str) {
        this.transportType = transportType;
        this.address = str;
    }

    public NvAddress(TransportType transportType, NvAddressExtra nvAddressExtra) {
        this.transportType = transportType;
        this.extra = nvAddressExtra;
    }

    public NvAddress(TransportType transportType, String str, NvAddressExtra nvAddressExtra) {
        this.transportType = transportType;
        this.address = str;
        this.extra = nvAddressExtra;
    }

    public TransportType getTransportType() {
        return this.transportType;
    }

    public String getAddress() {
        return this.address;
    }

    public NvAddressExtra getExtra() {
        return this.extra;
    }

    public boolean isValid() {
        return !C2160n.m5855a((CharSequence) this.address) && this.extra.isValidate();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NvAddress) {
            NvAddress nvAddress = (NvAddress) obj;
            return this.transportType == nvAddress.transportType && Objects.equals(this.address, nvAddress.address) && Objects.equals(this.extra, nvAddress.extra);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.transportType, this.address, this.extra);
    }

    public String toString() {
        return "NvAddress{transportType=" + this.transportType + ", address='" + this.address + "', extra=" + this.extra + '}';
    }
}
