package com.squareup.picasso;

import android.content.Context;
import android.media.ExifInterface;
import android.net.Uri;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.squareup.picasso.j */
/* loaded from: classes2.dex */
public class FileRequestHandler extends ContentStreamRequestHandler {
    /* JADX INFO: Access modifiers changed from: package-private */
    public FileRequestHandler(Context context) {
        super(context);
    }

    @Override // com.squareup.picasso.ContentStreamRequestHandler, com.squareup.picasso.RequestHandler
    /* renamed from: a */
    public boolean mo5635a(C2365q c2365q) {
        return "file".equals(c2365q.f6980d.getScheme());
    }

    @Override // com.squareup.picasso.ContentStreamRequestHandler, com.squareup.picasso.RequestHandler
    /* renamed from: a */
    public RequestHandler.C2368a mo5634a(C2365q c2365q, int i) throws IOException {
        return new RequestHandler.C2368a(null, m5715b(c2365q), Picasso.LoadedFrom.DISK, m5689a(c2365q.f6980d));
    }

    /* renamed from: a */
    static int m5689a(Uri uri) throws IOException {
        int attributeInt = new ExifInterface(uri.getPath()).getAttributeInt(android.support.media.ExifInterface.TAG_ORIENTATION, 1);
        if (attributeInt != 3) {
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        }
        return 180;
    }
}
