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

/* compiled from: PlatformServiceClient.java */
/* renamed from: com.facebook.internal.t */
/* loaded from: classes.dex */
public abstract class AbstractServiceConnectionC0919t implements ServiceConnection {

    /* renamed from: a */
    private final Context f2050a;

    /* renamed from: b */
    private final Handler f2051b;

    /* renamed from: c */
    private a f2052c;

    /* renamed from: d */
    private boolean f2053d;

    /* renamed from: e */
    private Messenger f2054e;

    /* renamed from: f */
    private int f2055f;

    /* renamed from: g */
    private int f2056g;

    /* renamed from: h */
    private final String f2057h;

    /* renamed from: i */
    private final int f2058i;

    /* compiled from: PlatformServiceClient.java */
    /* renamed from: com.facebook.internal.t$a */
    /* loaded from: classes.dex */
    public interface a {
        /* renamed from: a */
        void mo2421a(Bundle bundle);
    }

    /* renamed from: a */
    protected abstract void mo2416a(Bundle bundle);

    public AbstractServiceConnectionC0919t(Context context, int i, int i2, int i3, String str) {
        Context applicationContext = context.getApplicationContext();
        this.f2050a = applicationContext != null ? applicationContext : context;
        this.f2055f = i;
        this.f2056g = i2;
        this.f2057h = str;
        this.f2058i = i3;
        this.f2051b = new Handler() { // from class: com.facebook.internal.t.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                AbstractServiceConnectionC0919t.this.m2417a(message);
            }
        };
    }

    /* renamed from: a */
    public void m2418a(a aVar) {
        this.f2052c = aVar;
    }

    /* renamed from: a */
    public boolean m2419a() {
        Intent m2376a;
        if (this.f2053d || NativeProtocol.m2389b(this.f2058i) == -1 || (m2376a = NativeProtocol.m2376a(this.f2050a)) == null) {
            return false;
        }
        this.f2053d = true;
        this.f2050a.bindService(m2376a, this, 1);
        return true;
    }

    /* renamed from: b */
    public void m2420b() {
        this.f2053d = false;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f2054e = new Messenger(iBinder);
        m2415c();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f2054e = null;
        try {
            this.f2050a.unbindService(this);
        } catch (IllegalArgumentException unused) {
        }
        m2414b(null);
    }

    /* renamed from: c */
    private void m2415c() {
        Bundle bundle = new Bundle();
        bundle.putString("com.facebook.platform.extra.APPLICATION_ID", this.f2057h);
        mo2416a(bundle);
        Message obtain = Message.obtain((Handler) null, this.f2055f);
        obtain.arg1 = this.f2058i;
        obtain.setData(bundle);
        obtain.replyTo = new Messenger(this.f2051b);
        try {
            this.f2054e.send(obtain);
        } catch (RemoteException unused) {
            m2414b(null);
        }
    }

    /* renamed from: a */
    protected void m2417a(Message message) {
        if (message.what == this.f2056g) {
            Bundle data = message.getData();
            if (data.getString("com.facebook.platform.status.ERROR_TYPE") != null) {
                m2414b(null);
            } else {
                m2414b(data);
            }
            try {
                this.f2050a.unbindService(this);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    /* renamed from: b */
    private void m2414b(Bundle bundle) {
        if (this.f2053d) {
            this.f2053d = false;
            a aVar = this.f2052c;
            if (aVar != null) {
                aVar.mo2421a(bundle);
            }
        }
    }
}