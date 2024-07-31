package org.apache.ftpserver.ftplet;

/* loaded from: classes2.dex */
public class FtpException extends Exception {
    private static final long serialVersionUID = -1328383839915898987L;

    public FtpException() {
    }

    public FtpException(String str) {
        super(str);
    }

    public FtpException(Throwable th) {
        super(th.getMessage());
    }

    public FtpException(String str, Throwable th) {
        super(str);
    }

    @Deprecated
    public Throwable getRootCause() {
        return getCause();
    }
}