package okhttp3;

import java.util.Collections;
import java.util.List;

/* renamed from: okhttp3.m */
/* loaded from: classes2.dex */
public interface CookieJar {

    /* renamed from: a */
    public static final CookieJar f10521a = new CookieJar() { // from class: okhttp3.m.1
        @Override // okhttp3.CookieJar
        /* renamed from: a */
        public void mo2546a(HttpUrl httpUrl, List<Cookie> list) {
        }

        @Override // okhttp3.CookieJar
        /* renamed from: a */
        public List<Cookie> mo2547a(HttpUrl httpUrl) {
            return Collections.emptyList();
        }
    };

    /* renamed from: a */
    List<Cookie> mo2547a(HttpUrl httpUrl);

    /* renamed from: a */
    void mo2546a(HttpUrl httpUrl, List<Cookie> list);
}
