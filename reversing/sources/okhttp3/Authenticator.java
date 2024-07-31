package okhttp3;

import java.io.IOException;
import javax.annotation.Nullable;

/* renamed from: okhttp3.b */
/* loaded from: classes2.dex */
public interface Authenticator {

    /* renamed from: b */
    public static final Authenticator f9951b = new Authenticator() { // from class: okhttp3.b.1
        @Override // okhttp3.Authenticator
        /* renamed from: a */
        public C2993z mo2994a(Route route, Response response) {
            return null;
        }
    };

    @Nullable
    /* renamed from: a */
    C2993z mo2994a(Route route, Response response) throws IOException;
}
