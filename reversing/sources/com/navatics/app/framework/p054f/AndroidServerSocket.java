package com.navatics.app.framework.p054f;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import java.io.IOException;

/* renamed from: com.navatics.app.framework.f.b */
/* loaded from: classes.dex */
public class AndroidServerSocket extends ServerSocket {

    /* renamed from: a */
    private LocalServerSocket f4469a;

    public AndroidServerSocket(String str) throws IOException {
        super(str);
        this.f4469a = new LocalServerSocket(str);
    }

    @Override // com.navatics.app.framework.p054f.ServerSocket
    /* renamed from: a */
    public void mo8327a() throws IOException {
        LocalSocket localSocket = new LocalSocket();
        try {
            try {
                try {
                    localSocket.connect(this.f4469a.getLocalSocketAddress());
                    localSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    localSocket.close();
                }
            } catch (Throwable th) {
                try {
                    localSocket.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                throw th;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    @Override // com.navatics.app.framework.p054f.ServerSocket
    /* renamed from: b */
    public ClientSocket mo8326b() throws IOException {
        return new AndroidClientSocket(this.f4469a.accept());
    }
}
