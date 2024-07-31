package com.navatics.robot.transport;

/* loaded from: classes.dex */
public class ProtoMeta {
    String name;
    int versionCode;

    ProtoMeta() {
    }

    public ProtoMeta(String str, int i) {
        this.name = str;
        this.versionCode = i;
    }

    public String getName() {
        return this.name;
    }

    public int getVersionCode() {
        return this.versionCode;
    }
}