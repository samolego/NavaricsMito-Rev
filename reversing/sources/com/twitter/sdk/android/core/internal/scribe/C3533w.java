package com.twitter.sdk.android.core.internal.scribe;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: com.twitter.sdk.android.core.internal.scribe.w */
/* loaded from: classes2.dex */
public class SyndicatedSdkImpressionEvent extends ScribeEvent {
    @SerializedName("external_ids")

    /* renamed from: f */
    public final C2688a f8675f;
    @SerializedName("device_id_created_at")

    /* renamed from: g */
    public final long f8676g;
    @SerializedName(IjkMediaMeta.IJKM_KEY_LANGUAGE)

    /* renamed from: h */
    public final String f8677h;

    public SyndicatedSdkImpressionEvent(EventNamespace eventNamespace, long j, String str, String str2, List<ScribeItem> list) {
        super("syndicated_sdk_impression", eventNamespace, j, list);
        this.f8677h = str;
        this.f8675f = new C2688a(str2);
        this.f8676g = 0L;
    }

    /* compiled from: SyndicatedSdkImpressionEvent.java */
    /* renamed from: com.twitter.sdk.android.core.internal.scribe.w$a */
    /* loaded from: classes2.dex */
    public class C2688a {
        @SerializedName("AD_ID")

        /* renamed from: a */
        public final String f8678a;

        public C2688a(String str) {
            this.f8678a = str;
        }
    }
}
