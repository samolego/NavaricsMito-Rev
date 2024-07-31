package okhttp3.internal.p104b;

import com.example.divelog.dao.entity.CommandCard;

/* renamed from: okhttp3.internal.b.f */
/* loaded from: classes2.dex */
public final class HttpMethod {
    /* renamed from: a */
    public static boolean m2923a(String str) {
        return str.equals("POST") || str.equals("PATCH") || str.equals("PUT") || str.equals(CommandCard.DELETE) || str.equals("MOVE");
    }

    /* renamed from: b */
    public static boolean m2922b(String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    /* renamed from: c */
    public static boolean m2921c(String str) {
        return (str.equals("GET") || str.equals("HEAD")) ? false : true;
    }

    /* renamed from: d */
    public static boolean m2920d(String str) {
        return str.equals("PROPFIND");
    }

    /* renamed from: e */
    public static boolean m2919e(String str) {
        return !str.equals("PROPFIND");
    }
}
