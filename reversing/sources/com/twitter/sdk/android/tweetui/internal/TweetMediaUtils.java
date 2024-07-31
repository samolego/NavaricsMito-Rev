package com.twitter.sdk.android.tweetui.internal;

import android.os.Build;
import com.twitter.sdk.android.core.internal.scribe.ScribeItem;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.TweetEntities;
import com.twitter.sdk.android.core.models.VideoInfo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.twitter.sdk.android.tweetui.internal.g */
/* loaded from: classes2.dex */
public final class TweetMediaUtils {
    /* renamed from: a */
    public static MediaEntity m3927a(Tweet tweet) {
        List<MediaEntity> m3918f = m3918f(tweet);
        for (int size = m3918f.size() - 1; size >= 0; size--) {
            MediaEntity mediaEntity = m3918f.get(size);
            if (mediaEntity.type != null && m3929a(mediaEntity)) {
                return mediaEntity;
            }
        }
        return null;
    }

    /* renamed from: b */
    public static List<MediaEntity> m3925b(Tweet tweet) {
        ArrayList arrayList = new ArrayList();
        TweetEntities tweetEntities = tweet.f8735e;
        if (tweetEntities == null || tweetEntities.f8794d == null || tweetEntities.f8794d.size() <= 0) {
            return arrayList;
        }
        for (int i = 0; i <= tweetEntities.f8794d.size() - 1; i++) {
            MediaEntity mediaEntity = tweetEntities.f8794d.get(i);
            if (mediaEntity.type != null && m3929a(mediaEntity)) {
                arrayList.add(mediaEntity);
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public static boolean m3923c(Tweet tweet) {
        return m3927a(tweet) != null;
    }

    /* renamed from: d */
    public static MediaEntity m3921d(Tweet tweet) {
        for (MediaEntity mediaEntity : m3918f(tweet)) {
            if (mediaEntity.type != null && m3926b(mediaEntity)) {
                return mediaEntity;
            }
        }
        return null;
    }

    /* renamed from: e */
    public static boolean m3919e(Tweet tweet) {
        MediaEntity m3921d = m3921d(tweet);
        return (m3921d == null || m3924c(m3921d) == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m3929a(MediaEntity mediaEntity) {
        return "photo".equals(mediaEntity.type);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static boolean m3926b(MediaEntity mediaEntity) {
        return "video".equals(mediaEntity.type) || ScribeItem.MediaDetails.GIF_TYPE.equals(mediaEntity.type);
    }

    /* renamed from: c */
    public static VideoInfo.Variant m3924c(MediaEntity mediaEntity) {
        for (VideoInfo.Variant variant : mediaEntity.videoInfo.variants) {
            if (m3928a(variant)) {
                return variant;
            }
        }
        return null;
    }

    /* renamed from: d */
    public static boolean m3922d(MediaEntity mediaEntity) {
        return ScribeItem.MediaDetails.GIF_TYPE.equals(mediaEntity.type) || ("video".endsWith(mediaEntity.type) && mediaEntity.videoInfo.durationMillis < 6500);
    }

    /* renamed from: e */
    public static boolean m3920e(MediaEntity mediaEntity) {
        return !ScribeItem.MediaDetails.GIF_TYPE.equals(mediaEntity.type);
    }

    /* renamed from: a */
    static boolean m3928a(VideoInfo.Variant variant) {
        return (Build.VERSION.SDK_INT >= 21 && "application/x-mpegURL".equals(variant.contentType)) || "video/mp4".equals(variant.contentType);
    }

    /* renamed from: f */
    static List<MediaEntity> m3918f(Tweet tweet) {
        ArrayList arrayList = new ArrayList();
        if (tweet.f8734d != null && tweet.f8734d.f8794d != null) {
            arrayList.addAll(tweet.f8734d.f8794d);
        }
        if (tweet.f8735e != null && tweet.f8735e.f8794d != null) {
            arrayList.addAll(tweet.f8735e.f8794d);
        }
        return arrayList;
    }
}
