package com.navatics.robot.protocol;

/* compiled from: UpdateOutputMessage.java */
/* renamed from: com.navatics.robot.protocol.az, reason: use source file name */
/* loaded from: classes.dex */
public abstract class UpdateOutputMessage extends OutputMessage {

    /* renamed from: d */
    private int f6391d;

    public UpdateOutputMessage(int i) {
        super(i);
        this.f6391d = -1;
    }

    /* renamed from: b */
    public UpdateOutputMessage mo6399b(int i) {
        this.f6391d = i;
        return this;
    }

    /* renamed from: c */
    public int m6409c() {
        return this.f6391d;
    }
}