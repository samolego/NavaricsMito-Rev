package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.twitter.sdk.android.core.GuestSessionProvider;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.internal.ExecutorUtils;
import com.twitter.sdk.android.core.internal.IdManager;
import com.twitter.sdk.android.core.internal.scribe.ScribeEvent;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* renamed from: com.twitter.sdk.android.core.internal.scribe.a */
/* loaded from: classes2.dex */
public class DefaultScribeClient extends ScribeClient {

    /* renamed from: b */
    private static volatile ScheduledExecutorService f8591b;

    /* renamed from: c */
    private final SessionManager<? extends Session<TwitterAuthToken>> f8592c;

    /* renamed from: d */
    private final String f8593d;

    /* renamed from: e */
    private final Context f8594e;

    public DefaultScribeClient(Context context, SessionManager<? extends Session<TwitterAuthToken>> sessionManager, GuestSessionProvider guestSessionProvider, IdManager idManager, ScribeConfig scribeConfig) {
        this(context, TwitterCore.m4230a().m4227c(), sessionManager, guestSessionProvider, idManager, scribeConfig);
    }

    DefaultScribeClient(Context context, TwitterAuthConfig twitterAuthConfig, SessionManager<? extends Session<TwitterAuthToken>> sessionManager, GuestSessionProvider guestSessionProvider, IdManager idManager, ScribeConfig scribeConfig) {
        super(context, m4354d(), scribeConfig, new ScribeEvent.C2687a(m4356c()), twitterAuthConfig, sessionManager, guestSessionProvider, idManager);
        this.f8594e = context;
        this.f8592c = sessionManager;
        this.f8593d = idManager.m4436c();
    }

    /* renamed from: a */
    public void m4359a(EventNamespace... eventNamespaceArr) {
        for (EventNamespace eventNamespace : eventNamespaceArr) {
            m4363a(eventNamespace, Collections.emptyList());
        }
    }

    /* renamed from: a */
    public void m4363a(EventNamespace eventNamespace, List<ScribeItem> list) {
        m4362a(ScribeEventFactory.m4275a(eventNamespace, "", System.currentTimeMillis(), m4358b(), this.f8593d, list));
    }

    /* renamed from: a */
    public void m4362a(ScribeEvent scribeEvent) {
        super.m4281a(scribeEvent, m4361a(m4364a()));
    }

    /* renamed from: a */
    Session m4364a() {
        return this.f8592c.mo4266b();
    }

    /* renamed from: a */
    long m4361a(Session session) {
        if (session != null) {
            return session.m4269b();
        }
        return 0L;
    }

    /* renamed from: b */
    private String m4358b() {
        return this.f8594e.getResources().getConfiguration().locale.getLanguage();
    }

    /* renamed from: c */
    private static Gson m4356c() {
        return new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
    }

    /* renamed from: d */
    private static ScheduledExecutorService m4354d() {
        if (f8591b == null) {
            synchronized (DefaultScribeClient.class) {
                if (f8591b == null) {
                    f8591b = ExecutorUtils.m4441b("scribe");
                }
            }
        }
        return f8591b;
    }

    /* renamed from: a */
    public static ScribeConfig m4360a(String str, String str2) {
        return new ScribeConfig(m4353e(), m4355c("https://syndication.twitter.com", ""), "i", "sdk", "", m4357b(str, str2), 100, IjkMediaCodecInfo.RANK_LAST_CHANCE);
    }

    /* renamed from: e */
    private static boolean m4353e() {
        return !"release".equals("debug");
    }

    /* renamed from: b */
    static String m4357b(String str, String str2) {
        return "TwitterKit/3.0 (Android " + Build.VERSION.SDK_INT + ") " + str + "/" + str2;
    }

    /* renamed from: c */
    static String m4355c(String str, String str2) {
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }
}
