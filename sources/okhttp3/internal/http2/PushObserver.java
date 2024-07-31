package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import okio.BufferedSource;

/* renamed from: okhttp3.internal.http2.j */
/* loaded from: classes2.dex */
public interface PushObserver {

    /* renamed from: a */
    public static final PushObserver f10469a = new PushObserver() { // from class: okhttp3.internal.http2.j.1
        @Override // okhttp3.internal.http2.PushObserver
        /* renamed from: a */
        public void mo2599a(int i, ErrorCode errorCode) {
        }

        @Override // okhttp3.internal.http2.PushObserver
        /* renamed from: a */
        public boolean mo2601a(int i, List<Header> list) {
            return true;
        }

        @Override // okhttp3.internal.http2.PushObserver
        /* renamed from: a */
        public boolean mo2600a(int i, List<Header> list, boolean z) {
            return true;
        }

        @Override // okhttp3.internal.http2.PushObserver
        /* renamed from: a */
        public boolean mo2598a(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException {
            bufferedSource.mo2231i(i2);
            return true;
        }
    };

    /* renamed from: a */
    void mo2599a(int i, ErrorCode errorCode);

    /* renamed from: a */
    boolean mo2601a(int i, List<Header> list);

    /* renamed from: a */
    boolean mo2600a(int i, List<Header> list, boolean z);

    /* renamed from: a */
    boolean mo2598a(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException;
}
