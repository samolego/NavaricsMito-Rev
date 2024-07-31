package com.navatics.app.framework.p054f;

import android.net.LocalSocket;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.navatics.app.framework.f.a */
/* loaded from: classes.dex */
public class AndroidClientSocket extends ClientSocket {

    /* renamed from: a */
    private LocalSocket f4468a;

    public AndroidClientSocket(LocalSocket localSocket) {
        this.f4468a = localSocket;
    }

    @Override // com.navatics.app.framework.p054f.ClientSocket
    /* renamed from: a */
    public void mo8409a() throws IOException {
        this.f4468a.close();
    }

    @Override // com.navatics.app.framework.p054f.ClientSocket
    /* renamed from: b */
    public OutputStream mo8408b() throws IOException {
        return this.f4468a.getOutputStream();
    }
}
