package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* renamed from: okio.k */
/* loaded from: classes2.dex */
public final class Okio {

    /* renamed from: a */
    static final Logger f10690a = Logger.getLogger(Okio.class.getName());

    private Okio() {
    }

    /* renamed from: a */
    public static BufferedSource m2263a(Source source) {
        return new RealBufferedSource(source);
    }

    /* renamed from: a */
    public static BufferedSink m2264a(Sink sink) {
        return new RealBufferedSink(sink);
    }

    /* renamed from: a */
    private static Sink m2267a(final OutputStream outputStream, final Timeout timeout) {
        if (outputStream != null) {
            if (timeout == null) {
                throw new IllegalArgumentException("timeout == null");
            }
            return new Sink() { // from class: okio.k.1
                @Override // okio.Sink
                /* renamed from: a_ */
                public void mo2215a_(Buffer buffer, long j) throws IOException {
                    C3006s.m2204a(buffer.f10675b, 0L, j);
                    while (j > 0) {
                        Timeout.this.mo2206g();
                        Segment segment = buffer.f10674a;
                        int min = (int) Math.min(j, segment.f10705c - segment.f10704b);
                        outputStream.write(segment.f10703a, segment.f10704b, min);
                        segment.f10704b += min;
                        long j2 = min;
                        j -= j2;
                        buffer.f10675b -= j2;
                        if (segment.f10704b == segment.f10705c) {
                            buffer.f10674a = segment.m2220b();
                            SegmentPool.m2217a(segment);
                        }
                    }
                }

                @Override // okio.Sink, java.io.Flushable
                public void flush() throws IOException {
                    outputStream.flush();
                }

                @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    outputStream.close();
                }

                @Override // okio.Sink
                /* renamed from: a */
                public Timeout mo2216a() {
                    return Timeout.this;
                }

                public String toString() {
                    return "sink(" + outputStream + ")";
                }
            };
        }
        throw new IllegalArgumentException("out == null");
    }

    /* renamed from: a */
    public static Sink m2265a(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getOutputStream() == null) {
            throw new IOException("socket's output stream == null");
        }
        AsyncTimeout m2261c = m2261c(socket);
        return m2261c.m2324a(m2267a(socket.getOutputStream(), m2261c));
    }

    /* renamed from: a */
    public static Source m2269a(InputStream inputStream) {
        return m2268a(inputStream, new Timeout());
    }

    /* renamed from: a */
    private static Source m2268a(final InputStream inputStream, final Timeout timeout) {
        if (inputStream != null) {
            if (timeout == null) {
                throw new IllegalArgumentException("timeout == null");
            }
            return new Source() { // from class: okio.k.2
                @Override // okio.Source
                /* renamed from: a */
                public long mo130a(Buffer buffer, long j) throws IOException {
                    int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                    if (i < 0) {
                        throw new IllegalArgumentException("byteCount < 0: " + j);
                    } else if (i == 0) {
                        return 0L;
                    } else {
                        try {
                            Timeout.this.mo2206g();
                            Segment m2293e = buffer.m2293e(1);
                            int read = inputStream.read(m2293e.f10703a, m2293e.f10705c, (int) Math.min(j, 8192 - m2293e.f10705c));
                            if (read == -1) {
                                return -1L;
                            }
                            m2293e.f10705c += read;
                            long j2 = read;
                            buffer.f10675b += j2;
                            return j2;
                        } catch (AssertionError e) {
                            if (Okio.m2266a(e)) {
                                throw new IOException(e);
                            }
                            throw e;
                        }
                    }
                }

                @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    inputStream.close();
                }

                @Override // okio.Source
                /* renamed from: a */
                public Timeout mo2214a() {
                    return Timeout.this;
                }

                public String toString() {
                    return "source(" + inputStream + ")";
                }
            };
        }
        throw new IllegalArgumentException("in == null");
    }

    /* renamed from: a */
    public static Source m2270a(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return m2269a(new FileInputStream(file));
    }

    /* renamed from: b */
    public static Source m2262b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        }
        AsyncTimeout m2261c = m2261c(socket);
        return m2261c.m2323a(m2268a(socket.getInputStream(), m2261c));
    }

    /* renamed from: c */
    private static AsyncTimeout m2261c(final Socket socket) {
        return new AsyncTimeout() { // from class: okio.k.3
            @Override // okio.AsyncTimeout
            /* renamed from: a */
            protected IOException mo2259a(@Nullable IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            @Override // okio.AsyncTimeout
            /* renamed from: a */
            protected void mo2260a() {
                try {
                    socket.close();
                } catch (AssertionError e) {
                    if (Okio.m2266a(e)) {
                        Logger logger = Okio.f10690a;
                        Level level = Level.WARNING;
                        logger.log(level, "Failed to close timed out socket " + socket, (Throwable) e);
                        return;
                    }
                    throw e;
                } catch (Exception e2) {
                    Logger logger2 = Okio.f10690a;
                    Level level2 = Level.WARNING;
                    logger2.log(level2, "Failed to close timed out socket " + socket, (Throwable) e2);
                }
            }
        };
    }

    /* renamed from: a */
    static boolean m2266a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
