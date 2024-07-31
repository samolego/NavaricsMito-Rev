package com.twitter.sdk.android.core.internal.scribe;

import android.annotation.SuppressLint;
import android.content.Context;
import com.twitter.sdk.android.core.GuestSessionProvider;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.internal.IdManager;

/* renamed from: com.twitter.sdk.android.core.internal.scribe.z */
/* loaded from: classes2.dex */
public class TwitterCoreScribeClientHolder {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a */
    private static DefaultScribeClient f8687a;

    /* renamed from: a */
    public static DefaultScribeClient m4272a() {
        return f8687a;
    }

    /* renamed from: a */
    public static void m4271a(Context context, SessionManager<? extends Session<TwitterAuthToken>> sessionManager, GuestSessionProvider guestSessionProvider, IdManager idManager, String str, String str2) {
        f8687a = new DefaultScribeClient(context, sessionManager, guestSessionProvider, idManager, DefaultScribeClient.m4360a(str, str2));
    }
}
