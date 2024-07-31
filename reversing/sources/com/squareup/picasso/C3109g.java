package com.squareup.picasso;

import android.content.Context;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.squareup.picasso.g */
/* loaded from: classes2.dex */
public class ContentStreamRequestHandler extends RequestHandler {

    /* renamed from: a */
    final Context f6929a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContentStreamRequestHandler(Context context) {
        this.f6929a = context;
    }

    @Override // com.squareup.picasso.RequestHandler
    /* renamed from: a */
    public boolean mo5635a(C2365q c2365q) {
        return "content".equals(c2365q.f6980d.getScheme());
    }

    @Override // com.squareup.picasso.RequestHandler
    /* renamed from: a */
    public RequestHandler.C2368a mo5634a(C2365q c2365q, int i) throws IOException {
        return new RequestHandler.C2368a(m5715b(c2365q), Picasso.LoadedFrom.DISK);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public InputStream m5715b(C2365q c2365q) throws FileNotFoundException {
        return this.f6929a.getContentResolver().openInputStream(c2365q.f6980d);
    }
}
