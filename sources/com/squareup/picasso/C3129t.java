package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.squareup.picasso.t */
/* loaded from: classes2.dex */
public class ResourceRequestHandler extends RequestHandler {

    /* renamed from: a */
    private final Context f7027a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResourceRequestHandler(Context context) {
        this.f7027a = context;
    }

    @Override // com.squareup.picasso.RequestHandler
    /* renamed from: a */
    public boolean mo5635a(C2365q c2365q) {
        if (c2365q.f6981e != 0) {
            return true;
        }
        return "android.resource".equals(c2365q.f6980d.getScheme());
    }

    @Override // com.squareup.picasso.RequestHandler
    /* renamed from: a */
    public RequestHandler.C2368a mo5634a(C2365q c2365q, int i) throws IOException {
        Resources m5768a = C2344aa.m5768a(this.f7027a, c2365q);
        return new RequestHandler.C2368a(m5636a(m5768a, C2344aa.m5766a(m5768a, c2365q), c2365q), Picasso.LoadedFrom.DISK);
    }

    /* renamed from: a */
    private static Bitmap m5636a(Resources resources, int i, C2365q c2365q) {
        BitmapFactory.Options c = m5641c(c2365q);
        if (m5644a(c)) {
            BitmapFactory.decodeResource(resources, i, c);
            m5645a(c2365q.f6984h, c2365q.f6985i, c, c2365q);
        }
        return BitmapFactory.decodeResource(resources, i, c);
    }
}
