package com.twitter.sdk.android.tweetui;

import android.content.res.Resources;
import android.support.p008v4.util.SparseArrayCompat;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.twitter.sdk.android.tweetui.v */
/* loaded from: classes2.dex */
final class TweetDateUtils {

    /* renamed from: a */
    static final SimpleDateFormat f9135a = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);

    /* renamed from: b */
    static final C2769a f9136b = new C2769a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static long m3884a(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return f9135a.parse(str).getTime();
        } catch (ParseException unused) {
            return -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static boolean m3883b(String str) {
        return m3884a(str) != -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static String m3882c(String str) {
        return "• " + str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m3885a(Resources resources, long j, long j2) {
        long j3 = j - j2;
        if (j3 >= 0) {
            if (j3 < 60000) {
                int i = (int) (j3 / 1000);
                return resources.getQuantityString(R.plurals.tw__time_secs, i, Integer.valueOf(i));
            } else if (j3 < 3600000) {
                int i2 = (int) (j3 / 60000);
                return resources.getQuantityString(R.plurals.tw__time_mins, i2, Integer.valueOf(i2));
            } else if (j3 < 86400000) {
                int i3 = (int) (j3 / 3600000);
                return resources.getQuantityString(R.plurals.tw__time_hours, i3, Integer.valueOf(i3));
            } else {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(j);
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTimeInMillis(j2);
                Date date = new Date(j2);
                if (calendar.get(1) == calendar2.get(1)) {
                    return f9136b.m3879b(resources, date);
                }
                return f9136b.m3880a(resources, date);
            }
        }
        return f9136b.m3880a(resources, new Date(j2));
    }

    /* compiled from: TweetDateUtils.java */
    /* renamed from: com.twitter.sdk.android.tweetui.v$a */
    /* loaded from: classes2.dex */
    static class C2769a {

        /* renamed from: a */
        private final SparseArrayCompat<SimpleDateFormat> f9137a = new SparseArrayCompat<>();

        /* renamed from: b */
        private Locale f9138b;

        C2769a() {
        }

        /* renamed from: a */
        synchronized String m3880a(Resources resources, Date date) {
            return m3881a(resources, R.string.tw__relative_date_format_long).format(date);
        }

        /* renamed from: b */
        synchronized String m3879b(Resources resources, Date date) {
            return m3881a(resources, R.string.tw__relative_date_format_short).format(date);
        }

        /* renamed from: a */
        private synchronized DateFormat m3881a(Resources resources, int i) {
            SimpleDateFormat simpleDateFormat;
            if (this.f9138b == null || this.f9138b != resources.getConfiguration().locale) {
                this.f9138b = resources.getConfiguration().locale;
                this.f9137a.clear();
            }
            simpleDateFormat = this.f9137a.get(i);
            if (simpleDateFormat == null) {
                simpleDateFormat = new SimpleDateFormat(resources.getString(i), Locale.getDefault());
                this.f9137a.put(i, simpleDateFormat);
            }
            return simpleDateFormat;
        }
    }
}
