package com.twitter.sdk.android.core;

import retrofit2.C3204l;
import retrofit2.InterfaceC3169b;
import retrofit2.InterfaceC3171d;

/* compiled from: Callback.java */
/* renamed from: com.twitter.sdk.android.core.c */
/* loaded from: classes2.dex */
public abstract class AbstractC2641c<T> implements InterfaceC3171d<T> {
    /* renamed from: a */
    public abstract void mo3868a(TwitterException twitterException);

    /* renamed from: a */
    public abstract void mo3867a(Result<T> result);

    @Override // retrofit2.InterfaceC3171d
    /* renamed from: a */
    public final void mo143a(InterfaceC3169b<T> interfaceC3169b, C3204l<T> c3204l) {
        if (c3204l.m68d()) {
            mo3867a(new Result<>(c3204l.m67e(), c3204l));
        } else {
            mo3868a(new TwitterApiException(c3204l));
        }
    }

    @Override // retrofit2.InterfaceC3171d
    /* renamed from: a */
    public final void mo144a(InterfaceC3169b<T> interfaceC3169b, Throwable th) {
        mo3868a(new TwitterException("Request Failure", th));
    }
}
