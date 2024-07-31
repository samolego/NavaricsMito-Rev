package org.apache.ftpserver;

/* loaded from: classes2.dex */
public class FtpServerConfigurationException extends RuntimeException {
    private static final long serialVersionUID = -1328432839915898987L;

    public FtpServerConfigurationException() {
    }

    public FtpServerConfigurationException(String str, Throwable th) {
        super(str, th);
    }

    public FtpServerConfigurationException(String str) {
        super(str);
    }

    public FtpServerConfigurationException(Throwable th) {
        super(th);
    }
}
