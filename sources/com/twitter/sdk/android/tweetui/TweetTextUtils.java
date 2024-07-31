package com.twitter.sdk.android.tweetui;

import android.text.TextUtils;
import com.twitter.sdk.android.core.models.HashtagEntity;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.core.models.MentionEntity;
import com.twitter.sdk.android.core.models.SymbolEntity;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.UrlEntity;
import com.twitter.sdk.android.tweetui.internal.p080a.HtmlEntities;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.twitter.sdk.android.tweetui.ac */
/* loaded from: classes2.dex */
public final class TweetTextUtils {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static FormattedTweetText m4106a(Tweet tweet) {
        if (tweet == null) {
            return null;
        }
        FormattedTweetText formattedTweetText = new FormattedTweetText();
        m4105a(formattedTweetText, tweet);
        m4102b(formattedTweetText, tweet);
        return formattedTweetText;
    }

    /* renamed from: a */
    static void m4105a(FormattedTweetText formattedTweetText, Tweet tweet) {
        if (tweet.f8734d == null) {
            return;
        }
        List<UrlEntity> list = tweet.f8734d.f8792b;
        if (list != null) {
            for (UrlEntity urlEntity : list) {
                formattedTweetText.f8956b.add(FormattedUrlEntity.m4070a(urlEntity));
            }
        }
        List<MediaEntity> list2 = tweet.f8734d.f8794d;
        if (list2 != null) {
            for (MediaEntity mediaEntity : list2) {
                formattedTweetText.f8957c.add(new FormattedMediaEntity(mediaEntity));
            }
        }
        List<HashtagEntity> list3 = tweet.f8734d.f8795e;
        if (list3 != null) {
            for (HashtagEntity hashtagEntity : list3) {
                formattedTweetText.f8958d.add(FormattedUrlEntity.m4073a(hashtagEntity));
            }
        }
        List<MentionEntity> list4 = tweet.f8734d.f8793c;
        if (list4 != null) {
            for (MentionEntity mentionEntity : list4) {
                formattedTweetText.f8959e.add(FormattedUrlEntity.m4072a(mentionEntity));
            }
        }
        List<SymbolEntity> list5 = tweet.f8734d.f8796f;
        if (list5 != null) {
            for (SymbolEntity symbolEntity : list5) {
                formattedTweetText.f8960f.add(FormattedUrlEntity.m4071a(symbolEntity));
            }
        }
    }

    /* renamed from: b */
    static void m4102b(FormattedTweetText formattedTweetText, Tweet tweet) {
        if (TextUtils.isEmpty(tweet.f8723A)) {
            return;
        }
        HtmlEntities.C2755d m3961b = HtmlEntities.f9054a.m3961b(tweet.f8723A);
        StringBuilder sb = new StringBuilder(m3961b.f9061a);
        m4103a(formattedTweetText.f8956b, m3961b.f9062b);
        m4103a(formattedTweetText.f8957c, m3961b.f9062b);
        m4103a(formattedTweetText.f8958d, m3961b.f9062b);
        m4103a(formattedTweetText.f8959e, m3961b.f9062b);
        m4103a(formattedTweetText.f8960f, m3961b.f9062b);
        m4104a(sb, formattedTweetText);
        formattedTweetText.f8955a = sb.toString();
    }

    /* renamed from: a */
    static void m4103a(List<? extends FormattedUrlEntity> list, List<int[]> list2) {
        if (list == null || list2 == null || list2.isEmpty()) {
            return;
        }
        int size = list2.size();
        int i = 0;
        int i2 = 0;
        for (FormattedUrlEntity formattedUrlEntity : list) {
            int i3 = i;
            int i4 = 0;
            while (i < size) {
                int[] iArr = list2.get(i);
                int i5 = iArr[0];
                int i6 = iArr[1];
                int i7 = i6 - i5;
                if (i6 < formattedUrlEntity.f8961c) {
                    i2 += i7;
                    i3++;
                } else if (i6 < formattedUrlEntity.f8962d) {
                    i4 += i7;
                }
                i++;
            }
            int i8 = i4 + i2;
            formattedUrlEntity.f8961c -= i8;
            formattedUrlEntity.f8962d -= i8;
            i = i3;
        }
    }

    /* renamed from: a */
    static void m4104a(StringBuilder sb, FormattedTweetText formattedTweetText) {
        ArrayList arrayList = new ArrayList();
        int length = sb.length() - 1;
        for (int i = 0; i < length; i++) {
            if (Character.isHighSurrogate(sb.charAt(i)) && Character.isLowSurrogate(sb.charAt(i + 1))) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        m4101b(formattedTweetText.f8956b, arrayList);
        m4101b(formattedTweetText.f8957c, arrayList);
        m4101b(formattedTweetText.f8958d, arrayList);
        m4101b(formattedTweetText.f8959e, arrayList);
        m4101b(formattedTweetText.f8960f, arrayList);
    }

    /* renamed from: b */
    static void m4101b(List<? extends FormattedUrlEntity> list, List<Integer> list2) {
        if (list == null || list2 == null) {
            return;
        }
        for (FormattedUrlEntity formattedUrlEntity : list) {
            int i = formattedUrlEntity.f8961c;
            int i2 = 0;
            Iterator<Integer> it = list2.iterator();
            while (it.hasNext() && it.next().intValue() - i2 <= i) {
                i2++;
            }
            formattedUrlEntity.f8961c += i2;
            formattedUrlEntity.f8962d += i2;
        }
    }
}
