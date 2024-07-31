package com.twitter.sdk.android.core;

import android.content.Context;
import java.util.concurrent.ExecutorService;

/* renamed from: com.twitter.sdk.android.core.o */
/* loaded from: classes2.dex */
public class TwitterConfig {

    /* renamed from: a */
    final Context f8800a;

    /* renamed from: b */
    final InterfaceC2645h f8801b;

    /* renamed from: c */
    final TwitterAuthConfig f8802c;

    /* renamed from: d */
    final ExecutorService f8803d;

    /* renamed from: e */
    final Boolean f8804e;

    private TwitterConfig(Context context, InterfaceC2645h interfaceC2645h, TwitterAuthConfig twitterAuthConfig, ExecutorService executorService, Boolean bool) {
        this.f8800a = context;
        this.f8801b = interfaceC2645h;
        this.f8802c = twitterAuthConfig;
        this.f8803d = executorService;
        this.f8804e = bool;
    }

    /* compiled from: TwitterConfig.java */
    /* renamed from: com.twitter.sdk.android.core.o$a */
    /* loaded from: classes2.dex */
    public static class C2693a {

        /* renamed from: a */
        private final Context f8805a;

        /* renamed from: b */
        private InterfaceC2645h f8806b;

        /* renamed from: c */
        private TwitterAuthConfig f8807c;

        /* renamed from: d */
        private ExecutorService f8808d;

        /* renamed from: e */
        private Boolean f8809e;

        public C2693a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.f8805a = context.getApplicationContext();
        }

        /* renamed from: a */
        public C2693a m4232a(InterfaceC2645h interfaceC2645h) {
            if (interfaceC2645h == null) {
                throw new IllegalArgumentException("Logger must not be null.");
            }
            this.f8806b = interfaceC2645h;
            return this;
        }

        /* renamed from: a */
        public C2693a m4233a(TwitterAuthConfig twitterAuthConfig) {
            if (twitterAuthConfig == null) {
                throw new IllegalArgumentException("TwitterAuthConfig must not be null.");
            }
            this.f8807c = twitterAuthConfig;
            return this;
        }

        /* renamed from: a */
        public C2693a m4231a(boolean z) {
            this.f8809e = Boolean.valueOf(z);
            return this;
        }

        /* renamed from: a */
        public TwitterConfig m4234a() {
            return new TwitterConfig(this.f8805a, this.f8806b, this.f8807c, this.f8808d, this.f8809e);
        }
    }
}
