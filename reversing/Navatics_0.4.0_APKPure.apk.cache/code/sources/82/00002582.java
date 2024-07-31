package org.apache.ftpserver;

import org.apache.ftpserver.ftplet.FtpException;

/* loaded from: classes2.dex */
public class DataConnectionException extends FtpException {
    private static final long serialVersionUID = -1328383839917648987L;

    public DataConnectionException() {
    }

    public DataConnectionException(String str) {
        super(str);
    }

    public DataConnectionException(Throwable th) {
        super(th);
    }

    public DataConnectionException(String str, Throwable th) {
        super(str, th);
    }
}