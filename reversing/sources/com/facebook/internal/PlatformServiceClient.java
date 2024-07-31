package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

/* renamed from: com.facebook.internal.t */
/* loaded from: classes.dex */
public abstract class PlatformServiceClient implements ServiceConnection {

    /* renamed from: a */
    private final Context f2043a;

    /* renamed from: b */
    private final Handler f2044b;

    /* renamed from: c */
    private InterfaceC0981a f2045c;

    /* renamed from: d */
    private boolean f2046d;

    /* renamed from: e */
    private Messenger f2047e;

    /* renamed from: f */
    private int f2048f;

    /* renamed from: g */
    private int f2049g;

    /* renamed from: h */
    private final String f2050h;

    /* renamed from: i */
    private final int f2051i;

    /* compiled from: PlatformServiceClient.java */
    /* renamed from: com.facebook.internal.t$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0981a {
        /* renamed from: a */
        void mo10084a(Bundle bundle);
    }

    /* renamed from: a */
    protected abstract void mo10060a(Bundle bundle);

    public PlatformServiceClient(Context context, int i, int i2, int i3, String str) {
        Context applicationContext = context.getApplicationContext();
        this.f2043a = applicationContext != null ? applicationContext : context;
        this.f2048f = i;
        this.f2049g = i2;
        this.f2050h = str;
        this.f2051i = i3;
        this.f2044b = new Handler() { // from class: com.facebook.internal.t.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                PlatformServiceClient.this.m10563a(message);
            }
        };
    }

    /* renamed from: a */
    public void m10562a(InterfaceC0981a interfaceC0981a) {
        this.f2045c = interfaceC0981a;
    }

    /* renamed from: a */
    public boolean m10564a() {
        Intent m10603a;
        if (this.f2046d || NativeProtocol.m10588b(this.f2051i) == -1 || (m10603a = NativeProtocol.m10603a(this.f2043a)) == null) {
            return false;
        }
        this.f2046d = true;
        this.f2043a.bindService(m10603a, this, 1);
        return true;
    }

    /* renamed from: b */
    public void m10561b() {
        this.f2046d = false;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f2047e = new Messenger(iBinder);
        m10559c();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f2047e = null;
        try {
            this.f2043a.unbindService(this);
        } catch (IllegalArgumentException unused) {
        }
        m10560b(null);
    }

    /* renamed from: c */
    private void m10559c() {
        Bundle bundle = new Bundle();
        bundle.putString("com.facebook.platform.extra.APPLICATION_ID", this.f2050h);
        mo10060a(bundle);
        Message obtain = Message.obtain((Handler) null, this.f2048f);
        obtain.arg1 = this.f2051i;
        obtain.setData(bundle);
        obtain.replyTo = new Messenger(this.f2044b);
        try {
            this.f2047e.send(obtain);
        } catch (RemoteException unused) {
            m10560b(null);
        }
    }

    /* renamed from: a */
    protected void m10563a(Message message) {
        if (message.what == this.f2049g) {
            Bundle data = message.getData();
            if (data.getString("com.facebook.platform.status.ERROR_TYPE") != null) {
                m10560b(null);
            } else {
                m10560b(data);
            }
            try {
                this.f2043a.unbindService(this);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    /* renamed from: b */
    private void m10560b(Bundle bundle) {
        if (this.f2046d) {
            this.f2046d = false;
            InterfaceC0981a interfaceC0981a = this.f2045c;
            if (interfaceC0981a != null) {
                interfaceC0981a.mo10084a(bundle);
            }
        }
    }
}
