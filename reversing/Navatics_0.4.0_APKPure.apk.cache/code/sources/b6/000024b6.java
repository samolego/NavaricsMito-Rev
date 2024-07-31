package okhttp3.internal.p093b;

import com.example.divelog.dao.entity.CommandCard;

/* compiled from: HttpMethod.java */
/* renamed from: okhttp3.internal.b.f */
/* loaded from: classes2.dex */
public final class C2931f {
    /* renamed from: a */
    public static boolean m9939a(String str) {
        return str.equals("POST") || str.equals("PATCH") || str.equals("PUT") || str.equals(CommandCard.DELETE) || str.equals("MOVE");
    }

    /* renamed from: b */
    public static boolean m9940b(String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    /* renamed from: c */
    public static boolean m9941c(String str) {
        return (str.equals("GET") || str.equals("HEAD")) ? false : true;
    }

    /* renamed from: d */
    public static boolean m9942d(String str) {
        return str.equals("PROPFIND");
    }

    /* renamed from: e */
    public static boolean m9943e(String str) {
        return !str.equals("PROPFIND");
    }
}