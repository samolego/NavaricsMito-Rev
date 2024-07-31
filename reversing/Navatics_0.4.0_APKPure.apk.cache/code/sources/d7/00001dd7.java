package com.senseplay.sdk.model.device;

/* loaded from: classes2.dex */
public class BatteryStatus {
    public int energyLevel;
    public int state;
    public String stateDesc;

    public int getEnergyLevel() {
        return this.energyLevel;
    }

    public void setEnergyLevel(int i) {
        this.energyLevel = i;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int i) {
        this.state = i;
    }

    public String getStateDesc() {
        return this.stateDesc;
    }

    public void setStateDesc(String str) {
        this.stateDesc = str;
    }
}