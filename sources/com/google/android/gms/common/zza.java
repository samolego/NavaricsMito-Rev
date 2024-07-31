package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzac;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class zza implements ServiceConnection {

    /* renamed from: uH */
    boolean f3017uH = false;

    /* renamed from: uI */
    private final BlockingQueue<IBinder> f3018uI = new LinkedBlockingQueue();

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f3018uI.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }

    public IBinder zza(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        zzac.zzhr("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f3017uH) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f3017uH = true;
        IBinder poll = this.f3018uI.poll(j, timeUnit);
        if (poll != null) {
            return poll;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    public IBinder zzapc() throws InterruptedException {
        zzac.zzhr("BlockingServiceConnection.getService() called on main thread");
        if (this.f3017uH) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f3017uH = true;
        return this.f3018uI.take();
    }
}
