package com.twitter.sdk.android.core.internal.scribe;

import com.google.gson.annotations.SerializedName;

/* compiled from: EventNamespace.java */
/* renamed from: com.twitter.sdk.android.core.internal.scribe.e, reason: use source file name */
/* loaded from: classes2.dex */
public class EventNamespace {

    /* renamed from: a */
    @SerializedName("client")
    public final String f8641a;

    /* renamed from: b */
    @SerializedName("page")
    public final String f8642b;

    /* renamed from: c */
    @SerializedName("section")
    public final String f8643c;

    /* renamed from: d */
    @SerializedName("component")
    public final String f8644d;

    /* renamed from: e */
    @SerializedName("element")
    public final String f8645e;

    /* renamed from: f */
    @SerializedName("action")
    public final String f8646f;

    public EventNamespace(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f8641a = str;
        this.f8642b = str2;
        this.f8643c = str3;
        this.f8644d = str4;
        this.f8645e = str5;
        this.f8646f = str6;
    }

    public String toString() {
        return "client=" + this.f8641a + ", page=" + this.f8642b + ", section=" + this.f8643c + ", component=" + this.f8644d + ", element=" + this.f8645e + ", action=" + this.f8646f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EventNamespace eventNamespace = (EventNamespace) obj;
        String str = this.f8646f;
        if (str == null ? eventNamespace.f8646f != null : !str.equals(eventNamespace.f8646f)) {
            return false;
        }
        String str2 = this.f8641a;
        if (str2 == null ? eventNamespace.f8641a != null : !str2.equals(eventNamespace.f8641a)) {
            return false;
        }
        String str3 = this.f8644d;
        if (str3 == null ? eventNamespace.f8644d != null : !str3.equals(eventNamespace.f8644d)) {
            return false;
        }
        String str4 = this.f8645e;
        if (str4 == null ? eventNamespace.f8645e != null : !str4.equals(eventNamespace.f8645e)) {
            return false;
        }
        String str5 = this.f8642b;
        if (str5 == null ? eventNamespace.f8642b != null : !str5.equals(eventNamespace.f8642b)) {
            return false;
        }
        String str6 = this.f8643c;
        return str6 == null ? eventNamespace.f8643c == null : str6.equals(eventNamespace.f8643c);
    }

    public int hashCode() {
        String str = this.f8641a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f8642b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f8643c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f8644d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f8645e;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.f8646f;
        return hashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    /* compiled from: EventNamespace.java */
    /* renamed from: com.twitter.sdk.android.core.internal.scribe.e$a */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a */
        private String f8647a;

        /* renamed from: b */
        private String f8648b;

        /* renamed from: c */
        private String f8649c;

        /* renamed from: d */
        private String f8650d;

        /* renamed from: e */
        private String f8651e;

        /* renamed from: f */
        private String f8652f;

        /* renamed from: a */
        public a m8520a(String str) {
            this.f8647a = str;
            return this;
        }

        /* renamed from: b */
        public a m8522b(String str) {
            this.f8648b = str;
            return this;
        }

        /* renamed from: c */
        public a m8523c(String str) {
            this.f8649c = str;
            return this;
        }

        /* renamed from: d */
        public a m8524d(String str) {
            this.f8650d = str;
            return this;
        }

        /* renamed from: e */
        public a m8525e(String str) {
            this.f8651e = str;
            return this;
        }

        /* renamed from: f */
        public a m8526f(String str) {
            this.f8652f = str;
            return this;
        }

        /* renamed from: a */
        public EventNamespace m8521a() {
            return new EventNamespace(this.f8647a, this.f8648b, this.f8649c, this.f8650d, this.f8651e, this.f8652f);
        }
    }
}