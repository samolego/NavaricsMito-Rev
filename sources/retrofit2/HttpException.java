package retrofit2;

/* loaded from: classes2.dex */
public class HttpException extends RuntimeException {

    /* renamed from: a */
    private final transient C3204l<?> f12572a;
    private final int code;
    private final String message;

    /* renamed from: a */
    private static String m171a(C3204l<?> c3204l) {
        C3208o.m25a(c3204l, "response == null");
        return "HTTP " + c3204l.m73a() + " " + c3204l.m70b();
    }

    public HttpException(C3204l<?> c3204l) {
        super(m171a(c3204l));
        this.code = c3204l.m73a();
        this.message = c3204l.m70b();
        this.f12572a = c3204l;
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public C3204l<?> response() {
        return this.f12572a;
    }
}
