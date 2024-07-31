package com.facebook.appevents;

import android.content.Intent;
import android.os.Bundle;
import android.support.p008v4.content.LocalBroadcastManager;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.facebook.appevents.c */
/* loaded from: classes.dex */
public class AppEventQueue {

    /* renamed from: a */
    private static final String f1561a = "com.facebook.appevents.c";

    /* renamed from: d */
    private static ScheduledFuture f1564d;

    /* renamed from: b */
    private static volatile AppEventCollection f1562b = new AppEventCollection();

    /* renamed from: c */
    private static final ScheduledExecutorService f1563c = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: e */
    private static final Runnable f1565e = new Runnable() { // from class: com.facebook.appevents.c.1
        @Override // java.lang.Runnable
        public void run() {
            ScheduledFuture unused = AppEventQueue.f1564d = null;
            if (AppEventsLogger.m11292a() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
                AppEventQueue.m11229b(FlushReason.TIMER);
            }
        }
    };

    AppEventQueue() {
    }

    /* renamed from: a */
    public static void m11239a() {
        f1563c.execute(new Runnable() { // from class: com.facebook.appevents.c.2
            @Override // java.lang.Runnable
            public void run() {
                AppEventStore.m11087a(AppEventQueue.f1562b);
                AppEventCollection unused = AppEventQueue.f1562b = new AppEventCollection();
            }
        });
    }

    /* renamed from: a */
    public static void m11235a(final FlushReason flushReason) {
        f1563c.execute(new Runnable() { // from class: com.facebook.appevents.c.3
            @Override // java.lang.Runnable
            public void run() {
                AppEventQueue.m11229b(FlushReason.this);
            }
        });
    }

    /* renamed from: a */
    public static void m11237a(final AccessTokenAppIdPair accessTokenAppIdPair, final AppEvent appEvent) {
        f1563c.execute(new Runnable() { // from class: com.facebook.appevents.c.4
            @Override // java.lang.Runnable
            public void run() {
                AppEventQueue.f1562b.m11252a(AccessTokenAppIdPair.this, appEvent);
                if (AppEventsLogger.m11292a() == AppEventsLogger.FlushBehavior.EXPLICIT_ONLY || AppEventQueue.f1562b.m11250b() <= 100) {
                    if (AppEventQueue.f1564d == null) {
                        ScheduledFuture unused = AppEventQueue.f1564d = AppEventQueue.f1563c.schedule(AppEventQueue.f1565e, 15L, TimeUnit.SECONDS);
                        return;
                    }
                    return;
                }
                AppEventQueue.m11229b(FlushReason.EVENT_THRESHOLD);
            }
        });
    }

    /* renamed from: b */
    public static Set<AccessTokenAppIdPair> m11231b() {
        return f1562b.m11254a();
    }

    /* renamed from: b */
    static void m11229b(FlushReason flushReason) {
        f1562b.m11251a(AppEventStore.m11090a());
        try {
            FlushStatistics m11234a = m11234a(flushReason, f1562b);
            if (m11234a != null) {
                Intent intent = new Intent("com.facebook.sdk.APP_EVENTS_FLUSHED");
                intent.putExtra("com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED", m11234a.f1708a);
                intent.putExtra("com.facebook.sdk.APP_EVENTS_FLUSH_RESULT", m11234a.f1709b);
                LocalBroadcastManager.getInstance(FacebookSdk.m10869h()).sendBroadcast(intent);
            }
        } catch (Exception e) {
            Log.w(f1561a, "Caught unexpected exception while flushing app events: ", e);
        }
    }

    /* renamed from: a */
    private static FlushStatistics m11234a(FlushReason flushReason, AppEventCollection appEventCollection) {
        FlushStatistics flushStatistics = new FlushStatistics();
        boolean m10878b = FacebookSdk.m10878b(FacebookSdk.m10869h());
        ArrayList<GraphRequest> arrayList = new ArrayList();
        for (AccessTokenAppIdPair accessTokenAppIdPair : appEventCollection.m11254a()) {
            GraphRequest m11236a = m11236a(accessTokenAppIdPair, appEventCollection.m11253a(accessTokenAppIdPair), m10878b, flushStatistics);
            if (m11236a != null) {
                arrayList.add(m11236a);
            }
        }
        if (arrayList.size() > 0) {
            Logger.m10633a(LoggingBehavior.APP_EVENTS, f1561a, "Flushing %d events due to %s.", Integer.valueOf(flushStatistics.f1708a), flushReason.toString());
            for (GraphRequest graphRequest : arrayList) {
                graphRequest.m11349i();
            }
            return flushStatistics;
        }
        return null;
    }

