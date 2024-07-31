package com.facebook.appevents;

import android.content.Context;
import com.facebook.FacebookSdk;
import com.facebook.internal.AttributionIdentifiers;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.facebook.appevents.b */
/* loaded from: classes.dex */
public class AppEventCollection {

    /* renamed from: a */
    private final HashMap<AccessTokenAppIdPair, SessionEventsState> f1551a = new HashMap<>();

    /* renamed from: a */
    public synchronized void m11251a(PersistedEvents persistedEvents) {
        if (persistedEvents == null) {
            return;
        }
        for (AccessTokenAppIdPair accessTokenAppIdPair : persistedEvents.keySet()) {
            SessionEventsState m11249b = m11249b(accessTokenAppIdPair);
            for (AppEvent appEvent : persistedEvents.get(accessTokenAppIdPair)) {
                m11249b.m11047a(appEvent);
            }
        }
    }

    /* renamed from: a */
    public synchronized void m11252a(AccessTokenAppIdPair accessTokenAppIdPair, AppEvent appEvent) {
        m11249b(accessTokenAppIdPair).m11047a(appEvent);
    }

    /* renamed from: a */
    public synchronized Set<AccessTokenAppIdPair> m11254a() {
        return this.f1551a.keySet();
    }

    /* renamed from: a */
    public synchronized SessionEventsState m11253a(AccessTokenAppIdPair accessTokenAppIdPair) {
        return this.f1551a.get(accessTokenAppIdPair);
    }

    /* renamed from: b */
    public synchronized int m11250b() {
        int i;
        i = 0;
        for (SessionEventsState sessionEventsState : this.f1551a.values()) {
            i += sessionEventsState.m11050a();
        }
        return i;
    }

    /* renamed from: b */
    private synchronized SessionEventsState m11249b(AccessTokenAppIdPair accessTokenAppIdPair) {
        SessionEventsState sessionEventsState;
        sessionEventsState = this.f1551a.get(accessTokenAppIdPair);
        if (sessionEventsState == null) {
            Context m10869h = FacebookSdk.m10869h();
            sessionEventsState = new SessionEventsState(AttributionIdentifiers.m10751b(m10869h), AppEventsLogger.m11285b(m10869h));
        }
        this.f1551a.put(accessTokenAppIdPair, sessionEventsState);
        return sessionEventsState;
    }
}
