package com.navatics.app.framework.network.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.navatics.app.framework.network.NetworkConnection;
import com.navatics.app.framework.network.NetworkServiceHandler;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public abstract class NetworkServerService extends Service {

    /* renamed from: a */
    private static final C3044k f4736a = C3044k.m1564a(NetworkServerService.class);

    /* renamed from: b */
    private static final String f4737b = NetworkServerService.class.getSimpleName();

    /* renamed from: c */
    private Looper f4738c;

    /* renamed from: d */
    private NetworkServiceHandler f4739d;

    /* renamed from: e */
    private NetworkConnection f4740e;

    /* renamed from: a */
    protected abstract NetworkServiceHandler mo7969a(Looper looper, NetworkServerService networkServerService);

    /* renamed from: a */
    public abstract Object mo7970a();

    /* renamed from: b */
    public abstract boolean mo7967b();

    /* renamed from: c */
    public abstract void mo7966c();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m7968a(Exception exc) {
        f4736a.mo1510a("could not start server", exc);
        sendBroadcast(new Intent("com.navatics.app.framework.action.FTPSERVER_FAILEDTOSTART"));
    }

    @Override // android.app.Service
    public void onCreate() {
        HandlerThread handlerThread = new HandlerThread("ServiceStartArguments", 10);
        handlerThread.start();
        this.f4738c = handlerThread.getLooper();
        this.f4739d = mo7969a(this.f4738c, this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            f4736a.mo1511a((Object) "intent is null in onStartCommand()");
            return 3;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            this.f4740e = NetworkConnection.m7990a(getApplicationContext());
        } else {
            this.f4740e = (NetworkConnection) extras.getParcelable("root");
        }
        Message obtainMessage = this.f4739d.obtainMessage();
        obtainMessage.arg1 = 1;
        this.f4739d.sendMessage(obtainMessage);
        return 1;
    }

    @Override // android.app.Service
    public void onDestroy() {
        Message obtainMessage = this.f4739d.obtainMessage();
        obtainMessage.arg1 = 2;
        this.f4739d.sendMessage(obtainMessage);
    }

    /* renamed from: d */
    public NetworkConnection m7965d() {
        return this.f4740e;
    }
}
