package com.twitter.sdk.android.tweetui;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.twitter.sdk.android.core.models.ModelUtils;
import com.twitter.sdk.android.tweetui.internal.ClickableLinkSpan;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: com.twitter.sdk.android.tweetui.ab */
/* loaded from: classes2.dex */
final class TweetTextLinkifier {

    /* renamed from: a */
    static final Pattern f8940a = Pattern.compile("^https?://twitter\\.com(/#!)?/\\w+/status/\\d+$");

    /* renamed from: b */
    static final Pattern f8941b = Pattern.compile("^https?://vine\\.co(/#!)?/v/\\w+$");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static CharSequence m4115a(FormattedTweetText formattedTweetText, LinkClickListener linkClickListener, int i, int i2, boolean z, boolean z2) {
        if (formattedTweetText == null) {
            return null;
        }
        if (TextUtils.isEmpty(formattedTweetText.f8955a)) {
            return formattedTweetText.f8955a;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(formattedTweetText.f8955a);
        List<FormattedUrlEntity> m4110a = m4110a(ModelUtils.m4248a(formattedTweetText.f8956b), ModelUtils.m4248a(formattedTweetText.f8957c), ModelUtils.m4248a(formattedTweetText.f8958d), ModelUtils.m4248a(formattedTweetText.f8959e), ModelUtils.m4248a(formattedTweetText.f8960f));
        m4116a(spannableStringBuilder, m4110a, m4111a(formattedTweetText.f8955a, m4110a, z, z2), linkClickListener, i, i2);
        return m4113a(spannableStringBuilder);
    }

    /* renamed from: a */
    static CharSequence m4113a(CharSequence charSequence) {
        int length = charSequence.length();
        while (length > 0 && charSequence.charAt(length - 1) <= ' ') {
            length--;
        }
        return length < charSequence.length() ? charSequence.subSequence(0, length) : charSequence;
    }

    /* renamed from: a */
    static List<FormattedUrlEntity> m4110a(List<FormattedUrlEntity> list, List<FormattedMediaEntity> list2, List<FormattedUrlEntity> list3, List<FormattedUrlEntity> list4, List<FormattedUrlEntity> list5) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.addAll(list2);
        arrayList.addAll(list3);
        arrayList.addAll(list4);
        arrayList.addAll(list5);
        Collections.sort(arrayList, new Comparator<FormattedUrlEntity>() { // from class: com.twitter.sdk.android.tweetui.ab.1
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(FormattedUrlEntity formattedUrlEntity, FormattedUrlEntity formattedUrlEntity2) {
                if (formattedUrlEntity != null || formattedUrlEntity2 == null) {
                    if (formattedUrlEntity == null || formattedUrlEntity2 != null) {
                        if (formattedUrlEntity == null && formattedUrlEntity2 == null) {
                            return 0;
                        }
                        if (formattedUrlEntity.f8961c < formattedUrlEntity2.f8961c) {
                            return -1;
                        }
                        return formattedUrlEntity.f8961c > formattedUrlEntity2.f8961c ? 1 : 0;
                    }
                    return 1;
                }
                return -1;
            }
        });
        return arrayList;
    }

    /* renamed from: a */
    private static void m4116a(SpannableStringBuilder spannableStringBuilder, List<FormattedUrlEntity> list, FormattedUrlEntity formattedUrlEntity, final LinkClickListener linkClickListener, int i, int i2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i3 = 0;
        for (final FormattedUrlEntity formattedUrlEntity2 : list) {
            int i4 = formattedUrlEntity2.f8961c - i3;
            int i5 = formattedUrlEntity2.f8962d - i3;
            if (i4 >= 0 && i5 <= spannableStringBuilder.length()) {
                if (formattedUrlEntity != null && formattedUrlEntity.f8961c == formattedUrlEntity2.f8961c) {
                    spannableStringBuilder.replace(i4, i5, "");
                    i3 += i5 - i4;
                } else if (!TextUtils.isEmpty(formattedUrlEntity2.f8963e)) {
                    spannableStringBuilder.replace(i4, i5, (CharSequence) formattedUrlEntity2.f8963e);
                    int length = i5 - (formattedUrlEntity2.f8963e.length() + i4);
                    i3 += length;
                    spannableStringBuilder.setSpan(new ClickableLinkSpan(i2, i, false) { // from class: com.twitter.sdk.android.tweetui.ab.2
                        @Override // android.text.style.ClickableSpan, com.twitter.sdk.android.tweetui.internal.HighlightedClickableSpan
                        public void onClick(View view) {
                            LinkClickListener linkClickListener2 = linkClickListener;
                            if (linkClickListener2 == null) {
                                return;
                            }
                            linkClickListener2.mo3915a(formattedUrlEntity2.f8964f);
                        }
                    }, i4, i5 - length, 33);
                }
            }
        }
    }

    /* renamed from: a */
    static FormattedUrlEntity m4111a(String str, List<FormattedUrlEntity> list, boolean z, boolean z2) {
        if (list.isEmpty()) {
            return null;
        }
        FormattedUrlEntity formattedUrlEntity = list.get(list.size() - 1);
        if (m4112a(str).endsWith(formattedUrlEntity.f8964f) && (m4114a(formattedUrlEntity) || ((z && m4109b(formattedUrlEntity)) || (z2 && m4108c(formattedUrlEntity))))) {
            return formattedUrlEntity;
        }
        return null;
    }

    /* renamed from: a */
    static String m4112a(String str) {
        return str.endsWith(Character.toString((char) 8206)) ? str.substring(0, str.length() - 1) : str;
    }

    /* renamed from: a */
    static boolean m4114a(FormattedUrlEntity formattedUrlEntity) {
        return (formattedUrlEntity instanceof FormattedMediaEntity) && "photo".equals(((FormattedMediaEntity) formattedUrlEntity).f8953a);
    }

    /* renamed from: b */
    static boolean m4109b(FormattedUrlEntity formattedUrlEntity) {
        return f8940a.matcher(formattedUrlEntity.f8965g).find();
    }

    /* renamed from: c */
    static boolean m4108c(FormattedUrlEntity formattedUrlEntity) {
        return f8941b.matcher(formattedUrlEntity.f8965g).find();
    }
}
