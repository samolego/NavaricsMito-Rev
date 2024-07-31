package com.twitter.sdk.android.core;

import android.content.Context;
import java.util.concurrent.ExecutorService;

/* compiled from: TwitterConfig.java */
/* renamed from: com.twitter.sdk.android.core.o, reason: use source file name */
/* loaded from: classes2.dex */
public class TwitterConfig {

    /* renamed from: a */
    final Context f8840a;

    /* renamed from: b */
    final InterfaceC2514h f8841b;

    /* renamed from: c */
    final TwitterAuthConfig f8842c;

    /* renamed from: d */
    final ExecutorService f8843d;

    /* renamed from: e */
    final Boolean f8844e;

    private TwitterConfig(Context context, InterfaceC2514h interfaceC2514h, TwitterAuthConfig twitterAuthConfig, ExecutorService executorService, Boolean bool) {
        this.f8840a = context;
        this.f8841b = interfaceC2514h;
        this.f8842c = twitterAuthConfig;
        this.f8843d = executorService;
        this.f8844e = bool;
    }

    /* compiled from: TwitterConfig.java */
    /* renamed from: com.twitter.sdk.android.core.o$a */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a */
        private final Context f8845a;

        /* renamed from: b */
        private InterfaceC2514h f8846b;

        /* renamed from: c */
        private TwitterAuthConfig f8847c;

        /* renamed from: d */
        private ExecutorService f8848d;

        /* renamed from: e */
        private Boolean f8849e;

        public a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.f8845a = context.getApplicationContext();
        }

        /* renamed from: a */
        public a m8622a(InterfaceC2514h interfaceC2514h) {
            if (interfaceC2514h == null) {
                throw new IllegalArgumentException("Logger must not be null.");
            }
            this.f8846b = interfaceC2514h;
            return this;
        }

        /* renamed from: a */
        public a m8621a(TwitterAuthConfig twitterAuthConfig) {
            if (twitterAuthConfig == null) {
                throw new IllegalArgumentException("TwitterAuthConfig must not be null.");
            }
            this.f8847c = twitterAuthConfig;
            return this;
        }

        /* renamed from: a */
        public a m8623a(boolean z) {
            this.f8849e = Boolean.valueOf(z);
            return this;
        }

        /* renamed from: a */
        public TwitterConfig m8624a() {
            return new TwitterConfig(this.f8845a, this.f8846b, this.f8847c, this.f8848d, this.f8849e);
        }
    }
}