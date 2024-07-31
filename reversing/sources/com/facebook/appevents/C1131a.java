package com.facebook.appevents;

import android.preference.PreferenceManager;
import android.util.Log;
import com.facebook.FacebookSdk;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: com.facebook.appevents.a */
/* loaded from: classes.dex */
class AnalyticsUserIDStore {

    /* renamed from: a */
    private static final String f1531a = "a";

    /* renamed from: c */
    private static String f1533c;

    /* renamed from: b */
    private static ReentrantReadWriteLock f1532b = new ReentrantReadWriteLock();

    /* renamed from: d */
    private static volatile boolean f1534d = false;

    AnalyticsUserIDStore() {
    }

    /* renamed from: a */
    public static void m11282a() {
        if (f1534d) {
            return;
        }
        InternalAppEventsLogger.m11052c().execute(new Runnable() { // from class: com.facebook.appevents.a.1
            @Override // java.lang.Runnable
            public void run() {
                AnalyticsUserIDStore.m11279d();
            }
        });
    }

    /* renamed from: b */
    public static String m11281b() {
        if (!f1534d) {
            Log.w(f1531a, "initStore should have been called before calling setUserID");
            m11279d();
        }
        f1532b.readLock().lock();
        try {
            return f1533c;
        } finally {
            f1532b.readLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static void m11279d() {
        if (f1534d) {
            return;
        }
        f1532b.writeLock().lock();
        try {
            if (f1534d) {
                return;
            }
            f1533c = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.m10869h()).getString("com.facebook.appevents.AnalyticsUserIDStore.userID", null);
            f1534d = true;
        } finally {
            f1532b.writeLock().unlock();
        }
    }
}
