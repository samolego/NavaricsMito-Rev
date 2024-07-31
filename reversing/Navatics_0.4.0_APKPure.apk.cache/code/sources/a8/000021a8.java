package com.twitter.sdk.android.core.models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes2.dex */
public class VideoInfo implements Serializable {

    @SerializedName("aspect_ratio")
    public final List<Integer> aspectRatio;

    @SerializedName("duration_millis")
    public final long durationMillis;

    @SerializedName("variants")
    public final List<Variant> variants;

    public VideoInfo(List<Integer> list, long j, List<Variant> list2) {
        this.aspectRatio = ModelUtils.m8607a(list);
        this.durationMillis = j;
        this.variants = ModelUtils.m8607a(list2);
    }

    /* loaded from: classes2.dex */
    public static class Variant implements Serializable {

        @SerializedName(IjkMediaMeta.IJKM_KEY_BITRATE)
        public final long bitrate;

        @SerializedName("content_type")
        public final String contentType;

        @SerializedName("url")
        public final String url;

        public Variant(long j, String str, String str2) {
            this.bitrate = j;
            this.contentType = str;
            this.url = str2;
        }
    }
}