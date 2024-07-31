package org.apache.ftpserver.ftplet;

/* loaded from: classes2.dex */
public class AuthenticationFailedException extends FtpException {
    private static final long serialVersionUID = -1328383839915898987L;

    public AuthenticationFailedException() {
    }

    public AuthenticationFailedException(String str) {
        super(str);
    }

    public AuthenticationFailedException(Throwable th) {
        super(th);
    }

    public AuthenticationFailedException(String str, Throwable th) {
        super(str, th);
    }
}
