package com.twitter.sdk.android.core.models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes2.dex */
public class MediaEntity extends UrlEntity {
    @SerializedName("ext_alt_text")
    public final String altText;
    @SerializedName("id")

    /* renamed from: id */
    public final long f8701id;
    @SerializedName("id_str")
    public final String idStr;
    @SerializedName("media_url")
    public final String mediaUrl;
    @SerializedName("media_url_https")
    public final String mediaUrlHttps;
    @SerializedName("sizes")
    public final Sizes sizes;
    @SerializedName("source_status_id")
    public final long sourceStatusId;
    @SerializedName("source_status_id_str")
    public final String sourceStatusIdStr;
    @SerializedName(IjkMediaMeta.IJKM_KEY_TYPE)
    public final String type;
    @SerializedName("video_info")
    public final VideoInfo videoInfo;

    public MediaEntity(String str, String str2, String str3, int i, int i2, long j, String str4, String str5, String str6, Sizes sizes, long j2, String str7, String str8, VideoInfo videoInfo, String str9) {
        super(str, str2, str3, i, i2);
        this.f8701id = j;
        this.idStr = str4;
        this.mediaUrl = str5;
        this.mediaUrlHttps = str6;
        this.sizes = sizes;
        this.sourceStatusId = j2;
        this.sourceStatusIdStr = str7;
        this.type = str8;
        this.videoInfo = videoInfo;
        this.altText = str9;
    }

    /* loaded from: classes2.dex */
    public static class Sizes implements Serializable {
        @SerializedName("large")
        public final Size large;
        @SerializedName("medium")
        public final Size medium;
        @SerializedName("small")
        public final Size small;
        @SerializedName("thumb")
        public final Size thumb;

        public Sizes(Size size, Size size2, Size size3, Size size4) {
            this.thumb = size;
            this.small = size2;
            this.medium = size3;
            this.large = size4;
        }
    }

    /* loaded from: classes2.dex */
    public static class Size implements Serializable {
        @SerializedName("h")

        /* renamed from: h */
        public final int f8702h;
        @SerializedName("resize")
        public final String resize;
        @SerializedName("w")

        /* renamed from: w */
        public final int f8703w;

        public Size(int i, int i2, String str) {
            this.f8703w = i;
            this.f8702h = i2;
            this.resize = str;
        }
    }
}