    /* renamed from: a */
    private static GraphRequest m11236a(final AccessTokenAppIdPair accessTokenAppIdPair, final SessionEventsState sessionEventsState, boolean z, final FlushStatistics flushStatistics) {
        String applicationId = accessTokenAppIdPair.getApplicationId();
        FetchedAppSettings m10806a = FetchedAppSettingsManager.m10806a(applicationId, false);
        final GraphRequest m11394a = GraphRequest.m11394a((AccessToken) null, String.format("%s/activities", applicationId), (JSONObject) null, (GraphRequest.InterfaceC0829b) null);
        Bundle m11358e = m11394a.m11358e();
        if (m11358e == null) {
            m11358e = new Bundle();
        }
        m11358e.putString("access_token", accessTokenAppIdPair.getAccessTokenString());
        String m11051d = InternalAppEventsLogger.m11051d();
        if (m11051d != null) {
            m11358e.putString("device_token", m11051d);
        }
        String m11068e = AppEventsLoggerImpl.m11068e();
        if (m11068e != null) {
            m11358e.putString("install_referrer", m11068e);
        }
        m11394a.m11397a(m11358e);
        int m11048a = sessionEventsState.m11048a(m11394a, FacebookSdk.m10869h(), m10806a != null ? m10806a.m10692a() : false, z);
        if (m11048a == 0) {
            return null;
        }
        flushStatistics.f1708a += m11048a;
        m11394a.m11393a(new GraphRequest.InterfaceC0829b() { // from class: com.facebook.appevents.c.5
            @Override // com.facebook.GraphRequest.InterfaceC0829b
            /* renamed from: a */
            public void mo10080a(GraphResponse graphResponse) {
                AppEventQueue.m11230b(AccessTokenAppIdPair.this, m11394a, graphResponse, sessionEventsState, flushStatistics);
            }
        });
        return m11394a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m11230b(final AccessTokenAppIdPair accessTokenAppIdPair, GraphRequest graphRequest, GraphResponse graphResponse, final SessionEventsState sessionEventsState, FlushStatistics flushStatistics) {
        String str;
        FacebookRequestError m10831a = graphResponse.m10831a();
        String str2 = "Success";
        FlushResult flushResult = FlushResult.SUCCESS;
        if (m10831a != null) {
            if (m10831a.m11408b() == -1) {
                str2 = "Failed: No Connectivity";
                flushResult = FlushResult.NO_CONNECTIVITY;
            } else {
                str2 = String.format("Failed:\n  Response: %s\n  Error %s", graphResponse.toString(), m10831a.toString());
                flushResult = FlushResult.SERVER_ERROR;
            }
        }
        if (FacebookSdk.m10880a(LoggingBehavior.APP_EVENTS)) {
            try {
                str = new JSONArray((String) graphRequest.m11350h()).toString(2);
            } catch (JSONException unused) {
                str = "<Can't encode events for debug logging>";
            }
            Logger.m10633a(LoggingBehavior.APP_EVENTS, f1561a, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", graphRequest.m11398a().toString(), str2, str);
        }
        sessionEventsState.m11046a(m10831a != null);
        if (flushResult == FlushResult.NO_CONNECTIVITY) {
            FacebookSdk.m10871f().execute(new Runnable() { // from class: com.facebook.appevents.c.6
                @Override // java.lang.Runnable
                public void run() {
                    AppEventStore.m11089a(AccessTokenAppIdPair.this, sessionEventsState);
                }
            });
        }
        if (flushResult == FlushResult.SUCCESS || flushStatistics.f1709b == FlushResult.NO_CONNECTIVITY) {
            return;
        }
        flushStatistics.f1709b = flushResult;
    }
}
