package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import com.twitter.sdk.android.core.GuestSessionProvider;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.internal.CommonUtils;
import com.twitter.sdk.android.core.internal.IdManager;
import com.twitter.sdk.android.core.internal.SystemCurrentTimeProvider;
import com.twitter.sdk.android.core.internal.p079b.FileStoreImpl;
import com.twitter.sdk.android.core.internal.scribe.ScribeEvent;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.twitter.sdk.android.core.internal.scribe.q */
/* loaded from: classes2.dex */
public class ScribeClient {

    /* renamed from: a */
    final ConcurrentHashMap<Long, ScribeHandler> f8652a = new ConcurrentHashMap<>(2);

    /* renamed from: b */
    private final Context f8653b;

    /* renamed from: c */
    private final ScheduledExecutorService f8654c;

    /* renamed from: d */
    private final ScribeConfig f8655d;

    /* renamed from: e */
    private final ScribeEvent.C2687a f8656e;

    /* renamed from: f */
    private final TwitterAuthConfig f8657f;

    /* renamed from: g */
    private final SessionManager<? extends Session<TwitterAuthToken>> f8658g;

    /* renamed from: h */
    private final GuestSessionProvider f8659h;

    /* renamed from: i */
    private final IdManager f8660i;

    public ScribeClient(Context context, ScheduledExecutorService scheduledExecutorService, ScribeConfig scribeConfig, ScribeEvent.C2687a c2687a, TwitterAuthConfig twitterAuthConfig, SessionManager<? extends Session<TwitterAuthToken>> sessionManager, GuestSessionProvider guestSessionProvider, IdManager idManager) {
        this.f8653b = context;
        this.f8654c = scheduledExecutorService;
        this.f8655d = scribeConfig;
        this.f8656e = c2687a;
        this.f8657f = twitterAuthConfig;
        this.f8658g = sessionManager;
        this.f8659h = guestSessionProvider;
        this.f8660i = idManager;
    }

    /* renamed from: a */
    public boolean m4281a(ScribeEvent scribeEvent, long j) {
        try {
            m4283a(j).m4273a(scribeEvent);
            return true;
        } catch (IOException e) {
            CommonUtils.m4452a(this.f8653b, "Failed to scribe event", e);
            return false;
        }
    }

    /* renamed from: a */
    ScribeHandler m4283a(long j) throws IOException {
        if (!this.f8652a.containsKey(Long.valueOf(j))) {
            this.f8652a.putIfAbsent(Long.valueOf(j), m4278d(j));
        }
        return this.f8652a.get(Long.valueOf(j));
    }

    /* renamed from: d */
    private ScribeHandler m4278d(long j) throws IOException {
        Context context = this.f8653b;
        ScribeFilesManager scribeFilesManager = new ScribeFilesManager(this.f8653b, this.f8656e, new SystemCurrentTimeProvider(), new QueueFileEventStorage(context, new FileStoreImpl(context).m4483a(), m4280b(j), m4279c(j)), this.f8655d.f8667g);
        return new ScribeHandler(this.f8653b, m4282a(j, scribeFilesManager), scribeFilesManager, this.f8654c);
    }

    /* renamed from: a */
    EventsStrategy<ScribeEvent> m4282a(long j, ScribeFilesManager scribeFilesManager) {
        if (this.f8655d.f8661a) {
            CommonUtils.m4454a(this.f8653b, "Scribe enabled");
            Context context = this.f8653b;
            ScheduledExecutorService scheduledExecutorService = this.f8654c;
            ScribeConfig scribeConfig = this.f8655d;
            return new EnabledScribeStrategy(context, scheduledExecutorService, scribeFilesManager, scribeConfig, new ScribeFilesSender(context, scribeConfig, j, this.f8657f, this.f8658g, this.f8659h, scheduledExecutorService, this.f8660i));
        }
        CommonUtils.m4454a(this.f8653b, "Scribe disabled");
        return new DisabledEventsStrategy();
    }

    /* renamed from: b */
    String m4280b(long j) {
        return j + "_se.tap";
    }

    /* renamed from: c */
    String m4279c(long j) {
        return j + "_se_to_send";
    }
}
