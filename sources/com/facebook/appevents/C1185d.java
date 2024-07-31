package com.facebook.appevents;

import android.content.Context;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.Utility;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;

/* renamed from: com.facebook.appevents.d */
/* loaded from: classes.dex */
class AppEventStore {

    /* renamed from: a */
    private static final String f1696a = "com.facebook.appevents.d";

    AppEventStore() {
    }

    /* renamed from: a */
    public static synchronized void m11089a(AccessTokenAppIdPair accessTokenAppIdPair, SessionEventsState sessionEventsState) {
        synchronized (AppEventStore.class) {
            AppEventUtility.m11019a();
            PersistedEvents m11090a = m11090a();
            if (m11090a.containsKey(accessTokenAppIdPair)) {
                m11090a.get(accessTokenAppIdPair).addAll(sessionEventsState.m11045b());
            } else {
                m11090a.addEvents(accessTokenAppIdPair, sessionEventsState.m11045b());
            }
            m11088a(m11090a);
        }
    }

    /* renamed from: a */
    public static synchronized void m11087a(AppEventCollection appEventCollection) {
        synchronized (AppEventStore.class) {
            AppEventUtility.m11019a();
            PersistedEvents m11090a = m11090a();
            for (AccessTokenAppIdPair accessTokenAppIdPair : appEventCollection.m11254a()) {
                m11090a.addEvents(accessTokenAppIdPair, appEventCollection.m11253a(accessTokenAppIdPair).m11045b());
            }
            m11088a(m11090a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008a A[Catch: all -> 0x0091, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:8:0x0021, B:9:0x0024, B:42:0x008a, B:12:0x002f, B:21:0x0045, B:22:0x0048, B:25:0x0053, B:26:0x0057, B:29:0x005e, B:30:0x0061, B:34:0x0073, B:33:0x006c, B:36:0x0075, B:37:0x0078, B:40:0x0083), top: B:49:0x0003, inners: #1, #4, #9, #10 }] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.Throwable, java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.lang.String] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized com.facebook.appevents.PersistedEvents m11090a() {
        /*
            java.lang.Class<com.facebook.appevents.d> r0 = com.facebook.appevents.AppEventStore.class
            monitor-enter(r0)
            com.facebook.appevents.internal.AppEventUtility.m11019a()     // Catch: java.lang.Throwable -> L91
            android.content.Context r1 = com.facebook.FacebookSdk.m10869h()     // Catch: java.lang.Throwable -> L91
            r2 = 0
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.FileInputStream r3 = r1.openFileInput(r3)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c java.io.FileNotFoundException -> L74
            com.facebook.appevents.d$a r4 = new com.facebook.appevents.d$a     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c java.io.FileNotFoundException -> L74
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c java.io.FileNotFoundException -> L74
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c java.io.FileNotFoundException -> L74
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c java.io.FileNotFoundException -> L74
            java.lang.Object r3 = r4.readObject()     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L5b java.io.FileNotFoundException -> L75
            com.facebook.appevents.PersistedEvents r3 = (com.facebook.appevents.PersistedEvents) r3     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L5b java.io.FileNotFoundException -> L75
            com.facebook.internal.Utility.m10538a(r4)     // Catch: java.lang.Throwable -> L91
            java.lang.String r2 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r2)     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L91
            r1.delete()     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L91
            goto L36
        L2e:
            r1 = move-exception
            java.lang.String r2 = com.facebook.appevents.AppEventStore.f1696a     // Catch: java.lang.Throwable -> L91
            java.lang.String r4 = "Got unexpected exception when removing events file: "
            android.util.Log.w(r2, r4, r1)     // Catch: java.lang.Throwable -> L91
        L36:
            r2 = r3
            goto L88
        L38:
            r3 = move-exception
            goto L3e
        L3a:
            r3 = move-exception
            goto L5e
        L3c:
            r3 = move-exception
            r4 = r2
        L3e:
            java.lang.String r5 = com.facebook.appevents.AppEventStore.f1696a     // Catch: java.lang.Throwable -> L5b
            java.lang.String r6 = "Got unexpected exception while reading events: "
            android.util.Log.w(r5, r6, r3)     // Catch: java.lang.Throwable -> L5b
            com.facebook.internal.Utility.m10538a(r4)     // Catch: java.lang.Throwable -> L91
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L91
            r1.delete()     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L91
            goto L88
        L52:
            r1 = move-exception
            java.lang.String r3 = com.facebook.appevents.AppEventStore.f1696a     // Catch: java.lang.Throwable -> L91
            java.lang.String r4 = "Got unexpected exception when removing events file: "
        L57:
            android.util.Log.w(r3, r4, r1)     // Catch: java.lang.Throwable -> L91
            goto L88
        L5b:
            r2 = move-exception
            r3 = r2
            r2 = r4
        L5e:
            com.facebook.internal.Utility.m10538a(r2)     // Catch: java.lang.Throwable -> L91
            java.lang.String r2 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r2)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L91
            r1.delete()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L91
            goto L73
        L6b:
            r1 = move-exception
            java.lang.String r2 = com.facebook.appevents.AppEventStore.f1696a     // Catch: java.lang.Throwable -> L91
            java.lang.String r4 = "Got unexpected exception when removing events file: "
            android.util.Log.w(r2, r4, r1)     // Catch: java.lang.Throwable -> L91
        L73:
            throw r3     // Catch: java.lang.Throwable -> L91
        L74:
            r4 = r2
        L75:
            com.facebook.internal.Utility.m10538a(r4)     // Catch: java.lang.Throwable -> L91
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L91
            r1.delete()     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L91
            goto L88
        L82:
            r1 = move-exception
            java.lang.String r3 = com.facebook.appevents.AppEventStore.f1696a     // Catch: java.lang.Throwable -> L91
            java.lang.String r4 = "Got unexpected exception when removing events file: "
            goto L57
        L88:
            if (r2 != 0) goto L8f
            com.facebook.appevents.PersistedEvents r2 = new com.facebook.appevents.PersistedEvents     // Catch: java.lang.Throwable -> L91
            r2.<init>()     // Catch: java.lang.Throwable -> L91
        L8f:
            monitor-exit(r0)
            return r2
        L91:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventStore.m11090a():com.facebook.appevents.PersistedEvents");
    }

    /* renamed from: a */
    private static void m11088a(PersistedEvents persistedEvents) {
        Context m10869h = FacebookSdk.m10869h();
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new BufferedOutputStream(m10869h.openFileOutput("AppEventsLogger.persistedevents", 0)));
                try {
                    objectOutputStream2.writeObject(persistedEvents);
                    Utility.m10538a(objectOutputStream2);
                } catch (Exception e) {
                    e = e;
                    objectOutputStream = objectOutputStream2;
                    Log.w(f1696a, "Got unexpected exception while persisting events: ", e);
                    try {
                        m10869h.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                    } catch (Exception unused) {
                    }
                    Utility.m10538a(objectOutputStream);
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    Utility.m10538a(objectOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AppEventStore.java */
    /* renamed from: com.facebook.appevents.d$a */
    /* loaded from: classes.dex */
    public static class C0870a extends ObjectInputStream {
        public C0870a(InputStream inputStream) throws IOException {
            super(inputStream);
        }

        @Override // java.io.ObjectInputStream
        protected ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
            ObjectStreamClass readClassDescriptor = super.readClassDescriptor();
            if (readClassDescriptor.getName().equals("com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1")) {
                return ObjectStreamClass.lookup(AccessTokenAppIdPair.SerializationProxyV1.class);
            }
            return readClassDescriptor.getName().equals("com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV1") ? ObjectStreamClass.lookup(AppEvent.SerializationProxyV1.class) : readClassDescriptor;
        }
    }
}
