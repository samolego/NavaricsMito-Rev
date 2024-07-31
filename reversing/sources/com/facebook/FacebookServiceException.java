package com.facebook;

/* loaded from: classes.dex */
public class FacebookServiceException extends FacebookException {
    private static final long serialVersionUID = 1;
    private final FacebookRequestError error;

    public FacebookServiceException(FacebookRequestError facebookRequestError, String str) {
        super(str);
        this.error = facebookRequestError;
    }

    public final FacebookRequestError getRequestError() {
        return this.error;
    }

    @Override // com.facebook.FacebookException, java.lang.Throwable
    public final String toString() {
        return "{FacebookServiceException: httpResponseCode: " + this.error.m11410a() + ", facebookErrorCode: " + this.error.m11408b() + ", facebookErrorType: " + this.error.m11406d() + ", message: " + this.error.m11405e() + "}";
    }
}
