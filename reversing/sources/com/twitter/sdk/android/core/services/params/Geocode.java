package com.twitter.sdk.android.core.services.params;

/* loaded from: classes2.dex */
public class Geocode {

    /* renamed from: a */
    public final double f8824a;

    /* renamed from: b */
    public final double f8825b;

    /* renamed from: c */
    public final int f8826c;

    /* renamed from: d */
    public final Distance f8827d;

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
        return this.f8824a + "," + this.f8825b + "," + this.f8826c + this.f8827d.identifier;
    }
}
