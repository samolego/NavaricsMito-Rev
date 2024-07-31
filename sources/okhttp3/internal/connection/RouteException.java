package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.internal.C2930c;

/* loaded from: classes2.dex */
public final class RouteException extends RuntimeException {
    private IOException firstException;
    private IOException lastException;

    public RouteException(IOException iOException) {
        super(iOException);
        this.firstException = iOException;
        this.lastException = iOException;
    }

    public IOException getFirstConnectException() {
        return this.firstException;
    }

    public IOException getLastConnectException() {
        return this.lastException;
    }

    public void addConnectException(IOException iOException) {
        C2930c.m2885a((Throwable) this.firstException, (Throwable) iOException);
        this.lastException = iOException;
    }
}
