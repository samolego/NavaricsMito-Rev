package com.twitter.sdk.android.core.internal.scribe;

import android.support.media.ExifInterface;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* renamed from: com.twitter.sdk.android.core.internal.scribe.s */
/* loaded from: classes2.dex */
public class ScribeEvent {
    @SerializedName("event_namespace")

    /* renamed from: a */
    final EventNamespace f8669a;
    @SerializedName("ts")

    /* renamed from: b */
    final String f8670b;
    @SerializedName("format_version")

    /* renamed from: c */
    final String f8671c = ExifInterface.GPS_MEASUREMENT_2D;
    @SerializedName("_category_")

    /* renamed from: d */
    final String f8672d;
    @SerializedName("items")

    /* renamed from: e */
    final List<ScribeItem> f8673e;

    public ScribeEvent(String str, EventNamespace eventNamespace, long j, List<ScribeItem> list) {
        this.f8672d = str;
        this.f8669a = eventNamespace;
        this.f8670b = String.valueOf(j);
        this.f8673e = Collections.unmodifiableList(list);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("event_namespace=");
        sb.append(this.f8669a);
        sb.append(", ts=");
        sb.append(this.f8670b);
        sb.append(", format_version=");
        sb.append(this.f8671c);
        sb.append(", _category_=");
        sb.append(this.f8672d);
        sb.append(", items=");
        sb.append("[" + TextUtils.join(", ", this.f8673e) + "]");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ScribeEvent scribeEvent = (ScribeEvent) obj;
        String str = this.f8672d;
        if (str == null ? scribeEvent.f8672d == null : str.equals(scribeEvent.f8672d)) {
            EventNamespace eventNamespace = this.f8669a;
            if (eventNamespace == null ? scribeEvent.f8669a == null : eventNamespace.equals(scribeEvent.f8669a)) {
                String str2 = this.f8671c;
                if (str2 == null ? scribeEvent.f8671c == null : str2.equals(scribeEvent.f8671c)) {
                    String str3 = this.f8670b;
                    if (str3 == null ? scribeEvent.f8670b == null : str3.equals(scribeEvent.f8670b)) {
                        List<ScribeItem> list = this.f8673e;
                        return list == null ? scribeEvent.f8673e == null : list.equals(scribeEvent.f8673e);
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
        EventNamespace eventNamespace = this.f8669a;
        int hashCode = (eventNamespace != null ? eventNamespace.hashCode() : 0) * 31;
        String str = this.f8670b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f8671c;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f8672d;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<ScribeItem> list = this.f8673e;
        return hashCode4 + (list != null ? list.hashCode() : 0);
    }

    /* compiled from: ScribeEvent.java */
    /* renamed from: com.twitter.sdk.android.core.internal.scribe.s$a */
    /* loaded from: classes2.dex */
    public static class C2687a implements EventTransform<ScribeEvent> {

        /* renamed from: a */
        private final Gson f8674a;

        public C2687a(Gson gson) {
            this.f8674a = gson;
        }

        @Override // com.twitter.sdk.android.core.internal.scribe.EventTransform
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public byte[] mo4276a(ScribeEvent scribeEvent) throws IOException {
            return this.f8674a.toJson(scribeEvent).getBytes("UTF-8");
        }
    }
}
