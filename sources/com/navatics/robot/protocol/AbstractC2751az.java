package com.navatics.robot.protocol;

/* renamed from: com.navatics.robot.protocol.az */
/* loaded from: classes.dex */
public abstract class UpdateOutputMessage extends OutputMessage {

    /* renamed from: d */
    private int f6363d;

    public UpdateOutputMessage(int i) {
        super(i);
        this.f6363d = -1;
    }

    /* renamed from: b */
    public UpdateOutputMessage mo6463b(int i) {
        this.f6363d = i;
        return this;
    }

    /* renamed from: c */
    public int m6462c() {
        return this.f6363d;
    }
}
