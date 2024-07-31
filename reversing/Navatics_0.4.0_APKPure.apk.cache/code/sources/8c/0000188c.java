package com.navatics.app.framework.p048f;

import android.net.LocalSocket;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: AndroidClientSocket.java */
/* renamed from: com.navatics.app.framework.f.a, reason: use source file name */
/* loaded from: classes.dex */
public class AndroidClientSocket extends ClientSocket {

    /* renamed from: a */
    private LocalSocket f4490a;

    public AndroidClientSocket(LocalSocket localSocket) {
        this.f4490a = localSocket;
    }

    @Override // com.navatics.app.framework.p048f.ClientSocket
    /* renamed from: a */
    public void mo4576a() throws IOException {
        this.f4490a.close();
    }

    @Override // com.navatics.app.framework.p048f.ClientSocket
    /* renamed from: b */
    public OutputStream mo4577b() throws IOException {
        return this.f4490a.getOutputStream();
    }
}