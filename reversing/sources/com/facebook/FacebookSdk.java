package com.facebook;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.util.Base64;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.AppEventsManager;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.BoltsMeasurementEventListener;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.LockOnGetVariable;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.p043a.InstrumentManager;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;

/* renamed from: com.facebook.f */
/* loaded from: classes.dex */
public final class FacebookSdk {

    /* renamed from: c */
    private static Executor f1842c;

    /* renamed from: d */
    private static volatile String f1843d;
    @Nullable

    /* renamed from: e */
    private static volatile String f1844e;

    /* renamed from: f */
    private static volatile String f1845f;

    /* renamed from: g */
    private static volatile Boolean f1846g;

    /* renamed from: l */
    private static LockOnGetVariable<File> f1851l;

    /* renamed from: m */
    private static Context f1852m;

    /* renamed from: a */
    private static final String f1840a = FacebookSdk.class.getCanonicalName();

    /* renamed from: b */
    private static final HashSet<LoggingBehavior> f1841b = new HashSet<>(Arrays.asList(LoggingBehavior.DEVELOPER_ERRORS));

    /* renamed from: h */
    private static volatile String f1847h = "facebook.com";

    /* renamed from: i */
    private static AtomicLong f1848i = new AtomicLong(65536);

    /* renamed from: j */
    private static volatile boolean f1849j = false;

    /* renamed from: k */
    private static boolean f1850k = false;

    /* renamed from: n */
    private static int f1853n = 64206;

    /* renamed from: o */
    private static final Object f1854o = new Object();

    /* renamed from: p */
    private static String f1855p = ServerProtocol.m10552d();

    /* renamed from: q */
    private static Boolean f1856q = false;

    /* renamed from: r */
    private static Boolean f1857r = false;

