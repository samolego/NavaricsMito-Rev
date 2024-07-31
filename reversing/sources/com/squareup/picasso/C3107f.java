package com.squareup.picasso;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.squareup.picasso.f */
/* loaded from: classes2.dex */
public class ContactsPhotoRequestHandler extends RequestHandler {

    /* renamed from: a */
    private static final UriMatcher f6927a = new UriMatcher(-1);

    /* renamed from: b */
    private final Context f6928b;

    static {
        f6927a.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        f6927a.addURI("com.android.contacts", "contacts/lookup/*", 1);
        f6927a.addURI("com.android.contacts", "contacts/#/photo", 2);
        f6927a.addURI("com.android.contacts", "contacts/#", 3);
        f6927a.addURI("com.android.contacts", "display_photo/#", 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContactsPhotoRequestHandler(Context context) {
        this.f6928b = context;
    }

    @Override // com.squareup.picasso.RequestHandler
    /* renamed from: a */
    public boolean mo5635a(C2365q c2365q) {
        Uri uri = c2365q.f6980d;
        return "content".equals(uri.getScheme()) && ContactsContract.Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && f6927a.match(c2365q.f6980d) != -1;
    }

    @Override // com.squareup.picasso.RequestHandler
    /* renamed from: a */
    public RequestHandler.C2368a mo5634a(C2365q c2365q, int i) throws IOException {
        InputStream m5717b = m5717b(c2365q);
        if (m5717b != null) {
            return new RequestHandler.C2368a(m5717b, Picasso.LoadedFrom.DISK);
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: b */
    private InputStream m5717b(C2365q c2365q) throws IOException {
        ContentResolver contentResolver = this.f6928b.getContentResolver();
        Uri uri = c2365q.f6980d;
        switch (f6927a.match(uri)) {
            case 1:
                uri = ContactsContract.Contacts.lookupContact(contentResolver, uri);
                if (uri == null) {
                    return null;
                }
                break;
            case 2:
            case 4:
                return contentResolver.openInputStream(uri);
            case 3:
                break;
            default:
                throw new IllegalStateException("Invalid uri: " + uri);
        }
        if (Build.VERSION.SDK_INT < 14) {
            return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri);
        }
        return C2358a.m5716a(contentResolver, uri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ContactsPhotoRequestHandler.java */
    @TargetApi(14)
    /* renamed from: com.squareup.picasso.f$a */
    /* loaded from: classes2.dex */
    public static class C2358a {
        /* renamed from: a */
        static InputStream m5716a(ContentResolver contentResolver, Uri uri) {
            return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
        }
    }
}
