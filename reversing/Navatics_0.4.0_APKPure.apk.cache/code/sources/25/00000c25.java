package com.common;

/* loaded from: classes.dex */
public class VEHICLE_CONFIG_INFO {
    public String crc;

    /* renamed from: sn */
    public String f1320sn;
    public String time;
    public String ver;

    public String toString() {
        return "info { \n       ver = " + this.ver + "\n       time = " + this.time + "\n       sn = " + this.f1320sn + "\n       crc= " + this.crc + "\n }";
    }
}