package com.twitter.sdk.android.core;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.twitter.sdk.android.core.internal.p079b.SerializationStrategy;

/* renamed from: com.twitter.sdk.android.core.t */
/* loaded from: classes2.dex */
public class TwitterSession extends Session<TwitterAuthToken> {
    @SerializedName("user_name")

    /* renamed from: a */
    private final String f8829a;

    public TwitterSession(TwitterAuthToken twitterAuthToken, long j, String str) {
        super(twitterAuthToken, j);
        this.f8829a = str;
    }

    @Override // com.twitter.sdk.android.core.Session
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && super.equals(obj)) {
            TwitterSession twitterSession = (TwitterSession) obj;
            String str = this.f8829a;
            return str != null ? str.equals(twitterSession.f8829a) : twitterSession.f8829a == null;
        }
        return false;
    }

    @Override // com.twitter.sdk.android.core.Session
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.f8829a;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    /* compiled from: TwitterSession.java */
    /* renamed from: com.twitter.sdk.android.core.t$a */
    /* loaded from: classes2.dex */
    static class C2695a implements SerializationStrategy<TwitterSession> {

        /* renamed from: a */
        private final Gson f8830a = new Gson();

        @Override // com.twitter.sdk.android.core.internal.p079b.SerializationStrategy
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public String mo4216a(TwitterSession twitterSession) {
            if (twitterSession == null || twitterSession.m4270a() == null) {
                return "";
            }
            try {
                return this.f8830a.toJson(twitterSession);
            } catch (Exception e) {
                Twitter.m4253h().mo4561a("Twitter", e.getMessage());
                return "";
            }
        }

        @Override // com.twitter.sdk.android.core.internal.p079b.SerializationStrategy
        /* renamed from: a */
        public TwitterSession mo4214b(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return (TwitterSession) this.f8830a.fromJson(str, (Class<Object>) TwitterSession.class);
            } catch (Exception e) {
                Twitter.m4253h().mo4561a("Twitter", e.getMessage());
                return null;
            }
        }
    }
}
