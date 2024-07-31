package com.navatics.app.framework.p054f;

import java.io.IOException;

/* renamed from: com.navatics.app.framework.f.c */
/* loaded from: classes.dex */
public class AndroidServerSocketProvider implements IServerSocketProvider {
    @Override // com.navatics.app.framework.p054f.IServerSocketProvider
    /* renamed from: a */
    public ServerSocket mo8407a(String str) throws IOException {
        return new AndroidServerSocket(str);
    }
}
