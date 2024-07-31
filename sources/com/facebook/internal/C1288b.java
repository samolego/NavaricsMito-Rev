package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.internal.b */
/* loaded from: classes.dex */
public class AttributionIdentifiers {

    /* renamed from: a */
    private static final String f1928a = AttributionIdentifiers.class.getCanonicalName();

    /* renamed from: g */
    private static AttributionIdentifiers f1929g;

    /* renamed from: b */
    private String f1930b;

    /* renamed from: c */
    private String f1931c;

    /* renamed from: d */
    private String f1932d;

    /* renamed from: e */
    private boolean f1933e;

    /* renamed from: f */
    private long f1934f;

    /* renamed from: c */
    private static AttributionIdentifiers m10749c(Context context) {
        AttributionIdentifiers m10747d = m10747d(context);
        if (m10747d == null) {
            AttributionIdentifiers m10745f = m10745f(context);
            return m10745f == null ? new AttributionIdentifiers() : m10745f;
        }
        return m10747d;
    }

    /* renamed from: d */
    private static AttributionIdentifiers m10747d(Context context) {
        Method m10524a;
        Object m10532a;
        try {
            if (!m10746e(context) || (m10524a = Utility.m10524a("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", Context.class)) == null || (m10532a = Utility.m10532a((Object) null, m10524a, context)) == null) {
                return null;
            }
            Method m10534a = Utility.m10534a(m10532a.getClass(), "getId", new Class[0]);
            Method m10534a2 = Utility.m10534a(m10532a.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
            if (m10534a != null && m10534a2 != null) {
                AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
                attributionIdentifiers.f1931c = (String) Utility.m10532a(m10532a, m10534a, new Object[0]);
                attributionIdentifiers.f1933e = ((Boolean) Utility.m10532a(m10532a, m10534a2, new Object[0])).booleanValue();
                return attributionIdentifiers;
            }
            return null;
        } catch (Exception e) {
            Utility.m10528a("android_id", e);
            return null;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* renamed from: a */
    public static boolean m10754a(Context context) {
        AttributionIdentifiers m10751b = m10751b(context);
        return m10751b != null && m10751b.m10748d();
    }

    /* renamed from: e */
    private static boolean m10746e(Context context) {
        Method m10524a = Utility.m10524a("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", Context.class);
        if (m10524a == null) {
            return false;
        }
        Object m10532a = Utility.m10532a((Object) null, m10524a, context);
        return (m10532a instanceof Integer) && ((Integer) m10532a).intValue() == 0;
    }

    /* renamed from: f */
    private static AttributionIdentifiers m10745f(Context context) {
        ServiceConnectionC0941b serviceConnectionC0941b = new ServiceConnectionC0941b();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, serviceConnectionC0941b, 1)) {
            try {
                C0940a c0940a = new C0940a(serviceConnectionC0941b.m10741a());
                AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
                attributionIdentifiers.f1931c = c0940a.m10743a();
                attributionIdentifiers.f1933e = c0940a.m10742b();
                return attributionIdentifiers;
            } catch (Exception e) {
                Utility.m10528a("android_id", e);
            } finally {
                context.unbindService(serviceConnectionC0941b);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x010c  */
    @android.support.annotation.Nullable
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.internal.AttributionIdentifiers m10751b(android.content.Context r12) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.AttributionIdentifiers.m10751b(android.content.Context):com.facebook.internal.b");
    }

    /* renamed from: a */
    private static AttributionIdentifiers m10753a(AttributionIdentifiers attributionIdentifiers) {
        attributionIdentifiers.f1934f = System.currentTimeMillis();
        f1929g = attributionIdentifiers;
        return attributionIdentifiers;
    }

    /* renamed from: a */
    public String m10755a() {
        return this.f1930b;
    }

    /* renamed from: b */
    public String m10752b() {
        if (FacebookSdk.m10885a() && FacebookSdk.m10859r()) {
            return this.f1931c;
        }
        return null;
    }

    /* renamed from: c */
    public String m10750c() {
        return this.f1932d;
    }

    /* renamed from: d */
    public boolean m10748d() {
        return this.f1933e;
    }

    @Nullable
    /* renamed from: g */
    private static String m10744g(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            return packageManager.getInstallerPackageName(context.getPackageName());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AttributionIdentifiers.java */
    /* renamed from: com.facebook.internal.b$b */
    /* loaded from: classes.dex */
    public static final class ServiceConnectionC0941b implements ServiceConnection {

        /* renamed from: a */
        private AtomicBoolean f1936a;

        /* renamed from: b */
        private final BlockingQueue<IBinder> f1937b;

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        private ServiceConnectionC0941b() {
            this.f1936a = new AtomicBoolean(false);
            this.f1937b = new LinkedBlockingDeque();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder != null) {
                try {
                    this.f1937b.put(iBinder);
                } catch (InterruptedException unused) {
                }
            }
        }

        /* renamed from: a */
        public IBinder m10741a() throws InterruptedException {
            if (this.f1936a.compareAndSet(true, true)) {
                throw new IllegalStateException("Binder already consumed");
            }
            return this.f1937b.take();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AttributionIdentifiers.java */
    /* renamed from: com.facebook.internal.b$a */
    /* loaded from: classes.dex */
    public static final class C0940a implements IInterface {

        /* renamed from: a */
        private IBinder f1935a;

        C0940a(IBinder iBinder) {
            this.f1935a = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f1935a;
        }

        /* renamed from: a */
        public String m10743a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f1935a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        /* renamed from: b */
        public boolean m10742b() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(1);
                this.f1935a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }
}
