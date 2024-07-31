package com.twitter.sdk.android.core;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.twitter.sdk.android.core.internal.oauth.GuestAuthToken;
import com.twitter.sdk.android.core.internal.p079b.SerializationStrategy;

/* renamed from: com.twitter.sdk.android.core.e */
/* loaded from: classes2.dex */
public class GuestSession extends Session<GuestAuthToken> {
    public GuestSession(GuestAuthToken guestAuthToken) {
        super(guestAuthToken, 0L);
    }

    /* compiled from: GuestSession.java */
    /* renamed from: com.twitter.sdk.android.core.e$a */
    /* loaded from: classes2.dex */
    public static class C2642a implements SerializationStrategy<GuestSession> {

        /* renamed from: a */
        private final Gson f8440a = new GsonBuilder().registerTypeAdapter(GuestAuthToken.class, new AuthTokenAdapter()).create();

        @Override // com.twitter.sdk.android.core.internal.p079b.SerializationStrategy
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public String mo4216a(GuestSession guestSession) {
            if (guestSession == null || guestSession.m4270a() == null) {
                return "";
            }
            try {
                return this.f8440a.toJson(guestSession);
            } catch (Exception e) {
                InterfaceC2645h m4253h = Twitter.m4253h();
                m4253h.mo4561a("Twitter", "Failed to serialize session " + e.getMessage());
                return "";
            }
        }

        @Override // com.twitter.sdk.android.core.internal.p079b.SerializationStrategy
        /* renamed from: a */
        public GuestSession mo4214b(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return (GuestSession) this.f8440a.fromJson(str, (Class<Object>) GuestSession.class);
            } catch (Exception e) {
                InterfaceC2645h m4253h = Twitter.m4253h();
                m4253h.mo4561a("Twitter", "Failed to deserialize session " + e.getMessage());
                return null;
            }
        }
    }
}