    /* compiled from: FacebookSdk.java */
    /* renamed from: com.facebook.f$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0918a {
        /* renamed from: a */
        void m10852a();
    }

    /* renamed from: j */
    public static String m10867j() {
        return "5.13.0";
    }

    @Deprecated
    /* renamed from: a */
    public static synchronized void m10883a(Context context) {
        synchronized (FacebookSdk.class) {
            m10882a(context, (InterfaceC0918a) null);
        }
    }

    @Deprecated
    /* renamed from: a */
    public static synchronized void m10882a(final Context context, final InterfaceC0918a interfaceC0918a) {
        synchronized (FacebookSdk.class) {
            if (f1856q.booleanValue()) {
                if (interfaceC0918a != null) {
                    interfaceC0918a.m10852a();
                }
                return;
            }
            Validate.m10469a(context, "applicationContext");
            Validate.m10464b(context, false);
            Validate.m10470a(context, false);
            f1852m = context.getApplicationContext();
            AppEventsLogger.m11285b(context);
            m10875c(f1852m);
            if (Utility.m10530a(f1843d)) {
                throw new FacebookException("A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.");
            }
            f1856q = true;
            if (m10862o()) {
                m10876c();
            }
            if ((f1852m instanceof Application) && UserSettingsManager.m10218c()) {
                ActivityLifecycleTracker.m11041a((Application) f1852m, f1843d);
            }
            FetchedAppSettingsManager.m10809a();
            NativeProtocol.m10589b();
            BoltsMeasurementEventListener.m10822a(f1852m);
            f1851l = new LockOnGetVariable<>(new Callable<File>() { // from class: com.facebook.f.1
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public File call() throws Exception {
                    return FacebookSdk.f1852m.getCacheDir();
                }
            });
            FeatureManager.m10812a(FeatureManager.Feature.Instrument, new FeatureManager.InterfaceC0926a() { // from class: com.facebook.f.2
                @Override // com.facebook.internal.FeatureManager.InterfaceC0926a
                /* renamed from: a */
                public void mo10784a(boolean z) {
                    if (z) {
                        InstrumentManager.m10785a();
                    }
                }
            });
            FeatureManager.m10812a(FeatureManager.Feature.AppEvents, new FeatureManager.InterfaceC0926a() { // from class: com.facebook.f.3
                @Override // com.facebook.internal.FeatureManager.InterfaceC0926a
                /* renamed from: a */
                public void mo10784a(boolean z) {
                    if (z) {
                        AppEventsManager.m11064a();
                    }
                }
            });
            m10871f().execute(new FutureTask(new Callable<Void>() { // from class: com.facebook.f.4
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Void call() throws Exception {
                    AccessTokenManager.m10905a().m10894c();
                    ProfileManager.m10403a().m10398c();
                    if (AccessToken.m11451b() && Profile.m11320a() == null) {
                        Profile.m11318b();
                    }
                    InterfaceC0918a interfaceC0918a2 = InterfaceC0918a.this;
                    if (interfaceC0918a2 != null) {
                        interfaceC0918a2.m10852a();
                    }
                    AppEventsLogger.m11289a(FacebookSdk.f1852m, FacebookSdk.f1843d);
                    AppEventsLogger.m11290a(context.getApplicationContext()).m11286b();
                    return null;
                }
            }));
        }
    }

    /* renamed from: a */
    public static synchronized boolean m10885a() {
        boolean booleanValue;
        synchronized (FacebookSdk.class) {
            booleanValue = f1856q.booleanValue();
        }
        return booleanValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* renamed from: b */
    public static synchronized boolean m10879b() {
        boolean booleanValue;
        synchronized (FacebookSdk.class) {
            booleanValue = f1857r.booleanValue();
        }
        return booleanValue;
    }

    /* renamed from: c */
    public static void m10876c() {
        f1857r = true;
    }

    /* renamed from: a */
    public static boolean m10880a(LoggingBehavior loggingBehavior) {
        boolean z;
        synchronized (f1841b) {
            z = m10874d() && f1841b.contains(loggingBehavior);
        }
        return z;
    }

    /* renamed from: d */
    public static boolean m10874d() {
        return f1849j;
    }

    /* renamed from: e */
    public static boolean m10872e() {
        return f1850k;
    }

    /* renamed from: f */
    public static Executor m10871f() {
        synchronized (f1854o) {
            if (f1842c == null) {
                f1842c = AsyncTask.THREAD_POOL_EXECUTOR;
            }
        }
        return f1842c;
    }

    /* renamed from: g */
    public static String m10870g() {
        return f1847h;
    }

    /* renamed from: h */
    public static Context m10869h() {
        Validate.m10472a();
        return f1852m;
    }

    /* renamed from: i */
    public static String m10868i() {
        Utility.m10505b(f1840a, String.format("getGraphApiVersion: %s", f1855p));
        return f1855p;
    }

    /* renamed from: a */
    public static void m10881a(Context context, final String str) {
        final Context applicationContext = context.getApplicationContext();
        m10871f().execute(new Runnable() { // from class: com.facebook.f.5
            @Override // java.lang.Runnable
            public void run() {
                FacebookSdk.m10877b(applicationContext, str);
            }
        });
    }

    /* renamed from: b */
    static void m10877b(Context context, String str) {
        try {
            if (context == null || str == null) {
                throw new IllegalArgumentException("Both context and applicationId must be non-null");
            }
            AttributionIdentifiers m10751b = AttributionIdentifiers.m10751b(context);
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.attributionTracking", 0);
            String str2 = str + "ping";
            long j = sharedPreferences.getLong(str2, 0L);
            try {
                GraphRequest m11394a = GraphRequest.m11394a((AccessToken) null, String.format("%s/activities", str), AppEventsLoggerUtility.m11044a(AppEventsLoggerUtility.GraphAPIActivityType.MOBILE_INSTALL_EVENT, m10751b, AppEventsLogger.m11285b(context), m10878b(context), context), (GraphRequest.InterfaceC0829b) null);
                if (j == 0 && m11394a.m11349i().m10831a() == null) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putLong(str2, System.currentTimeMillis());
                    edit.apply();
                }
            } catch (JSONException e) {
                throw new FacebookException("An error occurred while publishing install.", e);
            }
        } catch (Exception e2) {
            Utility.m10528a("Facebook-publish", e2);
        }
    }

    /* renamed from: b */
    public static boolean m10878b(Context context) {
        Validate.m10472a();
        return context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("limitEventUsage", false);
    }

    /* renamed from: k */
    public static long m10866k() {
        Validate.m10472a();
        return f1848i.get();
    }

    /* renamed from: c */
    static void m10875c(Context context) {
        if (context == null) {
            return;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return;
            }
            if (f1843d == null) {
                Object obj = applicationInfo.metaData.get("com.facebook.sdk.ApplicationId");
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (str.toLowerCase(Locale.ROOT).startsWith("fb")) {
                        f1843d = str.substring(2);
                    } else {
                        f1843d = str;
                    }
                } else if (obj instanceof Integer) {
                    throw new FacebookException("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
                }
            }
            if (f1844e == null) {
                f1844e = applicationInfo.metaData.getString("com.facebook.sdk.ApplicationName");
            }
            if (f1845f == null) {
                f1845f = applicationInfo.metaData.getString("com.facebook.sdk.ClientToken");
            }
            if (f1853n == 64206) {
                f1853n = applicationInfo.metaData.getInt("com.facebook.sdk.CallbackOffset", 64206);
            }
            if (f1846g == null) {
                f1846g = Boolean.valueOf(applicationInfo.metaData.getBoolean("com.facebook.sdk.CodelessDebugLogEnabled", false));
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    /* renamed from: d */
    public static String m10873d(Context context) {
        PackageManager packageManager;
        Validate.m10472a();
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 64);
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null || signatureArr.length == 0) {
                return null;
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                messageDigest.update(packageInfo.signatures[0].toByteArray());
                return Base64.encodeToString(messageDigest.digest(), 9);
            } catch (NoSuchAlgorithmException unused) {
                return null;
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            return null;
        }
    }

    /* renamed from: l */
    public static String m10865l() {
        Validate.m10472a();
        return f1843d;
    }

    @Nullable
    /* renamed from: m */
    public static String m10864m() {
        Validate.m10472a();
        return f1844e;
    }

    /* renamed from: n */
    public static String m10863n() {
        Validate.m10472a();
        return f1845f;
    }

    /* renamed from: o */
    public static boolean m10862o() {
        return UserSettingsManager.m10220b();
    }

    /* renamed from: p */
    public static boolean m10861p() {
        return UserSettingsManager.m10218c();
    }

    /* renamed from: q */
    public static boolean m10860q() {
        return UserSettingsManager.m10214e();
    }

    /* renamed from: r */
    public static boolean m10859r() {
        return UserSettingsManager.m10216d();
    }

    /* renamed from: s */
    public static File m10858s() {
        Validate.m10472a();
        return f1851l.m10642a();
    }

    /* renamed from: t */
    public static int m10857t() {
        Validate.m10472a();
        return f1853n;
    }

    /* renamed from: a */
    public static boolean m10884a(int i) {
        int i2 = f1853n;
        return i >= i2 && i < i2 + 100;
    }
}
