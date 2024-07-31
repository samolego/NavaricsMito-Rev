package com.navatics.robot.transport;

/* loaded from: classes.dex */
public class NvBatteryInfo {
    public static int CHARGE_FULL = 2;
    public static int CHARGING = 1;
    public static int DISCHARGING = 0;
    public static int FAULT = 3;
    private int level;
    private int state;

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int i) {
        this.state = i;
    }
}
