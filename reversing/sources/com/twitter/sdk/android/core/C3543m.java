package com.twitter.sdk.android.core;

import android.annotation.SuppressLint;
import android.content.Context;
import com.twitter.sdk.android.core.internal.ActivityLifecycleManager;
import com.twitter.sdk.android.core.internal.CommonUtils;
import com.twitter.sdk.android.core.internal.ExecutorUtils;
import com.twitter.sdk.android.core.internal.IdManager;
import java.io.File;
import java.util.concurrent.ExecutorService;

/* renamed from: com.twitter.sdk.android.core.m */
/* loaded from: classes2.dex */
public class Twitter {

    /* renamed from: a */
    static final InterfaceC2645h f8692a = new DefaultLogger();
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b */
    static volatile Twitter f8693b;

    /* renamed from: c */
    private final Context f8694c;

    /* renamed from: d */
    private final IdManager f8695d;

    /* renamed from: e */
    private final ExecutorService f8696e;

    /* renamed from: f */
    private final TwitterAuthConfig f8697f;

    /* renamed from: g */
    private final ActivityLifecycleManager f8698g;

    /* renamed from: h */
    private final InterfaceC2645h f8699h;

    /* renamed from: i */
    private final boolean f8700i;

    private Twitter(TwitterConfig twitterConfig) {
        this.f8694c = twitterConfig.f8800a;
        this.f8695d = new IdManager(this.f8694c);
        this.f8698g = new ActivityLifecycleManager(this.f8694c);
        if (twitterConfig.f8802c == null) {
            this.f8697f = new TwitterAuthConfig(CommonUtils.m4445b(this.f8694c, "com.twitter.sdk.android.CONSUMER_KEY", ""), CommonUtils.m4445b(this.f8694c, "com.twitter.sdk.android.CONSUMER_SECRET", ""));
        } else {
            this.f8697f = twitterConfig.f8802c;
        }
        if (twitterConfig.f8803d == null) {
            this.f8696e = ExecutorUtils.m4444a("twitter-worker");
        } else {
            this.f8696e = twitterConfig.f8803d;
        }
        if (twitterConfig.f8801b == null) {
            this.f8699h = f8692a;
        } else {
            this.f8699h = twitterConfig.f8801b;
        }
        if (twitterConfig.f8804e == null) {
            this.f8700i = false;
        } else {
            this.f8700i = twitterConfig.f8804e.booleanValue();
        }
    }

    /* renamed from: a */
    public static void m4262a(TwitterConfig twitterConfig) {
        m4259b(twitterConfig);
    }

    /* renamed from: b */
    static synchronized Twitter m4259b(TwitterConfig twitterConfig) {
        synchronized (Twitter.class) {
            if (f8693b == null) {
                f8693b = new Twitter(twitterConfig);
                return f8693b;
            }
            return f8693b;
        }
    }

    /* renamed from: a */
    static void m4263a() {
        if (f8693b == null) {
            throw new IllegalStateException("Must initialize Twitter before using getInstance()");
        }
    }

    /* renamed from: b */
    public static Twitter m4260b() {
        m4263a();
        return f8693b;
    }

    /* renamed from: a */
    public Context m4261a(String str) {
        Context context = this.f8694c;
        return new TwitterContext(context, str, ".TwitterKit" + File.separator + str);
    }

    /* renamed from: c */
    public IdManager m4258c() {
        return this.f8695d;
    }

    /* renamed from: d */
    public TwitterAuthConfig m4257d() {
        return this.f8697f;
    }

    /* renamed from: e */
    public ExecutorService m4256e() {
        return this.f8696e;
    }

    /* renamed from: f */
    public ActivityLifecycleManager m4255f() {
        return this.f8698g;
    }

    /* renamed from: g */
    public static boolean m4254g() {
        if (f8693b == null) {
            return false;
        }
        return f8693b.f8700i;
    }

    /* renamed from: h */
    public static InterfaceC2645h m4253h() {
        if (f8693b == null) {
            return f8692a;
        }
        return f8693b.f8699h;
    }
}
