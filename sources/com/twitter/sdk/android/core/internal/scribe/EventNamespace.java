package com.twitter.sdk.android.core.internal.scribe;

import com.google.gson.annotations.SerializedName;

/* renamed from: com.twitter.sdk.android.core.internal.scribe.e */
/* loaded from: classes2.dex */
public class EventNamespace {
    @SerializedName("client")

    /* renamed from: a */
    public final String f8601a;
    @SerializedName("page")

    /* renamed from: b */
    public final String f8602b;
    @SerializedName("section")

    /* renamed from: c */
    public final String f8603c;
    @SerializedName("component")

    /* renamed from: d */
    public final String f8604d;
    @SerializedName("element")

    /* renamed from: e */
    public final String f8605e;
    @SerializedName("action")

    /* renamed from: f */
    public final String f8606f;

    public EventNamespace(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f8601a = str;
        this.f8602b = str2;
        this.f8603c = str3;
        this.f8604d = str4;
        this.f8605e = str5;
        this.f8606f = str6;
    }

    public String toString() {
        return "client=" + this.f8601a + ", page=" + this.f8602b + ", section=" + this.f8603c + ", component=" + this.f8604d + ", element=" + this.f8605e + ", action=" + this.f8606f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EventNamespace eventNamespace = (EventNamespace) obj;
        String str = this.f8606f;
        if (str == null ? eventNamespace.f8606f == null : str.equals(eventNamespace.f8606f)) {
            String str2 = this.f8601a;
            if (str2 == null ? eventNamespace.f8601a == null : str2.equals(eventNamespace.f8601a)) {
                String str3 = this.f8604d;
                if (str3 == null ? eventNamespace.f8604d == null : str3.equals(eventNamespace.f8604d)) {
                    String str4 = this.f8605e;
                    if (str4 == null ? eventNamespace.f8605e == null : str4.equals(eventNamespace.f8605e)) {
                        String str5 = this.f8602b;
                        if (str5 == null ? eventNamespace.f8602b == null : str5.equals(eventNamespace.f8602b)) {
                            String str6 = this.f8603c;
                            return str6 == null ? eventNamespace.f8603c == null : str6.equals(eventNamespace.f8603c);
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f8601a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f8602b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f8603c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f8604d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f8605e;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.f8606f;
        return hashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    /* compiled from: EventNamespace.java */
    /* renamed from: com.twitter.sdk.android.core.internal.scribe.e$a */
    /* loaded from: classes2.dex */
    public static class C2678a {

        /* renamed from: a */
        private String f8607a;

        /* renamed from: b */
        private String f8608b;

        /* renamed from: c */
        private String f8609c;

        /* renamed from: d */
        private String f8610d;

        /* renamed from: e */
        private String f8611e;

        /* renamed from: f */
        private String f8612f;

        /* renamed from: a */
        public C2678a m4347a(String str) {
            this.f8607a = str;
            return this;
        }

        /* renamed from: b */
        public C2678a m4346b(String str) {
            this.f8608b = str;
            return this;
        }

        /* renamed from: c */
        public C2678a m4345c(String str) {
            this.f8609c = str;
            return this;
        }

        /* renamed from: d */
        public C2678a m4344d(String str) {
            this.f8610d = str;
            return this;
        }

        /* renamed from: e */
        public C2678a m4343e(String str) {
            this.f8611e = str;
            return this;
        }

        /* renamed from: f */
        public C2678a m4342f(String str) {
            this.f8612f = str;
            return this;
        }

        /* renamed from: a */
        public EventNamespace m4348a() {
            return new EventNamespace(this.f8607a, this.f8608b, this.f8609c, this.f8610d, this.f8611e, this.f8612f);
        }
    }
}
