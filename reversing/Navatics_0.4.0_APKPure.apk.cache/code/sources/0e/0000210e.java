package com.twitter.sdk.android.core;

/* loaded from: classes2.dex */
public class TwitterAuthException extends TwitterException {
    private static final long serialVersionUID = 577033016879783994L;

    public TwitterAuthException(String str) {
        super(str);
    }

    public TwitterAuthException(String str, Throwable th) {
        super(str, th);
    }
}