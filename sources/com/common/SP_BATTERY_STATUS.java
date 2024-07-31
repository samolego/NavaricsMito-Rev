package com.common;

/* loaded from: classes.dex */
public class SP_BATTERY_STATUS implements SPRC_T {
    public byte EnergyLevel;
    public SP_BATTER_STATE State;

    @Override // com.common.SPRC_T
    public int fill(byte[] bArr, int i) {
        int i2 = i + 1;
        byte b = (byte) (bArr[i] & 255);
        if (b == 0) {
            this.State = SP_BATTER_STATE.DISCHARGING;
        } else if (1 == b) {
            this.State = SP_BATTER_STATE.CHARGING;
        } else if (2 == b) {
            this.State = SP_BATTER_STATE.CHARGE_FULL;
        } else if (3 == b) {
            this.State = SP_BATTER_STATE.FAULT;
        } else if (-2 == b) {
            this.State = SP_BATTER_STATE.UNREGISTERED;
        } else if (-1 == b) {
            this.State = SP_BATTER_STATE.STATUS_UNKNOWN;
        }
        int i3 = i2 + 1;
        this.EnergyLevel = bArr[i2];
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Batter State: " + this.State + "\n");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Level: ");
        sb2.append((int) this.EnergyLevel);
        sb.append(sb2.toString());
        return sb.toString();
    }
}
