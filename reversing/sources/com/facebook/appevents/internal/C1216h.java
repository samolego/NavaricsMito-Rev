package com.facebook.appevents.internal;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import java.util.UUID;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.facebook.appevents.internal.h */
/* loaded from: classes.dex */
public class SessionInfo {

    /* renamed from: a */
    private Long f1757a;

    /* renamed from: b */
    private Long f1758b;

    /* renamed from: c */
    private int f1759c;

    /* renamed from: d */
    private Long f1760d;

    /* renamed from: e */
    private SourceApplicationInfo f1761e;

    /* renamed from: f */
    private UUID f1762f;

    public SessionInfo(Long l, Long l2) {
        this(l, l2, UUID.randomUUID());
    }

    public SessionInfo(Long l, Long l2, UUID uuid) {
        this.f1757a = l;
        this.f1758b = l2;
        this.f1762f = uuid;
    }

    /* renamed from: a */
    public static SessionInfo m10979a() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.m10869h());
        long j = defaultSharedPreferences.getLong("com.facebook.appevents.SessionInfo.sessionStartTime", 0L);
        long j2 = defaultSharedPreferences.getLong("com.facebook.appevents.SessionInfo.sessionEndTime", 0L);
        String string = defaultSharedPreferences.getString("com.facebook.appevents.SessionInfo.sessionId", null);
        if (j == 0 || j2 == 0 || string == null) {
            return null;
        }
        SessionInfo sessionInfo = new SessionInfo(Long.valueOf(j), Long.valueOf(j2));
        sessionInfo.f1759c = defaultSharedPreferences.getInt("com.facebook.appevents.SessionInfo.interruptionCount", 0);
        sessionInfo.f1761e = SourceApplicationInfo.m10963a();
        sessionInfo.f1760d = Long.valueOf(System.currentTimeMillis());
        sessionInfo.f1762f = UUID.fromString(string);
        return sessionInfo;
    }

    /* renamed from: b */
    public static void m10977b() {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.m10869h()).edit();
        edit.remove("com.facebook.appevents.SessionInfo.sessionStartTime");
        edit.remove("com.facebook.appevents.SessionInfo.sessionEndTime");
        edit.remove("com.facebook.appevents.SessionInfo.interruptionCount");
        edit.remove("com.facebook.appevents.SessionInfo.sessionId");
        edit.apply();
        SourceApplicationInfo.m10962b();
    }

    /* renamed from: c */
    public Long m10976c() {
        return this.f1758b;
    }

    /* renamed from: a */
    public void m10978a(Long l) {
        this.f1758b = l;
    }

    /* renamed from: d */
    public int m10975d() {
        return this.f1759c;
    }

    /* renamed from: e */
    public void m10974e() {
        this.f1759c++;
    }

    /* renamed from: f */
    public long m10973f() {
        Long l = this.f1760d;
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    /* renamed from: g */
    public UUID m10972g() {
        return this.f1762f;
    }

    /* renamed from: h */
    public long m10971h() {
        Long l;
        if (this.f1757a == null || (l = this.f1758b) == null) {
            return 0L;
        }
        return l.longValue() - this.f1757a.longValue();
    }

    /* renamed from: i */
    public SourceApplicationInfo m10970i() {
        return this.f1761e;
    }

    /* renamed from: j */
    public void m10969j() {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.m10869h()).edit();
        edit.putLong("com.facebook.appevents.SessionInfo.sessionStartTime", this.f1757a.longValue());
        edit.putLong("com.facebook.appevents.SessionInfo.sessionEndTime", this.f1758b.longValue());
        edit.putInt("com.facebook.appevents.SessionInfo.interruptionCount", this.f1759c);
        edit.putString("com.facebook.appevents.SessionInfo.sessionId", this.f1762f.toString());
        edit.apply();
        SourceApplicationInfo sourceApplicationInfo = this.f1761e;
        if (sourceApplicationInfo != null) {
            sourceApplicationInfo.m10961c();
        }
    }
}
