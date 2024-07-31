package com.twitter.sdk.android.tweetui;

/* compiled from: Utils.java */
/* renamed from: com.twitter.sdk.android.tweetui.af */
/* loaded from: classes2.dex */
final class C2652af {
    /* renamed from: a */
    static CharSequence m8776a(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence != null ? charSequence : charSequence2;
    }

    /* renamed from: a */
    static String m8779a(String str, String str2) {
        return str != null ? str : str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static Long m8777a(String str, long j) {
        try {
            return Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            return Long.valueOf(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m8778a(String str) {
        return m8779a(str, "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static CharSequence m8775a(CharSequence charSequence) {
        return m8776a(charSequence, "");
    }
}