package com.twitter.sdk.android.core.services.params;

/* loaded from: classes2.dex */
public class Geocode {

    /* renamed from: a */
    public final double f8864a;

    /* renamed from: b */
    public final double f8865b;

    /* renamed from: c */
    public final int f8866c;

    /* renamed from: d */
    public final Distance f8867d;

    /* loaded from: classes2.dex */
    public enum Distance {
        MILES("mi"),
        KILOMETERS("km");

        public final String identifier;

        Distance(String str) {
            this.identifier = str;
        }
    }

    public String toString() {
        return this.f8864a + "," + this.f8865b + "," + this.f8866c + this.f8867d.identifier;
    }
}