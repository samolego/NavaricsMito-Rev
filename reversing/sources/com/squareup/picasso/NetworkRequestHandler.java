package com.squareup.picasso;

import android.graphics.Bitmap;
import android.net.NetworkInfo;
import com.squareup.picasso.Downloader;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class NetworkRequestHandler extends RequestHandler {

    /* renamed from: a */
    private final Downloader f6846a;

    /* renamed from: b */
    private final Stats f6847b;

    @Override // com.squareup.picasso.RequestHandler
    /* renamed from: a */
    int mo5647a() {
        return 2;
    }

    @Override // com.squareup.picasso.RequestHandler
    /* renamed from: b */
    boolean mo5642b() {
        return true;
    }

    public NetworkRequestHandler(Downloader downloader, Stats stats) {
        this.f6846a = downloader;
        this.f6847b = stats;
    }

    @Override // com.squareup.picasso.RequestHandler
    /* renamed from: a */
    public boolean mo5635a(C2365q c2365q) {
        String scheme = c2365q.f6980d.getScheme();
        return "http".equals(scheme) || "https".equals(scheme);
    }

    @Override // com.squareup.picasso.RequestHandler
    /* renamed from: a */
    public RequestHandler.C2368a mo5634a(C2365q c2365q, int i) throws IOException {
        Downloader.C2335a mo5613a = this.f6846a.mo5613a(c2365q.f6980d, c2365q.f6979c);
        if (mo5613a == null) {
            return null;
        }
        Picasso.LoadedFrom loadedFrom = mo5613a.f6840c ? Picasso.LoadedFrom.DISK : Picasso.LoadedFrom.NETWORK;
        Bitmap m5803b = mo5613a.m5803b();
        if (m5803b != null) {
            return new RequestHandler.C2368a(m5803b, loadedFrom);
        }
        InputStream m5804a = mo5613a.m5804a();
        if (m5804a == null) {
            return null;
        }
        if (loadedFrom == Picasso.LoadedFrom.DISK && mo5613a.m5802c() == 0) {
            C2344aa.m5758a(m5804a);
            throw new ContentLengthException("Received response with 0 content-length header.");
        }
        if (loadedFrom == Picasso.LoadedFrom.NETWORK && mo5613a.m5802c() > 0) {
            this.f6847b.m5631a(mo5613a.m5802c());
        }
        return new RequestHandler.C2368a(m5804a, loadedFrom);
    }

    @Override // com.squareup.picasso.RequestHandler
    /* renamed from: a */
    boolean mo5643a(boolean z, NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class ContentLengthException extends IOException {
        public ContentLengthException(String str) {
            super(str);
        }
    }
}
