package com.navatics.app.framework.network;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.navatics.app.framework.network.service.NetworkServerService;
import java.lang.ref.WeakReference;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.app.framework.network.b */
/* loaded from: classes.dex */
public class NetworkServiceHandler extends Handler {

    /* renamed from: a */
    private static final C3044k f4733a = C3044k.m1564a(NetworkServiceHandler.class);

    /* renamed from: b */
    private final WeakReference<NetworkServerService> f4734b;

    public NetworkServiceHandler(Looper looper, NetworkServerService networkServerService) {
        super(looper);
        this.f4734b = new WeakReference<>(networkServerService);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        f4733a.mo1511a((Object) "handleMessage()");
        NetworkServerService networkServerService = this.f4734b.get();
        if (networkServerService == null) {
            f4733a.mo1511a((Object) "serviceRef is null");
            return;
        }
        int i = message.arg1;
        if (i == 1) {
            m7973a(networkServerService);
        } else if (i == 2) {
            m7971b(networkServerService);
        }
    }

    /* renamed from: a */
    protected void m7973a(NetworkServerService networkServerService) {
        if (networkServerService.mo7970a() == null) {
            f4733a.mo1511a((Object) "starting {} server");
            if (networkServerService.mo7967b() && networkServerService.mo7970a() != null) {
                m7972a(networkServerService, "com.navatics.app.framework.action.FTPSERVER_STARTED");
            } else {
                networkServerService.stopSelf();
            }
        }
    }

    /* renamed from: b */
    protected void m7971b(NetworkServerService networkServerService) {
        if (networkServerService.mo7970a() != null) {
            f4733a.mo1511a((Object) "stopping {} server");
            networkServerService.mo7966c();
        }
        f4733a.mo1511a((Object) "stopSelf ({})");
        networkServerService.stopSelf();
        m7972a(networkServerService, "com.navatics.app.framework.action.FTPSERVER_STOPPED");
    }

    /* renamed from: a */
    private void m7972a(NetworkServerService networkServerService, String str) {
        networkServerService.sendBroadcast(new Intent(str));
    }
}
