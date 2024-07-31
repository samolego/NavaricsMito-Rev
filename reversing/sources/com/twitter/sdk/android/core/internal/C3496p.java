package com.twitter.sdk.android.core.internal;

import com.twitter.sdk.android.core.models.Card;
import com.twitter.sdk.android.core.models.ImageValue;
import com.twitter.sdk.android.core.models.UserValue;

/* renamed from: com.twitter.sdk.android.core.internal.p */
/* loaded from: classes2.dex */
public class VineCardUtils {
    /* renamed from: a */
    public static boolean m4381a(Card card) {
        return ("player".equals(card.f8711b) || "vine".equals(card.f8711b)) && m4377e(card);
    }

    /* renamed from: e */
    private static boolean m4377e(Card card) {
        UserValue userValue = (UserValue) card.f8710a.m4252a("site");
        if (userValue != null) {
            try {
                if (Long.parseLong(userValue.f8797a) == 586671909) {
                    return true;
                }
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static String m4380b(Card card) {
        return ((UserValue) card.f8710a.m4252a("site")).f8797a;
    }

    /* renamed from: c */
    public static String m4379c(Card card) {
        return (String) card.f8710a.m4252a("player_stream_url");
    }

    /* renamed from: d */
    public static ImageValue m4378d(Card card) {
        return (ImageValue) card.f8710a.m4252a("player_image");
    }
}
