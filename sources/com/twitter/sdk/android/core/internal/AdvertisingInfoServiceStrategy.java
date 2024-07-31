package com.twitter.sdk.android.core.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import com.twitter.sdk.android.core.Twitter;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* renamed from: com.twitter.sdk.android.core.internal.e */
/* loaded from: classes2.dex */
class AdvertisingInfoServiceStrategy implements AdvertisingInfoStrategy {

    /* renamed from: a */
    private final Context f8505a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdvertisingInfoServiceStrategy(Context context) {
        this.f8505a = context.getApplicationContext();
    }

    @Override // com.twitter.sdk.android.core.internal.AdvertisingInfoStrategy
    /* renamed from: a */
    public AdvertisingInfo mo4457a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Twitter.m4253h().mo4561a("Twitter", "AdvertisingInfoServiceStrategy cannot be called on the main thread");
            return null;
        }
        try {
            this.f8505a.getPackageManager().getPackageInfo("com.android.vending", 0);
            ServiceConnectionC2660a serviceConnectionC2660a = new ServiceConnectionC2660a();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (this.f8505a.bindService(intent, serviceConnectionC2660a, 1)) {
                    try {
                        C2661b c2661b = new C2661b(serviceConnectionC2660a.m4461a());
                        AdvertisingInfo advertisingInfo = new AdvertisingInfo(c2661b.m4460a(), c2661b.m4458b());
                        this.f8505a.unbindService(serviceConnectionC2660a);
                        return advertisingInfo;
                    } catch (Exception e) {
                        Twitter.m4253h().mo4558b("Twitter", "Exception in binding to Google Play Service to capture AdvertisingId", e);
                        this.f8505a.unbindService(serviceConnectionC2660a);
                    }
                } else {
                    Twitter.m4253h().mo4561a("Twitter", "Could not bind to Google Play Service to capture AdvertisingId");
                }
            } catch (Throwable th) {
                Twitter.m4253h().mo4560a("Twitter", "Could not bind to Google Play Service to capture AdvertisingId", th);
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            Twitter.m4253h().mo4561a("Twitter", "Unable to find Google Play Services package name");
            return null;
        } catch (Exception e2) {
            Twitter.m4253h().mo4560a("Twitter", "Unable to determine if Google Play Services is available", e2);
            return null;
        }
    }

    /* compiled from: AdvertisingInfoServiceStrategy.java */
    /* renamed from: com.twitter.sdk.android.core.internal.e$a */
    /* loaded from: classes2.dex */
    private static final class ServiceConnectionC2660a implements ServiceConnection {

        /* renamed from: a */
        private boolean f8506a;

        /* renamed from: b */
        private final LinkedBlockingQueue<IBinder> f8507b;

        private ServiceConnectionC2660a() {
            this.f8507b = new LinkedBlockingQueue<>(1);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f8507b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            this.f8507b.clear();
        }

        /* renamed from: a */
        IBinder m4461a() {
            if (this.f8506a) {
                Twitter.m4253h().mo4557c("Twitter", "getBinder already called");
            }
            this.f8506a = true;
            try {
                return this.f8507b.poll(200L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                return null;
            }
        }
    }

    /* compiled from: AdvertisingInfoServiceStrategy.java */
    /* renamed from: com.twitter.sdk.android.core.internal.e$b */
    /* loaded from: classes2.dex */
    private static final class C2661b implements IInterface {

        /* renamed from: a */
        private final IBinder f8508a;

        private C2661b(IBinder iBinder) {
            this.f8508a = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f8508a;
        }

        /* renamed from: a */
        public String m4460a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    this.f8508a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } catch (Exception unused) {
                    Twitter.m4253h().mo4561a("Twitter", "Could not get parcel from Google Play Service to capture AdvertisingId");
                    obtain2.recycle();
                    obtain.recycle();
                    return null;
                }
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public boolean m4458b() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            boolean z = false;
            try {
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    obtain.writeInt(1);
                    this.f8508a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                } catch (Exception unused) {
                    Twitter.m4253h().mo4561a("Twitter", "Could not get parcel from Google Play Service to capture Advertising limitAdTracking");
                }
                return z;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }
}
