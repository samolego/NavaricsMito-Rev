package com.navatics.app.framework.p048f;

import java.io.IOException;

/* compiled from: ServerSocket.java */
/* renamed from: com.navatics.app.framework.f.m */
/* loaded from: classes.dex */
public abstract class ServerSocket {

    /* renamed from: a */
    private String f4558a;

    /* renamed from: a */
    public abstract void mo4578a() throws IOException;

    /* renamed from: b */
    public abstract ClientSocket mo4579b() throws IOException;

    public ServerSocket(String str) throws IOException {
        this.f4558a = str;
    }
}