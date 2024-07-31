package com.twitter.sdk.android.core.internal;

/* compiled from: SystemCurrentTimeProvider.java */
/* renamed from: com.twitter.sdk.android.core.internal.m, reason: use source file name */
/* loaded from: classes2.dex */
public class SystemCurrentTimeProvider implements CurrentTimeProvider {
    @Override // com.twitter.sdk.android.core.internal.CurrentTimeProvider
    /* renamed from: a */
    public long mo8419a() {
        return System.currentTimeMillis();
    }
}