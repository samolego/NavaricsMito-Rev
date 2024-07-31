package com.navatics.app.framework.p054f;

import java.io.IOException;

/* renamed from: com.navatics.app.framework.f.m */
/* loaded from: classes.dex */
public abstract class ServerSocket {

    /* renamed from: a */
    private String f4536a;

    /* renamed from: a */
    public abstract void mo8327a() throws IOException;

    /* renamed from: b */
    public abstract ClientSocket mo8326b() throws IOException;

    public ServerSocket(String str) throws IOException {
        this.f4536a = str;
    }
}
