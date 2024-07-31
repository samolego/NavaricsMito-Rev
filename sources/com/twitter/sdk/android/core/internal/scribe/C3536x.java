package com.twitter.sdk.android.core.internal.scribe;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: com.twitter.sdk.android.core.internal.scribe.x */
/* loaded from: classes2.dex */
public class SyndicationClientEvent extends ScribeEvent {
    @SerializedName(IjkMediaMeta.IJKM_KEY_LANGUAGE)

    /* renamed from: f */
    public final String f8680f;
    @SerializedName("event_info")

    /* renamed from: g */
    public final String f8681g;
    @SerializedName("external_ids")

    /* renamed from: h */
    public final C2689a f8682h;

    public SyndicationClientEvent(EventNamespace eventNamespace, String str, long j, String str2, String str3, List<ScribeItem> list) {
        super("tfw_client_event", eventNamespace, j, list);
        this.f8680f = str2;
        this.f8681g = str;
        this.f8682h = new C2689a(str3);
    }

    /* compiled from: SyndicationClientEvent.java */
    /* renamed from: com.twitter.sdk.android.core.internal.scribe.x$a */
    /* loaded from: classes2.dex */
    public class C2689a {
        @SerializedName("6")

        /* renamed from: a */
        public final String f8683a;

        public C2689a(String str) {
            this.f8683a = str;
        }
    }
}
