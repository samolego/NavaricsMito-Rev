package com.squareup.picasso;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.squareup.picasso.b */
/* loaded from: classes2.dex */
public class AssetRequestHandler extends RequestHandler {

    /* renamed from: a */
    private static final int f6896a = 22;

    /* renamed from: b */
    private final AssetManager f6897b;

    public AssetRequestHandler(Context context) {
        this.f6897b = context.getAssets();
    }

    @Override // com.squareup.picasso.RequestHandler
    /* renamed from: a */
    public boolean mo5635a(C2365q c2365q) {
        Uri uri = c2365q.f6980d;
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }

    @Override // com.squareup.picasso.RequestHandler
    /* renamed from: a */
    public RequestHandler.C2368a mo5634a(C2365q c2365q, int i) throws IOException {
        return new RequestHandler.C2368a(this.f6897b.open(m5743b(c2365q)), Picasso.LoadedFrom.DISK);
    }

    /* renamed from: b */
    static String m5743b(C2365q c2365q) {
        return c2365q.f6980d.toString().substring(f6896a);
    }
}
