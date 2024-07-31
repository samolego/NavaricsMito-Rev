package com.twitter.sdk.android.tweetcomposer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.twitter.sdk.android.core.GuestSessionProvider;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.internal.p078a.UrlUtils;
import com.twitter.sdk.android.core.internal.scribe.DefaultScribeClient;
import java.net.URL;

/* renamed from: com.twitter.sdk.android.tweetcomposer.h */
/* loaded from: classes2.dex */
public class TweetComposer {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a */
    static volatile TweetComposer f8866a;

    /* renamed from: e */
    InterfaceC2713e f8870e = new ScribeClientImpl(null);

    /* renamed from: b */
    SessionManager<TwitterSession> f8867b = TwitterCore.m4230a().m4224f();

    /* renamed from: c */
    GuestSessionProvider f8868c = TwitterCore.m4230a().m4223g();

    /* renamed from: d */
    Context f8869d = Twitter.m4260b().m4261a(m4175c());

    /* renamed from: b */
    public String m4176b() {
        return "3.1.1.9";
    }

    /* renamed from: c */
    public String m4175c() {
        return "com.twitter.sdk.android:tweet-composer";
    }

    /* renamed from: a */
    public static TweetComposer m4177a() {
        if (f8866a == null) {
            synchronized (TweetComposer.class) {
                if (f8866a == null) {
                    f8866a = new TweetComposer();
                }
            }
        }
        return f8866a;
    }

    TweetComposer() {
        m4173e();
    }

    /* renamed from: e */
    private void m4173e() {
        this.f8870e = new ScribeClientImpl(new DefaultScribeClient(this.f8869d, this.f8867b, this.f8868c, Twitter.m4260b().m4258c(), DefaultScribeClient.m4360a("TweetComposer", m4176b())));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public InterfaceC2713e m4174d() {
        return this.f8870e;
    }

    /* compiled from: TweetComposer.java */
    /* renamed from: com.twitter.sdk.android.tweetcomposer.h$a */
    /* loaded from: classes2.dex */
    public static class C2714a {

        /* renamed from: a */
        private final Context f8871a;

        /* renamed from: b */
        private String f8872b;

        /* renamed from: c */
        private URL f8873c;

        /* renamed from: d */
        private Uri f8874d;

        public C2714a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.f8871a = context;
        }

        /* renamed from: a */
        public C2714a m4170a(String str) {
            if (str == null) {
                throw new IllegalArgumentException("text must not be null.");
            }
            if (this.f8872b != null) {
                throw new IllegalStateException("text already set.");
            }
            this.f8872b = str;
            return this;
        }

        /* renamed from: a */
        public C2714a m4169a(URL url) {
            if (url == null) {
                throw new IllegalArgumentException("url must not be null.");
            }
            if (this.f8873c != null) {
                throw new IllegalStateException("url already set.");
            }
            this.f8873c = url;
            return this;
        }

        /* renamed from: a */
        public C2714a m4171a(Uri uri) {
            if (uri == null) {
                throw new IllegalArgumentException("imageUri must not be null.");
            }
            if (this.f8874d != null) {
                throw new IllegalStateException("imageUri already set.");
            }
            this.f8874d = uri;
            return this;
        }

        /* renamed from: a */
        public Intent m4172a() {
            Intent m4168b = m4168b();
            return m4168b == null ? m4167c() : m4168b;
        }

        /* renamed from: b */
        Intent m4168b() {
            Intent intent = new Intent("android.intent.action.SEND");
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.f8872b)) {
                sb.append(this.f8872b);
            }
            if (this.f8873c != null) {
                if (sb.length() > 0) {
                    sb.append(' ');
                }
                sb.append(this.f8873c.toString());
            }
            intent.putExtra("android.intent.extra.TEXT", sb.toString());
            intent.setType("text/plain");
            Uri uri = this.f8874d;
            if (uri != null) {
                intent.putExtra("android.intent.extra.STREAM", uri);
                intent.setType("image/jpeg");
            }
            for (ResolveInfo resolveInfo : this.f8871a.getPackageManager().queryIntentActivities(intent, 65536)) {
                if (resolveInfo.activityInfo.packageName.startsWith("com.twitter.android")) {
                    intent.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
                    return intent;
                }
            }
            return null;
        }

        /* renamed from: c */
        Intent m4167c() {
            URL url = this.f8873c;
            return new Intent("android.intent.action.VIEW", Uri.parse(String.format("https://twitter.com/intent/tweet?text=%s&url=%s", UrlUtils.m4488a(this.f8872b), UrlUtils.m4488a(url == null ? "" : url.toString()))));
        }

        /* renamed from: d */
        public void m4166d() {
            this.f8871a.startActivity(m4172a());
        }
    }
}
