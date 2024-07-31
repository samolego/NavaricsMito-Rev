package com.navatics.robot.transport;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.navatics.robot.transport.y */
/* loaded from: classes.dex */
public abstract class NvVideoChannel extends NvChannel {
    /* renamed from: i */
    public abstract InputStream mo5954i() throws IOException;

    /* renamed from: j */
    public boolean mo5953j() {
        return false;
    }

    public NvVideoChannel(int i) {
        super(i, 2, 0, 0);
    }
}
