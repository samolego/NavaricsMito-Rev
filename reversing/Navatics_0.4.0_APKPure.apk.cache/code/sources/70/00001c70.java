package com.navatics.robot.transport;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: NvVideoChannel.java */
/* renamed from: com.navatics.robot.transport.y, reason: use source file name */
/* loaded from: classes.dex */
public abstract class NvVideoChannel extends NvChannel {
    /* renamed from: i */
    public abstract InputStream mo6809i() throws IOException;

    /* renamed from: j */
    public boolean mo6810j() {
        return false;
    }

    public NvVideoChannel(int i) {
        super(i, 2, 0, 0);
    }
}