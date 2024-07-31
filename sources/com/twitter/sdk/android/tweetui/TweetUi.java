package com.twitter.sdk.android.tweetui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.GuestSessionProvider;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.internal.scribe.DefaultScribeClient;
import com.twitter.sdk.android.core.internal.scribe.EventNamespace;
import com.twitter.sdk.android.core.internal.scribe.ScribeItem;
import java.util.List;

/* renamed from: com.twitter.sdk.android.tweetui.ad */
/* loaded from: classes2.dex */
public class TweetUi {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a */
    static volatile TweetUi f8944a;

    /* renamed from: b */
    SessionManager<TwitterSession> f8945b;

    /* renamed from: c */
    GuestSessionProvider f8946c;

    /* renamed from: d */
    DefaultScribeClient f8947d;

    /* renamed from: e */
    Context f8948e;

    /* renamed from: f */
    private TweetRepository f8949f;

    /* renamed from: g */
    private Picasso f8950g;

    /* renamed from: b */
    public String m4097b() {
        return "com.twitter.sdk.android:tweet-ui";
    }

    /* renamed from: c */
    public String m4096c() {
        return "3.1.1.9";
    }

    /* renamed from: a */
    public static TweetUi m4100a() {
        if (f8944a == null) {
            synchronized (TweetUi.class) {
                if (f8944a == null) {
                    f8944a = new TweetUi();
                }
            }
        }
        return f8944a;
    }

    TweetUi() {
        TwitterCore m4230a = TwitterCore.m4230a();
        this.f8948e = Twitter.m4260b().m4261a(m4097b());
        this.f8945b = m4230a.m4224f();
        this.f8946c = m4230a.m4223g();
        this.f8949f = new TweetRepository(new Handler(Looper.getMainLooper()), m4230a.m4224f());
        this.f8950g = Picasso.m5798a(Twitter.m4260b().m4261a(m4097b()));
        m4093f();
    }

    /* renamed from: f */
    private void m4093f() {
        this.f8947d = new DefaultScribeClient(this.f8948e, this.f8945b, this.f8946c, Twitter.m4260b().m4258c(), DefaultScribeClient.m4360a("TweetUi", m4096c()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m4098a(EventNamespace... eventNamespaceArr) {
        if (this.f8947d == null) {
            return;
        }
        for (EventNamespace eventNamespace : eventNamespaceArr) {
            this.f8947d.m4359a(eventNamespace);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m4099a(EventNamespace eventNamespace, List<ScribeItem> list) {
        DefaultScribeClient defaultScribeClient = this.f8947d;
        if (defaultScribeClient == null) {
            return;
        }
        defaultScribeClient.m4363a(eventNamespace, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public TweetRepository m4095d() {
        return this.f8949f;
    }

    /* renamed from: e */
    public Picasso m4094e() {
        return this.f8950g;
    }
}
